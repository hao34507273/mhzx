/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*    */ import mzm.gsp.task.main.TaskData;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BTaskInfo;
/*    */ import xbean.BountyInfo;
/*    */ import xdb.Lockeys;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2bounty;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(((Long)this.arg).longValue())));
/*    */     
/* 30 */     BountyInfo xBountyInfo = Role2bounty.get((Long)this.arg);
/* 31 */     if (xBountyInfo == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     checkBTask();
/* 36 */     checkBTaskState(((Long)this.arg).longValue(), xBountyInfo.getTaskinfos());
/* 37 */     BountyManager.synBountyInfo(((Long)this.arg).longValue(), xBountyInfo);
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void checkBTask()
/*    */   {
/* 46 */     for (Iterator i$ = BountyManager.getGraphIds().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*    */       
/* 48 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), graphId))
/*    */       {
/*    */ 
/*    */ 
/* 52 */         TaskData taskData = TaskInterface.getRoleGraphTask(((Long)this.arg).longValue(), graphId);
/* 53 */         if ((taskData != null) && 
/*    */         
/*    */ 
/*    */ 
/* 57 */           (taskData.getState() == 1))
/*    */         {
/*    */ 
/*    */ 
/* 61 */           GameServer.logger().error(String.format("[bounty]POnRoleLogin.checkBTask@ has can accept task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { this.arg, Integer.valueOf(graphId), Integer.valueOf(taskData.getTaskId()) }));
/*    */           
/*    */ 
/* 64 */           Procedure.execute(new AccpetTaskProcedure(((Long)this.arg).longValue(), graphId, taskData.getTaskId()));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/* 70 */   private void checkBTaskState(long roleId, Map<Integer, BTaskInfo> bTaskData) { Iterator<Map.Entry<Integer, BTaskInfo>> it = bTaskData.entrySet().iterator();
/* 71 */     while (it.hasNext())
/*    */     {
/* 73 */       Map.Entry<Integer, BTaskInfo> entry = (Map.Entry)it.next();
/* 74 */       int graphId = ((Integer)entry.getKey()).intValue();
/* 75 */       BTaskInfo xBTaskInfo = (BTaskInfo)entry.getValue();
/*    */       
/* 77 */       if ((xBTaskInfo.getTaskstate() == 1) && 
/*    */       
/*    */ 
/*    */ 
/* 81 */         (!TaskInterface.isHaveGraphId(roleId, graphId)))
/*    */       {
/*    */ 
/*    */ 
/* 85 */         xBTaskInfo.setTaskstate(2);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */