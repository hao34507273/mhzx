/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class DamageReductionWithOutPet extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int exphydamagerate;
/*    */   private int exmgcdamagerate;
/*    */   
/*    */   public DamageReductionWithOutPet(int exphydamagerate, int exmgcdamagerate)
/*    */   {
/* 14 */     this.exmgcdamagerate = exmgcdamagerate;
/* 15 */     this.exphydamagerate = exphydamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addBeforeAttackHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remBeforeAttackHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 32 */     Fighter targetFighter = inputObj.getTarget();
/* 33 */     if (targetFighter == null) {
/* 34 */       return;
/*    */     }
/* 36 */     if ((targetFighter.isRoleType()) && 
/* 37 */       (!targetFighter.carryPet())) {
/* 38 */       outputObj.bephydamagerate += this.exphydamagerate;
/* 39 */       outputObj.bemgcdamagerate += this.exmgcdamagerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DamageReductionWithOutPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */