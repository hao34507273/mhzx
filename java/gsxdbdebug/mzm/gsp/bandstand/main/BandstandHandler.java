/*    */ package mzm.gsp.bandstand.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity4.confbean.SBandstandActivityCfg;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BandstandInfo;
/*    */ 
/*    */ public class BandstandHandler implements ActivityHandler
/*    */ {
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 33 */     BandstandInfo xBandstandInfo = BandstandManager.getBandstandInfo(roleId);
/* 34 */     xBandstandInfo.getActivityid2todayawardcount().put(Integer.valueOf(activityid), Integer.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 41 */     if (!OpenInterface.getOpenStatus(548))
/*    */     {
/* 43 */       return;
/*    */     }
/* 45 */     int npcId = SBandstandActivityCfg.get(activityid).npcId;
/* 46 */     SNpc sNpc = SNpc.get(npcId);
/* 47 */     if (null == sNpc)
/*    */     {
/* 49 */       String logstr = String.format("[bandstand]BandstandHandler.onActivityStart@npc cfg not exsists|activityId=%d,npcId=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(npcId) });
/*    */       
/* 51 */       GameServer.logger().error(logstr);
/* 52 */       return;
/*    */     }
/* 54 */     ControllerInterface.triggerController(sNpc.controllerId);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 60 */     int npcId = SBandstandActivityCfg.get(activityid).npcId;
/* 61 */     SNpc sNpc = SNpc.get(npcId);
/* 62 */     if (null == sNpc)
/*    */     {
/* 64 */       String logstr = String.format("[bandstand]BandstandHandler.onActivityEnd@npc cfg not exsists|activityId=%d,npcId=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(npcId) });
/*    */       
/* 66 */       GameServer.logger().error(logstr);
/* 67 */       return;
/*    */     }
/* 69 */     ControllerInterface.collectController(sNpc.controllerId);
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\BandstandHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */