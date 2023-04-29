/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class RefreshObserver extends DateObserver
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int commonTimeCfgid;
/*    */   
/*    */   public RefreshObserver(int commonTimeCfgid, int activityCfgid)
/*    */   {
/* 13 */     super(commonTimeCfgid);
/*    */     
/* 15 */     this.commonTimeCfgid = commonTimeCfgid;
/* 16 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 22 */     Executor.getInstance().execute(new RRefresh(this.activityCfgid, this.commonTimeCfgid));
/*    */     
/* 24 */     return false;
/*    */   }
/*    */   
/*    */   private static class RRefresh extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final int activityCfgid;
/*    */     private final int commonTimeCfgid;
/*    */     
/*    */     public RRefresh(int activityCfgid, int commonTimeCfgid)
/*    */     {
/* 34 */       this.activityCfgid = activityCfgid;
/* 35 */       this.commonTimeCfgid = commonTimeCfgid;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 41 */       if (!LuckyBagManager.isFunOpen())
/*    */       {
/* 43 */         return;
/*    */       }
/*    */       
/* 46 */       LuckyBagManager.refreshLuckyBag(this.activityCfgid);
/* 47 */       ObserverManager.getInstance().remove(this.activityCfgid, this.commonTimeCfgid);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\RefreshObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */