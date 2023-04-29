/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ 
/*     */ public class TimesRebound
/*     */   extends FighterEffect
/*     */   implements ReboundHandle, BeDamageHandle
/*     */ {
/*     */   private int rate;
/*     */   private int timestype;
/*     */   private int times;
/*     */   private int mask;
/*     */   private int limit;
/*     */   private int effectTimes_BeDamage;
/*     */   private int curRound_BeDamage;
/*     */   private int effectTimes_Rebound;
/*     */   private int curRound_Rebound;
/*     */   private static final int TIMESTYPE_ROUND = 1;
/*     */   private static final int TIMESTYPE_ALL = 2;
/*     */   
/*     */   public TimesRebound(int rate, int timestype, int times, int mask, int limit)
/*     */   {
/*  31 */     this.rate = rate;
/*  32 */     this.timestype = timestype;
/*  33 */     this.times = times;
/*  34 */     this.mask = mask;
/*  35 */     this.limit = limit;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  40 */     fighter.addReboundHandle(this);
/*  41 */     fighter.addBeDamageHandle(this);
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  47 */     fighter.remReboundHandle(this);
/*  48 */     fighter.remBeDamageHandle(this);
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public void onRebound(Fighter fighter, int damageType, int damage, ReboundHandle.OutPutObj outPutObj)
/*     */   {
/*  54 */     int curRound = fighter.getRound();
/*  55 */     if (this.timestype == 1) {
/*  56 */       if (curRound != this.curRound_Rebound) {}
/*     */ 
/*     */     }
/*  59 */     else if ((this.timestype == 2) && 
/*  60 */       (this.times <= this.effectTimes_Rebound)) {
/*  61 */       if (this.times <= this.effectTimes_BeDamage) {
/*  62 */         setLeftRound(0);
/*     */       }
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     if ((this.mask & damageType) > 0)
/*     */     {
/*  69 */       this.curRound_Rebound = curRound;
/*  70 */       this.effectTimes_Rebound += 1;
/*  71 */       if ((this.times <= this.effectTimes_Rebound) && (this.times <= this.effectTimes_BeDamage)) {
/*  72 */         setLeftRound(0);
/*     */       }
/*  74 */       int retDamage = (int)(damage * (this.rate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  75 */       retDamage = Math.min(retDamage, this.limit);
/*  76 */       outPutObj.reboundDamage += retDamage;
/*  77 */       int passiveSkillid = getPassiveSkillid();
/*  78 */       if (passiveSkillid > 0) {
/*  79 */         outPutObj.targetPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*     */   {
/*  87 */     Fighter target = inputObj.getTarget();
/*  88 */     if (target == null) {
/*  89 */       return;
/*     */     }
/*  91 */     int curRound = target.getRound();
/*  92 */     if (this.timestype == 1) {
/*  93 */       if (curRound != this.curRound_BeDamage) {}
/*     */ 
/*     */     }
/*  96 */     else if ((this.timestype == 2) && 
/*  97 */       (this.times <= this.effectTimes_BeDamage)) {
/*  98 */       if (this.times <= this.effectTimes_Rebound) {
/*  99 */         setLeftRound(0);
/*     */       }
/* 101 */       return;
/*     */     }
/*     */     
/* 104 */     if ((this.mask & inputObj.getDamageType()) > 0) {
/* 105 */       this.curRound_BeDamage = curRound;
/* 106 */       this.effectTimes_BeDamage += 1;
/* 107 */       if ((this.times <= this.effectTimes_Rebound) && (this.times <= this.effectTimes_BeDamage)) {
/* 108 */         setLeftRound(0);
/*     */       }
/* 110 */       outputObj.nowDamage = 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TimesRebound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */