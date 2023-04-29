/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinMultiInstanceEvent extends mzm.event.BasicEvent<JoinMultiInstanceArg>
/*    */ {
/*  7 */   private static EventManager<JoinMultiInstanceArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinMultiInstanceArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnJoinMultiInstance());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\JoinMultiInstanceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */