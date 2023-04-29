/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.TeamEffect;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class CumulativeIncrease
/*     */   extends FighterEffect implements TeamEffect
/*     */ {
/*     */   private int type;
/*     */   private int mask;
/*     */   private int value;
/*     */   private static final int HP_MAX = 1;
/*     */   private static final int PHY_ATK = 2;
/*     */   private static final int MAG_ATK = 4;
/*     */   private static final int PHY_DEF = 8;
/*     */   private static final int MAG_DEF = 16;
/*     */   private static final int SPEED = 32;
/*     */   private static final int SEAL_RESIST = 64;
/*     */   
/*     */   public CumulativeIncrease(int type, int mask, int value)
/*     */   {
/*  27 */     this.type = type;
/*  28 */     this.mask = mask;
/*  29 */     this.value = value;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  34 */     if (((this.mask & fighter.getType()) > 0) && 
/*  35 */       ((fighter.getType() & this.mask) > 0)) {
/*  36 */       if ((this.type & 0x1) > 0) {
/*  37 */         fighter.addMaxFixHp(this.value);
/*  38 */         if (getGroup() != null) {
/*  39 */           Skill skill = getGroup().getSkill();
/*  40 */           if (skill != null) {
/*  41 */             skill.updateBuffHp(fighter);
/*     */           }
/*     */         }
/*     */       }
/*  45 */       if ((this.type & 0x2) > 0) {
/*  46 */         fighter.addPHYATK(this.value);
/*     */       }
/*  48 */       if ((this.type & 0x4) > 0) {
/*  49 */         fighter.addMAGATK(this.value);
/*     */       }
/*  51 */       if ((this.type & 0x8) > 0) {
/*  52 */         fighter.addPHYDEF(this.value);
/*     */       }
/*  54 */       if ((this.type & 0x10) > 0) {
/*  55 */         fighter.addMAGDEF(this.value);
/*     */       }
/*  57 */       if ((this.type & 0x20) > 0) {
/*  58 */         fighter.addSpeed(this.value);
/*  59 */         if (GameServer.logger().isDebugEnabled()) {
/*     */           try
/*     */           {
/*  62 */             if (fighter.isRole()) {
/*  63 */               int effectGroupId = 0;
/*  64 */               FighterBuff fighterBuff = getGroup();
/*  65 */               if (fighterBuff != null) {
/*  66 */                 effectGroupId = fighterBuff.getBuffCfgId();
/*     */               }
/*  68 */               GameServer.logger().debug(String.format("[FightSpeedLogDump]CumulativeIncrease attach addSpeed|name=%s|value=%d|round=%d|effectGroupId=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(this.value), Integer.valueOf(fighter.getRound()), Integer.valueOf(effectGroupId), Long.valueOf(fighter.getFightUuid()) }));
/*     */             }
/*     */           }
/*     */           catch (Exception e) {}
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  79 */       if ((this.type & 0x40) > 0) {
/*  80 */         fighter.addSealResist(this.value);
/*     */       }
/*     */     }
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  89 */     if (((this.mask & fighter.getType()) > 0) && 
/*  90 */       ((fighter.getType() & this.mask) > 0)) {
/*  91 */       if ((this.type & 0x1) > 0) {
/*  92 */         fighter.addMaxFixHp(-this.value);
/*     */       }
/*  94 */       if ((this.type & 0x2) > 0) {
/*  95 */         fighter.addPHYATK(-this.value);
/*     */       }
/*  97 */       if ((this.type & 0x4) > 0) {
/*  98 */         fighter.addMAGATK(-this.value);
/*     */       }
/* 100 */       if ((this.type & 0x8) > 0) {
/* 101 */         fighter.addPHYDEF(-this.value);
/*     */       }
/* 103 */       if ((this.type & 0x10) > 0) {
/* 104 */         fighter.addMAGDEF(-this.value);
/*     */       }
/* 106 */       if ((this.type & 0x20) > 0) {
/* 107 */         fighter.addSpeed(-this.value);
/* 108 */         if (GameServer.logger().isDebugEnabled()) {
/*     */           try {
/* 110 */             if (fighter.isRole()) {
/* 111 */               int effectGroupId = 0;
/* 112 */               FighterBuff fighterBuff = getGroup();
/* 113 */               if (fighterBuff != null) {
/* 114 */                 effectGroupId = fighterBuff.getBuffCfgId();
/*     */               }
/* 116 */               GameServer.logger().debug(String.format("[FightSpeedLogDump]CumulativeIncrease detach addSpeed|name=%s|value=%d|round=%d|effectGroupId=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(-this.value), Integer.valueOf(fighter.getRound()), Integer.valueOf(effectGroupId), Long.valueOf(fighter.getFightUuid()) }));
/*     */             }
/*     */           }
/*     */           catch (Exception e) {}
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */       if ((this.type & 0x40) > 0) {
/* 129 */         fighter.addSealResist(-this.value);
/*     */       }
/*     */     }
/*     */     
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\CumulativeIncrease.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */