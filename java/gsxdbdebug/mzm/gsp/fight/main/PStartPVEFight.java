/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightCfg;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.event.PVEFightStartFail;
/*     */ import mzm.gsp.fight.event.PVEFightStartFailArg;
/*     */ import mzm.gsp.fight.event.PVEFightStartFailArg.FailReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamDpMember;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2fight;
/*     */ 
/*     */ 
/*     */ 
/*     */ class PStartPVEFight
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int id;
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReson;
/*  38 */   private FightParam fightParam = null;
/*     */   
/*     */   PStartPVEFight(long roleid, int id, FightContext context, int fightType, FightReason fightReson) {
/*  41 */     this.roleid = roleid;
/*  42 */     this.id = id;
/*  43 */     this.context = context;
/*  44 */     this.fightType = fightType;
/*  45 */     this.fightReson = fightReson;
/*     */   }
/*     */   
/*     */   PStartPVEFight(long roleid, int id, FightContext context, int fightType, FightReason fightReson, FightParam fightParam)
/*     */   {
/*  50 */     this(roleid, id, context, fightType, fightReson);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     if (SFightCfg.get(this.id) == null) {
/*  58 */       FightManager.sendNormalResult(this.id, 1, new String[0]);
/*  59 */       PVEFightStartFailArg pveFightStartFailArg = new PVEFightStartFailArg(this.id, this.context, this.roleid, PVEFightStartFailArg.FailReason.FIGHT_ID_NOT_EXIST);
/*     */       
/*  61 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PVEFightStartFail(), pveFightStartFailArg);
/*  62 */       return false;
/*     */     }
/*  64 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  65 */     if (fightTypeCfg == null) {
/*  66 */       GameServer.logger().error("不存在的战斗类型配置:type:" + this.fightType);
/*  67 */       PVEFightStartFailArg pveFightStartFailArg = new PVEFightStartFailArg(this.id, this.context, this.roleid, PVEFightStartFailArg.FailReason.FIGHT_TYPE_NOT_EXIST);
/*     */       
/*  69 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PVEFightStartFail(), pveFightStartFailArg);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     xbean.Fight xFight = Pod.newFight();
/*  75 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*  76 */     List<Long> roles = new ArrayList();
/*  77 */     roles.add(Long.valueOf(this.roleid));
/*     */     
/*  79 */     Map<Integer, TeamDpMember> zhanWeiMap = TeamInterface.getZhanWeiInfo(this.roleid, false);
/*  80 */     for (TeamDpMember teamDpMember : zhanWeiMap.values()) {
/*  81 */       if ((teamDpMember.dispositionmember_type == 0) && 
/*  82 */         (!roles.contains(Long.valueOf(teamDpMember.teamdispositionmember_id)))) {
/*  83 */         roles.add(Long.valueOf(teamDpMember.teamdispositionmember_id));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  89 */     Set<Long> allLockRoles = new HashSet();
/*  90 */     allLockRoles.addAll(roles);
/*  91 */     if (this.fightParam != null) {
/*  92 */       for (RoleRowModleInfo roleRowModleInfo : this.fightParam.pveRoleRowModleInfos) {
/*  93 */         allLockRoles.add(Long.valueOf(roleRowModleInfo.roleid));
/*     */       }
/*     */     }
/*  96 */     lock(Basic.getTable(), allLockRoles);
/*     */     
/*     */ 
/*  99 */     long wrongRoleid = -1L;
/* 100 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 101 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/* 102 */       if (fightIdLong != null) {
/* 103 */         FightManager.sendNormalResult(roleid, 101, new String[0]);
/* 104 */         PVEFightStartFailArg pveFightStartFailArg = new PVEFightStartFailArg(this.id, this.context, roleid, PVEFightStartFailArg.FailReason.ROLE_IS_IN_FIGHT);
/*     */         
/* 106 */         TriggerEventsManger.getInstance().triggerEventAtOnce(new PVEFightStartFail(), pveFightStartFailArg);
/* 107 */         return false;
/*     */       }
/*     */       
/* 110 */       if (!RoleStatusInterface.setStatus(roleid, 0, true)) {
/* 111 */         wrongRoleid = roleid;
/* 112 */         break;
/*     */       }
/*     */     }
/* 115 */     if (wrongRoleid != -1L)
/*     */     {
/* 117 */       if (wrongRoleid != this.roleid) {
/* 118 */         String roleName = RoleInterface.getName(wrongRoleid);
/* 119 */         FightManager.sendNormalResult(this.roleid, 1, new String[] { roleName });
/*     */       }
/* 121 */       PVEFightStartFailArg pveFightStartFailArg = new PVEFightStartFailArg(this.id, this.context, this.roleid, PVEFightStartFailArg.FailReason.ROLE_SET_STATUS_WRONG);
/*     */       
/* 123 */       TriggerEventsManger.getInstance().triggerEventAtOnce(new PVEFightStartFail(), pveFightStartFailArg);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (this.context != null) {
/* 128 */       xFight.setContext(this.context);
/* 129 */       if (this.context.isRecordEnable()) {
/* 130 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/* 133 */     if (this.fightParam != null) {
/* 134 */       xFight.setFightparams(this.fightParam);
/*     */     }
/* 136 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 137 */     xFight.setCfgtype(this.fightType);
/* 138 */     xFight.setFightreason(this.fightReson.value);
/* 139 */     xFight.setStarttime(curTime);
/* 140 */     xFight.setObservers(new LinkedHashMap());
/*     */     
/* 142 */     FightManager.startPVEFight(fightid, xFight, roles, this.id);
/*     */     
/*     */ 
/* 145 */     if (fightTypeCfg.maxDuration > 0) {
/* 146 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 147 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/* 151 */     UpdateTimer updateTimer = new UpdateTimer(fightid, FightArgs.getInstance().updateSec);
/* 152 */     xFight.setUpdatetimer(updateTimer);
/*     */     
/* 154 */     FightManager.logger.info(String.format("[Fight]PStartPVEFight.processImp@fight roles|roles=%s|time=%d|fightcfgid=%d|fightUUid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(roles), Long.valueOf(curTime), Integer.valueOf(this.id), Long.valueOf(fightid), Integer.valueOf(this.fightReson.value) }));
/*     */     
/*     */ 
/*     */ 
/* 158 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPVEFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */