/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.ReportCrossCompeteFactionInfoReq;
/*     */ import hub.ReportCrossCompeteFactionInfoRsp;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crosscompete.roam.PBuildRoamFaction;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_ReportCrossCompeteFactionInfo
/*     */   extends DataTransferHandler<ReportCrossCompeteFactionInfoReq, ReportCrossCompeteFactionInfoRsp>
/*     */ {
/*     */   protected ReportCrossCompeteFactionInfoReq makeReqDataBean()
/*     */   {
/*  28 */     return new ReportCrossCompeteFactionInfoReq();
/*     */   }
/*     */   
/*     */   protected ReportCrossCompeteFactionInfoRsp makeRspDataBean()
/*     */   {
/*  33 */     return new ReportCrossCompeteFactionInfoRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, ReportCrossCompeteFactionInfoReq reqData)
/*     */   {
/*  39 */     if (!GameServerInfoManager.isRoamServer()) {
/*  40 */       GameServer.logger().error(String.format("[crosscompete]DTH_ReportCrossCompeteFactionInfo.onDataTransferReq@not roam server|req=%s|req_data=%s", new Object[] { req, reqData }));
/*     */       
/*     */ 
/*     */ 
/*  44 */       return;
/*     */     }
/*     */     
/*  47 */     DataTransferRsp rsp = new DataTransferRsp();
/*  48 */     rsp.direction = 0;
/*  49 */     rsp.xid = req.xid;
/*  50 */     rsp.src_id = req.dst_id;
/*  51 */     rsp.dst_id = req.src_id;
/*  52 */     rsp.data_type = req.data_type;
/*     */     
/*  54 */     ReportCrossCompeteFactionInfoRsp rspData = new ReportCrossCompeteFactionInfoRsp();
/*  55 */     rspData.factionid = reqData.factionid;
/*     */     
/*  57 */     PBuildRoamFaction pBuild = new PBuildRoamFaction(reqData.factionid, reqData.name, reqData.members, reqData.design_titleid, reqData.partcipate_count);
/*     */     
/*  59 */     if (pBuild.call()) {
/*  60 */       rsp.retcode = 0;
/*  61 */       GameServer.logger().info(String.format("[crosscompete]DTH_ReportCrossCompeteFactionInfo.onDataTransferReq@build roam faction succeed|factionid=%d|name=%s", new Object[] { Long.valueOf(reqData.factionid), reqData.name }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  68 */       rsp.retcode = 2;
/*  69 */       GameServer.logger().error(String.format("[crosscompete]DTH_ReportCrossCompeteFactionInfo.onDataTransferReq@build roam faction failed|factionid=%d|name=%s", new Object[] { Long.valueOf(reqData.factionid), reqData.name }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  75 */     OctetsStream os = new OctetsStream();
/*  76 */     os.marshal(rspData);
/*  77 */     rsp.data = os;
/*     */     
/*  79 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ReportCrossCompeteFactionInfoReq reqData, DataTransferRspXidWrapper rspXidWrapper, ReportCrossCompeteFactionInfoRsp rspData)
/*     */   {
/*  87 */     if (rspXidWrapper.getProtocol().retcode == 0) {
/*  88 */       GameServer.logger().info(String.format("[crosscompete]DTH_ReportCrossCompeteFactionInfo.onDataTransferReq@report faction succeed|factionid=%d", new Object[] { Long.valueOf(rspData.factionid) }));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  94 */       GameServer.logger().error(String.format("[crosscompete]DTH_ReportCrossCompeteFactionInfo.onDataTransferReq@report faction error|factionid=%d|retcode=%d|req_data=%s|rsp=%s", new Object[] { Long.valueOf(rspData.factionid), Integer.valueOf(rspXidWrapper.getProtocol().retcode), reqData, rspXidWrapper.getProtocol() }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ReportCrossCompeteFactionInfoReq reqData, int code)
/*     */   {
/* 109 */     GameServer.logger().error(String.format("[crosscompete]DTH_ReportCrossCompeteFactionInfo.onDataTransferReq@report faction timeout|factionid=%d|code=%d", new Object[] { Long.valueOf(reqData.factionid), Integer.valueOf(code) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ReportCrossCompeteFactionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */