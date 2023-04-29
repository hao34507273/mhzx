/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KnockOutSignalFightEnd extends mzm.event.BasicEvent<KnockOutSignalFightEndArg>
/*    */ {
/*  7 */   private static EventManager<KnockOutSignalFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KnockOutSignalFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnKnockoutStageSignalFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\KnockOutSignalFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */