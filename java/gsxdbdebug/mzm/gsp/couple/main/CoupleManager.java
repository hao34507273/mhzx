/*     */ package mzm.gsp.couple.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.aircraft.main.AircraftInterface;
/*     */ import mzm.gsp.couple.CommonRideRoleInfo;
/*     */ import mzm.gsp.couple.SCommonRideRes;
/*     */ import mzm.gsp.couple.SCoupleNormalRet;
/*     */ import mzm.gsp.couple.SLeaveRideRes;
/*     */ import mzm.gsp.couple.confbean.SCoupleRideConst;
/*     */ import mzm.gsp.couple.event.CreateCoupleRideArg;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.CoupleRide;
/*     */ import xbean.Pod;
/*     */ import xtable.Coupleride;
/*     */ import xtable.Role2coupleride;
/*     */ 
/*     */ class CoupleManager
/*     */ {
/*     */   static void sendNormalResult(long roleid, int ret, String... args)
/*     */   {
/*  30 */     SCoupleNormalRet coupleNormalRet = new SCoupleNormalRet();
/*  31 */     fillNormalResult(coupleNormalRet, ret, args);
/*  32 */     OnlineManager.getInstance().sendAtOnce(roleid, coupleNormalRet);
/*     */   }
/*     */   
/*     */   static void fillNormalResult(SCoupleNormalRet coupleNormalRet, int ret, String[] args) {
/*  36 */     coupleNormalRet.ret = ret;
/*  37 */     for (String arg : args) {
/*  38 */       coupleNormalRet.args.add(arg);
/*     */     }
/*     */   }
/*     */   
/*     */   static void fillInCommonRideRes(long roleid, CommonRideRoleInfo commonRideRoleInfo, boolean retainLock)
/*     */   {
/*  44 */     commonRideRoleInfo.roleid = roleid;
/*  45 */     Role role = RoleInterface.getRole(roleid, retainLock);
/*  46 */     commonRideRoleInfo.gender = role.getGender();
/*  47 */     commonRideRoleInfo.level = role.getLevel();
/*  48 */     commonRideRoleInfo.menpai = role.getOccupationId();
/*     */   }
/*     */   
/*     */   static CoupleRideRet coupleRide(long roleid1, long roleid2) {
/*  52 */     long roleMale = roleid1;
/*  53 */     long roleFeMale = roleid2;
/*  54 */     if (RoleInterface.getGender(roleid1) == 2) {
/*  55 */       roleMale = roleid2;
/*  56 */       roleFeMale = roleid1;
/*     */     }
/*  58 */     CoupleRideRet coupleRideRet = canCoupleFly(roleMale, roleFeMale, false);
/*  59 */     if (coupleRideRet.success()) {
/*  60 */       int feijianCfgid = AircraftInterface.getEquipedFeiJianCfgId(roleMale, true);
/*  61 */       coupleRideRet = doCoupleRide(roleMale, roleFeMale, feijianCfgid);
/*     */     }
/*  63 */     return coupleRideRet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static CoupleRideRet doCoupleRide(long inviteRoleid, long roleid, int feijianCfgid)
/*     */   {
/*  72 */     boolean ret = RoleStatusInterface.setStatus(inviteRoleid, 25, false);
/*  73 */     if (!ret) {
/*  74 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderStatusError);
/*     */     }
/*  76 */     boolean ret1 = RoleStatusInterface.setStatus(roleid, 25, false);
/*  77 */     if (!ret1) {
/*  78 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleMemberStatusError);
/*     */     }
/*  80 */     boolean retFly = RoleStatusInterface.setStatus(Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(inviteRoleid) }), 2, false);
/*     */     
/*  82 */     if (!retFly) {
/*  83 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderStatusError);
/*     */     }
/*  85 */     CoupleRide xCoupleRide = Pod.newCoupleRide();
/*  86 */     xCoupleRide.setRolea(inviteRoleid);
/*  87 */     xCoupleRide.setRoleb(roleid);
/*  88 */     long coupleRideid = Coupleride.insert(xCoupleRide).longValue();
/*  89 */     Role2coupleride.insert(Long.valueOf(roleid), Long.valueOf(coupleRideid));
/*  90 */     Role2coupleride.insert(Long.valueOf(inviteRoleid), Long.valueOf(coupleRideid));
/*     */     
/*     */ 
/*  93 */     SCommonRideRes commonRideRoleRes = new SCommonRideRes();
/*  94 */     fillInCommonRideRes(inviteRoleid, commonRideRoleRes.commonrideroleinfo, true);
/*  95 */     OnlineManager.getInstance().send(roleid, commonRideRoleRes);
/*     */     
/*  97 */     SCommonRideRes commonRideInviteRes = new SCommonRideRes();
/*  98 */     fillInCommonRideRes(roleid, commonRideInviteRes.commonrideroleinfo, true);
/*  99 */     OnlineManager.getInstance().send(inviteRoleid, commonRideInviteRes);
/*     */     
/* 101 */     CreateCoupleRideArg createCoupleRideArg = new CreateCoupleRideArg(coupleRideid, inviteRoleid, roleid, feijianCfgid);
/*     */     
/* 103 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.couple.event.CreateCoupleRide(), createCoupleRideArg);
/* 104 */     return new CoupleRideRet(CoupleRideRet.Reason.SUCCESS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static DissolveCoupleRideRet dissolveCoupleRide(long roleA, long roleB)
/*     */   {
/* 115 */     Long coupleid = Role2coupleride.get(Long.valueOf(roleA));
/* 116 */     if (coupleid == null) {
/* 117 */       return new DissolveCoupleRideRet(DissolveCoupleRideRet.Reason.NOT_IN_COUPLE_RIDE);
/*     */     }
/* 119 */     CoupleRide coupleRide = Coupleride.get(coupleid);
/* 120 */     if (coupleRide == null) {
/* 121 */       return new DissolveCoupleRideRet(DissolveCoupleRideRet.Reason.NOT_IN_COUPLE_RIDE);
/*     */     }
/* 123 */     if ((roleB != coupleRide.getRolea()) && (roleB != coupleRide.getRoleb())) {
/* 124 */       return new DissolveCoupleRideRet(DissolveCoupleRideRet.Reason.NOT_IN_COUPLE_RIDE);
/*     */     }
/* 126 */     RoleStatusInterface.unsetStatus(roleA, 25);
/* 127 */     if (AircraftInterface.getEquipedFeiJianCfgId(roleA, true) <= 0) {
/* 128 */       RoleStatusInterface.unsetStatus(roleA, 2);
/*     */     }
/* 130 */     RoleStatusInterface.unsetStatus(roleB, 25);
/* 131 */     if (AircraftInterface.getEquipedFeiJianCfgId(roleB, true) <= 0) {
/* 132 */       RoleStatusInterface.unsetStatus(roleB, 2);
/*     */     }
/*     */     
/* 135 */     boolean ret = Role2coupleride.remove(Long.valueOf(roleA));
/* 136 */     if (!ret) {
/* 137 */       return new DissolveCoupleRideRet(DissolveCoupleRideRet.Reason.NOT_IN_COUPLE_RIDE);
/*     */     }
/* 139 */     Role2coupleride.remove(Long.valueOf(roleB));
/* 140 */     Coupleride.remove(coupleid);
/* 141 */     SLeaveRideRes leaveRideRes = new SLeaveRideRes();
/* 142 */     OnlineManager.getInstance().send(roleA, leaveRideRes);
/* 143 */     OnlineManager.getInstance().send(roleB, leaveRideRes);
/*     */     
/* 145 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.couple.event.DissolveCoupleRide(), new mzm.gsp.couple.event.DissolveCoupleRideArg(coupleid.longValue(), roleA, roleB));
/*     */     
/* 147 */     return new DissolveCoupleRideRet(DissolveCoupleRideRet.Reason.SUCCESS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static CoupleRideRet canCoupleFly(long roleid, long otherRoleid, boolean sendStatusTip)
/*     */   {
/* 159 */     int mapcfgId = MapInterface.getRoleMapId(roleid);
/* 160 */     if (!MapInterface.canFly(mapcfgId)) {
/* 161 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderInNotFlyMap);
/*     */     }
/* 163 */     int level = RoleInterface.getLevel(roleid);
/* 164 */     if (level < SCoupleRideConst.getInstance().needLevel) {
/* 165 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderLevelNotEnough);
/*     */     }
/* 167 */     int otherLevel = RoleInterface.getLevel(otherRoleid);
/* 168 */     if (otherLevel < SCoupleRideConst.getInstance().needLevel) {
/* 169 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleMemberLevelNotEnough);
/*     */     }
/*     */     
/* 172 */     int feijianId = AircraftInterface.getEquipedFeiJianCfgId(roleid, false);
/* 173 */     if (feijianId <= 0) {
/* 174 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderNotHasAirCraft);
/*     */     }
/* 176 */     SFeiJianCfg feiJianCfg = ItemInterface.getFeiJianCfg(feijianId);
/* 177 */     if (feiJianCfg == null) {
/* 178 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderNotHasAirCraft);
/*     */     }
/* 180 */     if ((feiJianCfg.feiJianType != 2) && (feiJianCfg.feiJianType != 4)) {
/* 181 */       if (RoleInterface.getGender(roleid) != 1) {
/* 182 */         return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderMustMALE);
/*     */       }
/* 184 */       if (RoleInterface.getGender(otherRoleid) != 2) {
/* 185 */         return new CoupleRideRet(CoupleRideRet.Reason.CoupleMemberMustFEMALE);
/*     */       }
/*     */     }
/*     */     
/* 189 */     if (TeamInterface.isRoleInTeam(roleid, true)) {
/* 190 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderInTeam);
/*     */     }
/* 192 */     if (TeamInterface.isRoleInTeam(otherRoleid, true)) {
/* 193 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleMemberInTeam);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */     if (!RoleStatusInterface.checkCanSetStatus(roleid, 25, sendStatusTip)) {
/* 206 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderStatusError);
/*     */     }
/*     */     
/* 209 */     if (!RoleStatusInterface.checkCanSetStatus(otherRoleid, 25, false)) {
/* 210 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleMemberStatusError);
/*     */     }
/* 212 */     if (Role2coupleride.get(Long.valueOf(roleid)) != null) {
/* 213 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleLeaderInCoupleRide);
/*     */     }
/* 215 */     if (Role2coupleride.get(Long.valueOf(otherRoleid)) != null) {
/* 216 */       return new CoupleRideRet(CoupleRideRet.Reason.CoupleMemberInCoupleRide);
/*     */     }
/* 218 */     return new CoupleRideRet(CoupleRideRet.Reason.SUCCESS);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\CoupleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */