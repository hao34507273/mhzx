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
/*    */ 
/*    */ public class PCloseGraph
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   
/*    */   public PCloseGraph(long roleId, int graphId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 29 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleId, this.graphId);
/* 30 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PCloseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */