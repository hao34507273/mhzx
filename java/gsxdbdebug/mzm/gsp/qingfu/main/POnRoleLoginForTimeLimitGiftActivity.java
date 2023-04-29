/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2timelimitgift;
/*    */ 
/*    */ public class POnRoleLoginForTimeLimitGiftActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userId;
/*    */   private final long roleId;
/*    */   
/*    */   public POnRoleLoginForTimeLimitGiftActivity(String userId, long roleId)
/*    */   {
/* 13 */     this.userId = userId;
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     lock(Lockeys.get(xtable.User.getTable(), this.userId));
/* 22 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleId)));
/* 23 */     xbean.TimeLimitGift xTimeLimitGift = Role2timelimitgift.get(Long.valueOf(this.roleId));
/* 24 */     if (xTimeLimitGift == null)
/*    */     {
/* 26 */       xTimeLimitGift = xbean.Pod.newTimeLimitGift();
/* 27 */       Role2timelimitgift.insert(Long.valueOf(this.roleId), xTimeLimitGift);
/*    */     }
/*    */     
/* 30 */     return TimeLimitGiftActivityManager.onRoleLogin(this.userId, this.roleId, xTimeLimitGift);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLoginForTimeLimitGiftActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */