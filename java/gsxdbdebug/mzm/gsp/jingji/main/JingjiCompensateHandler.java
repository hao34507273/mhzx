/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JingjiCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 15 */     return Collections.singletonList(Integer.valueOf(8));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 21 */     if (count < 0)
/*    */     {
/* 23 */       return 0;
/*    */     }
/* 25 */     int maxCount = JingjiActivityCfgConsts.getInstance().DAY_OFFER_CHALLENGE_COUNT;
/* 26 */     return count >= maxCount ? 0 : maxCount - count;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */