/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.confbean.SSkillCfg;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ChangeSkill extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.BeforeUseSkilHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int skillid;
/*    */   private int changeskillid;
/*    */   
/*    */   public ChangeSkill(int skillid, int changeskillid)
/*    */   {
/* 16 */     this.skillid = skillid;
/* 17 */     this.changeskillid = changeskillid;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeforeUseSkillHandle(this);
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 28 */     fighter.remBeforeUseSkillHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void beforeUseSkill(BeforeUseSkilHandle.InputObj inputObj, BeforeUseSkilHandle.OutputObj outputObj)
/*    */   {
/* 34 */     Skill skill = inputObj.getSkill();
/* 35 */     if ((skill != null) && 
/* 36 */       (skill.getID() == this.skillid)) {
/* 37 */       if (SSkillCfg.getAll().containsKey(Integer.valueOf(this.changeskillid))) {
/* 38 */         outputObj.changedSkill = this.changeskillid;
/*    */       } else {
/* 40 */         mzm.gsp.GameServer.logger().error("替换效果替换的技能不存在!!!changeSkillid:" + this.changeskillid);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean validate()
/*    */   {
/* 48 */     if (SSkillCfg.get(this.skillid) == null) {
/* 49 */       throw new RuntimeException("ChangeSkill效果的技能id不存在:skillid:" + this.skillid);
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ChangeSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */