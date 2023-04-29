/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.FactionCompetition;
/*     */ import xtable.Faction_competition;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompetitionInterface
/*     */ {
/*     */   public static boolean setProtectedStatus(long roleid)
/*     */   {
/*  20 */     return RoleStatusInterface.setStatus(roleid, 17, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unsetProtectedStatus(long roleid)
/*     */   {
/*  31 */     RoleStatusInterface.unsetStatus(roleid, 17);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getActiveness(int activeNumber, int winTimes, int loseTimes)
/*     */   {
/*  43 */     return CompetitionConfigManager.getInstance().getActiveness(activeNumber, winTimes, loseTimes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFactionActiveNumber(long factionid)
/*     */   {
/*  55 */     FactionCompetition xFactionCompetition = Faction_competition.select(Long.valueOf(factionid));
/*  56 */     if (xFactionCompetition == null) {
/*  57 */       return 0;
/*     */     }
/*  59 */     return Math.max(xFactionCompetition.getActive_number(), xFactionCompetition.getLast_active_number());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAddFactionPkScore(int loserLevel)
/*     */   {
/*  69 */     return CompetitionConfigManager.getInstance().getAddFactionPkScore(loserLevel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMaxFactionParticipateCount(long factionid)
/*     */   {
/*  79 */     FactionCompetition xFactionCompetition = Faction_competition.select(Long.valueOf(factionid));
/*  80 */     if (xFactionCompetition == null) {
/*  81 */       return 0;
/*     */     }
/*  83 */     return Math.max(xFactionCompetition.getPaticipate_count(), xFactionCompetition.getLast_partcipate_count());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCopperTreasure(int mapItemid)
/*     */   {
/*  93 */     return CompetitionConfigManager.getInstance().isCopperTreasure(mapItemid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isSilverTreasure(int mapItemid)
/*     */   {
/* 102 */     return CompetitionConfigManager.getInstance().isSilverTreasure(mapItemid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isGoldTreasure(int mapItemid)
/*     */   {
/* 111 */     return CompetitionConfigManager.getInstance().isGoldTreasure(mapItemid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */