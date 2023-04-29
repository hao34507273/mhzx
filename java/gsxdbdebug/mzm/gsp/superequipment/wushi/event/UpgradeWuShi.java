/*    */ package mzm.gsp.superequipment.wushi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UpgradeWuShi extends mzm.event.BasicEvent<UpgradeWuShiArg>
/*    */ {
/*  7 */   private static EventManager<UpgradeWuShiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UpgradeWuShiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnUpgradeWuShi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\event\UpgradeWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */