/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnRoleLoginForDailyGift extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   public POnRoleLoginForDailyGift(String userid, long roleid)
/*    */   {
/* 13 */     this.userid = userid;
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     lock(Lockeys.get(xtable.User.getTable(), this.userid));
/* 22 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 24 */     DailyGiftManager.onRoleLogin(this.userid, this.roleid);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLoginForDailyGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */