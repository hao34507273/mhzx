/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qmhw.SSynStageChange;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import xbean.QMHWActivity;
/*    */ import xtable.Role2jiuxiao;
/*    */ 
/*    */ public class POnTransferScene extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long oldWorldid = ((MapTransferArg)this.arg).oldWorldId;
/* 17 */     long newWorldid = ((MapTransferArg)this.arg).newWorldId;
/*    */     
/* 19 */     QMHWActivity xQmhwActivity = xtable.Qmhw.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 20 */     if (xQmhwActivity == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     long quhwWorld = xQmhwActivity.getWorldid();
/*    */     
/* 26 */     lock(Role2jiuxiao.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */     
/* 28 */     if ((oldWorldid != quhwWorld) || (newWorldid != quhwWorld))
/*    */     {
/* 30 */       if ((oldWorldid == quhwWorld) && (newWorldid != quhwWorld))
/*    */       {
/* 32 */         mzm.gsp.status.main.RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 31);
/* 33 */       } else if ((oldWorldid != quhwWorld) && (newWorldid == quhwWorld))
/*    */       {
/*    */ 
/* 36 */         SSynStageChange synStageChange = new SSynStageChange();
/* 37 */         synStageChange.stage = mzm.gsp.activity.main.ActivityInterface.getActivityStage(SQMHWCfgConsts.getInstance().ACTIVITY_ID);
/* 38 */         OnlineManager.getInstance().sendMulti(synStageChange, ((MapTransferArg)this.arg).roleList);
/*    */       } }
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */