/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ByAnswerRightNumArgs
/*    */   implements IRewardPolicyArgs
/*    */ {
/*    */   private final List<Integer> rightQuestionCfgIds;
/*    */   private final Map<Long, String> roleId2UserId;
/*    */   
/*    */   public ByAnswerRightNumArgs(Map<Long, String> roleId2UserId, List<Integer> rightQuestionCfgIds)
/*    */   {
/* 28 */     this.rightQuestionCfgIds = rightQuestionCfgIds;
/* 29 */     this.roleId2UserId = roleId2UserId;
/*    */   }
/*    */   
/*    */   public List<Integer> getRightQuestionCfgIds()
/*    */   {
/* 34 */     return this.rightQuestionCfgIds;
/*    */   }
/*    */   
/*    */   public Map<Long, String> getRoleId2UserId()
/*    */   {
/* 39 */     return this.roleId2UserId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\ByAnswerRightNumArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */