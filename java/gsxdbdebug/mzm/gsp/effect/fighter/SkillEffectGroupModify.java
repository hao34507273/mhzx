/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.effect.fighter.Interface.Validate;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillEffectGroupModify
/*    */   extends FighterEffect
/*    */   implements BeforeUseSkilHandle, Validate
/*    */ {
/*    */   private int skillid;
/*    */   private int oldEffectGroupId;
/*    */   private int newEffectGroupId;
/*    */   private int modificationRate;
/*    */   
/*    */   public SkillEffectGroupModify(int skillId, int oldEffectGroupId, int newEffectGroupId, int modificationRate)
/*    */   {
/* 31 */     this.skillid = skillId;
/* 32 */     this.oldEffectGroupId = oldEffectGroupId;
/* 33 */     this.newEffectGroupId = newEffectGroupId;
/* 34 */     this.modificationRate = modificationRate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 39 */     fighter.addBeforeUseSkillHandle(this);
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 45 */     fighter.remBeforeUseSkillHandle(this);
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public void beforeUseSkill(BeforeUseSkilHandle.InputObj inputObj, BeforeUseSkilHandle.OutputObj outputObj)
/*    */   {
/* 51 */     Skill skill = inputObj.getSkill();
/* 52 */     if ((skill != null) && 
/* 53 */       (skill.getID() == this.skillid)) {
/* 54 */       int rate = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 55 */       if (this.modificationRate <= rate)
/*    */       {
/* 57 */         return;
/*    */       }
/* 59 */       skill.addReplacedEffectGroupId(this.oldEffectGroupId, this.newEffectGroupId);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean validate()
/*    */   {
/* 67 */     SSkillEffectGroupCfg effectGroupCfg = SSkillEffectGroupCfg.get(this.newEffectGroupId);
/* 68 */     if (effectGroupCfg == null) {
/* 69 */       return false;
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SkillEffectGroupModify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */