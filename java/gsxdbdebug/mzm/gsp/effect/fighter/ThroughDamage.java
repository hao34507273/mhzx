/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightUtil;
/*     */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*     */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThroughDamage
/*     */   extends FighterEffect
/*     */   implements OpOnce
/*     */ {
/*     */   private static final int FRONT = 1;
/*     */   private static final int AFTER = 2;
/*     */   private static final int LEFT = 4;
/*     */   private static final int RIGHT = 8;
/*     */   private int skillDamageRate;
/*     */   private int adjacentDamageRate;
/*     */   private int mask;
/*     */   
/*     */   public ThroughDamage(int skillDamageRate, int adjacentDamageRate, int mask)
/*     */   {
/*  45 */     this.skillDamageRate = skillDamageRate;
/*  46 */     this.adjacentDamageRate = adjacentDamageRate;
/*  47 */     this.mask = mask;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  53 */     int trueDamage = 0;
/*  54 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */     
/*  56 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */     
/*  58 */     outputObj.skillDamageRate += this.skillDamageRate;
/*  59 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*     */     
/*     */ 
/*  62 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/*  63 */     FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*     */     
/*  65 */     if (!damageOutputObj.isHit) {
/*  66 */       return true;
/*     */     }
/*  68 */     skill.addTarget(target.getid());
/*     */     
/*  70 */     trueDamage = (int)(damageOutputObj.damage * (this.adjacentDamageRate / FightArgs.getInstance().getDefaultRate()));
/*     */     
/*  72 */     if (trueDamage <= 0) {
/*  73 */       return true;
/*     */     }
/*     */     
/*  76 */     List<Fighter> adjacentTargets = new LinkedList();
/*  77 */     initAdjacentTargets(releaser, target, adjacentTargets);
/*     */     
/*  79 */     if (adjacentTargets.isEmpty()) {
/*  80 */       return true;
/*     */     }
/*     */     
/*  83 */     for (Fighter adjacentFighter : adjacentTargets) {
/*  84 */       adjacentFighter.addHp(releaser, -trueDamage);
/*  85 */       releaser.addDamageToFighter(adjacentFighter, -trueDamage);
/*  86 */       AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, 0, false, false, releaser, adjacentFighter);
/*     */       
/*  88 */       skill.afterTargetDamage(releaser, adjacentFighter, 0, attackResultBean, -trueDamage, false);
/*     */       
/*     */ 
/*  91 */       AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, adjacentFighter);
/*     */       
/*  93 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */       
/*     */ 
/*  96 */       skill.addTarget(adjacentFighter.getid());
/*     */     }
/*     */     
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void initAdjacentTargets(Fighter releaser, Fighter target, List<Fighter> adjacentTargets) {
/* 113 */     Map<Integer, Fighter> pos2FighterMap = target.getFriendPosToFighters();
/* 114 */     int pos = target.getPos();
/* 115 */     Set<Integer> rowPos = new HashSet();
/* 116 */     FightInterface.fillRowPos(pos, rowPos);
/* 117 */     int teamNum = TeamInterface.getTeamCapacity();
/* 118 */     if ((this.mask & 0x1) > 0) {
/* 119 */       int frontPos = pos - teamNum;
/* 120 */       Fighter frontFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(frontPos));
/* 121 */       if ((frontFighter != null) && (!frontFighter.isDead()) && (!frontFighter.isFakeDead()))
/*     */       {
/* 123 */         if ((!frontFighter.isInvisible()) || (releaser.isVisible())) {
/* 124 */           adjacentTargets.add(frontFighter);
/*     */         }
/*     */       }
/*     */     }
/* 128 */     if ((this.mask & 0x2) > 0) {
/* 129 */       int afterPos = pos + teamNum;
/* 130 */       Fighter afterFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(afterPos));
/* 131 */       if ((afterFighter != null) && (!afterFighter.isDead()) && (!afterFighter.isFakeDead()) && (
/* 132 */         (!afterFighter.isInvisible()) || (releaser.isVisible()))) {
/* 133 */         adjacentTargets.add(afterFighter);
/*     */       }
/*     */     }
/*     */     
/* 137 */     if ((this.mask & 0x4) > 0) {
/* 138 */       int leftPos = pos - 1;
/* 139 */       if (rowPos.contains(Integer.valueOf(leftPos))) {
/* 140 */         Fighter leftFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(leftPos));
/* 141 */         if ((leftFighter != null) && (!leftFighter.isDead()) && (!leftFighter.isFakeDead()) && (
/* 142 */           (!leftFighter.isInvisible()) || (releaser.isVisible()))) {
/* 143 */           adjacentTargets.add(leftFighter);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 148 */     if ((this.mask & 0x8) > 0) {
/* 149 */       int rightPos = pos + 1;
/* 150 */       if (rowPos.contains(Integer.valueOf(rightPos))) {
/* 151 */         Fighter rightFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(rightPos));
/* 152 */         if ((rightFighter != null) && (!rightFighter.isDead()) && (!rightFighter.isFakeDead()) && (
/* 153 */           (!rightFighter.isInvisible()) || (releaser.isVisible()))) {
/* 154 */           adjacentTargets.add(rightFighter);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ThroughDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */