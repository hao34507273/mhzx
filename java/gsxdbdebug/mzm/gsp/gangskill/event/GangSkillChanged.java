/*    */ package mzm.gsp.gangskill.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangSkillChanged extends mzm.event.BasicEvent<GangSkillArg>
/*    */ {
/*  7 */   private static EventManager<GangSkillArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangSkillArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnGangSkillChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangskill\event\GangSkillChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */