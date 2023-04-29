/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.confbean.SSkillCfg;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ModifyMenpaiHeal extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeHealHandle
/*    */ {
/*    */   private int healeffectrate;
/*    */   
/*    */   public ModifyMenpaiHeal(int healeffectrate)
/*    */   {
/* 15 */     this.healeffectrate = healeffectrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 20 */     fighter.addBeforeHealHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remBeforeHealHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeHeal(BeforeHealHandle.InputObj inputObj, BeforeHealHandle.OutputObj outputObj)
/*    */   {
/* 32 */     Skill skill = inputObj.getSkill();
/* 33 */     if (skill == null) {
/* 34 */       return;
/*    */     }
/* 36 */     if ((skill.getSkillCfg().isMenPaiSkill) && (mzm.gsp.skill.main.SkillInterface.isSkillEffectType(skill.getSkillCfg().id, 7)))
/*    */     {
/* 38 */       outputObj.healeffectrate += this.healeffectrate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMenpaiHeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */