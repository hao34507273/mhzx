/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncMemberOffline;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class POnRoleLogoff extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 12 */     GangMember xGangMember = xtable.Role2gangmember.get(Long.valueOf(roleid));
/* 13 */     if (xGangMember == null) {
/* 14 */       return false;
/*    */     }
/* 16 */     long gangid = xGangMember.getGangid();
/*    */     
/* 18 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangid));
/* 19 */     if (xGang == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     if (!GangManager.isInGang(xGang, roleid)) {
/* 23 */       return false;
/*    */     }
/* 25 */     SSyncMemberOffline sSyncMemberOffline = new SSyncMemberOffline();
/* 26 */     sSyncMemberOffline.roleid = roleid;
/* 27 */     GangManager.broadcast(xGang, sSyncMemberOffline);
/*    */     
/*    */ 
/* 30 */     xtable.Gangteam_invitations.remove(Long.valueOf(roleid));
/*    */     
/*    */ 
/* 33 */     mzm.gsp.gang.cache.GangCacheManager.setMemberOfflineTime(gangid, roleid, mzm.gsp.role.main.RoleInterface.getLastLogoffTime(roleid));
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */