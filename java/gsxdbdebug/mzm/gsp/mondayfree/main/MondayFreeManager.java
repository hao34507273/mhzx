/*    */ package mzm.gsp.mondayfree.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.mondayfree.SMondayFreeNormalResult;
/*    */ import mzm.gsp.mondayfree.SSyncMondayFree;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MondayFree;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2mondayfree;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class MondayFreeManager
/*    */ {
/*    */   static Logger logger;
/*    */   
/*    */   static void init()
/*    */   {
/* 21 */     logger = Logger.getLogger("mondayfree");
/*    */   }
/*    */   
/*    */   static MondayFree createXMondayFreeIfNotExist(long roleid) {
/* 25 */     MondayFree xMondayFree = Role2mondayfree.get(Long.valueOf(roleid));
/* 26 */     if (xMondayFree == null) {
/* 27 */       xMondayFree = Pod.newMondayFree();
/* 28 */       Role2mondayfree.insert(Long.valueOf(roleid), xMondayFree);
/*    */     }
/* 30 */     return xMondayFree;
/*    */   }
/*    */   
/*    */   static void logWarn(String formatStr, Object... args) {
/* 34 */     logger.warn(String.format(formatStr, args));
/*    */   }
/*    */   
/*    */   static void logError(String formatStr, Object... args) {
/* 38 */     logger.error(String.format(formatStr, args));
/*    */   }
/*    */   
/*    */   static void logInfo(String formatStr, Object... args) {
/* 42 */     logger.info(String.format(formatStr, args));
/*    */   }
/*    */   
/*    */   static void logDebug(String formatStr, Object... args) {
/* 46 */     logger.debug(String.format(formatStr, args));
/*    */   }
/*    */   
/*    */   static void sendNormalResult(long roleid, int result) {
/* 50 */     SMondayFreeNormalResult p = new SMondayFreeNormalResult(result);
/* 51 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*    */   }
/*    */   
/*    */   static void syncMondayFree(long roleid, MondayFree xMondayFree) {
/* 55 */     SSyncMondayFree p = new SSyncMondayFree();
/* 56 */     p.sunday_award_time = TimeUnit.MILLISECONDS.toSeconds(xMondayFree.getSunday_award_time());
/* 57 */     p.monday_award_time = TimeUnit.MILLISECONDS.toSeconds(xMondayFree.getMonday_award_time());
/* 58 */     p.finish_shimen_time = TimeUnit.MILLISECONDS.toSeconds(xMondayFree.getFinish_shimen_time());
/* 59 */     p.finish_baotu_time = TimeUnit.MILLISECONDS.toSeconds(xMondayFree.getFinish_baotu_time());
/* 60 */     OnlineManager.getInstance().send(roleid, p);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\main\MondayFreeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */