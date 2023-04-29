/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class ROnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 12 */       return;
/*    */     }
/*    */     
/* 15 */     new POnRoleLevelUpForInviter(((RoleLevelUpArg)this.arg).roleId).call();
/* 16 */     new POnRoleLevelUpForInvitee(((RoleLevelUpArg)this.arg).roleId).call();
/* 17 */     new POnRoleLevelUpForRecall(((RoleLevelUpArg)this.arg).roleId).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\ROnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */