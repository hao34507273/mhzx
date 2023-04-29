/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(((RoleLevelUpArg)this.arg).roleId) }));
/* 12 */     int levelNew = RoleInterface.getLevel(((RoleLevelUpArg)this.arg).roleId);
/* 13 */     OnlineRoleLevelManage.getInstance().updateRole(((RoleLevelUpArg)this.arg).oldLevel, levelNew, ((RoleLevelUpArg)this.arg).roleId);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */