/*     */ package mzm.gsp.fight.ai.util;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.main.FightInfo;
/*     */ import mzm.gsp.fight.main.FighterAIOperator;
/*     */ 
/*     */ public abstract class GroupAI
/*     */   extends AbstractAI
/*     */ {
/*  13 */   private Set<Integer> set = new HashSet(4);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init(FightInfo fightInfo, Set<Integer> set)
/*     */   {
/*  20 */     this.set = set;
/*  21 */     super.init(fightInfo);
/*     */   }
/*     */   
/*     */   public List<FighterAIOperator> getAiOperators() {
/*  25 */     return this.m_operators;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getSelfFidSet()
/*     */   {
/*  34 */     return new HashSet(this.set);
/*     */   }
/*     */   
/*     */   private int getGroupFirstid() {
/*  38 */     int fid = -1;
/*  39 */     Iterator i$ = this.set.iterator(); if (i$.hasNext()) { int fighterid = ((Integer)i$.next()).intValue();
/*  40 */       fid = fighterid;
/*     */     }
/*     */     
/*  43 */     return fid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getEnemies()
/*     */   {
/*  52 */     int fid = getGroupFirstid();
/*  53 */     return super.getEnemies(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getFriends()
/*     */   {
/*  62 */     int fid = getGroupFirstid();
/*  63 */     return super.getFriends(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getAliveEnemies()
/*     */   {
/*  72 */     int fid = getGroupFirstid();
/*  73 */     return super.getAliveEnemies(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Integer> getAliveFriends()
/*     */   {
/*  82 */     int fid = getGroupFirstid();
/*  83 */     return super.getAliveFriends(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int randAliveEnemies()
/*     */   {
/*  92 */     int fid = getGroupFirstid();
/*  93 */     return super.randAliveEnemies(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int randAliveFriends()
/*     */   {
/* 102 */     int fid = getGroupFirstid();
/* 103 */     return super.randAliveFriends(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemyHpRemainMin()
/*     */   {
/* 112 */     int fid = getGroupFirstid();
/* 113 */     return super.getEnemyHpRemainMin(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemyHpRemainMax()
/*     */   {
/* 122 */     int fid = getGroupFirstid();
/* 123 */     return super.getEnemyHpRemainMax(fid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendHpGreater(int order)
/*     */   {
/* 134 */     int fid = getGroupFirstid();
/* 135 */     return super.getFriendHpGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendHpRateGreater(int order)
/*     */   {
/* 146 */     int fid = getGroupFirstid();
/* 147 */     return super.getFriendHpGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendMpGreater(int order)
/*     */   {
/* 158 */     int fid = getGroupFirstid();
/* 159 */     return super.getFriendMpGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendMpRateGreater(int order)
/*     */   {
/* 170 */     int fid = getGroupFirstid();
/* 171 */     return super.getFriendMpRateGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemyHpGreater(int order)
/*     */   {
/* 182 */     int fid = getGroupFirstid();
/* 183 */     return super.getEnemyHpGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemyHpRateGreater(int order)
/*     */   {
/* 194 */     int fid = getGroupFirstid();
/* 195 */     return super.getEnemyHpRateGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemyMpGreater(int order)
/*     */   {
/* 206 */     int fid = getGroupFirstid();
/* 207 */     return super.getEnemyMpGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemyMpRateGreater(int order)
/*     */   {
/* 218 */     int fid = getGroupFirstid();
/* 219 */     return super.getEnemyMpRateGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendSpeedGreater(int order)
/*     */   {
/* 230 */     int fid = getGroupFirstid();
/* 231 */     return super.getFriendSpeedGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemySpeedGreater(int order)
/*     */   {
/* 242 */     int fid = getGroupFirstid();
/* 243 */     return super.getEnemySpeedGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getFriendPhyAtkGreater(int order)
/*     */   {
/* 254 */     int fid = getGroupFirstid();
/* 255 */     return super.getFriendPhyAtkGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getEnemyPhyAtkGreater(int order)
/*     */   {
/* 266 */     int fid = getGroupFirstid();
/* 267 */     return super.getEnemyPhyAtkGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getFriendPhyDefGreater(int order)
/*     */   {
/* 278 */     int fid = getGroupFirstid();
/* 279 */     return super.getFriendPhyDefGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getEnemyPhyDefGreater(int order)
/*     */   {
/* 290 */     int fid = getGroupFirstid();
/* 291 */     return super.getEnemyPhyDefGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getFriendMGCAtkGreater(int order)
/*     */   {
/* 302 */     int fid = getGroupFirstid();
/* 303 */     return super.getFriendMGCAtkGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getEnemyMGCAtkGreater(int order)
/*     */   {
/* 314 */     int fid = getGroupFirstid();
/* 315 */     return super.getEnemyMGCAtkGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getFriendMGCDefGreater(int order)
/*     */   {
/* 326 */     int fid = getGroupFirstid();
/* 327 */     return super.getFriendMGCDefGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int getEnemyMGCDefGreater(int order)
/*     */   {
/* 338 */     int fid = getGroupFirstid();
/* 339 */     return super.getEnemyMGCDefGreater(fid, order);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendByPosition(int position)
/*     */   {
/* 350 */     int fid = getGroupFirstid();
/* 351 */     return super.getFriendByPosition(fid, position);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnermyByPosition(int position)
/*     */   {
/* 362 */     int fid = getGroupFirstid();
/* 363 */     return super.getEnermyByPosition(fid, position);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendNum()
/*     */   {
/* 372 */     int fid = getGroupFirstid();
/* 373 */     return super.getFriends(fid).size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFriendAliveNum()
/*     */   {
/* 382 */     int fid = getGroupFirstid();
/* 383 */     return super.getAliveFriends(fid).size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemiesNum()
/*     */   {
/* 392 */     int fid = getGroupFirstid();
/* 393 */     return super.getEnemies(fid).size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getEnemiesAliveNum()
/*     */   {
/* 402 */     int fid = getGroupFirstid();
/* 403 */     return super.getAliveEnemies(fid).size();
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
/*     */   public void useNromalAttack(int fid, int tfid)
/*     */   {
/* 445 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 446 */       super.useNromalAttack(fid, tfid);
/*     */     }
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
/*     */   public void useSkill(int fid, int skillid, int skillLV, int tfid)
/*     */   {
/* 464 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 465 */       super.useSkill(fid, skillid, skillLV, tfid);
/*     */     }
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
/*     */   public void useSkill(int fid, int skillid, int tfid)
/*     */   {
/* 480 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 481 */       super.useSkill(fid, skillid, getLevel(fid), tfid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void useSkill(int fid, int skillid)
/*     */   {
/* 494 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 495 */       super.useSkill(fid, skillid, -1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void defense(int fid)
/*     */   {
/* 506 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 507 */       super.defense(fid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void protect(int fid, int tfid)
/*     */   {
/* 520 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 521 */       super.protect(fid, tfid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void escape(int fid)
/*     */   {
/* 532 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 533 */       super.escape(fid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void escapeSuccess(int fid)
/*     */   {
/* 544 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 545 */       super.escapeSuccess(fid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void escapeImmediately(int fid)
/*     */   {
/* 556 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 557 */       super.escapeImmediately(fid);
/*     */     }
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
/*     */   public void useItem(int fid, int itemcfgid, int tfid)
/*     */   {
/* 572 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 573 */       super.useItem(fid, itemcfgid, tfid);
/*     */     }
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
/*     */   public void summonFriendMonster(int fid, int level, int... monsterids)
/*     */   {
/* 588 */     super.summonFriendMonster(fid, level, monsterids);
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
/*     */   public void summonFriendMonsterImmediately(int fid, int level, int... monsterids)
/*     */   {
/* 602 */     super.summonFriendMonsterImmediately(fid, level, monsterids);
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
/*     */   public void summonEnernyMonster(int fid, int level, int... monsterids)
/*     */   {
/* 616 */     super.summonEnernyMonster(fid, level, monsterids);
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
/*     */   public void summonEnernyMonsterImmediately(int fid, int level, int... monsterids)
/*     */   {
/* 630 */     super.summonEnernyMonsterImmediately(fid, level, monsterids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void defaultOperator(int fid)
/*     */   {
/* 640 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 641 */       super.defaultOperator(fid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addBuff(int fid, int effectGroupid)
/*     */   {
/* 654 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 655 */       FighterAIOperator operator = this.fightInfo.addBuff(fid, effectGroupid);
/* 656 */       this.m_operators.add(operator);
/*     */     }
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
/*     */   public void addBuffImmediately(int fid, int effectGroupid)
/*     */   {
/* 670 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 671 */       this.fightInfo.addBuffImmediately(fid, effectGroupid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remBuff(int fid, int effectGroupid)
/*     */   {
/* 683 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 684 */       FighterAIOperator operator = this.fightInfo.remBuff(fid, effectGroupid);
/* 685 */       this.m_operators.add(operator);
/*     */     }
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
/*     */   public void remBuffImmediately(int fid, int effectGroupid)
/*     */   {
/* 699 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 700 */       this.fightInfo.remBuffImmediately(fid, effectGroupid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean enermyHasOutFightBuff(int outFightBuffid)
/*     */   {
/* 709 */     return this.fightInfo.enermyHasOutFightBuff(getGroupFirstid(), outFightBuffid);
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
/*     */   public void changeFighter(int fid, int monsterid, int level)
/*     */   {
/* 723 */     changeFighter(fid, monsterid, level, 0);
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
/*     */   public void changeFighter(int fid, int monsterid, int level, int hpRate)
/*     */   {
/* 739 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 740 */       FighterAIOperator operator = this.fightInfo.changeFighter(fid, monsterid, level, hpRate);
/* 741 */       this.m_operators.add(operator);
/*     */     }
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
/*     */   public void changeFighterImmediately(int fid, int monsterid, int level)
/*     */   {
/* 756 */     this.fightInfo.changeFighterImmediately(fid, monsterid, level, 0);
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
/*     */   public void changeFighterImmediately(int fid, int monsterid, int level, int hpRate)
/*     */   {
/* 772 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 773 */       this.fightInfo.changeFighterImmediately(fid, monsterid, level, hpRate);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void changeFighterModel(int fid, int monsterid)
/*     */   {
/* 784 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 785 */       FighterAIOperator operator = this.fightInfo.changeFighterModel(fid, monsterid);
/* 786 */       this.m_operators.add(operator);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void changeFighterModelImmediately(int fid, int monsterid)
/*     */   {
/* 798 */     if (this.set.contains(Integer.valueOf(fid))) {
/* 799 */       this.fightInfo.changeFighterModelImmediately(fid, monsterid);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\ai\util\GroupAI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */