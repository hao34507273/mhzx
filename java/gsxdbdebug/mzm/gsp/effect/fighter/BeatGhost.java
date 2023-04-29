/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class BeatGhost extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int exdamagerate;
/*    */   
/*    */   public BeatGhost(int exdamagerate)
/*    */   {
/* 13 */     this.exdamagerate = exdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addBuffState(114);
/* 19 */     fighter.addBeforeAttackHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remBuffState(114);
/* 26 */     fighter.remBeforeAttackHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 32 */     if ((inputObj.getReleser() != null) && (inputObj.getTarget() != null) && 
/* 33 */       (inputObj.getReleser().isBeatGhost()) && (inputObj.getTarget().isGhost())) {
/* 34 */       outputObj.damageRate += this.exdamagerate;
/* 35 */       int passiveSkillid = getPassiveSkillid();
/* 36 */       if (passiveSkillid > 0) {
/* 37 */         outputObj.releasertriggerPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BeatGhost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */