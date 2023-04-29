/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2marriage;
/*    */ 
/*    */ public class PCTransforToMarrage extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long friendid;
/*    */   
/*    */   public PCTransforToMarrage(long operRoleid, long roleid)
/*    */   {
/* 21 */     this.roleid = operRoleid;
/* 22 */     this.friendid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     if (!FriendInterface.isFriend(this.roleid, this.friendid, false)) {
/* 28 */       GameServer.logger().error(String.format("[Marriage]PCTransforToMarrage.processImp@they are not friend|roleid=%d|friend=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.friendid) }));
/*    */       
/*    */ 
/* 31 */       return false;
/*    */     }
/* 33 */     Long marriageId = Role2marriage.select(Long.valueOf(this.friendid));
/* 34 */     if (marriageId == null) {
/* 35 */       MarriageManager.sendNormalResult(this.roleid, 80, new String[0]);
/* 36 */       return false;
/*    */     }
/* 38 */     xbean.Marriage xMarriage = xtable.Marriage.select(marriageId);
/* 39 */     if (xMarriage == null) {
/* 40 */       MarriageManager.sendNormalResult(this.roleid, 80, new String[0]);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     long time = xMarriage.getMarrytime() + SMarriageConsts.getInstance().giftTime * 60000;
/*    */     
/* 46 */     if (DateTimeUtils.getCurrTimeInMillis() > time) {
/* 47 */       MarriageManager.sendNormalResult(this.roleid, 80, new String[0]);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleid, 30, true);
/* 52 */     if (!ret) {
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     long leaderid = TeamInterface.getTeamLeaderByRoleid(this.roleid, false, false);
/* 57 */     if ((leaderid >= 0L) && (leaderid != this.roleid) && (TeamInterface.isTeamMemberNormal(this.roleid))) {
/* 58 */       return false;
/*    */     }
/* 60 */     MapInterface.transferToScene(this.roleid, SMarriageConsts.getInstance().marriageMapid, SMarriageConsts.getInstance().x, SMarriageConsts.getInstance().y);
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCTransforToMarrage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */