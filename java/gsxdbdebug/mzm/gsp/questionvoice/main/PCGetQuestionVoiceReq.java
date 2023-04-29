/*     */ package mzm.gsp.questionvoice.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.questionvoice.SGetQuestionVoiceFailRes;
/*     */ import mzm.gsp.questionvoice.SGetQuestionVoiceSuccessRes;
/*     */ import mzm.gsp.questionvoice.confbean.SActivityTriggerQuestionVoiceCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.AbstractChoosePolicy;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.ByCfgOrderCircleArgs;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QuestionVoiceBean;
/*     */ import xbean.QuestionVoiceInfo;
/*     */ import xtable.Role2question_voice_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetQuestionVoiceReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int npcCfgId;
/*     */   
/*     */   public PCGetQuestionVoiceReq(long roleId, int activityCfgId, int npcCfgId)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.activityCfgId = activityCfgId;
/*  37 */     this.npcCfgId = npcCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (this.activityCfgId <= 0)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  53 */     SActivityTriggerQuestionVoiceCfg cfg = SActivityTriggerQuestionVoiceCfg.get(this.activityCfgId);
/*  54 */     if (cfg == null)
/*     */     {
/*  56 */       onFailed(-4);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  62 */     if (this.npcCfgId != cfg.npcCfgid)
/*     */     {
/*  64 */       onFailed(-4);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  70 */     if (!QuestionVoiceManager.isFunOpen(this.roleId, this.activityCfgId))
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  76 */     if (userid == null)
/*     */     {
/*  78 */       onFailed(-2);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  84 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  89 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1681, true, true))
/*     */     {
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  98 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, this.activityCfgId);
/*     */     
/* 100 */     if (!result.isCanJoin())
/*     */     {
/* 102 */       Map<String, Object> extras = new HashMap();
/* 103 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 104 */       onFailed(-6, extras);
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */     int activityCount = ActivityInterface.getActivityCount(userid, this.roleId, this.activityCfgId, true);
/* 113 */     if (activityCount >= cfg.maxQuestionNum)
/*     */     {
/* 115 */       Map<String, Object> extras = new HashMap();
/* 116 */       extras.put("activityCount", Integer.valueOf(activityCount));
/* 117 */       extras.put("maxCount", Integer.valueOf(cfg.maxQuestionNum));
/* 118 */       onFailed(-7, extras);
/* 119 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 124 */     int targetCount = ActivityInterface.getActivityCount(userid, this.roleId, cfg.targetActivityId, true);
/* 125 */     if (targetCount / cfg.needNum <= activityCount)
/*     */     {
/* 127 */       Map<String, Object> extras = new HashMap();
/* 128 */       extras.put("questionCount", Integer.valueOf(activityCount));
/* 129 */       extras.put("questionMaxCount", Integer.valueOf(targetCount / cfg.needNum));
/* 130 */       onFailed(-7, extras);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 136 */     QuestionVoiceInfo questionVoiceInfo = Role2question_voice_info.get(Long.valueOf(this.roleId));
/* 137 */     QuestionVoiceBean xQuestionVoiceBean = (QuestionVoiceBean)questionVoiceInfo.getActivity2question_voice().get(Integer.valueOf(this.activityCfgId));
/* 138 */     if (xQuestionVoiceBean == null)
/*     */     {
/* 140 */       xQuestionVoiceBean = xbean.Pod.newQuestionVoiceBean();
/* 141 */       questionVoiceInfo.getActivity2question_voice().put(Integer.valueOf(this.activityCfgId), xQuestionVoiceBean);
/*     */     }
/* 143 */     SGetQuestionVoiceSuccessRes sGetQuestionVoiceSuccessRes = new SGetQuestionVoiceSuccessRes();
/*     */     
/* 145 */     TreeMap<Integer, SQuestionVoiceBean> questionMap = QuestionVoiceManager.getQuestionMap(cfg.policyId);
/* 146 */     SQuestionVoiceBean sQuestionVoiceBean = (SQuestionVoiceBean)questionMap.get(Integer.valueOf(xQuestionVoiceBean.getNow_question_id()));
/*     */     
/*     */     Iterator i$;
/*     */     
/* 150 */     if (sQuestionVoiceBean == null)
/*     */     {
/*     */ 
/* 153 */       AbstractChoosePolicy<?> choosePolicy = QuestionVoiceManager.getChoosePolicy(cfg.policyId, new ByCfgOrderCircleArgs(xQuestionVoiceBean.getLast_question_id()));
/*     */       
/* 155 */       if (choosePolicy == null)
/*     */       {
/* 157 */         onFailed(-3);
/* 158 */         return false;
/*     */       }
/*     */       
/* 161 */       int nextQuestionId = choosePolicy.getQuestionId();
/* 162 */       if (nextQuestionId <= 0)
/*     */       {
/* 164 */         onFailed(-3);
/* 165 */         return false;
/*     */       }
/* 167 */       xQuestionVoiceBean.setNow_question_id(nextQuestionId);
/* 168 */       sQuestionVoiceBean = (SQuestionVoiceBean)questionMap.get(Integer.valueOf(nextQuestionId));
/* 169 */       List<String> optionals = new ArrayList(sQuestionVoiceBean.answerList);
/* 170 */       java.util.Collections.shuffle(optionals);
/* 171 */       for (String optional : optionals)
/*     */       {
/* 173 */         xQuestionVoiceBean.getNow_optional_order().add(Integer.valueOf(sQuestionVoiceBean.answerList.indexOf(optional)));
/*     */       }
/* 175 */       sGetQuestionVoiceSuccessRes.answer_list.addAll(optionals);
/*     */       
/*     */ 
/* 178 */       ActivityInterface.logActivity(this.roleId, this.activityCfgId, ActivityLogStatus.ATTEND);
/*     */       
/* 180 */       ActivityInterface.tlogActivity(this.roleId, this.activityCfgId, ActivityLogStatus.ATTEND);
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 187 */       for (i$ = xQuestionVoiceBean.getNow_optional_order().iterator(); i$.hasNext();) { int optionalIndex = ((Integer)i$.next()).intValue();
/*     */         
/* 189 */         sGetQuestionVoiceSuccessRes.answer_list.add(sQuestionVoiceBean.answerList.get(optionalIndex));
/*     */       }
/*     */     }
/* 192 */     sGetQuestionVoiceSuccessRes.activity_id = this.activityCfgId;
/* 193 */     sGetQuestionVoiceSuccessRes.question_id = xQuestionVoiceBean.getNow_question_id();
/*     */     
/* 195 */     OnlineManager.getInstance().send(this.roleId, sGetQuestionVoiceSuccessRes);
/*     */     
/* 197 */     GameServer.logger().info(String.format("[questionvoice]PCGetQuestionVoiceReq.processImp@ success|roleid=%d|activity_cfgid=%d|question_id=%d|answer_list=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(xQuestionVoiceBean.getNow_question_id()), xQuestionVoiceBean.getNow_optional_order() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 203 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 208 */     onFailed(retcode, null);
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
/* 219 */     SGetQuestionVoiceFailRes rsp = new SGetQuestionVoiceFailRes();
/* 220 */     rsp.error_code = retcode;
/* 221 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 223 */     StringBuffer logBuilder = new StringBuffer();
/* 224 */     logBuilder.append("[questionvoice]PCGetQuestionVoiceReq.onFailed@getReward failed");
/* 225 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 226 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgId);
/* 227 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 229 */     if (extraParams != null)
/*     */     {
/* 231 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 233 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 237 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\PCGetQuestionVoiceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */