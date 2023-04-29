/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
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
/*    */ public class HealRateOnce extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.HealType
/*    */ {
/*    */   private int hprate;
/*    */   private int maxlimit;
/*    */   
/*    */   public HealRateOnce(int hprate, int maxlimit)
/*    */   {
/* 21 */     this.hprate = hprate;
/* 22 */     if (this.hprate >= maxlimit) {
/* 23 */       this.hprate = maxlimit;
/*    */     }
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
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 39 */     double healbase = target.getMaxHp() * (this.hprate * 1.0D / FightArgs.getInstance().getDefaultRate());
/* 40 */     BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/* 42 */     BeforeHealHandle.OutputObj tagertOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup)); BeforeHealHandle.OutputObj 
/*    */     
/* 44 */       tmp62_60 = outputObj;tmp62_60.baseHeal = ((int)(tmp62_60.baseHeal + healbase));
/* 45 */     boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, target);
/* 46 */     int healValue = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagertOutputObj);
/* 47 */     int finalHeal = target.handleHeal(healValue);
/*    */     
/* 49 */     AttackResultBean attackResultBean = skill.addHealHpRet(releaser, target, finalHeal, iscrt);
/* 50 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/* 51 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkills);
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 57 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HealRateOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */