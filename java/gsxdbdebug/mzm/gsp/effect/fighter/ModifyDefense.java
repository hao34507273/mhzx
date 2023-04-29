/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyDefense extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int rate;
/*    */   
/*    */   public ModifyDefense(int rate)
/*    */   {
/* 12 */     this.rate = rate;
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
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 29 */     if (inputObj.isTargetOwn()) {
/* 30 */       Fighter targetFighter = inputObj.getTarget();
/* 31 */       if (targetFighter == null) {
/* 32 */         return;
/*    */       }
/* 34 */       if (targetFighter.isDefense()) {
/* 35 */         outputObj.bephydamagerate += this.rate;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyDefense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */