/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnActivityClosed
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public POnActivityClosed(int activityId)
/*    */   {
/* 23 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     GameServer.logger().info(String.format("[singleTask]POnActivityClosed.processImp@ begin handle after activity close|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*    */     
/*    */ 
/* 32 */     if (!closeController())
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       NoneRealTimeTaskManager.getInstance().addTask(new PRoleActivityClosed(roleId, this.activityId));
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean closeController()
/*    */   {
/* 51 */     SingleTaskCfg cfg = SingleTaskManager.getSingleTaskCfg(this.activityId);
/* 52 */     if (cfg == null)
/*    */     {
/* 54 */       GameServer.logger().error(String.format("[singleTask]POnActivityClosed.processImp@ cfg not exist!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*    */       
/* 56 */       return false;
/*    */     }
/* 58 */     ControllerInterface.collectController(cfg.controller);
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\POnActivityClosed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */