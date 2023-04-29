/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ChivalryDayInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     ChivalryDayInfo cDayInfo = ChivalryManager.getRoleChivalryDayInfo(((Long)this.arg).longValue(), false);
/* 18 */     if (cDayInfo == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     long currentTime = DateTimeUtils.getCurrTimeInMillis() + 1000L;
/* 23 */     long lastClearTime = cDayInfo.getLastflushtime();
/* 24 */     if (!DateTimeUtils.isInSameDay(lastClearTime, currentTime))
/*    */     {
/* 26 */       PChivalryDayInitPro p = new PChivalryDayInitPro(((Long)this.arg).longValue());
/* 27 */       return p.call();
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */