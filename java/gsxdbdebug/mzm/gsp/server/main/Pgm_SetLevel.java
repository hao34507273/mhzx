/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.server.event.ServerLevelArg;
/*    */ import mzm.gsp.server.event.ServerLevelUp;
/*    */ import mzm.gsp.serverconf.confbean.SServerLevelConfig;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LevelTimeBean;
/*    */ 
/*    */ 
/*    */ public class Pgm_SetLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int newlevel;
/*    */   private String endTime;
/*    */   
/*    */   public Pgm_SetLevel(int newlevel, String endTime)
/*    */   {
/* 22 */     this.newlevel = newlevel;
/* 23 */     this.endTime = endTime;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     int orgServerLevel = ServerInterface.getCurrentServerLevel();
/* 31 */     SServerLevelConfig serverLevelBean = ServerManager.getServerLevelBeanBylevel(this.newlevel);
/* 32 */     if (serverLevelBean == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     LevelTimeBean xLevelTimeBean = ServerManager.getOrAddLevelTimeBean();
/* 37 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 38 */     long end = 0L;
/* 39 */     if ((this.endTime == null) || ("".equals(this.endTime)))
/*    */     {
/* 41 */       end = now + TimeUnit.HOURS.toMillis(serverLevelBean.duration);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 46 */       end = ServerManager.computeEndTimeInMills(this.endTime);
/* 47 */       if (end < now)
/*    */       {
/* 49 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 55 */     long length = TimeUnit.MILLISECONDS.toSeconds(end - now);
/*    */     
/* 57 */     long startTimeSec = TimeUnit.MILLISECONDS.toSeconds(now);
/* 58 */     long nextUpgradeTimeSec = TimeUnit.MILLISECONDS.toSeconds(end);
/*    */     
/* 60 */     ServerManager.setCurrentLevel(xLevelTimeBean, serverLevelBean.level, nextUpgradeTimeSec, startTimeSec);
/*    */     
/* 62 */     ServerManager.resetObserver(length);
/*    */     
/* 64 */     ServerLevelObject.getInstance().update(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/* 67 */     ServerManager.syncServerLevelToAll(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/* 70 */     ServerLevelArg arg = new ServerLevelArg(serverLevelBean.level, xLevelTimeBean.getStarttime());
/*    */     
/* 72 */     TriggerEventsManger.getInstance().triggerEvent(new ServerLevelUp(), arg);
/* 73 */     String logStr = String.format("[serverlevel]Pgm_SetLevel.processImp@ gm set server level  success|serverlevel=%d|persisttime=%d", new Object[] { Integer.valueOf(serverLevelBean.level), Long.valueOf(length) });
/*    */     
/*    */ 
/*    */ 
/* 77 */     ServerManager.logger.info(logStr);
/*    */     
/* 79 */     ServerManager.tlogServerLevelChange(serverLevelBean.level, orgServerLevel, length, 3);
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\Pgm_SetLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */