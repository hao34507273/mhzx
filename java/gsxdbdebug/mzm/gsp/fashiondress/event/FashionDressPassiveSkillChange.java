/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FashionDressPassiveSkillChange extends mzm.event.BasicEvent<PassiveSkillChangeArg>
/*    */ {
/*  7 */   private static EventManager<PassiveSkillChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PassiveSkillChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnDressPSkillChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\FashionDressPassiveSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */