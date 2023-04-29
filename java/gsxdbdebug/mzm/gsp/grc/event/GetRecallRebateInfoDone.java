/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetRecallRebateInfoDone extends mzm.event.BasicEvent<GetRecallRebateInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetRecallRebateInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetRecallRebateInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnGetRecallRebateInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetRecallRebateInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */