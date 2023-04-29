/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class BeHitDebuff extends FighterEffect implements BeforeAttackHandle, Validate
/*     */ {
/*     */   private int hitdebuffrate;
/*     */   private int debuffid;
/*     */   private int mask;
/*     */   private int attmask;
/*  24 */   private final int NORMAL_SKILL = 1;
/*  25 */   private final int PHY_SKILL = 2;
/*  26 */   private final int MAG_SKILL = 4;
/*     */   private static final int ATTACK = 1;
/*     */   private static final int TARGET = 2;
/*     */   
/*     */   public BeHitDebuff(int hitdebuffrate, int debuffid, int mask, int attmask)
/*     */   {
/*  32 */     this.hitdebuffrate = hitdebuffrate;
/*  33 */     this.debuffid = debuffid;
/*  34 */     this.mask = mask;
/*  35 */     this.attmask = attmask;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  40 */     fighter.addBeforeAttackHandle(this);
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  46 */     fighter.remBeforeAttackHandle(this);
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*     */   {
/*  52 */     if (!inputObj.isTargetOwn()) {
/*  53 */       return;
/*     */     }
/*  55 */     Fighter releaser = inputObj.getReleser();
/*  56 */     if (releaser == null) {
/*  57 */       return;
/*     */     }
/*  59 */     Fighter targetFighter = inputObj.getTarget();
/*  60 */     if (targetFighter == null) {
/*  61 */       return;
/*     */     }
/*  63 */     Skill skill = inputObj.getSkill();
/*  64 */     if (skill == null) {
/*  65 */       return;
/*     */     }
/*  67 */     boolean trigger = false;
/*  68 */     int skillid = skill.getID();
/*  69 */     if (FightInterface.isNormalAttackSkill(skillid)) {
/*  70 */       if ((this.attmask & 0x1) > 0) {
/*  71 */         trigger = true;
/*     */       }
/*     */     } else {
/*  74 */       int skillType = skill.getType();
/*  75 */       if (skillType == 2) {
/*  76 */         if ((this.attmask & 0x4) > 0) {
/*  77 */           trigger = true;
/*     */         }
/*  79 */       } else if ((skillType == 1) && 
/*  80 */         ((this.attmask & 0x2) > 0)) {
/*  81 */         trigger = true;
/*     */       }
/*     */     }
/*     */     
/*  85 */     if (!trigger) {
/*  86 */       return;
/*     */     }
/*  88 */     int randomRate = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  89 */     if (this.hitdebuffrate > randomRate) {
/*  90 */       if ((this.mask & 0x1) > 0) {
/*  91 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.debuffid);
/*  92 */         if (addGroup != null) {
/*  93 */           int level = super.getSkillLevel();
/*  94 */           addGroup.run(level, releaser, releaser, releaser.getid());
/*     */         }
/*     */       }
/*  97 */       if ((this.mask & 0x2) > 0) {
/*  98 */         FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.debuffid);
/*  99 */         if (addGroup != null) {
/* 100 */           int level = super.getSkillLevel();
/* 101 */           addGroup.run(level, targetFighter, targetFighter, targetFighter.getid());
/*     */         }
/*     */       }
/* 104 */       int triggerSkillid = getPassiveSkillid();
/* 105 */       if (triggerSkillid > 0) {
/* 106 */         outputObj.targetPassiveSkillids.add(Integer.valueOf(triggerSkillid));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 113 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.debuffid);
/* 114 */     if (effectGroup == null) {
/* 115 */       throw new RuntimeException("BeHitDebuff中配置的效果组id不存在:效果组id" + this.debuffid);
/*     */     }
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BeHitDebuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */