/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class HomeStateChangeEvent extends mzm.event.BasicEvent<HomeStateChangeArg>
/*    */ {
/*  7 */   private static EventManager<HomeStateChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<HomeStateChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.cat.main.POnHomeStateChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\HomeStateChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */