/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.AbsorbDamage;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class AbsorbDamageRate
/*    */   extends FighterEffect implements AbsorbDamage
/*    */ {
/*    */   private int absorbdamagerate;
/*    */   private int max;
/*    */   private int ratemax;
/* 16 */   private int absorbed = 0;
/*    */   
/*    */   public AbsorbDamageRate(int absorbdamagerate, int ratemax, int max) {
/* 19 */     if (absorbdamagerate > ratemax) {
/* 20 */       absorbdamagerate = ratemax;
/*    */     }
/* 22 */     this.absorbdamagerate = absorbdamagerate;
/* 23 */     this.max = max;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 28 */     fighter.addBeDamageHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 34 */     fighter.remBeDamageHandle(this);
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 40 */     int absorb = this.max - this.absorbed;
/* 41 */     if (absorb <= 0) {
/* 42 */       setLeftRound(0);
/* 43 */       return;
/*    */     }
/* 45 */     int damageNow = (int)(outputObj.nowDamage * (1.0D - this.absorbdamagerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */     
/* 47 */     if (absorb > damageNow) {
/* 48 */       this.absorbed += damageNow;
/* 49 */       outputObj.nowDamage -= damageNow;
/*    */     } else {
/* 51 */       this.absorbed = this.max;
/* 52 */       setLeftRound(0);
/* 53 */       outputObj.nowDamage -= absorb;
/*    */     }
/* 55 */     outputObj.absorb = true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AbsorbDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */