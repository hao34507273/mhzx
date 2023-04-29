/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.Roam_crosscompete_role;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PAttackReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long target;
/*     */   
/*     */   public PAttackReq(long roleid, long target)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.target = target;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!OpenInterface.getOpenStatus(408)) {
/*  45 */       CrossCompeteManager.logError("PAttackReq.processImp@cross compete not open|roleid=%d|target=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.target) });
/*     */       
/*     */ 
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*  54 */     if (!CrossCompeteManager.isFightStage(stage)) {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     Long selfFactionid = Roam_crosscompete_role.selectFactionid(Long.valueOf(this.roleid));
/*  60 */     Long targetFactionid = Roam_crosscompete_role.selectFactionid(Long.valueOf(this.target));
/*     */     
/*     */ 
/*  63 */     if ((selfFactionid.longValue() <= 0L) || (targetFactionid.longValue() <= 0L)) {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     if (selfFactionid.longValue() == targetFactionid.longValue()) {
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     RoamCrossCompeteFactionTmp xSelfFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(selfFactionid.longValue(), false);
/*     */     
/*  75 */     RoamCrossCompeteFactionTmp xTargetFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(targetFactionid.longValue(), false);
/*     */     
/*     */ 
/*  78 */     if ((xSelfFactionTmp == null) || (xTargetFactionTmp == null)) {
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (xSelfFactionTmp.getWorld() != xTargetFactionTmp.getWorld()) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     long world = MapInterface.getRoleWorldInstanceId(this.roleid);
/*  87 */     long targetWorld = MapInterface.getRoleWorldInstanceId(this.target);
/*  88 */     if (world < 0L) {
/*  89 */       return false;
/*     */     }
/*  91 */     if (world != targetWorld) {
/*  92 */       return false;
/*     */     }
/*  94 */     if (world != xSelfFactionTmp.getWorld()) {
/*  95 */       return false;
/*     */     }
/*  97 */     if (world != xTargetFactionTmp.getWorld()) {
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     TeamInfo team1 = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 103 */     List<Long> activeRoles = new ArrayList();
/*     */     
/* 105 */     if (team1 != null) {
/* 106 */       if (team1.isNormalState(this.roleid)) {
/* 107 */         if (!team1.isLeader(this.roleid)) {
/* 108 */           if (CrossCompeteManager.isLoggerDebugEnabled()) {
/* 109 */             CrossCompeteManager.logDebug("PAttackReq.processImp@not leader attack|roleid=%d|targetid=%d|world=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.target), Long.valueOf(world) });
/*     */           }
/*     */           
/*     */ 
/* 113 */           return false;
/*     */         }
/*     */         
/* 116 */         activeRoles.addAll(team1.getTeamNormalList());
/*     */       }
/*     */       else
/*     */       {
/* 120 */         activeRoles.add(Long.valueOf(this.roleid));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 125 */       activeRoles.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/* 128 */     List<Long> passiveRoles = new ArrayList();
/* 129 */     TeamInfo team2 = TeamInterface.getTeamInfoByRoleId(this.target);
/*     */     
/* 131 */     if (team2 != null) {
/* 132 */       if (team2.isNormalState(this.target)) {
/* 133 */         passiveRoles.addAll(team2.getTeamNormalList());
/*     */       }
/*     */       else {
/* 136 */         passiveRoles.add(Long.valueOf(this.target));
/*     */       }
/*     */     }
/*     */     else {
/* 140 */       passiveRoles.add(Long.valueOf(this.target));
/*     */     }
/*     */     
/* 143 */     Set<Long> lockRoles = new HashSet();
/* 144 */     lockRoles.addAll(activeRoles);
/* 145 */     lockRoles.addAll(passiveRoles);
/*     */     
/*     */ 
/* 148 */     lock(Roam_crosscompete_role.getTable(), lockRoles);
/*     */     
/*     */ 
/* 151 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 152 */       RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/*     */       
/* 154 */       int deductPoint = SCrossCompeteConsts.getInstance().DeductActionPointWhenPK;
/* 155 */       if ((xRoamRole == null) || (xRoamRole.getAction_point() - deductPoint <= 0))
/*     */       {
/* 157 */         if (activeRoles.size() == 1) {
/* 158 */           CrossCompeteManager.sendNormalResult(this.roleid, 31, new Object[0]);
/*     */         }
/*     */         else
/*     */         {
/* 162 */           CrossCompeteManager.broadcastNormalResult(activeRoles, 32, new Object[] { RoleInterface.getName(r) });
/*     */         }
/*     */         
/*     */ 
/* 166 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 171 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 172 */       RoamCrossCompeteRole xRoamRole = CrossCompeteRoamManager.getXRoamCrossCompeteRole(r, true);
/*     */       
/* 174 */       if ((xRoamRole == null) || (xRoamRole.getAction_point() <= 0)) {
/* 175 */         CrossCompeteManager.logError("PAttackReq.processImp@passive lack action point|active_roles=%s|passive_roles=%s|active_faction=%d|passive_faction=%d|lack_role=%d", new Object[] { activeRoles, passiveRoles, Long.valueOf(selfFactionid.longValue()), Long.valueOf(targetFactionid.longValue()), Long.valueOf(r) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 182 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 187 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 188 */       if (RoleStatusInterface.containsStatus(r, 17)) {
/* 189 */         CrossCompeteManager.broadcastNormalResult(activeRoles, 33, new Object[0]);
/*     */         
/* 191 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 195 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 196 */       if (RoleStatusInterface.containsStatus(r, 17)) {
/* 197 */         CrossCompeteManager.broadcastNormalResult(activeRoles, 34, new Object[0]);
/*     */         
/* 199 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 204 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 205 */       if (RoleStatusInterface.containsStatus(r, 0)) {
/* 206 */         CrossCompeteManager.broadcastNormalResult(activeRoles, 35, new Object[0]);
/*     */         
/* 208 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 212 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 213 */       if (RoleStatusInterface.containsStatus(r, 0)) {
/* 214 */         CrossCompeteManager.broadcastNormalResult(activeRoles, 36, new Object[0]);
/*     */         
/* 216 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 225 */     FightInterface.startPVPFight(this.roleid, ((Long)passiveRoles.get(0)).longValue(), new PVPFightContext(selfFactionid.longValue(), targetFactionid.longValue()), 23, FightReason.CROSS_COMPETE_PVP);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 231 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 232 */       ActivityInterface.logActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/* 234 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 235 */       ActivityInterface.logActivity(r, SCompetitionConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/*     */     
/*     */ 
/* 239 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 240 */       ActivityInterface.tlogActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/* 242 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 243 */       ActivityInterface.tlogActivity(r, SCrossCompeteConsts.getInstance().Activityid, ActivityLogStatus.ATTEND);
/*     */     }
/* 245 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PAttackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */