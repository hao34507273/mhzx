/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class SealSkill extends mzm.gsp.effect.main.FighterEffect implements BeforeUseSkilHandle
/*    */ {
/*    */   private int round;
/*    */   private int skillid;
/*    */   
/*    */   public SealSkill(int paramInt)
/*    */   {
/* 16 */     this.round = paramInt;
/* 17 */     this.skillid = 0;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter) {
/* 21 */     paramFighter.addBeforeUseSkillHandle(this);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter) {
/* 26 */     paramFighter.remBeforeUseSkillHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public void beforeUseSkill(BeforeUseSkilHandle.InputObj paramInputObj, BeforeUseSkilHandle.OutputObj paramOutputObj) {
/* 31 */     Skill localSkill = paramInputObj.getSkill();
/* 32 */     if (localSkill != null) {
/* 33 */       if (this.skillid == 0) {
/* 34 */         this.skillid = localSkill.getID();
/* 35 */         int i = Math.max(0, getLeftRound() + this.round);
/* 36 */         setLeftRound(i);
/*    */       }
/* 38 */       else if (localSkill.getID() == this.skillid) {
/* 39 */         paramOutputObj.seal = true;
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SealSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */