/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BulletinObserver
/*    */   extends Observer
/*    */ {
/* 18 */   private int count = 0;
/*    */   
/*    */   public BulletinObserver(long intervalSeconds, int count)
/*    */   {
/* 22 */     super(intervalSeconds);
/* 23 */     this.count = count;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 31 */     new SendBulletinPro(this).execute();
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   private static class SendBulletinPro extends LogicProcedure
/*    */   {
/*    */     private BulletinObserver bulletinObserver;
/*    */     
/*    */     SendBulletinPro(BulletinObserver bulletinObserver) {
/* 40 */       this.bulletinObserver = bulletinObserver;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 45 */       if ((!OpenInterface.getOpenStatus(12)) || (!ActivityInterface.isActivityOpen(SParaseleneCfgConsts.getInstance().ActivityId)))
/*    */       {
/*    */ 
/* 48 */         this.bulletinObserver.stopTimer();
/* 49 */         return false;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 55 */       int rest = SParaseleneCfgConsts.getInstance().Minute_To_End - this.bulletinObserver.count * SParaseleneCfgConsts.getInstance().Bulletin_Inteval;
/*    */       
/* 57 */       if (rest < 0)
/*    */       {
/* 59 */         this.bulletinObserver.stopTimer();
/* 60 */         return false;
/*    */       }
/* 62 */       ParaseleneManager.broadcastActivityClose(rest);
/*    */       
/* 64 */       this.bulletinObserver.setIntervalSeconds(TimeUnit.MINUTES.toSeconds(SParaseleneCfgConsts.getInstance().Bulletin_Inteval));
/* 65 */       BulletinObserver.access$008(this.bulletinObserver);
/* 66 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\BulletinObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */