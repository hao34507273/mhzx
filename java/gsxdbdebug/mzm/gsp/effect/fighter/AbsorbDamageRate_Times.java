/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.AbsorbDamage;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class AbsorbDamageRate_Times extends FighterEffect implements AbsorbDamage
/*    */ {
/*    */   private int absorbtimes;
/*    */   private int absorbdamagerate;
/*    */   private int absorbmax;
/*    */   private int timesmax;
/*    */   
/*    */   public AbsorbDamageRate_Times(int absorbtimes, int absorbdamagerate, int timesmax, int absorbmax)
/*    */   {
/* 19 */     if (absorbtimes > timesmax) {
/* 20 */       absorbtimes = timesmax;
/*    */     }
/* 22 */     this.absorbtimes = absorbtimes;
/* 23 */     this.absorbdamagerate = absorbdamagerate;
/* 24 */     this.absorbmax = absorbmax;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 29 */     fighter.addBeDamageHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 35 */     fighter.remBeDamageHandle(this);
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 41 */     Fighter fighter = inputObj.getTarget();
/* 42 */     if (fighter == null) {
/* 43 */       return;
/*    */     }
/* 45 */     if ((this.absorbtimes == 0) || (this.absorbmax <= 0)) {
/* 46 */       setLeftRound(0);
/* 47 */       return;
/*    */     }
/* 49 */     if (--this.absorbtimes <= 0) {
/* 50 */       setLeftRound(0);
/*    */     }
/* 52 */     int damageNow = (int)(outputObj.nowDamage * (this.absorbdamagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 53 */     if (this.absorbmax > damageNow) {
/* 54 */       this.absorbmax -= damageNow;
/* 55 */       outputObj.nowDamage -= damageNow;
/*    */     } else {
/* 57 */       outputObj.nowDamage -= this.absorbmax;
/* 58 */       this.absorbmax = 0;
/* 59 */       setLeftRound(0);
/*    */     }
/* 61 */     outputObj.absorb = true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AbsorbDamageRate_Times.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */