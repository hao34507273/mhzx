/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SelectionOrFinalMatchSucceed extends mzm.event.BasicEvent<SelectionOrFinalMatchSucceedArg>
/*    */ {
/*  7 */   private static EventManager<SelectionOrFinalMatchSucceedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SelectionOrFinalMatchSucceedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnSelectionOrFinalMatchSucceed());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnSelectionOrFinalMatchSucceed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SelectionOrFinalMatchSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */