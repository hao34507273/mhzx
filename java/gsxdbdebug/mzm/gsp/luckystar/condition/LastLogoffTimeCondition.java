/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LastLogoffTimeCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 17 */     long currentTimeMillis = RoleInterface.getLastLogoffTime(roleId);
/*    */     
/* 19 */     long beginTime = TimeCommonUtil.getLimitTimeBegin(conditionValueBean.left_value);
/* 20 */     long endTime = TimeCommonUtil.getLimitTimeEnd(conditionValueBean.right_value);
/*    */     
/* 22 */     if ((currentTimeMillis >= beginTime) && (currentTimeMillis <= endTime))
/*    */     {
/* 24 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\LastLogoffTimeCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */