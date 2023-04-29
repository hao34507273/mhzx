/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ExtendBagEvent extends mzm.event.BasicEvent<ExtendBagArg>
/*    */ {
/*  7 */   private static EventManager<ExtendBagArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ExtendBagArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnExtendBag());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\ExtendBagEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */