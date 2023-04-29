/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.FriendsCircleDeleteTreadHistoryReq;
/*     */ import hub.FriendsCircleDeleteTreadHistoryRsp;
/*     */ import hub.GHubHelper;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerDeleteTreadFriendsCircle;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerDeleteTreadFriendsCircleRsp;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_FriendsCircleDeleteTread
/*     */   extends DataTransferHandler<FriendsCircleDeleteTreadHistoryReq, FriendsCircleDeleteTreadHistoryRsp>
/*     */ {
/*     */   protected FriendsCircleDeleteTreadHistoryReq makeReqDataBean()
/*     */   {
/*  24 */     return new FriendsCircleDeleteTreadHistoryReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected FriendsCircleDeleteTreadHistoryRsp makeRspDataBean()
/*     */   {
/*  30 */     return new FriendsCircleDeleteTreadHistoryRsp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, FriendsCircleDeleteTreadHistoryReq reqData)
/*     */   {
/*  37 */     StringBuilder sBuilder = new StringBuilder();
/*  38 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleDeleteTread.onDataTransferReq@get friends circle delete tread history req");
/*  39 */     sBuilder.append("|req=").append(req);
/*  40 */     sBuilder.append("|req_data=").append(reqData);
/*     */     
/*  42 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/*  44 */     POnCrossServerDeleteTreadFriendsCircle procedure = new POnCrossServerDeleteTreadFriendsCircle(reqData.tread_role_id, reqData.be_trod_role_id, reqData.tread_serial_id);
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
/*  58 */     FriendsCircleDeleteTreadHistoryRsp rspData = new FriendsCircleDeleteTreadHistoryRsp();
/*     */     
/*  60 */     rspData.result = ((byte)procedure.getResult());
/*     */     
/*  62 */     rsp.data = new OctetsStream().marshal(rspData);
/*     */     
/*  64 */     StringBuilder rspSbLog = new StringBuilder();
/*  65 */     rspSbLog.append("|req=").append(req);
/*  66 */     rspSbLog.append("|req_data=").append(reqData);
/*  67 */     rspSbLog.append("|rsp_result=").append(rspData.result);
/*  68 */     rspSbLog.append("|receive_role_name=").append(rspData);
/*     */     
/*  70 */     if (!GHubHelper.sendDataTransferRsp(rsp))
/*     */     {
/*  72 */       GameServer.logger().error(String.format("[crossserver_friendscircle]DTH_FriendsCircleDeleteTread.onDataTransferReq@send friends circle delete tread history req rsp failed|context=%s", new Object[] { rspSbLog }));
/*     */       
/*     */ 
/*     */ 
/*  76 */       return;
/*     */     }
/*     */     
/*  79 */     GameServer.logger().info(String.format("[crossserver_friendscircle]DTH_FriendsCircleDeleteTread.onDataTransferReq@send friends circle delete tread history req rsp success|context=%s", new Object[] { rspSbLog }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleDeleteTreadHistoryReq reqData, int code)
/*     */   {
/*  90 */     StringBuilder sBuilder = new StringBuilder();
/*  91 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleDeleteTread.onDataTransferTimeout@friends circle delete tread time out");
/*  92 */     sBuilder.append("|req=").append(reqXidWrapper.getProtocol());
/*  93 */     sBuilder.append("|req_data=").append(reqData);
/*  94 */     sBuilder.append("|code=").append(code);
/*     */     
/*  96 */     GameServer.logger().info(sBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleDeleteTreadHistoryReq reqData, DataTransferRspXidWrapper rspXidWrapper, FriendsCircleDeleteTreadHistoryRsp rspData)
/*     */   {
/* 104 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 105 */     if (rsp.retcode != 0)
/*     */     {
/* 107 */       StringBuilder sBuilder = new StringBuilder();
/* 108 */       sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleDeleteTread.onDataTransferRsp@friends circle delete tread error");
/* 109 */       sBuilder.append("|rsp_retcode=").append(rsp.retcode);
/*     */       
/* 111 */       GameServer.logger().error(sBuilder.toString());
/* 112 */       return;
/*     */     }
/*     */     
/* 115 */     new POnCrossServerDeleteTreadFriendsCircleRsp(reqData.tread_role_id, reqData.be_trod_role_id, reqData.tread_role_id, rspData.result).call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_FriendsCircleDeleteTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */