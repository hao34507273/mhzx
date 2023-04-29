/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Visible extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int exdamagerate;
/*    */   
/*    */   public Visible(int exdamagerate)
/*    */   {
/* 13 */     this.exdamagerate = exdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addBuffState(108);
/* 19 */     fighter.addBeforeAttackHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remBuffState(108);
/* 26 */     fighter.remBeforeAttackHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 32 */     Fighter releser = inputObj.getReleser();
/* 33 */     Fighter target = inputObj.getTarget();
/* 34 */     if ((releser != null) && (target != null) && 
/* 35 */       (releser.isVisible()) && (target.isInvisible())) {
/* 36 */       outputObj.damageRate += this.exdamagerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Visible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */