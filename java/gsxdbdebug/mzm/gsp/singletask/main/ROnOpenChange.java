/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.activity.confbean.STOpenId2ActivityId;
/*    */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     STOpenId2ActivityId cfg = STOpenId2ActivityId.get(((OpenChangeComplexArg)this.arg).getType());
/* 25 */     if (cfg == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     SingleTaskCfg singleTaskcfg = SingleTaskManager.getSingleTaskCfg(cfg.activityId);
/* 30 */     if (singleTaskcfg == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/*    */ 
/* 37 */       onSwithOpen(cfg.activityId, singleTaskcfg);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 42 */       onSwitchClose(cfg.activityId, singleTaskcfg);
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   private void onSwithOpen(int activityId, SingleTaskCfg singleTaskcfg)
/*    */   {
/* 49 */     if (!ActivityInterface.isActivityOpen(activityId))
/*    */     {
/* 51 */       return;
/*    */     }
/*    */     
/* 54 */     ControllerInterface.triggerController(singleTaskcfg.controller);
/*    */   }
/*    */   
/*    */   private void onSwitchClose(int activityId, SingleTaskCfg singleTaskcfg)
/*    */   {
/* 59 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 61 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */       {
/*    */ 
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 67 */           int lastGraphId = SingleTaskManager.selectLastGraphId(roleId, this.val$activityId);
/* 68 */           if (lastGraphId <= 0)
/*    */           {
/* 70 */             return false;
/*    */           }
/* 72 */           TaskInterface.closeActivityGraphWithoutEvent(roleId, lastGraphId);
/* 73 */           return true;
/*    */         }
/*    */       });
/*    */     }
/*    */     
/* 78 */     ControllerInterface.collectController(singleTaskcfg.controller);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */