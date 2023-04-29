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
/*     */ class XinYouLingXiAnswerSession extends Session
/*     */ {
/*     */   public static final int UN_SELECTOR = -1;
/*     */   private final long partnerRoleId;
/*     */   private final long sessionStartTime;
/*  35 */   private int leaderSelect = -1;
/*  36 */   private int partnerSelect = -1;
/*     */   
/*     */ 
/*     */   public XinYouLingXiAnswerSession(long interval, long roleId, long partnerRoleId, long sessionStartTime)
/*     */   {
/*  41 */     super(interval, roleId);
/*  42 */     this.partnerRoleId = partnerRoleId;
/*  43 */     this.sessionStartTime = sessionStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  49 */     PXinYouLingXiTimeOut pXinYouLingXiTimeOut = new PXinYouLingXiTimeOut(getOwerId(), this.partnerRoleId, this);
/*  50 */     pXinYouLingXiTimeOut.execute();
/*     */   }
/*     */   
/*     */   public int getLeaderSelect()
/*     */   {
/*  55 */     return this.leaderSelect;
/*     */   }
/*     */   
/*     */   public boolean setLeaderSelect(int leaderSelect)
/*     */   {
/*  60 */     if (this.leaderSelect != -1) {
/*  61 */       return false;
/*     */     }
/*  63 */     this.leaderSelect = leaderSelect;
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public int getPartnerSelect()
/*     */   {
/*  69 */     return this.partnerSelect;
/*     */   }
/*     */   
/*     */   public boolean setPartnerSelect(int partnerSelect)
/*     */   {
/*  74 */     if (this.partnerSelect != -1) {
/*  75 */       return false;
/*     */     }
/*  77 */     this.partnerSelect = partnerSelect;
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   public long getPartnerRoleId()
/*     */   {
/*  83 */     return this.partnerRoleId;
/*     */   }
/*     */   
/*     */   public long getSessionStartTime()
/*     */   {
/*  88 */     return this.sessionStartTime;
/*     */   }
/*     */   
/*     */ 
/*     */   static class PXinYouLingXiTimeOut
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long leaderRoleId;
/*     */     
/*     */     private final long partnerRoleId;
/*     */     
/*     */     private final XinYouLingXiAnswerSession answerSession;
/*     */     
/*     */ 
/*     */     public PXinYouLingXiTimeOut(long leaderRoleId, long partnerRoleId, XinYouLingXiAnswerSession answerSession)
/*     */     {
/* 104 */       this.leaderRoleId = leaderRoleId;
/* 105 */       this.partnerRoleId = partnerRoleId;
/* 106 */       this.answerSession = answerSession;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 112 */       Long teamId = TeamInterface.getTeamidByRoleid(this.leaderRoleId, false);
/* 113 */       if (teamId == null)
/*     */       {
/* 115 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@not exist team id|leader_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 119 */         return false;
/*     */       }
/*     */       
/* 122 */       String leaderUserId = RoleInterface.getUserId(this.leaderRoleId);
/* 123 */       String partnerUserId = RoleInterface.getUserId(this.partnerRoleId);
/*     */       
/*     */ 
/* 126 */       lock(User.getTable(), Arrays.asList(new String[] { leaderUserId, partnerUserId }));
/*     */       
/* 128 */       List<Long> roleIdList = Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) });
/*     */       
/*     */ 
/* 131 */       lock(xtable.Role2properties.getTable(), roleIdList);
/*     */       
/* 133 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*     */       
/* 135 */       List<Long> memberList = teamInfo.getTeamMemberList();
/* 136 */       if (memberList.size() != 2)
/*     */       {
/* 138 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@team size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(memberList.size()), teamId }));
/*     */         
/*     */ 
/*     */ 
/* 142 */         return false;
/*     */       }
/*     */       
/* 145 */       if (teamInfo.getTeamNormalList().size() != 2)
/*     */       {
/* 147 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@team normal size not equal 2|leader_role_id=%d|team_size=%d|team_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Integer.valueOf(teamInfo.getTeamNormalList().size()), teamId }));
/*     */         
/*     */ 
/*     */ 
/* 151 */         return false;
/*     */       }
/*     */       
/* 154 */       if ((this.leaderRoleId != ((Long)memberList.get(0)).longValue()) || (this.partnerRoleId != ((Long)memberList.get(1)).longValue()))
/*     */       {
/* 156 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@team info changes|team_id=%d|select_leader_role_id=%d|select_partner_role_id=%d|get_leader_role_id=%d|get_partner_role_id=%d", new Object[] { teamId, Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), memberList.get(0), memberList.get(1) }));
/*     */         
/*     */ 
/*     */ 
/* 160 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 164 */       long partnerMarriageRoleId = MarriageInterface.getMarriedRoleid(this.partnerRoleId, true);
/* 165 */       if (partnerMarriageRoleId != this.leaderRoleId)
/*     */       {
/* 167 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@marriage info not match|leader_role_id=%d|partner_role_id=%d|partner_marriage_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(partnerMarriageRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 171 */         return false;
/*     */       }
/*     */       
/* 174 */       Map<Long, String> mapRoleId2UserId = new HashMap();
/* 175 */       mapRoleId2UserId.put(Long.valueOf(this.partnerRoleId), partnerUserId);
/* 176 */       mapRoleId2UserId.put(Long.valueOf(this.leaderRoleId), leaderUserId);
/* 177 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(mapRoleId2UserId, memberList, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/*     */       
/* 179 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/* 181 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@activity can not join|leader_role_id=%d|partner_role_id=%d|reason=%d|role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(activityJoinResult.getReasonValue()), Long.valueOf(activityJoinResult.getRoleId()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 187 */         return false;
/*     */       }
/* 189 */       Role2CoupleDailyInfo xLeaderCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.leaderRoleId));
/*     */       
/* 191 */       if (xLeaderCoupleDailyInfo == null)
/*     */       {
/* 193 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@leader couple daily info is null|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 197 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 201 */       Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.partnerRoleId));
/* 202 */       if (xPartnerCoupleDailyInfo == null)
/*     */       {
/* 204 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@partner couple daily info is null|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 208 */         return false;
/*     */       }
/*     */       
/* 211 */       long xLeaderCoupleDailyPartnerId = xLeaderCoupleDailyInfo.getPartnerroleid();
/* 212 */       long xPartnerCoupleDailyPartnerId = xPartnerCoupleDailyInfo.getPartnerroleid();
/*     */       
/* 214 */       if ((xLeaderCoupleDailyPartnerId == 0L) && (xPartnerCoupleDailyPartnerId == 0L))
/*     */       {
/* 216 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@leader and partner data all empty|partner_role_id=%d|leader_role_id=%d", new Object[] { Long.valueOf(this.partnerRoleId), Long.valueOf(this.leaderRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 220 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 224 */       if ((xLeaderCoupleDailyPartnerId != this.partnerRoleId) || (xPartnerCoupleDailyPartnerId != this.leaderRoleId))
/*     */       {
/* 226 */         GameServer.logger().info(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@partner id not match|leader_role_id=%d|leader_partner_role_id=%d|partner_role_id=%d|partner_partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(xLeaderCoupleDailyPartnerId), Long.valueOf(this.partnerRoleId), Long.valueOf(xPartnerCoupleDailyPartnerId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 231 */         return false;
/*     */       }
/*     */       
/* 234 */       List<TaskInfo> leaderTaskInfos = xLeaderCoupleDailyInfo.getTasklist();
/* 235 */       CoupleQuestionInfo xLeaderCoupleQuestionInfo = null;
/* 236 */       TaskInfo xLeaderTaskInfo = null;
/* 237 */       for (TaskInfo taskInfo : leaderTaskInfos)
/*     */       {
/* 239 */         if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 0)
/*     */         {
/* 241 */           xLeaderCoupleQuestionInfo = xLeaderCoupleDailyInfo.getCouplequestioninfo();
/* 242 */           xLeaderTaskInfo = taskInfo;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 247 */       if (xLeaderCoupleQuestionInfo == null)
/*     */       {
/* 249 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@leader has no question task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 253 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 257 */       if (xLeaderTaskInfo.getIs_finish() == 1)
/*     */       {
/* 259 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@question task aleardy done|leader_role_id=%d|partner_role_id=%d|cfg_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderTaskInfo.getCfg_id()) }));
/*     */         
/*     */ 
/*     */ 
/* 263 */         return false;
/*     */       }
/* 265 */       List<TaskInfo> xPartnerTaskList = xPartnerCoupleDailyInfo.getTasklist();
/* 266 */       TaskInfo xPartnerTaskInfo = null;
/* 267 */       for (TaskInfo taskInfo : xPartnerTaskList)
/*     */       {
/* 269 */         if (SCoupleDailyActivityCfg.get(taskInfo.getCfg_id()).taskType == 0)
/*     */         {
/* 271 */           xPartnerTaskInfo = taskInfo;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 276 */       if (xPartnerTaskInfo == null)
/*     */       {
/* 278 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@partner has no question task|leader_role_id=%d|partner_role_id=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */         
/*     */ 
/*     */ 
/* 282 */         return false;
/*     */       }
/*     */       
/* 285 */       int xNowQuestionProcess = xLeaderCoupleQuestionInfo.getCurrentquestionidx();
/*     */       
/* 287 */       if (xNowQuestionProcess >= xLeaderCoupleQuestionInfo.getQuestionlist().size() - 1)
/*     */       {
/* 289 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@question aleary done over|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|current_index=%d|size=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderTaskInfo.getCfg_id()), Integer.valueOf(xLeaderCoupleQuestionInfo.getCurrentquestionidx()), Integer.valueOf(xLeaderCoupleQuestionInfo.getQuestionlist().size()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 295 */         return false;
/*     */       }
/*     */       
/* 298 */       if ((this.answerSession.getLeaderSelect() != -1) && (this.answerSession.getPartnerSelect() != -1))
/*     */       {
/* 300 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@question aleary done over|leader_role_id=%d|partner_role_id=%d|cfg_id=%d|current_index=%d|size=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(xLeaderTaskInfo.getCfg_id()), Integer.valueOf(xLeaderCoupleQuestionInfo.getCurrentquestionidx()), Integer.valueOf(xLeaderCoupleQuestionInfo.getQuestionlist().size()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 306 */         return false;
/*     */       }
/*     */       
/* 309 */       Session.removeSession(this.answerSession.getSessionId());
/*     */       
/* 311 */       long activityStartTime = ActivityInterface.getActivityStartTime(CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID);
/* 312 */       if (this.answerSession.getSessionStartTime() <= activityStartTime)
/*     */       {
/* 314 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@not today's session question|leader_role_id=%d|partner_role_id=%d|session_id=%d|session_start_time=%d|activity_start_time=%d", new Object[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId), Long.valueOf(this.answerSession.getSessionId()), Long.valueOf(this.answerSession.getSessionStartTime()), Long.valueOf(activityStartTime) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 319 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 323 */       SAnswerXinYouLingXiResult sAnswerXinYouLingXiResult = new SAnswerXinYouLingXiResult();
/* 324 */       sAnswerXinYouLingXiResult.ismatch = 0;
/*     */       
/* 326 */       OnlineManager.getInstance().sendMulti(sAnswerXinYouLingXiResult, Arrays.asList(new Long[] { Long.valueOf(this.leaderRoleId), Long.valueOf(this.partnerRoleId) }));
/*     */       
/*     */ 
/* 329 */       SCoupleDailyActivityCfg sCoupleDailyActivityCfg = SCoupleDailyActivityCfg.get(xLeaderTaskInfo.getCfg_id());
/*     */       
/* 331 */       AwardModel leaderAwardModel = AwardInterface.award(sCoupleDailyActivityCfg.failAwardId, leaderUserId, this.leaderRoleId, false, true, new AwardReason(LogReason.XIN_YOU_LING_XI_AWARD));
/*     */       
/* 333 */       if (leaderAwardModel == null)
/*     */       {
/* 335 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@award leader error,AwardModel is null|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(sCoupleDailyActivityCfg.failAwardId) }));
/*     */         
/*     */ 
/*     */ 
/* 339 */         return false;
/*     */       }
/*     */       
/* 342 */       AwardModel partnerAwardModel = AwardInterface.award(sCoupleDailyActivityCfg.failAwardId, partnerUserId, this.partnerRoleId, false, true, new AwardReason(LogReason.XIN_YOU_LING_XI_AWARD));
/*     */       
/* 344 */       if (partnerAwardModel == null)
/*     */       {
/* 346 */         GameServer.logger().error(String.format("[coupledaily]XinYouLingXiAnswerSession.PXinYouLingXiTimeOut.processImp@award partner error,AwardModel is null|leader_user_id=%s|leader_role_id=%d|partner_user_id=%s|partner_role_id=%d|award_id=%d", new Object[] { leaderUserId, Long.valueOf(this.leaderRoleId), partnerUserId, Long.valueOf(this.partnerRoleId), Integer.valueOf(sCoupleDailyActivityCfg.failAwardId) }));
/*     */         
/*     */ 
/*     */ 
/* 350 */         return false;
/*     */       }
/*     */       
/* 353 */       xLeaderCoupleQuestionInfo.setCurrentquestionidx(++xNowQuestionProcess);
/* 354 */       xPartnerCoupleDailyInfo.getCouplequestioninfo().setCurrentquestionidx(xNowQuestionProcess);
/* 355 */       if (xNowQuestionProcess >= CoupleDailyActivityConst.getInstance().QUESTION_NUM - 1)
/*     */       {
/* 357 */         new PUnSetCoupleDailyStatus(roleIdList).execute();
/*     */         
/*     */ 
/* 360 */         xLeaderTaskInfo.setIs_finish(1);
/* 361 */         xPartnerTaskInfo.setIs_finish(1);
/*     */         
/*     */ 
/* 364 */         CoupleDailyManager.sSyncCoupleDailyInfo(xLeaderCoupleDailyInfo, memberList);
/* 365 */         CoupleDailyManager.tlogCoupleDailyTaskResult(this.leaderRoleId, this.partnerRoleId, xLeaderTaskInfo.getCfg_id(), CoupleDailyTaskResultEnum.SUCCESS);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 370 */         int nextQuestionCfgId = ((Integer)xLeaderCoupleQuestionInfo.getQuestionlist().get(xNowQuestionProcess + 1)).intValue();
/*     */         
/* 372 */         new QuestionIntervaMillObserver(this.leaderRoleId, this.partnerRoleId, CoupleDailyActivityConst.getInstance().ANSWER_QUESTION_INTERVAL * 1000, nextQuestionCfgId);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 377 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\XinYouLingXiAnswerSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */