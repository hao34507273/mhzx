/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*    */ import mzm.gsp.gang.SSyncGangHelp;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PCircleTaskCallGangHelp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PCircleTaskCallGangHelp(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 207, true))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     int taskId = TaskInterface.findTaskInGraph(this.roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID);
/* 30 */     if (taskId == 0) {
/* 31 */       return false;
/*    */     }
/* 33 */     long gangId = GangInterface.getGangId(this.roleId);
/* 34 */     if (gangId == 0L) {
/* 35 */       return false;
/*    */     }
/* 37 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, true);
/* 38 */     if (teamId == null) {
/* 39 */       return false;
/*    */     }
/* 41 */     SSyncGangHelp sSyncGangHelp = new SSyncGangHelp();
/* 42 */     sSyncGangHelp.helpertype = 1;
/* 43 */     sSyncGangHelp.paramlong.put(Integer.valueOf(14), Long.valueOf(this.roleId));
/* 44 */     sSyncGangHelp.paramlong.put(Integer.valueOf(17), teamId);
/* 45 */     sSyncGangHelp.paramint.put(Integer.valueOf(18), Integer.valueOf(taskId));
/* 46 */     GangInterface.brocastInGang(sSyncGangHelp, gangId);
/*    */     
/* 48 */     CircleTaskManager.logAskCircleTaskHelp(this.roleId, taskId);
/* 49 */     CircleTaskManager.tlogAskCircleTaskHelp(this.roleId, taskId);
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\PCircleTaskCallGangHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */