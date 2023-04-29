/*     */ package mzm.gsp.feisheng.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FeiShengActivityHandler
/*     */   implements ActivityHandler
/*     */ {
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  25 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  31 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/*  43 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  45 */       return;
/*     */     }
/*  47 */     if (!FeiShengManager.isFeiShengActivitySwitchOpen(activityid))
/*     */     {
/*  49 */       return;
/*     */     }
/*  51 */     SFeiShengCfg cfg = SFeiShengCfg.get(activityid);
/*  52 */     if (cfg == null)
/*     */     {
/*     */ 
/*  55 */       return;
/*     */     }
/*  57 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  60 */       return;
/*     */     }
/*  62 */     ControllerInterface.collectController(cfg.npc_controller_id);
/*  63 */     for (Iterator i$ = OnlineManager.getInstance().getOnlineRoleidList(cfg.level, cfg.level).iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  65 */       FeiShengOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityid), new PCloseTaskGraph(roleid, activityid));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  78 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  80 */       return;
/*     */     }
/*  82 */     if (!FeiShengManager.isFeiShengActivitySwitchOpen(activityid))
/*     */     {
/*  84 */       return;
/*     */     }
/*  86 */     SFeiShengCfg cfg = SFeiShengCfg.get(activityid);
/*  87 */     if (cfg == null)
/*     */     {
/*     */ 
/*  90 */       return;
/*     */     }
/*  92 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  95 */       return;
/*     */     }
/*  97 */     ControllerInterface.triggerOrReSpawn(MapInterface.getBigWorldid(), cfg.npc_controller_id);
/*  98 */     for (Iterator i$ = OnlineManager.getInstance().getOnlineRoleidList(cfg.level, cfg.level).iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 100 */       FeiShengOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityid), new PActiveTaskGraph(roleid, activityid));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\FeiShengActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */