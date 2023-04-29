/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.effect.fighter.Interface.ReliveType;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResult;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.FightFormulaHelp;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class RebirthWithHpRate extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, ReliveType
/*    */ {
/*    */   private int rebirthwithphrate;
/*    */   private int ratemax;
/*    */   private int needFormula;
/*    */   
/*    */   public RebirthWithHpRate(int rebirthwithphrate, int ratemax, int needFormula)
/*    */   {
/* 25 */     if (rebirthwithphrate > ratemax) {
/* 26 */       this.rebirthwithphrate = ratemax;
/*    */     } else {
/* 28 */       this.rebirthwithphrate = rebirthwithphrate;
/*    */     }
/* 30 */     this.needFormula = needFormula;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 45 */     if ((target.isExisted()) && (
/* 46 */       (target.isFakeDead()) || (target.isDead()))) {
/* 47 */       int hp = (int)(target.getMaxHp() * (this.rebirthwithphrate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */       
/* 49 */       BeforeHealHandle.OutputObj outputObj = null;
/* 50 */       BeforeHealHandle.OutputObj tagertOutputObj = null;
/*    */       
/* 52 */       if (this.needFormula > 0)
/*    */       {
/* 54 */         outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */         
/* 56 */         tagertOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */         
/* 58 */         outputObj.healFix += hp;
/*    */         
/* 60 */         boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, target);
/* 61 */         hp = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagertOutputObj);
/*    */       }
/* 63 */       boolean isRelive = target.reliveWithHp(hp);
/* 64 */       if (!isRelive) {
/* 65 */         return true;
/*    */       }
/* 67 */       AttackResult attackResult = skill.getAttackResult(target.getid());
/*    */       
/* 69 */       AttackResultBean attackResultBean = new AttackResultBean();
/* 70 */       target.fillFighterStatus(attackResultBean.targetstatus);
/* 71 */       attackResultBean.targetstatus.hpchange += target.getHp();
/* 72 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(23));
/*    */       
/* 74 */       if (outputObj != null) {
/* 75 */         attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/*    */       }
/* 77 */       if (tagertOutputObj != null) {
/* 78 */         attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkills);
/*    */       }
/*    */       
/* 81 */       releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*    */       
/* 83 */       attackResult.attackresultbeans.add(attackResultBean);
/* 84 */       return true;
/*    */     }
/*    */     
/* 87 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RebirthWithHpRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */