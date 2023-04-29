/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.award.confbean.ItemdropMod;
/*    */ import mzm.gsp.award.confbean.SAwardItemContent;
/*    */ import mzm.gsp.award.gem.AwardGemManager;
/*    */ import mzm.gsp.award.gift.PInitXAwarGiftInfo;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AwardModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 22 */     AwardManager.init();
/* 23 */     PBuffEffect.init();
/* 24 */     AwardGemManager.loadDBCountInfos();
/* 25 */     AwardGemManager.checkGemOpenCfg();
/* 26 */     AwardGemManager.rmAllAwardIdXData();
/*    */     
/*    */ 
/* 29 */     OpenInterface.setOpenDefaultStatus(152, false);
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 48 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 54 */     new PInitXAwarGiftInfo().execute();
/*    */     
/*    */ 
/* 57 */     for (SAwardItemContent awardItem : SAwardItemContent.getAll().values())
/*    */     {
/* 59 */       for (ItemdropMod itemDrop : awardItem.itemdropModList)
/*    */       {
/* 61 */         if (itemDrop.dropType == 1)
/*    */         {
/* 63 */           if (!ItemInterface.isItemExist(itemDrop.itemId))
/*    */           {
/* 65 */             throw new RuntimeException("5005_物品奖励内容表配置的道具不存在:itemId:" + itemDrop.itemId);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\AwardModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */