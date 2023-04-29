/*    */ package mzm.gsp.active.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ClearActivePointPoint extends mzm.event.BasicEvent<ClearActivePointArg>
/*    */ {
/*  7 */   private static EventManager<ClearActivePointArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ClearActivePointArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.shitu.main.POnClearActivePointPoint());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\event\ClearActivePointPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */