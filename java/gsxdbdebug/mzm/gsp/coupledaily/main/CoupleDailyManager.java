/*     */ package mzm.gsp.coupledaily.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyActivityCfg;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyFightCfg;
/*     */ import mzm.gsp.activity.confbean.SCoupleDailyPinTuCfg;
/*     */ import mzm.gsp.activity.confbean.SXinYouLingXiQuestionCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.coupledaily.SRefreshCoupleDailyInfo;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2CoupleDailyInfo;
/*     */ import xbean.TaskInfo;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ class CoupleDailyManager
/*     */ {
/*     */   static void initCfg()
/*     */   {
/*  32 */     ActivityInterface.registerActivityByLogicType(37, new CoupleDailyActivityHandler());
/*     */     
/*     */ 
/*  35 */     ItemAccessManager.registerActivityReward(CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, CoupleDailyActivityConst.getInstance().FINISH_ALL_TASK_AWARD_ID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getRandomTaskList()
/*     */   {
/*  44 */     List<Integer> taskCfgList = new ArrayList(SCoupleDailyActivityCfg.getAll().keySet());
/*     */     
/*  46 */     List<Integer> taskList = randomList(taskCfgList, CoupleDailyActivityConst.getInstance().RANDOM_TASK_NUM);
/*     */     
/*  48 */     return taskList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Integer> getRandomXinYouLIngXiQuestionList()
/*     */   {
/*  56 */     List<Integer> questionCfgIdList = new ArrayList(SXinYouLingXiQuestionCfg.getAll().keySet());
/*  57 */     List<Integer> randomQuestionList = randomList(questionCfgIdList, CoupleDailyActivityConst.getInstance().QUESTION_NUM);
/*     */     
/*     */ 
/*  60 */     return randomQuestionList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRandomCoupleFightFightId()
/*     */   {
/*  68 */     List<Integer> fightCfgIdList = new ArrayList(SCoupleDailyFightCfg.getAll().keySet());
/*  69 */     int randomIndex = Xdb.random().nextInt(fightCfgIdList.size());
/*     */     
/*  71 */     return SCoupleDailyFightCfg.get(((Integer)fightCfgIdList.get(randomIndex)).intValue()).fightId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRandomPinTuCfgId()
/*     */   {
/*  79 */     List<Integer> pintuCfgIdList = new ArrayList(SCoupleDailyPinTuCfg.getAll().keySet());
/*  80 */     int randomIndex = Xdb.random().nextInt(pintuCfgIdList.size());
/*     */     
/*  82 */     return SCoupleDailyPinTuCfg.get(((Integer)pintuCfgIdList.get(randomIndex)).intValue()).pinTuCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sSyncCoupleDailyInfo(Role2CoupleDailyInfo xLeaderCoupleDailyInfo, List<Long> roleList)
/*     */   {
/*  91 */     SRefreshCoupleDailyInfo sRefreshCoupleDailyInfo = new SRefreshCoupleDailyInfo();
/*  92 */     for (TaskInfo xTaskInfo : xLeaderCoupleDailyInfo.getTasklist())
/*     */     {
/*  94 */       sRefreshCoupleDailyInfo.tasklist.add(Integer.valueOf(xTaskInfo.getCfg_id()));
/*  95 */       if (xTaskInfo.getIs_finish() == 1)
/*     */       {
/*  97 */         sRefreshCoupleDailyInfo.finishtasklist.add(Integer.valueOf(xTaskInfo.getCfg_id()));
/*     */       }
/*     */     }
/* 100 */     boolean isAward = xLeaderCoupleDailyInfo.getIsawarded() == 1;
/* 101 */     sRefreshCoupleDailyInfo.isaward = (isAward ? 1 : 0);
/*     */     
/* 103 */     OnlineManager.getInstance().sendMulti(sRefreshCoupleDailyInfo, roleList);
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
/*     */   static void tlogCoupleDailyTaskResult(long leaderRoleId, long partnerRoleId, int taskCfgId, CoupleDailyTaskResultEnum resultEnum)
/*     */   {
/* 116 */     String leaderUserId = RoleInterface.getUserId(leaderRoleId);
/* 117 */     int leaderRoleLevel = RoleInterface.getLevel(leaderRoleId);
/* 118 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/* 119 */     int partnerRoleLevel = RoleInterface.getLevel(partnerRoleId);
/*     */     
/* 121 */     StringBuilder sbLog = new StringBuilder();
/* 122 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 123 */     sbLog.append(leaderUserId).append('|');
/* 124 */     sbLog.append(leaderRoleId).append('|');
/* 125 */     sbLog.append(leaderRoleLevel).append('|');
/*     */     
/* 127 */     sbLog.append(partnerUserId).append('|');
/* 128 */     sbLog.append(partnerRoleId).append('|');
/* 129 */     sbLog.append(partnerRoleLevel).append('|');
/* 130 */     sbLog.append(taskCfgId).append('|');
/* 131 */     sbLog.append(resultEnum.getResult());
/*     */     
/* 133 */     TLogManager.getInstance().addLog(leaderRoleId, "CoupleDailyTask", sbLog.toString());
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
/*     */   private static List<Integer> randomList(List<Integer> sourceList, int count)
/*     */   {
/* 148 */     int size = sourceList.size();
/* 149 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 151 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 154 */     if (size == count)
/*     */     {
/* 156 */       return new ArrayList(sourceList);
/*     */     }
/*     */     
/* 159 */     Random random = Xdb.random();
/* 160 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 162 */       Collections.swap(sourceList, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 165 */     return new ArrayList(sourceList.subList(size - count, size));
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
/*     */   static boolean isCoupleDailySwitchOpen(long roleId, String logString)
/*     */   {
/* 180 */     if (!OpenInterface.getOpenStatus(54))
/*     */     {
/* 182 */       GameServer.logger().info(String.format("[coupledaily]%s@couple daily system switch closed|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     if (OpenInterface.isBanPlay(roleId, 54))
/*     */     {
/* 190 */       GameServer.logger().info(String.format("[coupledaily]%s@couple daily is ban play|role_id=%d", new Object[] { logString, Long.valueOf(roleId) }));
/*     */       
/* 192 */       OpenInterface.sendBanPlayMsg(roleId, 54);
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\CoupleDailyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */