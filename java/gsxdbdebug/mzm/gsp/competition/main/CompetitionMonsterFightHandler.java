/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ import xbean.Competition;
/*    */ import xbean.CompetitionAgainst;
/*    */ import xbean.FactionCompetition;
/*    */ import xtable.Faction_competition;
/*    */ 
/*    */ 
/*    */ 
/*    */ class CompetitionMonsterFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/* 22 */   static final CompetitionMonsterFightHandler instance = new CompetitionMonsterFightHandler();
/*    */   
/*    */ 
/*    */ 
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 28 */     int monsterCfgid = FightInterface.getFightFirstMonsterid(fightId);
/*    */     
/* 30 */     int categoryid = MonsterInterface.getMonsterCategoryId(monsterCfgid);
/* 31 */     if (categoryid != SCompetitionMercenaryConsts.getInstance().MonsterTypeID) {
/* 32 */       return 0;
/*    */     }
/*    */     
/*    */ 
/* 36 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/* 37 */     if ((stage < 1) || (stage >= 4)) {
/* 38 */       return 7;
/*    */     }
/*    */     
/*    */ 
/* 42 */     long selfFactionid = GangInterface.getGangId(roleId);
/* 43 */     if (selfFactionid <= 0L) {
/* 44 */       return 9;
/*    */     }
/*    */     
/*    */ 
/* 48 */     FactionCompetition xFC = Faction_competition.select(Long.valueOf(selfFactionid));
/*    */     
/* 50 */     if (xFC == null) {
/* 51 */       return 9;
/*    */     }
/*    */     
/* 54 */     long opponentFactionid = xFC.getOpponent();
/*    */     
/*    */ 
/* 57 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/* 58 */     CompetitionAgainst xAgainst = CompetitionManager.getXAgainst(xCompetition, selfFactionid, opponentFactionid);
/*    */     
/*    */ 
/* 61 */     if (xAgainst == null) {
/* 62 */       return 9;
/*    */     }
/*    */     
/* 65 */     if (xAgainst.getMercenary_faction() == selfFactionid) {
/* 66 */       return 8;
/*    */     }
/*    */     
/* 69 */     if (xAgainst.getFinished()) {
/* 70 */       return 10;
/*    */     }
/*    */     
/* 73 */     FightInterface.startPVEFight(roleId, fightId, context, 17, FightReason.FACTION_COMPETITION_MERCENARY);
/*    */     
/*    */ 
/*    */ 
/* 77 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionMonsterFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */