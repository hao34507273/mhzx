/*      */ package mzm.gsp.fight.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.common.PropertyRandomUtil.KeyValuePair;
/*      */ import mzm.gsp.effect.fighter.Interface.TeamEffect;
/*      */ import mzm.gsp.fight.Play;
/*      */ import mzm.gsp.fight.PlaySummon;
/*      */ import mzm.gsp.fight.confbean.PetBattleConsts;
/*      */ import mzm.gsp.fight.confbean.SFightCfg;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*      */ import mzm.gsp.fight.fighter.selector.AliveFighterSelector;
/*      */ import mzm.gsp.fight.fighter.selector.ExistedFighterSelector;
/*      */ import mzm.gsp.fight.fighter.selector.FighterSelector;
/*      */ import mzm.gsp.monster.main.Monster;
/*      */ import mzm.gsp.monster.main.MonsterInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.partner.main.PartnerInterface;
/*      */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*      */ import mzm.gsp.pet.confbean.SPetFightConsts;
/*      */ import mzm.gsp.pet.main.PetFightTeam;
/*      */ import mzm.gsp.pet.main.PetFightTeam.Position;
/*      */ import mzm.gsp.pvc.confbean.PVCRobotCfg;
/*      */ import mzm.gsp.pvc.confbean.SPVCCfg;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.skill.main.Skill.Attack;
/*      */ import mzm.gsp.team.main.TeamDpMember;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.zhenfa.main.ZhenfaInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightCmd;
/*      */ import xbean.Pod;
/*      */ import xdb.Xdb;
/*      */ import xio.Protocol;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class FightTeam
/*      */ {
/*      */   protected final boolean isActive;
/*      */   private final xbean.FightTeam xTeam;
/*      */   protected final Fight fight;
/*      */   
/*      */   FightTeam(boolean isActive, xbean.FightTeam xTeam, Fight fight)
/*      */   {
/*   62 */     this.isActive = isActive;
/*   63 */     this.xTeam = xTeam;
/*   64 */     this.fight = fight;
/*   65 */     initAITeamVariable();
/*      */   }
/*      */   
/*      */   protected final Fight getFight() {
/*   69 */     return this.fight;
/*      */   }
/*      */   
/*      */   protected final boolean isRecordEnable() {
/*   73 */     return this.fight.isRecordEnable();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addFightGroupRoles(List<Long> roleids, boolean bFellow)
/*      */   {
/*   85 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*   86 */     int maxLevel = 0;
/*   87 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*   88 */       int level = RoleInterface.getLevel(roleid);
/*   89 */       if (level > maxLevel) {
/*   90 */         maxLevel = level;
/*      */       }
/*      */     }
/*      */     
/*   94 */     ZhenFaResult zhenFaResult = fighterRoleZhenFaZhenFa(roleids);
/*   95 */     Map<Integer, PartnerOutFightObj> partnerOutFightObjMap = new HashMap();
/*      */     
/*   97 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*   98 */     for (int i = 0; i < posNumPerRow; i++) {
/*   99 */       if (zhenFaResult.posMap.containsKey(Integer.valueOf(i))) {
/*  100 */         ZhenFaPosInfo zhenFaPosInfo = (ZhenFaPosInfo)zhenFaResult.posMap.get(Integer.valueOf(i));
/*  101 */         int pos = ((Integer)posPiorList.get(i)).intValue();
/*  102 */         if (zhenFaPosInfo.type == 1) {
/*  103 */           FightGroupRole groupRole = generateGroupRole();
/*  104 */           groupRole.init(zhenFaPosInfo.uuid, pos, maxLevel);
/*  105 */         } else if (zhenFaPosInfo.type == 2)
/*      */         {
/*  107 */           pos += posNumPerRow * 1;
/*  108 */           long ownid = zhenFaPosInfo.owerid;
/*  109 */           int partnerid = (int)zhenFaPosInfo.uuid;
/*  110 */           PartnerOutFightObj partnerObj = PartnerInterface.getPartnerOutFightObjById(ownid, partnerid);
/*  111 */           partnerOutFightObjMap.put(Integer.valueOf(pos), partnerObj);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  117 */     if ((partnerOutFightObjMap.size() > 0) && (bFellow)) {
/*  118 */       FightGroupRole fightGroupRole = getGroupRole(((Long)roleids.get(0)).longValue());
/*  119 */       fightGroupRole.initFellow(partnerOutFightObjMap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  125 */     int zhenfaid = zhenFaResult.getZhenfaId();
/*  126 */     if (zhenfaid > 0) {
/*  127 */       int zhenfaLevel = ZhenfaInterface.getZhenfaLevel(((Long)roleids.get(0)).longValue(), zhenfaid);
/*  128 */       checkAndAddZhenFa(zhenfaid, zhenfaLevel);
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
/*      */   void addFightGroupRoleWithTeamDisposition(List<Long> roleids, boolean bFellow)
/*      */   {
/*  142 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*  143 */     int maxLevel = 0;
/*  144 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  145 */       int level = RoleInterface.getLevel(roleid);
/*  146 */       if (level > maxLevel) {
/*  147 */         maxLevel = level;
/*      */       }
/*      */     }
/*  150 */     long leaderid = ((Long)roleids.get(0)).longValue();
/*      */     
/*  152 */     ZhenFaResult zhenFaResult = new ZhenFaResult(null);
/*  153 */     int zhenFaId = PartnerInterface.getRolePartnerDefaultZhenFaId(leaderid);
/*  154 */     zhenFaResult.setZhenfaId(zhenFaId);
/*  155 */     zhenFaResult.setRoleNum(roleids.size());
/*  156 */     for (int i = 0; i < roleids.size(); i++) {
/*  157 */       long roleid = ((Long)roleids.get(i)).longValue();
/*  158 */       ZhenFaPosInfo zhenFaPosInfo = new ZhenFaPosInfo(1, roleid, roleid);
/*  159 */       zhenFaResult.setPos(i, zhenFaPosInfo);
/*      */     }
/*  161 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*  162 */     Map<Integer, Integer> partnerPosMap = PartnerInterface.getFightPartnerListWithoutRole(leaderid, true);
/*  163 */     if (partnerPosMap != null) {
/*  164 */       for (int i = 0; i < posNumPerRow - zhenFaResult.roleNum; i++) {
/*  165 */         Integer partnerid = (Integer)partnerPosMap.get(Integer.valueOf(i));
/*  166 */         if (partnerid == null) {
/*      */           break;
/*      */         }
/*  169 */         ZhenFaPosInfo partnerPosInfo = new ZhenFaPosInfo(2, partnerid.intValue(), leaderid);
/*  170 */         zhenFaResult.setPos(zhenFaResult.roleNum + i, partnerPosInfo);
/*      */       }
/*      */     }
/*      */     
/*  174 */     Map<Integer, PartnerOutFightObj> partnerOutFightObjMap = new HashMap();
/*      */     
/*  176 */     for (int i = 0; i < posNumPerRow; i++) {
/*  177 */       if (zhenFaResult.posMap.containsKey(Integer.valueOf(i))) {
/*  178 */         ZhenFaPosInfo zhenFaPosInfo = (ZhenFaPosInfo)zhenFaResult.posMap.get(Integer.valueOf(i));
/*  179 */         int pos = ((Integer)posPiorList.get(i)).intValue();
/*  180 */         if (zhenFaPosInfo.type == 1) {
/*  181 */           FightGroupRole groupRole = generateGroupRole();
/*  182 */           groupRole.init(zhenFaPosInfo.uuid, pos, maxLevel);
/*  183 */         } else if (zhenFaPosInfo.type == 2)
/*      */         {
/*  185 */           pos += posNumPerRow * 1;
/*  186 */           long ownid = zhenFaPosInfo.owerid;
/*  187 */           int partnerid = (int)zhenFaPosInfo.uuid;
/*  188 */           PartnerOutFightObj partnerObj = PartnerInterface.getPartnerOutFightObjById(ownid, partnerid);
/*  189 */           partnerOutFightObjMap.put(Integer.valueOf(pos), partnerObj);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  195 */     if ((partnerOutFightObjMap.size() > 0) && (bFellow)) {
/*  196 */       FightGroupRole fightGroupRole = getGroupRole(((Long)roleids.get(0)).longValue());
/*  197 */       fightGroupRole.initFellow(partnerOutFightObjMap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  203 */     int zhenfaid = zhenFaResult.getZhenfaId();
/*  204 */     if (zhenfaid > 0) {
/*  205 */       int zhenfaLevel = ZhenfaInterface.getZhenfaLevel(((Long)roleids.get(0)).longValue(), zhenfaid);
/*  206 */       checkAndAddZhenFa(zhenfaid, zhenfaLevel);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void addPVCFightGroupRoles(long activeRoleid, List<Long> passiveRoles, int pvcCfgid, boolean carryFellow)
/*      */   {
/*  212 */     SPVCCfg spvcCfg = SPVCCfg.get(pvcCfgid);
/*      */     
/*  214 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*  215 */     int posNumberPerRow = FightManager.getPosNumberPerRow();
/*      */     
/*  217 */     int level = RoleInterface.getLevel(activeRoleid);
/*      */     
/*      */ 
/*  220 */     for (int index = 0; index < passiveRoles.size(); index++) {
/*  221 */       long passiveRoleid = ((Long)passiveRoles.get(index)).longValue();
/*  222 */       FightGroupRole fightGroupRole = generateGroupRole();
/*  223 */       fightGroupRole.initClone(passiveRoleid, ((Integer)posPiorList.get(index)).intValue(), spvcCfg, level);
/*  224 */       fightGroupRole.setExtra(FightGroupExtra.PVC_Cfg_Id, pvcCfgid);
/*      */     }
/*      */     
/*      */ 
/*  228 */     long passiveRoleid = ((Long)passiveRoles.get(0)).longValue();
/*      */     
/*      */ 
/*  231 */     if (carryFellow)
/*      */     {
/*  233 */       Map<Integer, Integer> partnerPosMap = PartnerInterface.getFightPartnerListWithoutRole(passiveRoleid, true);
/*  234 */       if (partnerPosMap != null) {
/*  235 */         int roleCount = passiveRoles.size();
/*  236 */         Iterator<Map.Entry<Integer, Integer>> iterator = partnerPosMap.entrySet().iterator();
/*  237 */         while (iterator.hasNext()) {
/*  238 */           Map.Entry<Integer, Integer> entry = (Map.Entry)iterator.next();
/*  239 */           int partnerPos = ((Integer)entry.getKey()).intValue() + 1;
/*  240 */           if (partnerPos < roleCount) {
/*  241 */             iterator.remove();
/*      */           }
/*      */         }
/*      */         
/*  245 */         Map<Integer, PartnerOutFightObj> partnerMap = new HashMap();
/*  246 */         for (Map.Entry<Integer, Integer> entry : partnerPosMap.entrySet()) {
/*  247 */           int partnerPos = ((Integer)entry.getKey()).intValue() + 1;
/*  248 */           PartnerOutFightObj partnerOutFightObj = PartnerInterface.getPartnerOutFightObjById(passiveRoleid, ((Integer)entry.getValue()).intValue());
/*      */           
/*  250 */           partnerMap.put(Integer.valueOf(((Integer)posPiorList.get(partnerPos)).intValue() + 1 * posNumberPerRow), partnerOutFightObj);
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  255 */         if (partnerMap.size() > 0) {
/*  256 */           FightGroupRole fightGroupRole = getGroupRole(passiveRoleid);
/*  257 */           fightGroupRole.initCloneFellow(partnerMap, spvcCfg, level);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  263 */     int zhenFaid = PartnerInterface.getSPartnerZhenfaId(passiveRoleid, true);
/*  264 */     if (zhenFaid > 0) {
/*  265 */       int zhenfaLevel = ZhenfaInterface.getZhenfaLevel(passiveRoleid, zhenFaid);
/*  266 */       checkAndAddZhenFa(zhenFaid, zhenfaLevel);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected void addPVCFightGroupRoleWithRobot(long activeRoleid, List<Long> passiveRoles, int robotClassid, boolean carryFellow)
/*      */   {
/*  274 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*  275 */     int posNumberPerRow = FightManager.getPosNumberPerRow();
/*  276 */     Role role = RoleInterface.getRole(activeRoleid, false);
/*  277 */     int level = role.getLevel();
/*  278 */     PVCRobotCfg spvcRobotCfg = FightConfigManager.getInstance().getPVCRobotCfg(robotClassid, level);
/*  279 */     if (passiveRoles.size() <= 0)
/*      */     {
/*  281 */       FightGroupMonster groupMonster = generateGroupMonster();
/*      */       
/*      */ 
/*  284 */       Monster roleMonster = MonsterInterface.getMonster(spvcRobotCfg.roleRobotid, level);
/*  285 */       List<Integer> partnerids = FightConfigManager.getInstance().getPartnerids(spvcRobotCfg);
/*  286 */       int petMonsterid = FightConfigManager.getInstance().getPetid(spvcRobotCfg);
/*      */       
/*  288 */       int rolePos = ((Integer)posPiorList.get(0)).intValue() + posNumberPerRow * 1;
/*  289 */       FighterNpcMonster fighterNpcMonster = groupMonster.generateFighterNpcMonster();
/*  290 */       fighterNpcMonster.init(roleMonster, rolePos);
/*      */       
/*      */ 
/*  293 */       if (petMonsterid > 0) {
/*  294 */         Monster petMonster = MonsterInterface.getMonster(petMonsterid, level);
/*  295 */         int petPos = ((Integer)posPiorList.get(0)).intValue() + posNumberPerRow * 0;
/*  296 */         FighterMonster fighterMonster = groupMonster.generateFighterMonster();
/*  297 */         fighterMonster.init(petMonster, petPos);
/*      */       }
/*      */       
/*      */ 
/*  301 */       for (int i = 1; i < posPiorList.size(); i++) {
/*  302 */         if (partnerids.size() < i) {
/*      */           break;
/*      */         }
/*  305 */         Monster partnerMonster = MonsterInterface.getMonster(((Integer)partnerids.get(i - 1)).intValue(), level);
/*  306 */         int partnerPos = ((Integer)posPiorList.get(i)).intValue() + posNumberPerRow * 1;
/*  307 */         FighterNpcMonster fighterNpcMonster2 = groupMonster.generateFighterNpcMonster();
/*  308 */         fighterNpcMonster2.init(partnerMonster, partnerPos);
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/*  314 */       for (int index = 0; index < passiveRoles.size(); index++) {
/*  315 */         long passiveRoleid = ((Long)passiveRoles.get(index)).longValue();
/*  316 */         FightGroupRole fightGroupRole = generateGroupRole();
/*  317 */         fightGroupRole.initClone(passiveRoleid, ((Integer)posPiorList.get(index)).intValue(), spvcRobotCfg, level);
/*  318 */         fightGroupRole.setExtra(FightGroupExtra.PVC_Cfg_Robot_Classid, robotClassid);
/*  319 */         fightGroupRole.setExtra(FightGroupExtra.PVC_Cfg_Robot_Level, level);
/*      */       }
/*      */       
/*      */ 
/*  323 */       long passiveRoleid = ((Long)passiveRoles.get(0)).longValue();
/*      */       
/*  325 */       if (carryFellow)
/*      */       {
/*      */ 
/*  328 */         Map<Integer, Integer> partnerPosMap = PartnerInterface.getFightPartnerListWithoutRole(passiveRoleid, true);
/*      */         
/*  330 */         if (partnerPosMap != null) {
/*  331 */           int roleCount = passiveRoles.size();
/*  332 */           Iterator<Map.Entry<Integer, Integer>> iterator = partnerPosMap.entrySet().iterator();
/*  333 */           while (iterator.hasNext()) {
/*  334 */             Map.Entry<Integer, Integer> entry = (Map.Entry)iterator.next();
/*  335 */             int partnerPos = ((Integer)entry.getKey()).intValue() + 1;
/*  336 */             if (partnerPos < roleCount) {
/*  337 */               iterator.remove();
/*      */             }
/*      */           }
/*      */           
/*  341 */           Map<Integer, PartnerOutFightObj> partnerMap = new HashMap();
/*  342 */           for (Map.Entry<Integer, Integer> entry : partnerPosMap.entrySet()) {
/*  343 */             int partnerPos = ((Integer)entry.getKey()).intValue() + 1;
/*  344 */             PartnerOutFightObj partnerOutFightObj = PartnerInterface.getPartnerOutFightObjById(passiveRoleid, ((Integer)entry.getValue()).intValue());
/*      */             
/*  346 */             partnerMap.put(Integer.valueOf(((Integer)posPiorList.get(partnerPos)).intValue() + 1 * posNumberPerRow), partnerOutFightObj);
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  351 */           if (partnerMap.size() > 0) {
/*  352 */             FightGroupRole fightGroupRole = getGroupRole(passiveRoleid);
/*  353 */             fightGroupRole.initCloneFellow(partnerMap, spvcRobotCfg, level);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  359 */       int zhenFaid = PartnerInterface.getSPartnerZhenfaId(passiveRoleid, true);
/*  360 */       if (zhenFaid > 0) {
/*  361 */         int zhenfaLevel = ZhenfaInterface.getZhenfaLevel(passiveRoleid, zhenFaid);
/*  362 */         checkAndAddZhenFa(zhenFaid, zhenfaLevel);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   protected void addFightGroupCloneRobotPet(FightInterface.PetFightRobotInfo fightInfo)
/*      */   {
/*  369 */     long roleId = fightInfo.roleId;
/*  370 */     FightGroupRole groupRole = generateGroupRole();
/*  371 */     groupRole.setRoleid(roleId);
/*  372 */     FightGroupMonster groupMonster = generateGroupMonster();
/*  373 */     groupMonster.setRoleid(roleId);
/*  374 */     groupMonster.removeAI();
/*  375 */     Set<Map.Entry<Integer, PetFightTeam.Position>> posZhenfaEntrySet = fightInfo.zhenfaInfo.positions.entrySet();
/*  376 */     for (Map.Entry<Integer, PetFightTeam.Position> posZhenfaEntry : posZhenfaEntrySet)
/*      */     {
/*  378 */       int zhenfaPos = ((Integer)posZhenfaEntry.getKey()).intValue();
/*      */       
/*  380 */       int fightPos = FightManager.getPetFightPostionFromPetZhenfaPostion(zhenfaPos);
/*  381 */       FightInterface.PetFightRobotInfo.PetRobot robot = (FightInterface.PetFightRobotInfo.PetRobot)fightInfo.robots.get(Integer.valueOf(zhenfaPos));
/*  382 */       if (robot != null)
/*      */       {
/*      */ 
/*  385 */         Monster petMonster = MonsterInterface.getMonster(robot.monsterCfgId, robot.level);
/*      */         
/*  387 */         Map<Integer, Integer> petExaAttrsMap = new HashMap();
/*  388 */         Set<Map.Entry<Integer, Integer>> propEntrySet = ((PetFightTeam.Position)posZhenfaEntry.getValue()).properties.entrySet();
/*  389 */         for (Map.Entry<Integer, Integer> propEntry : propEntrySet) {
/*  390 */           int key = ((Integer)propEntry.getKey()).intValue();
/*  391 */           int oldValue = petExaAttrsMap.get(Integer.valueOf(key)) == null ? 0 : ((Integer)petExaAttrsMap.get(Integer.valueOf(key))).intValue();
/*  392 */           petExaAttrsMap.put(Integer.valueOf(key), Integer.valueOf(oldValue + ((Integer)propEntry.getValue()).intValue()));
/*      */         }
/*  394 */         petMonster.fillOtherFightProperty(petExaAttrsMap);
/*      */         
/*      */ 
/*      */ 
/*  398 */         int petPos = fightPos;
/*  399 */         FighterMonster fighterMonster = groupMonster.generateFighterMonster();
/*  400 */         fighterMonster.init(petMonster, petPos);
/*      */         
/*      */ 
/*  403 */         fighterMonster.setExtra(FighterExtra.PET_ROBOT, 1);
/*      */         
/*      */ 
/*  406 */         PetFightTeam.Position zhenfaPosition = (PetFightTeam.Position)fightInfo.zhenfaInfo.positions.get(Integer.valueOf(zhenfaPos));
/*  407 */         long petId = zhenfaPosition.petId;
/*  408 */         fighterMonster.setUuid(petId);
/*      */         
/*      */ 
/*  411 */         String aiName = PetBattleConsts.getInstance().defaultAI;
/*      */         
/*  413 */         fighterMonster.setAi(new AI(aiName).getAi());
/*      */       } }
/*  415 */     int zhenfaid = fightInfo.zhenfaInfo.formationId;
/*  416 */     int zhenfaLevel = fightInfo.zhenfaInfo.formationLevel;
/*      */     
/*      */ 
/*  419 */     if (SPetFightConsts.getInstance().DEFAULT_FORMATION_ID == zhenfaid) {
/*  420 */       zhenfaid = 0;
/*      */     }
/*  422 */     setZhenFaid(zhenfaid);
/*  423 */     setZhenFaLevel(zhenfaLevel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void addFightGroupClonePet(FightInterface.PetFightInfo fightInfo)
/*      */   {
/*  432 */     FightGroupRole groupRole = generateGroupRole();
/*  433 */     long roleId = fightInfo.roleId;
/*      */     
/*  435 */     Set<Map.Entry<Integer, PetFightTeam.Position>> posZhenfaEntrySet = fightInfo.zhenfaInfo.positions.entrySet();
/*  436 */     for (Map.Entry<Integer, PetFightTeam.Position> posZhenfaEntry : posZhenfaEntrySet)
/*      */     {
/*  438 */       int zhenfaGridPos = ((Integer)posZhenfaEntry.getKey()).intValue();
/*  439 */       long petId = ((PetFightTeam.Position)posZhenfaEntry.getValue()).petId;
/*  440 */       int fightPos = FightManager.getPetFightPostionFromPetZhenfaPostion(zhenfaGridPos);
/*      */       
/*      */ 
/*  443 */       Map<Integer, Integer> petExaAttrsMap = new HashMap();
/*  444 */       Set<Map.Entry<Integer, Integer>> propEntrySet = ((PetFightTeam.Position)posZhenfaEntry.getValue()).properties.entrySet();
/*  445 */       for (Map.Entry<Integer, Integer> propEntry : propEntrySet) {
/*  446 */         int key = ((Integer)propEntry.getKey()).intValue();
/*  447 */         int oldValue = petExaAttrsMap.get(Integer.valueOf(key)) == null ? 0 : ((Integer)petExaAttrsMap.get(Integer.valueOf(key))).intValue();
/*  448 */         petExaAttrsMap.put(Integer.valueOf(key), Integer.valueOf(oldValue + ((Integer)propEntry.getValue()).intValue()));
/*      */       }
/*      */       
/*  451 */       CloneFighterPet fighterPet = groupRole.initClonePet(roleId, petId, fightPos, petExaAttrsMap);
/*  452 */       if (fighterPet != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  457 */         if (groupRole.getGroupAI() == null) {
/*  458 */           String aiName = PetBattleConsts.getInstance().defaultAI;
/*      */           
/*  460 */           fighterPet.setAi(new AI(aiName).getAi());
/*      */         } }
/*      */     }
/*  463 */     int zhenfaid = fightInfo.zhenfaInfo.formationId;
/*  464 */     int zhenfaLevel = fightInfo.zhenfaInfo.formationLevel;
/*      */     
/*      */ 
/*  467 */     if (SPetFightConsts.getInstance().DEFAULT_FORMATION_ID == zhenfaid) {
/*  468 */       zhenfaid = 0;
/*      */     }
/*  470 */     setZhenFaid(zhenfaid);
/*  471 */     setZhenFaLevel(zhenfaLevel);
/*      */   }
/*      */   
/*      */   protected void addFightGroupRoles(int id, Map<Integer, Monster> npcMonsterMap, List<Long> roleids)
/*      */   {
/*  476 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*      */     
/*  478 */     ZhenFaResult zhenFaResult = fighterRoleZhenFaZhenFa(roleids);
/*      */     
/*  480 */     Map<Integer, PartnerOutFightObj> partnerOutFightObjMap = new HashMap();
/*      */     
/*      */ 
/*  483 */     boolean addNpc = zhenFaResult.roleNum <= 1;
/*  484 */     if (!addNpc) {
/*  485 */       Iterator<Map.Entry<Integer, Monster>> itor = npcMonsterMap.entrySet().iterator();
/*  486 */       while (itor.hasNext()) {
/*  487 */         if (((Integer)((Map.Entry)itor.next()).getKey()).intValue() != 12)
/*      */         {
/*      */ 
/*  490 */           itor.remove(); }
/*      */       }
/*      */     }
/*  493 */     int maxLevel = 0;
/*  494 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  495 */       int level = RoleInterface.getLevel(roleid);
/*  496 */       if (level > maxLevel) {
/*  497 */         maxLevel = level;
/*      */       }
/*      */     }
/*      */     
/*  501 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*  502 */     for (int i = 0; i < posNumPerRow; i++) {
/*  503 */       if (zhenFaResult.posMap.containsKey(Integer.valueOf(i))) {
/*  504 */         ZhenFaPosInfo zhenFaPosInfo = (ZhenFaPosInfo)zhenFaResult.posMap.get(Integer.valueOf(i));
/*  505 */         int pos = ((Integer)posPiorList.get(i)).intValue();
/*  506 */         if (zhenFaPosInfo.type == 1) {
/*  507 */           FightGroupRole groupRole = generateGroupRole();
/*  508 */           groupRole.init(zhenFaPosInfo.uuid, pos, maxLevel);
/*  509 */         } else if (zhenFaPosInfo.type == 2)
/*      */         {
/*  511 */           pos += posNumPerRow * 1;
/*  512 */           if ((!addNpc) || 
/*  513 */             (!npcMonsterMap.containsKey(Integer.valueOf(pos))))
/*      */           {
/*      */ 
/*      */ 
/*  517 */             long ownid = zhenFaPosInfo.owerid;
/*  518 */             int partnerid = (int)zhenFaPosInfo.uuid;
/*  519 */             PartnerOutFightObj partnerObj = PartnerInterface.getPartnerOutFightObjById(ownid, partnerid);
/*  520 */             partnerOutFightObjMap.put(Integer.valueOf(pos), partnerObj);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  526 */     Map<Integer, Fighter> posToFighterMap = getPosToFighter();
/*  527 */     Iterator<Map.Entry<Integer, Monster>> iterator = npcMonsterMap.entrySet().iterator();
/*  528 */     while (iterator.hasNext()) {
/*  529 */       Map.Entry<Integer, Monster> entry = (Map.Entry)iterator.next();
/*  530 */       if (posToFighterMap.containsKey(entry.getKey())) {
/*  531 */         iterator.remove();
/*      */       }
/*      */     }
/*  534 */     if (npcMonsterMap.size() > 0) {
/*  535 */       FightGroupNpcMonster npcMonster = generateGroupNpcMonster();
/*  536 */       npcMonster.init(id, npcMonsterMap);
/*      */     }
/*      */     
/*  539 */     int cfgType = getFight().getCfgType();
/*      */     
/*  541 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(cfgType);
/*      */     
/*      */ 
/*  544 */     if ((partnerOutFightObjMap.size() > 0) && (fightTypeCfg.canCarryFellow)) {
/*  545 */       FightGroupRole groupRole = getGroupRole(((Long)roleids.get(0)).longValue());
/*  546 */       groupRole.initFellow(partnerOutFightObjMap);
/*      */     }
/*      */     
/*      */ 
/*  550 */     int zhenfaid = zhenFaResult.getZhenfaId();
/*  551 */     if (zhenfaid > 0) {
/*  552 */       int zhenfaLevel = ZhenfaInterface.getZhenfaLevel(((Long)roleids.get(0)).longValue(), zhenfaid);
/*  553 */       checkAndAddZhenFa(zhenfaid, zhenfaLevel);
/*      */     }
/*      */   }
/*      */   
/*      */   private void checkAndAddZhenFa(int zhenfaid, int zhenfaLevel)
/*      */   {
/*  559 */     Map<Integer, Fighter> zhenfaPosfighters = getZhenFaPosFighter();
/*  560 */     Map<Integer, List<Long>> zhenFaParaMap = new HashMap();
/*  561 */     for (Fighter fighter : zhenfaPosfighters.values()) {
/*  562 */       int type = fighter.getType();
/*  563 */       long uuid = 0L;
/*  564 */       switch (type) {
/*      */       case 1: 
/*  566 */         type = 1;
/*  567 */         if (fighter.isCloneRole()) {
/*  568 */           CloneFighterRole cloneFighterRole = (CloneFighterRole)fighter;
/*  569 */           uuid = cloneFighterRole.getRoleid();
/*      */         } else {
/*  571 */           FighterRole fighterRole = (FighterRole)fighter;
/*  572 */           uuid = fighterRole.getRoleid();
/*      */         }
/*  574 */         break;
/*      */       case 2: 
/*  576 */         type = 2;
/*  577 */         if (fighter.isCloneFellow()) {
/*  578 */           CloneFighterFellow cloneFighterFellow = (CloneFighterFellow)fighter;
/*  579 */           uuid = cloneFighterFellow.getUuid();
/*      */         } else {
/*  581 */           FighterFellow fighterFellow = (FighterFellow)fighter;
/*  582 */           uuid = fighterFellow.getPartnerid();
/*      */         }
/*      */         
/*  585 */         break;
/*      */       case 4: 
/*  587 */         type = 4;
/*  588 */         if (fighter.isClonePet()) {
/*  589 */           CloneFighterPet cloneFighterPet = (CloneFighterPet)fighter;
/*  590 */           uuid = cloneFighterPet.getUuid();
/*      */         } else {
/*  592 */           uuid = fighter.getUuid();
/*      */         }
/*  594 */         break;
/*      */       case 8: 
/*  596 */         FighterMonster fighterMonster = (FighterMonster)fighter;
/*  597 */         uuid = fighterMonster.getMonsterid();
/*  598 */         break;
/*      */       case 16: 
/*  600 */         uuid = fighter.getUuid();
/*  601 */         break;
/*      */       }
/*      */       
/*      */       
/*  605 */       if (zhenFaParaMap.containsKey(Integer.valueOf(type))) {
/*  606 */         ((List)zhenFaParaMap.get(Integer.valueOf(type))).add(Long.valueOf(uuid));
/*      */       } else {
/*  608 */         List<Long> list = new ArrayList();
/*  609 */         list.add(Long.valueOf(uuid));
/*  610 */         zhenFaParaMap.put(Integer.valueOf(type), list);
/*      */       }
/*      */     }
/*  613 */     boolean available = ZhenfaInterface.isZhenfaAvailable(zhenFaParaMap, zhenfaid);
/*  614 */     if (available) {
/*  615 */       effectZhenFa(zhenfaid, zhenfaLevel, zhenfaPosfighters);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void effectZhenFa(int zhenfaid, int zhenfaLevel, Map<Integer, Fighter> zhenfaPosfighters)
/*      */   {
/*  627 */     setZhenFaid(zhenfaid);
/*  628 */     setZhenFaLevel(zhenfaLevel);
/*      */     
/*  630 */     Map<Integer, List<PropertyRandomUtil.KeyValuePair>> posToAttriMap = ZhenfaInterface.getZhenfaPosAttributes(zhenfaid, zhenfaLevel);
/*  631 */     for (Map.Entry<Integer, List<PropertyRandomUtil.KeyValuePair>> entry : posToAttriMap.entrySet()) {
/*  632 */       fighter = (Fighter)zhenfaPosfighters.get(entry.getKey());
/*  633 */       if (fighter != null) {
/*  634 */         for (PropertyRandomUtil.KeyValuePair keyValuePair : (List)entry.getValue()) {
/*  635 */           int key = keyValuePair.getKey();
/*  636 */           fighter.addAttriChangeProperty(key, keyValuePair.getValue());
/*  637 */           if ((GameServer.logger().isDebugEnabled()) && (
/*  638 */             (key == 24) || (key == 47))) {
/*      */             try {
/*  640 */               if (fighter.isRole()) {
/*  641 */                 GameServer.logger().debug(String.format("[FightSpeedLogDump]Fight zhenfaRestrict|name=%s|key=%d|value=%d|round=%d|zhenfaid=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(key), Integer.valueOf(keyValuePair.getValue()), Integer.valueOf(fighter.getRound()), Integer.valueOf(zhenfaid), Long.valueOf(this.fight.fightid) }));
/*      */               }
/*      */             }
/*      */             catch (Exception e) {}
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     Fighter fighter;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Map<Integer, Fighter> getZhenFaPosFighter()
/*      */   {
/*  665 */     List<Integer> posList = getZhenFaPosInFight();
/*  666 */     Map<Integer, Fighter> zhenFaPosFighter = new HashMap();
/*      */     
/*  668 */     Map<Integer, Fighter> posToFighterMap = getPosToFighter();
/*  669 */     for (int i = 0; i < posList.size(); i++) {
/*  670 */       int position = ((Integer)posList.get(i)).intValue();
/*  671 */       Fighter fighter = (Fighter)posToFighterMap.get(Integer.valueOf(position));
/*  672 */       if (fighter != null)
/*      */       {
/*  674 */         zhenFaPosFighter.put(Integer.valueOf(i + 1), fighter);
/*      */       }
/*      */     }
/*      */     
/*  678 */     return zhenFaPosFighter;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Map<Integer, Fighter> getPosToFighter()
/*      */   {
/*  687 */     Map<Integer, Fighter> posFighterMap = new HashMap();
/*  688 */     for (Fighter fighter : getFighters()) {
/*  689 */       posFighterMap.put(Integer.valueOf(fighter.getPos()), fighter);
/*      */     }
/*  691 */     return posFighterMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   List<Integer> getZhenFaPosInFight()
/*      */   {
/*  701 */     List<Integer> posList = new ArrayList();
/*  702 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*  703 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*  704 */     for (int i = 0; i < posNumPerRow; i++) {
/*  705 */       int pos = ((Integer)posPiorList.get(i)).intValue() + 1 * posNumPerRow;
/*  706 */       posList.add(Integer.valueOf(pos));
/*      */     }
/*  708 */     return posList;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   ZhenFaResult fighterRoleZhenFaZhenFa(List<Long> roleids)
/*      */   {
/*  741 */     ZhenFaResult zhenFaResult = new ZhenFaResult(null);
/*      */     
/*      */ 
/*  744 */     long teamLeaderid = ((Long)roleids.get(0)).longValue();
/*  745 */     Long teamidLong = TeamInterface.getTeamidByRoleid(teamLeaderid, false);
/*  746 */     if ((teamidLong != null) && (TeamInterface.isTeamLeader(teamidLong.longValue(), teamLeaderid, false))) {
/*  747 */       int zhenfaId = TeamInterface.getZhenFaId(teamLeaderid, false);
/*  748 */       zhenFaResult.setZhenfaId(zhenfaId);
/*  749 */       int roleNum = 0;
/*  750 */       Map<Integer, TeamDpMember> teamDpMemberMap = TeamInterface.getZhanWeiInfo(teamLeaderid, false);
/*  751 */       for (Map.Entry<Integer, TeamDpMember> entry : teamDpMemberMap.entrySet()) {
/*  752 */         TeamDpMember teamDpMember = (TeamDpMember)entry.getValue();
/*  753 */         if (teamDpMember.dispositionmember_type == 1) {
/*  754 */           ZhenFaPosInfo zhenFaPosInfo = new ZhenFaPosInfo(2, teamDpMember.teamdispositionmember_id, teamLeaderid);
/*      */           
/*  756 */           zhenFaResult.setPos(((Integer)entry.getKey()).intValue(), zhenFaPosInfo);
/*  757 */         } else if ((teamDpMember.dispositionmember_type == 0) && 
/*  758 */           (roleids.contains(Long.valueOf(teamDpMember.teamdispositionmember_id)))) {
/*  759 */           ZhenFaPosInfo zhenFaPosInfo = new ZhenFaPosInfo(1, teamDpMember.teamdispositionmember_id, teamDpMember.teamdispositionmember_id);
/*      */           
/*  761 */           zhenFaResult.setPos(((Integer)entry.getKey()).intValue(), zhenFaPosInfo);
/*  762 */           roleNum++;
/*      */         }
/*      */       }
/*      */       
/*  766 */       zhenFaResult.setRoleNum(roleNum);
/*      */     }
/*      */     else {
/*  769 */       ZhenFaPosInfo zhenFaPosInfo = new ZhenFaPosInfo(1, teamLeaderid, teamLeaderid);
/*  770 */       zhenFaResult.setPos(0, zhenFaPosInfo);
/*  771 */       int zhanFaid = PartnerInterface.getSPartnerZhenfaId(teamLeaderid, true);
/*  772 */       zhenFaResult.setZhenfaId(zhanFaid);
/*  773 */       Map<Integer, Integer> partnerPosMap = PartnerInterface.getFightPartnerListWithoutRole(teamLeaderid, true);
/*  774 */       if (partnerPosMap == null) {
/*  775 */         return zhenFaResult;
/*      */       }
/*  777 */       for (Map.Entry<Integer, Integer> posToidEntry : partnerPosMap.entrySet()) {
/*  778 */         int pos = ((Integer)posToidEntry.getKey()).intValue() + 1;
/*  779 */         int partnerid = ((Integer)posToidEntry.getValue()).intValue();
/*  780 */         ZhenFaPosInfo partnerPosInfo = new ZhenFaPosInfo(2, partnerid, teamLeaderid);
/*  781 */         zhenFaResult.setPos(pos, partnerPosInfo);
/*      */       }
/*      */     }
/*  784 */     return zhenFaResult;
/*      */   }
/*      */   
/*      */   private class ZhenFaResult { private int zhenfaId;
/*      */     
/*      */     private ZhenFaResult() {}
/*      */     
/*  791 */     private int roleNum = 1;
/*      */     
/*  793 */     private Map<Integer, FightTeam.ZhenFaPosInfo> posMap = new HashMap();
/*      */     
/*      */     int getZhenfaId() {
/*  796 */       return this.zhenfaId;
/*      */     }
/*      */     
/*      */     void setZhenfaId(int zhenfaId) {
/*  800 */       this.zhenfaId = zhenfaId;
/*      */     }
/*      */     
/*      */     void setRoleNum(int roleNum) {
/*  804 */       this.roleNum = roleNum;
/*      */     }
/*      */     
/*      */     void setPos(int pos, FightTeam.ZhenFaPosInfo zhenFaPosInfo) {
/*  808 */       this.posMap.put(Integer.valueOf(pos), zhenFaPosInfo);
/*      */     }
/*      */     
/*      */     boolean containPos(int pos)
/*      */     {
/*  813 */       return this.posMap.containsKey(Integer.valueOf(pos));
/*      */     }
/*      */   }
/*      */   
/*      */   private class ZhenFaPosInfo {
/*      */     public final int type;
/*      */     public final long uuid;
/*      */     public final long owerid;
/*      */     
/*      */     public ZhenFaPosInfo(int type, long uuid, long owerid) {
/*  823 */       this.type = type;
/*  824 */       this.uuid = uuid;
/*  825 */       this.owerid = owerid;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addFightGroupMonster(int id, Map<Integer, Monster> piorPos2Monster)
/*      */   {
/*  836 */     FightGroupMonster groupMonster = generateGroupMonster();
/*  837 */     Map<Integer, Monster> pos2Monster = getPos2Monster(piorPos2Monster);
/*  838 */     groupMonster.init(id, pos2Monster);
/*  839 */     SFightCfg fightCfg = SFightCfg.get(id);
/*  840 */     handleZhenFa(fightCfg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void handleZhenFa(SFightCfg fightCfg)
/*      */   {
/*  849 */     FightParam fightParam = this.fight.getFightParam();
/*  850 */     if ((fightParam != null) && (fightParam.pveRoleRowModleInfos.size() > 0)) {
/*  851 */       RoleRowModleInfo roleRowModleInfo = (RoleRowModleInfo)fightParam.pveRoleRowModleInfos.get(0);
/*  852 */       long roleid = roleRowModleInfo.roleid;
/*  853 */       int zhenfaid = PartnerInterface.getSPartnerZhenfaId(roleid, true);
/*  854 */       if (zhenfaid > 0) {
/*  855 */         int zhenfaLevel = ZhenfaInterface.getZhenfaLevel(roleid, zhenfaid);
/*      */         
/*  857 */         Map<Integer, Fighter> zhenfaFighters = getZhenFaPosFighter();
/*  858 */         effectZhenFa(zhenfaid, zhenfaLevel, zhenfaFighters);
/*      */       }
/*      */     }
/*  861 */     else if (fightCfg.zhenfaList.size() > 0) {
/*  862 */       int zhenFaIndex = Xdb.random().nextInt(fightCfg.zhenfaList.size());
/*  863 */       int zhenfaLv = fightCfg.zhenfaLV;
/*  864 */       if (zhenfaLv <= 0) {
/*  865 */         zhenfaLv = this.fight.getActiveTeam().getZhenFaLevel();
/*      */       }
/*  867 */       zhenfaLv = Math.max(1, zhenfaLv);
/*      */       
/*  869 */       Map<Integer, Fighter> zhenfaFighters = getZhenFaPosFighter();
/*  870 */       effectZhenFa(((Integer)fightCfg.zhenfaList.get(zhenFaIndex)).intValue(), zhenfaLv, zhenfaFighters);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Map<Integer, Monster> getPos2Monster(Map<Integer, Monster> piorPos2Monster)
/*      */   {
/*  881 */     Map<Integer, Monster> pos2Monster = new TreeMap();
/*  882 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*  883 */     for (Map.Entry<Integer, Monster> entry : piorPos2Monster.entrySet()) {
/*  884 */       int piorPos = ((Integer)entry.getKey()).intValue();
/*  885 */       Monster m = (Monster)entry.getValue();
/*  886 */       int posNumberPerRow = FightManager.getPosNumberPerRow();
/*  887 */       int rowIndex = piorPos / posNumberPerRow;
/*  888 */       int row = 1;
/*  889 */       switch (rowIndex) {
/*      */       case 0: 
/*  891 */         row = 1;
/*  892 */         break;
/*      */       case 1: 
/*  894 */         row = 0;
/*  895 */         break;
/*      */       default: 
/*  897 */         throw new RuntimeException("wrong monster pior pos: piorPos=" + piorPos);
/*      */       }
/*  899 */       int pos = ((Integer)posPiorList.get(piorPos % posNumberPerRow)).intValue();
/*  900 */       pos2Monster.put(Integer.valueOf(pos + row * posNumberPerRow), m);
/*      */     }
/*  902 */     return pos2Monster;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addFightGroupInvincibleMonster(int id, Map<Integer, Monster> piorPos2Monster, int hprate)
/*      */   {
/*  913 */     FightGroupMonster groupMonster = generateGroupMonster();
/*  914 */     Map<Integer, Monster> pos2Monster = getPos2Monster(piorPos2Monster);
/*  915 */     groupMonster.initInvincibleMonter(id, pos2Monster, hprate);
/*  916 */     SFightCfg fightCfg = SFightCfg.get(id);
/*  917 */     handleZhenFa(fightCfg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void excuteOpSummonMonster(int fighterid, List<Integer> monsterids, List<Integer> positions, int level, ExcuteCmdResult excuteCmdResult)
/*      */   {
/*  929 */     List<Integer> summonPositions = getSummonMonsterPos();
/*  930 */     if (positions.size() <= 0) {
/*  931 */       positions.addAll(summonPositions);
/*      */     }
/*  933 */     int max = Math.min(positions.size(), monsterids.size());
/*  934 */     Map<Integer, Monster> posMonsterMap = new HashMap();
/*  935 */     for (int i = 0; i < max; i++) {
/*  936 */       Monster monster = MonsterInterface.getMonster(((Integer)monsterids.get(i)).intValue(), level);
/*  937 */       if (monster == null) {
/*  938 */         GameServer.logger().error("AI召唤怪物中不存在的怪物!!monsterid:" + monsterids.get(i));
/*      */       }
/*      */       else {
/*  941 */         posMonsterMap.put(positions.get(i), monster);
/*      */       }
/*      */     }
/*  944 */     List<Fighter> fighters = new ArrayList();
/*  945 */     for (FightGroup fightGroup : getGroups()) {
/*  946 */       if ((fightGroup instanceof FightGroupMonster)) {
/*  947 */         for (Map.Entry<Integer, Monster> posMonsterEntry : posMonsterMap.entrySet()) {
/*  948 */           int pos = ((Integer)posMonsterEntry.getKey()).intValue();
/*  949 */           if (summonPositions.contains(Integer.valueOf(pos)))
/*      */           {
/*      */ 
/*  952 */             fighters.add(fightGroup.addMonster((Monster)posMonsterEntry.getValue(), pos)); }
/*      */         }
/*  954 */         break;
/*      */       }
/*      */     }
/*      */     
/*      */     FightGroupMonster fightGroupMonster;
/*  959 */     if (fighters.size() <= 0) {
/*  960 */       fightGroupMonster = generateGroupMonster();
/*  961 */       for (Map.Entry<Integer, Monster> posMonsterEntry : posMonsterMap.entrySet()) {
/*  962 */         int pos = ((Integer)posMonsterEntry.getKey()).intValue();
/*  963 */         if (summonPositions.contains(Integer.valueOf(pos)))
/*      */         {
/*      */ 
/*  966 */           FighterMonster fighterMonster = fightGroupMonster.generateFighterMonster();
/*  967 */           fighterMonster.init((Monster)posMonsterEntry.getValue(), pos);
/*  968 */           fighters.add(fighterMonster);
/*      */         }
/*      */       }
/*      */     }
/*  972 */     Fighter sumFighter = this.fight.getFighter(fighterid);
/*  973 */     int summonSize = fighters.size();
/*  974 */     if (summonSize > 0) {
/*  975 */       PlaySummon playSummon = new PlaySummon();
/*  976 */       sumFighter.fillPlaySummonResult(playSummon, 1, fighterid, fighters);
/*  977 */       List<Integer> targets = new ArrayList();
/*  978 */       List<Skill.Attack> attacks = new ArrayList();
/*  979 */       for (Fighter fighter : fighters) {
/*  980 */         targets.add(Integer.valueOf(fighter.fighterid));
/*  981 */         Skill.Attack attack = new Skill.Attack();
/*  982 */         attack.addNormalCount(1);
/*  983 */         attacks.add(attack);
/*      */       }
/*      */       
/*  986 */       int playTime = FightUtil.getPlayTime(sumFighter.getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, targets, attacks);
/*      */       
/*  988 */       excuteCmdResult.addPlayTime(playTime);
/*      */       
/*  990 */       if (sumFighter.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/*  991 */         Play play = new Play();
/*  992 */         play.play_type = 2;
/*  993 */         play.content = playSummon.marshal(new OctetsStream());
/*  994 */         excuteCmdResult.addPlay(play, true);
/*  995 */         excuteCmdResult.addPlay(play, false);
/*  996 */         if (isRecordEnable()) {
/*  997 */           excuteCmdResult.addPlay(play);
/*      */         }
/*      */       } else {
/* 1000 */         Play oppisitePlay = new Play();
/* 1001 */         PlaySummon oppisitePlaySummon = sumFighter.getOppisitePlaySummon(playSummon, true);
/* 1002 */         oppisitePlay.play_type = 2;
/* 1003 */         oppisitePlay.content = oppisitePlaySummon.marshal(new OctetsStream());
/* 1004 */         excuteCmdResult.addPlay(oppisitePlay, true);
/*      */         
/* 1006 */         Play oppisitePassivePlay = new Play();
/* 1007 */         PlaySummon oppisitePassivePlaySummon = sumFighter.getOppisitePlaySummon(playSummon, false);
/* 1008 */         oppisitePassivePlay.play_type = 2;
/* 1009 */         oppisitePassivePlay.content = oppisitePassivePlaySummon.marshal(new OctetsStream());
/* 1010 */         excuteCmdResult.addPlay(oppisitePassivePlay, false);
/*      */         
/* 1012 */         if (isRecordEnable()) {
/* 1013 */           Play play = new Play();
/* 1014 */           play.play_type = 2;
/* 1015 */           play.content = playSummon.marshal(new OctetsStream());
/* 1016 */           excuteCmdResult.addPlay(play);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1021 */     for (Fighter fighter : fighters) {
/* 1022 */       fighter.onEnterFight();
/* 1023 */       fighter.handleOnAftSummon(sumFighter, excuteCmdResult);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected List<Integer> getSummonMonsterPos()
/*      */   {
/* 1034 */     Set<Integer> positioins = new HashSet();
/* 1035 */     for (FightGroup fightGroup : getGroups()) {
/* 1036 */       for (Fighter fighter : fightGroup.getExistedFighters()) {
/* 1037 */         positioins.add(Integer.valueOf(fighter.getPos()));
/*      */       }
/*      */     }
/* 1040 */     List<Integer> retPosList = new ArrayList();
/* 1041 */     List<Integer> posPiorList = FightManager.getPosPiorList();
/*      */     
/* 1043 */     int posNumberPerRow = FightManager.getPosNumberPerRow();
/* 1044 */     int role_row_Move = 1 * posNumberPerRow;
/*      */     
/* 1046 */     for (Iterator i$ = posPiorList.iterator(); i$.hasNext();) { int pos = ((Integer)i$.next()).intValue();
/* 1047 */       int position = pos + role_row_Move;
/* 1048 */       if (!positioins.contains(Integer.valueOf(position)))
/*      */       {
/*      */ 
/* 1051 */         retPosList.add(Integer.valueOf(position));
/*      */       }
/*      */     }
/* 1054 */     int pet_row_Move = 0 * posNumberPerRow;
/*      */     
/* 1056 */     for (Iterator i$ = posPiorList.iterator(); i$.hasNext();) { int pos = ((Integer)i$.next()).intValue();
/* 1057 */       int position = pos + pet_row_Move;
/* 1058 */       if (!positioins.contains(Integer.valueOf(position)))
/*      */       {
/*      */ 
/* 1061 */         retPosList.add(Integer.valueOf(position));
/*      */       }
/*      */     }
/* 1064 */     int npc_row_Move = 2 * posNumberPerRow;
/* 1065 */     int position = npc_row_Move + ((Integer)posPiorList.get(0)).intValue();
/* 1066 */     if (!positioins.contains(Integer.valueOf(position))) {
/* 1067 */       retPosList.add(Integer.valueOf(position));
/*      */     }
/* 1069 */     return retPosList;
/*      */   }
/*      */   
/*      */   protected final FightGroupRole generateGroupRole() {
/* 1073 */     xbean.FightGroup xGroup = Pod.newFightGroup();
/* 1074 */     int groupid = this.fight.getNextID();
/* 1075 */     this.xTeam.getGroups().put(Integer.valueOf(groupid), xGroup);
/* 1076 */     xGroup.setType(0);
/* 1077 */     return new FightGroupRole(groupid, xGroup, this);
/*      */   }
/*      */   
/*      */   protected final FightGroupFellow generateGroupFellow() {
/* 1081 */     xbean.FightGroup xGroup = Pod.newFightGroup();
/* 1082 */     int groupid = this.fight.getNextID();
/* 1083 */     this.xTeam.getGroups().put(Integer.valueOf(groupid), xGroup);
/* 1084 */     xGroup.setType(2);
/* 1085 */     return new FightGroupFellow(groupid, xGroup, this);
/*      */   }
/*      */   
/*      */   protected final FightGroupMonster generateGroupMonster() {
/* 1089 */     xbean.FightGroup xGroup = Pod.newFightGroup();
/* 1090 */     int groupid = this.fight.getNextID();
/* 1091 */     this.xTeam.getGroups().put(Integer.valueOf(groupid), xGroup);
/* 1092 */     xGroup.setType(1);
/* 1093 */     return new FightGroupMonster(groupid, xGroup, this);
/*      */   }
/*      */   
/*      */   protected final FightGroupNpcMonster generateGroupNpcMonster() {
/* 1097 */     xbean.FightGroup xGroup = Pod.newFightGroup();
/* 1098 */     int groupid = this.fight.getNextID();
/* 1099 */     this.xTeam.getGroups().put(Integer.valueOf(groupid), xGroup);
/* 1100 */     xGroup.setType(1);
/* 1101 */     return new FightGroupNpcMonster(groupid, xGroup, this);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<FightGroup> getGroups()
/*      */   {
/* 1110 */     Set<FightGroup> groups = new HashSet();
/* 1111 */     for (Map.Entry<Integer, xbean.FightGroup> entry : this.xTeam.getGroups().entrySet()) {
/* 1112 */       int groupid = ((Integer)entry.getKey()).intValue();
/* 1113 */       xbean.FightGroup xGroup = (xbean.FightGroup)entry.getValue();
/* 1114 */       groups.add(FightManager.getFightGroup(groupid, xGroup, this));
/*      */     }
/* 1116 */     return groups;
/*      */   }
/*      */   
/*      */   protected final Set<FightGroupRole> getGroupRoles() {
/* 1120 */     Set<FightGroupRole> groups = new HashSet();
/* 1121 */     for (Map.Entry<Integer, xbean.FightGroup> entry : this.xTeam.getGroups().entrySet()) {
/* 1122 */       int groupid = ((Integer)entry.getKey()).intValue();
/* 1123 */       xbean.FightGroup xGroup = (xbean.FightGroup)entry.getValue();
/* 1124 */       FightGroup group = FightManager.getFightGroup(groupid, xGroup, this);
/* 1125 */       if ((group.isGroupRole()) && ((group instanceof FightGroupRole))) {
/* 1126 */         groups.add((FightGroupRole)group);
/*      */       }
/*      */     }
/* 1129 */     return groups;
/*      */   }
/*      */   
/*      */   protected final Set<FightGroupMonster> getGroupMonsters() {
/* 1133 */     Set<FightGroupMonster> groups = new HashSet();
/* 1134 */     for (Map.Entry<Integer, xbean.FightGroup> entry : this.xTeam.getGroups().entrySet()) {
/* 1135 */       int groupid = ((Integer)entry.getKey()).intValue();
/* 1136 */       xbean.FightGroup xgroup = (xbean.FightGroup)entry.getValue();
/* 1137 */       FightGroup group = FightManager.getFightGroup(groupid, xgroup, this);
/* 1138 */       if ((group.isGroupMonster()) && ((group instanceof FightGroupMonster))) {
/* 1139 */         groups.add((FightGroupMonster)group);
/*      */       }
/*      */     }
/* 1142 */     return groups;
/*      */   }
/*      */   
/*      */   protected final Set<FightGroupFellow> getGroupFellows() {
/* 1146 */     Set<FightGroupFellow> groups = new HashSet();
/* 1147 */     for (Map.Entry<Integer, xbean.FightGroup> entry : this.xTeam.getGroups().entrySet()) {
/* 1148 */       int groupid = ((Integer)entry.getKey()).intValue();
/* 1149 */       xbean.FightGroup xGroup = (xbean.FightGroup)entry.getValue();
/* 1150 */       FightGroup group = FightManager.getFightGroup(groupid, xGroup, this);
/* 1151 */       if ((group.isGroupFellow()) && ((group instanceof FightGroupFellow))) {
/* 1152 */         groups.add((FightGroupFellow)group);
/*      */       }
/*      */     }
/* 1155 */     return groups;
/*      */   }
/*      */   
/*      */   protected final FightGroupRole getGroupRole(long roleid) {
/* 1159 */     for (Map.Entry<Integer, xbean.FightGroup> entry : this.xTeam.getGroups().entrySet()) {
/* 1160 */       int groupid = ((Integer)entry.getKey()).intValue();
/* 1161 */       xbean.FightGroup xGroup = (xbean.FightGroup)entry.getValue();
/* 1162 */       FightGroup group = FightManager.getFightGroup(groupid, xGroup, this);
/* 1163 */       if (group.isGroupRole()) {
/* 1164 */         FightGroupRole groupRole = (FightGroupRole)group;
/* 1165 */         if (groupRole.getRoleid() == roleid) {
/* 1166 */           return groupRole;
/*      */         }
/*      */       }
/*      */     }
/* 1170 */     return null;
/*      */   }
/*      */   
/*      */   protected Fighter getFighter(int fighterid) {
/* 1174 */     for (FightGroup fightGroup : getGroups()) {
/* 1175 */       Fighter fighter = fightGroup.getFighter(fighterid);
/* 1176 */       if (fighter != null) {
/* 1177 */         return fighter;
/*      */       }
/*      */     }
/* 1180 */     return null;
/*      */   }
/*      */   
/*      */   protected Fighter getFighterLeaved(int fighterId) {
/* 1184 */     for (FightGroup fightGroup : getGroups()) {
/* 1185 */       for (Fighter fighter : fightGroup.getLeaveFightFighters()) {
/* 1186 */         if (fighter.fighterid == fighterId) {
/* 1187 */           return fighter;
/*      */         }
/*      */       }
/*      */     }
/* 1191 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected List<Long> getTeamRoleids()
/*      */   {
/* 1200 */     Set<FightGroupRole> groupRoles = getGroupRoles();
/* 1201 */     if (groupRoles.size() <= 0) {
/* 1202 */       return new ArrayList();
/*      */     }
/* 1204 */     List<Integer> groupids = new ArrayList();
/* 1205 */     Map<Integer, Long> groupIdToRoleIds = new HashMap();
/* 1206 */     for (FightGroupRole groupRole : groupRoles) {
/* 1207 */       groupids.add(Integer.valueOf(groupRole.groupid));
/* 1208 */       groupIdToRoleIds.put(Integer.valueOf(groupRole.groupid), Long.valueOf(groupRole.getRoleid()));
/*      */     }
/* 1210 */     Collections.sort(groupids);
/* 1211 */     List<Long> roleIds = new ArrayList();
/* 1212 */     for (Iterator i$ = groupids.iterator(); i$.hasNext();) { int groupid = ((Integer)i$.next()).intValue();
/* 1213 */       roleIds.add(groupIdToRoleIds.get(Integer.valueOf(groupid)));
/*      */     }
/* 1215 */     return roleIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Long> getBroadcastRoles()
/*      */   {
/* 1224 */     Set<Long> roles = new HashSet();
/* 1225 */     for (FightGroupRole gr : getGroupRoles()) {
/* 1226 */       if ((!gr.isRoleEscape()) && (!gr.isCloneGroup())) {
/* 1227 */         roles.add(Long.valueOf(gr.getRoleid()));
/*      */       }
/*      */     }
/* 1230 */     return roles;
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
/*      */   protected Set<Long> getLockRoles()
/*      */   {
/* 1273 */     Set<Long> roles = new HashSet();
/* 1274 */     for (FightGroupRole gr : getGroupRoles()) {
/* 1275 */       if (!gr.isRoleEscape()) {
/* 1276 */         roles.add(Long.valueOf(gr.getRoleid()));
/*      */       }
/*      */     }
/* 1279 */     return roles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Long> getFightRoles()
/*      */   {
/* 1288 */     Set<Long> roles = new HashSet();
/* 1289 */     for (FightGroupRole gr : getGroupRoles()) {
/* 1290 */       if ((!gr.isRoleEscape()) && (!gr.isCloneGroup())) {
/* 1291 */         roles.add(Long.valueOf(gr.getRoleid()));
/*      */       }
/*      */     }
/* 1294 */     return roles;
/*      */   }
/*      */   
/*      */   public Set<Long> getOperatorRoles() {
/* 1298 */     Set<Long> roles = new HashSet();
/* 1299 */     for (Iterator i$ = getGroupRoles().iterator(); i$.hasNext();) { gr = (FightGroupRole)i$.next();
/* 1300 */       for (Fighter fighter : gr.getFighters()) {
/* 1301 */         if (((fighter instanceof FighterRole)) && 
/* 1302 */           (!fighter.isEscaped())) {
/* 1303 */           roles.add(Long.valueOf(gr.getRoleid()));
/*      */         }
/*      */       }
/*      */     }
/*      */     FightGroupRole gr;
/* 1308 */     return roles;
/*      */   }
/*      */   
/*      */   protected List<Integer> getAllMonsters() {
/* 1312 */     List<Integer> monsters = new ArrayList();
/* 1313 */     for (FightGroupMonster gr : getGroupMonsters()) {
/* 1314 */       for (Fighter fighter : gr.getFighters()) {
/* 1315 */         if ((fighter instanceof FighterMonster)) {
/* 1316 */           monsters.add(Integer.valueOf(((FighterMonster)fighter).getMonsterid()));
/*      */         }
/*      */       }
/* 1319 */       for (Fighter fighter : gr.getLeaveFightFighters()) {
/* 1320 */         if ((fighter instanceof FighterMonster)) {
/* 1321 */           monsters.add(Integer.valueOf(((FighterMonster)fighter).getMonsterid()));
/*      */         }
/*      */       }
/*      */     }
/* 1325 */     return monsters;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void onEnterFight()
/*      */   {
/* 1332 */     for (FightGroup group : getGroups()) {
/* 1333 */       group.onEnterFight();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void onRoundBefore()
/*      */   {
/* 1341 */     for (FightGroup group : getGroups()) {
/* 1342 */       group.onRoundBefore();
/*      */     }
/*      */   }
/*      */   
/*      */   protected final void onRoundPrapare2() {
/* 1347 */     for (FightGroup group : getGroups()) {
/* 1348 */       group.onRoundPrapare2();
/*      */     }
/*      */   }
/*      */   
/*      */   protected final void onRoundPrapare1() {
/* 1353 */     for (FightGroup group : getGroups()) {
/* 1354 */       group.onRoundPrapare1();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void onPlayBefore()
/*      */   {
/* 1362 */     for (FightGroup group : getGroups()) {
/* 1363 */       group.onPlayBefore();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void onRoundEnd()
/*      */   {
/* 1371 */     for (FightGroup group : getGroups()) {
/* 1372 */       group.onRoundEnd();
/*      */     }
/*      */   }
/*      */   
/*      */   protected void onFighterDie(int fid) {
/* 1377 */     for (FightGroup group : getGroups()) {
/* 1378 */       group.onFighterDie(fid);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void onFighterRelive(int fid) {
/* 1383 */     for (FightGroup group : getGroups()) {
/* 1384 */       group.onFighterRelive(fid);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected final void onFightEnd()
/*      */   {
/* 1392 */     for (FightGroup group : getGroups()) {
/* 1393 */       if ((group instanceof FightGroupRole)) {
/* 1394 */         FightGroupRole groupRole = (FightGroupRole)group;
/* 1395 */         if (groupRole.isRoleEscape()) {}
/*      */       }
/*      */       else
/*      */       {
/* 1399 */         group.onFightEnd();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addTeamEffect(TeamEffect teamEffect)
/*      */   {
/* 1410 */     this.xTeam.getTeameffects().add(teamEffect);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Set<TeamEffect> getAllTeamEffects()
/*      */   {
/* 1419 */     Set<TeamEffect> effects = new HashSet();
/* 1420 */     for (TeamEffect teamEffect : this.xTeam.getTeameffects()) {
/* 1421 */       effects.add(teamEffect);
/*      */     }
/* 1423 */     return effects;
/*      */   }
/*      */   
/*      */   protected final void fillFightTeamBean(mzm.gsp.fight.FightTeam fightTeamBean) {
/* 1427 */     for (FightGroup fightGroup : getGroups()) {
/* 1428 */       mzm.gsp.fight.FightGroup fightGroupBean = fightGroup.getFightGroupBean();
/* 1429 */       fightTeamBean.groups.put(Integer.valueOf(fightGroup.groupid), fightGroupBean);
/*      */     }
/*      */     
/* 1432 */     fightTeamBean.zhenfaid = getZhenFaid();
/* 1433 */     fightTeamBean.zhenfalevel = getZhenFaLevel();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Fighter> getFighters()
/*      */   {
/* 1442 */     return getSelectedFighters(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Fighter> getExistedFighters()
/*      */   {
/* 1451 */     return getSelectedFighters(new ExistedFighterSelector());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final Set<Fighter> getAliveFighters()
/*      */   {
/* 1460 */     return getSelectedFighters(new AliveFighterSelector());
/*      */   }
/*      */   
/*      */   protected final Set<Fighter> getSelectedFighters(FighterSelector selector) {
/* 1464 */     Set<Fighter> fighters = new HashSet();
/* 1465 */     for (FightGroup group : getGroups()) {
/* 1466 */       fighters.addAll(group.getSelectedFighters(selector));
/*      */     }
/* 1468 */     return fighters;
/*      */   }
/*      */   
/*      */   protected void setZhenFaid(int zhenFaid) {
/* 1472 */     setExtra(FightTeamExtra.ZHEN_FA_ID, zhenFaid);
/*      */   }
/*      */   
/*      */   protected int getZhenFaid() {
/* 1476 */     return getExtra(FightTeamExtra.ZHEN_FA_ID);
/*      */   }
/*      */   
/*      */   protected void setZhenFaLevel(int zhenFaLevel) {
/* 1480 */     setExtra(FightTeamExtra.ZHEN_FA_LEVEL, zhenFaLevel);
/*      */   }
/*      */   
/*      */   protected int getZhenFaLevel() {
/* 1484 */     return getExtra(FightTeamExtra.ZHEN_FA_LEVEL);
/*      */   }
/*      */   
/*      */   protected int getDeadTimes() {
/* 1488 */     return getExtra(FightTeamExtra.DEAD_TIMES);
/*      */   }
/*      */   
/*      */   private void setExtra(FightTeamExtra fightTeamExtra, int value) {
/* 1492 */     if (value == 0) {
/* 1493 */       this.xTeam.getExtra().remove(Integer.valueOf(fightTeamExtra.ordinal()));
/*      */     } else {
/* 1495 */       this.xTeam.getExtra().put(Integer.valueOf(fightTeamExtra.ordinal()), Integer.valueOf(value));
/*      */     }
/*      */   }
/*      */   
/*      */   private int getExtra(FightTeamExtra fightTeamExtra) {
/* 1500 */     Integer value = (Integer)this.xTeam.getExtra().get(Integer.valueOf(fightTeamExtra.ordinal()));
/* 1501 */     if (value == null) {
/* 1502 */       return 0;
/*      */     }
/* 1504 */     return value.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void addDeadTimes()
/*      */   {
/* 1512 */     int deadTimes = getExtra(FightTeamExtra.DEAD_TIMES);
/* 1513 */     setExtra(FightTeamExtra.DEAD_TIMES, ++deadTimes);
/*      */   }
/*      */   
/*      */   protected Set<Fighter> getOccupationFighters(int occupation) {
/* 1517 */     Set<Fighter> fighters = new HashSet();
/* 1518 */     Set<FightGroup> activiteGroup = getGroups();
/* 1519 */     for (FightGroup group : activiteGroup) {
/* 1520 */       fighters.addAll(group.getOccupationFighters(occupation));
/*      */     }
/* 1522 */     return fighters;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final void broadcast(Protocol p)
/*      */   {
/* 1532 */     OnlineManager.getInstance().sendMulti(p, getBroadcastRoles());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   List<FightCmd> getFightTeamCmd()
/*      */   {
/* 1541 */     List<FightCmd> fightCmds = new ArrayList();
/* 1542 */     for (Fighter fighter : getExistedFighters()) {
/* 1543 */       FightCmd xFightCmd = this.fight.getFightCmd(fighter.fighterid);
/* 1544 */       if (xFightCmd != null) {
/* 1545 */         fightCmds.add(xFightCmd);
/*      */       }
/*      */     }
/* 1548 */     return fightCmds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   List<FightCmd> getTeamRoleAndPetCmd()
/*      */   {
/* 1557 */     List<FightCmd> fightCmds = new ArrayList();
/* 1558 */     for (Fighter fighter : getExistedFighters()) {
/* 1559 */       if ((fighter.isRole()) || (fighter.isPet()) || (fighter.isChild())) {
/* 1560 */         FightCmd xFightCmd = this.fight.getFightCmd(fighter.fighterid);
/* 1561 */         if (xFightCmd != null) {
/* 1562 */           fightCmds.add(xFightCmd);
/*      */         }
/*      */       }
/*      */     }
/* 1566 */     return fightCmds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isRoleCapture()
/*      */   {
/* 1575 */     for (Fighter fighter : getExistedFighters()) {
/* 1576 */       FightCmd xFightCmd = this.fight.getFightCmd(fighter.fighterid);
/* 1577 */       if ((xFightCmd != null) && 
/* 1578 */         (xFightCmd.getOp_type() == 2)) {
/* 1579 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1583 */     return false;
/*      */   }
/*      */   
/*      */   void setTeamAssistFellowNum(int value) {
/* 1587 */     this.xTeam.setAssistfellownum(value);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getTeamAssistFellowNum()
/*      */   {
/* 1596 */     return this.xTeam.getAssistfellownum();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getDeathSkillCommonEffectRound()
/*      */   {
/* 1605 */     Integer value = (Integer)this.xTeam.getExtra().get(Integer.valueOf(FightTeamExtra.DEATH_SKILL_COMMON_EFFECT_ROUND.ordinal()));
/* 1606 */     if (value == null) {
/* 1607 */       return -1;
/*      */     }
/* 1609 */     return value.intValue();
/*      */   }
/*      */   
/*      */   void setDeathSkillCommonEffectRound(int round)
/*      */   {
/* 1614 */     this.xTeam.getExtra().put(Integer.valueOf(FightTeamExtra.DEATH_SKILL_COMMON_EFFECT_ROUND.ordinal()), Integer.valueOf(round));
/*      */   }
/*      */   
/*      */   void initAITeamVariable() {
/* 1618 */     if (this.xTeam.getAiteamvariable() == null) {
/* 1619 */       this.xTeam.setAiteamvariable(new FightInfo.AITeamVariable());
/*      */     }
/*      */   }
/*      */   
/*      */   void setTeamAIVariable1(int variable1) {
/* 1624 */     this.xTeam.getAiteamvariable().var1 = variable1;
/*      */   }
/*      */   
/*      */   int getTeamAIVariable1() {
/* 1628 */     return this.xTeam.getAiteamvariable().var1;
/*      */   }
/*      */   
/*      */   void setTeamAIVariable2(int variable2) {
/* 1632 */     this.xTeam.getAiteamvariable().var2 = variable2;
/*      */   }
/*      */   
/*      */   int getTeamAIVariable2() {
/* 1636 */     return this.xTeam.getAiteamvariable().var2;
/*      */   }
/*      */   
/*      */   void setTeamAIVariable3(int variable3) {
/* 1640 */     this.xTeam.getAiteamvariable().var3 = variable3;
/*      */   }
/*      */   
/*      */   int getTeamAIVariable3() {
/* 1644 */     return this.xTeam.getAiteamvariable().var3;
/*      */   }
/*      */   
/*      */   void setTeamAIVariable4(int variable4) {
/* 1648 */     this.xTeam.getAiteamvariable().var4 = variable4;
/*      */   }
/*      */   
/*      */   int getTeamAIVariable4() {
/* 1652 */     return this.xTeam.getAiteamvariable().var4;
/*      */   }
/*      */   
/*      */   void setTeamAIVariable5(int variable5) {
/* 1656 */     this.xTeam.getAiteamvariable().var5 = variable5;
/*      */   }
/*      */   
/*      */   int getTeamAIVariable5() {
/* 1660 */     return this.xTeam.getAiteamvariable().var5;
/*      */   }
/*      */   
/*      */   void setTeamAIVariable6(int variable6) {
/* 1664 */     this.xTeam.getAiteamvariable().var6 = variable6;
/*      */   }
/*      */   
/*      */   int getTeamAIVariable6() {
/* 1668 */     return this.xTeam.getAiteamvariable().var6;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */