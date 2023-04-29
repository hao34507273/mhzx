/*     */ package mzm.gsp.fight.ai.util;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.main.FightInfo;
/*     */ import mzm.gsp.fight.main.FighterAIOperator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FighterAI
/*     */   extends AbstractAI
/*     */ {
/*  16 */   private int selffid = -1;
/*     */   
/*     */ 
/*     */ 
/*     */   public void init(FightInfo fightInfo, int selffid)
/*     */   {
/*  22 */     init(fightInfo);
/*  23 */     this.selffid = selffid;
/*     */   }
/*     */   
/*     */   public List<FighterAIOperator> getAiOperators() {
/*  27 */     return this.m_operators;
/*     */   }
/*     */   
/*     */   public int getSelfFid() {
/*  31 */     return this.selffid;
/*     */   }
/*     */   
/*     */   public int getMonsterid() {
/*  35 */     return super.getMonsterid(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getEnemies() {
/*  39 */     return super.getEnemies(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getFriends() {
/*  43 */     return super.getFriends(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getAliveEnemies() {
/*  47 */     return super.getAliveEnemies(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getAliveFriends() {
/*  51 */     return super.getAliveFriends(this.selffid);
/*     */   }
/*     */   
/*     */   public int randAliveEnemies() {
/*  55 */     return super.randAliveEnemies(this.selffid);
/*     */   }
/*     */   
/*     */   public int randAliveFriends() {
/*  59 */     return super.randAliveFriends(this.selffid);
/*     */   }
/*     */   
/*     */   public int getEnemyHpRemainMin() {
/*  63 */     return super.getEnemyHpRemainMin(this.selffid);
/*     */   }
/*     */   
/*     */   public int getEnemyHpRemainMax() {
/*  67 */     return super.getEnemyHpRemainMax(this.selffid);
/*     */   }
/*     */   
/*     */   public int getAnger() {
/*  71 */     return super.getAnger(this.selffid);
/*     */   }
/*     */   
/*     */   public int getHp() {
/*  75 */     return super.getTargetHp(this.selffid);
/*     */   }
/*     */   
/*     */   public int getHpRate() {
/*  79 */     return super.getTargetHpRate(this.selffid);
/*     */   }
/*     */   
/*     */   public int getMp() {
/*  83 */     return super.getTargetMp(this.selffid);
/*     */   }
/*     */   
/*     */   public int getEnergy() {
/*  87 */     return super.getEnergy(this.selffid);
/*     */   }
/*     */   
/*     */   public int getSpeed() {
/*  91 */     return super.getSpeed(this.selffid);
/*     */   }
/*     */   
/*     */   public int getMpRate() {
/*  95 */     return super.getTargetMpRate(this.selffid);
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  99 */     return super.getLevel(this.selffid);
/*     */   }
/*     */   
/*     */   public int getSkillLv(int skillid) {
/* 103 */     return super.getSkillLv(this.selffid, skillid);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 107 */     return super.getName(this.selffid);
/*     */   }
/*     */   
/*     */   public int getPosition() {
/* 111 */     return super.getPosition(this.selffid);
/*     */   }
/*     */   
/*     */   public int getGender() {
/* 115 */     return super.getGender(this.selffid);
/*     */   }
/*     */   
/*     */   public int getFriendHpGreater(int order) {
/* 119 */     return super.getFriendHpGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getFriendHpRateGreater(int order) {
/* 123 */     return super.getFriendHpGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getFriendMpGreater(int order) {
/* 127 */     return super.getFriendMpGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getFriendMpRateGreater(int order) {
/* 131 */     return super.getFriendMpRateGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getEnemyHpGreater(int order) {
/* 135 */     return super.getEnemyHpGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getEnemyHpMin(int order) {
/* 139 */     return super.getEnemyHpMin(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getEnemyHpRateGreater(int order) {
/* 143 */     return super.getEnemyHpRateGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getEnemyMpGreater(int order) {
/* 147 */     return super.getEnemyMpGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getEnemyMpRateGreater(int order) {
/* 151 */     return super.getEnemyMpRateGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getFriendSpeedGreater(int order) {
/* 155 */     return super.getFriendSpeedGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   public int getEnemySpeedGreater(int order) {
/* 159 */     return super.getEnemySpeedGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getFriendPhyAtkGreater(int order) {
/* 163 */     return super.getFriendPhyAtkGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getEnemyPhyAtkGreater(int order) {
/* 167 */     return super.getEnemyPhyAtkGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getFriendPhyDefGreater(int order) {
/* 171 */     return super.getFriendPhyDefGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getEnemyPhyDefGreater(int order) {
/* 175 */     return super.getEnemyPhyDefGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getFriendMGCAtkGreater(int order) {
/* 179 */     return super.getFriendMGCAtkGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getEnemyMGCAtkGreater(int order) {
/* 183 */     return super.getEnemyMGCAtkGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getFriendMGCDefGreater(int order) {
/* 187 */     return super.getFriendMGCDefGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected int getEnemyMGCDefGreater(int order) {
/* 191 */     return super.getEnemyMGCDefGreater(this.selffid, order);
/*     */   }
/*     */   
/*     */   protected List<Integer> getFriendSpeedOrders() {
/* 195 */     return super.getFriendSpeedOrders(this.selffid);
/*     */   }
/*     */   
/*     */   public int getFriendByPosition(int position) {
/* 199 */     return super.getFriendByPosition(this.selffid, position);
/*     */   }
/*     */   
/*     */   public int getEnermyByPosition(int position) {
/* 203 */     return super.getEnermyByPosition(this.selffid, position);
/*     */   }
/*     */   
/*     */   public int getFriendNum() {
/* 207 */     return super.getFriends(this.selffid).size();
/*     */   }
/*     */   
/*     */   public int getFriendAliveNum() {
/* 211 */     return super.getAliveFriends(this.selffid).size();
/*     */   }
/*     */   
/*     */   public int getEnemiesNum() {
/* 215 */     return super.getEnemies(this.selffid).size();
/*     */   }
/*     */   
/*     */   public int getEnemiesAliveNum() {
/* 219 */     return super.getAliveEnemies(this.selffid).size();
/*     */   }
/*     */   
/*     */   public void useNromalAttack(int tfid) {
/* 223 */     super.useNromalAttack(this.selffid, tfid);
/*     */   }
/*     */   
/*     */   public void useSkill(int skillid, int skillLV, int tfid) {
/* 227 */     super.useSkill(this.selffid, skillid, skillLV, tfid);
/*     */   }
/*     */   
/*     */   public void useSkill(int skillid, int tfid) {
/* 231 */     super.useSkill(this.selffid, skillid, getSkillLv(skillid), tfid);
/*     */   }
/*     */   
/*     */   public boolean canUseSkill(int skillid, int skillLV) {
/* 235 */     return super.canFighterUseSkill(this.selffid, skillid, skillLV);
/*     */   }
/*     */   
/*     */   public void useSkill(int skillid) {
/* 239 */     super.useSkill(this.selffid, skillid, -1);
/*     */   }
/*     */   
/*     */   public boolean canUseSkill(int skillid) {
/* 243 */     return super.canFighterUseSkill(this.selffid, skillid);
/*     */   }
/*     */   
/*     */   public List<Integer> getSkillTarget(int skillid, int skillLv) {
/* 247 */     return super.getSkillTarget(this.selffid, skillid, skillLv);
/*     */   }
/*     */   
/*     */   public Set<Integer> getCanUseSkillSet() {
/* 251 */     return super.getCanUseSkillSet(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getSkillSet() {
/* 255 */     return super.getSkillSet(this.selffid);
/*     */   }
/*     */   
/*     */   public Integer convertSkill(int skillid) {
/* 259 */     return super.convertSkill(this.selffid, skillid);
/*     */   }
/*     */   
/*     */   public void defense() {
/* 263 */     super.defense(this.selffid);
/*     */   }
/*     */   
/*     */   public void protect(int tfid) {
/* 267 */     super.protect(this.selffid, tfid);
/*     */   }
/*     */   
/*     */   public void escape() {
/* 271 */     super.escape(this.selffid);
/*     */   }
/*     */   
/*     */   public void escapeSuccess() {
/* 275 */     super.escapeSuccess(this.selffid);
/*     */   }
/*     */   
/*     */   public void escapeImmediately() {
/* 279 */     super.escapeImmediately(this.selffid);
/*     */   }
/*     */   
/*     */   public void useItem(int itemcfgid, int tfid) {
/* 283 */     super.useItem(this.selffid, itemcfgid, tfid);
/*     */   }
/*     */   
/*     */   public void summonFriendMonster(int level, int... monsterids) {
/* 287 */     super.summonFriendMonster(this.selffid, level, monsterids);
/*     */   }
/*     */   
/*     */   public void summonFriendMonsterImmediately(int level, int... monsterids) {
/* 291 */     super.summonFriendMonsterImmediately(this.selffid, level, monsterids);
/*     */   }
/*     */   
/*     */   public void summonFriendMonsterFixPos(int level, int monsterid, int position) {
/* 295 */     super.summonFriendMonsterFixPos(this.selffid, level, monsterid, position);
/*     */   }
/*     */   
/*     */   public void summonFriendMonsterFixPos(int level, Map<Integer, List<Integer>> monsteridToPositionMap) {
/* 299 */     super.summonFriendMonsterFixPos(this.selffid, level, monsteridToPositionMap);
/*     */   }
/*     */   
/*     */   public void summonFriendMonsterFixPosImmediately(int level, int monsterid, int position) {
/* 303 */     super.summonFriendMonsterFixPosImmediately(this.selffid, level, monsterid, position);
/*     */   }
/*     */   
/*     */   public void summonFriendMonsterFixPosImmediately(int level, Map<Integer, List<Integer>> monsteridToPositionMap) {
/* 307 */     super.summonFriendMonsterFixPosImmediately(this.selffid, level, monsteridToPositionMap);
/*     */   }
/*     */   
/*     */   public void summonEnernyMonster(int level, int... monsterids) {
/* 311 */     super.summonEnernyMonster(this.selffid, level, monsterids);
/*     */   }
/*     */   
/*     */   public void summonEnernyMonsterFixPos(int level, int monsterid, int pos) {
/* 315 */     super.summonEnernyMonsterFixPos(this.selffid, level, monsterid, pos);
/*     */   }
/*     */   
/*     */   public void summonEnernyMonsterFixPos(int level, Map<Integer, List<Integer>> monsteridToPosMap) {
/* 319 */     super.summonEnernyMonsterFixPos(this.selffid, level, monsteridToPosMap);
/*     */   }
/*     */   
/*     */   public void summonEnernyMonsterImmediately(int level, int... monsterids) {
/* 323 */     super.summonEnernyMonsterImmediately(this.selffid, level, monsterids);
/*     */   }
/*     */   
/*     */   public void summonEnermyMonsterFixPosImmediately(int level, int monsterid, int pos) {
/* 327 */     super.summonEnermyMonsterFixPosImmediately(this.selffid, level, monsterid, pos);
/*     */   }
/*     */   
/*     */   public void summonEnermyMonsterFixPosImmediately(int level, Map<Integer, List<Integer>> monsteridToPosMap) {
/* 331 */     super.summonEnermyMonsterFixPosImmediately(this.selffid, level, monsteridToPosMap);
/*     */   }
/*     */   
/*     */   public void summonPet(long petUuid) {
/* 335 */     FighterAIOperator operator = this.fightInfo.summonPet(this.selffid, petUuid);
/* 336 */     this.m_operators.add(operator);
/*     */   }
/*     */   
/*     */   public void summonChild(long childUuid) {
/* 340 */     FighterAIOperator operator = this.fightInfo.summonChild(this.selffid, childUuid);
/* 341 */     this.m_operators.add(operator);
/*     */   }
/*     */   
/*     */   public boolean canSummon() {
/* 345 */     return this.fightInfo.canSummon(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean canSummonChild() {
/* 349 */     return this.fightInfo.canSummonChild(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Long> getCanSummonPet() {
/* 353 */     return this.fightInfo.getCanSummonPets(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Long> getCanSummonChildren() {
/* 357 */     return this.fightInfo.getCanSummonChildren(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean carryPet() {
/* 361 */     return this.fightInfo.carryPet(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean carryChild() {
/* 365 */     return this.fightInfo.carryChild(this.selffid);
/*     */   }
/*     */   
/*     */   public int getPetLevel(long petid) {
/* 369 */     return this.fightInfo.getPetLevel(petid, this.selffid);
/*     */   }
/*     */   
/*     */   public void defaultOperator() {
/* 373 */     super.defaultOperator(this.selffid);
/*     */   }
/*     */   
/*     */   public void defaultOperator(Set<Integer> skillids) {
/* 377 */     super.defaultOperator(this.selffid, skillids);
/*     */   }
/*     */   
/*     */   public void defaultOperator(Set<Integer> skillids, int tfid) {
/* 381 */     super.defaultOperator(this.selffid, skillids, tfid);
/*     */   }
/*     */   
/*     */   public void addBuff(int effectGroupid) {
/* 385 */     FighterAIOperator operator = this.fightInfo.addBuff(this.selffid, effectGroupid);
/* 386 */     this.m_operators.add(operator);
/*     */   }
/*     */   
/*     */   public void addBuffImmediately(int effectGroupid) {
/* 390 */     this.fightInfo.addBuffImmediately(this.selffid, effectGroupid);
/*     */   }
/*     */   
/*     */   public void remBuff(int effectGroupid) {
/* 394 */     FighterAIOperator operator = this.fightInfo.remBuff(this.selffid, effectGroupid);
/* 395 */     this.m_operators.add(operator);
/*     */   }
/*     */   
/*     */   public void remBuffImmediately(int effectGroupid) {
/* 399 */     this.fightInfo.remBuffImmediately(this.selffid, effectGroupid);
/*     */   }
/*     */   
/*     */   public boolean enermyHasOutFightBuff(int outFightBuffid) {
/* 403 */     return this.fightInfo.enermyHasOutFightBuff(this.selffid, outFightBuffid);
/*     */   }
/*     */   
/*     */   public void changeFighter(int monsterid, int level) {
/* 407 */     changeFighter(monsterid, level, 0);
/*     */   }
/*     */   
/*     */   public void changeFighter(int monsterid, int level, int hpRate) {
/* 411 */     FighterAIOperator operator = this.fightInfo.changeFighter(this.selffid, monsterid, level, hpRate);
/* 412 */     this.m_operators.add(operator);
/*     */   }
/*     */   
/*     */   public void changeFighterImmediately(int monsterid, int level) {
/* 416 */     changeFighterImmediately(monsterid, level, 0);
/*     */   }
/*     */   
/*     */   public void changeFighterImmediately(int monsterid, int level, int hpRate) {
/* 420 */     this.fightInfo.changeFighterImmediately(this.selffid, monsterid, level, hpRate);
/*     */   }
/*     */   
/*     */   public void changeFighterModel(int monsterid) {
/* 424 */     FighterAIOperator operator = this.fightInfo.changeFighterModel(this.selffid, monsterid);
/* 425 */     this.m_operators.add(operator);
/*     */   }
/*     */   
/*     */   public void changeFighterModelImmediately(int monsterid) {
/* 429 */     this.fightInfo.changeFighterModelImmediately(this.selffid, monsterid);
/*     */   }
/*     */   
/*     */   public void say(int strid, String... args) {
/* 433 */     super.say(this.selffid, strid, args);
/*     */   }
/*     */   
/*     */   public void sayImmediately(int strid, String... args) {
/* 437 */     super.sayImmediately(this.selffid, strid, args);
/*     */   }
/*     */   
/*     */   public boolean hasBuffState(int state) {
/* 441 */     return super.hasBuffState(this.selffid, state);
/*     */   }
/*     */   
/*     */   public boolean isSealed() {
/* 445 */     return super.isSealed(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean isNegetive() {
/* 449 */     return super.isNegetive(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean isPositive() {
/* 453 */     return super.isPositive(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean isPoison() {
/* 457 */     return super.isPoison(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean isInVisiable() {
/* 461 */     return super.isInvisiable(this.selffid);
/*     */   }
/*     */   
/*     */   public boolean isVisiable() {
/* 465 */     return super.isVisiable(this.selffid);
/*     */   }
/*     */   
/*     */   public void setTeamVariable1(int variable1) {
/* 469 */     super.setTeamVariable1(this.selffid, variable1);
/*     */   }
/*     */   
/*     */   public int getTeamVariable1() {
/* 473 */     return super.getTeamVariable1(this.selffid);
/*     */   }
/*     */   
/*     */   public void setTeamVariable2(int variable2) {
/* 477 */     super.setTeamVariable2(this.selffid, variable2);
/*     */   }
/*     */   
/*     */   public int getTeamVariable2() {
/* 481 */     return super.getTeamVariable2(this.selffid);
/*     */   }
/*     */   
/*     */   public void setTeamVariable3(int variable3) {
/* 485 */     super.setTeamVariable3(this.selffid, variable3);
/*     */   }
/*     */   
/*     */   public int getTeamVariable3() {
/* 489 */     return super.getTeamVariable3(this.selffid);
/*     */   }
/*     */   
/*     */   public void setTeamVariable4(int variable4) {
/* 493 */     super.setTeamVariable4(this.selffid, variable4);
/*     */   }
/*     */   
/*     */   public int getTeamVariable4() {
/* 497 */     return super.getTeamVariable4(this.selffid);
/*     */   }
/*     */   
/*     */   public void setTeamVariable5(int variable5) {
/* 501 */     super.setTeamVariable5(this.selffid, variable5);
/*     */   }
/*     */   
/*     */   public int getTeamVariable5() {
/* 505 */     return super.getTeamVariable5(this.selffid);
/*     */   }
/*     */   
/*     */   public void setTeamVariable6(int variable6) {
/* 509 */     super.setTeamVariable6(this.selffid, variable6);
/*     */   }
/*     */   
/*     */   public int getTeamVariable6() {
/* 513 */     return super.getTeamVariable6(this.selffid);
/*     */   }
/*     */   
/*     */   protected AbstractAI.OperatorInfo getOperatorInfo() {
/* 517 */     return super.getOperatorInfo(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getFriendAiOperateFighters() {
/* 521 */     return super.getFriendAiOperateFighters(this.selffid);
/*     */   }
/*     */   
/*     */   public Set<Integer> getEnermySealedFighters() {
/* 525 */     return super.getEnermySealedFighters(this.selffid);
/*     */   }
/*     */   
/*     */   public List<Integer> getAiOperateFriendOrderSpeed(boolean fakeDeadIncluded) {
/* 529 */     return super.getAiOperateFriendOrderSpeed(this.selffid, fakeDeadIncluded);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\ai\util\FighterAI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */