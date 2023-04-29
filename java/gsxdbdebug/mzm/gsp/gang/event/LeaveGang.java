/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LeaveGang extends mzm.event.BasicEvent<LeaveGangArg>
/*    */ {
/*  7 */   private static EventManager<LeaveGangArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LeaveGangArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chat.main.POnleaveGang());
/* 16 */     manager.register(new mzm.gsp.title.main.POnleaveGang());
/* 17 */     manager.register(new mzm.gsp.gang.main.POnleaveGang());
/* 18 */     manager.register(new mzm.gsp.huanhun.main.POnleaveGang());
/* 19 */     manager.register(new mzm.gsp.factiontask.main.POnleaveGang());
/* 20 */     manager.register(new mzm.gsp.msdkprofile.main.POnleaveGang());
/* 21 */     manager.register(new mzm.gsp.worship.main.POnleaveGang());
/* 22 */     manager.register(new mzm.gsp.crosscompete.main.POnLeaveGang());
/* 23 */     manager.register(new mzm.gsp.friendscircle.main.POnLeaveGang());
/* 24 */     manager.register(new mzm.gsp.achievement.main.ROnLeaveGang());
/* 25 */     manager.register(new mzm.gsp.makeup.main.POnLeaveGang());
/* 26 */     manager.register(new mzm.gsp.cake.main.POnLeaveGang());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\LeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */