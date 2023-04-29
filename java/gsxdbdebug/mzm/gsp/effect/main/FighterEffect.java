/*    */ package mzm.gsp.effect.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ import mzm.gsp.skill.main.PassiveSkill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class FighterEffect
/*    */   implements Effect<Fighter>
/*    */ {
/*    */   private FighterBuff fighterBuff;
/*    */   private int passiveSkillid;
/*    */   private int passiveSkillLv;
/*    */   
/*    */   public void setGroup(FighterBuff fighterBuff)
/*    */   {
/* 21 */     this.fighterBuff = fighterBuff;
/*    */   }
/*    */   
/*    */   public FighterBuff getGroup() {
/* 25 */     return this.fighterBuff;
/*    */   }
/*    */   
/*    */   public void setPassiveSkill(PassiveSkill passiveSkill) {
/* 29 */     this.passiveSkillid = passiveSkill.getPassiveSkillCfgId();
/* 30 */     this.passiveSkillLv = passiveSkill.getLevel();
/*    */   }
/*    */   
/*    */   public int getPassiveSkillid() {
/* 34 */     return this.passiveSkillid;
/*    */   }
/*    */   
/*    */   public int getPassiveSkillLv() {
/* 38 */     return this.passiveSkillLv;
/*    */   }
/*    */   
/*    */   protected int getSkillLevel() {
/* 42 */     FighterBuff fighterBuff = getGroup();
/* 43 */     int level = 1;
/* 44 */     if (fighterBuff != null) {
/* 45 */       level = fighterBuff.getLevel();
/*    */     }
/* 47 */     else if (getPassiveSkillid() > 0) {
/* 48 */       level = getPassiveSkillLv();
/*    */     }
/*    */     
/* 51 */     return level;
/*    */   }
/*    */   
/*    */   protected void setLeftRound(int leftRound) {
/* 55 */     if (this.fighterBuff != null) {
/* 56 */       this.fighterBuff.setLeftRound(leftRound);
/*    */     }
/*    */   }
/*    */   
/*    */   protected int getLeftRound() {
/* 61 */     if (this.fighterBuff != null) {
/* 62 */       return this.fighterBuff.getLeftRound();
/*    */     }
/* 64 */     return 0;
/*    */   }
/*    */   
/*    */   public abstract boolean attach(Fighter paramFighter);
/*    */   
/*    */   public abstract boolean detach(Fighter paramFighter);
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\FighterEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */