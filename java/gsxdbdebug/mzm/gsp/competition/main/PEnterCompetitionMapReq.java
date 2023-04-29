/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.CompetitionMatch;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xbean.RoleCompetition;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Faction_competition;
/*     */ import xtable.Faction_competition_tmp;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PEnterCompetitionMapReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int npc;
/*     */   
/*     */   public PEnterCompetitionMapReq(long roleid, int npc)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.npc = npc;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(this.npc, 150205301, this.roleid)) {
/*  44 */       CompetitionManager.logError("PEnterCompetitionMapReq.processImp@check npc service failed|roleid=%d|npc=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.npc) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, false);
/*  54 */     if (faction == null) {
/*  55 */       CompetitionManager.logError("PEnterCompetitionMapReq.processImp@no faction|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*     */ 
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     TeamInfo team = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*     */     
/*  65 */     List<Long> roleList = new ArrayList();
/*  66 */     if (team != null) {
/*  67 */       if (team.isNormalState(this.roleid)) {
/*  68 */         if (!team.isLeader(this.roleid)) {
/*  69 */           CompetitionManager.logger.error(String.format("PEnterCompetitionMapReq.processImp@not team leader|roleid=%d|teamid=%d|leaderid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(team.getTeamId()), Long.valueOf(team.getLeaderId()) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */           return false;
/*     */         }
/*  77 */         roleList.addAll(team.getTeamNormalList());
/*     */       }
/*     */       else {
/*  80 */         roleList.add(Long.valueOf(this.roleid));
/*     */       }
/*     */     }
/*     */     else {
/*  84 */       roleList.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/*  87 */     Map<Long, String> userIds = new HashMap();
/*  88 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*  89 */       userIds.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  92 */     Lockeys.lock(User.getTable(), userIds.values());
/*     */     
/*     */ 
/*  95 */     lock(Basic.getTable(), roleList);
/*     */     
/*     */ 
/*  98 */     if (!ActivityInterface.isActivityOpen(SCompetitionConsts.getInstance().Activityid)) {
/*  99 */       CompetitionManager.broadcastNormalResult(roleList, 11, new String[0]);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userIds, roleList, SCompetitionConsts.getInstance().Activityid);
/* 105 */     if (!result.isCanJoin()) {
/* 106 */       CompetitionManager.logError("PEnterCompetitionMapReq.processImp@cannot join activity|roles=%s|reason_roleid=%d|reason=%d", new Object[] { roleList.toString(), Long.valueOf(result.getRoleId()), Integer.valueOf(result.getReasonValue()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     int stage = ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*     */     
/*     */ 
/*     */ 
/* 120 */     FactionCompetition xFC = Faction_competition.select(Long.valueOf(faction.getGangId()));
/* 121 */     if (xFC == null) {
/* 122 */       CompetitionManager.logError("PEnterCompetitionMapReq.processImp@no faction competition|roles=%s|factionid=%d|faction_displayid=%d|stage=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     Competition xCompetition = CompetitionManager.getXCompetition(false);
/* 134 */     if (xCompetition == null) {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     CompetitionMatch xMatch = CompetitionManager.getXMatch(faction.getGangId(), xFC.getOpponent());
/* 139 */     CompetitionAgainst xAgainst = (CompetitionAgainst)xCompetition.getAgainsts().get(xMatch);
/* 140 */     if ((xAgainst == null) || (xAgainst.getFinished())) {
/* 141 */       CompetitionManager.broadcastNormalResult(roleList, 12, new String[0]);
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     if (stage >= 3) {
/* 147 */       CompetitionManager.broadcastNormalResult(roleList, 13, new String[0]);
/* 148 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 152 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 154 */       if (!faction.isNormalMember(r)) {
/* 155 */         if (roleList.size() == 1) {
/* 156 */           CompetitionManager.sendNormalResult(this.roleid, 7, new String[0]);
/*     */         }
/*     */         else {
/* 159 */           CompetitionManager.broadcastNormalResult(roleList, 8, new String[] { RoleInterface.getName(r) });
/*     */         }
/* 161 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 165 */       if (!CompetitionManager.simplified.get()) {
/* 166 */         int joinDays = faction.getJoinDays(r);
/* 167 */         if (joinDays < SCompetitionConsts.getInstance().JoinDays) {
/* 168 */           if (roleList.size() == 1) {
/* 169 */             CompetitionManager.sendNormalResult(this.roleid, 9, new String[0]);
/*     */           }
/*     */           else {
/* 172 */             CompetitionManager.broadcastNormalResult(roleList, 10, new String[] { RoleInterface.getName(r) });
/*     */           }
/* 174 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 178 */       RoleCompetition xRoleCompetition = CompetitionManager.getXRoleCompetitionIfNotExist(r);
/*     */       
/* 180 */       if (stage != 0) {
/* 181 */         CompetitionManager.deductActionPoint(r, xRoleCompetition, SCompetitionConsts.getInstance().DeductActionPointWhenEnterLate, 1);
/*     */       }
/*     */       
/*     */ 
/* 185 */       if (xRoleCompetition.getAction_point() <= 0) {
/* 186 */         if (roleList.size() == 1) {
/* 187 */           CompetitionManager.sendNormalResult(this.roleid, 1, new String[0]);
/*     */         }
/*     */         else {
/* 190 */           CompetitionManager.broadcastNormalResult(roleList, 2, new String[] { RoleInterface.getName(r) });
/*     */         }
/* 192 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 196 */       if (xRoleCompetition.getParticipated()) {
/* 197 */         if (roleList.size() == 1) {
/* 198 */           CompetitionManager.sendNormalResult(this.roleid, 3, new String[0]);
/*     */         }
/*     */         else
/*     */         {
/* 202 */           CompetitionManager.broadcastNormalResult(roleList, 4, new String[] { RoleInterface.getName(r) });
/*     */         }
/*     */         
/*     */ 
/* 206 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator i$;
/* 211 */     if (team != null) {
/* 212 */       for (i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 213 */         if (!faction.isInGang(r)) {
/* 214 */           CompetitionManager.broadcastNormalResult(roleList, 5, new String[0]);
/*     */           
/* 216 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 222 */     FactionCompetitionTmp xTmp = Faction_competition_tmp.get(Long.valueOf(faction.getGangId()));
/* 223 */     if (xTmp == null) {
/* 224 */       CompetitionManager.logError("PEnterCompetitionMapReq.processImp@no faction competition tmp, no world|roles=%s|factionid=%d|stage=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Integer.valueOf(stage) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 230 */       return false;
/*     */     }
/* 232 */     long world = xTmp.getWorld();
/*     */     
/*     */ 
/* 235 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 236 */       boolean ret = mzm.gsp.status.main.RoleStatusInterface.setStatus(r, 11, false);
/* 237 */       if (!ret) {
/* 238 */         CompetitionManager.logError("PEnterCompetitionMapReq.processImp@set compete status failed|roles=%s|factionid=%d|stage=%d|failed_roleid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Integer.valueOf(stage), Long.valueOf(r) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 249 */     if (stage == 0) {
/* 250 */       MapInterface.transferToScene(this.roleid, world, SCompetitionConsts.getInstance().PrepareMap);
/*     */     }
/*     */     else
/*     */     {
/* 254 */       FactionCompetition xFactionCompetition = CompetitionManager.getXFactionCompetitionIfNotExist(faction.getGangId());
/*     */       
/* 256 */       xFactionCompetition.setParticipated(true);
/*     */       
/* 258 */       MapInterface.transferToScene(this.roleid, world, SCompetitionConsts.getInstance().FightMap);
/*     */     }
/*     */     
/*     */ 
/* 262 */     CompetitionManager.addFactionPlayer(faction.getGangId(), xTmp, roleList.size());
/*     */     
/*     */ 
/* 265 */     CompetitionManager.logInfo("PEnterCompetitionMapReq.processImp@success|roles=%s|factionid=%d|faction_displayid=%d|world=%d|stage=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Long.valueOf(world), Integer.valueOf(stage) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 274 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PEnterCompetitionMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */