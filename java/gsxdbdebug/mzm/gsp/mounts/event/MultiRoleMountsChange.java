/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MultiRoleMountsChange extends mzm.event.BasicEvent<MultiRoleMountsChangeArg>
/*    */ {
/*  7 */   private static EventManager<MultiRoleMountsChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MultiRoleMountsChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.mounts.main.POnMultiRoleMountsChange());
/* 16 */     manager.register(new mzm.gsp.map.main.POnMultiRoleMountsChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MultiRoleMountsChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */