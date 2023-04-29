/*    */ package mzm.gsp.cake.main;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ 
/*    */ public class GlobalOvenData
/*    */ {
/*  7 */   private static AtomicLong nextOvenInstanceId = new AtomicLong(0L);
/*    */   
/*    */   static long getNewOvenInstanceId()
/*    */   {
/* 11 */     return nextOvenInstanceId.addAndGet(1L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\GlobalOvenData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */