/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import xtable.Role2forcedivorcetimer;
/*    */ 
/*    */ public class POnRoleLogoff extends mzm.gsp.online.event.PlayerEnterProtectProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     xbean.ForcedDivorceTimer xForcedDivorceTimer = Role2forcedivorcetimer.get((Long)this.arg);
/*  8 */     if (xForcedDivorceTimer != null) {
/*  9 */       xForcedDivorceTimer.getForcedivorcetimer().stopTimer();
/* 10 */       Role2forcedivorcetimer.remove((Long)this.arg);
/*    */     }
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */