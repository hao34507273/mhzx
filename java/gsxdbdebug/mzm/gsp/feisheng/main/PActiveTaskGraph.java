/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PActiveTaskGraph
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PActiveTaskGraph(long roleid, int activityCfgid)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!FeiShengManager.isFeiShengActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*    */     {
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     SFeiShengCfg cfg = SFeiShengCfg.get(this.activityCfgid);
/* 37 */     if (cfg == null)
/*    */     {
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*    */     {
/*    */ 
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 50 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 52 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 54 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*    */     
/* 56 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/*    */ 
/* 59 */       return false;
/*    */     }
/* 61 */     if (!TaskInterface.isHaveGraphId(this.roleid, cfg.task_graph_id))
/*    */     {
/* 63 */       TaskInterface.activeGraph(Long.valueOf(this.roleid), cfg.task_graph_id);
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\PActiveTaskGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */