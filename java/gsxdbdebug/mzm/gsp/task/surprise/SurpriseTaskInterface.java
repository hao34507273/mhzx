/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LevelStartTimeData;
/*    */ import xbean.Pod;
/*    */ import xtable.Levelstarttime;
/*    */ 
/*    */ 
/*    */ public class SurpriseTaskInterface
/*    */ {
/*    */   public static void checkAndInitCurrentServerLevel()
/*    */   {
/* 18 */     new checkAndInitCurrentServerLevel(null).call();
/*    */   }
/*    */   
/*    */   private static class checkAndInitCurrentServerLevel
/*    */     extends LogicProcedure
/*    */   {
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 27 */       int curServerLevel = ServerInterface.getCurrentServerLevel();
/*    */       
/* 29 */       LevelStartTimeData xLevelStartTime = Levelstarttime.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 30 */       if (xLevelStartTime == null)
/*    */       {
/* 32 */         Levelstarttime.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xLevelStartTime = Pod.newLevelStartTimeData());
/*    */         
/*    */ 
/* 35 */         xLevelStartTime.getServerlevel2starttime().put(Integer.valueOf(curServerLevel), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis())));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 40 */         Long tmpCurStartTime = (Long)xLevelStartTime.getServerlevel2starttime().get(Integer.valueOf(curServerLevel));
/* 41 */         if (tmpCurStartTime == null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */           xLevelStartTime.getServerlevel2starttime().put(Integer.valueOf(curServerLevel), Long.valueOf(ServerInterface.getCurrentServerLevelStartTime()));
/*    */         }
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 53 */       ServerLevelCache.getInstance().initServerLevelStartTime(xLevelStartTime.getServerlevel2starttime());
/* 54 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseTaskInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */