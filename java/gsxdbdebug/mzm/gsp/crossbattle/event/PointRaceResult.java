/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PointRaceResult extends mzm.event.BasicEvent<PointRaceResultArg>
/*    */ {
/*  7 */   private static EventManager<PointRaceResultArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PointRaceResultArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnPointRaceResult());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\PointRaceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */