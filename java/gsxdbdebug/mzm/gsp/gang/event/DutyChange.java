/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DutyChange extends mzm.event.BasicEvent<GangArg>
/*    */ {
/*  7 */   private static EventManager<GangArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.title.main.POnGangDutyChange());
/* 16 */     manager.register(new mzm.gsp.msdkprofile.main.POnGangDutyChange());
/* 17 */     manager.register(new mzm.gsp.worship.main.POnGangDutyChange());
/* 18 */     manager.register(new mzm.gsp.achievement.main.POnGangDutyChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\DutyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */