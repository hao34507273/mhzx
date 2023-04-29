/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BanTradeEvent extends mzm.event.BasicEvent<TradeArg>
/*    */ {
/*  7 */   private static EventManager<TradeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TradeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.shanghui.main.POnItemBanTrade());
/* 16 */     manager.register(new mzm.gsp.mall.main.POnItemBanTrade());
/* 17 */     manager.register(new mzm.gsp.market.main.POnItemBanTrade());
/* 18 */     manager.register(new mzm.gsp.market.main.POnPetBanTrade());
/* 19 */     manager.register(new mzm.gsp.pet.main.POnPetBanTrade());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\BanTradeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */