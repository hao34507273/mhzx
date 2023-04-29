/*    */ package mzm.gsp.ladder.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleAttendLadder extends mzm.event.BasicEvent<RoleAttendLadderArg>
/*    */ {
/*  7 */   private static EventManager<RoleAttendLadderArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleAttendLadderArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRoleAttendLadder());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\event\RoleAttendLadder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */