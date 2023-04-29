/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.children.main.ChildrenManager;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ 
/*    */ public class ChildrenEquipLevelCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 11 */     int equipMaxLevel = ChildrenManager.getRoleChildrenEquipMaxLevel(roleId);
/* 12 */     int equipMinLevel = ChildrenManager.getRoleChildrenEquipMinLevel(roleId);
/*    */     
/* 14 */     if ((equipMaxLevel < 0) || (equipMinLevel == Integer.MAX_VALUE))
/*    */     {
/* 16 */       return false;
/*    */     }
/*    */     
/* 19 */     if ((equipMinLevel >= conditionValueBean.left_value) && (equipMaxLevel <= conditionValueBean.right_value))
/*    */     {
/* 21 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\ChildrenEquipLevelCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */