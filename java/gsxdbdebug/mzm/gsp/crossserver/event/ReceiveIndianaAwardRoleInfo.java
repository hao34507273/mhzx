/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReceiveIndianaAwardRoleInfo extends mzm.event.BasicEvent<ReceiveIndianaAwardRoleInfoArg>
/*    */ {
/*  7 */   private static EventManager<ReceiveIndianaAwardRoleInfoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReceiveIndianaAwardRoleInfoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.indiana.main.POnReceiveIndianaAwardRoleInfo());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReceiveIndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */