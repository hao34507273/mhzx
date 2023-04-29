/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RoamType
/*    */ {
/*  8 */   LADDER(96), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   CROSS_COMPETE(1502), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   CROSS_BATTLE_POINT(1445), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   CROSS_BATTLE_SELECTION_FINAL(1741), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   SINGLE_CROSS_FIELD(1583);
/*    */   
/*    */   private final int status;
/*    */   
/*    */   private RoamType(int status)
/*    */   {
/* 34 */     this.status = status;
/*    */   }
/*    */   
/*    */   public int getMask()
/*    */   {
/* 39 */     return 1 << ordinal();
/*    */   }
/*    */   
/*    */   public final int getStatus()
/*    */   {
/* 44 */     return this.status;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */