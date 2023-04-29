/*   */ package mzm.gsp.ladder.main;
/*   */ 
/*   */ class LadderMatchContextManager extends LadderContextManager<String, LadderMatchEndContext> {
/* 4 */   private static final LadderMatchContextManager instance = new LadderMatchContextManager();
/*   */   
/*   */   static LadderMatchContextManager getInstance() {
/* 7 */     return instance;
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderMatchContextManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */