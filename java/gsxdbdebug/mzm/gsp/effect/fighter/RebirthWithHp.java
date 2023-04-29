/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResult;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightFormulaHelp;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class RebirthWithHp extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.ReliveType
/*    */ {
/*    */   private int rebirthwithhp;
/*    */   private int needFormula;
/*    */   
/*    */   public RebirthWithHp(int rebirthwithhp, int needFormula)
/*    */   {
/* 22 */     this.rebirthwithhp = rebirthwithhp;
/* 23 */     this.needFormula = needFormula;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 38 */     if ((target.isExisted()) && 
/* 39 */       (target.isFakeDead())) {
/* 40 */       int hp = this.rebirthwithhp;
/* 41 */       BeforeHealHandle.OutputObj outputObj = null;
/* 42 */       BeforeHealHandle.OutputObj tagertOutputObj = null;
/* 43 */       if (this.needFormula > 0)
/*    */       {
/* 45 */         outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */         
/* 47 */         tagertOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */         
/* 49 */         outputObj.healFix += hp;
/*    */         
/* 51 */         boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, target);
/* 52 */         hp = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagertOutputObj);
/*    */       }
/*    */       
/*    */ 
/* 56 */       boolean isRelive = target.reliveWithHp(hp);
/* 57 */       if (!isRelive) {
/* 58 */         return true;
/*    */       }
/* 60 */       AttackResult attackResult = skill.getAttackResult(target.getid());
/*    */       
/* 62 */       AttackResultBean attackResultBean = new AttackResultBean();
/* 63 */       target.fillFighterStatus(attackResultBean.targetstatus);
/* 64 */       attackResultBean.targetstatus.hpchange += target.getHp();
/*    */       
/* 66 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(23));
/*    */       
/* 68 */       releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*    */       
/* 70 */       attackResult.attackresultbeans.add(attackResultBean);
/*    */       
/* 72 */       if (outputObj != null) {
/* 73 */         attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/*    */       }
/* 75 */       if (tagertOutputObj != null) {
/* 76 */         attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkills);
/*    */       }
/* 78 */       return true;
/*    */     }
/*    */     
/* 81 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RebirthWithHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */