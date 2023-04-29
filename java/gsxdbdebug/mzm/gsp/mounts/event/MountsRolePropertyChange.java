/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MountsRolePropertyChange extends mzm.event.BasicEvent<MountsRolePropertyChangeArg>
/*    */ {
/*  7 */   private static EventManager<MountsRolePropertyChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MountsRolePropertyChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnMountsRolePropertyChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MountsRolePropertyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */