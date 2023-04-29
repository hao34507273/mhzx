/*    */ package mzm.gsp.leitai.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LeiTaiFightEndEvent extends mzm.event.BasicEvent<mzm.gsp.fight.event.PVPFightEndArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.fight.event.PVPFightEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.fight.event.PVPFightEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.main.POnLeiTaiFightEndEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\event\LeiTaiFightEndEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */