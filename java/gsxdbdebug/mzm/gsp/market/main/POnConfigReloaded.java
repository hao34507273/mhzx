/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.market.confbean.SMarketItemCfg;
/*    */ import mzm.gsp.market.confbean.SMarketPetCfg;
/*    */ 
/*    */ public class POnConfigReloaded extends mzm.gsp.config.event.ConfigReloadedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     Set<Integer> oldItemids = new HashSet(SMarketItemCfg.getOldAll().keySet());
/* 15 */     Set<Integer> newItemids = new HashSet(SMarketItemCfg.getAll().keySet());
/*    */     
/* 17 */     oldItemids.removeAll(newItemids);
/* 18 */     for (Iterator i$ = oldItemids.iterator(); i$.hasNext();) { int deleteItemId = ((Integer)i$.next()).intValue();
/*    */       
/*    */ 
/* 21 */       SMarketItemCfg oldMarketItemCfg = SMarketItemCfg.getOld(deleteItemId);
/*    */       
/* 23 */       if (oldMarketItemCfg != null)
/*    */       {
/* 25 */         int subid = oldMarketItemCfg.subid;
/* 26 */         new PDealItemBanTrade(deleteItemId, subid).execute();
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 31 */     Set<Integer> oldPetCfgIds = new HashSet(SMarketPetCfg.getOldAll().keySet());
/* 32 */     Set<Integer> newPetCfgIds = new HashSet(SMarketPetCfg.getAll().keySet());
/*    */     
/* 34 */     oldPetCfgIds.removeAll(newPetCfgIds);
/* 35 */     for (Iterator i$ = oldPetCfgIds.iterator(); i$.hasNext();) { int deletePetId = ((Integer)i$.next()).intValue();
/*    */       
/*    */ 
/* 38 */       SMarketPetCfg oldMarketPetCfg = SMarketPetCfg.getOld(deletePetId);
/*    */       
/* 40 */       if (oldMarketPetCfg != null)
/*    */       {
/* 42 */         int subid = oldMarketPetCfg.subid;
/* 43 */         new PDealPetBanTrade(deletePetId, subid).execute();
/*    */       }
/*    */     }
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */