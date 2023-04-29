/*     */ package mzm.gsp.factiontask.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.factiontask.event.FinishOneTask;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnGangTaskStateChanged extends mzm.gsp.task.event.TaskStateChangeProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int activityId;
/*     */   private int graphId;
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     this.graphId = ((TaskEventArg)this.arg).graphId;
/*  27 */     if (this.graphId != GangTaskManager.getGangTaskGraph())
/*     */     {
/*  29 */       return false;
/*     */     }
/*  31 */     this.roleId = ((TaskEventArg)this.arg).roleId;
/*  32 */     this.activityId = GangTaskManager.getGangTaskActivityId();
/*     */     
/*     */ 
/*  35 */     if (!GangTaskManager.isFactionTaskOpen(this.roleId))
/*     */     {
/*  37 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleId, ((TaskEventArg)this.arg).graphId);
/*  38 */       return true;
/*     */     }
/*     */     
/*  41 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */     case 8: 
/*  44 */       return onHandUp();
/*     */     
/*     */     case 2: 
/*  47 */       return onAlreadyAccept();
/*     */     
/*     */     case 9: 
/*  50 */       return onGiveUp();
/*     */     }
/*     */     
/*  53 */     return false;
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
/*     */   private boolean onAlreadyAccept()
/*     */   {
/*  66 */     String userId = RoleInterface.getUserId(this.roleId);
/*  67 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  69 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  71 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*  72 */     if (!res.isCanJoin())
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[factionTask]POnGangTaskStateChanged.onAlreadyAccept@ can not join!|roleId=%d|activityId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     int count = ActivityInterface.getActivityCount(userId, this.roleId, this.activityId, true);
/*  82 */     TaskInterface.setGraphFinishNum(this.roleId, this.graphId, count % getOnCircleTaskNum());
/*     */     
/*  84 */     ActivityInterface.logActivity(this.roleId, this.activityId, ActivityLogStatus.ATTEND);
/*  85 */     ActivityInterface.tlogActivity(this.roleId, this.activityId, ActivityLogStatus.ATTEND);
/*  86 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean onHandUp()
/*     */   {
/*  92 */     String userId = RoleInterface.getUserId(this.roleId);
/*  93 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  95 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  97 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*  98 */     if (!res.isCanJoin())
/*     */     {
/* 100 */       GameServer.logger().error(String.format("[factionTask]POnGangTaskStateChanged.onHandUp@ can not join!|roleId=%d|activityId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     boolean ret = ActivityInterface.addActivityCount(userId, this.roleId, this.activityId);
/* 109 */     if (!ret)
/*     */     {
/* 111 */       GameServer.logger().error(String.format("[factionTask]POnGangTaskStateChanged.onHandUp@ add activity count error!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 115 */       return false;
/*     */     }
/* 117 */     int ringNum = ActivityInterface.getActivityCount(userId, this.roleId, this.activityId, false);
/* 118 */     if (ringNum < 0)
/*     */     {
/* 120 */       return false;
/*     */     }
/* 122 */     if (ringNum == 1)
/*     */     {
/* 124 */       TaskInterface.setGraphFinishNum(this.roleId, this.graphId, 1);
/*     */     }
/* 126 */     boolean isOpen = GangTaskManager.isFactionTaskOpen(this.roleId);
/* 127 */     if (!GangTaskManager.giveAward(this.roleId, userId, ringNum, isOpen))
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     TriggerEventsManger.getInstance().triggerEvent(new FinishOneTask(), new mzm.gsp.factiontask.event.TaskArg(this.roleId, this.graphId, ((TaskEventArg)this.arg).taskId));
/*     */     
/* 135 */     ActivityInterface.logActivity(this.roleId, this.activityId, ActivityLogStatus.FINISH);
/* 136 */     ActivityInterface.tlogActivity(this.roleId, this.activityId, ActivityLogStatus.FINISH);
/*     */     
/* 138 */     return afterTaskStateChange(userId, this.graphId, this.roleId, ringNum, isOpen);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean onGiveUp()
/*     */   {
/* 144 */     String userId = RoleInterface.getUserId(this.roleId);
/* 145 */     lock(Lockeys.get(User.getTable(), userId));
/* 146 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 147 */     if (!GangTaskManager.cancelPerfect(this.roleId))
/*     */     {
/*     */ 
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/* 154 */     if (!res.isCanJoin())
/*     */     {
/* 156 */       GameServer.logger().error(String.format("[factionTask]POnGangTaskStateChanged.onGiveUp@ can not join!|roleId=%d|activityId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 160 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 164 */     boolean addRet = ActivityInterface.addActivityCount(userId, ((TaskEventArg)this.arg).roleId, this.activityId);
/* 165 */     if (!addRet)
/*     */     {
/* 167 */       return false;
/*     */     }
/* 169 */     int ringNum = ActivityInterface.getActivityCount(userId, this.roleId, this.activityId, false);
/* 170 */     if (ringNum < 0)
/*     */     {
/* 172 */       return false;
/*     */     }
/* 174 */     if (ringNum == 1)
/*     */     {
/* 176 */       TaskInterface.setGraphFinishNum(this.roleId, this.graphId, 1);
/*     */     }
/* 178 */     if (GangTaskManager.isFactionTaskOpen(this.roleId))
/*     */     {
/* 180 */       if (!GangTaskManager.giveExAward(this.roleId, userId, ringNum))
/*     */       {
/* 182 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 186 */     return true;
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
/*     */   private boolean afterTaskStateChange(String userId, int graphId, long roleId, int ringNum, boolean isOpen)
/*     */   {
/* 201 */     if (ringNum >= GangTaskManager.getPerfectRingNum())
/*     */     {
/* 203 */       if (!TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId))
/*     */       {
/* 205 */         return false;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */     }
/* 212 */     else if (isOpen)
/*     */     {
/* 214 */       TaskInterface.goNextTask(roleId, graphId);
/*     */     }
/*     */     
/* 217 */     return true;
/*     */   }
/*     */   
/*     */   int getOnCircleTaskNum()
/*     */   {
/* 222 */     return 10;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\POnGangTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */