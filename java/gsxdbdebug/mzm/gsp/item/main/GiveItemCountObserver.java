/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class GiveItemCountObserver extends DateObserver
/*    */ {
/*    */   public GiveItemCountObserver(DateObserver.MyDate myDate)
/*    */   {
/* 17 */     super(myDate);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 23 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 27 */         for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */         {
/* 29 */           NoneRealTimeTaskManager.getInstance().addTask(new GiveItemCountObserver.POnGiveItemCountObserverTimeout(roleId.longValue()));
/*    */         }
/*    */       }
/* 32 */     });
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   private static class POnGiveItemCountObserverTimeout extends LogicProcedure
/*    */   {
/*    */     private long roleid;
/*    */     
/*    */     POnGiveItemCountObserverTimeout(long roleid) {
/* 41 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 46 */       ItemGiveManager.clearGiveItemCount(this.roleid, DateTimeUtils.getCurrTimeInMillis());
/* 47 */       ItemGiveManager.clearGiveYuanbaoCount(this.roleid, DateTimeUtils.getCurrTimeInMillis());
/* 48 */       ItemGiveManager.synGiveItemInfo(this.roleid);
/*    */       
/* 50 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\GiveItemCountObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */