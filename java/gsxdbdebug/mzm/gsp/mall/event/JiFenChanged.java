/*    */ package mzm.gsp.mall.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JiFenChanged extends mzm.event.BasicEvent<JiFenChangedArg>
/*    */ {
/*  7 */   private static EventManager<JiFenChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JiFenChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnJiFenChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\event\JiFenChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */