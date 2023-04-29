/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetRoleBigBossRankInfoDone extends mzm.event.BasicEvent<GetRoleBigBossRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<GetRoleBigBossRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetRoleBigBossRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.bigboss.main.POnGetRoleBigBossRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetRoleBigBossRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */