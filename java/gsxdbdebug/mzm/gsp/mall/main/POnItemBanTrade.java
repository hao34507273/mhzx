/*    */ package mzm.gsp.mall.main;
/*    */ 
/*    */ import mzm.gsp.item.event.BanTradeEventProcedure;
/*    */ import mzm.gsp.item.event.TradeArg;
/*    */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnItemBanTrade
/*    */   extends BanTradeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (((TradeArg)this.arg).tradeType == ItemBanTrade.TradeTypeEnum.MALL.value)
/*    */     {
/* 16 */       for (Long roleId : OnlineManager.getInstance().getAllRolesInWorld())
/*    */       {
/* 18 */         NoneRealTimeTaskManager.getInstance().addTask(new PSynAllMallItemNum(roleId.longValue()));
/*    */       }
/*    */     }
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\main\POnItemBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */