/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
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
/* 17 */     this.roleId = roleId;
/* 18 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     return TaskInterface.closeActivityGraphWithoutEvent(this.roleId, this.graphId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\PCloseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */