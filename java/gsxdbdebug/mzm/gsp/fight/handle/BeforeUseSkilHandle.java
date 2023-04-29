/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface BeforeUseSkilHandle
/*    */ {
/*    */   public abstract void beforeUseSkill(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private mzm.gsp.skill.main.Skill skill;
/*    */     
/*    */     public InputObj(Fighter paramFighter, mzm.gsp.skill.main.Skill paramSkill) {
/* 15 */       this.releser = paramFighter;
/* 16 */       this.skill = paramSkill;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 20 */       return this.releser;
/*    */     }
/*    */     
/*    */     public mzm.gsp.skill.main.Skill getSkill() {
/* 24 */       return this.skill;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj {
/* 29 */     public int changedSkill = 0;
/*    */     public int skillLevelModify;
/*    */     public boolean seal;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeforeUseSkilHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */