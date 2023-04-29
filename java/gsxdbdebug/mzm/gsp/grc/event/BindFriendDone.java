/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BindFriendDone extends mzm.event.BasicEvent<BindFriendDoneArg>
/*    */ {
/*  7 */   private static EventManager<BindFriendDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BindFriendDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnBindFriendDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\BindFriendDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */