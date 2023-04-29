/*    */ package mzm.gsp.massexp.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.massexp.SMassExpInfo;
/*    */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MassExpInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     long roleid = ((Long)this.arg).longValue();
/* 24 */     if (!MassExpManager.isFunOpen(roleid, false))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 30 */     int activityCfgid = SMassExpCfgConsts.getInstance().ACTIVITY_CFG_ID;
/*    */     
/*    */ 
/* 33 */     lock(Lockeys.get(User.getTable(), userid));
/* 34 */     MassExpInfo xMassExpInfo = MassExpManager.getMassExpInfo(roleid, activityCfgid);
/* 35 */     if (xMassExpInfo == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     MassExpManager.dataStruceChange(xMassExpInfo);
/*    */     
/* 43 */     if (xMassExpInfo.getStatus() == 0)
/*    */     {
/* 45 */       GameServer.logger().info(String.format("[massexp]POnRoleLogin.processImp@init status|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 50 */     if (MassExpManager.expire(xMassExpInfo.getEnd_time(), now))
/*    */     {
/* 52 */       MassExpManager.taskEnd(userid, roleid, activityCfgid, xMassExpInfo, MassExpInitReason.ROLE_LOGIN);
/* 53 */       return true;
/*    */     }
/*    */     
/* 56 */     if (xMassExpInfo.getStatus() == 1)
/*    */     {
/* 58 */       long endTime = xMassExpInfo.getEnd_time();
/* 59 */       long intervalSeconds = endTime - now;
/* 60 */       if (intervalSeconds < 0L)
/*    */       {
/* 62 */         intervalSeconds = 0L;
/*    */       }
/*    */       
/* 65 */       MassExpManager.startObserver(roleid, activityCfgid, intervalSeconds);
/*    */     }
/*    */     
/* 68 */     SMassExpInfo msg = new SMassExpInfo();
/* 69 */     msg.mass_exp_info = MassExpManager.buildMassExpInfo(xMassExpInfo);
/* 70 */     OnlineManager.getInstance().send(roleid, msg);
/*    */     
/* 72 */     GameServer.logger().info(String.format("[massexp]POnRoleLogin.processImp@send mass exp info msg|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */