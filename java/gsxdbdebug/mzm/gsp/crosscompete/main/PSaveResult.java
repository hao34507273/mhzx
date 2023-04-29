/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteMatchFaction;
/*    */ import xbean.FactionCrossCompete;
/*    */ 
/*    */ public class PSaveResult extends LogicProcedure
/*    */ {
/*    */   private final long winFactionid;
/*    */   private final long loseFactionid;
/*    */   
/*    */   public PSaveResult(long winFactionid, long loseFactionid)
/*    */   {
/* 21 */     this.winFactionid = winFactionid;
/* 22 */     this.loseFactionid = loseFactionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.winFactionid), Long.valueOf(this.loseFactionid) }));
/*    */     
/*    */ 
/* 31 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/* 32 */     if (xCompete == null) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     CrossCompeteMatch cMatch = CrossCompeteManager.getCMatch(this.winFactionid, this.loseFactionid);
/* 37 */     CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)xCompete.getAgainsts().get(cMatch);
/*    */     
/* 39 */     if (xAgainst.getWinner() > 0L) {
/* 40 */       CrossCompeteManager.logInfo("PSaveResult.processImp@already save result|win_factionid=%d|lose_factionid=%d", new Object[] { Long.valueOf(this.winFactionid), Long.valueOf(this.loseFactionid) });
/*    */       
/*    */ 
/* 43 */       return true;
/*    */     }
/*    */     
/* 46 */     xAgainst.setWinner(this.winFactionid);
/*    */     
/* 48 */     FactionCrossCompete xWinFactionCompete = CrossCompeteManager.getXFactionCrossCompete(this.winFactionid, true);
/*    */     
/* 50 */     FactionCrossCompete xLoseFactionCompete = CrossCompeteManager.getXFactionCrossCompete(this.loseFactionid, true);
/*    */     
/*    */ 
/* 53 */     String winName = null;
/* 54 */     boolean bWinSelf = false;
/* 55 */     String loseName = null;
/* 56 */     boolean bLoseSelf = false;
/*    */     
/*    */ 
/* 59 */     if (xWinFactionCompete != null) {
/* 60 */       xWinFactionCompete.setWin_times(xWinFactionCompete.getWin_times() + 1);
/* 61 */       bWinSelf = true;
/*    */     }
/* 63 */     if (xLoseFactionCompete != null) {
/* 64 */       xLoseFactionCompete.setLose_times(xLoseFactionCompete.getLose_times() + 1);
/* 65 */       bLoseSelf = true;
/*    */     }
/*    */     
/* 68 */     if (cMatch.getFront_factionid() == this.winFactionid) {
/* 69 */       winName = xAgainst.getFront_faction().getName();
/* 70 */       loseName = xAgainst.getBehind_faction().getName();
/*    */     }
/*    */     else {
/* 73 */       winName = xAgainst.getBehind_faction().getName();
/* 74 */       loseName = xAgainst.getFront_faction().getName();
/*    */     }
/*    */     
/*    */ 
/* 78 */     CrossCompeteManager.broadcastCompeteResult(this.winFactionid, winName, bWinSelf, this.loseFactionid, loseName, bLoseSelf);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 83 */     mzm.gsp.gang.main.Gang winFaction = GangInterface.getGang(this.winFactionid, true);
/* 84 */     if (winFaction != null) {
/* 85 */       winFaction.addGangMoney(SCrossCompeteConsts.getInstance().WinnerFactionMoney);
/* 86 */       winFaction.addLiHe(SCrossCompeteConsts.getInstance().WinnerFactionGift);
/*    */     }
/* 88 */     mzm.gsp.gang.main.Gang loseFaction = GangInterface.getGang(this.loseFactionid, true);
/* 89 */     if (loseFaction != null) {
/* 90 */       loseFaction.addGangMoney(SCrossCompeteConsts.getInstance().LoserFactionMoney);
/* 91 */       loseFaction.addLiHe(SCrossCompeteConsts.getInstance().LoserFactionGift);
/*    */     }
/*    */     
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PSaveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */