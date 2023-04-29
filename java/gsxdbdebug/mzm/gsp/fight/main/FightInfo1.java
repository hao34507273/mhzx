/*      */ package mzm.gsp.fight.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.fight.OpCapture;
/*      */ import mzm.gsp.fight.ai.util.AbstractAI.OperatorInfo;
/*      */ import mzm.gsp.fight.ai.util.AbstractAI.OperatorInfo.OperatorCapture;
/*      */ import mzm.gsp.fight.ai.util.AbstractAI.OperatorInfo.OperatorEscape;
/*      */ import mzm.gsp.fight.ai.util.AbstractAI.OperatorInfo.OperatorSkill;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*      */ import mzm.gsp.fight.fighter.comparator.HpComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.HpPercentRateComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MAGATKComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MAGDEFComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MpComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.MpPercentRateComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.PHYATKComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.PHYDEFComparator;
/*      */ import mzm.gsp.fight.fighter.comparator.SpeedComparator;
/*      */ import mzm.gsp.monster.main.MonsterInterface;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.skill.main.Skill;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import mzm.gsp.teamplatform.match.TeamMatchInterface;
/*      */ import xbean.FightCmd;
/*      */ import xdb.Xdb;
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class FightInfo1
/*      */ {
/*      */   private Fight fight;
/*      */   
/*      */   public FightInfo1(Fight var1)
/*      */   {
/*   43 */     this.fight = var1;
/*      */   }
/*      */   
/*      */   public int getRound() {
/*   47 */     return this.fight.getRound();
/*      */   }
/*      */   
/*      */   public Set<Long> getCanSummonPets(int var1) {
/*   51 */     Fighter var2 = this.fight.getFighter(var1);
/*   52 */     if (var2 == null) {
/*   53 */       return new HashSet();
/*      */     }
/*   55 */     return (var2 instanceof CloneFighterRole) ? ((CloneFighterRole)var2).getCanSummonPets() : new HashSet();
/*      */   }
/*      */   
/*      */   public Set<Long> getCanSummonChildren(int var1)
/*      */   {
/*   60 */     Fighter var2 = this.fight.getFighter(var1);
/*   61 */     if (var2 == null) {
/*   62 */       return new HashSet();
/*      */     }
/*   64 */     return (var2 instanceof CloneFighterRole) ? ((CloneFighterRole)var2).getCanSummonChildren() : new HashSet();
/*      */   }
/*      */   
/*      */   public boolean canSummon(int var1)
/*      */   {
/*   69 */     Fighter var2 = this.fight.getFighter(var1);
/*   70 */     return var2 == null ? false : var2.canSummon();
/*      */   }
/*      */   
/*      */   public boolean canSummonChild(int var1) {
/*   74 */     Fighter var2 = this.fight.getFighter(var1);
/*   75 */     return var2 == null ? false : var2.canSummonChild();
/*      */   }
/*      */   
/*      */   public boolean carryPet(int var1) {
/*   79 */     Fighter var2 = this.fight.getFighter(var1);
/*   80 */     return var2 == null ? false : var2.carryPet();
/*      */   }
/*      */   
/*      */   public boolean carryChild(int var1) {
/*   84 */     Fighter var2 = this.fight.getFighter(var1);
/*   85 */     return var2 == null ? false : var2.carryChild();
/*      */   }
/*      */   
/*      */   public int getPetLevel(long var1, int var3) {
/*   89 */     Fighter var4 = this.fight.getFighter(var3);
/*   90 */     if (var4 == null) {
/*   91 */       return -1;
/*      */     }
/*   93 */     return (var4 instanceof CloneFighterRole) ? ((CloneFighterRole)var4).getPetLevel(var1) : -1;
/*      */   }
/*      */   
/*      */   public Set<Integer> getEnemies(int var1)
/*      */   {
/*   98 */     Fighter var2 = this.fight.getFighter(var1);
/*   99 */     HashSet var3 = new HashSet();
/*  100 */     if (var2 == null) {
/*  101 */       return var3;
/*      */     }
/*  103 */     Iterator var4 = var2.getEnermyFighters().iterator();
/*      */     
/*  105 */     while (var4.hasNext()) {
/*  106 */       Fighter var5 = (Fighter)var4.next();
/*  107 */       var3.add(Integer.valueOf(var5.getid()));
/*      */     }
/*      */     
/*  110 */     return var3;
/*      */   }
/*      */   
/*      */   public Set<Integer> getFriends(int var1)
/*      */   {
/*  115 */     Fighter var2 = this.fight.getFighter(var1);
/*  116 */     HashSet var3 = new HashSet();
/*  117 */     if (var2 == null) {
/*  118 */       return var3;
/*      */     }
/*  120 */     Iterator var4 = var2.getFriendFighters().iterator();
/*      */     
/*  122 */     while (var4.hasNext()) {
/*  123 */       Fighter var5 = (Fighter)var4.next();
/*  124 */       var3.add(Integer.valueOf(var5.getid()));
/*      */     }
/*      */     
/*  127 */     return var3;
/*      */   }
/*      */   
/*      */   public Set<Integer> getAliveEnemies(int var1)
/*      */   {
/*  132 */     Fighter var2 = this.fight.getFighter(var1);
/*  133 */     HashSet var3 = new HashSet();
/*  134 */     if (var2 == null) {
/*  135 */       return var3;
/*      */     }
/*  137 */     Iterator var4 = var2.getEnermyLiveFighters().iterator();
/*      */     
/*  139 */     while (var4.hasNext()) {
/*  140 */       Fighter var5 = (Fighter)var4.next();
/*  141 */       var3.add(Integer.valueOf(var5.getid()));
/*      */     }
/*      */     
/*  144 */     return var3;
/*      */   }
/*      */   
/*      */   public Set<Integer> getAliveFriends(int var1)
/*      */   {
/*  149 */     Fighter var2 = this.fight.getFighter(var1);
/*  150 */     HashSet var3 = new HashSet();
/*  151 */     if (var2 == null) {
/*  152 */       return var3;
/*      */     }
/*  154 */     Iterator var4 = var2.getFriendLiveFighters().iterator();
/*      */     
/*  156 */     while (var4.hasNext()) {
/*  157 */       Fighter var5 = (Fighter)var4.next();
/*  158 */       var3.add(Integer.valueOf(var5.getid()));
/*      */     }
/*      */     
/*  161 */     return var3;
/*      */   }
/*      */   
/*      */   public int randAliveEnemies(int var1)
/*      */   {
/*  166 */     Set var2 = getAliveEnemies(var1);
/*  167 */     int var3 = var2.size();
/*  168 */     if (var3 == 0) {
/*  169 */       return -1;
/*      */     }
/*  171 */     int var4 = Xdb.random().nextInt(var3);
/*  172 */     return ((Integer[])(Integer[])(Integer[])var2.toArray(new Integer[var3]))[var4].intValue();
/*      */   }
/*      */   
/*      */   public int randAliveFriends(int var1)
/*      */   {
/*  177 */     Set var2 = getAliveFriends(var1);
/*  178 */     int var3 = var2.size();
/*  179 */     if (var3 == 0) {
/*  180 */       return -1;
/*      */     }
/*  182 */     int var4 = Xdb.random().nextInt(var3);
/*  183 */     return ((Integer[])(Integer[])(Integer[])var2.toArray(new Integer[var3]))[var4].intValue();
/*      */   }
/*      */   
/*      */   public int randAliveFriendsExceptSelf(int var1)
/*      */   {
/*  188 */     Fighter var2 = this.fight.getFighter(var1);
/*  189 */     ArrayList var3 = new ArrayList();
/*  190 */     if (var2 == null) {
/*  191 */       return -1;
/*      */     }
/*  193 */     Iterator var4 = var2.getFriendLiveFighters().iterator();
/*      */     
/*  195 */     while (var4.hasNext()) {
/*  196 */       Fighter var5 = (Fighter)var4.next();
/*  197 */       int var6 = var5.getid();
/*  198 */       if (var6 != var1) {
/*  199 */         var3.add(Integer.valueOf(var6));
/*      */       }
/*      */     }
/*      */     
/*  203 */     int var7 = var3.size();
/*  204 */     if (var7 <= 0) {
/*  205 */       return -1;
/*      */     }
/*  207 */     int var8 = Xdb.random().nextInt(var7);
/*  208 */     return ((Integer)var3.get(var8)).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyHpRemainMin(int var1)
/*      */   {
/*  214 */     Fighter var2 = this.fight.getFighter(var1);
/*  215 */     if (var2 == null) {
/*  216 */       return -1;
/*      */     }
/*  218 */     ArrayList var3 = new ArrayList();
/*  219 */     Set var4 = var2.getEnermyLiveFighters();
/*  220 */     var3.addAll(var4);
/*  221 */     if (var3.size() <= 0) {
/*  222 */       return -1;
/*      */     }
/*  224 */     Collections.sort(var3, new HpComparator(true));
/*  225 */     return ((Fighter)var3.get(0)).fighterid;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyHpRemainMax(int var1)
/*      */   {
/*  231 */     Fighter var2 = this.fight.getFighter(var1);
/*  232 */     if (var2 == null) {
/*  233 */       return -1;
/*      */     }
/*  235 */     ArrayList var3 = new ArrayList();
/*  236 */     Set var4 = var2.getEnermyLiveFighters();
/*  237 */     var3.addAll(var4);
/*  238 */     if (var3.size() <= 0) {
/*  239 */       return -1;
/*      */     }
/*  241 */     Collections.sort(var3, new HpComparator(false));
/*  242 */     return ((Fighter)var3.get(0)).fighterid;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getTargetHp(int var1)
/*      */   {
/*  248 */     Fighter var2 = this.fight.getFighter(var1);
/*  249 */     return var2 == null ? -1 : var2.getHp();
/*      */   }
/*      */   
/*      */   public int getTargetMp(int var1) {
/*  253 */     Fighter var2 = this.fight.getFighter(var1);
/*  254 */     return var2 == null ? -1 : var2.getMp();
/*      */   }
/*      */   
/*      */   public int getEnergy(int var1) {
/*  258 */     Fighter var2 = this.fight.getFighter(var1);
/*  259 */     return var2 == null ? -1 : var2.getEnergy();
/*      */   }
/*      */   
/*      */   public int getSpeed(int var1) {
/*  263 */     Fighter var2 = this.fight.getFighter(var1);
/*  264 */     return var2 == null ? -1 : var2.getSpeed();
/*      */   }
/*      */   
/*      */   public int getTargetHpRate(int var1) {
/*  268 */     Fighter var2 = this.fight.getFighter(var1);
/*  269 */     return var2 == null ? -1 : (int)var2.getCurHpRateValue();
/*      */   }
/*      */   
/*      */   public int getTargetMpRate(int var1) {
/*  273 */     Fighter var2 = this.fight.getFighter(var1);
/*  274 */     return var2 == null ? -1 : (int)var2.getCurMpRateValue();
/*      */   }
/*      */   
/*      */   public int getAnger(int var1) {
/*  278 */     Fighter var2 = this.fight.getFighter(var1);
/*  279 */     return var2 == null ? -1 : var2.getAnger();
/*      */   }
/*      */   
/*      */   public boolean isDead(int var1) {
/*  283 */     Fighter var2 = this.fight.getFighter(var1);
/*  284 */     if (var2 == null) {
/*  285 */       return true;
/*      */     }
/*  287 */     return (var2.isDead()) || (var2.isFakeDead());
/*      */   }
/*      */   
/*      */   public boolean isRealDead(int var1)
/*      */   {
/*  292 */     Fighter var2 = this.fight.getFighter(var1);
/*  293 */     return var2 == null ? true : var2.isDead();
/*      */   }
/*      */   
/*      */   public boolean isFakeDead(int var1) {
/*  297 */     Fighter var2 = this.fight.getFighter(var1);
/*  298 */     return var2 == null ? false : var2.isFakeDead();
/*      */   }
/*      */   
/*      */   public boolean hasBuffState(int var1, int var2) {
/*  302 */     Fighter var3 = this.fight.getFighter(var1);
/*  303 */     return var3 == null ? false : var3.hasBuffState(var2);
/*      */   }
/*      */   
/*      */   public boolean isStone(int var1) {
/*  307 */     Fighter var2 = this.fight.getFighter(var1);
/*  308 */     return var2 == null ? true : var2.isStone();
/*      */   }
/*      */   
/*      */   public boolean isNotBeHealed(int var1) {
/*  312 */     Fighter var2 = this.fight.getFighter(var1);
/*  313 */     return var2 == null ? true : var2.isNotBeHealed();
/*      */   }
/*      */   
/*      */   public boolean isInvisiable(int var1) {
/*  317 */     Fighter var2 = this.fight.getFighter(var1);
/*  318 */     return var2 == null ? true : var2.isInvisible();
/*      */   }
/*      */   
/*      */   public boolean isVisiable(int var1) {
/*  322 */     Fighter var2 = this.fight.getFighter(var1);
/*  323 */     return var2 == null ? false : var2.isVisible();
/*      */   }
/*      */   
/*      */   public boolean isSleep(int var1) {
/*  327 */     Fighter var2 = this.fight.getFighter(var1);
/*  328 */     return var2 == null ? true : var2.isSleep();
/*      */   }
/*      */   
/*      */   public boolean isRest(int var1) {
/*  332 */     Fighter var2 = this.fight.getFighter(var1);
/*  333 */     return var2 == null ? true : var2.isRest();
/*      */   }
/*      */   
/*      */   public boolean isWeak(int var1) {
/*  337 */     Fighter var2 = this.fight.getFighter(var1);
/*  338 */     return var2 == null ? true : var2.isWeak();
/*      */   }
/*      */   
/*      */   public boolean isMess(int var1) {
/*  342 */     Fighter var2 = this.fight.getFighter(var1);
/*  343 */     return var2 == null ? true : var2.isMess();
/*      */   }
/*      */   
/*      */   public boolean isFear(int var1) {
/*  347 */     Fighter var2 = this.fight.getFighter(var1);
/*  348 */     return var2 == null ? true : var2.isFear();
/*      */   }
/*      */   
/*      */   public boolean isGhost(int var1) {
/*  352 */     Fighter var2 = this.fight.getFighter(var1);
/*  353 */     return var2 == null ? true : var2.isGhost();
/*      */   }
/*      */   
/*      */   public boolean isSealPhy(int var1) {
/*  357 */     Fighter var2 = this.fight.getFighter(var1);
/*  358 */     return var2 == null ? true : var2.isSealPhy();
/*      */   }
/*      */   
/*      */   public boolean isSealMgc(int var1) {
/*  362 */     Fighter var2 = this.fight.getFighter(var1);
/*  363 */     return var2 == null ? true : var2.isSealMgc();
/*      */   }
/*      */   
/*      */   public final boolean isSealSpecial(int var1) {
/*  367 */     Fighter var2 = this.fight.getFighter(var1);
/*  368 */     return var2 == null ? true : var2.isSealSpecial();
/*      */   }
/*      */   
/*      */   public boolean isSealNormal(int var1) {
/*  372 */     Fighter var2 = this.fight.getFighter(var1);
/*  373 */     return var2 == null ? true : var2.isSealNormal();
/*      */   }
/*      */   
/*      */   public boolean isSealDefence(int var1) {
/*  377 */     Fighter var2 = this.fight.getFighter(var1);
/*  378 */     return var2 == null ? true : var2.isSealDefence();
/*      */   }
/*      */   
/*      */   public boolean isSealEscape(int var1) {
/*  382 */     Fighter var2 = this.fight.getFighter(var1);
/*  383 */     return var2 == null ? true : var2.isSealEscape();
/*      */   }
/*      */   
/*      */   public boolean isSealProtect(int var1) {
/*  387 */     Fighter var2 = this.fight.getFighter(var1);
/*  388 */     return var2 == null ? true : var2.isSealProtect();
/*      */   }
/*      */   
/*      */   public boolean isSealSummon(int var1) {
/*  392 */     Fighter var2 = this.fight.getFighter(var1);
/*  393 */     return var2 == null ? true : var2.isSealSummon();
/*      */   }
/*      */   
/*      */   public boolean isNegetive(int var1) {
/*  397 */     Fighter var2 = this.fight.getFighter(var1);
/*  398 */     return var2 == null ? true : var2.isNegetive();
/*      */   }
/*      */   
/*      */   public boolean isPoison(int var1) {
/*  402 */     Fighter var2 = this.fight.getFighter(var1);
/*  403 */     return var2 == null ? true : var2.isPoison();
/*      */   }
/*      */   
/*      */   public boolean isPositive(int var1) {
/*  407 */     Fighter var2 = this.fight.getFighter(var1);
/*  408 */     return var2 == null ? true : var2.isPositive();
/*      */   }
/*      */   
/*      */   public Set<Integer> getEnermySealedFighters(int var1) {
/*  412 */     HashSet var2 = new HashSet();
/*  413 */     Iterator var3 = var2.iterator();
/*      */     
/*  415 */     while (var3.hasNext()) {
/*  416 */       int var4 = ((Integer)var3.next()).intValue();
/*  417 */       if (isSealed(var4)) {
/*  418 */         var2.add(Integer.valueOf(var4));
/*      */       }
/*      */     }
/*      */     
/*  422 */     return var2;
/*      */   }
/*      */   
/*      */   public boolean isSealed(int var1) {
/*  426 */     Fighter var2 = this.fight.getFighter(var1);
/*  427 */     if (var2 == null) {
/*  428 */       return false;
/*      */     }
/*  430 */     return var2.getAllSealEffectBuff().size() > 0;
/*      */   }
/*      */   
/*      */   public int getFriendHpGreater(int var1, int var2)
/*      */   {
/*  435 */     Fighter var3 = this.fight.getFighter(var1);
/*  436 */     if (var3 == null) {
/*  437 */       return -1;
/*      */     }
/*  439 */     Set var4 = var3.getFriendLiveFighters();
/*  440 */     if (var4.size() <= 0) {
/*  441 */       return -1;
/*      */     }
/*  443 */     ArrayList var5 = new ArrayList();
/*  444 */     var5.addAll(var4);
/*  445 */     Collections.sort(var5, new HpComparator(false));
/*  446 */     if (var2 > var5.size()) {
/*  447 */       var2 = var5.size();
/*      */     }
/*      */     
/*  450 */     int var6 = var2 - 1;
/*  451 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendHpRateGreater(int var1, int var2)
/*      */   {
/*  457 */     Fighter var3 = this.fight.getFighter(var1);
/*  458 */     if (var3 == null) {
/*  459 */       return -1;
/*      */     }
/*  461 */     Set var4 = var3.getFriendLiveFighters();
/*  462 */     if (var4.size() <= 0) {
/*  463 */       return -1;
/*      */     }
/*  465 */     ArrayList var5 = new ArrayList();
/*  466 */     var5.addAll(var4);
/*  467 */     Collections.sort(var5, new HpPercentRateComparator(false));
/*  468 */     if (var2 > var5.size()) {
/*  469 */       var2 = var5.size();
/*      */     }
/*      */     
/*  472 */     int var6 = var2 - 1;
/*  473 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendMpGreater(int var1, int var2)
/*      */   {
/*  479 */     Fighter var3 = this.fight.getFighter(var1);
/*  480 */     if (var3 == null) {
/*  481 */       return -1;
/*      */     }
/*  483 */     Set var4 = var3.getFriendLiveFighters();
/*  484 */     if (var4.size() <= 0) {
/*  485 */       return -1;
/*      */     }
/*  487 */     ArrayList var5 = new ArrayList();
/*  488 */     var5.addAll(var4);
/*  489 */     Collections.sort(var5, new MpComparator(false));
/*  490 */     if (var2 > var5.size()) {
/*  491 */       var2 = var5.size();
/*      */     }
/*      */     
/*  494 */     int var6 = var2 - 1;
/*  495 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendMpRateGreater(int var1, int var2)
/*      */   {
/*  501 */     Fighter var3 = this.fight.getFighter(var1);
/*  502 */     if (var3 == null) {
/*  503 */       return -1;
/*      */     }
/*  505 */     Set var4 = var3.getFriendLiveFighters();
/*  506 */     if (var4.size() <= 0) {
/*  507 */       return -1;
/*      */     }
/*  509 */     ArrayList var5 = new ArrayList();
/*  510 */     var5.addAll(var4);
/*  511 */     Collections.sort(var5, new MpPercentRateComparator(false));
/*  512 */     if (var2 > var5.size()) {
/*  513 */       var2 = var5.size();
/*      */     }
/*      */     
/*  516 */     int var6 = var2 - 1;
/*  517 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyHpGreater(int var1, int var2)
/*      */   {
/*  523 */     Fighter var3 = this.fight.getFighter(var1);
/*  524 */     if (var3 == null) {
/*  525 */       return -1;
/*      */     }
/*  527 */     Set var4 = var3.getEnermyLiveFighters();
/*  528 */     if (var4.size() <= 0) {
/*  529 */       return -1;
/*      */     }
/*  531 */     ArrayList var5 = new ArrayList();
/*  532 */     var5.addAll(var4);
/*  533 */     Collections.sort(var5, new HpComparator(false));
/*  534 */     if (var2 > var5.size()) {
/*  535 */       var2 = var5.size();
/*      */     }
/*      */     
/*  538 */     int var6 = var2 - 1;
/*  539 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyHpMin(int var1, int var2)
/*      */   {
/*  545 */     Fighter var3 = this.fight.getFighter(var1);
/*  546 */     if (var3 == null) {
/*  547 */       return -1;
/*      */     }
/*  549 */     Set var4 = var3.getEnermyLiveFighters();
/*  550 */     if (var4.size() <= 0) {
/*  551 */       return -1;
/*      */     }
/*  553 */     ArrayList var5 = new ArrayList();
/*  554 */     var5.addAll(var4);
/*  555 */     Collections.sort(var5, new HpComparator(true));
/*  556 */     if (var2 > var5.size()) {
/*  557 */       var2 = var5.size();
/*      */     }
/*      */     
/*  560 */     int var6 = var2 - 1;
/*  561 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyHpRateGreater(int var1, int var2)
/*      */   {
/*  567 */     Fighter var3 = this.fight.getFighter(var1);
/*  568 */     if (var3 == null) {
/*  569 */       return -1;
/*      */     }
/*  571 */     Set var4 = var3.getEnermyLiveFighters();
/*  572 */     if (var4.size() <= 0) {
/*  573 */       return -1;
/*      */     }
/*  575 */     ArrayList var5 = new ArrayList();
/*  576 */     var5.addAll(var4);
/*  577 */     Collections.sort(var5, new HpPercentRateComparator(false));
/*  578 */     if (var2 > var5.size()) {
/*  579 */       var2 = var5.size();
/*      */     }
/*      */     
/*  582 */     int var6 = var2 - 1;
/*  583 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyMpGreater(int var1, int var2)
/*      */   {
/*  589 */     Fighter var3 = this.fight.getFighter(var1);
/*  590 */     if (var3 == null) {
/*  591 */       return -1;
/*      */     }
/*  593 */     Set var4 = var3.getEnermyLiveFighters();
/*  594 */     if (var4.size() <= 0) {
/*  595 */       return -1;
/*      */     }
/*  597 */     ArrayList var5 = new ArrayList();
/*  598 */     var5.addAll(var4);
/*  599 */     Collections.sort(var5, new MpComparator(false));
/*  600 */     if (var2 > var5.size()) {
/*  601 */       var2 = var5.size();
/*      */     }
/*      */     
/*  604 */     int var6 = var2 - 1;
/*  605 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyMpRateGreater(int var1, int var2)
/*      */   {
/*  611 */     Fighter var3 = this.fight.getFighter(var1);
/*  612 */     if (var3 == null) {
/*  613 */       return -1;
/*      */     }
/*  615 */     Set var4 = var3.getEnermyLiveFighters();
/*  616 */     if (var4.size() <= 0) {
/*  617 */       return -1;
/*      */     }
/*  619 */     ArrayList var5 = new ArrayList();
/*  620 */     var5.addAll(var4);
/*  621 */     Collections.sort(var5, new MpPercentRateComparator(false));
/*  622 */     if (var2 > var5.size()) {
/*  623 */       var2 = var5.size();
/*      */     }
/*      */     
/*  626 */     int var6 = var2 - 1;
/*  627 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getAiOperateFriendOrderSpeed(int var1, boolean var2)
/*      */   {
/*  633 */     Fighter var3 = this.fight.getFighter(var1);
/*  634 */     if (var3 == null) {
/*  635 */       return new ArrayList();
/*      */     }
/*  637 */     Set var4 = var3.getFriendFighters();
/*  638 */     if (var4.size() <= 0) {
/*  639 */       return new ArrayList();
/*      */     }
/*  641 */     ArrayList var5 = new ArrayList();
/*  642 */     var5.addAll(var4);
/*  643 */     Collections.sort(var5, new SpeedComparator(false));
/*  644 */     Iterator var6 = var5.iterator();
/*  645 */     ArrayList var7 = new ArrayList();
/*      */     
/*      */ 
/*  648 */     while (var6.hasNext()) {
/*  649 */       Fighter var8 = (Fighter)var6.next();
/*  650 */       if (var8.canPlayerOperate()) {
/*  651 */         var6.remove();
/*  652 */       } else if (!var2) {
/*  653 */         if ((!var8.isFakeDead()) && (!var8.isDead())) {
/*  654 */           var7.add(Integer.valueOf(var8.getid()));
/*      */         } else {
/*  656 */           var6.remove();
/*      */         }
/*      */       } else {
/*  659 */         var7.add(Integer.valueOf(var8.getid()));
/*      */       }
/*      */     }
/*      */     
/*  663 */     return var7;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFriendSpeedGreater(int var1, int var2)
/*      */   {
/*  670 */     Fighter var3 = this.fight.getFighter(var1);
/*  671 */     if (var3 == null) {
/*  672 */       return -1;
/*      */     }
/*  674 */     Set var4 = var3.getFriendLiveFighters();
/*  675 */     if (var4.size() <= 0) {
/*  676 */       return -1;
/*      */     }
/*  678 */     ArrayList var5 = new ArrayList();
/*  679 */     var5.addAll(var4);
/*  680 */     Collections.sort(var5, new SpeedComparator(false));
/*  681 */     if (var2 > var5.size()) {
/*  682 */       var2 = var5.size();
/*      */     }
/*      */     
/*  685 */     int var6 = var2 - 1;
/*  686 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemySpeedGreater(int var1, int var2)
/*      */   {
/*  692 */     Fighter var3 = this.fight.getFighter(var1);
/*  693 */     if (var3 == null) {
/*  694 */       return -1;
/*      */     }
/*  696 */     Set var4 = var3.getEnermyLiveFighters();
/*  697 */     if (var4.size() <= 0) {
/*  698 */       return -1;
/*      */     }
/*  700 */     ArrayList var5 = new ArrayList();
/*  701 */     var5.addAll(var4);
/*  702 */     Collections.sort(var5, new SpeedComparator(false));
/*  703 */     if (var2 > var5.size()) {
/*  704 */       var2 = var5.size();
/*      */     }
/*      */     
/*  707 */     int var6 = var2 - 1;
/*  708 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendPhyAtkGreater(int var1, int var2)
/*      */   {
/*  714 */     Fighter var3 = this.fight.getFighter(var1);
/*  715 */     if (var3 == null) {
/*  716 */       return -1;
/*      */     }
/*  718 */     Set var4 = var3.getFriendLiveFighters();
/*  719 */     if (var4.size() <= 0) {
/*  720 */       return -1;
/*      */     }
/*  722 */     ArrayList var5 = new ArrayList();
/*  723 */     var5.addAll(var4);
/*  724 */     Collections.sort(var5, new PHYATKComparator(false));
/*  725 */     if (var2 > var5.size()) {
/*  726 */       var2 = var5.size();
/*      */     }
/*      */     
/*  729 */     int var6 = var2 - 1;
/*  730 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnermyPhyAtkGreater(int var1, int var2)
/*      */   {
/*  736 */     Fighter var3 = this.fight.getFighter(var1);
/*  737 */     if (var3 == null) {
/*  738 */       return -1;
/*      */     }
/*  740 */     Set var4 = var3.getEnermyLiveFighters();
/*  741 */     if (var4.size() <= 0) {
/*  742 */       return -1;
/*      */     }
/*  744 */     ArrayList var5 = new ArrayList();
/*  745 */     var5.addAll(var4);
/*  746 */     Collections.sort(var5, new PHYATKComparator(false));
/*  747 */     if (var2 > var5.size()) {
/*  748 */       var2 = var5.size();
/*      */     }
/*      */     
/*  751 */     int var6 = var2 - 1;
/*  752 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendPhyDefGreater(int var1, int var2)
/*      */   {
/*  758 */     Fighter var3 = this.fight.getFighter(var1);
/*  759 */     if (var3 == null) {
/*  760 */       return -1;
/*      */     }
/*  762 */     Set var4 = var3.getFriendLiveFighters();
/*  763 */     if (var4.size() <= 0) {
/*  764 */       return -1;
/*      */     }
/*  766 */     ArrayList var5 = new ArrayList();
/*  767 */     var5.addAll(var4);
/*  768 */     Collections.sort(var5, new PHYDEFComparator(false));
/*  769 */     if (var2 > var5.size()) {
/*  770 */       var2 = var5.size();
/*      */     }
/*      */     
/*  773 */     int var6 = var2 - 1;
/*  774 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnermyPhyDefGreater(int var1, int var2)
/*      */   {
/*  780 */     Fighter var3 = this.fight.getFighter(var1);
/*  781 */     if (var3 == null) {
/*  782 */       return -1;
/*      */     }
/*  784 */     Set var4 = var3.getEnermyLiveFighters();
/*  785 */     if (var4.size() <= 0) {
/*  786 */       return -1;
/*      */     }
/*  788 */     ArrayList var5 = new ArrayList();
/*  789 */     var5.addAll(var4);
/*  790 */     Collections.sort(var5, new PHYDEFComparator(false));
/*  791 */     if (var2 > var5.size()) {
/*  792 */       var2 = var5.size();
/*      */     }
/*      */     
/*  795 */     int var6 = var2 - 1;
/*  796 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyPhyDefMinute(int var1, int var2)
/*      */   {
/*  802 */     Fighter var3 = this.fight.getFighter(var1);
/*  803 */     if (var3 == null) {
/*  804 */       return -1;
/*      */     }
/*  806 */     Set var4 = var3.getEnermyLiveFighters();
/*  807 */     if (var4.size() <= 0) {
/*  808 */       return -1;
/*      */     }
/*  810 */     ArrayList var5 = new ArrayList();
/*  811 */     var5.addAll(var4);
/*  812 */     Collections.sort(var5, new PHYDEFComparator(true));
/*  813 */     if (var2 > var5.size()) {
/*  814 */       var2 = var5.size();
/*      */     }
/*      */     
/*  817 */     int var6 = var2 - 1;
/*  818 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendMGCAtkGreater(int var1, int var2)
/*      */   {
/*  824 */     Fighter var3 = this.fight.getFighter(var1);
/*  825 */     if (var3 == null) {
/*  826 */       return -1;
/*      */     }
/*  828 */     Set var4 = var3.getFriendLiveFighters();
/*  829 */     if (var4.size() <= 0) {
/*  830 */       return -1;
/*      */     }
/*  832 */     ArrayList var5 = new ArrayList();
/*  833 */     var5.addAll(var4);
/*  834 */     Collections.sort(var5, new MAGATKComparator(false));
/*  835 */     if (var2 > var5.size()) {
/*  836 */       var2 = var5.size();
/*      */     }
/*      */     
/*  839 */     int var6 = var2 - 1;
/*  840 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnermyMGCAtkGreater(int var1, int var2)
/*      */   {
/*  846 */     Fighter var3 = this.fight.getFighter(var1);
/*  847 */     if (var3 == null) {
/*  848 */       return -1;
/*      */     }
/*  850 */     Set var4 = var3.getEnermyLiveFighters();
/*  851 */     if (var4.size() <= 0) {
/*  852 */       return -1;
/*      */     }
/*  854 */     ArrayList var5 = new ArrayList();
/*  855 */     var5.addAll(var4);
/*  856 */     Collections.sort(var5, new MAGATKComparator(false));
/*  857 */     if (var2 > var5.size()) {
/*  858 */       var2 = var5.size();
/*      */     }
/*      */     
/*  861 */     int var6 = var2 - 1;
/*  862 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getFriendMGCDefGreater(int var1, int var2)
/*      */   {
/*  868 */     Fighter var3 = this.fight.getFighter(var1);
/*  869 */     if (var3 == null) {
/*  870 */       return -1;
/*      */     }
/*  872 */     Set var4 = var3.getFriendLiveFighters();
/*  873 */     if (var4.size() <= 0) {
/*  874 */       return -1;
/*      */     }
/*  876 */     ArrayList var5 = new ArrayList();
/*  877 */     var5.addAll(var4);
/*  878 */     Collections.sort(var5, new MAGDEFComparator(false));
/*  879 */     if (var2 > var5.size()) {
/*  880 */       var2 = var5.size();
/*      */     }
/*      */     
/*  883 */     int var6 = var2 - 1;
/*  884 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnermyMGCDefGreater(int var1, int var2)
/*      */   {
/*  890 */     Fighter var3 = this.fight.getFighter(var1);
/*  891 */     if (var3 == null) {
/*  892 */       return -1;
/*      */     }
/*  894 */     Set var4 = var3.getEnermyLiveFighters();
/*  895 */     if (var4.size() <= 0) {
/*  896 */       return -1;
/*      */     }
/*  898 */     ArrayList var5 = new ArrayList();
/*  899 */     var5.addAll(var4);
/*  900 */     Collections.sort(var5, new MAGDEFComparator(false));
/*  901 */     if (var2 > var5.size()) {
/*  902 */       var2 = var5.size();
/*      */     }
/*      */     
/*  905 */     int var6 = var2 - 1;
/*  906 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public int getEnemyMGCDefMinute(int var1, int var2)
/*      */   {
/*  912 */     Fighter var3 = this.fight.getFighter(var1);
/*  913 */     if (var3 == null) {
/*  914 */       return -1;
/*      */     }
/*  916 */     Set var4 = var3.getEnermyLiveFighters();
/*  917 */     if (var4.size() <= 0) {
/*  918 */       return -1;
/*      */     }
/*  920 */     ArrayList var5 = new ArrayList();
/*  921 */     var5.addAll(var4);
/*  922 */     Collections.sort(var5, new MAGDEFComparator(true));
/*  923 */     if (var2 > var5.size()) {
/*  924 */       var2 = var5.size();
/*      */     }
/*      */     
/*  927 */     int var6 = var2 - 1;
/*  928 */     return var6 < 0 ? -1 : ((Fighter)var5.get(var6)).getid();
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getFriendSpeedOrders(int var1)
/*      */   {
/*  934 */     Fighter var2 = this.fight.getFighter(var1);
/*  935 */     if (var2 == null) {
/*  936 */       return Collections.emptyList();
/*      */     }
/*  938 */     Set var3 = var2.getFriendFighters();
/*  939 */     if (var3.size() <= 0) {
/*  940 */       return Collections.emptyList();
/*      */     }
/*  942 */     ArrayList var4 = new ArrayList();
/*  943 */     var4.addAll(var3);
/*  944 */     Collections.sort(var4, new SpeedComparator(false));
/*  945 */     ArrayList var5 = new ArrayList();
/*  946 */     Iterator var6 = var4.iterator();
/*      */     
/*  948 */     while (var6.hasNext()) {
/*  949 */       Fighter var7 = (Fighter)var6.next();
/*  950 */       var5.add(Integer.valueOf(var7.getid()));
/*      */     }
/*      */     
/*  953 */     return var5;
/*      */   }
/*      */   
/*      */ 
/*      */   public FighterAIOperator useNromalSkill(int var1, int var2)
/*      */   {
/*  959 */     Operator_UseSkill var3 = new Operator_UseSkill(var1, getNormalAttack(var1), 1, var2);
/*  960 */     return var3;
/*      */   }
/*      */   
/*      */   public FighterAIOperator useSkill(int var1, int var2, int var3, int var4) {
/*  964 */     Operator_UseSkill var5 = new Operator_UseSkill(var1, var2, var3, var4);
/*  965 */     return var5;
/*      */   }
/*      */   
/*      */   public boolean canUseSkill(int var1, int var2, int var3) {
/*  969 */     Fighter var4 = this.fight.getFighter(var1);
/*  970 */     if (var4 == null) {
/*  971 */       return false;
/*      */     }
/*  973 */     Skill var5 = SkillInterface.getSkill(var2, var3);
/*  974 */     if (var5 == null) {
/*  975 */       return false;
/*      */     }
/*  977 */     return var4.canChoiceSkill(var5);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getSkillTarget(int var1, int var2, int var3)
/*      */   {
/*  983 */     ArrayList var4 = new ArrayList();
/*  984 */     Skill var5 = SkillInterface.getSkill(var2, var3);
/*  985 */     if (var5 == null) {
/*  986 */       return var4;
/*      */     }
/*  988 */     Fighter var6 = this.fight.getFighter(var1);
/*  989 */     if (var6 == null) {
/*  990 */       return var4;
/*      */     }
/*  992 */     List var7 = var5.getScacleTarget(var6, -1);
/*  993 */     Iterator var8 = var7.iterator();
/*      */     
/*  995 */     while (var8.hasNext()) {
/*  996 */       Fighter var9 = (Fighter)var8.next();
/*  997 */       var4.add(Integer.valueOf(var9.fighterid));
/*      */     }
/*      */     
/* 1000 */     return var4;
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getSkillSet(int var1)
/*      */   {
/* 1006 */     Fighter var2 = this.fight.getFighter(var1);
/* 1007 */     return var2 == null ? new HashSet() : var2.getActiveSkills();
/*      */   }
/*      */   
/*      */   public Integer convertSkill(int var1, int var2) {
/* 1011 */     Fighter var3 = this.fight.getFighter(var1);
/* 1012 */     return Integer.valueOf(var3 == null ? var2 : var3.convertSkill(var2).intValue());
/*      */   }
/*      */   
/*      */   public FighterAIOperator defense(int var1) {
/* 1016 */     Operator_Defense var2 = new Operator_Defense(var1);
/* 1017 */     return var2;
/*      */   }
/*      */   
/*      */   public FighterAIOperator capture(int var1, int var2) {
/* 1021 */     Operator_Capture var3 = new Operator_Capture(var1, var2);
/* 1022 */     return var3;
/*      */   }
/*      */   
/*      */   public FighterAIOperator protect(int var1, int var2) {
/* 1026 */     Operator_Protect var3 = new Operator_Protect(var1, var2);
/* 1027 */     return var3;
/*      */   }
/*      */   
/*      */   public FighterAIOperator escape(int var1) {
/* 1031 */     Operator_Escape var2 = new Operator_Escape(var1, false, false);
/* 1032 */     return var2;
/*      */   }
/*      */   
/*      */   public FighterAIOperator escapeSuccess(int var1) {
/* 1036 */     Operator_Escape var2 = new Operator_Escape(var1, true, false);
/* 1037 */     return var2;
/*      */   }
/*      */   
/*      */   public void escapeImmediately(int var1) {
/* 1041 */     Operator_Escape var2 = new Operator_Escape(var1, true, true);
/* 1042 */     var2.excute(this.fight);
/*      */   }
/*      */   
/*      */   public FighterAIOperator useItem(int var1, int var2, int var3) {
/* 1046 */     Operator_UseItem var4 = new Operator_UseItem(var1, var2, var3);
/* 1047 */     return var4;
/*      */   }
/*      */   
/*      */   public FighterAIOperator summonFriendMonster(boolean var1, int var2, int var3, int... var4) {
/* 1051 */     Operator_SummonMonster var5 = new Operator_SummonMonster(var2, true, var3, var4, var1);
/* 1052 */     if (var1) {
/* 1053 */       var5.excute(this.fight);
/*      */     }
/*      */     
/* 1056 */     return var5;
/*      */   }
/*      */   
/*      */   public FighterAIOperator summonFriendMonsterFixPos(boolean var1, int var2, int var3, Map<Integer, List<Integer>> var4) {
/* 1060 */     Operator_SummonMonsterFixPosition var5 = new Operator_SummonMonsterFixPosition(var2, true, var3, var4, var1);
/* 1061 */     if (var1) {
/* 1062 */       var5.excute(this.fight);
/*      */     }
/*      */     
/* 1065 */     return var5;
/*      */   }
/*      */   
/*      */   public FighterAIOperator summonEnernyMonster(boolean var1, int var2, int var3, int... var4) {
/* 1069 */     Operator_SummonMonster var5 = new Operator_SummonMonster(var2, false, var3, var4, var1);
/* 1070 */     if (var1) {
/* 1071 */       var5.excute(this.fight);
/*      */     }
/*      */     
/* 1074 */     return var5;
/*      */   }
/*      */   
/*      */   public FighterAIOperator summonEnernyMonsterFixPos(boolean var1, int var2, int var3, Map<Integer, List<Integer>> var4) {
/* 1078 */     Operator_SummonMonsterFixPosition var5 = new Operator_SummonMonsterFixPosition(var2, false, var3, var4, var1);
/* 1079 */     if (var1) {
/* 1080 */       var5.excute(this.fight);
/*      */     }
/*      */     
/* 1083 */     return var5;
/*      */   }
/*      */   
/*      */   public FighterAIOperator summonPet(int var1, long var2) {
/* 1087 */     Operator_SummonPet var4 = new Operator_SummonPet(var1, var2);
/* 1088 */     return var4;
/*      */   }
/*      */   
/*      */   public FighterAIOperator summonChild(int var1, long var2) {
/* 1092 */     Operator_SummonChild var4 = new Operator_SummonChild(var1, var2);
/* 1093 */     return var4;
/*      */   }
/*      */   
/*      */   public FighterAIOperator addBuff(int var1, int var2) {
/* 1097 */     Operator_AddBuff var3 = new Operator_AddBuff(var1, var2);
/* 1098 */     return var3;
/*      */   }
/*      */   
/*      */   public void addBuffImmediately(int var1, int var2) {
/* 1102 */     Operator_AddBuff var3 = new Operator_AddBuff(var1, var2);
/* 1103 */     var3.excute(this.fight);
/*      */   }
/*      */   
/*      */   public FighterAIOperator remBuff(int var1, int var2) {
/* 1107 */     Operator_remBuff var3 = new Operator_remBuff(var1, var2);
/* 1108 */     return var3;
/*      */   }
/*      */   
/*      */   public boolean hasBuff(int var1, int var2) {
/* 1112 */     Fighter var3 = this.fight.getFighter(var1);
/* 1113 */     return var3 == null ? false : var3.hasBuff(var2);
/*      */   }
/*      */   
/*      */   public void remBuffImmediately(int var1, int var2) {
/* 1117 */     Operator_remBuff var3 = new Operator_remBuff(var1, var2);
/* 1118 */     var3.excute(this.fight);
/*      */   }
/*      */   
/*      */   public boolean enermyHasOutFightBuff(int var1, int var2) {
/* 1122 */     Fighter var3 = this.fight.getFighter(var1);
/* 1123 */     return var3 == null ? false : var3.enermyHasOutFightBuff(var2);
/*      */   }
/*      */   
/*      */   public boolean hasOutFightBuff(int var1, int var2) {
/* 1127 */     Fighter var3 = this.fight.getFighter(var1);
/* 1128 */     return var3 == null ? false : var3.hasOutFightBuff(var2);
/*      */   }
/*      */   
/*      */   public FighterAIOperator changeFighter(int var1, int var2, int var3, int var4) {
/* 1132 */     Operator_ChangeFighter var5 = new Operator_ChangeFighter(var1, var2, var3, var4);
/* 1133 */     return var5;
/*      */   }
/*      */   
/*      */   public void changeFighterImmediately(int var1, int var2, int var3, int var4) {
/* 1137 */     Operator_ChangeFighter var5 = new Operator_ChangeFighter(var1, var2, var3, var4);
/* 1138 */     var5.excute(this.fight);
/*      */   }
/*      */   
/*      */   public FighterAIOperator changeFighterModel(int var1, int var2) {
/* 1142 */     Operator_ChangeFighterModel var3 = new Operator_ChangeFighterModel(var1, var2);
/* 1143 */     return var3;
/*      */   }
/*      */   
/*      */   public void changeFighterModelImmediately(int var1, int var2) {
/* 1147 */     Operator_ChangeFighterModel var3 = new Operator_ChangeFighterModel(var1, var2);
/* 1148 */     var3.excute(this.fight);
/*      */   }
/*      */   
/*      */   public FighterAIOperator say(int var1, int var2, String... var3) {
/* 1152 */     Operator_Say var4 = new Operator_Say(var1, var2, var3);
/* 1153 */     return var4;
/*      */   }
/*      */   
/*      */   public void sayImmediately(int var1, int var2, String... var3) {
/* 1157 */     Operator_Say var4 = new Operator_Say(var1, var2, var3);
/* 1158 */     var4.excute(this.fight);
/*      */   }
/*      */   
/*      */   public void changeFightMapImmediately(int var1) {
/* 1162 */     Operator_ChangeFightMap var2 = new Operator_ChangeFightMap(var1);
/* 1163 */     var2.excute(this.fight);
/*      */   }
/*      */   
/*      */   public boolean isMonster(int var1) {
/* 1167 */     Fighter var2 = this.fight.getFighter(var1);
/* 1168 */     return var2 == null ? false : var2.isMonster();
/*      */   }
/*      */   
/*      */   public boolean isRole(int var1) {
/* 1172 */     Fighter var2 = this.fight.getFighter(var1);
/* 1173 */     if (var2 == null) {
/* 1174 */       return false;
/*      */     }
/* 1176 */     return (var2.isRole()) || (var2.isCloneRole());
/*      */   }
/*      */   
/*      */   public boolean isRealRole(int var1)
/*      */   {
/* 1181 */     Fighter var2 = this.fight.getFighter(var1);
/* 1182 */     return var2 == null ? false : var2.isRole();
/*      */   }
/*      */   
/*      */   public boolean isPet(int var1) {
/* 1186 */     Fighter var2 = this.fight.getFighter(var1);
/* 1187 */     return var2 == null ? false : var2.isPetType();
/*      */   }
/*      */   
/*      */   public boolean isFellow(int var1) {
/* 1191 */     Fighter var2 = this.fight.getFighter(var1);
/* 1192 */     return var2 == null ? false : var2.isFellowType();
/*      */   }
/*      */   
/*      */   public boolean isChild(int var1) {
/* 1196 */     Fighter var2 = this.fight.getFighter(var1);
/* 1197 */     return var2 == null ? false : var2.isChildType();
/*      */   }
/*      */   
/*      */   public boolean isAiObj(int var1) {
/* 1201 */     Fighter var2 = this.fight.getFighter(var1);
/* 1202 */     if (var2 == null)
/* 1203 */       return false;
/* 1204 */     if (var2.isClone()) {
/* 1205 */       return true;
/*      */     }
/* 1207 */     return (var2.isFellow()) || (var2.isMonster());
/*      */   }
/*      */   
/*      */   public String getName(int var1)
/*      */   {
/* 1212 */     Fighter var2 = this.fight.getFighter(var1);
/* 1213 */     return var2 == null ? "" : var2.getName();
/*      */   }
/*      */   
/*      */   public int getLevel(int var1) {
/* 1217 */     Fighter var2 = this.fight.getFighter(var1);
/* 1218 */     return var2 == null ? 0 : var2.getLevel();
/*      */   }
/*      */   
/*      */   public int getPosition(int var1) {
/* 1222 */     Fighter var2 = this.fight.getFighter(var1);
/* 1223 */     return var2 == null ? -1 : var2.getPos();
/*      */   }
/*      */   
/*      */   public int getFriendByPosition(int var1, int var2) {
/* 1227 */     Fighter var3 = this.fight.getFighter(var1);
/* 1228 */     if (var3 == null) {
/* 1229 */       return -1;
/*      */     }
/* 1231 */     Set var4 = var3.getFriendFighters();
/* 1232 */     Iterator var5 = var4.iterator();
/*      */     Fighter var6;
/*      */     do
/*      */     {
/* 1236 */       if (!var5.hasNext()) {
/* 1237 */         return -1;
/*      */       }
/*      */       
/* 1240 */       var6 = (Fighter)var5.next();
/* 1241 */     } while (var6.getPos() != var2);
/*      */     
/* 1243 */     return var6.getid();
/*      */   }
/*      */   
/*      */   public int getEnermyByPosition(int var1, int var2)
/*      */   {
/* 1248 */     Fighter var3 = this.fight.getFighter(var1);
/* 1249 */     if (var3 == null) {
/* 1250 */       return -1;
/*      */     }
/* 1252 */     Set var4 = var3.getEnermyLiveFighters();
/* 1253 */     Iterator var5 = var4.iterator();
/*      */     Fighter var6;
/*      */     do
/*      */     {
/* 1257 */       if (!var5.hasNext()) {
/* 1258 */         return -1;
/*      */       }
/*      */       
/* 1261 */       var6 = (Fighter)var5.next();
/* 1262 */     } while (var6.getPos() != var2);
/*      */     
/* 1264 */     return var6.getid();
/*      */   }
/*      */   
/*      */   public int getOccupation(int var1)
/*      */   {
/* 1269 */     Fighter var2 = this.fight.getFighter(var1);
/* 1270 */     return var2 == null ? -1 : var2.getOccupation();
/*      */   }
/*      */   
/*      */   public int getGender(int var1) {
/* 1274 */     Fighter var2 = this.fight.getFighter(var1);
/* 1275 */     return var2 == null ? -1 : var2.getGender();
/*      */   }
/*      */   
/*      */   public Set<Integer> getGuiWang() {
/* 1279 */     return getOccupationSet(1);
/*      */   }
/*      */   
/*      */   public Set<Integer> getQingYun() {
/* 1283 */     return getOccupationSet(2);
/*      */   }
/*      */   
/*      */   public Set<Integer> getTianYinSi() {
/* 1287 */     return getOccupationSet(3);
/*      */   }
/*      */   
/*      */   public Set<Integer> getFenXiang() {
/* 1291 */     return getOccupationSet(4);
/*      */   }
/*      */   
/*      */   public Set<Integer> getHeHuan() {
/* 1295 */     return getOccupationSet(5);
/*      */   }
/*      */   
/*      */   public Set<Integer> getShengWu() {
/* 1299 */     return getOccupationSet(6);
/*      */   }
/*      */   
/*      */   public Set<Integer> getCangYuGe() {
/* 1303 */     return getOccupationSet(7);
/*      */   }
/*      */   
/*      */   public Set<Integer> getLingYinDian() {
/* 1307 */     return getOccupationSet(8);
/*      */   }
/*      */   
/*      */   public Set<Integer> getYiNengZhe() {
/* 1311 */     return getOccupationSet(9);
/*      */   }
/*      */   
/*      */   public Set<Integer> getWanDuMen() {
/* 1315 */     return getOccupationSet(10);
/*      */   }
/*      */   
/*      */   public Set<Integer> getDanQingGe() {
/* 1319 */     return getOccupationSet(11);
/*      */   }
/*      */   
/*      */   public Set<Integer> getYinYangShi() {
/* 1323 */     return getOccupationSet(12);
/*      */   }
/*      */   
/*      */   private Set<Integer> getOccupationSet(int var1) {
/* 1327 */     HashSet var2 = new HashSet();
/* 1328 */     Set var3 = this.fight.getOccupationFighters(var1);
/* 1329 */     Iterator var4 = var3.iterator();
/*      */     
/* 1331 */     while (var4.hasNext()) {
/* 1332 */       Fighter var5 = (Fighter)var4.next();
/* 1333 */       var2.add(Integer.valueOf(var5.fighterid));
/*      */     }
/*      */     
/* 1336 */     return var2;
/*      */   }
/*      */   
/*      */   public int getMonsterid(int var1) {
/* 1340 */     Fighter var2 = this.fight.getFighter(var1);
/* 1341 */     return (var2 != null) && ((var2 instanceof FighterMonster)) ? ((FighterMonster)var2).getMonsterid() : -1;
/*      */   }
/*      */   
/*      */   public int getMonsterTypeid(int var1) {
/* 1345 */     Fighter var2 = this.fight.getFighter(var1);
/* 1346 */     if ((var2 != null) && ((var2 instanceof FighterMonster))) {
/* 1347 */       int var3 = ((FighterMonster)var2).getMonsterid();
/* 1348 */       return MonsterInterface.getMonsterTypeId(var3);
/*      */     }
/* 1350 */     return -1;
/*      */   }
/*      */   
/*      */   public int getSealNumLimit()
/*      */   {
/* 1355 */     SFightTypeCfg var1 = this.fight.getFightTypeCfg();
/* 1356 */     return var1.isSealLimit ? SFightConsts.getInstance().SEAL_NUM_MAX : Integer.MAX_VALUE;
/*      */   }
/*      */   
/*      */   public void setTeamVariable1(int var1, int var2) {
/* 1360 */     Fighter var3 = this.fight.getFighter(var1);
/* 1361 */     if (var3 != null) {
/* 1362 */       var3.fightGroup.fightTeam.setTeamAIVariable1(var2);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getTeamVariable1(int var1)
/*      */   {
/* 1368 */     Fighter var2 = this.fight.getFighter(var1);
/* 1369 */     return var2 != null ? var2.fightGroup.fightTeam.getTeamAIVariable1() : -1;
/*      */   }
/*      */   
/*      */   public void setTeamVariable2(int var1, int var2) {
/* 1373 */     Fighter var3 = this.fight.getFighter(var1);
/* 1374 */     if (var3 != null) {
/* 1375 */       var3.fightGroup.fightTeam.setTeamAIVariable2(var2);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getTeamVariable2(int var1)
/*      */   {
/* 1381 */     Fighter var2 = this.fight.getFighter(var1);
/* 1382 */     return var2 != null ? var2.fightGroup.fightTeam.getTeamAIVariable2() : -1;
/*      */   }
/*      */   
/*      */   public void setTeamVariable3(int var1, int var2) {
/* 1386 */     Fighter var3 = this.fight.getFighter(var1);
/* 1387 */     if (var3 != null) {
/* 1388 */       var3.fightGroup.fightTeam.setTeamAIVariable3(var2);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getTeamVariable3(int var1)
/*      */   {
/* 1394 */     Fighter var2 = this.fight.getFighter(var1);
/* 1395 */     return var2 != null ? var2.fightGroup.fightTeam.getTeamAIVariable3() : -1;
/*      */   }
/*      */   
/*      */   public void setTeamVariable4(int var1, int var2) {
/* 1399 */     Fighter var3 = this.fight.getFighter(var1);
/* 1400 */     if (var3 != null) {
/* 1401 */       var3.fightGroup.fightTeam.setTeamAIVariable4(var2);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getTeamVariable4(int var1)
/*      */   {
/* 1407 */     Fighter var2 = this.fight.getFighter(var1);
/* 1408 */     return var2 != null ? var2.fightGroup.fightTeam.getTeamAIVariable4() : -1;
/*      */   }
/*      */   
/*      */   public void setTeamVariable5(int var1, int var2) {
/* 1412 */     Fighter var3 = this.fight.getFighter(var1);
/* 1413 */     if (var3 != null) {
/* 1414 */       var3.fightGroup.fightTeam.setTeamAIVariable5(var2);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getTeamVariable5(int var1)
/*      */   {
/* 1420 */     Fighter var2 = this.fight.getFighter(var1);
/* 1421 */     return var2 != null ? var2.fightGroup.fightTeam.getTeamAIVariable5() : -1;
/*      */   }
/*      */   
/*      */   public void setTeamVariable6(int var1, int var2) {
/* 1425 */     Fighter var3 = this.fight.getFighter(var1);
/* 1426 */     if (var3 != null) {
/* 1427 */       var3.fightGroup.fightTeam.setTeamAIVariable6(var2);
/*      */     }
/*      */   }
/*      */   
/*      */   public int getTeamVariable6(int var1)
/*      */   {
/* 1433 */     Fighter var2 = this.fight.getFighter(var1);
/* 1434 */     return var2 != null ? var2.fightGroup.fightTeam.getTeamAIVariable6() : -1;
/*      */   }
/*      */   
/*      */   public AbstractAI.OperatorInfo getOperatorInfo(int var1) {
/* 1438 */     Fighter var2 = this.fight.getFighter(var1);
/* 1439 */     AbstractAI.OperatorInfo var3 = new AbstractAI.OperatorInfo();
/* 1440 */     if (var2 == null) {
/* 1441 */       return var3;
/*      */     }
/* 1443 */     FighterFellow var4 = null;
/* 1444 */     if ((var2 instanceof FighterFellow)) {
/* 1445 */       var4 = (FighterFellow)var2;
/*      */     }
/*      */     
/* 1448 */     List var5 = var2.fightGroup.fightTeam.getTeamRoleAndPetCmd();
/* 1449 */     Iterator var6 = var5.iterator();
/*      */     
/* 1451 */     while (var6.hasNext()) {
/* 1452 */       FightCmd var7 = (FightCmd)var6.next();
/* 1453 */       if (var7.getOp_type() == 2) {
/* 1454 */         OpCapture var8 = new OpCapture();
/* 1455 */         var7.getContent(var8);
/* 1456 */         AbstractAI.OperatorInfo.OperatorCapture var9 = new AbstractAI.OperatorInfo.OperatorCapture();
/* 1457 */         var9.releaserFid = var7.getFighterid();
/* 1458 */         var9.targetFid = var8.target;
/* 1459 */         var3.addOperatorCapture(var9);
/* 1460 */       } else if (var7.getOp_type() == 0) {
/* 1461 */         Op_UseSkill var10 = new Op_UseSkill();
/* 1462 */         var7.getContent(var10);
/* 1463 */         AbstractAI.OperatorInfo.OperatorSkill var12 = new AbstractAI.OperatorInfo.OperatorSkill();
/* 1464 */         var12.releaserFid = var7.getFighterid();
/* 1465 */         var12.skillid = var10.skill;
/* 1466 */         var12.skillLv = var10.skillLv;
/* 1467 */         var12.targetFid = var10.main_target;
/* 1468 */         var3.addOperatorSKill(var12);
/* 1469 */       } else if (var7.getOp_type() == 4) {
/* 1470 */         AbstractAI.OperatorInfo.OperatorEscape var11 = new AbstractAI.OperatorInfo.OperatorEscape();
/* 1471 */         var11.releaserFid = var7.getFighterid();
/* 1472 */         var11.isRole = isRealRole(var11.releaserFid);
/* 1473 */         Fighter var13 = this.fight.getFighter(var11.releaserFid);
/* 1474 */         if ((var13 != null) && (var4 != null)) {
/* 1475 */           var11.isMine = var4.isMyOwner(var13);
/*      */         }
/*      */         
/* 1478 */         var3.addOperatorEscape(var11);
/*      */       }
/*      */     }
/*      */     
/* 1482 */     return var3;
/*      */   }
/*      */   
/*      */   public int getDiffcultType()
/*      */   {
/* 1487 */     return this.fight.getDiffcultType();
/*      */   }
/*      */   
/*      */   public int getDisType() {
/* 1491 */     return this.fight.getCfgType();
/*      */   }
/*      */   
/*      */   public boolean enermyHasNewer(int var1) {
/* 1495 */     Fighter var2 = this.fight.getFighter(var1);
/* 1496 */     if (var2 == null) {
/* 1497 */       return false;
/*      */     }
/* 1499 */     int var3 = 0;
/* 1500 */     int var4 = 0;
/* 1501 */     Iterator var5 = var2.getEnermyFighters().iterator();
/*      */     
/* 1503 */     while (var5.hasNext()) {
/* 1504 */       Fighter var6 = (Fighter)var5.next();
/* 1505 */       int var7 = var6.getLevel();
/* 1506 */       if (var7 > var3) {
/* 1507 */         var3 = var7;
/*      */       }
/*      */       
/* 1510 */       if (var4 == 0) {
/* 1511 */         var4 = var7;
/* 1512 */       } else if (var7 < var4) {
/* 1513 */         var4 = var7;
/*      */       }
/*      */     }
/*      */     
/* 1517 */     return var3 - var4 >= TeamMatchInterface.getNewGuyLevelDiff();
/*      */   }
/*      */   
/*      */   public boolean friendHasNewer(int var1)
/*      */   {
/* 1522 */     Fighter var2 = this.fight.getFighter(var1);
/* 1523 */     if (var2 == null) {
/* 1524 */       return false;
/*      */     }
/* 1526 */     int var3 = 0;
/* 1527 */     int var4 = 0;
/* 1528 */     Iterator var5 = var2.getFriendFighters().iterator();
/*      */     
/* 1530 */     while (var5.hasNext()) {
/* 1531 */       Fighter var6 = (Fighter)var5.next();
/* 1532 */       int var7 = var6.getLevel();
/* 1533 */       if (var7 > var3) {
/* 1534 */         var3 = var7;
/*      */       }
/*      */       
/* 1537 */       if (var4 == 0) {
/* 1538 */         var4 = var7;
/* 1539 */       } else if (var7 < var4) {
/* 1540 */         var4 = var7;
/*      */       }
/*      */     }
/*      */     
/* 1544 */     return var3 - var4 >= TeamMatchInterface.getNewGuyLevelDiff();
/*      */   }
/*      */   
/*      */   public int getSkillLv(int var1, int var2)
/*      */   {
/* 1549 */     Fighter var3 = this.fight.getFighter(var1);
/* 1550 */     return var3 == null ? 1 : var3.getSkillLevel(var2);
/*      */   }
/*      */   
/*      */   public Set<Integer> getFriendAiOperateFighters(int var1) {
/* 1554 */     return this.fight.getFriendAiOperateFighters(var1);
/*      */   }
/*      */   
/*      */   public boolean isFightAiTianYinOpen() {
/* 1558 */     return OpenInterface.getOpenStatus(242);
/*      */   }
/*      */   
/*      */   public int getNormalAttack(int var1) {
/* 1562 */     int var2 = getOccupation(var1);
/* 1563 */     return FightManager.getNormalAttack(var2);
/*      */   }
/*      */   
/*      */   public static class AITeamVariable {
/* 1567 */     public int var1 = -1;
/* 1568 */     public int var2 = -1;
/* 1569 */     public int var3 = -1;
/* 1570 */     public int var4 = -1;
/* 1571 */     public int var5 = -1;
/* 1572 */     public int var6 = -1;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightInfo1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */