/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleCrossFieldMatchSuccess extends mzm.event.BasicEvent<SingleCrossFieldMatchSuccessArg>
/*    */ {
/*  7 */   private static EventManager<SingleCrossFieldMatchSuccessArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleCrossFieldMatchSuccessArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnSingleCrossFieldMatchSuccess());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnSingleCrossFieldMatchSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldMatchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */