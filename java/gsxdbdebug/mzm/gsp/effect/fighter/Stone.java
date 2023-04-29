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
/*    */ public class Stone extends FighterEffect implements mzm.gsp.effect.fighter.Interface.SealType
/*    */ {
/*    */   private int phydefrate;
/*    */   private int magdefrate;
/*    */   private int hitRate;
/*    */   
/*    */   public Stone(int phydefrate, int magdefrate, int hitRate)
/*    */   {
/* 19 */     this.phydefrate = phydefrate;
/* 20 */     this.magdefrate = magdefrate;
/* 21 */     this.hitRate = hitRate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 26 */     boolean isSeal = false;
/* 27 */     if (getGroup() == null) {
/* 28 */       return isSeal;
/*    */     }
/* 30 */     Fighter releaser = getGroup().getReleaser(fighter);
/* 31 */     if (releaser == null) {
/* 32 */       return isSeal;
/*    */     }
/* 34 */     BeforeSealHandle.OutputObj out = releaser.handleBeforeSeal(new BeforeSealHandle.InputObj(releaser, fighter, getGroup().getSkill()));
/*    */     
/* 36 */     int rate = out.sealRate + this.hitRate;
/* 37 */     isSeal = mzm.gsp.fight.main.FightFormulaHelp.isSealHit0(releaser, fighter, rate);
/* 38 */     if (isSeal) {
/* 39 */       fighter.addPHYDEFRate(this.phydefrate);
/* 40 */       fighter.addMAGDEFRate(this.magdefrate);
/* 41 */       fighter.addBuffState(102);
/* 42 */       if (fighter.isCmdedInRound()) {
/* 43 */         int leftRound = getGroup().getLeftRound();
/* 44 */         getGroup().setLeftRound(leftRound + SFightConsts.getInstance().SEAL_ACTIONED_ADD_LAST_ROUND);
/*    */       }
/*    */     } else {
/* 47 */       Skill skill = getGroup().getSkill();
/* 48 */       if (skill != null) {
/* 49 */         skill.addNotSealRet(releaser, fighter);
/*    */       }
/*    */     }
/* 52 */     return isSeal;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 58 */     fighter.addPHYDEFRate(-this.phydefrate);
/* 59 */     fighter.addMAGDEFRate(-this.magdefrate);
/* 60 */     fighter.remBuffState(102);
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Stone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */