/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xbean.RoleCompetition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ import xtable.Role_competition;
/*     */ 
/*     */ public class PAttackReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long target;
/*     */   
/*     */   public PAttackReq(long roleid, long target)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.target = target;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!CompetitionManager.isActivityTime()) {
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     long faction1 = GangInterface.getGangId(this.roleid);
/*  47 */     long faction2 = GangInterface.getGangId(this.target);
/*  48 */     if ((faction1 <= 0L) || (faction2 <= 0L)) {
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     if (faction1 == faction2) {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     FactionCompetitionTmp xTmp1 = Faction_competition_tmp.select(Long.valueOf(faction1));
/*  59 */     FactionCompetitionTmp xTmp2 = Faction_competition_tmp.select(Long.valueOf(faction2));
/*  60 */     if ((xTmp1 == null) || (xTmp2 == null)) {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (xTmp1.getWorld() != xTmp2.getWorld()) {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long world = MapInterface.getRoleWorldInstanceId(this.roleid);
/*  69 */     if (world != xTmp1.getWorld()) {
/*  70 */       return false;
/*     */     }
/*  72 */     if (world != xTmp2.getWorld()) {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if ((FightInterface.isInFight(this.roleid)) || (FightInterface.isInFight(this.target))) {
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     TeamInfo team1 = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  83 */     List<Long> activeRoles = new ArrayList();
/*     */     
/*  85 */     if (team1 != null) {
/*  86 */       if (team1.isNormalState(this.roleid)) {
/*  87 */         if (!team1.isLeader(this.roleid)) {
/*  88 */           if (CompetitionManager.logger.isDebugEnabled()) {
/*  89 */             CompetitionManager.logger.debug("帮派竞赛攻击，队伍中只能队长操作！");
/*     */           }
/*  91 */           return false;
/*     */         }
/*     */         
/*  94 */         activeRoles.addAll(team1.getTeamNormalList());
/*     */       }
/*     */       else
/*     */       {
/*  98 */         activeRoles.add(Long.valueOf(this.roleid));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 103 */       activeRoles.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/* 106 */     List<Long> passiveRoles = new ArrayList();
/* 107 */     TeamInfo team2 = TeamInterface.getTeamInfoByRoleId(this.target);
/*     */     
/* 109 */     if (team2 != null) {
/* 110 */       if (team2.isNormalState(this.target)) {
/* 111 */         passiveRoles.addAll(team2.getTeamNormalList());
/*     */       }
/*     */       else {
/* 114 */         passiveRoles.add(Long.valueOf(this.target));
/*     */       }
/*     */     }
/*     */     else {
/* 118 */       passiveRoles.add(Long.valueOf(this.target));
/*     */     }
/*     */     
/* 121 */     Set<Long> lockRoles = new HashSet();
/* 122 */     lockRoles.addAll(activeRoles);
/* 123 */     lockRoles.addAll(passiveRoles);
/*     */     
/*     */ 
/* 126 */     lock(Role_competition.getTable(), lockRoles);
/*     */     
/*     */ 
/* 129 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 130 */       RoleCompetition xRC = CompetitionManager.getXRoleCompetitionIfNotExist(r);
/* 131 */       if (xRC.getAction_point() - SCompetitionConsts.getInstance().DeductActionPointWhenPK <= 0) {
/* 132 */         if (activeRoles.size() == 1) {
/* 133 */           CompetitionManager.sendNormalResult(this.roleid, 21, new String[0]);
/*     */         }
/*     */         else
/*     */         {
/* 137 */           CompetitionManager.broadcastNormalResult(activeRoles, 22, new String[] { RoleInterface.getName(r) });
/*     */         }
/*     */         
/*     */ 
/* 141 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 145 */       CompetitionManager.syncRoleCompetition(r, xRC);
/*     */     }
/*     */     
/*     */ 
/* 149 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 150 */       RoleCompetition xRC = CompetitionManager.getXRoleCompetitionIfNotExist(r);
/* 151 */       if (xRC.getParticipated()) {
/* 152 */         CompetitionManager.logWarn("PAttackReq.processImp@passive participated|active_roles=%s|passive_roles=%s|active_factionid=%d|passive_factionid=%d|participated_role=%d", new Object[] { activeRoles, passiveRoles, Long.valueOf(faction1), Long.valueOf(faction2), Long.valueOf(r) });
/*     */         
/*     */ 
/* 155 */         return false;
/*     */       }
/* 157 */       if (xRC.getAction_point() <= 0) {
/* 158 */         CompetitionManager.logWarn("PAttackReq.processImp@passive lack action point|active_roles=%s|passive_roles=%s|active_faction=%d|passive_faction=%d|lack_role=%d", new Object[] { activeRoles, passiveRoles, Long.valueOf(faction1), Long.valueOf(faction2), Long.valueOf(r) });
/*     */         
/*     */ 
/* 161 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 166 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 167 */       if (RoleStatusInterface.containsStatus(r, 17)) {
/* 168 */         CompetitionManager.broadcastNormalResult(activeRoles, 23, new String[0]);
/*     */         
/* 170 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 174 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 175 */       if (RoleStatusInterface.containsStatus(r, 17)) {
/* 176 */         CompetitionManager.broadcastNormalResult(activeRoles, 24, new String[0]);
/*     */         
/* 178 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 183 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 184 */       if (RoleStatusInterface.containsStatus(r, 0)) {
/* 185 */         CompetitionManager.broadcastNormalResult(activeRoles, 25, new String[0]);
/*     */         
/* 187 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 191 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 192 */       if (RoleStatusInterface.containsStatus(r, 0)) {
/* 193 */         CompetitionManager.broadcastNormalResult(activeRoles, 26, new String[0]);
/*     */         
/* 195 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 204 */     FightInterface.startPVPFight(this.roleid, ((Long)passiveRoles.get(0)).longValue(), new CompetitionFightContext(), 5, FightReason.FACTION_COMPETITION_PVP);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 209 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 210 */       ActivityInterface.logActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/* 212 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 213 */       ActivityInterface.logActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/*     */     
/*     */ 
/* 217 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 218 */       ActivityInterface.tlogActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/* 220 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 221 */       ActivityInterface.tlogActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/* 223 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PAttackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */