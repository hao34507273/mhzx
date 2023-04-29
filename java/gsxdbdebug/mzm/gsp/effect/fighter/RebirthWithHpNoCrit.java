/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
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
/*    */ public class RebirthWithHpNoCrit extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.ReliveType
/*    */ {
/*    */   private int rebirthwithhp;
/*    */   private int exheal;
/*    */   
/*    */   public RebirthWithHpNoCrit(int rebirthwithhp, int exheal)
/*    */   {
/* 21 */     this.rebirthwithhp = rebirthwithhp;
/* 22 */     this.exheal = exheal;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 37 */     if ((target.isExisted()) && 
/* 38 */       (target.isFakeDead())) {
/* 39 */       int hp = this.rebirthwithhp;
/*    */       
/* 41 */       BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */       
/* 43 */       BeforeHealHandle.OutputObj tagertOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */       
/* 45 */       outputObj.healFix += hp;
/* 46 */       outputObj.modifyParam += this.exheal;
/*    */       
/* 48 */       boolean iscrt = false;
/* 49 */       hp = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagertOutputObj);
/*    */       
/* 51 */       boolean isRelive = target.reliveWithHp(hp);
/* 52 */       if (!isRelive) {
/* 53 */         return true;
/*    */       }
/* 55 */       target.clearAnger();
/*    */       
/* 57 */       AttackResult attackResult = skill.getAttackResult(target.getid());
/*    */       
/* 59 */       AttackResultBean attackResultBean = new AttackResultBean();
/* 60 */       target.fillFighterStatus(attackResultBean.targetstatus);
/* 61 */       attackResultBean.targetstatus.hpchange += target.getHp();
/*    */       
/* 63 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(23));
/*    */       
/* 65 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/*    */       
/* 67 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkills);
/*    */       
/* 69 */       releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*    */       
/* 71 */       attackResult.attackresultbeans.add(attackResultBean);
/* 72 */       return true;
/*    */     }
/*    */     
/* 75 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RebirthWithHpNoCrit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */