/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Onlines;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.SReportRoleRes;
/*     */ import mzm.gsp.chat.confbean.ReportConsts;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.ReportInfo;
/*     */ import xbean.ReportRecord;
/*     */ import xbean.ReportedInfo;
/*     */ import xtable.Role2report;
/*     */ import xtable.Role2reported;
/*     */ 
/*     */ public class PCReportRole extends LogicProcedure
/*     */ {
/*     */   private static final String TLOG_NAME = "SecUICComplaintFlowClient";
/*     */   private static final String ENCODING = "UTF-8";
/*     */   private final long roleId;
/*     */   private final long targetRoleId;
/*     */   private final Octets explain;
/*     */   private final int reasonId;
/*     */   private final Octets basis;
/*     */   
/*     */   public PCReportRole(long roleId, long targetRoleId, Octets explain, int reasonId, Octets basis)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.targetRoleId = targetRoleId;
/*  41 */     this.explain = explain;
/*  42 */     this.reasonId = reasonId;
/*  43 */     this.basis = basis;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!isFunOpen(this.roleId))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (!RoleInterface.isRoleExist(this.targetRoleId, false))
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[chat]PCReportRole.processImp@targetRoleId not exist|roleId=%d|targetRoleId=%d|explain=%s|reasonId=%d|basis=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), this.explain.getString("UTF-8"), Integer.valueOf(this.reasonId), this.basis.getString("UTF-8") }));
/*     */       
/*     */ 
/*     */ 
/*  62 */       onFailed(1);
/*  63 */       return false;
/*     */     }
/*  65 */     String targetRoleName = RoleInterface.getName(this.targetRoleId);
/*  66 */     String targetUserid = RoleInterface.getUserId(this.targetRoleId);
/*  67 */     String targetOpenid = Onlines.getInstance().findOpenid(targetUserid);
/*  68 */     long targetSaveAmt = mzm.gsp.qingfu.main.QingfuInterface.getSaveAmt(targetUserid, false);
/*  69 */     String targetPicURL = "0";
/*     */     
/*     */ 
/*  72 */     lock(xdb.Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  75 */     if (RoleInterface.getLevel(this.roleId) < ReportConsts.getInstance().MIN_LEVEL)
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[chat]PCReportRole.processImp@roleLvel < %d|roleId=%d|targetRoleId=%d|explain=%s|reasonId=%d|basis=%s", new Object[] { Integer.valueOf(ReportConsts.getInstance().MIN_LEVEL), Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), this.explain.getString("UTF-8"), Integer.valueOf(this.reasonId), this.basis.getString("UTF-8") }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  82 */       onFailed(2);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     ReportInfo xReportInfo = Role2report.get(Long.valueOf(this.roleId));
/*  88 */     if (xReportInfo == null)
/*     */     {
/*  90 */       xReportInfo = Pod.newReportInfo();
/*  91 */       Role2report.insert(Long.valueOf(this.roleId), xReportInfo);
/*     */     }
/*     */     
/*     */ 
/*  95 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  96 */     long lastReportTime = xReportInfo.getReport_timestamp();
/*  97 */     STimeCommonCfg sTimeCommonCfg = TimeCommonUtil.getCommonCfg(ReportConsts.getInstance().REPORT_CLEAR_TIME);
/*  98 */     if (DateTimeUtils.needDailyReset(lastReportTime, now, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute))
/*     */     {
/* 100 */       xReportInfo.getReport_records().clear();
/*     */     }
/*     */     
/*     */ 
/* 104 */     ReportRecord xReportRecord = (ReportRecord)xReportInfo.getReport_records().get(Long.valueOf(this.targetRoleId));
/* 105 */     if ((xReportRecord != null) && (xReportRecord.getNum() >= ReportConsts.getInstance().DAYLIY_REPORT_ROLE_MAX))
/*     */     {
/* 107 */       GameServer.logger().error(String.format("[chat]PCReportRole.processImp@reported same role num >= %d|roleId=%d|targetRoleId=%d|explain=%s|reasonId=%d|basis=%s", new Object[] { Integer.valueOf(ReportConsts.getInstance().DAYLIY_REPORT_ROLE_MAX), Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), this.explain.getString("UTF-8"), Integer.valueOf(this.reasonId), this.basis.getString("UTF-8") }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 112 */       onFailed(5);
/* 113 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 117 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.VIGOR_CUT__REPORT_ROLE);
/* 118 */     if (!RoleInterface.cutVigor(this.roleId, ReportConsts.getInstance().VIGOR, logArg))
/*     */     {
/* 120 */       GameServer.logger().error(String.format("[chat]PCReportRole.processImp@cut vigor failed|roleId=%d|targetRoleId=%d|explain=%s|reasonId=%d|basis=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), this.explain.getString("UTF-8"), Integer.valueOf(this.reasonId), this.basis.getString("UTF-8") }));
/*     */       
/*     */ 
/*     */ 
/* 124 */       onFailed(3);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     if (xReportRecord == null)
/*     */     {
/* 131 */       xReportRecord = Pod.newReportRecord();
/* 132 */       xReportInfo.getReport_records().put(Long.valueOf(this.targetRoleId), xReportRecord);
/*     */     }
/* 134 */     xReportRecord.setNum(xReportRecord.getNum() + 1);
/* 135 */     xReportInfo.setReport_timestamp(now);
/*     */     
/* 137 */     String explainStr = this.explain.getString("UTF-8").replaceAll("|", "");
/* 138 */     String basisStr = this.basis.getString("UTF-8").replaceAll("|", "");
/* 139 */     if (basisStr.isEmpty())
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[chat]PCReportRole.processImp@basis is empty|roleId=%d|targetRoleId=%d|explain=%s|reasonId=%d|basis=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), explainStr, Integer.valueOf(this.reasonId), basisStr }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       onFailed(6);
/* 146 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 150 */     asyncRecordReportedInfo();
/*     */     
/*     */ 
/* 153 */     String userId = RoleInterface.getUserId(this.roleId);
/* 154 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 155 */     StringBuilder sbLog = new StringBuilder();
/* 156 */     sbLog.append(mzm.gsp.GameServerInfoManager.getHostIP()).append('|');
/* 157 */     sbLog.append(userId).append('|');
/* 158 */     sbLog.append(this.roleId).append('|');
/* 159 */     sbLog.append(String.valueOf(roleLevel)).append('|');
/*     */     
/*     */ 
/* 162 */     sbLog.append(this.targetRoleId).append('|');
/* 163 */     sbLog.append(targetRoleName.replaceAll("|", "")).append('|');
/* 164 */     sbLog.append(explainStr).append('|');
/* 165 */     sbLog.append(this.reasonId).append('|');
/* 166 */     sbLog.append(basisStr).append('|');
/* 167 */     sbLog.append(targetOpenid).append('|');
/* 168 */     sbLog.append(targetSaveAmt).append('|');
/* 169 */     sbLog.append("0");
/*     */     
/*     */ 
/* 172 */     if (!TLogManager.getInstance().addLog(this.roleId, "SecUICComplaintFlowClient", sbLog.toString()))
/*     */     {
/* 174 */       GameServer.logger().error(String.format("[chat]PCReportRole.processImp@add tlog failed|roleId=%d|targetRoleId=%d|explain=%s|reasonId=%d|basis=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), explainStr, Integer.valueOf(this.reasonId), basisStr }));
/*     */       
/*     */ 
/*     */ 
/* 178 */       onFailed(4);
/* 179 */       return false;
/*     */     }
/*     */     
/* 182 */     SReportRoleRes res = new SReportRoleRes();
/* 183 */     res.resultcode = 0;
/* 184 */     res.targetroleid = this.targetRoleId;
/* 185 */     res.targetrolename = targetRoleName;
/* 186 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retCode)
/*     */   {
/* 193 */     SReportRoleRes res = new SReportRoleRes();
/* 194 */     res.resultcode = retCode;
/* 195 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */   
/*     */   private boolean isFunOpen(long roleId)
/*     */   {
/* 200 */     if (!OpenInterface.getOpenStatus(133))
/*     */     {
/* 202 */       return false;
/*     */     }
/* 204 */     if (OpenInterface.isBanPlay(roleId, 133))
/*     */     {
/* 206 */       OpenInterface.sendBanPlayMsg(roleId, 133);
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void asyncRecordReportedInfo()
/*     */   {
/* 217 */     if (!OpenInterface.getOpenStatus(495))
/* 218 */       return;
/* 219 */     RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(this.targetRoleId), new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 224 */         ReportedInfo xReportedInfo = Role2reported.get(Long.valueOf(PCReportRole.this.targetRoleId));
/* 225 */         if (xReportedInfo == null)
/*     */         {
/* 227 */           xReportedInfo = Pod.newReportedInfo();
/* 228 */           Role2reported.add(Long.valueOf(PCReportRole.this.targetRoleId), xReportedInfo);
/*     */         }
/* 230 */         int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 231 */         xReportedInfo.getReport_time_map().put(Long.valueOf(PCReportRole.this.roleId), Integer.valueOf(now));
/* 232 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCReportRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */