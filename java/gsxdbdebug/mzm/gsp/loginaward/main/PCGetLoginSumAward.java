/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.loginaward.SGetLoginSumAwardFailed;
/*    */ import mzm.gsp.loginaward.SGetLoginSumAwardSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetLoginSumAward extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityCfgId;
/*    */   private final int sortId;
/*    */   private String userid;
/*    */   
/*    */   public PCGetLoginSumAward(long roleId, int activityCfgId, int sortId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.activityCfgId = activityCfgId;
/* 24 */     this.sortId = sortId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!LoginSumActivityManager.isFunOpen(this.roleId, true))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     if (!LoginAwardManager.checkRoleStatus(this.roleId, 234))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     this.userid = RoleInterface.getUserId(this.roleId);
/* 42 */     if (this.userid == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 48 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/* 50 */     int result = LoginSumActivityManager.getAward(this.userid, this.roleId, this.activityCfgId, this.sortId);
/* 51 */     if (result != 0)
/*    */     {
/* 53 */       onFailed(result);
/*    */       
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     SGetLoginSumAwardSuccess resp = new SGetLoginSumAwardSuccess();
/* 59 */     resp.activityid = this.activityCfgId;
/* 60 */     resp.sortid = this.sortId;
/* 61 */     OnlineManager.getInstance().send(this.roleId, resp);
/*    */     
/* 63 */     GameServer.logger().info(String.format("[loginaward]PCGetLoginSumAward.processImp@get login sum activity award success|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.activityCfgId), Integer.valueOf(this.sortId), Integer.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   private void onFailed(int retcode)
/*    */   {
/* 72 */     if (retcode < 0)
/*    */     {
/* 74 */       SGetLoginSumAwardFailed resp = new SGetLoginSumAwardFailed();
/* 75 */       resp.retcode = retcode;
/* 76 */       resp.activityid = this.activityCfgId;
/* 77 */       resp.sortid = this.sortId;
/* 78 */       OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*    */     }
/*    */     
/* 81 */     GameServer.logger().error(String.format("[loginaward]PCGetLoginSumAward.onFailed@get login sum activity award failed|roleid=%d|userid=%s|activity_cfgid=%d|sortid=%d|retcode=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.activityCfgId), Integer.valueOf(this.sortId), Integer.valueOf(retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\PCGetLoginSumAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */