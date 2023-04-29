/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.main.ItemBanTrade;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shanghui.SSyncBanShopingList;
/*    */ import mzm.gsp.shanghui.confbean.SShangHuiConsts;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (!ShanghuiManager.isShangHuiSwitchOpenForRole(((Long)this.arg).longValue(), false)) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     int level = RoleInterface.getLevel(((Long)this.arg).longValue());
/* 23 */     if (level < SShangHuiConsts.getInstance().OPEN_LEVEL) {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     Set<Integer> banItemSet = ItemBanTrade.getInstance().getBanTradeIds(ItemBanTrade.TradeTypeEnum.SHANGHUI.value);
/* 28 */     if (banItemSet.size() > 0) {
/* 29 */       SSyncBanShopingList sSyncBanShopingList = new SSyncBanShopingList();
/* 30 */       sSyncBanShopingList.banitemlist.addAll(banItemSet);
/* 31 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncBanShopingList);
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */