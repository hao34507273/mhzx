/*    */ package mzm.gsp.marriage.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarrySkillChange extends mzm.event.BasicEvent<MarrySkillChangeArg>
/*    */ {
/*  7 */   private static EventManager<MarrySkillChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarrySkillChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\event\MarrySkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */