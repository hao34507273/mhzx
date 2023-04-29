/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PositionDamage
/*    */   extends FighterEffect
/*    */   implements OpOnce
/*    */ {
/*    */   final int fighterType;
/*    */   final int row;
/*    */   final int skillDamageRate;
/*    */   private static final int ROW_1 = 1;
/*    */   private static final int ROW_2 = 2;
/*    */   private static final int ROW_3 = 4;
/*    */   
/*    */   public PositionDamage(int fighterType, int position, int skillDamageRate)
/*    */   {
/* 35 */     this.fighterType = fighterType;
/* 36 */     this.row = position;
/* 37 */     this.skillDamageRate = skillDamageRate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter targetParam)
/*    */   {
/* 52 */     Set<Fighter> targets = genTargets(releaser);
/* 53 */     for (Fighter target : targets) {
/* 54 */       BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */       
/* 56 */       BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */       
/* 58 */       outputObj.skillDamageRate += this.skillDamageRate;
/*    */       
/* 60 */       FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */       
/*    */ 
/* 63 */       FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 64 */       FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */       
/* 66 */       skill.addEffectTarget(target.getid());
/*    */     }
/*    */     
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   private Set<Fighter> genTargets(Fighter releaser) {
/* 73 */     Set<Fighter> targets = new HashSet();
/* 74 */     Set<Fighter> fighters = releaser.getEnermyLiveFighters();
/* 75 */     for (Fighter fighter : fighters)
/* 76 */       if ((fighter.getType() & this.fighterType) > 0)
/*    */       {
/*    */ 
/* 79 */         int fighterRow = fighter.getRow();
/* 80 */         if (fighterRow == 0 ? 
/* 81 */           (this.row & 0x1) > 0 : 
/*    */           
/*    */ 
/* 84 */           fighterRow == 1 ? 
/* 85 */           (this.row & 0x2) > 0 : 
/*    */           
/*    */ 
/* 88 */           (fighterRow != 2) || 
/* 89 */           ((this.row & 0x4) > 0))
/*    */         {
/*    */ 
/*    */ 
/* 93 */           targets.add(fighter); }
/*    */       }
/* 95 */     return targets;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\PositionDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */