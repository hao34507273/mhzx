/*    */ package mzm.gsp.apollo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CloseVoipRoomResponse extends mzm.event.BasicEvent<CloseVoipRoomResponseArg>
/*    */ {
/*  7 */   private static EventManager<CloseVoipRoomResponseArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CloseVoipRoomResponseArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.apollo.main.POnCloseVoipRoomResponse());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\event\CloseVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */