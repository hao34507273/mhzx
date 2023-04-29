/*     */ package mzm.gsp.singlebattle.task;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.SSynRoleTaskInfo;
/*     */ import mzm.gsp.singlebattle.SSynRoleTaskParam;
/*     */ import mzm.gsp.singlebattle.confbean.SBattleTaskCfg;
/*     */ import mzm.gsp.singlebattle.main.RoleBattleBaseInfo;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*     */ import xbean.RoleBattleTaskData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BattleTaskManager
/*     */ {
/*     */   static void synRoleTaskDatas(long roleId, RoleBattleTaskData xRoleBattleTaskData)
/*     */   {
/*  25 */     if (xRoleBattleTaskData == null)
/*     */     {
/*  27 */       return;
/*     */     }
/*  29 */     SSynRoleTaskInfo syn = new SSynRoleTaskInfo();
/*  30 */     for (Map.Entry<Integer, xbean.BattleTaskData> xEntry : xRoleBattleTaskData.getTaskdatas().entrySet())
/*     */     {
/*  32 */       syn.taskdatas.put(xEntry.getKey(), new mzm.gsp.singlebattle.BattleTaskData(((xbean.BattleTaskData)xEntry.getValue()).getParameter()));
/*     */     }
/*  34 */     OnlineManager.getInstance().send(roleId, syn);
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
/*     */   static void updateTaskParameter(long roleId, int addValue, RoleBattleTaskData xRoleBattleTaskData, int taskType)
/*     */   {
/*  48 */     RoleBattleBaseInfo roleBaseInfo = SingleBattleInterface.getRoleBattleBaseInfo(roleId, true);
/*  49 */     if (roleBaseInfo == null)
/*     */     {
/*  51 */       return;
/*     */     }
/*  53 */     Set<Integer> needUpdateTaskIds = new HashSet();
/*     */     
/*  55 */     for (Map.Entry<Integer, xbean.BattleTaskData> xEntry : xRoleBattleTaskData.getTaskdatas().entrySet())
/*     */     {
/*  57 */       int taskId = ((Integer)xEntry.getKey()).intValue();
/*  58 */       SBattleTaskCfg sTaskCfg = SBattleTaskCfg.get(taskId);
/*  59 */       if ((sTaskCfg != null) && 
/*     */       
/*     */ 
/*     */ 
/*  63 */         (sTaskCfg.taskType == taskType) && 
/*     */         
/*     */ 
/*     */ 
/*  67 */         (sTaskCfg.needNum > ((xbean.BattleTaskData)xEntry.getValue()).getParameter()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  72 */         needUpdateTaskIds.add(Integer.valueOf(taskId)); }
/*     */     }
/*  74 */     for (Iterator i$ = needUpdateTaskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*     */       
/*  76 */       addTaskParam(roleId, xRoleBattleTaskData, taskId, addValue, roleBaseInfo);
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
/*     */   static void addTaskParam(long roleId, RoleBattleTaskData xRoleBattleTaskData, int taskId, int addValue, RoleBattleBaseInfo roleBaseInfo)
/*     */   {
/*  91 */     SBattleTaskCfg cfg = SBattleTaskCfg.get(taskId);
/*  92 */     if (cfg == null)
/*     */     {
/*  94 */       return;
/*     */     }
/*  96 */     int maxValue = cfg.needNum;
/*  97 */     if (maxValue <= 0)
/*     */     {
/*  99 */       return;
/*     */     }
/* 101 */     xbean.BattleTaskData xBattleTaskData = (xbean.BattleTaskData)xRoleBattleTaskData.getTaskdatas().get(Integer.valueOf(taskId));
/* 102 */     if (xBattleTaskData == null)
/*     */     {
/* 104 */       return;
/*     */     }
/* 106 */     int orgValue = xBattleTaskData.getParameter();
/* 107 */     if (orgValue >= maxValue)
/*     */     {
/* 109 */       return;
/*     */     }
/* 111 */     int nowNum = orgValue + addValue;
/* 112 */     if (maxValue <= nowNum)
/*     */     {
/* 114 */       nowNum = maxValue;
/*     */       
/* 116 */       SingleBattleInterface.addRolePoint(roleBaseInfo.getBattleId(), roleBaseInfo.getCampId(), roleId, cfg.addPoint);
/*     */     }
/*     */     
/* 119 */     xBattleTaskData.setParameter(nowNum);
/*     */     
/* 121 */     OnlineManager.getInstance().send(roleId, new SSynRoleTaskParam(taskId, nowNum));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\task\BattleTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */