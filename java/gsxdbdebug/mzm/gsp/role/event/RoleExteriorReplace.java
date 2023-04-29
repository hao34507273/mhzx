/*    */ package mzm.gsp.role.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleExteriorReplace extends mzm.event.BasicEvent<mzm.gsp.role.changemodel.ExteriorReplaceArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.role.changemodel.ExteriorReplaceArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.role.changemodel.ExteriorReplaceArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleExteriorReplace());
/* 16 */     manager.register(new mzm.gsp.team.main.POnRoleExteriorReplace());
/* 17 */     manager.register(new mzm.gsp.corps.main.POnRoleExteriorReplace());
/* 18 */     manager.register(new mzm.gsp.shitu.main.POnRoleExteriorReplace());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\event\RoleExteriorReplace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */