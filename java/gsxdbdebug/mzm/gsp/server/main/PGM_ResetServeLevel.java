/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.server.event.ServerLevelArg;
/*    */ import mzm.gsp.server.event.ServerLevelUp;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LevelTimeBean;
/*    */ 
/*    */ 
/*    */ public class PGM_ResetServeLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int newlevel;
/*    */   private long endTimeSec;
/*    */   
/*    */   public PGM_ResetServeLevel(int newlevel, long endTimeSec)
/*    */   {
/* 21 */     this.newlevel = newlevel;
/* 22 */     this.endTimeSec = endTimeSec;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     int orgServerLevel = ServerInterface.getCurrentServerLevel();
/* 30 */     LevelTimeBean xLevelTimeBean = ServerManager.getOrAddLevelTimeBean();
/* 31 */     long nowSec = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 32 */     if (this.endTimeSec < nowSec)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     long length = this.endTimeSec - nowSec;
/*    */     
/* 39 */     ServerManager.setCurrentLevel(xLevelTimeBean, this.newlevel, this.endTimeSec, nowSec);
/*    */     
/* 41 */     ServerManager.resetObserver(length);
/*    */     
/* 43 */     ServerLevelObject.getInstance().update(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/* 46 */     ServerManager.syncServerLevelToAll(xLevelTimeBean.getServerlevel(), xLevelTimeBean.getStarttime(), xLevelTimeBean.getUpgradetime());
/*    */     
/*    */ 
/* 49 */     ServerLevelArg arg = new ServerLevelArg(this.newlevel, xLevelTimeBean.getStarttime());
/*    */     
/* 51 */     TriggerEventsManger.getInstance().triggerEvent(new ServerLevelUp(), arg);
/* 52 */     String logStr = String.format("[serverlevel]PGM_ResetServeLevel.processImp@ gm set server level  success|serverlevel=%d|persisttime=%d", new Object[] { Integer.valueOf(this.newlevel), Long.valueOf(length) });
/*    */     
/*    */ 
/*    */ 
/* 56 */     ServerManager.logger.info(logStr);
/*    */     
/* 58 */     ServerManager.tlogServerLevelChange(this.newlevel, orgServerLevel, length, 3);
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\PGM_ResetServeLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */