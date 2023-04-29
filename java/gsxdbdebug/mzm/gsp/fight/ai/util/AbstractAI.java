/*      */ package mzm.gsp.fight.ai.util;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.fight.main.FightInfo;
/*      */ import mzm.gsp.fight.main.FighterAIOperator;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import xdb.Xdb;
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class AbstractAI
/*      */   implements AI
/*      */ {
/*      */   protected FightInfo fightInfo;
/*   22 */   List<FighterAIOperator> m_operators = new ArrayList(1);
/*      */   
/*      */ 
/*      */ 
/*      */   protected void init(FightInfo var1)
/*      */   {
/*   28 */     this.fightInfo = var1;
/*      */   }
/*      */   
/*      */   protected int getRound() {
/*   32 */     return this.fightInfo.getRound();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getEnemies(int var1) {
/*   36 */     return this.fightInfo.getEnemies(var1);
/*      */   }
/*      */   
/*      */   protected Set<Integer> getFriends(int var1) {
/*   40 */     return this.fightInfo.getFriends(var1);
/*      */   }
/*      */   
/*      */   protected Set<Integer> getAliveEnemies(int var1) {
/*   44 */     return this.fightInfo.getAliveEnemies(var1);
/*      */   }
/*      */   
/*      */   protected Set<Integer> getAliveFriends(int var1) {
/*   48 */     return this.fightInfo.getAliveFriends(var1);
/*      */   }
/*      */   
/*      */   protected int randAliveEnemies(int var1) {
/*   52 */     return this.fightInfo.randAliveEnemies(var1);
/*      */   }
/*      */   
/*      */   protected int randAliveFriends(int var1) {
/*   56 */     return this.fightInfo.randAliveFriends(var1);
/*      */   }
/*      */   
/*      */   protected int getEnemyHpRemainMin(int var1) {
/*   60 */     return this.fightInfo.getEnemyHpRemainMin(var1);
/*      */   }
/*      */   
/*      */   protected int getEnemyHpRemainMax(int var1) {
/*   64 */     return this.fightInfo.getEnemyHpRemainMax(var1);
/*      */   }
/*      */   
/*      */   protected int getTargetHp(int var1) {
/*   68 */     return this.fightInfo.getTargetHp(var1);
/*      */   }
/*      */   
/*      */   protected int getTargetMp(int var1) {
/*   72 */     return this.fightInfo.getTargetMp(var1);
/*      */   }
/*      */   
/*      */   protected int getEnergy(int var1) {
/*   76 */     return this.fightInfo.getEnergy(var1);
/*      */   }
/*      */   
/*      */   protected int getSpeed(int var1) {
/*   80 */     return this.fightInfo.getSpeed(var1);
/*      */   }
/*      */   
/*      */   protected int getTargetHpRate(int var1) {
/*   84 */     return this.fightInfo.getTargetHpRate(var1);
/*      */   }
/*      */   
/*      */   protected int getTargetMpRate(int var1) {
/*   88 */     return this.fightInfo.getTargetMpRate(var1);
/*      */   }
/*      */   
/*      */   protected int getAnger(int var1) {
/*   92 */     return this.fightInfo.getAnger(var1);
/*      */   }
/*      */   
/*      */   protected boolean isDead(int var1) {
/*   96 */     return this.fightInfo.isDead(var1);
/*      */   }
/*      */   
/*      */   protected boolean isRealDead(int var1) {
/*  100 */     return this.fightInfo.isRealDead(var1);
/*      */   }
/*      */   
/*      */   protected boolean isFakeDead(int var1) {
/*  104 */     return this.fightInfo.isFakeDead(var1);
/*      */   }
/*      */   
/*      */   protected boolean hasBuffState(int var1, int var2) {
/*  108 */     return this.fightInfo.hasBuffState(var1, var2);
/*      */   }
/*      */   
/*      */   protected boolean isInvisiable(int var1) {
/*  112 */     return this.fightInfo.isInvisiable(var1);
/*      */   }
/*      */   
/*      */   protected boolean isVisiable(int var1) {
/*  116 */     return this.fightInfo.isVisiable(var1);
/*      */   }
/*      */   
/*      */   protected boolean isStone(int var1) {
/*  120 */     return this.fightInfo.isStone(var1);
/*      */   }
/*      */   
/*      */   protected boolean isNotBeHealed(int var1) {
/*  124 */     return this.fightInfo.isNotBeHealed(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSleep(int var1) {
/*  128 */     return this.fightInfo.isSleep(var1);
/*      */   }
/*      */   
/*      */   protected boolean isRest(int var1) {
/*  132 */     return this.fightInfo.isRest(var1);
/*      */   }
/*      */   
/*      */   protected boolean isWeak(int var1) {
/*  136 */     return this.fightInfo.isWeak(var1);
/*      */   }
/*      */   
/*      */   protected boolean isMess(int var1) {
/*  140 */     return this.fightInfo.isMess(var1);
/*      */   }
/*      */   
/*      */   protected boolean isFear(int var1) {
/*  144 */     return this.fightInfo.isFear(var1);
/*      */   }
/*      */   
/*      */   protected boolean isGhost(int var1) {
/*  148 */     return this.fightInfo.isGhost(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSealPhy(int var1) {
/*  152 */     return this.fightInfo.isSealPhy(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSealMgc(int var1) {
/*  156 */     return this.fightInfo.isSealMgc(var1);
/*      */   }
/*      */   
/*      */   protected final boolean isSealSpecial(int var1) {
/*  160 */     return this.fightInfo.isSealSpecial(var1);
/*      */   }
/*      */   
/*      */   protected final boolean isSealNormal(int var1) {
/*  164 */     return this.fightInfo.isSealNormal(var1);
/*      */   }
/*      */   
/*      */   protected final boolean isSealDefence(int var1) {
/*  168 */     return this.fightInfo.isSealDefence(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSealEscape(int var1) {
/*  172 */     return this.fightInfo.isSealEscape(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSealProtect(int var1) {
/*  176 */     return this.fightInfo.isSealProtect(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSealSummon(int var1) {
/*  180 */     return this.fightInfo.isSealSummon(var1);
/*      */   }
/*      */   
/*      */   protected boolean isSealed(int var1) {
/*  184 */     return this.fightInfo.isSealed(var1);
/*      */   }
/*      */   
/*      */   protected boolean isNegetive(int var1) {
/*  188 */     return this.fightInfo.isNegetive(var1);
/*      */   }
/*      */   
/*      */   protected boolean isPositive(int var1) {
/*  192 */     return this.fightInfo.isPositive(var1);
/*      */   }
/*      */   
/*      */   protected boolean isPoison(int var1) {
/*  196 */     return this.fightInfo.isPoison(var1);
/*      */   }
/*      */   
/*      */   protected boolean canSummon(int var1) {
/*  200 */     return this.fightInfo.canSummon(var1);
/*      */   }
/*      */   
/*      */   protected int getFriendHpGreater(int var1, int var2) {
/*  204 */     return this.fightInfo.getFriendHpGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendHpRateGreater(int var1, int var2) {
/*  208 */     return this.fightInfo.getFriendHpGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendMpGreater(int var1, int var2) {
/*  212 */     return this.fightInfo.getFriendMpGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendMpRateGreater(int var1, int var2) {
/*  216 */     return this.fightInfo.getFriendMpRateGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyHpGreater(int var1, int var2) {
/*  220 */     return this.fightInfo.getEnemyHpGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyHpMin(int var1, int var2) {
/*  224 */     return this.fightInfo.getEnemyHpMin(var1, var2);
/*      */   }
/*      */   
/*  227 */   protected int getEnemyHpRateGreater(int var1, int var2) { return this.fightInfo.getEnemyHpRateGreater(var1, var2); }
/*      */   
/*      */   protected int getEnemyMpGreater(int var1, int var2)
/*      */   {
/*  231 */     return this.fightInfo.getEnemyMpGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyMpRateGreater(int var1, int var2) {
/*  235 */     return this.fightInfo.getEnemyMpRateGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendSpeedGreater(int var1, int var2) {
/*  239 */     return this.fightInfo.getFriendSpeedGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemySpeedGreater(int var1, int var2) {
/*  243 */     return this.fightInfo.getEnemySpeedGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendPhyAtkGreater(int var1, int var2) {
/*  247 */     return this.fightInfo.getFriendPhyAtkGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyPhyAtkGreater(int var1, int var2) {
/*  251 */     return this.fightInfo.getEnermyPhyAtkGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendPhyDefGreater(int var1, int var2) {
/*  255 */     return this.fightInfo.getFriendPhyDefGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyPhyDefGreater(int var1, int var2) {
/*  259 */     return this.fightInfo.getEnermyPhyDefGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendMGCAtkGreater(int var1, int var2) {
/*  263 */     return this.fightInfo.getFriendMGCAtkGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyMGCAtkGreater(int var1, int var2) {
/*  267 */     return this.fightInfo.getEnermyMGCAtkGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendMGCDefGreater(int var1, int var2) {
/*  271 */     return this.fightInfo.getFriendMGCDefGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getEnemyMGCDefGreater(int var1, int var2) {
/*  275 */     return this.fightInfo.getEnermyMGCDefGreater(var1, var2);
/*      */   }
/*      */   
/*      */   protected List<Integer> getFriendSpeedOrders(int var1) {
/*  279 */     return this.fightInfo.getFriendSpeedOrders(var1);
/*      */   }
/*      */   
/*      */   public int getFriendByPosition(int var1, int var2) {
/*  283 */     return this.fightInfo.getFriendByPosition(var1, var2);
/*      */   }
/*      */   
/*      */   public int getEnermyByPosition(int var1, int var2) {
/*  287 */     return this.fightInfo.getEnermyByPosition(var1, var2);
/*      */   }
/*      */   
/*      */   protected int getFriendNum(int var1) {
/*  291 */     return this.fightInfo.getFriends(var1).size();
/*      */   }
/*      */   
/*      */   protected int getFriendAliveNum(int var1) {
/*  295 */     return this.fightInfo.getAliveFriends(var1).size();
/*      */   }
/*      */   
/*      */   protected int getEnemiesNum(int var1) {
/*  299 */     return this.fightInfo.getEnemies(var1).size();
/*      */   }
/*      */   
/*      */   protected int getEnemiesAliveNum(int var1) {
/*  303 */     return this.fightInfo.getAliveEnemies(var1).size();
/*      */   }
/*      */   
/*      */   void useNromalAttack(int var1, int var2) {
/*  307 */     FighterAIOperator var3 = this.fightInfo.useNromalSkill(var1, var2);
/*  308 */     this.m_operators.add(var3);
/*      */   }
/*      */   
/*      */   void useSkill(int var1, int var2, int var3, int var4) {
/*  312 */     FighterAIOperator var5 = this.fightInfo.useSkill(var1, var2, var3, var4);
/*  313 */     this.m_operators.add(var5);
/*      */   }
/*      */   
/*      */   protected boolean canFighterUseSkill(int var1, int var2, int var3) {
/*  317 */     return this.fightInfo.canUseSkill(var1, var2, var3);
/*      */   }
/*      */   
/*      */   protected void useSkill(int var1, int var2, int var3) {
/*  321 */     FighterAIOperator var4 = this.fightInfo.useSkill(var1, var2, this.fightInfo.getLevel(var1), var3);
/*  322 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   protected boolean canFighterUseSkill(int var1, int var2) {
/*  326 */     return this.fightInfo.canUseSkill(var1, var2, this.fightInfo.getLevel(var1));
/*      */   }
/*      */   
/*      */   protected List<Integer> getSkillTarget(int var1, int var2, int var3) {
/*  330 */     return this.fightInfo.getSkillTarget(var1, var2, var3);
/*      */   }
/*      */   
/*      */   protected Set<Integer> getCanUseSkillSet(int var1) {
/*  334 */     Set var2 = this.fightInfo.getSkillSet(var1);
/*  335 */     Iterator var3 = var2.iterator();
/*      */     
/*  337 */     while (var3.hasNext()) {
/*  338 */       int var4 = ((Integer)var3.next()).intValue();
/*  339 */       if (!canFighterUseSkill(var1, var4, this.fightInfo.getLevel(var1))) {
/*  340 */         var3.remove();
/*      */       }
/*      */     }
/*      */     
/*  344 */     return var2;
/*      */   }
/*      */   
/*      */   public void setTeamVariable1(int var1, int var2) {
/*  348 */     this.fightInfo.setTeamVariable1(var1, var2);
/*      */   }
/*      */   
/*      */   public int getTeamVariable1(int var1) {
/*  352 */     return this.fightInfo.getTeamVariable1(var1);
/*      */   }
/*      */   
/*      */   public void setTeamVariable2(int var1, int var2) {
/*  356 */     this.fightInfo.setTeamVariable2(var1, var2);
/*      */   }
/*      */   
/*      */   public int getTeamVariable2(int var1) {
/*  360 */     return this.fightInfo.getTeamVariable2(var1);
/*      */   }
/*      */   
/*      */   public void setTeamVariable3(int var1, int var2) {
/*  364 */     this.fightInfo.setTeamVariable3(var1, var2);
/*      */   }
/*      */   
/*      */   public int getTeamVariable3(int var1) {
/*  368 */     return this.fightInfo.getTeamVariable3(var1);
/*      */   }
/*      */   
/*      */   public void setTeamVariable4(int var1, int var2) {
/*  372 */     this.fightInfo.setTeamVariable4(var1, var2);
/*      */   }
/*      */   
/*      */   public int getTeamVariable4(int var1) {
/*  376 */     return this.fightInfo.getTeamVariable4(var1);
/*      */   }
/*      */   
/*      */   public void setTeamVariable5(int var1, int var2) {
/*  380 */     this.fightInfo.setTeamVariable5(var1, var2);
/*      */   }
/*      */   
/*      */   public int getTeamVariable5(int var1) {
/*  384 */     return this.fightInfo.getTeamVariable5(var1);
/*      */   }
/*      */   
/*      */   public void setTeamVariable6(int var1, int var2) {
/*  388 */     this.fightInfo.setTeamVariable6(var1, var2);
/*      */   }
/*      */   
/*      */   public int getTeamVariable6(int var1) {
/*  392 */     return this.fightInfo.getTeamVariable6(var1);
/*      */   }
/*      */   
/*      */   void defense(int var1) {
/*  396 */     FighterAIOperator var2 = this.fightInfo.defense(var1);
/*  397 */     this.m_operators.add(var2);
/*      */   }
/*      */   
/*      */   void protect(int var1, int var2) {
/*  401 */     FighterAIOperator var3 = this.fightInfo.protect(var1, var2);
/*  402 */     this.m_operators.add(var3);
/*      */   }
/*      */   
/*      */   void escape(int var1) {
/*  406 */     FighterAIOperator var2 = this.fightInfo.escape(var1);
/*  407 */     this.m_operators.add(var2);
/*      */   }
/*      */   
/*      */   void escapeSuccess(int var1) {
/*  411 */     FighterAIOperator var2 = this.fightInfo.escapeSuccess(var1);
/*  412 */     this.m_operators.add(var2);
/*      */   }
/*      */   
/*      */   void escapeImmediately(int var1) {
/*  416 */     this.fightInfo.escapeImmediately(var1);
/*      */   }
/*      */   
/*      */   void useItem(int var1, int var2, int var3) {
/*  420 */     FighterAIOperator var4 = this.fightInfo.useItem(var1, var2, var3);
/*  421 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   void summonFriendMonster(int var1, int var2, int... var3) {
/*  425 */     FighterAIOperator var4 = this.fightInfo.summonFriendMonster(false, var1, var2, var3);
/*  426 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   void summonFriendMonsterImmediately(int var1, int var2, int... var3) {
/*  430 */     this.fightInfo.summonFriendMonster(true, var1, var2, var3);
/*      */   }
/*      */   
/*      */   protected void summonFriendMonsterFixPos(int var1, int var2, int var3, int var4) {
/*  434 */     HashMap var5 = new HashMap();
/*  435 */     ArrayList var6 = new ArrayList();
/*  436 */     var6.add(Integer.valueOf(var4));
/*  437 */     var5.put(Integer.valueOf(var3), var6);
/*  438 */     FighterAIOperator var7 = this.fightInfo.summonFriendMonsterFixPos(false, var1, var2, var5);
/*  439 */     this.m_operators.add(var7);
/*      */   }
/*      */   
/*      */   protected void summonFriendMonsterFixPos(int var1, int var2, Map<Integer, List<Integer>> var3) {
/*  443 */     FighterAIOperator var4 = this.fightInfo.summonFriendMonsterFixPos(false, var1, var2, var3);
/*  444 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   protected void summonFriendMonsterFixPosImmediately(int var1, int var2, int var3, int var4) {
/*  448 */     HashMap var5 = new HashMap();
/*  449 */     ArrayList var6 = new ArrayList();
/*  450 */     var6.add(Integer.valueOf(var4));
/*  451 */     var5.put(Integer.valueOf(var3), var6);
/*  452 */     this.fightInfo.summonFriendMonsterFixPos(true, var1, var2, var5);
/*      */   }
/*      */   
/*      */   protected void summonFriendMonsterFixPosImmediately(int var1, int var2, Map<Integer, List<Integer>> var3) {
/*  456 */     this.fightInfo.summonFriendMonsterFixPos(true, var1, var2, var3);
/*      */   }
/*      */   
/*      */   void summonEnernyMonster(int var1, int var2, int... var3) {
/*  460 */     FighterAIOperator var4 = this.fightInfo.summonEnernyMonster(false, var1, var2, var3);
/*  461 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   protected void summonEnernyMonsterFixPos(int var1, int var2, int var3, int var4) {
/*  465 */     HashMap var5 = new HashMap();
/*  466 */     ArrayList var6 = new ArrayList();
/*  467 */     var6.add(Integer.valueOf(var4));
/*  468 */     var5.put(Integer.valueOf(var3), var6);
/*  469 */     FighterAIOperator var7 = this.fightInfo.summonEnernyMonsterFixPos(false, var1, var2, var5);
/*  470 */     this.m_operators.add(var7);
/*      */   }
/*      */   
/*      */   protected void summonEnernyMonsterFixPos(int var1, int var2, Map<Integer, List<Integer>> var3) {
/*  474 */     FighterAIOperator var4 = this.fightInfo.summonEnernyMonsterFixPos(false, var1, var2, var3);
/*  475 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   void summonEnernyMonsterImmediately(int var1, int var2, int... var3) {
/*  479 */     this.fightInfo.summonEnernyMonster(true, var1, var2, var3);
/*      */   }
/*      */   
/*      */   protected void summonEnermyMonsterFixPosImmediately(int var1, int var2, int var3, int var4) {
/*  483 */     HashMap var5 = new HashMap();
/*  484 */     ArrayList var6 = new ArrayList();
/*  485 */     var6.add(Integer.valueOf(var4));
/*  486 */     var5.put(Integer.valueOf(var3), var6);
/*  487 */     this.fightInfo.summonEnernyMonsterFixPos(true, var1, var2, var5);
/*      */   }
/*      */   
/*      */   protected void summonEnermyMonsterFixPosImmediately(int var1, int var2, Map<Integer, List<Integer>> var3) {
/*  491 */     this.fightInfo.summonEnernyMonsterFixPos(true, var1, var2, var3);
/*      */   }
/*      */   
/*      */   void defaultOperator(int var1) {
/*  495 */     Set var2 = getCanUseSkillSet(var1);
/*  496 */     defaultOperator(var1, var2);
/*      */   }
/*      */   
/*      */   protected void defaultOperator(int var1, Set<Integer> var2) {
/*  500 */     if (var2 == null) {
/*  501 */       useNromalAttack(var1, randAliveEnemies(var1));
/*      */     } else {
/*  503 */       int var3 = getLevel(var1);
/*  504 */       Iterator var4 = var2.iterator();
/*      */       
/*      */ 
/*  507 */       while (var4.hasNext()) {
/*  508 */         int var5 = ((Integer)var4.next()).intValue();
/*  509 */         if (!this.fightInfo.canUseSkill(var1, var5, var3)) {
/*  510 */           var4.remove();
/*      */         }
/*      */       }
/*      */       
/*  514 */       int var5 = this.fightInfo.getNormalAttack(var1);
/*  515 */       if (var2.size() > 0) {
/*  516 */         var5 = randomFromSet(var2);
/*      */       }
/*      */       
/*  519 */       List var6 = getSkillTarget(var1, var5, var3);
/*  520 */       int var7 = 0;
/*  521 */       if (var6.size() > 0) {
/*  522 */         var7 = ((Integer)var6.get(0)).intValue();
/*      */       }
/*      */       
/*  525 */       useSkill(var1, var5, var3, var7);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void defaultOperator(int var1, Set<Integer> var2, int var3) {
/*  530 */     if (var2 == null) {
/*  531 */       useNromalAttack(var1, randAliveEnemies(var1));
/*      */     } else {
/*  533 */       int var4 = getLevel(var1);
/*  534 */       Iterator var5 = var2.iterator();
/*      */       
/*      */ 
/*  537 */       while (var5.hasNext()) {
/*  538 */         int var6 = ((Integer)var5.next()).intValue();
/*  539 */         if (!this.fightInfo.canUseSkill(var1, var6, var4)) {
/*  540 */           var5.remove();
/*      */         }
/*      */       }
/*      */       
/*  544 */       int var6 = this.fightInfo.getNormalAttack(var1);
/*  545 */       if (var2.size() > 0) {
/*  546 */         var6 = randomFromSet(var2);
/*      */       }
/*      */       
/*  549 */       useSkill(var1, var6, var4, var3);
/*      */     }
/*      */   }
/*      */   
/*      */   public void addBuff(int var1, int var2) {
/*  554 */     FighterAIOperator var3 = this.fightInfo.addBuff(var1, var2);
/*  555 */     this.m_operators.add(var3);
/*      */   }
/*      */   
/*      */   public void addBuffImmediately(int var1, int var2) {
/*  559 */     this.fightInfo.addBuffImmediately(var1, var2);
/*      */   }
/*      */   
/*      */   protected void say(int var1, int var2, String... var3) {
/*  563 */     FighterAIOperator var4 = this.fightInfo.say(var1, var2, var3);
/*  564 */     this.m_operators.add(var4);
/*      */   }
/*      */   
/*      */   protected void sayImmediately(int var1, int var2, String... var3) {
/*  568 */     this.fightInfo.sayImmediately(var1, var2, var3);
/*      */   }
/*      */   
/*      */   protected void changeFightMapImmediately(int var1) {
/*  572 */     this.fightInfo.changeFightMapImmediately(var1);
/*      */   }
/*      */   
/*      */   protected boolean isMonster(int var1) {
/*  576 */     return this.fightInfo.isMonster(var1);
/*      */   }
/*      */   
/*      */   protected boolean isRole(int var1) {
/*  580 */     return this.fightInfo.isRole(var1);
/*      */   }
/*      */   
/*      */   protected boolean isPet(int var1) {
/*  584 */     return this.fightInfo.isPet(var1);
/*      */   }
/*      */   
/*      */   protected boolean isFellow(int var1) {
/*  588 */     return this.fightInfo.isFellow(var1);
/*      */   }
/*      */   
/*      */   protected boolean isChild(int var1) {
/*  592 */     return this.fightInfo.isChild(var1);
/*      */   }
/*      */   
/*      */   protected boolean isAiObj(int var1) {
/*  596 */     return this.fightInfo.isAiObj(var1);
/*      */   }
/*      */   
/*      */   protected int getMonsterid(int var1) {
/*  600 */     return this.fightInfo.getMonsterid(var1);
/*      */   }
/*      */   
/*      */   protected int getMonsterTypeid(int var1) {
/*  604 */     return this.fightInfo.getMonsterTypeid(var1);
/*      */   }
/*      */   
/*      */   protected String getName(int var1) {
/*  608 */     return this.fightInfo.getName(var1);
/*      */   }
/*      */   
/*      */   protected int getLevel(int var1) {
/*  612 */     return this.fightInfo.getLevel(var1);
/*      */   }
/*      */   
/*      */   protected int getPosition(int var1) {
/*  616 */     return this.fightInfo.getPosition(var1);
/*      */   }
/*      */   
/*      */   protected int getOccupation(int var1) {
/*  620 */     return this.fightInfo.getOccupation(var1);
/*      */   }
/*      */   
/*      */   protected int getGender(int var1) {
/*  624 */     return this.fightInfo.getGender(var1);
/*      */   }
/*      */   
/*      */   protected Set<Integer> getGuiWang() {
/*  628 */     return this.fightInfo.getGuiWang();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getQingYun() {
/*  632 */     return this.fightInfo.getQingYun();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getTianYinSi() {
/*  636 */     return this.fightInfo.getTianYinSi();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getFenXiang() {
/*  640 */     return this.fightInfo.getFenXiang();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getHeHuan() {
/*  644 */     return this.fightInfo.getHeHuan();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getShengWu() {
/*  648 */     return this.fightInfo.getShengWu();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getCangYuGe() {
/*  652 */     return this.fightInfo.getCangYuGe();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getLingYinDian() {
/*  656 */     return this.fightInfo.getLingYinDian();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getYiNengZhe() {
/*  660 */     return this.fightInfo.getYiNengZhe();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getWanDuMen() {
/*  664 */     return this.fightInfo.getWanDuMen();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getDanQingGe() {
/*  668 */     return this.fightInfo.getDanQingGe();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getYinYangShi() {
/*  672 */     return this.fightInfo.getYinYangShi();
/*      */   }
/*      */   
/*      */   protected boolean hasBuff(int var1, int var2) {
/*  676 */     return this.fightInfo.hasBuff(var1, var2);
/*      */   }
/*      */   
/*      */   protected boolean hasOutFightBuff(int var1, int var2) {
/*  680 */     return this.fightInfo.hasOutFightBuff(var1, var2);
/*      */   }
/*      */   
/*      */   protected int random(int var1) {
/*  684 */     return var1 <= 0 ? 0 : Xdb.random().nextInt(var1);
/*      */   }
/*      */   
/*      */   protected Set<Integer> setAnd(Set<Integer>... var1) {
/*  688 */     HashSet var2 = new HashSet();
/*  689 */     if (var1.length > 0) {
/*  690 */       var2.addAll(var1[0]);
/*      */     }
/*      */     
/*  693 */     for (int var3 = 1; var3 < var1.length; var3++) {
/*  694 */       var2.retainAll(var1[var3]);
/*      */     }
/*      */     
/*  697 */     return var2;
/*      */   }
/*      */   
/*      */   protected Set<Integer> setOr(Set<Integer>... var1) {
/*  701 */     HashSet var2 = new HashSet();
/*      */     
/*  703 */     for (int var3 = 0; var3 < var1.length; var3++) {
/*  704 */       var2.addAll(var1[var3]);
/*      */     }
/*      */     
/*  707 */     return var2;
/*      */   }
/*      */   
/*      */   protected Set<Integer> setNot(Set<Integer> var1, Set<Integer> var2) {
/*  711 */     HashSet var3 = new HashSet(var1);
/*  712 */     var3.removeAll(var2);
/*  713 */     return var3;
/*      */   }
/*      */   
/*      */   public void onFighterRelive(int var1) {}
/*      */   
/*      */   protected int randomFromSet(Set<Integer> var1)
/*      */   {
/*  720 */     int var2 = var1.size();
/*  721 */     if (var2 <= 0) {
/*  722 */       return -1;
/*      */     }
/*  724 */     int var3 = random(var2);
/*  725 */     return ((Integer[])(Integer[])(Integer[])var1.toArray(new Integer[var2]))[var3].intValue();
/*      */   }
/*      */   
/*      */   protected boolean isSetEmpty(Set<Integer> var1)
/*      */   {
/*  730 */     return (var1 == null) || (var1.isEmpty());
/*      */   }
/*      */   
/*      */   protected void removeFromSet(Set<Integer> var1, int var2) {
/*  734 */     var1.remove(Integer.valueOf(var2));
/*      */   }
/*      */   
/*      */   protected Set<Integer> getSkillSet(int var1) {
/*  738 */     return this.fightInfo.getSkillSet(var1);
/*      */   }
/*      */   
/*      */   public Integer convertSkill(int var1, int var2) {
/*  742 */     return this.fightInfo.convertSkill(var1, var2);
/*      */   }
/*      */   
/*      */   public static boolean isSkillSeal(int var0) {
/*  746 */     return SkillInterface.isSkillEffectType(var0, 2);
/*      */   }
/*      */   
/*      */   public static boolean isSkillRelive(int var0) {
/*  750 */     return SkillInterface.isSkillEffectType(var0, 1);
/*      */   }
/*      */   
/*      */   public static boolean isSkillDisperseSeal(int var0) {
/*  754 */     return SkillInterface.isSkillEffectType(var0, 5);
/*      */   }
/*      */   
/*      */   public static boolean isSkillDispersePositive(int var0) {
/*  758 */     return SkillInterface.isSkillEffectType(var0, 3);
/*      */   }
/*      */   
/*      */   public static boolean isSkillDisperseNegetive(int var0) {
/*  762 */     return SkillInterface.isSkillEffectType(var0, 4);
/*      */   }
/*      */   
/*      */   public static boolean isSkillDispersePoison(int var0) {
/*  766 */     return SkillInterface.isSkillEffectType(var0, 3);
/*      */   }
/*      */   
/*      */   protected OperatorInfo getOperatorInfo(int var1) {
/*  770 */     return this.fightInfo.getOperatorInfo(var1);
/*      */   }
/*      */   
/*      */   public int getDiffcultType() {
/*  774 */     return this.fightInfo.getDiffcultType();
/*      */   }
/*      */   
/*      */   public int getDisType() {
/*  778 */     return this.fightInfo.getDisType();
/*      */   }
/*      */   
/*      */   public boolean enermyHasNewer(int var1) {
/*  782 */     return this.fightInfo.enermyHasNewer(var1);
/*      */   }
/*      */   
/*      */   public boolean friendHasNewer(int var1) {
/*  786 */     return this.fightInfo.friendHasNewer(var1);
/*      */   }
/*      */   
/*      */   public int getSkillLv(int var1, int var2) {
/*  790 */     return this.fightInfo.getSkillLv(var1, var2);
/*      */   }
/*      */   
/*      */   public int getSealNumLimit() {
/*  794 */     return this.fightInfo.getSealNumLimit();
/*      */   }
/*      */   
/*      */   public Set<Integer> getFriendAiOperateFighters(int var1) {
/*  798 */     return this.fightInfo.getFriendAiOperateFighters(var1);
/*      */   }
/*      */   
/*      */   public Set<Integer> getEnermySealedFighters(int var1) {
/*  802 */     return this.fightInfo.getEnermySealedFighters(var1);
/*      */   }
/*      */   
/*      */   public List<Integer> getAiOperateFriendOrderSpeed(int var1, boolean var2) {
/*  806 */     return this.fightInfo.getAiOperateFriendOrderSpeed(var1, var2);
/*      */   }
/*      */   
/*      */   public boolean isFightAiTianYinOpen() {
/*  810 */     return this.fightInfo.isFightAiTianYinOpen();
/*      */   }
/*      */   
/*      */   public static class OperatorInfo {
/*  814 */     private List<OperatorSkill> operatorSkillsList = new ArrayList();
/*  815 */     private List<OperatorCapture> capturesList = new ArrayList();
/*  816 */     private List<OperatorEscape> escapeLists = new ArrayList();
/*      */     
/*      */ 
/*      */ 
/*      */     public void addOperatorSKill(OperatorSkill var1)
/*      */     {
/*  822 */       this.operatorSkillsList.add(var1);
/*      */     }
/*      */     
/*      */     public void addOperatorCapture(OperatorCapture var1) {
/*  826 */       this.capturesList.add(var1);
/*      */     }
/*      */     
/*      */     public void addOperatorEscape(OperatorEscape var1) {
/*  830 */       this.escapeLists.add(var1);
/*      */     }
/*      */     
/*      */     public boolean isRoleExcuteEscape() {
/*  834 */       Iterator var1 = this.escapeLists.iterator();
/*      */       OperatorEscape var2;
/*      */       do
/*      */       {
/*  838 */         if (!var1.hasNext()) {
/*  839 */           return false;
/*      */         }
/*      */         
/*  842 */         var2 = (OperatorEscape)var1.next();
/*  843 */       } while ((!var2.isRole) || (!var2.isMine));
/*      */       
/*  845 */       return true;
/*      */     }
/*      */     
/*      */     public List<OperatorSkill> getOperatorSkills() {
/*  849 */       ArrayList var1 = new ArrayList();
/*  850 */       var1.addAll(this.operatorSkillsList);
/*  851 */       return var1;
/*      */     }
/*      */     
/*      */     public List<OperatorCapture> getOperatorCaptures() {
/*  855 */       ArrayList var1 = new ArrayList();
/*  856 */       var1.addAll(this.capturesList);
/*  857 */       return var1;
/*      */     }
/*      */     
/*      */     public boolean isOperatorCapture() {
/*  861 */       return this.capturesList.size() > 0;
/*      */     }
/*      */     
/*      */     public boolean isOperatorSealTarget(int var1) {
/*  865 */       Iterator var2 = this.operatorSkillsList.iterator();
/*      */       OperatorSkill var3;
/*      */       do
/*      */       {
/*  869 */         if (!var2.hasNext()) {
/*  870 */           return false;
/*      */         }
/*      */         
/*  873 */         var3 = (OperatorSkill)var2.next();
/*  874 */       } while ((!var3.isSkillSeal()) || (var3.targetFid != var1));
/*      */       
/*  876 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isOperatorReliveTarget(int var1) {
/*  880 */       Iterator var2 = this.operatorSkillsList.iterator();
/*      */       OperatorSkill var3;
/*      */       do
/*      */       {
/*  884 */         if (!var2.hasNext()) {
/*  885 */           return false;
/*      */         }
/*      */         
/*  888 */         var3 = (OperatorSkill)var2.next();
/*  889 */       } while ((!var3.isSkillRelive()) || (var3.targetFid != var1));
/*      */       
/*  891 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isOperatorDisperseSeal(int var1) {
/*  895 */       Iterator var2 = this.operatorSkillsList.iterator();
/*      */       OperatorSkill var3;
/*      */       do
/*      */       {
/*  899 */         if (!var2.hasNext()) {
/*  900 */           return false;
/*      */         }
/*      */         
/*  903 */         var3 = (OperatorSkill)var2.next();
/*  904 */       } while ((!var3.isSkillDisperseSeal()) || (var3.targetFid != var1));
/*      */       
/*  906 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isOperatorDispersePoison(int var1) {
/*  910 */       Iterator var2 = this.operatorSkillsList.iterator();
/*      */       OperatorSkill var3;
/*      */       do
/*      */       {
/*  914 */         if (!var2.hasNext()) {
/*  915 */           return false;
/*      */         }
/*      */         
/*  918 */         var3 = (OperatorSkill)var2.next();
/*  919 */       } while ((!var3.isSkillDispersePoison()) || (var3.targetFid != var1));
/*      */       
/*  921 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isOperatorDisperseNegetive(int var1) {
/*  925 */       Iterator var2 = this.operatorSkillsList.iterator();
/*      */       OperatorSkill var3;
/*      */       do
/*      */       {
/*  929 */         if (!var2.hasNext()) {
/*  930 */           return false;
/*      */         }
/*      */         
/*  933 */         var3 = (OperatorSkill)var2.next();
/*  934 */       } while ((!var3.isSkillDisperseNegetive()) || (var3.targetFid != var1));
/*      */       
/*  936 */       return true;
/*      */     }
/*      */     
/*      */     public boolean isOperatorDispersePositive(int var1) {
/*  940 */       Iterator var2 = this.operatorSkillsList.iterator();
/*      */       OperatorSkill var3;
/*      */       do
/*      */       {
/*  944 */         if (!var2.hasNext()) {
/*  945 */           return false;
/*      */         }
/*      */         
/*  948 */         var3 = (OperatorSkill)var2.next();
/*  949 */       } while ((!var3.isSkillDispersePositive()) || (var3.targetFid != var1));
/*      */       
/*  951 */       return true;
/*      */     }
/*      */     
/*      */     public static class OperatorEscape {
/*      */       public int releaserFid;
/*      */       public boolean isRole;
/*  957 */       public boolean isMine = false;
/*      */     }
/*      */     
/*      */ 
/*      */     public static class OperatorCapture
/*      */     {
/*      */       public int releaserFid;
/*      */       
/*      */       public int targetFid;
/*      */     }
/*      */     
/*      */ 
/*      */     public static class OperatorSkill
/*      */     {
/*      */       public int releaserFid;
/*      */       
/*      */       public int skillid;
/*      */       
/*      */       public int skillLv;
/*      */       
/*      */       public int targetFid;
/*      */       
/*      */       public boolean isSkillSeal()
/*      */       {
/*  981 */         return SkillInterface.isSkillEffectType(this.skillid, 2);
/*      */       }
/*      */       
/*      */       public boolean isSkillRelive() {
/*  985 */         return SkillInterface.isSkillEffectType(this.skillid, 1);
/*      */       }
/*      */       
/*      */       public boolean isSkillDisperseSeal() {
/*  989 */         return SkillInterface.isSkillEffectType(this.skillid, 5);
/*      */       }
/*      */       
/*      */       public boolean isSkillDispersePositive() {
/*  993 */         return SkillInterface.isSkillEffectType(this.skillid, 3);
/*      */       }
/*      */       
/*      */       public boolean isSkillDisperseNegetive() {
/*  997 */         return SkillInterface.isSkillEffectType(this.skillid, 4);
/*      */       }
/*      */       
/*      */       public boolean isSkillDispersePoison() {
/* 1001 */         return SkillInterface.isSkillEffectType(this.skillid, 3);
/*      */       }
/*      */       
/*      */       public boolean isSkillHeal() {
/* 1005 */         return SkillInterface.isSkillEffectType(this.skillid, 7);
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\ai\util\AbstractAI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */