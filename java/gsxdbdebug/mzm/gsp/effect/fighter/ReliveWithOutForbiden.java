/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
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
/*    */ public class ReliveWithOutForbiden extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.ReliveType
/*    */ {
/*    */   private int rebirthwithhp;
/*    */   private int hprate;
/*    */   
/*    */   public ReliveWithOutForbiden(int rebirthwithhp, int hprate)
/*    */   {
/* 22 */     this.rebirthwithhp = rebirthwithhp;
/* 23 */     this.hprate = hprate;
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
/*    */ 
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 39 */     BeforeHealHandle.OutputObj outputObj = releaser.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/* 41 */     BeforeHealHandle.OutputObj tagertOutputObj = target.handleBeforeHeal(new BeforeHealHandle.InputObj(releaser, target, skill, effectGroup));
/*    */     
/*    */ 
/* 44 */     boolean iscrt = FightFormulaHelp.isHealCrt(releaser.getMAGCRTRate(), releaser, target);
/* 45 */     int healValue = FightFormulaHelp.calHealOnce(releaser, target, iscrt, outputObj, tagertOutputObj);
/* 46 */     healValue += this.rebirthwithhp;
/* 47 */     healValue = (int)(healValue + target.getMaxHp() * (this.hprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */     
/* 49 */     target.addHp(healValue);
/* 50 */     target.setAlive();
/* 51 */     target.addActionCount();
/* 52 */     target.onRelive();
/*    */     
/* 54 */     AttackResult attackResult = skill.getAttackResult(target.getid());
/*    */     
/* 56 */     AttackResultBean attackResultBean = new AttackResultBean();
/* 57 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 58 */     attackResultBean.targetstatus.status_set.add(Integer.valueOf(23));
/*    */     
/* 60 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releaserPassiveSkills);
/*    */     
/* 62 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkills);
/*    */     
/* 64 */     releaser.fillFighterStatus(attackResultBean.attackerstatus);
/*    */     
/* 66 */     attackResult.attackresultbeans.add(attackResultBean);
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ReliveWithOutForbiden.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */