/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SetPhyDamageWaveLow extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phydamagewavemin;
/*    */   
/*    */   public SetPhyDamageWaveLow(int phydamagewavemin)
/*    */   {
/* 11 */     this.phydamagewavemin = phydamagewavemin;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.setPHYDAMAGEWAVELow(this.phydamagewavemin);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.remPHYDAMAGEWAVELow();
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SetPhyDamageWaveLow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */