/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleCrossFieldMatchFail extends mzm.event.BasicEvent<SingleCrossFieldMatchFailArg>
/*    */ {
/*  7 */   private static EventManager<SingleCrossFieldMatchFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleCrossFieldMatchFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnSingleCrossFieldMatchFail());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnSingleCrossFieldMatchFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldMatchFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */