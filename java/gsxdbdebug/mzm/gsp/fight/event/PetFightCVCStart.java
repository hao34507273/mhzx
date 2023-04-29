/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PetFightCVCStart extends mzm.event.BasicEvent<PetFightCVCStartArg>
/*    */ {
/*  7 */   private static EventManager<PetFightCVCStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PetFightCVCStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PetFightCVCStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */