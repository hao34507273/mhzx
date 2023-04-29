/*    */ package mzm.gsp.christmasstocking.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChristmasStockingTreeRemove extends mzm.event.BasicEvent<ChristmasStockingTreeRemoveArg>
/*    */ {
/*  7 */   private static EventManager<ChristmasStockingTreeRemoveArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChristmasStockingTreeRemoveArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChristmasStockingTreeRemove());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\event\ChristmasStockingTreeRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */