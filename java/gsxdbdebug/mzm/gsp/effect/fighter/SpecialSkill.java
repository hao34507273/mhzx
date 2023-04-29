/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.confbean.SSkillCfg;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class SpecialSkill extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeAttackHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int skillid;
/*    */   private int rate1;
/*    */   private int rate2;
/*    */   private int exdamagerate1;
/*    */   private int exdamagerate2;
/*    */   private int exdamagerate3;
/*    */   
/*    */   public SpecialSkill(int skillid, int rate1, int rate2, int exdamagerate1, int exdamagerate2, int exdamagerate3)
/*    */   {
/* 21 */     this.skillid = skillid;
/* 22 */     this.rate1 = rate1;
/* 23 */     this.rate2 = rate2;
/* 24 */     this.exdamagerate1 = exdamagerate1;
/* 25 */     this.exdamagerate2 = exdamagerate2;
/* 26 */     this.exdamagerate3 = exdamagerate3;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 31 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/* 32 */     if (skillCfg == null) {
/* 33 */       throw new RuntimeException("SpecialSkill效果配置的技能id不存在,skillid:" + this.skillid);
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 40 */     fighter.addBeforeAttackHandle(this);
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 46 */     fighter.remBeforeAttackHandle(this);
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeAttack(BeforeAttackHandle.InputObj inputObj, BeforeAttackHandle.OutputObj outputObj)
/*    */   {
/* 52 */     Skill skill = inputObj.getSkill();
/* 53 */     if ((skill != null) && (skill.getID() == this.skillid)) {
/* 54 */       int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 55 */       if (random < this.rate1) {
/* 56 */         outputObj.bedamagerate += this.exdamagerate1;
/* 57 */       } else if (random < this.rate2) {
/* 58 */         outputObj.bedamagerate += this.exdamagerate2;
/*    */       } else {
/* 60 */         outputObj.bedamagerate += this.exdamagerate3;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SpecialSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */