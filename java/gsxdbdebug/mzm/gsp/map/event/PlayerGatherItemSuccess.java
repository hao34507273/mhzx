/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerGatherItemSuccess extends mzm.event.BasicEvent<mzm.gsp.map.main.GatherItemEventArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.map.main.GatherItemEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.map.main.GatherItemEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.main.POnGatherMine());
/* 16 */     manager.register(new mzm.gsp.competition.main.POnGatherItem());
/* 17 */     manager.register(new mzm.gsp.crosscompete.roam.POnGatherItem());
/* 18 */     manager.register(new mzm.gsp.map.main.POnGatherItem());
/* 19 */     manager.register(new mzm.gsp.drawcarnival.main.POnGatherItem());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\PlayerGatherItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */