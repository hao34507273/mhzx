/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PVCFightStart extends mzm.event.BasicEvent<PVCFightStartArg>
/*    */ {
/*  7 */   private static EventManager<PVCFightStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PVCFightStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVCFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */