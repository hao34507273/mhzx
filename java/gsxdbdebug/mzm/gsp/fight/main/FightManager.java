/*      */ package mzm.gsp.fight.main;
/*      */ 
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.fight.SAutoOperateNotify;
/*      */ import mzm.gsp.fight.SEnterFightBrd;
/*      */ import mzm.gsp.fight.SFightNormalResult;
/*      */ import mzm.gsp.fight.SOperateRes;
/*      */ import mzm.gsp.fight.confbean.SFightCfg;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.confbean.SFightSkillLogCfg;
/*      */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*      */ import mzm.gsp.fight.confbean.SPetFightZhenfaPos2Fight;
/*      */ import mzm.gsp.fight.confbean.SSkillLogCfg;
/*      */ import mzm.gsp.fight.event.PVPFightFail;
/*      */ import mzm.gsp.fight.event.PVPFightFailArg;
/*      */ import mzm.gsp.fight.event.RoleObserveStart;
/*      */ import mzm.gsp.idip.main.IdipManager;
/*      */ import mzm.gsp.map.main.MapCallback;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.scene.Position;
/*      */ import mzm.gsp.monster.main.Monster;
/*      */ import mzm.gsp.monster.main.MonsterManager;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.personal.main.PersonalInterface;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.skill.confbean.SOccupationNormalSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillCfg;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightCache;
/*      */ import xbean.ObserveFight;
/*      */ import xbean.Pod;
/*      */ import xdb.Lockeys;
/*      */ import xtable.Basic;
/*      */ import xtable.Role2fight;
/*      */ import xtable.Role2observefight;
/*      */ import xtable.Rolefightcache;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class FightManager
/*      */ {
/*      */   static final int ROW_PET = 0;
/*      */   static final int ROW_ROLE = 1;
/*      */   static final int ROW_NPC = 2;
/*      */   static final int PROB_SUM = 10000;
/*   75 */   static final Logger logger = Logger.getLogger("fight");
/*      */   
/*      */   static final int LOSE = 0;
/*      */   
/*      */   static final int WIN = 1;
/*      */   static final int ESCAPE = 2;
/*   81 */   static final Map<Long, ObserveFightChecker> OBSERVEFIGHTCHECK_MAP = new ConcurrentHashMap();
/*      */   
/*      */   static Fight getFight(long fightid) {
/*   84 */     xbean.Fight xFight = xtable.Fight.get(Long.valueOf(fightid));
/*   85 */     if (xFight == null) {
/*   86 */       return null;
/*      */     }
/*   88 */     return getFight(fightid, xFight);
/*      */   }
/*      */   
/*      */   static Fight getFight(long fightid, xbean.Fight xFight) {
/*   92 */     switch (xFight.getType()) {
/*      */     case 0: 
/*   94 */       return new PVEFight(fightid, xFight);
/*      */     case 1: 
/*   96 */       return new PVPFight(fightid, xFight);
/*      */     case 2: 
/*   98 */       return new PVCFight(fightid, xFight);
/*      */     case 3: 
/*  100 */       return new PVIMonsterFight(fightid, xFight);
/*      */     case 4: 
/*  102 */       return new PetCVCFight(fightid, xFight);
/*      */     }
/*  104 */     return null;
/*      */   }
/*      */   
/*      */   static Fight getFightByRoleid(long roleid)
/*      */   {
/*  109 */     Long fightid = Role2fight.select(Long.valueOf(roleid));
/*  110 */     if (fightid == null) {
/*  111 */       return null;
/*      */     }
/*  113 */     return getFight(fightid.longValue());
/*      */   }
/*      */   
/*      */   static void removeFight(Fight fight) {
/*  117 */     xtable.Fight.remove(Long.valueOf(fight.fightid));
/*  118 */     Set<Long> roleids = fight.getFightRoles();
/*  119 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  120 */       Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/*  121 */       if ((fightIdLong != null) && (fightIdLong.longValue() != fight.fightid)) {
/*  122 */         GameServer.logger().error(String.format("[fight]remove_fihgt wrong|roleid=%d|fightid=%d", new Object[] { Long.valueOf(roleid), fightIdLong }));
/*      */       }
/*      */       
/*  125 */       Role2fight.remove(Long.valueOf(roleid));
/*  126 */       RoleStatusInterface.unsetStatus(roleid, 0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getPosNumberPerRow()
/*      */   {
/*  137 */     return TeamInterface.getTeamCapacity();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getPosPiorList()
/*      */   {
/*  148 */     LinkedList<Integer> posList = new LinkedList();
/*  149 */     int posNum = getPosNumberPerRow();
/*  150 */     for (int i = 0; i < posNum; i++) {
/*  151 */       posList.addLast(Integer.valueOf(i));
/*      */     }
/*      */     
/*  154 */     for (int i = 0; i < posNum - 2; i++) {
/*  155 */       int pick = (posNum - i - 1) / 2 + i;
/*  156 */       if ((pick >= 0) && (pick != i)) {
/*  157 */         Integer v = (Integer)posList.remove(pick);
/*  158 */         posList.add(i, v);
/*      */       }
/*      */     }
/*      */     
/*  162 */     return posList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getRowMiddlePos(int row)
/*      */   {
/*  171 */     List<Integer> posPiorList = getPosPiorList();
/*  172 */     return row * posPiorList.size() + ((Integer)posPiorList.get(0)).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getColumnPos(int pos)
/*      */   {
/*  182 */     List<Integer> posList = new ArrayList();
/*  183 */     int posNumPerRow = getPosNumberPerRow();
/*  184 */     int mod = pos % posNumPerRow;
/*  185 */     for (int i = 0; i <= 2; i++) {
/*  186 */       posList.add(Integer.valueOf(mod + posNumPerRow * i));
/*      */     }
/*  188 */     return posList;
/*      */   }
/*      */   
/*      */   static void fillColumnPos(int pos, Collection<Integer> positions) {
/*  192 */     int posNumPerRow = getPosNumberPerRow();
/*  193 */     int mod = pos % posNumPerRow;
/*  194 */     for (int i = 0; i <= 2; i++) {
/*  195 */       positions.add(Integer.valueOf(mod + posNumPerRow * i));
/*      */     }
/*      */   }
/*      */   
/*      */   static List<Integer> getRowPos(int pos) {
/*  200 */     List<Integer> posList = new ArrayList();
/*  201 */     int posNumPerRow = getPosNumberPerRow();
/*  202 */     int rowStart = pos / posNumPerRow * posNumPerRow;
/*  203 */     for (int i = 0; i < posNumPerRow; i++) {
/*  204 */       posList.add(Integer.valueOf(i + rowStart));
/*      */     }
/*  206 */     return posList;
/*      */   }
/*      */   
/*      */   static void fillRowPos(int pos, Collection<Integer> positions) {
/*  210 */     int posNumPerRow = getPosNumberPerRow();
/*  211 */     int rowStart = pos / posNumPerRow * posNumPerRow;
/*  212 */     for (int i = 0; i < posNumPerRow; i++) {
/*  213 */       positions.add(Integer.valueOf(i + rowStart));
/*      */     }
/*      */   }
/*      */   
/*      */   static FightGroup getFightGroup(int groupid, xbean.FightGroup xGroup, FightTeam fightTeam) {
/*  218 */     switch (xGroup.getType()) {
/*      */     case 0: 
/*  220 */       return new FightGroupRole(groupid, xGroup, fightTeam);
/*      */     case 1: 
/*  222 */       if (FightGroupMonster.isNpcMonsterGroup(xGroup)) {
/*  223 */         return new FightGroupNpcMonster(groupid, xGroup, fightTeam);
/*      */       }
/*  225 */       return new FightGroupMonster(groupid, xGroup, fightTeam);
/*      */     
/*      */     case 2: 
/*  228 */       return new FightGroupFellow(groupid, xGroup, fightTeam);
/*      */     }
/*  230 */     return null;
/*      */   }
/*      */   
/*      */   static Fighter getFighter(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*      */   {
/*  235 */     switch (xFighter.getType()) {
/*      */     case 1: 
/*  237 */       if (Fighter.isCloneRole(xFighter)) {
/*  238 */         return new CloneFighterRole(fighterid, xFighter, fightGroup);
/*      */       }
/*  240 */       return new FighterRole(fighterid, xFighter, fightGroup);
/*      */     case 4: 
/*  242 */       if (Fighter.isClonePet(xFighter)) {
/*  243 */         return new CloneFighterPet(fighterid, xFighter, fightGroup);
/*      */       }
/*  245 */       return new FighterPet(fighterid, xFighter, fightGroup);
/*      */     case 8: 
/*  247 */       if (FighterMonster.isNpcMonseter(xFighter))
/*  248 */         return new FighterNpcMonster(fighterid, xFighter, fightGroup);
/*  249 */       if (FighterMonster.isInvincibleMonster(xFighter)) {
/*  250 */         return new FighterInvincibleMonster(fighterid, xFighter, fightGroup);
/*      */       }
/*  252 */       return new FighterMonster(fighterid, xFighter, fightGroup);
/*      */     
/*      */     case 2: 
/*  255 */       if (Fighter.isCloneFellow(xFighter)) {
/*  256 */         return new CloneFighterFellow(fighterid, xFighter, fightGroup);
/*      */       }
/*  258 */       return new FighterFellow(fighterid, xFighter, fightGroup);
/*      */     case 16: 
/*  260 */       if (Fighter.isCloneChild(xFighter)) {
/*  261 */         return new CloneFighterChild(fighterid, xFighter, fightGroup);
/*      */       }
/*  263 */       return new FighterChild(fighterid, xFighter, fightGroup);
/*      */     }
/*  265 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startPVEFight(long fightid, xbean.Fight xFight, List<Long> roleids, int id)
/*      */   {
/*  278 */     xFight.setType(0);
/*      */     
/*  280 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  281 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  284 */     Fight fight = new PVEFight(fightid, xFight);
/*      */     
/*  286 */     Map<Integer, Monster> npcMonsterMap = getNpcMonsters(roleids, id, xFight.getCfgtype());
/*  287 */     fight.getActiveTeam().addFightGroupRoles(id, npcMonsterMap, roleids);
/*      */     
/*  289 */     Map<Integer, Monster> piorPos2Monster = getMonsters(roleids, id, xFight.getCfgtype());
/*  290 */     fight.getPassiveTeam().addFightGroupMonster(id, piorPos2Monster);
/*      */     
/*  292 */     fight.zhenfaRestrict();
/*      */     
/*  294 */     fight.start();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startPVInvincibleMonster(long fightid, xbean.Fight xFight, List<Long> roleids, int id, int hpRate)
/*      */   {
/*  308 */     xFight.setType(3);
/*      */     
/*  310 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  311 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  314 */     Fight fight = new PVIMonsterFight(fightid, xFight);
/*      */     
/*  316 */     Map<Integer, Monster> npcMonsterMap = getNpcMonsters(roleids, id, xFight.getCfgtype());
/*  317 */     fight.getActiveTeam().addFightGroupRoles(id, npcMonsterMap, roleids);
/*      */     
/*  319 */     Map<Integer, Monster> piorPos2Monster = getMonsters(roleids, id, xFight.getCfgtype());
/*  320 */     fight.getPassiveTeam().addFightGroupInvincibleMonster(id, piorPos2Monster, hpRate);
/*      */     
/*  322 */     fight.zhenfaRestrict();
/*      */     
/*  324 */     fight.start();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startPVPFight(long fightid, xbean.Fight xFight, List<Long> activeRoles, List<Long> passiveRoles)
/*      */   {
/*  336 */     xFight.setType(1);
/*      */     
/*  338 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  339 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  342 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  343 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  346 */     Fight fight = new PVPFight(fightid, xFight);
/*      */     
/*  348 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(xFight.getCfgtype());
/*      */     
/*  350 */     fight.getActiveTeam().addFightGroupRoles(activeRoles, fightTypeCfg.canCarryFellow);
/*      */     
/*  352 */     fight.getPassiveTeam().addFightGroupRoles(passiveRoles, fightTypeCfg.canCarryFellow);
/*      */     
/*  354 */     fight.zhenfaRestrict();
/*      */     
/*  356 */     fight.start();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void startPVPFightWithTeamDisposition(long fightid, xbean.Fight xFight, List<Long> activeRoles, List<Long> passiveRoles)
/*      */   {
/*  369 */     xFight.setType(1);
/*      */     
/*  371 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  372 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  375 */     for (Iterator i$ = passiveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  376 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  379 */     Fight fight = new PVPFight(fightid, xFight);
/*      */     
/*  381 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(xFight.getCfgtype());
/*      */     
/*  383 */     fight.getActiveTeam().addFightGroupRoleWithTeamDisposition(activeRoles, fightTypeCfg.canCarryFellow);
/*      */     
/*  385 */     fight.getPassiveTeam().addFightGroupRoleWithTeamDisposition(passiveRoles, fightTypeCfg.canCarryFellow);
/*      */     
/*  387 */     fight.zhenfaRestrict();
/*      */     
/*  389 */     fight.start();
/*      */   }
/*      */   
/*      */   static void startPVCFight(long fightid, xbean.Fight xFight, List<Long> activeRoles, List<Long> passiveRoles, int pvcCfgid)
/*      */   {
/*  394 */     xFight.setType(2);
/*      */     
/*  396 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  397 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  400 */     Fight fight = new PVCFight(fightid, xFight);
/*      */     
/*  402 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(xFight.getCfgtype());
/*      */     
/*  404 */     fight.getActiveTeam().addFightGroupRoles(activeRoles, fightTypeCfg.canCarryFellow);
/*      */     
/*  406 */     fight.getPassiveTeam().addPVCFightGroupRoles(((Long)activeRoles.get(0)).longValue(), passiveRoles, pvcCfgid, fightTypeCfg.canCarryFellow);
/*      */     
/*      */ 
/*  409 */     fight.zhenfaRestrict();
/*      */     
/*  411 */     fight.start();
/*      */   }
/*      */   
/*      */   static void startPVCFightWithRobot(long fightid, xbean.Fight xFight, List<Long> activeRoles, List<Long> passiveRoles, int robotClassid)
/*      */   {
/*  416 */     xFight.setType(2);
/*      */     
/*  418 */     for (Iterator i$ = activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  419 */       Role2fight.insert(Long.valueOf(roleid), Long.valueOf(fightid));
/*      */     }
/*      */     
/*  422 */     Fight fight = new PVCFight(fightid, xFight);
/*      */     
/*  424 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(xFight.getCfgtype());
/*      */     
/*  426 */     fight.getActiveTeam().addFightGroupRoles(activeRoles, fightTypeCfg.canCarryFellow);
/*      */     
/*  428 */     fight.getPassiveTeam().addPVCFightGroupRoleWithRobot(((Long)activeRoles.get(0)).longValue(), passiveRoles, robotClassid, fightTypeCfg.canCarryFellow);
/*      */     
/*      */ 
/*  431 */     fight.zhenfaRestrict();
/*      */     
/*  433 */     fight.start();
/*      */   }
/*      */   
/*      */   static void startPetCVCRobotFight(long fightid, xbean.Fight xFight, FightInterface.PetFightInfo activeFightInfo, FightInterface.PetFightRobotInfo passiveFightInfo)
/*      */   {
/*  438 */     xFight.setType(4);
/*      */     
/*  440 */     Fight fight = new PetCVCFight(fightid, xFight);
/*      */     
/*  442 */     fight.getActiveTeam().addFightGroupClonePet(activeFightInfo);
/*      */     
/*  444 */     fight.getPassiveTeam().addFightGroupCloneRobotPet(passiveFightInfo);
/*      */     
/*  446 */     fight.start();
/*      */   }
/*      */   
/*      */   static void startPetCVCFight(long fightid, xbean.Fight xFight, FightInterface.PetFightInfo activeFightInfo, FightInterface.PetFightInfo passiveFightInfo)
/*      */   {
/*  451 */     xFight.setType(4);
/*      */     
/*  453 */     Fight fight = new PetCVCFight(fightid, xFight);
/*      */     
/*  455 */     fight.getActiveTeam().addFightGroupClonePet(activeFightInfo);
/*      */     
/*  457 */     fight.getPassiveTeam().addFightGroupClonePet(passiveFightInfo);
/*      */     
/*  459 */     fight.start();
/*      */   }
/*      */   
/*      */   static void triggerPVPFailEvent(FightContext context, List<Long> activeRoles, List<Long> passiveRoles) {
/*  463 */     PVPFightFailArg pvpFightFailArg = new PVPFightFailArg(context);
/*  464 */     pvpFightFailArg.activeRoles.addAll(activeRoles);
/*  465 */     pvpFightFailArg.passiveRoles.addAll(passiveRoles);
/*  466 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new PVPFightFail(), pvpFightFailArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Integer, Monster> getNpcMonsters(List<Long> roles, int id, int fightCfgType)
/*      */   {
/*  480 */     Map<Integer, Monster> npcMonsterMap = new HashMap();
/*  481 */     SFightCfg fightCfg = SFightCfg.get(id);
/*  482 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(fightCfgType);
/*  483 */     int level = getLevel(roles, fightCfg, fightTypeCfg);
/*      */     
/*  485 */     List<Integer> posPiorList = getPosPiorList();
/*      */     
/*  487 */     int firstPosPior = ((Integer)posPiorList.remove(0)).intValue();
/*      */     
/*  489 */     for (int i = 0; i < fightCfg.roleRowNpcCfgs.size(); i++) {
/*  490 */       int monsterFightCfgID = ((Integer)fightCfg.roleRowNpcCfgs.get(i)).intValue();
/*  491 */       if (monsterFightCfgID > 0)
/*      */       {
/*      */ 
/*  494 */         int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(monsterFightCfgID);
/*  495 */         if (monsterid >= 0)
/*      */         {
/*      */ 
/*  498 */           Monster m = MonsterManager.getInstance().getMonsterById(monsterid, level);
/*  499 */           int pos = ((Integer)posPiorList.get(i)).intValue() + 1 * getPosNumberPerRow();
/*  500 */           npcMonsterMap.put(Integer.valueOf(pos), m);
/*      */         }
/*      */       } }
/*  503 */     for (int i = 0; i < fightCfg.petRowNpcCfgs.size(); i++) {
/*  504 */       int monsterFightCfgID = ((Integer)fightCfg.petRowNpcCfgs.get(i)).intValue();
/*  505 */       if (monsterFightCfgID > 0)
/*      */       {
/*      */ 
/*  508 */         int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(monsterFightCfgID);
/*  509 */         if (monsterid >= 0)
/*      */         {
/*      */ 
/*  512 */           Monster m = MonsterManager.getInstance().getMonsterById(monsterid, level);
/*  513 */           int pos = ((Integer)posPiorList.get(i)).intValue() + 0 * getPosNumberPerRow();
/*  514 */           npcMonsterMap.put(Integer.valueOf(pos), m);
/*      */         }
/*      */       } }
/*  517 */     if (fightCfg.npcFightCfg12 > 0) {
/*  518 */       int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(fightCfg.npcFightCfg12);
/*  519 */       if (monsterid > 0) {
/*  520 */         Monster m = MonsterManager.getInstance().getMonsterById(monsterid, level);
/*  521 */         int pos = firstPosPior + 2 * getPosNumberPerRow();
/*  522 */         npcMonsterMap.put(Integer.valueOf(pos), m);
/*      */       }
/*      */     }
/*      */     
/*  526 */     return npcMonsterMap;
/*      */   }
/*      */   
/*      */   static int getFirstMonstByCfgid(int fightcfgid)
/*      */   {
/*  531 */     SFightCfg fightCfg = SFightCfg.get(fightcfgid);
/*  532 */     if (fightCfg == null) {
/*  533 */       logger.error("战斗配置id不存在：" + fightcfgid);
/*  534 */       return -1;
/*      */     }
/*      */     
/*      */ 
/*  538 */     if (fightCfg.roleNum2MonsterNumCfg == 0)
/*  539 */       for (int i = 0; i < fightCfg.monsterCfgs.size(); i++) {
/*  540 */         int monsterFightCfgID = ((Integer)fightCfg.monsterCfgs.get(i)).intValue();
/*  541 */         if (monsterFightCfgID > 0)
/*      */         {
/*      */ 
/*  544 */           int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(monsterFightCfgID);
/*  545 */           if (monsterid >= 0)
/*      */           {
/*      */ 
/*  548 */             return monsterid; }
/*      */         }
/*      */       } else
/*  551 */       for (int i = 0; i < fightCfg.monsterCfgs.size(); i++) {
/*  552 */         int monsterFightCfgID = ((Integer)fightCfg.monsterCfgs.get(i)).intValue();
/*  553 */         if (monsterFightCfgID > 0)
/*      */         {
/*      */ 
/*  556 */           int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(monsterFightCfgID);
/*  557 */           if (monsterid >= 0)
/*      */           {
/*      */ 
/*  560 */             return monsterid; }
/*      */         }
/*      */       }
/*  563 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Integer, Monster> getMonsters(List<Long> roles, int id, int fightCfgType)
/*      */   {
/*  577 */     TreeMap<Integer, Monster> piorPos2Monster = new TreeMap();
/*      */     
/*  579 */     SFightCfg fightCfg = SFightCfg.get(id);
/*  580 */     if (fightCfg == null) {
/*  581 */       throw new RuntimeException("战斗配置id不存在：" + id);
/*      */     }
/*  583 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(fightCfgType);
/*      */     
/*  585 */     int level = getLevel(roles, fightCfg, fightTypeCfg);
/*      */     
/*      */ 
/*  588 */     if (fightCfg.roleNum2MonsterNumCfg == 0) {
/*  589 */       for (int i = 0; i < fightCfg.monsterCfgs.size(); i++) {
/*  590 */         int monsterFightCfgID = ((Integer)fightCfg.monsterCfgs.get(i)).intValue();
/*  591 */         if (monsterFightCfgID > 0)
/*      */         {
/*      */ 
/*  594 */           int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(monsterFightCfgID);
/*  595 */           if (monsterid >= 0)
/*      */           {
/*      */ 
/*  598 */             Monster m = MonsterManager.getInstance().getMonsterById(monsterid, level);
/*  599 */             piorPos2Monster.put(Integer.valueOf(i), m);
/*      */           }
/*      */         }
/*  602 */       } } else { int monsterNum = FightConfigManager.getInstance().getMonsterNum(fightCfg.roleNum2MonsterNumCfg, roles.size());
/*      */       
/*  604 */       if (monsterNum <= 0) {
/*  605 */         logger.error("怪物战斗无法生成怪物：id=" + id + ",roles=" + roles);
/*  606 */         return piorPos2Monster;
/*      */       }
/*  608 */       for (int i = 0; (i < fightCfg.monsterCfgs.size()) && (monsterNum > 0); i++) {
/*  609 */         int monsterFightCfgID = ((Integer)fightCfg.monsterCfgs.get(i)).intValue();
/*  610 */         if (monsterFightCfgID > 0)
/*      */         {
/*      */ 
/*  613 */           int monsterid = FightConfigManager.getInstance().randomGenerateMonsterID(monsterFightCfgID);
/*  614 */           if (monsterid >= 0)
/*      */           {
/*      */ 
/*  617 */             Monster m = MonsterManager.getInstance().getMonsterById(monsterid, level);
/*  618 */             piorPos2Monster.put(Integer.valueOf(i), m);
/*  619 */             monsterNum--;
/*      */           }
/*      */         }
/*      */       } }
/*  623 */     return piorPos2Monster;
/*      */   }
/*      */   
/*      */   private static int getLevel(List<Long> roles, SFightCfg fightCfg, SFightTypeCfg fightTypeCfg) {
/*  627 */     int level = 0;
/*  628 */     Iterator i$; int minLevel; Iterator i$; switch (fightCfg.levelType) {
/*      */     case 1: 
/*  630 */       level = RoleInterface.getLevel(((Long)roles.get(0)).longValue());
/*  631 */       break;
/*      */     case 2: 
/*  633 */       int totalLevel = 0;
/*  634 */       int maxLevel = 0;
/*  635 */       for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  636 */         int tmpLevel = RoleInterface.getLevel(roleid);
/*  637 */         totalLevel += tmpLevel;
/*  638 */         if (tmpLevel > maxLevel) {
/*  639 */           maxLevel = tmpLevel;
/*      */         }
/*      */       }
/*  642 */       level = totalLevel / roles.size();
/*  643 */       if (fightTypeCfg.hasNewer) {
/*  644 */         level = Math.max(maxLevel - fightTypeCfg.n, level);
/*      */       }
/*      */       break;
/*      */     case 3: 
/*  648 */       for (i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  649 */         int tmpLevel = RoleInterface.getLevel(roleid);
/*  650 */         if (level == 0) {
/*  651 */           level = tmpLevel;
/*  652 */         } else if (tmpLevel > level) {
/*  653 */           level = tmpLevel;
/*      */         }
/*      */       }
/*  656 */       break;
/*      */     
/*      */     case 4: 
/*  659 */       minLevel = 0;
/*  660 */       for (i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  661 */         int tmpLevel = RoleInterface.getLevel(roleid);
/*  662 */         if (minLevel == 0) {
/*  663 */           minLevel = tmpLevel;
/*  664 */         } else if (tmpLevel < minLevel) {
/*  665 */           minLevel = tmpLevel;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     
/*  671 */     if (level < fightCfg.levelMin) {
/*  672 */       level = fightCfg.levelMin;
/*      */     }
/*  674 */     if (level > fightCfg.levelMax) {
/*  675 */       level = fightCfg.levelMax;
/*      */     }
/*  677 */     return level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void notifyOperate(long roleid, int fighterid)
/*      */   {
/*  687 */     SOperateRes res = new SOperateRes();
/*  688 */     res.fighterid = fighterid;
/*  689 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void notifyOperate(long roleid)
/*      */   {
/*  699 */     SAutoOperateNotify notify = new SAutoOperateNotify();
/*  700 */     OnlineManager.getInstance().send(roleid, notify);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void closeFight(long roleid, boolean isWin)
/*      */   {
/*  709 */     Fight fight = getFightByRoleid(roleid);
/*  710 */     if (fight == null) {
/*  711 */       return;
/*      */     }
/*  713 */     Set<Long> lockRoles = fight.getLockRoles();
/*  714 */     Lockeys.lock(Basic.getTable(), lockRoles);
/*  715 */     fight.fightEndOnTeamWin(isWin);
/*      */   }
/*      */   
/*      */   static void closeFightWithRoleWin(long roleid, boolean isWin) {
/*  719 */     Fight fight = getFightByRoleid(roleid);
/*  720 */     if (fight == null) {
/*  721 */       return;
/*      */     }
/*  723 */     Set<Long> lockRoles = fight.getLockRoles();
/*  724 */     Lockeys.lock(Basic.getTable(), lockRoles);
/*  725 */     Fighter fighter = fight.getFighterByRoleId(roleid);
/*  726 */     if (fighter == null) {
/*  727 */       return;
/*      */     }
/*  729 */     boolean isRoleActive = fight.isInActiveTime(fighter.getid());
/*  730 */     boolean activeWin = isWin;
/*  731 */     if (!isRoleActive) {
/*  732 */       activeWin = !isWin;
/*      */     }
/*  734 */     if (GameServer.logger().isDebugEnabled()) {
/*  735 */       GameServer.logger().debug(String.format("[fight]FightManager.closeFightWithRoleWin@final param|roleid=%d,isRoleActive=%b,activeWin=%b", new Object[] { Long.valueOf(roleid), Boolean.valueOf(isRoleActive), Boolean.valueOf(activeWin) }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  742 */     fight.fightEndOnTeamWin(activeWin);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqObserveFight(long observerRoleid, long beObservedRoleid)
/*      */   {
/*  757 */     Fight fight = getFightByRoleid(beObservedRoleid);
/*  758 */     if (fight == null) {
/*  759 */       sendNormalResult(observerRoleid, 100, new String[0]);
/*  760 */       return false;
/*      */     }
/*  762 */     return observeFight(observerRoleid, fight, beObservedRoleid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqObserveFightByOthers(long observerRoleid, long beObservedRoleid, long fightid, int observeTeamType)
/*      */   {
/*  773 */     Fight fight = getFight(fightid);
/*  774 */     if (fight == null) {
/*  775 */       sendNormalResult(observerRoleid, 104, new String[0]);
/*  776 */       return false;
/*      */     }
/*  778 */     return observeFightByOthers(observerRoleid, beObservedRoleid, fight, observeTeamType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static boolean observeFightByOthers(long observerRoleid, long beObservedRoleid, Fight fight, int observeTeamType)
/*      */   {
/*  785 */     Set<Long> lockedRoleSet = fight.getLockRoles();
/*  786 */     lockedRoleSet.addAll(fight.getDisObservers());
/*  787 */     lockedRoleSet.add(Long.valueOf(observerRoleid));
/*  788 */     Lockeys.lock(Basic.getTable(), lockedRoleSet);
/*  789 */     if (!observeCheck(observerRoleid, fight)) {
/*  790 */       return false;
/*      */     }
/*  792 */     fight.addObserver(observerRoleid, observeTeamType);
/*  793 */     ObserveFight xObserveFight = Pod.newObserveFight();
/*  794 */     xObserveFight.setFightid(fight.fightid);
/*  795 */     xObserveFight.setObservetype(0);
/*  796 */     xObserveFight.setObservevalue(beObservedRoleid);
/*  797 */     xObserveFight.setObserveteamtype(observeTeamType);
/*  798 */     Role2observefight.insert(Long.valueOf(observerRoleid), xObserveFight);
/*      */     
/*      */ 
/*  801 */     RoleObserveStart roleObserveStart = new RoleObserveStart();
/*  802 */     TriggerEventsManger.getInstance().triggerEvent(roleObserveStart, Long.valueOf(observerRoleid));
/*      */     
/*  804 */     SEnterFightBrd enterFightBrd = new SEnterFightBrd();
/*  805 */     fight.fillFightBean(enterFightBrd.fight);
/*  806 */     OnlineManager.getInstance().send(observerRoleid, enterFightBrd);
/*  807 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqObserveFight(long observerRoleid, long fightid, long monsterInstanceid)
/*      */   {
/*  824 */     Fight fight = getFight(fightid);
/*  825 */     if (fight == null) {
/*  826 */       sendNormalResult(observerRoleid, 104, new String[0]);
/*  827 */       return false;
/*      */     }
/*  829 */     return observeMonsterFight(observerRoleid, fight, monsterInstanceid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean observeMonsterFight(long observerRoleid, Fight fight, long monsterInstanceid)
/*      */   {
/*  842 */     Set<Long> lockedRoleSet = fight.getLockRoles();
/*  843 */     lockedRoleSet.addAll(fight.getDisObservers());
/*  844 */     lockedRoleSet.add(Long.valueOf(observerRoleid));
/*  845 */     Lockeys.lock(Basic.getTable(), lockedRoleSet);
/*  846 */     if (!observeCheck(observerRoleid, fight)) {
/*  847 */       return false;
/*      */     }
/*  849 */     fight.addObserver(observerRoleid, 1);
/*  850 */     ObserveFight xObserveFight = Pod.newObserveFight();
/*  851 */     xObserveFight.setFightid(fight.fightid);
/*  852 */     xObserveFight.setObservetype(1);
/*  853 */     xObserveFight.setObservevalue(monsterInstanceid);
/*  854 */     Role2observefight.insert(Long.valueOf(observerRoleid), xObserveFight);
/*      */     
/*      */ 
/*  857 */     RoleObserveStart roleObserveStart = new RoleObserveStart();
/*  858 */     TriggerEventsManger.getInstance().triggerEvent(roleObserveStart, Long.valueOf(observerRoleid));
/*      */     
/*  860 */     SEnterFightBrd enterFightBrd = new SEnterFightBrd();
/*  861 */     fight.fillFightBean(enterFightBrd.fight);
/*  862 */     OnlineManager.getInstance().send(observerRoleid, enterFightBrd);
/*  863 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean observeCheck(long observerRoleid, Fight fight) {
/*  867 */     if (Role2observefight.select(Long.valueOf(observerRoleid)) != null)
/*      */     {
/*  869 */       return false;
/*      */     }
/*  871 */     if (FightInterface.isInFight(observerRoleid)) {
/*  872 */       sendNormalResult(observerRoleid, 101, new String[0]);
/*  873 */       return false;
/*      */     }
/*      */     
/*  876 */     if (fight.isObserverToLimit()) {
/*  877 */       sendNormalResult(observerRoleid, 103, new String[0]);
/*  878 */       return false;
/*      */     }
/*  880 */     if (!RoleStatusInterface.setStatus(observerRoleid, 10, true)) {
/*  881 */       return false;
/*      */     }
/*  883 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean observeFight(long observerRoleid, Fight fight, long fightTeamRoleid)
/*      */   {
/*  894 */     Set<Long> lockedRoleSet = fight.getLockRoles();
/*  895 */     lockedRoleSet.addAll(fight.getDisObservers());
/*  896 */     lockedRoleSet.add(Long.valueOf(observerRoleid));
/*  897 */     Lockeys.lock(Basic.getTable(), lockedRoleSet);
/*  898 */     if (!observeCheck(observerRoleid, fight)) {
/*  899 */       return false;
/*      */     }
/*  901 */     int teamType = 0;
/*  902 */     FightGroupRole groupRole = fight.getGroupRole(fightTeamRoleid);
/*  903 */     if (groupRole == null) {
/*  904 */       Integer tempTeamType = fight.getObserverTeamType(fightTeamRoleid);
/*  905 */       if (tempTeamType != null) {
/*  906 */         teamType = tempTeamType.intValue();
/*      */       }
/*  908 */     } else if (!groupRole.fightTeam.isActive) {
/*  909 */       teamType = 1;
/*      */     }
/*  911 */     fight.addObserver(observerRoleid, teamType);
/*  912 */     ObserveFight xObserveFight = Pod.newObserveFight();
/*  913 */     xObserveFight.setFightid(fight.fightid);
/*  914 */     xObserveFight.setObservetype(0);
/*  915 */     xObserveFight.setObservevalue(fightTeamRoleid);
/*  916 */     xObserveFight.setObserveteamtype(teamType);
/*  917 */     Role2observefight.insert(Long.valueOf(observerRoleid), xObserveFight);
/*      */     
/*      */ 
/*  920 */     RoleObserveStart roleObserveStart = new RoleObserveStart();
/*  921 */     TriggerEventsManger.getInstance().triggerEvent(roleObserveStart, Long.valueOf(observerRoleid));
/*      */     
/*  923 */     SEnterFightBrd enterFightBrd = new SEnterFightBrd();
/*  924 */     fight.fillFightBean(enterFightBrd.fight);
/*  925 */     OnlineManager.getInstance().send(observerRoleid, enterFightBrd);
/*  926 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onPetJoinFight(long roleid, long petid)
/*      */   {
/*  936 */     FightCache xCache = Rolefightcache.get(Long.valueOf(roleid));
/*  937 */     Iterator i$; if ((xCache != null) && 
/*  938 */       (xCache.getIsauto())) {
/*  939 */       if (xCache.getPet_default_skills().containsKey(Long.valueOf(petid))) {
/*  940 */         return;
/*      */       }
/*  942 */       List<Integer> skillids = PetInterface.getPetSkillList(roleid, petid);
/*  943 */       for (i$ = skillids.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*  944 */         SSkillCfg skillCfg = SSkillCfg.get(skillid);
/*  945 */         if (skillCfg.canAuto)
/*      */         {
/*      */ 
/*  948 */           xCache.getPet_default_skills().put(Long.valueOf(petid), Integer.valueOf(skillid));
/*  949 */           FightInterface.syncAutoState(roleid);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isCommonSkill(int skillid, int occupation)
/*      */   {
/*  963 */     return (skillid == SFightConsts.getInstance().DEFENCE_SKILL) || (skillid == getNormalAttack(occupation));
/*      */   }
/*      */   
/*      */   static int getNormalAttack(int occupation) {
/*  967 */     SOccupationNormalSkillCfg normalSkillCfg = SOccupationNormalSkillCfg.get(occupation);
/*  968 */     if (normalSkillCfg == null) {
/*  969 */       return SFightConsts.getInstance().ATTACK_SKILL;
/*      */     }
/*  971 */     return normalSkillCfg.normalSkillid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void cancelAutoFight(long roleid, FightCache xFightCache)
/*      */   {
/*  982 */     if (xFightCache == null) {
/*  983 */       return;
/*      */     }
/*  985 */     if (!xFightCache.getIsauto()) {
/*  986 */       return;
/*      */     }
/*  988 */     xFightCache.setIsauto(false);
/*  989 */     FightInterface.syncAutoState(roleid, xFightCache);
/*      */   }
/*      */   
/*      */   static void registerObserveFight(long worldid, ObserveFightChecker observeFightChecker) {
/*  993 */     if (OBSERVEFIGHTCHECK_MAP.containsKey(Long.valueOf(worldid))) {
/*  994 */       throw new RuntimeException("重复注册了检查能否观战的世界id:" + worldid);
/*      */     }
/*  996 */     OBSERVEFIGHTCHECK_MAP.put(Long.valueOf(worldid), observeFightChecker);
/*      */   }
/*      */   
/*      */   static void unRegisterObserveFight(long worldid) {
/* 1000 */     OBSERVEFIGHTCHECK_MAP.remove(Long.valueOf(worldid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendNormalResult(long roleid, int ret, String... args)
/*      */   {
/* 1011 */     SFightNormalResult fightNormalResult = new SFightNormalResult();
/* 1012 */     fillNormalResult(fightNormalResult, ret, args);
/* 1013 */     OnlineManager.getInstance().sendAtOnce(roleid, fightNormalResult);
/*      */   }
/*      */   
/*      */   static void sendNormalResult(long roleid, int ret, List<String> args) {
/* 1017 */     SFightNormalResult fightNormalResult = new SFightNormalResult();
/* 1018 */     fightNormalResult.result = ret;
/* 1019 */     if (args != null) {
/* 1020 */       fightNormalResult.args.addAll(args);
/*      */     }
/* 1022 */     OnlineManager.getInstance().sendAtOnce(roleid, fightNormalResult);
/*      */   }
/*      */   
/*      */   static void fillNormalResult(SFightNormalResult fightNormalResult, int ret, String... args) {
/* 1026 */     fightNormalResult.result = ret;
/* 1027 */     for (String arg : args) {
/* 1028 */       fightNormalResult.args.add(arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logPveFight(long roleid, int fightReason, long fightid, int fightCfgid, int monsterLevel, int teamNum, boolean activeWin, int round, int deadTimes)
/*      */   {
/* 1055 */     int platform = RoleInterface.getPlatform(roleid);
/* 1056 */     String channel = RoleInterface.getChannel(roleid);
/* 1057 */     String mac = RoleInterface.getMac(roleid);
/*      */     
/* 1059 */     String userid = RoleInterface.getUserId(roleid);
/* 1060 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1061 */     int result = 0;
/* 1062 */     if (activeWin) {
/* 1063 */       result = 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1068 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fightReason), Long.valueOf(fightid), Integer.valueOf(fightCfgid), Integer.valueOf(monsterLevel), Integer.valueOf(teamNum), Integer.valueOf(result), Integer.valueOf(round), Integer.valueOf(deadTimes) });
/*      */     
/* 1070 */     LogManager.getInstance().addLog("pvefight", logStr);
/*      */   }
/*      */   
/*      */   static void tLogPveFight(long roleid, int fightReason, long fightid, int fightCfgid, int monsterLevel, int teamNum, boolean activeWin, int round, int deadTimes)
/*      */   {
/* 1075 */     String userid = RoleInterface.getUserId(roleid);
/* 1076 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1077 */     int result = 0;
/* 1078 */     if (activeWin) {
/* 1079 */       result = 1;
/*      */     }
/*      */     
/* 1082 */     int fightValue = RoleInterface.getFightValue(roleid);
/* 1083 */     int mFFightValue = RoleInterface.getRoleMFValue(roleid);
/*      */     
/*      */ 
/*      */ 
/* 1087 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fightReason), Long.valueOf(fightid), Integer.valueOf(fightCfgid), Integer.valueOf(monsterLevel), Integer.valueOf(teamNum), Integer.valueOf(result), Integer.valueOf(round), Integer.valueOf(deadTimes), Integer.valueOf(fightValue), Integer.valueOf(mFFightValue) });
/*      */     
/* 1089 */     TLogManager.getInstance().addLog(roleid, "PveFight", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logPVPFight(long roleid, int fightType, int fightReason, long fightid, int teamType, int teamNum, boolean win, int round, int deadTimes, int fightTime)
/*      */   {
/* 1108 */     String userid = RoleInterface.getUserId(roleid);
/* 1109 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1110 */     int result = 0;
/* 1111 */     if (win) {
/* 1112 */       result = 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1117 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fightType), Integer.valueOf(fightReason), Long.valueOf(fightid), Integer.valueOf(teamType), Integer.valueOf(teamNum), Integer.valueOf(result), Integer.valueOf(round), Integer.valueOf(deadTimes), Integer.valueOf(fightTime) });
/*      */     
/* 1119 */     LogManager.getInstance().addLog("pvpfight", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tLogPVPFight(long roleid, int fightType, int fightReason, long fightid, int teamType, int teamNum, boolean win, int round, int deadTimes, int fightTime)
/*      */   {
/* 1135 */     String userid = RoleInterface.getUserId(roleid);
/* 1136 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 1137 */     int result = 0;
/* 1138 */     if (win) {
/* 1139 */       result = 1;
/*      */     }
/*      */     
/* 1142 */     int fightValue = RoleInterface.getFightValue(roleid);
/* 1143 */     int mFFightValue = RoleInterface.getRoleMFValue(roleid);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1148 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fightType), Integer.valueOf(fightReason), Long.valueOf(fightid), Integer.valueOf(teamType), Integer.valueOf(teamNum), Integer.valueOf(result), Integer.valueOf(round), Integer.valueOf(deadTimes), Integer.valueOf(fightTime), Integer.valueOf(fightValue), Integer.valueOf(mFFightValue) });
/*      */     
/*      */ 
/* 1151 */     TLogManager.getInstance().addLog(userid, "PVPFight", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRoundFlow(long roleid, int fightType, int fightid, boolean activeWin, int timeSec, int round)
/*      */   {
/* 1159 */     int result = 0;
/* 1160 */     if (activeWin) {
/* 1161 */       result = 1;
/*      */     }
/* 1163 */     int level = RoleInterface.getLevel(roleid);
/*      */     
/*      */ 
/* 1166 */     String logStr = String.format("%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(fightid), Integer.valueOf(fightType), Integer.valueOf(0), Integer.valueOf(timeSec), Integer.valueOf(result), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(round), Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(round) });
/*      */     
/* 1168 */     TLogManager.getInstance().addLog(roleid, "RoundFlow", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */   static void logRoundFlow(long roleid, int fightType, int fightid, boolean activeWin, int timeSec, int round)
/*      */   {
/* 1174 */     int result = 0;
/* 1175 */     if (activeWin) {
/* 1176 */       result = 1;
/*      */     }
/* 1178 */     int level = RoleInterface.getLevel(roleid);
/*      */     
/*      */ 
/* 1181 */     String logStr = String.format("%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(fightid), Integer.valueOf(fightType), Integer.valueOf(0), Integer.valueOf(timeSec), Integer.valueOf(result), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(round), Long.valueOf(roleid), Integer.valueOf(level), Integer.valueOf(round) });
/*      */     
/* 1183 */     LogManager.getInstance().addLog("roundflow", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogFightSecurity(String userid, long roleid, int partnerCount, int partnerBattlePoint, int petLevel, int petBattlePoint, int fightReason, int fightEndReason, int fightcfgid, int battleTime, int battleCD, int roundCount, int roundActionMax, int actionTotal, long battleStartTimeMil)
/*      */   {
/* 1193 */     tlogFightSecurity(userid, roleid, partnerCount, partnerBattlePoint, petLevel, petBattlePoint, fightReason, fightEndReason, fightcfgid, battleTime, battleCD, roundCount, roundActionMax, actionTotal, battleStartTimeMil, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogFightSecurity(String userid, long roleid, final int partnerCount, final int partnerBattlePoint, final int petLevel, int petBattlePoint, final int fightReason, final int fightEndReason, final int fightcfgid, final int battleTime, final int battleCD, final int roundCount, final int roundActionMax, final int actionTotal, long battleStartTimeMil, Map<Long, AwardModel> awards)
/*      */   {
/* 1211 */     final int battleID = (int)(battleStartTimeMil / 1000L);
/* 1212 */     final String roleName = RoleInterface.getName(roleid);
/* 1213 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 1214 */     final String dtEventStartTime = sdf.format(Long.valueOf(battleStartTimeMil));
/* 1215 */     final String dtEventEndTime = sdf.format(Long.valueOf(battleStartTimeMil + battleTime));
/* 1216 */     final long yuanBao = QingfuInterface.getYuanbao(userid, false);
/* 1217 */     final long gold = RoleInterface.getGold(roleid);
/* 1218 */     long silver = RoleInterface.getSilver(roleid);
/* 1219 */     final int roleLevel = RoleInterface.getLevel(roleid);
/* 1220 */     int roleCurExp = RoleInterface.getCurExp(roleid);
/* 1221 */     final long reserveExp = StorageExpInterface.getCurCanUseStorageExp(roleid);
/* 1222 */     int roleBattlePoiont = RoleInterface.getFightValue(roleid);
/* 1223 */     final int mapId = MapInterface.getRoleMapId(roleid);
/* 1224 */     MapInterface.getRolePosition(roleid, new MapCallback()
/*      */     {
/*      */       public boolean onResult(Map<Long, Position> result)
/*      */       {
/* 1228 */         Position position = null;
/* 1229 */         if (result != null) {
/* 1230 */           position = (Position)result.get(Long.valueOf(this.val$roleid));
/*      */         }
/* 1232 */         int x = 0;
/* 1233 */         int y = 0;
/* 1234 */         if (position != null) {
/* 1235 */           x = position.getX();
/* 1236 */           y = position.getY();
/*      */         }
/* 1238 */         int awardRoleExp = 0;
/* 1239 */         int awardPetExp = 0;
/* 1240 */         long awardYuanBao = 0L;
/* 1241 */         long awardGold = 0L;
/* 1242 */         long awardSilver = 0L;
/* 1243 */         String awardItemid = String.valueOf(0);
/* 1244 */         String awardItemUID = String.valueOf(0);
/* 1245 */         String awardItemCount = String.valueOf(0);
/* 1246 */         if (battleID != null) {
/* 1247 */           AwardModel awardModel = (AwardModel)battleID.get(Long.valueOf(this.val$roleid));
/* 1248 */           if (awardModel != null) {
/* 1249 */             awardRoleExp = awardModel.getRoleExp();
/* 1250 */             awardPetExp = awardModel.getPetExp();
/* 1251 */             awardYuanBao = awardModel.getYuanbao();
/* 1252 */             awardGold = awardModel.getGold();
/* 1253 */             awardSilver = awardModel.getSilver();
/*      */             
/* 1255 */             Map<Integer, Integer> item2Count = awardModel.getItemMap();
/* 1256 */             if ((item2Count != null) && (item2Count.size() > 0)) {
/* 1257 */               boolean first = true;
/* 1258 */               StringBuilder awardItemidBuilder = new StringBuilder();
/* 1259 */               StringBuilder awardItemCountBuilder = new StringBuilder();
/* 1260 */               StringBuilder awardItemUIDBuilder = new StringBuilder();
/* 1261 */               for (Map.Entry<Integer, Integer> entry : item2Count.entrySet()) {
/* 1262 */                 if (!first) {
/* 1263 */                   awardItemidBuilder.append(",");
/* 1264 */                   awardItemCountBuilder.append(",");
/*      */                 }
/* 1266 */                 int itemid = ((Integer)entry.getKey()).intValue();
/* 1267 */                 awardItemidBuilder.append(itemid);
/* 1268 */                 awardItemCountBuilder.append(entry.getValue());
/*      */                 try {
/* 1270 */                   uuidFirst = true;
/* 1271 */                   Set<Long> uuids = (Set)awardModel.getAwardItemId2uuids().get(Integer.valueOf(itemid));
/* 1272 */                   for (i$ = uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/* 1273 */                     if ((!uuidFirst) || (!first)) {
/* 1274 */                       awardItemUIDBuilder.append(",");
/*      */                     }
/* 1276 */                     awardItemUIDBuilder.append(uuid);
/* 1277 */                     uuidFirst = false;
/*      */                   } } catch (Exception e) { boolean uuidFirst;
/*      */                   Iterator i$;
/* 1280 */                   GameServer.logger().error(String.format("[Fight]FightManager.tlogFightSecurity@item uuid error", new Object[0]), e);
/*      */                 }
/*      */                 
/* 1283 */                 first = false;
/*      */               }
/* 1285 */               awardItemid = awardItemidBuilder.toString();
/* 1286 */               awardItemUID = awardItemUIDBuilder.toString();
/* 1287 */               awardItemCount = awardItemCountBuilder.toString();
/*      */             }
/*      */           }
/*      */         }
/* 1291 */         String headImageURL = PersonalInterface.getHeadImageURL(this.val$roleid, false);
/* 1292 */         if (headImageURL.isEmpty()) {
/* 1293 */           headImageURL = "0";
/*      */         }
/* 1295 */         String logStr = String.format("%d|%d|%s|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%s|%s|%s|%s", new Object[] { Long.valueOf(this.val$roleid), Integer.valueOf(dtEventStartTime), roleName, dtEventEndTime, roleName, yuanBao, Long.valueOf(gold), Long.valueOf(roleLevel), Long.valueOf(reserveExp), Integer.valueOf(partnerCount), Integer.valueOf(partnerBattlePoint), Long.valueOf(petLevel), Integer.valueOf(mapId), Integer.valueOf(fightReason), Integer.valueOf(fightEndReason), Integer.valueOf(fightcfgid), Integer.valueOf(battleTime), Integer.valueOf(battleCD), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(roundCount), Integer.valueOf(roundActionMax), Integer.valueOf(actionTotal), Integer.valueOf(this.val$battleTime), Integer.valueOf(this.val$battleCD), Integer.valueOf(this.val$roundCount), Integer.valueOf(this.val$roundActionMax), Integer.valueOf(this.val$actionTotal), Integer.valueOf(awardRoleExp), Integer.valueOf(awardPetExp), Long.valueOf(awardYuanBao), Long.valueOf(awardGold), Long.valueOf(awardSilver), awardItemid, awardItemUID, awardItemCount, headImageURL });
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1303 */         IdipManager.secBattleTLog(this.val$roleid, logStr);
/* 1304 */         return true;
/*      */       }
/*      */       
/*      */       public boolean isCallInProcedure()
/*      */       {
/* 1309 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void logSkillUse(long roleid, int fightReason, int fighttype, long fightuuid, int fightCfgid, int roleSkillid, int petskillid)
/*      */   {
/* 1327 */     int platform = RoleInterface.getPlatform(roleid);
/* 1328 */     String channel = RoleInterface.getChannel(roleid);
/* 1329 */     String mac = RoleInterface.getMac(roleid);
/*      */     
/* 1331 */     String userid = RoleInterface.getUserId(roleid);
/* 1332 */     Role role = RoleInterface.getRole(roleid, false);
/* 1333 */     int rolelevel = role.getLevel();
/* 1334 */     int occupation = role.getOccupationId();
/*      */     
/*      */ 
/* 1337 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fightReason), Integer.valueOf(fighttype), Long.valueOf(fightuuid), Integer.valueOf(fightCfgid), Integer.valueOf(occupation), Integer.valueOf(roleSkillid), Integer.valueOf(petskillid) });
/*      */     
/* 1339 */     LogManager.getInstance().addLog("skilluse", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tLogSkillUse(long roleid, int fightReason, int fighttype, long fightuuid, int fightCfgid, int roleSkillid, int petskillid)
/*      */   {
/* 1346 */     String userid = RoleInterface.getUserId(roleid);
/* 1347 */     Role role = RoleInterface.getRole(roleid, false);
/* 1348 */     int rolelevel = role.getLevel();
/* 1349 */     int occupation = role.getOccupationId();
/*      */     
/*      */ 
/* 1352 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(fightReason), Integer.valueOf(fighttype), Long.valueOf(fightuuid), Integer.valueOf(fightCfgid), Integer.valueOf(occupation), Integer.valueOf(roleSkillid), Integer.valueOf(petskillid) });
/*      */     
/* 1354 */     TLogManager.getInstance().addLog(roleid, "SkillUse", logStr);
/*      */   }
/*      */   
/*      */   static String getComplexStr(Collection<Long> roles) {
/* 1358 */     if ((roles == null) || (roles.size() <= 0)) {
/* 1359 */       return "";
/*      */     }
/* 1361 */     StringBuilder stringBuilder = new StringBuilder();
/* 1362 */     String splitString = ",";
/* 1363 */     boolean first = true;
/* 1364 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 1365 */       if (!first) {
/* 1366 */         stringBuilder.append(splitString);
/*      */       } else {
/* 1368 */         first = false;
/*      */       }
/* 1370 */       stringBuilder.append(roleid);
/*      */     }
/* 1372 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static void initSkillLog(xbean.Fight xFight)
/*      */   {
/* 1379 */     xFight.getSkillresulthandles().clear();
/* 1380 */     int fightType = xFight.getCfgtype();
/* 1381 */     SFightSkillLogCfg fightSkillLogCfg = SFightSkillLogCfg.get(fightType);
/* 1382 */     if (fightSkillLogCfg == null) {
/* 1383 */       return;
/*      */     }
/*      */     
/* 1386 */     int size = fightSkillLogCfg.skillLogIds.size();
/* 1387 */     for (int i = 0; i < size; i++) {
/* 1388 */       int id = ((Integer)fightSkillLogCfg.skillLogIds.get(i)).intValue();
/* 1389 */       if (id != 0)
/*      */       {
/*      */ 
/* 1392 */         SSkillLogCfg cfg = SSkillLogCfg.get(id);
/*      */         try {
/* 1394 */           String className = SkillResultHandle.class.getName() + "$" + cfg.classname;
/* 1395 */           Class<?> effectClass = Class.forName(className);
/* 1396 */           Constructor<?>[] constructors = effectClass.getDeclaredConstructors();
/* 1397 */           Constructor<?> constructor = constructors[0];
/* 1398 */           if (constructor == null) {
/* 1399 */             String errorTip = String.format("[fight]Fight.initSkillLog@no constructor|classname=%s|SSkillLogCfgid=%d", new Object[] { className, Integer.valueOf(id) });
/*      */             
/* 1401 */             GameServer.logger().error(errorTip);
/* 1402 */             throw new RuntimeException(errorTip);
/*      */           }
/*      */           
/* 1405 */           synchronized (constructor) {
/*      */             try {
/* 1407 */               Object obj = constructor.newInstance(cfg.params.toArray());
/* 1408 */               xFight.getSkillresulthandles().add((SkillResultHandle)obj);
/*      */             } catch (Exception e) {
/* 1410 */               e.printStackTrace();
/*      */             }
/*      */           }
/*      */         }
/*      */         catch (ClassNotFoundException e) {
/* 1415 */           GameServer.logger().error(String.format("[fight]Fight.initSkillLog@no class found|classname=%s|SSkillLogCfgid=%d", new Object[] { cfg.classname, Integer.valueOf(id) }));
/*      */           
/*      */ 
/* 1418 */           e.printStackTrace();
/* 1419 */           throw new RuntimeException(e);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int getPetFightPostionFromPetZhenfaPostion(int zhenfaPostion)
/*      */   {
/* 1431 */     return SPetFightZhenfaPos2Fight.get(zhenfaPostion).fightPostion;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */