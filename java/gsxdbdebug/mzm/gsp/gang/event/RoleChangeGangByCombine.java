/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleChangeGangByCombine extends mzm.event.BasicEvent<RoleChangeGangByCombineArg>
/*    */ {
/*  7 */   private static EventManager<RoleChangeGangByCombineArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleChangeGangByCombineArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.msdkprofile.main.POnRoleChangeGangByCombine());
/* 16 */     manager.register(new mzm.gsp.friendscircle.main.POnRoleChangeGangByCombine());
/* 17 */     manager.register(new mzm.gsp.makeup.main.POnRoleChangeGangByCombine());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\RoleChangeGangByCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */