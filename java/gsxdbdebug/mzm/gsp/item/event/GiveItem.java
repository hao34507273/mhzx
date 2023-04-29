/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GiveItem extends mzm.event.BasicEvent<GiveItemArg>
/*    */ {
/*  7 */   private static EventManager<GiveItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GiveItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnGiveItem());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\GiveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */