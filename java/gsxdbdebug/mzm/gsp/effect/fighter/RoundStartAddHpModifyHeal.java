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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoundStartAddHpModifyHeal
/*     */   extends FighterEffect
/*     */   implements RoundStartHandle
/*     */ {
/*     */   private int roundstartaddhprate;
/*     */   private int max;
/*     */   private int exheal;
/*  32 */   private int addHpValue = 0;
/*     */   
/*     */   public RoundStartAddHpModifyHeal(int roundstartaddhprate, int max, int exheal) {
/*  35 */     this.roundstartaddhprate = roundstartaddhprate;
/*  36 */     this.max = max;
/*  37 */     this.exheal = exheal;
/*     */   }
/*     */   
/*     */   public void onRoundStart(Fighter fighter)
/*     */   {
/*  42 */     if (!fighter.isAlive()) {
/*  43 */       return;
/*     */     }
/*  45 */     int addhp = this.addHpValue;
/*  46 */     if (getGroup() != null) {
/*  47 */       if (getGroup().getEffectGroupType() == 16) {
/*  48 */         Fighter releaser = getGroup().getReleaser(fighter);
/*  49 */         BeforePoisonHandle.InputObj inputObj = new BeforePoisonHandle.InputObj(releaser, fighter, getGroup().getSkill());
/*     */         
/*  51 */         BeforePoisonHandle.OutputObj outputObj = fighter.handleonBeforePoison(inputObj);
/*  52 */         addhp = (int)(addhp * (1.0D + outputObj.expoisonrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       }
/*  54 */       Fighter releserFighter = getGroup().getReleaser(fighter);
/*  55 */       if ((releserFighter != null) && (addhp < 0)) {
/*  56 */         releserFighter.addDamageToFighter(fighter, -addhp);
/*     */       }
/*     */     }
/*  59 */     fighter.addHp(addhp);
/*  60 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  61 */     fighterStatus.hpchange += this.addHpValue;
/*  62 */     if ((fighter.isGhost()) && 
/*  63 */       (fighter.isDead())) {
/*  64 */       fighter.setFakeDead();
/*     */     }
/*     */     
/*  67 */     fighter.fillFighterStatus(fighterStatus);
/*  68 */     if ((fighter.isDead()) || (fighter.isFakeDead())) {
/*  69 */       BeKilledHandle.OutPutObj outPutObj = fighter.handleBeKilled(new BeKilledHandle.InputObj(null, fighter, null, -addhp));
/*     */       
/*  71 */       if (fighter.isAlive()) {
/*  72 */         fighterStatus.status_set.remove(Integer.valueOf(1));
/*  73 */         fighterStatus.status_set.add(Integer.valueOf(3));
/*  74 */         FighterStatus reliveStatus = fighter.getAndAddRoundStatus();
/*  75 */         fighter.fillBuffStatus(reliveStatus);
/*  76 */         reliveStatus.hpchange += fighter.getHp();
/*  77 */         reliveStatus.status_set.add(Integer.valueOf(23));
/*  78 */         reliveStatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  85 */     if (this.roundstartaddhprate > this.max) {
/*  86 */       this.roundstartaddhprate = this.max;
/*     */     }
/*  88 */     double baseHeal = fighter.getMaxHp() * (this.roundstartaddhprate * 1.0D / FightArgs.getInstance().getDefaultRate());
/*     */     
/*  90 */     Fighter releaser = null;
/*  91 */     Skill skill = null;
/*  92 */     FighterBuff fighterBuff = getGroup();
/*  93 */     if (fighterBuff != null) {
/*  94 */       releaser = fighterBuff.getReleaser(fighter);
/*  95 */       if (releaser != null) {
/*  96 */         releaser = fighter.getFighter(releaser.getid());
/*     */       }
/*  98 */       skill = fighterBuff.getSkill();
/*     */     }
/* 100 */     if (releaser == null) {
/* 101 */       releaser = fighter;
/*     */     }
/* 103 */     if (skill == null) {
/* 104 */       skill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, releaser.getLevel());
/*     */     }
/*     */     
/* 107 */     if (fighterBuff != null) {
/* 108 */       BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, fighter, skill, fighterBuff.getFighterEffectGroup()));
/*     */       
/* 110 */       BeforeHealHandle.OutputObj tagertOutputObj = fighter.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, fighter, skill, fighterBuff.getFighterEffectGroup()));
/*     */       
/*     */ 
/* 113 */       boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, fighter); BeforeHealHandle.OutputObj 
/* 114 */         tmp185_183 = outputObj;tmp185_183.baseHeal = ((int)(tmp185_183.baseHeal + baseHeal));
/* 115 */       outputObj.modifyParam += this.exheal;
/* 116 */       this.addHpValue = FightFormulaHelp.calHealLast(releaser, fighter, tmp185_183, outputObj, tagertOutputObj);
/*     */     } else {
/* 118 */       this.addHpValue = ((int)baseHeal);
/*     */     }
/*     */     
/* 121 */     fighter.addRoundStartHandle(this);
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 127 */     fighter.remRoundStartHandle(this);
/* 128 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAddHpModifyHeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */