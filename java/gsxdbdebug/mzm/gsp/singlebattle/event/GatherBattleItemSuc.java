/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GatherBattleItemSuc extends mzm.event.BasicEvent<mzm.gsp.singlebattle.gather.EventArg_GatherSuc>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.singlebattle.gather.EventArg_GatherSuc> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.singlebattle.gather.EventArg_GatherSuc> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.task.POnGatherBattleItemSuc());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\GatherBattleItemSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */