/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ import mzm.gsp.question.confbean.SQYXTQuestionConst;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QYXTActivityCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 19 */     if (count < 0)
/*    */     {
/* 21 */       return 0;
/*    */     }
/* 23 */     return Math.max(0, ActivityInterface.getActivityCfg(SQYXTQuestionConst.getInstance().ACTIVITY_ID).count - count);
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 29 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\QYXTActivityCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */