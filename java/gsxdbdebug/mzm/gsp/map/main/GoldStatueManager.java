/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.crossbattle.knockout.FightStageEndCorpsInfo;
/*     */ import mzm.gsp.crossbattle.knockout.FightStageEndCorpsInfo.CorpsMemberInfoObj;
/*     */ import mzm.gsp.map.confbean.GoldStatueInfo;
/*     */ import mzm.gsp.map.confbean.SMapGoldStatueCfg;
/*     */ import mzm.gsp.map.confbean.SMapGoldStatuePositionCfg;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ 
/*     */ 
/*     */ public class GoldStatueManager
/*     */ {
/*  17 */   private static final GoldStatueManager instance = new GoldStatueManager();
/*     */   private static final int STATUS_INIT = 0;
/*     */   
/*     */   public static final GoldStatueManager getInstance() {
/*  21 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   private static final int STATUS_DOING = 1;
/*     */   
/*     */   private static final int STATUS_DONE = 2;
/*  28 */   private volatile int status = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   private volatile InitGoldStatueWatchDog watchDog;
/*     */   
/*     */ 
/*     */ 
/*     */   void tryInitGoldStatue()
/*     */   {
/*  38 */     if (!isOpen())
/*     */     {
/*  40 */       return;
/*     */     }
/*     */     
/*  43 */     if (this.status >= 1)
/*     */     {
/*  45 */       return;
/*     */     }
/*     */     
/*  48 */     this.status = 1;
/*     */     
/*  50 */     this.watchDog = new InitGoldStatueWatchDog();
/*  51 */     CrossBattleKnockoutInterface.getCrossBattleChampionCorpsInfo();
/*     */   }
/*     */   
/*     */   void onInitGoldStatueTimeout()
/*     */   {
/*  56 */     if (!isOpen())
/*     */     {
/*  58 */       return;
/*     */     }
/*     */     
/*  61 */     if (this.status != 1)
/*     */     {
/*  63 */       return;
/*     */     }
/*     */     
/*  66 */     this.status = 0;
/*  67 */     this.watchDog = null;
/*     */   }
/*     */   
/*     */   void onInitGoldStatueFailed()
/*     */   {
/*  72 */     if (!isOpen())
/*     */     {
/*  74 */       return;
/*     */     }
/*     */     
/*  77 */     this.status = 0;
/*     */     
/*  79 */     if (this.watchDog != null)
/*     */     {
/*  81 */       this.watchDog.stopTimer();
/*  82 */       this.watchDog = null;
/*     */     }
/*     */   }
/*     */   
/*     */   void onInitGoldStatueDone(boolean nowIsHasStatue, int crossBattleNo, FightStageEndCorpsInfo corpsInfo)
/*     */   {
/*  88 */     if (!isOpen())
/*     */     {
/*  90 */       return;
/*     */     }
/*     */     
/*  93 */     this.status = 2;
/*  94 */     if (this.watchDog != null)
/*     */     {
/*  96 */       this.watchDog.stopTimer();
/*  97 */       this.watchDog = null;
/*     */     }
/*     */     
/* 100 */     cleanStatues();
/*     */     
/* 102 */     if (!nowIsHasStatue)
/*     */     {
/* 104 */       return;
/*     */     }
/*     */     
/* 107 */     int sn = 0;
/* 108 */     long worldid = MapInterface.getBigWorldid();
/* 109 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 110 */     intExtraInfoEntries.put(Integer.valueOf(1602), Integer.valueOf(corpsInfo.corpsZoneId));
/* 111 */     intExtraInfoEntries.put(Integer.valueOf(1603), Integer.valueOf(corpsInfo.corpsBadgeId));
/* 112 */     intExtraInfoEntries.put(Integer.valueOf(1604), Integer.valueOf(crossBattleNo));
/* 113 */     for (FightStageEndCorpsInfo.CorpsMemberInfoObj obj : corpsInfo.corpsMemberSet)
/*     */     {
/* 115 */       sn++;SMapGoldStatuePositionCfg positionCfg = SMapGoldStatuePositionCfg.get(sn);
/* 116 */       if (positionCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 121 */         GoldStatueInfo info = getGoldStatueCfgid(obj.occupation, obj.gender);
/* 122 */         if (info != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 127 */           Map<Integer, String> stringExtraInfoEntries = new HashMap();
/* 128 */           stringExtraInfoEntries.put(Integer.valueOf(1600), obj.roleName);
/* 129 */           stringExtraInfoEntries.put(Integer.valueOf(1601), corpsInfo.corpsName);
/* 130 */           MapInterface.addMapEntity(MapEntityType.MET_GOLD_STATUE, sn, worldid, positionCfg.mapId, positionCfg.x, positionCfg.y, info.cfgid, intExtraInfoEntries, null, stringExtraInfoEntries, null);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void onOpenChanged(boolean isOpen) {
/* 137 */     if (isOpen)
/*     */     {
/* 139 */       tryInitGoldStatue();
/*     */     }
/*     */     else
/*     */     {
/* 143 */       this.status = 0;
/* 144 */       if (this.watchDog != null)
/*     */       {
/* 146 */         this.watchDog.stopTimer();
/* 147 */         this.watchDog = null;
/*     */       }
/*     */       
/* 150 */       cleanStatues();
/*     */     }
/*     */   }
/*     */   
/*     */   private void cleanStatues()
/*     */   {
/* 156 */     for (Integer sn : SMapGoldStatuePositionCfg.getAll().keySet())
/*     */     {
/* 158 */       MapInterface.removeMapEntity(MapEntityType.MET_GOLD_STATUE, sn.intValue(), null);
/*     */     }
/*     */   }
/*     */   
/*     */   private GoldStatueInfo getGoldStatueCfgid(int occupation, int gender)
/*     */   {
/* 164 */     SMapGoldStatueCfg cfg = SMapGoldStatueCfg.get(occupation);
/* 165 */     if (cfg == null)
/*     */     {
/* 167 */       return null;
/*     */     }
/*     */     
/* 170 */     return (GoldStatueInfo)cfg.infos.get(Integer.valueOf(gender));
/*     */   }
/*     */   
/*     */   private boolean isOpen()
/*     */   {
/* 175 */     return OpenInterface.getOpenStatus(443);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\GoldStatueManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */