/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleTotalFightValueCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int roleTotalFightValue = RoleInterface.getRoleMFValue(roleId);
/*    */     
/* 17 */     if ((roleTotalFightValue >= conditionValueBean.left_value) && (roleTotalFightValue <= conditionValueBean.right_value))
/*    */     {
/* 19 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\RoleTotalFightValueCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */