/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SilveValueChange extends mzm.event.BasicEvent<MoneyChangeArg>
/*    */ {
/*  7 */   private static EventManager<MoneyChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MoneyChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnRoleSilveValueChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\SilveValueChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */