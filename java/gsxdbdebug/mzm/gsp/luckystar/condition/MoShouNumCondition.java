/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MoShouNumCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int shenShouNum = PetInterface.getMoShouPetNum(roleId, true);
/* 16 */     if ((shenShouNum >= conditionValueBean.left_value) && (shenShouNum <= conditionValueBean.right_value))
/*    */     {
/* 18 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\MoShouNumCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */