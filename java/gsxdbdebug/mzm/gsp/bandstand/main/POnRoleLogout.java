/*    */ package mzm.gsp.bandstand.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2bandstandsessionid;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogout extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 17 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 18 */     if (null == userId)
/*    */     {
/* 20 */       String logstr = String.format("[bandstand]POnRoleLogout.processImp@user id not exists!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/* 21 */       GameServer.logger().info(logstr);
/* 22 */       return false;
/*    */     }
/* 24 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/* 25 */     Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleId)));
/*    */     
/* 27 */     Long sessionId = Role2bandstandsessionid.get(Long.valueOf(roleId));
/* 28 */     if (null == sessionId)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     BandstandSession session = (BandstandSession)BandstandSession.getSession(sessionId.longValue());
/* 35 */     if (null != session)
/*    */     {
/* 37 */       int activityId = session.getActivityId();
/* 38 */       int musicCfgId = session.getMusicCfgId();
/* 39 */       int loopCount = session.getLoopCount();
/* 40 */       BandstandManager.addEndBandstandTlog(roleId, activityId, musicCfgId, loopCount, BandstandManager.BandstandEndReason.OFFLINE);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 45 */       String logstr = String.format("[bandstand]POnRoleLogout.processImp@session and Role2bandstandsessionid not match!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/*    */       
/* 47 */       GameServer.logger().info(logstr);
/*    */     }
/*    */     
/*    */ 
/* 51 */     BandstandManager.stopBandstand(userId, roleId, sessionId.longValue());
/*    */     
/*    */ 
/* 54 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleId, 2081);
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */