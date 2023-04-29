/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.MenpaiPVPScore;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 18 */     MenpaiPVPScore xScore = MenpaiPVPManager.getXScore(roleid, true);
/*    */     
/*    */ 
/* 21 */     if (!ActivityInterface.isActivityOpen(MenpaiPVPConfigManager.getInstance().getActivityID())) {
/* 22 */       RoleStatusInterface.unsetStatus(roleid, 5);
/*    */ 
/*    */ 
/*    */     }
/* 26 */     else if (RoleStatusInterface.containsStatus(roleid, 5))
/*    */     {
/*    */ 
/* 29 */       MenpaiPVPManager.syncStage(roleid);
/*    */       
/* 31 */       MenpaiPVPManager.syncScore(roleid, xScore);
/*    */       
/* 33 */       MenpaiPVPManager.sendMatchCountDown(roleid);
/*    */     }
/*    */     
/*    */ 
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */