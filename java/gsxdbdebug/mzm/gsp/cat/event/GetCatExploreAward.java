/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetCatExploreAward extends mzm.event.BasicEvent<GetCatExploreAwardArg>
/*    */ {
/*  7 */   private static EventManager<GetCatExploreAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetCatExploreAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\GetCatExploreAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */