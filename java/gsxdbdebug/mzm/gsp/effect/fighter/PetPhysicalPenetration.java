/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class PetPhysicalPenetration extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int rate;
/*    */   
/*    */   public PetPhysicalPenetration(int rate)
/*    */   {
/* 12 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 17 */     fighter.addBeforeAttackHandle(this);
/* 18 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 23 */     fighter.remBeforeAttackHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(mzm.gsp.fight.handle.BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 29 */     if (inputObj.isReleserOwn()) {
/* 30 */       Fighter target = inputObj.getTarget();
/* 31 */       if ((target != null) && 
/* 32 */         (target.isPetType())) {
/* 33 */         outputObj.phyPenetrationrate += this.rate;
/* 34 */         int passiveSkillid = getPassiveSkillid();
/* 35 */         if (passiveSkillid > 0) {
/* 36 */           outputObj.releasertriggerPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\PetPhysicalPenetration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */