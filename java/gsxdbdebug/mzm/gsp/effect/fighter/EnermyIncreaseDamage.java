/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class EnermyIncreaseDamage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int number;
/*    */   private int exdamagerate;
/*    */   
/*    */   public EnermyIncreaseDamage(int number, int exdamagerate)
/*    */   {
/* 14 */     this.number = number;
/* 15 */     this.exdamagerate = exdamagerate;
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
/* 32 */     Fighter releaser = inputObj.getReleser();
/* 33 */     if (releaser == null) {
/* 34 */       return;
/*    */     }
/* 36 */     int enermyNum = releaser.getEnermyLiveFighters().size();
/*    */     
/* 38 */     if (this.number > 0) {
/* 39 */       outputObj.damageRate += this.exdamagerate * enermyNum / this.number;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\EnermyIncreaseDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */