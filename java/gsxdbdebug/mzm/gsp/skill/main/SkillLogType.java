/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum SkillLogType
/*    */ {
/*  7 */   MENPAI_SKILL(1), 
/*  8 */   XIULIAN_SKILL(2), 
/*  9 */   LIFE_SKILL(3);
/*    */   
/*    */   private int value;
/*    */   
/* 13 */   private SkillLogType(int value) { this.value = value; }
/*    */   
/*    */   public int value() {
/* 16 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 21 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\SkillLogType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */