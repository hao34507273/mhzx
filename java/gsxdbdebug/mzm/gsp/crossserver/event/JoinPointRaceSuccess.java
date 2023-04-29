/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinPointRaceSuccess extends mzm.event.BasicEvent<JoinPointRaceSuccessArg>
/*    */ {
/*  7 */   private static EventManager<JoinPointRaceSuccessArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinPointRaceSuccessArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnJoinPointRaceSuccess());
/* 16 */     manager.register(new mzm.gsp.crossserver.main.POnJoinPointRaceSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRaceSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */