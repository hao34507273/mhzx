/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildNameChange extends mzm.event.BasicEvent<ChildNameChangeArg>
/*    */ {
/*  7 */   private static EventManager<ChildNameChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildNameChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChildNameChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildNameChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */