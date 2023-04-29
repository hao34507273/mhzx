/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.loginaward.SLoginSignActivityInfo;
/*    */ import mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.LoginSignInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetLoginSignActivityInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetLoginSignActivityInfo(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!LoginAwardManager.checkRoleStatus(this.roleid, 235))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 32 */     if (this.userid == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 38 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 40 */     SLoginSignActivityInfo msg = new SLoginSignActivityInfo();
/*    */     
/*    */ 
/* 43 */     int activityCfgid = SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_CFG_ID;
/* 44 */     LoginSignInfo xLoginSignInfo = LoginSignActivityManager.getLoginSignActivityInfo(this.userid, this.roleid, activityCfgid);
/*    */     
/* 46 */     if (xLoginSignInfo != null)
/*    */     {
/* 48 */       LoginSignActivityManager.boxLoginSignInfo(msg, activityCfgid, xLoginSignInfo);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 54 */     int activityCfgid = SLoginAwardCfgConsts.getInstance().BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID;
/* 55 */     LoginSignInfo xLoginSignInfo = LoginSignActivityManager.getBeginnerLoginSignInfo(this.userid, this.roleid, activityCfgid);
/*    */     
/* 57 */     if (xLoginSignInfo != null)
/*    */     {
/* 59 */       LoginSignActivityManager.boxLoginSignInfo(msg, activityCfgid, xLoginSignInfo);
/*    */     }
/*    */     
/*    */ 
/* 63 */     OnlineManager.getInstance().send(this.roleid, msg);
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\PCGetLoginSignActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */