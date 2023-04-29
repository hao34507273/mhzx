/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import xbean.RoundRobinFightInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattleRoundRobinFightInfo
/*    */ {
/*    */   final RoundRobinFightInfo xRoundRobinFightInfo;
/*    */   
/*    */   public CrossBattleRoundRobinFightInfo(RoundRobinFightInfo xRoundRobinFightInfo)
/*    */   {
/* 13 */     this.xRoundRobinFightInfo = xRoundRobinFightInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsAid()
/*    */   {
/* 23 */     return this.xRoundRobinFightInfo.getCorps_a_id();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsBid()
/*    */   {
/* 33 */     return this.xRoundRobinFightInfo.getCorps_b_id();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getState()
/*    */   {
/* 43 */     return this.xRoundRobinFightInfo.getState();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleRoundRobinFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */