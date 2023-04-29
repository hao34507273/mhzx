/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FabaoLevelUp extends mzm.event.BasicEvent<FabaoLevelUpArg>
/*    */ {
/*  7 */   private static EventManager<FabaoLevelUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FabaoLevelUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnFabaoLevelUp());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnFabaoLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */