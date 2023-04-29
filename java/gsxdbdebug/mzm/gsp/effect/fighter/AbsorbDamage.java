/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class AbsorbDamage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.AbsorbDamage
/*    */ {
/*    */   private int absorbdamage;
/*    */   private int absorbmax;
/*    */   
/*    */   public AbsorbDamage(int absorbdamage, int absorbmax)
/*    */   {
/* 14 */     if (absorbdamage > absorbmax) {
/* 15 */       absorbdamage = absorbmax;
/*    */     }
/* 17 */     this.absorbdamage = absorbdamage;
/* 18 */     this.absorbmax = absorbmax;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 23 */     fighter.addBeDamageHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     fighter.remBeDamageHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*    */   {
/* 35 */     if (this.absorbdamage <= 0) {
/* 36 */       setLeftRound(0);
/* 37 */       return;
/*    */     }
/* 39 */     if (this.absorbdamage > outputObj.nowDamage) {
/* 40 */       this.absorbdamage -= outputObj.nowDamage;
/* 41 */       outputObj.nowDamage = 0;
/*    */     } else {
/* 43 */       outputObj.nowDamage -= this.absorbdamage;
/* 44 */       this.absorbdamage = 0;
/* 45 */       setLeftRound(0);
/*    */     }
/* 47 */     outputObj.absorb = true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AbsorbDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */