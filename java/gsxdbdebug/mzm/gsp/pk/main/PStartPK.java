/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.map.confbean.SMapConfig;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.SStartPKFail;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RolePKInformation;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ 
/*     */ 
/*     */ public class PStartPK
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long targetRoleId;
/*     */   
/*     */   public PStartPK(long roleId, long targetRoleId)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.targetRoleId = targetRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (PKManager.isNotEnable()) {
/*  47 */       return false;
/*     */     }
/*  49 */     InnerStatus status = new InnerStatus();
/*     */     
/*     */ 
/*  52 */     holdAllLocks(status, this.roleId, this.targetRoleId);
/*  53 */     if (status.returnFalse)
/*     */     {
/*  55 */       notifyFail(status);
/*  56 */       PKLogManager.error(String.format("PStartPK.processImp()@cannot hold correct locks|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     checkPKRoleRelation(status, this.roleId, this.targetRoleId);
/*  63 */     if (status.returnFalse) {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     checkActiveTeamLeader(status, this.roleId);
/*  68 */     if (status.returnFalse)
/*     */     {
/*  70 */       PKLogManager.error(String.format("PStartPK.processImp()@not team leader|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     checkTeamConfirmState(status);
/*  77 */     if (status.returnFalse)
/*     */     {
/*  79 */       PKLogManager.error(String.format("PStartPK.processImp()@in team confirm session|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     checkMap(status, this.roleId);
/*  86 */     if (status.returnFalse)
/*     */     {
/*  88 */       notifyFail(status);
/*  89 */       PKLogManager.error(String.format("PStartPK.processImp()@in safe map|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     checkDistance(status, this.roleId, this.targetRoleId);
/*  96 */     if (status.returnFalse)
/*     */     {
/*  98 */       notifyFail(status);
/*  99 */       PKLogManager.error(String.format("PStartPK.processImp()@distance too far away|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */       
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     checkFightStatus(status, this.roleId, this.targetRoleId);
/* 106 */     if (status.returnFalse)
/*     */     {
/* 108 */       notifyFail(status);
/* 109 */       PKLogManager.error(String.format("PStartPK.processImp()@in fight status|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     checkPKStatus(status, this.roleId);
/* 117 */     if (status.returnFalse)
/*     */     {
/* 119 */       notifyFail(status);
/* 120 */       PKLogManager.error(String.format("PStartPK.processImp()@pk status not enabled|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 123 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 127 */     checkZeroMoralValue(status, this.roleId);
/* 128 */     if (status.returnFalse)
/*     */     {
/* 130 */       notifyFail(status);
/* 131 */       PKLogManager.error(String.format("PStartPK.processImp()@zero moral value|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     checkActivePKTimes(status, this.roleId);
/* 139 */     if (status.returnFalse)
/*     */     {
/* 141 */       notifyFail(status);
/* 142 */       PKLogManager.error(String.format("PStartPK.processImp()@max pk times reached|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 145 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 149 */     checkActiveRoleForceProtection(status, this.roleId);
/* 150 */     if (status.returnFalse)
/*     */     {
/* 152 */       notifyFail(status);
/* 153 */       PKLogManager.error(String.format("PStartPK.processImp()@cannot start pk (force protected)|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 156 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 160 */     checkTargetLevel(status);
/* 161 */     if (status.returnFalse)
/*     */     {
/* 163 */       notifyFail(status);
/* 164 */       PKLogManager.error(String.format("PStartPK.processImp()@target level too low|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 167 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 171 */     checkTargetRoleProtection(status);
/* 172 */     if (status.returnFalse)
/*     */     {
/* 174 */       notifyFail(status);
/* 175 */       PKLogManager.error(String.format("PStartPK.processImp()@cannot be pk target (protected)|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 178 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 182 */     checkOutPrisonProtection(status, this.roleId);
/* 183 */     if (status.returnFalse)
/*     */     {
/* 185 */       notifyFail(status);
/* 186 */       PKLogManager.error(String.format("PStartPK.processImp()@out of prison protection|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 189 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 193 */     checkOtherStatusConflict(status, this.roleId);
/* 194 */     if (status.returnFalse)
/*     */     {
/* 196 */       notifyFail(status);
/* 197 */       PKLogManager.error(String.format("PStartPK.processImp()@status conflict|active_roleid=%d|target_roleid=%d|roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Long.valueOf(status.returnRoleId) }));
/*     */       
/*     */ 
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     if ((status.activeTeamId == null) || (status.activeRoleIds.size() == 1))
/*     */     {
/*     */ 
/* 206 */       PKFightContext fightContext = new PKFightContext();
/* 207 */       fightContext.mainActiveRoleId = this.roleId;
/* 208 */       fightContext.mainTargetRoleId = this.targetRoleId;
/*     */       long passiveRoleId;
/* 210 */       long passiveRoleId; if (status.targetTeamId == null)
/*     */       {
/* 212 */         passiveRoleId = this.targetRoleId;
/*     */       }
/*     */       else
/*     */       {
/* 216 */         passiveRoleId = status.targetInTempLeaving ? this.targetRoleId : TeamInterface.getTeamLeaderByTeamid(status.targetTeamId.longValue(), true);
/*     */       }
/*     */       
/* 219 */       FightInterface.startPVPFight(this.roleId, passiveRoleId, fightContext, 25, FightReason.PK_FIGHT);
/* 220 */       PKLogManager.info(String.format("PStartPK.processImp()@single pk started|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 227 */       PKTeamConfirmContext confirmContext = new PKTeamConfirmContext();
/* 228 */       confirmContext.activeRoleId = this.roleId;
/* 229 */       confirmContext.activeRoleIds = status.activeRoleIds;
/* 230 */       confirmContext.targetRoleId = this.targetRoleId;
/* 231 */       TeamConfirmInterface.startTeamConfirm(status.activeTeamId.longValue(), 3, confirmContext);
/* 232 */       PKLogManager.info(String.format("PStartPK.processImp()@wait for team confirmation|active_roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */     }
/*     */     
/*     */ 
/* 236 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static class InnerStatus
/*     */   {
/* 247 */     boolean returnFalse = false;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 253 */     int returnCode = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 259 */     int returnRoleType = -1;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 264 */     long returnRoleId = -1L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 269 */     Long activeTeamId = null;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 274 */     Set<Long> activeRoleIds = new HashSet();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 279 */     Long targetTeamId = null;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 284 */     Set<Long> targetRoleIds = new HashSet();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 289 */     boolean activeRoleInTempLeaving = false;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 294 */     boolean targetInTempLeaving = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void holdAllLocks(InnerStatus status, long activeRoleId, long targetRoleId)
/*     */   {
/* 304 */     status.activeRoleInTempLeaving = RoleStatusInterface.containsStatus(activeRoleId, 7);
/* 305 */     TeamInfo activeTeamInfo = TeamInterface.getTeamInfoByRoleId(activeRoleId);
/* 306 */     if (activeTeamInfo != null)
/*     */     {
/* 308 */       status.activeTeamId = Long.valueOf(activeTeamInfo.getTeamId());
/* 309 */       if (!status.activeRoleInTempLeaving)
/* 310 */         status.activeRoleIds = new HashSet(activeTeamInfo.getTeamNormalList());
/*     */     }
/* 312 */     status.targetInTempLeaving = RoleStatusInterface.containsStatus(targetRoleId, 7);
/* 313 */     TeamInfo targetTeamInfo = TeamInterface.getTeamInfoByRoleId(targetRoleId);
/* 314 */     if (targetTeamInfo != null)
/*     */     {
/* 316 */       status.targetTeamId = Long.valueOf(targetTeamInfo.getTeamId());
/* 317 */       if (!status.targetInTempLeaving) {
/* 318 */         status.targetRoleIds = new HashSet(targetTeamInfo.getTeamNormalList());
/*     */       }
/*     */     }
/* 321 */     Set<Long> allRoleIds = new HashSet();
/* 322 */     if (status.activeRoleIds.isEmpty())
/*     */     {
/* 324 */       allRoleIds.add(Long.valueOf(activeRoleId));
/*     */     }
/*     */     else
/*     */     {
/* 328 */       allRoleIds.addAll(status.activeRoleIds);
/*     */     }
/* 330 */     if (status.targetRoleIds.isEmpty())
/*     */     {
/* 332 */       allRoleIds.add(Long.valueOf(targetRoleId));
/*     */     }
/*     */     else
/*     */     {
/* 336 */       allRoleIds.addAll(status.targetRoleIds);
/*     */     }
/*     */     
/* 339 */     List<Long> allTeamIds = new ArrayList(2);
/* 340 */     if (status.activeTeamId != null)
/* 341 */       allTeamIds.add(status.activeTeamId);
/* 342 */     if (status.targetTeamId != null) {
/* 343 */       allTeamIds.add(status.targetTeamId);
/*     */     }
/*     */     
/* 346 */     Lockeys.lock(Basic.getTable(), allRoleIds);
/* 347 */     Lockeys.lock(Team.getTable(), allTeamIds);
/*     */     
/* 349 */     if (status.activeTeamId != null)
/*     */     {
/*     */ 
/* 352 */       if (((!status.activeRoleInTempLeaving) && (!checkLockConsistency(TeamInterface.getTeamInfo(status.activeTeamId.longValue(), true), status.activeRoleIds))) || ((status.activeRoleInTempLeaving) && (!checkLockConsistencyForTempLeaving(TeamInterface.getTeamInfo(status.activeTeamId.longValue(), true), status.activeRoleIds))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 357 */         status.returnFalse = true;
/* 358 */         status.returnCode = -1;
/* 359 */         return;
/*     */       }
/*     */     }
/* 362 */     if (status.targetTeamId != null)
/*     */     {
/*     */ 
/* 365 */       if (((!status.targetInTempLeaving) && (!checkLockConsistency(TeamInterface.getTeamInfo(status.targetTeamId.longValue(), true), status.targetRoleIds))) || ((status.targetInTempLeaving) && (!checkLockConsistencyForTempLeaving(TeamInterface.getTeamInfo(status.targetTeamId.longValue(), true), status.targetRoleIds))))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 370 */         status.returnFalse = true;
/* 371 */         status.returnCode = -1;
/* 372 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 377 */     if ((status.activeTeamId == null) || (status.activeRoleInTempLeaving))
/*     */     {
/* 379 */       status.activeRoleIds.add(Long.valueOf(activeRoleId));
/*     */     }
/* 381 */     if ((status.targetTeamId == null) || (status.targetInTempLeaving))
/*     */     {
/* 383 */       status.targetRoleIds.add(Long.valueOf(targetRoleId));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkLockConsistency(TeamInfo teamInfo, Set<Long> roleIds)
/*     */   {
/* 392 */     if (teamInfo == null)
/* 393 */       return roleIds.isEmpty();
/* 394 */     List<Long> normalRoleIds = teamInfo.getTeamNormalList();
/* 395 */     return (normalRoleIds.size() == roleIds.size()) && (roleIds.containsAll(normalRoleIds));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkLockConsistencyForTempLeaving(TeamInfo teamInfo, Set<Long> roleIds)
/*     */   {
/* 403 */     if (teamInfo == null)
/* 404 */       return false;
/* 405 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 407 */       if (teamInfo.getMemberStatus(roleId) != 1)
/* 408 */         return false;
/*     */     }
/* 410 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkPKRoleRelation(InnerStatus status, long activeRoleId, long targetRoleId)
/*     */   {
/* 418 */     if (activeRoleId == targetRoleId)
/*     */     {
/* 420 */       PKLogManager.error(String.format("PStartPK.checkPKRoleRelation()@cannot fight self|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(activeRoleId), Long.valueOf(targetRoleId) }));
/*     */       
/*     */ 
/* 423 */       status.returnFalse = true;
/* 424 */       return;
/*     */     }
/*     */     
/* 427 */     if (status.activeTeamId == null) {
/* 428 */       return;
/*     */     }
/* 430 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(status.activeTeamId.longValue(), true);
/* 431 */     if (teamInfo == null)
/* 432 */       return;
/* 433 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/* 434 */     if (teamMembers.contains(Long.valueOf(targetRoleId)))
/*     */     {
/* 436 */       PKLogManager.error(String.format("PStartPK.checkPKRoleRelation()@cannot fight teammate|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(activeRoleId), Long.valueOf(targetRoleId) }));
/*     */       
/*     */ 
/* 439 */       status.returnFalse = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkActiveTeamLeader(InnerStatus status, long roleId)
/*     */   {
/* 449 */     if ((status.activeTeamId != null) && (!status.activeRoleInTempLeaving))
/*     */     {
/* 451 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(status.activeTeamId.longValue(), true);
/* 452 */       if (teamInfo == null)
/*     */       {
/* 454 */         status.returnFalse = true;
/* 455 */         status.returnCode = -1;
/* 456 */         return;
/*     */       }
/* 458 */       if (teamInfo.getLeaderId() != roleId)
/*     */       {
/* 460 */         status.returnFalse = true;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkTeamConfirmState(InnerStatus status)
/*     */   {
/* 471 */     if ((status.activeTeamId != null) && (!status.activeRoleInTempLeaving))
/*     */     {
/* 473 */       status.returnFalse = TeamConfirmInterface.inConfirmIng(status.activeTeamId.longValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkMap(InnerStatus status, long roleId)
/*     */   {
/* 482 */     int mapId = MapInterface.getRoleMapId(roleId);
/* 483 */     if (mapId == 0)
/*     */     {
/* 485 */       status.returnFalse = true;
/* 486 */       status.returnCode = 6;
/* 487 */       return;
/*     */     }
/* 489 */     SMapConfig mapCfg = SMapConfig.get(mapId);
/* 490 */     if (mapCfg == null)
/*     */     {
/* 492 */       status.returnFalse = true;
/* 493 */       status.returnCode = 6;
/* 494 */       return;
/*     */     }
/* 496 */     status.returnFalse = (!mapCfg.canPK);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkDistance(InnerStatus status, long activeRoleId, long targetRoleId)
/*     */   {
/* 504 */     if (!MapInterface.isInSameView(activeRoleId, targetRoleId))
/*     */     {
/* 506 */       status.returnFalse = true;
/* 507 */       status.returnCode = 4;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkFightStatus(InnerStatus status, long activeRoleId, long targetRoleId)
/*     */   {
/* 516 */     for (Iterator i$ = Arrays.asList(new Long[] { Long.valueOf(activeRoleId), Long.valueOf(targetRoleId) }).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 518 */       if (RoleStatusInterface.containsStatus(roleId, 0))
/*     */       {
/* 520 */         status.returnFalse = true;
/* 521 */         status.returnCode = 5;
/* 522 */         status.returnRoleId = roleId;
/* 523 */         status.returnRoleType = (roleId == activeRoleId ? 0 : 2);
/* 524 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkPKStatus(InnerStatus status, long mainActiveRoleId)
/*     */   {
/* 534 */     for (Iterator i$ = status.activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 536 */       if (!RoleStatusInterface.containsStatus(roleId, 1621))
/*     */       {
/* 538 */         status.returnFalse = true;
/* 539 */         status.returnCode = 1;
/* 540 */         status.returnRoleId = roleId;
/* 541 */         status.returnRoleType = (roleId == mainActiveRoleId ? 0 : 1);
/* 542 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkZeroMoralValue(InnerStatus status, long mainActiveRoleId)
/*     */   {
/* 552 */     for (Iterator i$ = status.activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 554 */       if (MallInterface.getJifen(roleId, 7) == 0L)
/*     */       {
/* 556 */         status.returnFalse = true;
/* 557 */         status.returnCode = 13;
/* 558 */         status.returnRoleId = roleId;
/* 559 */         status.returnRoleType = (roleId == mainActiveRoleId ? 0 : 1);
/* 560 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkActivePKTimes(InnerStatus status, long mainActiveRoleId)
/*     */   {
/* 570 */     for (Iterator i$ = status.activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 572 */       if (!hasAvailablePKTimes(roleId))
/*     */       {
/* 574 */         status.returnFalse = true;
/* 575 */         status.returnCode = 12;
/* 576 */         status.returnRoleId = roleId;
/* 577 */         status.returnRoleType = (roleId == mainActiveRoleId ? 0 : 1);
/* 578 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean hasAvailablePKTimes(long roleId)
/*     */   {
/* 588 */     int maxPKTimesPerDay = SPKConsts.getInstance().MAX_PK_TIMES_PER_DAY;
/* 589 */     RolePKInformation xRolePKInformation = PKManager.getRolePKInformation(roleId);
/* 590 */     return (xRolePKInformation == null) || (xRolePKInformation.getActive_pk_times() < maxPKTimesPerDay);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkActiveRoleForceProtection(InnerStatus status, long mainActiveRoleId)
/*     */   {
/* 598 */     for (Iterator i$ = status.activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 600 */       if (RoleStatusInterface.containsStatus(roleId, 1623))
/*     */       {
/* 602 */         status.returnFalse = true;
/* 603 */         status.returnCode = 8;
/* 604 */         status.returnRoleId = roleId;
/* 605 */         status.returnRoleType = (roleId == mainActiveRoleId ? 0 : 1);
/* 606 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkTargetLevel(InnerStatus status)
/*     */   {
/* 616 */     for (Iterator i$ = status.targetRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 618 */       if (RoleInterface.getLevel(roleId) < SPKConsts.getInstance().ENABLE_PK_LEVEL)
/*     */       {
/* 620 */         status.returnFalse = true;
/* 621 */         status.returnCode = 2;
/* 622 */         status.returnRoleId = roleId;
/* 623 */         status.returnRoleType = 2;
/* 624 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkTargetRoleProtection(InnerStatus status)
/*     */   {
/* 634 */     for (Iterator i$ = status.targetRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 636 */       if ((RoleStatusInterface.containsStatus(roleId, 1622)) || (RoleStatusInterface.containsStatus(roleId, 1623)))
/*     */       {
/*     */ 
/* 639 */         status.returnFalse = true;
/* 640 */         status.returnCode = 7;
/* 641 */         status.returnRoleId = roleId;
/* 642 */         status.returnRoleType = 2;
/* 643 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkOutPrisonProtection(InnerStatus status, long mainActiveRoleId)
/*     */   {
/* 653 */     for (Iterator i$ = status.activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 655 */       if (RoleStatusInterface.containsStatus(roleId, 1662))
/*     */       {
/* 657 */         status.returnFalse = true;
/* 658 */         status.returnCode = 11;
/* 659 */         if (roleId == mainActiveRoleId)
/*     */         {
/* 661 */           status.returnRoleType = 0;
/*     */         }
/*     */         else
/*     */         {
/* 665 */           status.returnRoleType = 1;
/* 666 */           status.returnRoleId = roleId;
/*     */         }
/* 668 */         return;
/*     */       }
/*     */     }
/*     */     
/* 672 */     for (Iterator i$ = status.targetRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 674 */       if (RoleStatusInterface.containsStatus(roleId, 1662))
/*     */       {
/* 676 */         status.returnFalse = true;
/* 677 */         status.returnCode = 11;
/* 678 */         status.returnRoleType = 2;
/* 679 */         status.returnRoleId = roleId;
/* 680 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkOtherStatusConflict(InnerStatus status, long mainActiveRoleId)
/*     */   {
/* 690 */     for (Iterator i$ = status.activeRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 692 */       if (!RoleStatusInterface.checkCanSetStatus(roleId, 1624, false))
/*     */       {
/* 694 */         status.returnFalse = true;
/* 695 */         status.returnCode = 9;
/* 696 */         status.returnRoleId = roleId;
/* 697 */         status.returnRoleType = (roleId == mainActiveRoleId ? 0 : 1);
/* 698 */         return;
/*     */       }
/*     */     }
/* 701 */     for (Iterator i$ = status.targetRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 703 */       if (!RoleStatusInterface.checkCanSetStatus(roleId, 1625, false))
/*     */       {
/* 705 */         status.returnFalse = true;
/* 706 */         status.returnCode = 9;
/* 707 */         status.returnRoleId = roleId;
/* 708 */         status.returnRoleType = 2;
/* 709 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyFail(InnerStatus status)
/*     */   {
/* 716 */     SStartPKFail sStartPKFail = new SStartPKFail();
/* 717 */     sStartPKFail.retcode = status.returnCode;
/* 718 */     sStartPKFail.role_type = status.returnRoleType;
/* 719 */     if ((status.returnRoleId != -1L) && (status.returnRoleType > 0))
/*     */     {
/*     */       try
/*     */       {
/* 723 */         String name = RoleInterface.getName(status.returnRoleId);
/* 724 */         if (name != null)
/*     */         {
/* 726 */           sStartPKFail.role_name.setString(name, "UTF-8");
/*     */         }
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/* 731 */         PKLogManager.error("PStartPK.notifyFail()@unsupported encoding exception");
/*     */       }
/*     */     }
/* 734 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sStartPKFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PStartPK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */