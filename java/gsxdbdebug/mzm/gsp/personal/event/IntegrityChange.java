/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class IntegrityChange extends mzm.event.BasicEvent<IntegrityArg>
/*    */ {
/*  7 */   private static EventManager<IntegrityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<IntegrityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.personal.main.POnIntegrityChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\IntegrityChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */