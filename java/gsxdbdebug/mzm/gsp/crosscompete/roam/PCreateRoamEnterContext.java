/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import hub.CrossCompeteEnterRole;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteConfigManager;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PCreateRoamEnterContext
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long factionid;
/*     */   private final List<CrossCompeteEnterRole> roles;
/*     */   private final boolean isTeam;
/*  24 */   public int result = 6;
/*  25 */   public final List<Long> invalidRoles = new ArrayList();
/*  26 */   public long contextid = -1L;
/*     */   
/*     */   public PCreateRoamEnterContext(long factionid, List<CrossCompeteEnterRole> roles, boolean isTeam)
/*     */   {
/*  30 */     this.factionid = factionid;
/*  31 */     this.roles = roles;
/*  32 */     this.isTeam = isTeam;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     List<Long> roleList = new ArrayList();
/*  38 */     for (CrossCompeteEnterRole enterRole : this.roles) {
/*  39 */       roleList.add(Long.valueOf(enterRole.roleid));
/*     */     }
/*     */     
/*     */ 
/*  43 */     RoamCrossCompeteFaction xRoamFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid, false);
/*     */     
/*     */ 
/*  46 */     if (xRoamFaction == null) {
/*  47 */       CrossCompeteManager.logError("PCreateRoamEnterContext.processImp@no roam faction|factionid=%d|roles=%s", new Object[] { Long.valueOf(this.factionid), roleList });
/*     */       
/*     */ 
/*  50 */       this.result = 1;
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     boolean ret = true;
/*  56 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  57 */       if (!CrossCompeteRoamManager.isInRoamFaction(xRoamFaction, roleid)) {
/*  58 */         this.invalidRoles.add(Long.valueOf(roleid));
/*  59 */         ret = false;
/*     */       }
/*     */     }
/*     */     
/*  63 */     if (!ret) {
/*  64 */       CrossCompeteManager.logError("PCreateRoamEnterContext.processImp@member invalid|factionid=%d|roles=%s|invalid_roles=%s", new Object[] { Long.valueOf(this.factionid), this.roles, this.invalidRoles });
/*     */       
/*     */ 
/*  67 */       this.result = 2;
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  73 */     if (xRoamFaction.getOpponent() <= 0L) {
/*  74 */       CrossCompeteManager.logError("PCreateRoamEnterContext.processImp@no xfaction_compete|factionid=%d|roles=%s", new Object[] { Long.valueOf(this.factionid), this.roles });
/*     */       
/*     */ 
/*  77 */       this.result = 3;
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/*  83 */     if (xCompete == null) {
/*  84 */       CrossCompeteManager.logError("PCreateRoamEnterContext.processImp@no xcompete|factionid=%d|roles=%s", new Object[] { Long.valueOf(this.factionid), this.roles });
/*     */       
/*     */ 
/*  87 */       this.result = 3;
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, this.factionid, xRoamFaction.getOpponent());
/*     */     
/*     */ 
/*  94 */     if (xAgainst == null) {
/*  95 */       CrossCompeteManager.logError("PCreateRoamEnterContext.processImp@no xagainst|factionid=%d|roles=%s|opponentid=%d", new Object[] { Long.valueOf(this.factionid), this.roles, Long.valueOf(xRoamFaction.getOpponent()) });
/*     */       
/*     */ 
/*  98 */       this.result = 3;
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*     */ 
/* 106 */     if (CrossCompeteConfigManager.isInFirstCompeteTime(xAgainst.getCompete_index())) {
/* 107 */       if (stage != 5) {
/* 108 */         CrossCompeteManager.logError("PCreateEnterContext.processImp@stage err, not first prepare|factionid=%d|roles=%s|compete_index=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), this.roles, Integer.valueOf(xAgainst.getCompete_index()), Integer.valueOf(stage) });
/*     */         
/*     */ 
/* 111 */         this.result = 4;
/* 112 */         return false;
/*     */       }
/*     */       
/*     */     }
/* 116 */     else if (stage != 10) {
/* 117 */       CrossCompeteManager.logError("PCreateEnterContext.processImp@stage err, not second prepare|factionid=%d|roles=%s|compete_index=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), this.roles, Integer.valueOf(xAgainst.getCompete_index()), Integer.valueOf(stage) });
/*     */       
/*     */ 
/* 120 */       this.result = 4;
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 126 */     RoamCrossCompeteFactionTmp xRoamFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid, false);
/*     */     
/* 128 */     if ((xRoamFactionTmp == null) || (xRoamFactionTmp.getWorld() < 0L) || (xRoamFactionTmp.getMapid() <= 0)) {
/* 129 */       CrossCompeteManager.logError("PCreateEnterContext.processImp@no roam faction tmp|factionid=%d|roles=%s|compete_index=%d|stage=%d", new Object[] { Long.valueOf(this.factionid), this.roles, Integer.valueOf(xAgainst.getCompete_index()), Integer.valueOf(stage) });
/*     */       
/*     */ 
/* 132 */       this.result = 4;
/* 133 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 137 */     lock(Basic.getTable(), roleList);
/*     */     
/* 139 */     RoamEnterContext context = new RoamEnterContext(this.factionid, this.roles, this.isTeam);
/* 140 */     this.contextid = RoamEnterContextManager.getInstance().addContext(context);
/* 141 */     context.setContextid(this.contextid);
/*     */     
/*     */ 
/* 144 */     RoamEnterSession session = new RoamEnterSession(this.contextid);
/* 145 */     context.setSessionid(session.getSessionId());
/*     */     
/* 147 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PCreateRoamEnterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */