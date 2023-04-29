/*    */ package mzm.gsp.birthdaypray.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.birthdaypray.SSyncScheduleInfo;
/*    */ import mzm.gsp.nationalholiday.confbean.SBirthdayPrayCfg;
/*    */ import mzm.gsp.nationalholiday.confbean.STaskActivityId2ActivityIdCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChange
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if ((((TaskEventArg)this.arg).taskState != 8) || (!((TaskEventArg)this.arg).isToEnd))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     int taskActivityId = BirthdayPrayManager.getActivityId(((TaskEventArg)this.arg).graphId);
/* 33 */     if (taskActivityId < 0)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     STaskActivityId2ActivityIdCfg sTaskActivityId2ActivityIdCfg = STaskActivityId2ActivityIdCfg.get(taskActivityId);
/* 39 */     if (sTaskActivityId2ActivityIdCfg == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     int activityId = sTaskActivityId2ActivityIdCfg.activityId;
/*    */     
/* 45 */     SBirthdayPrayCfg sBirthdayPrayCfg = SBirthdayPrayCfg.get(activityId);
/*    */     
/* 47 */     if (!BirthdayPrayManager.isBirthdayPraySwitchOpen(((TaskEventArg)this.arg).roleId, sBirthdayPrayCfg.openId))
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 52 */     long roleId = ((TaskEventArg)this.arg).roleId;
/*    */     
/* 54 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 56 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*    */     
/* 58 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/*    */     
/*    */ 
/* 61 */     ActivityInterface.addActivityCount(userId, roleId, activityId);
/*    */     
/* 63 */     ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*    */     
/* 65 */     ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/* 66 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     long nowTimes = BirthdayPrayManager.addWorldCounterTimes(activityId, taskActivityId, 1);
/*    */     
/* 73 */     BirthdayPrayTLogManager.tlogBirthdayPray(roleId, activityId, ((TaskEventArg)this.arg).graphId, nowTimes);
/*    */     
/* 75 */     SSyncScheduleInfo syn = new SSyncScheduleInfo();
/* 76 */     syn.activity_cfg_id = activityId;
/* 77 */     syn.task_activity_id2times.put(Integer.valueOf(taskActivityId), Long.valueOf(nowTimes));
/* 78 */     OnlineManager.getInstance().sendAll(syn);
/*    */     
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */