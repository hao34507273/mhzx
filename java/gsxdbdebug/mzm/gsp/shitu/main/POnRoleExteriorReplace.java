/*   */ package mzm.gsp.shitu.main;
/*   */ 
/*   */ import mzm.gsp.role.changemodel.ExteriorReplaceArg;
/*   */ 
/*   */ public class POnRoleExteriorReplace extends mzm.gsp.role.event.RoleExteriorReplaceProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception {
/* 8 */     ShiTuManager.synShiTuRoleInfoChange(((ExteriorReplaceArg)this.arg).getRoleId());
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleExteriorReplace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */