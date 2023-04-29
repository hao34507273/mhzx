/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
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
/*    */ 
/*    */ public class AnswerRightOrWrong
/*    */   extends AbstractRewardPolicy<AnswerRightOrWrongArgs>
/*    */ {
/*    */   public AnswerRightOrWrong(int policyGroupId, AnswerRightOrWrongArgs arg, LogReason logReason)
/*    */   {
/* 25 */     super(policyGroupId, arg, logReason);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean doReward()
/*    */   {
/* 31 */     SQuestionVoiceRewardPolicyCfg cfg = SQuestionVoiceRewardPolicyCfg.get(this.policyGroupId);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     AwardModel awardModel = null;
/* 37 */     for (Map.Entry<Long, String> roleInfoEntry : ((AnswerRightOrWrongArgs)this.arg).getRoleId2UserId().entrySet())
/*    */     {
/* 39 */       roleId = ((Long)roleInfoEntry.getKey()).longValue();
/* 40 */       userId = (String)roleInfoEntry.getValue();
/* 41 */       for (Map.Entry<Integer, SQuestionVoiceRewardPolicyBean> entry : cfg.id2CfgMap.entrySet())
/*    */       {
/* 43 */         SQuestionVoiceRewardPolicyBean rewardPolicyBean = (SQuestionVoiceRewardPolicyBean)entry.getValue();
/* 44 */         if (rewardPolicyBean.awardType != 0)
/*    */         {
/*    */ 
/*    */ 
/* 48 */           AwardReason awardReason = new AwardReason(this.logReason, rewardPolicyBean.awardId);
/* 49 */           awardReason.setAwardItemBind(true);
/* 50 */           if (rewardPolicyBean.awardType == 2)
/*    */           {
/* 52 */             awardModel = AwardInterface.awardFixAward(rewardPolicyBean.awardId, userId, roleId, false, true, awardReason);
/*    */ 
/*    */           }
/*    */           else
/*    */           {
/* 57 */             awardModel = AwardInterface.award(rewardPolicyBean.awardId, userId, roleId, false, true, awardReason);
/*    */           }
/* 59 */           if (awardModel == null)
/*    */           {
/* 61 */             GameServer.logger().error(String.format("[questionvoice]AnswerRightOrWrong@award fail |roleId=%d|awardType=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(rewardPolicyBean.awardType), Integer.valueOf(rewardPolicyBean.awardId) })); }
/*    */         }
/*    */       }
/*    */     }
/*    */     long roleId;
/*    */     String userId;
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\AnswerRightOrWrong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */