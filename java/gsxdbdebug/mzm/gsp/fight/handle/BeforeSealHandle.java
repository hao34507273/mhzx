/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface BeforeSealHandle { public abstract void handleBeforeAttack(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class OutputObj { public int sealRate;
/*    */   }
/*    */   
/*    */   public static class InputObj { public final Fighter releaser;
/*    */     public final Fighter target;
/*    */     
/* 13 */     public InputObj(Fighter releaser, Fighter target, mzm.gsp.skill.main.Skill skill) { this.releaser = releaser;
/* 14 */       this.target = target;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 18 */       return this.releaser;
/*    */     }
/*    */     
/*    */     public Fighter getTarget() {
/* 22 */       return this.target;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeforeSealHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */