/*    */ package mzm.gsp.christmasstocking.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChristmasStockingTreeAdd extends mzm.event.BasicEvent<ChristmasStockingTreeAddArg>
/*    */ {
/*  7 */   private static EventManager<ChristmasStockingTreeAddArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChristmasStockingTreeAddArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChristmasStockingTreeAdd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\event\ChristmasStockingTreeAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */