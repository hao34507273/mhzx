/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ class HulaAwardObserver extends Observer
/*    */ {
/*    */   public HulaAwardObserver(long intervalSeconds)
/*    */   {
/* 16 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 23 */     Xdb.executor().execute(new HulaAwardRunnable(this));
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   private static class HulaAwardRunnable extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private HulaAwardObserver hulaAwardObserver;
/*    */     
/*    */     public HulaAwardRunnable(HulaAwardObserver hulaAwardObserver)
/*    */     {
/* 33 */       this.hulaAwardObserver = hulaAwardObserver;
/*    */     }
/*    */     
/*    */ 
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 40 */       if (GameServerInfoManager.isRoamServer())
/*    */       {
/* 42 */         return;
/*    */       }
/* 44 */       if ((!OpenInterface.getOpenStatus(200)) || (!ActivityInterface.isActivityOpen(SHulaCfgConsts.getInstance().ACTIVITY_ID)))
/*    */       {
/*    */ 
/* 47 */         String logstr = String.format("[hula]HulaAwardRunnable.process@hula activity closed", new Object[0]);
/* 48 */         HulaManager.logger.info(logstr);
/* 49 */         this.hulaAwardObserver.stopTimer();
/* 50 */         return;
/*    */       }
/* 52 */       int stage = ActivityInterface.getActivityStage(SHulaCfgConsts.getInstance().ACTIVITY_ID);
/* 53 */       HulaWorldManager.getInstance().awardExpToAllWorldRoles(stage);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */