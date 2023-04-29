/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.bigboss.ReportRoleBigBossRemoteRankInfoContext;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*    */ import mzm.gsp.crossserver.event.ReportRoleBigBossRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.top.BigBossTopChartObj;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BigBoss;
/*    */ import xtable.Role2bigboss;
/*    */ 
/*    */ public class POnReportRoleBigBossRankInfoDone extends mzm.gsp.crossserver.event.ReportRoleBigBossRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     int occupation = CommonUtils.getLongHigh(((ReportRoleBigBossRankInfoDoneArg)this.arg).getRankid());
/* 20 */     long startTimestamp = CommonUtils.getLongLow(((ReportRoleBigBossRankInfoDoneArg)this.arg).getRankid()) * 1000L;
/* 21 */     ReportRoleBigBossRemoteRankInfoContext context = new ReportRoleBigBossRemoteRankInfoContext();
/* 22 */     context.unmarshal(com.goldhuman.Common.Marshal.OctetsStream.wrap(((ReportRoleBigBossRankInfoDoneArg)this.arg).getContext()));
/* 23 */     if (((ReportRoleBigBossRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 25 */       GameServer.logger().info(String.format("[bigboss]POnReportRoleBigBossRankInfoDone.processImp@report role big boss remote rank info success|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Long.valueOf(((ReportRoleBigBossRankInfoDoneArg)this.arg).getChartObj().getRoleid()) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 30 */       return true;
/*    */     }
/*    */     
/* 33 */     if (!((ReportRoleBigBossRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[bigboss]POnReportRoleBigBossRankInfoDone.processImp@report role big boss remote rank info fail|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Long.valueOf(((ReportRoleBigBossRankInfoDoneArg)this.arg).getChartObj().getRoleid()) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     GameServer.logger().error(String.format("[bigboss]POnReportRoleBigBossRankInfoDone.processImp@remove role big boss remote info timeout|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Long.valueOf(((ReportRoleBigBossRankInfoDoneArg)this.arg).getChartObj().getRoleid()) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 47 */     if (context.count < BigbossManager.GRC_MAX_TRY_TIMES)
/*    */     {
/* 49 */       if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(SBigbossCfgConsts.getInstance().ACTIVITYID))
/*    */       {
/* 51 */         return false;
/*    */       }
/* 53 */       if (startTimestamp != BigbossManager.getActivityStarttime())
/*    */       {
/* 55 */         return false;
/*    */       }
/*    */       
/* 58 */       BigBoss xBigBoss = Role2bigboss.get(Long.valueOf(((ReportRoleBigBossRankInfoDoneArg)this.arg).getChartObj().getRoleid()));
/* 59 */       if (xBigBoss == null)
/*    */       {
/* 61 */         return false;
/*    */       }
/* 63 */       if (xBigBoss.getStarttime() != startTimestamp)
/*    */       {
/* 65 */         return false;
/*    */       }
/* 67 */       if (!xBigBoss.getOcp2damagepoint().containsKey(Integer.valueOf(occupation)))
/*    */       {
/* 69 */         return false;
/*    */       }
/* 71 */       BigbossManager.reportRoleBigBossRankInfo(((ReportRoleBigBossRankInfoDoneArg)this.arg).getRankid(), ((ReportRoleBigBossRankInfoDoneArg)this.arg).getChartObj().getRoleid(), mzm.gsp.role.main.RoleInterface.getName(((ReportRoleBigBossRankInfoDoneArg)this.arg).getChartObj().getRoleid()), occupation, ((Integer)xBigBoss.getOcp2damagepoint().get(Integer.valueOf(occupation))).intValue(), context.count + 1);
/*    */     }
/*    */     
/*    */ 
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnReportRoleBigBossRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */