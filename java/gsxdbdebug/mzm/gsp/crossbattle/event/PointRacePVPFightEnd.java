/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PointRacePVPFightEnd extends mzm.event.BasicEvent<PointRacePVPFightEndArg>
/*    */ {
/*  7 */   private static EventManager<PointRacePVPFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PointRacePVPFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnPointRacePVPFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\PointRacePVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */