/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SexBedamage extends FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int mask;
/*    */   private int bedamagerate;
/*    */   private static final int OPPOSITE_SEX = 1;
/*    */   private static final int MAN = 2;
/*    */   private static final int WOMEN = 4;
/*    */   
/*    */   public SexBedamage(int mask, int bedamagerate)
/*    */   {
/* 18 */     this.mask = mask;
/* 19 */     this.bedamagerate = bedamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 24 */     fighter.addBeforeAttackHandle(this);
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 30 */     fighter.remBeforeAttackHandle(this);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 36 */     Fighter releaser = inputObj.getReleser();
/* 37 */     Fighter target = inputObj.getTarget();
/* 38 */     if ((releaser == null) || (target == null)) {
/* 39 */       return;
/*    */     }
/* 41 */     if ((this.mask & 0x1) > 0) {
/* 42 */       if (releaser.getGender() != target.getGender()) {
/* 43 */         outputObj.bedamagerate += this.bedamagerate;
/*    */       }
/* 45 */     } else if ((this.mask & 0x2) > 0) {
/* 46 */       if (releaser.getGender() == 1) {
/* 47 */         outputObj.bedamagerate += this.bedamagerate;
/*    */       }
/*    */     }
/* 50 */     else if (((this.mask & 0x4) > 0) && 
/* 51 */       (releaser.getGender() == 2)) {
/* 52 */       outputObj.bedamagerate += this.bedamagerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SexBedamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */