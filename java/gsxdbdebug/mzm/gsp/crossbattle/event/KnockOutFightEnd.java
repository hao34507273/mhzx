/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KnockOutFightEnd extends mzm.event.BasicEvent<KnockOutFightEndArg>
/*    */ {
/*  7 */   private static EventManager<KnockOutFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KnockOutFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnKnockOutFightEnd());
/* 16 */     manager.register(new mzm.gsp.crossbattle.knockout.POnKnockoutStageFightEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\KnockOutFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */