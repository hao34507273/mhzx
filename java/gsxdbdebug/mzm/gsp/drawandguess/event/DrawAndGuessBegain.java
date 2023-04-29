/*    */ package mzm.gsp.drawandguess.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DrawAndGuessBegain extends mzm.event.BasicEvent<DrawAndGuessBegainArg>
/*    */ {
/*  7 */   private static EventManager<DrawAndGuessBegainArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DrawAndGuessBegainArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\event\DrawAndGuessBegain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */