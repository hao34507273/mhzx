/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EquipQiLinLevelAverageCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int equipQiLinAverageLevel = ItemInterface.getAvgQilinLevel(roleId, true);
/* 16 */     if ((equipQiLinAverageLevel >= conditionValueBean.left_value) && (equipQiLinAverageLevel <= conditionValueBean.right_value))
/*    */     {
/* 18 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\EquipQiLinLevelAverageCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */