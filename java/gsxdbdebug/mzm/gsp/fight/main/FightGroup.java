/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.OpItem;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlayChangeFighter;
/*     */ import mzm.gsp.fight.PlayUseItem;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SItemTypeInFightCfg;
/*     */ import mzm.gsp.fight.fighter.selector.AliveFighterSelector;
/*     */ import mzm.gsp.fight.fighter.selector.AliveRoleOrFellowFighterSelector;
/*     */ import mzm.gsp.fight.fighter.selector.ExistedFighterSelector;
/*     */ import mzm.gsp.fight.fighter.selector.FighterSelector;
/*     */ import mzm.gsp.fight.handle.DrugHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DrugHandle.OutputObj;
/*     */ import mzm.gsp.item.confbean.SDrugItem;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.monster.main.Monster;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.Skill.Attack;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class FightGroup
/*     */ {
/*     */   protected final int groupid;
/*     */   protected final xbean.FightGroup xGroup;
/*     */   protected final FightTeam fightTeam;
/*     */   private static final int CLONE_TYPE = 1;
/*     */   
/*     */   FightGroup(int groupid, xbean.FightGroup xGroup, FightTeam fightTeam)
/*     */   {
/*  58 */     this.groupid = groupid;
/*  59 */     this.xGroup = xGroup;
/*  60 */     this.fightTeam = fightTeam;
/*     */   }
/*     */   
/*     */   protected final Fight getFight() {
/*  64 */     return this.fightTeam.getFight();
/*     */   }
/*     */   
/*     */   protected final boolean isRecordEnable() {
/*  68 */     return this.fightTeam.fight.isRecordEnable();
/*     */   }
/*     */   
/*     */   protected FighterMonster addMonster(Monster m, int pos) {
/*  72 */     FighterMonster fm = generateFighterMonster();
/*  73 */     fm.init(m, pos);
/*  74 */     return fm;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected FighterPet addPet(Pet p, int pos)
/*     */   {
/*  84 */     FighterPet fp = generateFighterPet();
/*  85 */     fp.init(p, pos);
/*  86 */     return fp;
/*     */   }
/*     */   
/*     */   protected FighterChild addChild(ChildrenOutFightObj child, int pos) {
/*  90 */     FighterChild fc = generateFighterChild();
/*  91 */     fc.init(child, pos);
/*  92 */     return fc;
/*     */   }
/*     */   
/*     */   protected final FighterMonster generateFighterMonster() {
/*  96 */     xbean.Fighter xFighter = Pod.newFighter();
/*  97 */     int fighterid = getFight().getNextID();
/*  98 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/*  99 */     xFighter.setType(8);
/* 100 */     return new FighterMonster(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final FighterNpcMonster generateFighterNpcMonster() {
/* 104 */     xbean.Fighter xFighter = Pod.newFighter();
/* 105 */     int fighterid = getFight().getNextID();
/* 106 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 107 */     xFighter.setType(8);
/* 108 */     return new FighterNpcMonster(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final FighterInvincibleMonster generateFighterInvincibleMonster() {
/* 112 */     xbean.Fighter xFighter = Pod.newFighter();
/* 113 */     int fighterid = getFight().getNextID();
/* 114 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 115 */     xFighter.setType(8);
/* 116 */     return new FighterInvincibleMonster(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final FighterFellow generateFighterFellow() {
/* 120 */     xbean.Fighter xFighter = Pod.newFighter();
/* 121 */     int fighterid = getFight().getNextID();
/* 122 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 123 */     xFighter.setType(2);
/* 124 */     return new FighterFellow(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final CloneFighterFellow generateCloneFighterFellow() {
/* 128 */     xbean.Fighter xFighter = Pod.newFighter();
/* 129 */     int fighterid = getFight().getNextID();
/* 130 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 131 */     xFighter.setType(2);
/* 132 */     return new CloneFighterFellow(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final FighterRole generateFighterRole() {
/* 136 */     xbean.Fighter xFighter = Pod.newFighter();
/* 137 */     int fighterid = getFight().getNextID();
/* 138 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 139 */     xFighter.setType(1);
/* 140 */     return new FighterRole(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final CloneFighterRole generateCloneFighterRole() {
/* 144 */     xbean.Fighter xFighter = Pod.newFighter();
/* 145 */     int fighterid = getFight().getNextID();
/* 146 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 147 */     xFighter.setType(1);
/* 148 */     return new CloneFighterRole(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final FighterPet generateFighterPet() {
/* 152 */     xbean.Fighter xFighter = Pod.newFighter();
/* 153 */     int fighterid = getFight().getNextID();
/* 154 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 155 */     xFighter.setType(4);
/* 156 */     return new FighterPet(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final CloneFighterPet generateCloneFighterPet() {
/* 160 */     xbean.Fighter xFighter = Pod.newFighter();
/* 161 */     int fighterid = getFight().getNextID();
/* 162 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 163 */     xFighter.setType(4);
/* 164 */     return new CloneFighterPet(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final FighterChild generateFighterChild() {
/* 168 */     xbean.Fighter xFighter = Pod.newFighter();
/* 169 */     int fighterid = getFight().getNextID();
/* 170 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 171 */     xFighter.setType(16);
/* 172 */     return new FighterChild(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final CloneFighterChild generateCloneFighterChild() {
/* 176 */     xbean.Fighter xFighter = Pod.newFighter();
/* 177 */     int fighterid = getFight().getNextID();
/* 178 */     this.xGroup.getMembers().put(Integer.valueOf(fighterid), xFighter);
/* 179 */     xFighter.setType(16);
/* 180 */     return new CloneFighterChild(fighterid, xFighter, this);
/*     */   }
/*     */   
/*     */   protected final boolean isGroupRole() {
/* 184 */     return this.xGroup.getType() == 0;
/*     */   }
/*     */   
/*     */   protected final boolean isGroupMonster() {
/* 188 */     return this.xGroup.getType() == 1;
/*     */   }
/*     */   
/*     */   protected final boolean isGroupFellow() {
/* 192 */     return this.xGroup.getType() == 2;
/*     */   }
/*     */   
/*     */   protected final int getExtra(FightGroupExtra extraType) {
/* 196 */     Integer value = (Integer)this.xGroup.getExtra().get(Integer.valueOf(extraType.ordinal()));
/* 197 */     if (value == null) {
/* 198 */       return 0;
/*     */     }
/* 200 */     return value.intValue();
/*     */   }
/*     */   
/*     */   protected final void setExtra(FightGroupExtra extraType, int value)
/*     */   {
/* 205 */     if (value == 0) {
/* 206 */       this.xGroup.getExtra().remove(Integer.valueOf(extraType.ordinal()));
/*     */     } else {
/* 208 */       this.xGroup.getExtra().put(Integer.valueOf(extraType.ordinal()), Integer.valueOf(value));
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean isCloneGroup() {
/* 213 */     int cloneType = getExtra(FightGroupExtra.Group_Clone);
/* 214 */     return cloneType == 1;
/*     */   }
/*     */   
/*     */   protected void setCloneGroup() {
/* 218 */     setExtra(FightGroupExtra.Group_Clone, 1);
/*     */   }
/*     */   
/*     */   protected Set<Fighter> getFighters() {
/* 222 */     return getSelectedFighters(null);
/*     */   }
/*     */   
/*     */   protected Set<Fighter> getExistedFighters() {
/* 226 */     return getSelectedFighters(new ExistedFighterSelector());
/*     */   }
/*     */   
/*     */   protected Set<Fighter> getAliveFighters() {
/* 230 */     return getSelectedFighters(new AliveFighterSelector());
/*     */   }
/*     */   
/*     */   protected Set<Fighter> getAliveRoleOrFellowFighters() {
/* 234 */     return getSelectedFighters(new AliveRoleOrFellowFighterSelector());
/*     */   }
/*     */   
/*     */   protected Set<Fighter> getOccupationFighters(int occupation) {
/* 238 */     Set<Fighter> occupationFighters = new HashSet();
/* 239 */     for (Fighter fighter : getExistedFighters()) {
/* 240 */       if (fighter.getOccupation() == occupation) {
/* 241 */         occupationFighters.add(fighter);
/*     */       }
/*     */     }
/* 244 */     return occupationFighters;
/*     */   }
/*     */   
/*     */   protected final Set<Fighter> getSelectedFighters(FighterSelector selector) {
/* 248 */     Set<Fighter> fighters = new HashSet();
/* 249 */     for (Map.Entry<Integer, xbean.Fighter> entry : this.xGroup.getMembers().entrySet()) {
/* 250 */       int fighterid = ((Integer)entry.getKey()).intValue();
/* 251 */       xbean.Fighter xFighter = (xbean.Fighter)entry.getValue();
/* 252 */       Fighter f = FightManager.getFighter(fighterid, xFighter, this);
/* 253 */       if (selector != null) {
/* 254 */         if (selector.isSelected(f)) {
/* 255 */           fighters.add(f);
/*     */         }
/*     */       } else {
/* 258 */         fighters.add(f);
/*     */       }
/*     */     }
/* 261 */     return fighters;
/*     */   }
/*     */   
/*     */   protected final Fighter getFighter(int fighterid) {
/* 265 */     if (this.xGroup.getMembers().containsKey(Integer.valueOf(fighterid))) {
/* 266 */       xbean.Fighter xFighter = (xbean.Fighter)this.xGroup.getMembers().get(Integer.valueOf(fighterid));
/* 267 */       return FightManager.getFighter(fighterid, xFighter, this);
/*     */     }
/* 269 */     return null;
/*     */   }
/*     */   
/*     */   protected final Fighter removeFighter(int fighterid) {
/* 273 */     if (this.xGroup.getMembers().containsKey(Integer.valueOf(fighterid))) {
/* 274 */       xbean.Fighter xFighter = (xbean.Fighter)this.xGroup.getMembers().remove(Integer.valueOf(fighterid));
/* 275 */       return FightManager.getFighter(fighterid, xFighter, this);
/*     */     }
/* 277 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onEnterFight()
/*     */   {
/* 284 */     for (Fighter fighter : getExistedFighters()) {
/* 285 */       fighter.onEnterFight();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onRoundBefore()
/*     */   {
/* 293 */     Set<Fighter> set = getExistedFighters();
/* 294 */     for (Fighter fighter : set) {
/* 295 */       fighter.onRoundBefore();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected final void onRoundPrapare2()
/*     */   {
/* 303 */     for (Fighter fighter : getExistedFighters())
/* 304 */       fighter.onRoundPrapare2();
/*     */   }
/*     */   
/*     */   protected final void onRoundPrapare1() {
/* 308 */     for (Fighter fighter : getExistedFighters()) {
/* 309 */       fighter.onRoundPrapare1();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onPlayBefore()
/*     */   {
/* 316 */     Set<Fighter> set = getExistedFighters();
/* 317 */     GroupAI ai = getGroupAI();
/* 318 */     if (ai != null) {
/* 319 */       ai.onRoundBegin(getFight(), set);
/*     */     }
/* 321 */     for (Fighter fighter : getExistedFighters()) {
/* 322 */       fighter.onPlayBefore();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onRoundEnd()
/*     */   {
/* 331 */     GroupAI ai = getGroupAI();
/* 332 */     if (ai != null) {
/* 333 */       ai.onRoundEnd(getFight(), getExistedFighters());
/*     */     }
/* 335 */     Set<Fighter> set = getFighters();
/* 336 */     int roleskillid = 0;
/* 337 */     int petSkillid = 0;
/* 338 */     long roleid = 0L;
/* 339 */     for (Fighter fighter : set) {
/* 340 */       if ((this instanceof FightGroupRole)) {
/* 341 */         if ((fighter instanceof FighterRole)) {
/* 342 */           FighterRole fighterRole = (FighterRole)fighter;
/* 343 */           roleskillid = fighterRole.getExtra(FighterExtra.ROUND_USE_SKILLID);
/* 344 */           roleid = fighterRole.getRoleid();
/* 345 */         } else if ((fighter instanceof FighterPet)) {
/* 346 */           FighterPet fighterPet = (FighterPet)fighter;
/* 347 */           petSkillid = fighterPet.getExtra(FighterExtra.ROUND_USE_SKILLID);
/*     */         }
/*     */       }
/* 350 */       fighter.onRoundEnd();
/* 351 */       fighter.remExtra(FighterExtra.ROUND_USE_SKILLID);
/*     */     }
/* 353 */     if ((roleskillid > 0) || (petSkillid > 0)) {
/* 354 */       int fightcfgid = this.fightTeam.fight.getFightCfgid();
/* 355 */       FightManager.logSkillUse(roleid, getFight().getFightReason(), getFight().getType(), getFight().fightid, fightcfgid, roleskillid, petSkillid);
/*     */       
/* 357 */       FightManager.tLogSkillUse(roleid, getFight().getFightReason(), getFight().getType(), getFight().fightid, fightcfgid, roleskillid, petSkillid);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onFighterDie(int fid)
/*     */   {
/* 363 */     Set<Fighter> set = getExistedFighters();
/* 364 */     GroupAI ai = getGroupAI();
/* 365 */     if (ai != null) {
/* 366 */       ai.onFighterDie(getFight(), set, fid);
/*     */     }
/* 368 */     for (Fighter fighter : set) {
/* 369 */       fighter.onTargetFighterDie(fid);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onFighterRelive(int fid) {
/* 374 */     Set<Fighter> set = getExistedFighters();
/* 375 */     GroupAI ai = getGroupAI();
/* 376 */     if (ai != null) {
/* 377 */       ai.onFighterRelive(getFight(), set, fid);
/*     */     }
/* 379 */     for (Fighter fighter : set) {
/* 380 */       fighter.onTargetFighterRelive(fid);
/*     */     }
/*     */   }
/*     */   
/*     */   protected GroupAI getGroupAI() {
/* 385 */     return this.xGroup.getGroupai();
/*     */   }
/*     */   
/*     */   protected void removeAI() {
/* 389 */     this.xGroup.setGroupai(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onFightEnd()
/*     */   {
/* 396 */     for (Fighter fighter : getFighters()) {
/* 397 */       fighter.onFightEnd();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final boolean hasSummonBackPet(long petUUid)
/*     */   {
/* 408 */     for (Fighter fighter : this.xGroup.getLeavefighters()) {
/* 409 */       if ((fighter.isPetType()) && 
/* 410 */         (fighter.getUuid() == petUUid)) {
/* 411 */         return true;
/*     */       }
/*     */     }
/* 414 */     return false;
/*     */   }
/*     */   
/*     */   protected final boolean hasSummonBackChild(long childUUid) {
/* 418 */     for (Fighter fighter : this.xGroup.getLeavefighters()) {
/* 419 */       if ((fighter.isChildType()) && 
/* 420 */         (fighter.getUuid() == childUUid)) {
/* 421 */         return true;
/*     */       }
/*     */     }
/* 424 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final void addLeaveFightFighter(Fighter fighter)
/*     */   {
/* 432 */     this.xGroup.getLeavefighters().add(fighter);
/*     */   }
/*     */   
/*     */   protected final List<Fighter> getLeaveFightFighters() {
/* 436 */     List<Fighter> retFighters = new ArrayList();
/* 437 */     retFighters.addAll(this.xGroup.getLeavefighters());
/* 438 */     return retFighters;
/*     */   }
/*     */   
/*     */   protected final int getType() {
/* 442 */     return this.xGroup.getType();
/*     */   }
/*     */   
/*     */   protected final mzm.gsp.fight.FightGroup getFightGroupBean() {
/* 446 */     mzm.gsp.fight.FightGroup fightGroupBean = new mzm.gsp.fight.FightGroup();
/* 447 */     fillFightGroupBean(fightGroupBean);
/* 448 */     return fightGroupBean;
/*     */   }
/*     */   
/*     */   protected void fillFightGroupBean(mzm.gsp.fight.FightGroup fightGroupBean) {
/* 452 */     fightGroupBean.group_type = getType();
/* 453 */     for (Fighter fighter : getFighters()) {
/* 454 */       mzm.gsp.fight.Fighter fighterBean = fighter.getFighterBean();
/* 455 */       fightGroupBean.fighters.put(Integer.valueOf(fighter.fighterid), fighterBean);
/*     */     }
/*     */   }
/*     */   
/*     */   protected final long getRoleid() {
/* 460 */     int roleidHigh = getExtra(FightGroupExtra.Roleid_High);
/* 461 */     int roleidLow = getExtra(FightGroupExtra.Roleid_Low);
/* 462 */     return CommonUtils.getLong(roleidHigh, roleidLow);
/*     */   }
/*     */   
/*     */   protected final void setRoleid(long roleid) {
/* 466 */     int roleidHigh = CommonUtils.getLongHigh(roleid);
/* 467 */     int roleidLow = CommonUtils.getLongLow(roleid);
/* 468 */     setExtra(FightGroupExtra.Roleid_High, roleidHigh);
/* 469 */     setExtra(FightGroupExtra.Roleid_Low, roleidLow);
/*     */   }
/*     */   
/*     */   protected void excuteOpItem(Fighter fighter, OpItem opItem, ExcuteCmdResult excuteCmdResult) {
/* 473 */     if ((fighter.isSeal()) && 
/* 474 */       (fighter.isSealUseDrag())) {
/* 475 */       GameServer.logger().error("被封印了使用药物!!!");
/* 476 */       return;
/*     */     }
/*     */     
/* 479 */     int itemcfgid = opItem.item_cfgid;
/*     */     
/* 481 */     SItemCfg itemCfg = SItemCfg.get(itemcfgid);
/* 482 */     if (itemCfg == null) {
/* 483 */       GameServer.logger().error("使用的药物不存在!!!");
/* 484 */       return;
/*     */     }
/* 486 */     if ((itemCfg.type != 5) && (itemCfg.type != 6) && (SItemTypeInFightCfg.get(itemCfg.type) == null))
/*     */     {
/* 488 */       GameServer.logger().error("使用的药品类型不是战斗内可用的,itemtype:" + itemCfg.type);
/* 489 */       return;
/*     */     }
/*     */     
/* 492 */     List<Integer> effeceGroupIds = new ArrayList();
/* 493 */     int pro = 1;
/* 494 */     int type1 = 0;
/* 495 */     int type2 = 0;
/* 496 */     int type3 = 0;
/* 497 */     int type4 = 0;
/*     */     
/* 499 */     if ((itemCfg.type == 5) || (SItemTypeInFightCfg.get(itemCfg.type) != null)) {
/* 500 */       SItemDrugInFightCfg itemDrugInFightCfg = SItemDrugInFightCfg.get(itemCfg.id);
/* 501 */       if (itemDrugInFightCfg == null) {
/* 502 */         GameServer.logger().error("使用的药品对应的药品配置不存在:cfgid:" + itemCfg.id);
/* 503 */         return;
/*     */       }
/* 505 */       effeceGroupIds.addAll(itemDrugInFightCfg.skillEffectGroupIds);
/* 506 */       pro = itemDrugInFightCfg.drugPro;
/* 507 */       type1 = itemDrugInFightCfg.targettype1;
/* 508 */       type2 = itemDrugInFightCfg.targettype2;
/* 509 */       type3 = itemDrugInFightCfg.targettype3;
/* 510 */       type4 = itemDrugInFightCfg.targettype4;
/* 511 */     } else if (itemCfg.type == 6) {
/* 512 */       SDrugItem drugItem = SDrugItem.get(itemCfg.id);
/* 513 */       if (drugItem == null) {
/* 514 */         GameServer.logger().error("使用的药品对应的药品配置不存在:cfgid:" + itemCfg.id);
/* 515 */         return;
/*     */       }
/* 517 */       effeceGroupIds.add(Integer.valueOf(drugItem.skillEffectGroupId));
/* 518 */       type1 = drugItem.targettype1;
/* 519 */       type2 = drugItem.targettype2;
/* 520 */       type3 = drugItem.targettype3;
/* 521 */       type4 = drugItem.targettype4;
/*     */     } else {
/* 523 */       GameServer.logger().info("使用的药品类型不是战斗内可用的,itemtype:" + itemCfg.type);
/* 524 */       return;
/*     */     }
/*     */     
/* 527 */     Set<Fighter> targets = FightUtil.getTargets(fighter, type1, type2, type3, type4);
/* 528 */     Fighter maintaFighter = this.fightTeam.fight.getFighter(opItem.main_target);
/*     */     
/*     */ 
/* 531 */     if (!targets.contains(maintaFighter)) {
/* 532 */       return;
/*     */     }
/* 534 */     Skill skill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, pro);
/* 535 */     if (skill == null) {
/* 536 */       return;
/*     */     }
/* 538 */     List<FighterEffectGroup> fighterEffectGroups = new ArrayList();
/*     */     
/* 540 */     for (Iterator i$ = effeceGroupIds.iterator(); i$.hasNext();) { int effeceGroupId = ((Integer)i$.next()).intValue();
/* 541 */       FighterEffectGroup fighterEffectGroup = EffectInterface.getEffectGroup(effeceGroupId);
/* 542 */       if (fighterEffectGroup == null) {
/* 543 */         GameServer.logger().error("没有找到效果组的配置!effectGroupid:" + effeceGroupId);
/* 544 */         return;
/*     */       }
/*     */       
/* 547 */       fighterEffectGroups.add(fighterEffectGroup);
/*     */     }
/*     */     
/* 550 */     for (FighterEffectGroup fighterEffectGroup : fighterEffectGroups) {
/* 551 */       fighterEffectGroup.setFromDrag();
/* 552 */       fighterEffectGroup.run(skill, fighter, maintaFighter, maintaFighter.getid());
/*     */     }
/*     */     
/* 555 */     int targetid = maintaFighter.getid();
/*     */     
/* 557 */     Skill.Attack attack = new Skill.Attack();
/* 558 */     attack.addNormalCount(1);
/* 559 */     List<Skill.Attack> attacks = new ArrayList();
/* 560 */     attacks.add(attack);
/* 561 */     int playTime = FightUtil.getPlayTime(fighter.getModelid(), SFightConsts.getInstance().DRAG_USE_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(maintaFighter.getid()) }), attacks);
/*     */     
/*     */ 
/* 564 */     AttackResult taAttackResult = skill.getAttackResult(targetid);
/* 565 */     FighterStatus targetStatus = new FighterStatus();
/* 566 */     maintaFighter.fillFighterStatus(targetStatus);
/*     */     
/* 568 */     for (AttackResultBean attackResultBean : taAttackResult.attackresultbeans) {
/* 569 */       targetStatus.angerchange += attackResultBean.targetstatus.angerchange;
/* 570 */       targetStatus.hpchange += attackResultBean.targetstatus.hpchange;
/* 571 */       targetStatus.mpchange += attackResultBean.targetstatus.mpchange;
/*     */     }
/* 573 */     HashMap<Integer, FighterStatus> targetstatusMap = new HashMap();
/* 574 */     targetstatusMap.put(Integer.valueOf(targetid), targetStatus);
/*     */     
/* 576 */     DrugHandle.OutputObj outputObj = fighter.handleOnAfterDrug(new DrugHandle.InputObj(fighter, maintaFighter, targetStatus.hpchange));
/*     */     
/* 578 */     FighterStatus releaserStatus = new FighterStatus();
/* 579 */     releaserStatus.triggerpassiveskills.addAll(outputObj.passiveSkills);
/* 580 */     if (outputObj.drugSelfValue > 0) {
/* 581 */       fighter.addHp(outputObj.drugSelfValue);
/* 582 */       releaserStatus.hpchange += outputObj.drugSelfValue;
/*     */     }
/* 584 */     fighter.fillFighterStatus(releaserStatus);
/*     */     
/* 586 */     PlayUseItem playUseItem = new PlayUseItem();
/* 587 */     fighter.fillPlayUseItemResult(playUseItem, fighter.getid(), releaserStatus, itemCfg.id, targetstatusMap);
/*     */     
/* 589 */     boolean recordEnable = isRecordEnable();
/* 590 */     if (this.fightTeam.fight.canSeeOppsiteHpProp()) {
/* 591 */       Play play = new Play();
/* 592 */       play.play_type = 6;
/* 593 */       play.content = playUseItem.marshal(new OctetsStream());
/* 594 */       excuteCmdResult.addPlay(play, true);
/* 595 */       excuteCmdResult.addPlay(play, false);
/* 596 */       if (recordEnable) {
/* 597 */         excuteCmdResult.addPlay(play);
/*     */       }
/*     */     } else {
/* 600 */       Play activePlay = new Play();
/* 601 */       activePlay.play_type = 6;
/* 602 */       Pair<PlayUseItem, Boolean> activePlayUseItemPair = fighter.getOppisiteUseItemResult(playUseItem, true);
/*     */       
/* 604 */       PlayUseItem activePlayUseItem = (PlayUseItem)activePlayUseItemPair.first;
/* 605 */       activePlay.content = activePlayUseItem.marshal(new OctetsStream());
/* 606 */       excuteCmdResult.addPlay(activePlay, true);
/* 607 */       if ((!((Boolean)activePlayUseItemPair.second).booleanValue()) && 
/* 608 */         (recordEnable)) {
/* 609 */         excuteCmdResult.addPlay(activePlay);
/*     */       }
/*     */       
/*     */ 
/* 613 */       Play passivePlay = new Play();
/* 614 */       passivePlay.play_type = 6;
/* 615 */       Pair<PlayUseItem, Boolean> passivePlayUseItemPair = fighter.getOppisiteUseItemResult(playUseItem, false);
/*     */       
/* 617 */       PlayUseItem passivePlayUseItem = (PlayUseItem)passivePlayUseItemPair.first;
/* 618 */       passivePlay.content = passivePlayUseItem.marshal(new OctetsStream());
/* 619 */       excuteCmdResult.addPlay(passivePlay, false);
/* 620 */       if ((!((Boolean)passivePlayUseItemPair.second).booleanValue()) && 
/* 621 */         (recordEnable)) {
/* 622 */         excuteCmdResult.addPlay(passivePlay);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 627 */     excuteCmdResult.addPlayTime(playTime);
/*     */     
/* 629 */     fighter.addActionCount();
/*     */     
/*     */ 
/* 632 */     fighter.addUseItemCount();
/*     */   }
/*     */   
/*     */   void addDamageToFighter(Fighter targetFighter, int damage) {
/* 636 */     if ((this.fightTeam.isActive ^ targetFighter.fightGroup.fightTeam.isActive)) {
/* 637 */       int oriDamage = getExtra(FightGroupExtra.Group_Damage);
/* 638 */       setExtra(FightGroupExtra.Group_Damage, damage + oriDamage);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void changeFighter(Fighter fighter, int monsterid, int level, ExcuteCmdResult excuteCmdResult, int hprate)
/*     */   {
/* 644 */     Monster monster = MonsterInterface.getMonster(monsterid, level);
/* 645 */     if (monster == null) {
/* 646 */       GameServer.logger().error("AI替换不存在的怪物!!monsterid:" + monsterid);
/* 647 */       return;
/*     */     }
/*     */     
/*     */ 
/* 651 */     fighter.setEscape();
/* 652 */     fighter.onFightEnd();
/* 653 */     if (hprate <= 0) {
/* 654 */       hprate = (int)fighter.getCurHpRateValue();
/*     */     }
/* 656 */     FighterMonster fighterMonster = generateFighterMonster();
/* 657 */     fighterMonster.init(monster, fighter.getPos(), hprate);
/* 658 */     fighterMonster.onEnterFight();
/*     */     
/* 660 */     Play play = new Play();
/* 661 */     play.play_type = 9;
/* 662 */     PlayChangeFighter playChangeFighter = new PlayChangeFighter();
/* 663 */     playChangeFighter.changefighterid = fighterMonster.fighterid;
/* 664 */     playChangeFighter.fighterid = fighter.fighterid;
/* 665 */     fighterMonster.fillFighterBean(playChangeFighter.fighter);
/* 666 */     play.content = playChangeFighter.marshal(new OctetsStream());
/* 667 */     boolean isActive = fighterMonster.fightGroup.fightTeam.isActive;
/* 668 */     excuteCmdResult.addPlay(play, isActive);
/*     */     
/* 670 */     if (this.fightTeam.fight.canSeeOppsiteHpProp()) {
/* 671 */       excuteCmdResult.addPlay(play, !isActive);
/*     */     } else {
/* 673 */       PlayChangeFighter copyChangeFighter = fighter.getOppisiteChangeFighter(playChangeFighter);
/* 674 */       Play copyChangeFighterPlay = new Play();
/* 675 */       copyChangeFighterPlay.play_type = 9;
/* 676 */       copyChangeFighterPlay.content = copyChangeFighter.marshal(new OctetsStream());
/* 677 */       excuteCmdResult.addPlay(play, !isActive);
/*     */     }
/*     */     
/* 680 */     if (isRecordEnable()) {
/* 681 */       excuteCmdResult.addPlay(play);
/*     */     }
/*     */     
/* 684 */     fighter.addActionCount();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */