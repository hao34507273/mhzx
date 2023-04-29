/*    */ package mzm.gsp.afk.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AFKDetect extends mzm.event.BasicEvent<AFKDetectArg>
/*    */ {
/*  7 */   private static EventManager<AFKDetectArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AFKDetectArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.antiafk.POnAFKDetect());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\event\AFKDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */