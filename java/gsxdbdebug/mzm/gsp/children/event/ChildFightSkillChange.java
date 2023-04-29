/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildFightSkillChange extends mzm.event.BasicEvent<ChildFightSkillChangeArg>
/*    */ {
/*  7 */   private static EventManager<ChildFightSkillChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildFightSkillChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnChildFightSkillChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildFightSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */