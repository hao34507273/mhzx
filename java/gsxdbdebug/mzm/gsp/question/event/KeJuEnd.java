/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KeJuEnd extends mzm.event.BasicEvent<KeJuEndArg>
/*    */ {
/*  7 */   private static EventManager<KeJuEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KeJuEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.ROnKeJuEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\KeJuEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */