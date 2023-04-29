/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import mzm.gsp.competition.confbean.ItemController;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CompetitionConfigManager
/*     */ {
/*  15 */   private static final CompetitionConfigManager instance = new CompetitionConfigManager();
/*     */   
/*     */   static CompetitionConfigManager getInstance()
/*     */   {
/*  19 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void init()
/*     */   {
/*  27 */     initConsts();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initConsts() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   int getAddFactionPkScore(int loserLevel)
/*     */   {
/*  41 */     int score = SCompetitionConsts.getInstance().PkScoreA * loserLevel + SCompetitionConsts.getInstance().PkScoreB;
/*  42 */     return score;
/*     */   }
/*     */   
/*     */   int getSumItemWeight() {
/*  46 */     int sum = 0;
/*  47 */     for (ItemController controller : SCompetitionConsts.getInstance().ItemControllers) {
/*  48 */       sum += controller.Weight;
/*     */     }
/*  50 */     return sum;
/*     */   }
/*     */   
/*     */   int getActiveness(int activeNumber, int winTimes, int loseTimes)
/*     */   {
/*  55 */     int goalDiff = winTimes - loseTimes;
/*  56 */     if (goalDiff > SCompetitionConsts.getInstance().Max_GD) {
/*  57 */       goalDiff = SCompetitionConsts.getInstance().Max_GD;
/*     */     }
/*  59 */     else if (goalDiff < -SCompetitionConsts.getInstance().Max_GD) {
/*  60 */       goalDiff = -SCompetitionConsts.getInstance().Max_GD;
/*     */     }
/*  62 */     return (int)(activeNumber * (1.0D + SCompetitionConsts.getInstance().Activeness_A * Math.sin(SCompetitionConsts.getInstance().Activeness_B * goalDiff)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isActivityMap(int mapid)
/*     */   {
/*  73 */     return (mapid == SCompetitionConsts.getInstance().PrepareMap) || (mapid == SCompetitionConsts.getInstance().FightMap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRecallMercenaryCount(int selfCount, int opponentCount)
/*     */   {
/*  86 */     if ((selfCount <= 0) || (opponentCount <= 0)) {
/*  87 */       return 0;
/*     */     }
/*  89 */     int diff = opponentCount - selfCount;
/*  90 */     boolean bPositive = true;
/*  91 */     int smallCount = 1;
/*  92 */     if (diff >= 0) {
/*  93 */       bPositive = true;
/*  94 */       smallCount = selfCount;
/*     */     }
/*     */     else {
/*  97 */       diff = -diff;
/*  98 */       bPositive = false;
/*  99 */       smallCount = opponentCount;
/*     */     }
/*     */     
/* 102 */     if (diff < SCompetitionMercenaryConsts.getInstance().CountDiff) {
/* 103 */       return 0;
/*     */     }
/*     */     
/* 106 */     if (diff / smallCount < SCompetitionMercenaryConsts.getInstance().CountDiffRate) {
/* 107 */       return 0;
/*     */     }
/*     */     
/* 110 */     int count = (int)Math.ceil(diff / TeamInterface.getTeamCapacity());
/*     */     
/* 112 */     if (bPositive) {
/* 113 */       return count;
/*     */     }
/*     */     
/* 116 */     return -count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isCopperTreasure(int mapItemid)
/*     */   {
/* 126 */     return mapItemid == SCompetitionConsts.getInstance().CopperTreasureMapItem;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isSilverTreasure(int mapItemid)
/*     */   {
/* 135 */     return mapItemid == SCompetitionConsts.getInstance().SilverTreasureMapItem;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isGoldTreasure(int mapItemid)
/*     */   {
/* 144 */     return mapItemid == SCompetitionConsts.getInstance().GoldTreasureMapItem;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */