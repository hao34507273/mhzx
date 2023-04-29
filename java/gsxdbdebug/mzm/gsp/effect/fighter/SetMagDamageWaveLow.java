/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SetMagDamageWaveLow extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magdamagewavemin;
/*    */   
/*    */   public SetMagDamageWaveLow(int magdamagewavemin)
/*    */   {
/* 11 */     this.magdamagewavemin = magdamagewavemin;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.setMAGDAMAGEWAVELow(this.magdamagewavemin);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.remMAGDAMAGEWAVELow();
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SetMagDamageWaveLow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */