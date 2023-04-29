/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBeCapturedRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int rate;
/*    */   
/*    */   public ModifyBeCapturedRate(int rate)
/*    */   {
/* 11 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBeCapaturedRate(this.rate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeCapaturedRate(-this.rate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBeCapturedRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */