/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import mzm.gsp.mail.confbean.SMailCfgConsts;
/*    */ 
/*    */ public class MailManager
/*    */ {
/*  7 */   private static MailManager instance = new MailManager();
/*    */   
/*    */   public static MailManager getInstance() {
/* 10 */     return instance;
/*    */   }
/*    */   
/*    */   public void init() {}
/*    */   
/*    */   public int getStoreTimeByType(int mailType)
/*    */   {
/* 17 */     int storeTime = SMailCfgConsts.getInstance().SYS_MAIL_STORE_H;
/* 18 */     switch (mailType) {
/*    */     case 1: 
/* 20 */       storeTime = SMailCfgConsts.getInstance().SYS_MAIL_STORE_H;
/* 21 */       break;
/*    */     case 2: 
/* 23 */       storeTime = SMailCfgConsts.getInstance().BAG_FULL_STORE_H;
/* 24 */       break;
/*    */     case 3: 
/* 26 */       storeTime = SMailCfgConsts.getInstance().PLAYER_SEND;
/*    */     case 4: 
/* 28 */       storeTime = SMailCfgConsts.getInstance().FACTION_STORE_H;
/*    */     case 6: 
/* 30 */       storeTime = SMailCfgConsts.getInstance().PET_ARENA_DAILY_RANK_AWARD_STORE_H;
/*    */     }
/*    */     
/*    */     
/* 34 */     return storeTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\MailManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */