/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class SingleInstanceObserver extends DateObserver
/*    */ {
/*    */   public SingleInstanceObserver(int timeCommonCfgId)
/*    */   {
/* 11 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 16 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */       {
/* 20 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld()) {
/* 21 */           NoneRealTimeTaskManager.getInstance().addTask(new SingleDataDayProcedure(roleId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 25 */     });
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstanceObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */