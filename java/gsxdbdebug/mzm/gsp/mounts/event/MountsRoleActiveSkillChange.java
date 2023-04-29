/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MountsRoleActiveSkillChange extends mzm.event.BasicEvent<MountsRoleActiveSkillChangeArg>
/*    */ {
/*  7 */   private static EventManager<MountsRoleActiveSkillChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MountsRoleActiveSkillChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnMountsRoleActiveSkillChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MountsRoleActiveSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */