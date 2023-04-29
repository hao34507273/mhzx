/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleCrossFieldMatchStart extends mzm.event.BasicEvent<SingleCrossFieldMatchStartArg>
/*    */ {
/*  7 */   private static EventManager<SingleCrossFieldMatchStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleCrossFieldMatchStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossserver.main.POnSingleCrossFieldMatchStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldMatchStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */