/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRewardPolicy<T extends IRewardPolicyArgs>
/*    */ {
/*    */   protected final int policyGroupId;
/*    */   protected final T arg;
/*    */   protected final LogReason logReason;
/*    */   
/*    */   public AbstractRewardPolicy(int policyGroupId, T arg, LogReason logReason)
/*    */   {
/* 20 */     this.policyGroupId = policyGroupId;
/* 21 */     this.arg = arg;
/* 22 */     this.logReason = logReason;
/*    */   }
/*    */   
/*    */   public abstract boolean doReward();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\AbstractRewardPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */