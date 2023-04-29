/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagDamageRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magdamagerate;
/*    */   
/*    */   public ModifyMagDamageRate(int magdamagerate)
/*    */   {
/* 11 */     this.magdamagerate = magdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGDAMAGERate(this.magdamagerate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGDAMAGERate(-this.magdamagerate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */