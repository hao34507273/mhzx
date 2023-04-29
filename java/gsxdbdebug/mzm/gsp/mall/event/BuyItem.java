/*    */ package mzm.gsp.mall.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BuyItem extends mzm.event.BasicEvent<BuyItemArg>
/*    */ {
/*  7 */   private static EventManager<BuyItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BuyItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnBuyMallItem());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\event\BuyItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */