/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FabaoRankUp extends mzm.event.BasicEvent<FabaoRankUpArg>
/*    */ {
/*  7 */   private static EventManager<FabaoRankUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FabaoRankUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnFabaoRankUp());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnFabaoRankUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoRankUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */