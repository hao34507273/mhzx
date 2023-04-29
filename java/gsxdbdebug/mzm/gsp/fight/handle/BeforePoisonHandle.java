/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface BeforePoisonHandle { public abstract void beforePoison(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class OutputObj { public int expoisonrate; }
/*    */   
/*    */   public static class InputObj { private Fighter releser;
/*    */     private Fighter target;
/*    */     private mzm.gsp.skill.main.Skill skill;
/*    */     
/* 13 */     public InputObj(Fighter releser, Fighter target, mzm.gsp.skill.main.Skill skill) { this.releser = releser;
/* 14 */       this.target = target;
/* 15 */       this.skill = skill;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 19 */       return this.releser;
/*    */     }
/*    */     
/*    */     public Fighter getTarget() {
/* 23 */       return this.target;
/*    */     }
/*    */     
/*    */     public mzm.gsp.skill.main.Skill getSkill() {
/* 27 */       return this.skill;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeforePoisonHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */