/*    */ package mzm.gsp.floor.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PassFloorEvent extends mzm.event.BasicEvent<RolePassFloorEventArg>
/*    */ {
/*  7 */   private static EventManager<RolePassFloorEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RolePassFloorEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRolePassFloor());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\event\PassFloorEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */