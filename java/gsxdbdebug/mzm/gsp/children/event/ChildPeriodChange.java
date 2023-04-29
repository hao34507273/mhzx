/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildPeriodChange extends mzm.event.BasicEvent<ChildPeriodChangeArg>
/*    */ {
/*  7 */   private static EventManager<ChildPeriodChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildPeriodChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnChildPeriodChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildPeriodChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */