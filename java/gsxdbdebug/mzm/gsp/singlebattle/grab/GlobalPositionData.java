/*    */ package mzm.gsp.singlebattle.grab;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ public class GlobalPositionData
/*    */ {
/*  7 */   private static AtomicLong nextPositionId = new AtomicLong(0L);
/*    */   
/*    */   static long getNewPositionId()
/*    */   {
/* 11 */     return nextPositionId.addAndGet(1L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\grab\GlobalPositionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */