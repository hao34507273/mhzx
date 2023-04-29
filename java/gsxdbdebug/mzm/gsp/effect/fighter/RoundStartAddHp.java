/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforePoisonHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforePoisonHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.RoundStartHandle;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ 
/*     */ public class RoundStartAddHp extends FighterEffect implements RoundStartHandle
/*     */ {
/*     */   private int roundstartaddhp;
/*  24 */   private int addHpValue = 0;
/*     */   
/*     */   public RoundStartAddHp(int roundstartaddhp) {
/*  27 */     this.roundstartaddhp = roundstartaddhp;
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
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  46 */     Fighter releaser = null;
/*  47 */     Skill skill = null;
/*  48 */     FighterBuff fighterBuff = getGroup();
/*  49 */     if (fighterBuff != null) {
/*  50 */       releaser = fighterBuff.getReleaser(fighter);
/*  51 */       if (releaser != null) {
/*  52 */         releaser = fighter.getFighter(releaser.getid());
/*     */       }
/*  54 */       skill = fighterBuff.getSkill();
/*     */     }
/*  56 */     if (releaser == null) {
/*  57 */       releaser = fighter;
/*     */     }
/*  59 */     if (skill == null) {
/*  60 */       skill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, releaser.getLevel());
/*     */     }
/*  62 */     if (fighterBuff != null) {
/*  63 */       BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, fighter, skill, fighterBuff.getFighterEffectGroup()));
/*     */       
/*  65 */       BeforeHealHandle.OutputObj tagertOutputObj = fighter.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, fighter, skill, fighterBuff.getFighterEffectGroup()));
/*     */       
/*  67 */       boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, fighter);
/*  68 */       outputObj.healFix += this.roundstartaddhp;
/*     */       
/*  70 */       this.addHpValue = FightFormulaHelp.calHealLast(releaser, fighter, iscrt, outputObj, tagertOutputObj);
/*     */     } else {
/*  72 */       this.addHpValue = this.roundstartaddhp;
/*     */     }
/*     */     
/*  75 */     fighter.addRoundStartHandle(this);
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  81 */     fighter.remRoundStartHandle(this);
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public void onRoundStart(Fighter fighter)
/*     */   {
/*  87 */     if (!fighter.isAlive()) {
/*  88 */       return;
/*     */     }
/*  90 */     int addhp = this.addHpValue;
/*  91 */     if (getGroup() != null) {
/*  92 */       if (getGroup().getEffectGroupType() == 16) {
/*  93 */         Fighter releaser = getGroup().getReleaser(fighter);
/*  94 */         BeforePoisonHandle.InputObj inputObj = new BeforePoisonHandle.InputObj(releaser, fighter, getGroup().getSkill());
/*     */         
/*  96 */         BeforePoisonHandle.OutputObj outputObj = fighter.handleonBeforePoison(inputObj);
/*  97 */         addhp = (int)(addhp * (1.0D + outputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       }
/*  99 */       Fighter releserFighter = getGroup().getReleaser(fighter);
/* 100 */       if ((releserFighter != null) && (addhp < 0)) {
/* 101 */         releserFighter.addDamageToFighter(fighter, -addhp);
/*     */       }
/*     */     }
/* 104 */     fighter.addHp(addhp);
/* 105 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 106 */     fighterStatus.hpchange += this.addHpValue;
/* 107 */     if ((fighter.isGhost()) && 
/* 108 */       (fighter.isDead())) {
/* 109 */       fighter.setFakeDead();
/*     */     }
/*     */     
/* 112 */     fighter.fillFighterStatus(fighterStatus);
/* 113 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 114 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new BeKilledHandle.InputObj(null, fighter, null, -addhp));
/*     */       
/* 116 */       if (fighter.isAlive()) {
/* 117 */         fighterStatus.status_set.remove(Integer.valueOf(1));
/* 118 */         fighterStatus.status_set.add(Integer.valueOf(3));
/* 119 */         FighterStatus reliveStatus = fighter.getAndAddRoundStatus();
/* 120 */         fighter.fillBuffStatus(reliveStatus);
/* 121 */         reliveStatus.hpchange += fighter.getHp();
/* 122 */         reliveStatus.status_set.add(Integer.valueOf(23));
/* 123 */         reliveStatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAddHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */