/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyDefRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phydefrate;
/*    */   
/*    */   public ModifyPhyDefRate(int phydefrate)
/*    */   {
/* 11 */     this.phydefrate = phydefrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYDEFRate(this.phydefrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYDEFRate(-this.phydefrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyDefRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */