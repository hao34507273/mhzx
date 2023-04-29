/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import hub.CrossCompeteFactionDutyMembers;
/*     */ import java.text.DateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.competition.main.CompetitionInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crossserver.event.CrossCompeteRoamServersDoneArg;
/*     */ import mzm.gsp.crossserver.event.CrossCompeteRoamServersDoneRunnable;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.CrossCompeteMatchFaction;
/*     */ 
/*     */ public class ROnCrossCompeteRoamServersDone extends CrossCompeteRoamServersDoneRunnable
/*     */ {
/*     */   public void process() throws Exception
/*     */   {
/*  30 */     PSaveRoamServers pSave = new PSaveRoamServers((CrossCompeteRoamServersDoneArg)this.arg);
/*  31 */     if (!pSave.call()) {
/*  32 */       CrossCompeteManager.logError("ROnCrossCompeteRoamServersDone.process@save failed|starttime=%d|compete2roam_server=%s", new Object[] { Long.valueOf(((CrossCompeteRoamServersDoneArg)this.arg).startMillis), ((CrossCompeteRoamServersDoneArg)this.arg).compete2RoamServerid });
/*     */       
/*     */ 
/*  35 */       return;
/*     */     }
/*     */     
/*  38 */     for (Map.Entry<Long, Integer> entry : pSave.faction2RoamServer.entrySet()) {
/*  39 */       long factionid = ((Long)entry.getKey()).longValue();
/*  40 */       int roamServerid = ((Integer)entry.getValue()).intValue();
/*  41 */       boolean ret = new PReportFaction2RoamServer(factionid, roamServerid).call();
/*  42 */       if (ret) {
/*  43 */         CrossCompeteManager.logInfo("ROnCrossCompeteRoamServersDone.process@report faction to roam server succeed|factionid=%d|roamServerid=%d", new Object[] { Long.valueOf(factionid), Integer.valueOf(roamServerid) });
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  48 */         CrossCompeteManager.logError("ROnCrossCompeteRoamServersDone.process@report faction to roam server failed|factionid=%d|roamServerid=%d", new Object[] { Long.valueOf(factionid), Integer.valueOf(roamServerid) });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static class PSaveRoamServers
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final CrossCompeteRoamServersDoneArg arg;
/*     */     
/*  60 */     public Map<Long, Integer> faction2RoamServer = new HashMap();
/*     */     
/*     */     PSaveRoamServers(CrossCompeteRoamServersDoneArg arg) {
/*  63 */       this.arg = arg;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  69 */       long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*     */       
/*     */ 
/*  72 */       DateFormat dateFormat = CrossCompeteManager.getLogDateFormat();
/*     */       
/*  74 */       if (activityStartTime != this.arg.startMillis) {
/*  75 */         String selfDate = dateFormat.format(Long.valueOf(activityStartTime));
/*  76 */         String matcherDate = dateFormat.format(Long.valueOf(this.arg.startMillis));
/*  77 */         CrossCompeteManager.logError("PSaveRoamServers.processImp@activity start time err|self_starttime=%d|matcher_starttime=%d|self_date=%s|matcher_date=%s", new Object[] { Long.valueOf(activityStartTime), Long.valueOf(this.arg.startMillis), selfDate, matcherDate });
/*     */         
/*     */ 
/*  80 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  84 */       CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*  85 */       Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*     */       
/*  87 */       while (iter.hasNext()) {
/*  88 */         Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/*  89 */         CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/*  90 */         CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*  91 */         Integer roamServerid = (Integer)this.arg.compete2RoamServerid.get(Integer.valueOf(xAgainst.getCompete_index()));
/*  92 */         if (roamServerid != null) {
/*  93 */           xAgainst.setRoam_serverid(roamServerid.intValue());
/*     */           
/*  95 */           if (CrossCompeteManager.isSignedUp(xCompete, cMatch.getFront_factionid())) {
/*  96 */             this.faction2RoamServer.put(Long.valueOf(cMatch.getFront_factionid()), roamServerid);
/*     */           }
/*  98 */           if (CrossCompeteManager.isSignedUp(xCompete, cMatch.getBehind_factionid())) {
/*  99 */             this.faction2RoamServer.put(Long.valueOf(cMatch.getBehind_factionid()), roamServerid);
/*     */           }
/*     */           
/* 102 */           CrossCompeteManager.logInfo("PSaveRoamServers.processImp@set roam serverid|front_factionid=%d|front_faction_name=%s|behind_factionid=%d|behind_faction_name=%s|compete_index=%d|roam_serverid=%d", new Object[] { Long.valueOf(cMatch.getFront_factionid()), xAgainst.getFront_faction().getName(), Long.valueOf(cMatch.getBehind_factionid()), xAgainst.getBehind_faction().getName(), Integer.valueOf(xAgainst.getCompete_index()), Integer.valueOf(roamServerid.intValue()) });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 113 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class PReportFaction2RoamServer
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long factionid;
/*     */     private final int roamServerid;
/*     */     
/*     */     PReportFaction2RoamServer(long factionid, int roamServerid)
/*     */     {
/* 125 */       this.factionid = factionid;
/* 126 */       this.roamServerid = roamServerid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 132 */       Gang faction = GangInterface.getGang(this.factionid, true);
/*     */       
/* 134 */       if (faction == null) {
/* 135 */         return false;
/*     */       }
/*     */       
/* 138 */       List<CrossCompeteFactionDutyMembers> dutyMembersList = new ArrayList();
/*     */       
/*     */ 
/* 141 */       faction.fillCrossCompeteFactionDutyMembersList(dutyMembersList);
/*     */       
/*     */ 
/* 144 */       int activeCount = CompetitionInterface.getFactionActiveNumber(this.factionid);
/* 145 */       int participateCount = CompetitionInterface.getMaxFactionParticipateCount(this.factionid);
/*     */       
/* 147 */       int estimateParticipateCount = CrossCompeteManager.getEstimateParticipateCount(participateCount, activeCount);
/*     */       
/*     */ 
/* 150 */       boolean ret = CrossServerInterface.reportCrossCompeteFactionInfo(this.factionid, faction.getName(), dutyMembersList, faction.getGangTitleid(), estimateParticipateCount, this.roamServerid);
/*     */       
/*     */ 
/*     */ 
/* 154 */       if (ret) {
/* 155 */         CrossCompeteManager.logInfo("PReportFaction2RoamServer.processImp@succeed|factionid=%d|roam_serverid=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(this.roamServerid) });
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 160 */         CrossCompeteManager.logError("PReportFaction2RoamServer.processImp@failed|factionid=%d|roam_serverid=%d", new Object[] { Long.valueOf(this.factionid), Integer.valueOf(this.roamServerid) });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 165 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\ROnCrossCompeteRoamServersDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */