/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EveryDayQuestionActivityCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 20 */     List<Integer> switches = new ArrayList();
/* 21 */     switches.add(Integer.valueOf(32));
/* 22 */     return switches;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 28 */     if (roleid < 0L)
/*    */     {
/* 30 */       return 0;
/*    */     }
/* 32 */     return Math.max(0, ActivityInterface.getActivityCfg(EveryDayQuestionManager.getInstance().getActivityId()).count - count);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\EveryDayQuestionActivityCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */