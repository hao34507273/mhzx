/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DeleteAdvert extends mzm.event.BasicEvent<DeleteAdvertArg>
/*    */ {
/*  7 */   private static EventManager<DeleteAdvertArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DeleteAdvertArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.personal.main.POnDeleteAdvertRemoveCache());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\DeleteAdvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */