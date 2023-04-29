/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KnockOutFinalChampionBorn extends mzm.event.BasicEvent<KnockOutFinalChampionBornArg>
/*    */ {
/*  7 */   private static EventManager<KnockOutFinalChampionBornArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<KnockOutFinalChampionBornArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnKnockOutFinalChampionBorn());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\KnockOutFinalChampionBorn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */