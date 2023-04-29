/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BallBattleLogger
/*    */ {
/* 15 */   private static final Logger LOGGER = Logger.getLogger(BallBattleLogger.class);
/*    */   
/*    */   static boolean isDebugEnabled()
/*    */   {
/* 19 */     return LOGGER.isDebugEnabled();
/*    */   }
/*    */   
/*    */   static void debug(Object msg)
/*    */   {
/* 24 */     LOGGER.debug("[BallBattle]" + msg);
/*    */   }
/*    */   
/*    */   static void info(Object msg)
/*    */   {
/* 29 */     LOGGER.info("[BallBattle]" + msg);
/*    */   }
/*    */   
/*    */   static void error(Object msg)
/*    */   {
/* 34 */     LOGGER.error("[BallBattle]" + msg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\BallBattleLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */