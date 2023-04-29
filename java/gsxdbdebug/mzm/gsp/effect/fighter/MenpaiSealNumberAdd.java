/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.handle.TargetNumHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.TargetNumHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class MenpaiSealNumberAdd extends FighterEffect implements mzm.gsp.fight.handle.SealedHandle, mzm.gsp.fight.handle.TargetNumHandle
/*     */ {
/*     */   private int effectrate;
/*     */   private int number;
/*     */   private int round;
/*  21 */   private int effectRound = -1;
/*     */   
/*     */   public MenpaiSealNumberAdd(int effectrate, int number, int round) {
/*  24 */     this.effectrate = effectrate;
/*  25 */     this.number = number;
/*  26 */     this.round = round;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  31 */     fighter.addSealedHandle(this);
/*  32 */     fighter.addTargetNumHandle(this);
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  38 */     fighter.remSealedHandle(this);
/*  39 */     fighter.remTargetNumHandle(this);
/*  40 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onTargetNum(TargetNumHandle.InputObj inputObj, TargetNumHandle.OutputObj outputObj)
/*     */   {
/*  47 */     int formulaNum = inputObj.getFormulaNum();
/*  48 */     int scacleNum = inputObj.getScacleNum();
/*  49 */     int nowFinalNum = outputObj.finalTargetNum;
/*  50 */     if (nowFinalNum <= 0) {
/*  51 */       nowFinalNum = Math.min(formulaNum, scacleNum);
/*     */     }
/*  53 */     this.effectRound = -1;
/*  54 */     Fighter releaser = inputObj.getReleser();
/*  55 */     if (releaser == null) {
/*  56 */       return;
/*     */     }
/*  58 */     Skill skill = inputObj.getSkill();
/*  59 */     if (skill == null) {
/*  60 */       return;
/*     */     }
/*     */     
/*  63 */     if ((!skill.getSkillCfg().isMenPaiSkill) || (!SkillInterface.isSkillEffectType(skill.getSkillCfg().id, 2)))
/*     */     {
/*  65 */       return;
/*     */     }
/*  67 */     int curRound = releaser.getRound();
/*     */     
/*  69 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  70 */     if (random >= this.effectrate) {
/*  71 */       return;
/*     */     }
/*     */     
/*  74 */     int passiveSkillid = getPassiveSkillid();
/*  75 */     if (passiveSkillid > 0) {
/*  76 */       outputObj.passiveSkillids.add(Integer.valueOf(passiveSkillid));
/*     */     }
/*     */     
/*  79 */     if (this.number < 0) {
/*  80 */       if (nowFinalNum > 1) {
/*  81 */         this.effectRound = curRound;
/*  82 */         outputObj.finalTargetNum = Math.max(1, nowFinalNum + this.number);
/*     */       }
/*  84 */     } else if ((this.number > 0) && 
/*  85 */       (nowFinalNum < scacleNum)) {
/*  86 */       this.effectRound = curRound;
/*  87 */       outputObj.finalTargetNum = Math.min(scacleNum, nowFinalNum + this.number);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onSealed(Fighter attacker, Fighter target, FighterBuff fighterBuff) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onSealOthers(Fighter attacker, Fighter target, FighterBuff fighterBuff)
/*     */   {
/* 100 */     if (attacker != null) {
/* 101 */       int curRound = attacker.getRound();
/* 102 */       if (curRound != this.effectRound) {
/* 103 */         return;
/*     */       }
/* 105 */       if (fighterBuff != null) {
/* 106 */         int leftRound = fighterBuff.getLeftRound();
/* 107 */         leftRound = Math.max(1, leftRound + this.round);
/* 108 */         fighterBuff.setLeftRound(leftRound);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MenpaiSealNumberAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */