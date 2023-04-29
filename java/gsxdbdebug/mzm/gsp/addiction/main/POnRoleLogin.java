/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.OnlineInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2onlineinfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     long roleid = ((Long)this.arg).longValue();
/* 21 */     if (!AddictionManager.isFunOpen(roleid, false))
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*    */     
/*    */ 
/* 29 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 30 */     OnlineInfo xOnlineInfo = Role2onlineinfo.get((Long)this.arg);
/* 31 */     if (xOnlineInfo == null)
/*    */     {
/* 33 */       xOnlineInfo = xbean.Pod.newOnlineInfo();
/* 34 */       xOnlineInfo.setLastcalcuatetime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 35 */       Role2onlineinfo.insert(Long.valueOf(roleid), xOnlineInfo);
/*    */     }
/*    */     
/* 38 */     xOnlineInfo.setIs_adult(2);
/* 39 */     xOnlineInfo.setSingle_online(0);
/* 40 */     xOnlineInfo.setReport_count(0);
/* 41 */     xOnlineInfo.setPeriod_time(0);
/* 42 */     xOnlineInfo.setRest_time(0);
/* 43 */     xOnlineInfo.setKickout_type(0);
/*    */     
/* 45 */     mzm.gsp.addiction.pro.ProManager.queryUserInfo(userid, roleid);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[addiction]POnRoleLogin.processImp@role login|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */