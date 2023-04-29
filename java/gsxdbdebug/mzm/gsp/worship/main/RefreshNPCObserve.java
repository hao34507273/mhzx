/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RefreshNPCObserve
/*    */   extends DateObserver
/*    */ {
/*    */   private final int timeCommonCfgId;
/*    */   
/*    */   public RefreshNPCObserve(int timeCommonCfgId)
/*    */   {
/* 20 */     super(timeCommonCfgId);
/* 21 */     this.timeCommonCfgId = timeCommonCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 27 */     new LogicRunnable()
/*    */     {
/*    */ 
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {}
/*    */ 
/*    */ 
/* 36 */     }.execute();
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\RefreshNPCObserve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */