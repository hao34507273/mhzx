/*    */ package mzm.gsp.massexp.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.MassExpInfo;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     long roleid = ((Long)this.arg).longValue();
/* 18 */     if (!MassExpManager.isFunOpen(roleid, false))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*    */     
/* 25 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(roleid, activityCfgid);
/* 26 */     if (xMassExpInfo == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (xMassExpInfo.getStatus() == 1)
/*    */     {
/*    */ 
/* 34 */       MassExpManager.stopObserver(roleid, activityCfgid);
/*    */     }
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */