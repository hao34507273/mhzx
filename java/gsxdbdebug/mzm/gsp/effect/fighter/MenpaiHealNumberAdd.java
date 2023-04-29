/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mzm.gsp.fight.handle.BeforeHealHandle;
/*     */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.TargetNumHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.TargetNumHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ 
/*     */ public class MenpaiHealNumberAdd extends mzm.gsp.effect.main.FighterEffect implements BeforeHealHandle, mzm.gsp.fight.handle.TargetNumHandle
/*     */ {
/*     */   private int effectrate;
/*     */   private int number;
/*     */   private int exhealrate;
/*  20 */   private int effectRound = -1;
/*     */   
/*     */   public MenpaiHealNumberAdd(int effectrate, int number, int exhealrate) {
/*  23 */     this.effectrate = effectrate;
/*  24 */     this.number = number;
/*  25 */     this.exhealrate = exhealrate;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  30 */     fighter.addBeforeHealHandle(this);
/*  31 */     fighter.addTargetNumHandle(this);
/*  32 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  37 */     fighter.remBeforeHealHandle(this);
/*  38 */     fighter.remTargetNumHandle(this);
/*  39 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void handleBeforeHeal(BeforeHealHandle.InputObj inputObj, BeforeHealHandle.OutputObj outputObj)
/*     */   {
/*  45 */     Skill skill = inputObj.getSkill();
/*  46 */     if (skill == null) {
/*  47 */       return;
/*     */     }
/*  49 */     Fighter releaser = inputObj.getReleser();
/*  50 */     Fighter target = inputObj.getTarget();
/*  51 */     if ((releaser == null) || (target == null)) {
/*  52 */       return;
/*     */     }
/*  54 */     if (!skill.getSkillCfg().isMenPaiSkill) {
/*  55 */       return;
/*     */     }
/*  57 */     int curRound = releaser.getRound();
/*  58 */     if (curRound != this.effectRound) {
/*  59 */       return;
/*     */     }
/*  61 */     outputObj.healeffectrate += this.exhealrate;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onTargetNum(TargetNumHandle.InputObj inputObj, TargetNumHandle.OutputObj outputObj)
/*     */   {
/*  67 */     int formulaNum = inputObj.getFormulaNum();
/*  68 */     int scacleNum = inputObj.getScacleNum();
/*  69 */     int nowFinalNum = outputObj.finalTargetNum;
/*  70 */     if (nowFinalNum <= 0) {
/*  71 */       nowFinalNum = Math.min(formulaNum, scacleNum);
/*     */     }
/*  73 */     this.effectRound = -1;
/*  74 */     Fighter releaser = inputObj.getReleser();
/*  75 */     if (releaser == null) {
/*  76 */       return;
/*     */     }
/*  78 */     Skill skill = inputObj.getSkill();
/*  79 */     if (skill == null) {
/*  80 */       return;
/*     */     }
/*  82 */     if ((!skill.getSkillCfg().isMenPaiSkill) || (!SkillInterface.isSkillEffectType(skill.getSkillCfg().id, 7)))
/*     */     {
/*  84 */       return;
/*     */     }
/*  86 */     int curRound = releaser.getRound();
/*     */     
/*     */ 
/*  89 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  90 */     if (random >= this.effectrate) {
/*  91 */       return;
/*     */     }
/*     */     
/*  94 */     int passiveSkillid = getPassiveSkillid();
/*  95 */     if (passiveSkillid > 0) {
/*  96 */       outputObj.passiveSkillids.add(Integer.valueOf(passiveSkillid));
/*     */     }
/*     */     
/*  99 */     if (this.number < 0) {
/* 100 */       if (nowFinalNum > 1) {
/* 101 */         this.effectRound = curRound;
/* 102 */         outputObj.finalTargetNum = Math.max(1, nowFinalNum + this.number);
/*     */       }
/* 104 */     } else if ((this.number > 0) && 
/* 105 */       (nowFinalNum < scacleNum)) {
/* 106 */       this.effectRound = curRound;
/* 107 */       outputObj.finalTargetNum = Math.min(scacleNum, nowFinalNum + this.number);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MenpaiHealNumberAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */