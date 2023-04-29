/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.EnterCrossCompeteMapReq;
/*     */ import hub.EnterCrossCompeteMapRsp;
/*     */ import hub.GHubHelper;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crosscompete.main.PEnterCrossServerFailed;
/*     */ import mzm.gsp.crosscompete.main.PMakeRoamContext;
/*     */ import mzm.gsp.crosscompete.roam.PCreateRoamEnterContext;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_EnterCrossCompeteMap
/*     */   extends DataTransferHandler<EnterCrossCompeteMapReq, EnterCrossCompeteMapRsp>
/*     */ {
/*     */   protected EnterCrossCompeteMapReq makeReqDataBean()
/*     */   {
/*  30 */     return new EnterCrossCompeteMapReq();
/*     */   }
/*     */   
/*     */   protected EnterCrossCompeteMapRsp makeRspDataBean()
/*     */   {
/*  35 */     return new EnterCrossCompeteMapRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, EnterCrossCompeteMapReq reqData)
/*     */   {
/*  41 */     DataTransferRsp rsp = new DataTransferRsp();
/*  42 */     rsp.direction = 0;
/*  43 */     rsp.xid = req.xid;
/*  44 */     rsp.src_id = req.dst_id;
/*  45 */     rsp.dst_id = req.src_id;
/*  46 */     rsp.data_type = req.data_type;
/*     */     
/*  48 */     EnterCrossCompeteMapRsp rspData = new EnterCrossCompeteMapRsp();
/*     */     
/*  50 */     PCreateRoamEnterContext pContext = new PCreateRoamEnterContext(reqData.factionid, reqData.roles, reqData.team_type == 0);
/*     */     
/*  52 */     if (pContext.call()) {
/*  53 */       rsp.retcode = 0;
/*     */       
/*  55 */       rspData.contextid = pContext.contextid;
/*     */     }
/*     */     else {
/*  58 */       rsp.retcode = 2;
/*     */       
/*  60 */       rspData.result = pContext.result;
/*  61 */       rspData.invalid_roles.addAll(pContext.invalidRoles);
/*     */     }
/*     */     
/*  64 */     OctetsStream os = new OctetsStream();
/*  65 */     os.marshal(rspData);
/*  66 */     rsp.data = os;
/*     */     
/*  68 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, EnterCrossCompeteMapReq reqData, DataTransferRspXidWrapper rspXidWrapper, EnterCrossCompeteMapRsp rspData)
/*     */   {
/*  76 */     if (rspData.result != 0)
/*     */     {
/*  78 */       PEnterCrossServerFailed pFailed = new PEnterCrossServerFailed(reqData.factionid, reqData.roles, rspData.result);
/*     */       
/*  80 */       if (!pFailed.call()) {
/*  81 */         GameServer.logger().error(String.format("[crosscompete]DTH_EnterCrossCompeteMap.onDataTransferRsp@deal enter err|factionid=%d|roles=%s|result=%d|invalid_roles=%s", new Object[] { Long.valueOf(reqData.factionid), reqData.roles, Integer.valueOf(rspData.result), rspData.invalid_roles }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */       GameServer.logger().error(String.format("[crosscompete]DTH_EnterCrossCompeteMap.onDataTransferRsp@enter cross compete failed|factionid=%d|roles=%s|result=%d|invalid_roles=%s", new Object[] { Long.valueOf(reqData.factionid), reqData.roles, Integer.valueOf(rspData.result), rspData.invalid_roles }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */       return;
/*     */     }
/*     */     
/*     */ 
/*  99 */     PMakeRoamContext pMake = new PMakeRoamContext(reqData.factionid, reqData.roles, rspData.contextid);
/* 100 */     if (!pMake.call()) {
/* 101 */       GameServer.logger().error(String.format("[crosscompete]DTH_EnterCrossCompeteMap.onDataTransferRsp@make roam context failed|factionid=%d|roles=%s", new Object[] { Long.valueOf(reqData.factionid), reqData.roles }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */       new PEnterCrossServerFailed(reqData.factionid, reqData.roles, 14).call();
/*     */       
/* 109 */       return;
/*     */     }
/*     */     
/* 112 */     CrossServerManager.genRoamToken(pMake.roamContext);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, EnterCrossCompeteMapReq reqData, int code)
/*     */   {
/* 119 */     GameServer.logger().error(String.format("[crosscompete]DTH_EnterCrossCompeteMap.onDataTransferTimeout@enter cross compete timeout|factionid=%d|roles=%s|req=%s|code=%d", new Object[] { Long.valueOf(reqData.factionid), reqData.roles, reqXidWrapper.getProtocol(), Integer.valueOf(code) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */     PEnterCrossServerFailed pFailed = new PEnterCrossServerFailed(reqData.factionid, reqData.roles, 13);
/*     */     
/* 129 */     if (!pFailed.call()) {
/* 130 */       GameServer.logger().error(String.format("[crosscompete]DTH_EnterCrossCompeteMap.onDataTransferTimeout@deal enter timeout err|factionid=%d|roles=%s", new Object[] { Long.valueOf(reqData.factionid), reqData.roles }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_EnterCrossCompeteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */