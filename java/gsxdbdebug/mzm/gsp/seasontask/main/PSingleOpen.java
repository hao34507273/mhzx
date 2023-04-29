/*    */ package mzm.gsp.seasontask.main;
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
/*    */ public class PSingleOpen
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PSingleOpen(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int graphId = SummerTaskManager.getSingleGraph();
/* 26 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 27 */     boolean hasGraph = TaskInterface.isHaveGraphId(this.roleId, graphId);
/* 28 */     if (!hasGraph)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     TaskInterface.goNextTask(this.roleId, graphId);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PSingleOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */