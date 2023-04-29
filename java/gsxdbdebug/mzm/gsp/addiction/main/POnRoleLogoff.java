/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.OnlineInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2onlineinfo;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
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
/* 28 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 29 */     OnlineInfo xOnlineInfo = Role2onlineinfo.get(Long.valueOf(roleid));
/* 30 */     if (xOnlineInfo == null)
/*    */     {
/* 32 */       GameServer.logger().error(String.format("[adiction]POnRoleLogoff.processImp@xbean is null|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     int seconds = xOnlineInfo.getPeriod_time();
/* 37 */     mzm.gsp.addiction.pro.ProManager.updateUserInfo(userid, roleid, seconds, 6);
/* 38 */     Role2onlineinfo.remove(Long.valueOf(roleid));
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */