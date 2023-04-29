/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.award.SGetGiftRep;
/*    */ import mzm.gsp.giftaward.confbean.SClientGetGiftCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.AwarGiftInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PInitXAwarGiftInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     AwarGiftInfo xAwarGiftInfo = GiftManager.getAwarGiftIfNotExist();
/* 25 */     Map<Integer, Integer> useType2Global = xAwarGiftInfo.getType2global();
/*    */     
/* 27 */     for (SClientGetGiftCfg cfg : SClientGetGiftCfg.getAll().values())
/*    */     {
/* 29 */       int cfgUseType = cfg.useType;
/* 30 */       int cfgGlobal = cfg.global;
/* 31 */       Integer xGlobal = (Integer)useType2Global.get(Integer.valueOf(cfgUseType));
/* 32 */       if (xGlobal == null)
/*    */       {
/* 34 */         xGlobal = Integer.valueOf(cfgGlobal);
/* 35 */         useType2Global.put(Integer.valueOf(cfgUseType), Integer.valueOf(cfgGlobal));
/*    */       }
/* 37 */       if (cfg.activityId <= 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 42 */         if (xGlobal.intValue() < cfgGlobal)
/*    */         {
/* 44 */           useType2Global.put(Integer.valueOf(cfgUseType), Integer.valueOf(cfgGlobal));
/* 45 */           if (cfg.maxCount > 0)
/*    */           {
/*    */ 
/* 48 */             SGetGiftRep pro = new SGetGiftRep(cfgUseType, 0);
/* 49 */             OnlineManager.getInstance().sendAll(pro);
/*    */           }
/*    */         } }
/*    */     }
/* 53 */     GlobalGiftManager.addAllGlobalInfo(useType2Global);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\PInitXAwarGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */