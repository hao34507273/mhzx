/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/* 12 */     String userId = RoleInterface.getUserId(roleId);
/* 13 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/* 15 */     FashionDressManager.onRoleLogin(userId, roleId);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */