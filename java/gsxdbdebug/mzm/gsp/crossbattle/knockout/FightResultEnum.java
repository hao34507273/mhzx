/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FightResultEnum
/*    */ {
/*  8 */   A_FIGHT_WIN(1), 
/*    */   
/*    */ 
/*    */ 
/* 12 */   A_FIGHT_LOSE(2), 
/*    */   
/*    */ 
/*    */ 
/* 16 */   A_ABSTAIN_WIN(3), 
/*    */   
/*    */ 
/*    */ 
/* 20 */   A_ABSTAIN_LOSE(4), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 25 */   A_BYE_WIN(5), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 30 */   B_BYE_WIN(6), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 35 */   ALL_ABSTAIN(7), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 40 */   ALL_BYE(8);
/*    */   
/*    */   public final int fightResult;
/*    */   
/*    */   private FightResultEnum(int fightResult)
/*    */   {
/* 46 */     this.fightResult = fightResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\FightResultEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */