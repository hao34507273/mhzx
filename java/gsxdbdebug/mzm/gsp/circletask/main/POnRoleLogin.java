/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.SSyncRenXingYiXiaCount;
/*    */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*    */ import mzm.gsp.task.main.TaskData;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CircleTask;
/*    */ import xdb.Lockeys;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2circletask;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(((Long)this.arg).longValue())));
/*    */     
/* 29 */     CircleTask xCircleTask = Role2circletask.get((Long)this.arg);
/* 30 */     int count = 0;
/* 31 */     if (xCircleTask != null)
/*    */     {
/* 33 */       count = xCircleTask.getRenxingcounter();
/* 34 */       long legendTime = xCircleTask.getLegendendtime();
/* 35 */       if (legendTime > DateTimeUtils.getCurrTimeInMillis())
/*    */       {
/* 37 */         CircleTaskManager.synLegendTime(((Long)this.arg).longValue(), legendTime, TaskInterface.findTaskInGraph(((Long)this.arg).longValue(), CircleTaskConsts.getInstance().TASK_GRAPHIC_ID));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 42 */         xCircleTask.setLegendendtime(0L);
/*    */       }
/*    */     }
/* 45 */     SSyncRenXingYiXiaCount sSyncRenXingYiXiaCount = new SSyncRenXingYiXiaCount();
/* 46 */     sSyncRenXingYiXiaCount.count = count;
/* 47 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncRenXingYiXiaCount);
/* 48 */     checkCTask();
/* 49 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void checkCTask()
/*    */   {
/* 57 */     int graphId = CircleTaskConsts.getInstance().TASK_GRAPHIC_ID;
/* 58 */     if (!TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), graphId))
/*    */     {
/* 60 */       return;
/*    */     }
/* 62 */     TaskData taskData = TaskInterface.getRoleGraphTask(((Long)this.arg).longValue(), graphId);
/* 63 */     if (taskData == null)
/*    */     {
/* 65 */       return;
/*    */     }
/* 67 */     if (taskData.getState() != 1)
/*    */     {
/* 69 */       return;
/*    */     }
/* 71 */     GameServer.logger().error(String.format("[circle]POnRoleLogin.checkCTask@ has can accept task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { this.arg, Integer.valueOf(graphId), Integer.valueOf(taskData.getTaskId()) }));
/*    */     
/*    */ 
/* 74 */     Procedure.execute(new AccpetTaskProcedure(((Long)this.arg).longValue(), graphId, taskData.getTaskId()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */