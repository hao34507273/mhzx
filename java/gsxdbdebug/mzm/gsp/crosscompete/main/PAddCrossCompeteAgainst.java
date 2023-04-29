/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.CrossCompeteMatchFaction;
/*    */ import xbean.FactionCrossCompete;
/*    */ import xtable.Gang;
/*    */ 
/*    */ public class PAddCrossCompeteAgainst extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long frontFactionid;
/*    */   private final String frontFactionName;
/*    */   private final long behindFactionid;
/*    */   private final String behindFactionName;
/*    */   private final int competeIndex;
/*    */   
/*    */   public PAddCrossCompeteAgainst(long frontFactionid, String frontFactionName, long behindFactionid, String behindFactionName, int competeIndex)
/*    */   {
/* 22 */     this.frontFactionid = frontFactionid;
/* 23 */     this.frontFactionName = frontFactionName;
/* 24 */     this.behindFactionid = behindFactionid;
/* 25 */     this.behindFactionName = behindFactionName;
/* 26 */     this.competeIndex = competeIndex;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.frontFactionid), Long.valueOf(this.behindFactionid) }));
/*    */     
/*    */ 
/* 35 */     CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*    */     
/* 37 */     CrossCompeteMatch cMatch = new CrossCompeteMatch(this.frontFactionid, this.behindFactionid);
/*    */     
/* 39 */     CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)xCompete.getAgainsts().get(cMatch);
/* 40 */     if (xAgainst == null) {
/* 41 */       xAgainst = xbean.Pod.newCrossCompeteAgainst();
/* 42 */       xAgainst.getFront_faction().setName(this.frontFactionName);
/* 43 */       xAgainst.getBehind_faction().setName(this.behindFactionName);
/* 44 */       xAgainst.setCompete_index(this.competeIndex);
/*    */       
/* 46 */       xCompete.getAgainsts().put(cMatch, xAgainst);
/*    */       
/* 48 */       CrossCompeteManager.logInfo("PAddCrossCompete.processImp@add new against|front_factionid=%d|front_faction_name=%s|behind_factionid=%d|behind_faction_name=%s|compete_index=%d", new Object[] { Long.valueOf(this.frontFactionid), this.frontFactionName, Long.valueOf(this.behindFactionid), this.behindFactionName, Integer.valueOf(this.competeIndex) });
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 53 */       FactionCrossCompete xFrontFactionCompete = CrossCompeteManager.createXFactionCrossCompeteIfNotExist(this.frontFactionid);
/* 54 */       xFrontFactionCompete.setOpponent(this.behindFactionid);
/*    */       
/* 56 */       FactionCrossCompete xBehindFactionCrossCompete = CrossCompeteManager.createXFactionCrossCompeteIfNotExist(this.behindFactionid);
/* 57 */       xBehindFactionCrossCompete.setOpponent(this.frontFactionid);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 63 */       CrossCompeteManager.logInfo("PAddCrossCompete.processImp@against already existed|front_factionid=%d|front_faction_name=%s|behind_factionid=%d|behind_faction_name=%s|compete_index=%d", new Object[] { Long.valueOf(this.frontFactionid), this.frontFactionName, Long.valueOf(this.behindFactionid), this.behindFactionName, Integer.valueOf(this.competeIndex) });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PAddCrossCompeteAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */