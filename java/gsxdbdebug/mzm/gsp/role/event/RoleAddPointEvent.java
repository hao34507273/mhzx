/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleAddPointEvent extends mzm.event.BasicEvent<RoleAddPointArg>
/*    */ {
/*  7 */   private static EventManager<RoleAddPointArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleAddPointArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnRoleAddPointEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\RoleAddPointEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */