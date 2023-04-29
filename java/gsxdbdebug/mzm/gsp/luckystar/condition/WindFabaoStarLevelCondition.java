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
/*    */ public class WindFabaoStarLevelCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     int windFaBaoStarLevel = FabaoInterface.getEquipFaBaoRankLv(roleId, 6, true);
/* 17 */     if (windFaBaoStarLevel < 0)
/*    */     {
/* 19 */       windFaBaoStarLevel = 0;
/*    */     }
/*    */     
/* 22 */     if ((windFaBaoStarLevel >= conditionValueBean.left_value) && (windFaBaoStarLevel <= conditionValueBean.right_value))
/*    */     {
/* 24 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\WindFabaoStarLevelCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */