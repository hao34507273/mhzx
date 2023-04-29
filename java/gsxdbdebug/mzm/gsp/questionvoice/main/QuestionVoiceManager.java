/*     */ package mzm.gsp.questionvoice.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.questionvoice.confbean.SActivityTriggerQuestionVoiceCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceChoosePolicyCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoicePolicyCfg;
/*     */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceRewardPolicyCfg;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.AbstractChoosePolicy;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.ByCfgOrderCircle;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.ByCfgOrderCircleArgs;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.IChoosePolicyArgs;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.RandomAny;
/*     */ import mzm.gsp.questionvoice.main.choosepolicy.RandomDiff;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.AbstractRewardPolicy;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.AnswerRightOrWrong;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.AnswerRightOrWrongArgs;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.ByAnswerRightNum;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.ByAnswerRightNumArgs;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.ByAnswerRightOrder;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.ByAnswerRightOrderArgs;
/*     */ import mzm.gsp.questionvoice.main.rewardpolicy.IRewardPolicyArgs;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QuestionVoiceBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuestionVoiceManager
/*     */ {
/*     */   static boolean isFunOpen(int activityId)
/*     */   {
/*  46 */     SActivityTriggerQuestionVoiceCfg sActivityTriggerQuestionVoiceCfg = SActivityTriggerQuestionVoiceCfg.get(activityId);
/*  47 */     if (sActivityTriggerQuestionVoiceCfg == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     if (!OpenInterface.getOpenStatus(sActivityTriggerQuestionVoiceCfg.openId))
/*     */     {
/*  53 */       GameServer.logger().error("[questionvoice]QuestionVoiceManager.isFunOpen@fun not open");
/*  54 */       return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFunOpen(long roleid, int activityId)
/*     */   {
/*  68 */     SActivityTriggerQuestionVoiceCfg sActivityTriggerQuestionVoiceCfg = SActivityTriggerQuestionVoiceCfg.get(activityId);
/*  69 */     if (sActivityTriggerQuestionVoiceCfg == null)
/*     */     {
/*  71 */       return false;
/*     */     }
/*  73 */     if (!OpenInterface.getOpenStatus(sActivityTriggerQuestionVoiceCfg.openId))
/*     */     {
/*  75 */       GameServer.logger().error("[questionvoice]QuestionVoiceManager.isFunOpen@fun not open");
/*  76 */       return false;
/*     */     }
/*  78 */     if (OpenInterface.isBanPlay(roleid, sActivityTriggerQuestionVoiceCfg.openId))
/*     */     {
/*  80 */       GameServer.logger().error(String.format("[questionvoice]QuestionVoiceManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  81 */       OpenInterface.sendBanPlayMsg(roleid, sActivityTriggerQuestionVoiceCfg.openId);
/*  82 */       return false;
/*     */     }
/*  84 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNpcController(int activityId)
/*     */   {
/*  95 */     SActivityTriggerQuestionVoiceCfg sActivityTriggerQuestionVoiceCfg = SActivityTriggerQuestionVoiceCfg.get(activityId);
/*  96 */     if (sActivityTriggerQuestionVoiceCfg == null)
/*     */     {
/*  98 */       GameServer.logger().error(String.format("[questionvoice]QuestionVoiceManager.getNpcController@cfg is null|activity_cfgid=%d", new Object[] { Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/* 101 */       return -1;
/*     */     }
/* 103 */     SNpc npc = NpcInterface.getNpc(sActivityTriggerQuestionVoiceCfg.npcCfgid);
/* 104 */     if (npc == null)
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[questionvoice]QuestionVoiceManager.getNpcController@npc cfg is null|activity_cfgid=%d|npc_cfgid=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(sActivityTriggerQuestionVoiceCfg.npcCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 110 */       return -1;
/*     */     }
/* 112 */     return npc.controllerId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onOpenChange(int activityCfgid, boolean open)
/*     */   {
/* 123 */     if (!ActivityInterface.isActivityOpen(activityCfgid))
/*     */     {
/* 125 */       return;
/*     */     }
/*     */     
/* 128 */     int controller = getNpcController(activityCfgid);
/* 129 */     if (controller <= 0)
/*     */     {
/* 131 */       return;
/*     */     }
/*     */     
/* 134 */     if (open)
/*     */     {
/* 136 */       ControllerInterface.triggerController(controller);
/*     */     }
/*     */     else
/*     */     {
/* 140 */       ControllerInterface.collectController(controller);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static TreeMap<Integer, SQuestionVoiceBean> getQuestionMap(AbstractChoosePolicy<IChoosePolicyArgs> choosePolicy)
/*     */   {
/* 152 */     return choosePolicy.getQuestionMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static TreeMap<Integer, SQuestionVoiceBean> getQuestionMap(int policeId)
/*     */   {
/* 163 */     SQuestionVoicePolicyCfg sQuestionVoicePolicyCfg = SQuestionVoicePolicyCfg.get(policeId);
/* 164 */     if (sQuestionVoicePolicyCfg == null)
/*     */     {
/* 166 */       return new TreeMap();
/*     */     }
/* 168 */     SQuestionVoiceChoosePolicyCfg cfg = SQuestionVoiceChoosePolicyCfg.get(sQuestionVoicePolicyCfg.choosepolicyId);
/* 169 */     if (cfg == null)
/*     */     {
/* 171 */       return new TreeMap();
/*     */     }
/*     */     
/* 174 */     SQuestionVoiceCfg sQuestionVoiceCfg = SQuestionVoiceCfg.get(cfg.questionType);
/* 175 */     if (sQuestionVoiceCfg == null)
/*     */     {
/* 177 */       return new TreeMap();
/*     */     }
/* 179 */     return sQuestionVoiceCfg.id2CfgMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static AbstractChoosePolicy<?> getChoosePolicy(int policeId, IChoosePolicyArgs args)
/*     */   {
/* 192 */     SQuestionVoicePolicyCfg sQuestionVoicePolicyCfg = SQuestionVoicePolicyCfg.get(policeId);
/* 193 */     if (sQuestionVoicePolicyCfg == null)
/*     */     {
/* 195 */       return null;
/*     */     }
/* 197 */     SQuestionVoiceChoosePolicyCfg cfg = SQuestionVoiceChoosePolicyCfg.get(sQuestionVoicePolicyCfg.choosepolicyId);
/* 198 */     if (cfg == null)
/*     */     {
/* 200 */       return null;
/*     */     }
/* 202 */     switch (cfg.policyType)
/*     */     {
/*     */     case 1: 
/* 205 */       return new ByCfgOrderCircle(sQuestionVoicePolicyCfg.choosepolicyId, (ByCfgOrderCircleArgs)args);
/*     */     case 2: 
/* 207 */       return new RandomDiff(sQuestionVoicePolicyCfg.choosepolicyId);
/*     */     case 3: 
/* 209 */       return new RandomAny(sQuestionVoicePolicyCfg.choosepolicyId);
/*     */     }
/* 211 */     return null;
/*     */   }
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
/*     */   static AbstractRewardPolicy<?> getRewardPolicy(int policeId, boolean isRight, IRewardPolicyArgs args, LogReason logReason)
/*     */   {
/* 227 */     SQuestionVoicePolicyCfg sQuestionVoicePolicyCfg = SQuestionVoicePolicyCfg.get(policeId);
/* 228 */     if (sQuestionVoicePolicyCfg == null)
/*     */     {
/* 230 */       return null; }
/*     */     SQuestionVoiceRewardPolicyCfg cfg;
/*     */     SQuestionVoiceRewardPolicyCfg cfg;
/* 233 */     if (isRight) {
/* 234 */       cfg = SQuestionVoiceRewardPolicyCfg.get(sQuestionVoicePolicyCfg.righRewardPolicyGroupId);
/*     */     } else {
/* 236 */       cfg = SQuestionVoiceRewardPolicyCfg.get(sQuestionVoicePolicyCfg.wrongRewardPolicyGroupId);
/*     */     }
/* 238 */     if (cfg == null)
/*     */     {
/* 240 */       return null;
/*     */     }
/* 242 */     switch (cfg.policyType)
/*     */     {
/*     */     case 1: 
/*     */     case 2: 
/* 246 */       return new AnswerRightOrWrong(cfg.groupId, (AnswerRightOrWrongArgs)args, logReason);
/*     */     case 3: 
/* 248 */       return new ByAnswerRightOrder(cfg.groupId, (ByAnswerRightOrderArgs)args, logReason);
/*     */     case 4: 
/* 250 */       return new ByAnswerRightNum(cfg.groupId, (ByAnswerRightNumArgs)args, logReason);
/*     */     }
/* 252 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRight(int answerIndex, QuestionVoiceBean xQuestionVoiceBean)
/*     */   {
/* 265 */     return getRightAnswerIndex(xQuestionVoiceBean) == answerIndex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRightAnswerIndex(QuestionVoiceBean xQuestionVoiceBean)
/*     */   {
/* 276 */     return xQuestionVoiceBean.getNow_optional_order().indexOf(Integer.valueOf(0));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\QuestionVoiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */