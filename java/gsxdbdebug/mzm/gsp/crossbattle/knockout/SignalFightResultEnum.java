/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum SignalFightResultEnum
/*    */ {
/*  8 */   FIGHT_WIN(1), 
/*    */   
/*    */ 
/*    */ 
/* 12 */   FIGHT_LOSE(2), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 17 */   ABSTAIN_WIN(3), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 22 */   ABSTAIN_LOSE(4), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 27 */   BYE_WIN(5), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 32 */   BYE(6);
/*    */   
/*    */   public final int fightResult;
/*    */   
/*    */   private SignalFightResultEnum(int fightResult)
/*    */   {
/* 38 */     this.fightResult = fightResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\SignalFightResultEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */