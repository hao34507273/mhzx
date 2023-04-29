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
/*     */ import mzm.gsp.coupledaily.SAgreeOrRefuseXinYouLingXi;
/*     */ import mzm.gsp.coupledaily.SXinYouLingXiQuestionInfo;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CoupleQuestionInfo;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAgreeOrRefuseXinYouLingXi extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long partnerRoleId;
/*     */   private final int operator;
/*     */   private final long sessionId;
/*     */   private long leaderRoleId;
/*     */   
/*     */   public PCAgreeOrRefuseXinYouLingXi(long partnerRoleId, int operator, long sessionId)
/*     */   {
/*  37 */     this.partnerRoleId = partnerRoleId;
/*  38 */     this.operator = operator;
/*  39 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((this.operator != 1) && (this.operator != 0))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.partnerRoleId, "PCAgreeOrRefuseXinYouLingXi.processImp"))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     Long teamId = TeamInterface.getTeamidByRoleid(this.partnerRoleId, false);
/*  56 */     if (teamId == null)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@not exist team id|partner_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  65 */     if (selectMembers.size() != 2)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@select team size not equal 2|partner_role_id=%d|team_id=%d|team_size=%d", new Object[] { Long.valueOf(this.partnerRoleId), teamId, Integer.valueOf(selectMembers.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  71 */       return false;
/*     */     }
/*  73 */     this.leaderRoleId = ((Long)selectMembers.get(0)).longValue();
/*  74 */     if (this.partnerRoleId != ((Long)selectMembers.get(1)).longValue())
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@partner role id not match|team_id=%d|partner_role_id=%d|team_1_role_id=%d", new Object[] { teamId, Long.valueOf(this.partnerRoleId), selectMembers.get(1) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  84 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  87 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  90 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */     
/*  92 */     if (!RoleStatusInterface.checkCanSetStatus(this.partnerRoleId, 552, true, true))
/*     */     {
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     Session session = Session.getSession(this.sessionId);
/*  99 */     XinYouLingXiPrepareSession xinYouLingXiPrepareSession = null;
/* 100 */     if ((session instanceof XinYouLingXiPrepareSession))
/*     */     {
/* 102 */       xinYouLingXiPrepareSession = (XinYouLingXiPrepareSession)session;
/*     */     }
/* 104 */     if (xinYouLingXiPrepareSession == null)
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@session time out|leader_role_id=%d|partner_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     Session.removeSession(this.sessionId);
/*     */     
/*     */ 
/* 117 */     if (xinYouLingXiPrepareSession.getPartnerRoleId() != this.partnerRoleId)
/*     */     {
/* 119 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@session context not mathc|leader_role_id=%d|partner_role_id=%d|session_id=%d|session_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Long.valueOf(xinYouLingXiPrepareSession.getPartnerRoleId()) }));
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
/* 131 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 139 */     if (memberList.size() != 2)
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 150 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
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
/* 161 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|partner_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(partnerMarriageRoleId) }));
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
/* 175 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
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
/* 187 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
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
/* 198 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
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
/* 210 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 214 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 218 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 220 */       GameServer.logger().info(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     List<TaskInfo> xLeaderTaskList = xLeaderCoupleDailyInfo.getTasklist();
/* 228 */     CoupleQuestionInfo xLeaderCoupleQuestionInfo = null;
/* 229 */     TaskInfo xLeaderQuestionTaskInfo = null;
/* 230 */     for (TaskInfo taskInfo : xLeaderTaskList)
/*     */     {
/* 232 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 0)
/*     */       {
/* 234 */         xLeaderCoupleQuestionInfo = xLeaderCoupleDailyInfo.getCouplequestioninfo();
/* 235 */         xLeaderQuestionTaskInfo = taskInfo;
/* 236 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 241 */     if (xLeaderCoupleQuestionInfo == null)
/*     */     {
/* 243 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@couple has no question task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 247 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 251 */     if (xLeaderQuestionTaskInfo.getIs_finish() == 1)
/*     */     {
/* 253 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@question task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderQuestionTaskInfo.getCfg_id()) }));
/*     */       
/*     */ 
/*     */ 
/* 257 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 261 */     if (xLeaderCoupleQuestionInfo.getCurrentquestionidx() >= xLeaderCoupleQuestionInfo.getQuestionlist().size() - 1)
/*     */     {
/* 263 */       GameServer.logger().error(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@question aleary done over|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|current_index=%d|size=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderQuestionTaskInfo.getCfg_id()), Integer.valueOf(xLeaderCoupleQuestionInfo.getCurrentquestionidx()), Integer.valueOf(xLeaderCoupleQuestionInfo.getQuestionlist().size() - 1) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 269 */       return false;
/*     */     }
/*     */     
/* 272 */     if (this.operator == 1)
/*     */     {
/* 274 */       List<Long> roleIdList = Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) });
/*     */       
/* 276 */       RoleStatusInterface.setStatus(roleIdList, 558, true);
/*     */       
/* 278 */       SXinYouLingXiQuestionInfo sXinYouLingXiQuestionInfo = new SXinYouLingXiQuestionInfo();
/* 279 */       long sessionId = new XinYouLingXiAnswerSession(CoupleDailyActivityConst.getInstance().WAIT_COUPLE_ANSWER_TIME, this.leaderRoleId, this.partnerRoleId, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()).getSessionId();
/*     */       
/*     */ 
/*     */ 
/* 283 */       sXinYouLingXiQuestionInfo.questioncfgid = ((Integer)xLeaderCoupleQuestionInfo.getQuestionlist().get(xLeaderCoupleQuestionInfo.getCurrentquestionidx() + 1)).intValue();
/*     */       
/* 285 */       sXinYouLingXiQuestionInfo.sessionid = sessionId;
/* 286 */       OnlineManager.getInstance().sendMulti(sXinYouLingXiQuestionInfo, memberList);
/* 287 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 291 */     SAgreeOrRefuseXinYouLingXi sAgreeOrRefuseXinYouLingXi = new SAgreeOrRefuseXinYouLingXi();
/* 292 */     sAgreeOrRefuseXinYouLingXi.memberroleid = this.partnerRoleId;
/* 293 */     sAgreeOrRefuseXinYouLingXi.memberrolename = RoleInterface.getName(this.partnerRoleId);
/* 294 */     sAgreeOrRefuseXinYouLingXi.operator = this.operator;
/*     */     
/* 296 */     OnlineManager.getInstance().send(this.leaderRoleId, sAgreeOrRefuseXinYouLingXi);
/*     */     
/* 298 */     GameServer.logger().info(String.format("[coupledaily]PCAgreeOrRefuseXinYouLingXi.processImp@handle success|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|current_index=%d|size=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderQuestionTaskInfo.getCfg_id()), Integer.valueOf(xLeaderCoupleQuestionInfo.getCurrentquestionidx()), Integer.valueOf(xLeaderCoupleQuestionInfo.getQuestionlist().size()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 303 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCAgreeOrRefuseXinYouLingXi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */