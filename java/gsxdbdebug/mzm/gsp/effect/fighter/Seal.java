/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import mzm.gsp.effect.fighter.Interface.SealType;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.handle.BeforeSealHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeSealHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class Seal
/*     */   extends FighterEffect implements SealType
/*     */ {
/*     */   private int sealtype;
/*     */   private int seallevel;
/*     */   private int sealrate;
/*  19 */   private boolean isSeal = false;
/*     */   
/*  21 */   private final int SKILL_NORMAL_MASK = 1;
/*  22 */   private final int SKILL_PHY_MASK = 2;
/*  23 */   private final int SKILL_MAG_MASK = 4;
/*  24 */   private final int SKILL_SPECIAL_MASK = 8;
/*  25 */   private final int USE_ITEM_MASK = 16;
/*  26 */   private final int RUN_AWAY_MASK = 32;
/*  27 */   private final int SUMMON_MASK = 64;
/*  28 */   private final int SKILL_DEFENCE_MASK = 128;
/*  29 */   private final int PROTECT_MASK = 256;
/*  30 */   private final int SKILL_OTHER = 512;
/*     */   
/*     */   public Seal(int sealtype, int seallevel, int sealrate) {
/*  33 */     this.sealtype = sealtype;
/*  34 */     this.seallevel = seallevel;
/*  35 */     this.sealrate = sealrate;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  41 */     if (getGroup() == null) {
/*  42 */       this.isSeal = false;
/*  43 */       return true;
/*     */     }
/*  45 */     Fighter releaser = getGroup().getReleaser(fighter);
/*  46 */     if (releaser == null) {
/*  47 */       this.isSeal = false;
/*  48 */       return true;
/*     */     }
/*     */     
/*  51 */     BeforeSealHandle.OutputObj out = releaser.handleBeforeSeal(new BeforeSealHandle.InputObj(releaser, fighter, getGroup().getSkill()));
/*     */     
/*  53 */     int rate = out.sealRate + this.sealrate;
/*  54 */     this.isSeal = FightFormulaHelp.isSealHit(releaser, fighter, this.seallevel, rate);
/*  55 */     if (this.isSeal) {
/*  56 */       fighter.addBuffState(104);
/*  57 */       if (fighter.isCmdedInRound()) {
/*  58 */         int leftRound = getGroup().getLeftRound();
/*  59 */         getGroup().setLeftRound(leftRound + SFightConsts.getInstance().SEAL_ACTIONED_ADD_LAST_ROUND);
/*     */       }
/*  61 */       fighter.handleOnSealed(releaser, getGroup());
/*  62 */       if (releaser != null) {
/*  63 */         releaser.handleOnSealOthers(fighter, getGroup());
/*     */       }
/*     */     } else {
/*  66 */       Skill skill = getGroup().getSkill();
/*  67 */       if (skill != null) {
/*  68 */         skill.addNotSealRet(releaser, fighter);
/*     */       }
/*     */     }
/*     */     
/*  72 */     return this.isSeal;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  77 */     if (this.isSeal) {
/*  78 */       fighter.remBuffState(104);
/*     */     }
/*  80 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealNormalSKill()
/*     */   {
/*  89 */     return (this.isSeal) && ((this.sealtype & 0x1) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealPHYSkill()
/*     */   {
/*  98 */     return (this.isSeal) && ((this.sealtype & 0x2) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealMAGSkill()
/*     */   {
/* 107 */     return (this.isSeal) && ((this.sealtype & 0x4) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealSpecialSkill()
/*     */   {
/* 116 */     return (this.isSeal) && ((this.sealtype & 0x8) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealUseItem()
/*     */   {
/* 125 */     return (this.isSeal) && ((this.sealtype & 0x10) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealRunAway()
/*     */   {
/* 134 */     return (this.isSeal) && ((this.sealtype & 0x20) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealSummon()
/*     */   {
/* 143 */     return (this.isSeal) && ((this.sealtype & 0x40) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealDefenceSkill()
/*     */   {
/* 152 */     return (this.isSeal) && ((this.sealtype & 0x80) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealProtect()
/*     */   {
/* 161 */     return (this.isSeal) && ((this.sealtype & 0x100) > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSealOther()
/*     */   {
/* 170 */     return (this.isSeal) && ((this.sealtype & 0x200) > 0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Seal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */