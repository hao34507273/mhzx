/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
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
/*     */ public class FightFormulaHelp
/*     */ {
/*     */   public static int getAnger(int lostHp, double maxHp)
/*     */   {
/*  29 */     double lostHpRate = lostHp / maxHp * FightArgs.getInstance().defaultRate;
/*  30 */     return FightConfigManager.getInstance().getAddAnger(lostHpRate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isFightBack(int fightBackRate)
/*     */   {
/*  41 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  42 */     return fightBackRate > random;
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
/*     */   public static boolean isPhyHit(Fighter attacker, Fighter defenser, int extraHit)
/*     */   {
/*  55 */     if (!defenser.canDodge()) {
/*  56 */       return true;
/*     */     }
/*  58 */     int phyHitLevel = attacker.getPHYHITLevel();
/*  59 */     double fenMu = phyHitLevel + defenser.getPHYDODGELevel() * SFightConsts.getInstance().E;
/*  60 */     if (fenMu <= 0.0D) {
/*  61 */       if (Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate()) > FightArgs.getInstance().getDefaultRate() / 2)
/*     */       {
/*  63 */         return false;
/*     */       }
/*  65 */       return true;
/*     */     }
/*  67 */     double hit = Math.max(phyHitLevel / fenMu * FightArgs.getInstance().getDefaultRate(), SFightConsts.getInstance().U) + attacker.getPHYATKHITRate() + defenser.getBEPHYATKHITRate();
/*     */     
/*     */ 
/*  70 */     return hit > Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
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
/*     */   public static boolean isMagHit(Fighter attacker, Fighter defenser, int extraHit)
/*     */   {
/*  83 */     if (!defenser.canDodge()) {
/*  84 */       return true;
/*     */     }
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
/* 101 */     double hit = attacker.getMAGHITRate() + defenser.getBEMAGHITRate() + FightArgs.getInstance().getDefaultRate();
/* 102 */     return hit > Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isSealHit0(Fighter attacker, Fighter defenser, int extraHitRate)
/*     */   {
/* 114 */     int negetiveLevel = attacker.getSealHit();
/* 115 */     double fenmu = negetiveLevel * SFightConsts.getInstance().G1 + defenser.getSealResist() * SFightConsts.getInstance().G2;
/*     */     
/* 117 */     if (fenmu <= 0.0D) {
/* 118 */       return true;
/*     */     }
/* 120 */     double hit = Math.min(negetiveLevel / fenmu * FightArgs.getInstance().getDefaultRate(), SFightConsts.getInstance().T) + attacker.getSealHitRate() + defenser.getBeSealHitRate();
/*     */     
/*     */ 
/* 123 */     return hit + extraHitRate > Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
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
/*     */   public static boolean isSealHit(Fighter attacker, Fighter defenser, int extraHitLevel, int extraRate)
/*     */   {
/* 136 */     int negetiveLevel = attacker.getSealHit() + extraHitLevel;
/* 137 */     double fenmu = negetiveLevel * SFightConsts.getInstance().G1 + defenser.getSealResist() * SFightConsts.getInstance().G2;
/*     */     
/* 139 */     if (fenmu <= 0.0D) {
/* 140 */       return true;
/*     */     }
/* 142 */     double hit = Math.min(negetiveLevel / fenmu * FightArgs.getInstance().getDefaultRate(), SFightConsts.getInstance().T) + attacker.getSealHitRate() + defenser.getBeSealHitRate() + extraRate;
/*     */     
/*     */ 
/* 145 */     return hit > Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
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
/*     */   public static boolean isPHyCrt(Fighter releser, Fighter target, BeforeAttackHandle.OutputObj attackOutputObj, BeforeAttackHandle.OutputObj targetOutputObj)
/*     */   {
/* 158 */     if (target.isFortune()) {
/* 159 */       return false;
/*     */     }
/* 161 */     double calCrtRate = calCrtRate(releser.getPHYCRTLevel(), target.getPHYCRTDEFLevel(), releser.getLevel());
/* 162 */     double finalCrtRate = releser.getPHYCRTRate() + calCrtRate + attackOutputObj.excriticalrate + targetOutputObj.bePhyCrtRate;
/*     */     
/* 164 */     return isCrt(Math.min(finalCrtRate, SFightConsts.getInstance().S));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double calCrtRate(int attackerCrtLv, int targetDefLv, int releserLv)
/*     */   {
/* 176 */     double crtRate = attackerCrtLv * 1.0D / (attackerCrtLv + targetDefLv * SFightConsts.getInstance().K + releserLv * SFightConsts.getInstance().L + SFightConsts.getInstance().M) * SFightConsts.getInstance().N;
/*     */     
/*     */ 
/*     */ 
/* 180 */     return crtRate * FightArgs.getInstance().getDefaultRate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isHealCrt(double crtRate, Fighter releser, Fighter target)
/*     */   {
/* 192 */     double calCrtRate = calHealCrtRate(releser.getMAGCRTLevel(), releser.getLevel());
/*     */     
/* 194 */     return isCrt(Math.min(crtRate + calCrtRate, SFightConsts.getInstance().S));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double calHealCrtRate(int attackMagCrtLv, int realeserLv)
/*     */   {
/* 203 */     double rate = attackMagCrtLv * 1.0D / (attackMagCrtLv + realeserLv * SFightConsts.getInstance().O + SFightConsts.getInstance().P) * SFightConsts.getInstance().N;
/*     */     
/*     */ 
/* 206 */     return rate * FightArgs.getInstance().getDefaultRate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMagCrt(Fighter releser, Fighter target, BeforeAttackHandle.OutputObj attackOutputObj, BeforeAttackHandle.OutputObj targetOutputObj)
/*     */   {
/* 217 */     if (target.isFortune()) {
/* 218 */       return false;
/*     */     }
/* 220 */     double calRate = calCrtRate(releser.getMAGCRTLevel(), target.getMAGCRTDEFLevel(), releser.getLevel());
/* 221 */     double finalCrtRate = releser.getMAGCRTRate() + calRate + attackOutputObj.excriticalrate + targetOutputObj.beMagcrtrate;
/*     */     
/* 223 */     return isCrt(Math.min(finalCrtRate, SFightConsts.getInstance().S));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isCrt(double crtRate)
/*     */   {
/* 233 */     int randomValue = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 234 */     return crtRate > randomValue;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int calPHYDamage(Fighter attacker, Fighter defenser, int targetsize, boolean isCrt, BeforeAttackHandle.OutputObj attackOutputObj, BeforeAttackHandle.OutputObj targetOutputObj)
/*     */   {
/* 279 */     int phyAtk = attacker.getPHYATK(attackOutputObj.exaAtk, attackOutputObj.exaAtkRate);
/*     */     
/* 281 */     int targetDefense = defenser.getPHYDEF();
/* 282 */     int ignoreDefense = (int)(targetDefense * (attackOutputObj.phyPenetrationrate * 1.0D / FightArgs.getInstance().getDefaultRate()) + attackOutputObj.phyPenetration);
/*     */     
/* 284 */     targetDefense -= ignoreDefense;
/* 285 */     targetDefense = Math.max(1, targetDefense);
/*     */     
/* 287 */     int damageRate = attacker.getPHYDAMAGERate() + defenser.getBEPHYDAMAGERate() + attackOutputObj.damageRate + targetOutputObj.bedamagerate + targetOutputObj.bephydamagerate;
/*     */     
/*     */ 
/* 290 */     int phyCrtValue = attacker.getPHYCRTVALUE() + targetOutputObj.bePhyCrtValue;
/*     */     
/* 292 */     int phyDamageWaveLow = attacker.getPHYDAMAGEWAVELow();
/*     */     
/* 294 */     int phyDamageWaveHigh = attacker.getPHYDAMAGEWAVEHigh();
/*     */     
/* 296 */     int phyDamage = calPHYDamage(phyAtk, targetDefense, damageRate, isCrt, phyCrtValue, targetsize, phyDamageWaveLow, phyDamageWaveHigh, attackOutputObj.skillDamageRate, attackOutputObj.fixDamage);
/*     */     
/*     */ 
/*     */ 
/* 300 */     int randomDamage = (int)Math.max(1.0D, Math.ceil(phyAtk * SFightConsts.getInstance().Q));
/*     */     
/* 302 */     if (phyDamage >= randomDamage) {
/* 303 */       return phyDamage;
/*     */     }
/* 305 */     randomDamage = Xdb.random().nextInt(randomDamage) + 1;
/* 306 */     return phyDamage > randomDamage ? phyDamage : randomDamage;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int calPHYDamage(double phyatk, double phydef, double damagerate, boolean isCrt, double phycrtValue, int targetSize, int phyWaveLow, int phyWaveHigh, int skillDamageRate, int fixDamage)
/*     */   {
/* 334 */     if (targetSize <= 0) {
/* 335 */       GameServer.logger().error("计算物理伤害目标数量出错，按照一个人计算：targetsize：" + targetSize);
/* 336 */       targetSize = 1;
/*     */     }
/* 338 */     double relativeAtk = SFightConsts.getInstance().A * Math.max(0.0D, phyatk - phydef * SFightConsts.getInstance().B);
/*     */     
/* 340 */     double modifyDamageRate = modifyDamagerate(damagerate);
/* 341 */     double wave = modifyWave(phyWaveLow, phyWaveHigh);
/* 342 */     double crt = getCrt(isCrt, phycrtValue);
/* 343 */     double crtRateModify = Math.min(1.0D + crt, SFightConsts.getInstance().R);
/* 344 */     double targetModify = getTargetModify(targetSize);
/* 345 */     double result = (relativeAtk * (1.0D + modifyDamageRate + wave + skillDamageRate * 1.0D / FightArgs.getInstance().defaultRate) + fixDamage) * crtRateModify * targetModify;
/*     */     
/*     */ 
/*     */ 
/* 349 */     if (result > 2.147483647E9D) {
/* 350 */       return Integer.MAX_VALUE;
/*     */     }
/* 352 */     return (int)Math.round(result);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int calMAGDamage(Fighter attacker, Fighter defenser, int targetsize, boolean iscrt, BeforeAttackHandle.OutputObj attackOutputObj, BeforeAttackHandle.OutputObj targetOutputObj)
/*     */   {
/* 363 */     int attck = (int)attacker.getMAGATK(attackOutputObj.exaAtk, attackOutputObj.exaAtkRate);
/*     */     
/* 365 */     int targetDefense = defenser.getMAGDEF();
/* 366 */     int ignoreDefense = (int)(targetDefense * (attackOutputObj.mgcPenetrationrate * 1.0D / FightArgs.getInstance().getDefaultRate()) + attackOutputObj.mgcPenetration);
/*     */     
/* 368 */     targetDefense -= ignoreDefense;
/* 369 */     targetDefense = Math.max(1, targetDefense);
/*     */     
/* 371 */     int damageRate = attacker.getMAGDAMAGERate() + defenser.getBEMAGDAMAGERate() + attackOutputObj.damageRate + targetOutputObj.bedamagerate + targetOutputObj.bemgcdamagerate;
/*     */     
/*     */ 
/* 374 */     int magCrtValue = attacker.getMAGCRTVALUE() + targetOutputObj.beMagCrtValue;
/*     */     
/* 376 */     int waveLow = attacker.getMAGDAMAGEWAVELow();
/*     */     
/* 378 */     int waveHigh = attacker.getMAGDAMAGEWAVEHigh();
/*     */     
/* 380 */     int magDamage = calMAGDamage(attck, targetDefense, damageRate, iscrt, magCrtValue, targetsize, waveLow, waveHigh, attackOutputObj.skillDamageRate, attackOutputObj.fixDamage);
/*     */     
/* 382 */     int randomDamage = (int)Math.max(1.0D, Math.ceil(attck * SFightConsts.getInstance().Q));
/* 383 */     if (magDamage >= randomDamage) {
/* 384 */       return magDamage;
/*     */     }
/* 386 */     randomDamage = Xdb.random().nextInt(randomDamage) + 1;
/* 387 */     return magDamage > randomDamage ? magDamage : randomDamage;
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
/*     */   static int calMAGDamage(double magatk, double magdef, double damagerate, boolean isCrt, double magcrtValue, int targetSize, int magWaveLow, int magWaveHigh, int skillDamageRate, int fixDamage)
/*     */   {
/* 406 */     if (targetSize <= 0) {
/* 407 */       GameServer.logger().error("计算法术伤害目标数量出错，按照一个人计算：targetsize：" + targetSize);
/* 408 */       targetSize = 1;
/*     */     }
/* 410 */     double relativeAtk = SFightConsts.getInstance().C * Math.max(0.0D, magatk - magdef * SFightConsts.getInstance().D);
/*     */     
/* 412 */     double modifyDamageRate = modifyDamagerate(damagerate);
/* 413 */     double wave = modifyWave(magWaveLow, magWaveHigh);
/* 414 */     double crt = getCrt(isCrt, magcrtValue);
/* 415 */     double crtRateModify = Math.min(1.0D + crt, SFightConsts.getInstance().R);
/* 416 */     double targetModify = getTargetModify(targetSize);
/* 417 */     double result = (relativeAtk * (1.0D + modifyDamageRate + wave + skillDamageRate * 1.0D / FightArgs.getInstance().defaultRate) + fixDamage) * crtRateModify * targetModify;
/*     */     
/*     */ 
/* 420 */     if (result > 2.147483647E9D) {
/* 421 */       return Integer.MAX_VALUE;
/*     */     }
/* 423 */     return (int)Math.round(result);
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
/*     */   public static int calHealOnce(Fighter releaser, Fighter target, boolean iscrt, BeforeHealHandle.OutputObj attackOutputObj, BeforeHealHandle.OutputObj targetOutputObj)
/*     */   {
/* 438 */     int baseHeal = attackOutputObj.baseHeal;
/* 439 */     int magAtk = releaser.getMAGATK();
/* 440 */     int effectRate = releaser.getHealEffectRate() + target.getBeHealEffectRate() + attackOutputObj.healeffectrate + targetOutputObj.beHealEffectrate;
/*     */     
/* 442 */     int crtValue = releaser.getMAGCRTVALUE();
/* 443 */     int healFix = releaser.getHealEffectValue() + target.getBeHealEffectValue() + attackOutputObj.healFix;
/* 444 */     double modifyParam = SFightConsts.getInstance().I;
/* 445 */     modifyParam += attackOutputObj.modifyParam * 1.0D / FightArgs.getInstance().getDefaultRate();
/*     */     
/* 447 */     return calHealOnce(baseHeal, magAtk, modifyParam, effectRate, iscrt, crtValue, healFix);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int calHealOnce(double baseHeal, double magAtk, double modifyParam, double effectRate, boolean iscrt, double crtValue, double healFix)
/*     */   {
/* 469 */     double ret = 0.0D;
/* 470 */     double crtParam = 0.0D;
/* 471 */     if (iscrt) {
/* 472 */       crtParam = crtValue * 1.0D / FightArgs.getInstance().getDefaultRate();
/*     */     }
/* 474 */     ret = Math.max(0.0D, baseHeal + magAtk * modifyParam) * (1.0D + effectRate * 1.0D / FightArgs.getInstance().getDefaultRate()) * (1.0D + crtParam) + healFix;
/*     */     
/* 476 */     return (int)ret;
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
/*     */   public static int calHealLast(Fighter releaser, Fighter target, boolean iscrt, BeforeHealHandle.OutputObj attackOutputObj, BeforeHealHandle.OutputObj targetOutputObj)
/*     */   {
/* 491 */     int baseHeal = attackOutputObj.baseHeal;
/* 492 */     int magAtk = releaser.getMAGATK();
/* 493 */     int effectRate = releaser.getHealEffectRate() + target.getBeHealEffectRate() + attackOutputObj.healeffectrate;
/* 494 */     int healFix = releaser.getHealEffectValue() + target.getBeHealEffectValue() + attackOutputObj.healFix;
/* 495 */     double modifyParam = attackOutputObj.modifyParam * 1.0D / FightArgs.getInstance().getDefaultRate();
/* 496 */     return calHealLast(baseHeal, magAtk, effectRate, healFix, modifyParam);
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
/*     */   private static int calHealLast(double baseHeal, double magAtk, double effectRate, double healFix, double modifyParam)
/*     */   {
/* 513 */     double ret = 0.0D;
/* 514 */     ret = (baseHeal + magAtk * (SFightConsts.getInstance().J + modifyParam)) * (1.0D + effectRate * 1.0D / FightArgs.getInstance().getDefaultRate()) + healFix;
/*     */     
/* 516 */     return (int)ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isEscape(int escapeRate)
/*     */   {
/* 526 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 527 */     return escapeRate > random;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCaptrue(int captrueRate)
/*     */   {
/* 537 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 538 */     return captrueRate > random;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double modifyDamagerate(double damagerate)
/*     */   {
/* 563 */     return damagerate * 1.0D / FightArgs.getInstance().getDefaultRate();
/*     */   }
/*     */   
/*     */   private static double modifyWave(int waveLow, int waveHigh)
/*     */   {
/* 568 */     int waveValue = 0;
/* 569 */     waveLow += SFightConsts.getInstance().DAMAGEWAVEMIN;
/* 570 */     waveHigh += SFightConsts.getInstance().DAMAGEWAVEMAX;
/* 571 */     if (waveHigh == waveLow) {
/* 572 */       waveValue = waveHigh;
/* 573 */     } else if (waveHigh > waveLow) {
/* 574 */       waveValue = Xdb.random().nextInt(waveHigh - waveLow + 1) + waveLow;
/*     */     } else {
/* 576 */       GameServer.logger().error("FightFormulaHelp：计算伤害波动时发现上限小于下限 ");
/* 577 */       waveValue = waveHigh;
/*     */     }
/* 579 */     return waveValue * 1.0D / FightArgs.getInstance().getDefaultRate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double getCrt(boolean iscrt, double crtValue)
/*     */   {
/* 590 */     if (iscrt) {
/* 591 */       return crtValue * 1.0D / FightArgs.getInstance().getDefaultRate();
/*     */     }
/* 593 */     return 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double getTargetModify(int targetSize)
/*     */   {
/* 603 */     return 1.0D - (targetSize - 1) * 1.0D / 10.0D;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightFormulaHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */