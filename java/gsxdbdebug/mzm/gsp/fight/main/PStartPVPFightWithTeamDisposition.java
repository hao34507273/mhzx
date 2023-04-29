/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xbean.Pod;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2fight;
/*     */ import xtable.Rolefightcache;
/*     */ 
/*     */ class PStartPVPFightWithTeamDisposition extends LogicProcedure
/*     */ {
/*  23 */   private final List<Long> activeRoleids = new ArrayList();
/*  24 */   private final List<Long> passiveRoleids = new ArrayList();
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReson;
/*     */   
/*     */   PStartPVPFightWithTeamDisposition(List<Long> activeRoleids, List<Long> passiveRoleids, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/*  31 */     this.activeRoleids.addAll(activeRoleids);
/*  32 */     this.passiveRoleids.addAll(passiveRoleids);
/*  33 */     this.context = context;
/*  34 */     this.fightType = fightType;
/*  35 */     this.fightReson = fightReson;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  40 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  41 */     if (fightTypeCfg == null) {
/*  42 */       GameServer.logger().error("不存在的战斗类型配置:type:" + this.fightType);
/*  43 */       FightManager.triggerPVPFailEvent(this.context, this.activeRoleids, this.passiveRoleids);
/*  44 */       return false;
/*     */     }
/*  46 */     for (Iterator i$ = this.passiveRoleids.iterator(); i$.hasNext();) { long passiveRoleid = ((Long)i$.next()).longValue();
/*  47 */       if (this.activeRoleids.contains(Long.valueOf(passiveRoleid))) {
/*  48 */         GameServer.logger().error(String.format("PVP主动方和被动方id相同，不能进入战斗!!!|fightReason=%d|roleid=%d", new Object[] { Integer.valueOf(this.fightReson.value), Long.valueOf(passiveRoleid) }));
/*     */         
/*     */ 
/*  51 */         FightManager.triggerPVPFailEvent(this.context, this.activeRoleids, this.passiveRoleids);
/*  52 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  57 */     xbean.Fight xFight = Pod.newFight();
/*  58 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*     */     
/*  60 */     Set<Long> allRoles = new HashSet();
/*  61 */     allRoles.addAll(this.activeRoleids);
/*  62 */     allRoles.addAll(this.passiveRoleids);
/*     */     
/*  64 */     lock(Basic.getTable(), allRoles);
/*  65 */     boolean activeCanFight = canInFight(((Long)this.activeRoleids.get(0)).longValue(), this.activeRoleids);
/*  66 */     boolean passiveCanFight = canInFight(((Long)this.passiveRoleids.get(0)).longValue(), this.passiveRoleids);
/*  67 */     if ((!activeCanFight) || (!passiveCanFight)) {
/*  68 */       FightManager.triggerPVPFailEvent(this.context, this.activeRoleids, this.passiveRoleids);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     if (this.context != null) {
/*  73 */       xFight.setContext(this.context);
/*  74 */       if (this.context.isRecordEnable()) {
/*  75 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/*  78 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  79 */     xFight.setStarttime(curTime);
/*  80 */     xFight.setCfgtype(this.fightType);
/*  81 */     xFight.setFightreason(this.fightReson.value);
/*  82 */     xFight.setObservers(new LinkedHashMap());
/*  83 */     FightManager.startPVPFightWithTeamDisposition(fightid, xFight, this.activeRoleids, this.passiveRoleids);
/*     */     
/*     */ 
/*  86 */     if (fightTypeCfg.maxDuration > 0) {
/*  87 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/*  88 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/*  92 */     UpdateTimer updateTimer = new UpdateTimer(fightid, FightArgs.getInstance().updateSec);
/*  93 */     xFight.setUpdatetimer(updateTimer);
/*     */     
/*     */ 
/*  96 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  97 */       FightCache fightCache = Rolefightcache.get(Long.valueOf(roleid));
/*  98 */       FightManager.cancelAutoFight(roleid, fightCache);
/*     */     }
/*     */     
/* 101 */     FightManager.logger.info(String.format("[Fight]PStartPVPFightWithTeamDisposition.processImp@fight roles|activeRoles=%s|passiveRoles=%s|time=%d|fightUUid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(this.activeRoleids), FightManager.getComplexStr(this.passiveRoleids), Long.valueOf(curTime), Long.valueOf(fightid), Integer.valueOf(this.fightReson.value) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 106 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canInFight(long teamLeaderid, List<Long> teamRoles)
/*     */   {
/* 111 */     long wrongRoleid = -1L;
/* 112 */     for (Iterator i$ = teamRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 113 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/* 114 */       if (fightIdLong != null) {
/* 115 */         return false;
/*     */       }
/*     */       
/* 118 */       if (!RoleStatusInterface.setStatus(roleid, 0, true)) {
/* 119 */         wrongRoleid = roleid;
/* 120 */         break;
/*     */       }
/*     */     }
/* 123 */     if (wrongRoleid != -1L) {
/* 124 */       return false;
/*     */     }
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPVPFightWithTeamDisposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */