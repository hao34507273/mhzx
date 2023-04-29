/*     */ package mzm.gsp.arena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.arena.confbean.SArenaConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.ELO.RankResult;
/*     */ import xbean.Arena;
/*     */ import xbean.ArenaScore;
/*     */ import xbean.ArenaTmp;
/*     */ import xbean.Camp;
/*     */ import xtable.Arenascore;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVPFightEnd extends PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     if (!(((PVPFightEndArg)this.arg).context instanceof ArenaFightContext)) {
/*  31 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  36 */     Set<Long> allRoles = ((PVPFightEndArg)this.arg).getAllRoles();
/*  37 */     Map<Long, String> allUsers = new HashMap();
/*  38 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  39 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*  40 */       allUsers.put(Long.valueOf(roleid), userid);
/*     */     }
/*     */     
/*     */ 
/*  44 */     lock(User.getTable(), allUsers.values());
/*     */     
/*     */ 
/*  47 */     lock(Arenascore.getTable(), allRoles);
/*     */     
/*  49 */     List<Long> winRoles = ((PVPFightEndArg)this.arg).getWinnerList();
/*  50 */     List<Long> loseRoles = ((PVPFightEndArg)this.arg).getLoserList();
/*     */     
/*  52 */     List<Long> winRolesNotEscaped = ((PVPFightEndArg)this.arg).getWinnerNotEscapeList();
/*  53 */     List<Long> loseRolesNotEscaped = ((PVPFightEndArg)this.arg).getLoserNotEscapeList();
/*     */     
/*     */ 
/*  56 */     Arena xArena = ArenaManager.getXArena(true);
/*     */     
/*  58 */     int allAddScore = 0;
/*  59 */     int winnerCamp = -1;
/*     */     
/*  61 */     if (!xArena.getFinished()) {
/*  62 */       for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { r1 = ((Long)i$.next()).longValue();
/*  63 */         xScore1 = ArenaManager.getXArenaScoreIfNotExist(r1);
/*  64 */         winnerCamp = xScore1.getCamp();
/*  65 */         for (i$ = loseRoles.iterator(); i$.hasNext();) { long r2 = ((Long)i$.next()).longValue();
/*  66 */           ArenaScore xScore2 = ArenaManager.getXArenaScoreIfNotExist(r2);
/*     */           
/*  68 */           Integer times = (Integer)xScore1.getMatchroles().get(Long.valueOf(r2));
/*  69 */           if (times == null) {
/*  70 */             times = Integer.valueOf(1);
/*     */           }
/*     */           else {
/*  73 */             times = Integer.valueOf(times.intValue() + 1);
/*     */           }
/*     */           
/*  76 */           xScore1.getMatchroles().put(Long.valueOf(r2), times);
/*  77 */           xScore2.getMatchroles().put(Long.valueOf(r1), times);
/*     */           
/*     */ 
/*     */ 
/*  81 */           ELO.RankResult rankResult = mzm.gsp.util.ELO.getELORankIncResult(xScore1.getScore(), xScore2.getScore(), SArenaConsts.getInstance().ELO_K, mzm.gsp.util.ELO.MatchResult.Win);
/*     */           
/*     */ 
/*     */ 
/*  85 */           if (!mzm.gsp.idip.main.IdipManager.isZeroProfit(r1))
/*     */           {
/*  87 */             xScore1.setScore(xScore1.getScore() + rankResult.getRankA());
/*     */             
/*  89 */             allAddScore += rankResult.getRankA();
/*     */           }
/*     */         } }
/*     */       long r1;
/*     */       ArenaScore xScore1;
/*     */       Iterator i$;
/*  95 */       Camp xCampWinner = (Camp)xArena.getCamps().get(Integer.valueOf(winnerCamp));
/*  96 */       xCampWinner.setScore(xCampWinner.getScore() + allAddScore);
/*     */     }
/*     */     
/*     */ 
/* 100 */     AwardReason winReason = new AwardReason(LogReason.ARENA_FIGHT_WIN_AWARD);
/* 101 */     AwardReason loseReason = new AwardReason(LogReason.ARENA_FIGHT_LOSE_AWARD);
/*     */     
/* 103 */     List<String> winUsersNotEscaped = new ArrayList();
/* 104 */     for (Long roleId : winRolesNotEscaped) {
/* 105 */       winUsersNotEscaped.add(allUsers.get(roleId));
/*     */     }
/* 107 */     AwardInterface.award(SArenaConsts.getInstance().WinAward, winUsersNotEscaped, winRolesNotEscaped, winRoles, -1, false, true, winReason);
/*     */     
/*     */ 
/* 110 */     List<String> loseUsersNotEscaped = new ArrayList();
/* 111 */     for (Long roleId : loseRolesNotEscaped) {
/* 112 */       loseUsersNotEscaped.add(allUsers.get(roleId));
/*     */     }
/* 114 */     AwardInterface.award(SArenaConsts.getInstance().LoseAward, loseUsersNotEscaped, loseRolesNotEscaped, loseRoles, -1, false, true, loseReason);
/*     */     
/*     */ 
/*     */ 
/* 118 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmpIfNotExist();
/*     */     
/*     */ 
/*     */ 
/* 122 */     List<ArenaChartObj> chartObjs = new ArrayList();
/* 123 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 124 */       ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(r);
/*     */       
/*     */ 
/* 127 */       ArenaManager.addWinTimes(r, xScore);
/* 128 */       ArenaManager.syncRoleScore(r, xScore);
/*     */       
/*     */ 
/* 131 */       ArenaChartObj chartObj = new ArenaChartObj(r, xScore.getScore(), xScore.getWin_times());
/* 132 */       chartObjs.add(chartObj);
/*     */     }
/*     */     
/* 135 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 136 */       ArenaScore xScore = ArenaManager.getXArenaScoreIfNotExist(r);
/*     */       
/* 138 */       ArenaManager.deductActionPoint(xScore);
/* 139 */       if (xScore.getAction_point() <= 0) {
/* 140 */         if (TeamInterface.isRoleInTeam(r, false)) {
/* 141 */           TeamInterface.leaveTeamNoneRealTime(r);
/*     */         }
/*     */         else {
/* 144 */           ArenaManager.checkAndLeaveActivityWorld(r, xArenaTmp.getWorld());
/* 145 */           ArenaManager.sendNormalResult(r, 11, new String[0]);
/*     */         }
/*     */       }
/*     */       else {
/* 149 */         ArenaManager.syncRoleScore(r, xScore);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 155 */     xArenaTmp.getFights().remove(Long.valueOf(((PVPFightEndArg)this.arg).fightid));
/*     */     
/*     */ 
/*     */ 
/* 159 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 160 */       ActivityInterface.logActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/* 162 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 163 */       ActivityInterface.logActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/* 167 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 168 */       ActivityInterface.tlogActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/* 170 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 171 */       ActivityInterface.tlogActivity(r, SArenaConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/* 175 */     if (!xArena.getFinished()) {
/* 176 */       for (ArenaChartObj obj : chartObjs) {
/* 177 */         ArenaManager.chart.rank(obj);
/*     */       }
/*     */     }
/*     */     
/* 181 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */