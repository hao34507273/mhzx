/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PetSkillChangeLogEnum
/*    */ {
/*  7 */   INIT(1), 
/*  8 */   SKILLBOOK(2), 
/*  9 */   HUASHENG(3), 
/* 10 */   FANSHENG(4), 
/* 11 */   ZAISHENG(5), 
/* 12 */   JINJIE(6), 
/* 13 */   AUTOLEARN(7), 
/* 14 */   AUTOLEVELUP(8);
/*    */   
/*    */   public final int value;
/*    */   
/* 18 */   private PetSkillChangeLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 23 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetSkillChangeLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */