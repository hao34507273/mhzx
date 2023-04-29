/*    */ package mzm.gsp.superequipment.wushi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DelWuShi extends mzm.event.BasicEvent<DelWuShiArg>
/*    */ {
/*  7 */   private static EventManager<DelWuShiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DelWuShiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnDelWuShi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\event\DelWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */