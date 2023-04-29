/*     */ package mzm.gsp.circletask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CircleTask;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2circletask;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskStateChange extends mzm.gsp.task.event.TaskStateChangeProcedure
/*     */ {
/*  24 */   private static final Logger logger = Logger.getLogger(POnTaskStateChange.class);
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     if (CircleTaskConsts.getInstance().TASK_GRAPHIC_ID != ((TaskEventArg)this.arg).graphId) {
/*  29 */       return false;
/*     */     }
/*  31 */     String meetUserId = null;
/*  32 */     List<String> userList = new ArrayList();
/*  33 */     List<Long> roleList = ((TaskEventArg)this.arg).getAllRoleList();
/*  34 */     if (roleList.isEmpty()) {
/*  35 */       roleList.add(Long.valueOf(((TaskEventArg)this.arg).roleId));
/*     */     }
/*  37 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*  38 */       String userId = RoleInterface.getUserId(roleId);
/*  39 */       if (roleId == ((TaskEventArg)this.arg).roleId) {
/*  40 */         meetUserId = userId;
/*     */       }
/*  42 */       userList.add(userId);
/*     */     }
/*     */     
/*  45 */     lock(User.getTable(), userList);
/*     */     
/*  47 */     lock(xtable.Role2chivalrydayinfo.getTable(), roleList);
/*  48 */     if (((TaskEventArg)this.arg).taskState == 2) {
/*  49 */       return onAcceptTask();
/*     */     }
/*  51 */     if (((TaskEventArg)this.arg).taskState == 8) {
/*  52 */       return onHandoutTask(meetUserId);
/*     */     }
/*  54 */     if (((TaskEventArg)this.arg).taskState == 3) {
/*  55 */       return onTaskFinish();
/*     */     }
/*  57 */     if (((TaskEventArg)this.arg).taskState == 5) {
/*  58 */       return onGiveUpTask();
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean onTaskFinish()
/*     */   {
/*  68 */     if (!((TaskEventArg)this.arg).isFightTask()) {
/*  69 */       return false;
/*     */     }
/*  71 */     List<Long> members = ((TaskEventArg)this.arg).getRoleList();
/*  72 */     if (members.size() <= 1) {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     xdb.Procedure.execute(new PTeamAward(((TaskEventArg)this.arg).roleId, members));
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   private boolean onGiveUpTask() {
/*  81 */     CircleTaskManager.getInstance().onEndCircleTask(((TaskEventArg)this.arg).roleId);
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private boolean onHandoutTask(String userId)
/*     */   {
/*  87 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(((TaskEventArg)this.arg).roleId));
/*  88 */     if (xCircleTask == null) {
/*  89 */       return false;
/*     */     }
/*  91 */     xCircleTask.setLegendendtime(0L);
/*  92 */     xCircleTask.setTaskid(0);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     int taskNo = ((TaskEventArg)this.arg).taskNo;
/*     */     
/*  99 */     Integer modify = CircleTaskManager.getInstance().getModify(taskNo);
/* 100 */     if (modify == null) {
/* 101 */       logger.error("not find circle task award modify by task no " + taskNo);
/* 102 */       return true;
/*     */     }
/* 104 */     AwardReason reason = new AwardReason(mzm.gsp.tlog.LogReason.PAOHUAN_AWARD_ADD);
/* 105 */     mzm.gsp.award.main.AwardInterface.award(CircleTaskConsts.getInstance().AWARD_TYPE_ID, userId, ((TaskEventArg)this.arg).roleId, modify.intValue(), false, true, reason);
/*     */     
/* 107 */     ActivityLogStatus status = ActivityLogStatus.ATTEND;
/* 108 */     if (TaskInterface.getAllTaskNumInGraph(CircleTaskConsts.getInstance().TASK_GRAPHIC_ID) == ((TaskEventArg)this.arg).taskNo) {
/* 109 */       status = ActivityLogStatus.FINISH;
/*     */     }
/* 111 */     ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, CircleTaskConsts.getInstance().TASK_ACTIVITY_ID, status);
/* 112 */     ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, CircleTaskConsts.getInstance().TASK_ACTIVITY_ID, status);
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean onAcceptTask()
/*     */   {
/* 122 */     List<Integer> itemIdList = TaskInterface.getTaskNeedItem(((TaskEventArg)this.arg).roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID, ((TaskEventArg)this.arg).taskId);
/* 123 */     if (itemIdList.isEmpty()) {
/* 124 */       return true;
/*     */     }
/* 126 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(((TaskEventArg)this.arg).roleId));
/* 127 */     if (xCircleTask == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     if (xCircleTask.getTaskid() == ((TaskEventArg)this.arg).taskId) {
/* 131 */       return false;
/*     */     }
/* 133 */     xCircleTask.setTaskid(((TaskEventArg)this.arg).taskId);
/* 134 */     long legendTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() + CircleTaskConsts.getInstance().LEGEND_TASK_MINUTE * 60 * 1000;
/* 135 */     CircleTaskManager.synLegendTime(((TaskEventArg)this.arg).roleId, legendTime, ((TaskEventArg)this.arg).taskId);
/* 136 */     xCircleTask.setLegendendtime(legendTime);
/* 137 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void checkActivityInit(final long roleId)
/*     */   {
/* 144 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 150 */         String userId = RoleInterface.getUserId(roleId);
/* 151 */         lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 152 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 153 */         ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(RoleInterface.getUserId(roleId), ((TaskEventArg)POnTaskStateChange.this.arg).roleId, CircleTaskConsts.getInstance().TASK_ACTIVITY_ID);
/*     */         
/* 155 */         if (!result.isCanJoin())
/*     */         {
/* 157 */           GameServer.logger().info(String.format("[circle]POnTaskStateChange.onAcceptTask@can not join activity!|roleId=%d|activityId=%d|res=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(CircleTaskConsts.getInstance().TASK_ACTIVITY_ID), Integer.valueOf(result.getReasonValue()) }));
/*     */           
/*     */ 
/*     */ 
/* 161 */           return false;
/*     */         }
/* 163 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */