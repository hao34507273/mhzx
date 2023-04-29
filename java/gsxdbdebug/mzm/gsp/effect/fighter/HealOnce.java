/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightFormulaHelp;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class HealOnce extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.HealType
/*    */ {
/*    */   private int hp;
/*    */   
/*    */   public HealOnce(int hp)
/*    */   {
/* 18 */     this.hp = hp;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean perform(Skill skill, mzm.gsp.effect.main.FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 33 */     BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/* 35 */     BeforeHealHandle.OutputObj tagertOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/* 37 */     outputObj.baseHeal += this.hp;
/*    */     
/* 39 */     boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, target);
/*    */     
/* 41 */     int healValue = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagertOutputObj);
/*    */     
/* 43 */     target.handleHeal(healValue);
/* 44 */     AttackResultBean attackResultBean = skill.addHealHpRet(releaser, target, healValue, iscrt);
/* 45 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/* 46 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkills);
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HealOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */