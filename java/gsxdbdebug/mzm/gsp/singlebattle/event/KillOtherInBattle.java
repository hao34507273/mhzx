/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class KillOtherInBattle extends mzm.event.BasicEvent<EventArg_KillOther>
/*    */ {
/*  7 */   private static EventManager<EventArg_KillOther> manager = new EventManager();
/*    */   
/*    */   public EventManager<EventArg_KillOther> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.task.POnKillOtherInBattle());
/* 16 */     manager.register(new mzm.gsp.singlebattle.main.POnKillOtherInBattle());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\KillOtherInBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */