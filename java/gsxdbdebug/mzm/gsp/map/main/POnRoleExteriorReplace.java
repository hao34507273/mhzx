/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleExteriorChange;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.changemodel.ExteriorReplaceArg;
/*    */ 
/*    */ public class POnRoleExteriorReplace extends mzm.gsp.role.event.RoleExteriorReplaceProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((ExteriorReplaceArg)this.arg).getRoleId();
/* 12 */     boolean isRoleOnline = OnlineManager.getInstance().isOnline(roleid);
/* 13 */     int newChangeId = ((ExteriorReplaceArg)this.arg).getNewChangeId();
/* 14 */     new MMH_OnRoleExteriorChange(roleid, isRoleOnline, newChangeId).execute();
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleExteriorReplace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */