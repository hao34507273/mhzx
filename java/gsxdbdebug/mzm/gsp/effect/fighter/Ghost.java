/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.ReliveType;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class Ghost extends FighterEffect implements mzm.gsp.fight.handle.RoundEndHandle, ReliveType, BeKilledHandle
/*    */ {
/*    */   private int ghosttimes;
/*    */   private int canBeHealed;
/* 15 */   private int currentRound = 0;
/*    */   private static final int CAN_HEAL = 1;
/*    */   
/*    */   public Ghost(int ghosttimes, int canBeHealed)
/*    */   {
/* 20 */     this.ghosttimes = ghosttimes;
/* 21 */     this.canBeHealed = canBeHealed;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 26 */     fighter.addBuffState(113);
/* 27 */     fighter.addRoundEndHandle(this);
/* 28 */     fighter.addBeKilledHandle(this);
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 34 */     fighter.remBuffState(113);
/* 35 */     fighter.remRoundEndHandle(this);
/* 36 */     fighter.remBeKilledHandle(this);
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter fighter)
/*    */   {
/* 42 */     if (fighter.isFakeDead()) {
/* 43 */       this.currentRound += 1;
/* 44 */       if (this.currentRound >= this.ghosttimes) {
/* 45 */         int hpchange = (int)fighter.getMaxHp();
/* 46 */         int mpchange = (int)fighter.getMaxMp();
/* 47 */         boolean live = fighter.reliveWithHp(hpchange);
/* 48 */         if (!live) {
/* 49 */           return;
/*    */         }
/* 51 */         FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/*    */         
/* 53 */         fighter.addMp(mpchange);
/* 54 */         fighterStatus.hpchange += hpchange;
/* 55 */         fighterStatus.mpchange += mpchange;
/* 56 */         fighterStatus.status_set.add(Integer.valueOf(23));
/* 57 */         fighter.fillFighterStatus(fighterStatus);
/*    */         
/* 59 */         this.currentRound = 0;
/*    */       }
/*    */     } else {
/* 62 */       this.currentRound = 0;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean canBeHealed() {
/* 67 */     return 1 == this.canBeHealed;
/*    */   }
/*    */   
/*    */ 
/*    */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*    */   {
/* 73 */     this.currentRound = 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Ghost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */