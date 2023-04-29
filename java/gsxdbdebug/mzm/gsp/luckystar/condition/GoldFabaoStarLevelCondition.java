/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.fabao.main.FabaoInterface;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GoldFabaoStarLevelCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 15 */     int goldFaBaoStarLevel = FabaoInterface.getEquipFaBaoRankLv(roleId, 1, true);
/* 16 */     if (goldFaBaoStarLevel < 0)
/*    */     {
/* 18 */       goldFaBaoStarLevel = 0;
/*    */     }
/*    */     
/* 21 */     if ((goldFaBaoStarLevel >= conditionValueBean.left_value) && (goldFaBaoStarLevel <= conditionValueBean.right_value))
/*    */     {
/* 23 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 27 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\GoldFabaoStarLevelCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */