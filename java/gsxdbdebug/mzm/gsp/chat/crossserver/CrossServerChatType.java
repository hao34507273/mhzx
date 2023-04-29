/*    */ package mzm.gsp.chat.crossserver;
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
/*    */ public enum CrossServerChatType
/*    */ {
/* 14 */   CrossCompete(0, 2);
/*    */   
/*    */   private final int type;
/*    */   private final int channel;
/*    */   
/*    */   private CrossServerChatType(int type, int channel)
/*    */   {
/* 21 */     this.type = type;
/* 22 */     this.channel = channel;
/*    */   }
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return this.type;
/*    */   }
/*    */   
/*    */   public int getChannel()
/*    */   {
/* 32 */     return this.channel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\crossserver\CrossServerChatType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */