/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*     */ import mzm.gsp.ladder.SLadderMatchErrorRes;
/*     */ import mzm.gsp.ladder.SLadderMatchRes;
/*     */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2matchcontextid;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCLadderMatchReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCLadderMatchReq(long roleid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!OpenInterface.getOpenStatus(188)) {
/*  37 */       return false;
/*     */     }
/*  39 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  40 */     Long seasonStartTime = LadderManager.getBeforeSessionTimeMilSec(curTime);
/*  41 */     if (seasonStartTime == null) {
/*  42 */       sendErrorRes(8, new String[0]);
/*  43 */       GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@do not has season data!|curTime=%d", new Object[] { Long.valueOf(curTime) }));
/*     */       
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  49 */     if (teamid == null) {
/*  50 */       GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@do not has team|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  52 */       return false;
/*     */     }
/*  54 */     List<Long> memberList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*  55 */     if (memberList.size() <= 0) {
/*  56 */       sendErrorRes(3, new String[0]);
/*  57 */       return false;
/*     */     }
/*  59 */     Map<Long, String> role2UserMap = new HashMap();
/*  60 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  61 */       String userid = RoleInterface.getUserId(roleid);
/*  62 */       role2UserMap.put(Long.valueOf(roleid), userid);
/*     */     }
/*  64 */     lock(User.getTable(), role2UserMap.values());
/*  65 */     lock(xtable.Role2properties.getTable(), memberList);
/*  66 */     List<Long> trulyMemberList = TeamInterface.getTeamMemberList(teamid.longValue(), true);
/*  67 */     if ((trulyMemberList.size() != memberList.size()) || (!memberList.containsAll(trulyMemberList))) {
/*  68 */       sendErrorRes(3, new String[0]);
/*  69 */       return false;
/*     */     }
/*  71 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/*     */     
/*  73 */     if (normalList.size() != trulyMemberList.size()) {
/*  74 */       sendErrorRes(4, new String[0]);
/*  75 */       return false;
/*     */     }
/*  77 */     if (this.roleid != ((Long)normalList.get(0)).longValue()) {
/*  78 */       sendErrorRes(1, new String[0]);
/*  79 */       return false;
/*     */     }
/*  81 */     int levelRange = LadderManager.getLevelRange(memberList);
/*  82 */     if (levelRange <= 0)
/*     */     {
/*  84 */       sendErrorRes(9, new String[0]);
/*  85 */       return false;
/*     */     }
/*  87 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(role2UserMap, trulyMemberList, SLadderConsts.getInstance().activityid);
/*     */     
/*  89 */     if (!activityJoinResult.isCanJoin()) {
/*  90 */       GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@can not join activity|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*  93 */       return false;
/*     */     }
/*  95 */     if (RoleStatusInterface.containsStatus(this.roleid, 42)) {
/*  96 */       GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@in match stage already|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 103 */       if (OpenInterface.isBanPlay(roleid, 188)) {
/* 104 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 188);
/*     */         
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       if (roleid != this.roleid)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */         if (!RoleStatusInterface.containsStatus(roleid, 43)) {
/* 118 */           sendErrorRes(6, new String[0]);
/* 119 */           return false;
/*     */         }
/* 121 */         if (RoleStatusInterface.containsStatus(roleid, 42)) {
/* 122 */           GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@in match stage already|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */           
/* 124 */           return false;
/*     */         }
/*     */       } }
/* 127 */     boolean ret = RoleStatusInterface.setStatus(memberList, 42, true);
/* 128 */     if (!ret) {
/* 129 */       return false;
/*     */     }
/* 131 */     ret = RoleStatusInterface.setStatus(memberList, 40, true);
/* 132 */     if (!ret) {
/* 133 */       return false;
/*     */     }
/* 135 */     List<RoleMatchMarkingInfo> roleMatchMarkingInfos = new ArrayList();
/* 136 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 137 */       RoleMatchMarkingInfo roleMatchMarkingInfo = LadderManager.createMatchMarkingInfo(roleid);
/* 138 */       roleMatchMarkingInfos.add(roleMatchMarkingInfo);
/*     */     }
/* 140 */     long matchid = CrossServerInterface.match(levelRange, this.roleid, roleMatchMarkingInfos, new LadderMatchContext());
/* 141 */     if (matchid < 0L) {
/* 142 */       sendErrorRes(7, new String[0]);
/* 143 */       GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@unknown error|roleid=%d|roleids=%s", new Object[] { Long.valueOf(this.roleid), normalList }));
/*     */       
/*     */ 
/* 146 */       return false;
/*     */     }
/* 148 */     for (Iterator i$ = normalList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 149 */       Role2matchcontextid.insert(Long.valueOf(roleid), Long.valueOf(matchid));
/*     */     }
/* 151 */     SLadderMatchRes ladderMatchRes = new SLadderMatchRes();
/* 152 */     OnlineManager.getInstance().sendMulti(ladderMatchRes, memberList);
/* 153 */     GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@excute match succeed|roleid=%d|roleids=%s", new Object[] { Long.valueOf(this.roleid), normalList }));
/*     */     
/*     */ 
/*     */ 
/* 157 */     LadderManager.logMatch(memberList, role2UserMap, 0L, 2, matchid, 0);
/* 158 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int errorCode, String... args) {
/* 162 */     SLadderMatchErrorRes ladderMatchErrorRes = new SLadderMatchErrorRes();
/* 163 */     ladderMatchErrorRes.ret = errorCode;
/* 164 */     for (String arg : args) {
/* 165 */       ladderMatchErrorRes.args.add(arg);
/*     */     }
/* 167 */     OnlineManager.getInstance().sendAtOnce(this.roleid, ladderMatchErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLadderMatchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */