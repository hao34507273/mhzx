/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DaySessionInfo;
/*    */ import xbean.GlobalSurpriseScheduleInfo;
/*    */ import xtable.Globalsurpriseschedule;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStartServerLevelSession
/*    */   extends Session
/*    */ {
/*    */   private final int needServerLevel;
/*    */   private final int needDay;
/*    */   
/*    */   public PStartServerLevelSession(long interval, int needServerLevel, int needDay)
/*    */   {
/* 22 */     super(interval, 1L);
/* 23 */     this.needServerLevel = needServerLevel;
/* 24 */     this.needDay = needDay;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 30 */     new NewSurpriseGraphs(null).execute();
/*    */   }
/*    */   
/*    */   private class NewSurpriseGraphs
/*    */     extends LogicProcedure
/*    */   {
/*    */     private NewSurpriseGraphs() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 40 */       Set<Integer> newGraphIds = SurpriseScheduleManager.getNeedOpenGraphIds(PStartServerLevelSession.this.needServerLevel, PStartServerLevelSession.this.needDay);
/* 41 */       if ((newGraphIds == null) || (newGraphIds.size() == 0))
/*    */       {
/* 43 */         return false;
/*    */       }
/* 45 */       GlobalSurpriseScheduleInfo xGlobalInfo = Globalsurpriseschedule.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 46 */       if (xGlobalInfo == null)
/*    */       {
/* 48 */         return false;
/*    */       }
/* 50 */       DaySessionInfo xDaySessionInfo = (DaySessionInfo)xGlobalInfo.getSessioninfos().get(Integer.valueOf(PStartServerLevelSession.this.needServerLevel));
/* 51 */       if (xDaySessionInfo == null)
/*    */       {
/* 53 */         return false;
/*    */       }
/* 55 */       Long sesssionId = (Long)xDaySessionInfo.getSessionids().get(Integer.valueOf(PStartServerLevelSession.this.needDay));
/* 56 */       if ((sesssionId == null) || (sesssionId.longValue() != PStartServerLevelSession.this.getSessionId()))
/*    */       {
/* 58 */         return false;
/*    */       }
/*    */       
/* 61 */       xDaySessionInfo.getSessionids().remove(Integer.valueOf(PStartServerLevelSession.this.needDay));
/*    */       
/* 63 */       xGlobalInfo.getOpenedgraphids().addAll(newGraphIds);
/*    */       
/* 65 */       SurpriseScheduleManager.synNewSurpriseGraph();
/* 66 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PStartServerLevelSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */