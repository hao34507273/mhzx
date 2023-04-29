/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class FixedHpRoundStartAddFixHp extends FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle
/*    */ {
/*    */   private final int roundStartAddHp;
/*    */   private final int maxHpRate;
/*    */   
/*    */   public FixedHpRoundStartAddFixHp(int roundstartaddhp, int hprate)
/*    */   {
/* 15 */     this.roundStartAddHp = roundstartaddhp;
/* 16 */     this.maxHpRate = hprate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 21 */     fighter.addRoundStartHandle(this);
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 27 */     fighter.remRoundStartHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 33 */     if ((this.roundStartAddHp <= 0) || (this.maxHpRate <= 0)) {
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     if (!fighter.isAlive()) {
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     if (fighter.getHp() >= fighter.getMaxHp() * this.maxHpRate / FightArgs.getInstance().getDefaultRate()) {
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     fighter.addHp(this.roundStartAddHp);
/* 46 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 47 */     fighterStatus.hpchange += this.roundStartAddHp;
/* 48 */     fighter.fillFighterStatus(fighterStatus);
/* 49 */     int passiveSkillid = getPassiveSkillid();
/* 50 */     if (passiveSkillid > 0) {
/* 51 */       fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\FixedHpRoundStartAddFixHp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */