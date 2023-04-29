/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemovePointRaceDone extends mzm.event.BasicEvent<RemovePointRaceDoneArg>
/*    */ {
/*  7 */   private static EventManager<RemovePointRaceDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemovePointRaceDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossbattle.point.POnRemovePointRaceDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemovePointRaceDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */