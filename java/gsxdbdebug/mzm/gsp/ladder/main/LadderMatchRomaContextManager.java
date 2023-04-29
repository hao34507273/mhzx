/*   */ package mzm.gsp.ladder.main;
/*   */ 
/*   */ import mzm.gsp.crossserver.main.RoamedMatchContext;
/*   */ 
/*   */ class LadderMatchRomaContextManager extends LadderContextManager<Long, RoamedMatchContext> {
/* 6 */   private static final LadderMatchRomaContextManager instance = new LadderMatchRomaContextManager();
/*   */   
/*   */   static LadderMatchRomaContextManager getInstance() {
/* 9 */     return instance;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderMatchRomaContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */