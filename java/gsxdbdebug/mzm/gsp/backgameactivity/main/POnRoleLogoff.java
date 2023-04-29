/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/*  9 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 12 */     xbean.BackGameActivityInfo xBackGameActivityInfo = xtable.Role2backgameactivity.get(Long.valueOf(roleId));
/* 13 */     if (null == xBackGameActivityInfo)
/*    */     {
/* 15 */       return false;
/*    */     }
/* 17 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 23 */     BackGameActivityManager.updateLoginCountOnline(xBackGameActivityInfo);
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */