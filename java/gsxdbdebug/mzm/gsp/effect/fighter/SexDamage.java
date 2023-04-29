/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SexDamage extends FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int mask;
/*    */   private int damagerate;
/*    */   private static final int OPPOSITE_SEX = 1;
/*    */   private static final int MAN = 2;
/*    */   private static final int WOMEN = 4;
/*    */   private static final int SAME_SEX = 8;
/*    */   
/*    */   public SexDamage(int mask, int damagerate)
/*    */   {
/* 19 */     this.mask = mask;
/* 20 */     this.damagerate = damagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     fighter.addBeforeAttackHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 31 */     fighter.remBeforeAttackHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 37 */     Fighter releaser = inputObj.getReleser();
/* 38 */     Fighter target = inputObj.getTarget();
/* 39 */     if ((releaser == null) || (target == null)) {
/* 40 */       return;
/*    */     }
/* 42 */     if ((this.mask & 0x1) > 0) {
/* 43 */       if (releaser.getGender() != target.getGender()) {
/* 44 */         outputObj.damageRate += this.damagerate;
/*    */       }
/* 46 */     } else if ((this.mask & 0x2) > 0) {
/* 47 */       if (target.getGender() == 1) {
/* 48 */         outputObj.damageRate += this.damagerate;
/*    */       }
/*    */     }
/* 51 */     else if ((this.mask & 0x4) > 0) {
/* 52 */       if (target.getGender() == 2) {
/* 53 */         outputObj.damageRate += this.damagerate;
/*    */       }
/* 55 */     } else if (((this.mask & 0x8) > 0) && 
/* 56 */       (target.getGender() == releaser.getGender())) {
/* 57 */       outputObj.damageRate += this.damagerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SexDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */