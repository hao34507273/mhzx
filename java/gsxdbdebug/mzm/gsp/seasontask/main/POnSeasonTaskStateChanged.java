/*     */ package mzm.gsp.seasontask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.seasontask.event.FinishOneTaskArg;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.SeasonTaskInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2seasontaskinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnSeasonTaskStateChanged extends mzm.gsp.task.event.TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     int graphId = ((TaskEventArg)this.arg).graphId;
/*  33 */     if (graphId == SummerTaskManager.getSingleGraph())
/*     */     {
/*  35 */       return singleTaskPro();
/*     */     }
/*  37 */     if (graphId == SummerTaskManager.getMultiGraph())
/*     */     {
/*  39 */       return multiTaskPro();
/*     */     }
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   private boolean singleTaskPro()
/*     */   {
/*  46 */     int graphId = ((TaskEventArg)this.arg).graphId;
/*  47 */     long roleId = ((TaskEventArg)this.arg).roleId;
/*  48 */     int activityId = SummerTaskManager.getSingleActivityId();
/*     */     
/*     */ 
/*  51 */     String userId = RoleInterface.getUserId(roleId);
/*  52 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  54 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/*     */ 
/*  57 */     if (!SummerTaskManager.isSingleOpen(roleId))
/*     */     {
/*  59 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId);
/*  60 */       return true;
/*     */     }
/*     */     
/*  63 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */ 
/*     */     case 8: 
/*  67 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, SummerTaskManager.getSingleActivityId());
/*     */       
/*  69 */       if (!res.isCanJoin())
/*     */       {
/*  71 */         GameServer.logger().error(String.format("[singleTask]POnSeasonTaskStateChanged.singleTaskPro@ can not join activity!|roleId=%d|res=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(res.getReasonValue()) }));
/*     */         
/*     */ 
/*     */ 
/*  75 */         return false;
/*     */       }
/*     */       
/*  78 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*  79 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/*  82 */       boolean ret = ActivityInterface.addActivityCount(userId, ((TaskEventArg)this.arg).roleId, activityId);
/*  83 */       if (!ret)
/*     */       {
/*  85 */         GameServer.logger().error(String.format("[singleTask]POnSeasonTaskStateChanged.singleTaskPro@ addActivityCount err!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */         
/*     */ 
/*     */ 
/*  89 */         return false;
/*     */       }
/*  91 */       int ringNum = ActivityInterface.getActivityCount(userId, roleId, activityId, false);
/*  92 */       if (ringNum <= 0)
/*     */       {
/*  94 */         GameServer.logger().error(String.format("[singleTask]POnSeasonTaskStateChanged.singleTaskPro@ getActivityCount err!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */         
/*     */ 
/*     */ 
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       boolean isSingleOpen = SummerTaskManager.isSingleOpen(roleId);
/* 102 */       if (!SummerTaskManager.giveSingleAward(roleId, userId, ringNum, isSingleOpen))
/*     */       {
/* 104 */         GameServer.logger().error(String.format("[singleTask]POnSeasonTaskStateChanged.singleTaskPro@ giveSingleAward err!|roleId=%d|ringNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ringNum) }));
/*     */         
/*     */ 
/*     */ 
/* 108 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 112 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.seasontask.event.FinishOneSeasonTask(), new FinishOneTaskArg(roleId, graphId, ((TaskEventArg)this.arg).taskId, ringNum));
/*     */       
/*     */ 
/* 115 */       if (ringNum >= SummerTaskManager.getSingleCanJoinNum())
/*     */       {
/* 117 */         if (!TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId))
/*     */         {
/* 119 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 124 */       else if (isSingleOpen)
/*     */       {
/* 126 */         doNextTask(userId, roleId, graphId, activityId);
/*     */       }
/*     */       
/* 129 */       return true;
/*     */     
/*     */ 
/*     */     case 2: 
/* 133 */       ActivityJoinResult joinRes = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/* 134 */       if (!joinRes.isCanJoin())
/*     */       {
/* 136 */         GameServer.logger().error(String.format("[singleTask]POnSeasonTaskStateChanged.singleTaskPro@ can not join, already accept state!|roleId=%d|activityId=%d|res=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(joinRes.getReasonValue()) }));
/*     */         
/*     */ 
/*     */ 
/* 140 */         return false;
/*     */       }
/*     */       
/* 143 */       int count = ActivityInterface.getActivityCount(userId, roleId, activityId, true);
/* 144 */       TaskInterface.setGraphFinishNum(roleId, graphId, count % getOnCircleTaskNum(graphId));
/*     */       
/* 146 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/* 147 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/*     */       
/* 149 */       return true;
/*     */     
/*     */     case 9: 
/* 152 */       return false; }
/*     */     
/* 154 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getOnCircleTaskNum(int graphId)
/*     */   {
/* 161 */     return TaskInterface.getAllTaskNumInGraph(graphId);
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
/*     */   private void doNextTask(String userId, long roleId, int graphId, int activityId)
/*     */   {
/* 174 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, SummerTaskManager.getSingleActivityId());
/*     */     
/* 176 */     if (!res.isCanJoin())
/*     */     {
/* 178 */       GameServer.logger().error(String.format("[seasonTask]POnSeasonTaskStateChanged.singleTaskPro@ forbid join!|roleId=%d|activityId=%d|errcode=%d ", new Object[] { Long.valueOf(roleId), Integer.valueOf(SummerTaskManager.getSingleActivityId()), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 182 */       return;
/*     */     }
/*     */     
/* 185 */     int ringNumNow = ActivityInterface.getActivityCount(userId, roleId, activityId, false);
/* 186 */     if (ringNumNow == 0)
/*     */     {
/*     */ 
/* 189 */       return;
/*     */     }
/* 191 */     TaskInterface.goNextTask(roleId, graphId);
/*     */   }
/*     */   
/*     */   private boolean multiTaskPro()
/*     */   {
/* 196 */     long roleId = ((TaskEventArg)this.arg).roleId;
/* 197 */     int activityId = SummerTaskManager.getMultiActivityId();
/*     */     
/*     */ 
/* 200 */     if (!SummerTaskManager.isMultiOpen(roleId))
/*     */     {
/* 202 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, ((TaskEventArg)this.arg).graphId);
/* 203 */       return true;
/*     */     }
/*     */     
/* 206 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */     case 8: 
/* 209 */       List<Long> allRoleList = new ArrayList(((TaskEventArg)this.arg).getAllRoleList());
/* 210 */       List<Long> finishRoleList = ((TaskEventArg)this.arg).getRoleList();
/* 211 */       AwardReason reason = new AwardReason(mzm.gsp.tlog.LogReason.SUMMER_SINGLE_TASK_AWARD_ADD);
/* 212 */       int awardId = SummerTaskManager.getMultiAwardId();
/* 213 */       int curRing = ((TaskEventArg)this.arg).taskNo;
/* 214 */       AwardModel am = null;
/*     */       
/* 216 */       int roleLevel = RoleInterface.getLevel(roleId);
/* 217 */       if (roleLevel < SummerTaskManager.getMultiCanJoinLevel())
/*     */       {
/* 219 */         return false;
/*     */       }
/*     */       
/* 222 */       if ((allRoleList.size() > 0) && (finishRoleList.size() > 0))
/*     */       {
/*     */ 
/* 225 */         Map<Long, String> roleidToUserid = lockAllUser(allRoleList);
/* 226 */         lock(Lockeys.get(Basic.getTable(), allRoleList));
/* 227 */         if (!allRoleList.contains(Long.valueOf(roleId)))
/*     */         {
/* 229 */           return false;
/*     */         }
/* 231 */         getAwardRoleIds(allRoleList);
/* 232 */         if (allRoleList.size() <= 0)
/*     */         {
/* 234 */           return false;
/*     */         }
/*     */         
/* 237 */         ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, allRoleList, SummerTaskManager.getMultiActivityId());
/*     */         
/* 239 */         if (!res.isCanJoin())
/*     */         {
/* 241 */           GameServer.logger().error(String.format("[seasonTask]POnSeasonTaskStateChanged.multiTaskPro@ forbid join!|roleId=%d|activityId=%d|errcode=%d ", new Object[] { Long.valueOf(roleId), Integer.valueOf(SummerTaskManager.getMultiActivityId()), Integer.valueOf(res.getReasonValue()) }));
/*     */           
/*     */ 
/*     */ 
/* 245 */           return false;
/*     */         }
/*     */         
/* 248 */         am = AwardInterface.getRoleAwardModel(awardId, roleId, -1, finishRoleList, allRoleList, reason);
/*     */         
/* 250 */         if (!newStepHand(roleId, activityId, reason, curRing, am, ((TaskEventArg)this.arg).isToEnd))
/*     */         {
/* 252 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 259 */         String userId = RoleInterface.getUserId(roleId);
/* 260 */         lock(Lockeys.get(User.getTable(), userId));
/*     */         
/* 262 */         am = AwardInterface.getRoleAwardModel(awardId, roleId, -1, reason);
/* 263 */         if (!newStepHand(roleId, activityId, reason, curRing, am, ((TaskEventArg)this.arg).isToEnd))
/*     */         {
/* 265 */           return false;
/*     */         }
/*     */       }
/* 268 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/* 269 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*     */       
/* 271 */       return true;
/*     */     
/*     */     case 2: 
/* 274 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/* 275 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.ATTEND);
/*     */       
/* 277 */       return true;
/*     */     
/*     */     case 9: 
/* 280 */       return false;
/*     */     }
/* 282 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void getAwardRoleIds(List<Long> allRoleList)
/*     */   {
/* 289 */     Iterator<Long> it = allRoleList.iterator();
/* 290 */     while (it.hasNext())
/*     */     {
/* 292 */       long member = ((Long)it.next()).longValue();
/* 293 */       int level = RoleInterface.getLevel(member);
/* 294 */       if (level < SummerTaskManager.getMultiCanJoinLevel())
/*     */       {
/*     */ 
/*     */ 
/* 298 */         it.remove();
/*     */       }
/*     */     }
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
/*     */   private boolean newStepHand(long roleId, int activityId, AwardReason reason, int curRing, AwardModel am, boolean isToEnd)
/*     */   {
/* 315 */     SeasonTaskInfo xInfo = Role2seasontaskinfo.get(Long.valueOf(roleId));
/* 316 */     if (xInfo == null)
/*     */     {
/* 318 */       return false;
/*     */     }
/* 320 */     List<Integer> steps = xInfo.getMultiinfo().getFinishsteps();
/* 321 */     if (steps == null)
/*     */     {
/* 323 */       return false;
/*     */     }
/* 325 */     if (!steps.contains(Integer.valueOf(curRing)))
/*     */     {
/* 327 */       steps.add(Integer.valueOf(curRing));
/* 328 */       String userId = RoleInterface.getUserId(roleId);
/* 329 */       if (SummerTaskManager.isMultiOpen(roleId))
/*     */       {
/* 331 */         if (!AwardInterface.awardToRoleByAwardModel(userId, roleId, am, false, true, reason))
/*     */         {
/* 333 */           return false;
/*     */         }
/*     */       }
/* 336 */       if (SummerTaskManager.allFinished(steps.size()))
/*     */       {
/* 338 */         ActivityInterface.addActivityCount(userId, roleId, activityId);
/*     */       }
/*     */     }
/* 341 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, String> lockAllUser(List<Long> members)
/*     */   {
/* 352 */     if ((members == null) || (members.size() == 0))
/*     */     {
/* 354 */       return null;
/*     */     }
/* 356 */     Map<Long, String> roleId2userId = new HashMap();
/* 357 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 359 */       String userid = RoleInterface.getUserId(roleId);
/* 360 */       roleId2userId.put(Long.valueOf(roleId), userid);
/*     */     }
/* 362 */     if (roleId2userId.size() == 0)
/*     */     {
/* 364 */       return null;
/*     */     }
/*     */     
/* 367 */     lock(User.getTable(), roleId2userId.values());
/* 368 */     return roleId2userId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void closeAllMembersGraphAsyn(long roleId, int graphId)
/*     */   {
/* 379 */     new PCloseTeamMembersGraph(roleId, graphId).execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\POnSeasonTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */