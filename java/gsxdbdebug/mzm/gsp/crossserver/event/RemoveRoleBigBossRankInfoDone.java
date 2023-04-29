/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RemoveRoleBigBossRankInfoDone extends mzm.event.BasicEvent<RemoveRoleBigBossRankInfoDoneArg>
/*    */ {
/*  7 */   private static EventManager<RemoveRoleBigBossRankInfoDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RemoveRoleBigBossRankInfoDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.bigboss.main.POnRemoveRoleBigBossRankInfoDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemoveRoleBigBossRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */