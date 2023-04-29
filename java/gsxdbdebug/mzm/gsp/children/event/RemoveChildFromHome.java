/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemoveChildFromHome extends mzm.event.BasicEvent<RemoveChildFromHomeArg>
/*    */ {
/*  7 */   private static EventManager<RemoveChildFromHomeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemoveChildFromHomeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnRemoveChild());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\RemoveChildFromHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */