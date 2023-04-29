/*    */ package mzm.gsp.activitycompensate.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ class PRefreshCompensate extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityid;
/*    */   
/*    */   PRefreshCompensate(long roleid, int activityid)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     String userid = RoleInterface.getUserId(this.roleid);
/* 21 */     ActivityInterface.checkAndFreshCompensate(userid, this.roleid, this.activityid);
/*    */     
/* 23 */     ActivityCompensateManager.logInfo("PRefreshCompensate.process@succeed|roleid=%d|activityid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityid) });
/*    */     
/*    */ 
/*    */ 
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\main\PRefreshCompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */