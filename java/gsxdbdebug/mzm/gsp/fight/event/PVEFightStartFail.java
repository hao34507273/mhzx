/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVEFightStartFail extends mzm.event.BasicEvent<PVEFightStartFailArg>
/*    */ {
/*  7 */   private static EventManager<PVEFightStartFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVEFightStartFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnPVEFightStartFail());
/* 16 */     manager.register(new mzm.gsp.hula.main.POnPVEFightStartFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVEFightStartFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */