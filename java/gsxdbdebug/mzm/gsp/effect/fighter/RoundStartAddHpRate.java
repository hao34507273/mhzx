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
/*     */ public class RoundStartAddHpRate extends FighterEffect implements RoundStartHandle
/*     */ {
/*     */   private int roundstartaddhprate;
/*     */   private int max;
/*  25 */   private int addHpValue = 0;
/*     */   
/*     */   public RoundStartAddHpRate(int roundstartaddhprate, int max) {
/*  28 */     this.roundstartaddhprate = roundstartaddhprate;
/*  29 */     this.max = max;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  34 */     if (this.roundstartaddhprate > this.max) {
/*  35 */       this.roundstartaddhprate = this.max;
/*     */     }
/*  37 */     double baseHeal = fighter.getMaxHp() * (this.roundstartaddhprate * 1.0D / FightArgs.getInstance().getDefaultRate());
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
/*  58 */     Fighter releaser = null;
/*  59 */     Skill skill = null;
/*  60 */     FighterBuff fighterBuff = getGroup();
/*  61 */     if (fighterBuff != null) {
/*  62 */       releaser = fighterBuff.getReleaser(fighter);
/*  63 */       if (releaser != null) {
/*  64 */         releaser = fighter.getFighter(releaser.getid());
/*     */       }
/*  66 */       skill = fighterBuff.getSkill();
/*     */     }
/*  68 */     if (releaser == null) {
/*  69 */       releaser = fighter;
/*     */     }
/*  71 */     if (skill == null) {
/*  72 */       skill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, releaser.getLevel());
/*     */     }
/*     */     
/*  75 */     if (fighterBuff != null) {
/*  76 */       BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, fighter, skill, fighterBuff.getFighterEffectGroup()));
/*     */       
/*  78 */       BeforeHealHandle.OutputObj tagertOutputObj = fighter.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, fighter, skill, fighterBuff.getFighterEffectGroup()));
/*     */       
/*     */ 
/*  81 */       boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, fighter); BeforeHealHandle.OutputObj 
/*  82 */         tmp185_183 = outputObj;tmp185_183.baseHeal = ((int)(tmp185_183.baseHeal + baseHeal));
/*     */       
/*  84 */       this.addHpValue = FightFormulaHelp.calHealLast(releaser, fighter, tmp185_183, outputObj, tagertOutputObj);
/*     */     } else {
/*  86 */       this.addHpValue = ((int)baseHeal);
/*     */     }
/*     */     
/*  89 */     fighter.addRoundStartHandle(this);
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  95 */     fighter.remRoundStartHandle(this);
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   public void onRoundStart(Fighter fighter)
/*     */   {
/* 101 */     if (!fighter.isAlive()) {
/* 102 */       return;
/*     */     }
/* 104 */     int addhp = this.addHpValue;
/* 105 */     if (getGroup() != null) {
/* 106 */       if (getGroup().getEffectGroupType() == 16) {
/* 107 */         Fighter releaser = getGroup().getReleaser(fighter);
/* 108 */         BeforePoisonHandle.InputObj inputObj = new BeforePoisonHandle.InputObj(releaser, fighter, getGroup().getSkill());
/*     */         
/* 110 */         BeforePoisonHandle.OutputObj outputObj = fighter.handleonBeforePoison(inputObj);
/* 111 */         addhp = (int)(addhp * (1.0D + outputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       }
/* 113 */       Fighter releserFighter = getGroup().getReleaser(fighter);
/* 114 */       if ((releserFighter != null) && (addhp < 0)) {
/* 115 */         releserFighter.addDamageToFighter(fighter, -addhp);
/*     */       }
/*     */     }
/* 118 */     fighter.addHp(addhp);
/* 119 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 120 */     fighterStatus.hpchange += this.addHpValue;
/* 121 */     if ((fighter.isGhost()) && 
/* 122 */       (fighter.isDead())) {
/* 123 */       fighter.setFakeDead();
/*     */     }
/*     */     
/* 126 */     fighter.fillFighterStatus(fighterStatus);
/* 127 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/* 128 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new BeKilledHandle.InputObj(null, fighter, null, -addhp));
/*     */       
/* 130 */       if (fighter.isAlive()) {
/* 131 */         fighterStatus.status_set.remove(Integer.valueOf(1));
/* 132 */         fighterStatus.status_set.add(Integer.valueOf(3));
/* 133 */         FighterStatus reliveStatus = fighter.getAndAddRoundStatus();
/* 134 */         fighter.fillBuffStatus(reliveStatus);
/* 135 */         reliveStatus.hpchange += fighter.getHp();
/* 136 */         reliveStatus.status_set.add(Integer.valueOf(23));
/* 137 */         reliveStatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAddHpRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */