/*    */ package mzm.gsp.baitan.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ShangJiaEvent extends mzm.event.BasicEvent<ShangJiaArg>
/*    */ {
/*  7 */   private static EventManager<ShangJiaArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ShangJiaArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnShangJiaEvent());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnShangJiaEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\event\ShangJiaEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */