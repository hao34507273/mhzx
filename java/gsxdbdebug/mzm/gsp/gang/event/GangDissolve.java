/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangDissolve extends mzm.event.BasicEvent<GangArg>
/*    */ {
/*  7 */   private static EventManager<GangArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chat.main.POnGangDissolve());
/* 16 */     manager.register(new mzm.gsp.title.main.POnGangDissolve());
/* 17 */     manager.register(new mzm.gsp.msdkprofile.main.POnGangDissolve());
/* 18 */     manager.register(new mzm.gsp.factiontask.main.POnGangDissolve());
/* 19 */     manager.register(new mzm.gsp.huanhun.main.POnGangDissolve());
/* 20 */     manager.register(new mzm.gsp.worship.main.POnGangDissolve());
/* 21 */     manager.register(new mzm.gsp.cake.main.POnGangDissolve());
/* 22 */     manager.register(new mzm.gsp.chat.main.ROnGangDissolveForChatContentBuffer());
/* 23 */     manager.register(new mzm.gsp.crosscompete.main.POnGangDissolve());
/* 24 */     manager.register(new mzm.gsp.friendscircle.main.POnGangInfoChange());
/* 25 */     manager.register(new mzm.gsp.makeup.main.POnGangInfoChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */