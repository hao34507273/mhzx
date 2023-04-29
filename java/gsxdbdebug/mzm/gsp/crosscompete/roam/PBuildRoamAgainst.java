/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import hub.CrossCompeteAgainstFaction;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.Pod;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xtable.Gang;
/*    */ 
/*    */ public class PBuildRoamAgainst extends LogicProcedure
/*    */ {
/*    */   private final CrossCompeteAgainstFaction frontFaction;
/*    */   private final CrossCompeteAgainstFaction behindFaction;
/*    */   private final int competeIndex;
/*    */   
/*    */   public PBuildRoamAgainst(CrossCompeteAgainstFaction frontFaction, CrossCompeteAgainstFaction behindFaction, int competeIndex)
/*    */   {
/* 24 */     this.frontFaction = frontFaction;
/* 25 */     this.behindFaction = behindFaction;
/* 26 */     this.competeIndex = competeIndex;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.frontFaction.factionid), Long.valueOf(this.behindFaction.factionid) }));
/*    */     
/*    */ 
/* 35 */     RoamCrossCompeteFaction xFrontFaction = CrossCompeteRoamManager.createRoamCrossCompeteFactionIfNotExist(this.frontFaction.factionid);
/*    */     
/* 37 */     RoamCrossCompeteFaction xBehindFaction = CrossCompeteRoamManager.createRoamCrossCompeteFactionIfNotExist(this.behindFaction.factionid);
/*    */     
/*    */ 
/* 40 */     xFrontFaction.setName(this.frontFaction.faction_name);
/* 41 */     xFrontFaction.setOpponent(this.behindFaction.factionid);
/*    */     
/* 43 */     xBehindFaction.setName(this.behindFaction.faction_name);
/* 44 */     xBehindFaction.setOpponent(this.frontFaction.factionid);
/*    */     
/*    */ 
/* 47 */     CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*    */     
/* 49 */     CrossCompeteMatch cMatch = new CrossCompeteMatch(this.frontFaction.factionid, this.behindFaction.factionid);
/*    */     
/* 51 */     CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)xCompete.getAgainsts().get(cMatch);
/* 52 */     if (xAgainst == null) {
/* 53 */       xAgainst = Pod.newCrossCompeteAgainst();
/*    */       
/* 55 */       CrossCompeteManager.fillXCrossCompeteMatchFaction(xAgainst.getFront_faction(), this.frontFaction);
/* 56 */       CrossCompeteManager.fillXCrossCompeteMatchFaction(xAgainst.getBehind_faction(), this.behindFaction);
/* 57 */       xAgainst.setCompete_index(this.competeIndex);
/*    */       
/* 59 */       xCompete.getAgainsts().put(cMatch, xAgainst);
/*    */       
/* 61 */       CrossCompeteManager.logInfo("PBuildRoamAgainst.processImp@add new against|front_factionid=%d|front_faction_name=%s|behind_factionid=%d|behind_faction_name=%s|compete_index=%d", new Object[] { Long.valueOf(this.frontFaction.factionid), this.frontFaction.faction_name, Long.valueOf(this.behindFaction.factionid), this.behindFaction.faction_name, Integer.valueOf(this.competeIndex) });
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */       if (CrossCompeteManager.isPrepareStage()) {
/* 68 */         RoamCrossCompeteFactionTmp xFrontFactionTmp = CrossCompeteRoamManager.createXRoamCrossCompeteFactionTmpIfNotExist(this.frontFaction.factionid);
/*    */         
/*    */ 
/* 71 */         if (xFrontFactionTmp.getWorld() <= 0L) {
/* 72 */           long frontWorld = CrossCompeteRoamManager.createPrepareWorld(xFrontFactionTmp);
/*    */           
/* 74 */           CrossCompeteManager.logInfo("PBuildRoamAgainst.processImp@create prepare world|factionid=%d|world=%d", new Object[] { Long.valueOf(this.frontFaction.factionid), Long.valueOf(frontWorld) });
/*    */         }
/*    */         
/*    */ 
/*    */ 
/* 79 */         RoamCrossCompeteFactionTmp xBehindFactionTmp = CrossCompeteRoamManager.createXRoamCrossCompeteFactionTmpIfNotExist(this.behindFaction.factionid);
/*    */         
/*    */ 
/* 82 */         if (xBehindFactionTmp.getWorld() <= 0L) {
/* 83 */           long behindWorld = CrossCompeteRoamManager.createPrepareWorld(xBehindFactionTmp);
/*    */           
/* 85 */           CrossCompeteManager.logInfo("PBuildRoamAgainst.processImp@create prepare world|factionid=%d|world=%d", new Object[] { Long.valueOf(this.behindFaction.factionid), Long.valueOf(behindWorld) });
/*    */         }
/*    */         
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 92 */       CrossCompeteManager.logInfo("PBuildRoamAgainst.processImp@against already existed|front_factionid=%d|front_faction_name=%s|behind_factionid=%d|behind_faction_name=%s|compete_index=%d", new Object[] { Long.valueOf(this.frontFaction.factionid), this.frontFaction.faction_name, Long.valueOf(this.behindFaction.factionid), this.behindFaction.faction_name, Integer.valueOf(this.competeIndex) });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PBuildRoamAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */