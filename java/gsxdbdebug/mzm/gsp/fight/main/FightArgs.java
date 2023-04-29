/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightArgs
/*    */ {
/* 11 */   private static FightArgs instance = new FightArgs();
/*    */   int beforeFightMillis;
/*    */   
/* 14 */   public static FightArgs getInstance() { return instance; }
/*    */   
/*    */ 
/*    */   int fightEndMillis;
/*    */   
/* 19 */   int defaultRate = 10000;
/* 20 */   int updateSec = 20;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 25 */   int roamFightRecordDelayNotifyRound = 5;
/*    */   
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 31 */     instance = (FightArgs)ConfManager.getInstance().getconf("mzm.gsp.fight.main.FightArgs");
/* 32 */     if (instance == null) {
/* 33 */       throw new RuntimeException("找不到战斗程序配置：mzm.gsp.fight.main.FightArgs");
/*    */     }
/*    */   }
/*    */   
/*    */   public int getDefaultRate() {
/* 38 */     return this.defaultRate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */