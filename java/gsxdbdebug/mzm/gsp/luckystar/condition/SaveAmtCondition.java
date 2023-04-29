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
/*    */ public class SaveAmtCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     String userId = RoleInterface.getUserId(roleId);
/* 17 */     long saveAmt = QingfuInterface.getSaveAmt(userId, true);
/* 18 */     if ((saveAmt >= conditionValueBean.left_value) && (saveAmt <= conditionValueBean.right_value))
/*    */     {
/* 20 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\SaveAmtCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */