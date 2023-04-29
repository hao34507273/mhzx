/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildRatingChange extends mzm.event.BasicEvent<ChildRatingChangeArg>
/*    */ {
/*  7 */   private static EventManager<ChildRatingChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildRatingChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.main.POnChildRatingChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildRatingChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */