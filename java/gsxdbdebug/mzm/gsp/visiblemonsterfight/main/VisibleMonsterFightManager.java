/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.LinkedBlockingDeque;
/*     */ import mzm.gsp.activity.confbean.SMonsterLevelAwardCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity2.confbean.SVisibleMonsterInitTriggerCfg;
/*     */ import mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerCfg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class VisibleMonsterFightManager
/*     */ {
/*  20 */   private static VisibleMonsterFightManager instance = new VisibleMonsterFightManager();
/*  21 */   private LinkedBlockingDeque<IMonsterDeadHandle> monsterFightActivities = new LinkedBlockingDeque();
/*     */   
/*  23 */   private Map<Integer, VisibleMonsterActivity> visibleMonsterActivitiesMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static VisibleMonsterFightManager getInstance()
/*     */   {
/*  31 */     return instance;
/*     */   }
/*     */   
/*     */   void init() throws Exception
/*     */   {
/*  36 */     this.monsterFightActivities.add(new YaoShouTuXIActivity());
/*  37 */     this.monsterFightActivities.add(new LuanShiYaoMoActivity());
/*  38 */     this.monsterFightActivities.add(new ShengXiaoActivity());
/*  39 */     this.monsterFightActivities.add(new GangRobberActivity());
/*  40 */     for (SVisibleMonsterInitTriggerCfg initTriggerCfg : SVisibleMonsterInitTriggerCfg.getAll().values())
/*     */     {
/*  42 */       int activityCfgId = initTriggerCfg.activity_cfg_id;
/*  43 */       SVisibleMonsterKillMonsterTriggerCfg triggerCfg = SVisibleMonsterKillMonsterTriggerCfg.get(activityCfgId);
/*     */       
/*  45 */       VisibleMonsterActivity visibleMonsterActivity = new VisibleMonsterActivity(triggerCfg, initTriggerCfg);
/*  46 */       this.visibleMonsterActivitiesMap.put(Integer.valueOf(activityCfgId), visibleMonsterActivity);
/*  47 */       this.monsterFightActivities.add(visibleMonsterActivity);
/*     */     }
/*     */     
/*  50 */     ActivityInterface.registerActivityByLogicType(68, new VisibleMonsterActivityHandler());
/*     */   }
/*     */   
/*     */   void onMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/*  55 */     Iterator<IMonsterDeadHandle> it = this.monsterFightActivities.iterator();
/*  56 */     while (it.hasNext())
/*     */     {
/*  58 */       IMonsterDeadHandle activity = (IMonsterDeadHandle)it.next();
/*  59 */       activity.handleMonsterDead(context);
/*     */     }
/*     */   }
/*     */   
/*     */   void onMonsterWin(VisibleMonsterFightContext context)
/*     */   {
/*  65 */     Iterator<IMonsterDeadHandle> it = this.monsterFightActivities.iterator();
/*  66 */     while (it.hasNext())
/*     */     {
/*  68 */       IMonsterDeadHandle activity = (IMonsterDeadHandle)it.next();
/*  69 */       activity.handleMonsterWin(context);
/*     */     }
/*     */   }
/*     */   
/*     */   void postInit()
/*     */   {
/*  75 */     for (IMonsterDeadHandle handle : this.monsterFightActivities)
/*     */     {
/*  77 */       handle.init();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAwardId(int activityId, int enterFightLowLevel)
/*     */   {
/*  90 */     for (SMonsterLevelAwardCfg cfg : SMonsterLevelAwardCfg.getAll().values())
/*     */     {
/*  92 */       if ((cfg.activityId == activityId) && (cfg.levelLimit == enterFightLowLevel))
/*     */       {
/*  94 */         return cfg.awardTypeId1;
/*     */       }
/*     */     }
/*  97 */     return -1;
/*     */   }
/*     */   
/*     */   static int getAwardId2(int activityid, int enterfightLowLevel)
/*     */   {
/* 102 */     for (SMonsterLevelAwardCfg cfg : SMonsterLevelAwardCfg.getAll().values())
/*     */     {
/* 104 */       if ((cfg.activityId == activityid) && (cfg.levelLimit == enterfightLowLevel))
/*     */       {
/* 106 */         return cfg.awardTypeId2;
/*     */       }
/*     */     }
/* 109 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   VisibleMonsterActivity getVisibleMonsterActivity(int activityCfgId)
/*     */   {
/* 120 */     return (VisibleMonsterActivity)this.visibleMonsterActivitiesMap.get(Integer.valueOf(activityCfgId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\VisibleMonsterFightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */