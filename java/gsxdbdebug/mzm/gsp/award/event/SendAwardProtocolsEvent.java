/*    */ package mzm.gsp.award.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SendAwardProtocolsEvent extends mzm.event.BasicEvent<mzm.gsp.award.main.NeedSendProtocolsArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.award.main.NeedSendProtocolsArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.award.main.NeedSendProtocolsArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.award.main.POnSendAwardProtocols());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\event\SendAwardProtocolsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */