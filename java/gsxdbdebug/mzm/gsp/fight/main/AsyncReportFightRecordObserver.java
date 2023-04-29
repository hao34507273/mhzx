/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import xdb.Executor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AsyncReportFightRecordObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private final AsyncReportFightRecordInfo info;
/*    */   
/*    */   AsyncReportFightRecordObserver(AsyncReportFightRecordInfo info)
/*    */   {
/* 31 */     super(1000L);
/*    */     
/* 33 */     this.info = info;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 39 */     Executor.getInstance().execute(new RAsyncReportFightRecord(this.info));
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\AsyncReportFightRecordObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */