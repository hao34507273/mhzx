/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.SSyncQYXTGangAnswer;
/*     */ import mzm.gsp.question.SSyncQuestionNormalResult;
/*     */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QYXTQuestionInfo;
/*     */ import xtable.Role2qyxtquestion;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCQYXTGangHelpAnswerReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long activeHelpRoleId;
/*     */   private final long seekHelpRoleId;
/*     */   private final int questionCfgId;
/*     */   private final String helpAnswerString;
/*     */   
/*     */   public PCQYXTGangHelpAnswerReq(long activeHelpRoleId, long seekHelpRoleId, int questionCfgId, String helpAnswerString)
/*     */   {
/*  28 */     this.activeHelpRoleId = activeHelpRoleId;
/*  29 */     this.seekHelpRoleId = seekHelpRoleId;
/*  30 */     this.questionCfgId = questionCfgId;
/*  31 */     this.helpAnswerString = helpAnswerString;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!QYXTQuestionActivity.checkMutexStatus(this.activeHelpRoleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     String activeUserId = RoleInterface.getUserId(this.activeHelpRoleId);
/*  43 */     String seekHelpUserId = RoleInterface.getUserId(this.seekHelpRoleId);
/*  44 */     if ((activeUserId == null) || (seekHelpUserId == null))
/*     */     {
/*  46 */       GameServer.logger().error(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@userid is null|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s|active_user_id=%s|seek_help_user_id=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString, activeUserId, seekHelpUserId }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*  53 */     lock(User.getTable(), Arrays.asList(new String[] { activeUserId, seekHelpUserId }));
/*  54 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeHelpRoleId), Long.valueOf(this.seekHelpRoleId) }));
/*     */     
/*  56 */     QYXTQuestionInfo xQyxtQuestionInfo = Role2qyxtquestion.get(Long.valueOf(this.seekHelpRoleId));
/*  57 */     if (xQyxtQuestionInfo == null)
/*     */     {
/*     */ 
/*  60 */       GameServer.logger().error(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@seek help role question info is null|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     int hasAnswerNum = ActivityInterface.getActivityCount(seekHelpUserId, this.seekHelpRoleId, SQYXTQuestionConst.getInstance().ACTIVITY_ID, true);
/*     */     
/*     */ 
/*  70 */     if ((hasAnswerNum == -1) || (hasAnswerNum >= xQyxtQuestionInfo.getQuestions().size()) || (((Integer)xQyxtQuestionInfo.getQuestions().get(hasAnswerNum)).intValue() != this.questionCfgId))
/*     */     {
/*     */ 
/*  73 */       GameServer.logger().info(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@not has the question|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  78 */       SSyncQuestionNormalResult sSyncQuestionNormalResult = new SSyncQuestionNormalResult();
/*  79 */       sSyncQuestionNormalResult.result = 1;
/*  80 */       OnlineManager.getInstance().sendAtOnce(this.activeHelpRoleId, sSyncQuestionNormalResult);
/*     */       
/*  82 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  86 */     if (xQyxtQuestionInfo.getCurrent_help_roleids().contains(Long.valueOf(this.activeHelpRoleId)))
/*     */     {
/*  88 */       GameServer.logger().info(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@has help the question once|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  93 */       SSyncQuestionNormalResult sSyncQuestionNormalResult = new SSyncQuestionNormalResult();
/*  94 */       sSyncQuestionNormalResult.result = 2;
/*  95 */       OnlineManager.getInstance().sendAtOnce(this.activeHelpRoleId, sSyncQuestionNormalResult);
/*     */       
/*  97 */       return true;
/*     */     }
/*     */     
/* 100 */     long activeGangId = GangInterface.getGangId(this.activeHelpRoleId);
/* 101 */     if (activeGangId <= 0L)
/*     */     {
/*     */ 
/* 104 */       GameServer.logger().error(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@active role not has gang|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     long seekHelpGangId = GangInterface.getGangId(this.seekHelpRoleId);
/* 113 */     if (seekHelpGangId <= 0L)
/*     */     {
/*     */ 
/* 116 */       GameServer.logger().error(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@seek help role not has gang|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 121 */       SSyncQuestionNormalResult sSyncQuestionNormalResult = new SSyncQuestionNormalResult();
/* 122 */       sSyncQuestionNormalResult.result = 3;
/* 123 */       OnlineManager.getInstance().sendAtOnce(this.activeHelpRoleId, sSyncQuestionNormalResult);
/*     */       
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if (seekHelpGangId != activeGangId)
/*     */     {
/*     */ 
/* 131 */       SSyncQuestionNormalResult sSyncQuestionNormalResult = new SSyncQuestionNormalResult();
/* 132 */       sSyncQuestionNormalResult.result = 4;
/* 133 */       OnlineManager.getInstance().sendAtOnce(this.activeHelpRoleId, sSyncQuestionNormalResult);
/*     */       
/* 135 */       GameServer.logger().error(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@seek help role not has gang|active_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */       
/*     */ 
/*     */ 
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     xQyxtQuestionInfo.getCurrent_help_roleids().add(Long.valueOf(this.activeHelpRoleId));
/*     */     
/* 144 */     SSyncQYXTGangAnswer sSyncQYXTGangAnswer = new SSyncQYXTGangAnswer();
/* 145 */     sSyncQYXTGangAnswer.helpanswerroleid = this.activeHelpRoleId;
/* 146 */     sSyncQYXTGangAnswer.seekhelproleid = this.seekHelpRoleId;
/* 147 */     sSyncQYXTGangAnswer.questionid = this.questionCfgId;
/* 148 */     sSyncQYXTGangAnswer.helpanswerstring = this.helpAnswerString;
/* 149 */     GangInterface.brocastInGang(sSyncQYXTGangAnswer, seekHelpGangId);
/*     */     
/* 151 */     int seekHelpRoleLevel = RoleInterface.getLevel(this.seekHelpRoleId);
/* 152 */     QuestionInterface.tlogHelpAnswerQuestion(this.activeHelpRoleId, seekHelpUserId, this.seekHelpRoleId, seekHelpRoleLevel, this.questionCfgId);
/*     */     
/*     */ 
/* 155 */     GameServer.logger().info(String.format("[QYXT]PCQYXTGangHelpAnswerReq.processImp@help answer success|active_help_role_id=%d|question_cfg_id=%d|seek_help_role_id=%d|help_answer_string=%s", new Object[] { Long.valueOf(this.activeHelpRoleId), Integer.valueOf(this.questionCfgId), Long.valueOf(this.seekHelpRoleId), this.helpAnswerString }));
/*     */     
/*     */ 
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PCQYXTGangHelpAnswerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */