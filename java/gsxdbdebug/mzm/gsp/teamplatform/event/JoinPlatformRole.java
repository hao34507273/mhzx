/*    */ package mzm.gsp.teamplatform.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinPlatformRole extends mzm.event.BasicEvent<JoinPlatformRoleArg>
/*    */ {
/*  7 */   private static EventManager<JoinPlatformRoleArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinPlatformRoleArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\event\JoinPlatformRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */