/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerPlayExpressionAction extends mzm.event.BasicEvent<PlayerPlayExpressionActionArg>
/*    */ {
/*  7 */   private static EventManager<PlayerPlayExpressionActionArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PlayerPlayExpressionActionArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.surprise.POnPlayExpressionAction());
/* 16 */     manager.register(new mzm.gsp.flowerparade.main.POnPlayExpressionAction());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\PlayerPlayExpressionAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */