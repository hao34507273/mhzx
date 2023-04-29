/*    */ package mzm.gsp.apollo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CreateVoipRoomResponse extends mzm.event.BasicEvent<CreateVoipRoomResponseArg>
/*    */ {
/*  7 */   private static EventManager<CreateVoipRoomResponseArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CreateVoipRoomResponseArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.apollo.main.POnCreateVoipRoomResponse());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\event\CreateVoipRoomResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */