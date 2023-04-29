/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCloseTaskGraph
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PCloseTaskGraph(long roleid, int activityCfgid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     SFeiShengCfg cfg = SFeiShengCfg.get(this.activityCfgid);
/* 29 */     if (cfg == null)
/*    */     {
/*    */ 
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 37 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 39 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 41 */     if (TaskInterface.isHaveGraphId(this.roleid, cfg.task_graph_id))
/*    */     {
/* 43 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleid, cfg.task_graph_id);
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\PCloseTaskGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */