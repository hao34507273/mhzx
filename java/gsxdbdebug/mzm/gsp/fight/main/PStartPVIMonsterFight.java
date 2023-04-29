/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightCfg;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
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
/*     */ class PStartPVIMonsterFight
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int id;
/*     */   private final FightContext context;
/*     */   private final int fightType;
/*     */   private final FightReason fightReson;
/*     */   private final int hpRate;
/*     */   
/*     */   PStartPVIMonsterFight(long roleid, int id, FightContext context, int fightType, FightReason fightReson, int hpRate)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.id = id;
/*  38 */     this.context = context;
/*  39 */     this.fightType = fightType;
/*  40 */     this.fightReson = fightReson;
/*  41 */     this.hpRate = hpRate;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  46 */     if (SFightCfg.get(this.id) == null) {
/*  47 */       FightManager.sendNormalResult(this.id, 1, new String[0]);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightType);
/*  52 */     if (fightTypeCfg == null) {
/*  53 */       GameServer.logger().error("不存在的战斗类型配置:type:" + this.fightType);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     xbean.Fight xFight = Pod.newFight();
/*  59 */     long fightid = xtable.Fight.insert(xFight).longValue();
/*  60 */     List<Long> roles = new ArrayList();
/*  61 */     roles.add(Long.valueOf(this.roleid));
/*     */     
/*  63 */     Map<Integer, TeamDpMember> zhanWeiMap = TeamInterface.getZhanWeiInfo(this.roleid, false);
/*  64 */     for (TeamDpMember teamDpMember : zhanWeiMap.values()) {
/*  65 */       if ((teamDpMember.dispositionmember_type == 0) && 
/*  66 */         (!roles.contains(Long.valueOf(teamDpMember.teamdispositionmember_id)))) {
/*  67 */         roles.add(Long.valueOf(teamDpMember.teamdispositionmember_id));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  73 */     lock(Basic.getTable(), roles);
/*     */     
/*     */ 
/*  76 */     long wrongRoleid = -1L;
/*  77 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  78 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/*  79 */       if (fightIdLong != null) {
/*  80 */         FightManager.sendNormalResult(roleid, 101, new String[0]);
/*  81 */         return false;
/*     */       }
/*     */       
/*  84 */       if (!RoleStatusInterface.setStatus(roleid, 0, true)) {
/*  85 */         wrongRoleid = roleid;
/*  86 */         break;
/*     */       }
/*     */     }
/*  89 */     if (wrongRoleid != -1L)
/*     */     {
/*  91 */       if (wrongRoleid != this.roleid) {
/*  92 */         String roleName = RoleInterface.getName(wrongRoleid);
/*  93 */         FightManager.sendNormalResult(this.roleid, 1, new String[] { roleName });
/*     */       }
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (this.context != null) {
/*  99 */       xFight.setContext(this.context);
/* 100 */       if (this.context.isRecordEnable()) {
/* 101 */         xFight.setFight_recorder(new FightRecorder());
/*     */       }
/*     */     }
/* 104 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 105 */     xFight.setCfgtype(this.fightType);
/* 106 */     xFight.setFightreason(this.fightReson.value);
/* 107 */     xFight.setStarttime(curTime);
/* 108 */     xFight.setObservers(new LinkedHashMap());
/* 109 */     FightManager.startPVInvincibleMonster(fightid, xFight, roles, this.id, this.hpRate);
/*     */     
/*     */ 
/* 112 */     if (fightTypeCfg.maxDuration > 0) {
/* 113 */       FightTimer fightTimer = new FightTimer(fightid, fightTypeCfg.maxDuration);
/* 114 */       xFight.setTimer(fightTimer);
/*     */     }
/*     */     
/*     */ 
/* 118 */     UpdateTimer updateTimer = new UpdateTimer(fightid, FightArgs.getInstance().updateSec);
/* 119 */     xFight.setUpdatetimer(updateTimer);
/*     */     
/* 121 */     FightManager.logger.info(String.format("[Fight]PStartPVIMonsterFight.processImp@fight roles|roles=%s|time=%d|fightcfgid=%d|fightUUid=%d|fightReason=%d", new Object[] { FightManager.getComplexStr(roles), Long.valueOf(curTime), Integer.valueOf(this.id), Long.valueOf(fightid), Integer.valueOf(this.fightReson.value) }));
/*     */     
/*     */ 
/*     */ 
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PStartPVIMonsterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */