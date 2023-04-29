/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoamPointRaceDataStart extends mzm.event.BasicEvent<RoamPointRaceDataStartArg>
/*    */ {
/*  7 */   private static EventManager<RoamPointRaceDataStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoamPointRaceDataStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnRoamPointRaceDataStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RoamPointRaceDataStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */