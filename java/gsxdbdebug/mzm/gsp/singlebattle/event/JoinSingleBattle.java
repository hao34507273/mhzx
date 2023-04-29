/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinSingleBattle extends mzm.event.BasicEvent<JoinSingleBattleArg>
/*    */ {
/*  7 */   private static EventManager<JoinSingleBattleArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinSingleBattleArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.gm.POnJoinSingleBattle());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\JoinSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */