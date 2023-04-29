/*    */ package mzm.gsp.magicmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MagicMarkTypeUpdateEvent extends mzm.event.BasicEvent<MagicMarkTypeUpdateArg>
/*    */ {
/*  7 */   private static EventManager<MagicMarkTypeUpdateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MagicMarkTypeUpdateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnMagicMarkTypeUpdate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\event\MagicMarkTypeUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */