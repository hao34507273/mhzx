/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinPointRaceFail extends mzm.event.BasicEvent<JoinPointRaceFailArg>
/*    */ {
/*  7 */   private static EventManager<JoinPointRaceFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinPointRaceFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnJoinPointRaceFail());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnJoinPointRaceFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRaceFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */