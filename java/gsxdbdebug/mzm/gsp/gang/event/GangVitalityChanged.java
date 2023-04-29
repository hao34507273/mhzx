/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangVitalityChanged extends mzm.event.BasicEvent<GangVitalityChangedArg>
/*    */ {
/*  7 */   private static EventManager<GangVitalityChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangVitalityChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crosscompete.main.ROnGangVitalityChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangVitalityChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */