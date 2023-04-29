/*    */ package mzm.gsp.christmasstocking.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChristmasHiddenStockingAdd extends mzm.event.BasicEvent<ChristmasHiddenStockingAddArg>
/*    */ {
/*  7 */   private static EventManager<ChristmasHiddenStockingAddArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChristmasHiddenStockingAddArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChristmasHiddenStockingAdd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\event\ChristmasHiddenStockingAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */