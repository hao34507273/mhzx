/*    */ package mzm.gsp.exchange.main;
/*    */ 
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((Long)this.arg).longValue();
/* 12 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 13 */     lock(Lockeys.get(User.getTable(), userid));
/* 14 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 16 */     return ExchangeManager.onRoleLogin(userid, roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */