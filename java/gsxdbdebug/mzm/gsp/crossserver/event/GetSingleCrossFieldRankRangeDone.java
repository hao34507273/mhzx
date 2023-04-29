/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetSingleCrossFieldRankRangeDone extends mzm.event.BasicEvent<GetSingleCrossFieldRankRangeDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetSingleCrossFieldRankRangeDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetSingleCrossFieldRankRangeDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnGetSingleCrossFieldRankRangeDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetSingleCrossFieldRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */