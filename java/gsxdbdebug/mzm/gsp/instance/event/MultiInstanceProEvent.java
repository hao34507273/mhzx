/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MultiInstanceProEvent extends mzm.event.BasicEvent<MultiInstanceProArg>
/*    */ {
/*  7 */   private static EventManager<MultiInstanceProArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MultiInstanceProArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnMultiInstanceProEvent());
/* 16 */     manager.register(new mzm.gsp.active.main.POnMultiInstanceProEvent());
/* 17 */     manager.register(new mzm.gsp.grow.LevelGuide.POnMultiInstanceProEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\MultiInstanceProEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */