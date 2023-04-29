/*    */ package mzm.gsp.task.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TaskStateChange extends mzm.event.BasicEvent<mzm.gsp.task.main.TaskEventArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.task.main.TaskEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.task.main.TaskEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnTaskStateChange());
/* 16 */     manager.register(new mzm.gsp.circletask.main.POnTaskStateChange());
/* 17 */     manager.register(new mzm.gsp.baotu.main.POnTaskStateChanged());
/* 18 */     manager.register(new mzm.gsp.shimen.main.POnShimenTaskStateChanged());
/* 19 */     manager.register(new mzm.gsp.factiontask.main.POnGangTaskStateChanged());
/* 20 */     manager.register(new mzm.gsp.seasontask.main.POnSeasonTaskStateChanged());
/* 21 */     manager.register(new mzm.gsp.partner.main.POnTaskStateChanged());
/* 22 */     manager.register(new mzm.gsp.tmpactivity.main.POnTaskStateChanged());
/* 23 */     manager.register(new mzm.gsp.shimen.main.POnShimenTaskGiveUp());
/* 24 */     manager.register(new mzm.gsp.zhenyao.main.POnZhenyaoTaskChanged());
/* 25 */     manager.register(new mzm.gsp.qingyunzhi.main.POnTaskStateChange());
/* 26 */     manager.register(new mzm.gsp.bounty.main.POnTaskStateChange());
/* 27 */     manager.register(new mzm.gsp.instance.main.POnTaskStateChange());
/* 28 */     manager.register(new mzm.gsp.scochallenge.main.POnScoChallengeTaskStateChanged());
/* 29 */     manager.register(new mzm.gsp.guide.main.POnTaskStateChange());
/* 30 */     manager.register(new mzm.gsp.grow.LevelGuide.POnTaskStateChange());
/* 31 */     manager.register(new mzm.gsp.task.main.POnTaskStateChange());
/* 32 */     manager.register(new mzm.gsp.singletask.main.POnTaskStateChange());
/* 33 */     manager.register(new mzm.gsp.interactivetask.main.POnInteractiveTaskChanged());
/* 34 */     manager.register(new mzm.gsp.mourn.main.POnTaskChanged());
/* 35 */     manager.register(new mzm.gsp.feisheng.task.POnTaskStateChange());
/* 36 */     manager.register(new mzm.gsp.homeland.mysteryvisitor.POnTaskStateChange());
/* 37 */     manager.register(new mzm.gsp.shitu.main.POnTaskStateChange());
/* 38 */     manager.register(new mzm.gsp.pk.main.POnTaskStateChanged());
/* 39 */     manager.register(new mzm.gsp.backgameactivity.main.POnTaskStateChange());
/* 40 */     manager.register(new mzm.gsp.task.surprise.POnTaskStateChange());
/* 41 */     manager.register(new mzm.gsp.achievement.main.POnTaskStateChange());
/* 42 */     manager.register(new mzm.gsp.multicommontask.main.POnTaskStateChange());
/* 43 */     manager.register(new mzm.gsp.birthdaypray.main.POnTaskStateChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\event\TaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */