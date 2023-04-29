/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OpenServerTimeCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     long openServerTime = ServerInterface.getOpenServertime();
/* 17 */     long beginTime = TimeCommonUtil.getLimitTimeBegin(conditionValueBean.left_value);
/* 18 */     long endTime = TimeCommonUtil.getLimitTimeEnd(conditionValueBean.right_value);
/*    */     
/* 20 */     if ((openServerTime >= beginTime) && (openServerTime <= endTime))
/*    */     {
/* 22 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 26 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\OpenServerTimeCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */