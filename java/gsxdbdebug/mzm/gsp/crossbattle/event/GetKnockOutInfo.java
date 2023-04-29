/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetKnockOutInfo extends mzm.event.BasicEvent<GetKnockOutInfoArg>
/*    */ {
/*  7 */   private static EventManager<GetKnockOutInfoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetKnockOutInfoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnGetKnockOutInfo());
/* 16 */     manager.register(new mzm.gsp.crossbattle.bet.POnGetKnockoutInfo());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetKnockOutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */