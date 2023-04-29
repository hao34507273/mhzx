/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.confbean.SFightConsts;
/*    */ import mzm.gsp.fight.handle.BeforeSealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeSealHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.TauntHandle;
/*    */ import mzm.gsp.fight.main.FightFormulaHelp;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class Taunt extends FighterEffect implements TauntHandle, mzm.gsp.effect.fighter.Interface.SealType
/*    */ {
/*    */   private int hitRate;
/*    */   
/*    */   public Taunt(int hitRate)
/*    */   {
/* 19 */     this.hitRate = hitRate;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     boolean isSeal = false;
/* 26 */     if (getGroup() == null) {
/* 27 */       return isSeal;
/*    */     }
/* 29 */     Fighter releaser = getGroup().getReleaser(fighter);
/* 30 */     if (releaser == null) {
/* 31 */       return isSeal;
/*    */     }
/* 33 */     BeforeSealHandle.OutputObj out = releaser.handleBeforeSeal(new BeforeSealHandle.InputObj(releaser, fighter, getGroup().getSkill()));
/*    */     
/* 35 */     int rate = out.sealRate + this.hitRate;
/* 36 */     isSeal = FightFormulaHelp.isSealHit0(releaser, fighter, rate);
/* 37 */     if (isSeal) {
/* 38 */       fighter.addBuffState(127);
/* 39 */       fighter.addTauntHandle(this);
/* 40 */       if (fighter.isCmdedInRound()) {
/* 41 */         int leftRound = getGroup().getLeftRound();
/* 42 */         getGroup().setLeftRound(leftRound + SFightConsts.getInstance().SEAL_ACTIONED_ADD_LAST_ROUND);
/*    */       }
/*    */     } else {
/* 45 */       Skill skill = getGroup().getSkill();
/* 46 */       if (skill != null) {
/* 47 */         skill.addNotSealRet(releaser, fighter);
/*    */       }
/*    */     }
/* 50 */     return isSeal;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 56 */     fighter.remBuffState(127);
/* 57 */     fighter.remTauntHandle(this);
/* 58 */     return true;
/*    */   }
/*    */   
/*    */   public int getTauntTarget(Fighter fighter)
/*    */   {
/* 63 */     FighterBuff fighterBuff = getGroup();
/* 64 */     if (fighterBuff == null) {
/* 65 */       return -1;
/*    */     }
/* 67 */     Fighter releaser = fighterBuff.getReleaser(fighter);
/* 68 */     if ((releaser == null) || (releaser.isFakeDead()) || (releaser.isDead())) {
/* 69 */       return -1;
/*    */     }
/* 71 */     return releaser.getid();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Taunt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */