/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
/*     */ 
/*     */ 
/*     */ public class TaskLogManager
/*     */ {
/*     */   private static final String TLOG_TASK = "Task";
/*     */   
/*     */   static boolean addTaskLog(long roleId, int graphId, int taskId, int taskState, int taskType, long passtime)
/*     */   {
/*  15 */     zLogTask(roleId, taskId, taskState, taskType, passtime);
/*     */     
/*  17 */     tlogTask(roleId, graphId, taskId, taskState, taskType, passtime);
/*     */     
/*  19 */     return true;
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
/*     */   static boolean zLogTask(long roleId, int taskId, int taskState, int taskType, long passtime)
/*     */   {
/*  36 */     int taskStatusLog = getLogState(taskState);
/*     */     
/*  38 */     if (taskStatusLog < -1)
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     int platform = RoleInterface.getPlatform(roleId);
/*  44 */     String channel = RoleInterface.getChannel(roleId);
/*  45 */     String mac = RoleInterface.getMac(roleId);
/*  46 */     String userId = RoleInterface.getUserId(roleId);
/*  47 */     int level = RoleInterface.getLevel(roleId);
/*     */     
/*  49 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%s", new Object[] { Integer.valueOf(platform), channel, mac, userId, Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(taskId), Integer.valueOf(taskStatusLog), Integer.valueOf(taskType), Long.valueOf(passtime), "0" });
/*     */     
/*  51 */     LogManager.getInstance().addLog("task", logStr);
/*     */     
/*  53 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getLogState(int taskState)
/*     */   {
/*  63 */     switch (taskState)
/*     */     {
/*     */     case 2: 
/*  66 */       return 1;
/*     */     
/*     */     case 8: 
/*  69 */       return 2;
/*     */     
/*     */     case 9: 
/*  72 */       return 3;
/*     */     
/*     */     case 5: 
/*  75 */       return 4;
/*     */     
/*     */     case 1: 
/*  78 */       return 5;
/*     */     
/*     */     case 3: 
/*  81 */       return 6;
/*     */     
/*     */     case 6: 
/*     */     case 7: 
/*  85 */       return 7;
/*     */     }
/*     */     
/*  88 */     return -1;
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
/*     */   public static void tlogTask(long roleId, int graphId, int taskId, int taskState, int type, long passtime)
/*     */   {
/* 106 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 107 */     String userid = RoleInterface.getUserId(roleId);
/* 108 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 110 */     String taskName = TaskManager.getInstance().getTaskName(taskId);
/*     */     
/* 112 */     int statue = getLogState(taskState);
/*     */     
/* 114 */     if (statue < 0)
/*     */     {
/* 116 */       return;
/*     */     }
/*     */     
/* 119 */     int taskType = GraphManager.getInstance().getGraphTaskTypeById(graphId);
/* 120 */     if (taskType < 0)
/*     */     {
/* 122 */       return;
/*     */     }
/*     */     
/* 125 */     String logStr = String.format("%s|%s|%d|%d|%d|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(taskId), taskName, Integer.valueOf(statue), Integer.valueOf(taskType), Long.valueOf(passtime), Integer.valueOf(graphId) });
/*     */     
/* 127 */     TLogManager.getInstance().addLog(roleId, "Task", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */