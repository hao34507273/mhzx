/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PetPointChangeLogEnum
/*    */ {
/*  7 */   AUTOADD_TYPE(1), 
/*  8 */   DIYADD_TYPE(2), 
/*  9 */   RESET_TYPE(3);
/*    */   
/*    */   public final int value;
/*    */   
/* 13 */   private PetPointChangeLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 18 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetPointChangeLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */