/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.partneryuanshen.main.PartnerYuanshenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PartnerYuanShenCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int rank4PartnerYuanShenLevel = PartnerYuanshenInterface.getPartnerYuanshenLevelSortedByImprovement(roleId, 4, true);
/*    */     
/*    */ 
/* 18 */     int rank1PartnerYuanShenLevel = PartnerYuanshenInterface.getPartnerYuanshenLevelSortedByImprovement(roleId, 1, true);
/*    */     
/*    */ 
/* 21 */     if ((rank4PartnerYuanShenLevel >= conditionValueBean.left_value) && (rank1PartnerYuanShenLevel <= conditionValueBean.right_value))
/*    */     {
/*    */ 
/* 24 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\PartnerYuanShenCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */