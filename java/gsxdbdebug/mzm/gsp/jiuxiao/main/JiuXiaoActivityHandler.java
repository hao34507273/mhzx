/*     */ package mzm.gsp.jiuxiao.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*     */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoConsts;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JiuXiaoActivityBean;
/*     */ import xbean.JiuXiaoActivityInfo;
/*     */ import xbean.JiuXiaoBean;
/*     */ import xbean.JiuXiaoRank;
/*     */ import xbean.Pod;
/*     */ import xtable.Jiuxiaotable;
/*     */ 
/*     */ public class JiuXiaoActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public java.util.List<ActivityStage> getActivityStages()
/*     */   {
/*  22 */     ActivityStage activityStage = new ActivityStage(SJueZhanJiuXiaoConsts.getInstance().waitTime, mzm.gsp.activity.main.ActivityStage.TimeBaseLine.BEGIN, mzm.gsp.activity.main.ActivityStage.TimeLogic.FIX);
/*     */     
/*  24 */     ActivityStage activityStage1 = new ActivityStage(SJueZhanJiuXiaoConsts.getInstance().tipMinuteBeforeEnd, mzm.gsp.activity.main.ActivityStage.TimeBaseLine.END, mzm.gsp.activity.main.ActivityStage.TimeLogic.FIX);
/*     */     
/*  26 */     return java.util.Arrays.asList(new ActivityStage[] { activityStage, activityStage1 });
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  31 */     if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(13)) {
/*  32 */       return;
/*     */     }
/*  34 */     JiuXiaoActivityBean xJiuXiaoActivityBean = Jiuxiaotable.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  35 */     if (xJiuXiaoActivityBean == null) {
/*  36 */       xJiuXiaoActivityBean = Pod.newJiuXiaoActivityBean();
/*  37 */       Jiuxiaotable.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xJiuXiaoActivityBean);
/*     */     }
/*     */     
/*  40 */     if ((activityStartType.isBigTurn()) || (activityStartType.isLittleTurnFirst()))
/*     */     {
/*  42 */       JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(activityid));
/*  43 */       if (xJiuXiaoActivityInfo != null) {
/*  44 */         xJiuXiaoActivityInfo.getWinlayers().clear();
/*     */       }
/*  46 */       SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(activityid);
/*  47 */       long uniqKey = JiuXiaoRankManager.getInstance().getRankUniqKey(jiuXiaoActivityInfoCfg.rankType);
/*  48 */       JiuXiaoRank xJiuXiaoRank = xtable.Jiuxiaorank.get(Long.valueOf(uniqKey));
/*  49 */       if (xJiuXiaoRank != null) {
/*  50 */         xJiuXiaoRank.getRanklist().clear();
/*     */       } else {
/*  52 */         xJiuXiaoRank = Pod.newJiuXiaoRank();
/*  53 */         xtable.Jiuxiaorank.insert(Long.valueOf(uniqKey), xJiuXiaoRank);
/*     */       }
/*     */       
/*  56 */       JiuXiaoRankManager.getInstance().clear(jiuXiaoActivityInfoCfg.rankType);
/*     */     }
/*     */     
/*  59 */     JiuXiaoManager.activityStart(activityid, xJiuXiaoActivityBean);
/*     */     
/*  61 */     if (GameServer.logger().isDebugEnabled()) {
/*  62 */       GameServer.logger().debug("九霄活动开启--------");
/*     */     }
/*     */   }
/*     */   
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid)
/*     */   {
/*  68 */     switch (stageIndex) {
/*     */     case 1: 
/*     */       break;
/*     */     case 2: 
/*  72 */       new JiuXiaoTipSession(0L, activityid);
/*  73 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/*  82 */     JiuXiaoActivityBean xjiuXiaoActivityBean = Jiuxiaotable.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  83 */     JiuXiaoManager.activityEnd(activityid, xjiuXiaoActivityBean);
/*  84 */     if (GameServer.logger().isDebugEnabled()) {
/*  85 */       GameServer.logger().debug("九霄活动结束---------");
/*     */     }
/*     */   }
/*     */   
/*     */   public void initData(String userid, long roleid, int turn, int activityid)
/*     */   {
/*  91 */     xbean.JiuXiaoCacheBean xJiuXiaoCacheBean = xtable.Role2jiuxiaocache.get(Long.valueOf(roleid));
/*  92 */     if (xJiuXiaoCacheBean == null) {
/*  93 */       xJiuXiaoCacheBean = Pod.newJiuXiaoCacheBean();
/*  94 */       xtable.Role2jiuxiaocache.insert(Long.valueOf(roleid), xJiuXiaoCacheBean);
/*     */     }
/*  96 */     xJiuXiaoCacheBean.getFloorcachemap().clear();
/*     */     
/*  98 */     JiuXiaoBean xJiuXiaoBean = xtable.Role2jiuxiao.get(Long.valueOf(roleid));
/*  99 */     if (xJiuXiaoBean == null) {
/* 100 */       xJiuXiaoBean = Pod.newJiuXiaoBean();
/* 101 */       xtable.Role2jiuxiao.insert(Long.valueOf(roleid), xJiuXiaoBean);
/*     */     }
/* 103 */     xJiuXiaoBean.getFloormap().clear();
/*     */   }
/*     */   
/*     */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*     */   {
/* 108 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */