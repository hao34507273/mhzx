/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.DisperseType;
/*     */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class Disperse
/*     */   extends FighterEffect
/*     */   implements OpOnce, DisperseType, Validate
/*     */ {
/*     */   private int type;
/*     */   private int effectgroupnum;
/*     */   private int buffid;
/*  23 */   private final int POSITIVE = 1;
/*  24 */   private final int NEGATIVE = 2;
/*  25 */   private final int SEAL = 4;
/*  26 */   private final int POISON = 8;
/*     */   
/*     */   public Disperse(int type, int effectgroupnum, int buffid) {
/*  29 */     this.type = type;
/*  30 */     this.effectgroupnum = effectgroupnum;
/*  31 */     this.buffid = buffid;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  41 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  47 */     int disperseCount = 0;
/*  48 */     if ((this.type & 0x4) > 0) {
/*  49 */       if (this.effectgroupnum == 0) {
/*  50 */         disperseCount += target.dispelSealBuff();
/*     */       } else {
/*  52 */         disperseCount += target.dispelSealBuff(this.effectgroupnum);
/*     */       }
/*  54 */       if (isDisperseEnough(disperseCount)) {
/*  55 */         return true;
/*     */       }
/*     */     }
/*  58 */     if ((this.type & 0x2) > 0) {
/*  59 */       if (this.effectgroupnum == 0) {
/*  60 */         disperseCount += target.dispelNegativeBuff();
/*     */       } else {
/*  62 */         disperseCount += target.dispelNegativeBuff(this.effectgroupnum);
/*     */       }
/*  64 */       if (isDisperseEnough(disperseCount)) {
/*  65 */         return true;
/*     */       }
/*     */     }
/*  68 */     if ((this.type & 0x8) > 0) {
/*  69 */       if (this.effectgroupnum == 0) {
/*  70 */         disperseCount += target.dispelPoisonBuff();
/*     */       } else {
/*  72 */         disperseCount += target.dispelPoisonBuff(this.effectgroupnum);
/*     */       }
/*  74 */       if (isDisperseEnough(disperseCount)) {
/*  75 */         return true;
/*     */       }
/*     */     }
/*  78 */     if ((this.type & 0x1) > 0) {
/*  79 */       if (this.effectgroupnum == 0) {
/*  80 */         disperseCount += target.dispelPositiveBuff();
/*     */       } else {
/*  82 */         disperseCount += target.dispelPositiveBuff(this.effectgroupnum);
/*     */       }
/*  84 */       if (isDisperseEnough(disperseCount)) {
/*  85 */         return true;
/*     */       }
/*     */     }
/*  88 */     if ((disperseCount <= 0) && (this.buffid > 0))
/*     */     {
/*  90 */       FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.buffid);
/*  91 */       if (addGroup != null) {
/*  92 */         addGroup.run(skill, releaser, target, target.getid());
/*     */       } else {
/*  94 */         GameServer.logger().error("不存在的效果组id" + this.buffid);
/*     */       }
/*     */     }
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isDisperseEnough(int disperseCount) {
/* 101 */     if ((disperseCount >= this.effectgroupnum) && (this.effectgroupnum > 0)) {
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public Set<Integer> getDisperseTypes()
/*     */   {
/* 109 */     Set<Integer> disperseTypes = new HashSet();
/* 110 */     if ((this.type & 0x4) > 0) {
/* 111 */       disperseTypes.add(Integer.valueOf(5));
/*     */     }
/* 113 */     if ((this.type & 0x1) > 0) {
/* 114 */       disperseTypes.add(Integer.valueOf(3));
/*     */     }
/* 116 */     if ((this.type & 0x2) > 0) {
/* 117 */       disperseTypes.add(Integer.valueOf(4));
/*     */     }
/* 119 */     if ((this.type & 0x8) > 0) {
/* 120 */       disperseTypes.add(Integer.valueOf(6));
/*     */     }
/* 122 */     return disperseTypes;
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 127 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.buffid);
/* 128 */     if ((this.buffid > 0) && (effectGroup == null)) {
/* 129 */       throw new RuntimeException("Disperse中配置的效果组id不存在:效果组id" + this.buffid);
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Disperse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */