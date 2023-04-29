/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.common.RecoveryTimeDurationObserver;
/*    */ import mzm.gsp.gang.confbean.GangMiFangConst;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PYaoDianMiFangDurationObserver
/*    */   extends RecoveryTimeDurationObserver
/*    */ {
/* 11 */   private static boolean start = false;
/* 12 */   private static PYaoDianMiFangDurationObserver observer = new PYaoDianMiFangDurationObserver();
/*    */   
/*    */   private PYaoDianMiFangDurationObserver() {
/* 15 */     super(GangMiFangConst.getInstance().OPEN_DURATION);
/* 16 */     observer = this;
/*    */   }
/*    */   
/*    */   public static PYaoDianMiFangDurationObserver getInstance() {
/* 20 */     return observer;
/*    */   }
/*    */   
/*    */   protected boolean onStartTimeOut()
/*    */   {
/* 25 */     start = true;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   protected void onLastTimeOut()
/*    */   {
/* 31 */     start = false;
/*    */   }
/*    */   
/*    */   public boolean isStart() {
/* 35 */     return start;
/*    */   }
/*    */   
/*    */   public boolean isBetween(long time) {
/* 39 */     if ((start) && (time > getLogicStartTime()) && (time < getLogicEndTime())) {
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public void onReStartTimeOut()
/*    */   {
/* 47 */     onStartTimeOut();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PYaoDianMiFangDurationObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */