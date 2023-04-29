/*    */ package mzm.gsp.status.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     Set<Integer> statusSet = RoleStatusInterface.getStatusSet(((Long)this.arg).longValue());
/* 11 */     return RoleStatusManager.onRoleLogin(((Long)this.arg).longValue(), statusSet);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */