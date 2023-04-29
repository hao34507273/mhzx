/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleAnswerOneQYXTQuestion extends mzm.event.BasicEvent<RoleAnswerOneQYXTQuestionArg>
/*    */ {
/*  7 */   private static EventManager<RoleAnswerOneQYXTQuestionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleAnswerOneQYXTQuestionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRoleAnswerOneQYXTQuestion());
/* 16 */     manager.register(new mzm.gsp.storageexp.activity.POnAnswerOneQYXTQuestion());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\RoleAnswerOneQYXTQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */