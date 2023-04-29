/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.AftUseSkilHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class AfterSkillsBuffAdd extends FighterEffect implements mzm.gsp.fight.handle.AftUseSkilHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int effectid;
/*    */   private int effectrate;
/*    */   
/*    */   public AfterSkillsBuffAdd(int effectid, int effectrate)
/*    */   {
/* 19 */     this.effectid = effectid;
/* 20 */     this.effectrate = effectrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     fighter.addAftUseSkillHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 31 */     fighter.remAftUseSkillHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public void aftUseSkill(AftUseSkilHandle.InputObj inputObj, AftUseSkilHandle.OutputObj outputObj)
/*    */   {
/* 37 */     Skill skill = inputObj.getSkill();
/*    */     
/* 39 */     if (skill == null) {
/* 40 */       return;
/*    */     }
/* 42 */     Fighter releaser = inputObj.getReleser();
/* 43 */     if (releaser == null) {
/* 44 */       return;
/*    */     }
/*    */     
/* 47 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 48 */     if (this.effectrate <= random) {
/* 49 */       return;
/*    */     }
/* 51 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 52 */     if (addGroup != null) {
/* 53 */       int level = super.getSkillLevel();
/*    */       
/* 55 */       addGroup.run(level, releaser, releaser, releaser.getid());
/* 56 */       releaser.fillFighterStatus(skill.getAfterSkillUseFighterStatus());
/*    */     } else {
/* 58 */       mzm.gsp.GameServer.logger().error(String.format("AfterSkillsBuffAdd中配置的效果组id不存在|id=%d", new Object[] { Integer.valueOf(this.effectid) }));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean validate()
/*    */   {
/* 65 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 66 */     if (effectGroup == null) {
/* 67 */       throw new RuntimeException("AfterSkillsBuffAdd中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AfterSkillsBuffAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */