/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildGiveBirth extends mzm.event.BasicEvent<ChildGiveBirthArg>
/*    */ {
/*  7 */   private static EventManager<ChildGiveBirthArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildGiveBirthArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnChildGiveBirth());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildGiveBirth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */