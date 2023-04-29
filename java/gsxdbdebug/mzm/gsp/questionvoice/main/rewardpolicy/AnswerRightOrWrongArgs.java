/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
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
/*    */ public class AnswerRightOrWrongArgs
/*    */   implements IRewardPolicyArgs
/*    */ {
/*    */   private final Map<Long, String> roleId2UserId;
/*    */   
/*    */   public AnswerRightOrWrongArgs(Map<Long, String> roleId2UserId)
/*    */   {
/* 21 */     this.roleId2UserId = roleId2UserId;
/*    */   }
/*    */   
/*    */   public Map<Long, String> getRoleId2UserId()
/*    */   {
/* 26 */     return this.roleId2UserId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\AnswerRightOrWrongArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */