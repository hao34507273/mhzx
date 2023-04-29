/*    */ package mzm.gsp.lifeskill.main;
/*    */ 
/*    */ import mzm.gsp.skill.confbean.SLifeSkillBag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LifeSkill
/*    */ {
/*    */   protected SLifeSkillBag skillBag;
/*    */   protected int level;
/*    */   protected LifeSkillBag<?> parent;
/*    */   
/*    */   public void setParent(LifeSkillBag<?> parent)
/*    */   {
/* 16 */     this.parent = parent;
/*    */   }
/*    */   
/*    */   public LifeSkill(SLifeSkillBag skillBag, int level) {
/* 20 */     this.skillBag = skillBag;
/* 21 */     this.level = level;
/*    */   }
/*    */   
/*    */   public SLifeSkillBag getSkillBag()
/*    */   {
/* 26 */     return this.skillBag;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 30 */     return this.level;
/*    */   }
/*    */   
/*    */   public int getCostVigor() {
/* 34 */     if (this.parent == null)
/* 35 */       return -1;
/* 36 */     return this.parent.getCostVigor();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\main\LifeSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */