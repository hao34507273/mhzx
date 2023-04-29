/*    */ package mzm.gsp.apollo.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerEnterProtectProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleEnterProtect extends PlayerEnterProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((Long)this.arg).longValue();
/* 11 */     String userid = RoleInterface.getUserId(roleid);
/*    */     
/* 13 */     ApolloManager.onRoleLogoff(roleid, userid, true);
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\POnRoleEnterProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */