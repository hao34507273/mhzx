/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class GroupDamageDecrease extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private int rate;
/*    */   
/*    */   public GroupDamageDecrease(int rate)
/*    */   {
/* 13 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addBeforeAttackHandle(this);
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 24 */     fighter.remBeforeAttackHandle(this);
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 30 */     mzm.gsp.skill.main.Skill skill = inputObj.getSkill();
/* 31 */     if (skill == null) {
/* 32 */       return;
/*    */     }
/* 34 */     Fighter releaser = inputObj.getReleser();
/* 35 */     if (releaser == null) {
/* 36 */       return;
/*    */     }
/* 38 */     int targetSize = skill.calTagetSize(releaser);
/* 39 */     if (targetSize > 1) {
/* 40 */       outputObj.bedamagerate += this.rate;
/* 41 */       int passiveSkillid = getPassiveSkillid();
/* 42 */       if (passiveSkillid > 0) {
/* 43 */         outputObj.releasertriggerPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\GroupDamageDecrease.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */