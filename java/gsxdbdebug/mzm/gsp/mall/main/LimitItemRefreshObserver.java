/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LimitItemRefreshObserver
/*    */   extends DateObserver
/*    */ {
/*    */   public LimitItemRefreshObserver(int timeid)
/*    */   {
/* 20 */     super(timeid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 27 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 29 */     new UpdateMallFreshtime(cur).execute();
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   private static class UpdateMallFreshtime extends LogicProcedure
/*    */   {
/*    */     private long cur;
/*    */     
/*    */     public UpdateMallFreshtime(long cur)
/*    */     {
/* 39 */       this.cur = cur;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       MallManager.setMallRefreshTime(2, this.cur);
/* 46 */       for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */       {
/* 48 */         NoneRealTimeTaskManager.getInstance().addTask(new LimitItemRefreshObserver.ClearLimitItemBuyCount(roleId.longValue(), this.cur));
/*    */       }
/* 50 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */   private static class ClearLimitItemBuyCount
/*    */     extends LogicProcedure
/*    */   {
/*    */     long roleid;
/*    */     long time;
/*    */     
/*    */     ClearLimitItemBuyCount(long roleid, long time)
/*    */     {
/* 62 */       this.roleid = roleid;
/* 63 */       this.time = time;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 70 */       MallManager.clearItemBuyCount(this.roleid, this.time);
/* 71 */       MallManager.synAllMallItemNum(this.roleid);
/* 72 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\LimitItemRefreshObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */