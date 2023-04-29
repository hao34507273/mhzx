/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import hub.CrossCompeteAgainstFaction;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crossserver.event.ReportCrossCompeteSignUpDoneArg;
/*     */ import mzm.gsp.crossserver.event.ReportCrossCompeteSignUpDoneRunnable;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.FactionCrossCompete;
/*     */ import xbean.Pod;
/*     */ 
/*     */ public class ROnReportCrossCompeteSignUpDone extends ReportCrossCompeteSignUpDoneRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  24 */     long selfStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*     */ 
/*  27 */     DateFormat dateFormat = CrossCompeteManager.getLogDateFormat();
/*     */     
/*  29 */     String selfDate = dateFormat.format(Long.valueOf(selfStartTime));
/*  30 */     String matcherDate = dateFormat.format(Long.valueOf(((ReportCrossCompeteSignUpDoneArg)this.arg).startTime));
/*     */     
/*  32 */     if (((ReportCrossCompeteSignUpDoneArg)this.arg).isStartTimeErr()) {
/*  33 */       CrossCompeteManager.logError("ROnReportCrossCompeteSignUpDone.process@start time err|self_starttime=%d|matcher_starttime=%d|self_date=%s|matcher_date=%s", new Object[] { Long.valueOf(selfStartTime), Long.valueOf(((ReportCrossCompeteSignUpDoneArg)this.arg).startTime), selfDate, matcherDate });
/*     */       
/*     */ 
/*  36 */       return;
/*     */     }
/*  38 */     if (((ReportCrossCompeteSignUpDoneArg)this.arg).isMatching()) {
/*  39 */       CrossCompeteManager.logInfo("ROnReportCrossCompeteSignUpDone.process@matching|start_time=%d|start_date=%s", new Object[] { Long.valueOf(selfStartTime), selfDate });
/*     */       
/*     */ 
/*  42 */       return;
/*     */     }
/*  44 */     if (((ReportCrossCompeteSignUpDoneArg)this.arg).isSuccess()) {
/*  45 */       for (hub.CrossCompeteAgainst againstBean : ((ReportCrossCompeteSignUpDoneArg)this.arg).againsts) {
/*  46 */         PAddAgainst pAdd = new PAddAgainst(againstBean);
/*  47 */         if (!pAdd.call()) {
/*  48 */           CrossCompeteManager.logError("ROnReportCrossCompeteSignUpDone.process@add against err|start_time=%d|start_date=%s|against=%s", new Object[] { Long.valueOf(selfStartTime), selfDate, againstBean });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  56 */       for (Iterator i$ = ((ReportCrossCompeteSignUpDoneArg)this.arg).missTurnFactions.iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/*  57 */         new PAddMissTurnFaction(factionid).call();
/*     */       }
/*     */       
/*  60 */       CrossCompeteManager.logInfo("ROnReportCrossCompeteSignUpDone.process@succeed|start_time=%d|start_date=%s", new Object[] { Long.valueOf(selfStartTime), selfDate });
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  65 */       CrossCompeteManager.logError("POnReportCrossCompeteSignUpDone.processImp@unknown result|result=%d|self_starttime=%d|matcher_starttime=%d|self_date=%s|matcher_date=%s", new Object[] { Integer.valueOf(((ReportCrossCompeteSignUpDoneArg)this.arg).result), Long.valueOf(selfStartTime), Long.valueOf(((ReportCrossCompeteSignUpDoneArg)this.arg).startTime), selfDate, matcherDate });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static class PAddAgainst
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final hub.CrossCompeteAgainst againstBean;
/*     */     
/*     */     PAddAgainst(hub.CrossCompeteAgainst againstBean)
/*     */     {
/*  77 */       this.againstBean = againstBean;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  83 */       lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.againstBean.front_faction.factionid), Long.valueOf(this.againstBean.behind_faction.factionid) }));
/*     */       
/*     */ 
/*     */ 
/*  87 */       CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*  88 */       CrossCompeteMatch cMatch = new CrossCompeteMatch(this.againstBean.front_faction.factionid, this.againstBean.behind_faction.factionid);
/*     */       
/*     */ 
/*  91 */       if (xCompete.getAgainsts().containsKey(cMatch)) {
/*  92 */         CrossCompeteManager.logInfo("PAddAgainst.processImp@already has against|front_factionid=%d|behind_factionid=%d", new Object[] { Long.valueOf(this.againstBean.front_faction.factionid), Long.valueOf(this.againstBean.behind_faction.factionid) });
/*     */         
/*     */ 
/*     */ 
/*  96 */         return true;
/*     */       }
/*     */       
/*  99 */       xbean.CrossCompeteAgainst xAgainst = Pod.newCrossCompeteAgainst();
/* 100 */       CrossCompeteManager.fillXCrossCompeteMatchFaction(xAgainst.getFront_faction(), this.againstBean.front_faction);
/*     */       
/*     */ 
/* 103 */       CrossCompeteManager.fillXCrossCompeteMatchFaction(xAgainst.getBehind_faction(), this.againstBean.behind_faction);
/*     */       
/*     */ 
/* 106 */       xAgainst.setCompete_index(this.againstBean.compete_index);
/*     */       
/* 108 */       xCompete.getAgainsts().put(cMatch, xAgainst);
/*     */       
/* 110 */       mzm.gsp.gang.main.Gang frontFaction = GangInterface.getGang(this.againstBean.front_faction.factionid, true);
/* 111 */       mzm.gsp.gang.main.Gang behindFaction = GangInterface.getGang(this.againstBean.behind_faction.factionid, true);
/*     */       
/* 113 */       int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */       
/*     */ 
/* 116 */       int matchTimes = 0;
/* 117 */       if (frontFaction != null) {
/* 118 */         FactionCrossCompete xFrontCompete = CrossCompeteManager.createXFactionCrossCompeteIfNotExist(this.againstBean.front_faction.factionid);
/*     */         
/*     */ 
/* 121 */         xFrontCompete.setOpponent(this.againstBean.behind_faction.factionid);
/* 122 */         matchTimes = CrossCompeteManager.addMatchTimes(xFrontCompete, this.againstBean.behind_faction.factionid);
/*     */         
/* 124 */         if (stage > 1)
/*     */         {
/* 126 */           CrossCompeteManager.mailAndBroadcastMatch(frontFaction, this.againstBean.behind_faction.factionid, this.againstBean.behind_faction.faction_name, this.againstBean.compete_index);
/*     */         }
/*     */       }
/*     */       
/* 130 */       if (behindFaction != null) {
/* 131 */         FactionCrossCompete xBehindCompete = CrossCompeteManager.createXFactionCrossCompeteIfNotExist(this.againstBean.behind_faction.factionid);
/*     */         
/*     */ 
/* 134 */         xBehindCompete.setOpponent(this.againstBean.front_faction.factionid);
/* 135 */         matchTimes = CrossCompeteManager.addMatchTimes(xBehindCompete, this.againstBean.front_faction.factionid);
/*     */         
/* 137 */         if (stage > 1)
/*     */         {
/* 139 */           CrossCompeteManager.mailAndBroadcastMatch(behindFaction, this.againstBean.front_faction.factionid, this.againstBean.front_faction.faction_name, this.againstBean.compete_index);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 145 */       CrossCompeteManager.tlogMatch(this.againstBean.front_faction.factionid, this.againstBean.front_faction.faction_level, this.againstBean.front_faction.server_level, this.againstBean.behind_faction.factionid, this.againstBean.behind_faction.faction_level, this.againstBean.behind_faction.server_level, matchTimes);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 151 */       CrossCompeteManager.logInfo("PAddAgainst.processImp@add against|front_factionid=%d|front_name=%s|behind_factionid=%d|behind_name=%s|compete_index=%d", new Object[] { Long.valueOf(this.againstBean.front_faction.factionid), this.againstBean.front_faction.faction_name, Long.valueOf(this.againstBean.behind_faction.factionid), this.againstBean.behind_faction.faction_name, Integer.valueOf(this.againstBean.compete_index) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class PAddMissTurnFaction extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     
/*     */     PAddMissTurnFaction(long factionid)
/*     */     {
/* 169 */       this.factionid = factionid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 175 */       FactionCrossCompete xFaction = CrossCompeteManager.createXFactionCrossCompeteIfNotExist(this.factionid);
/*     */       
/*     */ 
/*     */ 
/* 179 */       CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*     */       
/* 181 */       int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */       
/*     */ 
/* 184 */       if (xCompete.getMiss_turn_factions().add(Long.valueOf(this.factionid))) {
/* 185 */         xFaction.setMiss_turn_times(xFaction.getMiss_turn_times() + 1);
/*     */         
/* 187 */         CrossCompeteManager.logInfo("PAddMissTurnFaction.processImp@add miss turn faction|factionid=%d", new Object[] { Long.valueOf(this.factionid) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 192 */         if (stage >= 1) {
/* 193 */           CrossCompeteManager.mailMissTurn(this.factionid);
/*     */         }
/*     */       }
/*     */       else {
/* 197 */         CrossCompeteManager.logInfo("PAddMissTurnFaction.processImp@already miss turn|factionid=%d", new Object[] { Long.valueOf(this.factionid) });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 202 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\ROnReportCrossCompeteSignUpDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */