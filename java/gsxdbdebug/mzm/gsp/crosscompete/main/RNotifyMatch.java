/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteMatchFaction;
/*    */ import xbean.FactionCrossCompete;
/*    */ 
/*    */ class RNotifyMatch extends LogicRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 20 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 21 */     if (xCompete == null) {
/* 22 */       return;
/*    */     }
/*    */     
/* 25 */     for (Iterator i$ = xCompete.getSignup_factions().keySet().iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/* 26 */       FactionCrossCompete xFaction = CrossCompeteManager.getXFactionCrossCompete(factionid, false);
/*    */       
/* 28 */       if (xFaction != null) {
/* 29 */         long opponent = xFaction.getOpponent();
/* 30 */         if (opponent > 0L) {
/* 31 */           CrossCompeteMatch cMatch = CrossCompeteManager.getCMatch(factionid, opponent);
/* 32 */           CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)xCompete.getAgainsts().get(cMatch);
/* 33 */           if (xAgainst != null)
/*    */           {
/*    */ 
/*    */ 
/* 37 */             String opponentName = null;
/* 38 */             if (cMatch.getFront_factionid() == factionid) {
/* 39 */               opponentName = xAgainst.getBehind_faction().getName();
/*    */             }
/*    */             else {
/* 42 */               opponentName = xAgainst.getFront_faction().getName();
/*    */             }
/*    */             
/* 45 */             new PNotifyMatch(factionid, opponent, opponentName, xAgainst.getCompete_index()).call();
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 51 */     for (Iterator i$ = xCompete.getMiss_turn_factions().iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/* 52 */       CrossCompeteManager.mailMissTurn(factionid);
/*    */     }
/*    */   }
/*    */   
/*    */   static class PNotifyMatch extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     private final long opponentid;
/*    */     private final String opponentName;
/*    */     private final int competeIndex;
/*    */     
/*    */     PNotifyMatch(long factionid, long opponentid, String opponentName, int competeIndex)
/*    */     {
/* 65 */       this.factionid = factionid;
/* 66 */       this.opponentid = opponentid;
/* 67 */       this.opponentName = opponentName;
/* 68 */       this.competeIndex = competeIndex;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 73 */       Gang faction = GangInterface.getGang(this.factionid, true);
/* 74 */       if (faction == null) {
/* 75 */         return false;
/*    */       }
/*    */       
/* 78 */       CrossCompeteManager.mailAndBroadcastMatch(faction, this.opponentid, this.opponentName, this.competeIndex);
/*    */       
/* 80 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\RNotifyMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */