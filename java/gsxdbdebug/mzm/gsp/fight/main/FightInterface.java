/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.AutoFightInfo;
/*     */ import mzm.gsp.fight.SSyncAutoState;
/*     */ import mzm.gsp.fight.confbean.MonsterProb;
/*     */ import mzm.gsp.fight.confbean.SFightCfg;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.confbean.SMonsterFightCfg;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetFightTeam;
/*     */ import mzm.gsp.skill.confbean.SOccupationNormalSkillCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2fight;
/*     */ import xtable.Role2observefight;
/*     */ import xtable.Rolefightcache;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FightInterface
/*     */ {
/*     */   public static void startPVEFight(long roleid, int id, FightContext context, FightReason fightReson)
/*     */   {
/*  49 */     Procedure.execute(new PStartPVEFight(roleid, id, context, 1, fightReson));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVEFight(long roleid, int id, FightContext context, FightReason fightReson, FightParam fightParam)
/*     */   {
/*  68 */     Procedure.execute(new PStartPVEFight(roleid, id, context, 1, fightReson, fightParam));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVEFight(long roleid, int id, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/*  87 */     Procedure.execute(new PStartPVEFight(roleid, id, context, fightType, fightReson));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVEFight(long roleid, int id, FightContext context, int fightType, FightReason fightReson, FightParam fightParam)
/*     */   {
/* 109 */     Procedure.execute(new PStartPVEFight(roleid, id, context, fightType, fightReson, fightParam));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addMonsterNextRoundBuffInFight(long fightid, Map<Integer, List<Integer>> monsterid2Buffid)
/*     */   {
/* 122 */     Procedure.execute(new PAddMonsterNextRoundBuffInFight(fightid, monsterid2Buffid));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVPFight(long activeRoleid, long passiveRoleid, FightContext context, FightReason fightReson)
/*     */   {
/* 140 */     Procedure.execute(new PStartPVPFight(activeRoleid, passiveRoleid, context, 1, fightReson));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVPFight(long activeRoleid, long passiveRoleid, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/* 160 */     Procedure.execute(new PStartPVPFight(activeRoleid, passiveRoleid, context, fightType, fightReson));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVPFightWithTeamDisposition(List<Long> activeRoleids, List<Long> passiveRoleids, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/* 180 */     Procedure.execute(new PStartPVPFightWithTeamDisposition(activeRoleids, passiveRoleids, context, fightType, fightReson));
/*     */   }
/*     */   
/*     */ 
/*     */   public static void startPetCVCFight(PetFightInfo activePetFightInfo, PetFightInfo passivePetCloneFightInfo, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/* 186 */     Procedure.execute(new PStartPetCVCFight(activePetFightInfo, passivePetCloneFightInfo, context, fightType, fightReson));
/*     */   }
/*     */   
/*     */ 
/*     */   public static void startPetCVCRobotFight(PetFightInfo activePetFightInfo, PetFightRobotInfo passiveRobot, FightContext context, int fightType, FightReason fightReson)
/*     */   {
/* 192 */     Procedure.execute(new PStartPetCVCRobotFight(activePetFightInfo, passiveRobot, context, fightType, fightReson));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static final class PetFightRobotInfo
/*     */   {
/*     */     public long roleId;
/*     */     
/*     */ 
/*     */     public PetFightTeam zhenfaInfo;
/*     */     
/*     */     public HashMap<Integer, PetRobot> robots;
/*     */     
/*     */ 
/*     */     public PetFightRobotInfo()
/*     */     {
/* 209 */       this.robots = new HashMap();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public static class PetRobot
/*     */     {
/*     */       public int monsterCfgId;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public int level;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVCFight(long activeRoleid, List<Long> passiveRoleids, FightContext context, int fightType, FightReason fightReson, int pvcCfgid)
/*     */   {
/* 236 */     Procedure.execute(new PStartPVCFight(activeRoleid, passiveRoleids, context, fightType, fightReson, pvcCfgid));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVCFightWithRobot(long activeRoleid, List<Long> passiveRoleids, FightContext context, int fightType, FightReason fightReson, int robotClassid)
/*     */   {
/* 259 */     Procedure.execute(new PStartPVCFightWithRobot(activeRoleid, passiveRoleids, context, fightType, fightReson, robotClassid));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVIMonsterFight(long roleid, int id, FightContext context, FightReason fightReson, int hpRate)
/*     */   {
/* 281 */     if (hpRate <= 0) {
/* 282 */       GameServer.logger().error("战斗中怪物剩余万分比已经小于等于0,fightReason:" + fightReson.value);
/* 283 */       return;
/*     */     }
/* 285 */     Procedure.execute(new PStartPVIMonsterFight(roleid, id, context, 1, fightReson, hpRate));
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startPVIMonsterFight(long roleid, int id, FightContext context, int fightType, FightReason fightReson, int hpRate)
/*     */   {
/* 308 */     if (hpRate <= 0) {
/* 309 */       GameServer.logger().error("战斗中怪物剩余万分比已经小于等于0,fightReason:" + fightReson.value);
/* 310 */       return;
/*     */     }
/* 312 */     Procedure.execute(new PStartPVIMonsterFight(roleid, id, context, fightType, fightReson, hpRate));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void observeFight(long obseverRoleid, long beObservedRoleid)
/*     */   {
/* 325 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 329 */         return FightManager.reqObserveFight(this.val$obseverRoleid, this.val$beObservedRoleid);
/*     */       }
/*     */     });
/*     */   }
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
/*     */ 
/*     */   public static void observeFight(long obseverRoleid, long fightid, final long monsterInstanceid)
/*     */   {
/* 346 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 350 */         return FightManager.reqObserveFight(this.val$obseverRoleid, monsterInstanceid, this.val$monsterInstanceid);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerObserveFight(long worldid, ObserveFightChecker observeFightChecker)
/*     */   {
/* 362 */     FightManager.registerObserveFight(worldid, observeFightChecker);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unRegisterObserveFight(long worldid)
/*     */   {
/* 371 */     FightManager.unRegisterObserveFight(worldid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void endFight(long fightid)
/*     */   {
/* 381 */     Procedure.execute(new CloseFightProcedure(fightid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void endFightNonRealTime(long fightid)
/*     */   {
/* 391 */     NoneRealTimeTaskManager.getInstance().addTask(new CloseFightProcedure(fightid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean syncEndFight(long fightid)
/*     */   {
/* 402 */     return new CloseFightProcedure(fightid).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInFight(long roleid)
/*     */   {
/* 413 */     return Role2fight.select(Long.valueOf(roleid)) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Long getFightIdByRoleid(long roleid, boolean retainLock)
/*     */   {
/* 424 */     Long fightid = null;
/* 425 */     if (retainLock) {
/* 426 */       fightid = Role2fight.get(Long.valueOf(roleid));
/*     */     } else {
/* 428 */       fightid = Role2fight.select(Long.valueOf(roleid));
/*     */     }
/* 430 */     return fightid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInObserving(long roleid)
/*     */   {
/* 441 */     return Role2observefight.select(Long.valueOf(roleid)) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SFightCfg getFightCfg(int fightCfgid)
/*     */   {
/* 451 */     return SFightCfg.get(fightCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFightFirstMonsterid(int fightCfgid)
/*     */   {
/* 461 */     return FightManager.getFirstMonstByCfgid(fightCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasPVCRobotClassid(int classid)
/*     */   {
/* 471 */     return FightConfigManager.getInstance().hasPVCRobotClassid(classid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean fightTypeHasNew(int fightType)
/*     */   {
/* 482 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(fightType);
/* 483 */     if (fightTypeCfg == null) {
/* 484 */       return false;
/*     */     }
/* 486 */     return fightTypeCfg.hasNewer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getAwardList(int battleId)
/*     */   {
/* 496 */     Set<Integer> awardset = new HashSet();
/* 497 */     SFightCfg fightCfg = SFightCfg.get(battleId);
/* 498 */     Iterator i$; if (fightCfg != null) {
/* 499 */       awardset.add(Integer.valueOf(fightCfg.rewardId));
/*     */       
/* 501 */       for (i$ = fightCfg.monsterCfgs.iterator(); i$.hasNext();) { int monsterFightCfgID = ((Integer)i$.next()).intValue();
/* 502 */         SMonsterFightCfg cfg = SMonsterFightCfg.get(monsterFightCfgID);
/* 503 */         if (cfg != null)
/*     */         {
/*     */ 
/* 506 */           for (MonsterProb monsterProb : cfg.monsterProbs) {
/* 507 */             if (monsterProb.prob > 0) {
/* 508 */               awardset.add(Integer.valueOf(MonsterInterface.getRewardId(monsterProb.monsterid)));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 514 */     return awardset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getColumnPos(int pos)
/*     */   {
/* 524 */     return FightManager.getColumnPos(pos);
/*     */   }
/*     */   
/*     */   public static void fillColumnPos(int pos, Collection<Integer> positions) {
/* 528 */     FightManager.fillColumnPos(pos, positions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getRowPos(int pos)
/*     */   {
/* 538 */     return FightManager.getRowPos(pos);
/*     */   }
/*     */   
/*     */   public static void fillRowPos(int pos, Collection<Integer> positions) {
/* 542 */     FightManager.fillRowPos(pos, positions);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final void syncAutoState(long roleid)
/*     */   {
/* 551 */     FightCache xCache = Rolefightcache.select(Long.valueOf(roleid));
/* 552 */     syncAutoState(roleid, xCache);
/*     */   }
/*     */   
/*     */   static void syncAutoState(long roleid, FightCache xCache) {
/* 556 */     SSyncAutoState sync = new SSyncAutoState();
/* 557 */     fillAutoFightInfoBean(xCache, sync.info);
/* 558 */     OnlineManager.getInstance().send(roleid, sync);
/*     */   }
/*     */   
/*     */   static void fillAutoFightInfoBean(FightCache xCache, AutoFightInfo bean) {
/* 562 */     if (xCache != null) {
/* 563 */       if (xCache.getIsauto()) {
/* 564 */         bean.auto_state = 1;
/*     */       } else {
/* 566 */         bean.auto_state = 0;
/*     */       }
/* 568 */       bean.child_default_skills.putAll(xCache.getChild_default_skills());
/* 569 */       bean.pet_default_skills.putAll(xCache.getPet_default_skills());
/* 570 */       bean.role_default_skill = xCache.getRole_default_skill();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isNormalAttackSkill(int skillid)
/*     */   {
/* 581 */     if (skillid == SFightConsts.getInstance().ATTACK_SKILL) {
/* 582 */       return true;
/*     */     }
/* 584 */     for (SOccupationNormalSkillCfg occupationNormalSkillCfg : SOccupationNormalSkillCfg.getAll().values()) {
/* 585 */       if (occupationNormalSkillCfg.normalSkillid == skillid) {
/* 586 */         return true;
/*     */       }
/*     */     }
/* 589 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SFightTypeCfg getFightTypeCfg(int fightType)
/*     */   {
/* 599 */     return FightConfigManager.getInstance().getFightTypeCfg(fightType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void watchFightRecord(long roleid, long recordid)
/*     */   {
/* 611 */     new PCGetRecordReq(roleid, recordid).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void removeFightRecord(long recordid)
/*     */   {
/* 621 */     new PRemoveFightRecord(recordid).execute();
/*     */   }
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
/*     */   public static void onReportFightRecordDone(int retcode, long recordid, int dataType, Octets data, Octets context)
/*     */   {
/* 635 */     FightRecordManager.onReportFightRecordDone(retcode, recordid, dataType, data, context);
/*     */   }
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
/*     */   public static void onGetFightRecordDone(int retcode, long recordid, int dataType, Octets context, Octets rspdata)
/*     */   {
/* 649 */     FightRecordManager.onGetFightRecordDone(retcode, recordid, dataType, context, rspdata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onRoamFightRecordStart(long recordid, Octets startData)
/*     */   {
/* 659 */     FightRecordManager.onRoamFightRecordStart(recordid, startData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onRoamFightRecordEnd(long recordid, int maxRound, Octets endData)
/*     */   {
/* 669 */     FightRecordManager.onRoamFightRecordEnd(recordid, maxRound, endData);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onRoamFightRecordRound(long recordid, int round, Octets roundData)
/*     */   {
/* 680 */     FightRecordManager.onRoamFightRecordRound(recordid, round, roundData);
/*     */   }
/*     */   
/*     */   public static final class PetFightInfo
/*     */   {
/*     */     public long roleId;
/*     */     public PetFightTeam zhenfaInfo;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */