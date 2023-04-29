/*    */ package mzm.gsp.activity.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AddActivityCountEvent extends mzm.event.BasicEvent<AddActivityCountArg>
/*    */ {
/*  7 */   private static EventManager<AddActivityCountArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AddActivityCountArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.backgameactivity.main.POnAddActivityCount());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\event\AddActivityCountEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */