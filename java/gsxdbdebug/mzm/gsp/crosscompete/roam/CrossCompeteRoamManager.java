/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import hub.CrossCompeteUserDataBack;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crosscompete.SReturnNotify;
/*     */ import mzm.gsp.crosscompete.SSyncAgainst;
/*     */ import mzm.gsp.crosscompete.SSyncFactionPlayerNumberBrd;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteAgainstTmp;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.CrossCompeteTmp;
/*     */ import xbean.GangDutyMembers;
/*     */ import xbean.Pod;
/*     */ import xbean.RoamCrossCompeteFaction;
/*     */ import xbean.RoamCrossCompeteFactionTmp;
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xtable.Crosscompete_tmp;
/*     */ import xtable.Roam_crosscompete_faction;
/*     */ import xtable.Roam_crosscompete_factiontmp;
/*     */ 
/*     */ public class CrossCompeteRoamManager
/*     */ {
/*     */   static RoamCrossCompeteFaction createRoamCrossCompeteFactionIfNotExist(long factionid)
/*     */   {
/*  40 */     RoamCrossCompeteFaction xRoamFaction = Roam_crosscompete_faction.get(Long.valueOf(factionid));
/*     */     
/*  42 */     if (xRoamFaction == null) {
/*  43 */       xRoamFaction = Pod.newRoamCrossCompeteFaction();
/*  44 */       Roam_crosscompete_faction.insert(Long.valueOf(factionid), xRoamFaction);
/*     */     }
/*  46 */     return xRoamFaction;
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteFaction getXRoamCrossCompeteFaction(long factionid, boolean remainLock)
/*     */   {
/*  51 */     RoamCrossCompeteFaction xRoamFaction = null;
/*  52 */     if (remainLock) {
/*  53 */       xRoamFaction = Roam_crosscompete_faction.get(Long.valueOf(factionid));
/*     */     }
/*     */     else {
/*  56 */       xRoamFaction = Roam_crosscompete_faction.select(Long.valueOf(factionid));
/*     */     }
/*  58 */     return xRoamFaction;
/*     */   }
/*     */   
/*     */   static List<Long> getMembers(RoamCrossCompeteFaction xFaction)
/*     */   {
/*  63 */     List<Long> members = new ArrayList();
/*  64 */     if (xFaction != null) {
/*  65 */       for (GangDutyMembers xMembers : xFaction.getDuty2members().values()) {
/*  66 */         members.addAll(xMembers.getMembers());
/*     */       }
/*     */     }
/*  69 */     return members;
/*     */   }
/*     */   
/*     */   static RoamCrossCompeteFactionTmp createXRoamCrossCompeteFactionTmpIfNotExist(long factionid)
/*     */   {
/*  74 */     RoamCrossCompeteFactionTmp xFactionTmp = Roam_crosscompete_factiontmp.get(Long.valueOf(factionid));
/*     */     
/*  76 */     if (xFactionTmp == null) {
/*  77 */       xFactionTmp = Pod.newRoamCrossCompeteFactionTmp();
/*  78 */       Roam_crosscompete_factiontmp.insert(Long.valueOf(factionid), xFactionTmp);
/*     */     }
/*  80 */     return xFactionTmp;
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteFactionTmp getXRoamCrossCompeteFactionTmp(long factionid, boolean remainLock)
/*     */   {
/*  85 */     RoamCrossCompeteFactionTmp xRoamFactionTmp = null;
/*  86 */     if (remainLock) {
/*  87 */       xRoamFactionTmp = Roam_crosscompete_factiontmp.get(Long.valueOf(factionid));
/*     */     }
/*     */     else {
/*  90 */       xRoamFactionTmp = Roam_crosscompete_factiontmp.select(Long.valueOf(factionid));
/*     */     }
/*  92 */     return xRoamFactionTmp;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getMemberDuty(RoamCrossCompeteFaction xRoamFaction, long roleid)
/*     */   {
/*  98 */     if (xRoamFaction == null) {
/*  99 */       return -1;
/*     */     }
/* 101 */     Iterator<Map.Entry<Integer, GangDutyMembers>> iter = xRoamFaction.getDuty2members().entrySet().iterator();
/*     */     
/* 103 */     while (iter.hasNext()) {
/* 104 */       Map.Entry<Integer, GangDutyMembers> entry = (Map.Entry)iter.next();
/* 105 */       int dutyid = ((Integer)entry.getKey()).intValue();
/* 106 */       GangDutyMembers xMembers = (GangDutyMembers)entry.getValue();
/* 107 */       if (xMembers.getMembers().contains(Long.valueOf(roleid))) {
/* 108 */         return dutyid;
/*     */       }
/*     */     }
/* 111 */     return -1;
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteRole getXRoamCrossCompeteRole(long roleid, boolean remainLock)
/*     */   {
/* 116 */     RoamCrossCompeteRole xRoamRole = null;
/* 117 */     if (remainLock) {
/* 118 */       xRoamRole = xtable.Roam_crosscompete_role.get(Long.valueOf(roleid));
/*     */     }
/*     */     else {
/* 121 */       xRoamRole = xtable.Roam_crosscompete_role.select(Long.valueOf(roleid));
/*     */     }
/* 123 */     return xRoamRole;
/*     */   }
/*     */   
/*     */   static CrossCompeteTmp createXCrossCompeteTmp() {
/* 127 */     long key = GameServerInfoManager.getLocalId();
/* 128 */     CrossCompeteTmp xCompeteTmp = Crosscompete_tmp.get(Long.valueOf(key));
/* 129 */     if (xCompeteTmp == null) {
/* 130 */       xCompeteTmp = Pod.newCrossCompeteTmp();
/* 131 */       Crosscompete_tmp.insert(Long.valueOf(key), xCompeteTmp);
/*     */     }
/* 133 */     return xCompeteTmp;
/*     */   }
/*     */   
/*     */   static CrossCompeteTmp getXCrossCompeteTmp(boolean remainLock) {
/* 137 */     long key = GameServerInfoManager.getLocalId();
/* 138 */     CrossCompeteTmp xCompeteTmp = null;
/* 139 */     if (remainLock) {
/* 140 */       xCompeteTmp = Crosscompete_tmp.get(Long.valueOf(key));
/*     */     }
/*     */     else {
/* 143 */       xCompeteTmp = Crosscompete_tmp.select(Long.valueOf(key));
/*     */     }
/* 145 */     return xCompeteTmp;
/*     */   }
/*     */   
/*     */   static boolean removeXCrossCompeteTmp() {
/* 149 */     long key = GameServerInfoManager.getLocalId();
/* 150 */     return Crosscompete_tmp.remove(Long.valueOf(key));
/*     */   }
/*     */   
/*     */   static CrossCompeteAgainstTmp getXAgainstTmp(CrossCompeteTmp xCompeteTmp, long factionid1, long factionid2)
/*     */   {
/* 155 */     CrossCompeteMatch cMatch = CrossCompeteManager.getCMatch(factionid1, factionid2);
/* 156 */     return getXAgainstTmp(xCompeteTmp, cMatch);
/*     */   }
/*     */   
/*     */   static CrossCompeteAgainstTmp getXAgainstTmp(CrossCompeteTmp xCompeteTmp, CrossCompeteMatch cMatch)
/*     */   {
/* 161 */     if (xCompeteTmp == null) {
/* 162 */       return null;
/*     */     }
/* 164 */     return (CrossCompeteAgainstTmp)xCompeteTmp.getAgainsts().get(cMatch);
/*     */   }
/*     */   
/*     */ 
/*     */   static CrossCompeteAgainstTmp createXAgainstTmpIfNotExist(CrossCompeteTmp xCompeteTmp, long factionid1, long factionid2)
/*     */   {
/* 170 */     CrossCompeteMatch cMatch = CrossCompeteManager.getCMatch(factionid1, factionid2);
/* 171 */     CrossCompeteAgainstTmp xAgainstTmp = (CrossCompeteAgainstTmp)xCompeteTmp.getAgainsts().get(cMatch);
/* 172 */     if (xAgainstTmp == null) {
/* 173 */       xAgainstTmp = Pod.newCrossCompeteAgainstTmp();
/* 174 */       xCompeteTmp.getAgainsts().put(cMatch, xAgainstTmp);
/*     */     }
/* 176 */     return xAgainstTmp;
/*     */   }
/*     */   
/*     */ 
/*     */   static long createPrepareWorld()
/*     */   {
/* 182 */     long world = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SCrossCompeteConsts.getInstance().PrepareMap) }));
/*     */     
/*     */ 
/* 185 */     TeamInterface.registerJoinTeam(world, CrossCompeteTeamHandler.instance);
/* 186 */     TeamInterface.registerActivityTeam(world, CrossCompeteTeamHandler.instance);
/*     */     
/* 188 */     return world;
/*     */   }
/*     */   
/*     */   static long createPrepareWorld(RoamCrossCompeteFactionTmp xFactionTmp) {
/* 192 */     long world = createPrepareWorld();
/* 193 */     xFactionTmp.setWorld(world);
/* 194 */     xFactionTmp.setMapid(SCrossCompeteConsts.getInstance().PrepareMap);
/* 195 */     return world;
/*     */   }
/*     */   
/*     */   static void destroyPrepareWorld(long world)
/*     */   {
/* 200 */     TeamInterface.unRegisterJoinTeam(world);
/* 201 */     TeamInterface.unRegisterActivityTeam(world);
/*     */     
/* 203 */     MapInterface.destroyWorld(world);
/*     */   }
/*     */   
/*     */   static long createFightWorld()
/*     */   {
/* 208 */     long world = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SCrossCompeteConsts.getInstance().FightMap) }));
/*     */     
/*     */ 
/* 211 */     TeamInterface.registerJoinTeam(world, CrossCompeteTeamHandler.instance);
/* 212 */     TeamInterface.registerActivityTeam(world, CrossCompeteTeamHandler.instance);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 217 */     return world;
/*     */   }
/*     */   
/*     */ 
/*     */   static void destroyFightWorld(long world)
/*     */   {
/* 223 */     TeamInterface.unRegisterJoinTeam(world);
/* 224 */     TeamInterface.unRegisterActivityTeam(world);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 229 */     MapInterface.destroyWorld(world);
/*     */   }
/*     */   
/*     */   static boolean isInRoamFaction(RoamCrossCompeteFaction xRoamFaction, long roleid)
/*     */   {
/* 234 */     for (GangDutyMembers xMembers : xRoamFaction.getDuty2members().values()) {
/* 235 */       if (xMembers.getMembers().contains(Long.valueOf(roleid))) {
/* 236 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 240 */     return false;
/*     */   }
/*     */   
/*     */   static boolean clearActivityStatus(long roleid)
/*     */   {
/* 245 */     boolean ret = mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 1502);
/*     */     
/*     */ 
/* 248 */     mzm.gsp.buff.main.BuffInterface.uninstallBuf(roleid, SCrossCompeteConsts.getInstance().ProtectedBuff);
/*     */     
/*     */ 
/* 251 */     unsetFactionTitle(roleid);
/*     */     
/* 253 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void syncAgainst(long roleid, long selfFactionid, RoamCrossCompeteFaction xSelfFaction, RoamCrossCompeteFactionTmp xSelfFactionTmp, long opponentFactionid, RoamCrossCompeteFaction xOpponentFaction, RoamCrossCompeteFactionTmp xOpponentFactionTmp)
/*     */   {
/* 262 */     syncAgainst(Arrays.asList(new Long[] { Long.valueOf(roleid) }), selfFactionid, xSelfFaction, xSelfFactionTmp, opponentFactionid, xOpponentFaction, xOpponentFactionTmp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void syncAgainst(Collection<Long> roles, long selfFactionid, RoamCrossCompeteFaction xSelfFaction, RoamCrossCompeteFactionTmp xSelfFactionTmp, long opponentFactionid, RoamCrossCompeteFaction xOpponentFaction, RoamCrossCompeteFactionTmp xOpponentFactionTmp)
/*     */   {
/* 272 */     SSyncAgainst sync = getSyncAgainstProtocol(selfFactionid, xSelfFaction, xSelfFactionTmp, opponentFactionid, xOpponentFaction, xOpponentFactionTmp);
/*     */     
/* 274 */     OnlineManager.getInstance().sendMulti(sync, roles);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SSyncAgainst getSyncAgainstProtocol(long selfFactionid, RoamCrossCompeteFaction xSelfFaction, RoamCrossCompeteFactionTmp xSelfFactionTmp, long opponentFactionid, RoamCrossCompeteFaction xOpponentFaction, RoamCrossCompeteFactionTmp xOpponentFactionTmp)
/*     */   {
/* 284 */     SSyncAgainst syncAgainst = new SSyncAgainst();
/* 285 */     fillCompeteFactionBean(selfFactionid, xSelfFaction, xSelfFactionTmp, syncAgainst.self_faction);
/* 286 */     syncAgainst.self_name = xSelfFaction.getName();
/* 287 */     fillCompeteFactionBean(opponentFactionid, xOpponentFaction, xOpponentFactionTmp, syncAgainst.opponent_faction);
/* 288 */     syncAgainst.opponent_name = xOpponentFaction.getName();
/* 289 */     return syncAgainst;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillCompeteFactionBean(long factionid, RoamCrossCompeteFaction xRoamFaction, RoamCrossCompeteFactionTmp xRoamFactionTmp, mzm.gsp.crosscompete.CompeteFaction factionBean)
/*     */   {
/* 297 */     factionBean.factionid = factionid;
/* 298 */     factionBean.pk_score = xRoamFaction.getPk_score();
/* 299 */     factionBean.player_score = xRoamFaction.getPlayer_score();
/* 300 */     factionBean.player_number = xRoamFactionTmp.getRoles().size();
/*     */   }
/*     */   
/*     */ 
/*     */   static void syncRoleCompete(long roleid, RoamCrossCompeteRole xRoamRole, RoamCrossCompeteFaction xRoamFaction, int competeIndex)
/*     */   {
/* 306 */     mzm.gsp.crosscompete.SSyncRoleCompete sync = new mzm.gsp.crosscompete.SSyncRoleCompete();
/* 307 */     sync.action_point = xRoamRole.getAction_point();
/* 308 */     sync.factionid = xRoamRole.getFactionid();
/* 309 */     sync.designed_titleid = xRoamFaction.getDesigned_titleid();
/* 310 */     sync.compete_index = competeIndex;
/*     */     
/* 312 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static void syncFactionPlayerNumber(long roleid, long factionid, RoamCrossCompeteFactionTmp xRoamFactionTmp)
/*     */   {
/* 317 */     SSyncFactionPlayerNumberBrd brd = getSyncFactionPlayerNumberProtocol(factionid, xRoamFactionTmp);
/* 318 */     OnlineManager.getInstance().send(roleid, brd);
/*     */   }
/*     */   
/*     */   private static SSyncFactionPlayerNumberBrd getSyncFactionPlayerNumberProtocol(long factionid, RoamCrossCompeteFactionTmp xRoamFactionTmp)
/*     */   {
/* 323 */     int playerNum = 0;
/* 324 */     if (xRoamFactionTmp != null) {
/* 325 */       playerNum = xRoamFactionTmp.getRoles().size();
/*     */     }
/* 327 */     return getSyncFactionPlayerNumberProtocol(factionid, playerNum);
/*     */   }
/*     */   
/*     */ 
/*     */   private static SSyncFactionPlayerNumberBrd getSyncFactionPlayerNumberProtocol(long factionid, int playerNum)
/*     */   {
/* 333 */     SSyncFactionPlayerNumberBrd sync = new SSyncFactionPlayerNumberBrd();
/* 334 */     sync.factionid = factionid;
/* 335 */     sync.player_num = playerNum;
/* 336 */     return sync;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setFactionTitle(long roleid, RoamCrossCompeteRole xRoamRole, RoamCrossCompeteFaction xRoamFaction)
/*     */   {
/* 346 */     setFactionTitle(roleid, xRoamRole.getFactionid(), xRoamFaction.getName(), xRoamRole.getDuty(), xRoamFaction.getDesigned_titleid());
/*     */   }
/*     */   
/*     */ 
/*     */   private static void setFactionTitle(long roleid, long factionid, String factionName, int duty, int designedTitleid)
/*     */   {
/* 352 */     mzm.gsp.crosscompete.SCrossCompeteTitle title = new mzm.gsp.crosscompete.SCrossCompeteTitle();
/* 353 */     title.faction_id = factionid;
/* 354 */     title.faction_name = factionName;
/* 355 */     title.faction_duty = duty;
/* 356 */     title.designed_titleid = designedTitleid;
/* 357 */     MapInterface.setModelProtocol(roleid, title);
/*     */   }
/*     */   
/*     */   static void unsetFactionTitle(long roleid) {
/* 361 */     MapInterface.unSetModelProtocol(roleid, 12616741);
/*     */   }
/*     */   
/*     */   static void addFactionPlayer(long factionid, RoamCrossCompeteFactionTmp xRoamFactionTmp, Collection<Long> roles, RoamCrossCompeteFaction xRoamFaction, boolean bSyncLoadMax)
/*     */   {
/* 366 */     if (xRoamFactionTmp == null) {
/* 367 */       return;
/*     */     }
/*     */     
/* 370 */     xRoamFactionTmp.getRoles().addAll(roles);
/*     */     
/* 372 */     if (xRoamFactionTmp.getRoles().size() > xRoamFaction.getMax_member_count()) {
/* 373 */       xRoamFaction.setMax_member_count(xRoamFactionTmp.getRoles().size());
/*     */     }
/*     */     
/* 376 */     broadcastFactionPlayerNumber(factionid, xRoamFactionTmp.getRoles().size(), xRoamFactionTmp.getWorld());
/*     */     
/*     */ 
/*     */ 
/* 380 */     if (bSyncLoadMax)
/*     */     {
/* 382 */       RoamLoadManager.instance.syncFactionOnlineCountWithMax(factionid, xRoamFactionTmp.getRoles().size());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 387 */       RoamLoadManager.instance.syncFactionOnlineCount(factionid, xRoamFactionTmp.getRoles().size());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void removeFactionPlayer(long factionid, RoamCrossCompeteFactionTmp xRoamFactionTmp, Collection<Long> leaveRoles, boolean bSyncLoadMax)
/*     */   {
/* 394 */     if (xRoamFactionTmp == null) {
/* 395 */       return;
/*     */     }
/*     */     
/* 398 */     xRoamFactionTmp.getRoles().removeAll(leaveRoles);
/* 399 */     broadcastFactionPlayerNumber(factionid, xRoamFactionTmp.getRoles().size(), xRoamFactionTmp.getWorld());
/*     */     
/*     */ 
/*     */ 
/* 403 */     if (bSyncLoadMax) {
/* 404 */       RoamLoadManager.instance.syncFactionOnlineCountWithMax(factionid, xRoamFactionTmp.getRoles().size());
/*     */     }
/*     */     else
/*     */     {
/* 408 */       RoamLoadManager.instance.syncFactionOnlineCount(factionid, xRoamFactionTmp.getRoles().size());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 413 */     if (xRoamFactionTmp.getRoles().isEmpty()) {
/* 414 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new PCheckEndByOneFactionEmpty(factionid));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void broadcastFactionPlayerNumber(long factionid, int playerNum, long worldid)
/*     */   {
/* 421 */     SSyncFactionPlayerNumberBrd sync = new SSyncFactionPlayerNumberBrd();
/* 422 */     sync.factionid = factionid;
/* 423 */     sync.player_num = playerNum;
/* 424 */     MapInterface.brocadCastInWorld(worldid, sync, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onOneFactionLeft(long winFactionid, long loseFactionid, RoamCrossCompeteFaction xWinFaction, RoamCrossCompeteFaction xLoseFaction, RoamCrossCompeteFactionTmp xWinFactionTmp, RoamCrossCompeteFactionTmp xLoseFationTmp, CrossCompeteAgainst xAgainst, long world)
/*     */   {
/* 439 */     xAgainst.setWinner(winFactionid);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 455 */     triggerMapItems(world, winFactionid);
/*     */     
/*     */ 
/* 458 */     broadcastWinLose(winFactionid, loseFactionid, xWinFaction, xLoseFaction, xWinFactionTmp, xLoseFationTmp, 2);
/*     */     
/*     */ 
/*     */ 
/* 462 */     if (winFactionid < loseFactionid) {
/* 463 */       CrossCompeteManager.tlogResult(winFactionid, xWinFaction.getPk_score(), xWinFaction.getPlayer_score(), loseFactionid, xLoseFaction.getPk_score(), xLoseFaction.getPlayer_score(), 4);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 468 */       CrossCompeteManager.tlogResult(loseFactionid, xLoseFaction.getPk_score(), xLoseFaction.getPlayer_score(), winFactionid, xWinFaction.getPk_score(), xWinFaction.getPlayer_score(), 5);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 473 */     return true;
/*     */   }
/*     */   
/*     */   static void triggerMapItems(long world, long winFactionid) {
/* 477 */     int leftCount = MapInterface.getRoleNumInWorld(world);
/* 478 */     triggerMapItems(world, leftCount, winFactionid);
/*     */   }
/*     */   
/*     */   static void triggerMapItems(long world, int leftCount, long winFactionid)
/*     */   {
/* 483 */     int leftSeconds = SCrossCompeteConsts.getInstance().TriggerMapItemSeconds;
/* 484 */     new TriggerMapItemSession(leftSeconds, winFactionid, world, leftCount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onNoFactionLeft(long factionid1, long factionid2, RoamCrossCompeteFaction xFaction1, RoamCrossCompeteFaction xFaction2, RoamCrossCompeteFactionTmp xFactionTmp1, RoamCrossCompeteFactionTmp xFactionTmp2, CrossCompeteAgainst xAgainst)
/*     */   {
/* 498 */     long winFactionid = -1L;
/* 499 */     long loseFactionid = -1L;
/* 500 */     RoamCrossCompeteFaction xWinFaction = null;
/* 501 */     RoamCrossCompeteFaction xLoseFaction = null;
/* 502 */     RoamCrossCompeteFactionTmp xWinFactionTmp = null;
/* 503 */     RoamCrossCompeteFactionTmp xLoseFactionTmp = null;
/* 504 */     if (isFrontWin(factionid1, xFaction1, factionid2, xFaction2)) {
/* 505 */       winFactionid = factionid1;
/* 506 */       loseFactionid = factionid2;
/* 507 */       xWinFaction = xFaction1;
/* 508 */       xLoseFaction = xFaction2;
/* 509 */       xWinFactionTmp = xFactionTmp1;
/* 510 */       xLoseFactionTmp = xFactionTmp2;
/*     */     }
/*     */     else {
/* 513 */       winFactionid = factionid2;
/* 514 */       loseFactionid = factionid1;
/* 515 */       xWinFaction = xFaction2;
/* 516 */       xLoseFaction = xFaction1;
/* 517 */       xWinFactionTmp = xFactionTmp2;
/* 518 */       xLoseFactionTmp = xFactionTmp1;
/*     */     }
/*     */     
/*     */ 
/* 522 */     CrossCompeteManager.logInfo("CrossCompeteRoamManager.onNoFactionLeft@early end|winfactionid=%d|losefactionid=%d", new Object[] { Long.valueOf(winFactionid), Long.valueOf(loseFactionid) });
/*     */     
/*     */ 
/*     */ 
/* 526 */     xAgainst.setWinner(winFactionid);
/*     */     
/*     */ 
/* 529 */     broadcastWinLose(winFactionid, loseFactionid, xWinFaction, xLoseFaction, xWinFactionTmp, xLoseFactionTmp, 2);
/*     */     
/*     */ 
/*     */ 
/* 533 */     if (winFactionid < loseFactionid) {
/* 534 */       CrossCompeteManager.tlogResult(winFactionid, xWinFaction.getPk_score(), xWinFaction.getPlayer_score(), loseFactionid, xLoseFaction.getPk_score(), xLoseFaction.getPlayer_score(), 4);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 539 */       CrossCompeteManager.tlogResult(loseFactionid, xLoseFaction.getPk_score(), xLoseFaction.getPlayer_score(), winFactionid, xWinFaction.getPk_score(), xWinFaction.getPlayer_score(), 5);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 544 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isFrontWin(long factionid1, RoamCrossCompeteFaction xFaction1, long factionid2, RoamCrossCompeteFaction xFaction2)
/*     */   {
/* 549 */     int score1 = xFaction1.getPk_score() + xFaction1.getPlayer_score();
/* 550 */     int score2 = xFaction2.getPk_score() + xFaction2.getPlayer_score();
/*     */     
/* 552 */     if (score1 > score2) {
/* 553 */       return true;
/*     */     }
/* 555 */     if (score1 < score2) {
/* 556 */       return false;
/*     */     }
/*     */     
/* 559 */     if (xFaction1.getPk_score() > xFaction2.getPk_score()) {
/* 560 */       return true;
/*     */     }
/* 562 */     if (xFaction1.getPk_score() < xFaction2.getPk_score()) {
/* 563 */       return false;
/*     */     }
/*     */     
/* 566 */     return factionid1 < factionid2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean leave(String userid, long roleid, RoamCrossCompeteRole xRoamRole, int reason)
/*     */   {
/* 582 */     boolean ret = clearActivityStatus(roleid);
/*     */     
/* 584 */     if (!ret) {
/* 585 */       CrossCompeteManager.logError("CrossCompeteRoamManager.leave@clear status failed|roleid=%d", new Object[] { Long.valueOf(roleid) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 590 */     SReturnNotify notify = new SReturnNotify();
/* 591 */     notify.reason = reason;
/*     */     
/* 593 */     OnlineManager.getInstance().send(roleid, notify);
/*     */     
/*     */ 
/* 596 */     MapInterface.forceTransferWhenFault(roleid);
/*     */     
/*     */ 
/* 599 */     com.goldhuman.Common.Octets token = LoginManager.getRoamToken(userid);
/*     */     
/* 601 */     if (!CrossServerInterface.crossCompeteRoleDataBack(roleid, userid, token, xRoamRole.getWin_times(), xRoamRole.getLose_times(), xRoamRole.getEscape_times(), xRoamRole.getWin_streak_awards(), xRoamRole.getFinal_award(), reason))
/*     */     {
/*     */ 
/*     */ 
/* 605 */       returnOriginalServer(userid, roleid);
/*     */       
/* 607 */       CrossCompeteManager.logWarn("CrossCompeteRoamManager.leave@send data back failed, force return orginal server|roleid=%d|userid=%s|reason=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(reason) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 612 */     CrossCompeteManager.logInfo("CrossCompeteRoamManager.leave@role leave|roleid=%d|userid=%s|reason=%d", new Object[] { Long.valueOf(roleid), userid, Integer.valueOf(reason) });
/*     */     
/*     */ 
/*     */ 
/* 616 */     return ret;
/*     */   }
/*     */   
/*     */   static boolean leave(List<Long> roles, Map<Long, String> roleid2Userid, int reason)
/*     */   {
/* 621 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 622 */       clearActivityStatus(r);
/*     */     }
/*     */     
/* 625 */     SReturnNotify notify = new SReturnNotify();
/* 626 */     notify.reason = reason;
/*     */     
/* 628 */     OnlineManager.getInstance().sendMulti(notify, roles);
/*     */     
/* 630 */     List<CrossCompeteUserDataBack> userDataList = new ArrayList();
/* 631 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 632 */       String userid = (String)roleid2Userid.get(Long.valueOf(r));
/*     */       
/* 634 */       com.goldhuman.Common.Octets token = LoginManager.getRoamToken(userid);
/* 635 */       if (token == null) {
/* 636 */         CrossCompeteManager.logError("CrossCompeteRoamManager.leave@token null|roleid=%d|userid=%s", new Object[] { Long.valueOf(r), userid });
/*     */         
/* 638 */         return false;
/*     */       }
/*     */       
/* 641 */       CrossCompeteUserDataBack userData = new CrossCompeteUserDataBack();
/* 642 */       userData.userid = userid;
/* 643 */       userData.roleid = r;
/* 644 */       userData.user_token = token;
/*     */       
/* 646 */       userDataList.add(userData);
/*     */     }
/*     */     
/* 649 */     if (!CrossServerInterface.crossCompeteTeamBack(userDataList))
/*     */     {
/* 651 */       for (CrossCompeteUserDataBack userData : userDataList) {
/* 652 */         returnOriginalServer(userData.userid, userData.roleid);
/*     */       }
/*     */       
/* 655 */       CrossCompeteManager.logWarn("CrossCompeteRoamManager.leave@send data back failed, force return orginal server|roles=%s", new Object[] { roles });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 661 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 662 */       MapInterface.forceTransferWhenFault(r);
/*     */     }
/*     */     
/* 665 */     CrossCompeteManager.logInfo("CrossCompeteRoamManager.leave@team leave|roles=%s|reason=%d", new Object[] { roles, Integer.valueOf(reason) });
/*     */     
/*     */ 
/*     */ 
/* 669 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void returnOriginalServer(String userid, long roleid)
/*     */   {
/* 680 */     CrossServerInterface.removeUserRoamedInfo(userid, mzm.gsp.crossserver.main.RoamType.CROSS_COMPETE);
/*     */     
/* 682 */     LoginManager.getInstance().onReturnOrigianServer(userid, roleid);
/*     */   }
/*     */   
/*     */ 
/*     */   static void deductActionPoint(long roleid, RoamCrossCompeteRole xRoamRole, int deductValue, int reason)
/*     */   {
/* 688 */     if (xRoamRole == null) {
/* 689 */       return;
/*     */     }
/* 691 */     xRoamRole.setAction_point(xRoamRole.getAction_point() - deductValue);
/* 692 */     mzm.gsp.crosscompete.SDeductActionPointNotify notify = new mzm.gsp.crosscompete.SDeductActionPointNotify();
/* 693 */     notify.deduct_value = deductValue;
/* 694 */     notify.reason = reason;
/* 695 */     OnlineManager.getInstance().send(roleid, notify);
/*     */   }
/*     */   
/*     */   static void broadcast(RoamCrossCompeteFactionTmp xFactionTmp, xio.Protocol p) {
/* 699 */     if ((xFactionTmp == null) || (p == null)) {
/* 700 */       return;
/*     */     }
/* 702 */     OnlineManager.getInstance().sendMulti(p, xFactionTmp.getRoles());
/*     */   }
/*     */   
/*     */   static void addRoleWinTimes(long roleid, String name, RoamCrossCompeteRole xRole, RoamCrossCompeteFactionTmp xFactionTmp)
/*     */   {
/* 707 */     xRole.setWin_times(xRole.getWin_times() + 1);
/* 708 */     xRole.setWin_streak(xRole.getWin_streak() + 1);
/* 709 */     if (xRole.getWin_streak() >= SCrossCompeteConsts.getInstance().WinStreakTimes) {
/* 710 */       xRole.setWin_streak_awards(xRole.getWin_streak_awards() + 1);
/* 711 */       broadcastWinStreak(xFactionTmp, roleid, name, xRole.getWin_streak());
/*     */       
/* 713 */       xRole.setWin_streak(0);
/*     */     }
/*     */     
/* 716 */     notifyWinLoseTimes(roleid, xRole);
/*     */   }
/*     */   
/*     */   static void addRoleLoseTimes(long roleid, RoamCrossCompeteRole xRole) {
/* 720 */     xRole.setLose_times(xRole.getLose_times() + 1);
/* 721 */     xRole.setWin_streak(0);
/*     */     
/* 723 */     notifyWinLoseTimes(roleid, xRole);
/*     */   }
/*     */   
/*     */   static void addRoleEscapeTimes(long roleid, RoamCrossCompeteRole xRole) {
/* 727 */     xRole.setEscape_times(xRole.getEscape_times() + 1);
/* 728 */     xRole.setWin_streak(0);
/*     */     
/* 730 */     notifyWinLoseTimes(roleid, xRole);
/*     */   }
/*     */   
/*     */   static void addFactionPVPWinTimes(RoamCrossCompeteFaction xRoamFaction) {
/* 734 */     xRoamFaction.setWin_times(xRoamFaction.getWin_times() + 1);
/*     */   }
/*     */   
/*     */   static void broadcastWinStreak(RoamCrossCompeteFactionTmp xFactionTmp, long roleid, String name, int winStreak)
/*     */   {
/* 739 */     mzm.gsp.crosscompete.SWinStreakBrd brd = new mzm.gsp.crosscompete.SWinStreakBrd();
/* 740 */     brd.roleid = roleid;
/* 741 */     brd.name = name;
/* 742 */     brd.win_streak = winStreak;
/* 743 */     broadcast(xFactionTmp, brd);
/*     */   }
/*     */   
/*     */   static void notifyWinLoseTimes(long roleid, RoamCrossCompeteRole xRole) {
/* 747 */     mzm.gsp.crosscompete.SWinLoseTimesNotify notify = new mzm.gsp.crosscompete.SWinLoseTimesNotify();
/* 748 */     notify.win_times = xRole.getWin_times();
/* 749 */     notify.lose_times = xRole.getLose_times();
/* 750 */     notify.escape_times = xRole.getEscape_times();
/* 751 */     notify.win_streak = xRole.getWin_streak();
/* 752 */     OnlineManager.getInstance().send(roleid, notify);
/*     */   }
/*     */   
/*     */   static int getTotalScore(RoamCrossCompeteFaction xRoamFaction) {
/* 756 */     if (xRoamFaction == null) {
/* 757 */       return 0;
/*     */     }
/* 759 */     return xRoamFaction.getPk_score() + xRoamFaction.getPlayer_score();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void broadcastWinLose(long winFactionid, long loseFactionid, RoamCrossCompeteFaction xWinFaction, RoamCrossCompeteFaction xLoseFaction, RoamCrossCompeteFactionTmp xWinFactionTmp, RoamCrossCompeteFactionTmp xLoseFactionTmp, int reason)
/*     */   {
/* 766 */     mzm.gsp.crosscompete.SWinLoseBrd brd = new mzm.gsp.crosscompete.SWinLoseBrd();
/*     */     
/* 768 */     brd.winner_id = winFactionid;
/* 769 */     brd.winner_name = xWinFaction.getName();
/* 770 */     brd.winner_score = getTotalScore(xWinFaction);
/* 771 */     brd.winner_participate_count = xWinFaction.getMax_member_count();
/* 772 */     brd.winner_left_count = xWinFactionTmp.getRoles().size();
/* 773 */     brd.winner_win_times = xWinFaction.getWin_times();
/*     */     
/* 775 */     brd.loser_id = loseFactionid;
/* 776 */     brd.loser_name = xLoseFaction.getName();
/* 777 */     brd.loser_score = getTotalScore(xLoseFaction);
/* 778 */     brd.loser_participate_count = xLoseFaction.getMax_member_count();
/* 779 */     brd.loser_left_count = xLoseFactionTmp.getRoles().size();
/* 780 */     brd.loser_win_times = xLoseFaction.getWin_times();
/*     */     
/* 782 */     brd.result = reason;
/*     */     
/* 784 */     broadcast(xWinFactionTmp, brd);
/* 785 */     broadcast(xLoseFactionTmp, brd);
/*     */     
/*     */ 
/* 788 */     CrossServerInterface.notifyCrossCompeteResult(winFactionid, winFactionid, loseFactionid);
/* 789 */     CrossServerInterface.notifyCrossCompeteResult(loseFactionid, winFactionid, loseFactionid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFactionidByRoleid(long roleid)
/*     */   {
/* 799 */     RoamCrossCompeteRole xRole = getXRoamCrossCompeteRole(roleid, false);
/* 800 */     if (xRole == null) {
/* 801 */       return -1L;
/*     */     }
/* 803 */     return xRole.getFactionid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Long> getMembers(long factionid)
/*     */   {
/* 813 */     RoamCrossCompeteFactionTmp xFactionTmp = getXRoamCrossCompeteFactionTmp(factionid, false);
/* 814 */     if (xFactionTmp == null) {
/* 815 */       return null;
/*     */     }
/* 817 */     return xFactionTmp.getRoles();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\CrossCompeteRoamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */