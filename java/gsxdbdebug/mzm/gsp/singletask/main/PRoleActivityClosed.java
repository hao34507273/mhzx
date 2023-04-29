/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRoleActivityClosed
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private SingleTaskCfg cfg;
/*    */   
/*    */   public PRoleActivityClosed(long roleId, int activityId)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   private boolean init()
/*    */   {
/* 31 */     this.cfg = SingleTaskManager.getSingleTaskCfg(this.activityId);
/* 32 */     if (this.cfg == null)
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[singleTask]POnActivityClosed.init@ cfg not exist!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*    */       
/* 36 */       return false;
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 44 */     int lastGraphId = SingleTaskManager.selectLastGraphId(this.roleId, this.activityId);
/* 45 */     if (lastGraphId <= 0)
/*    */     {
/* 47 */       GameServer.logger().info(String.format("[singleTask]PAcceptSingleTask.processImp@ not get graphId!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*    */       
/*    */ 
/* 50 */       return false;
/*    */     }
/* 52 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleId, lastGraphId);
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\PRoleActivityClosed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */