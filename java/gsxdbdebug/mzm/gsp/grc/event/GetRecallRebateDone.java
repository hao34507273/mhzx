/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetRecallRebateDone extends mzm.event.BasicEvent<GetRecallRebateDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetRecallRebateDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetRecallRebateDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnGetRecallRebateDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetRecallRebateDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */