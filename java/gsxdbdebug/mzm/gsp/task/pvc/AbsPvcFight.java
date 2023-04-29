/*     */ package mzm.gsp.task.pvc;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.condition.ConditionEnum;
/*     */ import mzm.gsp.task.confbean.STaskPvcCfg;
/*     */ import mzm.gsp.task.main.TaskImplManager;
/*     */ import mzm.gsp.task.main.TaskPvcContext;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.Pod;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbsPvcFight
/*     */ {
/*     */   private long _roleId;
/*     */   private int _graphId;
/*     */   private int _taskId;
/*     */   private int _pvcId;
/*     */   private int _conId;
/*     */   private long _targetRoleId;
/*     */   
/*     */   public AbsPvcFight(long roleId, int graphId, int taskId, int pvcId, int conId)
/*     */   {
/*  33 */     this._roleId = roleId;
/*  34 */     this._graphId = graphId;
/*  35 */     this._taskId = taskId;
/*  36 */     this._pvcId = pvcId;
/*  37 */     this._conId = conId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean onStartPvcFight(TaskBean xTaskBean)
/*     */   {
/*  48 */     if (!canActivePvc())
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     return startPvc(getXConTargetRoleId(xTaskBean));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean startPvc(long targetRoleId)
/*     */   {
/*  64 */     if (!RoleInterface.isRoleExist(targetRoleId, false))
/*     */     {
/*     */ 
/*  67 */       GameServer.logger().warn(String.format("[task]AbsPvcFight.startPvc@target roleData del!", new Object[0]));
/*     */     }
/*  69 */     TaskPvcContext context = new TaskPvcContext(this._taskId, getTaskUseId(), targetRoleId);
/*  70 */     List<Long> passiveRoleids = getPassiveRoleIds(targetRoleId);
/*  71 */     if (isUseRealPro(passiveRoleids, isCfgRealPro()))
/*     */     {
/*  73 */       FightInterface.startPVCFight(this._roleId, passiveRoleids, context, 1, FightReason.Task_CON_PVC_FIGHT, getPvcCfg().proCfgId);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  78 */       FightInterface.startPVCFightWithRobot(this._roleId, passiveRoleids, context, 1, FightReason.Task_CON_PVC_FIGHT, getPvcCfg().pvcCfgId);
/*     */     }
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isUseRealPro(List<Long> passiveRoleids, boolean isRealPro)
/*     */   {
/*  91 */     if ((passiveRoleids == null) || (passiveRoleids.size() == 0))
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     return isRealPro;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isCfgRealPro()
/*     */   {
/* 105 */     int realPro = getPvcCfg().useRealPro;
/* 106 */     if (realPro == 1)
/*     */     {
/* 108 */       return true;
/*     */     }
/* 110 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canActivePvc()
/*     */   {
/* 122 */     return TaskImplManager.canEnterFight(this._roleId, this._graphId, this._taskId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getXConTargetRoleId(TaskBean taskBean)
/*     */   {
/* 133 */     if (taskBean == null)
/*     */     {
/* 135 */       return -1L;
/*     */     }
/* 137 */     Map<Integer, ConBean> xConMap = taskBean.getConmap();
/* 138 */     ConBean xConBean = (ConBean)xConMap.get(Integer.valueOf(getConId()));
/* 139 */     Long targetRoleId = (Long)xConBean.getParammap().get(Integer.valueOf(getConKey()));
/* 140 */     if (targetRoleId == null)
/*     */     {
/* 142 */       return -1L;
/*     */     }
/* 144 */     return targetRoleId.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getPassiveRoleIds(long targetRoleId)
/*     */   {
/* 155 */     List<Long> targetIds = new ArrayList();
/* 156 */     if (targetRoleId > 0L)
/*     */     {
/* 158 */       targetIds.add(Long.valueOf(targetRoleId));
/*     */     }
/*     */     else
/*     */     {
/* 162 */       targetIds.addAll(getPassiveRoleIds());
/*     */     }
/* 164 */     return targetIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onAcceptPvcTask(TaskBean taskBean)
/*     */   {
/* 174 */     setPvcXData(taskBean);
/* 175 */     synTaskTargetRoleId();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void setPvcXData(TaskBean taskBean)
/*     */   {
/* 185 */     if (taskBean == null)
/*     */     {
/* 187 */       return;
/*     */     }
/* 189 */     int conKey = getConKey();
/* 190 */     ConBean xConBean = getXConbean(taskBean);
/* 191 */     if (xConBean.getParammap().containsKey(Integer.valueOf(conKey)))
/*     */     {
/*     */ 
/* 194 */       this._targetRoleId = ((Long)xConBean.getParammap().get(Integer.valueOf(conKey))).longValue();
/* 195 */       return;
/*     */     }
/* 197 */     this._targetRoleId = getMrTargetRoleId();
/* 198 */     xConBean.getParammap().put(Integer.valueOf(conKey), Long.valueOf(this._targetRoleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ConBean getXConbean(TaskBean taskBean)
/*     */   {
/* 209 */     Map<Integer, ConBean> xConMap = taskBean.getConmap();
/* 210 */     ConBean xConBean = (ConBean)xConMap.get(Integer.valueOf(getConId()));
/* 211 */     if (xConBean != null)
/*     */     {
/* 213 */       return xConBean;
/*     */     }
/* 215 */     xConBean = Pod.newConBean();
/* 216 */     xConBean.setType(6);
/* 217 */     xConMap.put(Integer.valueOf(getConId()), xConBean);
/* 218 */     return xConBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void synTaskTargetRoleId()
/*     */   {
/* 227 */     Procedure.execute(new PSendPvcTaskConData(this._roleId, this._graphId, this._taskId, this._conId, this._targetRoleId));
/*     */   }
/*     */   
/*     */   private int getConKey()
/*     */   {
/* 232 */     return ConditionEnum.CON_KILL_NPC_PLAYER_ID.getParamType();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract long getMrTargetRoleId();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   abstract List<Long> getPassiveRoleIds();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getRoleId()
/*     */   {
/* 256 */     return this._roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getTaskId()
/*     */   {
/* 266 */     return this._taskId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getGraphId()
/*     */   {
/* 276 */     return this._graphId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getPvcId()
/*     */   {
/* 286 */     return this._pvcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getConId()
/*     */   {
/* 296 */     return this._conId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   STaskPvcCfg getPvcCfg()
/*     */   {
/* 306 */     return STaskPvcCfg.get(this._pvcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getTaskUseId()
/*     */   {
/* 316 */     STaskPvcCfg cfg = getPvcCfg();
/* 317 */     if (cfg == null)
/*     */     {
/* 319 */       return -1;
/*     */     }
/* 321 */     return cfg.taskUseId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\pvc\AbsPvcFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */