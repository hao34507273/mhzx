/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class SimilarEffect extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int groupStatus;
/*    */   private int exdamagerate;
/*    */   private int rate;
/*    */   
/*    */   public SimilarEffect(int groupStatus, int exdamagerate, int rate)
/*    */   {
/* 15 */     this.groupStatus = groupStatus;
/* 16 */     this.exdamagerate = exdamagerate;
/* 17 */     this.rate = rate;
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
/* 34 */     Fighter releaser = inputObj.getReleser();
/* 35 */     Fighter target = inputObj.getTarget();
/* 36 */     if ((releaser == null) || (target == null)) {
/* 37 */       return;
/*    */     }
/* 39 */     if (target.hasGroupStatus(this.groupStatus)) {
/* 40 */       int random = xdb.Xdb.random().nextInt(mzm.gsp.fight.main.FightArgs.getInstance().getDefaultRate());
/* 41 */       if (this.rate > random) {
/* 42 */         outputObj.damageRate += this.exdamagerate;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SimilarEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */