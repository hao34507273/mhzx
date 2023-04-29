/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnScoSwitchChange extends mzm.gsp.open.event.OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (((OpenChangeComplexArg)this.arg).getType() != 10)
/*    */     {
/* 20 */       return false; }
/*    */     Iterator i$;
/* 22 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 24 */       if (ActivityInterface.isActivityOpen(SSchoolChallengeCfgConsts.getInstance().ACTIVITYID))
/*    */       {
/* 26 */         ControllerInterface.triggerController(SSchoolChallengeCfgConsts.getInstance().CONTROLLER_ID);
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 32 */       ControllerInterface.collectController(SSchoolChallengeCfgConsts.getInstance().CONTROLLER_ID);
/*    */       
/* 34 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */         
/*    */ 
/* 37 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/*    */ 
/* 44 */             if (TaskInterface.isHaveGraphId(roleId, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID))
/*    */             {
/*    */ 
/* 47 */               TaskInterface.closeActivityGraphWithoutEvent(roleId, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID);
/*    */             }
/*    */             
/*    */ 
/* 51 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\POnScoSwitchChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */