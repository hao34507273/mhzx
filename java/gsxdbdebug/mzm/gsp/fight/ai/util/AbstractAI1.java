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
/*      */ public abstract class AbstractAI
/*      */   implements AI
/*      */ {
/*      */   protected FightInfo fightInfo;
/*   20 */   List<FighterAIOperator> m_operators = new ArrayList(1);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void init(FightInfo fightInfo)
/*      */   {
/*   27 */     this.fightInfo = fightInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getRound()
/*      */   {
/*   36 */     return this.fightInfo.getRound();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getEnemies(int fid)
/*      */   {
/*   45 */     return this.fightInfo.getEnemies(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getFriends(int fid)
/*      */   {
/*   54 */     return this.fightInfo.getFriends(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getAliveEnemies(int fid)
/*      */   {
/*   63 */     return this.fightInfo.getAliveEnemies(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getAliveFriends(int fid)
/*      */   {
/*   72 */     return this.fightInfo.getAliveFriends(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int randAliveEnemies(int fid)
/*      */   {
/*   81 */     return this.fightInfo.randAliveEnemies(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int randAliveFriends(int fid)
/*      */   {
/*   90 */     return this.fightInfo.randAliveFriends(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyHpRemainMin(int fid)
/*      */   {
/*   99 */     return this.fightInfo.getEnemyHpRemainMin(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyHpRemainMax(int fid)
/*      */   {
/*  108 */     return this.fightInfo.getEnemyHpRemainMax(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getTargetHp(int tfid)
/*      */   {
/*  119 */     return this.fightInfo.getTargetHp(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getTargetMp(int tfid)
/*      */   {
/*  130 */     return this.fightInfo.getTargetMp(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnergy(int tfid)
/*      */   {
/*  140 */     return this.fightInfo.getEnergy(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getSpeed(int tfid)
/*      */   {
/*  150 */     return this.fightInfo.getSpeed(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getTargetHpRate(int tfid)
/*      */   {
/*  161 */     return this.fightInfo.getTargetHpRate(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getTargetMpRate(int tfid)
/*      */   {
/*  172 */     return this.fightInfo.getTargetMpRate(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getAnger(int tfid)
/*      */   {
/*  183 */     return this.fightInfo.getAnger(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isDead(int tfid)
/*      */   {
/*  194 */     return this.fightInfo.isDead(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isRealDead(int tfid)
/*      */   {
/*  205 */     return this.fightInfo.isRealDead(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isFakeDead(int tfid)
/*      */   {
/*  216 */     return this.fightInfo.isFakeDead(tfid);
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
/*      */   protected boolean hasBuffState(int tfid, int buffState)
/*      */   {
/*  229 */     return this.fightInfo.hasBuffState(tfid, buffState);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isInvisiable(int tfid)
/*      */   {
/*  240 */     return this.fightInfo.isInvisiable(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isVisiable(int tfid)
/*      */   {
/*  251 */     return this.fightInfo.isVisiable(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isStone(int tfid)
/*      */   {
/*  262 */     return this.fightInfo.isStone(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isNotBeHealed(int tfid)
/*      */   {
/*  272 */     return this.fightInfo.isNotBeHealed(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSleep(int tfid)
/*      */   {
/*  283 */     return this.fightInfo.isSleep(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isRest(int tfid)
/*      */   {
/*  294 */     return this.fightInfo.isRest(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isWeak(int tfid)
/*      */   {
/*  305 */     return this.fightInfo.isWeak(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isMess(int tfid)
/*      */   {
/*  316 */     return this.fightInfo.isMess(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isFear(int tfid)
/*      */   {
/*  326 */     return this.fightInfo.isFear(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isGhost(int tfid)
/*      */   {
/*  337 */     return this.fightInfo.isGhost(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSealPhy(int tfid)
/*      */   {
/*  347 */     return this.fightInfo.isSealPhy(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSealMgc(int tfid)
/*      */   {
/*  358 */     return this.fightInfo.isSealMgc(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean isSealSpecial(int tfid)
/*      */   {
/*  369 */     return this.fightInfo.isSealSpecial(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean isSealNormal(int tfid)
/*      */   {
/*  380 */     return this.fightInfo.isSealNormal(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected final boolean isSealDefence(int tfid)
/*      */   {
/*  391 */     return this.fightInfo.isSealDefence(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSealEscape(int tfid)
/*      */   {
/*  402 */     return this.fightInfo.isSealEscape(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSealProtect(int tfid)
/*      */   {
/*  413 */     return this.fightInfo.isSealProtect(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSealSummon(int tfid)
/*      */   {
/*  424 */     return this.fightInfo.isSealSummon(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSealed(int tfid)
/*      */   {
/*  434 */     return this.fightInfo.isSealed(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isNegetive(int tfid)
/*      */   {
/*  444 */     return this.fightInfo.isNegetive(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isPositive(int tfid)
/*      */   {
/*  454 */     return this.fightInfo.isPositive(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isPoison(int tfid)
/*      */   {
/*  464 */     return this.fightInfo.isPoison(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean canSummon(int tfid)
/*      */   {
/*  475 */     return this.fightInfo.canSummon(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendHpGreater(int fid, int order)
/*      */   {
/*  486 */     return this.fightInfo.getFriendHpGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendHpRateGreater(int fid, int order)
/*      */   {
/*  497 */     return this.fightInfo.getFriendHpGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendMpGreater(int fid, int order)
/*      */   {
/*  508 */     return this.fightInfo.getFriendMpGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendMpRateGreater(int fid, int order)
/*      */   {
/*  519 */     return this.fightInfo.getFriendMpRateGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyHpGreater(int fid, int order)
/*      */   {
/*  530 */     return this.fightInfo.getEnemyHpGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyHpRateGreater(int fid, int order)
/*      */   {
/*  541 */     return this.fightInfo.getEnemyHpRateGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyMpGreater(int fid, int order)
/*      */   {
/*  552 */     return this.fightInfo.getEnemyMpGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyMpRateGreater(int fid, int order)
/*      */   {
/*  563 */     return this.fightInfo.getEnemyMpRateGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendSpeedGreater(int fid, int order)
/*      */   {
/*  574 */     return this.fightInfo.getFriendSpeedGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemySpeedGreater(int fid, int order)
/*      */   {
/*  585 */     return this.fightInfo.getEnemySpeedGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendPhyAtkGreater(int fid, int order)
/*      */   {
/*  596 */     return this.fightInfo.getFriendPhyAtkGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyPhyAtkGreater(int fid, int order)
/*      */   {
/*  607 */     return this.fightInfo.getEnermyPhyAtkGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendPhyDefGreater(int fid, int order)
/*      */   {
/*  618 */     return this.fightInfo.getFriendPhyDefGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyPhyDefGreater(int fid, int order)
/*      */   {
/*  629 */     return this.fightInfo.getEnermyPhyDefGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendMGCAtkGreater(int fid, int order)
/*      */   {
/*  640 */     return this.fightInfo.getFriendMGCAtkGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyMGCAtkGreater(int fid, int order)
/*      */   {
/*  651 */     return this.fightInfo.getEnermyMGCAtkGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendMGCDefGreater(int fid, int order)
/*      */   {
/*  662 */     return this.fightInfo.getFriendMGCDefGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemyMGCDefGreater(int fid, int order)
/*      */   {
/*  673 */     return this.fightInfo.getEnermyMGCDefGreater(fid, order);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected List<Integer> getFriendSpeedOrders(int tfid)
/*      */   {
/*  684 */     return this.fightInfo.getFriendSpeedOrders(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getFriendByPosition(int tfid, int position)
/*      */   {
/*  695 */     return this.fightInfo.getFriendByPosition(tfid, position);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getEnermyByPosition(int tfid, int position)
/*      */   {
/*  706 */     return this.fightInfo.getEnermyByPosition(tfid, position);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendNum(int fid)
/*      */   {
/*  715 */     return this.fightInfo.getFriends(fid).size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getFriendAliveNum(int fid)
/*      */   {
/*  724 */     return this.fightInfo.getAliveFriends(fid).size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemiesNum(int fid)
/*      */   {
/*  733 */     return this.fightInfo.getEnemies(fid).size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getEnemiesAliveNum(int fid)
/*      */   {
/*  742 */     return this.fightInfo.getAliveEnemies(fid).size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void useNromalAttack(int fid, int tfid)
/*      */   {
/*  754 */     FighterAIOperator aiOperator = this.fightInfo.useNromalSkill(fid, tfid);
/*  755 */     this.m_operators.add(aiOperator);
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
/*      */   void useSkill(int fid, int skillid, int skillLV, int tfid)
/*      */   {
/*  771 */     FighterAIOperator operator_UseSkill = this.fightInfo.useSkill(fid, skillid, skillLV, tfid);
/*  772 */     this.m_operators.add(operator_UseSkill);
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
/*      */   protected boolean canFighterUseSkill(int fid, int skillid, int skillLV)
/*      */   {
/*  787 */     return this.fightInfo.canUseSkill(fid, skillid, skillLV);
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
/*      */   protected void useSkill(int fid, int skillid, int tfid)
/*      */   {
/*  812 */     FighterAIOperator operator_UseSkill = this.fightInfo.useSkill(fid, skillid, this.fightInfo.getLevel(fid), tfid);
/*  813 */     this.m_operators.add(operator_UseSkill);
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
/*      */   protected boolean canFighterUseSkill(int fid, int skillid)
/*      */   {
/*  826 */     return this.fightInfo.canUseSkill(fid, skillid, this.fightInfo.getLevel(fid));
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
/*      */   protected List<Integer> getSkillTarget(int fid, int skillid, int skillLv)
/*      */   {
/*  841 */     return this.fightInfo.getSkillTarget(fid, skillid, skillLv);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getCanUseSkillSet(int fid)
/*      */   {
/*  852 */     Set<Integer> skillSet = this.fightInfo.getSkillSet(fid);
/*  853 */     Iterator<Integer> skillIterator = skillSet.iterator();
/*  854 */     while (skillIterator.hasNext()) {
/*  855 */       int skillid = ((Integer)skillIterator.next()).intValue();
/*  856 */       if (!canFighterUseSkill(fid, skillid, this.fightInfo.getLevel(fid))) {
/*  857 */         skillIterator.remove();
/*      */       }
/*      */     }
/*  860 */     return skillSet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTeamVariable1(int tfid, int variable1)
/*      */   {
/*  870 */     this.fightInfo.setTeamVariable1(tfid, variable1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTeamVariable1(int tfid)
/*      */   {
/*  880 */     return this.fightInfo.getTeamVariable1(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTeamVariable2(int tfid, int variable2)
/*      */   {
/*  890 */     this.fightInfo.setTeamVariable2(tfid, variable2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTeamVariable2(int tfid)
/*      */   {
/*  899 */     return this.fightInfo.getTeamVariable2(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTeamVariable3(int tfid, int variable3)
/*      */   {
/*  909 */     this.fightInfo.setTeamVariable3(tfid, variable3);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTeamVariable3(int tfid)
/*      */   {
/*  918 */     return this.fightInfo.getTeamVariable3(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTeamVariable4(int tfid, int variable4)
/*      */   {
/*  928 */     this.fightInfo.setTeamVariable4(tfid, variable4);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTeamVariable4(int tfid)
/*      */   {
/*  937 */     return this.fightInfo.getTeamVariable4(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTeamVariable5(int tfid, int variable5)
/*      */   {
/*  947 */     this.fightInfo.setTeamVariable5(tfid, variable5);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTeamVariable5(int tfid)
/*      */   {
/*  956 */     return this.fightInfo.getTeamVariable5(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setTeamVariable6(int tfid, int variable6)
/*      */   {
/*  966 */     this.fightInfo.setTeamVariable6(tfid, variable6);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getTeamVariable6(int tfid)
/*      */   {
/*  975 */     return this.fightInfo.getTeamVariable6(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void defense(int fid)
/*      */   {
/*  985 */     FighterAIOperator operator = this.fightInfo.defense(fid);
/*  986 */     this.m_operators.add(operator);
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
/*      */   void protect(int fid, int tfid)
/*      */   {
/* 1028 */     FighterAIOperator operator = this.fightInfo.protect(fid, tfid);
/* 1029 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void escape(int fid)
/*      */   {
/* 1039 */     FighterAIOperator operator = this.fightInfo.escape(fid);
/* 1040 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void escapeSuccess(int fid)
/*      */   {
/* 1050 */     FighterAIOperator operator = this.fightInfo.escapeSuccess(fid);
/* 1051 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void escapeImmediately(int fid)
/*      */   {
/* 1061 */     this.fightInfo.escapeImmediately(fid);
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
/*      */   void useItem(int fid, int itemcfgid, int tfid)
/*      */   {
/* 1075 */     FighterAIOperator operator = this.fightInfo.useItem(fid, itemcfgid, tfid);
/* 1076 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void summonFriendMonster(int fid, int level, int... monsterids)
/*      */   {
/* 1088 */     FighterAIOperator operator = this.fightInfo.summonFriendMonster(false, fid, level, monsterids);
/* 1089 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void summonFriendMonsterImmediately(int fid, int level, int... monsterids)
/*      */   {
/* 1101 */     this.fightInfo.summonFriendMonster(true, fid, level, monsterids);
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
/*      */   protected void summonFriendMonsterFixPos(int fid, int level, int monsterid, int position)
/*      */   {
/* 1117 */     Map<Integer, List<Integer>> monsteridToPosMap = new HashMap();
/* 1118 */     List<Integer> pos = new ArrayList();
/* 1119 */     pos.add(Integer.valueOf(position));
/* 1120 */     monsteridToPosMap.put(Integer.valueOf(monsterid), pos);
/* 1121 */     FighterAIOperator operator = this.fightInfo.summonFriendMonsterFixPos(false, fid, level, monsteridToPosMap);
/* 1122 */     this.m_operators.add(operator);
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
/*      */   protected void summonFriendMonsterFixPos(int fid, int level, Map<Integer, List<Integer>> monsteridToPositionMap)
/*      */   {
/* 1136 */     FighterAIOperator operator = this.fightInfo.summonFriendMonsterFixPos(false, fid, level, monsteridToPositionMap);
/* 1137 */     this.m_operators.add(operator);
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
/*      */   protected void summonFriendMonsterFixPosImmediately(int fid, int level, int monsterid, int position)
/*      */   {
/* 1153 */     Map<Integer, List<Integer>> monsteridToPosMap = new HashMap();
/* 1154 */     List<Integer> posList = new ArrayList();
/* 1155 */     posList.add(Integer.valueOf(position));
/* 1156 */     monsteridToPosMap.put(Integer.valueOf(monsterid), posList);
/* 1157 */     this.fightInfo.summonFriendMonsterFixPos(true, fid, level, monsteridToPosMap);
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
/*      */   protected void summonFriendMonsterFixPosImmediately(int fid, int level, Map<Integer, List<Integer>> monsteridToPositionMap)
/*      */   {
/* 1172 */     this.fightInfo.summonFriendMonsterFixPos(true, fid, level, monsteridToPositionMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void summonEnernyMonster(int fid, int level, int... monsterids)
/*      */   {
/* 1184 */     FighterAIOperator operator = this.fightInfo.summonEnernyMonster(false, fid, level, monsterids);
/* 1185 */     this.m_operators.add(operator);
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
/*      */   protected void summonEnernyMonsterFixPos(int fid, int level, int monsterid, int pos)
/*      */   {
/* 1201 */     Map<Integer, List<Integer>> monsteridToPosMap = new HashMap();
/* 1202 */     List<Integer> positions = new ArrayList();
/* 1203 */     positions.add(Integer.valueOf(pos));
/* 1204 */     monsteridToPosMap.put(Integer.valueOf(monsterid), positions);
/* 1205 */     FighterAIOperator operator = this.fightInfo.summonEnernyMonsterFixPos(false, fid, level, monsteridToPosMap);
/* 1206 */     this.m_operators.add(operator);
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
/*      */   protected void summonEnernyMonsterFixPos(int fid, int level, Map<Integer, List<Integer>> monsteridToPosMap)
/*      */   {
/* 1220 */     FighterAIOperator operator = this.fightInfo.summonEnernyMonsterFixPos(false, fid, level, monsteridToPosMap);
/* 1221 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void summonEnernyMonsterImmediately(int fid, int level, int... monsterids)
/*      */   {
/* 1233 */     this.fightInfo.summonEnernyMonster(true, fid, level, monsterids);
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
/*      */   protected void summonEnermyMonsterFixPosImmediately(int fid, int level, int monsterid, int pos)
/*      */   {
/* 1249 */     Map<Integer, List<Integer>> monsteridToPosMap = new HashMap();
/* 1250 */     List<Integer> positions = new ArrayList();
/* 1251 */     positions.add(Integer.valueOf(pos));
/* 1252 */     monsteridToPosMap.put(Integer.valueOf(monsterid), positions);
/* 1253 */     this.fightInfo.summonEnernyMonsterFixPos(true, fid, level, monsteridToPosMap);
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
/*      */   protected void summonEnermyMonsterFixPosImmediately(int fid, int level, Map<Integer, List<Integer>> monsteridToPosMap)
/*      */   {
/* 1268 */     this.fightInfo.summonEnernyMonsterFixPos(true, fid, level, monsteridToPosMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void defaultOperator(int fid)
/*      */   {
/* 1278 */     Set<Integer> set = getCanUseSkillSet(fid);
/* 1279 */     defaultOperator(fid, set);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void defaultOperator(int fid, Set<Integer> skillids)
/*      */   {
/* 1291 */     if (skillids == null) {
/* 1292 */       useNromalAttack(fid, randAliveEnemies(fid));
/* 1293 */       return;
/*      */     }
/* 1295 */     int skillLv = getLevel(fid);
/* 1296 */     Iterator<Integer> iter = skillids.iterator();
/* 1297 */     while (iter.hasNext()) {
/* 1298 */       int skillid = ((Integer)iter.next()).intValue();
/* 1299 */       if (!this.fightInfo.canUseSkill(fid, skillid, skillLv)) {
/* 1300 */         iter.remove();
/*      */       }
/*      */     }
/* 1303 */     int skillid = this.fightInfo.getNormalAttack(fid);
/* 1304 */     if (skillids.size() > 0) {
/* 1305 */       skillid = randomFromSet(skillids);
/*      */     }
/* 1307 */     List<Integer> targetSet = getSkillTarget(fid, skillid, skillLv);
/* 1308 */     int tfid = 0;
/* 1309 */     if (targetSet.size() > 0) {
/* 1310 */       tfid = ((Integer)targetSet.get(0)).intValue();
/*      */     }
/* 1312 */     useSkill(fid, skillid, skillLv, tfid);
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
/*      */   protected void defaultOperator(int fid, Set<Integer> skillids, int tfid)
/*      */   {
/* 1326 */     if (skillids == null) {
/* 1327 */       useNromalAttack(fid, randAliveEnemies(fid));
/* 1328 */       return;
/*      */     }
/* 1330 */     int skillLv = getLevel(fid);
/* 1331 */     Iterator<Integer> iter = skillids.iterator();
/* 1332 */     while (iter.hasNext()) {
/* 1333 */       int skillid = ((Integer)iter.next()).intValue();
/* 1334 */       if (!this.fightInfo.canUseSkill(fid, skillid, skillLv)) {
/* 1335 */         iter.remove();
/*      */       }
/*      */     }
/* 1338 */     int skillid = this.fightInfo.getNormalAttack(fid);
/* 1339 */     if (skillids.size() > 0) {
/* 1340 */       skillid = randomFromSet(skillids);
/*      */     }
/* 1342 */     useSkill(fid, skillid, skillLv, tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addBuff(int tfid, int effectGroupid)
/*      */   {
/* 1354 */     FighterAIOperator operator = this.fightInfo.addBuff(tfid, effectGroupid);
/* 1355 */     this.m_operators.add(operator);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void addBuffImmediately(int tfid, int effectGroupid)
/*      */   {
/* 1367 */     this.fightInfo.addBuffImmediately(tfid, effectGroupid);
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
/*      */   protected void say(int fid, int strid, String... args)
/*      */   {
/* 1381 */     FighterAIOperator operator = this.fightInfo.say(fid, strid, args);
/* 1382 */     this.m_operators.add(operator);
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
/*      */   protected void sayImmediately(int fid, int strid, String... args)
/*      */   {
/* 1396 */     this.fightInfo.sayImmediately(fid, strid, args);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void changeFightMapImmediately(int mapSource)
/*      */   {
/* 1406 */     this.fightInfo.changeFightMapImmediately(mapSource);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isMonster(int tfid)
/*      */   {
/* 1417 */     return this.fightInfo.isMonster(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isRole(int tfid)
/*      */   {
/* 1427 */     return this.fightInfo.isRole(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isPet(int tfid)
/*      */   {
/* 1438 */     return this.fightInfo.isPet(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isFellow(int tfid)
/*      */   {
/* 1449 */     return this.fightInfo.isFellow(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isChild(int tfid)
/*      */   {
/* 1460 */     return this.fightInfo.isChild(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isAiObj(int tfid)
/*      */   {
/* 1471 */     return this.fightInfo.isAiObj(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getMonsterid(int fid)
/*      */   {
/* 1482 */     return this.fightInfo.getMonsterid(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getMonsterTypeid(int fid)
/*      */   {
/* 1493 */     return this.fightInfo.getMonsterTypeid(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected String getName(int tfid)
/*      */   {
/* 1504 */     return this.fightInfo.getName(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getLevel(int tfid)
/*      */   {
/* 1515 */     return this.fightInfo.getLevel(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getPosition(int tfid)
/*      */   {
/* 1526 */     return this.fightInfo.getPosition(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getOccupation(int tfid)
/*      */   {
/* 1536 */     return this.fightInfo.getOccupation(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int getGender(int tfid)
/*      */   {
/* 1546 */     return this.fightInfo.getGender(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getGuiWang()
/*      */   {
/* 1555 */     return this.fightInfo.getGuiWang();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getQingYun()
/*      */   {
/* 1564 */     return this.fightInfo.getQingYun();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getTianYinSi()
/*      */   {
/* 1573 */     return this.fightInfo.getTianYinSi();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getFenXiang()
/*      */   {
/* 1582 */     return this.fightInfo.getFenXiang();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getHeHuan()
/*      */   {
/* 1591 */     return this.fightInfo.getHeHuan();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getShengWu()
/*      */   {
/* 1600 */     return this.fightInfo.getShengWu();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getCangYuGe()
/*      */   {
/* 1609 */     return this.fightInfo.getCangYuGe();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getLingYinDian()
/*      */   {
/* 1618 */     return this.fightInfo.getLingYinDian();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getYiNengZhe()
/*      */   {
/* 1627 */     return this.fightInfo.getYiNengZhe();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getSenLuoDian()
/*      */   {
/* 1636 */     return this.fightInfo.getSenLuoDian();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean hasBuff(int fid, int effectGroupid)
/*      */   {
/* 1646 */     return this.fightInfo.hasBuff(fid, effectGroupid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean hasOutFightBuff(int fid, int outFightBuffid)
/*      */   {
/* 1657 */     return this.fightInfo.hasOutFightBuff(fid, outFightBuffid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int random(int max)
/*      */   {
/* 1668 */     if (max <= 0) {
/* 1669 */       return 0;
/*      */     }
/* 1671 */     return Xdb.random().nextInt(max);
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
/*      */   protected Set<Integer> setAnd(Set<Integer>... args)
/*      */   {
/* 1684 */     Set<Integer> set = new HashSet();
/* 1685 */     if (args.length > 0) {
/* 1686 */       set.addAll(args[0]);
/*      */     }
/* 1688 */     for (int i = 1; i < args.length; i++) {
/* 1689 */       set.retainAll(args[i]);
/*      */     }
/* 1691 */     return set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> setOr(Set<Integer>... args)
/*      */   {
/* 1701 */     Set<Integer> set = new HashSet();
/* 1702 */     for (int i = 0; i < args.length; i++) {
/* 1703 */       set.addAll(args[i]);
/*      */     }
/* 1705 */     return set;
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
/*      */   protected Set<Integer> setNot(Set<Integer> setA, Set<Integer> setB)
/*      */   {
/* 1718 */     Set<Integer> set = new HashSet(setA);
/* 1719 */     set.removeAll(setB);
/* 1720 */     return set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void onFighterRelive(int tfid) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected int randomFromSet(Set<Integer> setA)
/*      */   {
/* 1739 */     int size = setA.size();
/* 1740 */     if (size <= 0) {
/* 1741 */       return -1;
/*      */     }
/* 1743 */     int index = random(size);
/* 1744 */     return ((Integer[])setA.toArray(new Integer[size]))[index].intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected boolean isSetEmpty(Set<Integer> setA)
/*      */   {
/* 1754 */     return (setA == null) || (setA.isEmpty());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void removeFromSet(Set<Integer> targetSet, int tfid)
/*      */   {
/* 1766 */     targetSet.remove(Integer.valueOf(tfid));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected Set<Integer> getSkillSet(int tfid)
/*      */   {
/* 1777 */     return this.fightInfo.getSkillSet(tfid);
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
/*      */   public Integer convertSkill(int fid, int skillid)
/*      */   {
/* 1791 */     return this.fightInfo.convertSkill(fid, skillid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillSeal(int skillid)
/*      */   {
/* 1801 */     return SkillInterface.isSkillEffectType(skillid, 2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillRelive(int skillid)
/*      */   {
/* 1811 */     return SkillInterface.isSkillEffectType(skillid, 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillDisperseSeal(int skillid)
/*      */   {
/* 1821 */     return SkillInterface.isSkillEffectType(skillid, 5);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillDispersePositive(int skillid)
/*      */   {
/* 1831 */     return SkillInterface.isSkillEffectType(skillid, 3);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillDisperseNegetive(int skillid)
/*      */   {
/* 1841 */     return SkillInterface.isSkillEffectType(skillid, 4);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSkillDispersePoison(int skillid)
/*      */   {
/* 1851 */     return SkillInterface.isSkillEffectType(skillid, 3);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected AbstractAI.OperatorInfo getOperatorInfo(int tfid)
/*      */   {
/* 1861 */     return this.fightInfo.getOperatorInfo(tfid);
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
/*      */   public int getDiffcultType()
/*      */   {
/* 2131 */     return this.fightInfo.getDiffcultType();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getDisType()
/*      */   {
/* 2140 */     return this.fightInfo.getDisType();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean enermyHasNewer(int fid)
/*      */   {
/* 2150 */     return this.fightInfo.enermyHasNewer(fid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean friendHasNewer(int fid)
/*      */   {
/* 2160 */     return this.fightInfo.friendHasNewer(fid);
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
/*      */   public int getSkillLv(int fid, int skillid)
/*      */   {
/* 2173 */     return this.fightInfo.getSkillLv(fid, skillid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getSealNumLimit()
/*      */   {
/* 2182 */     return this.fightInfo.getSealNumLimit();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Integer> getFriendAiOperateFighters(int tfid)
/*      */   {
/* 2191 */     return this.fightInfo.getFriendAiOperateFighters(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Integer> getEnermySealedFighters(int tfid)
/*      */   {
/* 2201 */     return this.fightInfo.getEnermySealedFighters(tfid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public List<Integer> getAiOperateFriendOrderSpeed(int tfid, boolean fakeDeadIncluded)
/*      */   {
/* 2213 */     return this.fightInfo.getAiOperateFriendOrderSpeed(tfid, fakeDeadIncluded);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isFightAiTianYinOpen()
/*      */   {
/* 2222 */     return this.fightInfo.isFightAiTianYinOpen();
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\ai\util\AbstractAI1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */