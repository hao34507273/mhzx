/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.event.PVEFightStartProcedure;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import xbean.FactionCompetition;
/*    */ import xbean.MercenaryFights;
/*    */ import xtable.Faction_competition;
/*    */ 
/*    */ public class POnPVEFightStart extends PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (((PVEFightStartArg)this.arg).fightReason != FightReason.FACTION_COMPETITION_MERCENARY.value) {
/* 16 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 20 */     long factionid = mzm.gsp.gang.main.GangInterface.getGangId(((Long)((PVEFightStartArg)this.arg).roles.get(0)).longValue());
/*    */     
/* 22 */     FactionCompetition xFC = Faction_competition.select(Long.valueOf(factionid));
/*    */     
/* 24 */     if (xFC == null) {
/* 25 */       CompetitionManager.logError("POnPVEFightStart.processImp@faction competition null|factionid=%d|roles=%s", new Object[] { Long.valueOf(factionid), ((PVEFightStartArg)this.arg).roles });
/*    */       
/*    */ 
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     long opponentid = xFC.getOpponent();
/*    */     
/*    */ 
/* 34 */     xbean.CompetitionTmp xCompetitionTmp = CompetitionManager.getXCompetitionTmpIfNotExist();
/* 35 */     MercenaryFights xFights = CompetitionManager.getXMercenaryFightsIfNotExist(xCompetitionTmp, factionid, opponentid);
/*    */     
/* 37 */     xFights.getFights().add(Long.valueOf(((PVEFightStartArg)this.arg).fightid));
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnPVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */