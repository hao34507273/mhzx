/*     */ package mzm.gsp.coupledaily.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.coupledaily.SAgreeOrRefusePinTu;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAgreeOrRefusePinTu extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long partnerRoleId;
/*     */   private final long sessionId;
/*     */   private final int operator;
/*     */   public long leaderRoleId;
/*     */   
/*     */   public PCAgreeOrRefusePinTu(long partnerRoleId, long sessionId, int operator)
/*     */   {
/*  35 */     this.partnerRoleId = partnerRoleId;
/*  36 */     this.sessionId = sessionId;
/*  37 */     this.operator = operator;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if ((this.operator != 1) && (this.operator != 0))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.partnerRoleId, "PCAgreeOrRefusePinTu.processImp"))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     Long teamId = TeamInterface.getTeamidByRoleid(this.partnerRoleId, false);
/*  54 */     if (teamId == null)
/*     */     {
/*  56 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@not exist team id|partner_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  64 */     if (selectMembers.size() != 2)
/*     */     {
/*  66 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@select team size not equal 2|partner_role_id=%d|team_id=%d|team_size=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.partnerRoleId), teamId, Integer.valueOf(selectMembers.size()), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     this.leaderRoleId = ((Long)selectMembers.get(0)).longValue();
/*  73 */     if (this.partnerRoleId != ((Long)selectMembers.get(1)).longValue())
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@partner role id not match|team_id=%d|partner_role_id=%d|team_1_role_id=%d|session_id=%d|operator=%d", new Object[] { teamId, Long.valueOf(this.partnerRoleId), selectMembers.get(1), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  83 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  86 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  89 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*  91 */     if (!RoleStatusInterface.checkCanSetStatus(this.partnerRoleId, 551, true, true))
/*     */     {
/*     */ 
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     Session session = Session.getSession(this.sessionId);
/*  98 */     PinTuPrepareSession pinTuPrepareSession = null;
/*  99 */     if ((session instanceof PinTuPrepareSession))
/*     */     {
/* 101 */       pinTuPrepareSession = (PinTuPrepareSession)session;
/*     */     }
/* 103 */     if (pinTuPrepareSession == null)
/*     */     {
/* 105 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@session time out|leader_role_id=%d|partner_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     Session.removeSession(this.sessionId);
/*     */     
/*     */ 
/* 116 */     if ((pinTuPrepareSession.getPartnerRoleId() != this.partnerRoleId) || (pinTuPrepareSession.getOwerId() != this.leaderRoleId))
/*     */     {
/*     */ 
/* 119 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@session context not mathc|leader_role_id=%d|partner_role_id=%d|session_id=%d|session_partner_role_id=%d|session_leader_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Long.valueOf(pinTuPrepareSession.getPartnerRoleId()), Long.valueOf(pinTuPrepareSession.getOwerId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 129 */     if (teamInfo == null)
/*     */     {
/* 131 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 139 */     if (memberList.size() != 2)
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 150 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     long partnerMarriageRoleId = MarriageInterface.getMarriedRoleid(this.partnerRoleId, true);
/* 159 */     if (partnerMarriageRoleId != this.leaderRoleId)
/*     */     {
/* 161 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|partner_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(partnerMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 169 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 170 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 171 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 173 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 175 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 181 */       return false;
/*     */     }
/* 183 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 185 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 187 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 191 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 195 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 196 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 198 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 206 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 208 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 210 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 214 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 218 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 220 */       GameServer.logger().info(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 224 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 228 */     List<TaskInfo> xleaderTaskList = xLeaderCoupleDailyInfo.getTasklist();
/* 229 */     TaskInfo xLeaderPinTuTaskInfo = null;
/* 230 */     for (TaskInfo taskInfo : xleaderTaskList)
/*     */     {
/* 232 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 1)
/*     */       {
/* 234 */         xLeaderPinTuTaskInfo = taskInfo;
/* 235 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 240 */     if (xLeaderPinTuTaskInfo == null)
/*     */     {
/* 242 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@leader has no pin tu task|leader_role_id=%d|partner_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/* 246 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 250 */     if (xLeaderPinTuTaskInfo.getIs_finish() == 1)
/*     */     {
/* 252 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@leader pin tu task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderPinTuTaskInfo.getCfg_id()), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 257 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 261 */     List<TaskInfo> xPartnerTaskList = xPartnerCoupleDailyInfo.getTasklist();
/* 262 */     TaskInfo xPartnerPinTuTaskInfo = null;
/* 263 */     for (TaskInfo taskInfo : xPartnerTaskList)
/*     */     {
/* 265 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 1)
/*     */       {
/* 267 */         xPartnerPinTuTaskInfo = taskInfo;
/* 268 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 273 */     if (xPartnerPinTuTaskInfo == null)
/*     */     {
/* 275 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@partner has no pin tu task|leader_role_id=%d|partner_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/* 279 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 283 */     if (xPartnerPinTuTaskInfo.getIs_finish() == 1)
/*     */     {
/* 285 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@partner pin tu task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xPartnerPinTuTaskInfo.getCfg_id()), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 290 */       return false;
/*     */     }
/*     */     
/* 293 */     SAgreeOrRefusePinTu sAgreeOrRefusePinTu = new SAgreeOrRefusePinTu();
/* 294 */     sAgreeOrRefusePinTu.memberroleid = this.partnerRoleId;
/* 295 */     sAgreeOrRefusePinTu.memberrolename = RoleInterface.getName(this.partnerRoleId);
/* 296 */     sAgreeOrRefusePinTu.operator = this.operator;
/*     */     
/*     */ 
/* 299 */     OnlineManager.getInstance().send(this.leaderRoleId, sAgreeOrRefusePinTu);
/*     */     
/*     */ 
/* 302 */     if (this.operator == 1)
/*     */     {
/* 304 */       List<Long> roleIdList = Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) });
/*     */       
/* 306 */       RoleStatusInterface.setStatus(roleIdList, 558, true);
/* 307 */       RoleStatusInterface.setStatus(roleIdList, 559, true);
/*     */       
/* 309 */       int randomPinTuCfgId = CoupleDailyManager.getRandomPinTuCfgId();
/* 310 */       mzm.gsp.paraselene.main.JigsawInterface.startJigsaw(memberList, randomPinTuCfgId, new CoupleDailyJigsawContext(this.leaderRoleId, this.partnerRoleId, xPartnerPinTuTaskInfo.getCfg_id()));
/*     */     }
/*     */     
/*     */ 
/* 314 */     GameServer.logger().info(String.format("[coupledaily]PCAgreeOrRefusePinTu.processImp@handle agree or refuse pin tu req success|leader_role_id=%d|partner_role_id=%d|session_id=%d|operator=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Integer.valueOf(this.operator) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 319 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCAgreeOrRefusePinTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */