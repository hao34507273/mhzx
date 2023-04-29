/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.ActiveAcceptTaskHandler;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class GangTaskHandler implements ActiveAcceptTaskHandler
/*    */ {
/*    */   static volatile GangTaskHandler instance;
/*    */   
/*    */   static GangTaskHandler getInstance()
/*    */   {
/* 20 */     if (instance == null)
/*    */     {
/* 22 */       synchronized (GangTaskHandler.class)
/*    */       {
/* 24 */         if (instance == null)
/*    */         {
/* 26 */           instance = new GangTaskHandler();
/*    */         }
/*    */       }
/*    */     }
/* 30 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean canAcceptTask(long roleId, int graphId, int taskId)
/*    */   {
/* 36 */     CheckAcceptTask p = new CheckAcceptTask(roleId, graphId, taskId);
/* 37 */     p.call();
/* 38 */     return p.isPermit;
/*    */   }
/*    */   
/*    */ 
/*    */   class CheckAcceptTask
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     private final int graphId;
/*    */     
/*    */     private final int taskId;
/* 50 */     public boolean isPermit = false;
/*    */     
/*    */     public CheckAcceptTask(long roleId, int graphId, int taskId)
/*    */     {
/* 54 */       this.roleId = roleId;
/* 55 */       this.graphId = graphId;
/* 56 */       this.taskId = taskId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 63 */       String userId = RoleInterface.getUserId(this.roleId);
/* 64 */       lock(Lockeys.get(User.getTable(), userId));
/*    */       
/* 66 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */       
/* 68 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, GangTaskManager.getGangTaskActivityId());
/*    */       
/* 70 */       if (res.isCanJoin())
/*    */       {
/* 72 */         this.isPermit = true;
/* 73 */         return true;
/*    */       }
/* 75 */       if (res.isActivityJoinCountMax())
/*    */       {
/* 77 */         GangTaskManager.sendNormalResult(this.roleId, 2, new String[0]);
/*    */       }
/* 79 */       GameServer.logger().error(String.format("[factionTask]CheckAcceptTask.processImp@ forbid join!|roleId=%d|resCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/* 82 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\GangTaskHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */