/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyCrtValue extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phycrtValue;
/*    */   
/*    */   public ModifyPhyCrtValue(int phycrtValue)
/*    */   {
/* 11 */     this.phycrtValue = phycrtValue;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYCRTVALUE(this.phycrtValue);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYCRTVALUE(-this.phycrtValue);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyCrtValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */