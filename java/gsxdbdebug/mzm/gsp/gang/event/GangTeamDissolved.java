/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangTeamDissolved extends mzm.event.BasicEvent<GangTeamDissolvedArg>
/*    */ {
/*  7 */   private static EventManager<GangTeamDissolvedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangTeamDissolvedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnGangTeamDissolved());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangTeamDissolved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */