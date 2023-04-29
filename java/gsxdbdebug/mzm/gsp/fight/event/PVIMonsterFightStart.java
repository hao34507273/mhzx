/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVIMonsterFightStart extends mzm.event.BasicEvent<PVIMonsterFightStartArg>
/*    */ {
/*  7 */   private static EventManager<PVIMonsterFightStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVIMonsterFightStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.bigboss.main.POnPVIMonsterFightStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVIMonsterFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */