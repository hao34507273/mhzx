/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.loginaward.SGetLoginSignAwardFailed;
/*    */ import mzm.gsp.loginaward.SGetLoginSignAwardSuccess;
/*    */ import mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetLoginSignAward extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int sortid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetLoginSignAward(long roleid, int activityCfgid, int sortid)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.activityCfgid = activityCfgid;
/* 26 */     this.sortid = sortid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (this.activityCfgid <= 0)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (this.sortid <= 0)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!LoginSignActivityManager.isFunOpen(this.roleid, this.activityCfgid, true))
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     if (!LoginAwardManager.checkRoleStatus(this.roleid, 236))
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 53 */     if (this.userid == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 59 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 61 */     int result = 4;
/* 62 */     if (this.activityCfgid == SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_CFG_ID)
/*    */     {
/* 64 */       result = LoginSignActivityManager.getAward(this.userid, this.roleid, this.activityCfgid, this.sortid);
/*    */     }
/* 66 */     else if (this.activityCfgid == SLoginAwardCfgConsts.getInstance().BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID)
/*    */     {
/* 68 */       result = LoginSignActivityManager.getBeginnerLoginSignAward(this.userid, this.roleid, this.activityCfgid, this.sortid);
/*    */     }
/*    */     
/*    */ 
/* 72 */     if (result != 0)
/*    */     {
/* 74 */       onFailed(result);
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     SGetLoginSignAwardSuccess rsp = new SGetLoginSignAwardSuccess();
/* 79 */     rsp.sortid = this.sortid;
/* 80 */     rsp.activity_cfgid = this.activityCfgid;
/* 81 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 83 */     GameServer.logger().info(String.format("[loginaward]PCGetLoginSignAward.processImp@get login sign activity award success|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/* 87 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 92 */     SGetLoginSignAwardFailed resp = new SGetLoginSignAwardFailed();
/* 93 */     resp.retcode = retcode;
/* 94 */     resp.sortid = this.sortid;
/* 95 */     resp.activity_cfgid = this.activityCfgid;
/* 96 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*    */     
/* 98 */     GameServer.logger().error(String.format("[loginaward]PCGetLoginSignAward.onFailed@get login sign activity award failed|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleid), this.userid, Integer.valueOf(SLoginAwardCfgConsts.getInstance().LOGIN_SIGN_ACTIVITY_CFG_ID), Integer.valueOf(this.sortid), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\PCGetLoginSignAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */