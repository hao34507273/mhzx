/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActivityStage
/*    */ {
/*    */   public final TimeBaseLine timeBaseLine;
/*    */   
/*    */   public final TimeLogic timeLogic;
/*    */   
/*    */   public final int minute;
/*    */   
/*    */   int stage;
/*    */   
/*    */ 
/*    */   public static enum TimeBaseLine
/*    */   {
/* 18 */     BEGIN, 
/* 19 */     END, 
/* 20 */     BEFORE, 
/* 21 */     BEGIN_BEFORE;
/*    */     
/*    */ 
/*    */ 
/*    */     private TimeBaseLine() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static enum TimeLogic
/*    */   {
/* 32 */     FIX, 
/* 33 */     RELATIVE;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     private TimeLogic() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ActivityStage(int minute, TimeBaseLine timeBaseLine, TimeLogic timeLogic)
/*    */   {
/* 50 */     this.minute = minute;
/* 51 */     this.timeBaseLine = timeBaseLine;
/* 52 */     this.timeLogic = timeLogic;
/*    */   }
/*    */   
/*    */   public boolean isTimeBaseLineBegin()
/*    */   {
/* 57 */     return TimeBaseLine.BEGIN.equals(this.timeBaseLine);
/*    */   }
/*    */   
/*    */   public boolean isTimeBaseLineEnd() {
/* 61 */     return TimeBaseLine.END.equals(this.timeBaseLine);
/*    */   }
/*    */   
/*    */   public boolean isTimeBaseLineBefore() {
/* 65 */     return TimeBaseLine.BEFORE.equals(this.timeBaseLine);
/*    */   }
/*    */   
/*    */   public boolean isTimeBeseLineBeginBefore() {
/* 69 */     return TimeBaseLine.BEGIN_BEFORE.equals(this.timeBaseLine);
/*    */   }
/*    */   
/*    */   public boolean isTimeLogicFix() {
/* 73 */     return TimeLogic.FIX.equals(this.timeLogic);
/*    */   }
/*    */   
/*    */   public boolean isTimeLogicRelative() {
/* 77 */     return TimeLogic.RELATIVE.equals(this.timeLogic);
/*    */   }
/*    */   
/*    */   void setStage(int stage) {
/* 81 */     this.stage = stage;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\ActivityStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */