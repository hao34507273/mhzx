/*      */ package mzm.gsp.fight.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.common.IOutFightObject;
/*      */ import mzm.gsp.common.PropertyFormula;
/*      */ import mzm.gsp.effect.fighter.DeathBombing.DeathSkillCommonCDInputObj;
/*      */ import mzm.gsp.effect.fighter.Seal;
/*      */ import mzm.gsp.effect.main.FighterEffect;
/*      */ import mzm.gsp.fight.AttackOtherBean;
/*      */ import mzm.gsp.fight.AttackResultBean;
/*      */ import mzm.gsp.fight.Buff;
/*      */ import mzm.gsp.fight.CounterAttack;
/*      */ import mzm.gsp.fight.FighterStatus;
/*      */ import mzm.gsp.fight.InfluenceOther;
/*      */ import mzm.gsp.fight.Play;
/*      */ import mzm.gsp.fight.PlaySkill;
/*      */ import mzm.gsp.fight.PlaySummon;
/*      */ import mzm.gsp.fight.PlayUseItem;
/*      */ import mzm.gsp.fight.Protect;
/*      */ import mzm.gsp.fight.ShareDamageRet;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.handle.BeDamageHandle;
/*      */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*      */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*      */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*      */ import mzm.gsp.fight.handle.RoundEndHandle;
/*      */ import mzm.gsp.fight.handle.SkillCostHandle.CostResult;
/*      */ import mzm.gsp.skill.confbean.SSkillCfg;
/*      */ import mzm.gsp.skill.main.PassiveSkill;
/*      */ import mzm.gsp.skill.main.Skill;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightCmd;
/*      */ import xbean.FightState;
/*      */ import xbean.FighterBuffs;
/*      */ import xbean.FighterModelCard;
/*      */ import xbean.SkillResult;
/*      */ import xbean.Targets;
/*      */ 
/*      */ public abstract class Fighter
/*      */ {
/*      */   Fighter(int paramInt, xbean.Fighter paramFighter, FightGroup paramFightGroup)
/*      */   {
/*   54 */     this.influenceOthers = new HashMap();
/*   55 */     this.passiveSkillsReplace = new HashMap();
/*   56 */     this.fighterid = paramInt;
/*   57 */     this.xFighter = paramFighter;
/*   58 */     this.fightGroup = paramFightGroup;
/*      */   }
/*      */   
/*      */   protected abstract boolean canPlayerOperate();
/*      */   
/*      */   protected abstract boolean isAuto();
/*      */   
/*      */   protected abstract int getAutoSkill();
/*      */   
/*      */   protected abstract void setAuto();
/*      */   
/*      */   abstract void initChangeModelCard();
/*      */   
/*      */   protected void onEnterFight() {
/*   72 */     Set localSet = this.fightGroup.fightTeam.getAllTeamEffects();
/*   73 */     for (Object localObject1 = localSet.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (mzm.gsp.effect.fighter.Interface.TeamEffect)((Iterator)localObject1).next();
/*   74 */       if ((localObject2 instanceof FighterEffect))
/*   75 */         ((FighterEffect)localObject2).attach(this);
/*      */     }
/*      */     Object localObject2;
/*   78 */     if (!this.fightGroup.fightTeam.isActive) {
/*   79 */       localObject1 = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.getFight().getCfgType());
/*   80 */       if (((mzm.gsp.fight.confbean.SFightTypeCfg)localObject1).passivePSid > 0) {
/*   81 */         localObject2 = SkillInterface.getPassiveSkill(((mzm.gsp.fight.confbean.SFightTypeCfg)localObject1).passivePSid, getLevel());
/*   82 */         installPassiveSkill((PassiveSkill)localObject2);
/*      */       }
/*      */     }
/*   85 */     refreshAuto();
/*   86 */     initChangeModelCard();
/*   87 */     handleEnterFight();
/*   88 */     initSpeedFluctuateRate();
/*      */   }
/*      */   
/*      */   protected void onRoundBefore() {}
/*      */   
/*      */   protected void onPlayBefore()
/*      */   {
/*   95 */     if (!isExisted()) {
/*   96 */       return;
/*      */     }
/*   98 */     int i = getFight().getRound();
/*   99 */     xbean.FighterHealthInfo localFighterHealthInfo = xbean.Pod.newFighterHealthInfo();
/*  100 */     localFighterHealthInfo.setAnger(this.xFighter.getAnger());
/*  101 */     localFighterHealthInfo.setHp(this.xFighter.getHp());
/*  102 */     localFighterHealthInfo.setMp(this.xFighter.getMp());
/*  103 */     this.xFighter.getHealthatroundstart().put(Integer.valueOf(i), localFighterHealthInfo);
/*  104 */     Iterator localIterator = this.xFighter.getNextroundaddbuffids().iterator();
/*  105 */     while (localIterator.hasNext()) {
/*  106 */       int j = ((Integer)localIterator.next()).intValue();
/*  107 */       localIterator.remove();
/*  108 */       localObject = mzm.gsp.effect.main.EffectInterface.getEffectGroup(j);
/*  109 */       if (localObject == null) {
/*  110 */         GameServer.logger().info(String.format("[Fight]Fighter.onPlayBefore@不存在的效果组配置|buffid=%d", new Object[] { Integer.valueOf(j) }));
/*      */       }
/*      */       else {
/*  113 */         ((mzm.gsp.effect.main.FighterEffectGroup)localObject).run(getLevel(), this, this, this.fighterid);
/*      */       }
/*      */     }
/*  116 */     Set localSet = copySetValue(this.xFighter.getHandleonroundstart());
/*  117 */     for (Object localObject = localSet.iterator(); ((Iterator)localObject).hasNext();) { mzm.gsp.fight.handle.RoundStartHandle localRoundStartHandle = (mzm.gsp.fight.handle.RoundStartHandle)((Iterator)localObject).next();
/*  118 */       localRoundStartHandle.onRoundStart(this);
/*      */     }
/*  120 */     localObject = getAI();
/*  121 */     if (localObject != null) {
/*  122 */       ((AI)localObject).onRoundBegin(this.fightGroup.fightTeam.fight, this);
/*      */     }
/*  124 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid)) {
/*  125 */       setAuto();
/*  126 */       setDefautOper();
/*      */     }
/*      */   }
/*      */   
/*      */   protected void onRoundPrapare2() {
/*  131 */     if ((!this.fightGroup.getFight().hasFightCmd(this.fighterid)) && (isAuto()) && ((isPet()) || (isRole()) || (isChild()))) {
/*  132 */       setDefautOper();
/*  133 */       broadCastSelectOperInTeam();
/*      */     }
/*      */   }
/*      */   
/*      */   protected void onRoundPrapare1() {}
/*      */   
/*      */   protected void onRoundEnd()
/*      */   {
/*  141 */     if (isDead()) {
/*  142 */       onFightEnd();
/*  143 */       return;
/*      */     }
/*  145 */     AI localAI = getAI();
/*  146 */     if (localAI != null) {
/*  147 */       localAI.onRoundEnd(this.fightGroup.fightTeam.fight, this);
/*      */     }
/*  149 */     HashSet localHashSet1 = new HashSet();
/*  150 */     HashSet localHashSet2 = new HashSet();
/*  151 */     for (Object localObject1 = this.xFighter.getHandleonroundend().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (RoundEndHandle)((Iterator)localObject1).next();
/*  152 */       if ((localObject2 instanceof mzm.gsp.effect.fighter.Interface.ReliveType)) {
/*  153 */         localHashSet1.add(localObject2);
/*      */       }
/*      */       else {
/*  156 */         localHashSet2.add(localObject2);
/*      */       }
/*      */     }
/*  159 */     for (localObject1 = localHashSet2.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (RoundEndHandle)((Iterator)localObject1).next();
/*  160 */       ((RoundEndHandle)localObject2).onRoundEnd(this);
/*      */     }
/*  162 */     for (localObject1 = localHashSet1.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (RoundEndHandle)((Iterator)localObject1).next();
/*  163 */       ((RoundEndHandle)localObject2).onRoundEnd(this);
/*      */     }
/*  165 */     localObject1 = new ArrayList();
/*  166 */     Object localObject2 = this.xFighter.getBuffs().entrySet().iterator();
/*  167 */     Object localObject4; while (((Iterator)localObject2).hasNext()) {
/*  168 */       localObject3 = (Map.Entry)((Iterator)localObject2).next();
/*  169 */       localObject4 = (FighterBuffs)((Map.Entry)localObject3).getValue();
/*  170 */       Iterator localIterator = ((FighterBuffs)localObject4).getBuffs().iterator();
/*  171 */       while (localIterator.hasNext()) {
/*  172 */         FighterBuff localFighterBuff = (FighterBuff)localIterator.next();
/*  173 */         localFighterBuff.setLeftRound(localFighterBuff.getLeftRound() - 1);
/*  174 */         if (localFighterBuff.getLeftRound() <= 0) {
/*  175 */           if (localFighterBuff.isEffect()) {
/*  176 */             ((List)localObject1).add(localFighterBuff);
/*      */           }
/*  178 */           localIterator.remove();
/*      */         }
/*      */       }
/*  181 */       if (((FighterBuffs)localObject4).getBuffs().size() <= 0) {
/*  182 */         ((Iterator)localObject2).remove();
/*      */       }
/*      */     }
/*  185 */     for (Object localObject3 = ((List)localObject1).iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (FighterBuff)((Iterator)localObject3).next();
/*  186 */       setBuffUnEffect((FighterBuff)localObject4);
/*  187 */       findAndEffectStatusBuff(((FighterBuff)localObject4).getEffectGroupStatus());
/*      */     }
/*  189 */     this.xFighter.getProtecterids().clear();
/*      */   }
/*      */   
/*      */   public final int getRound() {
/*  193 */     return this.fightGroup.fightTeam.fight.getRound();
/*      */   }
/*      */   
/*      */   protected final void setAi(AI paramAI) {
/*  197 */     this.xFighter.setAi(paramAI);
/*      */   }
/*      */   
/*      */   protected final AI getAI() {
/*  201 */     return this.xFighter.getAi();
/*      */   }
/*      */   
/*      */   protected void setDefautOper() {
/*  205 */     int i = getAutoSkill();
/*  206 */     int j = getSkillLevel(i);
/*  207 */     Op_UseSkill localOp_UseSkill = getOp_UseSkill(i, j);
/*  208 */     if ((isRole()) || (isPet()) || (isChild())) {
/*  209 */       Skill localSkill = SkillInterface.getSkill(i, j);
/*  210 */       if (localSkill != null) {
/*  211 */         List localList = localSkill.getTargets(this, -1, true);
/*  212 */         if (localList.size() > 0) {
/*  213 */           localOp_UseSkill.main_target = ((Fighter)localList.get(0)).fighterid;
/*      */         }
/*      */       }
/*      */       else {
/*  217 */         GameServer.logger().error("选择的技能不存在skillid:" + i);
/*      */       }
/*      */     }
/*  220 */     this.fightGroup.getFight().addFightCmd(this.fighterid, 0, localOp_UseSkill);
/*      */   }
/*      */   
/*      */   protected static Op_UseSkill getOp_UseSkill(int paramInt1, int paramInt2) {
/*  224 */     Op_UseSkill localOp_UseSkill = new Op_UseSkill();
/*  225 */     localOp_UseSkill.skill = paramInt1;
/*  226 */     localOp_UseSkill.skillLv = paramInt2;
/*  227 */     return localOp_UseSkill;
/*      */   }
/*      */   
/*      */   protected final boolean hasSkill(int paramInt) {
/*  231 */     return (getActiveSkills().contains(Integer.valueOf(paramInt))) || (FightManager.isCommonSkill(paramInt, getOccupation()));
/*      */   }
/*      */   
/*      */   protected final int getCfgDefaultSkill() {
/*  235 */     for (Iterator localIterator = getActiveSkills().iterator(); localIterator.hasNext();) { int i = ((Integer)localIterator.next()).intValue();
/*  236 */       SSkillCfg localSSkillCfg = SSkillCfg.get(i);
/*  237 */       if ((localSSkillCfg != null) && (localSSkillCfg.canAuto) && (isSkillAvailableWithFightState(i))) {
/*  238 */         return i;
/*      */       }
/*      */     }
/*  241 */     return getNormalSkill();
/*      */   }
/*      */   
/*      */   protected Set<Integer> getActiveSkills() {
/*  245 */     HashSet localHashSet = new HashSet();
/*  246 */     if (!this.xFighter.getSkills().isEmpty()) {
/*  247 */       localHashSet.addAll(this.xFighter.getSkills().keySet());
/*      */     }
/*  249 */     return localHashSet;
/*      */   }
/*      */   
/*      */   public Integer convertSkill(int paramInt) {
/*  253 */     Set localSet = getActiveSkills();
/*  254 */     return Integer.valueOf(SkillInterface.getRealSkillCfgid(localSet, paramInt));
/*      */   }
/*      */   
/*      */   public static Integer convertSkill(Set<Integer> paramSet, int paramInt) {
/*  258 */     return Integer.valueOf(SkillInterface.getRealSkillCfgid(paramSet, paramInt));
/*      */   }
/*      */   
/*      */   public static Integer convertToSourceSkill(int paramInt) {
/*  262 */     return Integer.valueOf(SkillInterface.getSourceSkillCfgid(paramInt));
/*      */   }
/*      */   
/*      */   public final void addSkill(int paramInt1, int paramInt2) {
/*  266 */     this.xFighter.getSkills().put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*      */   }
/*      */   
/*      */   protected final void addAllSkill(Map<Integer, Integer> paramMap) {
/*  270 */     this.xFighter.getSkills().putAll(paramMap);
/*      */   }
/*      */   
/*      */   public final Map<Integer, Integer> getActiveSkillMap() {
/*  274 */     return this.xFighter.getSkills();
/*      */   }
/*      */   
/*      */   public void addNextRoundBuff(int paramInt) {
/*  278 */     this.xFighter.getNextroundaddbuffids().add(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public void addNextRoundBuff(List<Integer> paramList) {
/*  282 */     this.xFighter.getNextroundaddbuffids().addAll(paramList);
/*      */   }
/*      */   
/*      */   public final Set<Fighter> getEnermyLiveFighters() {
/*  286 */     if (this.fightGroup.fightTeam.isActive) {
/*  287 */       return this.fightGroup.getFight().getPassiveTeam().getAliveFighters();
/*      */     }
/*  289 */     return this.fightGroup.getFight().getActiveTeam().getAliveFighters();
/*      */   }
/*      */   
/*      */   public final Set<Fighter> getEnermyFighters() {
/*  293 */     if (this.fightGroup.fightTeam.isActive) {
/*  294 */       return this.fightGroup.getFight().getPassiveTeam().getExistedFighters();
/*      */     }
/*  296 */     return this.fightGroup.getFight().getActiveTeam().getExistedFighters();
/*      */   }
/*      */   
/*      */   public final Set<Fighter> getFriendLiveFighters() {
/*  300 */     if (this.fightGroup.fightTeam.isActive) {
/*  301 */       return this.fightGroup.getFight().getActiveTeam().getAliveFighters();
/*      */     }
/*  303 */     return this.fightGroup.getFight().getPassiveTeam().getAliveFighters();
/*      */   }
/*      */   
/*      */   public final Set<Fighter> getFriendFighters() {
/*  307 */     if (this.fightGroup.fightTeam.isActive) {
/*  308 */       return this.fightGroup.getFight().getActiveTeam().getExistedFighters();
/*      */     }
/*  310 */     return this.fightGroup.getFight().getPassiveTeam().getExistedFighters();
/*      */   }
/*      */   
/*      */   public final Fighter getFighter(int paramInt) {
/*  314 */     return this.fightGroup.fightTeam.fight.getFighter(paramInt);
/*      */   }
/*      */   
/*      */   public final Fighter getFighterFromAll(int paramInt) {
/*  318 */     Fighter localFighter = getFighter(paramInt);
/*  319 */     if (localFighter == null) {
/*  320 */       localFighter = this.fightGroup.fightTeam.fight.getFighterLeaved(paramInt);
/*      */     }
/*  322 */     return localFighter;
/*      */   }
/*      */   
/*      */   public final Fight getFight() {
/*  326 */     return this.fightGroup.fightTeam.fight;
/*      */   }
/*      */   
/*      */   public mzm.gsp.fight.confbean.SFightTypeCfg getFightTypeCfg() {
/*  330 */     return this.fightGroup.fightTeam.fight.getFightTypeCfg();
/*      */   }
/*      */   
/*      */   public final long getFightUuid() {
/*  334 */     return this.fightGroup.fightTeam.fight.fightid;
/*      */   }
/*      */   
/*      */   public final Fighter getFriendFighterByPos(int paramInt) {
/*  338 */     for (Fighter localFighter : getFriendFighters()) {
/*  339 */       if (localFighter.getPos() == paramInt) {
/*  340 */         return localFighter;
/*      */       }
/*      */     }
/*  343 */     return null;
/*      */   }
/*      */   
/*      */   public Map<Integer, Fighter> getFriendPosToFighters() {
/*  347 */     return this.fightGroup.fightTeam.getPosToFighter();
/*      */   }
/*      */   
/*      */   protected final boolean isSkillCostEnough(Skill paramSkill) {
/*  351 */     SSkillCfg localSSkillCfg = paramSkill.getSkillCfg();
/*  352 */     mzm.gsp.skill.confbean.SSkillConditionCfg localSSkillConditionCfg = mzm.gsp.skill.confbean.SSkillConditionCfg.get(localSSkillCfg.condition);
/*  353 */     if (localSSkillConditionCfg == null) {
/*  354 */       return true;
/*      */     }
/*  356 */     for (Object localObject1 = localSSkillConditionCfg.needCondtions.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (mzm.gsp.skill.confbean.ConditionType2FormulaId)((Iterator)localObject1).next();
/*  357 */       if (!checkSkillNeed(paramSkill, ((mzm.gsp.skill.confbean.ConditionType2FormulaId)localObject2).conditionType, ((mzm.gsp.skill.confbean.ConditionType2FormulaId)localObject2).formulaid)) {
/*  358 */         return false;
/*      */       }
/*      */     }
/*  361 */     localObject1 = handleSkillCost();
/*  362 */     for (Object localObject2 = localSSkillConditionCfg.costCondtions.iterator(); ((Iterator)localObject2).hasNext();) { mzm.gsp.skill.confbean.CostType2Formulaid localCostType2Formulaid = (mzm.gsp.skill.confbean.CostType2Formulaid)((Iterator)localObject2).next();
/*  363 */       if (!checkSkillCost(paramSkill, localCostType2Formulaid.costType, localCostType2Formulaid.formulaid, (SkillCostHandle.CostResult)localObject1)) {
/*  364 */         return false;
/*      */       }
/*      */     }
/*  367 */     return true;
/*      */   }
/*      */   
/*      */   private final boolean checkSkillCost(Skill paramSkill, int paramInt1, int paramInt2, SkillCostHandle.CostResult paramCostResult) {
/*  371 */     if (paramInt1 != 1) {
/*  372 */       mzm.gsp.skill.formula.fighter.SkillFormula localSkillFormula = SkillInterface.getSkillFormula(paramInt2);
/*  373 */       if (localSkillFormula != null) {
/*  374 */         int i = localSkillFormula.calc(paramSkill, this);
/*  375 */         Play localPlay1; int j; Play localPlay3; Play localPlay2; switch (paramInt1) {
/*      */         case 6: 
/*  377 */           if (getAnger() >= i * (1.0D + (paramCostResult.exangerRate + paramCostResult.extraRate) * 1.0D / FightArgs.getInstance().getDefaultRate())) {
/*  378 */             return true;
/*      */           }
/*  380 */           localPlay1 = new Play();
/*  381 */           fillPlayTipResult(localPlay1, this.fighterid, 121000031, new String[] { i + "" });
/*  382 */           paramSkill.addPlay(localPlay1, true);
/*  383 */           paramSkill.addPlay(localPlay1, false);
/*  384 */           if (isRecordEnable()) {
/*  385 */             paramSkill.addPlay(localPlay1);
/*      */           }
/*  387 */           return false;
/*      */         
/*      */         case 7: 
/*  390 */           if (getCurAngerRateValue() >= i * (1.0D + (paramCostResult.exangerRate + paramCostResult.extraRate) * 1.0D / FightArgs.getInstance().getDefaultRate())) {
/*  391 */             return true;
/*      */           }
/*  393 */           localPlay1 = new Play();
/*  394 */           fillPlayTipResult(localPlay1, this.fighterid, 121000032, new String[] { i / 100 + "" });
/*  395 */           paramSkill.addPlay(localPlay1, true);
/*  396 */           paramSkill.addPlay(localPlay1, false);
/*  397 */           if (isRecordEnable()) {
/*  398 */             paramSkill.addPlay(localPlay1);
/*      */           }
/*  400 */           return false;
/*      */         
/*      */         case 2: 
/*  403 */           if (getHp() >= i * (1.0D + paramCostResult.extraRate * 1.0D / FightArgs.getInstance().getDefaultRate())) {
/*  404 */             return true;
/*      */           }
/*  406 */           localPlay1 = new Play();
/*  407 */           fillPlayTipResult(localPlay1, this.fighterid, 121000027, new String[] { i + "" });
/*  408 */           paramSkill.addPlay(localPlay1, true);
/*  409 */           paramSkill.addPlay(localPlay1, false);
/*  410 */           if (isRecordEnable()) {
/*  411 */             paramSkill.addPlay(localPlay1);
/*      */           }
/*  413 */           return false;
/*      */         
/*      */         case 3: 
/*  416 */           if (getCurHpRateValue() >= i * (1.0D + paramCostResult.extraRate * 1.0D / FightArgs.getInstance().getDefaultRate())) {
/*  417 */             return true;
/*      */           }
/*  419 */           localPlay1 = new Play();
/*  420 */           fillPlayTipResult(localPlay1, this.fighterid, 121000028, new String[] { i / 100 + "" });
/*  421 */           paramSkill.addPlay(localPlay1, true);
/*  422 */           paramSkill.addPlay(localPlay1, false);
/*  423 */           if (isRecordEnable()) {
/*  424 */             paramSkill.addPlay(localPlay1);
/*      */           }
/*  426 */           return false;
/*      */         
/*      */         case 4: 
/*  429 */           j = (int)(i * (1.0D + (paramCostResult.extraRate - paramCostResult.magicreducerate) * 1.0D / FightArgs.getInstance().defaultRate));
/*  430 */           if (getMp() >= j) {
/*  431 */             return true;
/*      */           }
/*  433 */           localPlay3 = new Play();
/*  434 */           fillPlayTipResult(localPlay3, this.fighterid, 121000029, new String[] { i + "" });
/*  435 */           paramSkill.addPlay(localPlay3, true);
/*  436 */           paramSkill.addPlay(localPlay3, false);
/*  437 */           if (isRecordEnable()) {
/*  438 */             paramSkill.addPlay(localPlay3);
/*      */           }
/*  440 */           return false;
/*      */         
/*      */         case 5: 
/*  443 */           j = (int)(i * ((1 + paramCostResult.extraRate - paramCostResult.magicreducerate) * 1.0D / FightArgs.getInstance().defaultRate));
/*  444 */           if (getCurMpRateValue() >= j) {
/*  445 */             return true;
/*      */           }
/*  447 */           localPlay3 = new Play();
/*  448 */           fillPlayTipResult(localPlay3, this.fighterid, 121000030, new String[] { i / 100 + "" });
/*  449 */           paramSkill.addPlay(localPlay3, true);
/*  450 */           paramSkill.addPlay(localPlay3, false);
/*  451 */           if (isRecordEnable()) {
/*  452 */             paramSkill.addPlay(localPlay3);
/*      */           }
/*  454 */           return false;
/*      */         
/*      */         case 8: 
/*  457 */           if (getHp() > i) {
/*  458 */             return true;
/*      */           }
/*  460 */           localPlay2 = new Play();
/*  461 */           fillPlayTipResult(localPlay2, this.fighterid, 121000027, new String[] { i + 1 + "" });
/*  462 */           paramSkill.addPlay(localPlay2, true);
/*  463 */           paramSkill.addPlay(localPlay2, false);
/*  464 */           if (isRecordEnable()) {
/*  465 */             paramSkill.addPlay(localPlay2);
/*      */           }
/*  467 */           return false;
/*      */         
/*      */         case 9: 
/*  470 */           if (getEnergy() >= i) {
/*  471 */             return true;
/*      */           }
/*  473 */           localPlay2 = new Play();
/*  474 */           fillPlayTipResult(localPlay2, this.fighterid, 121001000, new String[] { i + "" });
/*  475 */           paramSkill.addPlay(localPlay2, true);
/*  476 */           paramSkill.addPlay(localPlay2, false);
/*  477 */           if (isRecordEnable()) {
/*  478 */             paramSkill.addPlay(localPlay2);
/*      */           }
/*  480 */           return false;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*  485 */     return true;
/*      */   }
/*      */   
/*      */   private final boolean checkSkillNeed(Skill paramSkill, int paramInt1, int paramInt2) {
/*  489 */     if (paramInt1 != 1) {
/*  490 */       mzm.gsp.skill.formula.fighter.SkillFormula localSkillFormula = SkillInterface.getSkillFormula(paramInt2);
/*  491 */       if (localSkillFormula != null) {
/*  492 */         int i = localSkillFormula.calc(paramSkill, this);
/*  493 */         Play localPlay; if (paramInt1 == 2) {
/*  494 */           if (getCurHpRateValue() >= i) {
/*  495 */             return true;
/*      */           }
/*  497 */           localPlay = new Play();
/*  498 */           fillPlayTipResult(localPlay, this.fighterid, 121000023, new String[] { i / 100 + "" });
/*  499 */           paramSkill.addPlay(localPlay, true);
/*  500 */           paramSkill.addPlay(localPlay, false);
/*  501 */           if (isRecordEnable()) {
/*  502 */             paramSkill.addPlay(localPlay);
/*      */           }
/*  504 */           return false;
/*      */         }
/*  506 */         if (paramInt1 == 3) {
/*  507 */           if (getCurHpRateValue() <= i) {
/*  508 */             return true;
/*      */           }
/*  510 */           localPlay = new Play();
/*  511 */           fillPlayTipResult(localPlay, this.fighterid, 121000024, new String[] { i / 100 + "" });
/*  512 */           paramSkill.addPlay(localPlay, true);
/*  513 */           paramSkill.addPlay(localPlay, false);
/*  514 */           if (isRecordEnable()) {
/*  515 */             paramSkill.addPlay(localPlay);
/*      */           }
/*  517 */           return false;
/*      */         }
/*  519 */         if (paramInt1 == 4) {
/*  520 */           if (getCurMpRateValue() >= i) {
/*  521 */             return true;
/*      */           }
/*  523 */           localPlay = new Play();
/*  524 */           fillPlayTipResult(localPlay, this.fighterid, 121000025, new String[] { i / 100 + "" });
/*  525 */           paramSkill.addPlay(localPlay, true);
/*  526 */           paramSkill.addPlay(localPlay, false);
/*  527 */           if (isRecordEnable()) {
/*  528 */             paramSkill.addPlay(localPlay);
/*      */           }
/*  530 */           return false;
/*      */         }
/*  532 */         if (paramInt1 == 5) {
/*  533 */           if (getCurMpRateValue() <= i) {
/*  534 */             return true;
/*      */           }
/*  536 */           localPlay = new Play();
/*  537 */           fillPlayTipResult(localPlay, this.fighterid, 121000026, new String[] { i / 100 + "" });
/*  538 */           paramSkill.addPlay(localPlay, true);
/*  539 */           paramSkill.addPlay(localPlay, false);
/*  540 */           if (isRecordEnable()) {
/*  541 */             paramSkill.addPlay(localPlay);
/*      */           }
/*  543 */           return false;
/*      */         }
/*  545 */         if (paramInt1 == 6) {
/*  546 */           if (getEnergy() >= i) {
/*  547 */             return true;
/*      */           }
/*  549 */           localPlay = new Play();
/*  550 */           fillPlayTipResult(localPlay, this.fighterid, 121001000, new String[] { i + "" });
/*  551 */           paramSkill.addPlay(localPlay, true);
/*  552 */           paramSkill.addPlay(localPlay, false);
/*  553 */           if (isRecordEnable()) {
/*  554 */             paramSkill.addPlay(localPlay);
/*      */           }
/*  556 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*  560 */     return true;
/*      */   }
/*      */   
/*      */   protected boolean isSkillAvailableWithFightState(int paramInt) {
/*  564 */     int i = paramInt;
/*  565 */     if (isRoleType()) {
/*  566 */       i = convertToSourceSkill(paramInt).intValue();
/*      */     }
/*  568 */     Set localSet = this.xFighter.getFightstates().entrySet();
/*  569 */     if (localSet.size() > 0)
/*  570 */       for (Map.Entry localEntry : localSet) {
/*  571 */         int j = ((Integer)localEntry.getKey()).intValue();
/*  572 */         if (j != 0)
/*      */         {
/*      */ 
/*  575 */           mzm.gsp.fight.confbean.SFighterStateCfg localSFighterStateCfg = mzm.gsp.fight.confbean.SFighterStateCfg.get(j);
/*  576 */           if (localSFighterStateCfg != null)
/*      */           {
/*      */ 
/*  579 */             int k = 0;
/*  580 */             java.util.Collection localCollection = localSFighterStateCfg.stateSkills.values();
/*  581 */             for (Iterator localIterator2 = localCollection.iterator(); localIterator2.hasNext();) { localFighterStateSkills = (mzm.gsp.fight.confbean.FighterStateSkills)localIterator2.next();
/*  582 */               if (localFighterStateSkills.skills.contains(Integer.valueOf(i))) {
/*  583 */                 k = 1;
/*  584 */                 break;
/*      */               } }
/*      */             mzm.gsp.fight.confbean.FighterStateSkills localFighterStateSkills;
/*  587 */             if (k != 0)
/*      */             {
/*      */ 
/*  590 */               int m = ((FightState)localEntry.getValue()).getState();
/*  591 */               localFighterStateSkills = (mzm.gsp.fight.confbean.FighterStateSkills)localSFighterStateCfg.stateSkills.get(Integer.valueOf(m));
/*  592 */               if ((localFighterStateSkills == null) || (!localFighterStateSkills.skills.contains(Integer.valueOf(i)))) {
/*  593 */                 GameServer.logger().info(String.format("[fight]Fighter.excuteOpSkill@current fight state can not use the skill|fightstategroup=%d|fightstate=%d|sourceskillid=%d|skillid=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(paramInt) }));
/*  594 */                 return false;
/*      */               }
/*      */             }
/*      */           } } }
/*  598 */     return true;
/*      */   }
/*      */   
/*      */   protected void excuteOpSkill(Op_UseSkill paramOp_UseSkill, ExcuteCmdResult paramExcuteCmdResult, List<Fighter> paramList, boolean paramBoolean) {
/*  602 */     if (isStone()) {
/*  603 */       Play localPlay1 = new Play();
/*  604 */       fillPlayTipResult(localPlay1, this.fighterid, 121000020, new String[0]);
/*  605 */       paramExcuteCmdResult.addPlay(localPlay1, true);
/*  606 */       paramExcuteCmdResult.addPlay(localPlay1, false);
/*  607 */       if (isRecordEnable()) {
/*  608 */         paramExcuteCmdResult.addPlay(localPlay1);
/*      */       }
/*  610 */       return;
/*      */     }
/*  612 */     int i = paramOp_UseSkill.skill;
/*  613 */     if (!hasSkill(i)) {
/*  614 */       GameServer.logger().error("战斗中战斗对象" + getName() + "不存在技能:skillid:" + i + ",战斗对象类型:" + getType());
/*  615 */       return;
/*      */     }
/*  617 */     if ((isRest()) && (paramOp_UseSkill.skill != SFightConsts.getInstance().DEFENCE_SKILL)) {
/*  618 */       localObject1 = new Play();
/*  619 */       fillPlayTipResult((Play)localObject1, this.fighterid, 121000004, new String[0]);
/*  620 */       paramExcuteCmdResult.addPlay((Play)localObject1, true);
/*  621 */       paramExcuteCmdResult.addPlay((Play)localObject1, false);
/*  622 */       if (isRecordEnable()) {
/*  623 */         paramExcuteCmdResult.addPlay((Play)localObject1);
/*      */       }
/*  625 */       return;
/*      */     }
/*  627 */     Object localObject1 = SkillInterface.getSkill(i, paramOp_UseSkill.skillLv);
/*  628 */     if (localObject1 == null) {
/*  629 */       GameServer.logger().error("找不到技能skillid:" + i);
/*  630 */       return;
/*      */     }
/*      */     
/*  633 */     int j = 1;
/*  634 */     if ((isHouFa()) && (!paramBoolean)) {
/*  635 */       localObject1 = SkillInterface.getSkill(getHouFaSkill(), paramOp_UseSkill.skillLv);
/*  636 */       j = 0; }
/*      */     Play localPlay2;
/*  638 */     if ((isSeal()) && (!isHouFa()) && (isSealedSkill((Skill)localObject1))) {
/*  639 */       localPlay2 = new Play();
/*  640 */       fillPlayTipResult(localPlay2, this.fighterid, 121000019, new String[0]);
/*  641 */       paramExcuteCmdResult.addPlay(localPlay2, true);
/*  642 */       paramExcuteCmdResult.addPlay(localPlay2, false);
/*  643 */       if (isRecordEnable()) {
/*  644 */         paramExcuteCmdResult.addPlay(localPlay2);
/*      */       }
/*  646 */       return;
/*      */     }
/*  648 */     if ((isInvisible()) && (!isStrengInvisible()) && (!FightInterface.isNormalAttackSkill(i))) {
/*  649 */       if (paramOp_UseSkill.skill != SFightConsts.getInstance().DEFENCE_SKILL) {
/*  650 */         localPlay2 = new Play();
/*  651 */         fillPlayTipResult(localPlay2, this.fighterid, 121000022, new String[0]);
/*  652 */         paramExcuteCmdResult.addPlay(localPlay2, true);
/*  653 */         paramExcuteCmdResult.addPlay(localPlay2, false);
/*  654 */         if (isRecordEnable()) {
/*  655 */           paramExcuteCmdResult.addPlay(localPlay2);
/*      */         }
/*      */       }
/*  658 */       return;
/*      */     }
/*  660 */     boolean bool = isSkillAvailableWithFightState(((Skill)localObject1).getID());
/*  661 */     if (!bool) {
/*  662 */       localObject1 = SkillInterface.getSkill(getNormalSkill(), getLevel());
/*      */     }
/*  664 */     if ((j != 0) && (!paramBoolean) && (!validateCDSkill(i))) {
/*  665 */       return;
/*      */     }
/*  667 */     int k = SkillInterface.getExchangeSkill(((Skill)localObject1).getID(), getEnergy());
/*  668 */     int m = 0;
/*  669 */     if ((k > 0) && (!paramBoolean)) {
/*  670 */       m = getEnergy();
/*  671 */       localObject1 = SkillInterface.getSkill(k, paramOp_UseSkill.skillLv);
/*      */     }
/*  673 */     mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj localOutputObj = handleOnBeforeUseSkill((Skill)localObject1);
/*  674 */     Object localObject2; if (localOutputObj.seal) {
/*  675 */       localObject2 = new Play();
/*  676 */       fillPlayTipResult((Play)localObject2, this.fighterid, 121001002, new String[0]);
/*  677 */       paramExcuteCmdResult.addPlay((Play)localObject2, true);
/*  678 */       paramExcuteCmdResult.addPlay((Play)localObject2, false);
/*  679 */       if (isRecordEnable()) {
/*  680 */         paramExcuteCmdResult.addPlay((Play)localObject2);
/*      */       }
/*  682 */       return;
/*      */     }
/*  684 */     if (localOutputObj.changedSkill > 0) {
/*  685 */       localObject2 = SkillInterface.getSkill(localOutputObj.changedSkill, paramOp_UseSkill.skillLv);
/*  686 */       if (localObject2 != null) {
/*  687 */         localObject1 = localObject2;
/*      */       }
/*      */     }
/*  690 */     if (isSkillCostEnough((Skill)localObject1)) {
/*  691 */       if ((paramList == null) || (paramList.size() <= 0)) {
/*  692 */         paramList = ((Skill)localObject1).getTargets(this, paramOp_UseSkill.main_target, true);
/*  693 */         if (!((Skill)localObject1).canRun(this, paramOp_UseSkill.main_target, paramList, true)) {
/*  694 */           paramExcuteCmdResult.addAllPlay(((Skill)localObject1).getActivePlays(), true);
/*  695 */           paramExcuteCmdResult.addAllPlay(((Skill)localObject1).getPassivePlays(), false);
/*  696 */           if (isRecordEnable()) {
/*  697 */             paramExcuteCmdResult.addAllPlay(((Skill)localObject1).getRecordPlays());
/*      */           }
/*  699 */           return;
/*      */         }
/*      */       }
/*  702 */       doUseSkill(paramOp_UseSkill, paramExcuteCmdResult, paramList, i, (Skill)localObject1, m, localOutputObj);
/*  703 */       paramExcuteCmdResult.skill = ((Skill)localObject1);
/*  704 */       if (!isHouFa()) {
/*  705 */         setExtra(FighterExtra.ROUND_USE_SKILLID, i);
/*      */       }
/*  707 */       int n = ((Skill)localObject1).getSkillCfg().complexSkillid;
/*  708 */       if ((n > 0) && (isRole())) {
/*  709 */         handleComplexSkill(n, paramOp_UseSkill.main_target, paramExcuteCmdResult);
/*      */       }
/*  711 */       if (j != 0) {
/*  712 */         xbean.SkillData localSkillData = (xbean.SkillData)this.xFighter.getSkilldatas().get(Integer.valueOf(i));
/*  713 */         if (localSkillData == null) {
/*  714 */           localSkillData = xbean.Pod.newSkillData();
/*  715 */           this.xFighter.getSkilldatas().put(Integer.valueOf(i), localSkillData);
/*      */         }
/*  717 */         localSkillData.setUseround(getRound());
/*  718 */         localSkillData.setUsecount(localSkillData.getUsecount() + 1);
/*      */       }
/*  720 */       return;
/*      */     }
/*  722 */     if (((paramList != null) && (paramList.size() > 0)) || (!isAuto()) || (!canPlayerOperate())) {
/*  723 */       paramExcuteCmdResult.addAllPlay(((Skill)localObject1).getActivePlays(), true);
/*  724 */       paramExcuteCmdResult.addAllPlay(((Skill)localObject1).getPassivePlays(), false);
/*  725 */       if (isRecordEnable()) {
/*  726 */         paramExcuteCmdResult.addAllPlay(((Skill)localObject1).getRecordPlays());
/*      */       }
/*  728 */       return;
/*      */     }
/*  730 */     Skill localSkill = SkillInterface.getSkill(getNormalSkill(), getLevel());
/*  731 */     paramList = localSkill.getTargets(this, paramOp_UseSkill.main_target, true);
/*  732 */     if (!localSkill.canRun(this, paramOp_UseSkill.main_target, paramList, true)) {
/*  733 */       paramExcuteCmdResult.addAllPlay(localSkill.getActivePlays(), true);
/*  734 */       paramExcuteCmdResult.addAllPlay(localSkill.getPassivePlays(), false);
/*  735 */       if (isRecordEnable()) {
/*  736 */         paramExcuteCmdResult.addAllPlay(localSkill.getRecordPlays());
/*      */       }
/*  738 */       return;
/*      */     }
/*  740 */     doUseSkill(paramOp_UseSkill, paramExcuteCmdResult, paramList, localSkill.getID(), localSkill, 0, localOutputObj);
/*  741 */     setExtra(FighterExtra.ROUND_USE_SKILLID, localSkill.getID());
/*      */   }
/*      */   
/*      */   protected void doUseSkill(Op_UseSkill paramOp_UseSkill, ExcuteCmdResult paramExcuteCmdResult, List<Fighter> paramList, int paramInt1, Skill paramSkill, int paramInt2, mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj paramOutputObj) {
/*  745 */     if ((paramOp_UseSkill.main_target > 0) && (paramList.size() > 0)) {
/*  746 */       localObject1 = (Fighter)paramList.get(0);
/*  747 */       if ((localObject1 != null) && (((Fighter)localObject1).isBeProtect())) {
/*  748 */         localObject2 = getEnermyLiveFighters();
/*  749 */         Set localSet = getFriendLiveFighters();
/*  750 */         if ((((Set)localObject2).size() != 0) || (localSet.size() != 0)) {
/*  751 */           ArrayList localArrayList = new ArrayList();
/*  752 */           for (Iterator localIterator = ((Set)localObject2).iterator(); localIterator.hasNext();) { localFighter = (Fighter)localIterator.next();
/*  753 */             if (((isVisible()) || (!localFighter.isInvisible())) && (localFighter.getid() != paramOp_UseSkill.main_target) && (!localFighter.isBeProtect()))
/*  754 */               localArrayList.add(localFighter);
/*      */           }
/*      */           Fighter localFighter;
/*  757 */           for (localIterator = localSet.iterator(); localIterator.hasNext();) { localFighter = (Fighter)localIterator.next();
/*  758 */             if (((isVisible()) || (!localFighter.isInvisible())) && (localFighter.getid() != paramOp_UseSkill.main_target) && (!localFighter.isBeProtect())) {
/*  759 */               localArrayList.add(localFighter);
/*      */             }
/*      */           }
/*  762 */           if (localArrayList.size() != 0) {
/*  763 */             int i = xdb.Xdb.random().nextInt(localArrayList.size());
/*  764 */             paramList.remove(localObject1);
/*  765 */             localObject1 = (Fighter)localArrayList.get(i);
/*  766 */             paramList.add(0, localObject1);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  772 */     addUseSkillCount();
/*  773 */     Object localObject1 = paramSkill.getSkillUseFighterStatus();
/*  774 */     doSkillCost(paramSkill, paramInt2);
/*  775 */     fillFighterStatus((FighterStatus)localObject1);
/*  776 */     if (paramSkill.getID() == paramInt1) {
/*  777 */       paramSkill.modifyLevel(paramOutputObj.skillLevelModify);
/*      */     }
/*  779 */     paramSkill.skillOnTarget(this, paramList);
/*  780 */     if (paramSkill.getID() != SFightConsts.getInstance().DEFENCE_SKILL) {
/*  781 */       addActionCount();
/*      */     }
/*  783 */     if ((!isDead()) && (!isFakeDead()) && (isReleaseSkillDead())) {
/*  784 */       setHp(0);
/*  785 */       onDead();
/*      */     }
/*  787 */     fillFighterStatus(paramSkill.getAfterSkillUseFighterStatus());
/*  788 */     paramSkill.addAllCounterAttackMultiPlayType(this);
/*  789 */     Object localObject2 = handleOnAftUseSkill(paramSkill, paramOp_UseSkill.main_target);
/*  790 */     paramSkill.getAfterSkillUseFighterStatus().triggerpassiveskills.addAll(((mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj)localObject2).releaserPassiveSkills);
/*  791 */     handleDeathSkill(this, paramSkill);
/*  792 */     handleOnSkillCausingDeath(this, paramSkill);
/*  793 */     fillSkillResult(paramSkill, paramExcuteCmdResult);
/*  794 */     handleSkillExcCmdResult(paramOp_UseSkill, paramSkill);
/*      */   }
/*      */   
/*      */   protected void handleSkillExcCmdResult(Op_UseSkill paramOp_UseSkill, Skill paramSkill) {
/*  798 */     Set localSet = getFight().getSkillResultHandles();
/*  799 */     for (SkillResultHandle localSkillResultHandle : localSet) {
/*  800 */       localSkillResultHandle.OnUseSkillResult(this, paramSkill, paramOp_UseSkill);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void handleSkillExcCmdEnd(Op_UseSkill paramOp_UseSkill) {
/*  805 */     if (!isRole()) {
/*  806 */       return;
/*      */     }
/*  808 */     Set localSet = getFight().getSkillResultHandles();
/*  809 */     for (SkillResultHandle localSkillResultHandle : localSet) {
/*  810 */       localSkillResultHandle.OnUseSkillEnd(this, paramOp_UseSkill);
/*      */     }
/*      */   }
/*      */   
/*      */   public void handleOnSkillCausingDeath(Fighter paramFighter, Skill paramSkill) {
/*  815 */     List localList = paramSkill.getTargets();
/*  816 */     if ((localList == null) || (localList.isEmpty())) {
/*  817 */       return;
/*      */     }
/*  819 */     int i = 0;
/*  820 */     for (Object localObject1 = localList.iterator(); ((Iterator)localObject1).hasNext();) { int j = ((Integer)((Iterator)localObject1).next()).intValue();
/*  821 */       localObject2 = getFighter(j);
/*  822 */       if (localObject2 != null)
/*      */       {
/*      */ 
/*  825 */         if ((((Fighter)localObject2).isDead()) || (((Fighter)localObject2).isFakeDead())) {
/*  826 */           i = 1;
/*  827 */           break;
/*      */         } }
/*      */     }
/*  830 */     if (i == 0) {
/*  831 */       return;
/*      */     }
/*  833 */     localObject1 = new mzm.gsp.fight.handle.SkillCausingDeathHandle.OutputObj();
/*  834 */     mzm.gsp.fight.handle.SkillCausingDeathHandle.InputObj localInputObj = new mzm.gsp.fight.handle.SkillCausingDeathHandle.InputObj(paramFighter, paramSkill, paramSkill.getMainTargetId());
/*  835 */     Object localObject2 = copySetValue(this.xFighter.getHandleonskillcausingdeath());
/*  836 */     for (mzm.gsp.fight.handle.SkillCausingDeathHandle localSkillCausingDeathHandle : (Set)localObject2) {
/*  837 */       localSkillCausingDeathHandle.skillCausingDeath(localInputObj, (mzm.gsp.fight.handle.SkillCausingDeathHandle.OutputObj)localObject1);
/*      */     }
/*  839 */     paramSkill.getAfterSkillUseFighterStatus().triggerpassiveskills.addAll(((mzm.gsp.fight.handle.SkillCausingDeathHandle.OutputObj)localObject1).releaserPassiveSkills);
/*      */   }
/*      */   
/*      */   public void handleDeathSkill(Fighter paramFighter, Skill paramSkill) {
/*  843 */     boolean bool1 = isRecordEnable();
/*  844 */     java.util.LinkedHashMap localLinkedHashMap = new java.util.LinkedHashMap();
/*  845 */     int i = 1;
/*  846 */     int j = paramFighter.getRound();
/*  847 */     for (Iterator localIterator1 = paramSkill.getDeathSkillWithCommonCD().entrySet().iterator(); localIterator1.hasNext();) { localObject1 = (Map.Entry)localIterator1.next();
/*  848 */       k = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
/*  849 */       localObject2 = (DeathBombing.DeathSkillCommonCDInputObj)((Map.Entry)localObject1).getValue();
/*  850 */       m = ((DeathBombing.DeathSkillCommonCDInputObj)localObject2).getSkill();
/*  851 */       Fighter localFighter1 = getFighter(k);
/*  852 */       if ((localFighter1 != null) && 
/*      */       
/*      */ 
/*  855 */         (!localFighter1.isAlive()))
/*      */       {
/*      */ 
/*  858 */         int i1 = localFighter1.getDeathSkillCommonEffectRound();
/*  859 */         if ((i1 <= 0) || (j - i1 >= ((DeathBombing.DeathSkillCommonCDInputObj)localObject2).getCDRound()))
/*      */         {
/*      */ 
/*  862 */           localObject4 = SkillInterface.getSkill(m, localFighter1.getLevel());
/*  863 */           ((Skill)localObject4).setPlayType(5);
/*  864 */           localFighter1.fillFighterStatus(((Skill)localObject4).getSkillUseFighterStatus());
/*  865 */           bool2 = false;
/*  866 */           ArrayList localArrayList = new ArrayList();
/*  867 */           for (Iterator localIterator2 = ((DeathBombing.DeathSkillCommonCDInputObj)localObject2).getTargets().iterator(); localIterator2.hasNext();) { int i4 = ((Integer)localIterator2.next()).intValue();
/*  868 */             Fighter localFighter2 = getFighter(i4);
/*  869 */             if ((localFighter2 != null) && (!localFighter2.isFakeDead()))
/*  870 */               if (!localFighter2.isDead())
/*      */               {
/*      */ 
/*  873 */                 int i5 = ((DeathBombing.DeathSkillCommonCDInputObj)localObject2).getDamage();
/*  874 */                 localFighter2.addHp(-i5);
/*  875 */                 AttackResultBean localAttackResultBean = ((Skill)localObject4).addDamageRet(i5, 0, false, false, localFighter1, localFighter2);
/*  876 */                 if ((localFighter2.isDead()) || (localFighter2.isFakeDead())) {
/*  877 */                   mzm.gsp.fight.handle.BeKilledHandle.OutPutObj localOutPutObj = localFighter2.handleBeKilled(new mzm.gsp.fight.handle.BeKilledHandle.InputObj(localFighter1, localFighter2, (Skill)localObject4, ((DeathBombing.DeathSkillCommonCDInputObj)localObject2).getDamage()));
/*  878 */                   ((Skill)localObject4).addTargetInfluenceMap(localFighter2, localFighter2.getInfluenceMap());
/*  879 */                   localFighter2.clearInfluenceTarget();
/*  880 */                   localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutPutObj.targetPassiveSkillids);
/*  881 */                   if (localFighter2.isAlive()) {
/*  882 */                     localAttackResultBean.targetstatus.status_set.remove(Integer.valueOf(1));
/*  883 */                     localAttackResultBean.targetstatus.status_set.add(Integer.valueOf(3));
/*  884 */                     FighterStatus localFighterStatus1 = new FighterStatus();
/*  885 */                     localFighterStatus1.status_set.add(Integer.valueOf(23));
/*  886 */                     FighterStatus localFighterStatus2 = localFighterStatus1;
/*  887 */                     localFighterStatus2.hpchange += localFighter2.getHp();
/*  888 */                     localFighter2.fillFighterStatus(localFighterStatus1);
/*  889 */                     localAttackResultBean.statusmap.put(Integer.valueOf(1), localFighterStatus1);
/*      */                   }
/*      */                 }
/*  892 */                 bool2 = true;
/*  893 */                 ((Skill)localObject4).getTargets().add(Integer.valueOf(i4));
/*  894 */                 localArrayList.add(localFighter2);
/*      */               }
/*      */           }
/*  897 */           if (bool2)
/*      */           {
/*      */ 
/*  900 */             localFighter1.addActionCount();
/*  901 */             localFighter1.fillFighterStatus(((Skill)localObject4).getAfterSkillUseFighterStatus());
/*      */             try {
/*  903 */               ((Skill)localObject4).calSkillPlayTime(localFighter1, localArrayList);
/*      */             }
/*      */             catch (Exception localException) {
/*  906 */               GameServer.logger().error("[Fight]Fighter.handleDeathSkill@calc play time error", localException);
/*  907 */               ((Skill)localObject4).addPlayTime(1500);
/*      */             }
/*  909 */             localFighter1.fightGroup.fightTeam.setDeathSkillCommonEffectRound(j);
/*  910 */             if (i != 0) {
/*  911 */               i = 0;
/*  912 */               int i3 = paramSkill.calFixTime(paramFighter);
/*  913 */               ((Skill)localObject4).addPlayTime(i3);
/*      */             }
/*  915 */             localLinkedHashMap.put(localObject4, localFighter1);
/*  916 */             paramSkill.putTrulyDeathSkill(k, ((Skill)localObject4).getID()); } } } }
/*      */     Object localObject1;
/*  918 */     int k; Object localObject2; int m; Object localObject4; boolean bool2; for (localIterator1 = paramSkill.getDeathSkillMap().entrySet().iterator(); localIterator1.hasNext();) { localObject1 = (Map.Entry)localIterator1.next();
/*  919 */       k = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
/*  920 */       localObject2 = (mzm.gsp.effect.fighter.DeathSkill.DeathSkillInputObj)((Map.Entry)localObject1).getValue();
/*  921 */       m = ((mzm.gsp.effect.fighter.DeathSkill.DeathSkillInputObj)localObject2).getSkill();
/*  922 */       int n = ((mzm.gsp.effect.fighter.DeathSkill.DeathSkillInputObj)localObject2).getMainTargetid();
/*  923 */       localObject3 = getFighter(k);
/*  924 */       if (localObject3 != null)
/*      */       {
/*      */ 
/*  927 */         if (((Fighter)localObject3).isAlive()) {
/*  928 */           ((Fighter)localObject3).resetDeathSkill();
/*      */         }
/*      */         else {
/*  931 */           localObject4 = SkillInterface.getSkill(m, ((Fighter)localObject3).getLevel());
/*  932 */           bool2 = handleDeathSkill((Skill)localObject4, (Fighter)localObject3, n, paramSkill, localLinkedHashMap);
/*  933 */           if ((bool2) && 
/*      */           
/*      */ 
/*  936 */             (i != 0))
/*      */           {
/*      */ 
/*  939 */             i = 0;
/*  940 */             int i2 = paramSkill.calFixTime(paramFighter);
/*  941 */             ((Skill)localObject4).addPlayTime(i2);
/*      */           } } } }
/*      */     Object localObject3;
/*  944 */     for (localIterator1 = localLinkedHashMap.entrySet().iterator(); localIterator1.hasNext();) { localObject1 = (Map.Entry)localIterator1.next();
/*  945 */       Skill localSkill = (Skill)((Map.Entry)localObject1).getKey();
/*  946 */       localObject2 = (Fighter)((Map.Entry)localObject1).getValue();
/*  947 */       handleDeathSkill((Fighter)localObject2, localSkill);
/*  948 */       m = ((Fighter)localObject2).getid();
/*  949 */       PlaySkill localPlaySkill1 = new PlaySkill();
/*  950 */       fillSkillResult(localPlaySkill1, localSkill, m);
/*  951 */       if (this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/*  952 */         localObject3 = new Play();
/*  953 */         ((Play)localObject3).play_type = 0;
/*  954 */         ((Play)localObject3).content = localPlaySkill1.marshal(new OctetsStream());
/*  955 */         localSkill.addPlayFirst((Play)localObject3, true);
/*  956 */         localSkill.addPlayFirst((Play)localObject3, false);
/*  957 */         if (bool1)
/*      */         {
/*      */ 
/*  960 */           localSkill.addPlayFirst((Play)localObject3);
/*      */         }
/*      */       } else {
/*  963 */         localObject3 = new Play();
/*  964 */         localObject4 = getOppsitePalySkill(localPlaySkill1, true);
/*  965 */         ((Play)localObject3).play_type = 0;
/*  966 */         ((Play)localObject3).content = ((PlaySkill)localObject4).marshal(new OctetsStream());
/*  967 */         localSkill.addPlayFirst((Play)localObject3, true);
/*  968 */         Play localPlay1 = new Play();
/*  969 */         PlaySkill localPlaySkill2 = getOppsitePalySkill(localPlaySkill1, false);
/*  970 */         localPlay1.play_type = 0;
/*  971 */         localPlay1.content = localPlaySkill2.marshal(new OctetsStream());
/*  972 */         localSkill.addPlayFirst(localPlay1, false);
/*  973 */         if (bool1)
/*      */         {
/*      */ 
/*  976 */           Play localPlay2 = new Play();
/*  977 */           localPlay2.play_type = 0;
/*  978 */           localPlay2.content = localPlaySkill1.marshal(new OctetsStream());
/*  979 */           localSkill.addPlayFirst(localPlay2);
/*      */         }
/*      */       } }
/*  982 */     for (localIterator1 = localLinkedHashMap.keySet().iterator(); localIterator1.hasNext();) { localObject1 = (Skill)localIterator1.next();
/*  983 */       paramSkill.addAllPlay(((Skill)localObject1).getActivePlays(), true);
/*  984 */       paramSkill.addAllPlay(((Skill)localObject1).getPassivePlays(), false);
/*  985 */       if (bool1) {
/*  986 */         paramSkill.addAllPlay(((Skill)localObject1).getRecordPlays());
/*      */       }
/*  988 */       paramSkill.addPlayTime(((Skill)localObject1).getPlayTime());
/*      */     }
/*      */   }
/*      */   
/*      */   public PlaySkill getOppsitePalySkill(PlaySkill paramPlaySkill, boolean paramBoolean) {
/*  993 */     int i = paramPlaySkill.fighterid;
/*  994 */     boolean bool1 = this.fightGroup.fightTeam.fight.isInActiveTime(i);
/*  995 */     HashMap localHashMap1 = new HashMap();
/*  996 */     handleOppisiteAttackResult(localHashMap1, paramPlaySkill.status_map, paramBoolean, bool1);
/*  997 */     HashMap localHashMap2 = new HashMap();
/*  998 */     handleOppisiteHitAginMap(localHashMap2, paramPlaySkill.hitagain_map, paramBoolean, bool1);
/*  999 */     HashMap localHashMap3 = new HashMap();
/* 1000 */     for (Object localObject1 = paramPlaySkill.protect_map.entrySet().iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (Map.Entry)((Iterator)localObject1).next();
/* 1001 */       localObject3 = handleOppisiteProtect((Protect)((Map.Entry)localObject2).getValue(), paramBoolean);
/* 1002 */       localHashMap3.put(((Map.Entry)localObject2).getKey(), localObject3);
/*      */     }
/* 1004 */     localObject1 = new HashMap();
/* 1005 */     for (Object localObject2 = paramPlaySkill.influencemap.entrySet().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (Map.Entry)((Iterator)localObject2).next();
/* 1006 */       InfluenceOther localInfluenceOther = handleOppisiteInfluenceOther((InfluenceOther)((Map.Entry)localObject3).getValue(), paramBoolean);
/* 1007 */       ((HashMap)localObject1).put(((Map.Entry)localObject3).getKey(), localInfluenceOther);
/*      */     }
/* 1009 */     localObject2 = null;
/* 1010 */     Object localObject3 = null;
/* 1011 */     boolean bool2 = paramBoolean ^ bool1;
/* 1012 */     if (bool2) {
/* 1013 */       localObject2 = Fight.copyFighterStatusIgnoreHpMpAnger(paramPlaySkill.releaser);
/* 1014 */       localObject3 = Fight.copyFighterStatusIgnoreHpMpAnger(paramPlaySkill.afterreleaser);
/*      */     }
/*      */     else {
/* 1017 */       localObject2 = paramPlaySkill.releaser;
/* 1018 */       localObject3 = paramPlaySkill.afterreleaser;
/*      */     }
/* 1020 */     PlaySkill localPlaySkill = new PlaySkill(paramPlaySkill.fighterid, paramPlaySkill.skill, paramPlaySkill.skillplaytype, paramPlaySkill.extra, (FighterStatus)localObject2, (FighterStatus)localObject3, paramPlaySkill.targets, localHashMap1, localHashMap2, localHashMap3, (HashMap)localObject1, paramPlaySkill.deathfighter2skills);
/* 1021 */     return localPlaySkill;
/*      */   }
/*      */   
/*      */   private void handleOppisiteHitAginMap(HashMap<Integer, mzm.gsp.fight.HitAgain> paramHashMap1, HashMap<Integer, mzm.gsp.fight.HitAgain> paramHashMap2, boolean paramBoolean1, boolean paramBoolean2) {
/* 1025 */     for (Map.Entry localEntry1 : paramHashMap2.entrySet()) {
/* 1026 */       int i = ((Integer)localEntry1.getKey()).intValue();
/* 1027 */       mzm.gsp.fight.HitAgain localHitAgain = (mzm.gsp.fight.HitAgain)localEntry1.getValue();
/* 1028 */       HashMap localHashMap1 = new HashMap();
/* 1029 */       handleOppisiteAttackResult(localHashMap1, localHitAgain.status_map, paramBoolean1, paramBoolean2);
/* 1030 */       HashMap localHashMap2 = new HashMap();
/* 1031 */       for (Object localObject = localHitAgain.influencemap.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry2 = (Map.Entry)((Iterator)localObject).next();
/* 1032 */         InfluenceOther localInfluenceOther = handleOppisiteInfluenceOther((InfluenceOther)localEntry2.getValue(), paramBoolean1);
/* 1033 */         localHashMap2.put(localEntry2.getKey(), localInfluenceOther);
/*      */       }
/* 1035 */       localObject = new mzm.gsp.fight.HitAgain(localHitAgain.targets, localHashMap1, localHashMap2);
/* 1036 */       paramHashMap1.put(Integer.valueOf(i), localObject);
/*      */     }
/*      */   }
/*      */   
/*      */   private void handleOppisiteAttackResult(HashMap<Integer, mzm.gsp.fight.AttackResult> paramHashMap1, HashMap<Integer, mzm.gsp.fight.AttackResult> paramHashMap2, boolean paramBoolean1, boolean paramBoolean2) {
/* 1041 */     for (Map.Entry localEntry : paramHashMap2.entrySet()) {
/* 1042 */       int i = ((Integer)localEntry.getKey()).intValue();
/* 1043 */       localAttackResult1 = new mzm.gsp.fight.AttackResult();
/* 1044 */       paramHashMap1.put(Integer.valueOf(i), localAttackResult1);
/* 1045 */       boolean bool1 = this.fightGroup.fightTeam.fight.isInActiveTime(i);
/* 1046 */       bool2 = bool1 ^ paramBoolean1;
/* 1047 */       mzm.gsp.fight.AttackResult localAttackResult2 = (mzm.gsp.fight.AttackResult)localEntry.getValue();
/* 1048 */       for (AttackResultBean localAttackResultBean : localAttackResult2.attackresultbeans) {
/* 1049 */         FighterStatus localFighterStatus1 = null;
/* 1050 */         boolean bool3 = paramBoolean1 ^ paramBoolean2;
/* 1051 */         if (bool3) {
/* 1052 */           localFighterStatus1 = Fight.copyFighterStatusIgnoreHpMpAnger(localAttackResultBean.attackerstatus);
/*      */         }
/*      */         else {
/* 1055 */           localFighterStatus1 = localAttackResultBean.attackerstatus;
/*      */         }
/* 1057 */         LinkedList localLinkedList1 = new LinkedList();
/* 1058 */         for (Object localObject1 = localAttackResultBean.attackothers.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (AttackOtherBean)((Iterator)localObject1).next();
/* 1059 */           int j = ((AttackOtherBean)localObject2).targetid;
/* 1060 */           boolean bool4 = this.fightGroup.fightTeam.fight.isInActiveTime(j);
/* 1061 */           localObject3 = null;
/* 1062 */           if (bool3) {
/* 1063 */             localObject3 = Fight.copyFighterStatusIgnoreHpMpAnger(((AttackOtherBean)localObject2).attackinnerbean.attackerstatus);
/*      */           }
/*      */           else {
/* 1066 */             localObject3 = ((AttackOtherBean)localObject2).attackinnerbean.attackerstatus;
/*      */           }
/* 1068 */           FighterStatus localFighterStatus3 = null;
/* 1069 */           boolean bool5 = paramBoolean1 ^ bool4;
/* 1070 */           if (bool5) {
/* 1071 */             localFighterStatus3 = Fight.copyFighterStatusIgnoreHpMpAnger(((AttackOtherBean)localObject2).attackinnerbean.targetstatus);
/*      */           }
/*      */           else {
/* 1074 */             localFighterStatus3 = ((AttackOtherBean)localObject2).attackinnerbean.targetstatus;
/*      */           }
/* 1076 */           CounterAttack localCounterAttack = handleOppisiteCounterAttack(((AttackOtherBean)localObject2).attackinnerbean.counterattack, paramBoolean1, bool3, bool5);
/* 1077 */           LinkedList localLinkedList2 = handleOppisiteShareDamage(((AttackOtherBean)localObject2).attackinnerbean.sharedamagetargets, paramBoolean1, bool3);
/* 1078 */           HashMap localHashMap2 = handleOppisiteEnumStatus(((AttackOtherBean)localObject2).attackinnerbean.statusmap, bool3, bool5);
/* 1079 */           InfluenceOther localInfluenceOther = handleOppisiteInfluenceOther(((AttackOtherBean)localObject2).influenceothers, paramBoolean1);
/* 1080 */           Protect localProtect = handleOppisiteProtect(((AttackOtherBean)localObject2).protect, paramBoolean1);
/* 1081 */           mzm.gsp.fight.AttackOtherBeanResult localAttackOtherBeanResult = new mzm.gsp.fight.AttackOtherBeanResult((FighterStatus)localObject3, localFighterStatus3, localLinkedList2, localCounterAttack, localHashMap2);
/* 1082 */           AttackOtherBean localAttackOtherBean = new AttackOtherBean(((AttackOtherBean)localObject2).targetid, localAttackOtherBeanResult, localInfluenceOther, localProtect);
/* 1083 */           localLinkedList1.add(localAttackOtherBean);
/*      */         }
/* 1085 */         localObject1 = handleOppisiteCounterAttack(localAttackResultBean.counterattack, paramBoolean1, bool3, bool2);
/* 1086 */         Object localObject2 = handleOppisiteShareDamage(localAttackResultBean.sharedamagetargets, paramBoolean1, bool3);
/* 1087 */         HashMap localHashMap1 = handleOppisiteEnumStatus(localAttackResultBean.statusmap, bool3, bool2);
/* 1088 */         FighterStatus localFighterStatus2 = null;
/* 1089 */         if (bool2) {
/* 1090 */           localFighterStatus2 = Fight.copyFighterStatusIgnoreHpMpAnger(localAttackResultBean.targetstatus);
/*      */         }
/*      */         else {
/* 1093 */           localFighterStatus2 = localAttackResultBean.targetstatus;
/*      */         }
/* 1095 */         Object localObject3 = new AttackResultBean(localFighterStatus1, localFighterStatus2, (LinkedList)localObject2, (CounterAttack)localObject1, localHashMap1, localLinkedList1);
/* 1096 */         localAttackResult1.attackresultbeans.add(localObject3);
/*      */       }
/*      */     }
/*      */     mzm.gsp.fight.AttackResult localAttackResult1;
/*      */     boolean bool2; }
/*      */   
/* 1102 */   private Protect handleOppisiteProtect(Protect paramProtect, boolean paramBoolean) { ArrayList localArrayList = new ArrayList();
/* 1103 */     Object localObject1; Object localObject2; for (int i = 0; i < paramProtect.protecterids.size(); i++) {
/* 1104 */       int j = ((Integer)paramProtect.protecterids.get(i)).intValue();
/* 1105 */       if (i < paramProtect.protecterstatuses.size()) {
/* 1106 */         localObject1 = (FighterStatus)paramProtect.protecterstatuses.get(i);
/* 1107 */         boolean bool = this.fightGroup.fightTeam.fight.isInActiveTime(j);
/* 1108 */         localObject2 = null;
/* 1109 */         if ((bool ^ paramBoolean)) {
/* 1110 */           localObject2 = Fight.copyFighterStatusIgnoreHpMpAnger((FighterStatus)localObject1);
/*      */         }
/*      */         else {
/* 1113 */           localObject2 = localObject1;
/*      */         }
/* 1115 */         if (localObject2 != null) {
/* 1116 */           localArrayList.add(localObject1);
/*      */         }
/*      */       }
/*      */     }
/* 1120 */     HashMap localHashMap = new HashMap();
/* 1121 */     for (Iterator localIterator = paramProtect.influencemap.entrySet().iterator(); localIterator.hasNext();) { localObject1 = (Map.Entry)localIterator.next();
/* 1122 */       int k = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
/* 1123 */       localObject2 = handleOppisiteInfluenceOther((InfluenceOther)((Map.Entry)localObject1).getValue(), paramBoolean);
/* 1124 */       localHashMap.put(Integer.valueOf(k), localObject2);
/*      */     }
/* 1126 */     return new Protect(paramProtect.protecterids, localArrayList, localHashMap);
/*      */   }
/*      */   
/*      */   public LinkedList<ShareDamageRet> handleOppisiteShareDamage(LinkedList<ShareDamageRet> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2) {
/* 1130 */     LinkedList localLinkedList = new LinkedList();
/* 1131 */     for (ShareDamageRet localShareDamageRet1 : paramLinkedList) {
/* 1132 */       FighterStatus localFighterStatus = null;
/* 1133 */       boolean bool1 = this.fightGroup.fightTeam.fight.isInActiveTime(localShareDamageRet1.targetid);
/* 1134 */       boolean bool2 = paramBoolean1 ^ bool1;
/* 1135 */       if (bool2) {
/* 1136 */         localFighterStatus = Fight.copyFighterStatusIgnoreHpMpAnger(localShareDamageRet1.sharedamagestatus);
/*      */       }
/*      */       else {
/* 1139 */         localFighterStatus = localShareDamageRet1.sharedamagestatus;
/*      */       }
/* 1141 */       HashMap localHashMap = handleOppisiteEnumStatus(localShareDamageRet1.statusmap, paramBoolean2, bool2);
/* 1142 */       ShareDamageRet localShareDamageRet2 = new ShareDamageRet(localShareDamageRet1.targetid, localFighterStatus, localHashMap);
/* 1143 */       localLinkedList.add(localShareDamageRet2);
/*      */     }
/* 1145 */     return localLinkedList;
/*      */   }
/*      */   
/*      */   public CounterAttack handleOppisiteCounterAttack(CounterAttack paramCounterAttack, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 1149 */     if (paramCounterAttack.skill <= 0) {
/* 1150 */       return paramCounterAttack;
/*      */     }
/* 1152 */     FighterStatus localFighterStatus1 = null;
/* 1153 */     if (paramBoolean3) {
/* 1154 */       localFighterStatus1 = Fight.copyFighterStatusIgnoreHpMpAnger(paramCounterAttack.attackerstatus);
/*      */     }
/*      */     else {
/* 1157 */       localFighterStatus1 = paramCounterAttack.attackerstatus;
/*      */     }
/* 1159 */     FighterStatus localFighterStatus2 = null;
/* 1160 */     if (paramBoolean2) {
/* 1161 */       localFighterStatus2 = Fight.copyFighterStatusIgnoreHpMpAnger(paramCounterAttack.targetstatus);
/*      */     }
/*      */     else {
/* 1164 */       localFighterStatus2 = paramCounterAttack.targetstatus;
/*      */     }
/* 1166 */     InfluenceOther localInfluenceOther = handleOppisiteInfluenceOther(paramCounterAttack.influences, paramBoolean1);
/* 1167 */     HashMap localHashMap = handleOppisiteEnumStatus(paramCounterAttack.statusmap, paramBoolean3, paramBoolean2);
/* 1168 */     return new CounterAttack(paramCounterAttack.skill, localFighterStatus1, localFighterStatus2, localHashMap, localInfluenceOther);
/*      */   }
/*      */   
/*      */   public InfluenceOther handleOppisiteInfluenceOther(InfluenceOther paramInfluenceOther, boolean paramBoolean) {
/* 1172 */     HashMap localHashMap = handleOppisiteOtherStatus(paramInfluenceOther.othermap, paramBoolean);
/* 1173 */     return new InfluenceOther(localHashMap);
/*      */   }
/*      */   
/*      */   private HashMap<Integer, FighterStatus> handleOppisiteEnumStatus(Map<Integer, FighterStatus> paramMap, boolean paramBoolean1, boolean paramBoolean2) {
/* 1177 */     HashMap localHashMap = new HashMap();
/* 1178 */     for (Map.Entry localEntry : paramMap.entrySet()) {
/* 1179 */       int i = ((Integer)localEntry.getKey()).intValue();
/* 1180 */       boolean bool = false;
/* 1181 */       switch (i) {
/*      */       case 0: 
/* 1183 */         bool = paramBoolean1;
/* 1184 */         break;
/*      */       
/*      */       case 2: 
/* 1187 */         bool = paramBoolean1;
/* 1188 */         break;
/*      */       
/*      */       case 1: 
/* 1191 */         bool = paramBoolean2;
/*      */       }
/*      */       
/*      */       
/* 1195 */       FighterStatus localFighterStatus = (FighterStatus)localEntry.getValue();
/* 1196 */       if (bool) {
/* 1197 */         localHashMap.put(Integer.valueOf(i), Fight.copyFighterStatusIgnoreHpMpAnger(localFighterStatus));
/*      */       }
/*      */       else {
/* 1200 */         localHashMap.put(Integer.valueOf(i), localFighterStatus);
/*      */       }
/*      */     }
/* 1203 */     return localHashMap;
/*      */   }
/*      */   
/*      */   private HashMap<Integer, FighterStatus> handleOppisiteOtherStatus(Map<Integer, FighterStatus> paramMap, boolean paramBoolean) {
/* 1207 */     HashMap localHashMap = new HashMap();
/* 1208 */     for (Map.Entry localEntry : paramMap.entrySet()) {
/* 1209 */       int i = ((Integer)localEntry.getKey()).intValue();
/* 1210 */       boolean bool1 = this.fightGroup.fightTeam.fight.isInActiveTime(i);
/* 1211 */       boolean bool2 = paramBoolean ^ bool1;
/* 1212 */       FighterStatus localFighterStatus = (FighterStatus)localEntry.getValue();
/* 1213 */       if (bool2) {
/* 1214 */         localHashMap.put(Integer.valueOf(i), Fight.copyFighterStatusIgnoreHpMpAnger(localFighterStatus));
/*      */       }
/*      */       else {
/* 1217 */         localHashMap.put(Integer.valueOf(i), localFighterStatus);
/*      */       }
/*      */     }
/* 1220 */     return localHashMap;
/*      */   }
/*      */   
/*      */   private boolean handleDeathSkill(Skill paramSkill1, Fighter paramFighter, int paramInt, Skill paramSkill2, Map<Skill, Fighter> paramMap) {
/* 1224 */     paramSkill1.setPlayType(4);
/* 1225 */     List localList = paramSkill1.getTargets(paramFighter, paramInt, false);
/* 1226 */     if (localList.size() <= 0) {
/* 1227 */       return false;
/*      */     }
/* 1229 */     paramFighter.fillFighterStatus(paramSkill1.getSkillUseFighterStatus());
/* 1230 */     paramSkill1.skillOnTarget(paramFighter, localList);
/* 1231 */     addActionCount();
/* 1232 */     paramFighter.fillFighterStatus(paramSkill1.getAfterSkillUseFighterStatus());
/* 1233 */     paramMap.put(paramSkill1, paramFighter);
/* 1234 */     paramSkill2.putTrulyDeathSkill(paramFighter.getid(), paramSkill1.getID());
/* 1235 */     int i = mzm.gsp.fight.durationCfg.DurationCfgManager.getActionDuration(paramFighter.getModelid(), SFightConsts.getInstance().DEATH_ACTION_ID);
/* 1236 */     paramSkill1.addPlayTime(i);
/* 1237 */     paramSkill1.addAllCounterAttackMultiPlayType(paramFighter);
/* 1238 */     return true;
/*      */   }
/*      */   
/*      */   protected void resetDeathSkill() {
/* 1242 */     Set localSet = copySetValue(this.xFighter.getHandleonbekilled());
/* 1243 */     for (mzm.gsp.fight.handle.BeKilledHandle localBeKilledHandle : localSet) {
/* 1244 */       if ((localBeKilledHandle instanceof mzm.gsp.effect.fighter.DeathSkill)) {
/* 1245 */         mzm.gsp.effect.fighter.DeathSkill localDeathSkill = (mzm.gsp.effect.fighter.DeathSkill)localBeKilledHandle;
/* 1246 */         localDeathSkill.resetEffect();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   protected boolean validateCDSkill(int paramInt) {
/* 1252 */     xbean.SkillData localSkillData = (xbean.SkillData)this.xFighter.getSkilldatas().get(Integer.valueOf(paramInt));
/* 1253 */     if (localSkillData != null) {
/* 1254 */       SSkillCfg localSSkillCfg = SSkillCfg.get(paramInt);
/* 1255 */       if ((localSSkillCfg.cdRound >= getRound() - localSkillData.getUseround()) && (localSkillData.getUseround() > 0)) {
/* 1256 */         GameServer.logger().info("技能在cd中,不能使用!!!");
/* 1257 */         return false;
/*      */       }
/* 1259 */       if ((localSSkillCfg.useCountInFight <= localSkillData.getUsecount()) && (localSSkillCfg.useCountInFight > 0)) {
/* 1260 */         GameServer.logger().info(String.format("[Fight]Fighter.validateCDSkill@技能已经到达了战斗中使用的最大次数!!!|skillid=%d|fightType=%d|fightUUid=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xFighter.getType()), Long.valueOf(this.fightGroup.fightTeam.fight.fightid) }));
/* 1261 */         return false;
/*      */       }
/*      */     }
/* 1264 */     return true;
/*      */   }
/*      */   
/*      */   protected boolean canChoiceSkill(Skill paramSkill) {
/* 1268 */     int i = paramSkill.getID();
/* 1269 */     return (hasSkill(i)) && (isSkillCostEnough(paramSkill)) && ((!isInvisible()) || (isStrengInvisible())) && (validateCDSkill(i));
/*      */   }
/*      */   
/*      */   public boolean canNormalUseSkillWithRestWeak(Skill paramSkill) {
/* 1273 */     return (isOperable()) && (!isMess()) && (!isTaunt()) && (!isStone()) && (!isIceCool()) && (!isSleep()) && ((!isInvisible()) || (isStrengInvisible()) || (FightInterface.isNormalAttackSkill(paramSkill.getID()))) && ((!isSeal()) || (!isSealedSkill(paramSkill)));
/*      */   }
/*      */   
/*      */   public boolean canNomalUseSkill(Skill paramSkill) {
/* 1277 */     return (isOperable()) && (!isMess()) && (!isTaunt()) && (nowStateCanUseSkill(paramSkill));
/*      */   }
/*      */   
/*      */   protected boolean nowStateCanUseSkill(Skill paramSkill) {
/* 1281 */     return (!isWeak()) && (!isStone()) && (!isIceCool()) && (!isSleep()) && ((!isRest()) || (paramSkill.getID() == SFightConsts.getInstance().DEFENCE_SKILL)) && ((!isInvisible()) || (FightInterface.isNormalAttackSkill(paramSkill.getID()))) && ((!isSeal()) || (!isSealedSkill(paramSkill)));
/*      */   }
/*      */   
/*      */   private boolean handleComplexSkill(int paramInt1, int paramInt2, ExcuteCmdResult paramExcuteCmdResult) {
/* 1285 */     mzm.gsp.skill.confbean.SComplexSkillCfg localSComplexSkillCfg = mzm.gsp.skill.confbean.SComplexSkillCfg.get(paramInt1);
/* 1286 */     if (localSComplexSkillCfg == null) {
/* 1287 */       return false;
/*      */     }
/* 1289 */     int i = localSComplexSkillCfg.skillid;
/* 1290 */     Set localSet = getFriendLiveFighters();
/* 1291 */     ArrayList localArrayList = new ArrayList();
/* 1292 */     for (Fighter localFighter : localSet)
/* 1293 */       if (localFighter.getid() != this.fighterid)
/* 1294 */         if ((localFighter.isRole()) && 
/*      */         
/*      */ 
/* 1297 */           ((localSComplexSkillCfg.occupation == 0) || (localSComplexSkillCfg.occupation == localFighter.getOccupation())) && (localFighter.hasSkill(i)))
/*      */         {
/*      */ 
/* 1300 */           localObject = SkillInterface.getSkill(i, getSkillLevel(i));
/* 1301 */           if ((localFighter.canNomalUseSkill((Skill)localObject)) && (localFighter.isSkillCostEnough((Skill)localObject)))
/*      */           {
/*      */ 
/* 1304 */             localArrayList.add(localFighter); }
/*      */         }
/*      */     Object localObject;
/* 1307 */     if (localArrayList.size() <= 0) {
/* 1308 */       return false;
/*      */     }
/* 1310 */     int j = xdb.Xdb.random().nextInt(FightArgs.getInstance().defaultRate) < localSComplexSkillCfg.probable ? 1 : 0;
/* 1311 */     if (j != 0) {
/* 1312 */       int k = xdb.Xdb.random().nextInt(localArrayList.size());
/* 1313 */       localObject = (Fighter)localArrayList.get(k);
/* 1314 */       i = getFightStateComplextSkillId(paramInt1, (Fighter)localObject);
/* 1315 */       int m = getSkillLevel(i);
/* 1316 */       Skill localSkill = SkillInterface.getSkill(i, m);
/* 1317 */       List localList = localSkill.getTargets((Fighter)localObject, paramInt2, false);
/* 1318 */       if (!localSkill.canRun((Fighter)localObject, paramInt2, localList, false)) {
/* 1319 */         return false;
/*      */       }
/* 1321 */       localSkill.setPlayType(1);
/* 1322 */       localSkill.addExtraPLayData(501, this.fighterid);
/* 1323 */       localSkill.addExtraPLayData(502, paramInt1);
/* 1324 */       ((Fighter)localObject).fillFighterStatus(localSkill.getSkillUseFighterStatus());
/* 1325 */       localSkill.skillOnTarget((Fighter)localObject, localList);
/* 1326 */       addActionCount();
/* 1327 */       ((Fighter)localObject).fillFighterStatus(localSkill.getAfterSkillUseFighterStatus());
/* 1328 */       ((Fighter)localObject).handleDeathSkill((Fighter)localObject, localSkill);
/* 1329 */       ((Fighter)localObject).fillSkillResult(localSkill, paramExcuteCmdResult);
/* 1330 */       localSkill.addAllCounterAttackMultiPlayType((Fighter)localObject);
/*      */     }
/* 1332 */     return true;
/*      */   }
/*      */   
/*      */   void setLastCanAutoSkill(int paramInt) {}
/*      */   
/*      */   protected final boolean isSealPhy()
/*      */   {
/* 1339 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1340 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1341 */         if ((localFighterEffect instanceof Seal)) {
/* 1342 */           Seal localSeal = (Seal)localFighterEffect;
/* 1343 */           if (localSeal.isSealPHYSkill()) {
/* 1344 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1350 */     return false;
/*      */   }
/*      */   
/*      */   protected final boolean isSealMgc() {
/* 1354 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1355 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1356 */         if ((localFighterEffect instanceof Seal)) {
/* 1357 */           Seal localSeal = (Seal)localFighterEffect;
/* 1358 */           if (localSeal.isSealMAGSkill()) {
/* 1359 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1365 */     return false;
/*      */   }
/*      */   
/*      */   protected final boolean isSealSpecial() {
/* 1369 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1370 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1371 */         if ((localFighterEffect instanceof Seal)) {
/* 1372 */           Seal localSeal = (Seal)localFighterEffect;
/* 1373 */           if (localSeal.isSealSpecialSkill()) {
/* 1374 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1380 */     return false;
/*      */   }
/*      */   
/*      */   protected final boolean isSealNormal() {
/* 1384 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1385 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1386 */         if ((localFighterEffect instanceof Seal)) {
/* 1387 */           Seal localSeal = (Seal)localFighterEffect;
/* 1388 */           if (localSeal.isSealNormalSKill()) {
/* 1389 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1395 */     return false;
/*      */   }
/*      */   
/*      */   protected final boolean isSealDefence() {
/* 1399 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1400 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1401 */         if ((localFighterEffect instanceof Seal)) {
/* 1402 */           Seal localSeal = (Seal)localFighterEffect;
/* 1403 */           if (localSeal.isSealDefenceSkill()) {
/* 1404 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1410 */     return false;
/*      */   }
/*      */   
/*      */   protected final boolean isSealedSkill(Skill paramSkill) {
/* 1414 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1415 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1416 */         if ((localFighterEffect instanceof Seal)) {
/* 1417 */           Seal localSeal = (Seal)localFighterEffect;
/* 1418 */           if (FightInterface.isNormalAttackSkill(paramSkill.getID())) {
/* 1419 */             if (localSeal.isSealNormalSKill()) {
/* 1420 */               return true;
/*      */             }
/*      */             
/*      */           }
/* 1424 */           else if (paramSkill.getID() == SFightConsts.getInstance().DEFENCE_SKILL) {
/* 1425 */             if (localSeal.isSealDefenceSkill()) {
/* 1426 */               return true;
/*      */             }
/*      */             
/*      */           }
/* 1430 */           else if (paramSkill.getType() == 4) {
/* 1431 */             if (localSeal.isSealSpecialSkill()) {
/* 1432 */               return true;
/*      */             }
/*      */             
/*      */           }
/* 1436 */           else if (paramSkill.getType() == 1) {
/* 1437 */             if (localSeal.isSealPHYSkill()) {
/* 1438 */               return true;
/*      */             }
/*      */             
/*      */           }
/* 1442 */           else if (paramSkill.getType() == 2) {
/* 1443 */             if (localSeal.isSealMAGSkill()) {
/* 1444 */               return true;
/*      */             }
/*      */             
/*      */ 
/*      */           }
/* 1449 */           else if ((paramSkill.getType() == 8) && (localSeal.isSealOther())) {
/* 1450 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1457 */     return false;
/*      */   }
/*      */   
/*      */   protected boolean isSealUseDrag() {
/* 1461 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1462 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1463 */         if ((localFighterEffect instanceof Seal)) {
/* 1464 */           Seal localSeal = (Seal)localFighterEffect;
/* 1465 */           if (localSeal.isSealUseItem()) {
/* 1466 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1472 */     return false;
/*      */   }
/*      */   
/*      */   protected boolean isSealEscape() {
/* 1476 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1477 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1478 */         if ((localFighterEffect instanceof Seal)) {
/* 1479 */           Seal localSeal = (Seal)localFighterEffect;
/* 1480 */           if (localSeal.isSealRunAway()) {
/* 1481 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1487 */     return false;
/*      */   }
/*      */   
/*      */   protected boolean isSealProtect() {
/* 1491 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1492 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1493 */         if ((localFighterEffect instanceof Seal)) {
/* 1494 */           Seal localSeal = (Seal)localFighterEffect;
/* 1495 */           if (localSeal.isSealProtect()) {
/* 1496 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1502 */     return false;
/*      */   }
/*      */   
/*      */   protected boolean isSealSummon() {
/* 1506 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1507 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1508 */         if ((localFighterEffect instanceof Seal)) {
/* 1509 */           Seal localSeal = (Seal)localFighterEffect;
/* 1510 */           if (localSeal.isSealSummon()) {
/* 1511 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1517 */     return false;
/*      */   }
/*      */   
/*      */   protected final int getHouFaSkill() {
/* 1521 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1522 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1523 */         if ((localFighterEffect instanceof mzm.gsp.effect.fighter.HouFa)) {
/* 1524 */           mzm.gsp.effect.fighter.HouFa localHouFa = (mzm.gsp.effect.fighter.HouFa)localFighterEffect;
/* 1525 */           return localHouFa.getskillid();
/*      */         }
/*      */       }
/*      */     }
/* 1529 */     return 0;
/*      */   }
/*      */   
/*      */   public final FighterBuff getHouFaBuff() {
/* 1533 */     for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1534 */       for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1535 */         if ((localFighterEffect instanceof mzm.gsp.effect.fighter.HouFa)) {
/* 1536 */           return localFighterEffect.getGroup();
/*      */         }
/*      */       }
/*      */     }
/* 1540 */     return null;
/*      */   }
/*      */   
/*      */   public static void fillSkillResult(PlaySkill paramPlaySkill, Skill paramSkill, int paramInt) {
/* 1544 */     paramPlaySkill.fighterid = paramInt;
/* 1545 */     paramPlaySkill.skill = paramSkill.getID();
/* 1546 */     paramPlaySkill.skillplaytype = paramSkill.getPlayType();
/* 1547 */     paramPlaySkill.extra = paramSkill.getExtra();
/* 1548 */     paramPlaySkill.releaser = paramSkill.getSkillUseFighterStatus();
/* 1549 */     paramPlaySkill.afterreleaser = paramSkill.getAfterSkillUseFighterStatus();
/* 1550 */     paramPlaySkill.targets.addAll(paramSkill.getTargets());
/* 1551 */     paramPlaySkill.status_map.putAll(paramSkill.getAttackResultMap());
/* 1552 */     paramPlaySkill.hitagain_map.putAll(paramSkill.getHitAgainMap());
/* 1553 */     paramPlaySkill.protect_map.putAll(paramSkill.getProtectMap());
/* 1554 */     for (Iterator localIterator = paramSkill.getDeathFighter2Skillid().entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 1555 */       mzm.gsp.fight.Skillids localSkillids = new mzm.gsp.fight.Skillids();
/* 1556 */       localSkillids.skilllist.addAll((java.util.Collection)localEntry.getValue());
/* 1557 */       paramPlaySkill.deathfighter2skills.put(localEntry.getKey(), localSkillids); }
/*      */     Map.Entry localEntry;
/* 1559 */     for (localIterator = paramSkill.getTargetInfluenceMap().entrySet().iterator(); localIterator.hasNext();) { localEntry = (Map.Entry)localIterator.next();
/* 1560 */       int i = ((Integer)localEntry.getKey()).intValue();
/* 1561 */       InfluenceOther localInfluenceOther = new InfluenceOther();
/* 1562 */       localInfluenceOther.othermap.putAll((Map)localEntry.getValue());
/* 1563 */       paramPlaySkill.influencemap.put(Integer.valueOf(i), localInfluenceOther);
/*      */     }
/*      */   }
/*      */   
/*      */   final void fillSkillResult(Skill paramSkill, ExcuteCmdResult paramExcuteCmdResult) {
/* 1568 */     boolean bool = isRecordEnable();
/* 1569 */     int i = this.fighterid;
/* 1570 */     PlaySkill localPlaySkill1 = new PlaySkill();
/* 1571 */     fillSkillResult(localPlaySkill1, paramSkill, i);
/* 1572 */     paramExcuteCmdResult.setNeedReexcute(false);
/* 1573 */     paramExcuteCmdResult.addPlayTime(paramSkill.getPlayTime());
/* 1574 */     Play localPlay1; if (this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/* 1575 */       localPlay1 = new Play();
/* 1576 */       localPlay1.play_type = 0;
/* 1577 */       localPlay1.content = localPlaySkill1.marshal(new OctetsStream());
/* 1578 */       paramExcuteCmdResult.addPlay(localPlay1, true);
/* 1579 */       paramExcuteCmdResult.addPlay(localPlay1, false);
/* 1580 */       if (bool) {
/* 1581 */         paramExcuteCmdResult.addPlay(localPlay1);
/*      */       }
/*      */     }
/*      */     else {
/* 1585 */       localPlay1 = new Play();
/* 1586 */       PlaySkill localPlaySkill2 = getOppsitePalySkill(localPlaySkill1, true);
/* 1587 */       localPlay1.play_type = 0;
/* 1588 */       localPlay1.content = localPlaySkill2.marshal(new OctetsStream());
/* 1589 */       paramExcuteCmdResult.addPlay(localPlay1, true);
/* 1590 */       Play localPlay2 = new Play();
/* 1591 */       PlaySkill localPlaySkill3 = getOppsitePalySkill(localPlaySkill1, false);
/* 1592 */       localPlay2.play_type = 0;
/* 1593 */       localPlay2.content = localPlaySkill3.marshal(new OctetsStream());
/* 1594 */       paramExcuteCmdResult.addPlay(localPlay2, false);
/* 1595 */       if (bool) {
/* 1596 */         Play localPlay3 = new Play();
/* 1597 */         localPlay3.play_type = 0;
/* 1598 */         localPlay3.content = localPlaySkill1.marshal(new OctetsStream());
/* 1599 */         paramExcuteCmdResult.addPlay(localPlay3);
/*      */       }
/*      */     }
/* 1602 */     paramExcuteCmdResult.addAllPlay(paramSkill.getActivePlays(), true);
/* 1603 */     paramExcuteCmdResult.addAllPlay(paramSkill.getPassivePlays(), false);
/* 1604 */     if (bool) {
/* 1605 */       paramExcuteCmdResult.addAllPlay(paramSkill.getRecordPlays());
/*      */     }
/*      */   }
/*      */   
/*      */   public static final void addFighterStatusBuffbean(FighterStatus paramFighterStatus, Buff paramBuff) {
/* 1610 */     Iterator localIterator = paramFighterStatus.buffs.iterator();
/* 1611 */     while (localIterator.hasNext()) {
/* 1612 */       Buff localBuff = (Buff)localIterator.next();
/* 1613 */       if ((localBuff.buffid < 0) && (localBuff.buffid == paramBuff.buffid)) {
/* 1614 */         localIterator.remove();
/*      */       }
/*      */     }
/* 1617 */     paramFighterStatus.buffs.add(paramBuff);
/*      */   }
/*      */   
/*      */   final void fillPlayUseItemResult(Play paramPlay, int paramInt1, FighterStatus paramFighterStatus, int paramInt2, HashMap<Integer, FighterStatus> paramHashMap) {
/* 1621 */     paramPlay.play_type = 6;
/* 1622 */     PlayUseItem localPlayUseItem = new PlayUseItem();
/* 1623 */     fillPlayUseItemResult(localPlayUseItem, paramInt1, paramFighterStatus, paramInt2, paramHashMap);
/* 1624 */     paramPlay.content = localPlayUseItem.marshal(new OctetsStream());
/*      */   }
/*      */   
/*      */   final void fillPlayUseItemResult(PlayUseItem paramPlayUseItem, int paramInt1, FighterStatus paramFighterStatus, int paramInt2, HashMap<Integer, FighterStatus> paramHashMap) {
/* 1628 */     paramPlayUseItem.fighterid = paramInt1;
/* 1629 */     paramPlayUseItem.releaserstatus = paramFighterStatus;
/* 1630 */     paramPlayUseItem.itemcfgid = paramInt2;
/* 1631 */     paramPlayUseItem.targetstatus = paramHashMap;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.util.Pair<PlayUseItem, Boolean> getOppisiteUseItemResult(PlayUseItem paramPlayUseItem, boolean paramBoolean) {
/* 1635 */     int i = paramPlayUseItem.fighterid;
/* 1636 */     boolean bool1 = this.fightGroup.fightTeam.fight.isInActiveTime(i);
/* 1637 */     FighterStatus localFighterStatus1 = null;
/* 1638 */     boolean bool2 = paramBoolean ^ bool1;
/* 1639 */     if (bool2) {
/* 1640 */       localFighterStatus1 = Fight.copyFighterStatusIgnoreHpMpAnger(paramPlayUseItem.releaserstatus);
/*      */     }
/*      */     else {
/* 1643 */       localFighterStatus1 = paramPlayUseItem.releaserstatus;
/*      */     }
/* 1645 */     HashMap localHashMap = new HashMap();
/* 1646 */     for (Map.Entry localEntry : paramPlayUseItem.targetstatus.entrySet()) {
/* 1647 */       int j = ((Integer)localEntry.getKey()).intValue();
/* 1648 */       boolean bool3 = this.fightGroup.fightTeam.fight.isInActiveTime(j);
/* 1649 */       if ((bool3 ^ paramBoolean)) {
/* 1650 */         FighterStatus localFighterStatus2 = Fight.copyFighterStatusIgnoreHpMpAnger((FighterStatus)localEntry.getValue());
/* 1651 */         localHashMap.put(Integer.valueOf(j), localFighterStatus2);
/*      */       }
/*      */       else {
/* 1654 */         localHashMap.put(Integer.valueOf(j), localEntry.getValue());
/*      */       }
/*      */     }
/* 1657 */     return new mzm.gsp.util.Pair(new PlayUseItem(paramPlayUseItem.fighterid, localFighterStatus1, paramPlayUseItem.itemcfgid, localHashMap), Boolean.valueOf(bool2));
/*      */   }
/*      */   
/*      */   final void fillPlayCaptureResult(Play paramPlay, int paramInt1, int paramInt2) {
/* 1661 */     paramPlay.play_type = 1;
/* 1662 */     mzm.gsp.fight.PlayCapture localPlayCapture = new mzm.gsp.fight.PlayCapture();
/* 1663 */     localPlayCapture.fighterid = this.fighterid;
/* 1664 */     localPlayCapture.capturedfighterid = paramInt1;
/* 1665 */     localPlayCapture.result = paramInt2;
/* 1666 */     paramPlay.content = localPlayCapture.marshal(new OctetsStream());
/*      */   }
/*      */   
/*      */   public final void fillPlayTipResult(Play paramPlay, int paramInt1, int paramInt2, String... paramVarArgs) {
/* 1670 */     paramPlay.play_type = 5;
/* 1671 */     mzm.gsp.fight.PlayTip localPlayTip = new mzm.gsp.fight.PlayTip();
/* 1672 */     localPlayTip.ret = paramInt2;
/* 1673 */     localPlayTip.fighterid = paramInt1;
/* 1674 */     for (String str : paramVarArgs) {
/* 1675 */       localPlayTip.args.add(str);
/*      */     }
/* 1677 */     paramPlay.content = localPlayTip.marshal(new OctetsStream());
/*      */   }
/*      */   
/*      */   final void fillPlayEscapeResult(Play paramPlay, int paramInt1, int paramInt2, int paramInt3) {
/* 1681 */     paramPlay.play_type = 3;
/* 1682 */     mzm.gsp.fight.PlayEscape localPlayEscape = new mzm.gsp.fight.PlayEscape();
/* 1683 */     localPlayEscape.fighterid = paramInt1;
/* 1684 */     localPlayEscape.suc = paramInt2;
/* 1685 */     localPlayEscape.sucrate = paramInt3;
/* 1686 */     paramPlay.content = localPlayEscape.marshal(new OctetsStream());
/*      */   }
/*      */   
/*      */   final void fillPlaySummonResult(PlaySummon paramPlaySummon, int paramInt1, int paramInt2, List<Fighter> paramList) {
/* 1690 */     paramPlaySummon.result = paramInt1;
/* 1691 */     paramPlaySummon.fighterid = paramInt2;
/* 1692 */     int i = -1;
/* 1693 */     int j = -1;
/* 1694 */     for (Fighter localFighter : paramList) {
/* 1695 */       paramPlaySummon.fighters.put(Integer.valueOf(localFighter.fighterid), localFighter.getFighterBean());
/* 1696 */       if (i < 0) {
/* 1697 */         i = localFighter.fightGroup.groupid;
/*      */       }
/* 1699 */       if (j < 0) {
/* 1700 */         if (localFighter.fightGroup.fightTeam.isActive) {
/* 1701 */           j = 2;
/*      */         }
/*      */         else {
/* 1704 */           j = 3;
/*      */         }
/*      */       }
/*      */     }
/* 1708 */     paramPlaySummon.groupid = i;
/* 1709 */     paramPlaySummon.team = j;
/*      */   }
/*      */   
/*      */   final PlaySummon getOppisitePlaySummon(PlaySummon paramPlaySummon, boolean paramBoolean) {
/* 1713 */     HashMap localHashMap = new HashMap();
/* 1714 */     for (Object localObject = paramPlaySummon.fighters.entrySet().iterator(); ((Iterator)localObject).hasNext();) { Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
/* 1715 */       int i = ((Integer)localEntry.getKey()).intValue();
/* 1716 */       mzm.gsp.fight.Fighter localFighter1 = (mzm.gsp.fight.Fighter)localEntry.getValue();
/* 1717 */       FighterStatus localFighterStatus = localFighter1.status;
/* 1718 */       boolean bool = this.fightGroup.fightTeam.fight.isInActiveTime(i);
/* 1719 */       if ((paramBoolean ^ bool)) {
/* 1720 */         mzm.gsp.fight.Fighter localFighter2 = copyFighterIgnoreMpHpAnger(localFighter1, localFighterStatus);
/* 1721 */         localHashMap.put(Integer.valueOf(i), localFighter2);
/*      */       }
/*      */       else {
/* 1724 */         localHashMap.put(Integer.valueOf(i), localFighter1);
/*      */       }
/*      */     }
/* 1727 */     localObject = new PlaySummon(paramPlaySummon.result, paramPlaySummon.fighterid, localHashMap, paramPlaySummon.groupid, paramPlaySummon.team);
/* 1728 */     return (PlaySummon)localObject;
/*      */   }
/*      */   
/*      */   mzm.gsp.fight.Fighter copyFighterIgnoreMpHpAnger(mzm.gsp.fight.Fighter paramFighter, FighterStatus paramFighterStatus) {
/* 1732 */     FighterStatus localFighterStatus = new FighterStatus(paramFighterStatus.hpchange, paramFighterStatus.mpchange, paramFighterStatus.angerchange, paramFighterStatus.status_set, paramFighterStatus.buff_status_set, paramFighterStatus.buffs, 0, 0, 0, 0, 0, 0, paramFighterStatus.curenergy, paramFighterStatus.changemodels, paramFighterStatus.triggerpassiveskills);
/* 1733 */     mzm.gsp.fight.Fighter localFighter = new mzm.gsp.fight.Fighter(paramFighter.fighter_type, paramFighter.uuid, paramFighter.cfgid, paramFighter.name, paramFighter.level, paramFighter.occupation, paramFighter.gender, paramFighter.pos, paramFighter.model, localFighterStatus, paramFighter.skilldatas);
/* 1734 */     return localFighter;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.PlayChangeFighter getOppisiteChangeFighter(mzm.gsp.fight.PlayChangeFighter paramPlayChangeFighter) {
/* 1738 */     mzm.gsp.fight.Fighter localFighter = copyFighterIgnoreMpHpAnger(paramPlayChangeFighter.fighter, paramPlayChangeFighter.fighter.status);
/* 1739 */     mzm.gsp.fight.PlayChangeFighter localPlayChangeFighter = new mzm.gsp.fight.PlayChangeFighter(paramPlayChangeFighter.fighterid, paramPlayChangeFighter.changefighterid, localFighter);
/* 1740 */     return localPlayChangeFighter;
/*      */   }
/*      */   
/*      */   final void fillPlayTalkResult(Play paramPlay, int paramInt, String[] paramArrayOfString) {
/* 1744 */     paramPlay.play_type = 4;
/* 1745 */     mzm.gsp.fight.PlayTalk localPlayTalk = new mzm.gsp.fight.PlayTalk();
/* 1746 */     localPlayTalk.fighterid = this.fighterid;
/* 1747 */     localPlayTalk.strid = paramInt;
/* 1748 */     for (String str : paramArrayOfString) {
/* 1749 */       localPlayTalk.args.add(str);
/*      */     }
/* 1751 */     paramPlay.content = localPlayTalk.marshal(new OctetsStream());
/*      */   }
/*      */   
/*      */   private final void doSkillCost(Skill paramSkill, int paramInt) {
/* 1755 */     SSkillCfg localSSkillCfg = paramSkill.getSkillCfg();
/* 1756 */     mzm.gsp.skill.confbean.SSkillConditionCfg localSSkillConditionCfg = mzm.gsp.skill.confbean.SSkillConditionCfg.get(localSSkillCfg.condition);
/* 1757 */     SkillCostHandle.CostResult localCostResult = handleSkillCost();
/* 1758 */     for (mzm.gsp.skill.confbean.CostType2Formulaid localCostType2Formulaid : localSSkillConditionCfg.costCondtions) {
/* 1759 */       doSkillCost(paramSkill, localCostType2Formulaid.costType, localCostType2Formulaid.formulaid, localCostResult);
/*      */     }
/* 1761 */     if (paramInt > 0) {
/* 1762 */       addEnergy(-paramInt);
/*      */     }
/* 1764 */     paramSkill.getSkillUseFighterStatus().triggerpassiveskills.addAll(localCostResult.passiveSkillids);
/*      */   }
/*      */   
/*      */   private final void doSkillCost(Skill paramSkill, int paramInt1, int paramInt2, SkillCostHandle.CostResult paramCostResult) {
/* 1768 */     FighterStatus localFighterStatus1 = paramSkill.getSkillUseFighterStatus();
/* 1769 */     if (paramInt1 != 1) {
/* 1770 */       mzm.gsp.skill.formula.fighter.SkillFormula localSkillFormula = SkillInterface.getSkillFormula(paramInt2);
/* 1771 */       if (localSkillFormula != null) {
/* 1772 */         int i = localSkillFormula.calc(paramSkill, this);
/* 1773 */         FighterStatus localFighterStatus4; int m; int n; switch (paramInt1) {
/*      */         case 6: 
/* 1775 */           i += (int)(i * ((paramCostResult.exangerRate + paramCostResult.extraRate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 1776 */           addAnger(-i);
/* 1777 */           break;
/*      */         
/*      */         case 7: 
/* 1780 */           int j = (int)(getMaxAnger() * (i * (1.0D + paramCostResult.extraRate * 1.0D / FightArgs.getInstance().defaultRate)));
/* 1781 */           addAnger(-j);
/* 1782 */           break;
/*      */         
/*      */         case 2: 
/* 1785 */           i *= (int)(1.0D + paramCostResult.extraRate * 1.0D / FightArgs.getInstance().defaultRate);
/* 1786 */           addHp(-i, false);
/* 1787 */           FighterStatus localFighterStatus2 = localFighterStatus1;
/* 1788 */           localFighterStatus2.hpchange -= i;
/* 1789 */           break;
/*      */         
/*      */         case 3: 
/* 1792 */           int k = (int)(getMaxHp() * (i * (1.0D + (paramCostResult.exangerRate + paramCostResult.extraRate) * 1.0D / FightArgs.getInstance().getDefaultRate()) / FightArgs.getInstance().defaultRate));
/* 1793 */           addHp(-k, false);
/* 1794 */           localFighterStatus4 = localFighterStatus1;
/* 1795 */           localFighterStatus4.hpchange -= k;
/* 1796 */           break;
/*      */         
/*      */         case 4: 
/* 1799 */           i -= (int)(i * ((paramCostResult.magicreducerate - paramCostResult.extraRate) * 1.0D / FightArgs.getInstance().defaultRate));
/* 1800 */           addMp(-i);
/* 1801 */           FighterStatus localFighterStatus3 = localFighterStatus1;
/* 1802 */           localFighterStatus3.mpchange -= i;
/* 1803 */           break;
/*      */         
/*      */         case 5: 
/* 1806 */           m = (int)(getMaxMp() * (i * (1.0D - (paramCostResult.magicreducerate - paramCostResult.extraRate) * 1.0D / FightArgs.getInstance().defaultRate) * 1.0D / FightArgs.getInstance().defaultRate));
/* 1807 */           addMp(-m);
/* 1808 */           localFighterStatus4 = localFighterStatus1;
/* 1809 */           localFighterStatus4.mpchange -= m;
/* 1810 */           break;
/*      */         
/*      */         case 8: 
/* 1813 */           m = getHp();
/* 1814 */           n = m - i;
/* 1815 */           if (n > 0) {
/* 1816 */             FighterStatus localFighterStatus5 = localFighterStatus1;
/* 1817 */             localFighterStatus5.hpchange -= n;
/* 1818 */             addHp(-n, false); }
/* 1819 */           break;
/*      */         
/*      */ 
/*      */ 
/*      */         case 9: 
/* 1824 */           m = getEnergy();
/* 1825 */           n = m - i;
/* 1826 */           if (n >= 0)
/*      */           {
/* 1828 */             localFighterStatus1.curenergy -= i;
/* 1829 */             addEnergy(-i);
/*      */           }
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   protected void excuteOpItem(mzm.gsp.fight.OpItem paramOpItem, ExcuteCmdResult paramExcuteCmdResult)
/*      */   {
/* 1839 */     if (isForbidUseItem()) {
/* 1840 */       for (FighterBuff localFighterBuff : getAllEffectBuff()) {
/* 1841 */         for (FighterEffect localFighterEffect : localFighterBuff.getEffects()) {
/* 1842 */           if ((localFighterEffect instanceof mzm.gsp.effect.fighter.ForbidUseItem))
/*      */           {
/* 1844 */             mzm.gsp.effect.fighter.ForbidUseItem localForbidUseItem = (mzm.gsp.effect.fighter.ForbidUseItem)localFighterEffect;
/* 1845 */             localForbidUseItem.onUserItem(this);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1851 */     this.fightGroup.excuteOpItem(this, paramOpItem, paramExcuteCmdResult);
/*      */   }
/*      */   
/*      */   protected void excuteOpCapture(mzm.gsp.fight.OpCapture paramOpCapture, ExcuteCmdResult paramExcuteCmdResult) {}
/*      */   
/*      */   protected void excuteOpProtect(mzm.gsp.fight.OpProtect paramOpProtect, ExcuteCmdResult paramExcuteCmdResult)
/*      */   {
/* 1858 */     if ((isSeal()) && (isSealProtect())) {
/* 1859 */       localObject = new Play();
/* 1860 */       fillPlayTipResult((Play)localObject, getid(), 121000019, new String[0]);
/* 1861 */       paramExcuteCmdResult.addPlay((Play)localObject, true);
/* 1862 */       paramExcuteCmdResult.addPlay((Play)localObject, false);
/* 1863 */       if (isRecordEnable()) {
/* 1864 */         paramExcuteCmdResult.addPlay((Play)localObject);
/*      */       }
/* 1866 */       return;
/*      */     }
/* 1868 */     Object localObject = getFighter(paramOpProtect.target);
/* 1869 */     Play localPlay; if (localObject == null) {
/* 1870 */       localPlay = new Play();
/* 1871 */       fillPlayTipResult(localPlay, getid(), 121000012, new String[0]);
/* 1872 */       paramExcuteCmdResult.addPlay(localPlay, true);
/* 1873 */       paramExcuteCmdResult.addPlay(localPlay, false);
/* 1874 */       if (isRecordEnable()) {
/* 1875 */         paramExcuteCmdResult.addPlay(localPlay);
/*      */       }
/* 1877 */       return;
/*      */     }
/* 1879 */     if ((!getFriendFighters().contains(localObject)) || (((Fighter)localObject).getid() == getid())) {
/* 1880 */       localPlay = new Play();
/* 1881 */       fillPlayTipResult(localPlay, getid(), 121000012, new String[0]);
/* 1882 */       paramExcuteCmdResult.addPlay(localPlay, true);
/* 1883 */       paramExcuteCmdResult.addPlay(localPlay, false);
/* 1884 */       if (isRecordEnable()) {
/* 1885 */         paramExcuteCmdResult.addPlay(localPlay);
/*      */       }
/* 1887 */       return;
/*      */     }
/* 1889 */     ((Fighter)localObject).addProtect(this.fighterid);
/* 1890 */     addActionCount();
/* 1891 */     addUseProtectionCount();
/*      */   }
/*      */   
/*      */   protected boolean excuteOpEscape(ExcuteCmdResult paramExcuteCmdResult) {
/* 1895 */     if (isEscaped()) {
/* 1896 */       return false;
/*      */     }
/* 1898 */     addActionCount();
/* 1899 */     Play localPlay = new Play();
/* 1900 */     int i = getEscapeRate();
/* 1901 */     int j = i / 100;
/* 1902 */     if ((isSeal()) && (isSealEscape())) {
/* 1903 */       fillPlayEscapeResult(localPlay, getid(), 1, j);
/* 1904 */       paramExcuteCmdResult.addPlay(localPlay, false);
/* 1905 */       paramExcuteCmdResult.addPlay(localPlay, true);
/* 1906 */       if (isRecordEnable()) {
/* 1907 */         paramExcuteCmdResult.addPlay(localPlay);
/*      */       }
/* 1909 */       paramExcuteCmdResult.addPlayTime(SFightConsts.getInstance().ESCAPE_ACTION_TIME);
/* 1910 */       return false;
/*      */     }
/* 1912 */     if ((!isSincerely()) && (FightFormulaHelp.isEscape(i))) {
/* 1913 */       escape(paramExcuteCmdResult);
/* 1914 */       return true;
/*      */     }
/* 1916 */     fillPlayEscapeResult(localPlay, getid(), 1, j);
/* 1917 */     paramExcuteCmdResult.addPlay(localPlay, false);
/* 1918 */     paramExcuteCmdResult.addPlay(localPlay, true);
/* 1919 */     if (isRecordEnable()) {
/* 1920 */       paramExcuteCmdResult.addPlay(localPlay);
/*      */     }
/* 1922 */     paramExcuteCmdResult.addPlayTime(SFightConsts.getInstance().ESCAPE_ACTION_TIME);
/* 1923 */     return false;
/*      */   }
/*      */   
/*      */   public void escape(ExcuteCmdResult paramExcuteCmdResult) {
/* 1927 */     Play localPlay = new Play();
/* 1928 */     setEscape();
/* 1929 */     Set localSet1 = getFight().getActiveTeam().getFighters();
/* 1930 */     Set localSet2 = getFight().getPassiveTeam().getFighters();
/* 1931 */     HashSet localHashSet = new HashSet();
/* 1932 */     localHashSet.addAll(localSet1);
/* 1933 */     localHashSet.addAll(localSet2);
/* 1934 */     for (Iterator localIterator1 = localHashSet.iterator(); localIterator1.hasNext();) { localFighter = (Fighter)localIterator1.next();
/* 1935 */       Set localSet3 = copySetValue(localFighter.xFighter.getHandleonescape());
/* 1936 */       for (mzm.gsp.fight.handle.EscapeHandle localEscapeHandle : localSet3)
/* 1937 */         localEscapeHandle.onEscaped(this, localFighter);
/*      */     }
/*      */     Fighter localFighter;
/* 1940 */     fillPlayEscapeResult(localPlay, getid(), 0, getEscapeRate() / 100);
/* 1941 */     paramExcuteCmdResult.addPlay(localPlay, false);
/* 1942 */     paramExcuteCmdResult.addPlay(localPlay, true);
/* 1943 */     if (isRecordEnable()) {
/* 1944 */       paramExcuteCmdResult.addPlay(localPlay);
/*      */     }
/* 1946 */     paramExcuteCmdResult.addPlayTime(SFightConsts.getInstance().ESCAPE_ACTION_TIME);
/* 1947 */     onFightEnd();
/*      */   }
/*      */   
/*      */   public void addCmdResult(ExcuteCmdResult paramExcuteCmdResult) {
/* 1951 */     this.fightGroup.fightTeam.fight.addCmdResult(paramExcuteCmdResult);
/*      */   }
/*      */   
/*      */ 
/*      */   protected void excuteOpSummonPet(mzm.gsp.fight.OpSummonPet paramOpSummonPet, ExcuteCmdResult paramExcuteCmdResult) {}
/*      */   
/*      */ 
/*      */   protected void excuteOpSummonChild(mzm.gsp.fight.OpSummonChild paramOpSummonChild, ExcuteCmdResult paramExcuteCmdResult) {}
/*      */   
/*      */   protected void excuteOpSummonMonster(mzm.gsp.fight.OpSummonMonster paramOpSummonMonster, ExcuteCmdResult paramExcuteCmdResult) {}
/*      */   
/*      */   public void excuteCmdEnd(FightCmd paramFightCmd)
/*      */   {
/* 1964 */     GameServer.logger().info(String.format("[fight]Fighter.excuteCmdEnd@cmd end|optype=%d|fighterid=%d", new Object[] { Integer.valueOf(paramFightCmd.getOp_type()), Integer.valueOf(paramFightCmd.getFighterid()) }));
/* 1965 */     if (0 == paramFightCmd.getOp_type()) {
/* 1966 */       Op_UseSkill localOp_UseSkill = new Op_UseSkill();
/* 1967 */       paramFightCmd.getContent(localOp_UseSkill);
/* 1968 */       GameServer.logger().info(String.format("[fight]Fighter.excuteCmdEnd@cmd end with exe skill cmd end|skillId=%d", new Object[] { Integer.valueOf(localOp_UseSkill.skill) }));
/* 1969 */       handleSkillExcCmdEnd(localOp_UseSkill);
/*      */     }
/*      */   }
/*      */   
/*      */   protected final ExcuteCmdResult excuteCmd(FightCmd paramFightCmd) {
/* 1974 */     ExcuteCmdResult localExcuteCmdResult = new ExcuteCmdResult();
/* 1975 */     if (!isOperable()) {
/* 1976 */       localExcuteCmdResult.addPlayTime(0);
/* 1977 */       localExcuteCmdResult.setNeedReexcute(isNeedReexcute());
/* 1978 */       if (isSleep()) {
/* 1979 */         localObject1 = new Play();
/* 1980 */         fillPlayTipResult((Play)localObject1, this.fighterid, 121000021, new String[0]);
/* 1981 */         localExcuteCmdResult.addPlay((Play)localObject1, true);
/* 1982 */         localExcuteCmdResult.addPlay((Play)localObject1, false);
/* 1983 */         if (isRecordEnable()) {
/* 1984 */           localExcuteCmdResult.addPlay((Play)localObject1);
/*      */         }
/*      */       }
/* 1987 */       if (isIceCool()) {
/* 1988 */         localObject1 = new Play();
/* 1989 */         fillPlayTipResult((Play)localObject1, this.fighterid, 121000014, new String[0]);
/* 1990 */         localExcuteCmdResult.addPlay((Play)localObject1, true);
/* 1991 */         localExcuteCmdResult.addPlay((Play)localObject1, false);
/* 1992 */         if (isRecordEnable()) {
/* 1993 */           localExcuteCmdResult.addPlay((Play)localObject1);
/*      */         }
/*      */       }
/* 1996 */       if (isStone()) {
/* 1997 */         localObject1 = new Play();
/* 1998 */         fillPlayTipResult((Play)localObject1, this.fighterid, 121000020, new String[0]);
/* 1999 */         localExcuteCmdResult.addPlay((Play)localObject1, true);
/* 2000 */         localExcuteCmdResult.addPlay((Play)localObject1, false);
/* 2001 */         if (isRecordEnable()) {
/* 2002 */           localExcuteCmdResult.addPlay((Play)localObject1);
/*      */         }
/*      */       }
/* 2005 */       return localExcuteCmdResult;
/*      */     }
/* 2007 */     if ((isMess()) && (!isHouFa())) {
/* 2008 */       return handleMess(localExcuteCmdResult);
/*      */     }
/* 2010 */     if ((isTaunt()) && (!isHouFa())) {
/* 2011 */       return handleTaunt(localExcuteCmdResult);
/*      */     }
/* 2013 */     if (isWeak()) {
/* 2014 */       localObject1 = new Play();
/* 2015 */       fillPlayTipResult((Play)localObject1, this.fighterid, 121000005, new String[0]);
/* 2016 */       localExcuteCmdResult.addPlay((Play)localObject1, true);
/* 2017 */       localExcuteCmdResult.addPlay((Play)localObject1, false);
/* 2018 */       if (isRecordEnable()) {
/* 2019 */         localExcuteCmdResult.addPlay((Play)localObject1);
/*      */       }
/* 2021 */       return localExcuteCmdResult;
/*      */     }
/* 2023 */     Object localObject1 = getAI();
/* 2024 */     if (localObject1 != null) {
/* 2025 */       ((AI)localObject1).runUnRoundOperator(this.fightGroup.fightTeam.fight);
/*      */     }
/* 2027 */     if (!isExisted())
/* 2028 */       return localExcuteCmdResult;
/*      */     Object localObject2;
/* 2030 */     if ((!isSincerely()) && (isFear()) && (paramFightCmd.getOp_type() != 3)) {
/* 2031 */       localObject2 = new Op_UseSkill();
/* 2032 */       ((Op_UseSkill)localObject2).main_target = this.fighterid;
/* 2033 */       ((Op_UseSkill)localObject2).skill = SFightConsts.getInstance().DEFENCE_SKILL;
/* 2034 */       if (hasSkill(((Op_UseSkill)localObject2).skill)) {
/* 2035 */         ((Op_UseSkill)localObject2).skillLv = getSkillLevel(((Op_UseSkill)localObject2).skill);
/*      */       }
/* 2037 */       paramFightCmd.setOp_type(0);
/* 2038 */       paramFightCmd.setContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/*      */     }
/* 2040 */     switch (paramFightCmd.getOp_type()) {
/*      */     case 0: 
/* 2042 */       localObject2 = new Op_UseSkill();
/* 2043 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2044 */       Skill localSkill = SkillInterface.getSkill(((Op_UseSkill)localObject2).skill, ((Op_UseSkill)localObject2).skillLv);
/* 2045 */       if (localSkill == null) {
/* 2046 */         return localExcuteCmdResult;
/*      */       }
/* 2048 */       if (isSkillCostEnough(localSkill)) {
/* 2049 */         beforeExcuteSkill((Op_UseSkill)localObject2, localExcuteCmdResult);
/*      */       }
/* 2051 */       if (this.fightGroup.fightTeam.fight.isFightEnd()) {
/* 2052 */         return localExcuteCmdResult;
/*      */       }
/* 2054 */       if ((isFakeDead()) || (isDead())) {
/* 2055 */         return localExcuteCmdResult;
/*      */       }
/* 2057 */       excuteOpSkill((Op_UseSkill)localObject2, localExcuteCmdResult, null, false);
/* 2058 */       break;
/*      */     
/*      */     case 1: 
/* 2061 */       localObject2 = new mzm.gsp.fight.OpItem();
/* 2062 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2063 */       excuteOpItem((mzm.gsp.fight.OpItem)localObject2, localExcuteCmdResult);
/* 2064 */       break;
/*      */     
/*      */     case 2: 
/* 2067 */       if (isRest()) {
/* 2068 */         localObject2 = new Play();
/* 2069 */         fillPlayTipResult((Play)localObject2, this.fighterid, 121000004, new String[0]);
/* 2070 */         localExcuteCmdResult.addPlay((Play)localObject2, true);
/* 2071 */         localExcuteCmdResult.addPlay((Play)localObject2, false);
/* 2072 */         if (isRecordEnable()) {
/* 2073 */           localExcuteCmdResult.addPlay((Play)localObject2);
/*      */         }
/* 2075 */         return localExcuteCmdResult;
/*      */       }
/* 2077 */       localObject2 = new mzm.gsp.fight.OpCapture();
/* 2078 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2079 */       excuteOpCapture((mzm.gsp.fight.OpCapture)localObject2, localExcuteCmdResult);
/* 2080 */       break;
/*      */     
/*      */     case 3: 
/* 2083 */       localObject2 = new mzm.gsp.fight.OpProtect();
/* 2084 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2085 */       excuteOpProtect((mzm.gsp.fight.OpProtect)localObject2, localExcuteCmdResult);
/* 2086 */       break;
/*      */     
/*      */     case 4: 
/* 2089 */       if (isRest()) {
/* 2090 */         localObject2 = new Play();
/* 2091 */         fillPlayTipResult((Play)localObject2, this.fighterid, 121000004, new String[0]);
/* 2092 */         localExcuteCmdResult.addPlay((Play)localObject2, true);
/* 2093 */         localExcuteCmdResult.addPlay((Play)localObject2, false);
/* 2094 */         if (isRecordEnable()) {
/* 2095 */           localExcuteCmdResult.addPlay((Play)localObject2);
/*      */         }
/* 2097 */         return localExcuteCmdResult;
/*      */       }
/* 2099 */       excuteOpEscape(localExcuteCmdResult);
/* 2100 */       break;
/*      */     
/*      */     case 5: 
/* 2103 */       if (isForbidSummon()) {
/* 2104 */         localObject2 = new Play();
/* 2105 */         fillPlayTipResult((Play)localObject2, this.fighterid, 121001001, new String[0]);
/* 2106 */         localExcuteCmdResult.addPlay((Play)localObject2, true);
/* 2107 */         localExcuteCmdResult.addPlay((Play)localObject2, false);
/* 2108 */         if (isRecordEnable()) {
/* 2109 */           localExcuteCmdResult.addPlay((Play)localObject2);
/*      */         }
/* 2111 */         return localExcuteCmdResult;
/*      */       }
/* 2113 */       localObject2 = new mzm.gsp.fight.OpSummonPet();
/* 2114 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2115 */       excuteOpSummonPet((mzm.gsp.fight.OpSummonPet)localObject2, localExcuteCmdResult);
/* 2116 */       break;
/*      */     
/*      */     case 6: 
/* 2119 */       if (isForbidSummon()) {
/* 2120 */         localObject2 = new Play();
/* 2121 */         fillPlayTipResult((Play)localObject2, this.fighterid, 121001001, new String[0]);
/* 2122 */         localExcuteCmdResult.addPlay((Play)localObject2, true);
/* 2123 */         localExcuteCmdResult.addPlay((Play)localObject2, false);
/* 2124 */         if (isRecordEnable()) {
/* 2125 */           localExcuteCmdResult.addPlay((Play)localObject2);
/*      */         }
/* 2127 */         return localExcuteCmdResult;
/*      */       }
/* 2129 */       localObject2 = new mzm.gsp.fight.OpSummonChild();
/* 2130 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2131 */       excuteOpSummonChild((mzm.gsp.fight.OpSummonChild)localObject2, localExcuteCmdResult);
/* 2132 */       break;
/*      */     
/*      */     case 7: 
/* 2135 */       if (isForbidSummon()) {
/* 2136 */         localObject2 = new Play();
/* 2137 */         fillPlayTipResult((Play)localObject2, this.fighterid, 121001001, new String[0]);
/* 2138 */         localExcuteCmdResult.addPlay((Play)localObject2, true);
/* 2139 */         localExcuteCmdResult.addPlay((Play)localObject2, false);
/* 2140 */         if (isRecordEnable()) {
/* 2141 */           localExcuteCmdResult.addPlay((Play)localObject2);
/*      */         }
/* 2143 */         return localExcuteCmdResult;
/*      */       }
/* 2145 */       localObject2 = new mzm.gsp.fight.OpSummonMonster();
/* 2146 */       paramFightCmd.getContent((com.goldhuman.Common.Marshal.Marshal)localObject2);
/* 2147 */       excuteOpSummonMonster((mzm.gsp.fight.OpSummonMonster)localObject2, localExcuteCmdResult);
/* 2148 */       break;
/*      */     
/*      */     default: 
/* 2151 */       GameServer.logger().error("战斗中不存在的操作类型:" + paramFightCmd.getOp_type());
/*      */     }
/*      */     
/*      */     
/* 2155 */     return localExcuteCmdResult;
/*      */   }
/*      */   
/*      */   protected void beforeExcuteSkill(Op_UseSkill paramOp_UseSkill, ExcuteCmdResult paramExcuteCmdResult) {}
/*      */   
/*      */   private ExcuteCmdResult handleTaunt(ExcuteCmdResult paramExcuteCmdResult)
/*      */   {
/* 2162 */     if (isAlive()) {
/* 2163 */       Set localSet = copySetValue(this.xFighter.getHandleontaunt());
/* 2164 */       int i = -1;
/* 2165 */       for (Object localObject1 = localSet.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (mzm.gsp.fight.handle.TauntHandle)((Iterator)localObject1).next();
/* 2166 */         i = ((mzm.gsp.fight.handle.TauntHandle)localObject2).getTauntTarget(this);
/* 2167 */         if (i >= 0) {
/*      */           break;
/*      */         }
/*      */       }
/* 2171 */       localObject1 = new Op_UseSkill();
/* 2172 */       ((Op_UseSkill)localObject1).skill = getNormalSkill();
/* 2173 */       ((Op_UseSkill)localObject1).skillLv = getSkillLevel(((Op_UseSkill)localObject1).skill);
/* 2174 */       ((Op_UseSkill)localObject1).main_target = i;
/* 2175 */       Object localObject2 = SkillInterface.getSkill(((Op_UseSkill)localObject1).skill, ((Op_UseSkill)localObject1).skillLv);
/* 2176 */       excuteOpSkill((Op_UseSkill)localObject1, paramExcuteCmdResult, ((Skill)localObject2).getTargets(this, ((Op_UseSkill)localObject1).main_target, true), true);
/*      */     }
/* 2178 */     paramExcuteCmdResult.setNeedReexcute(false);
/* 2179 */     return paramExcuteCmdResult;
/*      */   }
/*      */   
/*      */   private final ExcuteCmdResult handleMess(ExcuteCmdResult paramExcuteCmdResult) {
/* 2183 */     if (isAlive()) {
/* 2184 */       ArrayList localArrayList = new ArrayList();
/* 2185 */       int i = 0;
/* 2186 */       for (Object localObject1 = getAllEffectBuff().iterator(); ((Iterator)localObject1).hasNext();) { FighterBuff localFighterBuff = (FighterBuff)((Iterator)localObject1).next();
/* 2187 */         if (localArrayList.size() > 0) {
/*      */           break;
/*      */         }
/* 2190 */         for (localObject2 = localFighterBuff.getEffects().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (FighterEffect)((Iterator)localObject2).next();
/* 2191 */           if ((localObject3 instanceof mzm.gsp.effect.fighter.Mess)) {
/* 2192 */             localArrayList.addAll(((mzm.gsp.effect.fighter.Mess)localObject3).getTargets(this));
/* 2193 */             if (!(localObject3 instanceof mzm.gsp.effect.fighter.ChildrenMess)) break;
/* 2194 */             i = 1;
/* 2195 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */       Object localObject2;
/*      */       Object localObject3;
/* 2201 */       if (localArrayList.size() > 0) {
/* 2202 */         if (i != 0) {
/* 2203 */           localObject1 = new int[] { 710360003, 710360004, 710360005, 710360006 };
/* 2204 */           int j = localObject1[xdb.Xdb.random().nextInt(localObject1.length)];
/* 2205 */           localObject2 = new Play();
/* 2206 */           localObject3 = new String[0];
/* 2207 */           fillPlayTalkResult((Play)localObject2, j, (String[])localObject3);
/* 2208 */           paramExcuteCmdResult.addPlay((Play)localObject2, false);
/* 2209 */           paramExcuteCmdResult.addPlay((Play)localObject2, true);
/* 2210 */           if (isRecordEnable()) {
/* 2211 */             paramExcuteCmdResult.addPlay((Play)localObject2);
/*      */           }
/* 2213 */           paramExcuteCmdResult.addPlayTime(SFightConsts.getInstance().WORDS_ROUND_TIME);
/*      */         }
/* 2215 */         localObject1 = new Op_UseSkill();
/* 2216 */         ((Op_UseSkill)localObject1).skill = getNormalSkill();
/* 2217 */         ((Op_UseSkill)localObject1).skillLv = getSkillLevel(((Op_UseSkill)localObject1).skill);
/* 2218 */         excuteOpSkill((Op_UseSkill)localObject1, paramExcuteCmdResult, localArrayList, true);
/*      */       }
/*      */     }
/* 2221 */     paramExcuteCmdResult.setNeedReexcute(false);
/* 2222 */     return paramExcuteCmdResult;
/*      */   }
/*      */   
/*      */   protected final boolean isNeedReexcute() {
/* 2226 */     return isFakeDead();
/*      */   }
/*      */   
/*      */   public boolean hasBuff(int paramInt) {
/* 2230 */     mzm.gsp.skill.confbean.SSkillEffectGroupCfg localSSkillEffectGroupCfg = mzm.gsp.skill.confbean.SSkillEffectGroupCfg.get(paramInt);
/* 2231 */     if (localSSkillEffectGroupCfg == null) {
/* 2232 */       return false;
/*      */     }
/* 2234 */     int i = localSSkillEffectGroupCfg.classType;
/* 2235 */     FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(i));
/* 2236 */     if (localFighterBuffs == null) {
/* 2237 */       return false;
/*      */     }
/* 2239 */     for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2240 */       if ((localFighterBuff.getBuffCfgId() == paramInt) && (localFighterBuff.getLeftRound() > 0)) {
/* 2241 */         return true;
/*      */       }
/*      */     }
/* 2244 */     return false;
/*      */   }
/*      */   
/*      */   public boolean hasGroupStatus(int paramInt) {
/* 2248 */     FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(paramInt));
/* 2249 */     if (localFighterBuffs == null) {
/* 2250 */       return false;
/*      */     }
/* 2252 */     for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2253 */       if (localFighterBuff.getLeftRound() > 0) {
/* 2254 */         return true;
/*      */       }
/*      */     }
/* 2257 */     return false;
/*      */   }
/*      */   
/*      */   public mzm.gsp.fight.handle.AddBuffHandle.OutPutObj isCanAddBuff(FighterBuff paramFighterBuff) {
/* 2261 */     Set localSet = copySetValue(this.xFighter.getHandleonaddbuff());
/* 2262 */     mzm.gsp.fight.handle.AddBuffHandle.OutPutObj localOutPutObj = new mzm.gsp.fight.handle.AddBuffHandle.OutPutObj();
/* 2263 */     for (mzm.gsp.fight.handle.AddBuffHandle localAddBuffHandle : localSet) {
/* 2264 */       localAddBuffHandle.isCanAddBuff(this, paramFighterBuff, localOutPutObj);
/*      */     }
/* 2266 */     return localOutPutObj;
/*      */   }
/*      */   
/*      */   public final boolean attachBuff(FighterBuff paramFighterBuff) {
/* 2270 */     int i = paramFighterBuff.getEffectGroupStatus();
/* 2271 */     Set localSet = copySetValue(this.xFighter.getHandleonaddbuff());
/* 2272 */     for (Object localObject = localSet.iterator(); ((Iterator)localObject).hasNext();) { mzm.gsp.fight.handle.AddBuffHandle localAddBuffHandle = (mzm.gsp.fight.handle.AddBuffHandle)((Iterator)localObject).next();
/* 2273 */       localAddBuffHandle.onAddBuff(this, paramFighterBuff);
/*      */     }
/* 2275 */     localObject = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(i));
/* 2276 */     if (localObject == null) {
/* 2277 */       localObject = xbean.Pod.newFighterBuffs();
/* 2278 */       this.xFighter.getBuffs().put(Integer.valueOf(i), localObject);
/*      */     }
/* 2280 */     ((FighterBuffs)localObject).getBuffs().add(paramFighterBuff);
/* 2281 */     paramFighterBuff.setEffect(true);
/* 2282 */     if (!paramFighterBuff.attach(this)) {
/* 2283 */       ((FighterBuffs)localObject).getBuffs().remove(paramFighterBuff);
/* 2284 */       return false;
/*      */     }
/* 2286 */     return true;
/*      */   }
/*      */   
/*      */   private final void findAndEffectStatusBuff(int paramInt) {
/* 2290 */     if (paramInt <= 0) {
/* 2291 */       return;
/*      */     }
/* 2293 */     FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(paramInt));
/* 2294 */     if ((localFighterBuffs == null) || (localFighterBuffs.getBuffs().size() <= 0)) {
/* 2295 */       return;
/*      */     }
/* 2297 */     Object localObject1 = null;
/* 2298 */     Object localObject2 = null;
/* 2299 */     for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2300 */       if (localFighterBuff.isEffect()) {
/* 2301 */         localObject1 = localFighterBuff;
/*      */       }
/* 2303 */       if (localObject2 == null) {
/* 2304 */         localObject2 = localFighterBuff;
/*      */ 
/*      */       }
/* 2307 */       else if (localFighterBuff.getLevel() > ((FighterBuff)localObject2).getLevel())
/*      */       {
/*      */ 
/* 2310 */         localObject2 = localFighterBuff;
/*      */       }
/*      */     }
/* 2313 */     if ((localObject1 != null) && (localObject2 != null) && (((FighterBuff)localObject2).getLevel() > ((FighterBuff)localObject1).getLevel())) {
/* 2314 */       if (effectStatusBuff((FighterBuff)localObject2)) {
/* 2315 */         setBuffUnEffect((FighterBuff)localObject1);
/*      */       }
/*      */       else {
/* 2318 */         localFighterBuffs.getBuffs().remove(localObject2);
/* 2319 */         findAndEffectStatusBuff(paramInt);
/*      */       }
/*      */     }
/* 2322 */     if ((localObject1 == null) && (localObject2 != null) && (!effectStatusBuff((FighterBuff)localObject2))) {
/* 2323 */       localFighterBuffs.getBuffs().remove(localObject2);
/* 2324 */       findAndEffectStatusBuff(paramInt);
/*      */     }
/*      */   }
/*      */   
/*      */   private final boolean effectStatusBuff(FighterBuff paramFighterBuff) {
/* 2329 */     if (paramFighterBuff.attach(this)) {
/* 2330 */       paramFighterBuff.setEffect(true);
/* 2331 */       return true;
/*      */     }
/* 2333 */     return false;
/*      */   }
/*      */   
/*      */   private final void setBuffUnEffect(FighterBuff paramFighterBuff) {
/* 2337 */     paramFighterBuff.detach(this);
/* 2338 */     paramFighterBuff.setEffect(false);
/*      */   }
/*      */   
/*      */   public final List<FighterBuff> getAllEffectBuff() {
/* 2342 */     ArrayList localArrayList = new ArrayList();
/* 2343 */     for (FighterBuffs localFighterBuffs : this.xFighter.getBuffs().values()) {
/* 2344 */       for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2345 */         if (localFighterBuff.isEffect()) {
/* 2346 */           localArrayList.add(localFighterBuff);
/*      */         }
/*      */       }
/*      */     }
/* 2350 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public final List<FighterBuff> getAllEffectBuff(int paramInt) {
/* 2354 */     ArrayList localArrayList = new ArrayList();
/* 2355 */     for (FighterBuffs localFighterBuffs : this.xFighter.getBuffs().values()) {
/* 2356 */       for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2357 */         if ((localFighterBuff.isEffect()) && (localFighterBuff.getEffectGroupStatus() == paramInt)) {
/* 2358 */           localArrayList.add(localFighterBuff);
/*      */         }
/*      */       }
/*      */     }
/* 2362 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public final List<FighterBuff> getAllSealEffectBuff() {
/* 2366 */     ArrayList localArrayList = new ArrayList();
/* 2367 */     for (FighterBuffs localFighterBuffs : this.xFighter.getBuffs().values()) {
/* 2368 */       for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2369 */         if ((localFighterBuff.isEffect()) && (localFighterBuff.getEffectGroupType() == 8)) {
/* 2370 */           localArrayList.add(localFighterBuff);
/*      */         }
/*      */       }
/*      */     }
/* 2374 */     return localArrayList;
/*      */   }
/*      */   
/*      */   public final boolean isPoison() {
/* 2378 */     return isHasBuffType(16);
/*      */   }
/*      */   
/*      */   public final boolean isNegetive() {
/* 2382 */     return isHasBuffType(2);
/*      */   }
/*      */   
/*      */   public final boolean isPositive() {
/* 2386 */     return isHasBuffType(4);
/*      */   }
/*      */   
/*      */   public final boolean isNotBeHealed() {
/* 2390 */     if (isGhost()) {
/* 2391 */       Set localSet = copySetValue(this.xFighter.getHandleonroundend());
/* 2392 */       for (RoundEndHandle localRoundEndHandle : localSet) {
/* 2393 */         if ((localRoundEndHandle instanceof mzm.gsp.effect.fighter.Ghost)) {
/* 2394 */           mzm.gsp.effect.fighter.Ghost localGhost = (mzm.gsp.effect.fighter.Ghost)localRoundEndHandle;
/* 2395 */           if (!localGhost.canBeHealed()) {
/* 2396 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2402 */     return false;
/*      */   }
/*      */   
/*      */   public final <T> Set<T> copySetValue(Set<T> paramSet) {
/* 2406 */     HashSet localHashSet = new HashSet();
/* 2407 */     localHashSet.addAll(paramSet);
/* 2408 */     return localHashSet;
/*      */   }
/*      */   
/*      */   private final boolean isHasBuffType(int paramInt) {
/* 2412 */     for (FighterBuffs localFighterBuffs : this.xFighter.getBuffs().values()) {
/* 2413 */       for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 2414 */         if ((localFighterBuff.getEffectGroupType() == paramInt) && (localFighterBuff.getLeftRound() > 0)) {
/* 2415 */           return true;
/*      */         }
/*      */       }
/*      */     }
/* 2419 */     return false;
/*      */   }
/*      */   
/*      */   public final void addRoundStartHandle(mzm.gsp.fight.handle.RoundStartHandle paramRoundStartHandle) {
/* 2423 */     this.xFighter.getHandleonroundstart().add(paramRoundStartHandle);
/*      */   }
/*      */   
/*      */   public final void remRoundStartHandle(mzm.gsp.fight.handle.RoundStartHandle paramRoundStartHandle) {
/* 2427 */     this.xFighter.getHandleonroundstart().remove(paramRoundStartHandle);
/*      */   }
/*      */   
/*      */   public final void addAddAngerHandle(mzm.gsp.fight.handle.AddAngerHandle paramAddAngerHandle) {
/* 2431 */     this.xFighter.getHandleonaddangerhandle().add(paramAddAngerHandle);
/*      */   }
/*      */   
/*      */   public final void remAddAngerHandle(mzm.gsp.fight.handle.AddAngerHandle paramAddAngerHandle) {
/* 2435 */     this.xFighter.getHandleonaddangerhandle().remove(paramAddAngerHandle);
/*      */   }
/*      */   
/*      */   public final void addRoundEndHandle(RoundEndHandle paramRoundEndHandle) {
/* 2439 */     this.xFighter.getHandleonroundend().add(paramRoundEndHandle);
/*      */   }
/*      */   
/*      */   public final void remRoundEndHandle(RoundEndHandle paramRoundEndHandle) {
/* 2443 */     this.xFighter.getHandleonroundend().remove(paramRoundEndHandle);
/*      */   }
/*      */   
/*      */   public final void addDamageHandle(mzm.gsp.fight.handle.DamageHandle paramDamageHandle) {
/* 2447 */     this.xFighter.getHandleondamage().add(paramDamageHandle);
/*      */   }
/*      */   
/*      */   public final void remDamageHandle(mzm.gsp.fight.handle.DamageHandle paramDamageHandle) {
/* 2451 */     this.xFighter.getHandleondamage().remove(paramDamageHandle);
/*      */   }
/*      */   
/*      */   public final void addBeDamageHandle(BeDamageHandle paramBeDamageHandle) {
/* 2455 */     this.xFighter.getHandleonbedamage().add(paramBeDamageHandle);
/*      */   }
/*      */   
/*      */   public final void remBeDamageHandle(BeDamageHandle paramBeDamageHandle) {
/* 2459 */     this.xFighter.getHandleonbedamage().remove(paramBeDamageHandle);
/*      */   }
/*      */   
/*      */   public final void addBeKilledHandle(mzm.gsp.fight.handle.BeKilledHandle paramBeKilledHandle) {
/* 2463 */     this.xFighter.getHandleonbekilled().add(paramBeKilledHandle);
/*      */   }
/*      */   
/*      */   public final void remBeKilledHandle(mzm.gsp.fight.handle.BeKilledHandle paramBeKilledHandle) {
/* 2467 */     this.xFighter.getHandleonbekilled().remove(paramBeKilledHandle);
/*      */   }
/*      */   
/*      */   public final void addAfterAttackHandle(mzm.gsp.fight.handle.AfterAttackHandle paramAfterAttackHandle) {
/* 2471 */     this.xFighter.getHandleonafterattack().add(paramAfterAttackHandle);
/*      */   }
/*      */   
/*      */   public final void remAfterAttackHandle(mzm.gsp.fight.handle.AfterAttackHandle paramAfterAttackHandle) {
/* 2475 */     this.xFighter.getHandleonafterattack().remove(paramAfterAttackHandle);
/*      */   }
/*      */   
/*      */   public final void addAddBuffHandle(mzm.gsp.fight.handle.AddBuffHandle paramAddBuffHandle) {
/* 2479 */     this.xFighter.getHandleonaddbuff().add(paramAddBuffHandle);
/*      */   }
/*      */   
/*      */   public final void remAddBuffHandle(mzm.gsp.fight.handle.AddBuffHandle paramAddBuffHandle) {
/* 2483 */     this.xFighter.getHandleonaddbuff().remove(paramAddBuffHandle);
/*      */   }
/*      */   
/*      */   public final void addEscapeHandle(mzm.gsp.fight.handle.EscapeHandle paramEscapeHandle) {
/* 2487 */     this.xFighter.getHandleonescape().add(paramEscapeHandle);
/*      */   }
/*      */   
/*      */   public final void remEscapeHandle(mzm.gsp.fight.handle.EscapeHandle paramEscapeHandle) {
/* 2491 */     this.xFighter.getHandleonescape().remove(paramEscapeHandle);
/*      */   }
/*      */   
/*      */   public final void addKillOtherHandle(mzm.gsp.fight.handle.KillOtherHandle paramKillOtherHandle) {
/* 2495 */     this.xFighter.getHandleonkillother().add(paramKillOtherHandle);
/*      */   }
/*      */   
/*      */   public final void remKillOtherHandle(mzm.gsp.fight.handle.KillOtherHandle paramKillOtherHandle) {
/* 2499 */     this.xFighter.getHandleonkillother().remove(paramKillOtherHandle);
/*      */   }
/*      */   
/*      */   public final void addBeforeAttackHandle(mzm.gsp.fight.handle.BeforeAttackHandle paramBeforeAttackHandle) {
/* 2503 */     this.xFighter.getHandleonbeforeattack().add(paramBeforeAttackHandle);
/*      */   }
/*      */   
/*      */   public final void remBeforeAttackHandle(mzm.gsp.fight.handle.BeforeAttackHandle paramBeforeAttackHandle) {
/* 2507 */     this.xFighter.getHandleonbeforeattack().remove(paramBeforeAttackHandle);
/*      */   }
/*      */   
/*      */   public final void addLoseHpHandle(mzm.gsp.fight.handle.LoseHpHandle paramLoseHpHandle) {
/* 2511 */     this.xFighter.getHandleonlosehphandle().add(paramLoseHpHandle);
/*      */   }
/*      */   
/*      */   public final void remLoseHpHandle(mzm.gsp.fight.handle.LoseHpHandle paramLoseHpHandle) {
/* 2515 */     this.xFighter.getHandleonlosehphandle().remove(paramLoseHpHandle);
/*      */   }
/*      */   
/*      */   public final void addRebirthHandle(mzm.gsp.fight.handle.RebirthHandle paramRebirthHandle) {
/* 2519 */     this.xFighter.getHandleonrebirth().add(paramRebirthHandle);
/*      */   }
/*      */   
/*      */   public final void remRebirthHandle(mzm.gsp.fight.handle.RebirthHandle paramRebirthHandle) {
/* 2523 */     this.xFighter.getHandleonrebirth().remove(paramRebirthHandle);
/*      */   }
/*      */   
/*      */   public final void addSkillCostHandle(mzm.gsp.fight.handle.SkillCostHandle paramSkillCostHandle) {
/* 2527 */     this.xFighter.getHandleonskillcost().add(paramSkillCostHandle);
/*      */   }
/*      */   
/*      */   public final void remSkillCostHandle(mzm.gsp.fight.handle.SkillCostHandle paramSkillCostHandle) {
/* 2531 */     this.xFighter.getHandleonskillcost().remove(paramSkillCostHandle);
/*      */   }
/*      */   
/*      */   public final void addSealedHandle(mzm.gsp.fight.handle.SealedHandle paramSealedHandle) {
/* 2535 */     this.xFighter.getHandleonsealed().add(paramSealedHandle);
/*      */   }
/*      */   
/*      */   public final void remSealedHandle(mzm.gsp.fight.handle.SealedHandle paramSealedHandle) {
/* 2539 */     this.xFighter.getHandleonsealed().remove(paramSealedHandle);
/*      */   }
/*      */   
/*      */   public final void addDrugHandle(mzm.gsp.fight.handle.DrugHandle paramDrugHandle) {
/* 2543 */     this.xFighter.getHandleondrughandle().add(paramDrugHandle);
/*      */   }
/*      */   
/*      */   public final void remDrugHandle(mzm.gsp.fight.handle.DrugHandle paramDrugHandle) {
/* 2547 */     this.xFighter.getHandleondrughandle().remove(paramDrugHandle);
/*      */   }
/*      */   
/*      */   public final void addCounterHandle(mzm.gsp.fight.handle.CounterHandle paramCounterHandle) {
/* 2551 */     this.xFighter.getHandleoncounter().add(paramCounterHandle);
/*      */   }
/*      */   
/*      */   public final void remCounterHandle(mzm.gsp.fight.handle.CounterHandle paramCounterHandle) {
/* 2555 */     this.xFighter.getHandleoncounter().remove(paramCounterHandle);
/*      */   }
/*      */   
/*      */   public final void addProtectHandle(mzm.gsp.fight.handle.ProtectHandle paramProtectHandle) {
/* 2559 */     this.xFighter.getHandleonprotect().add(paramProtectHandle);
/*      */   }
/*      */   
/*      */   public final void remProtectHandle(mzm.gsp.fight.handle.ProtectHandle paramProtectHandle) {
/* 2563 */     this.xFighter.getHandleonprotect().remove(paramProtectHandle);
/*      */   }
/*      */   
/*      */   public final void addTauntHandle(mzm.gsp.fight.handle.TauntHandle paramTauntHandle) {
/* 2567 */     this.xFighter.getHandleontaunt().add(paramTauntHandle);
/*      */   }
/*      */   
/*      */   public final void remTauntHandle(mzm.gsp.fight.handle.TauntHandle paramTauntHandle) {
/* 2571 */     this.xFighter.getHandleontaunt().remove(paramTauntHandle);
/*      */   }
/*      */   
/*      */   public final void addReboundHandle(mzm.gsp.fight.handle.ReboundHandle paramReboundHandle) {
/* 2575 */     this.xFighter.getHandleonrebound().add(paramReboundHandle);
/*      */   }
/*      */   
/*      */   public final void remReboundHandle(mzm.gsp.fight.handle.ReboundHandle paramReboundHandle) {
/* 2579 */     this.xFighter.getHandleonrebound().remove(paramReboundHandle);
/*      */   }
/*      */   
/*      */   public final void addEnterFightHandle(mzm.gsp.fight.handle.EnterFightHandle paramEnterFightHandle) {
/* 2583 */     this.xFighter.getHandleonenterfight().add(paramEnterFightHandle);
/*      */   }
/*      */   
/*      */   public final void remEnterFightHandle(mzm.gsp.fight.handle.EnterFightHandle paramEnterFightHandle) {
/* 2587 */     this.xFighter.getHandleonenterfight().remove(paramEnterFightHandle);
/*      */   }
/*      */   
/*      */   public final void addPetEnterFightHandle(mzm.gsp.fight.handle.PetEnterFightHandle paramPetEnterFightHandle) {
/* 2591 */     this.xFighter.getHandleonpetenterfighthandle().add(paramPetEnterFightHandle);
/*      */   }
/*      */   
/*      */   public final void remPetEnterFightHandle(mzm.gsp.fight.handle.PetEnterFightHandle paramPetEnterFightHandle) {
/* 2595 */     this.xFighter.getHandleonpetenterfighthandle().remove(paramPetEnterFightHandle);
/*      */   }
/*      */   
/*      */   public final void addChildEnterFightHandle(mzm.gsp.fight.handle.ChildEnterFightHandle paramChildEnterFightHandle) {
/* 2599 */     this.xFighter.getHandleonchildenterfighthandle().add(paramChildEnterFightHandle);
/*      */   }
/*      */   
/*      */   public final void remChildEnterFightHandle(mzm.gsp.fight.handle.ChildEnterFightHandle paramChildEnterFightHandle) {
/* 2603 */     this.xFighter.getHandleonchildenterfighthandle().remove(paramChildEnterFightHandle);
/*      */   }
/*      */   
/*      */   public final void addFighterDeadHandle(mzm.gsp.fight.handle.FighterDeadHandle paramFighterDeadHandle) {
/* 2607 */     this.xFighter.getHandleonfighterdead().add(paramFighterDeadHandle);
/*      */   }
/*      */   
/*      */   public final void remFighterDeadHandle(mzm.gsp.fight.handle.FighterDeadHandle paramFighterDeadHandle) {
/* 2611 */     this.xFighter.getHandleonfighterdead().remove(paramFighterDeadHandle);
/*      */   }
/*      */   
/*      */   public final void addBeforeUseSkillHandle(mzm.gsp.fight.handle.BeforeUseSkilHandle paramBeforeUseSkilHandle) {
/* 2615 */     this.xFighter.getHandleonbeforeuseskill().add(paramBeforeUseSkilHandle);
/*      */   }
/*      */   
/*      */   public final void remBeforeUseSkillHandle(mzm.gsp.fight.handle.BeforeUseSkilHandle paramBeforeUseSkilHandle) {
/* 2619 */     this.xFighter.getHandleonbeforeuseskill().remove(paramBeforeUseSkilHandle);
/*      */   }
/*      */   
/*      */   public final void addAftUseSkillHandle(mzm.gsp.fight.handle.AftUseSkilHandle paramAftUseSkilHandle) {
/* 2623 */     this.xFighter.getHandleonaftuseskill().add(paramAftUseSkilHandle);
/*      */   }
/*      */   
/*      */   public final void remAftUseSkillHandle(mzm.gsp.fight.handle.AftUseSkilHandle paramAftUseSkilHandle) {
/* 2627 */     this.xFighter.getHandleonaftuseskill().remove(paramAftUseSkilHandle);
/*      */   }
/*      */   
/*      */   public final void addSkillCausingDeathHandle(mzm.gsp.fight.handle.SkillCausingDeathHandle paramSkillCausingDeathHandle) {
/* 2631 */     this.xFighter.getHandleonskillcausingdeath().add(paramSkillCausingDeathHandle);
/*      */   }
/*      */   
/*      */   public final void remSkillCausingDeathHandle(mzm.gsp.fight.handle.SkillCausingDeathHandle paramSkillCausingDeathHandle) {
/* 2635 */     this.xFighter.getHandleonskillcausingdeath().remove(paramSkillCausingDeathHandle);
/*      */   }
/*      */   
/*      */   public final void addAftSummonUseSkillHandle(mzm.gsp.fight.handle.AfterSummonHandle paramAfterSummonHandle) {
/* 2639 */     this.xFighter.getHandleonaftsummonhandle().add(paramAfterSummonHandle);
/*      */   }
/*      */   
/*      */   public final void remAftSummonUseSkillHandle(mzm.gsp.fight.handle.AfterSummonHandle paramAfterSummonHandle) {
/* 2643 */     this.xFighter.getHandleonaftsummonhandle().remove(paramAfterSummonHandle);
/*      */   }
/*      */   
/*      */   public final void addBeforeHealHandle(mzm.gsp.fight.handle.BeforeHealHandle paramBeforeHealHandle) {
/* 2647 */     this.xFighter.getHandleonbeforeheal().add(paramBeforeHealHandle);
/*      */   }
/*      */   
/*      */   public final void remBeforeHealHandle(mzm.gsp.fight.handle.BeforeHealHandle paramBeforeHealHandle) {
/* 2651 */     this.xFighter.getHandleonbeforeheal().remove(paramBeforeHealHandle);
/*      */   }
/*      */   
/*      */   public final void addTargetNumHandle(mzm.gsp.fight.handle.TargetNumHandle paramTargetNumHandle) {
/* 2655 */     this.xFighter.getHandleontargetnumhandle().add(paramTargetNumHandle);
/*      */   }
/*      */   
/*      */   public final void remTargetNumHandle(mzm.gsp.fight.handle.TargetNumHandle paramTargetNumHandle) {
/* 2659 */     this.xFighter.getHandleontargetnumhandle().remove(paramTargetNumHandle);
/*      */   }
/*      */   
/*      */   public final void addBeforePoisonHandle(mzm.gsp.fight.handle.BeforePoisonHandle paramBeforePoisonHandle) {
/* 2663 */     this.xFighter.getHandleonbeforepoisonhandle().add(paramBeforePoisonHandle);
/*      */   }
/*      */   
/*      */   public final void remBeforePoisonHandle(mzm.gsp.fight.handle.BeforePoisonHandle paramBeforePoisonHandle) {
/* 2667 */     this.xFighter.getHandleonbeforepoisonhandle().remove(paramBeforePoisonHandle);
/*      */   }
/*      */   
/*      */   public final void addOtherBekilledAfterhandle(mzm.gsp.fight.handle.OtherBeKilledAfterHandle paramOtherBeKilledAfterHandle) {
/* 2671 */     this.xFighter.getHandleonotherbekilledafter().add(paramOtherBeKilledAfterHandle);
/*      */   }
/*      */   
/*      */   public final void remOtherBekilledAfterhandle(mzm.gsp.fight.handle.OtherBeKilledAfterHandle paramOtherBeKilledAfterHandle) {
/* 2675 */     this.xFighter.getHandleonotherbekilledafter().remove(paramOtherBeKilledAfterHandle);
/*      */   }
/*      */   
/*      */   abstract void onDead();
/*      */   
/*      */   protected void onFighterDead() {
/* 2681 */     setAnger(0.0D);
/* 2682 */     for (Iterator localIterator1 = this.xFighter.getBuffs().values().iterator(); localIterator1.hasNext();) { localObject1 = (FighterBuffs)localIterator1.next();
/* 2683 */       Iterator localIterator2 = ((FighterBuffs)localObject1).getBuffs().iterator();
/* 2684 */       while (localIterator2.hasNext()) {
/* 2685 */         localObject2 = (FighterBuff)localIterator2.next();
/* 2686 */         if (((FighterBuff)localObject2).getIsDieAway()) {
/* 2687 */           if (((FighterBuff)localObject2).isEffect()) {
/* 2688 */             setBuffUnEffect((FighterBuff)localObject2);
/*      */           }
/* 2690 */           localIterator2.remove();
/*      */         } } }
/*      */     Object localObject1;
/*      */     Object localObject2;
/* 2694 */     for (localIterator1 = this.xFighter.getTargetstatusbuffs().entrySet().iterator(); localIterator1.hasNext();) { localObject1 = (Map.Entry)localIterator1.next();
/* 2695 */       i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
/* 2696 */       for (localObject2 = ((Targets)((Map.Entry)localObject1).getValue()).getTargets().iterator(); ((Iterator)localObject2).hasNext();) { int j = ((Integer)((Iterator)localObject2).next()).intValue();
/* 2697 */         Fighter localFighter = getFighter(j);
/* 2698 */         if ((localFighter != null) && 
/*      */         
/*      */ 
/* 2701 */           (localFighter.removeBuff(i)))
/*      */         {
/*      */ 
/* 2704 */           addInfluenceTarget(j); }
/*      */       } }
/*      */     int i;
/* 2707 */     this.xFighter.getTargetstatusbuffs().clear();
/* 2708 */     this.fightGroup.fightTeam.addDeadTimes();
/* 2709 */     this.fightGroup.getFight().onFighterDie(this.fighterid);
/* 2710 */     addDeadCount();
/*      */   }
/*      */   
/*      */   public void onRelive() {
/* 2714 */     this.fightGroup.getFight().onFighterRelive(this.fighterid);
/* 2715 */     addReliveCount();
/*      */   }
/*      */   
/*      */   protected abstract void onFightEnd();
/*      */   
/*      */   protected void onTargetFighterDie(int paramInt) {
/* 2721 */     AI localAI = getAI();
/* 2722 */     if (localAI != null) {
/* 2723 */       localAI.onFighterDie(this.fightGroup.getFight(), this, paramInt);
/*      */     }
/* 2725 */     handleOtherDie(getFighter(paramInt));
/*      */   }
/*      */   
/*      */   protected void onTargetFighterRelive(int paramInt) {
/* 2729 */     AI localAI = getAI();
/* 2730 */     if (localAI != null) {
/* 2731 */       localAI.onFighterRelive(this.fightGroup.getFight(), this, paramInt);
/*      */     }
/*      */   }
/*      */   
/*      */   protected int getSkillLevel(int paramInt) {
/* 2736 */     if (this.xFighter.getSkills().containsKey(Integer.valueOf(paramInt))) {
/* 2737 */       return ((Integer)this.xFighter.getSkills().get(Integer.valueOf(paramInt))).intValue();
/*      */     }
/* 2739 */     return getLevel();
/*      */   }
/*      */   
/*      */   public final int getid() {
/* 2743 */     return this.fighterid;
/*      */   }
/*      */   
/*      */   public final boolean isOperable() {
/* 2747 */     return (isExisted()) && (!isFakeDead()) && (!isDead()) && (!isSleep()) && (!isIceCool()) && (!isStone());
/*      */   }
/*      */   
/*      */   protected void setDead() {
/* 2751 */     this.xFighter.setState(1);
/*      */   }
/*      */   
/*      */   public final void setFakeDead() {
/* 2755 */     this.xFighter.setState(3);
/*      */   }
/*      */   
/*      */   public final void setAlive() {
/* 2759 */     this.xFighter.setState(0);
/*      */   }
/*      */   
/*      */   protected void setEscape() {
/* 2763 */     this.xFighter.setState(2);
/*      */   }
/*      */   
/*      */   public boolean isExisted() {
/* 2767 */     return (isAlive()) || (isFakeDead());
/*      */   }
/*      */   
/*      */   public final boolean isAlive() {
/* 2771 */     return this.xFighter.getState() == 0;
/*      */   }
/*      */   
/*      */   public final boolean isDead() {
/* 2775 */     return this.xFighter.getState() == 1;
/*      */   }
/*      */   
/*      */   protected final boolean isEscaped() {
/* 2779 */     return this.xFighter.getState() == 2;
/*      */   }
/*      */   
/*      */   public final boolean isFakeDead() {
/* 2783 */     return this.xFighter.getState() == 3;
/*      */   }
/*      */   
/*      */   public final boolean isCmdedInRound() {
/* 2787 */     return this.fightGroup.getFight().isCmdedInRound(this.fighterid);
/*      */   }
/*      */   
/*      */   protected final int getState() {
/* 2791 */     return this.xFighter.getState();
/*      */   }
/*      */   
/*      */   public final int getType() {
/* 2795 */     return this.xFighter.getType();
/*      */   }
/*      */   
/*      */   public final boolean isRoleType() {
/* 2799 */     return this.xFighter.getType() == 1;
/*      */   }
/*      */   
/*      */   public final boolean isPetType() {
/* 2803 */     return this.xFighter.getType() == 4;
/*      */   }
/*      */   
/*      */   public final boolean isFellowType() {
/* 2807 */     return this.xFighter.getType() == 2;
/*      */   }
/*      */   
/*      */   public final boolean isChildType() {
/* 2811 */     return this.xFighter.getType() == 16;
/*      */   }
/*      */   
/*      */   public final boolean isRole() {
/* 2815 */     return (!isCloneRole()) && (this.xFighter.getType() == 1);
/*      */   }
/*      */   
/*      */   public final boolean isPet() {
/* 2819 */     return (!isClonePet()) && (this.xFighter.getType() == 4);
/*      */   }
/*      */   
/*      */   public final boolean isMonster() {
/* 2823 */     return this.xFighter.getType() == 8;
/*      */   }
/*      */   
/*      */   public final boolean isChild() {
/* 2827 */     return this.xFighter.getType() == 16;
/*      */   }
/*      */   
/*      */   public final boolean isFellow() {
/* 2831 */     return (!isCloneFellow()) && (this.xFighter.getType() == 2);
/*      */   }
/*      */   
/*      */   public final boolean isCloneRole() {
/* 2835 */     if (this.xFighter.getType() == 1) {
/* 2836 */       Integer localInteger = (Integer)this.xFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2837 */       return (localInteger != null) && (localInteger.intValue() == 1);
/*      */     }
/* 2839 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean isClonePet() {
/* 2843 */     if (this.xFighter.getType() == 4) {
/* 2844 */       Integer localInteger = (Integer)this.xFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2845 */       return (localInteger != null) && (localInteger.intValue() == 4);
/*      */     }
/* 2847 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean isCloneChild() {
/* 2851 */     if (this.xFighter.getType() == 16) {
/* 2852 */       Integer localInteger = (Integer)this.xFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2853 */       return (localInteger != null) && (localInteger.intValue() == 16);
/*      */     }
/* 2855 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean isCloneFellow() {
/* 2859 */     if (this.xFighter.getType() == 2) {
/* 2860 */       Integer localInteger = (Integer)this.xFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2861 */       return (localInteger != null) && (localInteger.intValue() == 2);
/*      */     }
/* 2863 */     return false;
/*      */   }
/*      */   
/*      */   public final boolean isClone() {
/* 2867 */     return this.xFighter.getExtra().containsKey(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/*      */   }
/*      */   
/*      */   public static final boolean isCloneRole(xbean.Fighter paramFighter) {
/* 2871 */     if (paramFighter.getType() == 1) {
/* 2872 */       Integer localInteger = (Integer)paramFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2873 */       return (localInteger != null) && (localInteger.intValue() == 1);
/*      */     }
/* 2875 */     return false;
/*      */   }
/*      */   
/*      */   public static final boolean isCloneFellow(xbean.Fighter paramFighter) {
/* 2879 */     if (paramFighter.getType() == 2) {
/* 2880 */       Integer localInteger = (Integer)paramFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2881 */       return (localInteger != null) && (localInteger.intValue() == 2);
/*      */     }
/* 2883 */     return false;
/*      */   }
/*      */   
/*      */   public static final boolean isClonePet(xbean.Fighter paramFighter) {
/* 2887 */     if (paramFighter.getType() == 4) {
/* 2888 */       Integer localInteger = (Integer)paramFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2889 */       return (localInteger != null) && (localInteger.intValue() == 4);
/*      */     }
/* 2891 */     return false;
/*      */   }
/*      */   
/*      */   public static final boolean isCloneChild(xbean.Fighter paramFighter) {
/* 2895 */     if (paramFighter.getType() == 16) {
/* 2896 */       Integer localInteger = (Integer)paramFighter.getExtra().get(Integer.valueOf(FighterExtra.CLONE_MINI_TYPE.ordinal()));
/* 2897 */       return (localInteger != null) && (localInteger.intValue() == 16);
/*      */     }
/* 2899 */     return false;
/*      */   }
/*      */   
/*      */   protected final mzm.gsp.fight.Fighter getFighterBean() {
/* 2903 */     mzm.gsp.fight.Fighter localFighter = new mzm.gsp.fight.Fighter();
/* 2904 */     fillFighterBean(localFighter);
/* 2905 */     return localFighter;
/*      */   }
/*      */   
/*      */   protected final void fillFighterBean(mzm.gsp.fight.Fighter paramFighter) {
/* 2909 */     paramFighter.fighter_type = getType();
/* 2910 */     paramFighter.name = getName();
/* 2911 */     paramFighter.level = getLevel();
/* 2912 */     paramFighter.gender = getGenderInit();
/* 2913 */     paramFighter.occupation = getOccupationInit();
/* 2914 */     if ((this instanceof FighterMonster)) {
/* 2915 */       paramFighter.cfgid = ((FighterMonster)this).getMonsterid();
/*      */     }
/* 2917 */     else if (isPetType()) {
/* 2918 */       paramFighter.cfgid = getExtra(FighterExtra.PET_CFG_ID);
/*      */     }
/* 2920 */     fillModelInfo(paramFighter.model);
/* 2921 */     paramFighter.pos = getPos();
/* 2922 */     paramFighter.uuid = getUuid();
/* 2923 */     fillFighterStatus(paramFighter.status);
/* 2924 */     for (Map.Entry localEntry : this.xFighter.getSkilldatas().entrySet()) {
/* 2925 */       mzm.gsp.fight.SkillData localSkillData = new mzm.gsp.fight.SkillData();
/* 2926 */       paramFighter.skilldatas.put(localEntry.getKey(), localSkillData);
/* 2927 */       xbean.SkillData localSkillData1 = (xbean.SkillData)localEntry.getValue();
/* 2928 */       localSkillData.skillusecount = localSkillData1.getUsecount();
/* 2929 */       localSkillData.skilluseround = localSkillData1.getUseround();
/*      */     }
/*      */   }
/*      */   
/*      */   protected final void fillCommonBuff(FighterStatus paramFighterStatus) {
/* 2934 */     Buff localBuff1 = new Buff();
/* 2935 */     localBuff1.buffid = -1;
/* 2936 */     localBuff1.round = (getCurrentChangeModelCardClassType() << 16 | getCurrentChangeModelCardLevel());
/* 2937 */     addFighterStatusBuffbean(paramFighterStatus, localBuff1);
/* 2938 */     Set localSet = this.xFighter.getEffecttargets().entrySet();
/* 2939 */     for (Iterator localIterator = localSet.iterator(); localIterator.hasNext();) { localObject1 = (Map.Entry)localIterator.next();
/* 2940 */       i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
/* 2941 */       localObject2 = (Targets)((Map.Entry)localObject1).getValue();
/* 2942 */       localObject3 = ((Targets)localObject2).getTargets().iterator();
/* 2943 */       int j = 0;
/* 2944 */       while (((Iterator)localObject3).hasNext()) {
/* 2945 */         int k = ((Integer)((Iterator)localObject3).next()).intValue();
/* 2946 */         Buff localBuff4 = new Buff();
/* 2947 */         localBuff4.buffid = (i - j);
/* 2948 */         localBuff4.round = k;
/* 2949 */         addFighterStatusBuffbean(paramFighterStatus, localBuff4);
/* 2950 */         j++;
/*      */       } }
/*      */     Object localObject3;
/* 2953 */     localIterator = paramFighterStatus.buffs.iterator();
/* 2954 */     while (localIterator.hasNext()) {
/* 2955 */       localObject1 = (Buff)localIterator.next();
/* 2956 */       if ((((Buff)localObject1).buffid <= -100) && (((Buff)localObject1).buffid >= 65337)) {
/* 2957 */         localIterator.remove();
/*      */       }
/* 2959 */       if ((((Buff)localObject1).buffid <= 65236) && (((Buff)localObject1).buffid >= 65137)) {
/* 2960 */         localIterator.remove();
/*      */       }
/*      */     }
/* 2963 */     Object localObject1 = this.xFighter.getFightstates().entrySet();
/* 2964 */     int i = 0;
/* 2965 */     for (Object localObject2 = ((Set)localObject1).iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (Map.Entry)((Iterator)localObject2).next();
/* 2966 */       Buff localBuff2 = new Buff();
/* 2967 */       localBuff2.buffid = (-100 - i);
/* 2968 */       localBuff2.round = ((FightState)((Map.Entry)localObject3).getValue()).getGroup();
/* 2969 */       paramFighterStatus.buffs.add(localBuff2);
/* 2970 */       Buff localBuff3 = new Buff();
/* 2971 */       localBuff3.buffid = (65236 - i);
/* 2972 */       localBuff3.round = ((FightState)((Map.Entry)localObject3).getValue()).getState();
/* 2973 */       paramFighterStatus.buffs.add(localBuff3);
/* 2974 */       i++;
/*      */     }
/* 2976 */     localObject2 = getMirrorFighter();
/* 2977 */     if (localObject2 != null) {
/* 2978 */       localObject3 = new Buff();
/* 2979 */       ((Buff)localObject3).buffid = -60;
/* 2980 */       ((Buff)localObject3).round = ((Fighter)localObject2).getid();
/* 2981 */       addFighterStatusBuffbean(paramFighterStatus, (Buff)localObject3);
/*      */     }
/*      */   }
/*      */   
/*      */   private void clearBuffs(List<Buff> paramList) {
/* 2986 */     Iterator localIterator = paramList.iterator();
/* 2987 */     while (localIterator.hasNext()) {
/* 2988 */       Buff localBuff = (Buff)localIterator.next();
/* 2989 */       if (localBuff.buffid != -61)
/*      */       {
/*      */ 
/* 2992 */         localIterator.remove(); }
/*      */     }
/*      */   }
/*      */   
/*      */   public final void fillBuffStatus(FighterStatus paramFighterStatus) {
/* 2997 */     paramFighterStatus.buff_status_set.clear();
/* 2998 */     paramFighterStatus.buff_status_set.addAll(this.xFighter.getBuff_states().keySet());
/* 2999 */     clearBuffs(paramFighterStatus.buffs);
/* 3000 */     for (FighterBuff localFighterBuff : getAllEffectBuff())
/* 3001 */       if (localFighterBuff.getLeftRound() > 0)
/*      */       {
/*      */ 
/* 3004 */         Buff localBuff = new Buff();
/* 3005 */         localBuff.buffid = localFighterBuff.getBuffCfgId();
/* 3006 */         localBuff.round = localFighterBuff.getLeftRound();
/* 3007 */         paramFighterStatus.buffs.add(localBuff);
/*      */       }
/* 3009 */     fillCommonBuff(paramFighterStatus);
/* 3010 */     paramFighterStatus.hpmax = ((int)getMaxHp());
/* 3011 */     paramFighterStatus.curhp = getHp();
/* 3012 */     paramFighterStatus.mpmax = ((int)getMaxMp());
/* 3013 */     paramFighterStatus.curmp = getMp();
/* 3014 */     paramFighterStatus.angermax = getMaxAnger();
/* 3015 */     paramFighterStatus.curanger = getAnger();
/* 3016 */     paramFighterStatus.curenergy = getEnergy();
/*      */   }
/*      */   
/*      */   public final void fillFighterStatus(FighterStatus paramFighterStatus) {
/* 3020 */     paramFighterStatus.buff_status_set.clear();
/* 3021 */     paramFighterStatus.buff_status_set.addAll(this.xFighter.getBuff_states().keySet());
/* 3022 */     clearBuffs(paramFighterStatus.buffs);
/* 3023 */     for (FighterBuff localFighterBuff : getAllEffectBuff())
/* 3024 */       if (localFighterBuff.getLeftRound() > 0)
/*      */       {
/*      */ 
/* 3027 */         Buff localBuff = new Buff();
/* 3028 */         localBuff.buffid = localFighterBuff.getBuffCfgId();
/* 3029 */         localBuff.round = localFighterBuff.getLeftRound();
/* 3030 */         paramFighterStatus.buffs.add(localBuff);
/*      */       }
/* 3032 */     fillCommonBuff(paramFighterStatus);
/* 3033 */     paramFighterStatus.status_set.add(Integer.valueOf(this.xFighter.getState()));
/* 3034 */     paramFighterStatus.hpmax = ((int)getMaxHp());
/* 3035 */     paramFighterStatus.curhp = getHp();
/* 3036 */     paramFighterStatus.mpmax = ((int)getMaxMp());
/* 3037 */     paramFighterStatus.curmp = getMp();
/* 3038 */     paramFighterStatus.angermax = getMaxAnger();
/* 3039 */     paramFighterStatus.curanger = getAnger();
/* 3040 */     paramFighterStatus.curenergy = getEnergy();
/* 3041 */     paramFighterStatus.changemodels.clear();
/* 3042 */     for (??? = this.xFighter.getChangemodelids().iterator(); ???.hasNext();) { int i = ((Integer)???.next()).intValue();
/* 3043 */       paramFighterStatus.changemodels.add(Integer.valueOf(i));
/*      */     }
/*      */   }
/*      */   
/*      */   protected static final void sendDefalutSkillChangeRes(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {
/* 3048 */     mzm.gsp.fight.SChangeDefaultSkillRes localSChangeDefaultSkillRes = new mzm.gsp.fight.SChangeDefaultSkillRes();
/* 3049 */     localSChangeDefaultSkillRes.skill = paramInt1;
/* 3050 */     localSChangeDefaultSkillRes.uuid = paramLong2;
/* 3051 */     localSChangeDefaultSkillRes.roleid = paramLong1;
/* 3052 */     localSChangeDefaultSkillRes.fighter_type = paramInt2;
/* 3053 */     mzm.gsp.online.main.OnlineManager.getInstance().send(paramLong1, localSChangeDefaultSkillRes);
/*      */   }
/*      */   
/*      */   protected final int getExtra(FighterExtra paramFighterExtra) {
/* 3057 */     Integer localInteger = (Integer)this.xFighter.getExtra().get(Integer.valueOf(paramFighterExtra.ordinal()));
/* 3058 */     if (localInteger == null) {
/* 3059 */       return 0;
/*      */     }
/* 3061 */     return localInteger.intValue();
/*      */   }
/*      */   
/*      */   protected final void setExtra(FighterExtra paramFighterExtra, int paramInt) {
/* 3065 */     if (paramInt == 0) {
/* 3066 */       this.xFighter.getExtra().remove(Integer.valueOf(paramFighterExtra.ordinal()));
/*      */     }
/*      */     else {
/* 3069 */       this.xFighter.getExtra().put(Integer.valueOf(paramFighterExtra.ordinal()), Integer.valueOf(paramInt));
/*      */     }
/*      */   }
/*      */   
/*      */   protected final void remExtra(FighterExtra paramFighterExtra) {
/* 3074 */     this.xFighter.getExtra().remove(Integer.valueOf(paramFighterExtra.ordinal()));
/*      */   }
/*      */   
/*      */   public String getName() {
/* 3078 */     IOutFightObject localIOutFightObject = getOutFightObj();
/* 3079 */     if (localIOutFightObject != null) {
/* 3080 */       return localIOutFightObject.getName();
/*      */     }
/* 3082 */     GameServer.logger().error("战斗外对象不存在");
/* 3083 */     return "XX";
/*      */   }
/*      */   
/*      */   public int getLevel() {
/* 3087 */     IOutFightObject localIOutFightObject = getOutFightObj();
/* 3088 */     if (localIOutFightObject != null) {
/* 3089 */       return localIOutFightObject.getLevel();
/*      */     }
/* 3091 */     GameServer.logger().error("战斗外对象不存在");
/* 3092 */     return 0;
/*      */   }
/*      */   
/*      */   public int getGender() {
/* 3096 */     return getExtra(FighterExtra.GENDER);
/*      */   }
/*      */   
/*      */   public int getGenderInit() {
/* 3100 */     IOutFightObject localIOutFightObject = getOutFightObj();
/* 3101 */     if (localIOutFightObject != null) {
/* 3102 */       return localIOutFightObject.getSex();
/*      */     }
/* 3104 */     return 1;
/*      */   }
/*      */   
/*      */   public void setGender(int paramInt) {
/* 3108 */     setExtra(FighterExtra.GENDER, paramInt);
/*      */   }
/*      */   
/*      */   public void setGender(IOutFightObject paramIOutFightObject) {
/* 3112 */     if (paramIOutFightObject != null) {
/* 3113 */       setGender(paramIOutFightObject.getSex());
/*      */     }
/*      */     else {
/* 3116 */       setGender(1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void setOccupation(int paramInt) {
/* 3121 */     setExtra(FighterExtra.OCCUPATION, paramInt);
/*      */   }
/*      */   
/*      */   public void setOccupation(IOutFightObject paramIOutFightObject) {
/* 3125 */     setExtra(FighterExtra.OCCUPATION, paramIOutFightObject.getOccupationId());
/*      */   }
/*      */   
/*      */   public final int getOccupationInit() {
/* 3129 */     return this.xFighter.getOutfightinfo().getOcp();
/*      */   }
/*      */   
/*      */   public final int getOccupation() {
/* 3133 */     return getExtra(FighterExtra.OCCUPATION);
/*      */   }
/*      */   
/*      */   public int getModelid() {
/* 3137 */     mzm.gsp.pubdata.ModelInfo localModelInfo = new mzm.gsp.pubdata.ModelInfo();
/* 3138 */     fillModelInfo(localModelInfo);
/* 3139 */     return localModelInfo.modelid;
/*      */   }
/*      */   
/*      */   protected abstract IOutFightObject getOutFightObj();
/*      */   
/*      */   public void fillModelInfo(mzm.gsp.pubdata.ModelInfo paramModelInfo) {
/* 3145 */     int i = getExtra(FighterExtra.CHANGE_MONSTER_MODEL);
/* 3146 */     if (i > 0) {
/* 3147 */       mzm.gsp.monster.main.MonsterInterface.fillModelInfo(i, paramModelInfo);
/* 3148 */       return;
/*      */     }
/* 3150 */     childFillModelInfo(paramModelInfo);
/*      */   }
/*      */   
/*      */   protected void childFillModelInfo(mzm.gsp.pubdata.ModelInfo paramModelInfo) {
/* 3154 */     IOutFightObject localIOutFightObject = getOutFightObj();
/* 3155 */     if (localIOutFightObject != null) {
/* 3156 */       localIOutFightObject.fillModelInfo(paramModelInfo);
/*      */     }
/*      */   }
/*      */   
/*      */   int getFighterBaseAttr(int paramInt) {
/* 3161 */     if (this.xFighter.getAttrs().containsKey(Integer.valueOf(paramInt))) {
/* 3162 */       return ((Integer)this.xFighter.getAttrs().get(Integer.valueOf(paramInt))).intValue();
/*      */     }
/* 3164 */     return 0;
/*      */   }
/*      */   
/*      */   public final int getPos() {
/* 3168 */     return this.xFighter.getPos();
/*      */   }
/*      */   
/*      */   protected final void setPos(int paramInt) {
/* 3172 */     this.xFighter.setPos(paramInt);
/*      */   }
/*      */   
/*      */   public final int getRow() {
/* 3176 */     int i = getPos();
/* 3177 */     int j = FightManager.getPosNumberPerRow();
/* 3178 */     return i / j;
/*      */   }
/*      */   
/*      */   protected long getUuid() {
/* 3182 */     return mzm.gsp.util.CommonUtils.getLong(getExtra(FighterExtra.Uuid_High), getExtra(FighterExtra.Uuid_Low));
/*      */   }
/*      */   
/*      */   protected final void setUuid(long paramLong) {
/* 3186 */     setExtra(FighterExtra.Uuid_High, mzm.gsp.util.CommonUtils.getLongHigh(paramLong));
/* 3187 */     setExtra(FighterExtra.Uuid_Low, mzm.gsp.util.CommonUtils.getLongLow(paramLong));
/*      */   }
/*      */   
/*      */   protected final boolean hasBuffState(int paramInt) {
/* 3191 */     return this.xFighter.getBuff_states().containsKey(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public final void addBuffState(int paramInt) {
/* 3195 */     if (this.xFighter.getBuff_states().containsKey(Integer.valueOf(paramInt))) {
/* 3196 */       int i = ((Integer)this.xFighter.getBuff_states().get(Integer.valueOf(paramInt))).intValue();
/* 3197 */       this.xFighter.getBuff_states().put(Integer.valueOf(paramInt), Integer.valueOf(++i));
/*      */     }
/*      */     else {
/* 3200 */       this.xFighter.getBuff_states().put(Integer.valueOf(paramInt), Integer.valueOf(1));
/*      */     }
/*      */   }
/*      */   
/*      */   public final void remBuffState(int paramInt) {
/* 3205 */     if (this.xFighter.getBuff_states().containsKey(Integer.valueOf(paramInt))) {
/* 3206 */       int i = ((Integer)this.xFighter.getBuff_states().get(Integer.valueOf(paramInt))).intValue();
/* 3207 */       i--; if (i <= 0) {
/* 3208 */         this.xFighter.getBuff_states().remove(Integer.valueOf(paramInt));
/*      */       }
/*      */       else {
/* 3211 */         this.xFighter.getBuff_states().put(Integer.valueOf(paramInt), Integer.valueOf(i));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public final FighterModelCard getChangeModelCard() {
/* 3217 */     return this.xFighter.getChangemodelcard();
/*      */   }
/*      */   
/*      */   public void initChangeModelCard(int paramInt1, int paramInt2) {
/* 3221 */     this.xFighter.getChangemodelcard().setInitclassindex(paramInt1);
/* 3222 */     this.xFighter.getChangemodelcard().setInitlevel(paramInt2);
/*      */   }
/*      */   
/*      */   public void setTmpChangeModelCard(int paramInt1, int paramInt2) {
/* 3226 */     this.xFighter.getChangemodelcard().setTmpclassindex(paramInt1);
/* 3227 */     this.xFighter.getChangemodelcard().setTmplevel(paramInt2);
/*      */   }
/*      */   
/*      */   protected final boolean isRest() {
/* 3231 */     return hasBuffState(100);
/*      */   }
/*      */   
/*      */   protected final boolean isIceCool() {
/* 3235 */     return hasBuffState(128);
/*      */   }
/*      */   
/*      */   protected final boolean isWeak() {
/* 3239 */     return hasBuffState(110);
/*      */   }
/*      */   
/*      */   protected final boolean isSleep() {
/* 3243 */     return hasBuffState(101);
/*      */   }
/*      */   
/*      */   protected final boolean isStone() {
/* 3247 */     return hasBuffState(102);
/*      */   }
/*      */   
/*      */   protected final boolean isMess() {
/* 3251 */     return hasBuffState(103);
/*      */   }
/*      */   
/*      */   protected final boolean isTaunt() {
/* 3255 */     return hasBuffState(127);
/*      */   }
/*      */   
/*      */   protected final boolean isSeal() {
/* 3259 */     return hasBuffState(104);
/*      */   }
/*      */   
/*      */   public final boolean isHouFa() {
/* 3263 */     return hasBuffState(105);
/*      */   }
/*      */   
/*      */   protected final boolean isForbidRebirth() {
/* 3267 */     return hasBuffState(106);
/*      */   }
/*      */   
/*      */   protected final boolean isFortune() {
/* 3271 */     return hasBuffState(112);
/*      */   }
/*      */   
/*      */   public final boolean isGhost() {
/* 3275 */     return hasBuffState(113);
/*      */   }
/*      */   
/*      */   public final boolean isBeatGhost() {
/* 3279 */     return hasBuffState(114);
/*      */   }
/*      */   
/*      */   protected final boolean isPersistent() {
/* 3283 */     return hasBuffState(115);
/*      */   }
/*      */   
/*      */   public final boolean isFly() {
/* 3287 */     return hasBuffState(116);
/*      */   }
/*      */   
/*      */   public final boolean isAgile() {
/* 3291 */     return hasBuffState(117);
/*      */   }
/*      */   
/*      */   public final boolean isAccurate() {
/* 3295 */     return hasBuffState(118);
/*      */   }
/*      */   
/*      */   protected final boolean isFear() {
/* 3299 */     return hasBuffState(119);
/*      */   }
/*      */   
/*      */   protected final boolean isSincerely() {
/* 3303 */     return hasBuffState(120);
/*      */   }
/*      */   
/*      */   public final boolean isTrial() {
/* 3307 */     return hasBuffState(121);
/*      */   }
/*      */   
/*      */   public final boolean isBarriers() {
/* 3311 */     return hasBuffState(122);
/*      */   }
/*      */   
/*      */   public final boolean isBreakBarriers() {
/* 3315 */     return hasBuffState(123);
/*      */   }
/*      */   
/*      */   public final boolean isParry() {
/* 3319 */     return hasBuffState(124);
/*      */   }
/*      */   
/*      */   public final boolean isPropertyReLive() {
/* 3323 */     return hasBuffState(125);
/*      */   }
/*      */   
/*      */   public final boolean isDeathTriggerSkill() {
/* 3327 */     return hasBuffState(130);
/*      */   }
/*      */   
/*      */   public final boolean isReleaseSkillDead() {
/* 3331 */     return hasBuffState(132);
/*      */   }
/*      */   
/*      */   protected final boolean isForbidUseItem()
/*      */   {
/* 3336 */     return hasBuffState(1001);
/*      */   }
/*      */   
/*      */   protected final boolean isForgetSkill()
/*      */   {
/* 3341 */     return hasBuffState(1002);
/*      */   }
/*      */   
/*      */   public final boolean isPlague()
/*      */   {
/* 3346 */     return hasBuffState(1003);
/*      */   }
/*      */   
/*      */   public final boolean isBeProtect() {
/* 3350 */     return hasBuffState(1004);
/*      */   }
/*      */   
/*      */   public final boolean isStrengInvisible() {
/* 3354 */     return hasBuffState(1005);
/*      */   }
/*      */   
/*      */   public final boolean isForbidSummon() {
/* 3358 */     return hasBuffState(1006);
/*      */   }
/*      */   
/*      */   public final boolean isTech() {
/* 3362 */     return hasBuffState(111);
/*      */   }
/*      */   
/*      */   public final boolean isInvisible() {
/* 3366 */     return (hasBuffState(107)) || (hasBuffState(1005));
/*      */   }
/*      */   
/*      */   public final boolean isVisible() {
/* 3370 */     return hasBuffState(108);
/*      */   }
/*      */   
/*      */   public final boolean isDefense() {
/* 3374 */     return hasBuffState(109);
/*      */   }
/*      */   
/*      */   public final boolean isNotLeave() {
/* 3378 */     return hasBuffState(129);
/*      */   }
/*      */   
/*      */   public final boolean isSubSoulBond() {
/* 3382 */     return hasBuffState(131);
/*      */   }
/*      */   
/*      */   protected final void addProtect(int paramInt) {
/* 3386 */     this.xFighter.getProtecterids().add(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   protected final Map<Integer, Integer> getAttrsMap() {
/* 3390 */     return this.xFighter.getAttrs();
/*      */   }
/*      */   
/*      */   protected final Map<Integer, Integer> getExa_AttrsMap() {
/* 3394 */     return this.xFighter.getEx_attrs();
/*      */   }
/*      */   
/*      */   protected final int getAttrsChange(int paramInt) {
/* 3398 */     if (this.xFighter.getEx_attrs().containsKey(Integer.valueOf(paramInt))) {
/* 3399 */       return ((Integer)this.xFighter.getEx_attrs().get(Integer.valueOf(paramInt))).intValue();
/*      */     }
/* 3401 */     return 0;
/*      */   }
/*      */   
/*      */   public xbean.FighterHealthInfo getRoundStartHealthInfo(int paramInt) {
/* 3405 */     return (xbean.FighterHealthInfo)this.xFighter.getHealthatroundstart().get(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public xbean.FighterHealthInfo getRoundEndHealthInfo(int paramInt) {
/* 3409 */     return (xbean.FighterHealthInfo)this.xFighter.getHealthatroundstart().get(Integer.valueOf(paramInt + 1));
/*      */   }
/*      */   
/*      */   protected final void setAttrsChange(int paramInt1, int paramInt2) {
/* 3413 */     this.xFighter.getEx_attrs().put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*      */   }
/*      */   
/*      */   protected final void initSpeedFluctuateRate() {
/* 3417 */     int i = 0;
/* 3418 */     if (SFightConsts.getInstance().SPEED_FLUCTUATE_RATE > 0) {
/* 3419 */       i = xdb.Xdb.random().nextInt(SFightConsts.getInstance().SPEED_FLUCTUATE_RATE);
/*      */     }
/* 3421 */     if (xdb.Xdb.random().nextBoolean()) {
/* 3422 */       i *= -1;
/*      */     }
/* 3424 */     setExtra(FighterExtra.Speed_Fluctuate_Rate, i);
/*      */   }
/*      */   
/*      */   public final int getHp() {
/* 3428 */     return this.xFighter.getHp();
/*      */   }
/*      */   
/*      */   public final void setHp(int paramInt) {
/* 3432 */     this.xFighter.setHp(paramInt);
/*      */   }
/*      */   
/*      */   public final double getMaxHp() {
/* 3436 */     int i = getFighterBaseAttr(1);
/* 3437 */     int j = getFighterBaseAttr(30);
/* 3438 */     int k = getAttrsChange(1);
/* 3439 */     int m = getAttrsChange(30);
/* 3440 */     int n = j + m;
/* 3441 */     return PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addMaxFixHp(int paramInt) {
/* 3445 */     int i = getAttrsChange(1);
/* 3446 */     i += paramInt;
/* 3447 */     setAttrsChange(1, i);
/* 3448 */     if (paramInt < 0) {
/* 3449 */       modifyCurHp();
/*      */     }
/*      */     else {
/* 3452 */       setHp(getHp() + paramInt);
/*      */     }
/*      */   }
/*      */   
/*      */   private final void modifyCurHp() {
/* 3457 */     int i = getHp();
/* 3458 */     int j = (int)getMaxHp();
/* 3459 */     if (i > j) {
/* 3460 */       setHp(j);
/*      */     }
/*      */   }
/*      */   
/*      */   public final double getCurHpRateValue() {
/* 3465 */     return getHp() * 1.0D / getMaxHp() * FightArgs.getInstance().defaultRate;
/*      */   }
/*      */   
/*      */   public final int getMaxHpRate() {
/* 3469 */     int i = getFighterBaseAttr(30);
/* 3470 */     int j = getAttrsChange(30);
/* 3471 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addMaxHpRate(int paramInt) {
/* 3475 */     int i = (int)getMaxHp();
/* 3476 */     int j = getAttrsChange(30);
/* 3477 */     j += paramInt;
/* 3478 */     setAttrsChange(30, j);
/* 3479 */     int k = (int)getMaxHp();
/* 3480 */     int m = k - i;
/* 3481 */     if (m < 0) {
/* 3482 */       modifyCurHp();
/*      */     }
/*      */     else {
/* 3485 */       setHp(m + getHp());
/*      */     }
/*      */   }
/*      */   
/*      */   public final int getHealCrtRate() {
/* 3490 */     int i = getFighterBaseAttr(13);
/* 3491 */     int j = getAttrsChange(13);
/* 3492 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getHealEffectValue() {
/* 3496 */     int i = getFighterBaseAttr(80);
/* 3497 */     int j = getAttrsChange(80);
/* 3498 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addHealEffectValue(int paramInt) {
/* 3502 */     int i = getAttrsChange(80);
/* 3503 */     i += paramInt;
/* 3504 */     setAttrsChange(80, i);
/*      */   }
/*      */   
/*      */   public final int getHealEffectRate() {
/* 3508 */     int i = getFighterBaseAttr(81);
/* 3509 */     int j = getAttrsChange(81);
/* 3510 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addHealEffectRate(int paramInt) {
/* 3514 */     int i = getAttrsChange(81);
/* 3515 */     i += paramInt;
/* 3516 */     setAttrsChange(81, i);
/*      */   }
/*      */   
/*      */   public final int getBeHealEffectValue() {
/* 3520 */     int i = getFighterBaseAttr(72);
/* 3521 */     int j = getAttrsChange(72);
/* 3522 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addBeHealEffectValue(int paramInt) {
/* 3526 */     int i = getAttrsChange(72);
/* 3527 */     i += paramInt;
/* 3528 */     setAttrsChange(72, i);
/*      */   }
/*      */   
/*      */   public final int getBeHealEffectRate() {
/* 3532 */     int i = getFighterBaseAttr(73);
/* 3533 */     int j = getAttrsChange(73);
/* 3534 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addBeHealEffectRate(int paramInt) {
/* 3538 */     int i = getAttrsChange(73);
/* 3539 */     i += paramInt;
/* 3540 */     setAttrsChange(73, i);
/*      */   }
/*      */   
/*      */   public void addAttriChangeProperty(int paramInt1, int paramInt2) {
/* 3544 */     int i = getAttrsChange(paramInt1);
/* 3545 */     i += paramInt2;
/* 3546 */     setAttrsChange(paramInt1, i);
/*      */   }
/*      */   
/*      */   public final int getMp() {
/* 3550 */     return this.xFighter.getMp();
/*      */   }
/*      */   
/*      */   public final void setMp(int paramInt) {
/* 3554 */     this.xFighter.setMp(paramInt);
/*      */   }
/*      */   
/*      */   public final void addMaxMp(int paramInt) {
/* 3558 */     int i = getAttrsChange(3);
/* 3559 */     i += paramInt;
/* 3560 */     setAttrsChange(3, i);
/* 3561 */     if (paramInt < 0) {
/* 3562 */       modifyCurMp();
/*      */     }
/*      */   }
/*      */   
/*      */   private final void modifyCurMp() {
/* 3567 */     int i = getMp();
/* 3568 */     int j = (int)getMaxMp();
/* 3569 */     if (i > j) {
/* 3570 */       setMp(j);
/*      */     }
/*      */   }
/*      */   
/*      */   public final double getMaxMp() {
/* 3575 */     int i = getFighterBaseAttr(3);
/* 3576 */     int j = getFighterBaseAttr(31);
/* 3577 */     int k = getAttrsChange(3);
/* 3578 */     int m = getAttrsChange(31);
/* 3579 */     int n = j + m;
/* 3580 */     return PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addMaxMpRate(int paramInt) {
/* 3584 */     int i = getAttrsChange(31);
/* 3585 */     i += paramInt;
/* 3586 */     setAttrsChange(31, i);
/* 3587 */     if (paramInt < 0) {
/* 3588 */       modifyCurMp();
/*      */     }
/*      */   }
/*      */   
/*      */   public final double getCurMpRateValue() {
/* 3593 */     return getMp() * 1.0D / getMaxMp() * FightArgs.getInstance().defaultRate;
/*      */   }
/*      */   
/*      */   public final int getAnger() {
/* 3597 */     return (int)this.xFighter.getAnger();
/*      */   }
/*      */   
/*      */   public final void setAnger(double paramDouble) {
/* 3601 */     int i = getMaxAnger();
/* 3602 */     if (paramDouble >= i) {
/* 3603 */       paramDouble = i;
/*      */     }
/* 3605 */     this.xFighter.setAnger((float)paramDouble);
/*      */   }
/*      */   
/*      */   public final int getMaxAnger() {
/* 3609 */     int i = getFighterBaseAttr(5);
/* 3610 */     int j = getFighterBaseAttr(32);
/* 3611 */     int k = getAttrsChange(5);
/* 3612 */     int m = getAttrsChange(32);
/* 3613 */     int n = j + m;
/* 3614 */     int i1 = (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/* 3615 */     return Math.min(i1, SFightConsts.getInstance().ANGER_MAX);
/*      */   }
/*      */   
/*      */   public final int getCurAngerRateValue() {
/* 3619 */     int i = getMaxAnger();
/* 3620 */     if (i == 0) {
/* 3621 */       return FightArgs.getInstance().defaultRate;
/*      */     }
/* 3623 */     return (int)(getAnger() * 1.0D / i * FightArgs.getInstance().defaultRate);
/*      */   }
/*      */   
/*      */   public final int getEnergy() {
/* 3627 */     int i = getFighterBaseAttr(89);
/* 3628 */     int j = getAttrsChange(89);
/* 3629 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addEnergy(int paramInt) {
/* 3633 */     int i = getEnergy();
/* 3634 */     int j = i + paramInt;
/* 3635 */     if (j > SFightConsts.getInstance().ENERGY_MAX) {
/* 3636 */       j = SFightConsts.getInstance().ENERGY_MAX;
/*      */     }
/* 3638 */     if (j < 0) {
/* 3639 */       j = 0;
/*      */     }
/* 3641 */     int k = j - i;
/* 3642 */     k += getAttrsChange(89);
/* 3643 */     setAttrsChange(89, k);
/*      */   }
/*      */   
/*      */   void clearEnergy() {
/* 3647 */     addEnergy(-getEnergy());
/*      */   }
/*      */   
/*      */   public final int getPHYATK(int paramInt1, int paramInt2) {
/* 3651 */     int i = getFighterBaseAttr(7);
/* 3652 */     int j = getFighterBaseAttr(33);
/* 3653 */     int k = getAttrsChange(7) + paramInt1;
/* 3654 */     int m = getAttrsChange(33) + paramInt2;
/* 3655 */     int n = j + m;
/* 3656 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final int getPHYATK() {
/* 3660 */     int i = getFighterBaseAttr(7);
/* 3661 */     int j = getFighterBaseAttr(33);
/* 3662 */     int k = getAttrsChange(7);
/* 3663 */     int m = getAttrsChange(33);
/* 3664 */     int n = j + m;
/* 3665 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addPHYATK(int paramInt) {
/* 3669 */     int i = getAttrsChange(7);
/* 3670 */     i += paramInt;
/* 3671 */     setAttrsChange(7, i);
/*      */   }
/*      */   
/*      */   public final void addPHYATKRate(int paramInt) {
/* 3675 */     int i = getAttrsChange(33);
/* 3676 */     i += paramInt;
/* 3677 */     setAttrsChange(33, i);
/*      */   }
/*      */   
/*      */   public final void addPHYDAMAGERate(int paramInt) {
/* 3681 */     int i = getAttrsChange(57);
/* 3682 */     i += paramInt;
/* 3683 */     setAttrsChange(57, i);
/*      */   }
/*      */   
/*      */   public final int getPHYDAMAGERate() {
/* 3687 */     int i = getFighterBaseAttr(57);
/* 3688 */     int j = getAttrsChange(57);
/* 3689 */     int k = i + j + getFighterBaseAttr(55) + getAttrsChange(55);
/* 3690 */     return k;
/*      */   }
/*      */   
/*      */   public final void addPhyFightBackDamageRate(int paramInt) {
/* 3694 */     int i = getAttrsChange(82);
/* 3695 */     i += paramInt;
/* 3696 */     setAttrsChange(82, i);
/*      */   }
/*      */   
/*      */   public final int getPHyFightBackDamageRate() {
/* 3700 */     return getAttrsChange(82) + getFighterBaseAttr(82);
/*      */   }
/*      */   
/*      */   public final void addBEPHYDAMAGERate(int paramInt) {
/* 3704 */     int i = getAttrsChange(59);
/* 3705 */     i += paramInt;
/* 3706 */     setAttrsChange(59, i);
/*      */   }
/*      */   
/*      */   public final int getBEPHYDAMAGERate() {
/* 3710 */     int i = getFighterBaseAttr(59);
/* 3711 */     int j = getAttrsChange(59);
/* 3712 */     int k = i + j + getFighterBaseAttr(56) + getAttrsChange(56);
/* 3713 */     return k;
/*      */   }
/*      */   
/*      */   public final void setPHYDAMAGEWAVELow(int paramInt) {
/* 3717 */     setAttrsChange(76, paramInt);
/*      */   }
/*      */   
/*      */   public final void remPHYDAMAGEWAVELow() {
/* 3721 */     getExa_AttrsMap().remove(Integer.valueOf(76));
/*      */   }
/*      */   
/*      */   public final int getPHYDAMAGEWAVELow() {
/* 3725 */     if (getExa_AttrsMap().containsKey(Integer.valueOf(76))) {
/* 3726 */       int i = ((Integer)getExa_AttrsMap().get(Integer.valueOf(76))).intValue();
/* 3727 */       return i;
/*      */     }
/* 3729 */     return 0;
/*      */   }
/*      */   
/*      */   public final void setPHYDAMAGEWAVEHigh(int paramInt) {
/* 3733 */     setAttrsChange(77, paramInt);
/*      */   }
/*      */   
/*      */   public final void remPHYDAMAGEWAVEHigh() {
/* 3737 */     getExa_AttrsMap().remove(Integer.valueOf(77));
/*      */   }
/*      */   
/*      */   public final int getPHYDAMAGEWAVEHigh() {
/* 3741 */     if (getExa_AttrsMap().containsKey(Integer.valueOf(77))) {
/* 3742 */       int i = ((Integer)getExa_AttrsMap().get(Integer.valueOf(77))).intValue();
/* 3743 */       return i;
/*      */     }
/* 3745 */     return 0;
/*      */   }
/*      */   
/*      */   public final double getMAGATK(int paramInt1, int paramInt2) {
/* 3749 */     int i = getFighterBaseAttr(9);
/* 3750 */     int j = getFighterBaseAttr(35);
/* 3751 */     int k = getAttrsChange(9) + paramInt1;
/* 3752 */     int m = getAttrsChange(35) + paramInt2;
/* 3753 */     int n = j + m;
/* 3754 */     return PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final int getMAGATK() {
/* 3758 */     int i = getFighterBaseAttr(9);
/* 3759 */     int j = getFighterBaseAttr(35);
/* 3760 */     int k = getAttrsChange(9);
/* 3761 */     int m = getAttrsChange(35);
/* 3762 */     int n = j + m;
/* 3763 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addMAGATK(int paramInt) {
/* 3767 */     int i = getAttrsChange(9);
/* 3768 */     i += paramInt;
/* 3769 */     setAttrsChange(9, i);
/*      */   }
/*      */   
/*      */   public final void addMAGATKRate(int paramInt) {
/* 3773 */     int i = getAttrsChange(35);
/* 3774 */     i += paramInt;
/* 3775 */     setAttrsChange(35, i);
/*      */   }
/*      */   
/*      */   public final void addMAGDAMAGERate(int paramInt) {
/* 3779 */     int i = getAttrsChange(58);
/* 3780 */     i += paramInt;
/* 3781 */     setAttrsChange(58, i);
/*      */   }
/*      */   
/*      */   public final int getMAGDAMAGERate() {
/* 3785 */     int i = getAttrsChange(58) + getFighterBaseAttr(58) + getFighterBaseAttr(55) + getAttrsChange(55);
/* 3786 */     return i;
/*      */   }
/*      */   
/*      */   public final void addMagFightBackDamageRate(int paramInt) {
/* 3790 */     int i = getAttrsChange(83);
/* 3791 */     i += paramInt;
/* 3792 */     setAttrsChange(83, i);
/*      */   }
/*      */   
/*      */   public final int getMagFightBackDamageRate() {
/* 3796 */     return getAttrsChange(83) + getFighterBaseAttr(83);
/*      */   }
/*      */   
/*      */   public final void addBEMAGDAMAGERate(int paramInt) {
/* 3800 */     int i = getAttrsChange(60);
/* 3801 */     i += paramInt;
/* 3802 */     setAttrsChange(60, i);
/*      */   }
/*      */   
/*      */   public final int getBEMAGDAMAGERate() {
/* 3806 */     int i = getAttrsChange(60) + getFighterBaseAttr(60) + getFighterBaseAttr(56) + getAttrsChange(56);
/* 3807 */     return i;
/*      */   }
/*      */   
/*      */   public final void setMAGDAMAGEWAVELow(int paramInt) {
/* 3811 */     setAttrsChange(78, paramInt);
/*      */   }
/*      */   
/*      */   public final void remMAGDAMAGEWAVELow() {
/* 3815 */     getExa_AttrsMap().remove(Integer.valueOf(78));
/*      */   }
/*      */   
/*      */   public final int getMAGDAMAGEWAVELow() {
/* 3819 */     if (getExa_AttrsMap().containsKey(Integer.valueOf(78))) {
/* 3820 */       int i = ((Integer)getExa_AttrsMap().get(Integer.valueOf(78))).intValue();
/* 3821 */       return i;
/*      */     }
/* 3823 */     return 0;
/*      */   }
/*      */   
/*      */   public final void setMAGDAMAGEWAVEHigh(int paramInt) {
/* 3827 */     setAttrsChange(79, paramInt);
/*      */   }
/*      */   
/*      */   public final void remMAGDAMAGEWAVEHigh() {
/* 3831 */     getExa_AttrsMap().remove(Integer.valueOf(79));
/*      */   }
/*      */   
/*      */   public final int getMAGDAMAGEWAVEHigh() {
/* 3835 */     if (getExa_AttrsMap().containsKey(Integer.valueOf(79))) {
/* 3836 */       int i = ((Integer)getExa_AttrsMap().get(Integer.valueOf(79))).intValue();
/* 3837 */       return i;
/*      */     }
/* 3839 */     return 0;
/*      */   }
/*      */   
/*      */   public final int getPHYDEF() {
/* 3843 */     int i = getFighterBaseAttr(8);
/* 3844 */     int j = getFighterBaseAttr(34);
/* 3845 */     int k = getAttrsChange(8);
/* 3846 */     int m = getAttrsChange(34);
/* 3847 */     int n = j + m;
/* 3848 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addPHYDEF(int paramInt) {
/* 3852 */     int i = getAttrsChange(8);
/* 3853 */     i += paramInt;
/* 3854 */     setAttrsChange(8, i);
/*      */   }
/*      */   
/*      */   public final void addPHYDEFRate(int paramInt) {
/* 3858 */     int i = getAttrsChange(34);
/* 3859 */     i += paramInt;
/* 3860 */     setAttrsChange(34, i);
/*      */   }
/*      */   
/*      */   public final int getMAGDEF() {
/* 3864 */     int i = getFighterBaseAttr(10);
/* 3865 */     int j = getFighterBaseAttr(36);
/* 3866 */     int k = getAttrsChange(10);
/* 3867 */     int m = getAttrsChange(36);
/* 3868 */     int n = j + m;
/* 3869 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final int getMAGDEF(int paramInt1, int paramInt2) {
/* 3873 */     int i = getFighterBaseAttr(10);
/* 3874 */     int j = getFighterBaseAttr(36);
/* 3875 */     paramInt1 += getAttrsChange(10);
/* 3876 */     int k = getAttrsChange(36) + paramInt2;
/* 3877 */     int m = j + k;
/* 3878 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, paramInt1, m);
/*      */   }
/*      */   
/*      */   public final void addMAGDEF(int paramInt) {
/* 3882 */     int i = getAttrsChange(10);
/* 3883 */     i += paramInt;
/* 3884 */     setAttrsChange(10, i);
/*      */   }
/*      */   
/*      */   public final void addMAGDEFRate(int paramInt) {
/* 3888 */     int i = getAttrsChange(36);
/* 3889 */     i += paramInt;
/* 3890 */     setAttrsChange(36, i);
/*      */   }
/*      */   
/*      */   public final int getPHYCRTRate() {
/* 3894 */     int i = getFighterBaseAttr(11);
/* 3895 */     int j = getAttrsChange(11);
/* 3896 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addPHYCRTRate(int paramInt) {
/* 3900 */     int i = getAttrsChange(11);
/* 3901 */     i += paramInt;
/* 3902 */     setAttrsChange(11, i);
/*      */   }
/*      */   
/*      */   public final int getMAGCRTRate() {
/* 3906 */     int i = getFighterBaseAttr(12);
/* 3907 */     int j = getAttrsChange(12);
/* 3908 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addMAGCRTRate(int paramInt) {
/* 3912 */     int i = getAttrsChange(12);
/* 3913 */     i += paramInt;
/* 3914 */     setAttrsChange(12, i);
/*      */   }
/*      */   
/*      */   public final int getPHYCRTVALUE() {
/* 3918 */     int i = getFighterBaseAttr(14);
/* 3919 */     int j = getAttrsChange(14);
/* 3920 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addPHYCRTVALUE(int paramInt) {
/* 3924 */     int i = getAttrsChange(14);
/* 3925 */     i += paramInt;
/* 3926 */     setAttrsChange(14, i);
/*      */   }
/*      */   
/*      */   public final int getPHYCRTLevel() {
/* 3930 */     int i = getFighterBaseAttr(85);
/* 3931 */     int j = getAttrsChange(85);
/* 3932 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addPHYCRTLevel(int paramInt) {
/* 3936 */     int i = getAttrsChange(85);
/* 3937 */     i += paramInt;
/* 3938 */     setAttrsChange(85, i);
/*      */   }
/*      */   
/*      */   public final int getPHYCRTDEFLevel() {
/* 3942 */     int i = getFighterBaseAttr(87);
/* 3943 */     int j = getAttrsChange(87);
/* 3944 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addPHYCRTDEFLevel(int paramInt) {
/* 3948 */     int i = getAttrsChange(87);
/* 3949 */     i += paramInt;
/* 3950 */     setAttrsChange(87, i);
/*      */   }
/*      */   
/*      */   public final int getMAGCRTVALUE() {
/* 3954 */     int i = getFighterBaseAttr(15);
/* 3955 */     int j = getAttrsChange(15);
/* 3956 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addMAGCRTVALUE(int paramInt) {
/* 3960 */     int i = getAttrsChange(15);
/* 3961 */     i += paramInt;
/* 3962 */     setAttrsChange(15, i);
/*      */   }
/*      */   
/*      */   public final int getMAGCRTLevel() {
/* 3966 */     int i = getFighterBaseAttr(86);
/* 3967 */     int j = getAttrsChange(86);
/* 3968 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addMAGCRTLevel(int paramInt) {
/* 3972 */     int i = getAttrsChange(86);
/* 3973 */     i += paramInt;
/* 3974 */     setAttrsChange(86, i);
/*      */   }
/*      */   
/*      */   public final int getMAGCRTDEFLevel() {
/* 3978 */     int i = getFighterBaseAttr(88);
/* 3979 */     int j = getAttrsChange(88);
/* 3980 */     return i + j;
/*      */   }
/*      */   
/*      */   public final void addMAGCRTDEFLevel(int paramInt) {
/* 3984 */     int i = getAttrsChange(88);
/* 3985 */     i += paramInt;
/* 3986 */     setAttrsChange(88, i);
/*      */   }
/*      */   
/*      */   public final int getSealHit() {
/* 3990 */     int i = getFighterBaseAttr(16);
/* 3991 */     int j = getFighterBaseAttr(39);
/* 3992 */     int k = getAttrsChange(16);
/* 3993 */     int m = getAttrsChange(39);
/* 3994 */     int n = j + m;
/* 3995 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addSealHit(int paramInt) {
/* 3999 */     int i = getAttrsChange(16);
/* 4000 */     i += paramInt;
/* 4001 */     setAttrsChange(16, i);
/*      */   }
/*      */   
/*      */   public final void addSealHitRate(int paramInt) {
/* 4005 */     int i = getAttrsChange(65);
/* 4006 */     i += paramInt;
/* 4007 */     setAttrsChange(65, i);
/*      */   }
/*      */   
/*      */   public final int getSealHitRate() {
/* 4011 */     int i = getFighterBaseAttr(65);
/* 4012 */     int j = getAttrsChange(65);
/* 4013 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getSealResist() {
/* 4017 */     int i = getFighterBaseAttr(17);
/* 4018 */     int j = getFighterBaseAttr(40);
/* 4019 */     int k = getAttrsChange(17);
/* 4020 */     int m = getAttrsChange(40);
/* 4021 */     int n = j + m;
/* 4022 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addSealResist(int paramInt) {
/* 4026 */     int i = getAttrsChange(17);
/* 4027 */     i += paramInt;
/* 4028 */     setAttrsChange(17, i);
/*      */   }
/*      */   
/*      */   public final void addBeSealHitRate(int paramInt) {
/* 4032 */     int i = getAttrsChange(67);
/* 4033 */     i += paramInt;
/* 4034 */     setAttrsChange(67, i);
/*      */   }
/*      */   
/*      */   public final int getBeSealHitRate() {
/* 4038 */     int i = getFighterBaseAttr(67);
/* 4039 */     int j = getAttrsChange(67);
/* 4040 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getPHYHITLevel() {
/* 4044 */     int i = getFighterBaseAttr(18);
/* 4045 */     int j = getFighterBaseAttr(41);
/* 4046 */     int k = getAttrsChange(18);
/* 4047 */     int m = getAttrsChange(41);
/* 4048 */     int n = j + m;
/* 4049 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addPHYHITLevel(int paramInt) {
/* 4053 */     int i = getAttrsChange(18);
/* 4054 */     i += paramInt;
/* 4055 */     setAttrsChange(18, i);
/*      */   }
/*      */   
/*      */   public final void addPHYATKHITRate(int paramInt) {
/* 4059 */     int i = getAttrsChange(68);
/* 4060 */     i += paramInt;
/* 4061 */     setAttrsChange(68, i);
/*      */   }
/*      */   
/*      */   public final int getPHYATKHITRate() {
/* 4065 */     int i = getFighterBaseAttr(68);
/* 4066 */     int j = getAttrsChange(68);
/* 4067 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getPHYDODGELevel() {
/* 4071 */     if (isSleep()) {
/* 4072 */       return 0;
/*      */     }
/* 4074 */     int i = getFighterBaseAttr(19);
/* 4075 */     int j = getFighterBaseAttr(42);
/* 4076 */     int k = getAttrsChange(19);
/* 4077 */     int m = getAttrsChange(42);
/* 4078 */     int n = j + m;
/* 4079 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addPHYDODGElevel(int paramInt) {
/* 4083 */     int i = getAttrsChange(19);
/* 4084 */     i += paramInt;
/* 4085 */     setAttrsChange(19, i);
/*      */   }
/*      */   
/*      */   public final void addBEPHYATKHITRate(int paramInt) {
/* 4089 */     int i = getAttrsChange(69);
/* 4090 */     i += paramInt;
/* 4091 */     setAttrsChange(69, i);
/*      */   }
/*      */   
/*      */   public final int getBEPHYATKHITRate() {
/* 4095 */     int i = getFighterBaseAttr(69);
/* 4096 */     int j = getAttrsChange(69);
/* 4097 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getMAGHITLevel() {
/* 4101 */     int i = getFighterBaseAttr(20);
/* 4102 */     int j = getFighterBaseAttr(43);
/* 4103 */     int k = getAttrsChange(20);
/* 4104 */     int m = getAttrsChange(43);
/* 4105 */     int n = j + m;
/* 4106 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addMAGHITlevel(int paramInt) {
/* 4110 */     int i = getAttrsChange(20);
/* 4111 */     i += paramInt;
/* 4112 */     setAttrsChange(20, i);
/*      */   }
/*      */   
/*      */   public final void addMAGHITRate(int paramInt) {
/* 4116 */     int i = getAttrsChange(70);
/* 4117 */     i += paramInt;
/* 4118 */     setAttrsChange(68, i);
/*      */   }
/*      */   
/*      */   public final int getMAGHITRate() {
/* 4122 */     int i = getFighterBaseAttr(70);
/* 4123 */     int j = getAttrsChange(70);
/* 4124 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getMAGDODGELevel() {
/* 4128 */     if (isSleep()) {
/* 4129 */       return 0;
/*      */     }
/* 4131 */     int i = getFighterBaseAttr(21);
/* 4132 */     int j = getFighterBaseAttr(44);
/* 4133 */     int k = getAttrsChange(21);
/* 4134 */     int m = getAttrsChange(44);
/* 4135 */     int n = j + m;
/* 4136 */     return (int)PropertyFormula.roleFormulaFinalProperty(i, k, n);
/*      */   }
/*      */   
/*      */   public final void addMAGDODGELevel(int paramInt) {
/* 4140 */     int i = getAttrsChange(21);
/* 4141 */     i += paramInt;
/* 4142 */     setAttrsChange(21, i);
/*      */   }
/*      */   
/*      */   public final void addBEMAGHITRate(int paramInt) {
/* 4146 */     int i = getAttrsChange(71);
/* 4147 */     i += paramInt;
/* 4148 */     setAttrsChange(71, i);
/*      */   }
/*      */   
/*      */   public final int getBEMAGHITRate() {
/* 4152 */     int i = getFighterBaseAttr(71);
/* 4153 */     int j = getAttrsChange(71);
/* 4154 */     return i + j;
/*      */   }
/*      */   
/*      */   public final int getSpeed() {
/* 4158 */     int i = getFighterBaseAttr(24);
/* 4159 */     int j = getFighterBaseAttr(47);
/* 4160 */     int k = getAttrsChange(24);
/* 4161 */     int m = getAttrsChange(47);
/* 4162 */     int n = j + m;
/* 4163 */     double d = 1.0D - getExtra(FighterExtra.Speed_Fluctuate_Rate) * 1.0D / FightArgs.getInstance().defaultRate;
/* 4164 */     int i1 = (int)(PropertyFormula.roleFormulaFinalProperty(i, k, n) * d);
/* 4165 */     if (GameServer.logger().isDebugEnabled()) {
/*      */       try {
/* 4167 */         if (isRoleType()) {
/* 4168 */           GameServer.logger().debug(String.format("[FightSpeedLogDump]getSpeed|base=%d|extraAdd=%d|totalRate=%d|speed_fluctuate_rate=%f|name=%s|round=%d|fightUuid=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), Double.valueOf(d), getName(), Integer.valueOf(getRound()), Long.valueOf(getFightUuid()) }));
/*      */         }
/*      */       }
/*      */       catch (Exception localException) {}
/*      */     }
/* 4173 */     return i1;
/*      */   }
/*      */   
/*      */   public final void addSpeed(int paramInt) {
/* 4177 */     int i = getAttrsChange(24);
/* 4178 */     i += paramInt;
/* 4179 */     setAttrsChange(24, i);
/*      */   }
/*      */   
/*      */   public final void addSpeedRate(int paramInt) {
/* 4183 */     int i = getAttrsChange(47);
/* 4184 */     i += paramInt;
/* 4185 */     setAttrsChange(47, i);
/*      */   }
/*      */   
/*      */   public final int getPHYFIGHTBACK() {
/* 4189 */     if (isSleep()) {
/* 4190 */       return 0;
/*      */     }
/* 4192 */     int i = getFighterBaseAttr(22);
/* 4193 */     int j = getAttrsChange(22);
/* 4194 */     return Math.max(i, j);
/*      */   }
/*      */   
/*      */   public final void addPHYFIGHTBACK(int paramInt) {
/* 4198 */     int i = getAttrsChange(22);
/* 4199 */     i += paramInt;
/* 4200 */     setAttrsChange(22, i);
/*      */   }
/*      */   
/*      */   public final int getMAGFIGHTBACK() {
/* 4204 */     if (isSleep()) {
/* 4205 */       return 0;
/*      */     }
/* 4207 */     int i = getFighterBaseAttr(23);
/* 4208 */     int j = getAttrsChange(23);
/* 4209 */     return Math.max(i, j);
/*      */   }
/*      */   
/*      */   public final void addMAGFIGHTBACK(int paramInt) {
/* 4213 */     int i = getAttrsChange(23);
/* 4214 */     i += paramInt;
/* 4215 */     setAttrsChange(23, i);
/*      */   }
/*      */   
/*      */   public final void addEscapeRate(int paramInt) {
/* 4219 */     int i = getAttrsChange(74);
/* 4220 */     i += paramInt;
/* 4221 */     setAttrsChange(74, i);
/*      */   }
/*      */   
/*      */   public int getEscapeRate() {
/* 4225 */     int i = getFight().getCfgType();
/* 4226 */     if (i == 25) {
/* 4227 */       return SFightConsts.getInstance().PK_ESCAPE_RATE;
/*      */     }
/* 4229 */     if (i != 26) {
/* 4230 */       int j = getAttrsChange(74) + getFighterBaseAttr(74);
/* 4231 */       int k = this.fightGroup.fightTeam.fight.getType();
/* 4232 */       switch (k) {
/*      */       case 3: 
/* 4234 */         j += SFightConsts.getInstance().PVE_ESCAPE_RATE;
/* 4235 */         break;
/*      */       
/*      */       case 0: 
/* 4238 */         j += SFightConsts.getInstance().PVE_ESCAPE_RATE;
/* 4239 */         break;
/*      */       
/*      */       case 1: 
/* 4242 */         j += SFightConsts.getInstance().PVP_ESCAPE_RATE;
/* 4243 */         break;
/*      */       
/*      */       case 2: 
/* 4246 */         j += SFightConsts.getInstance().PVC_ESCAPE_RATE;
/*      */       }
/*      */       
/*      */       
/* 4250 */       return j;
/*      */     }
/* 4252 */     if (isRedName()) {
/* 4253 */       return SFightConsts.getInstance().ARREST_WANTED_RED_ESCAPE_RATE;
/*      */     }
/* 4255 */     return SFightConsts.getInstance().ARREST_WANTED_ESCAPE_RATE;
/*      */   }
/*      */   
/*      */   public final void addCatchPetRate(int paramInt) {
/* 4259 */     int i = getAttrsChange(75);
/* 4260 */     i += paramInt;
/* 4261 */     setAttrsChange(75, i);
/*      */   }
/*      */   
/*      */   public final int getCatchPetRate(mzm.gsp.monster.main.Monster paramMonster) {
/* 4265 */     int i = getFighterBaseAttr(75) + getAttrsChange(75) + paramMonster.getCatchProp();
/* 4266 */     return Math.min(i, SFightConsts.getInstance().CAPTURE_RATE_MAX);
/*      */   }
/*      */   
/*      */   public final void addBeCapaturedRate(int paramInt) {
/* 4270 */     int i = getAttrsChange(90);
/* 4271 */     i += paramInt;
/* 4272 */     setAttrsChange(90, i);
/*      */   }
/*      */   
/*      */   public final int getBeCapatureRate() {
/* 4276 */     return getFighterBaseAttr(90) + getAttrsChange(90);
/*      */   }
/*      */   
/*      */   public final void addAnger(double paramDouble) {
/* 4280 */     double d = getAnger() + paramDouble;
/* 4281 */     d = Math.max(0.0D, d);
/* 4282 */     setAnger(d);
/*      */   }
/*      */   
/*      */   public final void clearAnger() {
/* 4286 */     setAnger(0.0D);
/*      */   }
/*      */   
/*      */   public int addHp(Fighter paramFighter, int paramInt) {
/* 4290 */     int i = addHp(paramInt);
/* 4291 */     if (isDead()) {
/* 4292 */       if (paramFighter != null) {
/* 4293 */         if ((!paramFighter.isBeatGhost()) && (isGhost())) {
/* 4294 */           setFakeDead();
/*      */         }
/*      */       }
/* 4297 */       else if (isGhost()) {
/* 4298 */         setFakeDead();
/*      */       }
/*      */     }
/* 4301 */     return i;
/*      */   }
/*      */   
/*      */   public int addHp(int paramInt) {
/* 4305 */     return addHp(paramInt, true);
/*      */   }
/*      */   
/*      */   private int addHp(int paramInt, boolean paramBoolean) {
/* 4309 */     if (paramInt == 0) {
/* 4310 */       return 0;
/*      */     }
/* 4312 */     int i = getHp();
/* 4313 */     if (i < 0) {
/* 4314 */       return 0;
/*      */     }
/* 4316 */     if ((i == 0) && (paramInt < 0)) {
/* 4317 */       return 0;
/*      */     }
/* 4319 */     int j = i + paramInt;
/* 4320 */     if ((j > getMaxHp()) && (paramInt > 0)) {
/* 4321 */       j = (int)getMaxHp();
/*      */     }
/* 4323 */     if (j < 0) {
/* 4324 */       if (paramInt > 0) {
/* 4325 */         j = (int)getMaxHp();
/*      */       }
/*      */       else {
/* 4328 */         j = 0;
/*      */       }
/*      */     }
/* 4331 */     int k = j - i;
/* 4332 */     setHp(j);
/* 4333 */     if ((paramInt < 0) && (j == 0)) {
/* 4334 */       onDead();
/*      */     }
/* 4336 */     if ((k < 0) && (isAlive())) {
/* 4337 */       if (paramBoolean) {
/* 4338 */         double d = FightFormulaHelp.getAnger(-k, getMaxHp());
/* 4339 */         mzm.gsp.fight.handle.AddAngerHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.AddAngerHandle.OutputObj();
/* 4340 */         localOutputObj.finalAddAnger = d;
/* 4341 */         handleOnAddAnger(localOutputObj);
/* 4342 */         addAnger(localOutputObj.finalAddAnger);
/*      */       }
/* 4344 */       mzm.gsp.fight.handle.LoseHpHandle.InputObj localInputObj = new mzm.gsp.fight.handle.LoseHpHandle.InputObj(this, -k);
/* 4345 */       handleOnLostHp(localInputObj);
/*      */     }
/* 4347 */     return k;
/*      */   }
/*      */   
/*      */   public final int addMp(int paramInt) {
/* 4351 */     if (paramInt == 0) {
/* 4352 */       return 0;
/*      */     }
/* 4354 */     int i = getMp();
/* 4355 */     if (i < 0) {
/* 4356 */       return 0;
/*      */     }
/* 4358 */     if ((i == 0) && (paramInt < 0)) {
/* 4359 */       return 0;
/*      */     }
/* 4361 */     int j = i + paramInt;
/* 4362 */     if ((j > getMaxMp()) && (paramInt > 0)) {
/* 4363 */       j = (int)getMaxMp();
/*      */     }
/* 4365 */     if (j < 0) {
/* 4366 */       if (paramInt > 0) {
/* 4367 */         j = (int)getMaxMp();
/*      */       }
/*      */       else {
/* 4370 */         j = 0;
/*      */       }
/*      */     }
/* 4373 */     int k = j - i;
/* 4374 */     setMp(j);
/* 4375 */     return k;
/*      */   }
/*      */   
/*      */   public final BeDamageHandle.OutputObj handleBeDamage(BeDamageHandle.InputObj paramInputObj) {
/* 4379 */     BeDamageHandle.OutputObj localOutputObj = new BeDamageHandle.OutputObj();
/* 4380 */     localOutputObj.nowDamage = paramInputObj.getDamage();
/* 4381 */     if (paramInputObj.getDamage() <= 0) {
/* 4382 */       return localOutputObj;
/*      */     }
/* 4384 */     List localList = getAllEffectBuff();
/* 4385 */     int i = -1;
/* 4386 */     for (Object localObject1 = localList.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (FighterBuff)((Iterator)localObject1).next();
/* 4387 */       for (localObject3 = ((FighterBuff)localObject2).getEffects().iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (FighterEffect)((Iterator)localObject3).next();
/* 4388 */         if ((localObject4 instanceof mzm.gsp.effect.fighter.Sleep)) {
/* 4389 */           i = ((FighterBuff)localObject2).getEffectGroupStatus();
/* 4390 */           setBuffUnEffect((FighterBuff)localObject2);
/* 4391 */           break;
/*      */         }
/*      */       }
/*      */     }
/* 4395 */     if ((i != -1) && (this.xFighter.getBuffs().containsKey(Integer.valueOf(i)))) {
/* 4396 */       localObject1 = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(i));
/* 4397 */       for (localObject2 = ((FighterBuffs)localObject1).getBuffs().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (FighterBuff)((Iterator)localObject2).next();
/* 4398 */         if (((FighterBuff)localObject3).isEffect()) {
/* 4399 */           setBuffUnEffect((FighterBuff)localObject3);
/*      */         }
/*      */       }
/* 4402 */       this.xFighter.getBuffs().remove(Integer.valueOf(i));
/*      */     }
/* 4404 */     localObject1 = new ArrayList();
/* 4405 */     Object localObject2 = new ArrayList();
/* 4406 */     Object localObject3 = new ArrayList();
/* 4407 */     Object localObject4 = new ArrayList();
/* 4408 */     ArrayList localArrayList = new ArrayList();
/* 4409 */     Set localSet = copySetValue(this.xFighter.getHandleonbedamage());
/* 4410 */     for (Iterator localIterator = localSet.iterator(); localIterator.hasNext();) { localObject5 = (BeDamageHandle)localIterator.next();
/* 4411 */       if ((localObject5 instanceof mzm.gsp.fight.handle.Damage2Heal)) {
/* 4412 */         ((List)localObject1).add((mzm.gsp.fight.handle.Damage2Heal)localObject5);
/*      */       }
/* 4414 */       else if ((localObject5 instanceof mzm.gsp.fight.handle.AbsorbDamage)) {
/* 4415 */         ((List)localObject2).add((mzm.gsp.fight.handle.AbsorbDamage)localObject5);
/*      */       }
/* 4417 */       else if ((localObject5 instanceof mzm.gsp.fight.handle.Damagereduction)) {
/* 4418 */         ((List)localObject3).add((mzm.gsp.fight.handle.Damagereduction)localObject5);
/*      */       }
/* 4420 */       else if ((localObject5 instanceof mzm.gsp.fight.handle.MainSoulDamageHandle)) {
/* 4421 */         localArrayList.add((mzm.gsp.fight.handle.MainSoulDamageHandle)localObject5);
/*      */       }
/*      */       else
/* 4424 */         ((List)localObject4).add(localObject5);
/*      */     }
/*      */     Object localObject5;
/* 4427 */     for (localIterator = ((List)localObject4).iterator(); localIterator.hasNext();) { localObject5 = (BeDamageHandle)localIterator.next();
/* 4428 */       ((BeDamageHandle)localObject5).onBeDamage(paramInputObj, localOutputObj);
/*      */     }
/* 4430 */     if (localOutputObj.nowDamage <= 0) {
/* 4431 */       return localOutputObj;
/*      */     }
/* 4433 */     for (localIterator = ((List)localObject1).iterator(); localIterator.hasNext();) { localObject5 = (mzm.gsp.fight.handle.Damage2Heal)localIterator.next();
/* 4434 */       ((BeDamageHandle)localObject5).onBeDamage(paramInputObj, localOutputObj);
/* 4435 */       if (localOutputObj.nowDamage <= 0) {
/* 4436 */         return localOutputObj;
/*      */       }
/*      */     }
/* 4439 */     for (localIterator = ((List)localObject3).iterator(); localIterator.hasNext();) { localObject5 = (mzm.gsp.fight.handle.Damagereduction)localIterator.next();
/* 4440 */       if ((!(localObject5 instanceof mzm.gsp.effect.fighter.ProbabilityDamagereduction)) || (!isForgetSkill()))
/*      */       {
/*      */ 
/*      */ 
/* 4444 */         ((mzm.gsp.fight.handle.Damagereduction)localObject5).onBeDamage(paramInputObj, localOutputObj);
/* 4445 */         if (localOutputObj.nowDamage <= 0)
/* 4446 */           return localOutputObj;
/*      */       }
/*      */     }
/* 4449 */     for (localIterator = ((List)localObject2).iterator(); localIterator.hasNext();) { localObject5 = (mzm.gsp.fight.handle.AbsorbDamage)localIterator.next();
/* 4450 */       ((BeDamageHandle)localObject5).onBeDamage(paramInputObj, localOutputObj);
/* 4451 */       if (localOutputObj.nowDamage <= 0) {
/* 4452 */         return localOutputObj;
/*      */       }
/*      */     }
/* 4455 */     for (localIterator = localArrayList.iterator(); localIterator.hasNext();) { localObject5 = (mzm.gsp.fight.handle.MainSoulDamageHandle)localIterator.next();
/* 4456 */       ((BeDamageHandle)localObject5).onBeDamage(paramInputObj, localOutputObj);
/* 4457 */       if (localOutputObj.nowDamage <= 0) {
/* 4458 */         return localOutputObj;
/*      */       }
/*      */     }
/* 4461 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.DamageHandle.OutputObj handleOnDamage(mzm.gsp.fight.handle.DamageHandle.InputObj paramInputObj) {
/* 4465 */     Set localSet = copySetValue(this.xFighter.getHandleondamage());
/* 4466 */     mzm.gsp.fight.handle.DamageHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.DamageHandle.OutputObj();
/* 4467 */     localOutputObj.damage = paramInputObj.getDamage();
/* 4468 */     for (mzm.gsp.fight.handle.DamageHandle localDamageHandle : localSet) {
/* 4469 */       localDamageHandle.onDamage(paramInputObj, localOutputObj);
/*      */     }
/* 4471 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.ReboundHandle.OutPutObj handleOnRebound(int paramInt1, int paramInt2) {
/* 4475 */     Set localSet = copySetValue(this.xFighter.getHandleonrebound());
/* 4476 */     mzm.gsp.fight.handle.ReboundHandle.OutPutObj localOutPutObj = new mzm.gsp.fight.handle.ReboundHandle.OutPutObj();
/* 4477 */     for (mzm.gsp.fight.handle.ReboundHandle localReboundHandle : localSet) {
/* 4478 */       localReboundHandle.onRebound(this, paramInt1, paramInt2, localOutPutObj);
/*      */     }
/* 4480 */     return localOutPutObj;
/*      */   }
/*      */   
/*      */   public mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj handleOnBeforeUseSkill(Skill paramSkill) {
/* 4484 */     Set localSet = copySetValue(this.xFighter.getHandleonbeforeuseskill());
/* 4485 */     mzm.gsp.fight.handle.BeforeUseSkilHandle.InputObj localInputObj = new mzm.gsp.fight.handle.BeforeUseSkilHandle.InputObj(this, paramSkill);
/* 4486 */     mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj();
/* 4487 */     for (mzm.gsp.fight.handle.BeforeUseSkilHandle localBeforeUseSkilHandle : localSet) {
/* 4488 */       localBeforeUseSkilHandle.beforeUseSkill(localInputObj, localOutputObj);
/*      */     }
/* 4490 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj handleOnAftUseSkill(Skill paramSkill, int paramInt) {
/* 4494 */     mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj();
/* 4495 */     mzm.gsp.fight.handle.AftUseSkilHandle.InputObj localInputObj = new mzm.gsp.fight.handle.AftUseSkilHandle.InputObj(this, paramSkill, paramInt);
/* 4496 */     Set localSet = copySetValue(this.xFighter.getHandleonaftuseskill());
/* 4497 */     for (mzm.gsp.fight.handle.AftUseSkilHandle localAftUseSkilHandle : localSet) {
/* 4498 */       localAftUseSkilHandle.aftUseSkill(localInputObj, localOutputObj);
/*      */     }
/* 4500 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final void handleEnterFight() {
/* 4504 */     Set localSet = copySetValue(this.xFighter.getHandleonenterfight());
/* 4505 */     for (mzm.gsp.fight.handle.EnterFightHandle localEnterFightHandle : localSet) {
/* 4506 */       localEnterFightHandle.onEnterFight(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public mzm.gsp.fight.handle.AfterSummonHandle.OutputObj handleOnAftSummon(Fighter paramFighter, ExcuteCmdResult paramExcuteCmdResult) {
/* 4511 */     Set localSet = copySetValue(this.xFighter.getHandleonaftsummonhandle());
/* 4512 */     mzm.gsp.fight.handle.AfterSummonHandle.InputObj localInputObj = new mzm.gsp.fight.handle.AfterSummonHandle.InputObj(paramFighter, this, paramExcuteCmdResult);
/* 4513 */     mzm.gsp.fight.handle.AfterSummonHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.AfterSummonHandle.OutputObj();
/* 4514 */     for (mzm.gsp.fight.handle.AfterSummonHandle localAfterSummonHandle : localSet) {
/* 4515 */       localAfterSummonHandle.aftUseSummon(localInputObj, localOutputObj);
/*      */     }
/* 4517 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final void handleOtherDie(Fighter paramFighter) {
/* 4521 */     if (paramFighter == null) {
/* 4522 */       return;
/*      */     }
/* 4524 */     Set localSet = copySetValue(this.xFighter.getHandleonfighterdead());
/* 4525 */     for (mzm.gsp.fight.handle.FighterDeadHandle localFighterDeadHandle : localSet) {
/* 4526 */       localFighterDeadHandle.onFighterDead(this, paramFighter);
/*      */     }
/*      */   }
/*      */   
/*      */   public final ProtectResult handleProtect(int paramInt) {
/* 4531 */     ProtectResult localProtectResult = new ProtectResult(paramInt);
/* 4532 */     Iterator localIterator1 = this.xFighter.getProtecterids().iterator();
/* 4533 */     Fighter localFighter; while (localIterator1.hasNext()) {
/* 4534 */       int i = ((Integer)localIterator1.next()).intValue();
/* 4535 */       localFighter = getFighter(i);
/* 4536 */       if ((localFighter != null) && (localFighter.canProtectOther())) {
/* 4537 */         localIterator1.remove();
/* 4538 */         int j = (int)Math.ceil(paramInt * (SFightConsts.getInstance().DAMAGE_RATE_PROTECT * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 4539 */         localProtectResult.setProtectDamage(j);
/* 4540 */         localProtectResult.setFinalDamage(paramInt - j);
/* 4541 */         localProtectResult.setProtectid(i);
/* 4542 */         break;
/*      */       } }
/*      */     Iterator localIterator2;
/* 4545 */     if (!localProtectResult.isBeProtecetd())
/* 4546 */       for (localIterator2 = getFriendLiveFighters().iterator(); localIterator2.hasNext();) { localFighter = (Fighter)localIterator2.next();
/* 4547 */         if ((localFighter.getid() != this.fighterid) && 
/*      */         
/*      */ 
/* 4550 */           (localFighter.canProtectOther()))
/*      */         {
/*      */ 
/* 4553 */           boolean bool = localFighter.handleProtect(this);
/* 4554 */           if (bool) {
/* 4555 */             int k = (int)Math.ceil(paramInt * (SFightConsts.getInstance().DAMAGE_RATE_PROTECT * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 4556 */             localProtectResult.setProtectDamage(k);
/* 4557 */             localProtectResult.setFinalDamage(paramInt - k);
/* 4558 */             localProtectResult.setProtectid(localFighter.getid());
/* 4559 */             break;
/*      */           }
/*      */         }
/*      */       }
/* 4563 */     return localProtectResult;
/*      */   }
/*      */   
/*      */   protected boolean canProtectOther() {
/* 4567 */     return (isAlive()) && (isOperable()) && (!isSleep()) && (!isSealProtect()) && (!isStone()) && (!isRest());
/*      */   }
/*      */   
/*      */   public final int handleHeal(int paramInt) {
/* 4571 */     paramInt = addHp(paramInt);
/* 4572 */     return paramInt;
/*      */   }
/*      */   
/*      */   public final boolean reliveWithHp(int paramInt) {
/* 4576 */     if (isForbidRebirth()) {
/* 4577 */       Set localSet = copySetValue(this.xFighter.getHandleonrebirth());
/* 4578 */       for (mzm.gsp.fight.handle.RebirthHandle localRebirthHandle : localSet) {
/* 4579 */         localRebirthHandle.handleRebirth(this);
/*      */       }
/* 4581 */       return false;
/*      */     }
/* 4583 */     if (paramInt <= 0) {
/* 4584 */       GameServer.logger().error("复活传递的hp小于0:" + paramInt);
/* 4585 */       paramInt = 1;
/*      */     }
/* 4587 */     setAlive();
/* 4588 */     addActionCount();
/* 4589 */     onRelive();
/* 4590 */     setHp(paramInt);
/* 4591 */     return true;
/*      */   }
/*      */   
/*      */   public final void removeBuff(FighterBuff paramFighterBuff) {
/* 4595 */     int i = paramFighterBuff.getEffectGroupStatus();
/* 4596 */     if (this.xFighter.getBuffs().containsKey(Integer.valueOf(i))) {
/* 4597 */       FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(i));
/* 4598 */       localFighterBuffs.getBuffs().remove(paramFighterBuff);
/*      */     }
/* 4600 */     if (paramFighterBuff.isEffect()) {
/* 4601 */       setBuffUnEffect(paramFighterBuff);
/* 4602 */       findAndEffectStatusBuff(i);
/*      */     }
/*      */   }
/*      */   
/*      */   protected final boolean removeBuff(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 4607 */     boolean bool = false;
/* 4608 */     if (this.xFighter.getBuffs().containsKey(Integer.valueOf(paramInt1))) {
/* 4609 */       FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(paramInt1));
/* 4610 */       List localList = localFighterBuffs.getBuffs();
/* 4611 */       for (int i = localList.size() - 1; i >= 0; i--) {
/* 4612 */         FighterBuff localFighterBuff = (FighterBuff)localList.get(i);
/* 4613 */         if (localFighterBuff.getBuffCfgId() == paramInt2) {
/* 4614 */           if (localFighterBuff.isEffect()) {
/* 4615 */             setBuffUnEffect(localFighterBuff);
/*      */           }
/* 4617 */           localList.remove(i);
/* 4618 */           bool = true;
/* 4619 */           if (!paramBoolean) {
/*      */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 4625 */     return bool;
/*      */   }
/*      */   
/*      */   public final boolean removeBuff(int paramInt) {
/* 4629 */     boolean bool = false;
/* 4630 */     if (this.xFighter.getBuffs().containsKey(Integer.valueOf(paramInt))) {
/* 4631 */       FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(paramInt));
/* 4632 */       Iterator localIterator = localFighterBuffs.getBuffs().iterator();
/* 4633 */       while (localIterator.hasNext()) {
/* 4634 */         FighterBuff localFighterBuff = (FighterBuff)localIterator.next();
/* 4635 */         if (localFighterBuff.isEffect()) {
/* 4636 */           setBuffUnEffect(localFighterBuff);
/*      */         }
/* 4638 */         localIterator.remove();
/* 4639 */         bool = true;
/*      */       }
/* 4641 */       this.xFighter.getBuffs().remove(Integer.valueOf(paramInt));
/*      */     }
/* 4643 */     return bool;
/*      */   }
/*      */   
/*      */   public final boolean removeFirstBuff(int paramInt) {
/* 4647 */     if (this.xFighter.getBuffs().containsKey(Integer.valueOf(paramInt))) {
/* 4648 */       FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(paramInt));
/* 4649 */       if (localFighterBuffs.getBuffs().size() > 0) {
/* 4650 */         FighterBuff localFighterBuff = (FighterBuff)localFighterBuffs.getBuffs().remove(0);
/* 4651 */         if (localFighterBuff.isEffect()) {
/* 4652 */           setBuffUnEffect(localFighterBuff);
/*      */         }
/* 4654 */         if (localFighterBuffs.getBuffs().size() <= 0) {
/* 4655 */           this.xFighter.getBuffs().remove(Integer.valueOf(paramInt));
/*      */         }
/* 4657 */         return true;
/*      */       }
/*      */     }
/* 4660 */     return false;
/*      */   }
/*      */   
/*      */   public int getBuffSize(int paramInt) {
/* 4664 */     FighterBuffs localFighterBuffs = (FighterBuffs)this.xFighter.getBuffs().get(Integer.valueOf(paramInt));
/* 4665 */     if (localFighterBuffs == null) {
/* 4666 */       return 0;
/*      */     }
/* 4668 */     int i = 0;
/* 4669 */     for (FighterBuff localFighterBuff : localFighterBuffs.getBuffs()) {
/* 4670 */       if (localFighterBuff.getLeftRound() > 0) {
/* 4671 */         i++;
/*      */       }
/*      */     }
/* 4674 */     return i;
/*      */   }
/*      */   
/*      */   public final int dispelSealBuff(int paramInt) {
/* 4678 */     return dispelBuff(8, false, paramInt);
/*      */   }
/*      */   
/*      */   public final int dispelSealBuff() {
/* 4682 */     return dispelBuff(8, true, 0);
/*      */   }
/*      */   
/*      */   public final int dispelSealBuffForce() {
/* 4686 */     return dispelBuff(8, true, 0, true);
/*      */   }
/*      */   
/*      */   public final int dispelNegativeBuff(int paramInt) {
/* 4690 */     return dispelBuff(2, false, paramInt);
/*      */   }
/*      */   
/*      */   public final int dispelNegativeBuff() {
/* 4694 */     return dispelBuff(2, true, 0);
/*      */   }
/*      */   
/*      */   public final int dispelPoisonBuff(int paramInt) {
/* 4698 */     return dispelBuff(16, false, paramInt);
/*      */   }
/*      */   
/*      */   public final int dispelPoisonBuff() {
/* 4702 */     return dispelBuff(16, true, 0);
/*      */   }
/*      */   
/*      */   public final int dispelPositiveBuff(int paramInt) {
/* 4706 */     return dispelBuff(4, false, paramInt);
/*      */   }
/*      */   
/*      */   public final int dispelPositiveBuff() {
/* 4710 */     return dispelBuff(4, true, 0);
/*      */   }
/*      */   
/*      */   private int dispelBuff(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
/* 4714 */     if ((paramInt2 <= 0) && (!paramBoolean1)) {
/* 4715 */       return 0;
/*      */     }
/* 4717 */     int i = 0;
/* 4718 */     Iterator localIterator1 = this.xFighter.getBuffs().entrySet().iterator();
/* 4719 */     while (localIterator1.hasNext()) {
/* 4720 */       Map.Entry localEntry = (Map.Entry)localIterator1.next();
/* 4721 */       FighterBuffs localFighterBuffs = (FighterBuffs)localEntry.getValue();
/* 4722 */       Iterator localIterator2 = localFighterBuffs.getBuffs().iterator();
/* 4723 */       while (localIterator2.hasNext()) {
/* 4724 */         FighterBuff localFighterBuff = (FighterBuff)localIterator2.next();
/* 4725 */         if (localFighterBuff.getLeftRound() <= 0) {
/* 4726 */           localIterator2.remove();
/*      */ 
/*      */         }
/* 4729 */         else if ((localFighterBuff.getEffectGroupType() == paramInt1) && ((localFighterBuff.getCanBeDispel()) || (paramBoolean2)))
/*      */         {
/*      */ 
/* 4732 */           if (localFighterBuff.isEffect()) {
/* 4733 */             setBuffUnEffect(localFighterBuff);
/*      */           }
/* 4735 */           localIterator2.remove();
/* 4736 */           i++; if ((i >= paramInt2) && (!paramBoolean1)) {
/*      */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 4742 */       if (localFighterBuffs.getBuffs().size() == 0) {
/* 4743 */         localIterator1.remove();
/*      */       }
/* 4745 */       if ((i >= paramInt2) && (!paramBoolean1)) {
/* 4746 */         return i;
/*      */       }
/*      */     }
/* 4749 */     return i;
/*      */   }
/*      */   
/*      */   private final int dispelBuff(int paramInt1, boolean paramBoolean, int paramInt2) {
/* 4753 */     return dispelBuff(paramInt1, paramBoolean, paramInt2, false);
/*      */   }
/*      */   
/*      */   public final CounterAttack handleCounterAttack(Fighter paramFighter) {
/* 4757 */     if ((isMess()) || (isStone()) || (isSleep()) || (isIceCool())) {
/* 4758 */       return null;
/*      */     }
/* 4760 */     if ((paramFighter.isTech()) || (paramFighter.isDead()) || (paramFighter.isFakeDead())) {
/* 4761 */       return null;
/*      */     }
/* 4763 */     if ((isDead()) || (isFakeDead())) {
/* 4764 */       return null;
/*      */     }
/* 4766 */     boolean bool1 = FightFormulaHelp.isFightBack(getPHYFIGHTBACK());
/* 4767 */     boolean bool2 = FightFormulaHelp.isFightBack(getMAGFIGHTBACK());
/* 4768 */     if ((bool1) && (bool2)) {
/* 4769 */       bool1 = xdb.Xdb.random().nextBoolean();
/*      */     }
/* 4771 */     if ((!bool1) && (!bool2)) {
/* 4772 */       return null;
/*      */     }
/* 4774 */     mzm.gsp.fight.handle.CounterHandle.InputObj localInputObj = new mzm.gsp.fight.handle.CounterHandle.InputObj(this, paramFighter);
/* 4775 */     mzm.gsp.fight.handle.CounterHandle.OutputObj localOutputObj = handleBeforeCounter(localInputObj);
/* 4776 */     if (!localOutputObj.isCanCounter) {
/* 4777 */       return null;
/*      */     }
/* 4779 */     CounterAttack localCounterAttack = new CounterAttack();
/* 4780 */     paramFighter.fillFighterStatus(localCounterAttack.targetstatus);
/* 4781 */     fillFighterStatus(localCounterAttack.attackerstatus);
/* 4782 */     Skill localSkill = null;
/* 4783 */     BeforeAttackHandle.OutputObj localOutputObj1 = null;
/* 4784 */     BeforeAttackHandle.OutputObj localOutputObj2 = null;
/* 4785 */     int i = 0;
/* 4786 */     int j = 0;
/* 4787 */     BeDamageHandle.OutputObj localOutputObj3 = null;
/* 4788 */     boolean bool3; BeforeAttackHandle.OutputObj localOutputObj4; int k; Object localObject3; Object localObject4; boolean bool5; int m; FighterStatus localFighterStatus4; if (bool1) {
/* 4789 */       localSkill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, getLevel());
/* 4790 */       localCounterAttack.skill = SFightConsts.getInstance().ATTACK_SKILL;
/* 4791 */       localOutputObj1 = handleBeforeAttack(new mzm.gsp.fight.handle.BeforeAttackHandle.InputObj(this, paramFighter, localSkill));
/* 4792 */       localOutputObj2 = paramFighter.handleBeforeAttack(new mzm.gsp.fight.handle.BeforeAttackHandle.InputObj(this, paramFighter, localSkill));
/* 4793 */       if (!FightFormulaHelp.isPhyHit(this, paramFighter, 0)) {
/* 4794 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(22));
/* 4795 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(28));
/* 4796 */         return localCounterAttack;
/*      */       }
/* 4798 */       bool3 = FightFormulaHelp.isPHyCrt(this, paramFighter, localOutputObj1, localOutputObj2);
/* 4799 */       localOutputObj4 = localOutputObj1;
/* 4800 */       localOutputObj4.damageRate += getPHyFightBackDamageRate();
/* 4801 */       k = FightFormulaHelp.calPHYDamage(this, paramFighter, 1, bool3, localOutputObj1, localOutputObj2);
/* 4802 */       localObject3 = new BeDamageHandle.InputObj(this, paramFighter, localSkill, k, 1);
/* 4803 */       ((BeDamageHandle.InputObj)localObject3).setCounterAttack();
/* 4804 */       localOutputObj3 = paramFighter.handleBeDamage((BeDamageHandle.InputObj)localObject3);
/* 4805 */       localObject4 = paramFighter.handleOnRebound(1, k);
/* 4806 */       j = ((mzm.gsp.fight.handle.ReboundHandle.OutPutObj)localObject4).reboundDamage;
/* 4807 */       bool5 = localOutputObj3.absorb;
/* 4808 */       i = localOutputObj3.damage2heal > 0 ? -localOutputObj3.damage2heal : localOutputObj3.nowDamage;
/* 4809 */       paramFighter.addHp(this, -i);
/* 4810 */       addDamageToFighter(paramFighter, k);
/* 4811 */       if (bool3) {
/* 4812 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(21));
/* 4813 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(20));
/*      */       }
/*      */       else {
/* 4816 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(20));
/*      */       }
/* 4818 */       localCounterAttack.targetstatus.status_set.add(Integer.valueOf(28));
/* 4819 */       if (bool5) {
/* 4820 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(26));
/*      */       }
/* 4822 */       localCounterAttack.targetstatus.hpchange = (-i);
/* 4823 */       localCounterAttack.targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 4824 */       if (localOutputObj1.vampire) {
/* 4825 */         m = (int)(i * (localOutputObj1.phyVampirerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 4826 */         addHp(m);
/* 4827 */         localFighterStatus4 = localCounterAttack.attackerstatus;
/* 4828 */         localFighterStatus4.hpchange += m;
/*      */       }
/*      */     }
/*      */     else {
/* 4832 */       if (!bool2) {
/* 4833 */         return null;
/*      */       }
/* 4835 */       localSkill = SkillInterface.getSkill(SFightConsts.getInstance().MAG_SKILL, getLevel());
/* 4836 */       localCounterAttack.skill = SFightConsts.getInstance().MAG_SKILL;
/* 4837 */       localOutputObj1 = handleBeforeAttack(new mzm.gsp.fight.handle.BeforeAttackHandle.InputObj(this, paramFighter, localSkill));
/* 4838 */       localOutputObj2 = paramFighter.handleBeforeAttack(new mzm.gsp.fight.handle.BeforeAttackHandle.InputObj(this, paramFighter, localSkill));
/* 4839 */       if (!FightFormulaHelp.isMagHit(this, paramFighter, 0)) {
/* 4840 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(22));
/* 4841 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(28));
/* 4842 */         return localCounterAttack;
/*      */       }
/* 4844 */       bool3 = FightFormulaHelp.isMagCrt(this, paramFighter, localOutputObj1, localOutputObj2);
/* 4845 */       localOutputObj4 = localOutputObj1;
/* 4846 */       localOutputObj4.damageRate += getMagFightBackDamageRate();
/* 4847 */       k = FightFormulaHelp.calMAGDamage(this, paramFighter, 1, bool3, localOutputObj1, localOutputObj2);
/* 4848 */       localObject3 = new BeDamageHandle.InputObj(this, paramFighter, localSkill, k, 2);
/* 4849 */       ((BeDamageHandle.InputObj)localObject3).setCounterAttack();
/* 4850 */       localOutputObj3 = paramFighter.handleBeDamage((BeDamageHandle.InputObj)localObject3);
/* 4851 */       localObject4 = paramFighter.handleOnRebound(1, k);
/* 4852 */       j = ((mzm.gsp.fight.handle.ReboundHandle.OutPutObj)localObject4).reboundDamage;
/* 4853 */       bool5 = localOutputObj3.absorb;
/* 4854 */       i = localOutputObj3.damage2heal > 0 ? -localOutputObj3.damage2heal : localOutputObj3.nowDamage;
/* 4855 */       paramFighter.addHp(this, -i);
/* 4856 */       if (bool3) {
/* 4857 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(21));
/* 4858 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(20));
/*      */       }
/*      */       else {
/* 4861 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(20));
/*      */       }
/* 4863 */       localCounterAttack.targetstatus.status_set.add(Integer.valueOf(28));
/* 4864 */       if (bool5) {
/* 4865 */         localCounterAttack.targetstatus.status_set.add(Integer.valueOf(26));
/*      */       }
/* 4867 */       localCounterAttack.targetstatus.hpchange = (-i);
/* 4868 */       localCounterAttack.targetstatus.triggerpassiveskills.addAll(localOutputObj3.targetPassiveSkillids);
/* 4869 */       if (localOutputObj1.vampire) {
/* 4870 */         m = (int)(i * (localOutputObj1.magVampirerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 4871 */         addHp(m);
/* 4872 */         localFighterStatus4 = localCounterAttack.attackerstatus;
/* 4873 */         localFighterStatus4.hpchange += m;
/*      */       }
/*      */     }
/* 4876 */     paramFighter.fillFighterStatus(localCounterAttack.targetstatus);
/* 4877 */     fillFighterStatus(localCounterAttack.attackerstatus);
/* 4878 */     localCounterAttack.attackerstatus.triggerpassiveskills.addAll(localOutputObj1.releasertriggerPassiveSkillids);
/* 4879 */     localCounterAttack.targetstatus.triggerpassiveskills.addAll(localOutputObj2.targetPassiveSkillids);
/* 4880 */     localSkill.handleShareDamageInCounterAttack(this, localOutputObj3, localCounterAttack);
/* 4881 */     handleAfterCounter(localInputObj);
/* 4882 */     addActionCount();
/* 4883 */     Object localObject1; Object localObject2; FighterStatus localFighterStatus1; if ((paramFighter.isDead()) || (paramFighter.isFakeDead())) {
/* 4884 */       localObject1 = paramFighter.handleBeKilled(new mzm.gsp.fight.handle.BeKilledHandle.InputObj(this, paramFighter, localSkill, i));
/* 4885 */       if (!paramFighter.isDead()) {
/* 4886 */         boolean bool4 = localCounterAttack.targetstatus.status_set.remove(Integer.valueOf(1));
/* 4887 */         if (bool4) {
/* 4888 */           localCounterAttack.targetstatus.status_set.add(Integer.valueOf(3));
/*      */         }
/*      */       }
/* 4891 */       localCounterAttack.targetstatus.triggerpassiveskills.addAll(((mzm.gsp.fight.handle.BeKilledHandle.OutPutObj)localObject1).targetPassiveSkillids);
/* 4892 */       localCounterAttack.influences.othermap.putAll(paramFighter.getInfluenceMap());
/* 4893 */       paramFighter.clearInfluenceTarget();
/* 4894 */       if (paramFighter.isAlive())
/*      */       {
/* 4896 */         localFighterStatus1 = localObject2 = new FighterStatus();
/* 4897 */         localObject2.hpchange += paramFighter.getHp();
/* 4898 */         localFighterStatus1.status_set.add(Integer.valueOf(23));
/* 4899 */         paramFighter.fillFighterStatus(localFighterStatus1);
/* 4900 */         localCounterAttack.statusmap.put(Integer.valueOf(1), localFighterStatus1);
/*      */       }
/*      */     }
/*      */     else {
/* 4904 */       localObject1 = this;
/* 4905 */       localObject2 = paramFighter;
/* 4906 */       if ((j > 0) && (((Fighter)localObject1).isAlive())) {
/* 4907 */         ((Fighter)localObject1).addHp((Fighter)localObject2, -j);
/* 4908 */         ((Fighter)localObject2).addDamageToFighter((Fighter)localObject1, j);
/* 4909 */         localFighterStatus1 = new FighterStatus();
/* 4910 */         localFighterStatus1.status_set.add(Integer.valueOf(20));
/* 4911 */         ((Fighter)localObject1).fillFighterStatus(localFighterStatus1);
/* 4912 */         localObject3 = localFighterStatus1;
/* 4913 */         localObject3.hpchange -= j;
/* 4914 */         localCounterAttack.statusmap.put(Integer.valueOf(0), localFighterStatus1);
/* 4915 */         if ((((Fighter)localObject1).isDead()) || (((Fighter)localObject1).isFakeDead())) {
/* 4916 */           localObject4 = ((Fighter)localObject1).handleBeKilled(new mzm.gsp.fight.handle.BeKilledHandle.InputObj((Fighter)localObject2, (Fighter)localObject1, localSkill, j));
/* 4917 */           localSkill.addTargetInfluenceMap((Fighter)localObject2, ((Fighter)localObject1).getInfluenceMap());
/* 4918 */           ((Fighter)localObject1).clearInfluenceTarget();
/* 4919 */           FighterStatus localFighterStatus2 = (FighterStatus)localCounterAttack.statusmap.get(Integer.valueOf(0));
/* 4920 */           localFighterStatus2.triggerpassiveskills.addAll(((mzm.gsp.fight.handle.BeKilledHandle.OutPutObj)localObject4).targetPassiveSkillids);
/* 4921 */           if (((Fighter)localObject1).isAlive()) {
/* 4922 */             localFighterStatus2.status_set.remove(Integer.valueOf(1));
/* 4923 */             localFighterStatus2.status_set.add(Integer.valueOf(3));
/*      */             FighterStatus localFighterStatus3;
/* 4925 */             localFighterStatus4 = localFighterStatus3 = new FighterStatus();
/* 4926 */             localFighterStatus3.hpchange += ((Fighter)localObject1).getHp();
/* 4927 */             localFighterStatus4.status_set.add(Integer.valueOf(23));
/* 4928 */             ((Fighter)localObject1).fillFighterStatus(localFighterStatus4);
/* 4929 */             localCounterAttack.statusmap.put(Integer.valueOf(2), localFighterStatus4);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 4934 */     return localCounterAttack;
/*      */   }
/*      */   
/*      */   public final void handleKillOther(mzm.gsp.fight.handle.KillOtherHandle.InputObj paramInputObj, mzm.gsp.fight.handle.KillOtherHandle.OutputObj paramOutputObj) {
/* 4938 */     Set localSet = copySetValue(this.xFighter.getHandleonkillother());
/* 4939 */     for (mzm.gsp.fight.handle.KillOtherHandle localKillOtherHandle : localSet) {
/* 4940 */       localKillOtherHandle.killOther(paramInputObj, paramOutputObj);
/*      */     }
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.BeKilledHandle.OutPutObj handleBeKilled(mzm.gsp.fight.handle.BeKilledHandle.InputObj paramInputObj) {
/* 4945 */     Set localSet1 = copySetValue(this.xFighter.getHandleonbekilled());
/* 4946 */     mzm.gsp.fight.handle.BeKilledHandle.OutPutObj localOutPutObj = new mzm.gsp.fight.handle.BeKilledHandle.OutPutObj();
/* 4947 */     for (Object localObject1 = localSet1.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (mzm.gsp.fight.handle.BeKilledHandle)((Iterator)localObject1).next();
/* 4948 */       if (((!(localObject2 instanceof mzm.gsp.effect.fighter.GodBless)) && (!(localObject2 instanceof mzm.gsp.effect.fighter.ProbabilityResurrection))) || (!isForgetSkill()))
/*      */       {
/*      */ 
/*      */ 
/* 4952 */         ((mzm.gsp.fight.handle.BeKilledHandle)localObject2).handleOnBeKilled(paramInputObj, localOutPutObj); }
/*      */     }
/* 4954 */     localObject1 = paramInputObj.releser;
/* 4955 */     Object localObject2 = paramInputObj.skill;
/* 4956 */     if ((localObject1 == null) || (localObject2 == null)) {
/* 4957 */       return localOutPutObj;
/*      */     }
/* 4959 */     if ((((Fighter)localObject1).isBeatGhost()) && (isGhost())) {
/* 4960 */       return localOutPutObj;
/*      */     }
/* 4962 */     if (isGhost()) {
/* 4963 */       if (isDead()) {
/* 4964 */         setFakeDead();
/*      */       }
/* 4966 */       localObject3 = ((Skill)localObject2).getKilledFighterStatus((Fighter)localObject1, this);
/* 4967 */       if (localObject3 != null) {
/* 4968 */         boolean bool = ((FighterStatus)localObject3).status_set.remove(Integer.valueOf(1));
/* 4969 */         if (bool) {
/* 4970 */           ((FighterStatus)localObject3).status_set.add(Integer.valueOf(3));
/*      */         }
/*      */       }
/*      */     }
/* 4974 */     Object localObject3 = getFight().getActiveTeam().getFighters();
/* 4975 */     Set localSet2 = getFight().getPassiveTeam().getFighters();
/* 4976 */     HashSet localHashSet = new HashSet();
/* 4977 */     localHashSet.addAll((java.util.Collection)localObject3);
/* 4978 */     localHashSet.addAll(localSet2);
/* 4979 */     for (Iterator localIterator1 = localHashSet.iterator(); localIterator1.hasNext();) { localFighter = (Fighter)localIterator1.next();
/* 4980 */       Set localSet3 = copySetValue(localFighter.xFighter.getHandleonotherbekilledafter());
/* 4981 */       for (mzm.gsp.fight.handle.OtherBeKilledAfterHandle localOtherBeKilledAfterHandle : localSet3)
/* 4982 */         localOtherBeKilledAfterHandle.otherBeKilled(paramInputObj, localFighter);
/*      */     }
/*      */     Fighter localFighter;
/* 4985 */     return localOutPutObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.BeforeHealHandle.OutputObj handleBeforeHeal(mzm.gsp.fight.handle.BeforeHealHandle.InputObj paramInputObj) {
/* 4989 */     mzm.gsp.fight.handle.BeforeHealHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.BeforeHealHandle.OutputObj();
/* 4990 */     Set localSet = copySetValue(this.xFighter.getHandleonbeforeheal());
/* 4991 */     for (mzm.gsp.fight.handle.BeforeHealHandle localBeforeHealHandle : localSet) {
/* 4992 */       localBeforeHealHandle.handleBeforeHeal(paramInputObj, localOutputObj);
/*      */     }
/* 4994 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.BeforeSealHandle.OutputObj handleBeforeSeal(mzm.gsp.fight.handle.BeforeSealHandle.InputObj paramInputObj) {
/* 4998 */     mzm.gsp.fight.handle.BeforeSealHandle.OutputObj localOutputObj1 = new mzm.gsp.fight.handle.BeforeSealHandle.OutputObj();
/* 4999 */     Set localSet = copySetValue(this.xFighter.getHandleonbeforeseal());
/* 5000 */     for (Object localObject1 = localSet.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (mzm.gsp.fight.handle.BeforeSealHandle)((Iterator)localObject1).next();
/* 5001 */       ((mzm.gsp.fight.handle.BeforeSealHandle)localObject2).handleBeforeAttack(paramInputObj, localOutputObj1); }
/*      */     Object localObject2;
/* 5003 */     if (getFight().getExtra(FightExtra.CHANGE_MODEL_CARD_ENABLE) == 1) {
/* 5004 */       localObject1 = paramInputObj.getReleser();
/* 5005 */       if ((localObject1 != null) && (((Fighter)localObject1).getUuid() == getUuid())) {
/* 5006 */         localObject2 = paramInputObj.getTarget();
/* 5007 */         int i = getCardSealValue((Fighter)localObject2);
/* 5008 */         if (i != 0) {
/* 5009 */           mzm.gsp.fight.handle.BeforeSealHandle.OutputObj localOutputObj2 = localOutputObj1;
/* 5010 */           localOutputObj2.sealRate += i;
/*      */         }
/*      */       }
/*      */     }
/* 5014 */     return localOutputObj1;
/*      */   }
/*      */   
/*      */   public final BeforeAttackHandle.OutputObj handleBeforeAttack(mzm.gsp.fight.handle.BeforeAttackHandle.InputObj paramInputObj) {
/* 5018 */     paramInputObj.setOwner(this);
/* 5019 */     BeforeAttackHandle.OutputObj localOutputObj1 = new BeforeAttackHandle.OutputObj();
/* 5020 */     Set localSet = copySetValue(this.xFighter.getHandleonbeforeattack());
/* 5021 */     for (Object localObject1 = localSet.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (mzm.gsp.fight.handle.BeforeAttackHandle)((Iterator)localObject1).next();
/* 5022 */       ((mzm.gsp.fight.handle.BeforeAttackHandle)localObject2).handleBeforeAttack(paramInputObj, localOutputObj1); }
/*      */     Object localObject2;
/* 5024 */     if (getFight().getExtra(FightExtra.CHANGE_MODEL_CARD_ENABLE) == 1) {
/* 5025 */       localObject1 = paramInputObj.getReleser();
/* 5026 */       if ((localObject1 != null) && (((Fighter)localObject1).getUuid() == getUuid())) {
/* 5027 */         localObject2 = paramInputObj.getTarget();
/* 5028 */         int i = getCardBuffValue((Fighter)localObject2);
/* 5029 */         if (i != 0) {
/* 5030 */           BeforeAttackHandle.OutputObj localOutputObj2 = localOutputObj1;
/* 5031 */           localOutputObj2.damageRate += i;
/*      */         }
/*      */       }
/*      */     }
/* 5035 */     if ((isDead()) || (isFakeDead())) {
/* 5036 */       localOutputObj1.vampire = false;
/*      */     }
/* 5038 */     return localOutputObj1;
/*      */   }
/*      */   
/*      */   private final int getCardBuffValue(Fighter paramFighter) {
/* 5042 */     int i = 0;
/* 5043 */     if (paramFighter == null) {
/* 5044 */       return i;
/*      */     }
/* 5046 */     i = mzm.gsp.changemodelcard.main.ChangeModelCardInterface.getClassDamageRate(getCurrentChangeModelCardClassType(), getCurrentChangeModelCardLevel(), paramFighter.getCurrentChangeModelCardClassType(), paramFighter.getCurrentChangeModelCardLevel());
/* 5047 */     return i;
/*      */   }
/*      */   
/*      */   private final int getCardSealValue(Fighter paramFighter) {
/* 5051 */     int i = 0;
/* 5052 */     if (paramFighter == null) {
/* 5053 */       return i;
/*      */     }
/* 5055 */     i = mzm.gsp.changemodelcard.main.ChangeModelCardInterface.getClassSealRate(getCurrentChangeModelCardClassType(), getCurrentChangeModelCardLevel(), paramFighter.getCurrentChangeModelCardClassType(), paramFighter.getCurrentChangeModelCardLevel());
/* 5056 */     return i;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.CounterHandle.OutputObj handleBeforeCounter(mzm.gsp.fight.handle.CounterHandle.InputObj paramInputObj) {
/* 5060 */     mzm.gsp.fight.handle.CounterHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.CounterHandle.OutputObj();
/* 5061 */     Set localSet = copySetValue(this.xFighter.getHandleoncounter());
/* 5062 */     for (mzm.gsp.fight.handle.CounterHandle localCounterHandle : localSet) {
/* 5063 */       localCounterHandle.beforeCounter(paramInputObj, localOutputObj);
/*      */     }
/* 5065 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.CounterHandle.OutputObj handleAfterCounter(mzm.gsp.fight.handle.CounterHandle.InputObj paramInputObj) {
/* 5069 */     mzm.gsp.fight.handle.CounterHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.CounterHandle.OutputObj();
/* 5070 */     Set localSet = copySetValue(this.xFighter.getHandleoncounter());
/* 5071 */     for (mzm.gsp.fight.handle.CounterHandle localCounterHandle : localSet) {
/* 5072 */       localCounterHandle.afterCounter(paramInputObj, localOutputObj);
/*      */     }
/* 5074 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj handleAfterAttack(Skill paramSkill, Fighter paramFighter1, Fighter paramFighter2) {
/* 5078 */     Set localSet = copySetValue(this.xFighter.getHandleonafterattack());
/* 5079 */     mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj localOutPutObj = new mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj();
/* 5080 */     mzm.gsp.fight.handle.AfterAttackHandle.InputObj localInputObj = new mzm.gsp.fight.handle.AfterAttackHandle.InputObj(paramSkill, paramFighter1, paramFighter2);
/* 5081 */     for (mzm.gsp.fight.handle.AfterAttackHandle localAfterAttackHandle : localSet) {
/* 5082 */       localAfterAttackHandle.afterAttack(localInputObj, localOutPutObj);
/*      */     }
/* 5084 */     return localOutPutObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj handleAfterAttack(mzm.gsp.fight.handle.AfterAttackHandle.InputObj paramInputObj) {
/* 5088 */     Set localSet = copySetValue(this.xFighter.getHandleonafterattack());
/* 5089 */     mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj localOutPutObj = new mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj();
/* 5090 */     for (mzm.gsp.fight.handle.AfterAttackHandle localAfterAttackHandle : localSet) {
/* 5091 */       localAfterAttackHandle.afterAttack(paramInputObj, localOutPutObj);
/*      */     }
/* 5093 */     return localOutPutObj;
/*      */   }
/*      */   
/*      */   public final SkillCostHandle.CostResult handleSkillCost() {
/* 5097 */     SkillCostHandle.CostResult localCostResult1 = new SkillCostHandle.CostResult();
/* 5098 */     Set localSet = copySetValue(this.xFighter.getHandleonskillcost());
/* 5099 */     for (Object localObject = localSet.iterator(); ((Iterator)localObject).hasNext();) { mzm.gsp.fight.handle.SkillCostHandle localSkillCostHandle = (mzm.gsp.fight.handle.SkillCostHandle)((Iterator)localObject).next();
/* 5100 */       localSkillCostHandle.handle(localCostResult1);
/*      */     }
/* 5102 */     localObject = FightConfigManager.getInstance().getFightTypeCfg(getFight().getCfgType());
/* 5103 */     if ((((mzm.gsp.fight.confbean.SFightTypeCfg)localObject).isFellowSkillCost) && (isFellowType())) {
/* 5104 */       int i = this.fightGroup.fightTeam.getTeamAssistFellowNum();
/* 5105 */       SkillCostHandle.CostResult localCostResult2; if (i == SFightConsts.getInstance().ASSIST_FELLOW_NUM_1) {
/* 5106 */         localCostResult2 = localCostResult1;
/* 5107 */         localCostResult2.extraRate += SFightConsts.getInstance().ASSIST_COST_MODIFY_RATE_1;
/*      */       }
/* 5109 */       else if (i == SFightConsts.getInstance().ASSIST_FELLOW_NUM_2) {
/* 5110 */         localCostResult2 = localCostResult1;
/* 5111 */         localCostResult2.extraRate += SFightConsts.getInstance().ASSIST_COST_MODIFY_RATE_2;
/*      */       }
/*      */     }
/* 5114 */     return localCostResult1;
/*      */   }
/*      */   
/*      */   public final void handleOnSealed(Fighter paramFighter, FighterBuff paramFighterBuff) {
/* 5118 */     Set localSet = copySetValue(this.xFighter.getHandleonsealed());
/* 5119 */     for (mzm.gsp.fight.handle.SealedHandle localSealedHandle : localSet) {
/* 5120 */       localSealedHandle.onSealed(paramFighter, this, paramFighterBuff);
/*      */     }
/*      */   }
/*      */   
/*      */   public void handleOnSealOthers(Fighter paramFighter, FighterBuff paramFighterBuff) {
/* 5125 */     Set localSet = copySetValue(this.xFighter.getHandleonsealed());
/* 5126 */     for (mzm.gsp.fight.handle.SealedHandle localSealedHandle : localSet) {
/* 5127 */       localSealedHandle.onSealOthers(this, paramFighter, paramFighterBuff);
/*      */     }
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.TargetNumHandle.OutputObj handleonTargetNum(mzm.gsp.fight.handle.TargetNumHandle.InputObj paramInputObj) {
/* 5132 */     Set localSet = copySetValue(this.xFighter.getHandleontargetnumhandle());
/* 5133 */     mzm.gsp.fight.handle.TargetNumHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.TargetNumHandle.OutputObj();
/* 5134 */     for (mzm.gsp.fight.handle.TargetNumHandle localTargetNumHandle : localSet) {
/* 5135 */       localTargetNumHandle.onTargetNum(paramInputObj, localOutputObj);
/*      */     }
/* 5137 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj handleonBeforePoison(mzm.gsp.fight.handle.BeforePoisonHandle.InputObj paramInputObj) {
/* 5141 */     Set localSet = copySetValue(this.xFighter.getHandleonbeforepoisonhandle());
/* 5142 */     mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj();
/* 5143 */     for (mzm.gsp.fight.handle.BeforePoisonHandle localBeforePoisonHandle : localSet) {
/* 5144 */       localBeforePoisonHandle.beforePoison(paramInputObj, localOutputObj);
/*      */     }
/* 5146 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final void handleOnAddAnger(mzm.gsp.fight.handle.AddAngerHandle.OutputObj paramOutputObj) {
/* 5150 */     Set localSet = copySetValue(this.xFighter.getHandleonaddangerhandle());
/* 5151 */     for (mzm.gsp.fight.handle.AddAngerHandle localAddAngerHandle : localSet) {
/* 5152 */       localAddAngerHandle.onAddAnger(paramOutputObj);
/*      */     }
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.DrugHandle.OutputObj handleOnAfterDrug(mzm.gsp.fight.handle.DrugHandle.InputObj paramInputObj) {
/* 5157 */     Set localSet = copySetValue(this.xFighter.getHandleondrughandle());
/* 5158 */     mzm.gsp.fight.handle.DrugHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.DrugHandle.OutputObj();
/* 5159 */     for (mzm.gsp.fight.handle.DrugHandle localDrugHandle : localSet) {
/* 5160 */       localDrugHandle.onAfterDrug(paramInputObj, localOutputObj);
/*      */     }
/* 5162 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final mzm.gsp.fight.handle.LoseHpHandle.OutputObj handleOnLostHp(mzm.gsp.fight.handle.LoseHpHandle.InputObj paramInputObj) {
/* 5166 */     Set localSet = copySetValue(this.xFighter.getHandleonlosehphandle());
/* 5167 */     mzm.gsp.fight.handle.LoseHpHandle.OutputObj localOutputObj = new mzm.gsp.fight.handle.LoseHpHandle.OutputObj();
/* 5168 */     for (mzm.gsp.fight.handle.LoseHpHandle localLoseHpHandle : localSet) {
/* 5169 */       localLoseHpHandle.handleOnLoseHp(paramInputObj, localOutputObj);
/*      */     }
/* 5171 */     return localOutputObj;
/*      */   }
/*      */   
/*      */   public final boolean handleProtect(Fighter paramFighter) {
/* 5175 */     Set localSet = copySetValue(this.xFighter.getHandleonprotect());
/* 5176 */     for (mzm.gsp.fight.handle.ProtectHandle localProtectHandle : localSet) {
/* 5177 */       if (localProtectHandle.triggerProtect(paramFighter, this)) {
/* 5178 */         return true;
/*      */       }
/*      */     }
/* 5181 */     return false;
/*      */   }
/*      */   
/*      */   public final void addModel(int paramInt) {
/* 5185 */     if (this.xFighter.getChangemodelids().contains(Integer.valueOf(paramInt))) {
/* 5186 */       return;
/*      */     }
/* 5188 */     this.xFighter.getChangemodelids().add(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public final void removeModel(Integer paramInteger) {
/* 5192 */     this.xFighter.getChangemodelids().remove(paramInteger);
/*      */   }
/*      */   
/*      */   public boolean equals(Object paramObject)
/*      */   {
/* 5197 */     if (paramObject == null) {
/* 5198 */       return false;
/*      */     }
/* 5200 */     if ((paramObject instanceof Fighter)) {
/* 5201 */       Fighter localFighter = (Fighter)paramObject;
/* 5202 */       return (this.xFighter.getType() == localFighter.getType()) && (localFighter.getid() == this.fighterid);
/*      */     }
/* 5204 */     return false;
/*      */   }
/*      */   
/*      */   public int hashCode()
/*      */   {
/* 5209 */     return this.fighterid;
/*      */   }
/*      */   
/*      */   abstract void broadCastSelectOperInTeam();
/*      */   
/*      */   public FighterStatus getAndAddRoundStatus() {
/* 5215 */     return this.fightGroup.getFight().getAndAddRoundStatus(this.fighterid);
/*      */   }
/*      */   
/*      */   protected FighterEffect getPassiveEffect(int paramInt1, List<Integer> paramList, int paramInt2) {
/* 5219 */     Skill localSkill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, paramInt2);
/* 5220 */     ArrayList localArrayList = new ArrayList();
/* 5221 */     for (Object localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { int i = ((Integer)((Iterator)localObject).next()).intValue();
/* 5222 */       mzm.gsp.effect.formula.fighter.EffectFormula localEffectFormula = mzm.gsp.effect.main.EffectInterface.getFighterEffectFormula(i);
/* 5223 */       if (localEffectFormula == null) {
/* 5224 */         GameServer.logger().error("效果子表中配置的公式不存在,效果子表id:" + paramInt1);
/* 5225 */         break;
/*      */       }
/* 5227 */       int j = localEffectFormula.calc(localSkill, this, this);
/* 5228 */       localArrayList.add(Integer.valueOf(j));
/*      */     }
/* 5230 */     localObject = mzm.gsp.effect.main.EffectInterface.getFighterEffectInstance(paramInt1, localArrayList);
/* 5231 */     return (FighterEffect)localObject;
/*      */   }
/*      */   
/*      */   protected FighterEffect getPassiveEffect(int paramInt, List<Integer> paramList) {
/* 5235 */     return getPassiveEffect(paramInt, paramList, getLevel());
/*      */   }
/*      */   
/*      */   protected void addPassiveEffect(FighterEffect paramFighterEffect) {
/* 5239 */     if ((paramFighterEffect instanceof mzm.gsp.effect.fighter.Interface.TeamEffect)) {
/* 5240 */       mzm.gsp.effect.fighter.Interface.TeamEffect localTeamEffect = (mzm.gsp.effect.fighter.Interface.TeamEffect)paramFighterEffect;
/* 5241 */       this.fightGroup.fightTeam.addTeamEffect(localTeamEffect);
/*      */     }
/* 5243 */     else if ((paramFighterEffect instanceof mzm.gsp.effect.fighter.Interface.PassiveOnce)) {
/* 5244 */       ((mzm.gsp.effect.fighter.Interface.PassiveOnce)paramFighterEffect).perform(this);
/*      */     }
/*      */     else {
/* 5247 */       paramFighterEffect.attach(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isInSameTeam(Fighter paramFighter) {
/* 5252 */     if ((paramFighter == null) || (paramFighter.fightGroup == null)) {
/* 5253 */       return false;
/*      */     }
/* 5255 */     FightTeam localFightTeam1 = paramFighter.fightGroup.fightTeam;
/* 5256 */     if (localFightTeam1 == null) {
/* 5257 */       return false;
/*      */     }
/* 5259 */     FightTeam localFightTeam2 = this.fightGroup.fightTeam;
/* 5260 */     return localFightTeam2.isActive == localFightTeam1.isActive;
/*      */   }
/*      */   
/*      */   public boolean isPVP() {
/* 5264 */     return this.fightGroup.fightTeam.fight.isPVP();
/*      */   }
/*      */   
/*      */   public boolean isPVE() {
/* 5268 */     return this.fightGroup.fightTeam.fight.isPVE();
/*      */   }
/*      */   
/*      */   public Set<Integer> releaseUniqBuff(FighterBuff paramFighterBuff, int paramInt) {
/* 5272 */     HashSet localHashSet = new HashSet();
/* 5273 */     if (this.xFighter.getTargetstatusbuffs().containsKey(Integer.valueOf(paramFighterBuff.getEffectGroupStatus()))) {
/* 5274 */       Targets localTargets = (Targets)this.xFighter.getTargetstatusbuffs().get(Integer.valueOf(paramFighterBuff.getEffectGroupStatus()));
/* 5275 */       if (localTargets != null) {
/* 5276 */         Iterator localIterator = localTargets.getTargets().iterator();
/* 5277 */         while (localIterator.hasNext()) {
/* 5278 */           int i = ((Integer)localIterator.next()).intValue();
/* 5279 */           if (i != paramInt)
/*      */           {
/*      */ 
/* 5282 */             Fighter localFighter = getFighter(i);
/* 5283 */             if (localFighter != null) {
/* 5284 */               boolean bool = localFighter.removeBuff(paramFighterBuff.getEffectGroupStatus(), paramFighterBuff.getBuffCfgId(), true);
/* 5285 */               if (bool) {
/* 5286 */                 localHashSet.add(Integer.valueOf(i));
/*      */               }
/*      */             }
/* 5289 */             localIterator.remove();
/*      */           }
/*      */         }
/*      */       } }
/* 5293 */     return localHashSet;
/*      */   }
/*      */   
/*      */   public void addUniqBuff(int paramInt1, int paramInt2) {
/* 5297 */     if (this.xFighter.getTargetstatusbuffs().containsKey(Integer.valueOf(paramInt1))) {
/* 5298 */       ((Targets)this.xFighter.getTargetstatusbuffs().get(Integer.valueOf(paramInt1))).getTargets().add(Integer.valueOf(paramInt2));
/*      */     }
/*      */     else {
/* 5301 */       Targets localTargets = xbean.Pod.newTargets();
/* 5302 */       localTargets.getTargets().add(Integer.valueOf(paramInt2));
/* 5303 */       this.xFighter.getTargetstatusbuffs().put(Integer.valueOf(paramInt1), localTargets);
/*      */     }
/*      */   }
/*      */   
/*      */   public void addInfluenceTarget(int paramInt) {
/* 5308 */     Fighter localFighter = getFighter(paramInt);
/* 5309 */     if (localFighter == null) {
/* 5310 */       return;
/*      */     }
/* 5312 */     FighterStatus localFighterStatus = new FighterStatus();
/* 5313 */     localFighter.fillFighterStatus(localFighterStatus);
/* 5314 */     this.influenceOthers.put(Integer.valueOf(paramInt), localFighterStatus);
/*      */   }
/*      */   
/*      */   public void clearInfluenceTarget() {
/* 5318 */     this.influenceOthers.clear();
/*      */   }
/*      */   
/*      */   public Map<Integer, FighterStatus> getInfluenceMap() {
/* 5322 */     return this.influenceOthers;
/*      */   }
/*      */   
/*      */   public boolean canDodge() {
/* 5326 */     return (!isStone()) && (!isSleep()) && (!isIceCool());
/*      */   }
/*      */   
/*      */   public void exchangeHpRate(Fighter paramFighter) {
/* 5330 */     double d1 = getMaxHp();
/* 5331 */     int i = getHp();
/* 5332 */     double d2 = paramFighter.getMaxHp();
/* 5333 */     double d3 = paramFighter.getHp();
/* 5334 */     double d4 = i / d1;
/* 5335 */     double d5 = d3 / d2;
/* 5336 */     int j = (int)(d1 * d5);
/* 5337 */     setHp(j);
/* 5338 */     int k = (int)(d2 * d4);
/* 5339 */     paramFighter.setHp(k);
/*      */   }
/*      */   
/*      */   public void exchangeMpRate(Fighter paramFighter) {
/* 5343 */     double d1 = getMaxMp();
/* 5344 */     int i = getMp();
/* 5345 */     double d2 = paramFighter.getMaxMp();
/* 5346 */     int j = paramFighter.getMp();
/* 5347 */     double d3 = i / d1;
/* 5348 */     double d4 = j / d2;
/* 5349 */     int k = (int)(d1 * d4);
/* 5350 */     int m = (int)(d2 * d3);
/* 5351 */     setMp(k);
/* 5352 */     paramFighter.setMp(m);
/*      */   }
/*      */   
/*      */   public void averageHpRate(Fighter paramFighter) {
/* 5356 */     double d1 = getMaxHp();
/* 5357 */     int i = getHp();
/* 5358 */     double d2 = paramFighter.getMaxHp();
/* 5359 */     double d3 = paramFighter.getHp();
/* 5360 */     double d4 = i / d1;
/* 5361 */     double d5 = d3 / d2;
/* 5362 */     double d6 = (d5 + d4) / 2.0D;
/* 5363 */     int j = (int)(d1 * d6);
/* 5364 */     setHp(j);
/* 5365 */     int k = (int)(d2 * d6);
/* 5366 */     paramFighter.setHp(k);
/*      */   }
/*      */   
/*      */   public void averageMpRate(Fighter paramFighter) {
/* 5370 */     double d1 = getMaxMp();
/* 5371 */     int i = getMp();
/* 5372 */     double d2 = paramFighter.getMaxMp();
/* 5373 */     int j = paramFighter.getMp();
/* 5374 */     double d3 = i / d1;
/* 5375 */     double d4 = j / d2;
/* 5376 */     double d5 = (d3 + d4) / 2.0D;
/* 5377 */     int k = (int)(d1 * d5);
/* 5378 */     int m = (int)(d2 * d5);
/* 5379 */     setMp(k);
/* 5380 */     paramFighter.setMp(m);
/*      */   }
/*      */   
/*      */   public abstract boolean isMyOwner(Fighter paramFighter);
/*      */   
/*      */   public boolean carryPet() {
/* 5386 */     return false;
/*      */   }
/*      */   
/*      */   public boolean carryChild() {
/* 5390 */     return false;
/*      */   }
/*      */   
/*      */   public void addDamageToFighter(Fighter paramFighter, int paramInt) {
/* 5394 */     this.fightGroup.addDamageToFighter(paramFighter, paramInt);
/* 5395 */     int i = getDamage();
/* 5396 */     setExtra(FighterExtra.FIGHTER_DAMAGE, i + paramInt);
/*      */   }
/*      */   
/*      */   public int getDamage() {
/* 5400 */     return getExtra(FighterExtra.FIGHTER_DAMAGE);
/*      */   }
/*      */   
/*      */   protected void changeModel(int paramInt) {
/* 5404 */     setExtra(FighterExtra.CHANGE_MONSTER_MODEL, paramInt);
/*      */   }
/*      */   
/*      */   public boolean enermyHasOutFightBuff(int paramInt) {
/* 5408 */     for (Fighter localFighter : getEnermyFighters()) {
/* 5409 */       if (localFighter.hasOutFightBuff(paramInt)) {
/* 5410 */         return true;
/*      */       }
/*      */     }
/* 5413 */     return false;
/*      */   }
/*      */   
/*      */   public boolean hasOutFightBuff(int paramInt) {
/* 5417 */     return false;
/*      */   }
/*      */   
/*      */   public boolean canSummon() {
/* 5421 */     if (!isExisted()) {
/* 5422 */       return false;
/*      */     }
/* 5424 */     int i = this.fightGroup.getExtra(FightGroupExtra.Summon_pet_times);
/* 5425 */     return (i < SFightConsts.getInstance().SUMMON_TIMES) && ((!isSeal()) || (!isSealSummon())) && (!isIceCool()) && (!isSleep()) && (!isWeak()) && (!isStone()) && (!isMess()) && (!isTaunt()) && (!isFear());
/*      */   }
/*      */   
/*      */   public boolean canSummonChild() {
/* 5429 */     if (!isExisted()) {
/* 5430 */       return false;
/*      */     }
/* 5432 */     int i = this.fightGroup.getExtra(FightGroupExtra.Summon_child_times);
/* 5433 */     return (i < mzm.gsp.children.confbean.SChildrenConsts.getInstance().child_summon_max) && ((!isSeal()) || (!isSealSummon())) && (!isIceCool()) && (!isSleep()) && (!isWeak()) && (!isStone()) && (!isMess()) && (!isTaunt()) && (!isFear());
/*      */   }
/*      */   
/*      */   public boolean isRoleRowMiddlePos(int paramInt) {
/* 5437 */     return paramInt == FightManager.getRowMiddlePos(1);
/*      */   }
/*      */   
/*      */   public void afterSealed(Skill paramSkill, Fighter paramFighter) {
/* 5441 */     mzm.gsp.fight.confbean.SFightTypeCfg localSFightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(getFight().getCfgType());
/* 5442 */     if (!localSFightTypeCfg.isSealLimit) {
/* 5443 */       return;
/*      */     }
/* 5445 */     Set localSet = getFriendFighters();
/* 5446 */     HashMap localHashMap = new HashMap();
/* 5447 */     for (Object localObject1 = localSet.iterator(); ((Iterator)localObject1).hasNext();) { Fighter localFighter = (Fighter)((Iterator)localObject1).next();
/* 5448 */       if (localFighter.getid() != this.fighterid)
/*      */       {
/*      */ 
/* 5451 */         j = 0;
/* 5452 */         for (localObject2 = localFighter.getAllSealEffectBuff().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (FighterBuff)((Iterator)localObject2).next();
/* 5453 */           j += ((FighterBuff)localObject3).getLeftRound();
/*      */         }
/* 5455 */         if (j > 0)
/*      */         {
/*      */ 
/* 5458 */           localHashMap.put(localFighter, Integer.valueOf(j)); } } }
/*      */     int j;
/* 5460 */     Object localObject2; Object localObject3; if (localHashMap.size() >= SFightConsts.getInstance().SEAL_NUM_MAX) {
/* 5461 */       localObject1 = new ArrayList();
/* 5462 */       ((List)localObject1).addAll(localHashMap.entrySet());
/* 5463 */       java.util.Collections.sort((List)localObject1, new java.util.Comparator()
/*      */       {
/*      */         public int compare(Map.Entry<Fighter, Integer> paramAnonymousEntry1, Map.Entry<Fighter, Integer> paramAnonymousEntry2) {
/* 5466 */           return ((Integer)paramAnonymousEntry1.getValue()).intValue() - ((Integer)paramAnonymousEntry2.getValue()).intValue();
/*      */         }
/* 5468 */       });
/* 5469 */       int i = localHashMap.size() + 1 - SFightConsts.getInstance().SEAL_NUM_MAX; for (j = 0; j < i; j++) {
/* 5470 */         localObject2 = (Fighter)((Map.Entry)((List)localObject1).get(j)).getKey();
/* 5471 */         ((Fighter)localObject2).dispelSealBuffForce();
/* 5472 */         localObject3 = new HashSet();
/* 5473 */         ((Set)localObject3).add(Integer.valueOf(((Fighter)localObject2).fighterid));
/* 5474 */         paramSkill.addTargetInfluenceMap(this, (Set)localObject3);
/*      */       }
/* 5476 */       Play localPlay = new Play();
/* 5477 */       fillPlayTipResult(localPlay, this.fighterid, 121000033, new String[] { String.valueOf(SFightConsts.getInstance().SEAL_NUM_MAX) });
/* 5478 */       paramSkill.addPlay(localPlay, true);
/* 5479 */       paramSkill.addPlay(localPlay, false);
/* 5480 */       if (isRecordEnable()) {
/* 5481 */         paramSkill.addPlay(localPlay);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void addActionCount() {
/* 5487 */     getFight().addActionCount();
/*      */   }
/*      */   
/*      */   void installPassiveSkill(PassiveSkill paramPassiveSkill) {
/* 5491 */     if (paramPassiveSkill == null) {
/* 5492 */       return;
/*      */     }
/* 5494 */     int i = paramPassiveSkill.getLevel();
/* 5495 */     for (mzm.gsp.skill.confbean.SOutFightEffectGroup localSOutFightEffectGroup : paramPassiveSkill.getFighterEffectList()) {
/* 5496 */       FighterEffect localFighterEffect = getPassiveEffect(localSOutFightEffectGroup.effectId, localSOutFightEffectGroup.formulaList, i);
/* 5497 */       localFighterEffect.setPassiveSkill(paramPassiveSkill);
/* 5498 */       addPassiveEffect(localFighterEffect);
/*      */     }
/*      */   }
/*      */   
/*      */   public Map<Integer, Integer> getPassiveSkillsReplace() {
/* 5503 */     return this.passiveSkillsReplace;
/*      */   }
/*      */   
/*      */   protected void installPassiveSkills(java.util.Collection<PassiveSkill> paramCollection) {
/* 5507 */     Iterator localIterator = paramCollection.iterator();
/* 5508 */     Object localObject2; Object localObject3; Object localObject4; while (localIterator.hasNext()) {
/* 5509 */       localObject1 = (PassiveSkill)localIterator.next();
/* 5510 */       for (localObject2 = ((PassiveSkill)localObject1).getFighterEffectList().iterator(); ((Iterator)localObject2).hasNext();) { localObject3 = (mzm.gsp.skill.confbean.SOutFightEffectGroup)((Iterator)localObject2).next();
/* 5511 */         localObject4 = getPassiveEffect(((mzm.gsp.skill.confbean.SOutFightEffectGroup)localObject3).effectId, ((mzm.gsp.skill.confbean.SOutFightEffectGroup)localObject3).formulaList, ((PassiveSkill)localObject1).getLevel());
/* 5512 */         if ((localObject4 instanceof mzm.gsp.fight.handle.InstallPassiveSkillInit)) {
/* 5513 */           installPassiveSkill((PassiveSkill)localObject1);
/* 5514 */           localIterator.remove();
/*      */         }
/*      */       }
/*      */     }
/* 5518 */     for (Object localObject1 = paramCollection.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (PassiveSkill)((Iterator)localObject1).next();
/* 5519 */       localObject3 = localObject2;
/* 5520 */       localObject4 = (Integer)this.passiveSkillsReplace.get(Integer.valueOf(((PassiveSkill)localObject3).getPassiveSkillCfgId()));
/* 5521 */       if ((null != localObject4) && (((Integer)localObject4).intValue() != 0)) {
/* 5522 */         localObject2 = SkillInterface.getPassiveSkillById2Lv(((Integer)localObject4).intValue(), ((PassiveSkill)localObject3).getLevel());
/*      */       }
/* 5524 */       installPassiveSkill((PassiveSkill)localObject2);
/*      */     }
/*      */   }
/*      */   
/*      */   public Map<Integer, Integer> getFinalPropMap() {
/* 5529 */     HashMap localHashMap = new HashMap();
/* 5530 */     Map localMap = mzm.gsp.role.main.PropertyManager.getPro2Ret();
/* 5531 */     for (Map.Entry localEntry : localMap.entrySet()) {
/* 5532 */       int i = ((Integer)localEntry.getKey()).intValue();
/* 5533 */       int j = ((Integer)localEntry.getValue()).intValue();
/* 5534 */       int k = getFighterBaseAttr(i);
/* 5535 */       int m = getFighterBaseAttr(j);
/* 5536 */       int n = getAttrsChange(i);
/* 5537 */       int i1 = getAttrsChange(j);
/* 5538 */       int i2 = m + i1;
/* 5539 */       int i3 = 0;
/* 5540 */       if (i == 24) {
/* 5541 */         double d = 1.0D - getExtra(FighterExtra.Speed_Fluctuate_Rate) * 1.0D / FightArgs.getInstance().defaultRate;
/* 5542 */         i3 = (int)(PropertyFormula.roleFormulaFinalProperty(k, n, i2) * d);
/*      */       }
/* 5544 */       else if (i == 74) {
/* 5545 */         i3 = getEscapeRate();
/*      */       }
/*      */       else {
/* 5548 */         i3 = (int)PropertyFormula.roleFormulaFinalProperty(k, n, i2);
/*      */       }
/* 5550 */       localHashMap.put(Integer.valueOf(i), Integer.valueOf(i3));
/*      */     }
/* 5552 */     return localHashMap;
/*      */   }
/*      */   
/*      */   public int getDeathSkillCommonEffectRound() {
/* 5556 */     return this.fightGroup.fightTeam.getDeathSkillCommonEffectRound();
/*      */   }
/*      */   
/*      */   public int getNormalSkill() {
/* 5560 */     int i = getOccupation();
/* 5561 */     return FightManager.getNormalAttack(i);
/*      */   }
/*      */   
/*      */   public boolean isActive() {
/* 5565 */     return this.fightGroup.fightTeam.isActive;
/*      */   }
/*      */   
/*      */   public boolean canSeeOppsiteHpProp() {
/* 5569 */     return this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp();
/*      */   }
/*      */   
/*      */   public boolean isRecordEnable() {
/* 5573 */     return this.fightGroup.fightTeam.fight.isRecordEnable();
/*      */   }
/*      */   
/*      */   public boolean isRedName() {
/* 5577 */     int i = getExtra(FighterExtra.RED_LEVEL);
/* 5578 */     return i != 0;
/*      */   }
/*      */   
/*      */   public void setRedName() {
/* 5582 */     setExtra(FighterExtra.RED_LEVEL, 1);
/*      */   }
/*      */   
/*      */   public Fighter getPet() {
/* 5586 */     if (this.fightGroup == null) {
/* 5587 */       return null;
/*      */     }
/* 5589 */     Set localSet = this.fightGroup.getExistedFighters();
/* 5590 */     for (Fighter localFighter : localSet) {
/* 5591 */       if (localFighter.isPetType()) {
/* 5592 */         return localFighter;
/*      */       }
/*      */     }
/* 5595 */     return null;
/*      */   }
/*      */   
/*      */   public List<Integer> getDeadRounds() {
/* 5599 */     return this.xFighter.getDeadrounds();
/*      */   }
/*      */   
/*      */   public void addUseSkillCount() {
/* 5603 */     int i = getExtra(FighterExtra.USE_SKILL_COUNT);
/* 5604 */     setExtra(FighterExtra.USE_SKILL_COUNT, ++i);
/*      */   }
/*      */   
/*      */   public int getUseSkillCount() {
/* 5608 */     return getExtra(FighterExtra.USE_SKILL_COUNT);
/*      */   }
/*      */   
/*      */   public void addDeadCount() {
/* 5612 */     int i = getExtra(FighterExtra.DEAD_COUNT);
/* 5613 */     setExtra(FighterExtra.DEAD_COUNT, ++i);
/* 5614 */     this.xFighter.getDeadrounds().add(Integer.valueOf(getFight().getRound()));
/*      */   }
/*      */   
/*      */   public int getDeadCount() {
/* 5618 */     return getExtra(FighterExtra.DEAD_COUNT);
/*      */   }
/*      */   
/*      */   public void addReliveCount() {
/* 5622 */     int i = getExtra(FighterExtra.RELIVE_COUNT);
/* 5623 */     setExtra(FighterExtra.RELIVE_COUNT, ++i);
/*      */   }
/*      */   
/*      */   public int getReliveCount() {
/* 5627 */     return getExtra(FighterExtra.RELIVE_COUNT);
/*      */   }
/*      */   
/*      */   public void addMirrorFighter(int paramInt) {
/* 5631 */     setExtra(FighterExtra.MIRROR_FIGHTER, paramInt);
/*      */   }
/*      */   
/*      */   public void removeMirrorFighter() {
/* 5635 */     remExtra(FighterExtra.MIRROR_FIGHTER);
/*      */   }
/*      */   
/*      */   public Fighter getMirrorFighter() {
/* 5639 */     int i = getExtra(FighterExtra.MIRROR_FIGHTER);
/* 5640 */     if (i == 0) {
/* 5641 */       return null;
/*      */     }
/* 5643 */     return getFighterFromAll(i);
/*      */   }
/*      */   
/*      */   public void addUseProtectionCount() {
/* 5647 */     int i = getExtra(FighterExtra.USE_PROTECT_COMMOND_COUNT);
/* 5648 */     setExtra(FighterExtra.USE_PROTECT_COMMOND_COUNT, ++i);
/*      */   }
/*      */   
/*      */   public int getUseProtectionCount() {
/* 5652 */     return getExtra(FighterExtra.USE_PROTECT_COMMOND_COUNT);
/*      */   }
/*      */   
/*      */   public void addUseItemCount() {
/* 5656 */     int i = getExtra(FighterExtra.USE_ITEMS_COUNT);
/* 5657 */     setExtra(FighterExtra.USE_ITEMS_COUNT, ++i);
/*      */   }
/*      */   
/*      */   public int getUseItemCount() {
/* 5661 */     return getExtra(FighterExtra.USE_ITEMS_COUNT);
/*      */   }
/*      */   
/*      */   public SkillResult getSkillResult() {
/* 5665 */     return this.xFighter.getSkillresult();
/*      */   }
/*      */   
/*      */   public void addSkillKillCountInFight(int paramInt1, int paramInt2) {
/* 5669 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkillkillcountinfight().get(Integer.valueOf(paramInt1));
/* 5670 */     if (localInteger == null) {
/* 5671 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5673 */     this.xFighter.getSkillresult().getSkillkillcountinfight().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*      */   }
/*      */   
/*      */   public void addSkillKillCountMaxInRound(int paramInt1, int paramInt2) {
/* 5677 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkillkillcountinround().get(Integer.valueOf(paramInt1));
/* 5678 */     if (localInteger == null) {
/* 5679 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5681 */     if (localInteger.intValue() < paramInt2) {
/* 5682 */       this.xFighter.getSkillresult().getSkillkillcountinround().put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*      */     }
/*      */   }
/*      */   
/*      */   public void addSkillCriticalCountMaxInRound(int paramInt1, int paramInt2) {
/* 5687 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkillcriticalcountinround().get(Integer.valueOf(paramInt1));
/* 5688 */     if (localInteger == null) {
/* 5689 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5691 */     if (localInteger.intValue() < paramInt2) {
/* 5692 */       this.xFighter.getSkillresult().getSkillcriticalcountinround().put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*      */     }
/*      */   }
/*      */   
/*      */   public void addSkillBeDodgeCountInFight(int paramInt1, int paramInt2) {
/* 5697 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkillbedodgecountinfight().get(Integer.valueOf(paramInt1));
/* 5698 */     if (localInteger == null) {
/* 5699 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5701 */     this.xFighter.getSkillresult().getSkillbedodgecountinfight().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*      */   }
/*      */   
/*      */   public void addSkillTargetHpLeftCountInFight(int paramInt1, int paramInt2, int paramInt3) {
/* 5705 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkilltargethplesscountinfight().get(Integer.valueOf(paramInt1));
/* 5706 */     if (localInteger == null) {
/* 5707 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5709 */     this.xFighter.getSkillresult().getSkilltargethplesscountinfight().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*      */   }
/*      */   
/*      */   public void addSkillKillRebornCountInFight(int paramInt1, int paramInt2) {
/* 5713 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkillkillreborncountinfight().get(Integer.valueOf(paramInt1));
/* 5714 */     if (localInteger == null) {
/* 5715 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5717 */     this.xFighter.getSkillresult().getSkillkillreborncountinfight().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*      */   }
/*      */   
/*      */   public void addSkillKillHitMainTargetInFight(int paramInt1, int paramInt2) {
/* 5721 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkilltargetismaininfight().get(Integer.valueOf(paramInt1));
/* 5722 */     if (localInteger == null) {
/* 5723 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5725 */     this.xFighter.getSkillresult().getSkilltargetismaininfight().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*      */   }
/*      */   
/*      */   public void addKilledMonster(List<Integer> paramList, int paramInt) {
/* 5729 */     for (Iterator localIterator = paramList.iterator(); localIterator.hasNext();) { int i = ((Integer)localIterator.next()).intValue();
/* 5730 */       xbean.SkillResultKillMonsterInfo localSkillResultKillMonsterInfo = (xbean.SkillResultKillMonsterInfo)this.xFighter.getSkillresult().getKillmonster().get(Integer.valueOf(i));
/* 5731 */       if (localSkillResultKillMonsterInfo == null) {
/* 5732 */         localSkillResultKillMonsterInfo = xbean.Pod.newSkillResultKillMonsterInfo();
/* 5733 */         this.xFighter.getSkillresult().getKillmonster().put(Integer.valueOf(i), localSkillResultKillMonsterInfo);
/*      */       }
/* 5735 */       localSkillResultKillMonsterInfo.getRoundnumber().add(Integer.valueOf(paramInt));
/*      */     }
/*      */   }
/*      */   
/*      */   public void addSkillFailedCountInFight(int paramInt1, int paramInt2) {
/* 5740 */     Integer localInteger = (Integer)this.xFighter.getSkillresult().getSkillfailedcountinfight().get(Integer.valueOf(paramInt1));
/* 5741 */     if (localInteger == null) {
/* 5742 */       localInteger = Integer.valueOf(0);
/*      */     }
/* 5744 */     this.xFighter.getSkillresult().getSkillfailedcountinfight().put(Integer.valueOf(paramInt1), Integer.valueOf(localInteger.intValue() + paramInt2));
/*      */   }
/*      */   
/*      */   public int getCurrentChangeModelCardClassType() {
/* 5748 */     int i = this.xFighter.getChangemodelcard().getTmpclassindex();
/* 5749 */     if (i >= 0) {
/* 5750 */       return i;
/*      */     }
/* 5752 */     return this.xFighter.getChangemodelcard().getInitclassindex();
/*      */   }
/*      */   
/*      */   public int getCurrentChangeModelCardLevel() {
/* 5756 */     int i = this.xFighter.getChangemodelcard().getTmpclassindex();
/* 5757 */     if (i >= 0) {
/* 5758 */       return this.xFighter.getChangemodelcard().getTmplevel();
/*      */     }
/* 5760 */     return this.xFighter.getChangemodelcard().getInitlevel();
/*      */   }
/*      */   
/*      */   public void initOutFightCommon(IOutFightObject paramIOutFightObject) {
/* 5764 */     if ((null != paramIOutFightObject) && (paramIOutFightObject.getFighterState() != null)) {
/* 5765 */       int i = paramIOutFightObject.getFighterState().groupId;
/* 5766 */       int j = paramIOutFightObject.getFighterState().state;
/* 5767 */       FightState localFightState = xbean.Pod.newFightState();
/* 5768 */       localFightState.setState(j);
/* 5769 */       localFightState.setGroup(i);
/* 5770 */       this.xFighter.getFightstates().put(Integer.valueOf(i), localFightState);
/* 5771 */       this.xFighter.getDefaultfightstate().setGroup(i);
/* 5772 */       this.xFighter.getDefaultfightstate().setState(j);
/*      */     }
/* 5774 */     this.xFighter.getOutfightinfo().setGender(getGender());
/* 5775 */     this.xFighter.getOutfightinfo().setOcp(getOccupation());
/* 5776 */     this.xFighter.getOutfightinfo().getSkills().putAll(this.xFighter.getSkills());
/*      */   }
/*      */   
/*      */   public int getDefaultFightStateGroup() {
/* 5780 */     return this.xFighter.getDefaultfightstate().getGroup();
/*      */   }
/*      */   
/*      */   public int getDefaultFightState() {
/* 5784 */     return this.xFighter.getDefaultfightstate().getState();
/*      */   }
/*      */   
/*      */   public boolean hasFightState(int paramInt1, int paramInt2) {
/* 5788 */     FightState localFightState = (FightState)this.xFighter.getFightstates().get(Integer.valueOf(paramInt1));
/* 5789 */     if (localFightState == null) {
/* 5790 */       localFightState = xbean.Pod.newFightState();
/* 5791 */       return false;
/*      */     }
/* 5793 */     return localFightState.getState() == paramInt2;
/*      */   }
/*      */   
/*      */   public boolean addFightStateGroupIfGroupNotExsit(int paramInt1, int paramInt2) {
/* 5797 */     if (paramInt1 == 0) {
/* 5798 */       return false;
/*      */     }
/* 5800 */     FightState localFightState = (FightState)this.xFighter.getFightstates().get(Integer.valueOf(paramInt1));
/* 5801 */     if (localFightState == null) {
/* 5802 */       localFightState = xbean.Pod.newFightState();
/* 5803 */       localFightState.setGroup(paramInt1);
/* 5804 */       localFightState.setState(paramInt2);
/* 5805 */       this.xFighter.getFightstates().put(Integer.valueOf(paramInt1), localFightState);
/* 5806 */       return true;
/*      */     }
/* 5808 */     return false;
/*      */   }
/*      */   
/*      */   public void updateFightStateGroup(int paramInt1, int paramInt2) {
/* 5812 */     FightState localFightState = (FightState)this.xFighter.getFightstates().get(Integer.valueOf(paramInt1));
/* 5813 */     if (localFightState == null) {
/* 5814 */       localFightState = xbean.Pod.newFightState();
/* 5815 */       localFightState.setGroup(paramInt1);
/* 5816 */       localFightState.setState(paramInt2);
/* 5817 */       this.xFighter.getFightstates().put(Integer.valueOf(paramInt1), localFightState);
/*      */     }
/*      */     else {
/* 5820 */       localFightState.setState(paramInt2);
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeFightStateGroup(int paramInt) {
/* 5825 */     this.xFighter.getFightstates().remove(Integer.valueOf(paramInt));
/*      */   }
/*      */   
/*      */   public void removeAllFightState() {
/* 5829 */     this.xFighter.getFightstates().clear();
/*      */   }
/*      */   
/*      */   public FightState getFightState(int paramInt) {
/* 5833 */     FightState localFightState = (FightState)this.xFighter.getFightstates().get(Integer.valueOf(paramInt));
/* 5834 */     if (localFightState == null) {
/* 5835 */       return null;
/*      */     }
/* 5837 */     FightState localFightState1 = new FightState(localFightState.getGroup(), localFightState.getState());
/* 5838 */     return localFightState1;
/*      */   }
/*      */   
/*      */   public void addEffectTargets(int paramInt1, int paramInt2) {
/* 5842 */     Targets localTargets = (Targets)this.xFighter.getEffecttargets().get(Integer.valueOf(paramInt1));
/* 5843 */     if (localTargets == null) {
/* 5844 */       localTargets = xbean.Pod.newTargets();
/* 5845 */       this.xFighter.getEffecttargets().put(Integer.valueOf(paramInt1), localTargets);
/*      */     }
/* 5847 */     if (!localTargets.getTargets().contains(Integer.valueOf(paramInt2))) {
/* 5848 */       localTargets.getTargets().add(Integer.valueOf(paramInt2));
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeEffectTargets(int paramInt1, int paramInt2) {
/* 5853 */     Targets localTargets = (Targets)this.xFighter.getEffecttargets().get(Integer.valueOf(paramInt1));
/* 5854 */     if (localTargets == null) {
/* 5855 */       return;
/*      */     }
/* 5857 */     if (localTargets.getTargets().contains(Integer.valueOf(paramInt2))) {
/* 5858 */       localTargets.getTargets().remove(Integer.valueOf(paramInt2));
/*      */     }
/*      */   }
/*      */   
/*      */   public xbean.FighterOutFightInfo getOutFight() {
/* 5863 */     return this.xFighter.getOutfightinfo().copy();
/*      */   }
/*      */   
/*      */   public int synSkill(boolean paramBoolean) {
/* 5867 */     int i = 0;
/* 5868 */     Object localObject1; Object localObject2; if (isRole()) {
/* 5869 */       if (paramBoolean) {
/* 5870 */         i = skillRefreshSeq.incrementAndGet();
/*      */       }
/* 5872 */       localObject1 = (FighterRole)this;
/* 5873 */       localObject2 = new mzm.gsp.fight.SSynRoleSkillInfo();
/* 5874 */       ((mzm.gsp.fight.SSynRoleSkillInfo)localObject2).fight_uuid = this.fightGroup.fightTeam.getFight().fightid;
/* 5875 */       ((mzm.gsp.fight.SSynRoleSkillInfo)localObject2).skillmap.putAll(getActiveSkillMap());
/* 5876 */       ((mzm.gsp.fight.SSynRoleSkillInfo)localObject2).seq = i;
/* 5877 */       mzm.gsp.online.main.OnlineManager.getInstance().send(((FighterRole)localObject1).getRoleid(), (xio.Protocol)localObject2);
/*      */     }
/* 5879 */     else if (isPet()) {
/* 5880 */       if (paramBoolean) {
/* 5881 */         i = skillRefreshSeq.incrementAndGet();
/*      */       }
/* 5883 */       localObject1 = (FighterPet)this;
/* 5884 */       localObject2 = new mzm.gsp.fight.SSynRolePetSkillInfo();
/* 5885 */       ((mzm.gsp.fight.SSynRolePetSkillInfo)localObject2).fight_uuid = this.fightGroup.fightTeam.getFight().fightid;
/* 5886 */       ((mzm.gsp.fight.SSynRolePetSkillInfo)localObject2).petuuid = ((FighterPet)localObject1).getUuid();
/* 5887 */       ((mzm.gsp.fight.SSynRolePetSkillInfo)localObject2).skillmap.putAll(((FighterPet)localObject1).getActiveSkillMap());
/* 5888 */       ((mzm.gsp.fight.SSynRolePetSkillInfo)localObject2).seq = i;
/* 5889 */       mzm.gsp.online.main.OnlineManager.getInstance().send(((FighterPet)localObject1).getOwnerid(), (xio.Protocol)localObject2);
/*      */     }
/* 5891 */     else if (isChild()) {
/* 5892 */       if (paramBoolean) {
/* 5893 */         i = skillRefreshSeq.incrementAndGet();
/*      */       }
/* 5895 */       localObject1 = (FighterChild)this;
/* 5896 */       localObject2 = new mzm.gsp.fight.SSynRoleChildSkillInfo();
/* 5897 */       ((mzm.gsp.fight.SSynRoleChildSkillInfo)localObject2).childrenuuid = ((FighterChild)localObject1).getUuid();
/* 5898 */       ((mzm.gsp.fight.SSynRoleChildSkillInfo)localObject2).fight_uuid = this.fightGroup.fightTeam.getFight().fightid;
/* 5899 */       ((mzm.gsp.fight.SSynRoleChildSkillInfo)localObject2).skillmap.putAll(((FighterChild)localObject1).getActiveSkillMap());
/* 5900 */       ((mzm.gsp.fight.SSynRoleChildSkillInfo)localObject2).seq = i;
/* 5901 */       mzm.gsp.online.main.OnlineManager.getInstance().send(((FighterChild)localObject1).getOwnerid(), (xio.Protocol)localObject2);
/*      */     }
/* 5903 */     if (GameServer.logger().isDebugEnabled()) {
/* 5904 */       GameServer.logger().debug(String.format("[Fight]Fighter.synSkill@syn skill|code=%d|name=%s|fighterid=%d", new Object[] { Integer.valueOf(i), getName(), Integer.valueOf(getid()) }));
/*      */     }
/* 5906 */     return i;
/*      */   }
/*      */   
/*      */   public int getFightStateComplextSkillId(int paramInt, Fighter paramFighter) {
/* 5910 */     mzm.gsp.skill.confbean.SComplexSkillCfg localSComplexSkillCfg = mzm.gsp.skill.confbean.SComplexSkillCfg.get(paramInt);
/* 5911 */     int i = localSComplexSkillCfg.skillid;
/* 5912 */     mzm.gsp.skill.confbean.SFightStateComplexSkillCfg localSFightStateComplexSkillCfg = mzm.gsp.skill.confbean.SFightStateComplexSkillCfg.get(paramInt);
/* 5913 */     if (localSFightStateComplexSkillCfg == null) {
/* 5914 */       return i;
/*      */     }
/* 5916 */     for (mzm.gsp.skill.confbean.FightStateComplexSkill localFightStateComplexSkill : localSFightStateComplexSkillCfg.fightStateSkills) {
/* 5917 */       if (paramFighter.hasFightState(localFightStateComplexSkill.fightStateGroupId, localFightStateComplexSkill.fightState)) {
/* 5918 */         return localFightStateComplexSkill.skillid;
/*      */       }
/*      */     }
/* 5921 */     return i;
/*      */   }
/*      */   
/*      */   public void addRoundFighterStatusBuff(Buff paramBuff) {
/* 5925 */     getFight().addFighterStatusBuff(getid(), paramBuff);
/*      */   }
/*      */   
/*      */   public void refreshAuto() {
/* 5929 */     if ((this.fightGroup instanceof FightGroupRole)) {
/* 5930 */       FightGroupRole localFightGroupRole = (FightGroupRole)this.fightGroup;
/* 5931 */       localFightGroupRole.refreshAuto();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isPetRobot() {
/* 5936 */     return getExtra(FighterExtra.PET_ROBOT) > 0;
/*      */   }
/*      */   
/*      */ 
/* 5940 */   private static final java.util.concurrent.atomic.AtomicInteger skillRefreshSeq = new java.util.concurrent.atomic.AtomicInteger(10000);
/*      */   protected final int fighterid;
/*      */   protected final xbean.Fighter xFighter;
/*      */   protected final FightGroup fightGroup;
/*      */   protected Map<Integer, FighterStatus> influenceOthers;
/*      */   private Map<Integer, Integer> passiveSkillsReplace;
/*      */   
/*      */   public class ProtectResult {
/*      */     private int protectid;
/*      */     
/* 5950 */     public ProtectResult(int paramInt) { this.finalDamage = paramInt; }
/*      */     
/*      */     private int protectDamage;
/*      */     private int finalDamage;
/* 5954 */     void setProtectid(int paramInt) { this.protectid = paramInt; }
/*      */     
/*      */     void setProtectDamage(int paramInt)
/*      */     {
/* 5958 */       this.protectDamage = paramInt;
/*      */     }
/*      */     
/*      */     void setFinalDamage(int paramInt) {
/* 5962 */       this.finalDamage = paramInt;
/*      */     }
/*      */     
/*      */     public int getProtectid() {
/* 5966 */       return this.protectid;
/*      */     }
/*      */     
/*      */     public int getProtectDamage() {
/* 5970 */       return this.protectDamage;
/*      */     }
/*      */     
/*      */     public int getFinalDamage() {
/* 5974 */       return this.finalDamage;
/*      */     }
/*      */     
/*      */     public boolean isBeProtecetd() {
/* 5978 */       return this.protectid > 0;
/*      */     }
/*      */   }
/*      */   
/*      */   public static final class FightState
/*      */   {
/*      */     public final int fightGroup;
/*      */     public final int fightState;
/*      */     
/*      */     public FightState(int paramInt1, int paramInt2) {
/* 5988 */       this.fightGroup = paramInt1;
/* 5989 */       this.fightState = paramInt2;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Fighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */