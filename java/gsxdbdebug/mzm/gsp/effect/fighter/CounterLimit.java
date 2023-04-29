/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.CounterHandle.InputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class CounterLimit extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.CounterHandle
/*    */ {
/*    */   private int limit;
/*    */   private int curRound;
/*    */   private int counterTimes;
/*    */   
/*    */   public CounterLimit(int limit)
/*    */   {
/* 14 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 19 */     fighter.addCounterHandle(this);
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 25 */     fighter.remCounterHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public void beforeCounter(CounterHandle.InputObj inputObj, mzm.gsp.fight.handle.CounterHandle.OutputObj outputObj)
/*    */   {
/* 31 */     Fighter releaser = inputObj.getReleser();
/* 32 */     if (releaser == null) {
/* 33 */       outputObj.isCanCounter = false;
/* 34 */       return;
/*    */     }
/* 36 */     int round = releaser.getRound();
/* 37 */     if ((round == this.curRound) && 
/* 38 */       (this.counterTimes >= this.limit)) {
/* 39 */       outputObj.isCanCounter = false;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void afterCounter(CounterHandle.InputObj inputObj, mzm.gsp.fight.handle.CounterHandle.OutputObj outputObj)
/*    */   {
/* 46 */     Fighter releaser = inputObj.getReleser();
/* 47 */     if (releaser == null) {
/* 48 */       return;
/*    */     }
/* 50 */     int round = releaser.getRound();
/* 51 */     if (round != this.curRound) {
/* 52 */       this.curRound = round;
/* 53 */       this.counterTimes = 1;
/*    */     } else {
/* 55 */       this.counterTimes += 1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\CounterLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */