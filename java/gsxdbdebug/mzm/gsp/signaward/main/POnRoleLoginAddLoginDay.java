/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginAddLoginDay
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long logintime = SignAwardManager.getLoginTime(((Long)this.arg).longValue());
/*    */     
/* 19 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/* 20 */     if ((!DateTimeUtils.isInSameDay(logintime, cur)) && (cur > logintime))
/*    */     {
/* 22 */       boolean ret = SignAwardManager.addLoginDay(((Long)this.arg).longValue(), cur);
/* 23 */       if (!ret)
/*    */       {
/* 25 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 29 */     SignAwardManager.sendSLoginAwardRes(((Long)this.arg).longValue(), null);
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\POnRoleLoginAddLoginDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */