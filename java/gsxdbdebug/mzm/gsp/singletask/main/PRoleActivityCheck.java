/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRoleActivityCheck
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PRoleActivityCheck(long roleId, int activityId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (ActivityInterface.isActivityOpen(this.activityId))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     int lastGraphId = SingleTaskManager.selectLastGraphId(this.roleId, this.activityId);
/* 33 */     if (lastGraphId <= 0)
/*    */     {
/* 35 */       GameServer.logger().info(String.format("[singleTask]PAcceptSingleTask.processImp@ not get graphId!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/* 40 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleId, lastGraphId);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\PRoleActivityCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */