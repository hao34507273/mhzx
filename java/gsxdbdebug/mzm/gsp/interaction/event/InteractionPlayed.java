/*    */ package mzm.gsp.interaction.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class InteractionPlayed extends mzm.event.BasicEvent<InteractionPlayedArg>
/*    */ {
/*  7 */   private static EventManager<InteractionPlayedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<InteractionPlayedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\event\InteractionPlayed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */