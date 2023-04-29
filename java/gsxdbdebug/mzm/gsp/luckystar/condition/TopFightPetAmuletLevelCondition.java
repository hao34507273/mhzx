/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TopFightPetAmuletLevelCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int amuletLevel = PetInterface.getMaxYaoliPetAmuletLevel(roleId, true);
/* 16 */     if ((amuletLevel >= conditionValueBean.left_value) && (amuletLevel <= conditionValueBean.right_value))
/*    */     {
/* 18 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\TopFightPetAmuletLevelCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */