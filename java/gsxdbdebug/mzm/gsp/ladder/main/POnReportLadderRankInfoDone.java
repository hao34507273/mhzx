/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.ReportLadderRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.ReportLadderRankInfoDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.ladder.ReportLadderRankInfoContext;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnReportLadderRankInfoDone extends ReportLadderRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     ReportLadderRankInfoContext reportLadderRankInfoContext = new ReportLadderRankInfoContext();
/* 17 */     reportLadderRankInfoContext.unmarshal(new OctetsStream(((ReportLadderRankInfoDoneArg)this.arg).getContext()));
/* 18 */     if (((ReportLadderRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 20 */       GameServer.logger().info(String.format("[Ladder]POnReportLadderRankInfoDone.processImp@report ladder rank info success|roleid=%d|count=%d|code=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Long.valueOf(((ReportLadderRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(reportLadderRankInfoContext.count), Integer.valueOf(((ReportLadderRankInfoDoneArg)this.arg).getRetCode()), Integer.valueOf(CommonUtils.getLongHigh(((ReportLadderRankInfoDoneArg)this.arg).getRankid())), Integer.valueOf(CommonUtils.getLongLow(((ReportLadderRankInfoDoneArg)this.arg).getRankid())) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 25 */       return true;
/*    */     }
/*    */     
/* 28 */     GameServer.logger().info(String.format("[Ladder]POnReportLadderRankInfoDone.processImp@report ladder rank info fail|roleid=%d|count=%d|code=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Long.valueOf(((ReportLadderRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(reportLadderRankInfoContext.count), Integer.valueOf(((ReportLadderRankInfoDoneArg)this.arg).getRetCode()), Integer.valueOf(CommonUtils.getLongHigh(((ReportLadderRankInfoDoneArg)this.arg).getRankid())), Integer.valueOf(CommonUtils.getLongLow(((ReportLadderRankInfoDoneArg)this.arg).getRankid())) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 34 */     if (!((ReportLadderRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (reportLadderRankInfoContext.count < LadderManager.GRC_MAX_TRY_TIMES)
/*    */     {
/* 40 */       reportLadderRankInfoContext.count += 1;
/* 41 */       OctetsStream os = new OctetsStream();
/* 42 */       reportLadderRankInfoContext.marshal(os);
/* 43 */       CrossServerInterface.asyncReportLadderRankInfo(((ReportLadderRankInfoDoneArg)this.arg).getRankid(), ((ReportLadderRankInfoDoneArg)this.arg).getRoleid(), ((ReportLadderRankInfoDoneArg)this.arg).getRoleName(), ((ReportLadderRankInfoDoneArg)this.arg).getOccupation(), ((ReportLadderRankInfoDoneArg)this.arg).getDisplayRanking(), ((ReportLadderRankInfoDoneArg)this.arg).getRanking(), os);
/*    */     }
/*    */     
/*    */ 
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnReportLadderRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */