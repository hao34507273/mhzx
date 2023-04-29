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
/*    */ public class LastTwoWeeksSaveAmtCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     String userId = RoleInterface.getUserId(roleId);
/*    */     
/* 18 */     long lastTwoWeekSaveAmt = SaveAmtRecordInterface.getLastTwoWeekSaveAmt(userId);
/* 19 */     if ((lastTwoWeekSaveAmt >= conditionValueBean.left_value) && (lastTwoWeekSaveAmt <= conditionValueBean.right_value))
/*    */     {
/* 21 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\LastTwoWeeksSaveAmtCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */