/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaoTuCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 16 */     return Collections.singletonList(Integer.valueOf(2));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 22 */     if (count < 0)
/*    */     {
/* 24 */       return 0;
/*    */     }
/* 26 */     int maxCount = BaoTuActivityCfgConsts.getInstance().MAX_AWARD_COUNT;
/* 27 */     return count >= maxCount ? 0 : maxCount - count;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BaoTuCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */