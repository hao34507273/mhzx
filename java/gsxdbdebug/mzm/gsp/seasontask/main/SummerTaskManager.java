/*     */ package mzm.gsp.seasontask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.SSeasonNormalResult;
/*     */ import mzm.gsp.activity.confbean.SSessionSingleModifyCfg;
/*     */ import mzm.gsp.activity.confbean.SessionMultiConsts;
/*     */ import mzm.gsp.activity.confbean.SessionSingleConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.SeasonMultiTaskInfo;
/*     */ import xbean.SeasonTaskInfo;
/*     */ import xtable.Role2seasontaskinfo;
/*     */ 
/*     */ public class SummerTaskManager
/*     */ {
/*     */   static SessionSingleConsts getSconsts()
/*     */   {
/*  30 */     return SessionSingleConsts.getInstance();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SessionMultiConsts getMconsts()
/*     */   {
/*  39 */     return SessionMultiConsts.getInstance();
/*     */   }
/*     */   
/*     */   static int getSIngleCanJoinLevel()
/*     */   {
/*  44 */     return ActivityInterface.getActivityLevelMin(getSingleActivityId());
/*     */   }
/*     */   
/*     */   static int getMultiCanJoinLevel()
/*     */   {
/*  49 */     return ActivityInterface.getActivityLevelMin(getMultiActivityId());
/*     */   }
/*     */   
/*     */   static int getSingleGraph()
/*     */   {
/*  54 */     return getSconsts().TASK_GRAPH_ID;
/*     */   }
/*     */   
/*     */   static int getMultiGraph()
/*     */   {
/*  59 */     return getMconsts().TASK_GRAPH_ID;
/*     */   }
/*     */   
/*     */   static int getSingleNpcId()
/*     */   {
/*  64 */     return getSconsts().NPC_ID;
/*     */   }
/*     */   
/*     */   static int getMultiNpcId()
/*     */   {
/*  69 */     return getMconsts().NPC_ID;
/*     */   }
/*     */   
/*     */   static int getSingleActivityId()
/*     */   {
/*  74 */     return getSconsts().ACTIVITYID;
/*     */   }
/*     */   
/*     */   static int getMultiActivityId()
/*     */   {
/*  79 */     return getMconsts().ACTIVITYID;
/*     */   }
/*     */   
/*     */   static int getSingleCanJoinNum()
/*     */   {
/*  84 */     return getSconsts().NUM_UP;
/*     */   }
/*     */   
/*     */   static int getSingleController()
/*     */   {
/*  89 */     return getSconsts().controller;
/*     */   }
/*     */   
/*     */   static int getMultiController()
/*     */   {
/*  94 */     return getMconsts().controller;
/*     */   }
/*     */   
/*     */   static int getSingleAwardModifyId(int ringNum)
/*     */   {
/*  99 */     SSessionSingleModifyCfg cfg = SSessionSingleModifyCfg.get(ringNum);
/* 100 */     if (cfg == null)
/*     */     {
/* 102 */       return -1;
/*     */     }
/* 104 */     return cfg.modifyId;
/*     */   }
/*     */   
/*     */   static int getSingleAwardId()
/*     */   {
/* 109 */     return getSconsts().AWARD_ID;
/*     */   }
/*     */   
/*     */   static int getMultiAwardId()
/*     */   {
/* 114 */     return getMconsts().AWARD_ID;
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/* 119 */     ActivityInterface.registerActivityByLogicType(27, new PMultiTaskInit());
/* 120 */     ActivityInterface.registerActivityByLogicType(26, new PSingleTaskInit());
/*     */   }
/*     */   
/*     */   static void check()
/*     */   {
/* 125 */     if (!AwardInterface.hasAwardId(getMultiAwardId()))
/*     */     {
/* 127 */       throw new RuntimeException(String.format("节日多人活动常量表:奖励id不存在！@awardId=%d", new Object[] { Integer.valueOf(getMultiAwardId()) }));
/*     */     }
/* 129 */     if (!AwardInterface.hasAwardId(getSingleAwardId()))
/*     */     {
/* 131 */       throw new RuntimeException(String.format("节日单人活动常量表:奖励id不存在！@awardId=%d", new Object[] { Integer.valueOf(getSingleAwardId()) }));
/*     */     }
/* 133 */     if (!TaskInterface.isHaveGraphId(getMultiGraph()))
/*     */     {
/* 135 */       throw new RuntimeException(String.format("节日多人活动常量表:任务图id不存在！@graphId=%d", new Object[] { Integer.valueOf(getMultiGraph()) }));
/*     */     }
/* 137 */     if (!TaskInterface.isHaveGraphId(getSingleGraph()))
/*     */     {
/* 139 */       throw new RuntimeException(String.format("节日单人活动常量表:任务图id不存在！@graphId=%d", new Object[] { Integer.valueOf(getSingleGraph()) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void process()
/*     */   {
/* 149 */     ItemAccessManager.registerActivityReward(getSingleActivityId(), getSingleAwardId());
/* 150 */     ItemAccessManager.registerActivityReward(getMultiActivityId(), getMultiAwardId());
/*     */   }
/*     */   
/*     */   static boolean canJoinSingleTask(String userid, long roleId)
/*     */   {
/* 155 */     int ringNum = ActivityInterface.getActivityCount(userid, roleId, getSingleActivityId(), false);
/* 156 */     if (ringNum >= getSingleCanJoinNum())
/*     */     {
/* 158 */       sendNormalResult(roleId, 20, new String[0]);
/* 159 */       return false;
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   static boolean giveSingleAward(long roleId, String userId, int ringNum, boolean isSingleOpen)
/*     */   {
/* 166 */     if (!isSingleOpen)
/*     */     {
/* 168 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 170 */         GameServer.logger().debug(String.format("[seasontask]SummerTaskManager.giveSingleAward@ role is ban state|roleId=%d|ringNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(ringNum) }));
/*     */       }
/*     */       
/*     */ 
/* 174 */       return true;
/*     */     }
/* 176 */     int modifyId = getSingleAwardModifyId(ringNum);
/* 177 */     if (modifyId <= 0)
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     AwardReason reason = new AwardReason(LogReason.SUMMER_SINGLE_TASK_AWARD_ADD);
/* 182 */     AwardModel am = AwardInterface.award(getSingleAwardId(), userId, roleId, modifyId, false, true, reason);
/* 183 */     if (am == null)
/*     */     {
/* 185 */       return false;
/*     */     }
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   static int getSingleCircleCanGetStorageExp(long roleId)
/*     */   {
/* 192 */     String userid = RoleInterface.getUserId(roleId);
/* 193 */     if (!ActivityInterface.isInActivityLevel(userid, roleId, getSingleActivityId()))
/*     */     {
/* 195 */       return 0;
/*     */     }
/* 197 */     int totalStorageExp = 0;
/* 198 */     for (SSessionSingleModifyCfg cfg : SSessionSingleModifyCfg.getAll().values())
/*     */     {
/* 200 */       int modId = cfg.modifyId;
/* 201 */       if (modId > 0)
/*     */       {
/*     */ 
/*     */ 
/* 205 */         AwardReason reason = new AwardReason(LogReason.SUMMER_SINGLE_TASK_STORAGE_EXP_CAL);
/* 206 */         reason.setJustQuery(true);
/* 207 */         AwardModel am = AwardInterface.getRoleAwardModel(getSingleAwardId(), roleId, modId, reason);
/* 208 */         if (am.getRoleExp() > 0)
/*     */         {
/*     */ 
/*     */ 
/* 212 */           totalStorageExp += am.getRoleExp() * getSconsts().STORAGE_EXCHANGE_RET / 10000; }
/*     */       } }
/* 214 */     return totalStorageExp > 0 ? totalStorageExp : 0;
/*     */   }
/*     */   
/*     */   static int getSingleActivityXRingStorageExp(long roleId, int ringNum)
/*     */   {
/* 219 */     String userid = RoleInterface.getUserId(roleId);
/* 220 */     if (!ActivityInterface.isInActivityLevel(userid, roleId, getSingleActivityId()))
/*     */     {
/* 222 */       return 0;
/*     */     }
/* 224 */     int modId = getSingleAwardModifyId(ringNum);
/* 225 */     if (modId <= 0)
/*     */     {
/* 227 */       return 0;
/*     */     }
/* 229 */     AwardReason reason = new AwardReason(LogReason.SUMMER_SINGLE_TASK_STORAGE_EXP_CAL);
/* 230 */     reason.setJustQuery(true);
/* 231 */     AwardModel am = AwardInterface.getRoleAwardModel(getSingleAwardId(), roleId, modId, reason);
/* 232 */     int roleExp = am.getRoleExp();
/* 233 */     if (roleExp > 0)
/*     */     {
/* 235 */       roleExp = roleExp * getSconsts().STORAGE_EXCHANGE_RET / 10000;
/*     */     }
/*     */     else
/*     */     {
/* 239 */       roleExp = 0;
/*     */     }
/* 241 */     return roleExp;
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result, String... args)
/*     */   {
/* 246 */     SSeasonNormalResult pro = new SSeasonNormalResult();
/* 247 */     pro.result = result;
/* 248 */     for (String arg : args)
/*     */     {
/* 250 */       pro.args.add(arg);
/*     */     }
/* 252 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addNewStep(long roleId, int curRing)
/*     */   {
/* 264 */     SeasonTaskInfo xInfo = Role2seasontaskinfo.get(Long.valueOf(roleId));
/* 265 */     if (xInfo == null)
/*     */     {
/* 267 */       return false;
/*     */     }
/* 269 */     List<Integer> steps = xInfo.getMultiinfo().getFinishsteps();
/* 270 */     if (steps == null)
/*     */     {
/* 272 */       return false;
/*     */     }
/* 274 */     if (steps.contains(Integer.valueOf(curRing)))
/*     */     {
/* 276 */       return false;
/*     */     }
/* 278 */     steps.add(Integer.valueOf(curRing));
/* 279 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMultiTaskNum()
/*     */   {
/* 289 */     return TaskInterface.getAllTaskNumInGraph(getMultiGraph());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean allFinished(int count)
/*     */   {
/* 300 */     if (getMultiTaskNum() > count)
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isSingleOpen(long roleId)
/*     */   {
/* 314 */     if (!OpenInterface.getOpenStatus(19))
/*     */     {
/* 316 */       return false;
/*     */     }
/* 318 */     if (OpenInterface.isBanPlay(roleId, 19))
/*     */     {
/* 320 */       OpenInterface.sendBanPlayMsg(roleId, 19);
/* 321 */       return false;
/*     */     }
/* 323 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMultiOpen(long roleId)
/*     */   {
/* 333 */     if (!OpenInterface.getOpenStatus(20))
/*     */     {
/* 335 */       return false;
/*     */     }
/* 337 */     if (OpenInterface.isBanPlay(roleId, 20))
/*     */     {
/* 339 */       OpenInterface.sendBanPlayMsg(roleId, 20);
/* 340 */       return false;
/*     */     }
/* 342 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\SummerTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */