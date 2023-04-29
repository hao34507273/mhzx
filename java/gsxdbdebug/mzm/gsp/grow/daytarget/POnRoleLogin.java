/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleId = ((Long)this.arg).longValue();
/* 14 */     String userId = RoleInterface.getUserId(roleId);
/* 15 */     lock(Lockeys.get(User.getTable(), userId));
/* 16 */     RoleDayInfo roleDayInfo = new RoleDayInfo(roleId, true);
/*    */     
/* 18 */     if (RoleInterface.getLevel(((Long)this.arg).longValue()) < DayTargetManager.getDayTargetOpenLv())
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     if (!roleDayInfo.hasXData())
/*    */     {
/* 25 */       roleDayInfo.createDayInfo();
/* 26 */       DayTargetManager.flushNewTargets(roleDayInfo, 1);
/*    */     }
/*    */     
/* 29 */     if (roleDayInfo.getAllTarget().size() > 0)
/*    */     {
/* 31 */       DayTargetManager.synAllTargets(roleDayInfo);
/*    */     }
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */