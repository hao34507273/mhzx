/*    */ package mzm.gsp.chat.crossserver;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CrossServerChatExtraInfoType
/*    */ {
/* 12 */   FactionDuty(0), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 17 */   FactionidHigh(1), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 22 */   FactionidLow(2);
/*    */   
/*    */   private final int type;
/*    */   
/*    */   private CrossServerChatExtraInfoType(int type)
/*    */   {
/* 28 */     this.type = type;
/*    */   }
/*    */   
/*    */   public int getType()
/*    */   {
/* 33 */     return this.type;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\crossserver\CrossServerChatExtraInfoType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */