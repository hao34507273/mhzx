/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildWearFashion extends mzm.event.BasicEvent<ChildWearFashionArg>
/*    */ {
/*  7 */   private static EventManager<ChildWearFashionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildWearFashionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChildWearFashionChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildWearFashion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */