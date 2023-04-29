/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LeaveSingleBattle extends mzm.event.BasicEvent<LeaveSingleBattleArg>
/*    */ {
/*  7 */   private static EventManager<LeaveSingleBattleArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LeaveSingleBattleArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.gm.POnLeaveSingleBattle());
/* 16 */     manager.register(new mzm.gsp.crossfield.roam.POnLeaveSingleBattle());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\LeaveSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */