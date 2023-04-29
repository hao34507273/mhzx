/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AddChildIntoHome extends mzm.event.BasicEvent<AddChildIntoHomeArg>
/*    */ {
/*  7 */   private static EventManager<AddChildIntoHomeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AddChildIntoHomeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAddChild());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\AddChildIntoHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */