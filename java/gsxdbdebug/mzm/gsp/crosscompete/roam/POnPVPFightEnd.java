/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.crosscompete.SSyncFactionPkScoreBrd;
/*     */ import mzm.gsp.crosscompete.SWinFightBrd;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteAgainstTmp;
/*     */ import xbean.CrossCompeteTmp;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.Roam_crosscompete_faction;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!(((PVPFightEndArg)this.arg).context instanceof PVPFightContext)) {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     PVPFightContext context = (PVPFightContext)((PVPFightEndArg)this.arg).context;
/*     */     
/*     */ 
/*     */ 
/*  44 */     Map<Long, String> allUsers = new HashMap();
/*  45 */     Set<Long> allFightRoles = ((PVPFightEndArg)this.arg).getAllRoles();
/*  46 */     for (Long roleid : allFightRoles) {
/*  47 */       String userid = RoleInterface.getUserId(roleid.longValue());
/*  48 */       allUsers.put(roleid, userid);
/*     */     }
/*     */     
/*  51 */     lock(User.getTable(), allUsers.values());
/*     */     
/*  53 */     lock(xtable.Arenascore.getTable(), allFightRoles);
/*     */     
/*  55 */     List<Long> winRoles = ((PVPFightEndArg)this.arg).getWinnerList();
/*  56 */     List<Long> loseRoles = ((PVPFightEndArg)this.arg).getLoserList();
/*     */     
/*  58 */     List<Long> winRolesNotEscaped = ((PVPFightEndArg)this.arg).getWinnerNotEscapeList();
/*  59 */     List<Long> loseRolesNotEscaped = ((PVPFightEndArg)this.arg).getLoserNotEscapeList();
/*     */     
/*  61 */     long winFactionid = -1L;
/*  62 */     long loseFactionid = -1L;
/*     */     
/*  64 */     if (((PVPFightEndArg)this.arg).isActiveWin) {
/*  65 */       winFactionid = context.activeFactionid;
/*  66 */       loseFactionid = context.passiveFactionid;
/*     */     }
/*     */     else {
/*  69 */       winFactionid = context.passiveFactionid;
/*  70 */       loseFactionid = context.activeFactionid;
/*     */     }
/*     */     
/*     */ 
/*  74 */     lock(Roam_crosscompete_faction.getTable(), Arrays.asList(new Long[] { Long.valueOf(winFactionid), Long.valueOf(loseFactionid) }));
/*     */     
/*     */ 
/*  77 */     RoamCrossCompeteFaction xWinFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(winFactionid, true);
/*     */     
/*  79 */     RoamCrossCompeteFaction xLoseFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(loseFactionid, true);
/*     */     
/*     */ 
/*  82 */     if ((xWinFaction == null) || (xLoseFaction == null)) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     RoamCrossCompeteFactionTmp xWinFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(winFactionid, true);
/*     */     
/*  88 */     RoamCrossCompeteFactionTmp xLoseFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(loseFactionid, true);
/*     */     
/*     */ 
/*  91 */     if ((xWinFactionTmp == null) || (xLoseFactionTmp == null)) {
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/*     */     
/*     */ 
/*  99 */     long world = xWinFactionTmp.getWorld();
/* 100 */     List<Long> allRoles = MapInterface.getRoleList(world);
/*     */     
/*     */ 
/* 103 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, winFactionid, loseFactionid);
/*     */     
/* 105 */     if ((xAgainst != null) && (xAgainst.getWinner() <= 0L)) {
/* 106 */       int addScore = 0;
/* 107 */       for (Iterator i$ = loseRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */         
/* 109 */         addScore += mzm.gsp.competition.main.CompetitionInterface.getAddFactionPkScore(RoleInterface.getLevel(r));
/*     */       }
/*     */       
/* 112 */       xWinFaction.setPk_score(xWinFaction.getPk_score() + addScore);
/*     */       
/* 114 */       SSyncFactionPkScoreBrd brd = new SSyncFactionPkScoreBrd();
/* 115 */       brd.factionid = winFactionid;
/* 116 */       brd.pk_score = xWinFaction.getPk_score();
/* 117 */       OnlineManager.getInstance().sendMulti(brd, allRoles);
/*     */       
/*     */ 
/* 120 */       SWinFightBrd winBrd = new SWinFightBrd();
/* 121 */       winBrd.winner_leader = RoleInterface.getName(((Long)winRoles.get(0)).longValue());
/* 122 */       winBrd.winner_number = winRoles.size();
/* 123 */       winBrd.loser_leader = RoleInterface.getName(((Long)loseRoles.get(0)).longValue());
/* 124 */       winBrd.loser_number = loseRoles.size();
/* 125 */       winBrd.score = addScore;
/* 126 */       CrossCompeteRoamManager.broadcast(xWinFactionTmp, winBrd);
/*     */     }
/*     */     
/*     */ 
/* 130 */     List<String> winUsersNotEscaped = new ArrayList();
/* 131 */     for (Long roleId : winRolesNotEscaped) {
/* 132 */       winUsersNotEscaped.add(allUsers.get(roleId));
/*     */     }
/*     */     
/* 135 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 136 */       RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/*     */       
/*     */ 
/* 139 */       String name = RoleInterface.getName(r);
/* 140 */       CrossCompeteRoamManager.addRoleWinTimes(r, name, xRoamRole, xWinFactionTmp);
/*     */     }
/*     */     
/* 143 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 144 */       RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/*     */       
/*     */ 
/* 147 */       CrossCompeteRoamManager.addRoleLoseTimes(r, xRoamRole);
/*     */       
/* 149 */       CrossCompeteRoamManager.deductActionPoint(r, xRoamRole, SCrossCompeteConsts.getInstance().DeductActionPointWhenLose, 3);
/*     */       
/*     */ 
/*     */ 
/* 153 */       if (xRoamRole.getAction_point() <= 0) {
/* 154 */         if (TeamInterface.isRoleInTeam(r, true)) {
/* 155 */           TeamInterface.leaveTeamNoneRealTime(r);
/*     */         }
/*     */         else
/*     */         {
/* 159 */           String userid = (String)allUsers.get(Long.valueOf(r));
/* 160 */           CrossCompeteRoamManager.leave(userid, r, xRoamRole, 1);
/*     */           
/*     */ 
/* 163 */           CrossCompeteManager.sendNormalResult(r, 41, new Object[0]);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */     CrossCompeteRoamManager.addFactionPVPWinTimes(xWinFaction);
/*     */     
/*     */ 
/* 177 */     CrossCompeteTmp xCompeteTmp = CrossCompeteRoamManager.createXCrossCompeteTmp();
/*     */     
/* 179 */     CrossCompeteAgainstTmp xAgainstTmp = CrossCompeteRoamManager.getXAgainstTmp(xCompeteTmp, winFactionid, loseFactionid);
/*     */     
/* 181 */     if (xAgainstTmp != null) {
/* 182 */       xAgainstTmp.getPvp_fights().remove(Long.valueOf(((PVPFightEndArg)this.arg).fightid));
/*     */     }
/*     */     
/*     */ 
/* 186 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 187 */       BuffInterface.installBuff(r, SCrossCompeteConsts.getInstance().ProtectedBuff);
/*     */     }
/* 189 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 190 */       BuffInterface.installBuff(r, SCrossCompeteConsts.getInstance().ProtectedBuff);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 195 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 196 */       ActivityInterface.logActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/* 199 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 200 */       ActivityInterface.logActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 205 */     for (Iterator i$ = winRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 206 */       ActivityInterface.tlogActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/* 209 */     for (Iterator i$ = loseRolesNotEscaped.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 210 */       ActivityInterface.tlogActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/* 214 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */