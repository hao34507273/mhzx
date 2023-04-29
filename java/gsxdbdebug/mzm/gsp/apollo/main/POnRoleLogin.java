/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.apollo.SSyncApolloInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleid = ((Long)this.arg).longValue();
/* 13 */     String userid = RoleInterface.getUserId(roleid);
/* 14 */     SSyncApolloInfo info = new SSyncApolloInfo();
/* 15 */     ApolloManager.onRoleLogin(roleid, userid, info);
/* 16 */     OnlineManager.getInstance().send(roleid, info);
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */