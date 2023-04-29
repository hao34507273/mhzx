/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.FriendsCircleOperatorBlackReq;
/*     */ import hub.FriendsCircleOperatorBlackRsp;
/*     */ import hub.GHubHelper;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerOperatorBlacklist;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerOperatorBlacklistRsp;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_FriendsCircleOperatorBlacklist
/*     */   extends DataTransferHandler<FriendsCircleOperatorBlackReq, FriendsCircleOperatorBlackRsp>
/*     */ {
/*     */   protected FriendsCircleOperatorBlackReq makeReqDataBean()
/*     */   {
/*  24 */     return new FriendsCircleOperatorBlackReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected FriendsCircleOperatorBlackRsp makeRspDataBean()
/*     */   {
/*  30 */     return new FriendsCircleOperatorBlackRsp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, FriendsCircleOperatorBlackReq reqData)
/*     */   {
/*  37 */     StringBuilder sBuilder = new StringBuilder();
/*  38 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleOperatorBlacklist.onDataTransferReq@operator black list req");
/*  39 */     sBuilder.append("|req=").append(req);
/*  40 */     sBuilder.append("|req_data=").append(reqData);
/*     */     
/*  42 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/*  44 */     POnCrossServerOperatorBlacklist procedure = new POnCrossServerOperatorBlacklist(reqData.active_role_id, req.src_id, reqData.blacked_role_id, reqData.operator);
/*     */     
/*     */ 
/*     */ 
/*  48 */     procedure.call();
/*     */     
/*  50 */     DataTransferRsp rsp = new DataTransferRsp();
/*  51 */     rsp.direction = req.direction;
/*  52 */     rsp.xid = req.xid;
/*  53 */     rsp.src_id = req.dst_id;
/*  54 */     rsp.dst_id = req.src_id;
/*  55 */     rsp.data_type = req.data_type;
/*  56 */     rsp.retcode = 0;
/*     */     
/*  58 */     FriendsCircleOperatorBlackRsp rspData = new FriendsCircleOperatorBlackRsp();
/*     */     
/*  60 */     rspData.result = ((byte)procedure.getResult());
/*     */     
/*  62 */     rsp.data = new OctetsStream().marshal(rspData);
/*     */     
/*  64 */     StringBuilder rspSbLog = new StringBuilder();
/*  65 */     rspSbLog.append("|req=").append(req);
/*  66 */     rspSbLog.append("|req_data=").append(reqData);
/*  67 */     rspSbLog.append("|rsp_result=").append(rspData.result);
/*  68 */     rspSbLog.append("|rsp_data=").append(rspData);
/*     */     
/*  70 */     if (!GHubHelper.sendDataTransferRsp(rsp))
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[crossserver_friendscircle]DTH_FriendsCircleOperatorBlacklist.onDataTransferReq@send friends circle operator black list rsp failed|context=%s", new Object[] { rspSbLog }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return;
/*     */     }
/*     */     
/*  79 */     GameServer.logger().info(String.format("[crossserver_friendscircle]DTH_FriendsCircleOperatorBlacklist.onDataTransferReq@send friends circle operator black list rsp success|context=%s", new Object[] { rspSbLog }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleOperatorBlackReq reqData, int code)
/*     */   {
/*  89 */     StringBuilder sBuilder = new StringBuilder();
/*  90 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleOperatorBlacklist.onDataTransferTimeout@friends circle operator black list time out");
/*  91 */     sBuilder.append("|req=").append(reqXidWrapper.getProtocol());
/*  92 */     sBuilder.append("|req_data=").append(reqData);
/*  93 */     sBuilder.append("|code=").append(code);
/*     */     
/*  95 */     GameServer.logger().info(sBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleOperatorBlackReq reqData, DataTransferRspXidWrapper rspXidWrapper, FriendsCircleOperatorBlackRsp rspData)
/*     */   {
/* 102 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 103 */     if (rsp.retcode != 0)
/*     */     {
/* 105 */       StringBuilder sBuilder = new StringBuilder();
/* 106 */       sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleOperatorBlacklist.onDataTransferRsp@friends circle operator black list error");
/* 107 */       sBuilder.append("|rsp_retcode=").append(rsp.retcode);
/* 108 */       sBuilder.append("|req_data=").append(reqData);
/*     */       
/* 110 */       GameServer.logger().error(sBuilder.toString());
/*     */     }
/*     */     
/* 113 */     POnCrossServerOperatorBlacklistRsp pOnCrossServerOperatorBlacklistRsp = new POnCrossServerOperatorBlacklistRsp(reqData.active_role_id, reqData.blacked_role_id, reqData.operator, rsp.retcode);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 118 */     pOnCrossServerOperatorBlacklistRsp.call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_FriendsCircleOperatorBlacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */