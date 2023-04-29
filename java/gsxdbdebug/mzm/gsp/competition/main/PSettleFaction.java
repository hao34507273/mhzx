/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PSettleFaction
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   private final boolean isWinner;
/*    */   
/*    */   PSettleFaction(long factionid, boolean isWinner)
/*    */   {
/* 19 */     this.factionid = factionid;
/* 20 */     this.isWinner = isWinner;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Gang faction = GangInterface.getGang(this.factionid, true);
/*    */     
/* 28 */     if (this.isWinner) {
/* 29 */       faction.addGangMoney(SCompetitionConsts.getInstance().WinnerFactionMoney);
/* 30 */       faction.addLiHe(SCompetitionConsts.getInstance().WinnerFactionGift);
/*    */     }
/*    */     else {
/* 33 */       faction.addGangMoney(SCompetitionConsts.getInstance().LoserFactionMoney);
/* 34 */       faction.addLiHe(SCompetitionConsts.getInstance().LoserFactionGift);
/*    */     }
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PSettleFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */