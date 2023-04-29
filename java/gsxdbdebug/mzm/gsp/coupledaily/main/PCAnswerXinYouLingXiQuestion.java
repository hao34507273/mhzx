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
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.coupledaily.SAnswerXinYouLingXiResult;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CoupleQuestionInfo;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xtable.Role2coupledaily;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAnswerXinYouLingXiQuestion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long sessionId;
/*     */   private final int answer;
/*     */   private long leaderRoleId;
/*     */   private long partnerRoleId;
/*     */   
/*     */   public PCAnswerXinYouLingXiQuestion(long roleId, long sessionId, int answer)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.sessionId = sessionId;
/*  42 */     this.answer = answer;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!CoupleDailyManager.isCoupleDailySwitchOpen(this.roleId, "PCAnswerXinYouLingXiQuestion.processImp"))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  54 */     if (teamId == null)
/*     */     {
/*  56 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@not exist team id|role_id=%d|session_id=%d|answer=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.sessionId), Integer.valueOf(this.answer) }));
/*     */       
/*     */ 
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     List<Long> selectMembersRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  64 */     if (selectMembersRoleIdList.size() != 2)
/*     */     {
/*  66 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@select team size not equal 2|partner_role_id=%d|team_id=%d|team_size=%d", new Object[] { Long.valueOf(this.partnerRoleId), teamId, Integer.valueOf(selectMembersRoleIdList.size()) }));
/*     */       
/*     */ 
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     this.leaderRoleId = ((Long)selectMembersRoleIdList.get(0)).longValue();
/*  73 */     this.partnerRoleId = ((Long)selectMembersRoleIdList.get(1)).longValue();
/*     */     
/*     */ 
/*  76 */     if ((this.leaderRoleId != this.roleId) && (this.partnerRoleId != this.roleId))
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@team info changes|team_id=%d|leader_role_id=%d|partner_role_id=%d|role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/*  86 */     String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */     
/*     */ 
/*  89 */     lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */     
/*     */ 
/*  92 */     lock(xtable.Role2properties.getTable(), selectMembersRoleIdList);
/*     */     
/*  94 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 553, true, true))
/*     */     {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 100 */     if (teamInfo == null)
/*     */     {
/* 102 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@team not exist|leader_role_id=%d|partner_role_id=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), teamId }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 108 */     List<Long> memberList = teamInfo.getTeamMemberList();
/* 109 */     if (memberList.size() != 2)
/*     */     {
/* 111 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */       
/*     */ 
/*     */ 
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 128 */     long partnerMarriageRoleId = MarriageInterface.getMarriedRoleid(this.partnerRoleId, true);
/* 129 */     if (partnerMarriageRoleId != this.leaderRoleId)
/*     */     {
/* 131 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|partner_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(partnerMarriageRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 139 */     Session session = Session.getSession(this.sessionId);
/* 140 */     XinYouLingXiAnswerSession answerSession = null;
/* 141 */     if ((session instanceof XinYouLingXiAnswerSession))
/*     */     {
/* 143 */       answerSession = (XinYouLingXiAnswerSession)session;
/*     */     }
/* 145 */     if (answerSession == null)
/*     */     {
/* 147 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@session time out|leader_role_id=%d|partner_role_id=%d|session_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 152 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 156 */     if ((answerSession.getPartnerRoleId() != this.partnerRoleId) || (answerSession.getOwerId() != this.leaderRoleId))
/*     */     {
/* 158 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@session context not match|leader_role_id=%d|partner_role_id=%d|session_id=%d|session_leader_role_id=%d|session_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.sessionId), Long.valueOf(answerSession.getOwerId()), Long.valueOf(answerSession.getPartnerRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     Map<Long, String> mapRoleId2UserId = new HashMap();
/* 167 */     mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 168 */     mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 169 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */     
/* 171 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/* 173 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 179 */       return false;
/*     */     }
/* 181 */     Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */     
/* 183 */     if (xLeaderCoupleDailyInfo == null)
/*     */     {
/* 185 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 189 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 193 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 194 */     if (xPartnerCoupleDailyInfo == null)
/*     */     {
/* 196 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 204 */     long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */     
/* 206 */     if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */     {
/* 208 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 212 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 216 */     if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */     {
/* 218 */       GameServer.logger().info(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */       
/*     */ 
/*     */ 
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     List<TaskInfo> leaderTaskInfos = xLeaderCoupleDailyInfo.getTasklist();
/* 226 */     CoupleQuestionInfo xLeaderCoupleQuestionInfo = null;
/*     */     
/* 228 */     TaskInfo xLeaderTaskInfo = null;
/* 229 */     for (TaskInfo taskInfo : leaderTaskInfos)
/*     */     {
/* 231 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 0)
/*     */       {
/* 233 */         xLeaderCoupleQuestionInfo = xLeaderCoupleDailyInfo.getCouplequestioninfo();
/* 234 */         xLeaderTaskInfo = taskInfo;
/* 235 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 240 */     if (xLeaderCoupleQuestionInfo == null)
/*     */     {
/* 242 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@leader has no question task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 246 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 250 */     if (xLeaderTaskInfo.getIs_finish() == 1)
/*     */     {
/* 252 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@leader question task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderTaskInfo.getCfg_id()) }));
/*     */       
/*     */ 
/*     */ 
/* 256 */       return false;
/*     */     }
/*     */     
/* 259 */     List<TaskInfo> partnerTaskList = xPartnerCoupleDailyInfo.getTasklist();
/* 260 */     TaskInfo xPartnerTaskInfo = null;
/* 261 */     for (TaskInfo taskInfo : partnerTaskList)
/*     */     {
/* 263 */       if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 0)
/*     */       {
/* 265 */         xPartnerTaskInfo = taskInfo;
/* 266 */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 271 */     if (xPartnerTaskInfo == null)
/*     */     {
/* 273 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@partner has no question task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 277 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 281 */     if (xPartnerTaskInfo.getIs_finish() == 1)
/*     */     {
/* 283 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@partner question task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xPartnerTaskInfo.getCfg_id()) }));
/*     */       
/*     */ 
/*     */ 
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     int xLeaderNowQuestionProcess = xLeaderCoupleQuestionInfo.getCurrentquestionidx();
/* 291 */     int xPartnerNowQuestionProcess = xPartnerCoupleDailyInfo.getCouplequestioninfo().getCurrentquestionidx();
/* 292 */     if (xLeaderNowQuestionProcess != xPartnerNowQuestionProcess)
/*     */     {
/* 294 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@partner and leader question process not equal|leader_role_id=%d|partner_role_id=%d|leader_process=%d|partner_process=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderNowQuestionProcess), Integer.valueOf(xPartnerNowQuestionProcess) }));
/*     */       
/*     */ 
/*     */ 
/* 298 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 302 */     if (xLeaderNowQuestionProcess >= CoupleDailyActivityConst.getInstance().QUESTION_NUM - 1)
/*     */     {
/* 304 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@question aleary done over|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|current_index=%d|size=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderTaskInfo.getCfg_id()), Integer.valueOf(xLeaderCoupleQuestionInfo.getCurrentquestionidx()), Integer.valueOf(xLeaderCoupleQuestionInfo.getQuestionlist().size() - 1) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 310 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 314 */     if (this.roleId == this.leaderRoleId)
/*     */     {
/*     */ 
/* 317 */       if (!answerSession.setLeaderSelect(this.answer))
/*     */       {
/* 319 */         GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@leader has choose answer before|role_id=%d|leader_role_id=%d|partner_role_id=%d|answer=%d|session_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.answer), Long.valueOf(this.sessionId) }));
/*     */         
/*     */ 
/*     */ 
/* 323 */         return false;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 329 */     else if (!answerSession.setPartnerSelect(this.answer))
/*     */     {
/* 331 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@partner has choose answer before|role_id=%d|leader_role_id=%d|partner_role_id=%d|answer=%d|session_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.answer), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 335 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 340 */     boolean isCanAward = (answerSession.getPartnerSelect() != -1) && (answerSession.getLeaderSelect() != -1);
/*     */     
/*     */ 
/* 343 */     if (!isCanAward)
/*     */     {
/* 345 */       GameServer.logger().info(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@handle answer xin you ling xi req success|role_id=%d|leader_role_id=%d|partner_role_id=%d|answer=%d|session_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.answer), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 349 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 353 */     Session.removeSession(this.sessionId);
/*     */     
/*     */ 
/* 356 */     boolean isMatch = answerSession.getPartnerSelect() == answerSession.getLeaderSelect();
/* 357 */     SAnswerXinYouLingXiResult sAnswerXinYouLingXiResult = new SAnswerXinYouLingXiResult();
/* 358 */     sAnswerXinYouLingXiResult.ismatch = (isMatch ? 1 : 0);
/*     */     
/* 360 */     OnlineManager.getInstance().sendMulti(sAnswerXinYouLingXiResult, memberList);
/*     */     
/* 362 */     SCoupleDailyActivityCfg sCoupleDailyActivityCfg = SCoupleDailyActivityCfg.get(xLeaderTaskInfo.getCfg_id());
/* 363 */     int awardId = isMatch ? sCoupleDailyActivityCfg.successAwardId : sCoupleDailyActivityCfg.failAwardId;
/*     */     
/* 365 */     AwardModel leaderAwardModel = AwardInterface.award(awardId, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.XIN_YOU_LING_XI_AWARD));
/*     */     
/* 367 */     if (leaderAwardModel == null)
/*     */     {
/* 369 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@award leader error,AwardModel is null|leader_role_id=%d|partner_role_id=%d|answer=%d|session_id=%s", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.answer), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 373 */       return false;
/*     */     }
/*     */     
/* 376 */     AwardModel partnerAwardModel = AwardInterface.award(awardId, partnerUserId, this.partnerRoleId, false, true, new AwardReason(LogReason.XIN_YOU_LING_XI_AWARD));
/*     */     
/* 378 */     if (partnerAwardModel == null)
/*     */     {
/* 380 */       GameServer.logger().error(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@award partner error,AwardModel is null|leader_role_id=%d|partner_role_id=%d|answer=%d|session_id=%s", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.answer), Long.valueOf(this.sessionId) }));
/*     */       
/*     */ 
/*     */ 
/* 384 */       return false;
/*     */     }
/*     */     
/* 387 */     xLeaderCoupleQuestionInfo.setCurrentquestionidx(++xLeaderNowQuestionProcess);
/* 388 */     xPartnerCoupleDailyInfo.getCouplequestioninfo().setCurrentquestionidx(xLeaderNowQuestionProcess);
/*     */     
/* 390 */     if (xLeaderNowQuestionProcess >= CoupleDailyActivityConst.getInstance().QUESTION_NUM - 1)
/*     */     {
/* 392 */       new PUnSetCoupleDailyStatus(selectMembersRoleIdList).execute();
/*     */       
/*     */ 
/* 395 */       xLeaderTaskInfo.setIs_finish(1);
/* 396 */       xPartnerTaskInfo.setIs_finish(1);
/*     */       
/*     */ 
/* 399 */       CoupleDailyManager.sSyncCoupleDailyInfo(xLeaderCoupleDailyInfo, memberList);
/* 400 */       CoupleDailyManager.tlogCoupleDailyTaskResult(this.leaderRoleId, this.partnerRoleId, xLeaderTaskInfo.getCfg_id(), CoupleDailyTaskResultEnum.SUCCESS);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 405 */       int nextQuestionCfgId = ((Integer)xLeaderCoupleQuestionInfo.getQuestionlist().get(xLeaderNowQuestionProcess + 1)).intValue();
/*     */       
/* 407 */       new QuestionIntervaMillObserver(this.leaderRoleId, this.partnerRoleId, CoupleDailyActivityConst.getInstance().ANSWER_QUESTION_INTERVAL * 1000, nextQuestionCfgId);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 412 */     GameServer.logger().info(String.format("[coupledaily]PCAnswerXinYouLingXiQuestion.processImp@handle answer xin you ling xi req success,and award success|role_id=%d|leader_role_id=%d|partner_role_id=%d|answer=%d|session_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.answer), Long.valueOf(this.sessionId) }));
/*     */     
/*     */ 
/*     */ 
/* 416 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PCAnswerXinYouLingXiQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */