/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.crossbattle.SNotifyFinalResultOut;
/*    */ import mzm.gsp.crossbattle.event.KnockOutFinalChampionBornProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class POnKnockOutFinalChampionBorn
/*    */   extends KnockOutFinalChampionBornProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     Xdb.executor().schedule(new DelayNotifyClientChampion(null), 60000L, TimeUnit.MILLISECONDS);
/*    */     
/* 19 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private static class DelayNotifyClientChampion
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 29 */       OnlineManager.getInstance().sendAll(new SNotifyFinalResultOut());
/*    */       
/*    */ 
/* 32 */       CrossBattleKnockoutInterface.getCrossBattleChampionCorpsInfo();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnKnockOutFinalChampionBorn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */