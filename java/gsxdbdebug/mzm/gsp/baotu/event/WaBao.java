/*    */ package mzm.gsp.baotu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class WaBao extends mzm.event.BasicEvent<WaBaoArg>
/*    */ {
/*  7 */   private static EventManager<WaBaoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<WaBaoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.main.POnWaBao());
/* 16 */     manager.register(new mzm.gsp.role.main.POnWaBao());
/* 17 */     manager.register(new mzm.gsp.grow.LevelGuide.POnWaBao());
/* 18 */     manager.register(new mzm.gsp.achievement.main.POnWaBao());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\event\WaBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */