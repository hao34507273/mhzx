/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyDamageRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phydamagerate;
/*    */   
/*    */   public ModifyPhyDamageRate(int phydamagerate)
/*    */   {
/* 11 */     this.phydamagerate = phydamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYDAMAGERate(this.phydamagerate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYDAMAGERate(-this.phydamagerate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyDamageRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */