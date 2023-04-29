/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetCrossBattleKnockoutStageBetInfoDone extends mzm.event.BasicEvent<GetCrossBattleKnockoutStageBetInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetCrossBattleKnockoutStageBetInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetCrossBattleKnockoutStageBetInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.bet.POnGetCrossBattleKnockoutStageBetInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetCrossBattleKnockoutStageBetInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */