/*     */ package mzm.gsp.paraselene.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import xbean.Paraselene;
/*     */ import xtable.Role2paraselene;
/*     */ 
/*     */ public class ParaseleneActivityInit implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  21 */     Paraselene paraselene = Role2paraselene.get(Long.valueOf(roleId));
/*     */     
/*  23 */     if (paraselene == null)
/*     */     {
/*  25 */       paraselene = xbean.Pod.newParaselene();
/*  26 */       Role2paraselene.insert(Long.valueOf(roleId), paraselene);
/*     */     }
/*  28 */     paraselene.setIsinfuben(false);
/*  29 */     paraselene.getLayers().clear();
/*  30 */     paraselene.setFinishtime(0L);
/*  31 */     paraselene.setStarttime(0L);
/*  32 */     paraselene.setRecentlayer(0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  39 */     AwardReason a = new AwardReason(LogReason.PARASELENE_ACTIVITY_RECOMMEND_REWARD_ADD);
/*  40 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  47 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  54 */     ControllerInterface.triggerController(SParaseleneCfgConsts.getInstance().NPC_CONTROLLERID);
/*     */     
/*  56 */     if (activityStartType.startAgain())
/*     */     {
/*  58 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  59 */       long endtime = ActivityInterface.getActivityEndTime(SParaseleneCfgConsts.getInstance().ActivityId);
/*  60 */       long t = TimeUnit.MINUTES.toSeconds(SParaseleneCfgConsts.getInstance().Minute_To_End);
/*     */       
/*  62 */       long resttime = TimeUnit.MILLISECONDS.toSeconds(endtime - now);
/*  63 */       if (resttime > t)
/*     */       {
/*  65 */         new BulletinObserver(resttime - t, 0);
/*     */       }
/*     */       else
/*     */       {
/*  69 */         int toltalcount = SParaseleneCfgConsts.getInstance().Minute_To_End / SParaseleneCfgConsts.getInstance().Bulletin_Inteval;
/*     */         
/*  71 */         long inter = TimeUnit.MINUTES.toSeconds(SParaseleneCfgConsts.getInstance().Bulletin_Inteval);
/*  72 */         int c = (int)(resttime / inter);
/*     */         
/*  74 */         new BulletinObserver(resttime - c * inter, toltalcount - c);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  80 */       long dminutes = ActivityInterface.getActivityDurationMinute(SParaseleneCfgConsts.getInstance().ActivityId);
/*  81 */       long ds = TimeUnit.MINUTES.toSeconds(dminutes);
/*  82 */       long t = TimeUnit.MINUTES.toSeconds(SParaseleneCfgConsts.getInstance().Minute_To_End);
/*     */       
/*  84 */       new BulletinObserver(ds - t, 0);
/*  85 */       ParaseleneManager.clearRankData();
/*     */     }
/*  87 */     if (OpenInterface.getOpenStatus(12))
/*     */     {
/*  89 */       ParaseleneManager.broadcastActivityOpen();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 103 */     ParaseleneManager.onActivityEnd();
/* 104 */     ControllerInterface.collectController(SParaseleneCfgConsts.getInstance().NPC_CONTROLLERID);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */