/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MoneyGainTouchLine extends mzm.event.BasicEvent<mzm.gsp.role.moneywatchdog.MoneyGainTouchLineArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.role.moneywatchdog.MoneyGainTouchLineArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.role.moneywatchdog.MoneyGainTouchLineArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.moneywatchdog.POnMoneyGainTouchLine());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\MoneyGainTouchLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */