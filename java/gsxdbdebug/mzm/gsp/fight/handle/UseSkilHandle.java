/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface UseSkilHandle {
/*    */   public abstract void useSkill(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj {
/*    */     private Fighter releser;
/*    */     private mzm.gsp.skill.main.Skill skill;
/*    */     
/* 12 */     public InputObj(Fighter releser, mzm.gsp.skill.main.Skill skill) { this.releser = releser;
/* 13 */       this.skill = skill;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 17 */       return this.releser;
/*    */     }
/*    */     
/*    */     public mzm.gsp.skill.main.Skill getSkill() {
/* 21 */       return this.skill;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj
/*    */   {
/* 27 */     public int changedSkill = 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\UseSkilHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */