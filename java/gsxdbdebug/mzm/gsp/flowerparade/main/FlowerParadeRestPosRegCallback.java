/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ 
/*    */ public class FlowerParadeRestPosRegCallback
/*    */   implements MapCallback<Integer>
/*    */ {
/*    */   private final FlowerParadeRestPosZoneListener listener;
/*    */   
/*    */   public FlowerParadeRestPosRegCallback(FlowerParadeRestPosZoneListener listener)
/*    */   {
/* 12 */     this.listener = listener;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 18 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onResult(Integer result)
/*    */   {
/* 24 */     int eventId = result.intValue();
/* 25 */     this.listener.setEventId(eventId);
/* 26 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeRestPosRegCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */