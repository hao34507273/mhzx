/*     */ package mzm.gsp.questionvoice.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.questionvoice.SGetLastQuestionVoiceFailRes;
/*     */ import mzm.gsp.questionvoice.SGetLastQuestionVoiceSuccessRes;
/*     */ import mzm.gsp.questionvoice.confbean.SActivityTriggerQuestionVoiceCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QuestionVoiceBean;
/*     */ import xbean.QuestionVoiceInfo;
/*     */ import xtable.Role2question_voice_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetLastQuestionVoiceReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int npcCfgId;
/*     */   
/*     */   public PCGetLastQuestionVoiceReq(long roleId, int activityCfgId, int npcCfgId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.activityCfgId = activityCfgId;
/*  31 */     this.npcCfgId = npcCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (this.activityCfgId <= 0)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  47 */     SActivityTriggerQuestionVoiceCfg cfg = SActivityTriggerQuestionVoiceCfg.get(this.activityCfgId);
/*  48 */     if (cfg == null)
/*     */     {
/*  50 */       onFailed(-4);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  56 */     if (this.npcCfgId != cfg.npcCfgid)
/*     */     {
/*  58 */       onFailed(-4);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  64 */     if (!QuestionVoiceManager.isFunOpen(this.roleId, this.activityCfgId))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  70 */     if (userid == null)
/*     */     {
/*  72 */       onFailed(-2);
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  78 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1683, true, true))
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */     ActivityJoinResult result = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, this.activityCfgId);
/*     */     
/*  95 */     if (!result.isCanJoin())
/*     */     {
/*  97 */       Map<String, Object> extras = new HashMap();
/*  98 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/*  99 */       onFailed(-6, extras);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 105 */     QuestionVoiceInfo questionVoiceInfo = Role2question_voice_info.get(Long.valueOf(this.roleId));
/* 106 */     QuestionVoiceBean xQuestionVoiceBean = (QuestionVoiceBean)questionVoiceInfo.getActivity2question_voice().get(Integer.valueOf(this.activityCfgId));
/* 107 */     if (xQuestionVoiceBean == null)
/*     */     {
/* 109 */       onFailed(-7);
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     TreeMap<Integer, SQuestionVoiceBean> questionMap = QuestionVoiceManager.getQuestionMap(cfg.policyId);
/* 114 */     SQuestionVoiceBean sQuestionVoiceBean = (SQuestionVoiceBean)questionMap.get(Integer.valueOf(xQuestionVoiceBean.getLast_question_id()));
/*     */     
/*     */ 
/*     */ 
/* 118 */     if (sQuestionVoiceBean == null)
/*     */     {
/* 120 */       onFailed(-7);
/* 121 */       return false;
/*     */     }
/* 123 */     SGetLastQuestionVoiceSuccessRes sGetLastQuestionVoiceSuccessRes = new SGetLastQuestionVoiceSuccessRes();
/* 124 */     sGetLastQuestionVoiceSuccessRes.activity_id = this.activityCfgId;
/* 125 */     sGetLastQuestionVoiceSuccessRes.question_id = xQuestionVoiceBean.getLast_question_id();
/* 126 */     sGetLastQuestionVoiceSuccessRes.answer = ((String)sQuestionVoiceBean.answerList.get(0));
/*     */     
/* 128 */     OnlineManager.getInstance().send(this.roleId, sGetLastQuestionVoiceSuccessRes);
/*     */     
/* 130 */     GameServer.logger().info(String.format("[questionvoice]PCGetLastQuestionVoiceReq.processImp@ success|roleid=%d|activity_cfgid=%d|question_id=%d|answer=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(xQuestionVoiceBean.getLast_question_id()), sQuestionVoiceBean.answerList.get(0) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 141 */     onFailed(retcode, null);
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
/* 152 */     SGetLastQuestionVoiceFailRes rsp = new SGetLastQuestionVoiceFailRes();
/* 153 */     rsp.error_code = retcode;
/* 154 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 156 */     StringBuffer logBuilder = new StringBuffer();
/* 157 */     logBuilder.append("[questionvoice]PCGetQuestionVoiceReq.onFailed@getReward failed");
/* 158 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 159 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgId);
/* 160 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 162 */     if (extraParams != null)
/*     */     {
/* 164 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 166 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 170 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\PCGetLastQuestionVoiceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */