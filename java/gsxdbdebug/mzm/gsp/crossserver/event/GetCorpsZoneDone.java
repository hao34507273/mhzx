/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetCorpsZoneDone extends mzm.event.BasicEvent<GetCorpsZoneDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetCorpsZoneDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetCorpsZoneDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnGetCorpsZoneDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetCorpsZoneDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */