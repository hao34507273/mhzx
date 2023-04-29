/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum OnlineTreasureBoxActionEnum
/*    */ {
/*  7 */   BROADCAST_STAGE(1), 
/*  8 */   START_STAGE(2), 
/*  9 */   CLOSE_STAGE(3);
/*    */   
/*    */   public final int value;
/*    */   
/* 13 */   private OnlineTreasureBoxActionEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 18 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\OnlineTreasureBoxActionEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */