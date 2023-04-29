/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum GangDismissActionLogEnum
/*    */ {
/*  7 */   ACTIVIE_DISMISS(1), 
/*  8 */   MAINTAIN_DISMISS(2);
/*    */   
/*    */   public final int value;
/*    */   
/* 12 */   private GangDismissActionLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 17 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangDismissActionLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */