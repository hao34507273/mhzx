/*    */ package mzm.gsp.luckybag.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class OpenLuckyBag extends mzm.event.BasicEvent<OpenLuckyBagArg>
/*    */ {
/*  7 */   private static EventManager<OpenLuckyBagArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<OpenLuckyBagArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnOpenLuckyBag());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\event\OpenLuckyBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */