/*    */ package mzm.gsp.questionvoice.main.rewardpolicy;
/*    */ 
/*    */ import java.util.LinkedHashMap;
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
/*    */ public class ByAnswerRightOrderArgs
/*    */   implements IRewardPolicyArgs
/*    */ {
/*    */   private final LinkedHashMap<Long, String> roleId2UserId;
/*    */   
/*    */   public ByAnswerRightOrderArgs(LinkedHashMap<Long, String> roleId2UserId)
/*    */   {
/* 22 */     this.roleId2UserId = roleId2UserId;
/*    */   }
/*    */   
/*    */   public Map<Long, String> getRoleId2UserId()
/*    */   {
/* 27 */     return this.roleId2UserId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\rewardpolicy\ByAnswerRightOrderArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */