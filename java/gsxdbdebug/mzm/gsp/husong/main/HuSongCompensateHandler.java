/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HuSongCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 15 */     return Collections.singletonList(Integer.valueOf(5));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 21 */     if (count < 0)
/*    */     {
/* 23 */       return 0;
/*    */     }
/*    */     
/* 26 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/* 27 */     int maxCount = activityCfg.count;
/* 28 */     if (maxCount <= 0)
/*    */     {
/* 30 */       return 0;
/*    */     }
/* 32 */     return count >= maxCount ? 0 : maxCount - count;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HuSongCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */