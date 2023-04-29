/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleCrossFieldCancelMatchSuccess extends mzm.event.BasicEvent<SingleCrossFieldCancelMatchSuccessArg>
/*    */ {
/*  7 */   private static EventManager<SingleCrossFieldCancelMatchSuccessArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleCrossFieldCancelMatchSuccessArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnSingleCrossFieldCancelMatchSuccess());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnSingleCrossFieldCancelMatchSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldCancelMatchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */