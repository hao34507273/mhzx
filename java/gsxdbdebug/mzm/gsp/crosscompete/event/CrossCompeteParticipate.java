/*    */ package mzm.gsp.crosscompete.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CrossCompeteParticipate extends mzm.event.BasicEvent<CrossCompeteParticipateArg>
/*    */ {
/*  7 */   private static EventManager<CrossCompeteParticipateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CrossCompeteParticipateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnCrossCompeteParticipate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\event\CrossCompeteParticipate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */