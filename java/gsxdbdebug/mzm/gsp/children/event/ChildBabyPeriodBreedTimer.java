/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildBabyPeriodBreedTimer extends mzm.event.BasicEvent<ChildBabyPeriodBreedTimerArg>
/*    */ {
/*  7 */   private static EventManager<ChildBabyPeriodBreedTimerArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildBabyPeriodBreedTimerArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.main.POnChildBabyPeriodBreedTimer());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildBabyPeriodBreedTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */