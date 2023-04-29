/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.event.UnBanTradeEventProcedure;
/*    */ import mzm.gsp.item.main.ItemBanTrade;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.shanghui.SSyncBanShopingList;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnItemUnBanTrade
/*    */   extends UnBanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!ShanghuiManager.isShangHuiSwitchOpen()) {
/* 23 */       return false;
/*    */     }
/* 25 */     if (((TradeArg)this.arg).tradeType != ItemBanTrade.TradeTypeEnum.SHANGHUI.value) {
/* 26 */       return false;
/*    */     }
/* 28 */     List<Long> roleIdList = OnlineManager.getInstance().getOnlineHigherRoleidList((int)SShangHuiConsts.getInstance().OPEN_LEVEL - 1);
/* 29 */     Set<Integer> banItemSet = ItemBanTrade.getInstance().getBanTradeIds(ItemBanTrade.TradeTypeEnum.SHANGHUI.value);
/* 30 */     SSyncBanShopingList sSyncBanShopingList = new SSyncBanShopingList();
/* 31 */     sSyncBanShopingList.banitemlist.addAll(banItemSet);
/* 32 */     OnlineManager.getInstance().sendMulti(sSyncBanShopingList, roleIdList);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnItemUnBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */