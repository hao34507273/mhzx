/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class TssChanged extends mzm.event.BasicEvent<TssChangedArg>
/*    */ {
/*  7 */   private static EventManager<TssChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TssChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.qingfu.main.ROnUserTssChanged());
/* 16 */     manager.register(new mzm.gsp.achievement.main.ROnUserTssChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\TssChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */