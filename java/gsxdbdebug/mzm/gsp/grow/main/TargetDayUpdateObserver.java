/*    */ package mzm.gsp.grow.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class TargetDayUpdateObserver extends DateObserver
/*    */ {
/*    */   public TargetDayUpdateObserver(int timeCommonCfgId)
/*    */   {
/* 11 */     super(timeCommonCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 17 */     xdb.Xdb.executor().execute(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 21 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld()) {
/* 22 */           NoneRealTimeTaskManager.getInstance().addTask(new PTargetInitPro(roleId.longValue()));
/*    */         }
/*    */         
/*    */       }
/* 26 */     });
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\TargetDayUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */