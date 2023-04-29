/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class BeAttackedStronger extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle, mzm.gsp.fight.handle.BeDamageHandle
/*    */ {
/*    */   private int mask;
/*    */   private int times;
/*    */   private int damagerate;
/*    */   private int bedamagerate;
/*    */   private int curTimes;
/*    */   private int curRound;
/*    */   private int addDamageRate;
/*    */   private int addBeDamageRate;
/*    */   
/*    */   public BeAttackedStronger(int mask, int times, int damagerate, int bedamagerate)
/*    */   {
/* 20 */     this.mask = mask;
/* 21 */     this.times = times;
/* 22 */     this.damagerate = damagerate;
/* 23 */     this.bedamagerate = bedamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 28 */     fighter.addBeforeAttackHandle(this);
/* 29 */     fighter.addBeDamageHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 35 */     fighter.remBeforeAttackHandle(this);
/* 36 */     fighter.remBeDamageHandle(this);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(mzm.gsp.fight.handle.BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 42 */     Fighter fighter = inputObj.getReleser();
/* 43 */     if ((fighter != null) && (this.curRound == fighter.getRound())) {
/* 44 */       outputObj.damageRate += this.addDamageRate;
/* 45 */       outputObj.bedamagerate += this.addBeDamageRate;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, mzm.gsp.fight.handle.BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 53 */     int damageType = inputObj.getDamageType();
/* 54 */     Fighter target = inputObj.getTarget();
/* 55 */     if (target == null) {
/* 56 */       return;
/*    */     }
/* 58 */     if ((this.mask & damageType) > 0) {
/* 59 */       int round = target.getRound();
/* 60 */       if (this.curRound != round) {
/* 61 */         this.curTimes = 0;
/* 62 */         this.addDamageRate = 0;
/* 63 */         this.addBeDamageRate = 0;
/* 64 */         this.curRound = round;
/*    */       }
/* 66 */       if (this.curTimes >= this.times) {
/* 67 */         return;
/*    */       }
/* 69 */       this.addDamageRate += this.damagerate;
/* 70 */       this.addBeDamageRate += this.bedamagerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BeAttackedStronger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */