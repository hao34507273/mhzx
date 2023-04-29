/*    */ package mzm.gsp.feisheng.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleCompleteFeiShengActivity extends mzm.event.BasicEvent<RoleCompleteFeiShengActivityArg>
/*    */ {
/*  7 */   private static EventManager<RoleCompleteFeiShengActivityArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleCompleteFeiShengActivityArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnRoleCompleteFeiShengSubActivity());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\event\RoleCompleteFeiShengActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */