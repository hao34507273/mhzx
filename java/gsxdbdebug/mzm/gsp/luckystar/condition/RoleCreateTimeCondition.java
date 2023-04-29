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
/*    */ public class RoleCreateTimeCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     long roleCreateTime = RoleInterface.getRoleCreateTime(roleId);
/*    */     
/* 18 */     long beginTime = TimeCommonUtil.getLimitTimeBegin(conditionValueBean.left_value);
/* 19 */     long endTime = TimeCommonUtil.getLimitTimeEnd(conditionValueBean.left_value);
/*    */     
/* 21 */     if ((roleCreateTime >= beginTime) && (roleCreateTime <= endTime))
/*    */     {
/* 23 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 27 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\RoleCreateTimeCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */