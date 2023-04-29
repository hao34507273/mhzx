/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetFightStageEndCorpsInfo extends mzm.event.BasicEvent<GetFightStageEndCorpsInfoArg>
/*    */ {
/*  7 */   private static EventManager<GetFightStageEndCorpsInfoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetFightStageEndCorpsInfoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnGetFightStageEndCorpsInfo());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetFightStageEndCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */