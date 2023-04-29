/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FlowerGivePointChangedEvent extends mzm.event.BasicEvent<FlowerGivePointChangedArg>
/*    */ {
/*  7 */   private static EventManager<FlowerGivePointChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FlowerGivePointChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnFlowerGivePointChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\FlowerGivePointChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */