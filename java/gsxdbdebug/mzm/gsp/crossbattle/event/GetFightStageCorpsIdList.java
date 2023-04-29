/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetFightStageCorpsIdList extends mzm.event.BasicEvent<GetFightStageCorpsIdListArg>
/*    */ {
/*  7 */   private static EventManager<GetFightStageCorpsIdListArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetFightStageCorpsIdListArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.knockout.POnGetFightStageCorpsIdList());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetFightStageCorpsIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */