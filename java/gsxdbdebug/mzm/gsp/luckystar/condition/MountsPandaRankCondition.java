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
/*    */ public class MountsPandaRankCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     int pandaMaxRank = MountsInterface.getMountsTypeMaxRank(roleId, SMountsConsts.getInstance().panda_cfg_id, true);
/* 17 */     if ((pandaMaxRank >= conditionValueBean.left_value) && (pandaMaxRank <= conditionValueBean.right_value))
/*    */     {
/* 19 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\MountsPandaRankCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */