/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.GraphBean;
/*    */ import xbean.NodeBean;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ class RefreshTaskSetProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final long refreshTime;
/*    */   
/*    */   RefreshTaskSetProcedure(long roleId, int graphId, long refreshTime)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.graphId = graphId;
/* 19 */     this.refreshTime = refreshTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userId = RoleInterface.getUserId(this.roleId);
/* 27 */     lock(Lockeys.get(User.getTable(), userId));
/* 28 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/* 29 */     if (roleTask.getTaskDataBean() == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/* 34 */     if (graphBean == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 39 */     if (graph == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     if (!graph.isRingTypeGraph())
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     if (graphBean.getNodebean().getRefreshtime() == this.refreshTime)
/*    */     {
/*    */ 
/* 50 */       graph.refreshTaskSetGraph(this.roleId, graphBean, true);
/*    */       
/* 52 */       graphBean.getNodebean().setRefreshtime(0L);
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\RefreshTaskSetProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */