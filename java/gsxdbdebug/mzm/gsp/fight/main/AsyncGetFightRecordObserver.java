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
/*    */ class AsyncGetFightRecordObserver
/*    */   extends MilliObserver
/*    */ {
/*    */   private final AsyncGetFightRecordInfo info;
/*    */   
/*    */   AsyncGetFightRecordObserver(AsyncGetFightRecordInfo info)
/*    */   {
/* 29 */     super(1000L);
/*    */     
/* 31 */     this.info = info;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 37 */     Executor.getInstance().execute(new RAsyncGetFightRecord(this.info));
/* 38 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\AsyncGetFightRecordObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */