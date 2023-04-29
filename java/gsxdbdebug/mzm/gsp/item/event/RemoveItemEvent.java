/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemoveItemEvent extends mzm.event.BasicEvent<RemoveItemeArg>
/*    */ {
/*  7 */   private static EventManager<RemoveItemeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemoveItemeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fabao.main.POnRemoveItemEvent());
/* 16 */     manager.register(new mzm.gsp.cat.main.POnRemoveItem());
/* 17 */     manager.register(new mzm.gsp.item.main.POnRemoveItem());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\RemoveItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */