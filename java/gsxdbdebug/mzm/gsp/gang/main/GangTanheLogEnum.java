/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum GangTanheLogEnum
/*    */ {
/*  8 */   START(1), 
/*  9 */   SUCCESS(2), 
/* 10 */   CANCEL(3), 
/* 11 */   FAIL(4);
/*    */   
/*    */   public final int value;
/*    */   
/* 15 */   private GangTanheLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangTanheLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */