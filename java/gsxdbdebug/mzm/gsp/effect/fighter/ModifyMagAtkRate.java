/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagAtkRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magatkrate;
/*    */   
/*    */   public ModifyMagAtkRate(int mgcatkrate)
/*    */   {
/* 11 */     this.magatkrate = mgcatkrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGATKRate(this.magatkrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGATKRate(-this.magatkrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagAtkRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */