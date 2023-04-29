/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleCrossFieldCancelMatchFail extends mzm.event.BasicEvent<SingleCrossFieldCancelMatchFailArg>
/*    */ {
/*  7 */   private static EventManager<SingleCrossFieldCancelMatchFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleCrossFieldCancelMatchFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnSingleCrossFieldCancelMatchFail());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnSingleCrossFieldCancelMatchFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldCancelMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */