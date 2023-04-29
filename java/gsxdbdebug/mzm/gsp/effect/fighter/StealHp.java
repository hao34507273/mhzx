/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class StealHp extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int type;
/*    */   private int changerate;
/*    */   private int damagerate;
/* 20 */   private final int SKILL_NORMAL_MASK = 1;
/* 21 */   private final int SKILL_PHY_MASK = 2;
/* 22 */   private final int SKILL_MAG_MASK = 4;
/* 23 */   private final int SKILL_SPECIAL_MASK = 8;
/*    */   
/*    */   public StealHp(int type, int changerate, int damagerate) {
/* 26 */     this.type = type;
/* 27 */     this.changerate = changerate;
/* 28 */     this.damagerate = damagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 43 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 45 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 47 */     outputObj.damageRate += this.damagerate;
/* 48 */     outputObj.isStealHp = isSKillSuitStealHp(skill);
/* 49 */     outputObj.stealDamageRate += this.changerate;
/*    */     
/* 51 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/*    */ 
/* 54 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 55 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 57 */     return damageOutputObj.isHit;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean isSKillSuitStealHp(Skill skill)
/*    */   {
/* 67 */     if (skill == null) {
/* 68 */       return false;
/*    */     }
/* 70 */     if (FightInterface.isNormalAttackSkill(skill.getID())) {
/* 71 */       if ((0x1 & this.type) > 0) {
/* 72 */         return true;
/*    */       }
/* 74 */     } else if (skill.getType() == 2) {
/* 75 */       if ((0x4 & this.type) > 0) {
/* 76 */         return true;
/*    */       }
/* 78 */     } else if (skill.getType() == 1) {
/* 79 */       if ((0x2 & this.type) > 0) {
/* 80 */         return true;
/*    */       }
/* 82 */     } else if (skill.getType() == 4) {
/* 83 */       if ((0x8 & this.type) > 0) {
/* 84 */         return true;
/*    */       }
/*    */     } else {
/* 87 */       GameServer.logger().error("StealHp:不存在的技能类型:type:" + skill.getType());
/*    */     }
/* 89 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\StealHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */