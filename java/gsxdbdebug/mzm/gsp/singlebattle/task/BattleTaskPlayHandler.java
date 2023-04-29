/*     */ package mzm.gsp.singlebattle.task;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.singlebattle.confbean.SBattleTaskCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STPersonalTaskCfg;
/*     */ import mzm.gsp.singlebattle.main.EachPlayTypeHandler;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleBattleTaskData;
/*     */ import xtable.Role2battletask;
/*     */ 
/*     */ public class BattleTaskPlayHandler
/*     */   implements EachPlayTypeHandler
/*     */ {
/*     */   public void onBattleStart(long battleId, int playCfgId) {}
/*     */   
/*     */   public void onRoleJoinBattle(long battleId, int playCfgId, long roleId)
/*     */   {
/*  23 */     if (Role2battletask.get(Long.valueOf(roleId)) != null)
/*     */     {
/*     */ 
/*  26 */       GameServer.logger().error(String.format("[battletask]xRoleBattleTaskData is not null!|battleId=%d|playCfgId=%d|roleId=%d", new Object[] { Long.valueOf(battleId), Integer.valueOf(playCfgId), Long.valueOf(roleId) }));
/*     */       
/*     */ 
/*  29 */       Role2battletask.remove(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  32 */     RoleBattleTaskData xRoleBattleTaskData = Pod.newRoleBattleTaskData();
/*  33 */     STPersonalTaskCfg stTaskCfg = STPersonalTaskCfg.get(playCfgId);
/*  34 */     for (Iterator i$ = stTaskCfg.taskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*     */       
/*  36 */       SBattleTaskCfg taskCfg = SBattleTaskCfg.get(taskId);
/*  37 */       if (taskCfg != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  43 */         xRoleBattleTaskData.getTaskdatas().put(Integer.valueOf(taskId), Pod.newBattleTaskData());
/*     */       }
/*     */     }
/*  46 */     Role2battletask.insert(Long.valueOf(roleId), xRoleBattleTaskData);
/*     */     
/*  48 */     BattleTaskManager.synRoleTaskDatas(roleId, xRoleBattleTaskData);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onMatchStart(long battleId, int playCfgId) {}
/*     */   
/*     */ 
/*     */   public int getPoint(long battleId, int playCfgId, long roleId, boolean remainRoleLock)
/*     */   {
/*     */     RoleBattleTaskData xRoleBattleTaskData;
/*     */     
/*     */     RoleBattleTaskData xRoleBattleTaskData;
/*     */     
/*  61 */     if (remainRoleLock)
/*     */     {
/*  63 */       xRoleBattleTaskData = Role2battletask.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  67 */       xRoleBattleTaskData = Role2battletask.select(Long.valueOf(roleId));
/*     */     }
/*  69 */     if (xRoleBattleTaskData == null)
/*     */     {
/*  71 */       return 0;
/*     */     }
/*  73 */     return xRoleBattleTaskData.getPoint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onMatchEnd(long battleId, int playCfgId) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onStartClean(long battleId, int playCfgId) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onBattleEnd(long battleId, int playCfgId) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onRoleQuitBattle(long battleId, int playCfgId, long roleId, SingleBattleInterface.LeaveBattleReason leaveReason)
/*     */   {
/*  98 */     Role2battletask.remove(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canFight(long battleId, int playCfgId, long activeRoleId, long passiveRoleId)
/*     */   {
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\task\BattleTaskPlayHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */