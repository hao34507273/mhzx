/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BalanceCondtion
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     String userId = RoleInterface.getUserId(roleId);
/*    */     
/* 18 */     long balance = QingfuInterface.getBalance(userId, true);
/* 19 */     if ((balance >= conditionValueBean.left_value) && (balance <= conditionValueBean.right_value))
/*    */     {
/* 21 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\BalanceCondtion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */