/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import xbean.RoundRobinFightInfo;
/*    */ import xbean.RoundRobinRoundInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattleRoundRobinRoundInfo
/*    */ {
/*    */   final RoundRobinRoundInfo xRoundRobinRoundInfo;
/*    */   
/*    */   public CrossBattleRoundRobinRoundInfo(RoundRobinRoundInfo xRoundRobinRoundInfo)
/*    */   {
/* 16 */     this.xRoundRobinRoundInfo = xRoundRobinRoundInfo;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<CrossBattleRoundRobinFightInfo> getRoundRobinFightInfoList()
/*    */   {
/* 26 */     List<CrossBattleRoundRobinFightInfo> fightInfos = new ArrayList();
/* 27 */     for (RoundRobinFightInfo xRoundRobinFightInfo : this.xRoundRobinRoundInfo.getFight_infos())
/*    */     {
/* 29 */       fightInfos.add(new CrossBattleRoundRobinFightInfo(xRoundRobinFightInfo));
/*    */     }
/* 31 */     return fightInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public CrossBattleRoundRobinFightInfo getRoundRobinFightInfo(long corpsAid, long corpsBid)
/*    */   {
/* 45 */     for (RoundRobinFightInfo xRoundRobinFightInfo : this.xRoundRobinRoundInfo.getFight_infos())
/*    */     {
/* 47 */       if ((xRoundRobinFightInfo.getCorps_a_id() == corpsAid) && (xRoundRobinFightInfo.getCorps_b_id() == corpsBid))
/*    */       {
/* 49 */         return new CrossBattleRoundRobinFightInfo(xRoundRobinFightInfo);
/*    */       }
/*    */     }
/* 52 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getStage()
/*    */   {
/* 62 */     return this.xRoundRobinRoundInfo.getStage();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleRoundRobinRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */