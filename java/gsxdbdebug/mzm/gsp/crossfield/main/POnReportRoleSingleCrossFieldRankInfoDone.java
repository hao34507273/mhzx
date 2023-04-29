/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.crossfield.ReportRoleCrossFieldRankInfoContext;
/*    */ import mzm.gsp.crossserver.event.ReportRoleSingleCrossFieldRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.ReportRoleSingleCrossFieldRankInfoDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.crossserver.top.SingleCrossFieldTopChartObj;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnReportRoleSingleCrossFieldRankInfoDone
/*    */   extends ReportRoleSingleCrossFieldRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     ReportRoleCrossFieldRankInfoContext context = new ReportRoleCrossFieldRankInfoContext();
/* 20 */     context.unmarshal(OctetsStream.wrap(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getContext()));
/* 21 */     if (((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 23 */       CrossFieldManager.logger.info(String.format("[crossfield]POnReportRoleSingleCrossFieldRankInfoDone.processImp@report role single cross field rank info success|count=%d|roleid=%d|star_num=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Integer.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getStarNum()), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       
/*    */ 
/*    */ 
/* 27 */       return true;
/*    */     }
/*    */     
/* 30 */     if (!((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 32 */       CrossFieldManager.logger.info(String.format("[crossfield]POnReportRoleSingleCrossFieldRankInfoDone.processImp@report role single cross field rank info fail|count=%d|roleid=%d|star_num=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Integer.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getStarNum()), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       
/*    */ 
/*    */ 
/* 36 */       return true;
/*    */     }
/*    */     
/* 39 */     CrossFieldManager.logger.info(String.format("[crossfield]POnReportRoleSingleCrossFieldRankInfoDone.processImp@report role single cross field rank info timeout|count=%d|roleid=%d|star_num=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Integer.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getStarNum()), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */     
/*    */ 
/*    */ 
/* 43 */     if (context.count < CrossFieldManager.GRC_MAX_TRY_TIMES)
/*    */     {
/* 45 */       ReportRoleCrossFieldRankInfoContext tmp313_312 = context;tmp313_312.count = ((byte)(tmp313_312.count + 1));
/* 46 */       OctetsStream os = new OctetsStream();
/* 47 */       context.marshal(os);
/* 48 */       boolean ret = CrossServerInterface.reportRoleSingleCrossFieldRankInfo(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid(), ((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getRoleid(), ((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getName(), ((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getOccupation(), ((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getStarNum(), ((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getTimestamp(), os);
/*    */       
/*    */ 
/*    */ 
/* 52 */       if (!ret)
/*    */       {
/* 54 */         CrossFieldManager.logger.error(String.format("[crossfield]POnReportRoleSingleCrossFieldRankInfoDone.processImp@send report role single cross field rank info fail|count=%d|roleid=%d|star_num=%d|timestamp=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getRoleid()), Integer.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getStarNum()), Long.valueOf(((ReportRoleSingleCrossFieldRankInfoDoneArg)this.arg).getChartObj().getTimestamp()) }));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnReportRoleSingleCrossFieldRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */