/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinPointRaceStart extends mzm.event.BasicEvent<JoinPointRaceStartArg>
/*    */ {
/*  7 */   private static EventManager<JoinPointRaceStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinPointRaceStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossserver.main.POnJoinPointRaceStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRaceStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */