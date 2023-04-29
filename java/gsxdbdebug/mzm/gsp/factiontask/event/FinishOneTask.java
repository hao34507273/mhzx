/*    */ package mzm.gsp.factiontask.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishOneTask extends mzm.event.BasicEvent<TaskArg>
/*    */ {
/*  7 */   private static EventManager<TaskArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<TaskArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFinishFactionTask());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\event\FinishOneTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */