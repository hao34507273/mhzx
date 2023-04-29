/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
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
/*    */ class RAsyncReportFightRecord
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final AsyncReportFightRecordInfo info;
/*    */   
/*    */   public RAsyncReportFightRecord(AsyncReportFightRecordInfo info)
/*    */   {
/* 50 */     this.info = info;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 56 */     if (!GrcInterface.asyncReportFightRecord(this.info.recordid, this.info.dataType, this.info.data, this.info.context))
/*    */     {
/* 58 */       new AsyncReportFightRecordObserver(this.info);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RAsyncReportFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */