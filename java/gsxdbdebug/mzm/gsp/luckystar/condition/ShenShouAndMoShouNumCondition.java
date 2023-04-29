/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShenShouAndMoShouNumCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 14 */     int shenShouAndMoShouNum = PetInterface.getGodAndMoShowPetNum(roleId, true);
/* 15 */     if ((shenShouAndMoShouNum >= conditionValueBean.left_value) && (shenShouAndMoShouNum <= conditionValueBean.right_value))
/*    */     {
/* 17 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\ShenShouAndMoShouNumCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */