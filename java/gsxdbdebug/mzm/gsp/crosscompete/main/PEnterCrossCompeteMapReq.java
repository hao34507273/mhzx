/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import hub.CrossCompeteEnterRole;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.FactionCrossCompete;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PEnterCrossCompeteMapReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PEnterCrossCompeteMapReq(long roleid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!OpenInterface.getOpenStatus(408)) {
/*  42 */       CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@cross compete not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     mzm.gsp.gang.main.Gang faction = GangInterface.getGangByRoleId(this.roleid, false);
/*  50 */     if (faction == null) {
/*  51 */       CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@no faction|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  56 */       CrossCompeteManager.sendNormalResult(this.roleid, 11, new Object[0]);
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
/*  69 */           CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@not team leader|roleid=%d|teamid=%d|leaderid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(team.getTeamId()), Long.valueOf(team.getLeaderId()) });
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */           return false;
/*     */         }
/*  77 */         if (!team.isAllTeamMemberNormal()) {
/*  78 */           CrossCompeteManager.sendNormalResult(this.roleid, 14, new Object[0]);
/*     */           
/*     */ 
/*  81 */           CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@not all member normal|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(team.getTeamId()) });
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  86 */           return false;
/*     */         }
/*     */         
/*  89 */         roleList.addAll(team.getTeamNormalList());
/*     */       }
/*     */       else {
/*  92 */         CrossCompeteManager.sendNormalResult(this.roleid, 13, new Object[0]);
/*     */         
/*     */ 
/*  95 */         CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@temp leave|roleid=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(team.getTeamId()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 100 */         return false;
/*     */       }
/*     */     }
/*     */     else {
/* 104 */       roleList.add(Long.valueOf(this.roleid));
/*     */     }
/*     */     
/* 107 */     Map<Long, String> userIds = new HashMap();
/* 108 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/* 109 */       userIds.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*     */ 
/* 113 */     lock(User.getTable(), userIds.values());
/*     */     
/*     */ 
/* 116 */     lock(Basic.getTable(), roleList);
/*     */     
/*     */ 
/* 119 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*     */ 
/* 122 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userIds, roleList, SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/* 124 */     if (!result.isCanJoin()) {
/* 125 */       CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@cannot join activity|roles=%s|reason_roleid=%d|reason=%d", new Object[] { roleList.toString(), Long.valueOf(result.getRoleId()), Integer.valueOf(result.getReasonValue()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */       if (result.isRoleLevelWrong()) {
/* 132 */         int needLevel = ActivityInterface.getActivityLevelMin(SCrossCompeteConsts.getInstance().Activityid);
/*     */         
/* 134 */         if (roleList.size() == 1) {
/* 135 */           CrossCompeteManager.sendNormalResult(this.roleid, 25, new Object[] { Integer.valueOf(needLevel) });
/*     */         }
/*     */         else
/*     */         {
/* 139 */           CrossCompeteManager.broadcastNormalResult(roleList, 26, new Object[] { RoleInterface.getName(result.getRoleId()), Integer.valueOf(needLevel) });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 149 */     FactionCrossCompete xFactionCompete = CrossCompeteManager.getXFactionCrossCompete(faction.getGangId(), false);
/*     */     
/* 151 */     if (xFactionCompete == null) {
/* 152 */       CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@no faction cross compete|roles=%s|factionid=%d|faction_displayid=%d|stage=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 160 */       CrossCompeteManager.sendNormalResult(this.roleid, 12, new Object[0]);
/*     */       
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     if (xFactionCompete.getOpponent() <= 0L) {
/* 166 */       CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@no opponent|roles=%s|factionid=%d|faction_displayid=%d|stage=%d|opponentid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage), Long.valueOf(xFactionCompete.getOpponent()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 175 */       CrossCompeteManager.sendNormalResult(this.roleid, 12, new Object[0]);
/*     */       
/*     */ 
/* 178 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 182 */     lock(xtable.Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(faction.getGangId()), Long.valueOf(xFactionCompete.getOpponent()) }));
/*     */     
/*     */ 
/*     */ 
/* 186 */     CrossCompete xCrossCompete = CrossCompeteManager.getXCrossCompete(false);
/* 187 */     if (xCrossCompete == null) {
/* 188 */       return false;
/*     */     }
/*     */     
/* 191 */     CrossCompeteMatch cMatch = CrossCompeteManager.getCMatch(faction.getGangId(), xFactionCompete.getOpponent());
/*     */     
/* 193 */     CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)xCrossCompete.getAgainsts().get(cMatch);
/* 194 */     if (xAgainst == null) {
/* 195 */       CrossCompeteManager.broadcastNormalResult(roleList, 22, new Object[0]);
/*     */       
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     boolean isInFirstCompeteTime = CrossCompeteConfigManager.isInFirstCompeteTime(xAgainst.getCompete_index());
/*     */     
/*     */ 
/* 203 */     if (isInFirstCompeteTime) {
/* 204 */       if (stage < 5) {
/* 205 */         CrossCompeteManager.broadcastNormalResult(roleList, 21, new Object[0]);
/*     */         
/*     */ 
/* 208 */         CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@not prepare stage in frist compete time|roles=%s|factionid=%d|faction_displayid=%d|stage=%d|opponentid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage), Long.valueOf(xFactionCompete.getOpponent()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 217 */         return false;
/*     */       }
/* 219 */       if (stage > 5) {
/* 220 */         CrossCompeteManager.broadcastNormalResult(roleList, 23, new Object[0]);
/*     */         
/*     */ 
/* 223 */         CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@not prepare stage in frist compete time|roles=%s|factionid=%d|faction_displayid=%d|stage=%d|opponentid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage), Long.valueOf(xFactionCompete.getOpponent()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 232 */         return false;
/*     */       }
/*     */     }
/*     */     else {
/* 236 */       if (stage < 10) {
/* 237 */         CrossCompeteManager.broadcastNormalResult(roleList, 21, new Object[0]);
/*     */         
/*     */ 
/* 240 */         CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@not prepare stage in second compete time|roles=%s|factionid=%d|faction_displayid=%d|stage=%d|opponentid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage), Long.valueOf(xFactionCompete.getOpponent()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 249 */         return false;
/*     */       }
/* 251 */       if (stage > 10) {
/* 252 */         CrossCompeteManager.broadcastNormalResult(roleList, 23, new Object[0]);
/*     */         
/*     */ 
/* 255 */         CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@not prepare stage in second compete time|roles=%s|factionid=%d|faction_displayid=%d|stage=%d|opponentid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage), Long.valueOf(xFactionCompete.getOpponent()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 264 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 270 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 272 */       if (!faction.isNormalMember(r)) {
/* 273 */         if (roleList.size() == 1) {
/* 274 */           CrossCompeteManager.sendNormalResult(this.roleid, 17, new Object[0]);
/*     */         }
/*     */         else
/*     */         {
/* 278 */           CrossCompeteManager.broadcastNormalResult(roleList, 18, new Object[] { RoleInterface.getName(r) });
/*     */         }
/*     */         
/*     */ 
/* 282 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 286 */       if (!CrossCompeteManager.simplified) {
/* 287 */         int joinDays = faction.getJoinDays(r);
/* 288 */         if (joinDays < SCrossCompeteConsts.getInstance().JoinDays) {
/* 289 */           if (roleList.size() == 1) {
/* 290 */             CrossCompeteManager.sendNormalResult(this.roleid, 19, new Object[0]);
/*     */           }
/*     */           else
/*     */           {
/* 294 */             CrossCompeteManager.broadcastNormalResult(roleList, 20, new Object[] { RoleInterface.getName(r) });
/*     */           }
/*     */           
/*     */ 
/* 298 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator i$;
/*     */     
/* 305 */     if (team != null) {
/* 306 */       for (i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 307 */         if (!faction.isInGang(r)) {
/* 308 */           CrossCompeteManager.broadcastNormalResult(roleList, 15, new Object[0]);
/*     */           
/* 310 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 316 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 317 */       boolean ret = RoleStatusInterface.setStatus(r, 1501, true);
/* 318 */       if (!ret) {
/* 319 */         CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@set cross compete status failed|roles=%s|factionid=%d|stage=%d|failed_roleid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Integer.valueOf(stage), Long.valueOf(r) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 326 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 331 */     List<CrossCompeteEnterRole> enterRoles = new ArrayList();
/* 332 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 333 */       String userid = (String)userIds.get(Long.valueOf(r));
/* 334 */       enterRoles.add(new CrossCompeteEnterRole(r, userid));
/*     */     }
/*     */     
/* 337 */     boolean isTeam = team != null;
/* 338 */     boolean ret = CrossServerInterface.enterCrossCompeteMap(faction.getGangId(), enterRoles, xAgainst.getRoam_serverid(), isTeam);
/*     */     
/*     */ 
/* 341 */     if (!ret) {
/* 342 */       CrossCompeteManager.broadcastNormalResult(roleList, 24, new Object[0]);
/*     */       
/* 344 */       CrossCompeteManager.logError("PEnterCrossCompeteMapReq.processImp@send roam server enter failed|roles=%s|factionid=%d|stage=%d|roam_serverid=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Integer.valueOf(stage), Integer.valueOf(xAgainst.getRoam_serverid()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 351 */       return false;
/*     */     }
/*     */     
/* 354 */     CrossCompeteManager.broadcastEnterCrossCompeteMapInProgress(roleList, cMatch, xAgainst);
/*     */     
/*     */ 
/* 357 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 358 */       CrossCompeteManager.forceRemoveTeamBackContextByRoleid(r);
/*     */     }
/*     */     
/*     */ 
/* 362 */     CrossCompeteManager.logInfo("PEnterCrossCompeteMapReq.processImp@success|roles=%s|factionid=%d|faction_displayid=%d|stage=%d", new Object[] { roleList.toString(), Long.valueOf(faction.getGangId()), Long.valueOf(faction.getDisplayid()), Integer.valueOf(stage) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 370 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PEnterCrossCompeteMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */