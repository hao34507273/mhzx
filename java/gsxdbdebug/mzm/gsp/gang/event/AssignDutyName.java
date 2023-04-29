/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AssignDutyName extends mzm.event.BasicEvent<GangArg>
/*    */ {
/*  7 */   private static EventManager<GangArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.title.main.POnAssignDutyName());
/* 16 */     manager.register(new mzm.gsp.worship.main.POnAssignDutyName());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\AssignDutyName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */