/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SelectionOrFinalMatchFailed extends mzm.event.BasicEvent<SelectionOrFinalMatchFailedArg>
/*    */ {
/*  7 */   private static EventManager<SelectionOrFinalMatchFailedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SelectionOrFinalMatchFailedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnSelectionOrFinalMatchFailed());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnSelectionOrFinalMatchFailed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SelectionOrFinalMatchFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */