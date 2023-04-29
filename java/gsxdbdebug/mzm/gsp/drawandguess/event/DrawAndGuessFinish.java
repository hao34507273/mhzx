/*    */ package mzm.gsp.drawandguess.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DrawAndGuessFinish extends mzm.event.BasicEvent<DrawAndGuessFinishArg>
/*    */ {
/*  7 */   private static EventManager<DrawAndGuessFinishArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DrawAndGuessFinishArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.drawandguess.main.POnDrawAndGuessFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\event\DrawAndGuessFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */