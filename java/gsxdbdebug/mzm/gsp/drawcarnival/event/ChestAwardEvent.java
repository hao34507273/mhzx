/*    */ package mzm.gsp.drawcarnival.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChestAwardEvent extends mzm.event.BasicEvent<ChestAwardEventArg>
/*    */ {
/*  7 */   private static EventManager<ChestAwardEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChestAwardEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.drawcarnival.main.POnChestAward());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\event\ChestAwardEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */