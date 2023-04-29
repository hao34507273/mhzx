/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.item.SSynRoleExchangeUseItemInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleExchangeUseItemInfo;
/*    */ 
/*    */ public class POnRoleLoginForExchangeUseItem extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     RoleExchangeUseItemInfo xRoleExchangeUseItemInfo = xtable.Role_exchange_use_item_infos.get(Long.valueOf(roleid));
/* 18 */     if ((xRoleExchangeUseItemInfo == null) || (xRoleExchangeUseItemInfo.getExchange_use_item_infos().isEmpty()))
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     SSynRoleExchangeUseItemInfo protocol = new SSynRoleExchangeUseItemInfo();
/* 23 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 24 */     for (Map.Entry<Integer, xbean.ExchangeUseItemInfo> entry : xRoleExchangeUseItemInfo.getExchange_use_item_infos().entrySet())
/*    */     {
/* 26 */       int exchangeCfgid = ((Integer)entry.getKey()).intValue();
/* 27 */       xbean.ExchangeUseItemInfo xExchangeUseItemInfo = (xbean.ExchangeUseItemInfo)entry.getValue();
/* 28 */       if (DateTimeUtils.needDailyReset(xExchangeUseItemInfo.getTimestamp(), now, 0))
/*    */       {
/* 30 */         xExchangeUseItemInfo.setDaily_exchange_times(0);
/* 31 */         xExchangeUseItemInfo.setTimestamp(now);
/*    */       }
/* 33 */       mzm.gsp.item.ExchangeUseItemInfo exchangeUseItemInfo = new mzm.gsp.item.ExchangeUseItemInfo();
/* 34 */       exchangeUseItemInfo.exchange_times = xExchangeUseItemInfo.getExchange_times();
/* 35 */       exchangeUseItemInfo.daily_exchange_times = xExchangeUseItemInfo.getDaily_exchange_times();
/* 36 */       protocol.role_exchange_use_item_infos.put(Integer.valueOf(exchangeCfgid), exchangeUseItemInfo);
/*    */     }
/* 38 */     OnlineManager.getInstance().send(roleid, protocol);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginForExchangeUseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */