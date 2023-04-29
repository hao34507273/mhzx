/*    */ package mzm.gsp.apollo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ExitVoipRoomResponse extends mzm.event.BasicEvent<ExitVoipRoomResponseArg>
/*    */ {
/*  7 */   private static EventManager<ExitVoipRoomResponseArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ExitVoipRoomResponseArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.apollo.main.POnExitVoipRoomResponse());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\event\ExitVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */