/*     */ package mzm.gsp.questionvoice.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.questionvoice.SAnswerQuestionVoiceFailRes;
/*     */ import mzm.gsp.questionvoice.SAnswerQuestionVoiceSuccessRes;
/*     */ import mzm.gsp.questionvoice.confbean.SActivityTriggerQuestionVoiceCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.AbstractRewardPolicy;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.AnswerRightOrWrongArgs;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QuestionVoiceBean;
/*     */ import xbean.QuestionVoiceInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2question_voice_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAnswerQuestionVoiceReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int npcCfgId;
/*     */   private final int questionId;
/*     */   private final int answerIndex;
/*     */   
/*     */   public PCAnswerQuestionVoiceReq(long roleId, int activityCfgId, int npcCfgId, int questionId, int answerIndex)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.activityCfgId = activityCfgId;
/*  38 */     this.npcCfgId = npcCfgId;
/*  39 */     this.questionId = questionId;
/*  40 */     this.answerIndex = answerIndex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if ((this.activityCfgId <= 0) || (this.answerIndex < 0))
/*     */     {
/*  51 */       onFailed(-4);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  57 */     SActivityTriggerQuestionVoiceCfg cfg = SActivityTriggerQuestionVoiceCfg.get(this.activityCfgId);
/*  58 */     if (cfg == null)
/*     */     {
/*  60 */       onFailed(-4);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  66 */     if (this.npcCfgId != cfg.npcCfgid)
/*     */     {
/*  68 */       onFailed(-4);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     if (!QuestionVoiceManager.isFunOpen(this.roleId, this.activityCfgId))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  80 */     if (userid == null)
/*     */     {
/*  82 */       onFailed(-2);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  88 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  93 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1682, true, true))
/*     */     {
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, this.activityCfgId);
/*     */     
/* 104 */     if (!result.isCanJoin())
/*     */     {
/* 106 */       Map<String, Object> extras = new HashMap();
/* 107 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 108 */       onFailed(-6, extras);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 115 */     int activityCount = ActivityInterface.getActivityCount(userid, this.roleId, this.activityCfgId, true);
/* 116 */     if (activityCount >= cfg.maxQuestionNum)
/*     */     {
/* 118 */       Map<String, Object> extras = new HashMap();
/* 119 */       extras.put("activityCount", Integer.valueOf(activityCount));
/* 120 */       extras.put("maxCount", Integer.valueOf(cfg.maxQuestionNum));
/* 121 */       onFailed(-8, extras);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     int targetCount = ActivityInterface.getActivityCount(userid, this.roleId, cfg.targetActivityId, true);
/* 128 */     if (targetCount / cfg.needNum <= activityCount)
/*     */     {
/* 130 */       Map<String, Object> extras = new HashMap();
/* 131 */       extras.put("questionCount", Integer.valueOf(activityCount));
/* 132 */       extras.put("questionMaxCount", Integer.valueOf(targetCount / cfg.needNum));
/* 133 */       onFailed(-8, extras);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 139 */     QuestionVoiceInfo questionVoiceInfo = Role2question_voice_info.get(Long.valueOf(this.roleId));
/* 140 */     QuestionVoiceBean xQuestionVoiceBean = (QuestionVoiceBean)questionVoiceInfo.getActivity2question_voice().get(Integer.valueOf(this.activityCfgId));
/* 141 */     if (xQuestionVoiceBean == null)
/*     */     {
/* 143 */       onFailed(-9);
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 149 */     TreeMap<Integer, SQuestionVoiceBean> id2CfgMap = QuestionVoiceManager.getQuestionMap(cfg.policyId);
/* 150 */     if ((xQuestionVoiceBean.getNow_question_id() <= 0) || (id2CfgMap.get(Integer.valueOf(xQuestionVoiceBean.getNow_question_id())) == null))
/*     */     {
/* 152 */       onFailed(-9);
/* 153 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 158 */     if ((xQuestionVoiceBean.getNow_question_id() != this.questionId) || (this.answerIndex >= xQuestionVoiceBean.getNow_optional_order().size()))
/*     */     {
/*     */ 
/* 161 */       onFailed(-4);
/* 162 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 170 */     ActivityInterface.addActivityCount(userid, this.roleId, this.activityCfgId);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 175 */     boolean isRight = QuestionVoiceManager.isRight(this.answerIndex, xQuestionVoiceBean);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 180 */     Map<Long, String> roleidToUserid = new HashMap(1, 1.0F);
/* 181 */     roleidToUserid.put(Long.valueOf(this.roleId), userid);
/* 182 */     AbstractRewardPolicy<?> rewardPolicy = QuestionVoiceManager.getRewardPolicy(cfg.policyId, isRight, new AnswerRightOrWrongArgs(roleidToUserid), LogReason.QUESTION_VOICE_REWARD);
/*     */     
/* 184 */     if (rewardPolicy == null)
/*     */     {
/* 186 */       onFailed(-3);
/* 187 */       return false;
/*     */     }
/* 189 */     if (!rewardPolicy.doReward())
/*     */     {
/* 191 */       onFailed(-3);
/* 192 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 197 */     int rightIndex = QuestionVoiceManager.getRightAnswerIndex(xQuestionVoiceBean);
/*     */     
/*     */ 
/*     */ 
/* 201 */     xQuestionVoiceBean.setLast_question_id(this.questionId);
/* 202 */     xQuestionVoiceBean.setNow_question_id(0);
/* 203 */     xQuestionVoiceBean.getNow_optional_order().clear();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 208 */     SAnswerQuestionVoiceSuccessRes sAnswerQuestionVoiceSuccessRes = new SAnswerQuestionVoiceSuccessRes();
/* 209 */     sAnswerQuestionVoiceSuccessRes.activity_id = this.activityCfgId;
/* 210 */     sAnswerQuestionVoiceSuccessRes.question_id = this.questionId;
/* 211 */     sAnswerQuestionVoiceSuccessRes.answer_result = (isRight ? 1 : 0);
/* 212 */     sAnswerQuestionVoiceSuccessRes.right_index = rightIndex;
/* 213 */     OnlineManager.getInstance().send(this.roleId, sAnswerQuestionVoiceSuccessRes);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 218 */     QuestionVoiceTLogManager.tlogQuestionVoice(this.roleId, this.activityCfgId, this.questionId, isRight, this.answerIndex);
/*     */     
/* 220 */     GameServer.logger().info(String.format("[questionvoice]PCAnswerQuestionVoiceReq.processImp@ success|roleid=%d|activity_cfgid=%d|question_id=%d|answer_result=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.questionId), Integer.valueOf(sAnswerQuestionVoiceSuccessRes.answer_result) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 225 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 230 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 241 */     SAnswerQuestionVoiceFailRes rsp = new SAnswerQuestionVoiceFailRes();
/* 242 */     rsp.error_code = retcode;
/* 243 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 245 */     StringBuffer logBuilder = new StringBuffer();
/* 246 */     logBuilder.append("[questionvoice]PCAnswerQuestionVoiceReq.onFailed@getReward failed");
/* 247 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 248 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgId);
/* 249 */     logBuilder.append('|').append("question_id=").append(this.questionId);
/* 250 */     logBuilder.append('|').append("answer_index=").append(this.answerIndex);
/* 251 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 253 */     if (extraParams != null)
/*     */     {
/* 255 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 257 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 261 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\PCAnswerQuestionVoiceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */