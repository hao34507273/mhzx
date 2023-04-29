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
/*     */ import mzm.gsp.pvc.confbean.SPVCCfg;
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
/*     */ class PStartPVCFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long activeRoleid;
/*     */   private final List<Long> passiveRoleids;
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReson;
/*     */   private final int pvcCfgid;
/*     */   
/*     */   PStartPVCFight(long activeRoleid, List<Long> passiveRoleids, FightContext context, int fightType, FightReason fightReson, int pvcCfgid)
/*     */   {
/*  33 */     this.activeRoleid = activeRoleid;
/*  34 */     this.passiveRoleids = passiveRoleids;
/*  35 */     this.context = context;
/*  36 */     this.fightType = fightType;
/*  37 */     this.fightReson = fightReson;
/*  38 */     this.pvcCfgid = pvcCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  43 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  44 */     if (fightTypeCfg == null) {
/*  45 */       GameServer.logger().error("不存在的战斗类型配置:type:" + this.fightType);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (SPVCCfg.get(this.pvcCfgid) == null) {
/*  50 */       GameServer.logger().error("配置的镜像战斗配置id不存在:" + this.pvcCfgid);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (this.passiveRoleids.size() <= 0) {
/*  55 */       if (GameServer.logger().isDebugEnabled())
/*  56 */         GameServer.logger().debug("配置的镜像战斗配置id不存在:" + this.pvcCfgid);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     xbean.Fight xFight = xbean.Pod.newFight();
/*  62 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*     */     
/*  64 */     List<Long> activeRoles = new ArrayList();
/*  65 */     activeRoles.add(Long.valueOf(this.activeRoleid));
/*  66 */     Map<Integer, TeamDpMember> activeZhanWeiMap = TeamInterface.getZhanWeiInfo(this.activeRoleid, false);
/*  67 */     for (TeamDpMember teamDpMember : activeZhanWeiMap.values()) {
/*  68 */       if ((teamDpMember.dispositionmember_type == 0) && 
/*  69 */         (!activeRoles.contains(Long.valueOf(teamDpMember.teamdispositionmember_id)))) {
/*  70 */         activeRoles.add(Long.valueOf(teamDpMember.teamdispositionmember_id));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  75 */     Set<Long> allRoles = new HashSet();
/*  76 */     allRoles.addAll(activeRoles);
/*  77 */     allRoles.addAll(this.passiveRoleids);
/*     */     
/*  79 */     lock(Basic.getTable(), allRoles);
/*     */     
/*     */ 
/*  82 */     long wrongRoleid = -1L;
/*  83 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  84 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/*  85 */       if (fightIdLong != null) {
/*  86 */         FightManager.sendNormalResult(this.activeRoleid, 101, new String[0]);
/*  87 */         return false;
/*     */       }
/*     */       
/*  90 */       if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(roleid, 0, true)) {
/*  91 */         wrongRoleid = roleid;
/*  92 */         break;
/*     */       }
/*     */     }
/*  95 */     if (wrongRoleid != -1L) {
/*  96 */       if (wrongRoleid != this.activeRoleid) {
/*  97 */         String roleName = RoleInterface.getName(wrongRoleid);
/*  98 */         FightManager.sendNormalResult(this.activeRoleid, 1, new String[] { roleName });
/*     */       }
/* 100 */       return false;
/*     */     }
/*     */     
/* 103 */     if (this.context != null) {
/* 104 */       xFight.setContext(this.context);
/* 105 */       if (this.context.isRecordEnable()) {
/* 106 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/* 109 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 110 */     xFight.setStarttime(curTime);
/* 111 */     xFight.setCfgtype(this.fightType);
/* 112 */     xFight.setFightreason(this.fightReson.value);
/* 113 */     xFight.setObservers(new java.util.LinkedHashMap());
/* 114 */     FightManager.startPVCFight(fightid, xFight, activeRoles, this.passiveRoleids, this.pvcCfgid);
/*     */     
/*     */ 
/* 117 */     if (fightTypeCfg.maxDuration > 0) {
/* 118 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 119 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/* 123 */     UpdateTimer updateTimer = new UpdateTimer(fightid, FightArgs.getInstance().updateSec);
/* 124 */     xFight.setUpdatetimer(updateTimer);
/*     */     
/* 126 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 127 */       FightCache xFightCache = Rolefightcache.get(Long.valueOf(roleid));
/* 128 */       FightManager.cancelAutoFight(roleid, xFightCache);
/*     */     }
/*     */     
/* 131 */     FightManager.logger.info(String.format("[Fight]PStartPVCFight.processImp@fight roles|activeRoles=%s|passiveRoles=%s|time=%d|fightUUid=%d|pvcCfgid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(activeRoles), FightManager.getComplexStr(this.passiveRoleids), Long.valueOf(curTime), Long.valueOf(fightid), Integer.valueOf(this.pvcCfgid), Integer.valueOf(this.fightReson.value) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPVCFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */