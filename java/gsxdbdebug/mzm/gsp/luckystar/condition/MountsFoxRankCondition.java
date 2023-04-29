/*    */ package mzm.gsp.luckystar.condition;
/*    */ 
/*    */ import mzm.gsp.luckystar.confbean.ConditionValueBean;
/*    */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountsFoxRankCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     int foxMaxRank = MountsInterface.getMountsTypeMaxRank(roleId, SMountsConsts.getInstance().fox_cfg_id, true);
/* 17 */     if ((foxMaxRank >= conditionValueBean.left_value) && (foxMaxRank <= conditionValueBean.right_value))
/*    */     {
/* 19 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\MountsFoxRankCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */