/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class MenPaiSkillLevel extends FighterEffect implements mzm.gsp.effect.fighter.Interface.Validate, BeforeUseSkilHandle
/*    */ {
/*    */   private int id;
/*    */   private int level;
/*    */   
/*    */   public MenPaiSkillLevel(int id, int level)
/*    */   {
/* 16 */     this.id = id;
/* 17 */     this.level = level;
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
/*    */   public boolean validate()
/*    */   {
/* 34 */     return mzm.gsp.skill.main.SkillInterface.getSkill(this.id, this.level) != null;
/*    */   }
/*    */   
/*    */   public void beforeUseSkill(BeforeUseSkilHandle.InputObj inputObj, BeforeUseSkilHandle.OutputObj outputObj)
/*    */   {
/* 39 */     outputObj.skillLevelModify += this.level;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MenPaiSkillLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */