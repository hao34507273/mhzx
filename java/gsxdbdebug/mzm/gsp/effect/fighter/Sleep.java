/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.fight.handle.BeforeSealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeSealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class Sleep extends FighterEffect implements mzm.gsp.effect.fighter.Interface.SealType
/*    */ {
/*    */   private int hitRate;
/*    */   
/*    */   public Sleep(int hitRate)
/*    */   {
/* 17 */     this.hitRate = hitRate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 22 */     boolean isSeal = false;
/*    */     
/* 24 */     if (getGroup() == null) {
/* 25 */       return isSeal;
/*    */     }
/* 27 */     Fighter releaser = getGroup().getReleaser(fighter);
/* 28 */     if (releaser == null) {
/* 29 */       return isSeal;
/*    */     }
/* 31 */     BeforeSealHandle.OutputObj out = releaser.handleBeforeSeal(new BeforeSealHandle.InputObj(releaser, fighter, getGroup().getSkill()));
/*    */     
/* 33 */     int rate = out.sealRate + this.hitRate;
/*    */     
/* 35 */     isSeal = mzm.gsp.fight.main.FightFormulaHelp.isSealHit0(releaser, fighter, rate);
/*    */     
/* 37 */     if (isSeal) {
/* 38 */       fighter.addBuffState(101);
/* 39 */       if (fighter.isCmdedInRound()) {
/* 40 */         int leftRound = getGroup().getLeftRound();
/* 41 */         getGroup().setLeftRound(leftRound + SFightConsts.getInstance().SEAL_ACTIONED_ADD_LAST_ROUND);
/*    */       }
/*    */     } else {
/* 44 */       Skill skill = getGroup().getSkill();
/* 45 */       if (skill != null) {
/* 46 */         skill.addNotSealRet(releaser, fighter);
/*    */       }
/*    */     }
/* 49 */     return isSeal;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 55 */     fighter.remBuffState(101);
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Sleep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */