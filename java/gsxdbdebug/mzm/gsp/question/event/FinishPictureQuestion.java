/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishPictureQuestion extends mzm.event.BasicEvent<PictureQuestionArg>
/*    */ {
/*  7 */   private static EventManager<PictureQuestionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PictureQuestionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.paraselene.main.PFinishPictureQuestion());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\FinishPictureQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */