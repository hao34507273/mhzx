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
/*     */ import mzm.gsp.ladder.SLadderReadyErrorRes;
/*     */ import mzm.gsp.ladder.SLadderReadyRes;
/*     */ import mzm.gsp.ladder.confbean.SLadderConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCLadderReadyReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCLadderReadyReq(long roleid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if (!OpenInterface.getOpenStatus(188)) {
/*  35 */       return false;
/*     */     }
/*  37 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  38 */     Long seasonStartTime = LadderManager.getBeforeSessionTimeMilSec(curTime);
/*  39 */     if (seasonStartTime == null) {
/*  40 */       sendErrorRes(7, new String[0]);
/*  41 */       GameServer.logger().info(String.format("[Ladder]PCLadderMatchReq.processImp@do not has season data!|curTime=%d", new Object[] { Long.valueOf(curTime) }));
/*     */       
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  47 */     if (teamid == null) {
/*  48 */       sendErrorRes(3, new String[0]);
/*  49 */       return false;
/*     */     }
/*  51 */     List<Long> memberList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*  52 */     if (memberList.size() <= 0) {
/*  53 */       sendErrorRes(3, new String[0]);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!memberList.contains(Long.valueOf(this.roleid))) {
/*  57 */       sendErrorRes(3, new String[0]);
/*  58 */       return false;
/*     */     }
/*  60 */     Map<Long, String> role2UserMap = new HashMap();
/*  61 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  62 */       String userid = RoleInterface.getUserId(roleid);
/*  63 */       role2UserMap.put(Long.valueOf(roleid), userid);
/*     */     }
/*  65 */     lock(User.getTable(), role2UserMap.values());
/*  66 */     lock(xtable.Role2properties.getTable(), memberList);
/*  67 */     List<Long> trulyMemberList = TeamInterface.getTeamMemberList(teamid.longValue(), true);
/*  68 */     if ((trulyMemberList.size() != memberList.size()) || (!memberList.containsAll(trulyMemberList))) {
/*  69 */       sendErrorRes(6, new String[0]);
/*  70 */       return false;
/*     */     }
/*  72 */     List<Long> normalList = TeamInterface.getNormalRoleList(this.roleid);
/*     */     
/*  74 */     if (!normalList.contains(Long.valueOf(this.roleid))) {
/*  75 */       GameServer.logger().info(String.format("[Ladder]LadderManager.processImp@is not in normal status|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  77 */       return false;
/*     */     }
/*  79 */     Set<Integer> statuses = RoleStatusInterface.getStatusSet(this.roleid);
/*  80 */     if (statuses.contains(Integer.valueOf(42))) {
/*  81 */       sendErrorRes(4, new String[0]);
/*  82 */       return false;
/*     */     }
/*  84 */     if (statuses.contains(Integer.valueOf(43))) {
/*  85 */       sendErrorRes(5, new String[0]);
/*  86 */       return false;
/*     */     }
/*  88 */     for (Iterator i$ = memberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  89 */       if (OpenInterface.isBanPlay(roleid, 188)) {
/*  90 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 188);
/*     */         
/*  92 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(role2UserMap, trulyMemberList, SLadderConsts.getInstance().activityid);
/*     */     
/* 122 */     if (activityJoinResult.isActivityNotOpen()) {
/* 123 */       GameServer.logger().info(String.format("[Ladder]PCLadderReadyReq.processImp@activity is not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/* 125 */       return false;
/*     */     }
/* 127 */     if (activityJoinResult.isRoleLevelWrong()) {
/* 128 */       GameServer.logger().info(String.format("[Ladder]PCLadderReadyReq.processImp@level is not suit|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/* 130 */       return false;
/*     */     }
/* 132 */     boolean ret = RoleStatusInterface.setStatus(this.roleid, 43, true);
/* 133 */     if (!ret) {
/* 134 */       return false;
/*     */     }
/* 136 */     SLadderReadyRes ladderReadyRes = new SLadderReadyRes();
/* 137 */     ladderReadyRes.roleid = this.roleid;
/* 138 */     OnlineManager.getInstance().sendMulti(ladderReadyRes, memberList);
/* 139 */     GameServer.logger().info(String.format("[Ladder]PCLadderReadyReq.processImp@excute ready success|roleid=%d|roleids=%s", new Object[] { Long.valueOf(this.roleid), memberList }));
/*     */     
/*     */ 
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int errorCode, String... args) {
/* 146 */     SLadderReadyErrorRes ladderReadyErrorRes = new SLadderReadyErrorRes();
/* 147 */     ladderReadyErrorRes.ret = errorCode;
/* 148 */     for (String arg : args) {
/* 149 */       ladderReadyErrorRes.args.add(arg);
/*     */     }
/* 151 */     OnlineManager.getInstance().sendAtOnce(this.roleid, ladderReadyErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PCLadderReadyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */