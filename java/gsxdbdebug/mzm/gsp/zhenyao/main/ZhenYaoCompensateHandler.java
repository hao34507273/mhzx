/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhenYaoCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 18 */     return Collections.singletonList(Integer.valueOf(1));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 24 */     if (count < 0)
/*    */     {
/* 26 */       return 0; }
/*    */     int maxCount;
/*    */     int maxCount;
/* 29 */     if (OpenInterface.getOpenStatus(193))
/*    */     {
/* 31 */       maxCount = ZhenYaoActivityCfgConsts.getInstance().MAX_AWARD_COUNT2;
/*    */     }
/*    */     else
/*    */     {
/* 35 */       maxCount = ZhenYaoActivityCfgConsts.getInstance().MAX_AWARD_COUNT;
/*    */     }
/* 37 */     int leftCount = maxCount - count;
/* 38 */     if (leftCount <= 0)
/*    */     {
/* 40 */       return 0;
/*    */     }
/* 42 */     int finishGraphNeedTaskNum = TaskInterface.getFinishGraphNeedTaskNum(ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID);
/*    */     
/* 44 */     if (finishGraphNeedTaskNum <= 0)
/*    */     {
/* 46 */       return 0;
/*    */     }
/*    */     
/* 49 */     return leftCount / finishGraphNeedTaskNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\ZhenYaoCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */