/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class BeSimilarEffect extends FighterEffect implements BeforeAttackHandle
/*    */ {
/*    */   private int groupStatus;
/*    */   private int beexdamagerate;
/*    */   private int bnexdamagerate;
/*    */   
/*    */   public BeSimilarEffect(int groupStatus, int beexdamagerate, int bnexdamagerate)
/*    */   {
/* 17 */     this.groupStatus = groupStatus;
/* 18 */     this.beexdamagerate = beexdamagerate;
/* 19 */     this.bnexdamagerate = bnexdamagerate;
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
/* 41 */     if (releaser.hasGroupStatus(this.groupStatus)) {
/* 42 */       outputObj.bedamagerate += this.beexdamagerate;
/*    */     } else {
/* 44 */       outputObj.bedamagerate += this.bnexdamagerate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BeSimilarEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */