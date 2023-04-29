/*    */ package mzm.gsp.lifeskill.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LifeSkillLevelUpEvent extends mzm.event.BasicEvent<LifeSkillLevelUpArg>
/*    */ {
/*  7 */   private static EventManager<LifeSkillLevelUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LifeSkillLevelUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnLianYaoSkillLevelUpEvent());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnCookSkillLevelUpEvent());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnLifeSkillLevelUpEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\event\LifeSkillLevelUpEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */