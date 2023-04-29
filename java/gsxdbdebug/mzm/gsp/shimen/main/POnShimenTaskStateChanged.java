/*     */ package mzm.gsp.shimen.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*     */ import mzm.gsp.shimen.event.ShimenActivityArg;
/*     */ import mzm.gsp.shimen.event.ShimenActivityFinished;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnShimenTaskStateChanged
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!ShimenManager.isShimenActivity(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */     case 8: 
/*  42 */       if (!ShimenManager.isRoleStateCanJoinShimenActivity(((TaskEventArg)this.arg).roleId))
/*     */       {
/*  44 */         String logStr = String.format("[shimen]POnShimenTaskStateChanged.processImp@role state can not join shimen activity|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*     */         
/*     */ 
/*  47 */         ShimenManager.logger.info(logStr);
/*  48 */         return false;
/*     */       }
/*     */       
/*  51 */       String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/*  52 */       lock(Lockeys.get(User.getTable(), userId));
/*  53 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(((TaskEventArg)this.arg).roleId)));
/*  54 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, ((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID);
/*     */       
/*     */ 
/*  57 */       if (!res.isCanJoin())
/*     */       {
/*  59 */         String logstr = String.format("[shimen]POnShimenTaskStateChanged.processImp@can join error on task finished|roleid=%d|count=%d|taskid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(ActivityInterface.getActivityCount(userId, ((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, true)), Integer.valueOf(((TaskEventArg)this.arg).taskId) });
/*     */         
/*     */ 
/*     */ 
/*  63 */         ShimenManager.logger.error(logstr);
/*  64 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  68 */       boolean ret = ActivityInterface.addActivityCount(userId, ((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID);
/*     */       
/*  70 */       if (!ret)
/*     */       {
/*  72 */         String logstr = String.format("[shimen]POnShimenTaskStateChanged.processImp@Add Shimen Activity Count failed|roleid=%d|count=%d|taskid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(ActivityInterface.getActivityCount(userId, ((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, true)), Integer.valueOf(((TaskEventArg)this.arg).taskId) });
/*     */         
/*     */ 
/*     */ 
/*  76 */         ShimenManager.logger.error(logstr);
/*  77 */         return false;
/*     */       }
/*     */       
/*  80 */       ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */       
/*  82 */       ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/*  85 */       int shimencount = ActivityInterface.getActivityCount(userId, ((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */       
/*     */ 
/*  88 */       if (shimencount == 1)
/*     */       {
/*  90 */         TaskInterface.setGraphFinishNum(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, 1);
/*     */       }
/*     */       
/*  93 */       if (shimencount > ShimenActivityCfgConsts.getInstance().DAY_TOTAL_COUNT)
/*     */       {
/*  95 */         goNextTask();
/*  96 */         return true;
/*     */       }
/*     */       
/*  99 */       ShimenManager.addDayPerfectRingCout(((TaskEventArg)this.arg).roleId);
/*     */       
/* 101 */       ShimenManager.awardShimenReward(userId, ((TaskEventArg)this.arg).roleId, shimencount);
/*     */       
/* 103 */       ShimenManager.awardPerfectReward(userId, ((TaskEventArg)this.arg).roleId);
/*     */       
/*     */ 
/* 106 */       if (ActivityInterface.getActivityCount(userId, ((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, true) != ShimenActivityCfgConsts.getInstance().COUNT_FOR_BOUND_TIP)
/*     */       {
/*     */ 
/* 109 */         goNextTask();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 114 */         TaskInterface.ranOneCanAcceptTask(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId);
/* 115 */         List<Long> roleList = new ArrayList();
/* 116 */         roleList.add(Long.valueOf(((TaskEventArg)this.arg).roleId));
/* 117 */         AwardPoolInterface.awardLottery(roleList, ShimenActivityCfgConsts.getInstance().LOTTERY_VIEW_ID, false, ShimenActivityCfgConsts.getInstance().DELAY_OFFER_TIME, new TLogArg(LogReason.SHIMEN_LOTTERY_AWARD, ShimenActivityCfgConsts.getInstance().LOTTERY_VIEW_ID));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 122 */       TriggerEventsManger.getInstance().triggerEvent(new ShimenActivityFinished(), new ShimenActivityArg(((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, shimencount - 1, shimencount, ((TaskEventArg)this.arg).getTaskConditionInfos()));
/*     */       
/*     */ 
/*     */ 
/* 126 */       return true;
/*     */     
/*     */     case 2: 
/* 129 */       ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/* 131 */       ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, ShimenActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/*     */ 
/* 134 */       return true;
/*     */     }
/* 136 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void goNextTask()
/*     */   {
/* 165 */     int roleOcp = RoleInterface.getOccupationId(((TaskEventArg)this.arg).roleId);
/* 166 */     int graphId = ShimenManager.getShimenGraphIdByMenpai(roleOcp);
/* 167 */     boolean ret = TaskInterface.goNextTask(((TaskEventArg)this.arg).roleId, graphId);
/* 168 */     if (!ret)
/*     */     {
/* 170 */       String logstr = String.format("[shimen]POnShimenTaskStateChanged.goNextTask@Add Shimen Activity Count failed|roleid=%d|taskid=%d|ocp=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(roleOcp), Integer.valueOf(graphId) });
/*     */       
/*     */ 
/* 173 */       ShimenManager.logger.error(logstr);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\POnShimenTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */