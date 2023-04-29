/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityTaskCfg;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgameactivity.SBackGameExpTaskFinish;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2backgameactivity;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskStateChange extends mzm.gsp.task.event.TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */   {
/*  28 */     if (!BackGameActivityManager.isBackGameActivityOpen(((TaskEventArg)this.arg).roleId))
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     if (!PCAcceptBackGameExpTaskReq.isBackGameTaskOpen(((TaskEventArg)this.arg).roleId))
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  38 */     BackGameActivityInfo xBackGameActivityInfoData = Role2backgameactivity.select(Long.valueOf(((TaskEventArg)this.arg).roleId));
/*  39 */     if (null == xBackGameActivityInfoData)
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(xBackGameActivityInfoData.getActivity_id());
/*  46 */     if (null == sBackGameActivityCfg)
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     SBackGameActivityTaskCfg sBackGameActivityTaskCfg = SBackGameActivityTaskCfg.get(sBackGameActivityCfg.taskCfgId);
/*     */     
/*     */ 
/*  53 */     if (((TaskEventArg)this.arg).graphId != sBackGameActivityTaskCfg.graphId)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if ((((TaskEventArg)this.arg).taskState != 8) || (!((TaskEventArg)this.arg).isToEnd))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     Long teamId = TeamInterface.getTeamidByRoleid(((TaskEventArg)this.arg).roleId, false);
/*  66 */     if (null == teamId)
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), ((TaskEventArg)this.arg).roleId, false))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     List<Long> teamMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*     */     
/*     */ 
/*  81 */     Map<String, Long> userId2RoleId = new HashMap();
/*  82 */     for (Iterator i$ = teamMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  84 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/*  85 */       if (null == userId)
/*     */       {
/*  87 */         GameServer.logger().error(String.format("[backgameactivity]POnTaskStateChange.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */         
/*  89 */         return false;
/*     */       }
/*  91 */       userId2RoleId.put(userId, Long.valueOf(roleId));
/*     */     }
/*     */     
/*  94 */     lock(User.getTable(), userId2RoleId.keySet());
/*  95 */     lock(Basic.getTable(), teamMembers);
/*     */     
/*     */ 
/*  98 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/*  99 */     for (Map.Entry<String, Long> entry : userId2RoleId.entrySet())
/*     */     {
/* 101 */       String userId = (String)entry.getKey();
/* 102 */       long roleId = ((Long)entry.getValue()).longValue();
/*     */       
/*     */ 
/* 105 */       BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(roleId));
/* 106 */       if (null == xBackGameActivityInfo)
/*     */       {
/* 108 */         xBackGameActivityInfo = BackGameActivityManager.initEmptyBackGameActivityInfo(roleId);
/*     */       }
/*     */       
/*     */ 
/* 112 */       long lastGetTaskAwardTime = xBackGameActivityInfo.getLast_get_task_award_time();
/* 113 */       if (DateTimeUtils.needDailyReset(lastGetTaskAwardTime, currentTime, 0))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 119 */         int awardId = sBackGameActivityTaskCfg.awardId;
/* 120 */         mzm.gsp.award.main.AwardModel result = mzm.gsp.award.main.AwardInterface.award(awardId, userId, roleId, false, true, new AwardReason(LogReason.BACK_GAME_ACTIVITY_GIFT_TASK_AWARD));
/*     */         
/* 122 */         if (null == result)
/*     */         {
/* 124 */           String logStr = String.format("[backgameactivity]POnTaskStateChange.processImp@get award fail!|roleId=%d,awardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId) });
/*     */           
/* 126 */           GameServer.logger().error(logStr);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 131 */           xBackGameActivityInfo.setLast_get_task_award_time(currentTime);
/*     */           
/*     */ 
/* 134 */           OnlineManager.getInstance().send(roleId, new SBackGameExpTaskFinish(currentTime));
/*     */           
/*     */ 
/* 137 */           BackGameActivityTlogManager.addBackGameActivityExpTaskFinishTlog(roleId, xBackGameActivityInfo.getActivity_id(), xBackGameActivityInfo.getJoin_time(), ((TaskEventArg)this.arg).graphId, ((TaskEventArg)this.arg).taskId);
/*     */         }
/*     */       }
/*     */     }
/* 141 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */