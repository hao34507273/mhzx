/*    */ package mzm.gsp.bigboss.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleGetBigBossRemoteChartAward extends mzm.event.BasicEvent<RoleGetBigBossRemoteChartAwardArg>
/*    */ {
/*  7 */   private static EventManager<RoleGetBigBossRemoteChartAwardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleGetBigBossRemoteChartAwardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.bigboss.main.POnRoleGetBigBossRemoteChartAward());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\event\RoleGetBigBossRemoteChartAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */