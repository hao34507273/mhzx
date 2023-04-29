/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.competition.SSyncFactionPkScoreBrd;
/*     */ import mzm.gsp.competition.SWinFightBrd;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.CompetitionTmp;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xbean.RoleCompetition;
/*     */ import xtable.Faction_competition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if (!(((PVPFightEndArg)this.arg).context instanceof CompetitionFightContext)) {
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  43 */     Map<Long, String> allUsers = new java.util.HashMap();
/*  44 */     Set<Long> allFightRoles = ((PVPFightEndArg)this.arg).getAllRoles();
/*  45 */     for (Long roleid : allFightRoles) {
/*  46 */       String userid = RoleInterface.getUserId(roleid.longValue());
/*  47 */       allUsers.put(roleid, userid);
/*     */     }
/*     */     
/*  50 */     lock(xtable.User.getTable(), allUsers.values());
/*     */     
/*  52 */     lock(xtable.Arenascore.getTable(), allFightRoles);
/*     */     
/*  54 */     List<Long> winRoles = ((PVPFightEndArg)this.arg).getWinnerList();
/*  55 */     List<Long> loseRoles = ((PVPFightEndArg)this.arg).getLoserList();
/*     */     
/*  57 */     List<Long> winRolesNotEscaped = ((PVPFightEndArg)this.arg).getWinnerNotEscapeList();
/*  58 */     List<Long> loseRolesNotEscaped = ((PVPFightEndArg)this.arg).getLoserNotEscapeList();
/*     */     
/*     */ 
/*  61 */     long winFactionid = GangInterface.getGangId(((Long)winRoles.get(0)).longValue());
/*  62 */     long loseFactionid = GangInterface.getGangId(((Long)loseRoles.get(0)).longValue());
/*     */     
/*  64 */     if ((winFactionid <= 0L) || (loseFactionid <= 0L)) {
/*  65 */       CompetitionManager.logger.error("No factionid after pvp fight!! winRoles=" + winRoles + ",loserRoles=" + loseRoles);
/*     */       
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     lock(Faction_competition.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(winFactionid), Long.valueOf(loseFactionid) }));
/*  72 */     Gang winFaction = GangInterface.getGang(winFactionid, true);
/*  73 */     Gang loseFaction = GangInterface.getGang(loseFactionid, true);
/*     */     
/*     */ 
/*  76 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/*     */     
/*  78 */     xbean.CompetitionMatch xMatch = CompetitionManager.getXMatch(winFactionid, loseFactionid);
/*     */     
/*  80 */     FactionCompetitionTmp xWinFCTmp = Faction_competition_tmp.get(Long.valueOf(winFactionid));
/*  81 */     FactionCompetitionTmp xLoseFCTmp = Faction_competition_tmp.get(Long.valueOf(loseFactionid));
/*  82 */     if ((xWinFCTmp == null) || (xLoseFCTmp == null)) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     long world = xWinFCTmp.getWorld();
/*  87 */     List<Long> allRoles = MapInterface.getRoleList(world);
/*     */     
/*     */ 
/*  90 */     CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(xMatch);
/*  91 */     if ((xAgainst != null) && (!xAgainst.getFinished())) {
/*  92 */       int addScore = 0;
/*  93 */       for (Iterator i$ = loseRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*  94 */         addScore += CompetitionConfigManager.getInstance().getAddFactionPkScore(RoleInterface.getLevel(r));
/*     */       }
/*     */       
/*  97 */       FactionCompetition xWinnerCompetition = Faction_competition.get(Long.valueOf(winFactionid));
/*  98 */       xWinnerCompetition.setPk_score(xWinnerCompetition.getPk_score() + addScore);
/*     */       
/* 100 */       SSyncFactionPkScoreBrd brd = new SSyncFactionPkScoreBrd();
/* 101 */       brd.factionid = winFactionid;
/* 102 */       brd.pk_score = xWinnerCompetition.getPk_score();
/* 103 */       OnlineManager.getInstance().sendMulti(brd, allRoles);
/*     */       
/*     */ 
/* 106 */       SWinFightBrd winBrd = new SWinFightBrd();
/* 107 */       winBrd.winner_leader = RoleInterface.getName(((Long)winRoles.get(0)).longValue());
/* 108 */       winBrd.winner_number = winRoles.size();
/* 109 */       winBrd.loser_leader = RoleInterface.getName(((Long)loseRoles.get(0)).longValue());
/* 110 */       winBrd.loser_number = loseRoles.size();
/* 111 */       winBrd.score = addScore;
/* 112 */       winFaction.brocadcast(winBrd);
/*     */     }
/*     */     
/*     */ 
/* 116 */     AwardReason winReason = new AwardReason(LogReason.COMPETITION_FIGHT_WIN_AWARD);
/* 117 */     AwardReason loseReason = new AwardReason(LogReason.COMPETITION_FIGHT_LOSE_AWARD);
/* 118 */     List<String> winUsersNotEscaped = new ArrayList();
/* 119 */     for (Long roleId : winRolesNotEscaped) {
/* 120 */       winUsersNotEscaped.add(allUsers.get(roleId));
/*     */     }
/* 122 */     AwardInterface.award(SCompetitionConsts.getInstance().WinFightAward, winUsersNotEscaped, winRolesNotEscaped, winRoles, false, true, winReason);
/*     */     
/*     */ 
/* 125 */     List<String> loseUsersNotEscaped = new ArrayList();
/* 126 */     for (Long roleId : loseRolesNotEscaped) {
/* 127 */       loseUsersNotEscaped.add(allUsers.get(roleId));
/*     */     }
/* 129 */     AwardInterface.award(SCompetitionConsts.getInstance().LoseFightAward, loseUsersNotEscaped, loseRolesNotEscaped, loseRoles, false, true, loseReason);
/*     */     
/*     */ 
/*     */ 
/* 133 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 134 */       winFaction.addGongXun(r, SCompetitionConsts.getInstance().WinFightExploit);
/*     */     }
/* 136 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 137 */       loseFaction.addGongXun(r, SCompetitionConsts.getInstance().LoseFightExploit);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 142 */     for (Iterator i$ = winRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 143 */       RoleCompetition xRoleCompetition = CompetitionManager.getXRoleCompetitionIfNotExist(r);
/* 144 */       CompetitionManager.addWinStreakAndGiveReward(r, xRoleCompetition, winFaction);
/*     */     }
/*     */     
/*     */ 
/* 148 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 149 */       RoleCompetition xRoleCompetition = CompetitionManager.getXRoleCompetitionIfNotExist(r);
/* 150 */       CompetitionManager.deductActionPoint(r, xRoleCompetition, SCompetitionConsts.getInstance().DeductActionPointWhenLose, 3);
/*     */       
/*     */ 
/* 153 */       if (xRoleCompetition.getAction_point() <= 0) {
/* 154 */         if (TeamInterface.isRoleInTeam(r, true)) {
/* 155 */           TeamInterface.leaveTeamNoneRealTime(r);
/*     */         }
/*     */         else
/*     */         {
/* 159 */           CompetitionManager.leave((String)allUsers.get(Long.valueOf(r)), r, loseFaction, xLoseFCTmp);
/*     */           
/* 161 */           CompetitionManager.sendNormalResult(r, 31, new String[0]);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */     CompetitionTmp xCompetitionTmp = CompetitionManager.getXCompetitionTmpIfNotExist();
/* 172 */     xCompetitionTmp.getFights().remove(Long.valueOf(((PVPFightEndArg)this.arg).fightid));
/*     */     
/*     */ 
/*     */ 
/* 176 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 177 */       BuffInterface.installBuff(r, SCompetitionConsts.getInstance().ProtectedBuff);
/*     */     }
/* 179 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 180 */       BuffInterface.installBuff(r, SCompetitionConsts.getInstance().ProtectedBuff);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 185 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 186 */       ActivityInterface.logActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/* 188 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 189 */       ActivityInterface.logActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/* 193 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 194 */       ActivityInterface.tlogActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/* 196 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 197 */       ActivityInterface.tlogActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */