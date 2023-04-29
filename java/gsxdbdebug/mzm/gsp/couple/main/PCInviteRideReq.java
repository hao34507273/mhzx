/*     */ package mzm.gsp.couple.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.couple.SInviteRideRes;
/*     */ import mzm.gsp.couple.SReceiveRideInviteRes;
/*     */ import mzm.gsp.couple.confbean.SCoupleRideConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class PCInviteRideReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long otherRoleid;
/*     */   
/*     */   public PCInviteRideReq(long roleid, long otherroleid)
/*     */   {
/*  19 */     this.roleid = roleid;
/*  20 */     this.otherRoleid = otherroleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  25 */     lock(Role2properties.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.otherRoleid) }));
/*  26 */     if (Role2properties.get(Long.valueOf(this.otherRoleid)) == null) {
/*  27 */       GameServer.logger().error(String.format("[CoupleFly]PCInviteRideReq.processImp@client error,roleid is not exist|roleid=%d", new Object[] { Long.valueOf(this.otherRoleid) }));
/*     */       
/*  29 */       return false;
/*     */     }
/*  31 */     CoupleRideRet coupleRideRet = CoupleManager.canCoupleFly(this.roleid, this.otherRoleid, true);
/*  32 */     if (!coupleRideRet.success()) {
/*  33 */       if (coupleRideRet.isCoupleLeaderGenderError()) {
/*  34 */         GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@inviting couple ride role must be male|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */ 
/*     */ 
/*     */       }
/*  38 */       else if (coupleRideRet.isCoupleMemberGenderError()) {
/*  39 */         GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@be invited couple ride role must be female|roleid=%d", new Object[] { Long.valueOf(this.otherRoleid) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  46 */       else if (coupleRideRet.isCoupleLeaderLeveNotEnough()) {
/*  47 */         GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@role level not enough|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(RoleInterface.getLevel(this.roleid)) }));
/*     */ 
/*     */       }
/*  50 */       else if (coupleRideRet.isCoupleMemberLevelNotEnough()) {
/*  51 */         SInviteRideRes inviteRideRes = new SInviteRideRes();
/*  52 */         inviteRideRes.ret = 4;
/*  53 */         OnlineManager.getInstance().sendAtOnce(this.roleid, inviteRideRes);
/*  54 */       } else if (coupleRideRet.isCoupleLeaderNotHasAirCraft()) {
/*  55 */         GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@inviting couple ride role must wear AIRCRAFT|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*  62 */       else if (coupleRideRet.isCoupleMemberInTeam()) {
/*  63 */         SInviteRideRes inviteRideRes = new SInviteRideRes();
/*  64 */         inviteRideRes.ret = 2;
/*  65 */         OnlineManager.getInstance().sendAtOnce(this.roleid, inviteRideRes);
/*  66 */       } else if (!coupleRideRet.isCoupleLeaderStatusError())
/*     */       {
/*  68 */         if (coupleRideRet.isCoupleMemberStatusError()) {
/*  69 */           SInviteRideRes inviteRideRes = new SInviteRideRes();
/*  70 */           inviteRideRes.ret = 1;
/*  71 */           OnlineManager.getInstance().sendAtOnce(this.roleid, inviteRideRes);
/*  72 */         } else if (coupleRideRet.isCoupleLeaderInCoupleRide()) {
/*  73 */           GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@role is in couple ride status|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */ 
/*     */         }
/*  76 */         else if (coupleRideRet.isCoupleMemberInCoupleRide()) {
/*  77 */           SInviteRideRes sInviteRideRes = new SInviteRideRes();
/*  78 */           sInviteRideRes.ret = 3;
/*  79 */           OnlineManager.getInstance().sendAtOnce(this.roleid, sInviteRideRes);
/*  80 */         } else if (coupleRideRet.isCoupleLeaderInNotFlyMap()) {
/*  81 */           GameServer.logger().info(String.format("[Couple]PCInviteRideReq.processImp@role is in forbiden flying map|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */ 
/*     */         }
/*  84 */         else if (coupleRideRet.isCoupleLeaderInModelChange()) {
/*  85 */           SInviteRideRes sInviteRideRes = new SInviteRideRes();
/*  86 */           sInviteRideRes.ret = 5;
/*  87 */           OnlineManager.getInstance().sendAtOnce(this.roleid, sInviteRideRes);
/*  88 */         } else if (coupleRideRet.isCoupleMemberInModelChange()) {
/*  89 */           SInviteRideRes sInviteRideRes = new SInviteRideRes();
/*  90 */           sInviteRideRes.ret = 5;
/*  91 */           OnlineManager.getInstance().sendAtOnce(this.roleid, sInviteRideRes);
/*     */         } }
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     long sessionid = new CoupleRideSession(SCoupleRideConst.getInstance().defaultRefuseTime, this.roleid, this.otherRoleid).getSessionId();
/*     */     
/*     */ 
/*  99 */     SInviteRideRes inviteRideRes = new SInviteRideRes();
/* 100 */     inviteRideRes.ret = 0;
/* 101 */     OnlineManager.getInstance().send(this.roleid, inviteRideRes);
/*     */     
/* 103 */     SReceiveRideInviteRes receiveRideInviteRes = new SReceiveRideInviteRes();
/* 104 */     receiveRideInviteRes.sessionid = sessionid;
/* 105 */     receiveRideInviteRes.inviteroleid = this.roleid;
/* 106 */     receiveRideInviteRes.inviterolename = RoleInterface.getName(this.roleid);
/* 107 */     OnlineManager.getInstance().send(this.otherRoleid, receiveRideInviteRes);
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\PCInviteRideReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */