/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ClearCrossBattleOwnResultDone extends mzm.event.BasicEvent<ClearCrossBattleOwnResultDoneArg>
/*    */ {
/*  7 */   private static EventManager<ClearCrossBattleOwnResultDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ClearCrossBattleOwnResultDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.own.POnClearCrossBattleOwnResultDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ClearCrossBattleOwnResultDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */