/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinGang extends mzm.event.BasicEvent<GangArg>
/*    */ {
/*  7 */   private static EventManager<GangArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chat.main.POnJoinGang());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnJoinGang());
/* 17 */     manager.register(new mzm.gsp.guide.main.POnJoinGang());
/* 18 */     manager.register(new mzm.gsp.title.main.POnJoinGang());
/* 19 */     manager.register(new mzm.gsp.msdkprofile.main.POnJoinGang());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnJoinGang());
/* 21 */     manager.register(new mzm.gsp.huanhun.main.POnJoinGang());
/* 22 */     manager.register(new mzm.gsp.worship.main.POnJoinGang());
/* 23 */     manager.register(new mzm.gsp.factionpve.main.POnJoinGang());
/* 24 */     manager.register(new mzm.gsp.crosscompete.main.POnJoinGang());
/* 25 */     manager.register(new mzm.gsp.friendscircle.main.POnGangInfoChange());
/* 26 */     manager.register(new mzm.gsp.makeup.main.POnJoinGang());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\JoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */