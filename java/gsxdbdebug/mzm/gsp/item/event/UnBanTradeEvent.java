/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UnBanTradeEvent extends mzm.event.BasicEvent<TradeArg>
/*    */ {
/*  7 */   private static EventManager<TradeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TradeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.mall.main.POnItemUnBanTrade());
/* 16 */     manager.register(new mzm.gsp.shanghui.main.POnItemUnBanTrade());
/* 17 */     manager.register(new mzm.gsp.pet.main.POnPetUnBanTrade());
/* 18 */     manager.register(new mzm.gsp.market.main.POnItemUnBanTrade());
/* 19 */     manager.register(new mzm.gsp.market.main.POnPetUnBanTrade());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\UnBanTradeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */