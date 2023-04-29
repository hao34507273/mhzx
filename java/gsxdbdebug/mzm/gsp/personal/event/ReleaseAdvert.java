/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ReleaseAdvert extends mzm.event.BasicEvent<ReleaseAdvertArg>
/*    */ {
/*  7 */   private static EventManager<ReleaseAdvertArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ReleaseAdvertArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.personal.main.POnReleaseAdvertAddCache());
/* 16 */     manager.register(new mzm.gsp.personal.main.POnReleaseAdvertAddLRU());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\ReleaseAdvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */