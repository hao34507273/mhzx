/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/*    */     
/* 18 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/*    */ 
/* 21 */     FirstRechargeManager.trySendTipMail(userid, roleid);
/*    */     
/*    */ 
/* 24 */     SaveAmtActivityManager.trySendTipMail(userid, roleid);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */