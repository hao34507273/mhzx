/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetRoleSingleCrossFieldRankInfoDone extends mzm.event.BasicEvent<GetRoleSingleCrossFieldRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetRoleSingleCrossFieldRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetRoleSingleCrossFieldRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.crossfield.main.POnGetRoleSingleCrossFieldRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetRoleSingleCrossFieldRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */