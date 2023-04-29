/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Vampire extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int vampirerate;
/*    */   private int mask;
/*    */   private static final int TYPE_PHY = 1;
/*    */   private static final int TYPE_MAG = 2;
/*    */   
/*    */   public Vampire(int vampirerate, int mask)
/*    */   {
/* 16 */     this.vampirerate = vampirerate;
/* 17 */     this.mask = mask;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeforeAttackHandle(this);
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 28 */     fighter.remBeforeAttackHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 34 */     Fighter targetFighter = inputObj.getTarget();
/* 35 */     if ((targetFighter != null) && 
/* 36 */       (targetFighter.isGhost())) {
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     if ((this.mask & 0x1) > 0) {
/* 41 */       outputObj.phyVampirerate += this.vampirerate;
/*    */     }
/* 43 */     if ((this.mask & 0x2) > 0) {
/* 44 */       outputObj.magVampirerate += this.vampirerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Vampire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */