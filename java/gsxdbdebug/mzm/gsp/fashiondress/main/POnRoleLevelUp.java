/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLevelUp extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 13 */     long newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/*    */     
/* 15 */     if (!FashionDressManager.isFashionDressSwitchOpen(roleId, null, false, false))
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     if (!FashionDressManager.isLevelOpen(roleId, null, false))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     String userId = RoleInterface.getUserId(roleId);
/* 26 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/* 28 */     boolean ret = FashionDressManager.checkGoalUnLockFashionDress(roleId, newLevel, 2, "POnRoleLevelUp.processImp", FashionDressTLogEnum.LEVEL_UNLOCK);
/*    */     
/*    */ 
/* 31 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */