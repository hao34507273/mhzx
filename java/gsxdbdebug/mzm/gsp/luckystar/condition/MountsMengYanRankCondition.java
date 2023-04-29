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
/*    */ public class MountsMengYanRankCondition
/*    */   implements LuckyStarCondition
/*    */ {
/*    */   public boolean checkCondition(long roleId, ConditionValueBean conditionValueBean)
/*    */   {
/* 16 */     int maxMengYanMountsRank = MountsInterface.getMountsTypeMaxRank(roleId, SMountsConsts.getInstance().meng_yan_cfg_id, true);
/*    */     
/* 18 */     if ((maxMengYanMountsRank >= conditionValueBean.left_value) && (maxMengYanMountsRank <= conditionValueBean.right_value))
/*    */     {
/* 20 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\condition\MountsMengYanRankCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */