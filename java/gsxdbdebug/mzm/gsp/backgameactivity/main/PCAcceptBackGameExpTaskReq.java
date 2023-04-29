/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityTaskCfg;
/*     */ import mzm.gsp.backgameactivity.SAcceptBackGameExpTaskFail;
/*     */ import mzm.gsp.backgameactivity.SAcceptBackGameExpTaskSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2backgameactivity;
/*     */ 
/*     */ public class PCAcceptBackGameExpTaskReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCAcceptBackGameExpTaskReq(long roleId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  34 */     if (!BackGameActivityManager.isBackGameActivityOpen(this.roleId))
/*     */     {
/*  36 */       String logStr = String.format("[backgameactivity]PCAcceptBackGameExpTaskReq.processImp@BackGameActivity not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  38 */       GameServer.logger().info(logStr);
/*  39 */       return false;
/*     */     }
/*  41 */     if (!isBackGameTaskOpen(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[backgameactivity]PCAcceptBackGameExpTaskReq.processImp@BackGameActivityAward not open!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  46 */       GameServer.logger().info(logStr);
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  52 */     if (null == teamId)
/*     */     {
/*  54 */       onFail(-2);
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     List<Long> roleIds = TeamInterface.getNormalRoleList(this.roleId);
/*  60 */     lock(Basic.getTable(), roleIds);
/*  61 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*     */     
/*  63 */     if (null == teamInfo)
/*     */     {
/*  65 */       onFail(-2);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1674, true, true))
/*     */     {
/*  72 */       String logStr = String.format("[backgameactivity]PCAcceptBackGameExpTaskReq.processImp@state confict!|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  74 */       GameServer.logger().info(logStr);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/*  81 */       onFail(-3);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(this.roleId));
/*  87 */     if (null == xBackGameActivityInfo)
/*     */     {
/*  89 */       onFail(-1);
/*  90 */       return false;
/*     */     }
/*  92 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */     {
/*  94 */       onFail(-1);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(xBackGameActivityInfo.getActivity_id());
/* 100 */     SBackGameActivityTaskCfg sBackGameActivityTaskCfg = SBackGameActivityTaskCfg.get(sBackGameActivityCfg.taskCfgId);
/*     */     
/*     */ 
/* 103 */     if (teamInfo.getTeamNormalList().size() < sBackGameActivityTaskCfg.memberCount)
/*     */     {
/* 105 */       onFail(-4);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 111 */     long lastGetTaskAwardTime = xBackGameActivityInfo.getLast_get_task_award_time();
/* 112 */     if (!DateTimeUtils.needDailyReset(lastGetTaskAwardTime, currentTime, 0))
/*     */     {
/* 114 */       onFail(-6);
/* 115 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 119 */     int graphId = sBackGameActivityTaskCfg.graphId;
/* 120 */     if (TaskInterface.isHaveGraphId(this.roleId, graphId))
/*     */     {
/* 122 */       onFail(-5);
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     int firstTaskId = TaskInterface.getFristTaskId(graphId);
/* 128 */     if (firstTaskId < 0)
/*     */     {
/* 130 */       String logStr = String.format("[backgameactivity]PCAcceptBackGameExpTaskReq.onSuccess@graph config not exist!|roleId=%d,activityId=%d,graphId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xBackGameActivityInfo.getActivity_id()), Integer.valueOf(graphId) });
/*     */       
/*     */ 
/* 133 */       GameServer.logger().error(logStr);
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     TaskInterface.acceptGraphXTask(this.roleId, graphId, TaskInterface.getFristTaskId(graphId));
/* 138 */     onSuccess(xBackGameActivityInfo.getActivity_id(), sBackGameActivityCfg.taskCfgId, xBackGameActivityInfo.getJoin_time());
/*     */     
/* 140 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBackGameTaskOpen(long roleId)
/*     */   {
/* 150 */     if (!OpenInterface.getOpenStatus(422))
/*     */     {
/* 152 */       return false;
/*     */     }
/* 154 */     if (OpenInterface.isBanPlay(roleId, 422))
/*     */     {
/* 156 */       OpenInterface.sendBanPlayMsg(roleId, 422);
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(int activityId, int backGameTaskCfgId, long joinActivityTime)
/*     */   {
/* 165 */     String logStr = String.format("[backgameactivity]PCAcceptBackGameExpTaskReq.onSuccess@accept back game task successed!|roleId=%d,activityId=%d,backGameTaskCfgId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(activityId), Integer.valueOf(backGameTaskCfgId) });
/*     */     
/*     */ 
/* 168 */     GameServer.logger().info(logStr);
/*     */     
/*     */ 
/* 171 */     BackGameActivityTlogManager.addBackGameActivityExpTaskAcceptTlog(this.roleId, activityId, joinActivityTime);
/*     */     
/*     */ 
/* 174 */     OnlineManager.getInstance().send(this.roleId, new SAcceptBackGameExpTaskSuccess());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 184 */     String logStr = String.format("[backgameactivity]PCAcceptBackGameExpTaskReq.onFail@accept back game task failed!|roleId=%d,errorCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 187 */     GameServer.logger().info(logStr);
/* 188 */     SAcceptBackGameExpTaskFail protocol = new SAcceptBackGameExpTaskFail(errorCode);
/* 189 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PCAcceptBackGameExpTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */