/*     */ package mzm.gsp.menpaipvp.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.menpaipvp.confbean.MenpaiRankAward;
/*     */ import mzm.gsp.menpaipvp.confbean.SMenpaiCfg;
/*     */ import mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts;
/*     */ import mzm.gsp.menpaipvp.confbean.SMenpaiRankAwardCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MenpaiPVPConfigManager
/*     */ {
/*  23 */   private static MenpaiPVPConfigManager instance = new MenpaiPVPConfigManager();
/*     */   
/*     */   static MenpaiPVPConfigManager getInstance()
/*     */   {
/*  27 */     return instance;
/*     */   }
/*     */   
/*     */   void init()
/*     */   {
/*  32 */     checkAllMenpai();
/*     */   }
/*     */   
/*     */   void postInit() {
/*  36 */     checkActivityMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void checkAllMenpai()
/*     */   {
/*  44 */     Set<Integer> activityAllMenpai = SMenpaiCfg.getAll().keySet();
/*  45 */     List<Integer> allMenpai = RoleInterface.getAllOccupationIds();
/*     */     
/*  47 */     if (activityAllMenpai.size() != allMenpai.size()) {
/*  48 */       throw new RuntimeException("首席争霸活动门派配置错误，门派数量：" + activityAllMenpai.size() + ", 游戏中门派数量：" + allMenpai.size());
/*     */     }
/*  50 */     if (!allMenpai.containsAll(activityAllMenpai)) {
/*  51 */       throw new RuntimeException("首席争霸活动门派与游戏中门派不一致！活动门派：" + activityAllMenpai + ", 游戏总门派：" + allMenpai);
/*     */     }
/*     */   }
/*     */   
/*     */   void checkActivityMap()
/*     */   {
/*  57 */     for (Map.Entry<Integer, SMenpaiCfg> entry : SMenpaiCfg.getAll().entrySet()) {
/*  58 */       int menpai = ((Integer)entry.getKey()).intValue();
/*  59 */       SMenpaiCfg cfg = (SMenpaiCfg)entry.getValue();
/*  60 */       if (!MapInterface.isFuBenMap(cfg.mapid)) {
/*  61 */         throw new RuntimeException("首席争霸活动门派地图配置错误，不是副本地图！！！门派=" + menpai + ",mapid=" + cfg.mapid);
/*     */       }
/*     */     }
/*  64 */     if (MapInterface.isFuBenMap(SMenpaiPVPConsts.getInstance().LeaveMap)) {
/*  65 */       throw new RuntimeException("首席争霸活动离开地图配置错误，不是世界地图！！！mapid=" + SMenpaiPVPConsts.getInstance().LeaveMap);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMenpaiMap(int menpai)
/*     */   {
/*  77 */     SMenpaiCfg cfg = SMenpaiCfg.get(menpai);
/*  78 */     if (cfg == null) {
/*  79 */       throw new RuntimeException("没有门派相关配置！门派：" + menpai);
/*     */     }
/*  81 */     return cfg.mapid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getActivityID()
/*     */   {
/*  90 */     return SMenpaiPVPConsts.getInstance().Activityid;
/*     */   }
/*     */   
/*     */   Set<Integer> getAllMenpai()
/*     */   {
/*  95 */     return SMenpaiCfg.getAll().keySet();
/*     */   }
/*     */   
/*     */   int getScoreChartCapcity()
/*     */   {
/* 100 */     return SMenpaiPVPConsts.getInstance().ChartCapacity;
/*     */   }
/*     */   
/*     */   int getLeaveMap()
/*     */   {
/* 105 */     return SMenpaiPVPConsts.getInstance().LeaveMap;
/*     */   }
/*     */   
/*     */   int getMatchInterval()
/*     */   {
/* 110 */     return SMenpaiPVPConsts.getInstance().MatchInterval;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMaxLoseTimes()
/*     */   {
/* 119 */     return SMenpaiPVPConsts.getInstance().LoseTimes;
/*     */   }
/*     */   
/*     */   int getELO_K()
/*     */   {
/* 124 */     return SMenpaiPVPConsts.getInstance().ELO_K;
/*     */   }
/*     */   
/*     */   int getInitScore()
/*     */   {
/* 129 */     return SMenpaiPVPConsts.getInstance().InitPoint;
/*     */   }
/*     */   
/*     */   int getChartPageSize()
/*     */   {
/* 134 */     return SMenpaiPVPConsts.getInstance().ChartPageSize;
/*     */   }
/*     */   
/*     */   int getMenpaiChampionNpc(int menpai)
/*     */   {
/* 139 */     SMenpaiCfg cfg = SMenpaiCfg.get(menpai);
/* 140 */     if (cfg == null) {
/* 141 */       return -1;
/*     */     }
/* 143 */     return cfg.npcid;
/*     */   }
/*     */   
/*     */   List<Integer> getAllMenpaiChampionNpc() {
/* 147 */     List<Integer> npcs = new ArrayList();
/* 148 */     for (SMenpaiCfg cfg : SMenpaiCfg.getAll().values()) {
/* 149 */       npcs.add(Integer.valueOf(cfg.npcid));
/*     */     }
/* 151 */     return npcs;
/*     */   }
/*     */   
/*     */   int getPrepareAwardid()
/*     */   {
/* 156 */     return SMenpaiPVPConsts.getInstance().PrepareAward;
/*     */   }
/*     */   
/*     */   long getPrepareAwardIntervalSeconds()
/*     */   {
/* 161 */     return SMenpaiPVPConsts.getInstance().PrepareAwardMinutes * 60;
/*     */   }
/*     */   
/*     */   List<Integer> getTopNMails()
/*     */   {
/* 166 */     return SMenpaiPVPConsts.getInstance().TopMails;
/*     */   }
/*     */   
/*     */   int getWinAward()
/*     */   {
/* 171 */     return SMenpaiPVPConsts.getInstance().WinAward;
/*     */   }
/*     */   
/*     */   int getLoseAward() {
/* 175 */     return SMenpaiPVPConsts.getInstance().LoseAward;
/*     */   }
/*     */   
/*     */   int getMenpaiAppellation(int menpai) {
/* 179 */     SMenpaiCfg cfg = SMenpaiCfg.get(menpai);
/* 180 */     if (cfg == null) {
/* 181 */       return -1;
/*     */     }
/* 183 */     return cfg.appellation;
/*     */   }
/*     */   
/*     */   int getPrepareStageMinutes()
/*     */   {
/* 188 */     return SMenpaiPVPConsts.getInstance().PrepareStageMinutes;
/*     */   }
/*     */   
/*     */   int getShutdownMatchBeforeEndMinutes() {
/* 192 */     return SMenpaiPVPConsts.getInstance().ShutdownMatchBeforeEndMinutes;
/*     */   }
/*     */   
/*     */   int getEnterController()
/*     */   {
/* 197 */     return SMenpaiPVPConsts.getInstance().ControllerIn;
/*     */   }
/*     */   
/*     */   int getChampionBadge() {
/* 201 */     return SMenpaiPVPConsts.getInstance().ChampionBadge;
/*     */   }
/*     */   
/*     */   MenpaiRankAward getMenpaiRankAwardCfg(int gender, SMenpaiRankAwardCfg cfg) {
/* 205 */     for (MenpaiRankAward awardCfg : cfg.award) {
/* 206 */       if (awardCfg.gender == gender) {
/* 207 */         return awardCfg;
/*     */       }
/*     */     }
/* 210 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */