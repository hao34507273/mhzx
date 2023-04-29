/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CrossCompeteRoamServersDone extends mzm.event.BasicEvent<CrossCompeteRoamServersDoneArg>
/*    */ {
/*  7 */   private static EventManager<CrossCompeteRoamServersDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CrossCompeteRoamServersDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crosscompete.main.ROnCrossCompeteRoamServersDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\CrossCompeteRoamServersDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */