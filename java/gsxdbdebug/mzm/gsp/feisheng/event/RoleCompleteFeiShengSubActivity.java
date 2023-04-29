/*    */ package mzm.gsp.feisheng.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleCompleteFeiShengSubActivity extends mzm.event.BasicEvent<RoleCompleteFeiShengSubActivityArg>
/*    */ {
/*  7 */   private static EventManager<RoleCompleteFeiShengSubActivityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleCompleteFeiShengSubActivityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.feisheng.main.POnRoleCompleteFeiShengSubActivity());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\event\RoleCompleteFeiShengSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */