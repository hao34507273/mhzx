/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetBindVitalityInfoDone extends mzm.event.BasicEvent<GetBindVitalityInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetBindVitalityInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetBindVitalityInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnGetBindVitalityInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetBindVitalityInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */