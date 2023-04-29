/*    */ package mzm.gsp.prison.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleOutOfJail extends mzm.event.BasicEvent<RoleOutOfJailArg>
/*    */ {
/*  7 */   private static EventManager<RoleOutOfJailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleOutOfJailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\event\RoleOutOfJail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */