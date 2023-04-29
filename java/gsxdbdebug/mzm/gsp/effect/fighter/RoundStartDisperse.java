/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class RoundStartDisperse extends FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle
/*     */ {
/*     */   private int type;
/*     */   private int effectgroupnum;
/*     */   private int rate;
/*  14 */   private boolean isDispelAll = false;
/*     */   private static final byte TYPE_NEGETIVE = 1;
/*     */   private static final byte TYPE_SEAL = 2;
/*     */   private static final byte TYPE_POISION = 4;
/*     */   
/*     */   public RoundStartDisperse(int type, int effectgroupnum, int rate)
/*     */   {
/*  21 */     this.type = type;
/*  22 */     this.effectgroupnum = effectgroupnum;
/*  23 */     if (effectgroupnum <= 0) {
/*  24 */       this.isDispelAll = true;
/*     */     }
/*  26 */     this.rate = rate;
/*     */   }
/*     */   
/*     */   public void onRoundStart(Fighter fighter)
/*     */   {
/*  31 */     if (!fighter.isAlive()) {
/*  32 */       return;
/*     */     }
/*  34 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  35 */     if (random >= this.rate) {
/*  36 */       return;
/*     */     }
/*     */     
/*  39 */     if (this.isDispelAll) {
/*  40 */       int dispelNum = 0;
/*  41 */       if ((this.type & 0x1) > 0) {
/*  42 */         dispelNum += fighter.dispelNegativeBuff();
/*     */       }
/*  44 */       if ((this.type & 0x2) > 0) {
/*  45 */         dispelNum += fighter.dispelSealBuff();
/*     */       }
/*  47 */       if ((this.type & 0x4) > 0) {
/*  48 */         dispelNum += fighter.dispelPoisonBuff();
/*     */       }
/*  50 */       if (dispelNum > 0) {
/*  51 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  52 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*     */       }
/*     */     }
/*     */     else {
/*  56 */       if (this.effectgroupnum <= 0) {
/*  57 */         return;
/*     */       }
/*  59 */       int dispelNum = 0;
/*  60 */       if ((this.type & 0x1) > 0) {
/*  61 */         dispelNum += fighter.dispelNegativeBuff(this.effectgroupnum);
/*     */       }
/*  63 */       if (dispelNum >= this.effectgroupnum) {
/*  64 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  65 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*  66 */         return;
/*     */       }
/*  68 */       if ((this.type & 0x2) > 0) {
/*  69 */         dispelNum += fighter.dispelSealBuff(this.effectgroupnum - dispelNum);
/*     */       }
/*  71 */       if (dispelNum >= this.effectgroupnum) {
/*  72 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  73 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*  74 */         return;
/*     */       }
/*  76 */       if ((this.type & 0x4) > 0) {
/*  77 */         dispelNum += fighter.dispelPoisonBuff(this.effectgroupnum - dispelNum);
/*     */       }
/*  79 */       if (dispelNum > 0) {
/*  80 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  81 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean attach(Fighter fighter)
/*     */   {
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
/*     */   private void checkAndTriggerPassiveSkill(Fighter fighter, FighterStatus fighterStatus) {
/* 100 */     int passiveSkillid = getPassiveSkillid();
/* 101 */     if (passiveSkillid > 0) {
/* 102 */       fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*     */     }
/* 104 */     fighter.fillFighterStatus(fighterStatus);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartDisperse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */