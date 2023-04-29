/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xtable.Roam_crosscompete_factiontmp;
/*    */ 
/*    */ public class RRoamInit extends LogicRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 21 */     PInitGlobal pGlobal = new PInitGlobal();
/* 22 */     if (!pGlobal.call()) {
/* 23 */       CrossCompeteManager.logError("RRoamInit.processImp@init roam global failed", new Object[0]);
/*    */     }
/*    */     
/* 26 */     for (Iterator i$ = pGlobal.factions.iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/* 27 */       new PInitFaction(factionid).call();
/*    */     }
/*    */   }
/*    */   
/*    */   static class PInitGlobal
/*    */     extends LogicProcedure
/*    */   {
/* 34 */     public List<Long> factions = new ArrayList();
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 39 */       CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/* 40 */       if (xCompete == null) {
/* 41 */         return true;
/*    */       }
/*    */       
/* 44 */       Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*    */       
/*    */ 
/* 47 */       while (iter.hasNext()) {
/* 48 */         Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/*    */         
/*    */ 
/* 51 */         CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/* 52 */         this.factions.add(Long.valueOf(cMatch.getFront_factionid()));
/* 53 */         this.factions.add(Long.valueOf(cMatch.getBehind_factionid()));
/* 54 */         iter.remove();
/*    */       }
/*    */       
/*    */ 
/* 58 */       CrossCompeteRoamManager.removeXCrossCompeteTmp();
/*    */       
/* 60 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */   static class PInitFaction extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     
/*    */     PInitFaction(long factionid)
/*    */     {
/* 70 */       this.factionid = factionid;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 75 */       xtable.Roam_crosscompete_faction.remove(Long.valueOf(this.factionid));
/* 76 */       Roam_crosscompete_factiontmp.remove(Long.valueOf(this.factionid));
/*    */       
/* 78 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RRoamInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */