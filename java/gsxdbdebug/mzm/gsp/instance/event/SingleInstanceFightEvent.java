/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleInstanceFightEvent extends mzm.event.BasicEvent<SingleFightArg>
/*    */ {
/*  7 */   private static EventManager<SingleFightArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleFightArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnSingleInstanceFightEvent());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnSingleInstanceFightEvent());
/* 17 */     manager.register(new mzm.gsp.role.main.POnSingleInstanceFightEvent());
/* 18 */     manager.register(new mzm.gsp.active.main.POnSingleInstanceFightEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\SingleInstanceFightEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */