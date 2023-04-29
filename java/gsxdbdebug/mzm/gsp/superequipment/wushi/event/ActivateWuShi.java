/*    */ package mzm.gsp.superequipment.wushi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivateWuShi extends mzm.event.BasicEvent<ActivateWuShiArg>
/*    */ {
/*  7 */   private static EventManager<ActivateWuShiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivateWuShiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnActivateWuShi());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnActivateWuShi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\event\ActivateWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */