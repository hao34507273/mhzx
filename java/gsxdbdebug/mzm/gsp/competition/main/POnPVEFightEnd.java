/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import xbean.FactionCompetition;
/*    */ import xbean.MercenaryFights;
/*    */ import xtable.Basic;
/*    */ import xtable.Faction_competition;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     if (((PVEFightEndArg)this.arg).fightReason != FightReason.FACTION_COMPETITION_MERCENARY.value) {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     List<Long> awardRoles = ((PVEFightEndArg)this.arg).notEscapeRoles();
/*    */     
/* 29 */     List<Long> allRoles = new ArrayList();
/* 30 */     allRoles.addAll(awardRoles);
/* 31 */     allRoles.addAll(((PVEFightEndArg)this.arg).escapedRoles);
/*    */     
/* 33 */     List<String> awardUsers = new ArrayList();
/* 34 */     for (Iterator i$ = awardRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 36 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 37 */       awardUsers.add(userid);
/*    */     }
/*    */     
/*    */ 
/* 41 */     lock(User.getTable(), awardUsers);
/*    */     
/* 43 */     lock(Basic.getTable(), allRoles);
/*    */     
/*    */ 
/* 46 */     long factionid = GangInterface.getGangId(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue());
/*    */     
/* 48 */     FactionCompetition xFC = Faction_competition.select(Long.valueOf(factionid));
/* 49 */     if (xFC == null) {
/* 50 */       CompetitionManager.logError("POnPVEFightEnd.processImp@faction competition null|factionid=%d|roles=%s", new Object[] { Long.valueOf(factionid), ((PVEFightEndArg)this.arg).roleList });
/*    */       
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     long opponentid = xFC.getOpponent();
/*    */     
/*    */ 
/* 59 */     xbean.CompetitionTmp xCompetitionTmp = CompetitionManager.getXCompetitionTmp(true);
/* 60 */     if (xCompetitionTmp == null) {
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     MercenaryFights xFights = CompetitionManager.getXMercenaryFights(xCompetitionTmp, factionid, opponentid);
/*    */     
/* 66 */     if (xFights == null) {
/* 67 */       CompetitionManager.logError("POnPVEFightEnd.processImp@mercenary fights null|factionid=%d|opponentid=%d|roles=%s", new Object[] { Long.valueOf(factionid), Long.valueOf(opponentid), ((PVEFightEndArg)this.arg).roleList });
/*    */       
/*    */ 
/* 70 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 74 */     if ((((PVEFightEndArg)this.arg).isPlayerWin) || (((PVEFightEndArg)this.arg).isForceEnd)) {
/* 75 */       AwardReason awardReason = new AwardReason(mzm.gsp.tlog.LogReason.COMPETITION_MERCENARY_AWAARD);
/* 76 */       mzm.gsp.award.main.AwardInterface.award(SCompetitionMercenaryConsts.getInstance().MercenaryAward, awardUsers, awardRoles, allRoles, false, true, awardReason);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 81 */       CompetitionManager.logWarn("POnPVEFightEnd.processImp@mercenary fight lose|roles=%s|fightid=%d|fightcfgid=%d", new Object[] { ((PVEFightEndArg)this.arg).roleList, Long.valueOf(((PVEFightEndArg)this.arg).fightid), Integer.valueOf(((PVEFightEndArg)this.arg).fightCfgID) });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 87 */     xFights.getFights().remove(Long.valueOf(((PVEFightEndArg)this.arg).fightid));
/*    */     
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */