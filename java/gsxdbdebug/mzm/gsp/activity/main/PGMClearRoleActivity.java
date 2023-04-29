/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class PGMClearRoleActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PGMClearRoleActivity(long gmRoleid, long roleId, int activityId)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleId = roleId;
/* 16 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 23 */     Lockeys.lock(Lockeys.get(xtable.User.getTable(), userid));
/*    */     
/* 25 */     xbean.Activity xActivity = ActivityManager.getXActivity(userid, this.roleId, this.activityId);
/* 26 */     ActivityManager.PGM_clearActivityData(this.activityId, userid, this.roleId, xActivity);
/*    */     
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("clear role activity success|roleid=%d|activity_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) }));
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PGMClearRoleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */