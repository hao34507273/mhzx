/*      */ package mzm.gsp.skill.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.effect.fighter.DeathBombing.DeathSkillCommonCDInputObj;
/*      */ import mzm.gsp.effect.fighter.DeathSkill.DeathSkillInputObj;
/*      */ import mzm.gsp.effect.main.EffectInterface;
/*      */ import mzm.gsp.effect.main.FighterEffectGroup;
/*      */ import mzm.gsp.fight.AttackOtherBean;
/*      */ import mzm.gsp.fight.AttackOtherBeanResult;
/*      */ import mzm.gsp.fight.AttackResult;
/*      */ import mzm.gsp.fight.AttackResultBean;
/*      */ import mzm.gsp.fight.CounterAttack;
/*      */ import mzm.gsp.fight.FighterStatus;
/*      */ import mzm.gsp.fight.HitAgain;
/*      */ import mzm.gsp.fight.InfluenceOther;
/*      */ import mzm.gsp.fight.Play;
/*      */ import mzm.gsp.fight.PlaySkill;
/*      */ import mzm.gsp.fight.Protect;
/*      */ import mzm.gsp.fight.ShareDamageRet;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*      */ import mzm.gsp.fight.durationCfg.DurationCfgManager;
/*      */ import mzm.gsp.fight.fighter.comparator.HpComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.HpPercentRateComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MAGATKComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MAGDEFComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MpComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MpPercentRateComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.PHYATKComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.PHYDEFComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.SpeedComparator;
/*      */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*      */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*      */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*      */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*      */ import mzm.gsp.fight.handle.KillOtherHandle.InputObj;
/*      */ import mzm.gsp.fight.handle.KillOtherHandle.OutputObj;
/*      */ import mzm.gsp.fight.handle.TargetNumHandle.InputObj;
/*      */ import mzm.gsp.fight.handle.TargetNumHandle.OutputObj;
/*      */ import mzm.gsp.fight.main.FightInterface;
/*      */ import mzm.gsp.fight.main.FightUtil;
/*      */ import mzm.gsp.fight.main.Fighter;
/*      */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*      */ import mzm.gsp.fight.main.FighterBuff;
/*      */ import mzm.gsp.fight.main.FighterMonster;
/*      */ import mzm.gsp.fight.main.FighterRole;
/*      */ import mzm.gsp.marriage.main.MarriageInterface;
/*      */ import mzm.gsp.skill.confbean.ActionData;
/*      */ import mzm.gsp.skill.confbean.BeAttackedBean;
/*      */ import mzm.gsp.skill.confbean.EffectPlayData;
/*      */ import mzm.gsp.skill.confbean.Effectid2LateTime;
/*      */ import mzm.gsp.skill.confbean.FightStateSkillPlay;
/*      */ import mzm.gsp.skill.confbean.PosSortRule;
/*      */ import mzm.gsp.skill.confbean.SBeAttackFlyCfg;
/*      */ import mzm.gsp.skill.confbean.SMoveAction;
/*      */ import mzm.gsp.skill.confbean.SSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillPlayCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillPlayMapCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillPlayStageCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillTargetPosSortCfg;
/*      */ import mzm.gsp.skill.formula.fighter.SkillFormula;
/*      */ import mzm.gsp.skill.formula.fighter.SkillFormulaFactory;
/*      */ import org.apache.log4j.Logger;
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
/*      */ public class Skill
/*      */ {
/*      */   private final SSkillCfg skillCfg;
/*      */   private int skillLv;
/*   92 */   private int playTime = 0;
/*      */   
/*   94 */   private int targetSize = 1;
/*      */   
/*      */ 
/*      */   private int mainTargetId;
/*      */   
/*      */   private FighterStatus fighterStatus;
/*      */   
/*      */   private FighterStatus afterFighterStatus;
/*      */   
/*  103 */   private List<Integer> targets = new ArrayList();
/*      */   
/*      */ 
/*  106 */   private final List<Integer> effectTargets = new ArrayList();
/*      */   
/*  108 */   private Map<Integer, Map<Integer, FighterStatus>> targetInfluenceMap = new HashMap();
/*      */   
/*  110 */   private List<Play> passivePlays = new LinkedList();
/*      */   
/*  112 */   private List<Play> activePlays = new LinkedList();
/*      */   
/*  114 */   private List<Play> recordPlays = new LinkedList();
/*      */   
/*  116 */   private int playType = 0;
/*      */   
/*  118 */   private HashMap<Integer, Integer> extra = new HashMap();
/*      */   
/*  120 */   private Map<Integer, AttackResult> attackResultMap = new HashMap();
/*      */   
/*  122 */   private Map<Integer, HitAgain> hitAgainMap = new HashMap();
/*      */   
/*  124 */   private Map<Integer, Protect> protectMap = new HashMap();
/*      */   
/*  126 */   private Map<Integer, List<Integer>> deathSkillFid2Skillid = new HashMap();
/*      */   
/*      */ 
/*  129 */   private Map<Integer, DeathSkill.DeathSkillInputObj> deathSkillMap = new HashMap();
/*      */   
/*  131 */   private Map<Integer, DeathBombing.DeathSkillCommonCDInputObj> deathSkillWithCommonCDMap = new HashMap();
/*      */   
/*  133 */   public List<Fighter> willCounteringFighters = new ArrayList();
/*      */   
/*      */ 
/*  136 */   public Map<Integer, Integer> replacedEffectGroup = new HashMap();
/*      */   
/*      */   Skill(SSkillCfg skillCfg, int skillLV) {
/*  139 */     this.skillCfg = skillCfg;
/*  140 */     this.skillLv = skillLV;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getID()
/*      */   {
/*  147 */     return this.skillCfg.id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  156 */     return this.skillLv;
/*      */   }
/*      */   
/*      */   public void modifyLevel(int modifyLv) {
/*  160 */     this.skillLv += modifyLv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getType()
/*      */   {
/*  169 */     return this.skillCfg.type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getSpecialType()
/*      */   {
/*  178 */     return this.skillCfg.specialType;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean canBeProtect()
/*      */   {
/*  187 */     return this.skillCfg.canBeProtect;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SSkillCfg getSkillCfg()
/*      */   {
/*  196 */     return this.skillCfg;
/*      */   }
/*      */   
/*      */   public int getTargetSize() {
/*  200 */     return this.targetSize;
/*      */   }
/*      */   
/*      */   public int getMainTargetId() {
/*  204 */     return this.mainTargetId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getPlayTime()
/*      */   {
/*  213 */     return this.playTime;
/*      */   }
/*      */   
/*      */   public boolean isDeathSkill() {
/*  217 */     return this.playType == 4;
/*      */   }
/*      */   
/*      */   public void putDeathSkill(int fighterid, DeathSkill.DeathSkillInputObj deathSkillInputObj) {
/*  221 */     this.deathSkillMap.put(Integer.valueOf(fighterid), deathSkillInputObj);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Integer, DeathSkill.DeathSkillInputObj> getDeathSkillMap()
/*      */   {
/*  230 */     return this.deathSkillMap;
/*      */   }
/*      */   
/*      */   public void putDeathSkillWithCommonCD(int fighterid, DeathBombing.DeathSkillCommonCDInputObj commonCDInputObj) {
/*  234 */     this.deathSkillWithCommonCDMap.put(Integer.valueOf(fighterid), commonCDInputObj);
/*      */   }
/*      */   
/*      */   public Map<Integer, DeathBombing.DeathSkillCommonCDInputObj> getDeathSkillWithCommonCD() {
/*  238 */     return this.deathSkillWithCommonCDMap;
/*      */   }
/*      */   
/*      */   public void putTrulyDeathSkill(int fighterid, int skillid) {
/*  242 */     List<Integer> skillids = (List)this.deathSkillFid2Skillid.get(Integer.valueOf(fighterid));
/*  243 */     if (skillids == null) {
/*  244 */       skillids = new ArrayList();
/*  245 */       this.deathSkillFid2Skillid.put(Integer.valueOf(fighterid), skillids);
/*      */     }
/*      */     
/*  248 */     skillids.add(Integer.valueOf(skillid));
/*      */   }
/*      */   
/*      */   public Map<Integer, List<Integer>> getDeathFighter2Skillid() {
/*  252 */     return this.deathSkillFid2Skillid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addPlayTime(int time)
/*      */   {
/*  261 */     this.playTime += time;
/*      */   }
/*      */   
/*      */   public FighterStatus getSkillUseFighterStatus() {
/*  265 */     if (this.fighterStatus == null)
/*  266 */       this.fighterStatus = new FighterStatus();
/*  267 */     return this.fighterStatus;
/*      */   }
/*      */   
/*      */   public FighterStatus getAfterSkillUseFighterStatus() {
/*  271 */     if (this.afterFighterStatus == null) {
/*  272 */       this.afterFighterStatus = new FighterStatus();
/*      */     }
/*  274 */     return this.afterFighterStatus;
/*      */   }
/*      */   
/*      */   public List<Integer> getTargets() {
/*  278 */     return this.targets;
/*      */   }
/*      */   
/*      */   public void addTarget(int targetid) {
/*  282 */     if (this.targets.contains(Integer.valueOf(targetid))) {
/*  283 */       return;
/*      */     }
/*  285 */     this.targets.add(Integer.valueOf(targetid));
/*      */   }
/*      */   
/*      */   public List<Play> getActivePlays() {
/*  289 */     return this.activePlays;
/*      */   }
/*      */   
/*      */   public List<Play> getPassivePlays() {
/*  293 */     return this.passivePlays;
/*      */   }
/*      */   
/*      */   public void addPlay(Play play, boolean active) {
/*  297 */     if (active) {
/*  298 */       this.activePlays.add(play);
/*      */     } else {
/*  300 */       this.passivePlays.add(play);
/*      */     }
/*      */   }
/*      */   
/*      */   public void addPlayFirst(Play play, boolean active) {
/*  305 */     if (active) {
/*  306 */       this.activePlays.add(0, play);
/*      */     } else {
/*  308 */       this.passivePlays.add(0, play);
/*      */     }
/*      */   }
/*      */   
/*      */   public void addAllPlay(List<Play> plays, boolean active) {
/*  313 */     if (active) {
/*  314 */       this.activePlays.addAll(plays);
/*      */     } else {
/*  316 */       this.passivePlays.addAll(plays);
/*      */     }
/*      */   }
/*      */   
/*      */   public List<Play> getRecordPlays() {
/*  321 */     return this.recordPlays;
/*      */   }
/*      */   
/*      */   public void addPlay(Play play) {
/*  325 */     this.recordPlays.add(play);
/*      */   }
/*      */   
/*      */   public void addPlayFirst(Play play) {
/*  329 */     this.recordPlays.add(0, play);
/*      */   }
/*      */   
/*      */   public void addAllPlay(List<Play> plays) {
/*  333 */     this.recordPlays.addAll(plays);
/*      */   }
/*      */   
/*      */   public Map<Integer, AttackResult> getAttackResultMap() {
/*  337 */     return this.attackResultMap;
/*      */   }
/*      */   
/*      */   public Map<Integer, HitAgain> getHitAgainMap() {
/*  341 */     return this.hitAgainMap;
/*      */   }
/*      */   
/*      */   public Map<Integer, Protect> getProtectMap() {
/*  345 */     return this.protectMap;
/*      */   }
/*      */   
/*      */   public Map<Integer, Map<Integer, FighterStatus>> getTargetInfluenceMap() {
/*  349 */     return this.targetInfluenceMap;
/*      */   }
/*      */   
/*      */   public void setPlayType(int playType) {
/*  353 */     this.playType = playType;
/*      */   }
/*      */   
/*      */   public int getPlayType() {
/*  357 */     return this.playType;
/*      */   }
/*      */   
/*      */   public void addExtraPLayData(int key, int value) {
/*  361 */     this.extra.put(Integer.valueOf(key), Integer.valueOf(value));
/*      */   }
/*      */   
/*      */   public HashMap<Integer, Integer> getExtra() {
/*  365 */     return this.extra;
/*      */   }
/*      */   
/*      */   public AttackResult getAttackResult(int targetid) {
/*  369 */     if (this.attackResultMap.containsKey(Integer.valueOf(targetid))) {
/*  370 */       return (AttackResult)this.attackResultMap.get(Integer.valueOf(targetid));
/*      */     }
/*  372 */     AttackResult attackResult = new AttackResult();
/*  373 */     this.attackResultMap.put(Integer.valueOf(targetid), attackResult);
/*  374 */     return attackResult;
/*      */   }
/*      */   
/*      */   public Attack getAttackCount(int targetid)
/*      */   {
/*  379 */     Attack attack = new Attack();
/*  380 */     if (this.attackResultMap.containsKey(Integer.valueOf(targetid))) {
/*  381 */       AttackResult attackResult = (AttackResult)this.attackResultMap.get(Integer.valueOf(targetid));
/*  382 */       for (AttackResultBean attackResultBean : attackResult.attackresultbeans) {
/*  383 */         if (attackResultBean.targetstatus.status_set.contains(Integer.valueOf(24))) {
/*  384 */           attack.addComBoCount(1);
/*      */         } else {
/*  386 */           attack.addNormalCount(1);
/*      */         }
/*  388 */         attack.addNormalCount(attackResultBean.attackothers.size());
/*      */       }
/*      */     }
/*  391 */     return attack;
/*      */   }
/*      */   
/*      */   public static class Attack {
/*      */     private static final int ATTACK_NORMAL = 1;
/*      */     private static final int ATTACK_COMBO = 2;
/*  397 */     private Map<Integer, Integer> typeAndCountMap = new HashMap();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addNormalCount(int count)
/*      */     {
/*  404 */       if (this.typeAndCountMap.containsKey(Integer.valueOf(1))) {
/*  405 */         count += ((Integer)this.typeAndCountMap.get(Integer.valueOf(1))).intValue();
/*      */       }
/*  407 */       this.typeAndCountMap.put(Integer.valueOf(1), Integer.valueOf(count));
/*      */     }
/*      */     
/*      */     public int getAttackNormalCount() {
/*  411 */       if (this.typeAndCountMap.containsKey(Integer.valueOf(1))) {
/*  412 */         return ((Integer)this.typeAndCountMap.get(Integer.valueOf(1))).intValue();
/*      */       }
/*  414 */       return 0;
/*      */     }
/*      */     
/*      */     public void addComBoCount(int count)
/*      */     {
/*  419 */       if (this.typeAndCountMap.containsKey(Integer.valueOf(2))) {
/*  420 */         count += ((Integer)this.typeAndCountMap.get(Integer.valueOf(2))).intValue();
/*      */       }
/*  422 */       this.typeAndCountMap.put(Integer.valueOf(2), Integer.valueOf(count));
/*      */     }
/*      */     
/*      */     public int getComBoCount() {
/*  426 */       if (this.typeAndCountMap.containsKey(Integer.valueOf(2))) {
/*  427 */         return ((Integer)this.typeAndCountMap.get(Integer.valueOf(2))).intValue();
/*      */       }
/*  429 */       return 0;
/*      */     }
/*      */   }
/*      */   
/*      */   public HitAgain getHitAgain(int targetid)
/*      */   {
/*  435 */     if (this.hitAgainMap.containsKey(Integer.valueOf(targetid))) {
/*  436 */       return (HitAgain)this.hitAgainMap.get(Integer.valueOf(targetid));
/*      */     }
/*  438 */     HitAgain hitAgain = new HitAgain();
/*  439 */     this.hitAgainMap.put(Integer.valueOf(targetid), hitAgain);
/*  440 */     return hitAgain;
/*      */   }
/*      */   
/*      */   public Protect getProtect(int targetid)
/*      */   {
/*  445 */     if (this.protectMap.containsKey(Integer.valueOf(targetid))) {
/*  446 */       return (Protect)this.protectMap.get(Integer.valueOf(targetid));
/*      */     }
/*  448 */     Protect protect = new Protect();
/*  449 */     this.protectMap.put(Integer.valueOf(targetid), protect);
/*  450 */     return protect;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void calTargetSize(Fighter fighter)
/*      */   {
/*  461 */     SkillFormula skillFormula = SkillFormulaFactory.getFormula(this.skillCfg.targetnumformula);
/*  462 */     if (skillFormula == null) {
/*  463 */       GameServer.logger().error("没有找到技能目标数量的公式,公式id:" + this.skillCfg.targetnumformula);
/*  464 */       return;
/*      */     }
/*  466 */     this.targetSize = skillFormula.calc(this, fighter);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int calTagetSize(Fighter fighter)
/*      */   {
/*  477 */     SkillFormula skillFormula = SkillFormulaFactory.getFormula(this.skillCfg.targetnumformula);
/*  478 */     if (skillFormula == null) {
/*  479 */       GameServer.logger().error("没有找到技能目标数量的公式,公式id:" + this.skillCfg.targetnumformula);
/*  480 */       return 1;
/*      */     }
/*  482 */     return skillFormula.calc(this, fighter);
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
/*      */   public List<Fighter> getTargets(Fighter fighter, int mainTargetId, boolean triggerTargetHandle)
/*      */   {
/*  497 */     List<Fighter> targets = getScacleTarget(fighter, mainTargetId);
/*      */     
/*  499 */     if (targets.size() <= 0) {
/*  500 */       return targets;
/*      */     }
/*      */     
/*      */ 
/*  504 */     calTargetSize(fighter);
/*      */     
/*  506 */     int finalSize = this.targetSize;
/*      */     
/*  508 */     if (triggerTargetHandle) {
/*  509 */       TargetNumHandle.InputObj inputObj = new TargetNumHandle.InputObj(fighter, this, this.targetSize, targets.size());
/*      */       
/*  511 */       TargetNumHandle.OutputObj outputObj = fighter.handleonTargetNum(inputObj);
/*  512 */       getSkillUseFighterStatus().triggerpassiveskills.addAll(outputObj.passiveSkillids);
/*  513 */       if (outputObj.finalTargetNum > 0) {
/*  514 */         finalSize = outputObj.finalTargetNum;
/*      */       }
/*      */     }
/*      */     
/*  518 */     if (finalSize >= targets.size()) {
/*  519 */       return targets;
/*      */     }
/*      */     
/*  522 */     List<Fighter> retTargets = new ArrayList();
/*  523 */     for (int index = 0; (index < finalSize) && (index < targets.size()); index++) {
/*  524 */       retTargets.add(targets.get(index));
/*      */     }
/*  526 */     return retTargets;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Fighter> getScacleTarget(Fighter fighter, int mainTargetId)
/*      */   {
/*  536 */     Set<Fighter> fighters = FightUtil.getTargets(fighter, this.skillCfg.skilltargettype1, this.skillCfg.skilltargettype2, this.skillCfg.skilltargettype3, this.skillCfg.skilltargettype4);
/*      */     
/*      */ 
/*  539 */     LinkedList<Fighter> sortTargets = sortTargets(fighters);
/*      */     
/*  541 */     if (!fighter.isVisible())
/*      */     {
/*  543 */       Iterator<Fighter> iterator = sortTargets.iterator();
/*  544 */       while (iterator.hasNext()) {
/*  545 */         Fighter targetFighter = (Fighter)iterator.next();
/*  546 */         if (targetFighter.isInvisible()) {
/*  547 */           iterator.remove();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  553 */     if ((fighter.isRole()) && ((fighter instanceof FighterRole)) && 
/*  554 */       (SkillInterface.isMarrySkill(this.skillCfg.id))) {
/*  555 */       long roleid = ((FighterRole)fighter).getRoleid();
/*  556 */       long marriedRoleid = MarriageInterface.getMarriedRoleid(roleid);
/*  557 */       Iterator<Fighter> iterator = sortTargets.iterator();
/*  558 */       while (iterator.hasNext()) {
/*  559 */         Fighter targetFighter = (Fighter)iterator.next();
/*  560 */         if ((targetFighter.isRole()) && ((targetFighter instanceof FighterRole))) {
/*  561 */           long targetRoleid = ((FighterRole)targetFighter).getRoleid();
/*  562 */           if (marriedRoleid != targetRoleid) {
/*  563 */             iterator.remove();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  571 */     int secondSort = fighter.getFightTypeCfg().secondSort;
/*  572 */     if (secondSort > 0) {
/*  573 */       Fighter mainTarget = fighter.getFighter(mainTargetId);
/*  574 */       if ((null == mainTarget) || (mainTarget.isDead()) || (mainTarget.isFakeDead())) {
/*  575 */         if (null == mainTarget) {
/*  576 */           mainTarget = fighter.getFighterFromAll(mainTargetId);
/*      */         }
/*  578 */         if (mainTarget != null) {
/*  579 */           int mainTargetPos = mainTarget.getPos();
/*  580 */           SSkillTargetPosSortCfg sortCfg = SSkillTargetPosSortCfg.get(secondSort);
/*  581 */           Map<Integer, Integer> sortMap = ((PosSortRule)sortCfg.posSortMap.get(Integer.valueOf(mainTargetPos))).sortPosMap;
/*  582 */           sortTargets = sortTargets(sortMap, sortTargets);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  589 */     Fighter mainTagetFighter = findFighter(mainTargetId, sortTargets);
/*  590 */     if (mainTagetFighter != null) {
/*  591 */       sortTargets.remove(mainTagetFighter);
/*  592 */       sortTargets.add(0, mainTagetFighter);
/*      */     }
/*      */     
/*  595 */     if (sortTargets.size() <= 0) {
/*  596 */       return sortTargets;
/*      */     }
/*      */     
/*  599 */     if (mainTagetFighter == null) {
/*  600 */       mainTagetFighter = (Fighter)sortTargets.get(0);
/*      */     }
/*  602 */     int pos = mainTagetFighter.getPos();
/*      */     
/*  604 */     switch (this.skillCfg.skilltargettype5)
/*      */     {
/*      */ 
/*      */     case 3: 
/*  608 */       int posBefore = pos - 1;
/*  609 */       int posAfter = pos + 1;
/*  610 */       Set<Integer> posSet = new HashSet();
/*  611 */       FightInterface.fillColumnPos(pos, posSet);
/*  612 */       if (!posSet.contains(Integer.valueOf(posBefore))) {
/*  613 */         posBefore = -1;
/*      */       }
/*  615 */       if (!posSet.contains(Integer.valueOf(posAfter))) {
/*  616 */         posAfter = -1;
/*      */       }
/*  618 */       Iterator<Fighter> iterator = sortTargets.iterator();
/*  619 */       while (iterator.hasNext()) {
/*  620 */         Fighter bothSideFighter = (Fighter)iterator.next();
/*  621 */         int bothSidePos = bothSideFighter.getPos();
/*  622 */         if (bothSidePos != pos)
/*      */         {
/*      */ 
/*  625 */           if ((bothSidePos != posBefore) && (bothSidePos != posAfter)) {
/*  626 */             iterator.remove();
/*      */           }
/*      */         }
/*      */       }
/*  630 */       break;
/*      */     
/*      */     case 2: 
/*  633 */       Set<Integer> posSet = new HashSet();
/*  634 */       FightInterface.fillColumnPos(pos, posSet);
/*  635 */       Iterator<Fighter> columnIterator = sortTargets.iterator();
/*  636 */       while (columnIterator.hasNext()) {
/*  637 */         Fighter tmpFighter = (Fighter)columnIterator.next();
/*  638 */         int tmpPos = tmpFighter.getPos();
/*  639 */         if (tmpPos != pos)
/*      */         {
/*      */ 
/*  642 */           if (!posSet.contains(Integer.valueOf(tmpPos))) {
/*  643 */             columnIterator.remove();
/*      */           }
/*      */         }
/*      */       }
/*  647 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  651 */       Set<Integer> posSet = new HashSet();
/*  652 */       FightInterface.fillRowPos(pos, posSet);
/*  653 */       Iterator<Fighter> iterator = sortTargets.iterator();
/*  654 */       while (iterator.hasNext()) {
/*  655 */         Fighter tmpFighter = (Fighter)iterator.next();
/*  656 */         int tmpPos = tmpFighter.getPos();
/*  657 */         if (tmpPos != pos)
/*      */         {
/*      */ 
/*  660 */           if (!posSet.contains(Integer.valueOf(tmpPos))) {
/*  661 */             iterator.remove();
/*      */           }
/*      */         }
/*      */       }
/*  665 */       break;
/*      */     }
/*      */     
/*      */     
/*      */ 
/*      */ 
/*  671 */     return sortTargets;
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
/*      */   private Fighter findFighter(int fighterid, List<Fighter> fighters)
/*      */   {
/*  751 */     for (Fighter fighter : fighters) {
/*  752 */       if (fighterid == fighter.getid()) {
/*  753 */         return fighter;
/*      */       }
/*      */     }
/*  756 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private LinkedList<Fighter> sortTargets(Set<Fighter> targets)
/*      */   {
/*  767 */     LinkedList<Fighter> sortTargets = new LinkedList(targets);
/*  768 */     boolean fromLowToHigh = this.skillCfg.secondTargetSort == 1;
/*  769 */     if (this.skillCfg.secondTarget == 2) {
/*  770 */       Collections.sort(sortTargets, new HpComparator(fromLowToHigh));
/*      */     }
/*  772 */     if (this.skillCfg.secondTarget == 4) {
/*  773 */       Collections.sort(sortTargets, new HpPercentRateComparator(fromLowToHigh));
/*      */     }
/*  775 */     if (this.skillCfg.secondTarget == 7) {
/*  776 */       Collections.sort(sortTargets, new MAGATKComparator(fromLowToHigh));
/*      */     }
/*  778 */     if (this.skillCfg.secondTarget == 9) {
/*  779 */       Collections.sort(sortTargets, new MAGDEFComparator(fromLowToHigh));
/*      */     }
/*  781 */     if (this.skillCfg.secondTarget == 3) {
/*  782 */       Collections.sort(sortTargets, new MpComparator(fromLowToHigh));
/*      */     }
/*  784 */     if (this.skillCfg.secondTarget == 5) {
/*  785 */       Collections.sort(sortTargets, new MpPercentRateComparator(fromLowToHigh));
/*      */     }
/*  787 */     if (this.skillCfg.secondTarget == 6) {
/*  788 */       Collections.sort(sortTargets, new PHYATKComparator(fromLowToHigh));
/*      */     }
/*  790 */     if (this.skillCfg.secondTarget == 8) {
/*  791 */       Collections.sort(sortTargets, new PHYDEFComparator(fromLowToHigh));
/*      */     }
/*  793 */     if (this.skillCfg.secondTarget == 1) {
/*  794 */       Collections.shuffle(sortTargets);
/*      */     }
/*  796 */     if (this.skillCfg.secondTarget == 10) {
/*  797 */       Collections.sort(sortTargets, new SpeedComparator(fromLowToHigh));
/*      */     }
/*  799 */     return sortTargets;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private LinkedList<Fighter> sortTargets(Map<Integer, Integer> sortMap, Collection<Fighter> fighters)
/*      */   {
/*  811 */     LinkedList<Fighter> sortTargets = new LinkedList(fighters);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  817 */     int firstFighterSortPos = Integer.MAX_VALUE;
/*  818 */     int firstFighterIndex = Integer.MAX_VALUE;
/*  819 */     int size = sortTargets.size();
/*  820 */     if (size <= 1) {
/*  821 */       return sortTargets;
/*      */     }
/*  823 */     for (int i = 0; i < size; i++) {
/*  824 */       Fighter tmpFighter = (Fighter)sortTargets.get(i);
/*  825 */       int sortPos = ((Integer)sortMap.get(Integer.valueOf(tmpFighter.getPos()))).intValue();
/*  826 */       if (sortPos < firstFighterSortPos) {
/*  827 */         firstFighterSortPos = sortPos;
/*  828 */         firstFighterIndex = i;
/*      */       }
/*      */     }
/*  831 */     if (firstFighterIndex != Integer.MAX_VALUE) {
/*  832 */       Fighter firstFighter = (Fighter)sortTargets.remove(firstFighterIndex);
/*  833 */       sortTargets.addFirst(firstFighter);
/*      */     }
/*  835 */     return sortTargets;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean canRun(Fighter releser, int mainTargetId, List<Fighter> targets, boolean tip)
/*      */   {
/*  847 */     if (targets.size() <= 0) {
/*  848 */       if (tip) {
/*  849 */         Play play = new Play();
/*  850 */         releser.fillPlayTipResult(play, releser.getid(), 121000003, new String[0]);
/*  851 */         this.passivePlays.add(play);
/*  852 */         this.activePlays.add(play);
/*  853 */         this.recordPlays.add(play);
/*      */       }
/*  855 */       return false;
/*      */     }
/*      */     
/*  858 */     if ((!this.skillCfg.autoSelectSecond) && (
/*  859 */       (mainTargetId == 0) || (targets.size() <= 0) || (((Fighter)targets.get(0)).getid() != mainTargetId))) {
/*  860 */       if (tip) {
/*  861 */         Play play = new Play();
/*  862 */         releser.fillPlayTipResult(play, releser.getid(), 121000003, new String[0]);
/*  863 */         this.passivePlays.add(play);
/*  864 */         this.activePlays.add(play);
/*  865 */         this.recordPlays.add(play);
/*      */       }
/*  867 */       return false;
/*      */     }
/*      */     
/*  870 */     return true;
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
/*      */   public boolean skillOnTarget(Fighter releser, List<Fighter> targets)
/*      */   {
/*  898 */     this.targetSize = targets.size();
/*  899 */     if (this.targetSize <= 0)
/*      */     {
/*  901 */       return false;
/*      */     }
/*      */     
/*  904 */     releser.clearInfluenceTarget();
/*  905 */     for (Fighter fighter : targets) {
/*  906 */       fighter.clearInfluenceTarget();
/*      */     }
/*  908 */     this.effectTargets.clear();
/*  909 */     this.mainTargetId = ((Fighter)targets.get(0)).getid();
/*      */     
/*  911 */     for (Iterator i$ = this.skillCfg.skillEffectGroupId.iterator(); i$.hasNext();) { int skillEffectGroupid = ((Integer)i$.next()).intValue();
/*      */       
/*  913 */       Integer replacedEffectGroupId = (Integer)this.replacedEffectGroup.get(Integer.valueOf(skillEffectGroupid));
/*  914 */       if (replacedEffectGroupId != null) {
/*  915 */         if (GameServer.logger().isDebugEnabled()) {
/*  916 */           GameServer.logger().debug(String.format("[fight]Skill.skillOnTarget@log skill effect groupid was replaced|skillEffectGroupid=%d|replacedEffectGroupId=%d", new Object[] { Integer.valueOf(skillEffectGroupid), replacedEffectGroupId }));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  922 */         skillEffectGroupid = replacedEffectGroupId.intValue();
/*      */       }
/*      */       
/*  925 */       for (Fighter target : targets) {
/*  926 */         FighterEffectGroup fighterEffectGroup = EffectInterface.getEffectGroup(skillEffectGroupid);
/*  927 */         if (fighterEffectGroup == null) {
/*  928 */           GameServer.logger().error("没有找到效果组的配置!effectGroupid:" + skillEffectGroupid);
/*      */ 
/*      */         }
/*  931 */         else if ((fighterEffectGroup.isTargetReleaser()) || (
/*      */         
/*  933 */           (!target.isDead()) && (
/*      */           
/*      */ 
/*  936 */           (!target.isFakeDead()) || ((this.skillCfg.skilltargettype3 & 0x1) > 0))))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  941 */           FighterBuff fighterBuff = fighterEffectGroup.run(this, releser, target, this.mainTargetId);
/*  942 */           if (fighterBuff != null) {
/*  943 */             if (fighterEffectGroup.isTargetReleaser()) {
/*  944 */               if (targets.contains(releser)) {
/*  945 */                 target = releser;
/*      */               }
/*      */               else {
/*  948 */                 if (this.targets.size() > 0) continue;
/*  949 */                 releser.fillFighterStatus(getSkillUseFighterStatus()); continue;
/*      */               }
/*      */             }
/*      */             
/*      */ 
/*  954 */             int targetid = target.getid();
/*      */             
/*  956 */             if (!this.targets.contains(Integer.valueOf(targetid))) {
/*  957 */               this.targets.add(Integer.valueOf(targetid));
/*      */             }
/*      */           }
/*      */           
/*      */ 
/*  962 */           if (((releser.isDead()) || (releser.isFakeDead())) && (!isDeathSkill()))
/*      */             break;
/*      */         }
/*      */       }
/*  966 */       if ((releser.isDead()) && (!isDeathSkill())) {
/*      */         break;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  972 */     for (Fighter target : targets) {
/*  973 */       int targetid = target.getid();
/*  974 */       if (this.targets.contains(Integer.valueOf(target.getid()))) {
/*  975 */         AttackResult attackResult = getAttackResult(targetid);
/*  976 */         AttackResultBean attackResultBean = null;
/*  977 */         int attackResultSize = attackResult.attackresultbeans.size();
/*  978 */         if (attackResultSize > 0) {
/*  979 */           attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(attackResultSize - 1);
/*  980 */           if (!getHitAgainMap().containsKey(Integer.valueOf(targetid)))
/*      */           {
/*      */ 
/*  983 */             boolean hasTarget = false;
/*  984 */             for (AttackOtherBean attackOtherBean : attackResultBean.attackothers) {
/*  985 */               if (attackOtherBean.targetid == targetid) {
/*  986 */                 hasTarget = true;
/*  987 */                 break;
/*      */               }
/*      */             }
/*  990 */             if (!hasTarget)
/*      */             {
/*      */ 
/*  993 */               if (attackResultBean.counterattack.skill > 0)
/*      */               {
/*  995 */                 target.fillBuffStatus(attackResultBean.counterattack.attackerstatus);
/*      */               }
/*      */               else
/*      */               {
/*  999 */                 FighterStatus fighterStatus = (FighterStatus)attackResultBean.statusmap.get(Integer.valueOf(1));
/* 1000 */                 if (fighterStatus != null) {
/* 1001 */                   target.fillBuffStatus(fighterStatus);
/*      */                 } else {
/* 1003 */                   target.fillBuffStatus(attackResultBean.targetstatus);
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         } else {
/* 1009 */           attackResultBean = new AttackResultBean();
/* 1010 */           attackResult.attackresultbeans.add(attackResultBean);
/* 1011 */           releser.fillFighterStatus(attackResultBean.attackerstatus);
/* 1012 */           target.fillFighterStatus(attackResultBean.targetstatus);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1017 */     for (Iterator i$ = this.effectTargets.iterator(); i$.hasNext();) { int tmpTargetId = ((Integer)i$.next()).intValue();
/* 1018 */       addTarget(tmpTargetId);
/*      */     }
/*      */     
/* 1021 */     calSkillPlayTime(releser, targets);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1030 */     for (Iterator i$ = this.targets.iterator(); i$.hasNext();) { int fighterid = ((Integer)i$.next()).intValue();
/* 1031 */       Fighter targetFighter = releser.getFighter(fighterid);
/* 1032 */       if (targetFighter != null)
/*      */       {
/*      */ 
/* 1035 */         Map<Integer, FighterStatus> influenceMap = targetFighter.getInfluenceMap();
/* 1036 */         if (influenceMap.size() > 0)
/* 1037 */           addTargetInfluenceMap(targetFighter, influenceMap);
/*      */       }
/*      */     }
/* 1040 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getReliveDuration(Fighter fighter)
/*      */   {
/* 1049 */     if (fighter == null) {
/* 1050 */       return 0;
/*      */     }
/* 1052 */     int relivePreTime = 1000;
/* 1053 */     int modelId = fighter.getModelid();
/* 1054 */     int deathDuration = DurationCfgManager.getActionDuration(modelId, SFightConsts.getInstance().DEATH_ACTION_ID);
/*      */     
/* 1056 */     int reliveDuration = DurationCfgManager.getActionDuration(modelId, SFightConsts.getInstance().RELIVE_ACTION_ID);
/*      */     
/* 1058 */     return deathDuration + reliveDuration + 1000;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void calSkillReliveTime(Fighter releser)
/*      */   {
/* 1068 */     Set<Map.Entry<Integer, AttackResult>> attackResultEntrySet = this.attackResultMap.entrySet();
/* 1069 */     SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(getSkillPlayId(this.skillCfg.skillPlayid, releser));
/*      */     
/* 1071 */     int skillDuration = 0;
/* 1072 */     for (Map.Entry<Integer, AttackResult> entry : attackResultEntrySet) {
/* 1073 */       int targetFighterId = ((Integer)entry.getKey()).intValue();
/* 1074 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 1075 */       Integer attackResultDuration = Integer.valueOf(0);
/*      */       
/*      */ 
/*      */ 
/* 1079 */       int end = attackResult.attackresultbeans.size() - 1;
/* 1080 */       for (int i = 0; i < end; i++) {
/* 1081 */         int attackResultBeanDuration = getAttackResultBeanReliveTime(releser, targetFighterId, (AttackResultBean)attackResult.attackresultbeans.get(i));
/*      */         
/* 1083 */         attackResultDuration = Integer.valueOf(attackResultDuration.intValue() + attackResultBeanDuration);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1088 */       if (attackResultDuration.intValue() > 0) {
/* 1089 */         if (1 == skillPlayCfg.skillPlayType) {
/* 1090 */           if (GameServer.logger().isInfoEnabled()) {
/* 1091 */             GameServer.logger().info("activeResultDuration single=" + attackResultDuration);
/*      */           }
/* 1093 */           skillDuration += attackResultDuration.intValue();
/*      */         }
/* 1095 */         else if (skillDuration < attackResultDuration.intValue()) {
/* 1096 */           if (GameServer.logger().isInfoEnabled()) {
/* 1097 */             GameServer.logger().info("activeResultDuration mul=" + attackResultDuration);
/*      */           }
/* 1099 */           skillDuration = attackResultDuration.intValue();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1104 */     if (GameServer.logger().isDebugEnabled()) {
/* 1105 */       GameServer.logger().info(String.format("[fight]Skill.calSkillReliveTime@log PlaySkill relive time exclude last attackResultBean|skillDuration=%d", new Object[] { Integer.valueOf(skillDuration) }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1111 */     addPlayTime(skillDuration);
/*      */     
/*      */ 
/* 1114 */     if ((this.activePlays.size() > 0) || (this.passivePlays.size() > 0)) {
/* 1115 */       int duration = getLastAttackReliveTime(releser);
/* 1116 */       if (GameServer.logger().isDebugEnabled()) {
/* 1117 */         GameServer.logger().info(String.format("[fight]Skill.calSkillReliveTime@log PlaySkill last attackResultBean duration|duration=%d", new Object[] { Integer.valueOf(duration) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1123 */       addPlayTime(duration);
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
/*      */   public int getLastAttackReliveTime(Fighter releser)
/*      */   {
/* 1139 */     int targetSize = this.targets.size();
/* 1140 */     if (targetSize < 1) {
/* 1141 */       return 0;
/*      */     }
/* 1143 */     SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(getSkillPlayId(this.skillCfg.skillPlayid, releser));
/* 1144 */     if (1 == skillPlayCfg.skillPlayType) {
/* 1145 */       int targetFighterId = ((Integer)this.targets.get(targetSize - 1)).intValue();
/* 1146 */       AttackResult attackResult = (AttackResult)this.attackResultMap.get(Integer.valueOf(targetFighterId));
/* 1147 */       if (attackResult == null) {
/* 1148 */         return 0;
/*      */       }
/* 1150 */       int beansize = attackResult.attackresultbeans.size();
/* 1151 */       if (beansize < 1) {
/* 1152 */         return 0;
/*      */       }
/*      */       
/* 1155 */       AttackResultBean bean = (AttackResultBean)attackResult.attackresultbeans.get(beansize - 1);
/* 1156 */       int duration = getAttackResultBeanReliveTime(releser, targetFighterId, bean);
/* 1157 */       return duration;
/*      */     }
/* 1159 */     int duration = 0;
/* 1160 */     Set<Map.Entry<Integer, AttackResult>> attackResultEntrySet = this.attackResultMap.entrySet();
/*      */     
/* 1162 */     for (Map.Entry<Integer, AttackResult> entry : attackResultEntrySet) {
/* 1163 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 1164 */       int beansize = attackResult.attackresultbeans.size();
/* 1165 */       if (beansize < 1) {
/* 1166 */         return 0;
/*      */       }
/*      */       
/* 1169 */       AttackResultBean bean = (AttackResultBean)attackResult.attackresultbeans.get(beansize - 1);
/* 1170 */       int beanTime = getAttackResultBeanReliveTime(releser, ((Integer)entry.getKey()).intValue(), bean);
/* 1171 */       if (duration < beanTime) {
/* 1172 */         duration = beanTime;
/*      */       }
/*      */     }
/* 1175 */     if (duration > 0) {
/* 1176 */       return duration;
/*      */     }
/*      */     
/*      */ 
/* 1180 */     return 0;
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
/*      */   private int getAttackResultBeanReliveTime(Fighter releser, int targetFighterId, AttackResultBean bean)
/*      */   {
/* 1193 */     Integer releaserDuration = null;
/* 1194 */     Integer targetReliveDuration = null;
/* 1195 */     int duration = 0;
/*      */     
/* 1197 */     if (bean.statusmap.get(Integer.valueOf(2)) != null) {
/* 1198 */       if (releaserDuration == null) {
/* 1199 */         releaserDuration = Integer.valueOf(getReliveDuration(releser));
/*      */       }
/* 1201 */       duration = releaserDuration.intValue();
/*      */     }
/*      */     
/* 1204 */     if (bean.statusmap.get(Integer.valueOf(1)) != null) {
/* 1205 */       if (targetReliveDuration == null) {
/* 1206 */         targetReliveDuration = Integer.valueOf(getReliveDuration(releser.getFighterFromAll(targetFighterId)));
/*      */       }
/* 1208 */       if (duration < targetReliveDuration.intValue()) {
/* 1209 */         duration = targetReliveDuration.intValue();
/*      */       }
/* 1211 */     } else if (bean.counterattack != null)
/*      */     {
/* 1213 */       int countAttackReliveTime = 0;
/* 1214 */       if (bean.counterattack.statusmap.get(Integer.valueOf(2)) != null) {
/* 1215 */         if (releaserDuration == null) {
/* 1216 */           releaserDuration = Integer.valueOf(getReliveDuration(releser));
/*      */         }
/* 1218 */         countAttackReliveTime = releaserDuration.intValue();
/*      */       }
/* 1220 */       if (bean.counterattack.statusmap.get(Integer.valueOf(1)) != null) {
/* 1221 */         if (targetReliveDuration == null) {
/* 1222 */           targetReliveDuration = Integer.valueOf(getReliveDuration(releser.getFighterFromAll(targetFighterId)));
/*      */         }
/* 1224 */         countAttackReliveTime = countAttackReliveTime < targetReliveDuration.intValue() ? targetReliveDuration.intValue() : countAttackReliveTime;
/*      */       }
/*      */       
/* 1227 */       duration += countAttackReliveTime;
/*      */     }
/* 1229 */     return duration;
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
/*      */   public int calSkillReliveTimeBetweenSkills(Fighter currentSkillReleaser, Skill newSkill, Fighter newSkillReleaser)
/*      */   {
/* 1242 */     Set<Integer> currentSkillRelivedFighterID = new HashSet();
/*      */     
/* 1244 */     Map<Integer, AttackResultBean> lastAttackResultBeans = getSkillLastAttackResultBean(currentSkillReleaser);
/* 1245 */     if (lastAttackResultBeans == null) {
/* 1246 */       return 0;
/*      */     }
/* 1248 */     Set<Map.Entry<Integer, AttackResultBean>> set = lastAttackResultBeans.entrySet();
/* 1249 */     for (Map.Entry<Integer, AttackResultBean> entry : set) {
/* 1250 */       int targetId = ((Integer)entry.getKey()).intValue();
/* 1251 */       AttackResultBean bean = (AttackResultBean)entry.getValue();
/* 1252 */       if (bean.statusmap.get(Integer.valueOf(2)) != null) {
/* 1253 */         currentSkillRelivedFighterID.add(Integer.valueOf(currentSkillReleaser.getid()));
/*      */       }
/* 1255 */       if (bean.statusmap.get(Integer.valueOf(1)) != null) {
/* 1256 */         currentSkillRelivedFighterID.add(Integer.valueOf(targetId));
/*      */       }
/*      */       
/*      */ 
/* 1260 */       if (bean.counterattack.skill > 0) {
/* 1261 */         if (bean.statusmap.get(Integer.valueOf(2)) != null) {
/* 1262 */           currentSkillRelivedFighterID.add(Integer.valueOf(targetId));
/*      */         }
/* 1264 */         if (bean.statusmap.get(Integer.valueOf(1)) != null) {
/* 1265 */           currentSkillRelivedFighterID.add(Integer.valueOf(currentSkillReleaser.getid()));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1270 */     int reliveTime = 0;
/* 1271 */     for (Iterator i$ = currentSkillRelivedFighterID.iterator(); i$.hasNext();) { int fighterId = ((Integer)i$.next()).intValue();
/* 1272 */       if (newSkillReleaser.getid() == fighterId) {
/* 1273 */         int time = getReliveDuration(newSkillReleaser);
/* 1274 */         reliveTime = reliveTime > time ? reliveTime : time;
/*      */       }
/* 1276 */       if (newSkill.targets.contains(Integer.valueOf(fighterId))) {
/* 1277 */         Fighter target = currentSkillReleaser.getFighterFromAll(fighterId);
/* 1278 */         if (target != null) {
/* 1279 */           int time = getReliveDuration(target);
/* 1280 */           reliveTime = reliveTime > time ? reliveTime : time;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1285 */     return reliveTime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Integer, AttackResultBean> getSkillLastAttackResultBean(Fighter releaser)
/*      */   {
/* 1294 */     int targetSize = this.targets.size();
/* 1295 */     if (targetSize < 1) {
/* 1296 */       return null;
/*      */     }
/* 1298 */     SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(getSkillPlayId(this.skillCfg.skillPlayid, releaser));
/* 1299 */     if (1 == skillPlayCfg.skillPlayType) {
/* 1300 */       int targetFighterId = ((Integer)this.targets.get(targetSize - 1)).intValue();
/* 1301 */       AttackResult attackResult = (AttackResult)this.attackResultMap.get(Integer.valueOf(targetFighterId));
/* 1302 */       if (attackResult == null) {
/* 1303 */         return null;
/*      */       }
/* 1305 */       int beansize = attackResult.attackresultbeans.size();
/* 1306 */       if (beansize < 1) {
/* 1307 */         return null;
/*      */       }
/*      */       
/* 1310 */       AttackResultBean bean = (AttackResultBean)attackResult.attackresultbeans.get(beansize - 1);
/* 1311 */       Map<Integer, AttackResultBean> map = new HashMap();
/* 1312 */       map.put(Integer.valueOf(targetFighterId), bean);
/* 1313 */       return map;
/*      */     }
/* 1315 */     Map<Integer, AttackResultBean> map = new HashMap();
/* 1316 */     Set<Map.Entry<Integer, AttackResult>> attackResultEntrySet = this.attackResultMap.entrySet();
/*      */     
/* 1318 */     for (Map.Entry<Integer, AttackResult> entry : attackResultEntrySet) {
/* 1319 */       int targetId = ((Integer)entry.getKey()).intValue();
/* 1320 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 1321 */       int beansize = attackResult.attackresultbeans.size();
/* 1322 */       if (beansize >= 1)
/*      */       {
/*      */ 
/*      */ 
/* 1326 */         AttackResultBean bean = (AttackResultBean)attackResult.attackresultbeans.get(beansize - 1);
/* 1327 */         map.put(Integer.valueOf(targetId), bean);
/*      */       } }
/* 1329 */     return map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void calSkillPlayTime(Fighter releser, List<Fighter> fighters)
/*      */   {
/* 1339 */     int releserModelid = releser.getModelid();
/*      */     
/* 1341 */     List<Attack> attackCounts = new ArrayList();
/* 1342 */     for (Iterator i$ = this.targets.iterator(); i$.hasNext();) { int targetid = ((Integer)i$.next()).intValue();
/* 1343 */       attackCounts.add(getAttackCount(targetid));
/*      */     }
/* 1345 */     this.playTime += FightUtil.getPlayTime(releserModelid, getSkillPlayId(this.skillCfg.skillPlayid, releser), this.targets, attackCounts);
/*      */     
/*      */ 
/*      */ 
/* 1349 */     for (Map.Entry<Integer, AttackResult> attackResultEntry : this.attackResultMap.entrySet()) {
/* 1350 */       targetid = ((Integer)attackResultEntry.getKey()).intValue();
/* 1351 */       for (AttackResultBean attackresultbeans : ((AttackResult)attackResultEntry.getValue()).attackresultbeans) {
/* 1352 */         int skill = attackresultbeans.counterattack.skill;
/* 1353 */         if (skill > 0) {
/* 1354 */           calCounterAttackTime(releser, targetid, skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     int targetid;
/* 1360 */     for (Map.Entry<Integer, HitAgain> hitAgainEntry : this.hitAgainMap.entrySet()) {
/* 1361 */       calHitAgainTime(releser, (HitAgain)hitAgainEntry.getValue());
/*      */     }
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
/* 1382 */     calSkillReliveTime(releser);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void calHitAgainTime(Fighter releser, HitAgain hitAgain)
/*      */   {
/* 1392 */     int hitAgainTargetSize = hitAgain.targets.size();
/* 1393 */     if (hitAgainTargetSize <= 0) {
/* 1394 */       return;
/*      */     }
/*      */     
/* 1397 */     int releaserNormalSkillid = releser.getNormalSkill();
/* 1398 */     SSkillCfg skillCfg = SSkillCfg.get(releaserNormalSkillid);
/* 1399 */     if (skillCfg == null) {
/* 1400 */       GameServer.logger().error("技能配置不存在skillid:" + releaserNormalSkillid);
/* 1401 */       return;
/*      */     }
/* 1403 */     SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(getSkillPlayId(skillCfg.skillPlayid, releser));
/* 1404 */     if (skillPlayCfg == null) {
/* 1405 */       this.playTime += SFightConsts.getInstance().DEFAULT_ACTION_DURATION * hitAgainTargetSize;
/* 1406 */       return;
/*      */     }
/* 1408 */     this.playTime += calSkillEffectTime(skillPlayCfg, releser.getModelid()) * hitAgainTargetSize;
/*      */     
/*      */ 
/* 1411 */     for (Map.Entry<Integer, AttackResult> entry : hitAgain.status_map.entrySet()) {
/* 1412 */       targetid = ((Integer)entry.getKey()).intValue();
/* 1413 */       for (AttackResultBean attackresultbeans : ((AttackResult)entry.getValue()).attackresultbeans) {
/* 1414 */         int skill = attackresultbeans.counterattack.skill;
/* 1415 */         if (skill > 0) {
/* 1416 */           calCounterAttackTime(releser, targetid, skill);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     int targetid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void calCounterAttackTime(Fighter releser, int targetid, int counterSkillId)
/*      */   {
/* 1433 */     if (counterSkillId <= 0) {
/* 1434 */       return;
/*      */     }
/* 1436 */     SSkillCfg counterSkillCfg = SSkillCfg.get(counterSkillId);
/* 1437 */     if (counterSkillCfg == null) {
/* 1438 */       GameServer.logger().error("不存在技能的配置" + counterSkillId);
/* 1439 */       return;
/*      */     }
/*      */     
/* 1442 */     Fighter couterattackFighter = releser.getFighter(targetid);
/* 1443 */     if (couterattackFighter == null) {
/* 1444 */       this.playTime += SFightConsts.getInstance().DEFAULT_ACTION_DURATION;
/* 1445 */       return;
/*      */     }
/*      */     
/* 1448 */     SSkillPlayCfg skillCounterPlayCfg = SSkillPlayCfg.get(getSkillPlayId(counterSkillCfg.skillPlayid, couterattackFighter));
/*      */     
/* 1450 */     if (skillCounterPlayCfg == null) {
/* 1451 */       this.playTime += SFightConsts.getInstance().DEFAULT_ACTION_DURATION;
/* 1452 */       return;
/*      */     }
/*      */     
/* 1455 */     int counterAttackModelid = couterattackFighter.getModelid();
/*      */     
/* 1457 */     this.playTime += calSkillEffectTime(skillCounterPlayCfg, counterAttackModelid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int calSkillEffectTime(SSkillPlayCfg skillCounterPlayCfg, int modelid)
/*      */   {
/* 1465 */     int time = 0;
/* 1466 */     if (skillCounterPlayCfg.effectStages.size() > 0) {
/* 1467 */       time += FightUtil.calPlayStateTime(modelid, SSkillPlayStageCfg.get(((Integer)skillCounterPlayCfg.effectStages.get(0)).intValue()));
/*      */     }
/*      */     else {
/* 1470 */       time = SFightConsts.getInstance().DEFAULT_ACTION_DURATION;
/*      */     }
/*      */     
/* 1473 */     return time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private int callSkillMoveTime(SSkillPlayCfg skillCounterPlayCfg, int modelid)
/*      */   {
/* 1480 */     int time = 0;
/* 1481 */     if (skillCounterPlayCfg.moveStages.size() > 0) {
/* 1482 */       time += FightUtil.calPlayStateTime(modelid, SSkillPlayStageCfg.get(((Integer)skillCounterPlayCfg.effectStages.get(0)).intValue()));
/*      */     }
/*      */     else {
/* 1485 */       time = SFightConsts.getInstance().DEFAULT_ACTION_DURATION;
/*      */     }
/*      */     
/* 1488 */     return time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public AttackResultBean addDamageRet(int trueDamage, int vampireHp, boolean isCrt, boolean isAbsorbDamage, Fighter releaser, Fighter target)
/*      */   {
/* 1500 */     AttackResult attackResult = getAttackResult(target.getid());
/* 1501 */     AttackResultBean attackResultBean = new AttackResultBean();
/*      */     
/* 1503 */     addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target, attackResultBean);
/*      */     
/* 1505 */     attackResult.attackresultbeans.add(attackResultBean);
/*      */     
/* 1507 */     return attackResultBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public AttackResultBean addDamageRet(int trueDamage, int vampireHp, boolean isCrt, boolean isAbsorbDamage, Fighter releaser, Fighter target, AttackResultBean attackResultBean)
/*      */   {
/* 1519 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 1520 */     if (isCrt) {
/* 1521 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/* 1522 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/*      */     } else {
/* 1524 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/*      */     }
/* 1526 */     if (isAbsorbDamage) {
/* 1527 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(26));
/*      */     }
/* 1529 */     attackResultBean.targetstatus.hpchange = (-trueDamage);
/*      */     
/* 1531 */     releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 1532 */     attackResultBean.attackerstatus.hpchange += vampireHp;
/*      */     
/* 1534 */     return attackResultBean;
/*      */   }
/*      */   
/*      */   public AttackOtherBeanResult addDamageRet(int trueDamage, int vampireHp, boolean isCrt, boolean isAbsorbDamage, Fighter releaser, Fighter target, AttackOtherBeanResult attackOtherBeanResult)
/*      */   {
/* 1539 */     target.fillFighterStatus(attackOtherBeanResult.targetstatus);
/* 1540 */     if (isCrt) {
/* 1541 */       attackOtherBeanResult.targetstatus.status_set.add(Integer.valueOf(21));
/* 1542 */       attackOtherBeanResult.targetstatus.status_set.add(Integer.valueOf(20));
/*      */     } else {
/* 1544 */       attackOtherBeanResult.targetstatus.status_set.add(Integer.valueOf(20));
/*      */     }
/* 1546 */     if (isAbsorbDamage) {
/* 1547 */       attackOtherBeanResult.targetstatus.status_set.add(Integer.valueOf(26));
/*      */     }
/* 1549 */     attackOtherBeanResult.targetstatus.hpchange = (-trueDamage);
/*      */     
/* 1551 */     releaser.fillFighterStatus(attackOtherBeanResult.attackerstatus);
/* 1552 */     attackOtherBeanResult.attackerstatus.hpchange += vampireHp;
/*      */     
/* 1554 */     return attackOtherBeanResult;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillInAttackOtherBeanResult(AttackResultBean attackResultBean, AttackOtherBeanResult attackOtherBeanResult)
/*      */   {
/* 1564 */     attackOtherBeanResult.attackerstatus = attackResultBean.attackerstatus;
/* 1565 */     attackOtherBeanResult.counterattack = attackResultBean.counterattack;
/* 1566 */     attackOtherBeanResult.sharedamagetargets = attackResultBean.sharedamagetargets;
/* 1567 */     attackOtherBeanResult.statusmap = attackResultBean.statusmap;
/* 1568 */     attackOtherBeanResult.targetstatus = attackResultBean.targetstatus;
/*      */   }
/*      */   
/*      */   public void afterTargetDamage(Fighter releaser, Fighter target, int reboundDamage, AttackResultBean attackResultBean, int damage, boolean handleCounterAttack)
/*      */   {
/* 1573 */     if ((target.isDead()) || (target.isFakeDead())) {
/* 1574 */       KillOtherHandle.InputObj inputObj = new KillOtherHandle.InputObj(releaser, target, target, this);
/* 1575 */       KillOtherHandle.OutputObj outputObj = new KillOtherHandle.OutputObj();
/* 1576 */       releaser.handleKillOther(inputObj, outputObj);
/* 1577 */       attackResultBean.attackerstatus.hpchange += outputObj.addHp;
/* 1578 */       attackResultBean.attackerstatus.mpchange += outputObj.addMp;
/* 1579 */       if (outputObj.hitAgain != null) {
/* 1580 */         this.hitAgainMap.put(Integer.valueOf(target.getid()), outputObj.hitAgain);
/*      */       }
/* 1582 */       BeKilledHandle.OutPutObj outPutObj = target.handleBeKilled(new BeKilledHandle.InputObj(releaser, target, this, damage));
/*      */       
/* 1584 */       addTargetInfluenceMap(target, target.getInfluenceMap());
/* 1585 */       target.clearInfluenceTarget();
/* 1586 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 1587 */       if (target.isAlive()) {
/* 1588 */         attackResultBean.targetstatus.status_set.remove(Integer.valueOf(1));
/* 1589 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(3));
/* 1590 */         FighterStatus fighterStatus = new FighterStatus();
/* 1591 */         fighterStatus.status_set.add(Integer.valueOf(23));
/* 1592 */         fighterStatus.hpchange += target.getHp();
/* 1593 */         target.fillFighterStatus(fighterStatus);
/* 1594 */         attackResultBean.statusmap.put(Integer.valueOf(1), fighterStatus);
/*      */       }
/*      */     } else {
/* 1597 */       if ((reboundDamage > 0) && (releaser.isAlive())) {
/* 1598 */         releaser.addHp(target, -reboundDamage);
/* 1599 */         target.addDamageToFighter(releaser, reboundDamage);
/* 1600 */         FighterStatus fighterStatus = new FighterStatus();
/* 1601 */         fighterStatus.status_set.add(Integer.valueOf(20));
/* 1602 */         releaser.fillFighterStatus(fighterStatus);
/* 1603 */         fighterStatus.hpchange -= reboundDamage;
/* 1604 */         attackResultBean.statusmap.put(Integer.valueOf(0), fighterStatus);
/* 1605 */         if ((releaser.isDead()) || (releaser.isFakeDead())) {
/* 1606 */           BeKilledHandle.OutPutObj outPutObj = releaser.handleBeKilled(new BeKilledHandle.InputObj(target, releaser, this, reboundDamage));
/*      */           
/*      */ 
/* 1609 */           addTargetInfluenceMap(target, releaser.getInfluenceMap());
/* 1610 */           releaser.clearInfluenceTarget();
/* 1611 */           FighterStatus status = (FighterStatus)attackResultBean.statusmap.get(Integer.valueOf(0));
/* 1612 */           status.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 1613 */           if (releaser.isAlive()) {
/* 1614 */             status.status_set.remove(Integer.valueOf(1));
/* 1615 */             status.status_set.add(Integer.valueOf(3));
/*      */             
/* 1617 */             FighterStatus releaserReliveStatus = new FighterStatus();
/* 1618 */             releaserReliveStatus.hpchange += releaser.getHp();
/* 1619 */             releaserReliveStatus.status_set.add(Integer.valueOf(23));
/* 1620 */             releaser.fillFighterStatus(releaserReliveStatus);
/* 1621 */             attackResultBean.statusmap.put(Integer.valueOf(2), releaserReliveStatus);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1627 */       if (handleCounterAttack) {
/* 1628 */         addCounterAttack(releaser, target, attackResultBean);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   public void afterTargetDamage(Fighter releaser, Fighter target, int reboundDamage, AttackResultBean attackResultBean, int damage)
/*      */   {
/* 1644 */     afterTargetDamage(releaser, target, reboundDamage, attackResultBean, damage, true);
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
/*      */   public AttackResultBean addMpRet(int trueMpDamage, int vampireMp, boolean isCrt, boolean isAbsrobDamage, Fighter releaser, Fighter target)
/*      */   {
/* 1699 */     AttackResult attackResult = getAttackResult(target.getid());
/* 1700 */     AttackResultBean attackResultBean = new AttackResultBean();
/*      */     
/* 1702 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 1703 */     if (isCrt) {
/* 1704 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/* 1705 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/*      */     } else {
/* 1707 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/*      */     }
/* 1709 */     if (isAbsrobDamage) {
/* 1710 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(26));
/*      */     }
/* 1712 */     attackResultBean.targetstatus.mpchange = (-trueMpDamage);
/*      */     
/* 1714 */     releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 1715 */     attackResultBean.attackerstatus.mpchange += vampireMp;
/*      */     
/* 1717 */     attackResult.attackresultbeans.add(attackResultBean);
/*      */     
/* 1719 */     return attackResultBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public AttackResultBean addHealHpRet(Fighter releser, Fighter target, int healValue, boolean iscrt)
/*      */   {
/* 1731 */     AttackResult attackResult = getAttackResult(target.getid());
/*      */     
/* 1733 */     AttackResultBean attackResultBean = new AttackResultBean();
/*      */     
/* 1735 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 1736 */     if (iscrt) {
/* 1737 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/*      */     }
/* 1739 */     attackResultBean.targetstatus.hpchange += healValue;
/* 1740 */     releser.fillFighterStatus(attackResultBean.attackerstatus);
/*      */     
/* 1742 */     attackResult.attackresultbeans.add(attackResultBean);
/* 1743 */     return attackResultBean;
/*      */   }
/*      */   
/*      */   public void addHealMpRet(Fighter releser, Fighter target, int healValue, boolean iscrt) {
/* 1747 */     AttackResult attackResult = getAttackResult(target.getid());
/*      */     
/* 1749 */     AttackResultBean attackResultBean = new AttackResultBean();
/*      */     
/* 1751 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 1752 */     if (iscrt) {
/* 1753 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/*      */     }
/* 1755 */     attackResultBean.targetstatus.mpchange += healValue;
/* 1756 */     releser.fillFighterStatus(attackResultBean.attackerstatus);
/*      */     
/* 1758 */     attackResult.attackresultbeans.add(attackResultBean);
/*      */   }
/*      */   
/*      */   public void addAngerRet(Fighter releser, Fighter target, int changeValue, boolean iscrt) {
/* 1762 */     AttackResult attackResult = getAttackResult(target.getid());
/*      */     
/* 1764 */     AttackResultBean attackResultBean = new AttackResultBean();
/*      */     
/* 1766 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 1767 */     if (iscrt) {
/* 1768 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/*      */     }
/* 1770 */     attackResultBean.targetstatus.angerchange += changeValue;
/* 1771 */     releser.fillFighterStatus(attackResultBean.attackerstatus);
/*      */     
/* 1773 */     attackResult.attackresultbeans.add(attackResultBean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addDodge(Fighter releaser, Fighter targetFighter)
/*      */   {
/* 1783 */     AttackResult attackResult = getAttackResult(targetFighter.getid());
/*      */     
/* 1785 */     AttackResultBean attackResultBean = new AttackResultBean();
/*      */     
/* 1787 */     targetFighter.fillFighterStatus(attackResultBean.targetstatus);
/* 1788 */     attackResultBean.targetstatus.status_set.add(Integer.valueOf(22));
/*      */     
/* 1790 */     releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*      */     
/* 1792 */     addCounterAttack(releaser, targetFighter, attackResultBean);
/*      */     
/* 1794 */     attackResult.attackresultbeans.add(attackResultBean);
/*      */   }
/*      */   
/*      */   public void addDodge(Fighter releaser, Fighter targetFighter, AttackOtherBeanResult attackOtherBeanResult) {
/* 1798 */     targetFighter.fillFighterStatus(attackOtherBeanResult.targetstatus);
/* 1799 */     attackOtherBeanResult.targetstatus.status_set.add(Integer.valueOf(22));
/*      */     
/* 1801 */     releaser.fillFighterStatus(attackOtherBeanResult.attackerstatus);
/*      */     
/* 1803 */     addCounterAttack(releaser, targetFighter, attackOtherBeanResult);
/*      */   }
/*      */   
/*      */   public void addDodge(Fighter releaser, Fighter targetFighter, AttackResultBean attackResultBean) {
/* 1807 */     targetFighter.fillFighterStatus(attackResultBean.targetstatus);
/* 1808 */     attackResultBean.targetstatus.status_set.add(Integer.valueOf(22));
/*      */     
/* 1810 */     releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*      */     
/* 1812 */     addCounterAttack(releaser, targetFighter, attackResultBean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addNotSealRet(Fighter releaser, Fighter target)
/*      */   {
/* 1822 */     AttackResult attackResult = getAttackResult(target.getid());
/* 1823 */     if (attackResult != null) {
/* 1824 */       AttackResultBean attackResultBean = null;
/* 1825 */       int size = attackResult.attackresultbeans.size();
/* 1826 */       if (size > 0) {
/* 1827 */         attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(size - 1);
/*      */       } else {
/* 1829 */         attackResultBean = new AttackResultBean();
/* 1830 */         releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 1831 */         target.fillFighterStatus(attackResultBean.targetstatus);
/* 1832 */         attackResult.attackresultbeans.add(attackResultBean);
/*      */       }
/* 1834 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(30));
/*      */     }
/*      */   }
/*      */   
/*      */   public void addImmuneRet(Fighter releaser, Fighter target)
/*      */   {
/* 1840 */     AttackResult attackResult = getAttackResult(target.getid());
/* 1841 */     if (attackResult != null) {
/* 1842 */       AttackResultBean attackResultBean = null;
/* 1843 */       int size = attackResult.attackresultbeans.size();
/* 1844 */       if (size > 0) {
/* 1845 */         attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(size - 1);
/*      */       } else {
/* 1847 */         attackResultBean = new AttackResultBean();
/* 1848 */         releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 1849 */         target.fillFighterStatus(attackResultBean.targetstatus);
/* 1850 */         attackResult.attackresultbeans.add(attackResultBean);
/*      */       }
/* 1852 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(31));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void updateBuffHp(Fighter fighter)
/*      */   {
/* 1861 */     if (getAttackResultMap().containsKey(Integer.valueOf(fighter.getid()))) {
/* 1862 */       AttackResult attackResult = getAttackResult(fighter.getid());
/* 1863 */       int size = attackResult.attackresultbeans.size();
/* 1864 */       if (size > 0) {
/* 1865 */         AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(size - 1);
/* 1866 */         attackResultBean.targetstatus.curhp = fighter.getHp();
/* 1867 */         attackResultBean.targetstatus.hpmax = ((int)fighter.getMaxHp());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void handleProtectResult(Fighter releser, Fighter target, Fighter.ProtectResult protectResult)
/*      */   {
/* 1876 */     if (!canBeProtect()) {
/* 1877 */       return;
/*      */     }
/* 1879 */     if (protectResult.isBeProtecetd())
/*      */     {
/* 1881 */       Fighter protectFighter = target.getFighter(protectResult.getProtectid());
/* 1882 */       if (protectFighter != null) {
/* 1883 */         Protect protect = getProtect(target.getid());
/* 1884 */         handleProtect(releser, protectResult, protect, protectFighter);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void handleProtectResult(Fighter releser, Fighter target, Fighter.ProtectResult protectResult, Protect protect) {
/* 1890 */     if (!canBeProtect()) {
/* 1891 */       return;
/*      */     }
/* 1893 */     if (protectResult.isBeProtecetd())
/*      */     {
/* 1895 */       Fighter protectFighter = target.getFighter(protectResult.getProtectid());
/* 1896 */       if (protectFighter != null) {
/* 1897 */         handleProtect(releser, protectResult, protect, protectFighter);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void handleProtect(Fighter releser, Fighter.ProtectResult protectResult, Protect protect, Fighter protectFighter)
/*      */   {
/* 1904 */     int protectDamage = protectResult.getProtectDamage();
/* 1905 */     BeDamageHandle.InputObj inputObj = new BeDamageHandle.InputObj(releser, protectFighter, null, protectDamage, 1);
/*      */     
/* 1907 */     inputObj.setProtect();
/* 1908 */     BeDamageHandle.OutputObj beDamageRet = protectFighter.handleBeDamage(inputObj);
/* 1909 */     int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 1910 */     protectFighter.addHp(releser, -trueDamage);
/*      */     
/* 1912 */     FighterStatus status = new FighterStatus();
/* 1913 */     protectFighter.fillFighterStatus(status);
/* 1914 */     status.hpchange = (-protectDamage);
/* 1915 */     if (beDamageRet.absorb) {
/* 1916 */       status.status_set.add(Integer.valueOf(26));
/*      */     }
/* 1918 */     status.status_set.add(Integer.valueOf(20));
/* 1919 */     status.status_set.add(Integer.valueOf(27));
/* 1920 */     status.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 1921 */     protect.protecterids.add(Integer.valueOf(protectResult.getProtectid()));
/* 1922 */     protect.protecterstatuses.add(status);
/* 1923 */     this.playTime += SFightConsts.getInstance().PROTECT_PLAY_TIME;
/*      */     
/* 1925 */     InfluenceOther influenceOther = (InfluenceOther)protect.influencemap.get(Integer.valueOf(protectFighter.getid()));
/* 1926 */     int size = protectFighter.getInfluenceMap().size();
/* 1927 */     if (size > 0) {
/* 1928 */       if (influenceOther == null) {
/* 1929 */         influenceOther = new InfluenceOther();
/* 1930 */         protect.influencemap.put(Integer.valueOf(protectFighter.getid()), influenceOther);
/*      */       }
/* 1932 */       influenceOther.othermap.putAll(protectFighter.getInfluenceMap());
/* 1933 */       protectFighter.clearInfluenceTarget();
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
/*      */   public void addCounterAttack(Fighter releaser, Fighter target, AttackResultBean attackResultBean)
/*      */   {
/* 1947 */     if (this.skillCfg.canBeCounterAttack) {
/* 1948 */       SSkillPlayCfg playCfg = SSkillPlayCfg.get(getSkillPlayId(this.skillCfg.skillPlayid, releaser));
/* 1949 */       if (playCfg.skillPlayType == 1) {
/* 1950 */         CounterAttack counterAttack = target.handleCounterAttack(releaser);
/* 1951 */         if (counterAttack == null) {
/* 1952 */           return;
/*      */         }
/* 1954 */         attackResultBean.counterattack = counterAttack;
/*      */       } else {
/* 1956 */         this.willCounteringFighters.add(target);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addAllCounterAttackMultiPlayType(Fighter beCountedFighter)
/*      */   {
/* 1968 */     for (Fighter counter : this.willCounteringFighters) {
/* 1969 */       if ((counter != null) && (!counter.isDead()) && (!counter.isFakeDead()))
/*      */       {
/*      */ 
/* 1972 */         addCounterAttackMultiPlayType(beCountedFighter, counter);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void addCounterAttackMultiPlayType(Fighter beCountedFighter, Fighter counter) {
/* 1978 */     FighterStatus counterStatusBeforeUseSkill = new FighterStatus();
/* 1979 */     counter.fillFighterStatus(counterStatusBeforeUseSkill);
/*      */     
/*      */ 
/* 1982 */     SSkillPlayCfg playCfg = SSkillPlayCfg.get(getSkillPlayId(this.skillCfg.skillPlayid, beCountedFighter));
/* 1983 */     if (playCfg.skillPlayType == 2) {
/* 1984 */       CounterAttack counterAttack = counter.handleCounterAttack(beCountedFighter);
/* 1985 */       if (counterAttack == null) {
/* 1986 */         return;
/*      */       }
/* 1988 */       PlaySkill playSkill = new PlaySkill();
/* 1989 */       playSkill.releaser = counterStatusBeforeUseSkill;
/* 1990 */       counterAttackToPlaySkill(playSkill, counterAttack, counter, beCountedFighter);
/*      */       
/* 1992 */       boolean recordEnable = beCountedFighter.isRecordEnable();
/* 1993 */       if (beCountedFighter.canSeeOppsiteHpProp()) {
/* 1994 */         Play play = new Play();
/* 1995 */         play.play_type = 0;
/* 1996 */         play.content = playSkill.marshal(new OctetsStream());
/* 1997 */         addPlay(play, true);
/* 1998 */         addPlay(play, false);
/* 1999 */         if (recordEnable) {
/* 2000 */           addPlay(play);
/*      */         }
/*      */       } else {
/* 2003 */         Play oppisitePlay = new Play();
/* 2004 */         PlaySkill oppisitePlaySkill = beCountedFighter.getOppsitePalySkill(playSkill, true);
/* 2005 */         oppisitePlay.play_type = 0;
/* 2006 */         oppisitePlay.content = oppisitePlaySkill.marshal(new OctetsStream());
/* 2007 */         addPlay(oppisitePlay, true);
/*      */         
/* 2009 */         Play oppisitePassivePlay = new Play();
/* 2010 */         PlaySkill oppisitePassivePlaySkill = beCountedFighter.getOppsitePalySkill(playSkill, false);
/*      */         
/* 2012 */         oppisitePassivePlay.play_type = 0;
/* 2013 */         oppisitePassivePlay.content = oppisitePassivePlaySkill.marshal(new OctetsStream());
/* 2014 */         addPlay(oppisitePassivePlay, false);
/*      */         
/* 2016 */         if (recordEnable) {
/* 2017 */           Play play = new Play();
/* 2018 */           play.play_type = 0;
/* 2019 */           play.content = playSkill.marshal(new OctetsStream());
/* 2020 */           addPlay(play);
/*      */         }
/*      */       }
/*      */       
/* 2024 */       int counterTime = 0;
/*      */       
/* 2026 */       int counterModelid = counter.getModelid();
/* 2027 */       int counterSkillCfgId = counterAttack.skill;
/* 2028 */       SSkillCfg counterSkillCfg = SSkillCfg.get(counterSkillCfgId);
/* 2029 */       int skillPlayId = getSkillPlayId(counterSkillCfg.skillPlayid, counter);
/* 2030 */       SSkillPlayCfg counterSkillPlayCfg = SSkillPlayCfg.get(skillPlayId);
/*      */       
/* 2032 */       SSkillPlayStageCfg prepareStageCfg = SSkillPlayStageCfg.get(counterSkillPlayCfg.prepareStage);
/* 2033 */       counterTime += FightUtil.calPlayStateTime(counterModelid, prepareStageCfg);
/*      */       
/* 2035 */       if (counterSkillCfgId > 0) {
/* 2036 */         calCounterAttackTime(beCountedFighter, counter.getid(), counterSkillCfgId);
/*      */         
/* 2038 */         counterTime += callSkillMoveTime(counterSkillPlayCfg, counterModelid);
/*      */       }
/*      */       
/* 2041 */       SSkillPlayStageCfg returnPlayStageCfg = SSkillPlayStageCfg.get(counterSkillPlayCfg.returnStage);
/* 2042 */       counterTime += FightUtil.calPlayStateTime(counterModelid, returnPlayStageCfg);
/*      */       
/* 2044 */       this.playTime += counterTime;
/*      */     }
/*      */   }
/*      */   
/*      */   public void counterAttackToPlaySkill(PlaySkill playSkill, CounterAttack counterAttack, Fighter counter, Fighter beCounted)
/*      */   {
/* 2050 */     playSkill.fighterid = counter.getid();
/* 2051 */     playSkill.skill = counterAttack.skill;
/* 2052 */     playSkill.skillplaytype = 7;
/*      */     
/*      */ 
/* 2055 */     playSkill.afterreleaser = counterAttack.attackerstatus;
/* 2056 */     playSkill.targets.add(Integer.valueOf(beCounted.getid()));
/*      */     
/* 2058 */     AttackResultBean attackResultBean = new AttackResultBean();
/* 2059 */     attackResultBean.attackerstatus = counterAttack.attackerstatus;
/* 2060 */     attackResultBean.targetstatus = counterAttack.targetstatus;
/* 2061 */     attackResultBean.statusmap.putAll(counterAttack.statusmap);
/*      */     
/*      */ 
/* 2064 */     AttackResult attackResult = new AttackResult();
/* 2065 */     attackResult.attackresultbeans.add(attackResultBean);
/* 2066 */     playSkill.status_map.put(Integer.valueOf(beCounted.getid()), attackResult);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2076 */     playSkill.influencemap.put(Integer.valueOf(beCounted.getid()), counterAttack.influences);
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
/*      */   public void addCounterAttack(Fighter releser, Fighter target, AttackOtherBeanResult attackOtherBeanResult)
/*      */   {
/* 2089 */     if (this.skillCfg.canBeCounterAttack)
/*      */     {
/* 2091 */       CounterAttack counterAttack = target.handleCounterAttack(releser);
/* 2092 */       if (counterAttack != null) {
/* 2093 */         attackOtherBeanResult.counterattack = counterAttack;
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
/*      */ 
/*      */   public FighterStatus getKilledFighterStatus(Fighter attacker, Fighter target)
/*      */   {
/* 2107 */     if (getAttackResultMap().containsKey(Integer.valueOf(target.getid()))) {
/* 2108 */       AttackResult attackResult = getAttackResult(target.getid());
/* 2109 */       for (int i = 0; i < attackResult.attackresultbeans.size(); i++) {
/* 2110 */         AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(i);
/* 2111 */         FighterStatus status = attackResultBean.targetstatus;
/* 2112 */         if (status.status_set.contains(Integer.valueOf(3))) {
/* 2113 */           return status;
/*      */         }
/*      */       }
/* 2116 */     } else if (getHitAgainMap().containsKey(Integer.valueOf(target.getid()))) {
/* 2117 */       HitAgain hitAgain = getHitAgain(target.getid());
/* 2118 */       AttackResult attackResult = (AttackResult)hitAgain.status_map.get(Integer.valueOf(target.getid()));
/* 2119 */       if (attackResult != null) {
/* 2120 */         for (int i = 0; i < attackResult.attackresultbeans.size(); i++) {
/* 2121 */           AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(i);
/* 2122 */           FighterStatus status = attackResultBean.targetstatus;
/* 2123 */           if (status.status_set.contains(Integer.valueOf(3))) {
/* 2124 */             return status;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */     }
/* 2130 */     else if (getAttackResultMap().containsKey(Integer.valueOf(attacker.getid()))) {
/* 2131 */       AttackResult attackResult = getAttackResult(attacker.getid());
/* 2132 */       for (int i = 0; i < attackResult.attackresultbeans.size(); i++) {
/* 2133 */         AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(i);
/* 2134 */         FighterStatus status = attackResultBean.counterattack.targetstatus;
/* 2135 */         if (status.status_set.contains(Integer.valueOf(3))) {
/* 2136 */           return status;
/*      */         }
/*      */       }
/*      */     }
/* 2140 */     else if (getHitAgainMap().containsKey(Integer.valueOf(attacker.getid()))) {
/* 2141 */       HitAgain hitAgain = getHitAgain(attacker.getid());
/* 2142 */       AttackResult attackResult = (AttackResult)hitAgain.status_map.get(Integer.valueOf(attacker.getid()));
/* 2143 */       if (attackResult != null) {
/* 2144 */         for (int i = 0; i < attackResult.attackresultbeans.size(); i++) {
/* 2145 */           AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(i);
/* 2146 */           FighterStatus status = attackResultBean.counterattack.targetstatus;
/* 2147 */           if (status.status_set.contains(Integer.valueOf(3))) {
/* 2148 */             return status;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2157 */     for (AttackResult attackResult : getAttackResultMap().values()) {
/* 2158 */       for (AttackResultBean attackResultBean : attackResult.attackresultbeans) {
/* 2159 */         for (AttackOtherBean attackOtherBean : attackResultBean.attackothers) {
/* 2160 */           if ((attackOtherBean.targetid == target.getid()) && 
/* 2161 */             (attackOtherBean.attackinnerbean.targetstatus.status_set.contains(Integer.valueOf(3))))
/*      */           {
/* 2163 */             return attackOtherBean.attackinnerbean.targetstatus;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2169 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addTargetInfluenceMap(Fighter target, Set<Integer> influenceFighters)
/*      */   {
/* 2180 */     Map<Integer, FighterStatus> influenceOtherMap = null;
/* 2181 */     if (this.targetInfluenceMap.containsKey(Integer.valueOf(target.getid()))) {
/* 2182 */       influenceOtherMap = (Map)this.targetInfluenceMap.get(Integer.valueOf(target.getid()));
/*      */     } else {
/* 2184 */       influenceOtherMap = new HashMap();
/* 2185 */       this.targetInfluenceMap.put(Integer.valueOf(target.getid()), influenceOtherMap);
/*      */     }
/* 2187 */     for (Iterator i$ = influenceFighters.iterator(); i$.hasNext();) { int fighterid = ((Integer)i$.next()).intValue();
/* 2188 */       Fighter influenceFighter = target.getFighter(fighterid);
/* 2189 */       if (influenceFighter != null) {
/* 2190 */         FighterStatus fighterStatus = new FighterStatus();
/* 2191 */         influenceFighter.fillFighterStatus(fighterStatus);
/* 2192 */         influenceOtherMap.put(Integer.valueOf(fighterid), fighterStatus);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void addTargetInfluenceMap(Fighter target, Map<Integer, FighterStatus> influenceMap) {
/* 2198 */     Map<Integer, FighterStatus> influenceOtherMap = null;
/* 2199 */     if (this.targetInfluenceMap.containsKey(Integer.valueOf(target.getid()))) {
/* 2200 */       influenceOtherMap = (Map)this.targetInfluenceMap.get(Integer.valueOf(target.getid()));
/*      */     } else {
/* 2202 */       influenceOtherMap = new HashMap();
/* 2203 */       this.targetInfluenceMap.put(Integer.valueOf(target.getid()), influenceOtherMap);
/*      */     }
/* 2205 */     influenceOtherMap.putAll(influenceMap);
/*      */   }
/*      */   
/*      */   public void handleShareDamageInCounterAttack(Fighter counter, BeDamageHandle.OutputObj beDamageRet, CounterAttack counterAttack)
/*      */   {
/* 2210 */     if (beDamageRet == null)
/*      */       return;
/*      */     int shareDamage;
/* 2213 */     if (((beDamageRet.shareDamage > 0) || (beDamageRet.shareDamageUnvampire > 0)) && (beDamageRet.shareDamageFighters.size() > 0))
/*      */     {
/* 2215 */       shareDamage = (beDamageRet.shareDamage + beDamageRet.shareDamageUnvampire) / beDamageRet.shareDamageFighters.size();
/*      */       
/* 2217 */       shareDamage = Math.max(1, shareDamage);
/* 2218 */       for (Fighter fighter : beDamageRet.shareDamageFighters) {
/* 2219 */         fighter.addHp(counter, -shareDamage);
/*      */         
/* 2221 */         ShareDamageRet shareDamageRet = new ShareDamageRet();
/* 2222 */         fighter.fillFighterStatus(shareDamageRet.sharedamagestatus);
/* 2223 */         Set<Integer> fighterShareDamageTypes = (Set)beDamageRet.fighterShareDamageTypes.get(Integer.valueOf(fighter.getid()));
/* 2224 */         if (null != fighterShareDamageTypes)
/*      */         {
/* 2226 */           shareDamageRet.sharedamagestatus.status_set.addAll(fighterShareDamageTypes);
/*      */         }
/*      */         
/* 2229 */         shareDamageRet.sharedamagestatus.hpchange -= shareDamage;
/* 2230 */         shareDamageRet.targetid = fighter.getid();
/*      */         
/* 2232 */         if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 2233 */           BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new BeKilledHandle.InputObj(counter, fighter, this, shareDamage));
/*      */           
/*      */ 
/* 2236 */           shareDamageRet.sharedamagestatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 2237 */           if (fighter.isAlive()) {
/* 2238 */             shareDamageRet.sharedamagestatus.status_set.remove(Integer.valueOf(1));
/* 2239 */             shareDamageRet.sharedamagestatus.status_set.add(Integer.valueOf(3));
/* 2240 */             FighterStatus fighterStatus = new FighterStatus();
/* 2241 */             fighterStatus.status_set.add(Integer.valueOf(23));
/* 2242 */             fighterStatus.hpchange += fighter.getHp();
/* 2243 */             fighter.fillFighterStatus(fighterStatus);
/* 2244 */             shareDamageRet.statusmap.put(Integer.valueOf(1), fighterStatus);
/* 2245 */             counterAttack.influences.othermap.put(Integer.valueOf(-fighter.getid()), fighterStatus);
/*      */           }
/*      */         }
/*      */         
/* 2249 */         counterAttack.influences.othermap.put(Integer.valueOf(fighter.getid()), shareDamageRet.sharedamagestatus);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void handleShareDamage(Fighter releaser, BeDamageHandle.OutputObj beDamageRet, AttackResultBean attackResultBean)
/*      */   {
/*      */     int shareDamage;
/* 2257 */     if (((beDamageRet.shareDamage > 0) || (beDamageRet.shareDamageUnvampire > 0)) && (beDamageRet.shareDamageFighters.size() > 0))
/*      */     {
/* 2259 */       shareDamage = (beDamageRet.shareDamage + beDamageRet.shareDamageUnvampire) / beDamageRet.shareDamageFighters.size();
/*      */       
/* 2261 */       shareDamage = Math.max(1, shareDamage);
/* 2262 */       for (Fighter fighter : beDamageRet.shareDamageFighters) {
/* 2263 */         fighter.addHp(releaser, -shareDamage);
/*      */         
/* 2265 */         ShareDamageRet shareDamageRet = new ShareDamageRet();
/* 2266 */         fighter.fillFighterStatus(shareDamageRet.sharedamagestatus);
/* 2267 */         Set<Integer> fighterShareDamageTypes = (Set)beDamageRet.fighterShareDamageTypes.get(Integer.valueOf(fighter.getid()));
/* 2268 */         if (null != fighterShareDamageTypes)
/*      */         {
/* 2270 */           shareDamageRet.sharedamagestatus.status_set.addAll(fighterShareDamageTypes);
/*      */         }
/*      */         
/* 2273 */         shareDamageRet.sharedamagestatus.hpchange -= shareDamage;
/* 2274 */         shareDamageRet.targetid = fighter.getid();
/*      */         
/* 2276 */         if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 2277 */           BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new BeKilledHandle.InputObj(releaser, fighter, this, shareDamage));
/*      */           
/*      */ 
/* 2280 */           shareDamageRet.sharedamagestatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 2281 */           if (fighter.isAlive()) {
/* 2282 */             shareDamageRet.sharedamagestatus.status_set.remove(Integer.valueOf(1));
/* 2283 */             shareDamageRet.sharedamagestatus.status_set.add(Integer.valueOf(3));
/* 2284 */             FighterStatus fighterStatus = new FighterStatus();
/* 2285 */             fighterStatus.status_set.add(Integer.valueOf(23));
/* 2286 */             fighterStatus.hpchange += fighter.getHp();
/* 2287 */             fighter.fillFighterStatus(fighterStatus);
/* 2288 */             shareDamageRet.statusmap.put(Integer.valueOf(1), fighterStatus);
/*      */           }
/*      */         }
/* 2291 */         attackResultBean.sharedamagetargets.add(shareDamageRet);
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
/*      */   public int calFixTime(Fighter releaser, PlaySkill playSkill)
/*      */   {
/* 2304 */     return calFixTime(releaser, playSkill.targets, playSkill.hitagain_map, playSkill.status_map, SSkillCfg.get(playSkill.skill));
/*      */   }
/*      */   
/*      */   public int calFixTime(Fighter releaser)
/*      */   {
/* 2309 */     return calFixTime(releaser, this.targets, getHitAgainMap(), getAttackResultMap(), this.skillCfg);
/*      */   }
/*      */   
/*      */ 
/*      */   private int calFixTime(Fighter releaser, List<Integer> targets, Map<Integer, HitAgain> hitAgainMap, Map<Integer, AttackResult> attackResultMap, SSkillCfg releserSkillCfg)
/*      */   {
/*      */     try
/*      */     {
/* 2317 */       int targetSize = targets.size();
/* 2318 */       int modifyTime = 0;
/* 2319 */       if (targetSize <= 0) {
/* 2320 */         return modifyTime;
/*      */       }
/*      */       
/* 2323 */       if (releaser.isFakeDead()) {
/* 2324 */         modifyTime += DurationCfgManager.getActionDuration(releaser.getModelid(), SFightConsts.getInstance().DEATH_ACTION_ID);
/*      */       }
/* 2326 */       else if (releaser.isDead())
/*      */       {
/* 2328 */         modifyTime += SFightConsts.getInstance().BREAK_EFFECT_TIME;
/*      */       }
/* 2330 */       int lastTargetid = ((Integer)targets.get(targetSize - 1)).intValue();
/*      */       
/* 2332 */       int coverTime = 0;
/*      */       
/* 2334 */       int stageLateTime = 0;
/* 2335 */       int releaserModelid = releaser.getModelid();
/* 2336 */       int deathTime; if (hitAgainMap.containsKey(Integer.valueOf(lastTargetid)))
/*      */       {
/* 2338 */         HitAgain hitAgain = (HitAgain)hitAgainMap.get(Integer.valueOf(lastTargetid));
/* 2339 */         int hitAgainLastTarget = ((Integer)hitAgain.targets.get(hitAgain.targets.size() - 1)).intValue();
/* 2340 */         AttackResult attackResult = (AttackResult)hitAgain.status_map.get(Integer.valueOf(hitAgainLastTarget));
/* 2341 */         int attackSize = attackResult.attackresultbeans.size();
/* 2342 */         AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(attackSize - 1);
/* 2343 */         if ((attackResultBean.targetstatus.status_set.contains(Integer.valueOf(1))) || (attackResultBean.targetstatus.status_set.contains(Integer.valueOf(3))))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 2348 */           BeAttackedBean beAttackedBean = null;
/* 2349 */           int skillid = releaser.getNormalSkill();
/* 2350 */           SSkillCfg skillCfg = SSkillCfg.get(skillid);
/* 2351 */           SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(getSkillPlayId(skillCfg.skillPlayid, releaser));
/* 2352 */           int skillPlayStageid = ((Integer)skillPlayCfg.effectStages.get(0)).intValue();
/* 2353 */           for (Iterator i$ = skillPlayCfg.effectStages.iterator(); i$.hasNext();) { int effectStage = ((Integer)i$.next()).intValue();
/* 2354 */             if (effectStage > 0) {
/* 2355 */               skillPlayStageid = effectStage;
/* 2356 */               break;
/*      */             }
/*      */           }
/* 2359 */           SSkillPlayStageCfg skillPlayStageCfg = SSkillPlayStageCfg.get(skillPlayStageid);
/* 2360 */           int actionid = skillPlayStageCfg.actionid;
/* 2361 */           if (!SMoveAction.getAll().containsKey(Integer.valueOf(actionid)))
/*      */           {
/* 2363 */             ActionData sAction = DurationCfgManager.getAction(releaserModelid, actionid);
/* 2364 */             if ((sAction != null) && (sAction.beAttackedList.size() > 0)) {
/* 2365 */               beAttackedBean = (BeAttackedBean)sAction.beAttackedList.get(0);
/* 2366 */               stageLateTime = beAttackedBean.beAttackedTime;
/*      */ 
/*      */ 
/*      */             }
/* 2370 */             else if (skillPlayStageCfg.effectlist.size() > 0) {
/* 2371 */               Effectid2LateTime effectid2LateTime = (Effectid2LateTime)skillPlayStageCfg.effectlist.get(0);
/* 2372 */               int effectid = effectid2LateTime.effectid;
/* 2373 */               EffectPlayData effectPlayCfg = DurationCfgManager.getEffectPlayCfg(releaserModelid, effectid);
/*      */               
/* 2375 */               if (effectPlayCfg.beAttackedList.size() > 0) {
/* 2376 */                 beAttackedBean = (BeAttackedBean)effectPlayCfg.beAttackedList.get(0);
/* 2377 */                 stageLateTime = effectid2LateTime.lateTime + beAttackedBean.beAttackedTime;
/*      */               }
/*      */             }
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 2385 */           int stageEffetTime = FightUtil.calPlayStateTime(releaserModelid, skillPlayStageCfg);
/* 2386 */           coverTime = stageEffetTime - stageLateTime;
/*      */           
/*      */ 
/* 2389 */           int returnStage = SSkillPlayCfg.get(getSkillPlayId(releserSkillCfg.skillPlayid, releaser)).returnStage;
/* 2390 */           if (returnStage > 0) {
/* 2391 */             coverTime += FightUtil.calPlayStateTime(releaserModelid, SSkillPlayStageCfg.get(returnStage));
/*      */           }
/*      */           
/*      */ 
/* 2395 */           Fighter fighter = releaser.getFighter(lastTargetid);
/* 2396 */           boolean trueDeath = attackResultBean.targetstatus.status_set.contains(Integer.valueOf(1));
/* 2397 */           int deathTime = calTargetDeathTime(fighter.getModelid(), skillPlayCfg, beAttackedBean, trueDeath);
/* 2398 */           if (deathTime > coverTime) {
/* 2399 */             modifyTime += deathTime - coverTime;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 2406 */         AttackResult attackResult = (AttackResult)attackResultMap.get(Integer.valueOf(lastTargetid));
/* 2407 */         int attackSize = attackResult.attackresultbeans.size();
/* 2408 */         AttackResultBean attackResultBean = (AttackResultBean)attackResult.attackresultbeans.get(attackSize - 1);
/*      */         
/* 2410 */         if ((attackResultBean.targetstatus.status_set.contains(Integer.valueOf(1))) || (attackResultBean.targetstatus.status_set.contains(Integer.valueOf(3))))
/*      */         {
/* 2412 */           SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(getSkillPlayId(releserSkillCfg.skillPlayid, releaser));
/*      */           
/* 2414 */           BeAttackedBean beAttackedBean = null;
/*      */           
/*      */ 
/* 2417 */           List<Integer> effectStateges = new ArrayList();
/* 2418 */           for (Iterator i$ = skillPlayCfg.effectStages.iterator(); i$.hasNext();) { int effectStage = ((Integer)i$.next()).intValue();
/* 2419 */             if (effectStage > 0) {
/* 2420 */               effectStateges.add(Integer.valueOf(effectStage));
/*      */             }
/*      */           }
/* 2423 */           int skillPlayStageid = ((Integer)effectStateges.get(0)).intValue();
/*      */           
/* 2425 */           if (skillPlayCfg.skillPlayType == 2)
/*      */           {
/* 2427 */             skillPlayStageid = ((Integer)effectStateges.get(0)).intValue();
/*      */           }
/* 2429 */           else if (skillPlayCfg.skillPlayType == 1)
/*      */           {
/* 2431 */             if (effectStateges.size() < targetSize) {
/* 2432 */               int index = targetSize % effectStateges.size();
/*      */               
/* 2434 */               index--;
/* 2435 */               if (index < 0) {
/* 2436 */                 index += effectStateges.size();
/*      */               }
/* 2438 */               skillPlayStageid = ((Integer)effectStateges.get(index)).intValue();
/*      */             } else {
/* 2440 */               skillPlayStageid = ((Integer)effectStateges.get(targetSize - 1)).intValue();
/*      */             }
/*      */           }
/* 2443 */           SSkillPlayStageCfg skillPlayStageCfg = SSkillPlayStageCfg.get(skillPlayStageid);
/*      */           
/* 2445 */           int actionid = skillPlayStageCfg.actionid;
/* 2446 */           if (!SMoveAction.getAll().containsKey(Integer.valueOf(actionid)))
/*      */           {
/* 2448 */             ActionData sAction = DurationCfgManager.getAction(releaserModelid, actionid);
/*      */             
/* 2450 */             int actionSize = 0;
/* 2451 */             if (sAction != null) {
/* 2452 */               actionSize = sAction.beAttackedList.size();
/*      */             }
/* 2454 */             if ((sAction != null) && (actionSize >= attackSize)) {
/* 2455 */               beAttackedBean = (BeAttackedBean)sAction.beAttackedList.get(attackSize - 1);
/* 2456 */               stageLateTime = beAttackedBean.beAttackedTime;
/*      */             } else {
/* 2458 */               attackSize -= actionSize;
/*      */               
/* 2460 */               for (Effectid2LateTime effectid2LateTime : skillPlayStageCfg.effectlist) {
/* 2461 */                 EffectPlayData effectPlayCfg = DurationCfgManager.getEffectPlayCfg(releaserModelid, effectid2LateTime.effectid);
/*      */                 
/* 2463 */                 if (effectPlayCfg.beAttackedList.size() >= attackSize) {
/* 2464 */                   beAttackedBean = (BeAttackedBean)effectPlayCfg.beAttackedList.get(attackSize - 1);
/* 2465 */                   stageLateTime = effectid2LateTime.lateTime + beAttackedBean.beAttackedTime;
/* 2466 */                   break;
/*      */                 }
/* 2468 */                 attackSize -= effectPlayCfg.beAttackedList.size();
/*      */               }
/*      */             }
/*      */           }
/*      */           
/* 2473 */           int stageEffetTime = FightUtil.calPlayStateTime(releaserModelid, skillPlayStageCfg);
/* 2474 */           coverTime = stageEffetTime - stageLateTime;
/*      */           
/*      */ 
/* 2477 */           int returnStage = SSkillPlayCfg.get(getSkillPlayId(releserSkillCfg.skillPlayid, releaser)).returnStage;
/* 2478 */           if (returnStage > 0) {
/* 2479 */             coverTime += FightUtil.calPlayStateTime(releaserModelid, SSkillPlayStageCfg.get(returnStage));
/*      */           }
/*      */           
/*      */ 
/* 2483 */           Fighter fighter = releaser.getFighter(lastTargetid);
/* 2484 */           boolean trueDeath = attackResultBean.targetstatus.status_set.contains(Integer.valueOf(1));
/* 2485 */           deathTime = calTargetDeathTime(fighter.getModelid(), skillPlayCfg, beAttackedBean, trueDeath);
/* 2486 */           if (deathTime <= coverTime) {} } }
/* 2487 */       return modifyTime + (deathTime - coverTime);
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*      */ 
/* 2494 */       GameServer.logger().error("计算技能补偿时间出错", e);
/*      */     }
/* 2496 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */   private int calTargetDeathTime(int modelid, SSkillPlayCfg skillPlayCfg, BeAttackedBean beAttackedBean, boolean trueDeath)
/*      */   {
/* 2502 */     if (beAttackedBean != null) {
/* 2503 */       switch (beAttackedBean.beAttackedAction) {
/*      */       case 0: 
/* 2505 */         if (!trueDeath) {
/* 2506 */           return DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().DEATH_ACTION_ID);
/*      */         }
/* 2508 */         if (skillPlayCfg.deadStyle == 1)
/*      */         {
/* 2510 */           return DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().DEATH_ACTION_ID); }
/* 2511 */         if (skillPlayCfg.deadStyle == 3) {
/* 2512 */           int beAttackedTime = DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().BEATTACKED_ACTION_ID);
/*      */           
/*      */ 
/* 2515 */           return beAttackedTime / 2 + SFightConsts.getInstance().BREAK_EFFECT_TIME; }
/* 2516 */         if (skillPlayCfg.deadStyle == 2) {
/* 2517 */           int deathTime = DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().DEATH_ACTION_ID);
/*      */           
/*      */ 
/* 2520 */           return deathTime + SFightConsts.getInstance().DISSOLVE_EFFECT_TIME;
/*      */         }
/*      */         
/*      */ 
/*      */         break;
/*      */       case 1: 
/* 2526 */         return DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().DEATH_ACTION_ID);
/*      */       case 2: 
/* 2528 */         int flyTotalTime = SBeAttackFlyCfg.get(beAttackedBean.beAttackedActionid).time * 2 + DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().BEATTACKED_FLY_ACTION_ID);
/*      */         
/*      */ 
/*      */ 
/* 2532 */         if (!trueDeath) {
/* 2533 */           return flyTotalTime;
/*      */         }
/* 2535 */         if (skillPlayCfg.deadStyle == 2)
/* 2536 */           return flyTotalTime + SFightConsts.getInstance().DISSOLVE_EFFECT_TIME;
/* 2537 */         if (skillPlayCfg.deadStyle == 3) {
/* 2538 */           return flyTotalTime + SFightConsts.getInstance().BREAK_EFFECT_TIME;
/*      */         }
/* 2540 */         return flyTotalTime;
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2547 */     return DurationCfgManager.getActionDuration(modelid, SFightConsts.getInstance().DEATH_ACTION_ID);
/*      */   }
/*      */   
/*      */   public void addReplacedEffectGroupId(int oldEffectGroupId, int newEffectGroupId) {
/* 2551 */     this.replacedEffectGroup.put(Integer.valueOf(oldEffectGroupId), Integer.valueOf(newEffectGroupId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getKillCount()
/*      */   {
/* 2560 */     int count = 0;
/* 2561 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2562 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2563 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2564 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 2565 */       for (i$ = attackResult.attackresultbeans.iterator(); i$.hasNext();) { bean = (AttackResultBean)i$.next();
/* 2566 */         if ((bean.targetstatus.curhp <= 0) && (bean.targetstatus.hpchange < 0)) {
/* 2567 */           count++;
/*      */         }
/*      */         
/* 2570 */         for (AttackOtherBean otherBean : bean.attackothers)
/* 2571 */           if ((otherBean.attackinnerbean.targetstatus.curhp <= 0) && (bean.targetstatus.hpchange < 0))
/* 2572 */             count++;
/*      */       }
/*      */     }
/*      */     Iterator i$;
/*      */     AttackResultBean bean;
/* 2577 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getRebornCount()
/*      */   {
/* 2586 */     int count = 0;
/* 2587 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2588 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2589 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2590 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 2591 */       for (AttackResultBean bean : attackResult.attackresultbeans) {
/* 2592 */         if (bean.statusmap.containsKey(Integer.valueOf(1))) {
/* 2593 */           count++;
/*      */         }
/*      */         
/* 2596 */         for (AttackOtherBean otherBean : bean.attackothers) {
/* 2597 */           if (otherBean.attackinnerbean.statusmap.containsKey(Integer.valueOf(1))) {
/* 2598 */             count++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2604 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getDodgeCount()
/*      */   {
/* 2613 */     int count = 0;
/* 2614 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2615 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2616 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2617 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 2618 */       for (AttackResultBean bean : attackResult.attackresultbeans) {
/* 2619 */         if (bean.targetstatus.status_set.contains(Integer.valueOf(22))) {
/* 2620 */           count++;
/*      */         }
/*      */         
/* 2623 */         for (AttackOtherBean otherBean : bean.attackothers) {
/* 2624 */           if (otherBean.attackinnerbean.targetstatus.status_set.contains(Integer.valueOf(22))) {
/* 2625 */             count++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2630 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getCriticalCount()
/*      */   {
/* 2639 */     int count = 0;
/* 2640 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2641 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2642 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2643 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 2644 */       for (AttackResultBean bean : attackResult.attackresultbeans) {
/* 2645 */         if (bean.targetstatus.status_set.contains(Integer.valueOf(21))) {
/* 2646 */           count++;
/*      */         }
/*      */         
/* 2649 */         for (AttackOtherBean otherBean : bean.attackothers) {
/* 2650 */           if (otherBean.attackinnerbean.targetstatus.status_set.contains(Integer.valueOf(21)))
/*      */           {
/* 2652 */             count++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2657 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getHitTimesCount()
/*      */   {
/* 2666 */     int count = 0;
/* 2667 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2668 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2669 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2670 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 2671 */       for (AttackResultBean bean : attackResult.attackresultbeans) {
/* 2672 */         count++;
/* 2673 */         count += bean.attackothers.size();
/*      */       }
/*      */     }
/* 2676 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTargetHpLeftLittlePercentCount(int percent, boolean includeDead)
/*      */   {
/* 2687 */     int count = 0;
/* 2688 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2689 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2690 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2691 */       AttackResult attackResult = (AttackResult)entry.getValue();
/* 2692 */       int size = attackResult.attackresultbeans.size();
/* 2693 */       if (size > 0)
/*      */       {
/*      */ 
/* 2696 */         Map<Integer, FighterStatus> map = new HashMap();
/* 2697 */         AttackResultBean lastBean = (AttackResultBean)attackResult.attackresultbeans.get(size - 1);
/* 2698 */         map.put(entry.getKey(), lastBean.targetstatus);
/*      */         
/* 2700 */         for (AttackOtherBean otherBean : lastBean.attackothers) {
/* 2701 */           map.put(Integer.valueOf(otherBean.targetid), otherBean.attackinnerbean.targetstatus);
/*      */         }
/*      */         
/* 2704 */         for (FighterStatus targetstatus : map.values()) {
/* 2705 */           if (targetstatus.curhp <= 0) {
/* 2706 */             if (includeDead) {
/* 2707 */               count++;
/*      */             }
/*      */           } else {
/* 2710 */             float nowPercent = targetstatus.curhp * 100.0F / targetstatus.hpmax;
/* 2711 */             if (nowPercent <= percent)
/* 2712 */               count++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2717 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getKilledMonsters(Fighter releaser)
/*      */   {
/* 2724 */     List<Integer> list = new ArrayList();
/* 2725 */     Map<Integer, AttackResult> attackResultMap = getAttackResultMap();
/* 2726 */     Set<Map.Entry<Integer, AttackResult>> set = attackResultMap.entrySet();
/* 2727 */     for (Map.Entry<Integer, AttackResult> entry : set) {
/* 2728 */       int fighterId = ((Integer)entry.getKey()).intValue();
/* 2729 */       beAttackedFighter = releaser.getFighter(fighterId);
/* 2730 */       if ((beAttackedFighter != null) && 
/*      */       
/*      */ 
/* 2733 */         (beAttackedFighter.isMonster()))
/*      */       {
/*      */ 
/* 2736 */         AttackResult attackResult = (AttackResult)entry.getValue();
/* 2737 */         for (AttackResultBean bean : attackResult.attackresultbeans) {
/* 2738 */           if (bean.targetstatus.curhp <= 0) {
/* 2739 */             list.add(Integer.valueOf(((FighterMonster)beAttackedFighter).getMonsterid()));
/*      */           }
/* 2741 */           for (AttackOtherBean otherBean : bean.attackothers) {
/* 2742 */             int targetId = otherBean.targetid;
/* 2743 */             Fighter otherFighter = releaser.getFighter(targetId);
/* 2744 */             if ((otherFighter != null) && 
/*      */             
/*      */ 
/* 2747 */               (otherFighter.isMonster()))
/*      */             {
/*      */ 
/* 2750 */               if (otherBean.attackinnerbean.targetstatus.curhp <= 0)
/* 2751 */                 list.add(Integer.valueOf(((FighterMonster)otherFighter).getMonsterid())); }
/*      */           }
/*      */         }
/*      */       } }
/*      */     Fighter beAttackedFighter;
/* 2756 */     return list;
/*      */   }
/*      */   
/*      */   public int getSkillAttackTimes() {
/* 2760 */     int count = 0;
/* 2761 */     Set<Map.Entry<Integer, AttackResult>> entrySet = this.attackResultMap.entrySet();
/* 2762 */     for (Map.Entry<Integer, AttackResult> entry : entrySet) {
/* 2763 */       AttackResult result = (AttackResult)entry.getValue();
/* 2764 */       int size = result.attackresultbeans.size();
/* 2765 */       for (int i = 0; i < size; i++) {
/* 2766 */         AttackResultBean bean = (AttackResultBean)result.attackresultbeans.get(i);
/* 2767 */         if (bean.targetstatus.status_set.contains(Integer.valueOf(20))) {
/* 2768 */           count++;
/*      */         }
/*      */       }
/*      */     }
/* 2772 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public final int getSkillPlayId(int playId, Fighter releaser)
/*      */   {
/* 2783 */     if (releaser == null) {
/* 2784 */       return playId;
/*      */     }
/* 2786 */     SSkillPlayMapCfg playMapCfg = SSkillPlayMapCfg.get(playId);
/* 2787 */     if (playMapCfg == null) {
/* 2788 */       return playId;
/*      */     }
/* 2790 */     int size = playMapCfg.skillPlays.size();
/* 2791 */     for (int i = 0; i < size; i++) {
/* 2792 */       FightStateSkillPlay fightStatePlayCfg = (FightStateSkillPlay)playMapCfg.skillPlays.get(i);
/* 2793 */       if (releaser.hasFightState(fightStatePlayCfg.fightStateGroupId, fightStatePlayCfg.fightState)) {
/* 2794 */         return fightStatePlayCfg.finalSkillPlayid;
/*      */       }
/*      */     }
/* 2797 */     return playId;
/*      */   }
/*      */   
/*      */   public final void addEffectTarget(int targetId) {
/* 2801 */     if (!this.effectTargets.contains(Integer.valueOf(targetId))) {
/* 2802 */       this.effectTargets.add(Integer.valueOf(targetId));
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\Skill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */