/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerAnswerQuestion extends mzm.event.BasicEvent<QuestionArg>
/*    */ {
/*  7 */   private static EventManager<QuestionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<QuestionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnPlayerAnswerQuestion());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnPlayerAnswerQuestion());
/* 17 */     manager.register(new mzm.gsp.active.main.POnPlayerAnswerQuestion());
/* 18 */     manager.register(new mzm.gsp.storageexp.activity.POnPlayerAnswerQuestion());
/* 19 */     manager.register(new mzm.gsp.exploit.main.targets.POnQiyuanActivityFinished());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnPlayerAnswerQuestion());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\PlayerAnswerQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */