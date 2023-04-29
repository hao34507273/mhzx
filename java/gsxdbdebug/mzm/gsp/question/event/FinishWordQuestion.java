/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishWordQuestion extends mzm.event.BasicEvent<WordQuestionArg>
/*    */ {
/*  7 */   private static EventManager<WordQuestionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WordQuestionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.paraselene.main.PFinishWordQuestion());
/* 16 */     manager.register(new mzm.gsp.task.main.POnFinishWordQuestion());
/* 17 */     manager.register(new mzm.gsp.mourn.main.POnFinishWordQuestion());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\FinishWordQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */