/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleBattleEnd extends mzm.event.BasicEvent<SingleBattleEndArg>
/*    */ {
/*  7 */   private static EventManager<SingleBattleEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleBattleEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.gm.POnSingleBattleEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\SingleBattleEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */