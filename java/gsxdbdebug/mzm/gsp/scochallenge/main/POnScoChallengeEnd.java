/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnScoChallengeEnd
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     ControllerInterface.collectController(SSchoolChallengeCfgConsts.getInstance().CONTROLLER_ID);
/* 25 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 30 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */         {
/* 32 */           NoneRealTimeTaskManager.getInstance().addTask(new POnScoChallengeEnd.PClearScoChallengeData(roleId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 36 */     });
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   private static class PClearScoChallengeData
/*    */     extends LogicProcedure
/*    */   {
/*    */     private long roleid;
/*    */     
/*    */     PClearScoChallengeData(long roleid)
/*    */     {
/* 47 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleid, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID);
/*    */       
/* 57 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnScoChallengeEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */