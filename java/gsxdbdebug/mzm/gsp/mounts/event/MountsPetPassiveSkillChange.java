/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MountsPetPassiveSkillChange extends mzm.event.BasicEvent<MountsPetPassiveSkillChangeArg>
/*    */ {
/*  7 */   private static EventManager<MountsPetPassiveSkillChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MountsPetPassiveSkillChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.pet.main.POnMountsPetPassiveSkillChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MountsPetPassiveSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */