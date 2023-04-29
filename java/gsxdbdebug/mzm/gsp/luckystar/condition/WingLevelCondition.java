/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.wing.main2.WingInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingLevelCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int wingLevel = WingInterface.getRoleWingLevel(roleId, true);
/* 16 */     if ((wingLevel >= conditionValueBean.left_value) && (wingLevel <= conditionValueBean.right_value))
/*    */     {
/* 18 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\WingLevelCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */