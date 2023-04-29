/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SelectionOrFinalJoinSucceed extends mzm.event.BasicEvent<SelectionOrFinalJoinSucceedArg>
/*    */ {
/*  7 */   private static EventManager<SelectionOrFinalJoinSucceedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SelectionOrFinalJoinSucceedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossserver.main.POnSelectionOrFinalJoinSucceed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SelectionOrFinalJoinSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */