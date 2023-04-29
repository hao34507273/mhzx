/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import xbean.BigBoss;
/*     */ import xtable.Role2bigboss;
/*     */ 
/*     */ public class BigbossActivityInit implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  22 */     long starttime = BigbossManager.getActivityStarttime();
/*  23 */     BigBoss bigBoss = Role2bigboss.get(Long.valueOf(roleId));
/*  24 */     if (bigBoss == null)
/*     */     {
/*  26 */       bigBoss = xbean.Pod.newBigBoss();
/*  27 */       Role2bigboss.insert(Long.valueOf(roleId), bigBoss);
/*     */     }
/*  29 */     bigBoss.setBuycount(0);
/*  30 */     bigBoss.setRestbuycount(0);
/*  31 */     bigBoss.setChallengecount(SBigbossCfgConsts.getInstance().DAY_OFFER_CHALLENGE_COUNT);
/*  32 */     bigBoss.setFightcount(0);
/*  33 */     bigBoss.setDamagepoint(0);
/*  34 */     bigBoss.setRank(0);
/*  35 */     bigBoss.setStarttime(starttime);
/*  36 */     bigBoss.setIsawarded(false);
/*  37 */     bigBoss.getOcp2damagepoint().clear();
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  43 */     AwardReason a = new AwardReason(mzm.gsp.tlog.LogReason.BIGBOSS_ACTIVITY_RECOMMEND_REWARD_ADD, 0);
/*  44 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*     */   {
/*  50 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  56 */     boolean s = false;
/*  57 */     if (activityStartType.startAgain())
/*     */     {
/*  59 */       s = true;
/*     */     }
/*  61 */     BigbossManager.onActivityStart(s);
/*  62 */     new BulletinObserver(BigbossManager.getBulletinInterval());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/*  74 */     new BrodcastProcedure(null).execute();
/*     */     
/*  76 */     BigbossManager.onActivityEnd();
/*  77 */     BigBossFightManager.getInstance().onActivityEnd();
/*  78 */     long startTimestamp = BigbossManager.getActivityStarttime();
/*  79 */     Iterator i$; if (startTimestamp > 0L)
/*     */     {
/*  81 */       for (i$ = SBigbossRemoteChartTypeCfg.getAll().keySet().iterator(); i$.hasNext();) { int ocp = ((Integer)i$.next()).intValue();
/*     */         
/*  83 */         new GetBigBossRemoteRankRangeSession(BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + xdb.Xdb.random().nextInt(BigbossManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), CommonUtils.getLong(ocp, (int)(startTimestamp / 1000L)));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class BrodcastProcedure
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  97 */       int monstersortid = BigbossManager.getBigbossActivityMonsterSordId();
/*     */       
/*  99 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 100 */       bulletinInfo.bulletintype = 24;
/*     */       
/* 102 */       bulletinInfo.params.put(Integer.valueOf(7), String.valueOf(BigbossManager.getMonsterId(monstersortid)));
/*     */       
/* 104 */       BulletinInterface.sendBulletin(bulletinInfo);
/* 105 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BigbossActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */