/*    */ package mzm.gsp.singlebattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SingleBattleCreate extends mzm.event.BasicEvent<SingleBattleCreateArg>
/*    */ {
/*  7 */   private static EventManager<SingleBattleCreateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SingleBattleCreateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.singlebattle.gm.POnSingleBattleCreate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\event\SingleBattleCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */