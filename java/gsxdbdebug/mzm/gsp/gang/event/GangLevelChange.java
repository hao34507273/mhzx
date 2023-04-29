/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangLevelChange extends mzm.event.BasicEvent<GangLevelChangeArg>
/*    */ {
/*  7 */   private static EventManager<GangLevelChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangLevelChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnGangLevelChange());
/* 16 */     manager.register(new mzm.gsp.msdkprofile.main.POnGangLevelChange());
/* 17 */     manager.register(new mzm.gsp.crosscompete.main.POnGangLevelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangLevelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */