/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class PetTargetDamage extends FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle
/*    */ {
/*    */   private final int id;
/*    */   private final int skillDamageRate;
/*    */   private final double targetHpRate;
/*    */   
/*    */   public PetTargetDamage(int id, int skillDamageRate, int exDamage)
/*    */   {
/* 18 */     this.id = id;
/* 19 */     this.skillDamageRate = skillDamageRate;
/* 20 */     this.targetHpRate = exDamage;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 25 */     if ((null == inputObj.getSkill()) || (this.id != inputObj.getSkill().getID())) {
/* 26 */       return;
/*    */     }
/* 28 */     if (inputObj.isReleserOwn()) {
/* 29 */       Fighter target = inputObj.getTarget();
/* 30 */       if ((target != null) && 
/* 31 */         (target.isPetType())) {
/* 32 */         outputObj.skillDamageRate += this.skillDamageRate;
/* 33 */         outputObj.fixDamage += (int)(inputObj.getTarget().getMaxHp() * (this.targetHpRate / FightArgs.getInstance().getDefaultRate()));
/*    */         
/* 35 */         int passiveSkillid = getPassiveSkillid();
/* 36 */         if (passiveSkillid > 0) {
/* 37 */           outputObj.releasertriggerPassiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 46 */     fighter.addBeforeAttackHandle(this);
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 52 */     fighter.remBeforeAttackHandle(this);
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\PetTargetDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */