/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShiMenCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 17 */     return Collections.singletonList(Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 23 */     if (count < 0)
/*    */     {
/* 25 */       return 0;
/*    */     }
/* 27 */     int maxCount = ShimenActivityCfgConsts.getInstance().COUNT_FOR_BOUND_TIP;
/* 28 */     int leftCount = maxCount - count;
/* 29 */     if (leftCount <= 0)
/*    */     {
/* 31 */       return 0;
/*    */     }
/*    */     
/* 34 */     int graphId = ShimenManager.getShimenGraphIdByMenpai(RoleInterface.getOccupationId(roleid));
/* 35 */     if (graphId == -1)
/*    */     {
/* 37 */       return 0;
/*    */     }
/* 39 */     int finishGraphNeedTaskNum = TaskInterface.getFinishGraphNeedTaskNum(graphId);
/* 40 */     if (finishGraphNeedTaskNum <= 0)
/*    */     {
/* 42 */       return 0;
/*    */     }
/*    */     
/* 45 */     return leftCount / finishGraphNeedTaskNum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\ShiMenCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */