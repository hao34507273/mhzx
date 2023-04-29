/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.event.BanTradeEventProcedure;
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.main.ItemBanTrade;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SSyncBanPetList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnPetUnBanTrade
/*    */   extends BanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (((TradeArg)this.arg).tradeType != ItemBanTrade.TradeTypeEnum.PET_SHOP.value) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     List<Long> roleIdList = OnlineManager.getInstance().getAllRolesInWorld();
/* 26 */     Set<Integer> banPetSet = ItemBanTrade.getInstance().getBanTradeIds(ItemBanTrade.TradeTypeEnum.PET_SHOP.value);
/* 27 */     SSyncBanPetList sSyncBanPetList = new SSyncBanPetList();
/* 28 */     sSyncBanPetList.banpetlist.addAll(banPetSet);
/* 29 */     OnlineManager.getInstance().sendMulti(sSyncBanPetList, roleIdList);
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\POnPetUnBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */