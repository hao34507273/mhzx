/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.CakeData;
/*     */ import xbean.CakeInfo;
/*     */ import xbean.GlobalCakeData;
/*     */ import xtable.Role2cakeinfo;
/*     */ 
/*     */ public class CakeActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  20 */     CakeInfo xCakeInfo = Role2cakeinfo.get(Long.valueOf(roleId));
/*  21 */     if (xCakeInfo == null)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     CakeData xCakeData = (CakeData)xCakeInfo.getCakedatas().get(Integer.valueOf(activityid));
/*  26 */     if (xCakeData == null)
/*     */     {
/*  28 */       return;
/*     */     }
/*  30 */     xCakeData.setCollectnum(0);
/*  31 */     xCakeData.setCookothercount(0);
/*  32 */     xCakeData.setCookselfcount(0);
/*  33 */     xCakeData.setCurturn(0);
/*  34 */     xCakeData.setEffectfactionid(0L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  41 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*     */   {
/*  47 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  59 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityid);
/*  60 */     if (activityCfg == null)
/*     */     {
/*  62 */       CakeManager.loggerError("CakeActivityHandler.onActivityStart@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(activityid) });
/*  63 */       return;
/*     */     }
/*  65 */     if (!OpenInterface.getOpenStatus(activityCfg.switchId))
/*     */     {
/*  67 */       return;
/*     */     }
/*  69 */     triggerOvens(activityid);
/*  70 */     if ((activityStartType.isBigTurn()) || (activityStartType.isLittleTurnFirst()))
/*     */     {
/*  72 */       CakeManager.loggerInfo("--cake activity start!|activityId=%d", new Object[] { Integer.valueOf(activityid) });
/*     */       
/*  74 */       new PPrepareSession(activityCfg.prepareTime, activityid);
/*     */       
/*  76 */       POperCookState.addCookState(activityid);
/*  77 */       return;
/*     */     }
/*  79 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  80 */     long activityStartTime = ActivityInterface.getActivityStartTime(activityid);
/*  81 */     long interval = curTime - activityStartTime;
/*  82 */     if (interval < activityCfg.prepareTime * 1000L)
/*     */     {
/*     */ 
/*  85 */       new PPrepareSession(activityCfg.prepareTime, activityid);
/*  86 */       return;
/*     */     }
/*  88 */     long cookInterval = interval - activityCfg.prepareTime * 1000L;
/*  89 */     long allCookTime = CakeManager.getAllCookTime(activityCfg);
/*  90 */     if (cookInterval >= allCookTime)
/*     */     {
/*     */ 
/*  93 */       return;
/*     */     }
/*     */     
/*  96 */     long needMillsPerTurn = CakeManager.getNeedMillsPerTurn(activityCfg);
/*  97 */     int doneTurn = (int)(cookInterval / needMillsPerTurn);
/*  98 */     int nextTurn = doneTurn + 2;
/*  99 */     if (nextTurn > CakeManager.getCookMaxTurn(activityCfg))
/*     */     {
/*     */ 
/* 102 */       return;
/*     */     }
/*     */     
/* 105 */     GlobalCakeData xGlobalCakeData = CakeManager.getXGlobalCakeDataIfAbsent(activityid);
/* 106 */     xGlobalCakeData.setRecovery(true);
/* 107 */     int nextTurnInterval = (int)((needMillsPerTurn - cookInterval % needMillsPerTurn) / 1000L);
/* 108 */     new PReStartSession(nextTurnInterval, activityid, nextTurn);
/*     */   }
/*     */   
/*     */ 
/*     */   private void triggerOvens(int activityid)
/*     */   {
/* 114 */     for (Iterator i$ = CreateSceneFactionCache.getInstance().getAllJoinedFactionIds().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*     */       
/* 116 */       CakeManager.triggerFactionOvens(activityid, factionId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 131 */     CakeManager.globalOnActivityEnd(activityid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\CakeActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */