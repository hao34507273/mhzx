/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SetMagDamageWaveHigh extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magdamagewavemax;
/*    */   
/*    */   public SetMagDamageWaveHigh(int magdamagewavemax)
/*    */   {
/* 11 */     this.magdamagewavemax = magdamagewavemax;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.setMAGDAMAGEWAVEHigh(this.magdamagewavemax);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.remMAGDAMAGEWAVEHigh();
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SetMagDamageWaveHigh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */