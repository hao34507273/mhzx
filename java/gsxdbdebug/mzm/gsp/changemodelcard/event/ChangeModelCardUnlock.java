/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChangeModelCardUnlock extends mzm.event.BasicEvent<ChangeModelCardUnlockArg>
/*    */ {
/*  7 */   private static EventManager<ChangeModelCardUnlockArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChangeModelCardUnlockArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnChangeModelCardUnlock());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardUnlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */