/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.task.main.GraphStartArg;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ public class PonGraphStart extends mzm.gsp.task.event.GraphStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (((GraphStartArg)this.arg).graphId != HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(((GraphStartArg)this.arg).roleId));
/*    */     
/* 22 */     if (xHunInfo == null)
/*    */     {
/* 24 */       xHunInfo = HuanhunManager.createHunXTable(((GraphStartArg)this.arg).roleId);
/* 25 */       HuanhunManager.flushNewHunTask(xHunInfo, ((GraphStartArg)this.arg).roleId);
/*    */     }
/* 27 */     if (xHunInfo.getAlreadygettask())
/*    */     {
/* 29 */       GameServer.logger().error(String.format("[hun]PonGraphStart.processImp@ already get task!|roleId=%d", new Object[] { Long.valueOf(((GraphStartArg)this.arg).roleId) }));
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 43 */     if (!HuanhunManager.setNowTaskAndFlushNewNextTask(xHunInfo, ((GraphStartArg)this.arg).roleId))
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     xHunInfo.setAlreadygettask(true);
/*    */     
/*    */ 
/* 51 */     ActivityInterface.logActivity(((GraphStartArg)this.arg).roleId, HuanHunMiShuConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/* 52 */     ActivityInterface.tlogActivity(((GraphStartArg)this.arg).roleId, HuanHunMiShuConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PonGraphStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */