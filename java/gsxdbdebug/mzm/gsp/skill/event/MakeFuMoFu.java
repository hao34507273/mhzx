/*    */ package mzm.gsp.skill.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MakeFuMoFu extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnMakeFuMoFu());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnMakeFuMoFu());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\event\MakeFuMoFu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */