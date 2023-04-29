/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.ladder.RoleLadderInfo;
/*     */ import mzm.gsp.ladder.SAttendLadderErrorRes;
/*     */ import mzm.gsp.ladder.SAttendLadderRes;
/*     */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LadderActivity;
/*     */ import xtable.Ladderactivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendLadderReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCAttendLadderReq(long roleid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(188)) {
/*  37 */       return false;
/*     */     }
/*  39 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(SLadderConsts.getInstance().npcid, SLadderConsts.getInstance().npcServiceid, this.roleid))
/*     */     {
/*  41 */       sendErrorRes(4);
/*  42 */       return false;
/*     */     }
/*  44 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  45 */     Long seasonStartTime = LadderManager.getBeforeSessionTimeMilSec(curTime);
/*  46 */     if (seasonStartTime == null) {
/*  47 */       sendErrorRes(5);
/*  48 */       GameServer.logger().info(String.format("[Ladder]PCAttendLadderReq.processImp@do not has season data!|curTime=%d", new Object[] { Long.valueOf(curTime) }));
/*     */       
/*  50 */       return false;
/*     */     }
/*  52 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/*  53 */     boolean hasTeam = normalList.size() > 0;
/*  54 */     if (!hasTeam) {
/*  55 */       sendErrorRes(1);
/*  56 */       return false;
/*     */     }
/*  58 */     if (!normalList.contains(Long.valueOf(this.roleid))) {
/*  59 */       sendErrorRes(1);
/*  60 */       return false;
/*     */     }
/*  62 */     if (((Long)normalList.get(0)).longValue() != this.roleid) {
/*  63 */       sendErrorRes(1);
/*  64 */       return false;
/*     */     }
/*  66 */     Map<Long, String> role2UserMap = new HashMap();
/*  67 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  68 */       String userid = RoleInterface.getUserId(roleid);
/*  69 */       role2UserMap.put(Long.valueOf(roleid), userid);
/*     */     }
/*  71 */     lock(User.getTable(), role2UserMap.values());
/*  72 */     lock(xtable.Role2properties.getTable(), normalList);
/*  73 */     List<Long> tempNormalList = TeamInterface.getNormalRoleList(this.roleid);
/*  74 */     if ((normalList.size() != tempNormalList.size()) || (!normalList.containsAll(tempNormalList)))
/*     */     {
/*  76 */       GameServer.logger().info(String.format("[Ladder]PCAttendLadderReq.processImp@team info changed!!|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  78 */       sendErrorRes(2);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, true);
/*  83 */     if (teamId == null) {
/*  84 */       sendErrorRes(2);
/*  85 */       return false;
/*     */     }
/*  87 */     List<Long> members = TeamInterface.getTeamMemberList(teamId.longValue(), true);
/*  88 */     if ((members.size() != normalList.size()) || (!members.containsAll(normalList))) {
/*  89 */       sendErrorRes(3);
/*  90 */       return false;
/*     */     }
/*  92 */     if (tempNormalList.size() <= 0) {
/*  93 */       GameServer.logger().info(String.format("[Ladder]PCAttendLadderReq.processImp@team info changed!!|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  95 */       sendErrorRes(2);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     for (Iterator i$ = tempNormalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 100 */       if (OpenInterface.isBanPlay(roleid, 188)) {
/* 101 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 188);
/*     */         
/* 103 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 107 */     int levelRange = LadderManager.getLevelRange(normalList);
/* 108 */     if (levelRange <= 0)
/*     */     {
/* 110 */       sendErrorRes(6);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(role2UserMap, normalList, SLadderConsts.getInstance().activityid);
/*     */     
/* 116 */     if (!activityJoinResult.isCanJoin()) {
/* 117 */       GameServer.logger().info(String.format("[Ladder]PCAttendLadderReq.processImp@can not join activity|roleid=%d|activityid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SLadderConsts.getInstance().activityid), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/* 124 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 125 */     LadderActivity xLadderActivity = Ladderactivity.get(Long.valueOf(localid));
/* 126 */     if (xLadderActivity == null) {
/* 127 */       xLadderActivity = xbean.Pod.newLadderActivity();
/* 128 */       Ladderactivity.insert(Long.valueOf(localid), xLadderActivity);
/*     */     }
/* 130 */     xLadderActivity.getRoleids().addAll(normalList);
/* 131 */     boolean ret = mzm.gsp.status.main.RoleStatusInterface.setStatus(this.roleid, 43, true);
/* 132 */     if (!ret) {
/* 133 */       return false;
/*     */     }
/* 135 */     SAttendLadderRes attendLadderRes = new SAttendLadderRes();
/* 136 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 137 */       xbean.Ladder xLadder = LadderManager.getAndCreateXLadder(roleid);
/* 138 */       RoleLadderInfo roleLadderInfo = new RoleLadderInfo();
/* 139 */       LadderManager.fillRoleLadderInfo(roleLadderInfo, roleid, xLadder);
/* 140 */       attendLadderRes.roleladderinfos.add(roleLadderInfo);
/*     */     }
/* 142 */     OnlineManager.getInstance().sendMulti(attendLadderRes, normalList);
/* 143 */     GameServer.logger().info(String.format("[Ladder]PCAttendLadderReq.processImp@attend succeed|roleids=%s", new Object[] { normalList }));
/*     */     
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int errorCode) {
/* 149 */     SAttendLadderErrorRes attendLadderErrorRes = new SAttendLadderErrorRes();
/* 150 */     attendLadderErrorRes.ret = errorCode;
/* 151 */     OnlineManager.getInstance().sendAtOnce(this.roleid, attendLadderErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCAttendLadderReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */