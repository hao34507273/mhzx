/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.effect.fighter.Interface.HealType;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.FightFormulaHelp;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ModifyHealOnceNoCrit extends FighterEffect implements OpOnce, HealType
/*    */ {
/*    */   private int hp;
/*    */   private int hprate;
/*    */   private int exheal;
/*    */   private int maxheal;
/*    */   
/*    */   public ModifyHealOnceNoCrit(int hp, int hprate, int exheal, int maxheal)
/*    */   {
/* 26 */     this.hp = hp;
/* 27 */     this.hprate = hprate;
/* 28 */     this.exheal = exheal;
/* 29 */     this.maxheal = maxheal;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 35 */     int baseHeal = (int)(this.hp + target.getMaxHp() * (this.hprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 36 */     boolean iscrt = false;
/* 37 */     BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/* 39 */     BeforeHealHandle.OutputObj tagetOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/* 41 */     outputObj.baseHeal += baseHeal;
/* 42 */     outputObj.modifyParam += this.exheal;
/*    */     
/* 44 */     int healValue = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagetOutputObj);
/* 45 */     healValue = Math.min(this.maxheal, healValue);
/* 46 */     target.handleHeal(healValue);
/* 47 */     AttackResultBean attackResultBean = skill.addHealHpRet(releaser, target, healValue, iscrt);
/* 48 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/* 49 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(tagetOutputObj.targetPassiveSkills);
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 55 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyHealOnceNoCrit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */