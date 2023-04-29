/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.giftaward.confbean.SClientGetGiftCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.AwarGiftInfo;
/*    */ import xbean.Pod;
/*    */ import xtable.Awardgift;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GiftManager
/*    */ {
/*    */   static boolean isNewClientOpen(long roleId, boolean doNotice)
/*    */   {
/* 23 */     if (!OpenInterface.getOpenStatus(106))
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (OpenInterface.isBanPlay(roleId, 106))
/*    */     {
/* 29 */       if (doNotice)
/*    */       {
/* 31 */         OpenInterface.sendBanPlayMsg(roleId, 106);
/*    */       }
/* 33 */       return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   static GiftAwardType getGiftAwardType(String userId, long roleId, int usetType, int awardType)
/*    */   {
/* 40 */     switch (awardType)
/*    */     {
/*    */     case 1: 
/* 43 */       return new AwardFix(userId, roleId, usetType);
/*    */     
/*    */ 
/*    */     case 2: 
/* 47 */       return new AwardMail(userId, roleId, usetType);
/*    */     
/*    */ 
/*    */     case 3: 
/* 51 */       return new AwardItem(userId, roleId, usetType);
/*    */     }
/*    */     
/* 54 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int awardCountMaxCfg(int useType)
/*    */   {
/* 67 */     SClientGetGiftCfg cfg = SClientGetGiftCfg.get(useType);
/* 68 */     if (cfg == null)
/*    */     {
/* 70 */       return 0;
/*    */     }
/* 72 */     return cfg.maxCount;
/*    */   }
/*    */   
/*    */   static AwarGiftInfo getAwarGiftIfNotExist()
/*    */   {
/* 77 */     AwarGiftInfo xAwarGiftInfo = Awardgift.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 78 */     if (xAwarGiftInfo == null)
/*    */     {
/* 80 */       xAwarGiftInfo = Pod.newAwarGiftInfo();
/* 81 */       Awardgift.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xAwarGiftInfo);
/*    */     }
/* 83 */     return xAwarGiftInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\GiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */