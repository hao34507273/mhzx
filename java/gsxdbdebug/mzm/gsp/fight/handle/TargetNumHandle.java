/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface TargetNumHandle
/*    */ {
/*    */   public abstract void onTargetNum(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private mzm.gsp.skill.main.Skill skill;
/*    */     private int formulaNum;
/*    */     private int scacleNum;
/*    */     
/*    */     public InputObj(Fighter releser, mzm.gsp.skill.main.Skill skill, int formulaNum, int scacleNum)
/*    */     {
/* 18 */       this.releser = releser;
/* 19 */       this.skill = skill;
/* 20 */       this.formulaNum = formulaNum;
/* 21 */       this.scacleNum = scacleNum;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 25 */       return this.releser;
/*    */     }
/*    */     
/*    */     public mzm.gsp.skill.main.Skill getSkill() {
/* 29 */       return this.skill;
/*    */     }
/*    */     
/*    */     public int getFormulaNum() {
/* 33 */       return this.formulaNum;
/*    */     }
/*    */     
/*    */     public int getScacleNum() {
/* 37 */       return this.scacleNum;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public static class OutputObj
/*    */   {
/*    */     public int finalTargetNum;
/* 45 */     public java.util.Set<Integer> passiveSkillids = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\TargetNumHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */