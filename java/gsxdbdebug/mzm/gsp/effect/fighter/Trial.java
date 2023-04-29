/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Trial extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int bedamagerate;
/*    */   
/*    */   public Trial(int bedamagerate)
/*    */   {
/* 13 */     this.bedamagerate = bedamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addBuffState(121);
/* 19 */     fighter.addBeforeAttackHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remBuffState(121);
/* 26 */     fighter.remBeforeAttackHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 32 */     Fighter releaser = inputObj.getReleser();
/* 33 */     Fighter target = inputObj.getTarget();
/* 34 */     if ((releaser != null) && (target != null) && 
/* 35 */       (releaser.isTrial()) && 
/* 36 */       (target.isPropertyReLive())) {
/* 37 */       outputObj.damageRate += this.bedamagerate;
/* 38 */       int passiveSKillid = getPassiveSkillid();
/* 39 */       if (passiveSKillid > 0) {
/* 40 */         outputObj.releasertriggerPassiveSkillids.add(Integer.valueOf(passiveSKillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Trial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */