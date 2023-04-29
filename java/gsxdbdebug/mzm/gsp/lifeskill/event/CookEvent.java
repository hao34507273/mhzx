/*    */ package mzm.gsp.lifeskill.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CookEvent extends mzm.event.BasicEvent<LifeSkillArg>
/*    */ {
/*  7 */   private static EventManager<LifeSkillArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LifeSkillArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnCookEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\event\CookEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */