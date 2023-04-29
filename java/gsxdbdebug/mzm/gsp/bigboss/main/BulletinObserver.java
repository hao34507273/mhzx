/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*    */ import mzm.gsp.bulletin.SBulletinInfo;
/*    */ import mzm.gsp.bulletin.main.BulletinInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class BulletinObserver
/*    */   extends Observer
/*    */ {
/* 17 */   private int count = -1;
/*    */   
/*    */   public BulletinObserver(long intervalSeconds)
/*    */   {
/* 21 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 28 */     new SendBulletinPro(this).execute();
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   private static class SendBulletinPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private BulletinObserver bulletinObserver;
/*    */     
/*    */     public SendBulletinPro(BulletinObserver bulletinObserver)
/*    */     {
/* 39 */       this.bulletinObserver = bulletinObserver;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       if (GameServerInfoManager.isRoamServer())
/*    */       {
/* 47 */         this.bulletinObserver.stopTimer();
/* 48 */         return false;
/*    */       }
/* 50 */       if ((!OpenInterface.getOpenStatus(14)) || (!ActivityInterface.isActivityOpen(SBigbossCfgConsts.getInstance().ACTIVITYID)))
/*    */       {
/*    */ 
/* 53 */         this.bulletinObserver.stopTimer();
/* 54 */         return false;
/*    */       }
/* 56 */       BulletinObserver.access$008(this.bulletinObserver);
/* 57 */       if (this.bulletinObserver.count >= BigbossManager.getBulletinCount())
/*    */       {
/* 59 */         this.bulletinObserver.stopTimer();
/* 60 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 64 */       int monstersortid = BigbossManager.getBigbossActivityMonsterSordId();
/* 65 */       int decRate = BigbossManager.getDecHpRate(this.bulletinObserver.count);
/* 66 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 67 */       bulletinInfo.bulletintype = 22;
/* 68 */       bulletinInfo.params.put(Integer.valueOf(7), String.valueOf(BigbossManager.getMonsterId(monstersortid)));
/* 69 */       bulletinInfo.params.put(Integer.valueOf(20), String.valueOf(decRate));
/* 70 */       BulletinInterface.sendBulletin(bulletinInfo);
/* 71 */       this.bulletinObserver.setIntervalSeconds(BigbossManager.getBulletinInterval());
/*    */       
/* 73 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\BulletinObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */