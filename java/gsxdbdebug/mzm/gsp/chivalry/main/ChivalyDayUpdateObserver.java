/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class ChivalyDayUpdateObserver extends DateObserver
/*    */ {
/*    */   public ChivalyDayUpdateObserver(int timeCommonCfgId)
/*    */   {
/* 13 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 20 */     Xdb.executor().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 26 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */         {
/* 28 */           NoneRealTimeTaskManager.getInstance().addTask(new PChivalryDayInitPro(roleId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 32 */     });
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\ChivalyDayUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */