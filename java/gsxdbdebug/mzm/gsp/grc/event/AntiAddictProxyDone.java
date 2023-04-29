/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AntiAddictProxyDone extends mzm.event.BasicEvent<AntiAddictProxyDoneArg>
/*    */ {
/*  7 */   private static EventManager<AntiAddictProxyDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AntiAddictProxyDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.addiction.main.POnAntiAddictProxyDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\AntiAddictProxyDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */