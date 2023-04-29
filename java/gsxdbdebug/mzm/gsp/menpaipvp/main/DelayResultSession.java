/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.menpaipvp.confbean.SMenpaiRankAwardCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ class DelayResultSession
/*    */   extends Session
/*    */ {
/*    */   public DelayResultSession(long interval)
/*    */   {
/* 15 */     super(interval, -1L);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 20 */     Xdb.executor().execute(new RResult());
/*    */   }
/*    */   
/*    */   static class RResult
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 29 */       for (SMenpaiRankAwardCfg awardCfg : SMenpaiRankAwardCfg.getAll().values()) {
/* 30 */         MenpaiPVPChart chart = MenpaiPVPManager.getChart(awardCfg.menpai);
/*    */         
/* 32 */         if (chart != null)
/*    */         {
/*    */ 
/* 35 */           Long roleid = (Long)chart.getKeyByRank(awardCfg.rank - 1);
/* 36 */           if (roleid != null) {
/* 37 */             new PMenpaiRankAward(roleid.longValue(), awardCfg).call();
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 42 */       new PSetChampions().call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\DelayResultSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */