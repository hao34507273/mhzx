/*    */ package mzm.gsp.christmasstocking.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChristmasHiddenStockingRemove extends mzm.event.BasicEvent<ChristmasHiddenStockingRemoveArg>
/*    */ {
/*  7 */   private static EventManager<ChristmasHiddenStockingRemoveArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChristmasHiddenStockingRemoveArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChristmasHiddenStockingRemove());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\event\ChristmasHiddenStockingRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */