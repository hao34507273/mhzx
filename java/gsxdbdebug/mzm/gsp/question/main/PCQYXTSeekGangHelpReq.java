/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gang.SSyncGangHelp;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.SQYXTSeekGangHelpRsp;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QYXTQuestionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2qyxtquestion;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCQYXTSeekGangHelpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int questionCfgId;
/*     */   
/*     */   public PCQYXTSeekGangHelpReq(long roleId, int questionCfgId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.questionCfgId = questionCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!QYXTQuestionActivity.checkMutexStatus(this.roleId))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     String userId = RoleInterface.getUserId(this.roleId);
/*  42 */     lock(Lockeys.get(User.getTable(), userId));
/*  43 */     lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  45 */     long gangId = GangInterface.getGangId(this.roleId);
/*  46 */     if (gangId <= 0L)
/*     */     {
/*     */ 
/*  49 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@role not has gang|role_id=%d|question_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID);
/*     */     
/*  58 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@activity can not join|role_id=%d|question_cfg_id=%d|reason_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     QYXTQuestionInfo xQyxtQuestionInfo = Role2qyxtquestion.get(Long.valueOf(this.roleId));
/*     */     
/*  69 */     if (xQyxtQuestionInfo == null)
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@role qyxt question info is null|role_id=%d|question_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!xQyxtQuestionInfo.getQuestions().contains(Integer.valueOf(this.questionCfgId)))
/*     */     {
/*     */ 
/*  81 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@qustion id is wrong|role_id=%d|question_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId) }));
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     int hasAnswerNum = ActivityInterface.getActivityCount(userId, this.roleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID, true);
/*     */     
/*  89 */     int totalCount = ActivityInterface.getActivityCfg(SQYXTQuestionConst.getInstance().ACTIVITY_ID).count;
/*  90 */     if (hasAnswerNum >= totalCount)
/*     */     {
/*     */ 
/*  93 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@no question times left|role_id=%d|question_cfg_id=%d|has_answer_num=%d|total_count=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId), Integer.valueOf(hasAnswerNum), Integer.valueOf(totalCount) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     Set<Integer> xSeekHelpQuestionSet = xQyxtQuestionInfo.getSeek_help_questions();
/* 101 */     int hasSeekHelpTimes = xSeekHelpQuestionSet.size();
/* 102 */     int seekHelpTimesLimit = SQYXTQuestionConst.getInstance().maxSeekHelpTimes;
/* 103 */     if (hasSeekHelpTimes >= seekHelpTimesLimit)
/*     */     {
/*     */ 
/* 106 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@no seek gang help times left|role_id=%d|question_cfg_id=%d|has_seek_help_times=%d|total_seek_help_times_limit=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId), Integer.valueOf(hasSeekHelpTimes), Integer.valueOf(seekHelpTimesLimit) }));
/*     */       
/*     */ 
/*     */ 
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     if (xSeekHelpQuestionSet.contains(Integer.valueOf(this.questionCfgId)))
/*     */     {
/*     */ 
/* 116 */       GameServer.logger().error(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@current question have seek help|role_id=%d|question_cfg_id=%d|seek_help_question_set=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId), xSeekHelpQuestionSet.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 120 */       return false;
/*     */     }
/* 122 */     SQYXTSeekGangHelpRsp sQyxtSeekGangHelpRsp = new SQYXTSeekGangHelpRsp();
/* 123 */     sQyxtSeekGangHelpRsp.useganghelptimes = (hasSeekHelpTimes + 1);
/*     */     
/* 125 */     xSeekHelpQuestionSet.add(Integer.valueOf(this.questionCfgId));
/*     */     
/* 127 */     OnlineManager.getInstance().send(this.roleId, sQyxtSeekGangHelpRsp);
/*     */     
/* 129 */     SSyncGangHelp sSyncGangHelp = new SSyncGangHelp();
/* 130 */     sSyncGangHelp.helpertype = 3;
/* 131 */     sSyncGangHelp.paramlong.put(Integer.valueOf(14), Long.valueOf(this.roleId));
/* 132 */     sSyncGangHelp.paramint.put(Integer.valueOf(15), Integer.valueOf(this.questionCfgId));
/* 133 */     GangInterface.brocastInGang(sSyncGangHelp, gangId);
/* 134 */     QuestionInterface.tlogAskQuestionHelp(this.roleId, this.questionCfgId);
/*     */     
/* 136 */     GameServer.logger().info(String.format("[QYXT]PCQYXTSeekGangHelpReq.processImp@seek help success|role_id=%d|question_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.questionCfgId) }));
/*     */     
/*     */ 
/* 139 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PCQYXTSeekGangHelpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */