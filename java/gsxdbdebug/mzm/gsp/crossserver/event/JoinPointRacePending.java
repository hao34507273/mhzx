/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinPointRacePending extends mzm.event.BasicEvent<JoinPointRacePendingArg>
/*    */ {
/*  7 */   private static EventManager<JoinPointRacePendingArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinPointRacePendingArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnJoinPointRacePending());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRacePending.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */