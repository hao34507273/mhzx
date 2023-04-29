/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerFinishActivity extends mzm.event.BasicEvent<QuestionArg>
/*    */ {
/*  7 */   private static EventManager<QuestionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<QuestionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.question.main.POnPlayerFinishActivity());
/* 16 */     manager.register(new mzm.gsp.role.main.POnPlayerFinishActivity());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\PlayerFinishActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */