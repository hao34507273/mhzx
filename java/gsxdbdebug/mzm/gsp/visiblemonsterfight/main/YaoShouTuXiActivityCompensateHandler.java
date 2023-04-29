/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class YaoShouTuXiActivityCompensateHandler
/*    */   implements ActivityCompensateHandler
/*    */ {
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 21 */     List<Integer> switches = new ArrayList();
/* 22 */     switches.add(Integer.valueOf(96));
/* 23 */     return switches;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 29 */     if (roleid < 0L)
/*    */     {
/* 31 */       return 0;
/*    */     }
/* 33 */     return Math.max(0, ActivityInterface.getActivityCfg(SYaoShouTuXiConsts.getInstance().ACTIVITYID).recommendCount - count);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\YaoShouTuXiActivityCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */