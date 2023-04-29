/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class BeHitModifyPhyCrtValue extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int phycrtValue;
/*    */   
/*    */   public BeHitModifyPhyCrtValue(int phycrtValue)
/*    */   {
/* 12 */     this.phycrtValue = phycrtValue;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 17 */     fighter.addBeforeAttackHandle(this);
/* 18 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 23 */     fighter.remBeforeAttackHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(mzm.gsp.fight.handle.BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 29 */     outputObj.bePhyCrtValue += this.phycrtValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BeHitModifyPhyCrtValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */