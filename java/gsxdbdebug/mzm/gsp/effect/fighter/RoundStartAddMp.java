/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RoundStartAddMp extends FighterEffect implements mzm.gsp.fight.handle.RoundStartHandle
/*    */ {
/*    */   private int roundstartaddmp;
/*    */   private int roundstartaddmprate;
/*    */   
/*    */   public RoundStartAddMp(int roundstartaddmp, int roundstartaddmprate)
/*    */   {
/* 15 */     this.roundstartaddmp = roundstartaddmp;
/* 16 */     this.roundstartaddmprate = roundstartaddmprate;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 21 */     if (!fighter.isAlive()) {
/* 22 */       return;
/*    */     }
/* 24 */     int finalMp = (int)(this.roundstartaddmp + fighter.getMaxMp() * (this.roundstartaddmprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*    */     
/* 26 */     fighter.addMp(finalMp);
/* 27 */     FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 28 */     fighterStatus.mpchange += finalMp;
/* 29 */     fighter.fillFighterStatus(fighterStatus);
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 34 */     fighter.addRoundStartHandle(this);
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 40 */     fighter.remRoundStartHandle(this);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAddMp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */