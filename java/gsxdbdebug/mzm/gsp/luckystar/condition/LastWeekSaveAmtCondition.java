/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.qingfu.main.SaveAmtRecordInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LastWeekSaveAmtCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     String userId = RoleInterface.getUserId(roleId);
/* 17 */     long lastWeekSaveAmt = SaveAmtRecordInterface.getLastWeekSaveAmt(userId);
/* 18 */     if ((lastWeekSaveAmt >= conditionValueBean.left_value) && (lastWeekSaveAmt <= conditionValueBean.right_value))
/*    */     {
/* 20 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\LastWeekSaveAmtCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */