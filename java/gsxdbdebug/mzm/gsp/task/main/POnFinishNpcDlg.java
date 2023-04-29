/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.npc.event.FinishDlgArg;
/*     */ import mzm.gsp.npc.event.FinishDlgEventProcedure;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.question.main.QuestionInterface;
/*     */ import mzm.gsp.task.conParamObj.NpcDlgParamObj;
/*     */ import mzm.gsp.task.conParamObj.QuestionContext;
/*     */ import mzm.gsp.task.condition.AbsCondition;
/*     */ import mzm.gsp.task.condition.Con_KillNpc_6;
/*     */ import mzm.gsp.task.condition.Con_Question_19;
/*     */ import mzm.gsp.task.confbean.SBattleIds;
/*     */ import mzm.gsp.task.confbean.SNpc2Task;
/*     */ import mzm.gsp.task.confbean.STTaskId2PvcId;
/*     */ import mzm.gsp.task.confbean.STUseId2STaskPvcCfgId;
/*     */ import mzm.gsp.task.confbean.STaskConFinishQuestion;
/*     */ import mzm.gsp.task.confbean.STaskPvcCfg;
/*     */ import mzm.gsp.task.enterFight.JoinFightManager;
/*     */ import mzm.gsp.task.pvc.RoleTaskPvcManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnFinishNpcDlg
/*     */   extends FinishDlgEventProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     int taskId = ((FinishDlgArg)this.arg).taskId;
/*  45 */     int npcId = ((FinishDlgArg)this.arg).npcId;
/*  46 */     long roleId = ((FinishDlgArg)this.arg).roleId;
/*  47 */     if (taskId <= 0)
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     SNpc2Task sNpc2Task = NpcInterface.getSNpc2Task(npcId);
/*  52 */     if (sNpc2Task == null)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     Map<Integer, List<TaskStateInfo>> taskStateInfos = TaskInterface.getRoleTaskState(roleId);
/*  58 */     if (!taskStateInfos.containsKey(Integer.valueOf(taskId)))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     List<TaskStateInfo> taskStateInfoList = (List)taskStateInfos.get(Integer.valueOf(taskId));
/*  63 */     Set<Integer> states = new HashSet();
/*  64 */     for (TaskStateInfo taskStateInfo : taskStateInfoList)
/*     */     {
/*  66 */       states.add(Integer.valueOf(taskStateInfo.getTaskState()));
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (getTask2pvcId(sNpc2Task).containsKey(Integer.valueOf(taskId)))
/*     */     {
/*  72 */       if (states.contains(Integer.valueOf(2)))
/*     */       {
/*  74 */         return doPVCFight(taskId, roleId, taskStateInfoList);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (sNpc2Task.taskIdToBattleIds.containsKey(Integer.valueOf(taskId)))
/*     */     {
/*  81 */       if (states.contains(Integer.valueOf(2)))
/*     */       {
/*  83 */         if (TaskInterface.validateTaskNPCBattle(roleId, taskId, ((FinishDlgArg)this.arg).npcId))
/*     */         {
/*  85 */           SBattleIds battleIds = (SBattleIds)sNpc2Task.taskIdToBattleIds.get(Integer.valueOf(taskId));
/*  86 */           Random random = Xdb.random();
/*  87 */           int index = random.nextInt(battleIds.battleIds.size());
/*  88 */           int battleId = ((Integer)battleIds.battleIds.get(index)).intValue();
/*  89 */           int mapCfgid = MapInterface.getRoleMapId(roleId);
/*  90 */           if (mapCfgid == -1)
/*     */           {
/*  92 */             return false;
/*     */           }
/*  94 */           int graphId = getGraphId(taskStateInfoList);
/*  95 */           if (graphId <= 0)
/*     */           {
/*  97 */             return false;
/*     */           }
/*  99 */           if (!JoinFightManager.checkAndExcuteFight(roleId, graphId, taskId, battleId))
/*     */           {
/* 101 */             TaskImplManager.startTaskFight(taskId, roleId, battleId, mapCfgid, graphId);
/*     */           }
/*     */         }
/* 104 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 109 */     if (sNpc2Task.taskId2QuestionLibId.containsKey(Integer.valueOf(taskId)))
/*     */     {
/* 111 */       return handleQuestion(taskId, roleId);
/*     */     }
/*     */     
/*     */ 
/* 115 */     if (sNpc2Task.finishTaskIds.contains(Integer.valueOf(taskId)))
/*     */     {
/* 117 */       if (states.contains(Integer.valueOf(3)))
/*     */       {
/*     */ 
/* 120 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 125 */     if (sNpc2Task.acceptTaskIds.contains(Integer.valueOf(taskId)))
/*     */     {
/* 127 */       if (states.contains(Integer.valueOf(1)))
/*     */       {
/*     */ 
/* 130 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 135 */     if (sNpc2Task.dlgTaskIds.contains(Integer.valueOf(taskId)))
/*     */     {
/* 137 */       if (states.contains(Integer.valueOf(2)))
/*     */       {
/*     */ 
/* 140 */         NpcDlgParamObj obj = new NpcDlgParamObj();
/* 141 */         obj.setNpcId(npcId);
/* 142 */         TaskInterface.updateTaskCondition(roleId, taskId, 3, obj);
/* 143 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleQuestion(int taskId, long roleId)
/*     */   {
/* 159 */     STaskConFinishQuestion cfg = getQuestionCfg(taskId);
/* 160 */     if (cfg == null)
/*     */     {
/* 162 */       GameServer.logger().error(String.format("[task]POnFinishNpcDlg.handleQuestion@ STaskConFinishQuestion is null!|roleId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(taskId) }));
/*     */       
/*     */ 
/* 165 */       return false;
/*     */     }
/* 167 */     QuestionInterface.startTaskQuestion(Arrays.asList(new Long[] { Long.valueOf(roleId) }), cfg.questionContentId, cfg.questionLibId, new QuestionContext(taskId, cfg.questionLibId));
/*     */     
/* 169 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 171 */       GameServer.logger().debug(String.format("[task]POnFinishNpcDlg.handleQuestion@ offer question!|roleId=%d|taskId=%d|questionLibId=%d|questionContentId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(taskId), Integer.valueOf(cfg.questionContentId), Integer.valueOf(cfg.questionContentId) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 176 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private STaskConFinishQuestion getQuestionCfg(int taskId)
/*     */   {
/* 188 */     STaskConFinishQuestion cfg = null;
/* 189 */     Task task = TaskManager.getTaskById(taskId);
/* 190 */     if (task == null)
/*     */     {
/* 192 */       GameServer.logger().error(String.format("[task]POnFinishNpcDlg.getQuestionCfg@ task cfg is null!|taskId=%d", new Object[] { Integer.valueOf(taskId) }));
/*     */       
/* 194 */       return null;
/*     */     }
/* 196 */     List<AbsCondition> conditions = task.getCondition(19, 2);
/* 197 */     for (AbsCondition condition : conditions)
/*     */     {
/* 199 */       Con_Question_19 con = (Con_Question_19)condition;
/* 200 */       cfg = STaskConFinishQuestion.get(con.getConId());
/* 201 */       if (cfg != null) {
/*     */         break;
/*     */       }
/*     */       
/* 205 */       GameServer.logger().error(String.format("[task]POnFinishNpcDlg.getQuestionCfg@ STaskConFinishQuestion cfg is null!|taskId=%d|conId=%d", new Object[] { Integer.valueOf(taskId), Integer.valueOf(con.getConId()) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 211 */     return cfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doPVCFight(int taskId, long roleId, List<TaskStateInfo> taskStateInfoList)
/*     */   {
/* 226 */     STaskPvcCfg sCfg = getPvcCfg(taskId);
/* 227 */     if (sCfg == null)
/*     */     {
/* 229 */       GameServer.logger().error(String.format("[task]POnFinishNpcDlg.doPVCFight@ get pvc cfg error!|taskId=%d|roleId=%d", new Object[] { Integer.valueOf(taskId), Long.valueOf(roleId) }));
/*     */       
/* 231 */       return false;
/*     */     }
/* 233 */     int conId = getTaskPVCConId(taskId);
/* 234 */     if (conId <= 0)
/*     */     {
/* 236 */       GameServer.logger().error(String.format("[task]POnFinishNpcDlg.doPVCFight@ get pvc conId error!|taskId=%d|roleId=%d", new Object[] { Integer.valueOf(taskId), Long.valueOf(roleId) }));
/*     */       
/* 238 */       return false;
/*     */     }
/* 240 */     int graphId = getGraphId(taskStateInfoList);
/* 241 */     if (graphId <= 0)
/*     */     {
/* 243 */       GameServer.logger().error(String.format("[task]POnFinishNpcDlg.doPVCFight@ get pvc graphId error!|taskId=%d|roleId=%d", new Object[] { Integer.valueOf(taskId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 246 */       return false;
/*     */     }
/* 248 */     RoleTaskPvcManager.doPvcFight(roleId, graphId, taskId, sCfg.id, conId);
/* 249 */     return true;
/*     */   }
/*     */   
/*     */   private int getGraphId(List<TaskStateInfo> taskStateInfoList)
/*     */   {
/* 254 */     int graphId = 0;
/* 255 */     for (TaskStateInfo taskStateInfo : taskStateInfoList)
/*     */     {
/* 257 */       if (taskStateInfo.getTaskState() == 2)
/*     */       {
/* 259 */         graphId = taskStateInfo.getGraphId();
/*     */       }
/*     */     }
/* 262 */     return graphId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private HashMap<Integer, Integer> getTask2pvcId(SNpc2Task sNpc2Task)
/*     */   {
/* 272 */     HashMap<Integer, Integer> task2pvcId = new HashMap();
/* 273 */     if (sNpc2Task == null)
/*     */     {
/* 275 */       return task2pvcId;
/*     */     }
/* 277 */     task2pvcId.putAll(sNpc2Task.taskIdToPvcIds);
/* 278 */     return task2pvcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private STaskPvcCfg getPvcCfg(int taskId)
/*     */   {
/* 290 */     return getSTaskPvcCfg(getPvcIdBy(taskId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getPvcIdBy(int taskId)
/*     */   {
/* 302 */     STTaskId2PvcId sTTaskId2PvcId = STTaskId2PvcId.get(taskId);
/* 303 */     if (sTTaskId2PvcId == null)
/*     */     {
/* 305 */       return -1;
/*     */     }
/* 307 */     return sTTaskId2PvcId.pvcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   STaskPvcCfg getSTaskPvcCfg(int pvcId4TaskId)
/*     */   {
/* 319 */     if (pvcId4TaskId <= 0)
/*     */     {
/* 321 */       return null;
/*     */     }
/* 323 */     STUseId2STaskPvcCfgId cfg = STUseId2STaskPvcCfgId.get(pvcId4TaskId);
/* 324 */     if (cfg == null)
/*     */     {
/* 326 */       return null;
/*     */     }
/* 328 */     int sTaskPvcCfgId = cfg.sTaskPvcCfgId;
/* 329 */     return STaskPvcCfg.get(sTaskPvcCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getTaskPVCConId(int taskId)
/*     */   {
/* 340 */     Task task = TaskManager.getTaskById(taskId);
/* 341 */     if (task == null)
/*     */     {
/* 343 */       return -1;
/*     */     }
/* 345 */     List<AbsCondition> conditions = task.getCondition(6, 2);
/* 346 */     for (AbsCondition condition : conditions)
/*     */     {
/* 348 */       Con_KillNpc_6 killNpcCondition = (Con_KillNpc_6)condition;
/* 349 */       if (killNpcCondition.getTaskPvcCfgId() > 0)
/*     */       {
/* 351 */         return condition.getConId();
/*     */       }
/*     */     }
/* 354 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnFinishNpcDlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */