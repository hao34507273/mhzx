/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DisplayFurnitureEvent extends mzm.event.BasicEvent<DisplayFurnitureArg>
/*    */ {
/*  7 */   private static EventManager<DisplayFurnitureArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DisplayFurnitureArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnDisplayFurniture());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\DisplayFurnitureEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */