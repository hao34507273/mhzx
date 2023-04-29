/*    */ package mzm.gsp.competition.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PickUpTreasure extends mzm.event.BasicEvent<PickUpTreasureArg>
/*    */ {
/*  7 */   private static EventManager<PickUpTreasureArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PickUpTreasureArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnCompetitionPickUpTreasure());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\event\PickUpTreasure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */