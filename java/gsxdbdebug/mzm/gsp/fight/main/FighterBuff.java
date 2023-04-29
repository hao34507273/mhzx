/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FighterBuff
/*     */ {
/*  19 */   private int leftRound = -1;
/*     */   private FighterEffectGroup fighterEffectGroup;
/*     */   private int level;
/*  22 */   private boolean effect = false;
/*     */   
/*     */   private int releaserid;
/*     */   private Skill skill;
/*  26 */   private List<FighterEffect> effects = new ArrayList();
/*     */   
/*     */   public FighterBuff(Fighter releaser, int leftRound, FighterEffectGroup fighterEffectGroup, Skill skill) {
/*  29 */     this.releaserid = releaser.getid();
/*  30 */     this.leftRound = leftRound;
/*  31 */     this.fighterEffectGroup = fighterEffectGroup;
/*  32 */     this.level = skill.getLevel();
/*  33 */     this.skill = skill;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter) {
/*  37 */     int count = 0;
/*  38 */     for (FighterEffect effect : this.effects) {
/*  39 */       if (!effect.attach(fighter)) break;
/*  40 */       count++;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  45 */     if (count != this.effects.size()) {
/*  46 */       for (int i = 0; i < count; i++) {
/*  47 */         FighterEffect effect = (FighterEffect)this.effects.get(i);
/*  48 */         effect.detach(fighter);
/*     */       }
/*  50 */       return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public void detach(Fighter fighter) {
/*  56 */     for (FighterEffect effect : this.effects) {
/*  57 */       effect.detach(fighter);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addEffect(FighterEffect effect) {
/*  62 */     this.effects.add(effect);
/*  63 */     effect.setGroup(this);
/*     */   }
/*     */   
/*     */   public List<FighterEffect> getEffects() {
/*  67 */     return this.effects;
/*     */   }
/*     */   
/*     */   public void setLeftRound(int round) {
/*  71 */     this.leftRound = round;
/*     */   }
/*     */   
/*     */   public int getLeftRound() {
/*  75 */     return this.leftRound;
/*     */   }
/*     */   
/*     */   public int getEffectGroupType() {
/*  79 */     return this.fighterEffectGroup.getEffectGroupType();
/*     */   }
/*     */   
/*     */   public boolean getCanBeDispel() {
/*  83 */     return this.fighterEffectGroup.getEffectGroupCfg().isdispel;
/*     */   }
/*     */   
/*     */   public boolean getIsDieAway() {
/*  87 */     return this.fighterEffectGroup.getEffectGroupCfg().isdealaway;
/*     */   }
/*     */   
/*     */   public int getDamageType() {
/*  91 */     return this.fighterEffectGroup.getEffectGroupCfg().damagetype;
/*     */   }
/*     */   
/*     */   public int getEffectGroupStatus() {
/*  95 */     return this.fighterEffectGroup.getEffectGroupCfg().classType;
/*     */   }
/*     */   
/*     */   public int getMutex() {
/*  99 */     return this.fighterEffectGroup.getEffectGroupCfg().mutex;
/*     */   }
/*     */   
/*     */   public int getAdditonFormula() {
/* 103 */     return this.fighterEffectGroup.getEffectGroupCfg().additionFormula;
/*     */   }
/*     */   
/*     */   public int getBuffCfgId() {
/* 107 */     return this.fighterEffectGroup.getEffectGroupCfg().id;
/*     */   }
/*     */   
/*     */   public boolean isPositive() {
/* 111 */     return this.fighterEffectGroup.getEffectGroupCfg().effectgrouptype == 4;
/*     */   }
/*     */   
/*     */   public boolean isFromDrag() {
/* 115 */     return this.fighterEffectGroup.isFromDrag();
/*     */   }
/*     */   
/*     */   public FighterEffectGroup getFighterEffectGroup() {
/* 119 */     return this.fighterEffectGroup;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 128 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setEffect(boolean effect) {
/* 132 */     this.effect = effect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEffect()
/*     */   {
/* 141 */     return this.effect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Fighter getReleaser(Fighter fighter)
/*     */   {
/* 150 */     return fighter.getFighter(this.releaserid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getReleaserid()
/*     */   {
/* 159 */     return this.releaserid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Skill getSkill()
/*     */   {
/* 168 */     return this.skill;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */