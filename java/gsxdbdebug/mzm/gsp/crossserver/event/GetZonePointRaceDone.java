/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetZonePointRaceDone extends mzm.event.BasicEvent<GetZonePointRaceDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetZonePointRaceDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetZonePointRaceDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnGetZonePointRaceDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetZonePointRaceDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */