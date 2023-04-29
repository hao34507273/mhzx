/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
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
/*    */ public class ByAnswerRightOrder
/*    */   extends AbstractRewardPolicy<ByAnswerRightOrderArgs>
/*    */ {
/*    */   public ByAnswerRightOrder(int policyGroupId, ByAnswerRightOrderArgs arg, LogReason logReason)
/*    */   {
/* 26 */     super(policyGroupId, arg, logReason);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean doReward()
/*    */   {
/* 32 */     SQuestionVoiceRewardPolicyCfg cfg = SQuestionVoiceRewardPolicyCfg.get(this.policyGroupId);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 37 */     AwardModel awardModel = null;
/*    */     
/* 39 */     Iterator<Map.Entry<Integer, SQuestionVoiceRewardPolicyBean>> it = cfg.id2CfgMap.entrySet().iterator();
/*    */     
/* 41 */     for (Map.Entry<Long, String> roleInfoEntry : ((ByAnswerRightOrderArgs)this.arg).getRoleId2UserId().entrySet())
/*    */     {
/* 43 */       long roleId = ((Long)roleInfoEntry.getKey()).longValue();
/* 44 */       String userId = (String)roleInfoEntry.getValue();
/* 45 */       if (!it.hasNext()) {
/*    */         break;
/*    */       }
/*    */       
/* 49 */       SQuestionVoiceRewardPolicyBean rewardPolicyBean = (SQuestionVoiceRewardPolicyBean)((Map.Entry)it.next()).getValue();
/* 50 */       if (rewardPolicyBean.awardType != 0)
/*    */       {
/*    */ 
/*    */ 
/* 54 */         AwardReason awardReason = new AwardReason(this.logReason, rewardPolicyBean.awardId);
/* 55 */         awardReason.setAwardItemBind(true);
/* 56 */         if (rewardPolicyBean.awardType == 2)
/*    */         {
/* 58 */           awardModel = AwardInterface.awardFixAward(rewardPolicyBean.awardId, userId, roleId, false, true, awardReason);
/*    */         }
/*    */         else
/*    */         {
/* 62 */           awardModel = AwardInterface.award(rewardPolicyBean.awardId, userId, roleId, false, true, awardReason);
/*    */         }
/* 64 */         if (awardModel == null)
/*    */         {
/* 66 */           GameServer.logger().error(String.format("[questionvoice]ByAnswerRightOrder@award fail |roleId=%d|awardType=%d|awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(rewardPolicyBean.awardType), Integer.valueOf(rewardPolicyBean.awardId) }));
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\ByAnswerRightOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */