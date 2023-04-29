/*    */ package mzm.gsp.skill.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleSkillLevelUp extends mzm.event.BasicEvent<RoleSkillArg>
/*    */ {
/*  7 */   private static EventManager<RoleSkillArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleSkillArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnRoleSkillLevelUp());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnRoleSkillLevelUp());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnRoleSkillLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\event\RoleSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */