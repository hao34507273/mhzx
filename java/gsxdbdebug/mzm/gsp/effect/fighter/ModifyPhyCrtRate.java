/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyCrtRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phycrtrate;
/*    */   
/*    */   public ModifyPhyCrtRate(int phycrt)
/*    */   {
/* 11 */     this.phycrtrate = phycrt;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYCRTRate(this.phycrtrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYCRTRate(-this.phycrtrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyCrtRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */