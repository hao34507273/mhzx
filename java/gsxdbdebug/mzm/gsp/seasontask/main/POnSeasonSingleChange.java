/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnSeasonSingleChange extends mzm.gsp.open.event.OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (((OpenChangeComplexArg)this.arg).getType() != 19)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     if (!((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/*    */ 
/* 22 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 24 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 30 */             return TaskInterface.closeActivityGraphWithoutEvent(roleId, SummerTaskManager.getSingleGraph());
/*    */           }
/*    */         });
/*    */       }
/* 34 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\POnSeasonSingleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */