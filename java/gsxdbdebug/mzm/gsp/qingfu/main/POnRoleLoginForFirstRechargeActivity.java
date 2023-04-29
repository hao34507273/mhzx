/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLoginForFirstRechargeActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   public POnRoleLoginForFirstRechargeActivity(String userid, long roleid)
/*    */   {
/* 14 */     this.userid = userid;
/* 15 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (mzm.gsp.GameServerInfoManager.isRoamServer())
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 27 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 28 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 31 */     if (!FirstRechargeManager.onSaveAmtChanged(this.userid, true))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     FirstRechargeManager.trySendTipMail(this.userid, this.roleid);
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLoginForFirstRechargeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */