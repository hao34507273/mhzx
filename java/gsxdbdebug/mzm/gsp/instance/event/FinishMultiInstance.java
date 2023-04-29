/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishMultiInstance extends mzm.event.BasicEvent<FinishMultiInstanceArg>
/*    */ {
/*  7 */   private static EventManager<FinishMultiInstanceArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FinishMultiInstanceArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFinishMultiInstance());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\FinishMultiInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */