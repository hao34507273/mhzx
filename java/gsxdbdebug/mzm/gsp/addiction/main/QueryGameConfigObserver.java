/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ 
/*    */ class QueryGameConfigObserver extends Observer
/*    */ {
/*    */   public QueryGameConfigObserver(long seconds)
/*    */   {
/* 11 */     super(seconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 17 */     Executor.getInstance().execute(new RQueryGameConfig(null));
/* 18 */     return false;
/*    */   }
/*    */   
/*    */   private class RQueryGameConfig extends LogicRunnable
/*    */   {
/*    */     private RQueryGameConfig() {}
/*    */     
/*    */     public void process() throws Exception {
/* 26 */       if (!mzm.gsp.addiction.pro.ProManager.queryGameConfig())
/*    */       {
/* 28 */         AddictionManager.setConfig(new AddictionCfgInfo());
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\QueryGameConfigObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */