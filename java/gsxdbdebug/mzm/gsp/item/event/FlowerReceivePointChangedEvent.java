/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FlowerReceivePointChangedEvent extends mzm.event.BasicEvent<FlowerReceivePointChangedArg>
/*    */ {
/*  7 */   private static EventManager<FlowerReceivePointChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FlowerReceivePointChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.msdkprofile.main.POnFlowerReceivePointChange());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnFlowerReceivePointChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\FlowerReceivePointChangedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */