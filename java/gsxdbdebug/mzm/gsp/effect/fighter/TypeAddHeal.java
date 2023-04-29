/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class TypeAddHeal extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int pvphealrate;
/*    */   private int pvehealrate;
/*    */   
/*    */   public TypeAddHeal(int pvphealrate, int pvehealrate)
/*    */   {
/* 12 */     this.pvphealrate = pvphealrate;
/* 13 */     this.pvehealrate = pvehealrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     if (fighter.isPVE()) {
/* 19 */       fighter.addHealEffectRate(this.pvehealrate);
/* 20 */     } else if (fighter.isPVP()) {
/* 21 */       fighter.addHealEffectRate(this.pvphealrate);
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 28 */     if (fighter.isPVE()) {
/* 29 */       fighter.addHealEffectRate(-this.pvehealrate);
/* 30 */     } else if (fighter.isPVP()) {
/* 31 */       fighter.addHealEffectRate(-this.pvphealrate);
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TypeAddHeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */