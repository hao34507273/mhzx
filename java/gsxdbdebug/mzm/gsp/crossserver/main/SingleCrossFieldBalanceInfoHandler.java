/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldBalanceInfoHandler
/*    */   implements CollectServerBalanceInfoHandler
/*    */ {
/*    */   public int getOnlineNum()
/*    */   {
/* 16 */     return SingleBattleInterface.getValidMemberNum(1);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getReservedNum()
/*    */   {
/* 22 */     return SingleBattleInterface.getShouldMemberNum(1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldBalanceInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */