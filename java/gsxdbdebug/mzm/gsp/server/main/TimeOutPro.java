/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.server.event.ServerLevelArg;
/*    */ import mzm.gsp.server.event.ServerLevelUp;
/*    */ import mzm.gsp.serverconf.confbean.SServerLevelConfig;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LevelTimeBean;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Level2time;
/*    */ 
/*    */ public class TimeOutPro extends LogicProcedure
/*    */ {
/*    */   public boolean processImp() throws Exception
/*    */   {
/* 21 */     Lockeys.lock(Level2time.getTable(), Arrays.asList(new Long[] { Long.valueOf(GameServerInfoManager.getLocalId()) }));
/* 22 */     LevelTimeBean xLevelTimeBean = ServerManager.getOrAddLevelTimeBean();
/*    */     
/* 24 */     int currentLevel = xLevelTimeBean.getServerlevel();
/* 25 */     SServerLevelConfig nextBean = ServerManager.getNextServerLevelBean(currentLevel);
/* 26 */     if (nextBean == null)
/*    */     {
/* 28 */       String logStr = String.format("[serverlevel]TimeOutPro.process@server level upgrade fail,not found next server config|serverlevel=%d|maxconfiglevel=%d", new Object[] { Integer.valueOf(currentLevel), Integer.valueOf(ServerManager.getMaxServerLevel()) });
/*    */       
/*    */ 
/* 31 */       ServerManager.logger.error(logStr);
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 37 */     long duration = TimeUnit.HOURS.toSeconds(nextBean.duration);
/*    */     
/* 39 */     long endTime = ServerManager.computeEndTime(now, duration);
/*    */     
/* 41 */     long startTimeSec = TimeUnit.MILLISECONDS.toSeconds(now);
/* 42 */     long nextUpgradeTimeSec = TimeUnit.MILLISECONDS.toSeconds(endTime);
/*    */     
/* 44 */     ServerManager.setCurrentLevel(xLevelTimeBean, nextBean.level, nextUpgradeTimeSec, startTimeSec);
/*    */     
/* 46 */     TriggerEventsManger.getInstance().triggerEvent(new ServerLevelUp(), new ServerLevelArg(nextBean.level, xLevelTimeBean.getStarttime()));
/*    */     
/*    */ 
/* 49 */     long length = TimeUnit.MILLISECONDS.toSeconds(endTime - now);
/* 50 */     ServerManager.resetObserver(length);
/*    */     
/* 52 */     ServerLevelObject.getInstance().update(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/* 55 */     ServerManager.syncServerLevelToAll(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/* 58 */     String logStr = String.format("[serverlevel]TimeOutPro.process@server level upgrade success|serverlevel=%d|persisttime=%d", new Object[] { Integer.valueOf(nextBean.level), Long.valueOf(duration) });
/*    */     
/*    */ 
/*    */ 
/* 62 */     ServerManager.logger.info(logStr);
/*    */     
/* 64 */     ServerManager.tlogServerLevelChange(xLevelTimeBean.getServerlevel(), currentLevel, length, 2);
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\TimeOutPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */