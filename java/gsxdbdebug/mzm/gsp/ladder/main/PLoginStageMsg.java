/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.ladder.RoleLadderLoginInfo;
/*     */ import mzm.gsp.ladder.SSynLadderInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.LadderActivity;
/*     */ import xtable.Ladderactivity;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class PLoginStageMsg
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   
/*     */   PLoginStageMsg(long roleid)
/*     */   {
/* 391 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 397 */     LadderActivity xLadderActivity = Ladderactivity.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 398 */     if (xLadderActivity == null) {
/* 399 */       return false;
/*     */     }
/* 401 */     if (!xLadderActivity.getRoleids().contains(Long.valueOf(this.roleid))) {
/* 402 */       return unSetStatus();
/*     */     }
/* 404 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 405 */     if (teamid == null) {
/* 406 */       return unSetStatus();
/*     */     }
/* 408 */     List<Long> memberList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 409 */     if (memberList.size() <= 0) {
/* 410 */       return unSetStatus();
/*     */     }
/* 412 */     Map<Long, String> role2UserMap = new HashMap();
/* 413 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long memRoleid = ((Long)i$.next()).longValue();
/* 414 */       String userid = RoleInterface.getUserId(memRoleid);
/* 415 */       role2UserMap.put(Long.valueOf(memRoleid), userid);
/*     */     }
/* 417 */     lock(User.getTable(), role2UserMap.values());
/* 418 */     lock(Role2properties.getTable(), memberList);
/* 419 */     List<Long> trulyMemberList = TeamInterface.getTeamMemberList(teamid.longValue(), true);
/* 420 */     if ((trulyMemberList.size() != memberList.size()) || (!memberList.containsAll(trulyMemberList))) {
/* 421 */       return unSetStatus();
/*     */     }
/* 423 */     SSynLadderInfo synLadderRes = new SSynLadderInfo();
/* 424 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long memRoleid = ((Long)i$.next()).longValue();
/* 425 */       RoleLadderLoginInfo roleLadderLoginInfo = new RoleLadderLoginInfo();
/* 426 */       LadderManager.fillRoleLadderInfo(roleLadderLoginInfo.roleladderinfo, memRoleid);
/* 427 */       synLadderRes.roleladderlogininfos.add(roleLadderLoginInfo);
/* 428 */       Set<Integer> statuses = RoleStatusInterface.getStatusSet(memRoleid);
/* 429 */       if (statuses.contains(Integer.valueOf(42))) {
/* 430 */         roleLadderLoginInfo.matchstage = 2;
/* 431 */       } else if (statuses.contains(Integer.valueOf(43))) {
/* 432 */         roleLadderLoginInfo.matchstage = 1;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 437 */     OnlineManager.getInstance().send(this.roleid, synLadderRes);
/* 438 */     return true;
/*     */   }
/*     */   
/*     */   private boolean unSetStatus() {
/* 442 */     boolean ret = RoleStatusInterface.unsetStatus(this.roleid, 42);
/* 443 */     if (ret) {
/* 444 */       RoleStatusInterface.unsetStatus(this.roleid, 40);
/*     */     }
/* 446 */     RoleStatusInterface.unsetStatus(this.roleid, 43);
/* 447 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PLoginStageMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */