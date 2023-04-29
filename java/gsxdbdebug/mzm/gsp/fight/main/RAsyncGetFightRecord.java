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
/*    */ class RAsyncGetFightRecord
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final AsyncGetFightRecordInfo info;
/*    */   
/*    */   public RAsyncGetFightRecord(AsyncGetFightRecordInfo info)
/*    */   {
/* 48 */     this.info = info;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 54 */     if (!GrcInterface.asyncGetFightRecord(this.info.recordid, this.info.dataType, this.info.context))
/*    */     {
/* 56 */       new RAsyncGetFightRecord(this.info);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RAsyncGetFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */