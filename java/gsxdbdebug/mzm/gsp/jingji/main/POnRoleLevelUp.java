/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleLevelUp extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     String useId = RoleInterface.getUserId(((RoleLevelUpArg)this.arg).roleId);
/* 14 */     if (!ActivityInterface.isInActivityLevel(useId, ((RoleLevelUpArg)this.arg).roleId, JingjiActivityCfgConsts.getInstance().ACTIVITYID))
/*    */     {
/* 16 */       return true;
/*    */     }
/*    */     
/* 19 */     int winPoint = JingjiManager.getWinpoint(((RoleLevelUpArg)this.arg).roleId, false);
/* 20 */     if (winPoint <= 0)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     int rank = RoleJingjiChartInterface.getRank(((RoleLevelUpArg)this.arg).roleId);
/* 26 */     int multiFight = RoleInterface.getRoleMFValue(((RoleLevelUpArg)this.arg).roleId);
/* 27 */     FightMatchManager.addFightingCapacity(((RoleLevelUpArg)this.arg).roleId, rank, multiFight, winPoint);
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */