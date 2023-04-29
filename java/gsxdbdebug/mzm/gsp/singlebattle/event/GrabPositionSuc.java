/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GrabPositionSuc extends mzm.event.BasicEvent<mzm.gsp.singlebattle.grab.EventArg_GrabPositionSuc>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.singlebattle.grab.EventArg_GrabPositionSuc> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.singlebattle.grab.EventArg_GrabPositionSuc> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.task.POnGrabPositionSuc());
/* 16 */     manager.register(new mzm.gsp.singlebattle.grab.POnGrabPositionSuc());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\GrabPositionSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */