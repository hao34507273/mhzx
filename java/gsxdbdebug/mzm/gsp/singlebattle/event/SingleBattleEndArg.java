/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.SingleBattleResult;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleBattleEndArg
/*    */ {
/*    */   private final long battleId;
/*    */   private final SingleBattleResult res;
/*    */   
/*    */   public SingleBattleEndArg(long battleId, SingleBattleResult res)
/*    */   {
/* 18 */     this.battleId = battleId;
/* 19 */     this.res = res;
/*    */   }
/*    */   
/*    */   long getBattleId()
/*    */   {
/* 24 */     return this.battleId;
/*    */   }
/*    */   
/*    */   SingleBattleResult getRes() {
/* 28 */     return this.res;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\SingleBattleEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */