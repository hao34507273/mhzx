/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChangeModelCardUpgrade extends mzm.event.BasicEvent<ChangeModelCardUpgradeArg>
/*    */ {
/*  7 */   private static EventManager<ChangeModelCardUpgradeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChangeModelCardUpgradeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnChangeModelCardUpgrade());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */