/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Mark extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int rate;
/*    */   
/*    */   public Mark(int rate)
/*    */   {
/* 13 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addBuffState(133);
/* 19 */     fighter.addBeforeAttackHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remBuffState(133);
/* 26 */     fighter.remBeforeAttackHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 32 */     if (inputObj.isTargetOwn()) {
/* 33 */       Fighter relearser = inputObj.getReleser();
/* 34 */       if (relearser == null) {
/* 35 */         return;
/*    */       }
/* 37 */       mzm.gsp.fight.main.FighterBuff fighterBuff = getGroup();
/* 38 */       if (fighterBuff == null) {
/* 39 */         return;
/*    */       }
/* 41 */       int releaserid = fighterBuff.getReleaserid();
/* 42 */       if (relearser.getid() == releaserid) {
/* 43 */         outputObj.bedamagerate += this.rate;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Mark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */