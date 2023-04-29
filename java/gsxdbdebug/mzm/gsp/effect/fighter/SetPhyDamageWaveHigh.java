/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SetPhyDamageWaveHigh extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phydamagewavemax;
/*    */   
/*    */   public SetPhyDamageWaveHigh(int phydamagewavemax)
/*    */   {
/* 11 */     this.phydamagewavemax = phydamagewavemax;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.setPHYDAMAGEWAVEHigh(this.phydamagewavemax);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.remPHYDAMAGEWAVEHigh();
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SetPhyDamageWaveHigh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */