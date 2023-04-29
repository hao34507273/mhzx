/*    */ package mzm.gsp.genius.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GeniusSkillChange extends mzm.event.BasicEvent<GeniusSkillChangeArg>
/*    */ {
/*  7 */   private static EventManager<GeniusSkillChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GeniusSkillChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnGeniusSkillChange());
/* 16 */     manager.register(new mzm.gsp.fight.main.POnGeniusSkillChange());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnGeniusSkillChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\event\GeniusSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */