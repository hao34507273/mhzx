/*    */ package mzm.gsp.worldgoal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SectionPonitChange extends mzm.event.BasicEvent<SectionPonitChangeArg>
/*    */ {
/*  7 */   private static EventManager<SectionPonitChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SectionPonitChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.worldgoal.main.POnSectionPonitChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\event\SectionPonitChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */