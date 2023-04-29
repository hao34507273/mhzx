/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class RoundEndDisperse extends FighterEffect implements mzm.gsp.fight.handle.RoundEndHandle
/*     */ {
/*     */   private int type;
/*     */   private int effectgroupnum;
/*     */   private int rate;
/*  14 */   private boolean isDispelAll = false;
/*     */   private static final byte TYPE_NEGETIVE = 1;
/*     */   private static final byte TYPE_SEAL = 2;
/*     */   private static final byte TYPE_POISION = 4;
/*     */   
/*     */   public RoundEndDisperse(int type, int effectgroupnum, int rate)
/*     */   {
/*  21 */     this.type = type;
/*  22 */     this.effectgroupnum = effectgroupnum;
/*  23 */     if (effectgroupnum <= 0) {
/*  24 */       this.isDispelAll = true;
/*     */     }
/*  26 */     this.rate = rate;
/*     */   }
/*     */   
/*     */   public void onRoundEnd(Fighter fighter)
/*     */   {
/*  31 */     if (!fighter.isAlive()) {
/*  32 */       return;
/*     */     }
/*  34 */     int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  35 */     if (random >= this.rate) {
/*  36 */       return;
/*     */     }
/*  38 */     if (this.isDispelAll) {
/*  39 */       int dispelNum = 0;
/*  40 */       if ((this.type & 0x1) > 0) {
/*  41 */         dispelNum += fighter.dispelNegativeBuff();
/*     */       }
/*  43 */       if ((this.type & 0x2) > 0) {
/*  44 */         dispelNum += fighter.dispelSealBuff();
/*     */       }
/*  46 */       if ((this.type & 0x4) > 0) {
/*  47 */         dispelNum += fighter.dispelPoisonBuff();
/*     */       }
/*  49 */       if (dispelNum > 0) {
/*  50 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  51 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*     */       }
/*     */     }
/*     */     else {
/*  55 */       if (this.effectgroupnum <= 0) {
/*  56 */         return;
/*     */       }
/*  58 */       int dispelNum = 0;
/*  59 */       if ((this.type & 0x1) > 0) {
/*  60 */         dispelNum += fighter.dispelNegativeBuff(this.effectgroupnum);
/*     */       }
/*  62 */       if (dispelNum >= this.effectgroupnum) {
/*  63 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  64 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*  65 */         return;
/*     */       }
/*  67 */       if ((this.type & 0x2) > 0) {
/*  68 */         dispelNum += fighter.dispelSealBuff(this.effectgroupnum - dispelNum);
/*     */       }
/*  70 */       if (dispelNum >= this.effectgroupnum) {
/*  71 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  72 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*  73 */         return;
/*     */       }
/*  75 */       if ((this.type & 0x4) > 0) {
/*  76 */         dispelNum += fighter.dispelPoisonBuff(this.effectgroupnum - dispelNum);
/*     */       }
/*  78 */       if (dispelNum > 0) {
/*  79 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*  80 */         checkAndTriggerPassiveSkill(fighter, fighterStatus);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  88 */     fighter.addRoundEndHandle(this);
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  94 */     fighter.remRoundEndHandle(this);
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   private void checkAndTriggerPassiveSkill(Fighter fighter, FighterStatus fighterStatus) {
/*  99 */     int passiveSkillid = getPassiveSkillid();
/* 100 */     if (passiveSkillid > 0) {
/* 101 */       fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*     */     }
/* 103 */     fighter.fillFighterStatus(fighterStatus);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundEndDisperse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */