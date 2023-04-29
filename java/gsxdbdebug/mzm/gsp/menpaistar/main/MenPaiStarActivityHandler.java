/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MenPaiStarInfo;
/*    */ 
/*    */ public class MenPaiStarActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     MenPaiStarManager.initData(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 29 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 35 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 41 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 43 */       return;
/*    */     }
/*    */     
/*    */ 
/* 47 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 48 */     long activityStartTime = ActivityInterface.getActivityStartTime(activityid);
/*    */     
/* 50 */     for (Iterator i$ = MenPaiStarConfigManager.getOcpids().iterator(); i$.hasNext();) { int ocpid = ((Integer)i$.next()).intValue();
/*    */       
/* 52 */       MenPaiStarInfo xMenPaiStarInfo = MenPaiStarManager.getAndInitXMenPaiStarInfo(ocpid);
/* 53 */       if (xMenPaiStarInfo.getFinished())
/*    */       {
/* 55 */         xMenPaiStarInfo.setFinished(false);
/* 56 */         xMenPaiStarInfo.setStart_time(now);
/* 57 */         CampaignChartManager.canJoin(ocpid, true);
/* 58 */         CampaignChartManager.setLastChampion(ocpid, xMenPaiStarInfo.getChampion());
/* 59 */         CampaignChartManager.clear(ocpid);
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 64 */         long startTime = xMenPaiStarInfo.getStart_time();
/* 65 */         if (startTime < activityStartTime)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 71 */           CampaignChartManager.canJoin(ocpid, false);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 84 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 86 */       return;
/*    */     }
/*    */     
/* 89 */     for (Iterator i$ = MenPaiStarConfigManager.getOcpids().iterator(); i$.hasNext();) { int ocpid = ((Integer)i$.next()).intValue();
/*    */       
/* 91 */       if (!CampaignChartManager.canJoin(ocpid))
/*    */       {
/* 93 */         GameServer.logger().error(String.format("[menpaistar]MenPaiStarActivityHandler.onActivityEnd@can not join|ocpid=%d", new Object[] { Integer.valueOf(ocpid) }));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 98 */         UpdateCampaignOneByOne.getInstance().add(ocpid, new ROnActivityEnd(ocpid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */