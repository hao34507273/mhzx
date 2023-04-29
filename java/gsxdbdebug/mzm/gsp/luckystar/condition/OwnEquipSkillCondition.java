/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OwnEquipSkillCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 14 */     List<Integer> ownEquipSkillList = ItemInterface.getEquipSkillList(roleId, true);
/* 15 */     if ((ownEquipSkillList == null) || (ownEquipSkillList.isEmpty()))
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\OwnEquipSkillCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */