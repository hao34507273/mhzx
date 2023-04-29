/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.fabao.main.FabaoInterface;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonFabaoStarLevelCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     int commonFaBaoStarAverageLevel = FabaoInterface.getNormalAverageRankLv(roleId, true);
/* 17 */     if ((commonFaBaoStarAverageLevel >= conditionValueBean.left_value) && (commonFaBaoStarAverageLevel <= conditionValueBean.right_value))
/*    */     {
/*    */ 
/* 20 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\CommonFabaoStarLevelCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */