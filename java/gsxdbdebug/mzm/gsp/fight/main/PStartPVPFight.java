/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamDpMember;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*     */ import mzm.gsp.yzdd.main.YzddFightContext;
/*     */ import mzm.gsp.yzdd.main.YzddManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xbean.Pod;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2fight;
/*     */ import xtable.Rolefightcache;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PStartPVPFight
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long activeRoleid;
/*     */   private final long passiveRoleid;
/*     */   private FightContext context;
/*     */   private int fightType;
/*     */   private FightReason fightReson;
/*     */   
/*     */   PStartPVPFight(long activeRoleid, long passiveRoleid, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/*  43 */     this.activeRoleid = activeRoleid;
/*  44 */     this.passiveRoleid = passiveRoleid;
/*  45 */     this.context = context;
/*  46 */     this.fightType = fightType;
/*  47 */     this.fightReson = fightReson;
/*     */   }
/*     */   
/*  50 */   private boolean isYzdzPk(long roleid) { if (!ActivityInterface.isActivityOpen(YzddConsts.getInstance().ActivityId)) {
/*  51 */       return false;
/*     */     }
/*  53 */     int mapId = MapInterface.getRoleMapId(roleid);
/*  54 */     if ((mapId != YzddConsts.getInstance().MapId1) && (mapId != YzddConsts.getInstance().MapId2) && (mapId != YzddConsts.getInstance().MapId3)) {
/*  55 */       return false;
/*     */     }
/*  57 */     return true;
/*     */   }
/*     */   
/*  60 */   protected boolean processImp() throws Exception { xbean.Fight xFight = Pod.newFight();
/*  61 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*  62 */     List<Long> activeRoles = new ArrayList();
/*  63 */     activeRoles.add(Long.valueOf(this.activeRoleid));
/*  64 */     Map<Integer, TeamDpMember> activeZhanWeiMap = TeamInterface.getZhanWeiInfo(this.activeRoleid, false);
/*  65 */     for (TeamDpMember teamDpMember : activeZhanWeiMap.values()) {
/*  66 */       if ((teamDpMember.dispositionmember_type == 0) && (!activeRoles.contains(Long.valueOf(teamDpMember.teamdispositionmember_id))))
/*     */       {
/*  68 */         activeRoles.add(Long.valueOf(teamDpMember.teamdispositionmember_id)); }
/*     */     }
/*  70 */     List<Long> passiveRoles = new ArrayList();
/*  71 */     passiveRoles.add(Long.valueOf(this.passiveRoleid));
/*  72 */     Map<Integer, TeamDpMember> passiveZhanWeiMap = TeamInterface.getZhanWeiInfo(this.passiveRoleid, false);
/*  73 */     for (TeamDpMember teamDpMember : passiveZhanWeiMap.values()) {
/*  74 */       if ((teamDpMember.dispositionmember_type == 0) && (!passiveRoles.contains(Long.valueOf(teamDpMember.teamdispositionmember_id))))
/*     */       {
/*  76 */         passiveRoles.add(Long.valueOf(teamDpMember.teamdispositionmember_id)); }
/*     */     }
/*  78 */     Set<Long> allRoles = new HashSet();
/*  79 */     allRoles.addAll(activeRoles);
/*  80 */     allRoles.addAll(passiveRoles);
/*  81 */     lock(Basic.getTable(), allRoles);
/*     */     
/*  83 */     if (isYzdzPk(this.activeRoleid)) {
/*  84 */       this.context = new YzddFightContext();
/*  85 */       this.fightType = 2;
/*  86 */       this.fightReson = FightReason.GM;
/*  87 */       YzddManager.getInstance().AddFightId(fightid);
/*     */     }
/*     */     
/*  90 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  91 */     if (fightTypeCfg == null) {
/*  92 */       GameServer.logger().error("不存在的战斗类型配置:type:" + this.fightType);
/*  93 */       FightManager.triggerPVPFailEvent(this.context, activeRoles, passiveRoles);
/*  94 */       return false;
/*     */     }
/*  96 */     if (this.activeRoleid == this.passiveRoleid) {
/*  97 */       if (GameServer.logger().isDebugEnabled())
/*  98 */         GameServer.logger().debug("PVP主动方和被动方id相同，不能进入战斗!!!,fightReason:" + this.fightReson.value);
/*  99 */       FightManager.triggerPVPFailEvent(this.context, activeRoles, passiveRoles);
/* 100 */       return false;
/*     */     }
/* 102 */     boolean activeCanFight = canInFight(this.activeRoleid, activeRoles);
/* 103 */     boolean passiveCanFight = canInFight(this.passiveRoleid, passiveRoles);
/* 104 */     if ((!activeCanFight) || (!passiveCanFight)) {
/* 105 */       FightManager.triggerPVPFailEvent(this.context, activeRoles, passiveRoles);
/* 106 */       return false;
/*     */     }
/* 108 */     if (this.context != null) {
/* 109 */       xFight.setContext(this.context);
/* 110 */       if (this.context.isRecordEnable())
/* 111 */         xFight.setFight_recorder(new FightRecorder());
/*     */     }
/* 113 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 114 */     xFight.setStarttime(curTime);
/* 115 */     xFight.setCfgtype(this.fightType);
/* 116 */     xFight.setFightreason(this.fightReson.value);
/* 117 */     xFight.setObservers(new LinkedHashMap());
/* 118 */     FightManager.startPVPFight(fightid, xFight, activeRoles, passiveRoles);
/* 119 */     if (fightTypeCfg.maxDuration > 0) {
/* 120 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 121 */       xFight.setTimer(fightTimer);
/*     */     }
/* 123 */     UpdateTimer updateTimer = new UpdateTimer(fightid, FightArgs.getInstance().updateSec);
/* 124 */     xFight.setUpdatetimer(updateTimer);
/* 125 */     for (Iterator<Long> i$ = allRoles.iterator(); i$.hasNext();) {
/* 126 */       long roleid = ((Long)i$.next()).longValue();
/* 127 */       FightCache fightCache = Rolefightcache.get(Long.valueOf(roleid));
/* 128 */       FightManager.cancelAutoFight(roleid, fightCache);
/*     */     }
/* 130 */     FightManager.logger.info(String.format("[Fight]PStartPVPFight.processImp@fight roles|activeRoles=%s|passiveRoles=%s|time=%d|fightUUid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(activeRoles), FightManager.getComplexStr(passiveRoles), Long.valueOf(curTime), Long.valueOf(fightid), Integer.valueOf(this.fightReson.value) }));
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canInFight(long teamLeaderid, List<Long> teamRoles) {
/* 135 */     long wrongRoleid = -1L;
/* 136 */     for (Iterator<Long> i$ = teamRoles.iterator(); i$.hasNext();) {
/* 137 */       long roleid = ((Long)i$.next()).longValue();
/* 138 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/* 139 */       if (fightIdLong != null)
/* 140 */         return false;
/* 141 */       if (!RoleStatusInterface.setStatus(roleid, 0, true)) {
/* 142 */         wrongRoleid = roleid;
/* 143 */         break;
/*     */       }
/*     */     }
/* 146 */     if (wrongRoleid != -1L)
/* 147 */       return false;
/* 148 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPVPFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */