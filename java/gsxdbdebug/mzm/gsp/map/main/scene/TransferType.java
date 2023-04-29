/*    */ package mzm.gsp.map.main.scene;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum TransferType
/*    */ {
/* 11 */   TRANSPOS, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 16 */   GM, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   FAULT, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 26 */   LOGIN, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 31 */   SOMMON, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 36 */   FORCE_TRANSFER, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 41 */   ZONE_TRANSFER, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 46 */   TEAM, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 51 */   COUPLE_FLY, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 56 */   MARRIAGE, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 61 */   WATCH_MOON_XYXW_FLY, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 66 */   WATCH_MOON_SIDE_BY_SIDE_FLY, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 71 */   ENTER_HOME, 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 76 */   UNKNOWN;
/*    */   
/*    */   private TransferType() {}
/*    */   
/* 80 */   public static TransferType getTransferType(int ordinal) { TransferType[] types = values();
/* 81 */     if ((ordinal > types.length - 2) || (ordinal < 0))
/*    */     {
/* 83 */       return UNKNOWN;
/*    */     }
/* 85 */     return types[ordinal];
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\TransferType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */