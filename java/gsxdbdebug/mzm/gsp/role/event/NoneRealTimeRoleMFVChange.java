/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class NoneRealTimeRoleMFVChange extends mzm.event.BasicEvent<mzm.gsp.role.multirank.RoleChartMfvChangeArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.role.multirank.RoleChartMfvChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.role.multirank.RoleChartMfvChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnRoleMFVChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\NoneRealTimeRoleMFVChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */