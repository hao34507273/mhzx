/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ import mzm.gsp.couple.SRefuseCommonRideRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PCRefuseOrAgerrRideInvite extends LogicProcedure
/*    */ {
/*    */   private final long sessionid;
/*    */   private final long roleid;
/*    */   private int operate;
/*    */   
/*    */   public PCRefuseOrAgerrRideInvite(long sessionid, long roleid, int operate)
/*    */   {
/* 22 */     this.sessionid = sessionid;
/* 23 */     this.roleid = roleid;
/* 24 */     this.operate = operate;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     Session session = Session.getSession(this.sessionid);
/* 30 */     CoupleRideSession rideSession = null;
/* 31 */     if ((session instanceof CoupleRideSession)) {
/* 32 */       rideSession = (CoupleRideSession)session;
/*    */     } else {
/* 34 */       CoupleManager.sendNormalResult(this.roleid, 4, new String[0]);
/* 35 */       return false;
/*    */     }
/* 37 */     if (rideSession.getBeInvitedid() != this.roleid) {
/* 38 */       GameServer.logger().info(String.format("[Couple]PCRefuseOrAgerrRideInvite.processImp@role is not be invited by this session|roleid=%d|sessionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.sessionid) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */       return false;
/*    */     }
/* 47 */     long inviteRoleid = rideSession.getInviteid();
/*    */     
/* 49 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(inviteRoleid), Long.valueOf(this.roleid) }));
/* 50 */     if (this.operate == 1) {
/* 51 */       SRefuseCommonRideRes refuseCommonRideRes = new SRefuseCommonRideRes();
/* 52 */       refuseCommonRideRes.refuseroleid = this.roleid;
/* 53 */       refuseCommonRideRes.refuserolename = RoleInterface.getName(this.roleid);
/* 54 */       OnlineManager.getInstance().sendAtOnce(inviteRoleid, refuseCommonRideRes);
/* 55 */       rideSession.stopTimer();
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     CoupleRideRet coupleRideRet = CoupleManager.canCoupleFly(inviteRoleid, this.roleid, true);
/*    */     
/* 61 */     if (!coupleRideRet.success()) {
/* 62 */       if (coupleRideRet.isCoupleLeaderInNotFlyMap()) {
/* 63 */         CoupleManager.sendNormalResult(inviteRoleid, 5, new String[0]);
/* 64 */       } else if (coupleRideRet.isCoupleLeaderNotHasAirCraft()) {
/* 65 */         CoupleManager.sendNormalResult(this.roleid, 0, new String[0]);
/*    */       }
/* 67 */       else if (coupleRideRet.isCoupleLeaderInTeam()) {
/* 68 */         CoupleManager.sendNormalResult(this.roleid, 2, new String[0]);
/* 69 */       } else if (coupleRideRet.isCoupleLeaderStatusError()) {
/* 70 */         CoupleManager.sendNormalResult(this.roleid, 1, new String[0]);
/* 71 */       } else if (coupleRideRet.isCoupleMemberStatusError()) {
/* 72 */         CoupleManager.sendNormalResult(this.roleid, 1, new String[0]);
/* 73 */       } else if (coupleRideRet.isCoupleLeaderInCoupleRide()) {
/* 74 */         CoupleManager.sendNormalResult(this.roleid, 3, new String[0]);
/* 75 */       } else if (coupleRideRet.isCoupleMemberInCoupleRide()) {
/* 76 */         GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@role is in couple ride status|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */ 
/*    */       }
/* 79 */       else if (coupleRideRet.isCoupleLeaderInModelChange()) {
/* 80 */         CoupleManager.sendNormalResult(this.roleid, 6, new String[0]);
/* 81 */       } else if (coupleRideRet.isCoupleMemberInModelChange()) {
/* 82 */         CoupleManager.sendNormalResult(this.roleid, 7, new String[0]);
/*    */       }
/* 84 */       return false;
/*    */     }
/* 86 */     int feijianCfgid = AircraftInterface.getEquipedFeiJianCfgId(inviteRoleid, true);
/* 87 */     if (feijianCfgid < 0) {
/* 88 */       CoupleManager.sendNormalResult(this.roleid, 0, new String[0]);
/*    */       
/* 90 */       return false;
/*    */     }
/* 92 */     coupleRideRet = CoupleManager.doCoupleRide(inviteRoleid, this.roleid, feijianCfgid);
/*    */     
/* 94 */     return coupleRideRet.success();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\PCRefuseOrAgerrRideInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */