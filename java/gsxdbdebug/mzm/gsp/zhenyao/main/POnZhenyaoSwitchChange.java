/*    */ package mzm.gsp.zhenyao.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnZhenyaoSwitchChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (((OpenChangeComplexArg)this.arg).getType() != 1)
/*    */     {
/* 24 */       return false; }
/*    */     Iterator i$;
/* 26 */     if (!((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 32 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */         
/*    */ 
/* 35 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 41 */             if (TaskInterface.isHaveGraphId(roleId, ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID))
/*    */             {
/* 43 */               TaskInterface.closeActivityGraphWithoutEvent(roleId, ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID);
/*    */             }
/*    */             
/*    */ 
/* 47 */             if (TaskInterface.isHaveGraphId(roleId, ZhenYaoActivityCfgConsts.getInstance().GUIDE_GRAPH_ID))
/*    */             {
/*    */ 
/* 50 */               TaskInterface.closeActivityGraphWithoutEvent(roleId, ZhenYaoActivityCfgConsts.getInstance().GUIDE_GRAPH_ID);
/*    */             }
/*    */             
/* 53 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\POnZhenyaoSwitchChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */