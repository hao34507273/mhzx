/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.ActivityData;
/*    */ import mzm.gsp.activity.SynActivityChangeRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*    */ import mzm.gsp.task.main.RoleTask;
/*    */ import mzm.gsp.task.main.RoleTaskManager;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Activity;
/*    */ import xbean.ActivityBean;
/*    */ import xbean.TaskBean;
/*    */ import xtable.Role2activity;
/*    */ import xtable.Role2dayperfectringcount;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ClearShimen
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearShimen(long roleid)
/*    */   {
/* 28 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     Activity activity = Role2activity.get(Long.valueOf(this.roleid));
/* 36 */     if (activity == null)
/*    */     {
/* 38 */       return true;
/*    */     }
/* 40 */     ActivityBean activityBean = (ActivityBean)activity.getActivitymap().get(Integer.valueOf(ShimenActivityCfgConsts.getInstance().ACTIVITYID));
/* 41 */     if (activityBean == null)
/*    */     {
/* 43 */       return true;
/*    */     }
/* 45 */     activityBean.setCount(0);
/* 46 */     activityBean.setRecommendrewarded(false);
/*    */     
/* 48 */     Role2dayperfectringcount.delete(Long.valueOf(this.roleid));
/*    */     
/*    */ 
/* 51 */     int ocp = RoleInterface.getOccupationId(this.roleid);
/* 52 */     Integer graphid = Integer.valueOf(ShimenManager.getShimenGraphIdByMenpai(ocp));
/*    */     
/* 54 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleid, graphid.intValue());
/*    */     
/* 56 */     SynActivityChangeRes activityChangeRes = new SynActivityChangeRes();
/* 57 */     fillActivityData(ShimenActivityCfgConsts.getInstance().ACTIVITYID, activityChangeRes.activityinfo);
/* 58 */     OnlineManager.getInstance().send(this.roleid, activityChangeRes);
/* 59 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleid, true);
/* 60 */     for (TaskBean taskBean : roleTask.getAllTaskBean())
/*    */     {
/* 62 */       RoleTaskManager.sendUpdateTaskState(this.roleid, graphid.intValue(), taskBean.getTaskid(), 4);
/*    */     }
/*    */     
/* 65 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private static void fillActivityData(int activityId, ActivityData activityData)
/*    */   {
/* 71 */     activityData.actvityid = activityId;
/* 72 */     activityData.count = 0;
/* 73 */     activityData.awarded = 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\PGM_ClearShimen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */