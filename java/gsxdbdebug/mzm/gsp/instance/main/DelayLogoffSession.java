/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class DelayLogoffSession
/*    */   extends Session
/*    */ {
/*    */   public DelayLogoffSession(long interval, long roleId)
/*    */   {
/* 13 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 19 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 25 */         if (!OnlineManager.getInstance().isOnline(DelayLogoffSession.this.getOwerId()))
/*    */         {
/* 27 */           return new PHandleInstanceOffLine(DelayLogoffSession.this.getOwerId(), false).call();
/*    */         }
/* 29 */         return false;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\DelayLogoffSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */