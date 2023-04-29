/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.FighterDeadHandle;
/*     */ import mzm.gsp.fight.handle.OtherBeKilledAfterHandle;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ 
/*     */ public class Enrage extends FighterEffect implements FighterDeadHandle, OtherBeKilledAfterHandle
/*     */ {
/*     */   private static final int DEAD_FIGHTER_TYPE_PET = 1;
/*     */   private static final int DEAD_FIGHTER_TYPE_CHILD = 2;
/*     */   private static final int DEAD_FIGHTER_TYPE_FELLOW = 4;
/*     */   private static final int DEAD_FIGHTER_TYPE_ROLE = 8;
/*     */   private static final int DEAD_FIGHTER_TYPE_MONSTER = 16;
/*     */   private static final int CAMP_ENEMY = 1;
/*     */   private static final int CAMP_FIREND = 2;
/*     */   private static final int PROP_MP = 1;
/*     */   private static final int PROP_HP = 2;
/*     */   private static final int PROP_ANGER = 3;
/*     */   private final int deadFighterType;
/*     */   private final int deadFighterCamp;
/*     */   private final int prop;
/*     */   private final int propValue;
/*     */   
/*     */   public Enrage(int deadFighterType, int deadFighterCamp, int prop, int propValue)
/*     */   {
/*  31 */     this.deadFighterType = deadFighterType;
/*  32 */     this.deadFighterCamp = deadFighterCamp;
/*  33 */     this.prop = prop;
/*  34 */     this.propValue = propValue;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  39 */     fighter.addFighterDeadHandle(this);
/*  40 */     fighter.addOtherBekilledAfterhandle(this);
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  46 */     fighter.remFighterDeadHandle(this);
/*  47 */     fighter.remOtherBekilledAfterhandle(this);
/*  48 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onFighterDead(Fighter ownFighter, Fighter deadFighter) {}
/*     */   
/*     */ 
/*     */   public void otherBeKilled(BeKilledHandle.InputObj beKilledInput, Fighter self)
/*     */   {
/*  58 */     Fighter beKilledFighter = beKilledInput.target;
/*  59 */     if (beKilledFighter.isAlive()) {
/*  60 */       return;
/*     */     }
/*     */     
/*  63 */     Fighter ownFighter = self;
/*  64 */     Fighter deadFighter = beKilledFighter;
/*     */     
/*  66 */     if (!ownFighter.isAlive()) {
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     if ((deadFighter.isPetType()) && 
/*  71 */       ((this.deadFighterType & 0x1) != 1)) {
/*  72 */       return;
/*     */     }
/*     */     
/*  75 */     if ((deadFighter.isChildType()) && 
/*  76 */       ((this.deadFighterType & 0x2) != 2)) {
/*  77 */       return;
/*     */     }
/*     */     
/*     */ 
/*  81 */     if ((deadFighter.isFellowType()) && 
/*  82 */       ((this.deadFighterType & 0x4) != 4)) {
/*  83 */       return;
/*     */     }
/*     */     
/*     */ 
/*  87 */     if ((deadFighter.isRoleType()) && 
/*  88 */       ((this.deadFighterType & 0x8) != 8)) {
/*  89 */       return;
/*     */     }
/*     */     
/*     */ 
/*  93 */     if ((deadFighter.isMonster()) && 
/*  94 */       ((this.deadFighterType & 0x10) != 16)) {
/*  95 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 100 */     if (ownFighter.isActive() == deadFighter.isActive()) {
/* 101 */       if ((this.deadFighterCamp & 0x2) == 2) {}
/*     */ 
/*     */ 
/*     */     }
/* 105 */     else if ((this.deadFighterCamp & 0x1) != 1) {
/* 106 */       return;
/*     */     }
/*     */     
/*     */ 
/* 110 */     if (this.prop == 3) {
/* 111 */       ownFighter.addAnger(this.propValue);
/* 112 */       deadFighter.addInfluenceTarget(ownFighter.getid());
/* 113 */       FighterStatus status = (FighterStatus)deadFighter.getInfluenceMap().get(Integer.valueOf(ownFighter.getid()));
/* 114 */       status.angerchange += this.propValue;
/* 115 */       status.triggerpassiveskills.add(Integer.valueOf(getPassiveSkillid()));
/*     */     }
/* 117 */     if (this.prop == 1) {
/* 118 */       ownFighter.addMp(this.propValue);
/* 119 */       deadFighter.addInfluenceTarget(ownFighter.getid());
/* 120 */       FighterStatus status = (FighterStatus)deadFighter.getInfluenceMap().get(Integer.valueOf(ownFighter.getid()));
/* 121 */       status.mpchange += this.propValue;
/* 122 */       status.triggerpassiveskills.add(Integer.valueOf(getPassiveSkillid()));
/*     */     }
/* 124 */     if (this.prop == 2) {
/* 125 */       ownFighter.addHp(this.propValue);
/* 126 */       deadFighter.addInfluenceTarget(ownFighter.getid());
/* 127 */       FighterStatus status = (FighterStatus)deadFighter.getInfluenceMap().get(Integer.valueOf(ownFighter.getid()));
/* 128 */       status.hpchange += this.propValue;
/* 129 */       status.triggerpassiveskills.add(Integer.valueOf(getPassiveSkillid()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Enrage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */