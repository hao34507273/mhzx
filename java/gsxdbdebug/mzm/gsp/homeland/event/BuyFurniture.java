/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BuyFurniture extends mzm.event.BasicEvent<BuyFurnitureArg>
/*    */ {
/*  7 */   private static EventManager<BuyFurnitureArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BuyFurnitureArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnBuyFurniture());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\BuyFurniture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */