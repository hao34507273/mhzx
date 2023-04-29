/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RecallRechargeRebateDone extends mzm.event.BasicEvent<RecallRechargeRebateDoneArg>
/*    */ {
/*  7 */   private static EventManager<RecallRechargeRebateDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RecallRechargeRebateDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnRecallRechargeRebateDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\RecallRechargeRebateDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */