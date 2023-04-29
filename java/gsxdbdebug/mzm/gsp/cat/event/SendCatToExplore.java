/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SendCatToExplore extends mzm.event.BasicEvent<SendCatToExploreArg>
/*    */ {
/*  7 */   private static EventManager<SendCatToExploreArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SendCatToExploreArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnCatOut());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\SendCatToExplore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */