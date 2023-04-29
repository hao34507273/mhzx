/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PFactionOpen
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PFactionOpen(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     int graphId = GangTaskManager.getGangTaskGraph();
/* 27 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 28 */     boolean hasGraph = TaskInterface.isHaveGraphId(this.roleId, graphId);
/* 29 */     if (!hasGraph)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     TaskInterface.goNextTask(this.roleId, graphId);
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\PFactionOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */