/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KnockOutStageFightCal extends mzm.event.BasicEvent<KnockOutStageFightCalArg>
/*    */ {
/*  7 */   private static EventManager<KnockOutStageFightCalArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KnockOutStageFightCalArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnKnockoutStageFightCal());
/* 16 */     manager.register(new mzm.gsp.crossbattle.knockout.POnKnockoutStageFightCal());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\KnockOutStageFightCal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */