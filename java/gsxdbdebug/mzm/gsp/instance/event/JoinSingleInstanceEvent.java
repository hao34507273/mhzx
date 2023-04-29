/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinSingleInstanceEvent extends mzm.event.BasicEvent<JoinSingleInstanceArg>
/*    */ {
/*  7 */   private static EventManager<JoinSingleInstanceArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinSingleInstanceArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnJoinSingleInstance());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\JoinSingleInstanceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */