/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Solid extends FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int hprate;
/*    */   private int exphydamagerate;
/*    */   private int exmagdamagerate;
/*    */   
/*    */   public Solid(int hprate, int exphydamagerate, int exmagdamagerate)
/*    */   {
/* 17 */     this.hprate = hprate;
/* 18 */     this.exphydamagerate = exphydamagerate;
/* 19 */     this.exmagdamagerate = exmagdamagerate;
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
/* 36 */     Fighter target = inputObj.getTarget();
/* 37 */     if (target != null) {
/* 38 */       double curHpRate = target.getCurHpRateValue();
/* 39 */       double lostHpRate = FightArgs.getInstance().getDefaultRate() - curHpRate;
/* 40 */       if (lostHpRate >= this.hprate) {
/* 41 */         outputObj.bemgcdamagerate += this.exmagdamagerate;
/* 42 */         outputObj.bephydamagerate += this.exphydamagerate;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Solid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */