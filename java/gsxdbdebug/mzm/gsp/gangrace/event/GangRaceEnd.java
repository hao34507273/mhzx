/*    */ package mzm.gsp.gangrace.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangRaceEnd extends mzm.event.BasicEvent<GangRaceEndArg>
/*    */ {
/*  7 */   private static EventManager<GangRaceEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangRaceEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.ROnGangRaceEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\event\GangRaceEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */