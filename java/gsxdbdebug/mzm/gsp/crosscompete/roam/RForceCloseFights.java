/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteConfigManager;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteAgainstTmp;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteTmp;
/*    */ 
/*    */ public class RForceCloseFights extends LogicRunnable
/*    */ {
/*    */   private final boolean bFirstTime;
/*    */   
/*    */   public RForceCloseFights(boolean bFirstTime)
/*    */   {
/* 26 */     this.bFirstTime = bFirstTime;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 32 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 33 */     if (xCompete == null) {
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     CrossCompeteTmp xCompeteTmp = CrossCompeteRoamManager.getXCrossCompeteTmp(false);
/*    */     
/* 39 */     Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*    */     
/* 41 */     while (iter.hasNext()) {
/* 42 */       Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/* 43 */       CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/* 44 */       CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*    */       
/* 46 */       if ((CrossCompeteConfigManager.isInFirstCompeteTime(xAgainst.getCompete_index()) == this.bFirstTime) && 
/*    */       
/*    */ 
/*    */ 
/* 50 */         (xAgainst.getWinner() <= 0L))
/*    */       {
/*    */ 
/*    */ 
/* 54 */         CrossCompeteAgainstTmp xAgainstTmp = CrossCompeteRoamManager.getXAgainstTmp(xCompeteTmp, cMatch);
/*    */         Iterator i$;
/* 56 */         if (xAgainstTmp != null) {
/* 57 */           for (i$ = xAgainstTmp.getPvp_fights().iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*    */             
/* 59 */             FightInterface.syncEndFight(fightid);
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 64 */         PResultByScore pResult = new PResultByScore(cMatch.getFront_factionid(), cMatch.getBehind_factionid());
/*    */         
/* 66 */         if (!pResult.call()) {
/* 67 */           CrossCompeteManager.logError("RForceCloseFights.process@result by score failed|factionid1=%d|factionid2=%d", new Object[] { Long.valueOf(cMatch.getFront_factionid()), Long.valueOf(cMatch.getBehind_factionid()) });
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/*    */ 
/* 73 */           long winFactionid = pResult.getWinFactionid();
/* 74 */           long loseFactionid = pResult.getLoseFactionid();
/* 75 */           List<Long> winnerRoles = pResult.getWinnerRoles();
/* 76 */           List<Long> loserRoles = pResult.getLoserRoles();
/* 77 */           long world = pResult.getWorld();
/*    */           
/*    */ 
/* 80 */           for (Iterator i$ = loserRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */             
/* 82 */             TeamInterface.leaveTeam(roleid);
/*    */             
/* 84 */             new PLeave(roleid, 3).call();
/*    */           }
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 91 */           int treasureSeconds = SCrossCompeteConsts.getInstance().TriggerMapItemSeconds;
/* 92 */           new TriggerMapItemSession(treasureSeconds, winFactionid, world, winnerRoles.size());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RForceCloseFights.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */