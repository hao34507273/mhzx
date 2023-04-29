/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.loginaward.SLoginSignActivityInfo;
/*    */ import mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.LoginSignInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class POnRoleLoginLoginSignActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   public POnRoleLoginLoginSignActivity(String userid, long roleid)
/*    */   {
/* 16 */     this.userid = userid;
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     lock(Lockeys.get(xtable.User.getTable(), this.userid));
/* 25 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 27 */     SLoginSignActivityInfo msg = new SLoginSignActivityInfo();
/*    */     
/*    */ 
/*    */ 
/* 31 */     int activityCfgid = SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_CFG_ID;
/* 32 */     LoginSignInfo xLoginSignInfo = LoginSignActivityManager.getLoginSignActivityInfo(this.userid, this.roleid, activityCfgid);
/*    */     
/* 34 */     if (xLoginSignInfo != null)
/*    */     {
/* 36 */       LoginSignActivityManager.boxLoginSignInfo(msg, activityCfgid, xLoginSignInfo);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 42 */     int activityCfgid = SLoginAwardCfgConsts.getInstance().BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID;
/* 43 */     LoginSignInfo xLoginSignInfo = LoginSignActivityManager.getBeginnerLoginSignInfo(this.userid, this.roleid, activityCfgid);
/*    */     
/* 45 */     if (xLoginSignInfo != null)
/*    */     {
/* 47 */       LoginSignActivityManager.boxLoginSignInfo(msg, activityCfgid, xLoginSignInfo);
/*    */     }
/*    */     
/*    */ 
/* 51 */     if (msg.activity_infos.size() > 0)
/*    */     {
/* 53 */       OnlineManager.getInstance().send(this.roleid, msg);
/*    */     }
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\POnRoleLoginLoginSignActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */