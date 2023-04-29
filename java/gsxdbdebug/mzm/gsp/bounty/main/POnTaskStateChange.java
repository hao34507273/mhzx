/*     */ package mzm.gsp.bounty.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*     */ import mzm.gsp.activity.confbean.BountyConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.bounty.event.FinishOneTask;
/*     */ import mzm.gsp.bounty.event.FinishOneTaskArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BTaskData;
/*     */ import xbean.BTaskInfo;
/*     */ import xbean.BountyInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2bounty;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskStateChange extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if ((BountyConsts.getInstance().GUIDE_GRAPH_ID == ((TaskEventArg)this.arg).graphId) || (BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID == ((TaskEventArg)this.arg).graphId))
/*     */     {
/*     */ 
/*  34 */       new GuideTaskHand(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, ((TaskEventArg)this.arg).taskId, ((TaskEventArg)this.arg).taskState, ((TaskEventArg)this.arg).isToEnd).execute();
/*     */     }
/*  36 */     if (!BountyManager.isBGraph(((TaskEventArg)this.arg).graphId))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     BountyInfo xBountyInfo = null;
/*  41 */     if ((8 == ((TaskEventArg)this.arg).taskState) || (9 == ((TaskEventArg)this.arg).taskState))
/*     */     {
/*  43 */       int taskId = ((TaskEventArg)this.arg).taskId;
/*  44 */       int rank = BountyManager.getTaskRank(taskId);
/*  45 */       if (rank < 0)
/*     */       {
/*  47 */         rank = 3;
/*     */       }
/*     */       
/*  50 */       String userid = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/*  51 */       lock(Lockeys.get(User.getTable(), userid));
/*     */       
/*  53 */       xBountyInfo = Role2bounty.get(Long.valueOf(((TaskEventArg)this.arg).roleId));
/*  54 */       if (xBountyInfo == null)
/*     */       {
/*  56 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  60 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, ((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID);
/*     */       
/*  62 */       if (!res.isCanJoin())
/*     */       {
/*  64 */         GameServer.logger().error(String.format("[bounty]POnTaskStateChange.processImp@ can not join activity!|roleId=%d|activityId=%d|errCode=%d|taskState=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(BountyConsts.getInstance().ACTIVITYID), Integer.valueOf(res.getReasonValue()), Integer.valueOf(((TaskEventArg)this.arg).taskState) }));
/*     */         
/*     */ 
/*     */ 
/*  68 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  72 */       int count = xBountyInfo.getBountycount() + 1;
/*  73 */       xBountyInfo.setBountycount(count);
/*     */       
/*  75 */       BTaskInfo xBTaskInfo = (BTaskInfo)xBountyInfo.getTaskinfos().get(Integer.valueOf(((TaskEventArg)this.arg).graphId));
/*     */       
/*  77 */       if (8 == ((TaskEventArg)this.arg).taskState)
/*     */       {
/*  79 */         addDoneTask(xBountyInfo, taskId, rank);
/*  80 */         BountyManager.changeBTaskState(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, xBTaskInfo, 2, count);
/*  81 */         FinishOneTaskArg eventArg = new FinishOneTaskArg(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, ((TaskEventArg)this.arg).taskId, count);
/*  82 */         TriggerEventsManger.getInstance().triggerEvent(new FinishOneTask(), eventArg);
/*     */       }
/*  84 */       if (9 == ((TaskEventArg)this.arg).taskState)
/*     */       {
/*  86 */         BountyManager.changeBTaskState(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, xBTaskInfo, 3, count);
/*     */       }
/*     */       
/*  89 */       int num = BountyManager.getFinishTaskNum(xBountyInfo);
/*  90 */       if (num == BountyManager.getBountyTaskNum())
/*     */       {
/*  92 */         Procedure.execute(new PCFlushNewReq(((TaskEventArg)this.arg).roleId, false, 0L, 0L));
/*     */       }
/*     */       
/*  95 */       ActivityInterface.addActivityCount(userid, ((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID);
/*     */       
/*  97 */       ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*  98 */       ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*  99 */       return true;
/*     */     }
/* 101 */     if (2 == ((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */ 
/*     */ 
/* 105 */       String userid = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 106 */       lock(Lockeys.get(User.getTable(), userid));
/*     */       
/* 108 */       xBountyInfo = Role2bounty.get(Long.valueOf(((TaskEventArg)this.arg).roleId));
/* 109 */       if (xBountyInfo == null)
/*     */       {
/* 111 */         return false;
/*     */       }
/* 113 */       if (BountyManager.hasMoreThanXBGraph(((TaskEventArg)this.arg).roleId, 1))
/*     */       {
/* 115 */         GameServer.logger().error(String.format("[bounty]POnTaskStateChange.processImp@ has more than one graph!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId) }));
/*     */         
/*     */ 
/*     */ 
/* 119 */         TaskInterface.closeActivityGraphWithoutEvent(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId);
/* 120 */         return true;
/*     */       }
/* 122 */       BTaskInfo xBTaskInfo = (BTaskInfo)xBountyInfo.getTaskinfos().get(Integer.valueOf(((TaskEventArg)this.arg).graphId));
/*     */       
/* 124 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, ((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID);
/*     */       
/* 126 */       if (!res.isCanJoin())
/*     */       {
/* 128 */         GameServer.logger().error(String.format("[bounty]POnTaskStateChange.processImp@ can not join activity!|roleId=%d|activityId=%d|errCode=%d|taskState", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(BountyConsts.getInstance().ACTIVITYID), Integer.valueOf(res.getReasonValue()), Integer.valueOf(((TaskEventArg)this.arg).taskState) }));
/*     */         
/*     */ 
/*     */ 
/* 132 */         return false;
/*     */       }
/* 134 */       BountyManager.changeBTaskState(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId, xBTaskInfo, 1, xBountyInfo.getBountycount());
/*     */       
/*     */ 
/* 137 */       if (xBountyInfo.getBountycount() == 1)
/*     */       {
/* 139 */         ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 140 */         ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, BountyConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       }
/* 142 */       return true;
/*     */     }
/*     */     
/* 145 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addDoneTask(BountyInfo xBountyInfo, int taskId, int rank)
/*     */   {
/* 157 */     BTaskData xBTaskData = (BTaskData)xBountyInfo.getDonetaskinfo().get(Integer.valueOf(rank));
/* 158 */     if (xBTaskData == null)
/*     */     {
/* 160 */       xBTaskData = Pod.newBTaskData();
/* 161 */       xBountyInfo.getDonetaskinfo().put(Integer.valueOf(rank), xBTaskData);
/*     */     }
/* 163 */     xBTaskData.getTaskids().add(Integer.valueOf(taskId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */