/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public abstract interface LoseHpHandle { public abstract void handleOnLoseHp(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class OutputObj {}
/*    */   
/*    */   public static class InputObj { private Fighter fighter;
/*    */     private int loseHp;
/*    */     
/* 12 */     public InputObj(Fighter fighter, int loseHp) { this.fighter = fighter;
/* 13 */       this.loseHp = loseHp;
/*    */     }
/*    */     
/*    */     public Fighter getFighter() {
/* 17 */       return this.fighter;
/*    */     }
/*    */     
/*    */     public int getLoseHp() {
/* 21 */       return this.loseHp;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\LoseHpHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */