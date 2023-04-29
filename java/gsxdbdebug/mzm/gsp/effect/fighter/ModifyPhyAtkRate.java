/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyAtkRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phyatkrate;
/*    */   
/*    */   public ModifyPhyAtkRate(int phyatkrate)
/*    */   {
/* 11 */     this.phyatkrate = phyatkrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYATKRate(this.phyatkrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYATKRate(-this.phyatkrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyAtkRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */