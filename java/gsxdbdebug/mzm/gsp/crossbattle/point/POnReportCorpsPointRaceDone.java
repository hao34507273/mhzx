/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.ReportCorpsPointRaceReq;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossserver.event.ReportCorpsPointRaceDoneArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CrossbattlePointRaceInfo;
/*    */ import xbean.PointRaceInfo;
/*    */ 
/*    */ public class POnReportCorpsPointRaceDone extends mzm.gsp.crossserver.event.ReportCorpsPointRaceDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (((ReportCorpsPointRaceDoneArg)this.arg).isSucceed())
/*    */     {
/* 18 */       OctetsStream os = new OctetsStream(((ReportCorpsPointRaceDoneArg)this.arg).getContext());
/* 19 */       ReportCorpsPointRaceReq req = new ReportCorpsPointRaceReq();
/* 20 */       req.unmarshal(os);
/*    */       
/* 22 */       int activityCfgid = req.activity_cfgid;
/* 23 */       int timePointCfgid = req.time_point_cfgid;
/* 24 */       long corpsid = req.corpsid;
/* 25 */       long updateTime = req.data.update_time;
/*    */       
/* 27 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PReportCorpsPointRaceDone(activityCfgid, timePointCfgid, corpsid, updateTime));
/*    */       
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     if (!mzm.gsp.crossserver.main.CrossServerInterface.asyncReportCorpsPointRace(((ReportCorpsPointRaceDoneArg)this.arg).getContext()))
/*    */     {
/* 34 */       GameServer.logger().error("[crossbattlepoint]POnReportCorpsPointRaceDone.processImp@grc send msg failed");
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   private static class PReportCorpsPointRaceDone
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final int activityCfgid;
/*    */     private final int timePointCfgid;
/*    */     private final long corpsid;
/*    */     private final long updateTime;
/*    */     
/*    */     public PReportCorpsPointRaceDone(int activityCfgid, int timePointCfgid, long corpsid, long updateTime)
/*    */     {
/* 49 */       this.activityCfgid = activityCfgid;
/* 50 */       this.timePointCfgid = timePointCfgid;
/* 51 */       this.corpsid = corpsid;
/* 52 */       this.updateTime = updateTime;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 58 */       CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = CrossBattlePointManager.getCrossbattlePointRaceInfo(this.activityCfgid, this.timePointCfgid, true);
/*    */       
/* 60 */       if (xCrossbattlePointRaceInfo == null)
/*    */       {
/* 62 */         GameServer.logger().error(String.format("[crossbattlepoint]PReportCorpsPointRaceDone.processImp@xbean cross battle point race info is null|activity_cfgid=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.timePointCfgid) }));
/*    */         
/*    */ 
/*    */ 
/* 66 */         return false;
/*    */       }
/*    */       
/* 69 */       long corpsid = this.corpsid;
/* 70 */       PointRaceInfo xPointRaceInfo = (PointRaceInfo)xCrossbattlePointRaceInfo.getCorps().get(Long.valueOf(corpsid));
/* 71 */       if (xPointRaceInfo == null)
/*    */       {
/* 73 */         return false;
/*    */       }
/* 75 */       if (xPointRaceInfo.getUpdate_time() != this.updateTime)
/*    */       {
/* 77 */         return false;
/*    */       }
/* 79 */       xPointRaceInfo.setReported(true);
/* 80 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnReportCorpsPointRaceDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */