/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetFinalChampionMapStatue extends mzm.event.BasicEvent<GetFinalChampionMapStatueArg>
/*    */ {
/*  7 */   private static EventManager<GetFinalChampionMapStatueArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetFinalChampionMapStatueArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnGetFinalChampionMapStatue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetFinalChampionMapStatue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */