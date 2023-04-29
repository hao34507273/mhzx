/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamDpMember;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2fight;
/*     */ import xtable.Rolefightcache;
/*     */ 
/*     */ class PStartPVCFightWithRobot extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long activeRoleid;
/*     */   private final List<Long> passiveRoleids;
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReson;
/*     */   private final int robotClassid;
/*     */   
/*     */   public PStartPVCFightWithRobot(long activeRoleid, List<Long> passiveRoleids, FightContext context, int fightType, FightReason fightReson, int robotClassid)
/*     */   {
/*  32 */     this.activeRoleid = activeRoleid;
/*  33 */     this.passiveRoleids = passiveRoleids;
/*  34 */     this.context = context;
/*  35 */     this.fightType = fightType;
/*  36 */     this.fightReson = fightReson;
/*  37 */     this.robotClassid = robotClassid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  42 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  43 */     if (fightTypeCfg == null) {
/*  44 */       GameServer.logger().error("不存在的战斗类型配置:type:" + this.fightType);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!FightConfigManager.getInstance().hasPVCRobotClassid(this.robotClassid)) {
/*  49 */       GameServer.logger().error("配置的镜像战斗机器人配置的类id不存在:" + this.robotClassid);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     xbean.Fight xFight = xbean.Pod.newFight();
/*  55 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*     */     
/*  57 */     List<Long> activeRoles = new ArrayList();
/*  58 */     activeRoles.add(Long.valueOf(this.activeRoleid));
/*  59 */     Map<Integer, TeamDpMember> activeZhanWeiMap = TeamInterface.getZhanWeiInfo(this.activeRoleid, false);
/*  60 */     for (TeamDpMember teamDpMember : activeZhanWeiMap.values()) {
/*  61 */       if ((teamDpMember.dispositionmember_type == 0) && 
/*  62 */         (!activeRoles.contains(Long.valueOf(teamDpMember.teamdispositionmember_id)))) {
/*  63 */         activeRoles.add(Long.valueOf(teamDpMember.teamdispositionmember_id));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  68 */     Set<Long> allRoles = new HashSet();
/*  69 */     allRoles.addAll(activeRoles);
/*  70 */     allRoles.addAll(this.passiveRoleids);
/*     */     
/*  72 */     lock(Basic.getTable(), allRoles);
/*     */     
/*     */ 
/*  75 */     long wrongRoleid = -1L;
/*  76 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  77 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/*  78 */       if (fightIdLong != null) {
/*  79 */         FightManager.sendNormalResult(this.activeRoleid, 101, new String[0]);
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(roleid, 0, true)) {
/*  84 */         wrongRoleid = roleid;
/*  85 */         break;
/*     */       }
/*     */     }
/*  88 */     if (wrongRoleid != -1L) {
/*  89 */       if (wrongRoleid != this.activeRoleid) {
/*  90 */         String roleName = RoleInterface.getName(wrongRoleid);
/*  91 */         FightManager.sendNormalResult(this.activeRoleid, 1, new String[] { roleName });
/*     */       }
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (this.context != null) {
/*  97 */       xFight.setContext(this.context);
/*  98 */       if (this.context.isRecordEnable()) {
/*  99 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/* 102 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 103 */     xFight.setStarttime(curTime);
/* 104 */     xFight.setCfgtype(this.fightType);
/* 105 */     xFight.setFightreason(this.fightReson.value);
/* 106 */     xFight.setObservers(new java.util.LinkedHashMap());
/* 107 */     FightManager.startPVCFightWithRobot(fightid, xFight, activeRoles, this.passiveRoleids, this.robotClassid);
/*     */     
/*     */ 
/* 110 */     if (fightTypeCfg.maxDuration > 0) {
/* 111 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 112 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/* 116 */     UpdateTimer updateTimer = new UpdateTimer(fightid, FightArgs.getInstance().updateSec);
/* 117 */     xFight.setUpdatetimer(updateTimer);
/*     */     
/* 119 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 120 */       FightCache xFightCache = Rolefightcache.get(Long.valueOf(roleid));
/* 121 */       FightManager.cancelAutoFight(roleid, xFightCache);
/*     */     }
/*     */     
/* 124 */     FightManager.logger.info(String.format("[Fight]PStartPVCFightWithRobot.processImp@fight roles|activeRoles=%s|passiveRoles=%s|time=%d|fightUUid=%d|robotClassid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(activeRoles), FightManager.getComplexStr(this.passiveRoleids), Long.valueOf(curTime), Long.valueOf(fightid), Integer.valueOf(this.robotClassid), Integer.valueOf(this.fightReson.value) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPVCFightWithRobot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */