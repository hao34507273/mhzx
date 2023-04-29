/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.loginaward.SLoginSignActivityInfo;
/*    */ import mzm.gsp.loginaward.confbean.SBeginnerLoginSignCfg;
/*    */ import mzm.gsp.loginaward.confbean.SLoginAwardCfgConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 17 */     int activityCfgid = SLoginAwardCfgConsts.getInstance().BEGINNER_LOGIN_SIGN_ACTIVITY_CFG_ID;
/* 18 */     SBeginnerLoginSignCfg cfg = SBeginnerLoginSignCfg.get(activityCfgid);
/* 19 */     if (cfg == null)
/*    */     {
/* 21 */       GameServer.logger().error(String.format("[loginaward]POnRoleLevelUp.processImp@cfg is null|roleid=%d|activity_cfgid=%d", new Object[] { Long.valueOf(((RoleLevelUpArg)this.arg).roleId), Integer.valueOf(activityCfgid) }));
/*    */       
/*    */ 
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     int openLevel = cfg.openLevel;
/* 28 */     if ((((RoleLevelUpArg)this.arg).oldLevel >= openLevel) || (((RoleLevelUpArg)this.arg).newLevel < openLevel))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*    */     
/* 35 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 36 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 38 */     xbean.LoginSignInfo xLoginSignInfo = LoginSignActivityManager.initData(userid, roleid, activityCfgid);
/*    */     
/* 40 */     SLoginSignActivityInfo msg = new SLoginSignActivityInfo();
/* 41 */     LoginSignActivityManager.boxLoginSignInfo(msg, activityCfgid, xLoginSignInfo);
/*    */     
/* 43 */     OnlineManager.getInstance().send(roleid, msg);
/*    */     
/* 45 */     GameServer.logger().info(String.format("[loginaward]POnRoleLevelUp.processImp@init data|roleid=%d|activity_cfgid=%d|old_level=%d|new_level=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(((RoleLevelUpArg)this.arg).oldLevel), Integer.valueOf(((RoleLevelUpArg)this.arg).newLevel) }));
/*    */     
/*    */ 
/*    */ 
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */