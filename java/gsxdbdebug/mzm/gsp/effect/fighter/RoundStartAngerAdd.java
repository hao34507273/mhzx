/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RoundStartAngerAdd extends FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle
/*    */ {
/*    */   private final int roundstartangeradd;
/*    */   
/*    */   public RoundStartAngerAdd(int value)
/*    */   {
/* 13 */     this.roundstartangeradd = value;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 18 */     if ((this.roundstartangeradd <= 0) || (this.roundstartangeradd <= 0)) {
/* 19 */       return;
/*    */     }
/*    */     
/* 22 */     if (!fighter.isAlive()) {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     fighter.addAnger(this.roundstartangeradd);
/* 27 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 28 */     fighterStatus.angerchange += this.roundstartangeradd;
/* 29 */     fighter.fillFighterStatus(fighterStatus);
/* 30 */     int passiveSkillid = getPassiveSkillid();
/* 31 */     if (passiveSkillid > 0) {
/* 32 */       fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 38 */     fighter.addRoundStartHandle(this);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 44 */     fighter.remRoundStartHandle(this);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAngerAdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */