/*     */ package mzm.gsp.factiontask.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*     */ import mzm.gsp.task.main.TaskData;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FTaskInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2factiontaskinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*  23 */   private int graphId = 0;
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     long roleId = ((Long)this.arg).longValue();
/*  29 */     this.graphId = GangTaskManager.getGangTaskGraph();
/*     */     
/*  31 */     String userId = RoleInterface.getUserId(((Long)this.arg).longValue());
/*  32 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  34 */     FTaskInfo xInfo = Role2factiontaskinfo.get(Long.valueOf(roleId));
/*  35 */     if (xInfo == null)
/*     */     {
/*  37 */       Role2factiontaskinfo.add(Long.valueOf(roleId), Pod.newFTaskInfo());
/*     */     }
/*  39 */     checkFactionOpen(roleId);
/*  40 */     checkGTask(userId, roleId);
/*  41 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkFactionOpen(long roleId)
/*     */   {
/*  53 */     if (!GangTaskManager.isFactionTaskOpen(roleId))
/*     */     {
/*  55 */       return;
/*     */     }
/*  57 */     boolean hasGraph = TaskInterface.isHaveGraphId(roleId, this.graphId);
/*  58 */     if (!hasGraph) {}
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
/*     */   private void checkGTask(String userId, long roleId)
/*     */   {
/*  75 */     if (!TaskInterface.isHaveGraphId(roleId, this.graphId))
/*     */     {
/*  77 */       return;
/*     */     }
/*  79 */     if (!GangInterface.hasGang(roleId))
/*     */     {
/*  81 */       GameServer.logger().error(String.format("[factionTask]POnRoleLogin.checkGTask@ no faction but have faction task!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*  83 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, this.graphId);
/*  84 */       return;
/*     */     }
/*  86 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, GangTaskManager.getGangTaskActivityId()).isCanJoin())
/*     */     {
/*  88 */       return;
/*     */     }
/*  90 */     TaskData taskData = TaskInterface.getRoleGraphTask(roleId, this.graphId);
/*  91 */     if (taskData == null)
/*     */     {
/*  93 */       return;
/*     */     }
/*  95 */     if (taskData.getState() != 1)
/*     */     {
/*  97 */       return;
/*     */     }
/*  99 */     GameServer.logger().error(String.format("[bounty]POnRoleLogin.checkGTask@ has can accept task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { this.arg, Integer.valueOf(this.graphId), Integer.valueOf(taskData.getTaskId()) }));
/*     */     
/*     */ 
/* 102 */     Procedure.execute(new AccpetTaskProcedure(((Long)this.arg).longValue(), this.graphId, taskData.getTaskId()));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */