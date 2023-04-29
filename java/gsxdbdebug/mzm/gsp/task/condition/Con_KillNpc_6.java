/*     */ package mzm.gsp.task.condition;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.confbean.SFightCfg;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.conParamObj.KillNpcParamObj;
/*     */ import mzm.gsp.task.conParamObj.PvcParamObj;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConkillNpc;
/*     */ import mzm.gsp.task.main.RoleTask;
/*     */ import mzm.gsp.task.main.RoleTaskManager;
/*     */ import mzm.gsp.task.main.TaskManager;
/*     */ import mzm.gsp.task.pvc.PSendPvcTaskConData;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Procedure;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class Con_KillNpc_6 extends AbsCondition
/*     */ {
/*  31 */   private static final Logger logger = Logger.getLogger(Con_KillNpc_6.class);
/*     */   
/*     */   public Con_KillNpc_6(int conId, int conType, int sTaskId)
/*     */   {
/*  35 */     super(conId, conType, sTaskId);
/*     */   }
/*     */   
/*     */   public STaskConkillNpc getSConkillNpc()
/*     */   {
/*  40 */     return STaskConkillNpc.get(getConId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*     */   {
/*  49 */     STaskConkillNpc conkillNpc = getSConkillNpc();
/*  50 */     if (conMap != null)
/*     */     {
/*  52 */       ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/*  53 */       if (conBean == null)
/*     */       {
/*  55 */         conBean = Pod.newConBean();
/*  56 */         conBean.setType(getType());
/*  57 */         conMap.put(Integer.valueOf(getConId()), conBean);
/*     */       }
/*     */       
/*  60 */       if (getTaskPvcCfgId() > 0)
/*     */       {
/*     */ 
/*  63 */         if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType())))
/*     */         {
/*  65 */           long pvcCfgId = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType()))).longValue();
/*  66 */           if (getTaskPvcCfgId() == pvcCfgId)
/*     */           {
/*  68 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  73 */       if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_NPC_BATTLE_ID.getParamType())))
/*     */       {
/*  75 */         long bId = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_NPC_BATTLE_ID.getParamType()))).longValue();
/*  76 */         if (conkillNpc.battleIDs.contains(Long.valueOf(bId)))
/*     */         {
/*  78 */           return true;
/*     */         }
/*     */       }
/*  81 */       Object obj = params.get(Integer.valueOf(getType()));
/*  82 */       if (obj == null)
/*     */       {
/*  84 */         return false;
/*     */       }
/*  86 */       if ((obj instanceof KillNpcParamObj))
/*     */       {
/*  88 */         return checkKillNpcComplete(conBean, obj);
/*     */       }
/*  90 */       if ((obj instanceof PvcParamObj))
/*     */       {
/*  92 */         return checkPvcComplete(conBean, obj);
/*     */       }
/*     */       
/*     */ 
/*  96 */       logger.error("杀死npc条件传入的对象不是" + KillNpcParamObj.class.getName());
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 102 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkKillNpcComplete(ConBean conBean, Object obj)
/*     */   {
/* 114 */     STaskConkillNpc conkillNpc = getSConkillNpc();
/* 115 */     KillNpcParamObj killNpcParamObj = (KillNpcParamObj)obj;
/* 116 */     if (!conkillNpc.battleIDs.contains(Integer.valueOf(killNpcParamObj.getBattleId())))
/*     */     {
/* 118 */       return false;
/*     */     }
/* 120 */     conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_KILL_NPC_BATTLE_ID.getParamType()), Long.valueOf(killNpcParamObj.getBattleId()));
/* 121 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkPvcComplete(ConBean conBean, Object obj)
/*     */   {
/* 133 */     PvcParamObj pvcParamObj = (PvcParamObj)obj;
/* 134 */     if (getTaskPvcCfgId() != pvcParamObj.getTaskUseId())
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     long targetRoleId = ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType()))).longValue();
/* 139 */     if ((targetRoleId > 0L) && (!pvcParamObj.getTargetRoleIds().contains(Long.valueOf(targetRoleId))))
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PVC_TASK_USE_ID.getParamType()), Long.valueOf(pvcParamObj.getTaskUseId()));
/* 144 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTaskPvcCfgId()
/*     */   {
/* 154 */     return getSConkillNpc().pvcId;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getType()
/*     */   {
/* 160 */     return 6;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 166 */     STaskConkillNpc conkillNpc = getSConkillNpc();
/* 167 */     if (NpcInterface.getNpc(conkillNpc.fixNPCId) == null)
/*     */     {
/* 169 */       throw new RuntimeException("任务配置的npcId不存在:taskId:" + getSTask().id + " 与npc战斗条件");
/*     */     }
/* 171 */     for (Iterator i$ = conkillNpc.battleIDs.iterator(); i$.hasNext();) { int battleId = ((Integer)i$.next()).intValue();
/*     */       
/* 173 */       if (SFightCfg.get(battleId) == null)
/*     */       {
/* 175 */         throw new RuntimeException("任务配置的战斗Id不存在:taskId:" + getSTask().id + "battleId:" + battleId + " 与npc战斗条件");
/*     */       }
/*     */     }
/*     */     
/* 179 */     Map<Integer, Integer> taskId2PvcId = TaskManager.getTaskId2PvcId();
/* 180 */     if ((taskId2PvcId == null) || (taskId2PvcId.size() == 0))
/*     */     {
/* 182 */       return;
/*     */     }
/* 184 */     for (Iterator i$ = taskId2PvcId.values().iterator(); i$.hasNext();) { int pvcId = ((Integer)i$.next()).intValue();
/*     */       
/* 186 */       if (!TaskManager.getUseId2STaskPvcCfg().containsKey(Integer.valueOf(pvcId)))
/*     */       {
/* 188 */         throw new RuntimeException("任务配置的PvcId不存在:taskId:" + getSTask().id + "； pvcId:" + pvcId);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*     */   {
/* 197 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getJingXiangRoleId(TaskBean taskBean)
/*     */   {
/* 209 */     if (taskBean == null)
/*     */     {
/* 211 */       return -1L;
/*     */     }
/* 213 */     Map<Integer, ConBean> conMap = taskBean.getConmap();
/* 214 */     ConBean conBean = (ConBean)conMap.get(Integer.valueOf(getConId()));
/* 215 */     if (conBean == null)
/*     */     {
/* 217 */       return -1L;
/*     */     }
/* 219 */     if (conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType())))
/*     */     {
/* 221 */       return ((Long)conBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType()))).longValue();
/*     */     }
/* 223 */     return -1L;
/*     */   }
/*     */   
/*     */ 
/*     */   class CreateJingXiangRoleProcedure
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int graphId;
/*     */     private final long roleId;
/*     */     
/*     */     public CreateJingXiangRoleProcedure(long roleId, int graphId)
/*     */     {
/* 235 */       this.roleId = roleId;
/* 236 */       this.graphId = graphId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 242 */       STaskConkillNpc conkillNpc = Con_KillNpc_6.this.getSConkillNpc();
/*     */       
/* 244 */       Set<Long> roleSet = new HashSet();
/*     */       
/* 246 */       for (Iterator i$ = conkillNpc.playerRanges.iterator(); i$.hasNext();) { int jingXiangType = ((Integer)i$.next()).intValue();
/*     */         
/* 248 */         switch (jingXiangType)
/*     */         {
/*     */         case 1: 
/*     */           break;
/*     */         case 2: 
/*     */           break;
/*     */         
/*     */         case 3: 
/* 256 */           roleSet.addAll(FriendInterface.getAllFriends(this.roleId, false));
/* 257 */           break;
/*     */         case 4: 
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 264 */       Set<Long> notOnlineSet = new HashSet();
/* 265 */       if (conkillNpc.onlineFirst)
/*     */       {
/* 267 */         Iterator<Long> roleIterator = roleSet.iterator();
/* 268 */         while (roleIterator.hasNext())
/*     */         {
/* 270 */           long tempRoleId = ((Long)roleIterator.next()).longValue();
/* 271 */           if (!OnlineManager.getInstance().isOnline(tempRoleId))
/*     */           {
/* 273 */             notOnlineSet.add(Long.valueOf(tempRoleId));
/* 274 */             roleIterator.remove();
/*     */           }
/*     */         }
/*     */       }
/* 278 */       if (roleSet.size() == 0)
/*     */       {
/* 280 */         roleSet.addAll(notOnlineSet);
/*     */       }
/* 282 */       RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/* 283 */       TaskBean taskBean = roleTask.getTaskBean(this.graphId, Con_KillNpc_6.this.getSTask().id);
/* 284 */       if (taskBean == null)
/*     */       {
/* 286 */         return false; }
/*     */       ConBean conBean;
/* 288 */       int index; int i; Iterator i$; if (taskBean.getTaskstate() == 2)
/*     */       {
/* 290 */         conBean = (ConBean)taskBean.getConmap().get(Integer.valueOf(conkillNpc.id));
/* 291 */         if (conBean == null)
/*     */         {
/* 293 */           conBean = Pod.newConBean();
/* 294 */           taskBean.getConmap().put(Integer.valueOf(conkillNpc.id), conBean);
/*     */         }
/* 296 */         if (!conBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType())))
/*     */         {
/* 298 */           if (roleSet.size() != 0)
/*     */           {
/* 300 */             index = Xdb.random().nextInt(roleSet.size());
/* 301 */             i = 0;
/* 302 */             for (i$ = roleSet.iterator(); i$.hasNext();) { long roleRandomId = ((Long)i$.next()).longValue();
/*     */               
/* 304 */               if (index == i)
/*     */               {
/* 306 */                 conBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType()), Long.valueOf(roleRandomId));
/* 307 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 313 */       return true;
/*     */     }
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
/*     */   public ConParam getSendParam(ConBean xConBean)
/*     */   {
/* 327 */     ConParam p = new ConParam();
/* 328 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType())))
/*     */     {
/* 330 */       long targetId = ((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType()))).longValue();
/* 331 */       p.setParam(targetId);
/*     */     }
/* 333 */     return p;
/*     */   }
/*     */   
/*     */ 
/*     */   public void asynSendConParam(long roleId, int graphId, ConBean xConBean)
/*     */   {
/* 339 */     if (xConBean.getParammap().containsKey(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType())))
/*     */     {
/* 341 */       long targetId = ((Long)xConBean.getParammap().get(Integer.valueOf(ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType()))).longValue();
/* 342 */       if (targetId > 0L)
/*     */       {
/*     */ 
/* 345 */         Procedure.execute(new PSendPvcTaskConData(roleId, graphId, getTaskId(), getConId(), targetId));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_KillNpc_6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */