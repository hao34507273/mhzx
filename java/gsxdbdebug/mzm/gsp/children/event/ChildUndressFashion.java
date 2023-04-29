/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildUndressFashion extends mzm.event.BasicEvent<ChildUndressFashionArg>
/*    */ {
/*  7 */   private static EventManager<ChildUndressFashionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildUndressFashionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChildUndressFashionChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildUndressFashion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */