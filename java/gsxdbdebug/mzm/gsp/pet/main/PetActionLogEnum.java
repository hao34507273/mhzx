/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PetActionLogEnum
/*    */ {
/*  7 */   CATCH(1), 
/*  8 */   FANSHENG(2), 
/*  9 */   FANSHENG_BIANYI(3), 
/* 10 */   LIANGU(4), 
/* 11 */   HUASHENG(5), 
/* 12 */   NPC_BUY(6);
/*    */   
/*    */   public final int value;
/*    */   
/* 16 */   private PetActionLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 21 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetActionLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */