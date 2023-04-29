/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GenderChange extends mzm.event.BasicEvent<GenderArg>
/*    */ {
/*  7 */   private static EventManager<GenderArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GenderArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.personal.main.POnGenderChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\GenderChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */