/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PSignUpReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PSignUpReq(long roleid)
/*     */   {
/*  30 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(408)) {
/*  37 */       CrossCompeteManager.logError("PSignUpReq.processImp@cross compete not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (GameServerInfoManager.isRoamServer()) {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  50 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, false);
/*     */     
/*  52 */     if (faction == null) {
/*  53 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  58 */     if (!GangInterface.canSignUpCrossCompete(this.roleid)) {
/*  59 */       CrossCompeteManager.sendNormalResult(this.roleid, 1, new Object[0]);
/*     */       
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     Role managerRole = RoleInterface.getRole(this.roleid, false);
/*     */     
/*     */ 
/*     */ 
/*  69 */     long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*  71 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*  73 */     if (!CrossCompeteConfigManager.isSignUpStage(stage)) {
/*  74 */       CrossCompeteManager.sendNormalResult(this.roleid, 7, new Object[0]);
/*     */       
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (faction.getLevel() < SCrossCompeteConsts.getInstance().Scale) {
/*  81 */       CrossCompeteManager.sendNormalResult(this.roleid, 2, new Object[] { Integer.valueOf(SCrossCompeteConsts.getInstance().Scale) });
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  89 */     int needRoleLevel = ServerInterface.getCurrentServerLevel() - SCrossCompeteConsts.getInstance().MinusSeverLevel;
/*     */     
/*     */ 
/*  92 */     int qualifiedRoleNumber = 0;
/*  93 */     for (Iterator i$ = faction.getMemberList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/*  95 */       int level = RoleInterface.getLevel(r);
/*  96 */       if (level >= needRoleLevel) {
/*  97 */         qualifiedRoleNumber++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 102 */     if (!CrossCompeteManager.simplified)
/*     */     {
/* 104 */       if (nowMillis - faction.getCreateTime() <= SCrossCompeteConsts.getInstance().CreateDays * 86400000)
/*     */       {
/* 106 */         CrossCompeteManager.sendNormalResult(this.roleid, 2, new Object[] { Integer.valueOf(SCrossCompeteConsts.getInstance().Scale) });
/*     */         
/*     */ 
/* 109 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 113 */       if (faction.getVitality() < SCrossCompeteConsts.getInstance().Liveness) {
/* 114 */         CrossCompeteManager.sendNormalResult(this.roleid, 4, new Object[] { Integer.valueOf(SCrossCompeteConsts.getInstance().Liveness) });
/*     */         
/*     */ 
/* 117 */         return false;
/*     */       }
/*     */       
/* 120 */       if (qualifiedRoleNumber < SCrossCompeteConsts.getInstance().PlayerNumberOfQualifiedLevel)
/*     */       {
/* 122 */         CrossCompeteManager.sendNormalResult(this.roleid, 5, new Object[] { Integer.valueOf(SCrossCompeteConsts.getInstance().MinusSeverLevel), Integer.valueOf(SCrossCompeteConsts.getInstance().PlayerNumberOfQualifiedLevel) });
/*     */         
/*     */ 
/*     */ 
/* 126 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 131 */     if (GangInterface.isViceGangInCombining(faction.getGangId())) {
/* 132 */       CrossCompeteManager.sendNormalResult(this.roleid, 6, new Object[0]);
/*     */       
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     CrossCompete xCompete = CrossCompeteManager.createXCrossCompeteIfNotExist();
/*     */     
/* 140 */     boolean ret = CrossCompeteManager.addSignUpFaction(xCompete, faction.getGangId(), nowMillis, activityStartTime);
/*     */     
/*     */ 
/* 143 */     if (!ret) {
/* 144 */       CrossCompeteManager.sendNormalResult(this.roleid, 8, new Object[0]);
/* 145 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 149 */     CrossCompeteManager.broadcastSignUp(faction, this.roleid, managerRole.getName());
/*     */     
/*     */ 
/* 152 */     TLogArg tlogArg = new TLogArg(LogReason.CROSS_COMPETE_SIGNUP_MAIL);
/* 153 */     GangInterface.sendGangMail(faction.getGangId(), SCrossCompeteConsts.getInstance().SignUpMail, null, null, tlogArg);
/*     */     
/*     */ 
/*     */ 
/* 157 */     CrossCompeteManager.tlogSignUp(managerRole, faction, needRoleLevel, qualifiedRoleNumber);
/*     */     
/*     */ 
/* 160 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PSignUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */