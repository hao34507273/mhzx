/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class PetArenaAwardObserver extends Observer
/*    */ {
/*    */   private final long intervalSeconds;
/*    */   
/*    */   public PetArenaAwardObserver(long delaySeconds, long intervalSeconds)
/*    */   {
/* 11 */     super(delaySeconds);
/* 12 */     this.intervalSeconds = intervalSeconds;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 18 */     setIntervalSeconds(this.intervalSeconds);
/* 19 */     PetArenaRankManager.asyncPetArenaAward();
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */