/*    */ package mzm.gsp.timeflow.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class StepActivate extends mzm.event.BasicEvent<StepActivateArg>
/*    */ {
/*  7 */   private static EventManager<StepActivateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<StepActivateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.main.POnStepActivate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\event\StepActivate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */