/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceRewardPolicyBean;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceRewardPolicyCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ByAnswerRightNum
/*    */   extends AbstractRewardPolicy<ByAnswerRightNumArgs>
/*    */ {
/*    */   public ByAnswerRightNum(int policyGroupId, ByAnswerRightNumArgs arg, LogReason logReason)
/*    */   {
/* 25 */     super(policyGroupId, arg, logReason);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean doReward()
/*    */   {
/* 31 */     SQuestionVoiceRewardPolicyCfg cfg = SQuestionVoiceRewardPolicyCfg.get(this.policyGroupId);
/* 32 */     SQuestionVoiceRewardPolicyBean rewardPolicyBean = null;
/*    */     
/* 34 */     AwardModel awardModel = null;
/* 35 */     for (Map.Entry<Integer, SQuestionVoiceRewardPolicyBean> entry : cfg.id2CfgMap.entrySet())
/*    */     {
/* 37 */       rewardPolicyBean = (SQuestionVoiceRewardPolicyBean)entry.getValue();
/* 38 */       if (rewardPolicyBean.awardType == 0)
/*    */       {
/* 40 */         rewardPolicyBean = null;
/*    */       }
/*    */       else {
/* 43 */         if (((ByAnswerRightNumArgs)this.arg).getRightQuestionCfgIds().size() >= rewardPolicyBean.param_1) {
/*    */           break;
/*    */         }
/*    */         
/* 47 */         rewardPolicyBean = null;
/*    */       }
/*    */     }
/* 50 */     if (rewardPolicyBean == null)
/*    */     {
/* 52 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 56 */     for (Map.Entry<Long, String> roleInfoEntry : ((ByAnswerRightNumArgs)this.arg).getRoleId2UserId().entrySet())
/*    */     {
/* 58 */       long roleId = ((Long)roleInfoEntry.getKey()).longValue();
/* 59 */       String userId = (String)roleInfoEntry.getValue();
/*    */       
/* 61 */       AwardReason awardReason = new AwardReason(this.logReason, rewardPolicyBean.awardId);
/* 62 */       awardReason.setAwardItemBind(true);
/* 63 */       if (rewardPolicyBean.awardType == 2)
/*    */       {
/* 65 */         awardModel = AwardInterface.awardFixAward(rewardPolicyBean.awardId, userId, roleId, false, true, awardReason);
/*    */       }
/*    */       else
/*    */       {
/* 69 */         awardModel = AwardInterface.award(rewardPolicyBean.awardId, userId, roleId, false, true, awardReason);
/*    */       }
/* 71 */       if (awardModel == null)
/*    */       {
/* 73 */         GameServer.logger().error(String.format("[questionvoice]ByAnswerRightNum@award fail |roleId=%d|awardType=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(rewardPolicyBean.awardType), Integer.valueOf(rewardPolicyBean.awardId) }));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\ByAnswerRightNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */