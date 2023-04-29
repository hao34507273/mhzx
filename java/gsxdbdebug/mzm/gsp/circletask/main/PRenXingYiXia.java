/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.SSyncRenXingYiXiaCount;
/*    */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*    */ import mzm.gsp.circletask.confbean.SCircleTaskCostConf;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qingfu.main.CostResult;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.task.main.TaskData;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CircleTask;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2circletask;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PRenXingYiXia
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PRenXingYiXia(long roleId)
/*    */   {
/* 31 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     String userid = RoleInterface.getUserId(this.roleId);
/* 39 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 41 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(this.roleId));
/* 42 */     int num = xCircleTask.getRenxingcounter();
/* 43 */     Integer costId = CircleTaskManager.getInstance().getRenXingByCount(num + 1);
/* 44 */     if (costId == null)
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 208, true))
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     SCircleTaskCostConf conf = SCircleTaskCostConf.get(costId.intValue());
/* 53 */     int needYuanBao = conf.needYuanBao;
/* 54 */     if (QingfuInterface.costYuanbao(userid, this.roleId, needYuanBao, CostType.COST_BIND_FIRST_TASK_REN_XING_YI_XIA, new TLogArg(LogReason.PAOHUAN_RENXING_YUANBAO_REM)) != CostResult.Success)
/*    */     {
/*    */ 
/* 57 */       return false;
/*    */     }
/* 59 */     TaskData taskData = TaskInterface.getRoleGraphTask(this.roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID);
/* 60 */     if (taskData == null)
/*    */     {
/* 62 */       GameServer.logger().error(String.format("[circle]PRenXingYiXia.processImp@ get taskData fail!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(CircleTaskConsts.getInstance().TASK_GRAPHIC_ID) }));
/*    */       
/*    */ 
/* 65 */       return false;
/*    */     }
/* 67 */     if (!TaskInterface.finishSingleTask(this.roleId, CircleTaskConsts.getInstance().TASK_GRAPHIC_ID, taskData.getTaskId()))
/*    */     {
/* 69 */       GameServer.logger().error(String.format("[circle]PRenXingYiXia.processImp@ active finish task fail!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(CircleTaskConsts.getInstance().TASK_GRAPHIC_ID), Integer.valueOf(taskData.getTaskId()) }));
/*    */       
/*    */ 
/* 72 */       return false;
/*    */     }
/* 74 */     xCircleTask.setRenxingcounter(xCircleTask.getRenxingcounter() + 1);
/*    */     
/* 76 */     SSyncRenXingYiXiaCount sSyncRenXingYiXiaCount = new SSyncRenXingYiXiaCount();
/* 77 */     sSyncRenXingYiXiaCount.count = xCircleTask.getRenxingcounter();
/* 78 */     OnlineManager.getInstance().send(this.roleId, sSyncRenXingYiXiaCount);
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\PRenXingYiXia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */