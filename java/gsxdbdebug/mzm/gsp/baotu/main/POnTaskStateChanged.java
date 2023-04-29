/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTaskStateChanged
/*    */   extends TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (((TaskEventArg)this.arg).graphId != BaoTuActivityCfgConsts.getInstance().GRAPH_ID)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     switch (((TaskEventArg)this.arg).taskState)
/*    */     {
/*    */ 
/*    */ 
/*    */     case 8: 
/* 35 */       String userId = RoleInterface.getUserId(((TaskEventArg)this.arg).roleId);
/* 36 */       lock(Lockeys.get(User.getTable(), userId));
/* 37 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(((TaskEventArg)this.arg).roleId)));
/* 38 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, ((TaskEventArg)this.arg).roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID);
/*    */       
/* 40 */       if (!res.isCanJoin())
/*    */       {
/* 42 */         String logStr = String.format("[baotu]POnTaskStateChanged.processImp@can join boatu error|roleid=%d|curtaskid=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(BaoTuActivityCfgConsts.getInstance().GRAPH_ID) });
/*    */         
/*    */ 
/* 45 */         BaoTuItemModule.logger.error(logStr);
/* 46 */         return false;
/*    */       }
/* 48 */       if (!BaotuManager.isRoleStateCanJoinBaotuActivity(((TaskEventArg)this.arg).roleId))
/*    */       {
/* 50 */         String logStr = String.format("[baotu]POnTaskStateChanged.processImp@role state can not join baotu activity|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*    */         
/*    */ 
/* 53 */         BaoTuItemModule.logger.info(logStr);
/* 54 */         return false;
/*    */       }
/* 56 */       int activityCount = ActivityInterface.getActivityCount(userId, ((TaskEventArg)this.arg).roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, true);
/*    */       
/* 58 */       if (BaotuManager.onFinishBaoTu(userId, ((TaskEventArg)this.arg).roleId, activityCount) == -1)
/*    */       {
/* 60 */         return true;
/*    */       }
/*    */       
/* 63 */       boolean ret = TaskInterface.goNextTask(((TaskEventArg)this.arg).roleId, BaoTuActivityCfgConsts.getInstance().GRAPH_ID);
/* 64 */       if (!ret)
/*    */       {
/* 66 */         String logStr = String.format("[baotu]POnTaskStateChanged.processImp@baotu activity go next task error|roleid=%d|curtaskid=%d|graphid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(BaoTuActivityCfgConsts.getInstance().GRAPH_ID) });
/*    */         
/*    */ 
/* 69 */         BaoTuItemModule.logger.error(logStr);
/*    */       }
/*    */       
/*    */ 
/* 73 */       return true;
/*    */     
/*    */     case 2: 
/* 76 */       ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*    */       
/* 78 */       ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*    */       
/*    */ 
/* 81 */       return true; }
/*    */     
/* 83 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\POnTaskStateChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */