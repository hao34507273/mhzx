/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CreateGang extends mzm.event.BasicEvent<GangArg>
/*    */ {
/*  7 */   private static EventManager<GangArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chat.main.POnCreateGang());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnJoinGang());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnJoinGang());
/* 18 */     manager.register(new mzm.gsp.title.main.POnCreateGang());
/* 19 */     manager.register(new mzm.gsp.gangrace.main.POnCreateGang());
/* 20 */     manager.register(new mzm.gsp.msdkprofile.main.POnCreateGang());
/* 21 */     manager.register(new mzm.gsp.worship.main.POnCreateGang());
/* 22 */     manager.register(new mzm.gsp.friendscircle.main.POnGangInfoChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\CreateGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */