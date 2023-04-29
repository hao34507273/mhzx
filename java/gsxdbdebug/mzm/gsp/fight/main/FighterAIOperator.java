/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ public abstract class FighterAIOperator implements AIOperator
/*    */ {
/*    */   private boolean needRound;
/*    */   
/*    */   FighterAIOperator(boolean needRound) {
/*  8 */     this.needRound = needRound;
/*    */   }
/*    */   
/*    */   public boolean isNeedRound() {
/* 12 */     return this.needRound;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterAIOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */