/*    */ package mzm.gsp.title.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AppellationPropertyChange extends mzm.event.BasicEvent<mzm.gsp.title.main.AppellationPropertyChangeArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.title.main.AppellationPropertyChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.title.main.AppellationPropertyChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnAppellationPropertyChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\event\AppellationPropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */