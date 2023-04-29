/*    */ package mzm.gsp.seasontask.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishOneSeasonTask extends mzm.event.BasicEvent<FinishOneTaskArg>
/*    */ {
/*  7 */   private static EventManager<FinishOneTaskArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FinishOneTaskArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.storageexp.activity.POnFinishOneSeasonTask());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\event\FinishOneSeasonTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */