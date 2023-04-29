/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildShowModelChange extends mzm.event.BasicEvent<ChildShowModelChangeArg>
/*    */ {
/*  7 */   private static EventManager<ChildShowModelChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildShowModelChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleChildShowModelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildShowModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */