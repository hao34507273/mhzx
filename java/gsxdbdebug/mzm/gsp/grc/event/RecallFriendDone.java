/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RecallFriendDone extends mzm.event.BasicEvent<RecallFriendDoneArg>
/*    */ {
/*  7 */   private static EventManager<RecallFriendDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RecallFriendDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnRecallFriendDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\RecallFriendDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */