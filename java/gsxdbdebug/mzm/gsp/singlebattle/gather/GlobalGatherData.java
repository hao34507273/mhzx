/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GlobalGatherData
/*    */ {
/* 13 */   private static AtomicLong nextGatherId = new AtomicLong(0L);
/*    */   
/*    */   static long getNewGatherId()
/*    */   {
/* 17 */     return nextGatherId.addAndGet(1L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\GlobalGatherData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */