/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FightValueChange extends mzm.event.BasicEvent<RoleXFightValueChangeArg>
/*    */ {
/*  7 */   private static EventManager<RoleXFightValueChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleXFightValueChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRoleFightValueChange());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnRoleFightValueChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\FightValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */