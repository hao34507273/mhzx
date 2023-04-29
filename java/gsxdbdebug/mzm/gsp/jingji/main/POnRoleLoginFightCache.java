/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnRoleLoginFightCache extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public POnRoleLoginFightCache(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     String useId = RoleInterface.getUserId(this.roleId);
/* 21 */     if (!ActivityInterface.isInActivityLevel(useId, this.roleId, JingjiActivityCfgConsts.getInstance().ACTIVITYID))
/*    */     {
/* 23 */       return true;
/*    */     }
/*    */     
/* 26 */     int winPoint = JingjiManager.getWinpoint(this.roleId, false);
/* 27 */     if (winPoint <= 0)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     int rank = RoleJingjiChartInterface.getRank(this.roleId);
/* 33 */     int multiFight = RoleInterface.getRoleMFValue(this.roleId);
/* 34 */     FightMatchManager.addFightingCapacity(this.roleId, rank, multiFight, winPoint);
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\POnRoleLoginFightCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */