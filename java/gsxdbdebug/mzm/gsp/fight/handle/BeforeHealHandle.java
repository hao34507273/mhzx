/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public abstract interface BeforeHealHandle
/*    */ {
/*    */   public abstract void handleBeforeHeal(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private Fighter target;
/*    */     private Skill skill;
/*    */     private mzm.gsp.effect.main.FighterEffectGroup fighterEffectGroup;
/*    */     
/*    */     public InputObj(Fighter releser, Fighter target, Skill skill, mzm.gsp.effect.main.FighterEffectGroup fighterEffectGroup)
/*    */     {
/* 19 */       this.releser = releser;
/* 20 */       this.target = target;
/* 21 */       this.skill = skill;
/* 22 */       this.fighterEffectGroup = fighterEffectGroup;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 26 */       return this.releser;
/*    */     }
/*    */     
/*    */     public Fighter getTarget() {
/* 30 */       return this.target;
/*    */     }
/*    */     
/*    */     public Skill getSkill() {
/* 34 */       return this.skill;
/*    */     }
/*    */     
/*    */     public mzm.gsp.effect.main.FighterEffectGroup getFighterEffectGroup() {
/* 38 */       return this.fighterEffectGroup;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static class OutputObj
/*    */   {
/*    */     public int healeffectrate;
/*    */     
/*    */     public int baseHeal;
/*    */     
/*    */     public int healFix;
/*    */     
/*    */     public int modifyParam;
/*    */     
/*    */     public int beHealEffectrate;
/*    */     
/* 56 */     public java.util.Set<Integer> releaserPassiveSkills = new java.util.HashSet();
/*    */     
/* 58 */     public java.util.Set<Integer> targetPassiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeforeHealHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */