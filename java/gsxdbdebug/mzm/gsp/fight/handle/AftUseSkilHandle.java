/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface AftUseSkilHandle
/*    */ {
/*    */   public abstract void aftUseSkill(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private mzm.gsp.skill.main.Skill skill;
/*    */     private int mainTargetid;
/*    */     
/*    */     public InputObj(Fighter releser, mzm.gsp.skill.main.Skill skill, int mainTargetid)
/*    */     {
/* 17 */       this.releser = releser;
/* 18 */       this.skill = skill;
/* 19 */       this.mainTargetid = mainTargetid;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 23 */       return this.releser;
/*    */     }
/*    */     
/*    */     public mzm.gsp.skill.main.Skill getSkill() {
/* 27 */       return this.skill;
/*    */     }
/*    */     
/*    */     public int getMainTargetId() {
/* 31 */       return this.mainTargetid;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj
/*    */   {
/* 37 */     public java.util.Set<Integer> releaserPassiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\AftUseSkilHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */