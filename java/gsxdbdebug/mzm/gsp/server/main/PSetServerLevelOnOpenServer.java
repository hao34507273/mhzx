/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.config.event.OpenServerTimeChangedProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.serverconf.confbean.SServerLevelConfig;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LevelTimeBean;
/*    */ 
/*    */ public class PSetServerLevelOnOpenServer
/*    */   extends OpenServerTimeChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     SServerLevelConfig serverLevelBean = ServerManager.getFirstServerLevelBean();
/* 18 */     if (serverLevelBean == null)
/*    */     {
/* 20 */       String logStr = String.format("[serverlevel]PSetServerLevelOnOpenServer.processImp@can not get first server level", new Object[0]);
/*    */       
/* 22 */       ServerManager.logger.fatal(logStr);
/* 23 */       return false;
/*    */     }
/* 25 */     LevelTimeBean xLevelTimeBean = ServerManager.getOrAddLevelTimeBean();
/*    */     
/* 27 */     long currenttime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 29 */     long endtime = DateTimeUtils.getTimeInToday(currenttime, 0, 0, 0) + TimeUnit.DAYS.toMillis(1L);
/*    */     
/* 31 */     long length = TimeUnit.MILLISECONDS.toSeconds(endtime - currenttime);
/*    */     
/* 33 */     long startTimeSec = TimeUnit.MILLISECONDS.toSeconds(currenttime);
/* 34 */     long nextUpgradeTimeSec = TimeUnit.MILLISECONDS.toSeconds(endtime);
/*    */     
/* 36 */     ServerManager.setCurrentLevel(xLevelTimeBean, serverLevelBean.level, nextUpgradeTimeSec, startTimeSec);
/*    */     
/* 38 */     ServerManager.resetObserver(length);
/*    */     
/*    */ 
/* 41 */     ServerLevelObject.getInstance().update(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/*    */ 
/* 45 */     ServerManager.syncServerLevelToAll(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/*    */ 
/* 49 */     OnlineManager.getInstance().brocastAllServerOpenTime(((Long)this.arg).longValue());
/*    */     
/* 51 */     String logStr = String.format("[serverlevel]PSetServerLevelOnOpenServer.processImp@open server set server level success|serverlevel=%d|persisttime=%d", new Object[] { Integer.valueOf(serverLevelBean.level), Long.valueOf(length) });
/*    */     
/*    */ 
/*    */ 
/* 55 */     ServerManager.logger.info(logStr);
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\PSetServerLevelOnOpenServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */