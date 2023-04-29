/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qmhw.SSynStageChange;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import xbean.QMHWActivity;
/*    */ import xbean.RoleQMHWScore;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     RoleQMHWScore xRoleQMHWScore = xtable.Role2qmhw.get((Long)this.arg);
/*    */     
/* 19 */     long worldid = MapInterface.getRoleWorldInstanceId(((Long)this.arg).longValue());
/*    */     
/* 21 */     QMHWActivity xQmhwActivity = xtable.Qmhw.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 22 */     if ((xQmhwActivity == null) || (worldid != xQmhwActivity.getWorldid()))
/*    */     {
/* 24 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 31);
/*    */     }
/* 26 */     if (xQmhwActivity == null) {
/* 27 */       return true;
/*    */     }
/* 29 */     if (!ActivityInterface.isActivityOpen(SQMHWCfgConsts.getInstance().ACTIVITY_ID)) {
/* 30 */       return true;
/*    */     }
/* 32 */     if (xRoleQMHWScore != null) {
/* 33 */       QMHWManager.sendRoleQMHWTotalInfo(((Long)this.arg).longValue(), xRoleQMHWScore);
/*    */     }
/* 35 */     if (worldid == xQmhwActivity.getWorldid())
/*    */     {
/* 37 */       int stage = ActivityInterface.getActivityStage(SQMHWCfgConsts.getInstance().ACTIVITY_ID);
/* 38 */       SSynStageChange synStageChange = new SSynStageChange();
/* 39 */       synStageChange.stage = stage;
/* 40 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), synStageChange);
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */