/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.SeasonTaskInfo;
/*    */ import xtable.Role2seasontaskinfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     SeasonTaskInfo xinfo = Role2seasontaskinfo.get((Long)this.arg);
/* 13 */     if (xinfo == null)
/*    */     {
/* 15 */       xinfo = xbean.Pod.newSeasonTaskInfo();
/* 16 */       Role2seasontaskinfo.add((Long)this.arg, xinfo);
/*    */     }
/* 18 */     checkSingleOpen(((Long)this.arg).longValue());
/* 19 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void checkSingleOpen(long roleId)
/*    */   {
/* 31 */     int graphId = SummerTaskManager.getSingleGraph();
/* 32 */     boolean hasGraph = TaskInterface.isHaveGraphId(roleId, graphId);
/* 33 */     if (!hasGraph)
/*    */     {
/* 35 */       return;
/*    */     }
/* 37 */     if (!SummerTaskManager.isSingleOpen(roleId))
/*    */     {
/* 39 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, graphId);
/* 40 */       return;
/*    */     }
/* 42 */     TaskInterface.goNextTask(roleId, graphId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */