/*    */ package mzm.gsp.prison.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PutRoleInJail extends mzm.event.BasicEvent<PutRoleInJailArg>
/*    */ {
/*  7 */   private static EventManager<PutRoleInJailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PutRoleInJailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnPutRoleInJail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\event\PutRoleInJail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */