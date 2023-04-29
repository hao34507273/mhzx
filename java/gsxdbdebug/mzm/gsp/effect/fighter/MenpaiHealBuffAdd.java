/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.confbean.SSkillCfg;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class MenpaiHealBuffAdd extends FighterEffect implements mzm.gsp.fight.handle.BeforeHealHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int effectid;
/*    */   private int effectrate;
/*    */   
/*    */   public MenpaiHealBuffAdd(int effectid, int effectrate)
/*    */   {
/* 20 */     this.effectid = effectid;
/* 21 */     this.effectrate = effectrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 26 */     fighter.addBeforeHealHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 32 */     fighter.remBeforeHealHandle(this);
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeHeal(BeforeHealHandle.InputObj inputObj, BeforeHealHandle.OutputObj outputObj)
/*    */   {
/* 38 */     Skill skill = inputObj.getSkill();
/* 39 */     if (skill == null) {
/* 40 */       return;
/*    */     }
/* 42 */     Fighter releaser = inputObj.getReleser();
/* 43 */     Fighter target = inputObj.getTarget();
/* 44 */     if ((releaser == null) || (target == null)) {
/* 45 */       return;
/*    */     }
/* 47 */     if ((skill.getSkillCfg().isMenPaiSkill) && (mzm.gsp.skill.main.SkillInterface.isSkillEffectType(skill.getSkillCfg().id, 7)))
/*    */     {
/* 49 */       int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 50 */       if (this.effectrate > random) {
/* 51 */         FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 52 */         if (effectGroup != null) {
/* 53 */           int level = super.getSkillLevel();
/* 54 */           effectGroup.run(level, target, target, target.getid());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 62 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 63 */     if (effectGroup == null) {
/* 64 */       throw new RuntimeException("MenpaiHealBuffAdd中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MenpaiHealBuffAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */