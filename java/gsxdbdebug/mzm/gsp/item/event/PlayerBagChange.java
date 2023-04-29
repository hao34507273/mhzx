/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerBagChange extends mzm.event.BasicEvent<mzm.gsp.item.main.ItemEventArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.item.main.ItemEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.item.main.ItemEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.main.POnBagChange());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnBagChange());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnBagChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\PlayerBagChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */