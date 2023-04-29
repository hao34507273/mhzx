/*    */ package mzm.gsp.title.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AppOrTitleChange extends mzm.event.BasicEvent<mzm.gsp.title.main.AppOrTitleChangeArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.title.main.AppOrTitleChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.title.main.AppOrTitleChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnAppOrTitleChangeArg());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\event\AppOrTitleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */